package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.util.io.SimpleOutputStream;

class RecordStream
{
  private static int DEFAULT_PLAINTEXT_LIMIT = 16384;
  static final int TLS_HEADER_LENGTH_OFFSET = 3;
  static final int TLS_HEADER_SIZE = 5;
  static final int TLS_HEADER_TYPE_OFFSET = 0;
  static final int TLS_HEADER_VERSION_OFFSET = 1;
  private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
  private int ciphertextLimit;
  private int compressedLimit;
  private TlsProtocol handler;
  private TlsHandshakeHash handshakeHash = null;
  private SimpleOutputStream handshakeHashUpdater = new SimpleOutputStream()
  {
    public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      throws IOException
    {
      RecordStream.this.handshakeHash.update(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
    }
  };
  private InputStream input;
  private OutputStream output;
  private TlsCipher pendingCipher = null;
  private TlsCompression pendingCompression = null;
  private int plaintextLimit;
  private TlsCipher readCipher = null;
  private TlsCompression readCompression = null;
  private long readSeqNo = 0L;
  private ProtocolVersion readVersion = null;
  private boolean restrictReadVersion = true;
  private TlsCipher writeCipher = null;
  private TlsCompression writeCompression = null;
  private long writeSeqNo = 0L;
  private ProtocolVersion writeVersion = null;
  
  RecordStream(TlsProtocol paramTlsProtocol, InputStream paramInputStream, OutputStream paramOutputStream)
  {
    this.handler = paramTlsProtocol;
    this.input = paramInputStream;
    this.output = paramOutputStream;
    paramTlsProtocol = new TlsNullCompression();
    this.readCompression = paramTlsProtocol;
    this.writeCompression = paramTlsProtocol;
  }
  
  private static void checkLength(int paramInt1, int paramInt2, short paramShort)
    throws IOException
  {
    if (paramInt1 <= paramInt2) {
      return;
    }
    throw new TlsFatalAlert(paramShort);
  }
  
  private static void checkType(short paramShort1, short paramShort2)
    throws IOException
  {
    switch (paramShort1)
    {
    default: 
      throw new TlsFatalAlert(paramShort2);
    }
  }
  
  private byte[] getBufferContents()
  {
    byte[] arrayOfByte = this.buffer.toByteArray();
    this.buffer.reset();
    return arrayOfByte;
  }
  
  void checkRecordHeader(byte[] paramArrayOfByte)
    throws IOException
  {
    checkType(TlsUtils.readUint8(paramArrayOfByte, 0), (short)10);
    if (!this.restrictReadVersion)
    {
      if ((TlsUtils.readVersionRaw(paramArrayOfByte, 1) & 0xFF00) != 768) {
        throw new TlsFatalAlert((short)47);
      }
    }
    else
    {
      ProtocolVersion localProtocolVersion1 = TlsUtils.readVersion(paramArrayOfByte, 1);
      ProtocolVersion localProtocolVersion2 = this.readVersion;
      if ((localProtocolVersion2 != null) && (!localProtocolVersion1.equals(localProtocolVersion2))) {
        break label86;
      }
    }
    checkLength(TlsUtils.readUint16(paramArrayOfByte, 3), this.ciphertextLimit, (short)22);
    return;
    label86:
    throw new TlsFatalAlert((short)47);
  }
  
  byte[] decodeAndVerify(short paramShort, InputStream paramInputStream, int paramInt)
    throws IOException
  {
    paramInputStream = TlsUtils.readFully(paramInt, paramInputStream);
    Object localObject = this.readCipher;
    long l = this.readSeqNo;
    this.readSeqNo = (1L + l);
    localObject = ((TlsCipher)localObject).decodeCiphertext(l, paramShort, paramInputStream, 0, paramInputStream.length);
    checkLength(localObject.length, this.compressedLimit, (short)22);
    OutputStream localOutputStream = this.readCompression.decompress(this.buffer);
    paramInputStream = (InputStream)localObject;
    if (localOutputStream != this.buffer)
    {
      localOutputStream.write((byte[])localObject, 0, localObject.length);
      localOutputStream.flush();
      paramInputStream = getBufferContents();
    }
    checkLength(paramInputStream.length, this.plaintextLimit, (short)30);
    if (paramInputStream.length < 1)
    {
      if (paramShort == 23) {
        return paramInputStream;
      }
      throw new TlsFatalAlert((short)47);
    }
    return paramInputStream;
  }
  
  void finaliseHandshake()
    throws IOException
  {
    Object localObject1 = this.readCompression;
    Object localObject2 = this.pendingCompression;
    if ((localObject1 == localObject2) && (this.writeCompression == localObject2))
    {
      localObject1 = this.readCipher;
      localObject2 = this.pendingCipher;
      if ((localObject1 == localObject2) && (this.writeCipher == localObject2))
      {
        this.pendingCompression = null;
        this.pendingCipher = null;
        return;
      }
    }
    throw new TlsFatalAlert((short)40);
  }
  
  void flush()
    throws IOException
  {
    this.output.flush();
  }
  
  TlsHandshakeHash getHandshakeHash()
  {
    return this.handshakeHash;
  }
  
  OutputStream getHandshakeHashUpdater()
  {
    return this.handshakeHashUpdater;
  }
  
  int getPlaintextLimit()
  {
    return this.plaintextLimit;
  }
  
  ProtocolVersion getReadVersion()
  {
    return this.readVersion;
  }
  
  void init(TlsContext paramTlsContext)
  {
    Object localObject = new TlsNullCipher(paramTlsContext);
    this.readCipher = ((TlsCipher)localObject);
    this.writeCipher = ((TlsCipher)localObject);
    localObject = new DeferredHash();
    this.handshakeHash = ((TlsHandshakeHash)localObject);
    ((TlsHandshakeHash)localObject).init(paramTlsContext);
    setPlaintextLimit(DEFAULT_PLAINTEXT_LIMIT);
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
  
  boolean readRecord()
    throws IOException
  {
    byte[] arrayOfByte = TlsUtils.readAllOrNothing(5, this.input);
    if (arrayOfByte == null) {
      return false;
    }
    short s = TlsUtils.readUint8(arrayOfByte, 0);
    checkType(s, (short)10);
    if (!this.restrictReadVersion)
    {
      if ((TlsUtils.readVersionRaw(arrayOfByte, 1) & 0xFF00) != 768) {
        throw new TlsFatalAlert((short)47);
      }
    }
    else
    {
      ProtocolVersion localProtocolVersion1 = TlsUtils.readVersion(arrayOfByte, 1);
      ProtocolVersion localProtocolVersion2 = this.readVersion;
      if (localProtocolVersion2 == null) {
        this.readVersion = localProtocolVersion1;
      } else {
        if (!localProtocolVersion1.equals(localProtocolVersion2)) {
          break label140;
        }
      }
    }
    int i = TlsUtils.readUint16(arrayOfByte, 3);
    checkLength(i, this.ciphertextLimit, (short)22);
    arrayOfByte = decodeAndVerify(s, this.input, i);
    this.handler.processRecord(s, arrayOfByte, 0, arrayOfByte.length);
    return true;
    label140:
    throw new TlsFatalAlert((short)47);
  }
  
  void receivedReadCipherSpec()
    throws IOException
  {
    TlsCompression localTlsCompression = this.pendingCompression;
    if (localTlsCompression != null)
    {
      TlsCipher localTlsCipher = this.pendingCipher;
      if (localTlsCipher != null)
      {
        this.readCompression = localTlsCompression;
        this.readCipher = localTlsCipher;
        this.readSeqNo = 0L;
        return;
      }
    }
    throw new TlsFatalAlert((short)40);
  }
  
  void safeClose()
  {
    try
    {
      this.input.close();
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          this.output.close();
          return;
        }
        catch (IOException localIOException2) {}
        localIOException1 = localIOException1;
      }
    }
  }
  
  void sentWriteCipherSpec()
    throws IOException
  {
    TlsCompression localTlsCompression = this.pendingCompression;
    if (localTlsCompression != null)
    {
      TlsCipher localTlsCipher = this.pendingCipher;
      if (localTlsCipher != null)
      {
        this.writeCompression = localTlsCompression;
        this.writeCipher = localTlsCipher;
        this.writeSeqNo = 0L;
        return;
      }
    }
    throw new TlsFatalAlert((short)40);
  }
  
  void setPendingConnectionState(TlsCompression paramTlsCompression, TlsCipher paramTlsCipher)
  {
    this.pendingCompression = paramTlsCompression;
    this.pendingCipher = paramTlsCipher;
  }
  
  void setPlaintextLimit(int paramInt)
  {
    this.plaintextLimit = paramInt;
    paramInt += 1024;
    this.compressedLimit = paramInt;
    this.ciphertextLimit = (paramInt + 1024);
  }
  
  void setReadVersion(ProtocolVersion paramProtocolVersion)
  {
    this.readVersion = paramProtocolVersion;
  }
  
  void setRestrictReadVersion(boolean paramBoolean)
  {
    this.restrictReadVersion = paramBoolean;
  }
  
  void setWriteVersion(ProtocolVersion paramProtocolVersion)
  {
    this.writeVersion = paramProtocolVersion;
  }
  
  void writeRecord(short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.writeVersion == null) {
      return;
    }
    checkType(paramShort, (short)80);
    checkLength(paramInt2, this.plaintextLimit, (short)80);
    if ((paramInt2 < 1) && (paramShort != 23)) {
      throw new TlsFatalAlert((short)80);
    }
    Object localObject = this.writeCompression.compress(this.buffer);
    long l;
    if (localObject == this.buffer)
    {
      localObject = this.writeCipher;
      l = this.writeSeqNo;
      this.writeSeqNo = (1L + l);
      paramArrayOfByte = ((TlsCipher)localObject).encodePlaintext(l, paramShort, paramArrayOfByte, paramInt1, paramInt2);
    }
    else
    {
      ((OutputStream)localObject).write(paramArrayOfByte, paramInt1, paramInt2);
      ((OutputStream)localObject).flush();
      paramArrayOfByte = getBufferContents();
      checkLength(paramArrayOfByte.length, paramInt2 + 1024, (short)80);
      localObject = this.writeCipher;
      l = this.writeSeqNo;
      this.writeSeqNo = (1L + l);
      paramArrayOfByte = ((TlsCipher)localObject).encodePlaintext(l, paramShort, paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    checkLength(paramArrayOfByte.length, this.ciphertextLimit, (short)80);
    localObject = new byte[paramArrayOfByte.length + 5];
    TlsUtils.writeUint8(paramShort, (byte[])localObject, 0);
    TlsUtils.writeVersion(this.writeVersion, (byte[])localObject, 1);
    TlsUtils.writeUint16(paramArrayOfByte.length, (byte[])localObject, 3);
    System.arraycopy(paramArrayOfByte, 0, localObject, 5, paramArrayOfByte.length);
    this.output.write((byte[])localObject);
    this.output.flush();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\RecordStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */