package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.prng.RandomGenerator;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;

public abstract class TlsProtocol
{
  protected static final short ADS_MODE_0_N = 1;
  protected static final short ADS_MODE_0_N_FIRSTONLY = 2;
  protected static final short ADS_MODE_1_Nsub1 = 0;
  protected static final short CS_CERTIFICATE_REQUEST = 7;
  protected static final short CS_CERTIFICATE_STATUS = 5;
  protected static final short CS_CERTIFICATE_VERIFY = 12;
  protected static final short CS_CLIENT_CERTIFICATE = 10;
  protected static final short CS_CLIENT_FINISHED = 13;
  protected static final short CS_CLIENT_HELLO = 1;
  protected static final short CS_CLIENT_KEY_EXCHANGE = 11;
  protected static final short CS_CLIENT_SUPPLEMENTAL_DATA = 9;
  protected static final short CS_END = 16;
  protected static final short CS_SERVER_CERTIFICATE = 4;
  protected static final short CS_SERVER_FINISHED = 15;
  protected static final short CS_SERVER_HELLO = 2;
  protected static final short CS_SERVER_HELLO_DONE = 8;
  protected static final short CS_SERVER_KEY_EXCHANGE = 6;
  protected static final short CS_SERVER_SESSION_TICKET = 14;
  protected static final short CS_SERVER_SUPPLEMENTAL_DATA = 3;
  protected static final short CS_START = 0;
  protected static final Integer EXT_RenegotiationInfo = Integers.valueOf(65281);
  protected static final Integer EXT_SessionTicket = Integers.valueOf(35);
  private static final String TLS_ERROR_MESSAGE = "Internal TLS error, this could be an attack";
  private ByteQueue alertQueue = new ByteQueue(2);
  protected boolean allowCertificateStatus = false;
  private volatile boolean appDataReady = false;
  private volatile boolean appDataSplitEnabled = true;
  private volatile int appDataSplitMode = 0;
  private ByteQueue applicationDataQueue = new ByteQueue(0);
  protected boolean blocking;
  protected Hashtable clientExtensions = null;
  private volatile boolean closed = false;
  protected short connection_state = 0;
  protected boolean expectSessionTicket = false;
  private byte[] expected_verify_data = null;
  private volatile boolean failedWithError = false;
  private ByteQueue handshakeQueue = new ByteQueue(0);
  protected ByteQueueInputStream inputBuffers;
  protected int[] offeredCipherSuites = null;
  protected short[] offeredCompressionMethods = null;
  protected ByteQueueOutputStream outputBuffer;
  protected Certificate peerCertificate = null;
  protected boolean receivedChangeCipherSpec = false;
  RecordStream recordStream;
  protected boolean resumedSession = false;
  protected SecureRandom secureRandom;
  protected boolean secure_renegotiation = false;
  protected SecurityParameters securityParameters = null;
  protected Hashtable serverExtensions = null;
  protected SessionParameters sessionParameters = null;
  private TlsInputStream tlsInputStream = null;
  private TlsOutputStream tlsOutputStream = null;
  protected TlsSession tlsSession = null;
  
  public TlsProtocol(InputStream paramInputStream, OutputStream paramOutputStream, SecureRandom paramSecureRandom)
  {
    this.blocking = true;
    this.recordStream = new RecordStream(this, paramInputStream, paramOutputStream);
    this.secureRandom = paramSecureRandom;
  }
  
  public TlsProtocol(SecureRandom paramSecureRandom)
  {
    this.blocking = false;
    this.inputBuffers = new ByteQueueInputStream();
    this.outputBuffer = new ByteQueueOutputStream();
    this.recordStream = new RecordStream(this, this.inputBuffers, this.outputBuffer);
    this.secureRandom = paramSecureRandom;
  }
  
  protected static void assertEmpty(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    if (paramByteArrayInputStream.available() <= 0) {
      return;
    }
    throw new TlsFatalAlert((short)50);
  }
  
  protected static byte[] createRandomBlock(boolean paramBoolean, RandomGenerator paramRandomGenerator)
  {
    byte[] arrayOfByte = new byte[32];
    paramRandomGenerator.nextBytes(arrayOfByte);
    if (paramBoolean) {
      TlsUtils.writeGMTUnixTime(arrayOfByte, 0);
    }
    return arrayOfByte;
  }
  
  protected static byte[] createRenegotiationInfo(byte[] paramArrayOfByte)
    throws IOException
  {
    return TlsUtils.encodeOpaque8(paramArrayOfByte);
  }
  
  protected static void establishMasterSecret(TlsContext paramTlsContext, TlsKeyExchange paramTlsKeyExchange)
    throws IOException
  {
    paramTlsKeyExchange = paramTlsKeyExchange.generatePremasterSecret();
    try
    {
      paramTlsContext.getSecurityParameters().masterSecret = TlsUtils.calculateMasterSecret(paramTlsContext, paramTlsKeyExchange);
      return;
    }
    finally
    {
      if (paramTlsKeyExchange != null) {
        Arrays.fill(paramTlsKeyExchange, (byte)0);
      }
    }
  }
  
  protected static byte[] getCurrentPRFHash(TlsContext paramTlsContext, TlsHandshakeHash paramTlsHandshakeHash, byte[] paramArrayOfByte)
  {
    paramTlsHandshakeHash = paramTlsHandshakeHash.forkPRFHash();
    if ((paramArrayOfByte != null) && (TlsUtils.isSSL(paramTlsContext))) {
      paramTlsHandshakeHash.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    paramTlsContext = new byte[paramTlsHandshakeHash.getDigestSize()];
    paramTlsHandshakeHash.doFinal(paramTlsContext, 0);
    return paramTlsContext;
  }
  
  protected static int getPRFAlgorithm(TlsContext paramTlsContext, int paramInt)
    throws IOException
  {
    boolean bool = TlsUtils.isTLSv12(paramTlsContext);
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      switch (paramInt)
                      {
                      default: 
                        if (bool) {
                          return 1;
                        }
                        return 0;
                      }
                      break;
                    }
                    break;
                  }
                  break;
                }
                break;
              }
              break;
            }
          case 175: 
          case 177: 
          case 179: 
          case 181: 
          case 183: 
          case 49208: 
          case 49211: 
          case 49301: 
          case 49303: 
          case 49305: 
            if (bool) {
              return 2;
            }
            return 0;
          }
        case 157: 
        case 159: 
        case 161: 
        case 163: 
        case 165: 
        case 167: 
        case 169: 
        case 171: 
        case 173: 
          if (bool) {
            return 2;
          }
          throw new TlsFatalAlert((short)47);
        }
        break;
      }
      break;
    }
    if (bool) {
      return 1;
    }
    throw new TlsFatalAlert((short)47);
  }
  
  private void processAlertQueue()
    throws IOException
  {
    while (this.alertQueue.available() >= 2)
    {
      byte[] arrayOfByte = this.alertQueue.removeData(2, 0);
      short s1 = (short)arrayOfByte[0];
      short s2 = (short)arrayOfByte[1];
      getPeer().notifyAlertReceived(s1, s2);
      if (s1 != 2)
      {
        if (s2 == 0) {
          if (this.appDataReady) {
            handleClose(false);
          } else {
            throw new TlsFatalAlert((short)40);
          }
        }
        handleWarningMessage(s2);
      }
      else
      {
        invalidateSession();
        this.failedWithError = true;
        this.closed = true;
        this.recordStream.safeClose();
        throw new IOException("Internal TLS error, this could be an attack");
      }
    }
  }
  
  private void processApplicationDataQueue() {}
  
  private void processChangeCipherSpec(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 0;
    while (i < paramInt2) {
      if (TlsUtils.readUint8(paramArrayOfByte, paramInt1 + i) == 1)
      {
        if ((!this.receivedChangeCipherSpec) && (this.alertQueue.available() <= 0) && (this.handshakeQueue.available() <= 0))
        {
          this.recordStream.receivedReadCipherSpec();
          this.receivedChangeCipherSpec = true;
          handleChangeCipherSpecMessage();
          i += 1;
        }
        else
        {
          throw new TlsFatalAlert((short)10);
        }
      }
      else {
        throw new TlsFatalAlert((short)50);
      }
    }
  }
  
  private void processHandshakeQueue(ByteQueue paramByteQueue)
    throws IOException
  {
    while (paramByteQueue.available() >= 4)
    {
      Object localObject = new byte[4];
      boolean bool = false;
      paramByteQueue.read((byte[])localObject, 0, 4, 0);
      short s = TlsUtils.readUint8((byte[])localObject, 0);
      int i = TlsUtils.readUint24((byte[])localObject, 1);
      int j = i + 4;
      if (paramByteQueue.available() < j) {
        return;
      }
      if ((this.connection_state == 16) || (s == 20)) {
        bool = true;
      }
      checkReceivedChangeCipherSpec(bool);
      if (s != 0)
      {
        if (s == 20)
        {
          localObject = getContext();
          if ((this.expected_verify_data == null) && (((TlsContext)localObject).getSecurityParameters().getMasterSecret() != null)) {
            this.expected_verify_data = createVerifyData(((TlsContext)localObject).isServer() ^ true);
          }
        }
        paramByteQueue.copyTo(this.recordStream.getHandshakeHashUpdater(), j);
      }
      paramByteQueue.removeData(4);
      handleHandshakeMessage(s, paramByteQueue.readFrom(i));
    }
  }
  
  protected static Hashtable readExtensions(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    if (paramByteArrayInputStream.available() < 1) {
      return null;
    }
    Object localObject = TlsUtils.readOpaque16(paramByteArrayInputStream);
    assertEmpty(paramByteArrayInputStream);
    paramByteArrayInputStream = new ByteArrayInputStream((byte[])localObject);
    localObject = new Hashtable();
    while (paramByteArrayInputStream.available() > 0) {
      if (((Hashtable)localObject).put(Integers.valueOf(TlsUtils.readUint16(paramByteArrayInputStream)), TlsUtils.readOpaque16(paramByteArrayInputStream)) != null) {
        throw new TlsFatalAlert((short)47);
      }
    }
    return (Hashtable)localObject;
  }
  
  protected static Vector readSupplementalDataMessage(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    Object localObject = TlsUtils.readOpaque24(paramByteArrayInputStream);
    assertEmpty(paramByteArrayInputStream);
    paramByteArrayInputStream = new ByteArrayInputStream((byte[])localObject);
    localObject = new Vector();
    while (paramByteArrayInputStream.available() > 0) {
      ((Vector)localObject).addElement(new SupplementalDataEntry(TlsUtils.readUint16(paramByteArrayInputStream), TlsUtils.readOpaque16(paramByteArrayInputStream)));
    }
    return (Vector)localObject;
  }
  
  protected static void writeExtensions(OutputStream paramOutputStream, Hashtable paramHashtable)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    writeSelectedExtensions(localByteArrayOutputStream, paramHashtable, true);
    writeSelectedExtensions(localByteArrayOutputStream, paramHashtable, false);
    TlsUtils.writeOpaque16(localByteArrayOutputStream.toByteArray(), paramOutputStream);
  }
  
  protected static void writeSelectedExtensions(OutputStream paramOutputStream, Hashtable paramHashtable, boolean paramBoolean)
    throws IOException
  {
    Enumeration localEnumeration = paramHashtable.keys();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = (Integer)localEnumeration.nextElement();
      int i = ((Integer)localObject).intValue();
      localObject = (byte[])paramHashtable.get(localObject);
      boolean bool;
      if (localObject.length == 0) {
        bool = true;
      } else {
        bool = false;
      }
      if (paramBoolean == bool)
      {
        TlsUtils.checkUint16(i);
        TlsUtils.writeUint16(i, paramOutputStream);
        TlsUtils.writeOpaque16((byte[])localObject, paramOutputStream);
      }
    }
  }
  
  protected static void writeSupplementalData(OutputStream paramOutputStream, Vector paramVector)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    while (i < paramVector.size())
    {
      SupplementalDataEntry localSupplementalDataEntry = (SupplementalDataEntry)paramVector.elementAt(i);
      int j = localSupplementalDataEntry.getDataType();
      TlsUtils.checkUint16(j);
      TlsUtils.writeUint16(j, localByteArrayOutputStream);
      TlsUtils.writeOpaque16(localSupplementalDataEntry.getData(), localByteArrayOutputStream);
      i += 1;
    }
    TlsUtils.writeOpaque24(localByteArrayOutputStream.toByteArray(), paramOutputStream);
  }
  
  protected int applicationDataAvailable()
  {
    return this.applicationDataQueue.available();
  }
  
  protected void applyMaxFragmentLengthExtension()
    throws IOException
  {
    if (this.securityParameters.maxFragmentLength >= 0)
    {
      if (MaxFragmentLength.isValid(this.securityParameters.maxFragmentLength))
      {
        int i = this.securityParameters.maxFragmentLength;
        this.recordStream.setPlaintextLimit(1 << i + 8);
        return;
      }
      throw new TlsFatalAlert((short)80);
    }
  }
  
  protected void blockForHandshake()
    throws IOException
  {
    if (this.blocking) {
      while (this.connection_state != 16) {
        if (!this.closed) {
          safeReadRecord();
        } else {
          throw new TlsFatalAlert((short)80);
        }
      }
    }
  }
  
  protected void checkReceivedChangeCipherSpec(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean == this.receivedChangeCipherSpec) {
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
  
  protected void cleanupHandshake()
  {
    byte[] arrayOfByte = this.expected_verify_data;
    if (arrayOfByte != null)
    {
      Arrays.fill(arrayOfByte, (byte)0);
      this.expected_verify_data = null;
    }
    this.securityParameters.clear();
    this.peerCertificate = null;
    this.offeredCipherSuites = null;
    this.offeredCompressionMethods = null;
    this.clientExtensions = null;
    this.serverExtensions = null;
    this.resumedSession = false;
    this.receivedChangeCipherSpec = false;
    this.secure_renegotiation = false;
    this.allowCertificateStatus = false;
    this.expectSessionTicket = false;
  }
  
  public void close()
    throws IOException
  {
    handleClose(true);
  }
  
  public void closeInput()
    throws IOException
  {
    if (!this.blocking)
    {
      if (this.closed) {
        return;
      }
      if (this.inputBuffers.available() <= 0)
      {
        if (!this.appDataReady) {
          throw new TlsFatalAlert((short)40);
        }
        throw new TlsNoCloseNotifyException();
      }
      throw new EOFException();
    }
    throw new IllegalStateException("Cannot use closeInput() in blocking mode!");
  }
  
  protected void completeHandshake()
    throws IOException
  {
    for (;;)
    {
      try
      {
        this.connection_state = 16;
        this.alertQueue.shrink();
        this.handshakeQueue.shrink();
        this.recordStream.finaliseHandshake();
        if (!TlsUtils.isTLSv11(getContext()))
        {
          bool = true;
          this.appDataSplitEnabled = bool;
          if (!this.appDataReady)
          {
            this.appDataReady = true;
            if (this.blocking)
            {
              this.tlsInputStream = new TlsInputStream(this);
              this.tlsOutputStream = new TlsOutputStream(this);
            }
          }
          if (this.tlsSession != null)
          {
            if (this.sessionParameters == null)
            {
              this.sessionParameters = new SessionParameters.Builder().setCipherSuite(this.securityParameters.getCipherSuite()).setCompressionAlgorithm(this.securityParameters.getCompressionAlgorithm()).setMasterSecret(this.securityParameters.getMasterSecret()).setPeerCertificate(this.peerCertificate).setPSKIdentity(this.securityParameters.getPSKIdentity()).setSRPIdentity(this.securityParameters.getSRPIdentity()).setServerExtensions(this.serverExtensions).build();
              this.tlsSession = new TlsSessionImpl(this.tlsSession.getSessionID(), this.sessionParameters);
            }
            getContextAdmin().setResumableSession(this.tlsSession);
          }
          getPeer().notifyHandshakeComplete();
          return;
        }
      }
      finally
      {
        cleanupHandshake();
      }
      boolean bool = false;
    }
  }
  
  protected byte[] createVerifyData(boolean paramBoolean)
  {
    TlsContext localTlsContext = getContext();
    String str;
    if (paramBoolean) {
      str = "server finished";
    } else {
      str = "client finished";
    }
    byte[] arrayOfByte;
    if (paramBoolean) {
      arrayOfByte = TlsUtils.SSL_SERVER;
    } else {
      arrayOfByte = TlsUtils.SSL_CLIENT;
    }
    return TlsUtils.calculateVerifyData(localTlsContext, str, getCurrentPRFHash(localTlsContext, this.recordStream.getHandshakeHash(), arrayOfByte));
  }
  
  protected void failWithError(short paramShort1, short paramShort2, String paramString, Throwable paramThrowable)
    throws IOException
  {
    if (!this.closed)
    {
      this.closed = true;
      if (paramShort1 == 2)
      {
        invalidateSession();
        this.failedWithError = true;
      }
      raiseAlert(paramShort1, paramShort2, paramString, paramThrowable);
      this.recordStream.safeClose();
      if (paramShort1 != 2) {
        return;
      }
    }
    throw new IOException("Internal TLS error, this could be an attack");
  }
  
  protected void flush()
    throws IOException
  {
    this.recordStream.flush();
  }
  
  public int getAvailableInputBytes()
  {
    if (!this.blocking) {
      return applicationDataAvailable();
    }
    throw new IllegalStateException("Cannot use getAvailableInputBytes() in blocking mode! Use getInputStream().available() instead.");
  }
  
  public int getAvailableOutputBytes()
  {
    if (!this.blocking) {
      return this.outputBuffer.getBuffer().available();
    }
    throw new IllegalStateException("Cannot use getAvailableOutputBytes() in blocking mode! Use getOutputStream() instead.");
  }
  
  protected abstract TlsContext getContext();
  
  abstract AbstractTlsContext getContextAdmin();
  
  public InputStream getInputStream()
  {
    if (this.blocking) {
      return this.tlsInputStream;
    }
    throw new IllegalStateException("Cannot use InputStream in non-blocking mode! Use offerInput() instead.");
  }
  
  public OutputStream getOutputStream()
  {
    if (this.blocking) {
      return this.tlsOutputStream;
    }
    throw new IllegalStateException("Cannot use OutputStream in non-blocking mode! Use offerOutput() instead.");
  }
  
  protected abstract TlsPeer getPeer();
  
  protected void handleChangeCipherSpecMessage()
    throws IOException
  {}
  
  protected void handleClose(boolean paramBoolean)
    throws IOException
  {
    if (!this.closed)
    {
      if ((paramBoolean) && (!this.appDataReady)) {
        raiseWarning((short)90, "User canceled handshake");
      }
      failWithError((short)1, (short)0, "Connection closed", null);
    }
  }
  
  protected abstract void handleHandshakeMessage(short paramShort, ByteArrayInputStream paramByteArrayInputStream)
    throws IOException;
  
  protected void handleWarningMessage(short paramShort)
    throws IOException
  {}
  
  protected void invalidateSession()
  {
    Object localObject = this.sessionParameters;
    if (localObject != null)
    {
      ((SessionParameters)localObject).clear();
      this.sessionParameters = null;
    }
    localObject = this.tlsSession;
    if (localObject != null)
    {
      ((TlsSession)localObject).invalidate();
      this.tlsSession = null;
    }
  }
  
  public boolean isClosed()
  {
    return this.closed;
  }
  
  public void offerInput(byte[] paramArrayOfByte)
    throws IOException
  {
    if (!this.blocking)
    {
      if (!this.closed)
      {
        this.inputBuffers.addBytes(paramArrayOfByte);
        while (this.inputBuffers.available() >= 5)
        {
          paramArrayOfByte = new byte[5];
          this.inputBuffers.peek(paramArrayOfByte);
          int i = TlsUtils.readUint16(paramArrayOfByte, 3);
          if (this.inputBuffers.available() < i + 5)
          {
            safeCheckRecordHeader(paramArrayOfByte);
            return;
          }
          safeReadRecord();
          if (this.closed)
          {
            if (this.connection_state == 16) {
              return;
            }
            throw new TlsFatalAlert((short)80);
          }
        }
        return;
      }
      throw new IOException("Connection is closed, cannot accept any more input");
    }
    throw new IllegalStateException("Cannot use offerInput() in blocking mode! Use getInputStream() instead.");
  }
  
  public void offerOutput(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (!this.blocking)
    {
      if (this.appDataReady)
      {
        writeData(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      throw new IOException("Application data cannot be sent until the handshake is complete!");
    }
    throw new IllegalStateException("Cannot use offerOutput() in blocking mode! Use getOutputStream() instead.");
  }
  
  protected void processFinishedMessage(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    byte[] arrayOfByte = this.expected_verify_data;
    if (arrayOfByte != null)
    {
      arrayOfByte = TlsUtils.readFully(arrayOfByte.length, paramByteArrayInputStream);
      assertEmpty(paramByteArrayInputStream);
      if (Arrays.constantTimeAreEqual(this.expected_verify_data, arrayOfByte)) {
        return;
      }
      throw new TlsFatalAlert((short)51);
    }
    throw new TlsFatalAlert((short)80);
  }
  
  protected short processMaxFragmentLengthExtension(Hashtable paramHashtable1, Hashtable paramHashtable2, short paramShort)
    throws IOException
  {
    short s = TlsExtensionsUtils.getMaxFragmentLengthExtension(paramHashtable2);
    if (s >= 0)
    {
      if (MaxFragmentLength.isValid(s))
      {
        if (this.resumedSession) {
          break label47;
        }
        if (s == TlsExtensionsUtils.getMaxFragmentLengthExtension(paramHashtable1)) {
          return s;
        }
      }
      throw new TlsFatalAlert(paramShort);
    }
    label47:
    return s;
  }
  
  protected void processRecord(short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    switch (paramShort)
    {
    default: 
      throw new TlsFatalAlert((short)80);
    case 23: 
      if (this.appDataReady)
      {
        this.applicationDataQueue.addData(paramArrayOfByte, paramInt1, paramInt2);
        processApplicationDataQueue();
        return;
      }
      throw new TlsFatalAlert((short)10);
    case 22: 
      if (this.handshakeQueue.available() > 0)
      {
        this.handshakeQueue.addData(paramArrayOfByte, paramInt1, paramInt2);
        processHandshakeQueue(this.handshakeQueue);
        return;
      }
      ByteQueue localByteQueue = new ByteQueue(paramArrayOfByte, paramInt1, paramInt2);
      processHandshakeQueue(localByteQueue);
      paramShort = localByteQueue.available();
      if (paramShort > 0)
      {
        this.handshakeQueue.addData(paramArrayOfByte, paramInt1 + paramInt2 - paramShort, paramShort);
        return;
      }
      break;
    case 21: 
      this.alertQueue.addData(paramArrayOfByte, paramInt1, paramInt2);
      processAlertQueue();
      return;
    case 20: 
      processChangeCipherSpec(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  protected void raiseAlert(short paramShort1, short paramShort2, String paramString, Throwable paramThrowable)
    throws IOException
  {
    getPeer().notifyAlertRaised(paramShort1, paramShort2, paramString, paramThrowable);
    safeWriteRecord((short)21, new byte[] { (byte)paramShort1, (byte)paramShort2 }, 0, 2);
  }
  
  protected void raiseWarning(short paramShort, String paramString)
    throws IOException
  {
    raiseAlert((short)1, paramShort, paramString, null);
  }
  
  protected int readApplicationData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 1) {
      return 0;
    }
    while (this.applicationDataQueue.available() == 0)
    {
      if (this.closed)
      {
        if (!this.failedWithError) {
          return -1;
        }
        throw new IOException("Internal TLS error, this could be an attack");
      }
      safeReadRecord();
    }
    paramInt2 = Math.min(paramInt2, this.applicationDataQueue.available());
    this.applicationDataQueue.removeData(paramArrayOfByte, paramInt1, paramInt2, 0);
    return paramInt2;
  }
  
  public int readInput(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.blocking) {
      try
      {
        paramInt1 = readApplicationData(paramArrayOfByte, paramInt1, Math.min(paramInt2, applicationDataAvailable()));
        return paramInt1;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new RuntimeException(paramArrayOfByte.toString());
      }
    }
    throw new IllegalStateException("Cannot use readInput() in blocking mode! Use getInputStream() instead.");
  }
  
  public int readOutput(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.blocking)
    {
      paramInt2 = Math.min(getAvailableOutputBytes(), paramInt2);
      this.outputBuffer.getBuffer().removeData(paramArrayOfByte, paramInt1, paramInt2, 0);
      return paramInt2;
    }
    throw new IllegalStateException("Cannot use readOutput() in blocking mode! Use getOutputStream() instead.");
  }
  
  protected void refuseRenegotiation()
    throws IOException
  {
    if (!TlsUtils.isSSL(getContext()))
    {
      raiseWarning((short)100, "Renegotiation not supported");
      return;
    }
    throw new TlsFatalAlert((short)40);
  }
  
  protected void safeCheckRecordHeader(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      this.recordStream.checkRecordHeader(paramArrayOfByte);
      return;
    }
    catch (RuntimeException paramArrayOfByte)
    {
      failWithError((short)2, (short)80, "Failed to read record", paramArrayOfByte);
      throw paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      failWithError((short)2, (short)80, "Failed to read record", paramArrayOfByte);
      throw paramArrayOfByte;
    }
    catch (TlsFatalAlert paramArrayOfByte)
    {
      failWithError((short)2, paramArrayOfByte.getAlertDescription(), "Failed to read record", paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  protected void safeReadRecord()
    throws IOException
  {
    try
    {
      if (!this.recordStream.readRecord())
      {
        if (!this.appDataReady) {
          throw new TlsFatalAlert((short)40);
        }
        throw new TlsNoCloseNotifyException();
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (!this.closed) {
        failWithError((short)2, (short)80, "Failed to read record", localRuntimeException);
      }
      throw localRuntimeException;
    }
    catch (IOException localIOException)
    {
      if (!this.closed) {
        failWithError((short)2, (short)80, "Failed to read record", localIOException);
      }
      throw localIOException;
    }
    catch (TlsFatalAlert localTlsFatalAlert)
    {
      if (!this.closed) {
        failWithError((short)2, localTlsFatalAlert.getAlertDescription(), "Failed to read record", localTlsFatalAlert);
      }
      throw localTlsFatalAlert;
    }
  }
  
  protected void safeWriteRecord(short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      this.recordStream.writeRecord(paramShort, paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (RuntimeException paramArrayOfByte)
    {
      if (!this.closed) {
        failWithError((short)2, (short)80, "Failed to write record", paramArrayOfByte);
      }
      throw paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      if (!this.closed) {
        failWithError((short)2, (short)80, "Failed to write record", paramArrayOfByte);
      }
      throw paramArrayOfByte;
    }
    catch (TlsFatalAlert paramArrayOfByte)
    {
      if (!this.closed) {
        failWithError((short)2, paramArrayOfByte.getAlertDescription(), "Failed to write record", paramArrayOfByte);
      }
      throw paramArrayOfByte;
    }
  }
  
  protected void sendCertificateMessage(Certificate paramCertificate)
    throws IOException
  {
    Object localObject = paramCertificate;
    if (paramCertificate == null) {
      localObject = Certificate.EMPTY_CHAIN;
    }
    if ((((Certificate)localObject).isEmpty()) && (!getContext().isServer()))
    {
      paramCertificate = getContext().getServerVersion();
      if (paramCertificate.isSSL())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramCertificate.toString());
        ((StringBuilder)localObject).append(" client didn't provide credentials");
        raiseWarning((short)41, ((StringBuilder)localObject).toString());
        return;
      }
    }
    paramCertificate = new HandshakeMessage((short)11);
    ((Certificate)localObject).encode(paramCertificate);
    paramCertificate.writeToRecordStream();
  }
  
  protected void sendChangeCipherSpecMessage()
    throws IOException
  {
    safeWriteRecord((short)20, new byte[] { 1 }, 0, 1);
    this.recordStream.sentWriteCipherSpec();
  }
  
  protected void sendFinishedMessage()
    throws IOException
  {
    byte[] arrayOfByte = createVerifyData(getContext().isServer());
    HandshakeMessage localHandshakeMessage = new HandshakeMessage((short)20, arrayOfByte.length);
    localHandshakeMessage.write(arrayOfByte);
    localHandshakeMessage.writeToRecordStream();
  }
  
  protected void sendSupplementalDataMessage(Vector paramVector)
    throws IOException
  {
    HandshakeMessage localHandshakeMessage = new HandshakeMessage((short)23);
    writeSupplementalData(localHandshakeMessage, paramVector);
    localHandshakeMessage.writeToRecordStream();
  }
  
  protected void setAppDataSplitMode(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 2))
    {
      this.appDataSplitMode = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Illegal appDataSplitMode mode: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  protected void writeData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.closed)
    {
      if (this.failedWithError) {
        throw new IOException("Internal TLS error, this could be an attack");
      }
      throw new IOException("Sorry, connection has been closed, you cannot write more data");
    }
    while (paramInt2 > 0)
    {
      int i = paramInt1;
      int j = paramInt2;
      if (this.appDataSplitEnabled)
      {
        i = this.appDataSplitMode;
        if (i != 1)
        {
          if (i != 2)
          {
            safeWriteRecord((short)23, paramArrayOfByte, paramInt1, 1);
            i = paramInt1 + 1;
            j = paramInt2 - 1;
          }
          else
          {
            this.appDataSplitEnabled = false;
          }
        }
        else
        {
          safeWriteRecord((short)23, TlsUtils.EMPTY_BYTES, 0, 0);
          j = paramInt2;
          i = paramInt1;
        }
      }
      paramInt1 = i;
      paramInt2 = j;
      if (j > 0)
      {
        paramInt2 = Math.min(j, this.recordStream.getPlaintextLimit());
        safeWriteRecord((short)23, paramArrayOfByte, i, paramInt2);
        paramInt1 = i + paramInt2;
        paramInt2 = j - paramInt2;
      }
    }
  }
  
  protected void writeHandshakeMessage(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 >= 4)
    {
      if (TlsUtils.readUint8(paramArrayOfByte, paramInt1) != 0) {
        this.recordStream.getHandshakeHashUpdater().write(paramArrayOfByte, paramInt1, paramInt2);
      }
      int i = 0;
      int j;
      do
      {
        j = Math.min(paramInt2 - i, this.recordStream.getPlaintextLimit());
        safeWriteRecord((short)22, paramArrayOfByte, paramInt1 + i, j);
        j = i + j;
        i = j;
      } while (j < paramInt2);
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  class HandshakeMessage
    extends ByteArrayOutputStream
  {
    HandshakeMessage(short paramShort)
      throws IOException
    {
      this(paramShort, 60);
    }
    
    HandshakeMessage(short paramShort, int paramInt)
      throws IOException
    {
      super();
      TlsUtils.writeUint8(paramShort, this);
      this.count += 3;
    }
    
    void writeToRecordStream()
      throws IOException
    {
      int i = this.count - 4;
      TlsUtils.checkUint24(i);
      TlsUtils.writeUint24(i, this.buf, 1);
      TlsProtocol.this.writeHandshakeMessage(this.buf, 0, this.count);
      this.buf = null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */