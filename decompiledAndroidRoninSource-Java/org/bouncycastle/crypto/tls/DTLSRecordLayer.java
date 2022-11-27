package org.bouncycastle.crypto.tls;

import java.io.IOException;

class DTLSRecordLayer
  implements DatagramTransport
{
  private static final int MAX_FRAGMENT_LENGTH = 16384;
  private static final int RECORD_HEADER_LENGTH = 13;
  private static final long RETRANSMIT_TIMEOUT = 240000L;
  private static final long TCP_MSL = 120000L;
  private volatile boolean closed = false;
  private final TlsContext context;
  private DTLSEpoch currentEpoch;
  private volatile boolean failed = false;
  private volatile boolean inHandshake;
  private final TlsPeer peer;
  private DTLSEpoch pendingEpoch;
  private volatile int plaintextLimit;
  private DTLSEpoch readEpoch;
  private volatile ProtocolVersion readVersion = null;
  private final ByteQueue recordQueue = new ByteQueue();
  private DTLSHandshakeRetransmit retransmit = null;
  private DTLSEpoch retransmitEpoch = null;
  private long retransmitExpiry = 0L;
  private final DatagramTransport transport;
  private DTLSEpoch writeEpoch;
  private volatile ProtocolVersion writeVersion = null;
  
  DTLSRecordLayer(DatagramTransport paramDatagramTransport, TlsContext paramTlsContext, TlsPeer paramTlsPeer, short paramShort)
  {
    this.transport = paramDatagramTransport;
    this.context = paramTlsContext;
    this.peer = paramTlsPeer;
    this.inHandshake = true;
    paramDatagramTransport = new DTLSEpoch(0, new TlsNullCipher(paramTlsContext));
    this.currentEpoch = paramDatagramTransport;
    this.pendingEpoch = null;
    this.readEpoch = paramDatagramTransport;
    this.writeEpoch = paramDatagramTransport;
    setPlaintextLimit(16384);
  }
  
  private void closeTransport()
  {
    if (!this.closed) {}
    try
    {
      if (!this.failed) {
        warn((short)0, null);
      }
      this.transport.close();
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    this.closed = true;
  }
  
  private static long getMacSequenceNumber(int paramInt, long paramLong)
  {
    return (paramInt & 0xFFFFFFFF) << 48 | paramLong;
  }
  
  private void raiseAlert(short paramShort1, short paramShort2, String paramString, Throwable paramThrowable)
    throws IOException
  {
    this.peer.notifyAlertRaised(paramShort1, paramShort2, paramString, paramThrowable);
    sendRecord((short)21, new byte[] { (byte)paramShort1, (byte)paramShort2 }, 0, 2);
  }
  
  private int receiveRecord(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (this.recordQueue.available() > 0)
    {
      if (this.recordQueue.available() >= 13)
      {
        byte[] arrayOfByte = new byte[2];
        this.recordQueue.read(arrayOfByte, 0, 2, 11);
        paramInt2 = TlsUtils.readUint16(arrayOfByte, 0);
      }
      else
      {
        paramInt2 = 0;
      }
      paramInt2 = Math.min(this.recordQueue.available(), paramInt2 + 13);
      this.recordQueue.removeData(paramArrayOfByte, paramInt1, paramInt2, 0);
      return paramInt2;
    }
    paramInt3 = this.transport.receive(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    paramInt2 = paramInt3;
    if (paramInt3 >= 13)
    {
      int i = TlsUtils.readUint16(paramArrayOfByte, paramInt1 + 11) + 13;
      paramInt2 = paramInt3;
      if (paramInt3 > i)
      {
        this.recordQueue.addData(paramArrayOfByte, paramInt1 + i, paramInt3 - i);
        paramInt2 = i;
      }
    }
    return paramInt2;
  }
  
  private void sendRecord(short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.writeVersion == null) {
      return;
    }
    if (paramInt2 <= this.plaintextLimit)
    {
      if ((paramInt2 < 1) && (paramShort != 23)) {
        throw new TlsFatalAlert((short)80);
      }
      int i = this.writeEpoch.getEpoch();
      long l = this.writeEpoch.allocateSequenceNumber();
      paramArrayOfByte = this.writeEpoch.getCipher().encodePlaintext(getMacSequenceNumber(i, l), paramShort, paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 = paramArrayOfByte.length + 13;
      byte[] arrayOfByte = new byte[paramInt1];
      TlsUtils.writeUint8(paramShort, arrayOfByte, 0);
      TlsUtils.writeVersion(this.writeVersion, arrayOfByte, 1);
      TlsUtils.writeUint16(i, arrayOfByte, 3);
      TlsUtils.writeUint48(l, arrayOfByte, 5);
      TlsUtils.writeUint16(paramArrayOfByte.length, arrayOfByte, 11);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 13, paramArrayOfByte.length);
      this.transport.send(arrayOfByte, 0, paramInt1);
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public void close()
    throws IOException
  {
    if (!this.closed)
    {
      if (this.inHandshake) {
        warn((short)90, "User canceled handshake");
      }
      closeTransport();
    }
  }
  
  void fail(short paramShort)
  {
    if (!this.closed) {}
    try
    {
      raiseAlert((short)2, paramShort, null, null);
      this.failed = true;
      closeTransport();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  void failed()
  {
    if (!this.closed)
    {
      this.failed = true;
      closeTransport();
    }
  }
  
  ProtocolVersion getReadVersion()
  {
    return this.readVersion;
  }
  
  public int getReceiveLimit()
    throws IOException
  {
    return Math.min(this.plaintextLimit, this.readEpoch.getCipher().getPlaintextLimit(this.transport.getReceiveLimit() - 13));
  }
  
  public int getSendLimit()
    throws IOException
  {
    return Math.min(this.plaintextLimit, this.writeEpoch.getCipher().getPlaintextLimit(this.transport.getSendLimit() - 13));
  }
  
  void handshakeSuccessful(DTLSHandshakeRetransmit paramDTLSHandshakeRetransmit)
  {
    DTLSEpoch localDTLSEpoch1 = this.readEpoch;
    DTLSEpoch localDTLSEpoch2 = this.currentEpoch;
    if ((localDTLSEpoch1 != localDTLSEpoch2) && (this.writeEpoch != localDTLSEpoch2))
    {
      if (paramDTLSHandshakeRetransmit != null)
      {
        this.retransmit = paramDTLSHandshakeRetransmit;
        this.retransmitEpoch = localDTLSEpoch2;
        this.retransmitExpiry = (System.currentTimeMillis() + 240000L);
      }
      this.inHandshake = false;
      this.currentEpoch = this.pendingEpoch;
      this.pendingEpoch = null;
      return;
    }
    throw new IllegalStateException();
  }
  
  void initPendingEpoch(TlsCipher paramTlsCipher)
  {
    if (this.pendingEpoch == null)
    {
      this.pendingEpoch = new DTLSEpoch(this.writeEpoch.getEpoch() + 1, paramTlsCipher);
      return;
    }
    throw new IllegalStateException();
  }
  
  public int receive(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    Object localObject1 = null;
    int i = Math.min(paramInt2, getReceiveLimit()) + 13;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (localObject1.length >= i) {}
    }
    else
    {
      localObject2 = new byte[i];
    }
    label88:
    short s1;
    try
    {
      if ((this.retransmit != null) && (System.currentTimeMillis() > this.retransmitExpiry))
      {
        this.retransmit = null;
        this.retransmitEpoch = null;
      }
      i = receiveRecord((byte[])localObject2, 0, i, paramInt3);
      if (i >= 0) {
        break label547;
      }
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      label216:
      byte[] arrayOfByte;
      throw paramArrayOfByte;
    }
    if (i == TlsUtils.readUint16((byte[])localObject2, 11) + 13)
    {
      s1 = TlsUtils.readUint8((byte[])localObject2, 0);
      switch (s1)
      {
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
        int j = TlsUtils.readUint16((byte[])localObject2, 3);
        if (j == this.readEpoch.getEpoch())
        {
          localObject1 = this.readEpoch;
        }
        else
        {
          if ((s1 != 22) || (this.retransmitEpoch == null) || (j != this.retransmitEpoch.getEpoch())) {
            break label567;
          }
          localObject1 = this.retransmitEpoch;
          break label564;
          long l = TlsUtils.readUint48((byte[])localObject2, 5);
          if (!((DTLSEpoch)localObject1).getReplayWindow().shouldDiscard(l))
          {
            ProtocolVersion localProtocolVersion = TlsUtils.readVersion((byte[])localObject2, 1);
            if ((localProtocolVersion.isDTLS()) && ((this.readVersion == null) || (this.readVersion.equals(localProtocolVersion))))
            {
              arrayOfByte = ((DTLSEpoch)localObject1).getCipher().decodeCiphertext(getMacSequenceNumber(((DTLSEpoch)localObject1).getEpoch(), l), s1, (byte[])localObject2, 13, i - 13);
              ((DTLSEpoch)localObject1).getReplayWindow().reportAuthenticated(l);
              if (arrayOfByte.length > this.plaintextLimit) {
                break label578;
              }
              if (this.readVersion != null) {
                break label585;
              }
              this.readVersion = localProtocolVersion;
              break label585;
              if (this.inHandshake)
              {
                break label578;
                if (!this.inHandshake)
                {
                  if (this.retransmit == null) {
                    break label578;
                  }
                  this.retransmit.receivedHandshakeRecord(j, arrayOfByte, 0, arrayOfByte.length);
                  break label578;
                  if (arrayOfByte.length != 2) {
                    break label578;
                  }
                  s1 = (short)arrayOfByte[0];
                  short s2 = (short)arrayOfByte[1];
                  this.peer.notifyAlertReceived(s1, s2);
                  if (s1 != 2)
                  {
                    if (s2 != 0) {
                      break label578;
                    }
                    closeTransport();
                    break label578;
                  }
                  failed();
                  throw new TlsFatalAlert(s2);
                }
              }
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (i < arrayOfByte.length)
      {
        if ((TlsUtils.readUint8(arrayOfByte, i) == 1) && (this.pendingEpoch != null)) {
          this.readEpoch = this.pendingEpoch;
        }
      }
      else
      {
        for (;;)
        {
          if ((!this.inHandshake) && (this.retransmit != null))
          {
            this.retransmit = null;
            this.retransmitEpoch = null;
          }
          System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt1, arrayOfByte.length);
          paramInt1 = arrayOfByte.length;
          return paramInt1;
          label547:
          if (i >= 13) {
            break label88;
          }
          for (;;)
          {
            localObject1 = localObject2;
            break;
            continue;
            label564:
            break label570;
            label567:
            localObject1 = null;
            label570:
            if (localObject1 != null) {
              break label216;
            }
          }
          label578:
          localObject1 = localObject2;
          break;
          label585:
          switch (s1)
          {
          }
        }
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  void resetWriteEpoch()
  {
    DTLSEpoch localDTLSEpoch = this.retransmitEpoch;
    if (localDTLSEpoch == null) {
      localDTLSEpoch = this.currentEpoch;
    }
    this.writeEpoch = localDTLSEpoch;
  }
  
  public void send(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    short s1;
    if ((!this.inHandshake) && (this.writeEpoch != this.retransmitEpoch))
    {
      s1 = 23;
    }
    else
    {
      short s2 = 22;
      s1 = s2;
      if (TlsUtils.readUint8(paramArrayOfByte, paramInt1) == 20)
      {
        DTLSEpoch localDTLSEpoch = null;
        if (this.inHandshake) {
          localDTLSEpoch = this.pendingEpoch;
        } else if (this.writeEpoch == this.retransmitEpoch) {
          localDTLSEpoch = this.currentEpoch;
        }
        if (localDTLSEpoch != null)
        {
          sendRecord((short)20, new byte[] { 1 }, 0, 1);
          this.writeEpoch = localDTLSEpoch;
          s1 = s2;
        }
        else
        {
          throw new IllegalStateException();
        }
      }
    }
    sendRecord(s1, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  void setPlaintextLimit(int paramInt)
  {
    this.plaintextLimit = paramInt;
  }
  
  void setReadVersion(ProtocolVersion paramProtocolVersion)
  {
    this.readVersion = paramProtocolVersion;
  }
  
  void setWriteVersion(ProtocolVersion paramProtocolVersion)
  {
    this.writeVersion = paramProtocolVersion;
  }
  
  void warn(short paramShort, String paramString)
    throws IOException
  {
    raiseAlert((short)1, paramShort, paramString, null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DTLSRecordLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */