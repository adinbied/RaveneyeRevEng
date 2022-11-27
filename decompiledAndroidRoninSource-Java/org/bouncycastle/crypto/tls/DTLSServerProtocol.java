package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.Arrays;

public class DTLSServerProtocol
  extends DTLSProtocol
{
  protected boolean verifyRequests = true;
  
  public DTLSServerProtocol(SecureRandom paramSecureRandom)
  {
    super(paramSecureRandom);
  }
  
  protected void abortServerHandshake(ServerHandshakeState paramServerHandshakeState, DTLSRecordLayer paramDTLSRecordLayer, short paramShort)
  {
    paramDTLSRecordLayer.fail(paramShort);
    invalidateSession(paramServerHandshakeState);
  }
  
  /* Error */
  public DTLSTransport accept(TlsServer paramTlsServer, DatagramTransport paramDatagramTransport)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +182 -> 183
    //   4: aload_2
    //   5: ifnull +168 -> 173
    //   8: new 38	org/bouncycastle/crypto/tls/SecurityParameters
    //   11: dup
    //   12: invokespecial 41	org/bouncycastle/crypto/tls/SecurityParameters:<init>	()V
    //   15: astore_3
    //   16: aload_3
    //   17: iconst_0
    //   18: putfield 45	org/bouncycastle/crypto/tls/SecurityParameters:entity	I
    //   21: new 6	org/bouncycastle/crypto/tls/DTLSServerProtocol$ServerHandshakeState
    //   24: dup
    //   25: invokespecial 46	org/bouncycastle/crypto/tls/DTLSServerProtocol$ServerHandshakeState:<init>	()V
    //   28: astore 4
    //   30: aload 4
    //   32: aload_1
    //   33: putfield 50	org/bouncycastle/crypto/tls/DTLSServerProtocol$ServerHandshakeState:server	Lorg/bouncycastle/crypto/tls/TlsServer;
    //   36: aload 4
    //   38: new 52	org/bouncycastle/crypto/tls/TlsServerContextImpl
    //   41: dup
    //   42: aload_0
    //   43: getfield 56	org/bouncycastle/crypto/tls/DTLSServerProtocol:secureRandom	Ljava/security/SecureRandom;
    //   46: aload_3
    //   47: invokespecial 59	org/bouncycastle/crypto/tls/TlsServerContextImpl:<init>	(Ljava/security/SecureRandom;Lorg/bouncycastle/crypto/tls/SecurityParameters;)V
    //   50: putfield 63	org/bouncycastle/crypto/tls/DTLSServerProtocol$ServerHandshakeState:serverContext	Lorg/bouncycastle/crypto/tls/TlsServerContextImpl;
    //   53: aload_3
    //   54: aload_1
    //   55: invokeinterface 69 1 0
    //   60: aload 4
    //   62: getfield 63	org/bouncycastle/crypto/tls/DTLSServerProtocol$ServerHandshakeState:serverContext	Lorg/bouncycastle/crypto/tls/TlsServerContextImpl;
    //   65: invokevirtual 73	org/bouncycastle/crypto/tls/TlsServerContextImpl:getNonceRandomGenerator	()Lorg/bouncycastle/crypto/prng/RandomGenerator;
    //   68: invokestatic 79	org/bouncycastle/crypto/tls/TlsProtocol:createRandomBlock	(ZLorg/bouncycastle/crypto/prng/RandomGenerator;)[B
    //   71: putfield 83	org/bouncycastle/crypto/tls/SecurityParameters:serverRandom	[B
    //   74: aload_1
    //   75: aload 4
    //   77: getfield 63	org/bouncycastle/crypto/tls/DTLSServerProtocol$ServerHandshakeState:serverContext	Lorg/bouncycastle/crypto/tls/TlsServerContextImpl;
    //   80: invokeinterface 87 2 0
    //   85: new 20	org/bouncycastle/crypto/tls/DTLSRecordLayer
    //   88: dup
    //   89: aload_2
    //   90: aload 4
    //   92: getfield 63	org/bouncycastle/crypto/tls/DTLSServerProtocol$ServerHandshakeState:serverContext	Lorg/bouncycastle/crypto/tls/TlsServerContextImpl;
    //   95: aload_1
    //   96: bipush 22
    //   98: invokespecial 90	org/bouncycastle/crypto/tls/DTLSRecordLayer:<init>	(Lorg/bouncycastle/crypto/tls/DatagramTransport;Lorg/bouncycastle/crypto/tls/TlsContext;Lorg/bouncycastle/crypto/tls/TlsPeer;S)V
    //   101: astore_1
    //   102: aload_0
    //   103: aload 4
    //   105: aload_1
    //   106: invokevirtual 94	org/bouncycastle/crypto/tls/DTLSServerProtocol:serverHandshake	(Lorg/bouncycastle/crypto/tls/DTLSServerProtocol$ServerHandshakeState;Lorg/bouncycastle/crypto/tls/DTLSRecordLayer;)Lorg/bouncycastle/crypto/tls/DTLSTransport;
    //   109: astore_2
    //   110: aload_3
    //   111: invokevirtual 97	org/bouncycastle/crypto/tls/SecurityParameters:clear	()V
    //   114: aload_2
    //   115: areturn
    //   116: astore_1
    //   117: goto +50 -> 167
    //   120: astore_2
    //   121: aload_0
    //   122: aload 4
    //   124: aload_1
    //   125: bipush 80
    //   127: invokevirtual 99	org/bouncycastle/crypto/tls/DTLSServerProtocol:abortServerHandshake	(Lorg/bouncycastle/crypto/tls/DTLSServerProtocol$ServerHandshakeState;Lorg/bouncycastle/crypto/tls/DTLSRecordLayer;S)V
    //   130: new 34	org/bouncycastle/crypto/tls/TlsFatalAlert
    //   133: dup
    //   134: bipush 80
    //   136: aload_2
    //   137: invokespecial 102	org/bouncycastle/crypto/tls/TlsFatalAlert:<init>	(SLjava/lang/Throwable;)V
    //   140: athrow
    //   141: astore_2
    //   142: aload_0
    //   143: aload 4
    //   145: aload_1
    //   146: bipush 80
    //   148: invokevirtual 99	org/bouncycastle/crypto/tls/DTLSServerProtocol:abortServerHandshake	(Lorg/bouncycastle/crypto/tls/DTLSServerProtocol$ServerHandshakeState;Lorg/bouncycastle/crypto/tls/DTLSRecordLayer;S)V
    //   151: aload_2
    //   152: athrow
    //   153: astore_2
    //   154: aload_0
    //   155: aload 4
    //   157: aload_1
    //   158: aload_2
    //   159: invokevirtual 106	org/bouncycastle/crypto/tls/TlsFatalAlert:getAlertDescription	()S
    //   162: invokevirtual 99	org/bouncycastle/crypto/tls/DTLSServerProtocol:abortServerHandshake	(Lorg/bouncycastle/crypto/tls/DTLSServerProtocol$ServerHandshakeState;Lorg/bouncycastle/crypto/tls/DTLSRecordLayer;S)V
    //   165: aload_2
    //   166: athrow
    //   167: aload_3
    //   168: invokevirtual 97	org/bouncycastle/crypto/tls/SecurityParameters:clear	()V
    //   171: aload_1
    //   172: athrow
    //   173: new 108	java/lang/IllegalArgumentException
    //   176: dup
    //   177: ldc 110
    //   179: invokespecial 113	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   182: athrow
    //   183: new 108	java/lang/IllegalArgumentException
    //   186: dup
    //   187: ldc 115
    //   189: invokespecial 113	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	DTLSServerProtocol
    //   0	193	1	paramTlsServer	TlsServer
    //   0	193	2	paramDatagramTransport	DatagramTransport
    //   15	153	3	localSecurityParameters	SecurityParameters
    //   28	128	4	localServerHandshakeState	ServerHandshakeState
    // Exception table:
    //   from	to	target	type
    //   102	110	116	finally
    //   121	141	116	finally
    //   142	153	116	finally
    //   154	167	116	finally
    //   102	110	120	java/lang/RuntimeException
    //   102	110	141	java/io/IOException
    //   102	110	153	org/bouncycastle/crypto/tls/TlsFatalAlert
  }
  
  protected boolean expectCertificateVerifyMessage(ServerHandshakeState paramServerHandshakeState)
  {
    return (paramServerHandshakeState.clientCertificateType >= 0) && (TlsUtils.hasSigningCapability(paramServerHandshakeState.clientCertificateType));
  }
  
  protected byte[] generateCertificateRequest(ServerHandshakeState paramServerHandshakeState, CertificateRequest paramCertificateRequest)
    throws IOException
  {
    paramServerHandshakeState = new ByteArrayOutputStream();
    paramCertificateRequest.encode(paramServerHandshakeState);
    return paramServerHandshakeState.toByteArray();
  }
  
  protected byte[] generateCertificateStatus(ServerHandshakeState paramServerHandshakeState, CertificateStatus paramCertificateStatus)
    throws IOException
  {
    paramServerHandshakeState = new ByteArrayOutputStream();
    paramCertificateStatus.encode(paramServerHandshakeState);
    return paramServerHandshakeState.toByteArray();
  }
  
  protected byte[] generateNewSessionTicket(ServerHandshakeState paramServerHandshakeState, NewSessionTicket paramNewSessionTicket)
    throws IOException
  {
    paramServerHandshakeState = new ByteArrayOutputStream();
    paramNewSessionTicket.encode(paramServerHandshakeState);
    return paramServerHandshakeState.toByteArray();
  }
  
  protected byte[] generateServerHello(ServerHandshakeState paramServerHandshakeState)
    throws IOException
  {
    SecurityParameters localSecurityParameters = paramServerHandshakeState.serverContext.getSecurityParameters();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ProtocolVersion localProtocolVersion = paramServerHandshakeState.server.getServerVersion();
    if (localProtocolVersion.isEqualOrEarlierVersionOf(paramServerHandshakeState.serverContext.getClientVersion()))
    {
      paramServerHandshakeState.serverContext.setServerVersion(localProtocolVersion);
      TlsUtils.writeVersion(paramServerHandshakeState.serverContext.getServerVersion(), localByteArrayOutputStream);
      localByteArrayOutputStream.write(localSecurityParameters.getServerRandom());
      TlsUtils.writeOpaque8(TlsUtils.EMPTY_BYTES, localByteArrayOutputStream);
      int i = paramServerHandshakeState.server.getSelectedCipherSuite();
      if ((Arrays.contains(paramServerHandshakeState.offeredCipherSuites, i)) && (i != 0) && (!CipherSuite.isSCSV(i)) && (TlsUtils.isValidCipherSuiteForVersion(i, paramServerHandshakeState.serverContext.getServerVersion())))
      {
        validateSelectedCipherSuite(i, (short)80);
        localSecurityParameters.cipherSuite = i;
        short s = paramServerHandshakeState.server.getSelectedCompressionMethod();
        if (Arrays.contains(paramServerHandshakeState.offeredCompressionMethods, s))
        {
          localSecurityParameters.compressionAlgorithm = s;
          TlsUtils.writeUint16(i, localByteArrayOutputStream);
          TlsUtils.writeUint8(s, localByteArrayOutputStream);
          paramServerHandshakeState.serverExtensions = paramServerHandshakeState.server.getServerExtensions();
          boolean bool1 = paramServerHandshakeState.secure_renegotiation;
          boolean bool2 = true;
          if (bool1)
          {
            if (TlsUtils.getExtensionData(paramServerHandshakeState.serverExtensions, TlsProtocol.EXT_RenegotiationInfo) == null) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0)
            {
              paramServerHandshakeState.serverExtensions = TlsExtensionsUtils.ensureExtensionsInitialised(paramServerHandshakeState.serverExtensions);
              paramServerHandshakeState.serverExtensions.put(TlsProtocol.EXT_RenegotiationInfo, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES));
            }
          }
          if (localSecurityParameters.extendedMasterSecret)
          {
            paramServerHandshakeState.serverExtensions = TlsExtensionsUtils.ensureExtensionsInitialised(paramServerHandshakeState.serverExtensions);
            TlsExtensionsUtils.addExtendedMasterSecretExtension(paramServerHandshakeState.serverExtensions);
          }
          if (paramServerHandshakeState.serverExtensions != null)
          {
            localSecurityParameters.encryptThenMAC = TlsExtensionsUtils.hasEncryptThenMACExtension(paramServerHandshakeState.serverExtensions);
            localSecurityParameters.maxFragmentLength = evaluateMaxFragmentLengthExtension(paramServerHandshakeState.resumedSession, paramServerHandshakeState.clientExtensions, paramServerHandshakeState.serverExtensions, (short)80);
            localSecurityParameters.truncatedHMac = TlsExtensionsUtils.hasTruncatedHMacExtension(paramServerHandshakeState.serverExtensions);
            if ((!paramServerHandshakeState.resumedSession) && (TlsUtils.hasExpectedEmptyExtensionData(paramServerHandshakeState.serverExtensions, TlsExtensionsUtils.EXT_status_request, (short)80))) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            paramServerHandshakeState.allowCertificateStatus = bool1;
            if ((!paramServerHandshakeState.resumedSession) && (TlsUtils.hasExpectedEmptyExtensionData(paramServerHandshakeState.serverExtensions, TlsProtocol.EXT_SessionTicket, (short)80))) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
            paramServerHandshakeState.expectSessionTicket = bool1;
            TlsProtocol.writeExtensions(localByteArrayOutputStream, paramServerHandshakeState.serverExtensions);
          }
          localSecurityParameters.prfAlgorithm = TlsProtocol.getPRFAlgorithm(paramServerHandshakeState.serverContext, localSecurityParameters.getCipherSuite());
          localSecurityParameters.verifyDataLength = 12;
          return localByteArrayOutputStream.toByteArray();
        }
        throw new TlsFatalAlert((short)80);
      }
      throw new TlsFatalAlert((short)80);
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public boolean getVerifyRequests()
  {
    return this.verifyRequests;
  }
  
  protected void invalidateSession(ServerHandshakeState paramServerHandshakeState)
  {
    if (paramServerHandshakeState.sessionParameters != null)
    {
      paramServerHandshakeState.sessionParameters.clear();
      paramServerHandshakeState.sessionParameters = null;
    }
    if (paramServerHandshakeState.tlsSession != null)
    {
      paramServerHandshakeState.tlsSession.invalidate();
      paramServerHandshakeState.tlsSession = null;
    }
  }
  
  protected void notifyClientCertificate(ServerHandshakeState paramServerHandshakeState, Certificate paramCertificate)
    throws IOException
  {
    if (paramServerHandshakeState.certificateRequest != null)
    {
      if (paramServerHandshakeState.clientCertificate == null)
      {
        paramServerHandshakeState.clientCertificate = paramCertificate;
        if (paramCertificate.isEmpty())
        {
          paramServerHandshakeState.keyExchange.skipClientCredentials();
        }
        else
        {
          paramServerHandshakeState.clientCertificateType = TlsUtils.getClientCertificateType(paramCertificate, paramServerHandshakeState.serverCredentials.getCertificate());
          paramServerHandshakeState.keyExchange.processClientCertificate(paramCertificate);
        }
        paramServerHandshakeState.server.notifyClientCertificate(paramCertificate);
        return;
      }
      throw new TlsFatalAlert((short)10);
    }
    throw new IllegalStateException();
  }
  
  protected void processCertificateVerify(ServerHandshakeState paramServerHandshakeState, byte[] paramArrayOfByte, TlsHandshakeHash paramTlsHandshakeHash)
    throws IOException
  {
    if (paramServerHandshakeState.certificateRequest != null)
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      TlsServerContextImpl localTlsServerContextImpl = paramServerHandshakeState.serverContext;
      DigitallySigned localDigitallySigned = DigitallySigned.parse(localTlsServerContextImpl, paramArrayOfByte);
      TlsProtocol.assertEmpty(paramArrayOfByte);
      try
      {
        SignatureAndHashAlgorithm localSignatureAndHashAlgorithm = localDigitallySigned.getAlgorithm();
        if (TlsUtils.isTLSv12(localTlsServerContextImpl))
        {
          TlsUtils.verifySupportedSignatureAlgorithm(paramServerHandshakeState.certificateRequest.getSupportedSignatureAlgorithms(), localSignatureAndHashAlgorithm);
          paramArrayOfByte = paramTlsHandshakeHash.getFinalHash(localSignatureAndHashAlgorithm.getHash());
        }
        else
        {
          paramArrayOfByte = localTlsServerContextImpl.getSecurityParameters().getSessionHash();
        }
        paramTlsHandshakeHash = PublicKeyFactory.createKey(paramServerHandshakeState.clientCertificate.getCertificateAt(0).getSubjectPublicKeyInfo());
        paramServerHandshakeState = TlsUtils.createTlsSigner(paramServerHandshakeState.clientCertificateType);
        paramServerHandshakeState.init(localTlsServerContextImpl);
        if (paramServerHandshakeState.verifyRawSignature(localSignatureAndHashAlgorithm, localDigitallySigned.getSignature(), paramTlsHandshakeHash, paramArrayOfByte)) {
          return;
        }
        throw new TlsFatalAlert((short)51);
      }
      catch (Exception paramServerHandshakeState)
      {
        throw new TlsFatalAlert((short)51, paramServerHandshakeState);
      }
      catch (TlsFatalAlert paramServerHandshakeState)
      {
        throw paramServerHandshakeState;
      }
    }
    throw new IllegalStateException();
  }
  
  protected void processClientCertificate(ServerHandshakeState paramServerHandshakeState, byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    Certificate localCertificate = Certificate.parse(paramArrayOfByte);
    TlsProtocol.assertEmpty(paramArrayOfByte);
    notifyClientCertificate(paramServerHandshakeState, localCertificate);
  }
  
  protected void processClientHello(ServerHandshakeState paramServerHandshakeState, byte[] paramArrayOfByte)
    throws IOException
  {
    Object localObject = new ByteArrayInputStream(paramArrayOfByte);
    paramArrayOfByte = TlsUtils.readVersion((InputStream)localObject);
    if (paramArrayOfByte.isDTLS())
    {
      byte[] arrayOfByte = TlsUtils.readFully(32, (InputStream)localObject);
      if (TlsUtils.readOpaque8((InputStream)localObject).length <= 32)
      {
        TlsUtils.readOpaque8((InputStream)localObject);
        int i = TlsUtils.readUint16((InputStream)localObject);
        if ((i >= 2) && ((i & 0x1) == 0))
        {
          paramServerHandshakeState.offeredCipherSuites = TlsUtils.readUint16Array(i / 2, (InputStream)localObject);
          i = TlsUtils.readUint8((InputStream)localObject);
          if (i >= 1)
          {
            paramServerHandshakeState.offeredCompressionMethods = TlsUtils.readUint8Array(i, (InputStream)localObject);
            paramServerHandshakeState.clientExtensions = TlsProtocol.readExtensions((ByteArrayInputStream)localObject);
            localObject = paramServerHandshakeState.serverContext;
            SecurityParameters localSecurityParameters = ((TlsServerContextImpl)localObject).getSecurityParameters();
            localSecurityParameters.extendedMasterSecret = TlsExtensionsUtils.hasExtendedMasterSecretExtension(paramServerHandshakeState.clientExtensions);
            ((TlsServerContextImpl)localObject).setClientVersion(paramArrayOfByte);
            paramServerHandshakeState.server.notifyClientVersion(paramArrayOfByte);
            paramServerHandshakeState.server.notifyFallback(Arrays.contains(paramServerHandshakeState.offeredCipherSuites, 22016));
            localSecurityParameters.clientRandom = arrayOfByte;
            paramServerHandshakeState.server.notifyOfferedCipherSuites(paramServerHandshakeState.offeredCipherSuites);
            paramServerHandshakeState.server.notifyOfferedCompressionMethods(paramServerHandshakeState.offeredCompressionMethods);
            if (Arrays.contains(paramServerHandshakeState.offeredCipherSuites, 255)) {
              paramServerHandshakeState.secure_renegotiation = true;
            }
            paramArrayOfByte = TlsUtils.getExtensionData(paramServerHandshakeState.clientExtensions, TlsProtocol.EXT_RenegotiationInfo);
            if (paramArrayOfByte != null)
            {
              paramServerHandshakeState.secure_renegotiation = true;
              if (!Arrays.constantTimeAreEqual(paramArrayOfByte, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                throw new TlsFatalAlert((short)40);
              }
            }
            paramServerHandshakeState.server.notifySecureRenegotiation(paramServerHandshakeState.secure_renegotiation);
            if (paramServerHandshakeState.clientExtensions != null)
            {
              TlsExtensionsUtils.getPaddingExtension(paramServerHandshakeState.clientExtensions);
              paramServerHandshakeState.server.processClientExtensions(paramServerHandshakeState.clientExtensions);
            }
            return;
          }
          throw new TlsFatalAlert((short)47);
        }
        throw new TlsFatalAlert((short)50);
      }
      throw new TlsFatalAlert((short)47);
    }
    throw new TlsFatalAlert((short)47);
  }
  
  protected void processClientKeyExchange(ServerHandshakeState paramServerHandshakeState, byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    paramServerHandshakeState.keyExchange.processClientKeyExchange(paramArrayOfByte);
    TlsProtocol.assertEmpty(paramArrayOfByte);
  }
  
  protected void processClientSupplementalData(ServerHandshakeState paramServerHandshakeState, byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = TlsProtocol.readSupplementalDataMessage(new ByteArrayInputStream(paramArrayOfByte));
    paramServerHandshakeState.server.processClientSupplementalData(paramArrayOfByte);
  }
  
  protected DTLSTransport serverHandshake(ServerHandshakeState paramServerHandshakeState, DTLSRecordLayer paramDTLSRecordLayer)
    throws IOException
  {
    SecurityParameters localSecurityParameters = paramServerHandshakeState.serverContext.getSecurityParameters();
    DTLSReliableHandshake localDTLSReliableHandshake = new DTLSReliableHandshake(paramServerHandshakeState.serverContext, paramDTLSRecordLayer);
    Object localObject = localDTLSReliableHandshake.receiveMessage();
    int i = ((DTLSReliableHandshake.Message)localObject).getType();
    boolean bool1 = true;
    if (i == 1)
    {
      processClientHello(paramServerHandshakeState, ((DTLSReliableHandshake.Message)localObject).getBody());
      localObject = generateServerHello(paramServerHandshakeState);
      applyMaxFragmentLengthExtension(paramDTLSRecordLayer, localSecurityParameters.maxFragmentLength);
      ProtocolVersion localProtocolVersion = paramServerHandshakeState.serverContext.getServerVersion();
      paramDTLSRecordLayer.setReadVersion(localProtocolVersion);
      paramDTLSRecordLayer.setWriteVersion(localProtocolVersion);
      localDTLSReliableHandshake.sendMessage((short)2, (byte[])localObject);
      localDTLSReliableHandshake.notifyHelloComplete();
      localObject = paramServerHandshakeState.server.getServerSupplementalData();
      if (localObject != null) {
        localDTLSReliableHandshake.sendMessage((short)23, generateSupplementalData((Vector)localObject));
      }
      paramServerHandshakeState.keyExchange = paramServerHandshakeState.server.getKeyExchange();
      paramServerHandshakeState.keyExchange.init(paramServerHandshakeState.serverContext);
      paramServerHandshakeState.serverCredentials = paramServerHandshakeState.server.getCredentials();
      if (paramServerHandshakeState.serverCredentials == null)
      {
        paramServerHandshakeState.keyExchange.skipServerCredentials();
        localObject = null;
      }
      else
      {
        paramServerHandshakeState.keyExchange.processServerCredentials(paramServerHandshakeState.serverCredentials);
        localObject = paramServerHandshakeState.serverCredentials.getCertificate();
        localDTLSReliableHandshake.sendMessage((short)11, generateCertificate((Certificate)localObject));
      }
      if ((localObject == null) || (((Certificate)localObject).isEmpty())) {
        paramServerHandshakeState.allowCertificateStatus = false;
      }
      if (paramServerHandshakeState.allowCertificateStatus)
      {
        localObject = paramServerHandshakeState.server.getCertificateStatus();
        if (localObject != null) {
          localDTLSReliableHandshake.sendMessage((short)22, generateCertificateStatus(paramServerHandshakeState, (CertificateStatus)localObject));
        }
      }
      localObject = paramServerHandshakeState.keyExchange.generateServerKeyExchange();
      if (localObject != null) {
        localDTLSReliableHandshake.sendMessage((short)12, (byte[])localObject);
      }
      if (paramServerHandshakeState.serverCredentials != null)
      {
        paramServerHandshakeState.certificateRequest = paramServerHandshakeState.server.getCertificateRequest();
        if (paramServerHandshakeState.certificateRequest != null)
        {
          boolean bool2 = TlsUtils.isTLSv12(paramServerHandshakeState.serverContext);
          if (paramServerHandshakeState.certificateRequest.getSupportedSignatureAlgorithms() == null) {
            bool1 = false;
          }
          if (bool2 == bool1)
          {
            paramServerHandshakeState.keyExchange.validateCertificateRequest(paramServerHandshakeState.certificateRequest);
            localDTLSReliableHandshake.sendMessage((short)13, generateCertificateRequest(paramServerHandshakeState, paramServerHandshakeState.certificateRequest));
            TlsUtils.trackHashAlgorithms(localDTLSReliableHandshake.getHandshakeHash(), paramServerHandshakeState.certificateRequest.getSupportedSignatureAlgorithms());
          }
          else
          {
            throw new TlsFatalAlert((short)80);
          }
        }
      }
      localDTLSReliableHandshake.sendMessage((short)14, TlsUtils.EMPTY_BYTES);
      localDTLSReliableHandshake.getHandshakeHash().sealHashAlgorithms();
      localObject = localDTLSReliableHandshake.receiveMessage();
      if (((DTLSReliableHandshake.Message)localObject).getType() == 23)
      {
        processClientSupplementalData(paramServerHandshakeState, ((DTLSReliableHandshake.Message)localObject).getBody());
        localObject = localDTLSReliableHandshake.receiveMessage();
      }
      else
      {
        paramServerHandshakeState.server.processClientSupplementalData(null);
      }
      if (paramServerHandshakeState.certificateRequest == null)
      {
        paramServerHandshakeState.keyExchange.skipClientCredentials();
      }
      else if (((DTLSReliableHandshake.Message)localObject).getType() == 11)
      {
        processClientCertificate(paramServerHandshakeState, ((DTLSReliableHandshake.Message)localObject).getBody());
        localObject = localDTLSReliableHandshake.receiveMessage();
      }
      else
      {
        if (TlsUtils.isTLSv12(paramServerHandshakeState.serverContext)) {
          break label775;
        }
        notifyClientCertificate(paramServerHandshakeState, Certificate.EMPTY_CHAIN);
      }
      if (((DTLSReliableHandshake.Message)localObject).getType() == 16)
      {
        processClientKeyExchange(paramServerHandshakeState, ((DTLSReliableHandshake.Message)localObject).getBody());
        localObject = localDTLSReliableHandshake.prepareToFinish();
        localSecurityParameters.sessionHash = TlsProtocol.getCurrentPRFHash(paramServerHandshakeState.serverContext, (TlsHandshakeHash)localObject, null);
        TlsProtocol.establishMasterSecret(paramServerHandshakeState.serverContext, paramServerHandshakeState.keyExchange);
        paramDTLSRecordLayer.initPendingEpoch(paramServerHandshakeState.server.getCipher());
        if (expectCertificateVerifyMessage(paramServerHandshakeState)) {
          processCertificateVerify(paramServerHandshakeState, localDTLSReliableHandshake.receiveMessageBody((short)15), (TlsHandshakeHash)localObject);
        }
        localObject = TlsUtils.calculateVerifyData(paramServerHandshakeState.serverContext, "client finished", TlsProtocol.getCurrentPRFHash(paramServerHandshakeState.serverContext, localDTLSReliableHandshake.getHandshakeHash(), null));
        processFinished(localDTLSReliableHandshake.receiveMessageBody((short)20), (byte[])localObject);
        if (paramServerHandshakeState.expectSessionTicket) {
          localDTLSReliableHandshake.sendMessage((short)4, generateNewSessionTicket(paramServerHandshakeState, paramServerHandshakeState.server.getNewSessionTicket()));
        }
        localDTLSReliableHandshake.sendMessage((short)20, TlsUtils.calculateVerifyData(paramServerHandshakeState.serverContext, "server finished", TlsProtocol.getCurrentPRFHash(paramServerHandshakeState.serverContext, localDTLSReliableHandshake.getHandshakeHash(), null)));
        localDTLSReliableHandshake.finish();
        paramServerHandshakeState.server.notifyHandshakeComplete();
        return new DTLSTransport(paramDTLSRecordLayer);
      }
      throw new TlsFatalAlert((short)10);
      label775:
      throw new TlsFatalAlert((short)10);
    }
    throw new TlsFatalAlert((short)10);
  }
  
  public void setVerifyRequests(boolean paramBoolean)
  {
    this.verifyRequests = paramBoolean;
  }
  
  protected static class ServerHandshakeState
  {
    boolean allowCertificateStatus = false;
    CertificateRequest certificateRequest = null;
    Certificate clientCertificate = null;
    short clientCertificateType = -1;
    Hashtable clientExtensions = null;
    boolean expectSessionTicket = false;
    TlsKeyExchange keyExchange = null;
    int[] offeredCipherSuites = null;
    short[] offeredCompressionMethods = null;
    boolean resumedSession = false;
    boolean secure_renegotiation = false;
    TlsServer server = null;
    TlsServerContextImpl serverContext = null;
    TlsCredentials serverCredentials = null;
    Hashtable serverExtensions = null;
    SessionParameters sessionParameters = null;
    SessionParameters.Builder sessionParametersBuilder = null;
    TlsSession tlsSession = null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DTLSServerProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */