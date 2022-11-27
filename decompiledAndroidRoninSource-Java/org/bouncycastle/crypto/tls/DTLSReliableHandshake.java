package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.util.Integers;

class DTLSReliableHandshake
{
  private static final int MAX_RECEIVE_AHEAD = 10;
  private Hashtable currentInboundFlight = new Hashtable();
  private TlsHandshakeHash handshakeHash;
  private int message_seq = 0;
  private int next_receive_seq = 0;
  private Vector outboundFlight = new Vector();
  private Hashtable previousInboundFlight = null;
  private DTLSRecordLayer recordLayer;
  private boolean sending = true;
  
  DTLSReliableHandshake(TlsContext paramTlsContext, DTLSRecordLayer paramDTLSRecordLayer)
  {
    this.recordLayer = paramDTLSRecordLayer;
    paramDTLSRecordLayer = new DeferredHash();
    this.handshakeHash = paramDTLSRecordLayer;
    paramDTLSRecordLayer.init(paramTlsContext);
  }
  
  private static boolean checkAll(Hashtable paramHashtable)
  {
    paramHashtable = paramHashtable.elements();
    while (paramHashtable.hasMoreElements()) {
      if (((DTLSReassembler)paramHashtable.nextElement()).getBodyIfComplete() == null) {
        return false;
      }
    }
    return true;
  }
  
  private void checkInboundFlight()
  {
    Enumeration localEnumeration = this.currentInboundFlight.keys();
    while (localEnumeration.hasMoreElements()) {
      ((Integer)localEnumeration.nextElement()).intValue();
    }
  }
  
  private void prepareInboundFlight()
  {
    resetAll(this.currentInboundFlight);
    this.previousInboundFlight = this.currentInboundFlight;
    this.currentInboundFlight = new Hashtable();
  }
  
  private void resendOutboundFlight()
    throws IOException
  {
    this.recordLayer.resetWriteEpoch();
    int i = 0;
    while (i < this.outboundFlight.size())
    {
      writeMessage((Message)this.outboundFlight.elementAt(i));
      i += 1;
    }
  }
  
  private static void resetAll(Hashtable paramHashtable)
  {
    paramHashtable = paramHashtable.elements();
    while (paramHashtable.hasMoreElements()) {
      ((DTLSReassembler)paramHashtable.nextElement()).reset();
    }
  }
  
  private Message updateHandshakeMessagesDigest(Message paramMessage)
    throws IOException
  {
    if (paramMessage.getType() != 0)
    {
      byte[] arrayOfByte1 = paramMessage.getBody();
      byte[] arrayOfByte2 = new byte[12];
      TlsUtils.writeUint8(paramMessage.getType(), arrayOfByte2, 0);
      TlsUtils.writeUint24(arrayOfByte1.length, arrayOfByte2, 1);
      TlsUtils.writeUint16(paramMessage.getSeq(), arrayOfByte2, 4);
      TlsUtils.writeUint24(0, arrayOfByte2, 6);
      TlsUtils.writeUint24(arrayOfByte1.length, arrayOfByte2, 9);
      this.handshakeHash.update(arrayOfByte2, 0, 12);
      this.handshakeHash.update(arrayOfByte1, 0, arrayOfByte1.length);
    }
    return paramMessage;
  }
  
  private void writeHandshakeFragment(Message paramMessage, int paramInt1, int paramInt2)
    throws IOException
  {
    RecordLayerBuffer localRecordLayerBuffer = new RecordLayerBuffer(paramInt2 + 12);
    TlsUtils.writeUint8(paramMessage.getType(), localRecordLayerBuffer);
    TlsUtils.writeUint24(paramMessage.getBody().length, localRecordLayerBuffer);
    TlsUtils.writeUint16(paramMessage.getSeq(), localRecordLayerBuffer);
    TlsUtils.writeUint24(paramInt1, localRecordLayerBuffer);
    TlsUtils.writeUint24(paramInt2, localRecordLayerBuffer);
    localRecordLayerBuffer.write(paramMessage.getBody(), paramInt1, paramInt2);
    localRecordLayerBuffer.sendToRecordLayer(this.recordLayer);
  }
  
  private void writeMessage(Message paramMessage)
    throws IOException
  {
    int k = this.recordLayer.getSendLimit() - 12;
    if (k >= 1)
    {
      int m = paramMessage.getBody().length;
      int i = 0;
      int j;
      do
      {
        j = Math.min(m - i, k);
        writeHandshakeFragment(paramMessage, i, j);
        j = i + j;
        i = j;
      } while (j < m);
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  void finish()
  {
    if (!this.sending)
    {
      checkInboundFlight();
    }
    else if (this.currentInboundFlight != null)
    {
      local1 = new DTLSHandshakeRetransmit()
      {
        public void receivedHandshakeRecord(int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2, int paramAnonymousInt3)
          throws IOException
        {
          if (paramAnonymousInt3 < 12) {
            return;
          }
          int i = TlsUtils.readUint24(paramAnonymousArrayOfByte, paramAnonymousInt2 + 9);
          if (paramAnonymousInt3 != i + 12) {
            return;
          }
          int j = TlsUtils.readUint16(paramAnonymousArrayOfByte, paramAnonymousInt2 + 4);
          if (j >= DTLSReliableHandshake.this.next_receive_seq) {
            return;
          }
          short s = TlsUtils.readUint8(paramAnonymousArrayOfByte, paramAnonymousInt2);
          if (s == 20) {
            paramAnonymousInt3 = 1;
          } else {
            paramAnonymousInt3 = 0;
          }
          if (paramAnonymousInt1 != paramAnonymousInt3) {
            return;
          }
          paramAnonymousInt1 = TlsUtils.readUint24(paramAnonymousArrayOfByte, paramAnonymousInt2 + 1);
          paramAnonymousInt3 = TlsUtils.readUint24(paramAnonymousArrayOfByte, paramAnonymousInt2 + 6);
          if (paramAnonymousInt3 + i > paramAnonymousInt1) {
            return;
          }
          DTLSReassembler localDTLSReassembler = (DTLSReassembler)DTLSReliableHandshake.this.currentInboundFlight.get(Integers.valueOf(j));
          if (localDTLSReassembler != null)
          {
            localDTLSReassembler.contributeFragment(s, paramAnonymousInt1, paramAnonymousArrayOfByte, paramAnonymousInt2 + 12, paramAnonymousInt3, i);
            if (DTLSReliableHandshake.checkAll(DTLSReliableHandshake.this.currentInboundFlight))
            {
              DTLSReliableHandshake.this.resendOutboundFlight();
              DTLSReliableHandshake.resetAll(DTLSReliableHandshake.this.currentInboundFlight);
            }
          }
        }
      };
      break label35;
    }
    DTLSHandshakeRetransmit local1 = null;
    label35:
    this.recordLayer.handshakeSuccessful(local1);
  }
  
  TlsHandshakeHash getHandshakeHash()
  {
    return this.handshakeHash;
  }
  
  void notifyHelloComplete()
  {
    this.handshakeHash = this.handshakeHash.notifyPRFDetermined();
  }
  
  TlsHandshakeHash prepareToFinish()
  {
    TlsHandshakeHash localTlsHandshakeHash = this.handshakeHash;
    this.handshakeHash = localTlsHandshakeHash.stopTracking();
    return localTlsHandshakeHash;
  }
  
  Message receiveMessage()
    throws IOException
  {
    if (this.sending)
    {
      this.sending = false;
      prepareInboundFlight();
    }
    Object localObject1 = (DTLSReassembler)this.currentInboundFlight.get(Integers.valueOf(this.next_receive_seq));
    int i;
    if (localObject1 != null)
    {
      localObject2 = ((DTLSReassembler)localObject1).getBodyIfComplete();
      if (localObject2 != null)
      {
        this.previousInboundFlight = null;
        i = this.next_receive_seq;
        this.next_receive_seq = (i + 1);
        return updateHandshakeMessagesDigest(new Message(i, ((DTLSReassembler)localObject1).getMsgType(), (byte[])localObject2, null));
      }
    }
    int j = 1000;
    Object localObject2 = null;
    int k = this.recordLayer.getReceiveLimit();
    if (localObject2 != null)
    {
      i = j;
      localObject1 = localObject2;
      if (localObject2.length >= k) {}
    }
    else
    {
      localObject1 = new byte[k];
      i = j;
    }
    label539:
    for (;;)
    {
      j = i;
      try
      {
        n = this.recordLayer.receive((byte[])localObject1, 0, k, i);
        if (n >= 0) {
          break label539;
        }
      }
      catch (IOException localIOException)
      {
        int n;
        do
        {
          for (;;)
          {
            int m;
            short s;
            int i1;
            int i2;
            Object localObject3;
            i = j;
          }
        } while (n >= 12);
      }
      j = i;
      m = TlsUtils.readUint24((byte[])localObject1, 9);
      if (n == m + 12)
      {
        j = i;
        n = TlsUtils.readUint16((byte[])localObject1, 4);
        j = i;
        if (n <= this.next_receive_seq + 10)
        {
          j = i;
          s = TlsUtils.readUint8((byte[])localObject1, 0);
          j = i;
          i1 = TlsUtils.readUint24((byte[])localObject1, 1);
          j = i;
          i2 = TlsUtils.readUint24((byte[])localObject1, 6);
          if (i2 + m <= i1)
          {
            j = i;
            if (n < this.next_receive_seq)
            {
              j = i;
              if (this.previousInboundFlight != null)
              {
                j = i;
                localObject2 = (DTLSReassembler)this.previousInboundFlight.get(Integers.valueOf(n));
                if (localObject2 != null)
                {
                  j = i;
                  ((DTLSReassembler)localObject2).contributeFragment(s, i1, (byte[])localObject1, 12, i2, m);
                  j = i;
                  if (checkAll(this.previousInboundFlight))
                  {
                    j = i;
                    resendOutboundFlight();
                    j = i;
                    i = Math.min(i * 2, 60000);
                    j = i;
                    resetAll(this.previousInboundFlight);
                  }
                }
              }
            }
            else
            {
              j = i;
              localObject3 = (DTLSReassembler)this.currentInboundFlight.get(Integers.valueOf(n));
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                j = i;
                localObject2 = new DTLSReassembler(s, i1);
                j = i;
                this.currentInboundFlight.put(Integers.valueOf(n), localObject2);
              }
              j = i;
              ((DTLSReassembler)localObject2).contributeFragment(s, i1, (byte[])localObject1, 12, i2, m);
              j = i;
              if (n == this.next_receive_seq)
              {
                j = i;
                localObject3 = ((DTLSReassembler)localObject2).getBodyIfComplete();
                if (localObject3 != null)
                {
                  j = i;
                  this.previousInboundFlight = null;
                  j = i;
                  k = this.next_receive_seq;
                  j = i;
                  this.next_receive_seq = (k + 1);
                  j = i;
                  localObject2 = updateHandshakeMessagesDigest(new Message(k, ((DTLSReassembler)localObject2).getMsgType(), (byte[])localObject3, null));
                  return (Message)localObject2;
                  resendOutboundFlight();
                  j = Math.min(i * 2, 60000);
                  localObject2 = localObject1;
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
  
  byte[] receiveMessageBody(short paramShort)
    throws IOException
  {
    Message localMessage = receiveMessage();
    if (localMessage.getType() == paramShort) {
      return localMessage.getBody();
    }
    throw new TlsFatalAlert((short)10);
  }
  
  void resetHandshakeMessagesDigest()
  {
    this.handshakeHash.reset();
  }
  
  void sendMessage(short paramShort, byte[] paramArrayOfByte)
    throws IOException
  {
    TlsUtils.checkUint24(paramArrayOfByte.length);
    if (!this.sending)
    {
      checkInboundFlight();
      this.sending = true;
      this.outboundFlight.removeAllElements();
    }
    int i = this.message_seq;
    this.message_seq = (i + 1);
    paramArrayOfByte = new Message(i, paramShort, paramArrayOfByte, null);
    this.outboundFlight.addElement(paramArrayOfByte);
    writeMessage(paramArrayOfByte);
    updateHandshakeMessagesDigest(paramArrayOfByte);
  }
  
  static class Message
  {
    private final byte[] body;
    private final int message_seq;
    private final short msg_type;
    
    private Message(int paramInt, short paramShort, byte[] paramArrayOfByte)
    {
      this.message_seq = paramInt;
      this.msg_type = paramShort;
      this.body = paramArrayOfByte;
    }
    
    public byte[] getBody()
    {
      return this.body;
    }
    
    public int getSeq()
    {
      return this.message_seq;
    }
    
    public short getType()
    {
      return this.msg_type;
    }
  }
  
  static class RecordLayerBuffer
    extends ByteArrayOutputStream
  {
    RecordLayerBuffer(int paramInt)
    {
      super();
    }
    
    void sendToRecordLayer(DTLSRecordLayer paramDTLSRecordLayer)
      throws IOException
    {
      paramDTLSRecordLayer.send(this.buf, 0, this.count);
      this.buf = null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DTLSReliableHandshake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */