package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.util.Arrays;

public class DTLSClientProtocol
  extends DTLSProtocol
{
  public DTLSClientProtocol(SecureRandom paramSecureRandom)
  {
    super(paramSecureRandom);
  }
  
  protected static byte[] patchClientHelloWithCookie(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws IOException
  {
    int i = 35 + TlsUtils.readUint8(paramArrayOfByte1, 34);
    int j = i + 1;
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, i);
    TlsUtils.checkUint8(paramArrayOfByte2.length);
    TlsUtils.writeUint8(paramArrayOfByte2.length, arrayOfByte, i);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, j, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte1, j, arrayOfByte, paramArrayOfByte2.length + j, paramArrayOfByte1.length - j);
    return arrayOfByte;
  }
  
  protected void abortClientHandshake(ClientHandshakeState paramClientHandshakeState, DTLSRecordLayer paramDTLSRecordLayer, short paramShort)
  {
    paramDTLSRecordLayer.fail(paramShort);
    invalidateSession(paramClientHandshakeState);
  }
  
  protected DTLSTransport clientHandshake(ClientHandshakeState paramClientHandshakeState, DTLSRecordLayer paramDTLSRecordLayer)
    throws IOException
  {
    SecurityParameters localSecurityParameters = paramClientHandshakeState.clientContext.getSecurityParameters();
    DTLSReliableHandshake localDTLSReliableHandshake = new DTLSReliableHandshake(paramClientHandshakeState.clientContext, paramDTLSRecordLayer);
    Object localObject1 = generateClientHello(paramClientHandshakeState, paramClientHandshakeState.client);
    paramDTLSRecordLayer.setWriteVersion(ProtocolVersion.DTLSv10);
    localDTLSReliableHandshake.sendMessage((short)1, (byte[])localObject1);
    Object localObject2;
    for (;;)
    {
      localObject2 = localDTLSReliableHandshake.receiveMessage();
      if (((DTLSReliableHandshake.Message)localObject2).getType() != 3) {
        break label127;
      }
      if (!paramDTLSRecordLayer.getReadVersion().isEqualOrEarlierVersionOf(paramClientHandshakeState.clientContext.getClientVersion())) {
        break;
      }
      paramDTLSRecordLayer.setReadVersion(null);
      localObject2 = patchClientHelloWithCookie((byte[])localObject1, processHelloVerifyRequest(paramClientHandshakeState, ((DTLSReliableHandshake.Message)localObject2).getBody()));
      localDTLSReliableHandshake.resetHandshakeMessagesDigest();
      localDTLSReliableHandshake.sendMessage((short)1, (byte[])localObject2);
    }
    throw new TlsFatalAlert((short)47);
    label127:
    if (((DTLSReliableHandshake.Message)localObject2).getType() == 2)
    {
      localObject1 = paramDTLSRecordLayer.getReadVersion();
      reportServerVersion(paramClientHandshakeState, (ProtocolVersion)localObject1);
      paramDTLSRecordLayer.setWriteVersion((ProtocolVersion)localObject1);
      processServerHello(paramClientHandshakeState, ((DTLSReliableHandshake.Message)localObject2).getBody());
      localDTLSReliableHandshake.notifyHelloComplete();
      applyMaxFragmentLengthExtension(paramDTLSRecordLayer, localSecurityParameters.maxFragmentLength);
      if (paramClientHandshakeState.resumedSession)
      {
        localSecurityParameters.masterSecret = Arrays.clone(paramClientHandshakeState.sessionParameters.getMasterSecret());
        paramDTLSRecordLayer.initPendingEpoch(paramClientHandshakeState.client.getCipher());
        localObject1 = TlsUtils.calculateVerifyData(paramClientHandshakeState.clientContext, "server finished", TlsProtocol.getCurrentPRFHash(paramClientHandshakeState.clientContext, localDTLSReliableHandshake.getHandshakeHash(), null));
        processFinished(localDTLSReliableHandshake.receiveMessageBody((short)20), (byte[])localObject1);
        localDTLSReliableHandshake.sendMessage((short)20, TlsUtils.calculateVerifyData(paramClientHandshakeState.clientContext, "client finished", TlsProtocol.getCurrentPRFHash(paramClientHandshakeState.clientContext, localDTLSReliableHandshake.getHandshakeHash(), null)));
        localDTLSReliableHandshake.finish();
        paramClientHandshakeState.clientContext.setResumableSession(paramClientHandshakeState.tlsSession);
        paramClientHandshakeState.client.notifyHandshakeComplete();
        return new DTLSTransport(paramDTLSRecordLayer);
      }
      invalidateSession(paramClientHandshakeState);
      if (paramClientHandshakeState.selectedSessionID.length > 0) {
        paramClientHandshakeState.tlsSession = new TlsSessionImpl(paramClientHandshakeState.selectedSessionID, null);
      }
      localObject1 = localDTLSReliableHandshake.receiveMessage();
      if (((DTLSReliableHandshake.Message)localObject1).getType() == 23)
      {
        processServerSupplementalData(paramClientHandshakeState, ((DTLSReliableHandshake.Message)localObject1).getBody());
        localObject1 = localDTLSReliableHandshake.receiveMessage();
      }
      else
      {
        paramClientHandshakeState.client.processServerSupplementalData(null);
      }
      paramClientHandshakeState.keyExchange = paramClientHandshakeState.client.getKeyExchange();
      paramClientHandshakeState.keyExchange.init(paramClientHandshakeState.clientContext);
      Certificate localCertificate;
      if (((DTLSReliableHandshake.Message)localObject1).getType() == 11)
      {
        localCertificate = processServerCertificate(paramClientHandshakeState, ((DTLSReliableHandshake.Message)localObject1).getBody());
        localObject1 = localDTLSReliableHandshake.receiveMessage();
      }
      else
      {
        paramClientHandshakeState.keyExchange.skipServerCredentials();
        localCertificate = null;
      }
      if ((localCertificate == null) || (localCertificate.isEmpty())) {
        paramClientHandshakeState.allowCertificateStatus = false;
      }
      localObject2 = localObject1;
      if (((DTLSReliableHandshake.Message)localObject1).getType() == 22)
      {
        processCertificateStatus(paramClientHandshakeState, ((DTLSReliableHandshake.Message)localObject1).getBody());
        localObject2 = localDTLSReliableHandshake.receiveMessage();
      }
      if (((DTLSReliableHandshake.Message)localObject2).getType() == 12)
      {
        processServerKeyExchange(paramClientHandshakeState, ((DTLSReliableHandshake.Message)localObject2).getBody());
        localObject2 = localDTLSReliableHandshake.receiveMessage();
      }
      else
      {
        paramClientHandshakeState.keyExchange.skipServerKeyExchange();
      }
      localObject1 = localObject2;
      if (((DTLSReliableHandshake.Message)localObject2).getType() == 13)
      {
        processCertificateRequest(paramClientHandshakeState, ((DTLSReliableHandshake.Message)localObject2).getBody());
        TlsUtils.trackHashAlgorithms(localDTLSReliableHandshake.getHandshakeHash(), paramClientHandshakeState.certificateRequest.getSupportedSignatureAlgorithms());
        localObject1 = localDTLSReliableHandshake.receiveMessage();
      }
      if (((DTLSReliableHandshake.Message)localObject1).getType() == 14)
      {
        if (((DTLSReliableHandshake.Message)localObject1).getBody().length == 0)
        {
          localDTLSReliableHandshake.getHandshakeHash().sealHashAlgorithms();
          localObject1 = paramClientHandshakeState.client.getClientSupplementalData();
          if (localObject1 != null) {
            localDTLSReliableHandshake.sendMessage((short)23, generateSupplementalData((Vector)localObject1));
          }
          if (paramClientHandshakeState.certificateRequest != null)
          {
            paramClientHandshakeState.clientCredentials = paramClientHandshakeState.authentication.getClientCredentials(paramClientHandshakeState.certificateRequest);
            if (paramClientHandshakeState.clientCredentials != null) {
              localObject1 = paramClientHandshakeState.clientCredentials.getCertificate();
            } else {
              localObject1 = null;
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = Certificate.EMPTY_CHAIN;
            }
            localDTLSReliableHandshake.sendMessage((short)11, generateCertificate((Certificate)localObject2));
          }
          if (paramClientHandshakeState.clientCredentials != null) {
            paramClientHandshakeState.keyExchange.processClientCredentials(paramClientHandshakeState.clientCredentials);
          } else {
            paramClientHandshakeState.keyExchange.skipClientCredentials();
          }
          localDTLSReliableHandshake.sendMessage((short)16, generateClientKeyExchange(paramClientHandshakeState));
          localObject1 = localDTLSReliableHandshake.prepareToFinish();
          localSecurityParameters.sessionHash = TlsProtocol.getCurrentPRFHash(paramClientHandshakeState.clientContext, (TlsHandshakeHash)localObject1, null);
          TlsProtocol.establishMasterSecret(paramClientHandshakeState.clientContext, paramClientHandshakeState.keyExchange);
          paramDTLSRecordLayer.initPendingEpoch(paramClientHandshakeState.client.getCipher());
          if ((paramClientHandshakeState.clientCredentials != null) && ((paramClientHandshakeState.clientCredentials instanceof TlsSignerCredentials)))
          {
            localObject2 = (TlsSignerCredentials)paramClientHandshakeState.clientCredentials;
            SignatureAndHashAlgorithm localSignatureAndHashAlgorithm = TlsUtils.getSignatureAndHashAlgorithm(paramClientHandshakeState.clientContext, (TlsSignerCredentials)localObject2);
            if (localSignatureAndHashAlgorithm == null) {
              localObject1 = localSecurityParameters.getSessionHash();
            } else {
              localObject1 = ((TlsHandshakeHash)localObject1).getFinalHash(localSignatureAndHashAlgorithm.getHash());
            }
            localDTLSReliableHandshake.sendMessage((short)15, generateCertificateVerify(paramClientHandshakeState, new DigitallySigned(localSignatureAndHashAlgorithm, ((TlsSignerCredentials)localObject2).generateCertificateSignature((byte[])localObject1))));
          }
          localDTLSReliableHandshake.sendMessage((short)20, TlsUtils.calculateVerifyData(paramClientHandshakeState.clientContext, "client finished", TlsProtocol.getCurrentPRFHash(paramClientHandshakeState.clientContext, localDTLSReliableHandshake.getHandshakeHash(), null)));
          if (paramClientHandshakeState.expectSessionTicket)
          {
            localObject1 = localDTLSReliableHandshake.receiveMessage();
            if (((DTLSReliableHandshake.Message)localObject1).getType() == 4) {
              processNewSessionTicket(paramClientHandshakeState, ((DTLSReliableHandshake.Message)localObject1).getBody());
            } else {
              throw new TlsFatalAlert((short)10);
            }
          }
          localObject1 = TlsUtils.calculateVerifyData(paramClientHandshakeState.clientContext, "server finished", TlsProtocol.getCurrentPRFHash(paramClientHandshakeState.clientContext, localDTLSReliableHandshake.getHandshakeHash(), null));
          processFinished(localDTLSReliableHandshake.receiveMessageBody((short)20), (byte[])localObject1);
          localDTLSReliableHandshake.finish();
          if (paramClientHandshakeState.tlsSession != null)
          {
            paramClientHandshakeState.sessionParameters = new SessionParameters.Builder().setCipherSuite(localSecurityParameters.getCipherSuite()).setCompressionAlgorithm(localSecurityParameters.getCompressionAlgorithm()).setMasterSecret(localSecurityParameters.getMasterSecret()).setPeerCertificate(localCertificate).setPSKIdentity(localSecurityParameters.getPSKIdentity()).setSRPIdentity(localSecurityParameters.getSRPIdentity()).setServerExtensions(paramClientHandshakeState.serverExtensions).build();
            paramClientHandshakeState.tlsSession = TlsUtils.importSession(paramClientHandshakeState.tlsSession.getSessionID(), paramClientHandshakeState.sessionParameters);
            paramClientHandshakeState.clientContext.setResumableSession(paramClientHandshakeState.tlsSession);
          }
          paramClientHandshakeState.client.notifyHandshakeComplete();
          return new DTLSTransport(paramDTLSRecordLayer);
        }
        throw new TlsFatalAlert((short)50);
      }
      throw new TlsFatalAlert((short)10);
    }
    throw new TlsFatalAlert((short)10);
  }
  
  /* Error */
  public DTLSTransport connect(TlsClient paramTlsClient, DatagramTransport paramDatagramTransport)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +233 -> 234
    //   4: aload_2
    //   5: ifnull +218 -> 223
    //   8: new 143	org/bouncycastle/crypto/tls/SecurityParameters
    //   11: dup
    //   12: invokespecial 461	org/bouncycastle/crypto/tls/SecurityParameters:<init>	()V
    //   15: astore_3
    //   16: aload_3
    //   17: iconst_1
    //   18: putfield 465	org/bouncycastle/crypto/tls/SecurityParameters:entity	I
    //   21: new 6	org/bouncycastle/crypto/tls/DTLSClientProtocol$ClientHandshakeState
    //   24: dup
    //   25: invokespecial 466	org/bouncycastle/crypto/tls/DTLSClientProtocol$ClientHandshakeState:<init>	()V
    //   28: astore 4
    //   30: aload 4
    //   32: aload_1
    //   33: putfield 70	org/bouncycastle/crypto/tls/DTLSClientProtocol$ClientHandshakeState:client	Lorg/bouncycastle/crypto/tls/TlsClient;
    //   36: aload 4
    //   38: new 57	org/bouncycastle/crypto/tls/TlsClientContextImpl
    //   41: dup
    //   42: aload_0
    //   43: getfield 470	org/bouncycastle/crypto/tls/DTLSClientProtocol:secureRandom	Ljava/security/SecureRandom;
    //   46: aload_3
    //   47: invokespecial 473	org/bouncycastle/crypto/tls/TlsClientContextImpl:<init>	(Ljava/security/SecureRandom;Lorg/bouncycastle/crypto/tls/SecurityParameters;)V
    //   50: putfield 55	org/bouncycastle/crypto/tls/DTLSClientProtocol$ClientHandshakeState:clientContext	Lorg/bouncycastle/crypto/tls/TlsClientContextImpl;
    //   53: aload_3
    //   54: aload_1
    //   55: invokeinterface 476 1 0
    //   60: aload 4
    //   62: getfield 55	org/bouncycastle/crypto/tls/DTLSClientProtocol$ClientHandshakeState:clientContext	Lorg/bouncycastle/crypto/tls/TlsClientContextImpl;
    //   65: invokevirtual 480	org/bouncycastle/crypto/tls/TlsClientContextImpl:getNonceRandomGenerator	()Lorg/bouncycastle/crypto/prng/RandomGenerator;
    //   68: invokestatic 484	org/bouncycastle/crypto/tls/TlsProtocol:createRandomBlock	(ZLorg/bouncycastle/crypto/prng/RandomGenerator;)[B
    //   71: putfield 487	org/bouncycastle/crypto/tls/SecurityParameters:clientRandom	[B
    //   74: aload_1
    //   75: aload 4
    //   77: getfield 55	org/bouncycastle/crypto/tls/DTLSClientProtocol$ClientHandshakeState:clientContext	Lorg/bouncycastle/crypto/tls/TlsClientContextImpl;
    //   80: invokeinterface 490 2 0
    //   85: new 41	org/bouncycastle/crypto/tls/DTLSRecordLayer
    //   88: dup
    //   89: aload_2
    //   90: aload 4
    //   92: getfield 55	org/bouncycastle/crypto/tls/DTLSClientProtocol$ClientHandshakeState:clientContext	Lorg/bouncycastle/crypto/tls/TlsClientContextImpl;
    //   95: aload_1
    //   96: bipush 22
    //   98: invokespecial 493	org/bouncycastle/crypto/tls/DTLSRecordLayer:<init>	(Lorg/bouncycastle/crypto/tls/DatagramTransport;Lorg/bouncycastle/crypto/tls/TlsContext;Lorg/bouncycastle/crypto/tls/TlsPeer;S)V
    //   101: astore_1
    //   102: aload 4
    //   104: getfield 70	org/bouncycastle/crypto/tls/DTLSClientProtocol$ClientHandshakeState:client	Lorg/bouncycastle/crypto/tls/TlsClient;
    //   107: invokeinterface 497 1 0
    //   112: astore_2
    //   113: aload_2
    //   114: ifnull +38 -> 152
    //   117: aload_2
    //   118: invokeinterface 500 1 0
    //   123: ifeq +29 -> 152
    //   126: aload_2
    //   127: invokeinterface 503 1 0
    //   132: astore 5
    //   134: aload 5
    //   136: ifnull +16 -> 152
    //   139: aload 4
    //   141: aload_2
    //   142: putfield 217	org/bouncycastle/crypto/tls/DTLSClientProtocol$ClientHandshakeState:tlsSession	Lorg/bouncycastle/crypto/tls/TlsSession;
    //   145: aload 4
    //   147: aload 5
    //   149: putfield 159	org/bouncycastle/crypto/tls/DTLSClientProtocol$ClientHandshakeState:sessionParameters	Lorg/bouncycastle/crypto/tls/SessionParameters;
    //   152: aload_0
    //   153: aload 4
    //   155: aload_1
    //   156: invokevirtual 505	org/bouncycastle/crypto/tls/DTLSClientProtocol:clientHandshake	(Lorg/bouncycastle/crypto/tls/DTLSClientProtocol$ClientHandshakeState;Lorg/bouncycastle/crypto/tls/DTLSRecordLayer;)Lorg/bouncycastle/crypto/tls/DTLSTransport;
    //   159: astore_2
    //   160: aload_3
    //   161: invokevirtual 508	org/bouncycastle/crypto/tls/SecurityParameters:clear	()V
    //   164: aload_2
    //   165: areturn
    //   166: astore_1
    //   167: goto +50 -> 217
    //   170: astore_2
    //   171: aload_0
    //   172: aload 4
    //   174: aload_1
    //   175: bipush 80
    //   177: invokevirtual 510	org/bouncycastle/crypto/tls/DTLSClientProtocol:abortClientHandshake	(Lorg/bouncycastle/crypto/tls/DTLSClientProtocol$ClientHandshakeState;Lorg/bouncycastle/crypto/tls/DTLSRecordLayer;S)V
    //   180: new 128	org/bouncycastle/crypto/tls/TlsFatalAlert
    //   183: dup
    //   184: bipush 80
    //   186: aload_2
    //   187: invokespecial 513	org/bouncycastle/crypto/tls/TlsFatalAlert:<init>	(SLjava/lang/Throwable;)V
    //   190: athrow
    //   191: astore_2
    //   192: aload_0
    //   193: aload 4
    //   195: aload_1
    //   196: bipush 80
    //   198: invokevirtual 510	org/bouncycastle/crypto/tls/DTLSClientProtocol:abortClientHandshake	(Lorg/bouncycastle/crypto/tls/DTLSClientProtocol$ClientHandshakeState;Lorg/bouncycastle/crypto/tls/DTLSRecordLayer;S)V
    //   201: aload_2
    //   202: athrow
    //   203: astore_2
    //   204: aload_0
    //   205: aload 4
    //   207: aload_1
    //   208: aload_2
    //   209: invokevirtual 516	org/bouncycastle/crypto/tls/TlsFatalAlert:getAlertDescription	()S
    //   212: invokevirtual 510	org/bouncycastle/crypto/tls/DTLSClientProtocol:abortClientHandshake	(Lorg/bouncycastle/crypto/tls/DTLSClientProtocol$ClientHandshakeState;Lorg/bouncycastle/crypto/tls/DTLSRecordLayer;S)V
    //   215: aload_2
    //   216: athrow
    //   217: aload_3
    //   218: invokevirtual 508	org/bouncycastle/crypto/tls/SecurityParameters:clear	()V
    //   221: aload_1
    //   222: athrow
    //   223: new 518	java/lang/IllegalArgumentException
    //   226: dup
    //   227: ldc_w 520
    //   230: invokespecial 523	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   233: athrow
    //   234: new 518	java/lang/IllegalArgumentException
    //   237: dup
    //   238: ldc_w 525
    //   241: invokespecial 523	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	DTLSClientProtocol
    //   0	245	1	paramTlsClient	TlsClient
    //   0	245	2	paramDatagramTransport	DatagramTransport
    //   15	203	3	localSecurityParameters	SecurityParameters
    //   28	178	4	localClientHandshakeState	ClientHandshakeState
    //   132	16	5	localSessionParameters	SessionParameters
    // Exception table:
    //   from	to	target	type
    //   152	160	166	finally
    //   171	191	166	finally
    //   192	203	166	finally
    //   204	217	166	finally
    //   152	160	170	java/lang/RuntimeException
    //   152	160	191	java/io/IOException
    //   152	160	203	org/bouncycastle/crypto/tls/TlsFatalAlert
  }
  
  protected byte[] generateCertificateVerify(ClientHandshakeState paramClientHandshakeState, DigitallySigned paramDigitallySigned)
    throws IOException
  {
    paramClientHandshakeState = new ByteArrayOutputStream();
    paramDigitallySigned.encode(paramClientHandshakeState);
    return paramClientHandshakeState.toByteArray();
  }
  
  protected byte[] generateClientHello(ClientHandshakeState paramClientHandshakeState, TlsClient paramTlsClient)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject1 = paramTlsClient.getClientVersion();
    if (((ProtocolVersion)localObject1).isDTLS())
    {
      Object localObject2 = paramClientHandshakeState.clientContext;
      ((TlsClientContextImpl)localObject2).setClientVersion((ProtocolVersion)localObject1);
      TlsUtils.writeVersion((ProtocolVersion)localObject1, localByteArrayOutputStream);
      localByteArrayOutputStream.write(((TlsClientContextImpl)localObject2).getSecurityParameters().getClientRandom());
      localObject1 = TlsUtils.EMPTY_BYTES;
      if (paramClientHandshakeState.tlsSession != null)
      {
        localObject2 = paramClientHandshakeState.tlsSession.getSessionID();
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (localObject2.length <= 32) {}
        }
        else
        {
          localObject1 = TlsUtils.EMPTY_BYTES;
        }
      }
      TlsUtils.writeOpaque8((byte[])localObject1, localByteArrayOutputStream);
      TlsUtils.writeOpaque8(TlsUtils.EMPTY_BYTES, localByteArrayOutputStream);
      boolean bool1 = paramTlsClient.isFallback();
      paramClientHandshakeState.offeredCipherSuites = paramTlsClient.getCipherSuites();
      paramClientHandshakeState.clientExtensions = paramTlsClient.getClientExtensions();
      int i;
      if (TlsUtils.getExtensionData(paramClientHandshakeState.clientExtensions, TlsProtocol.EXT_RenegotiationInfo) == null) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool2 = Arrays.contains(paramClientHandshakeState.offeredCipherSuites, 255);
      if ((i != 0) && ((bool2 ^ true))) {
        paramClientHandshakeState.offeredCipherSuites = Arrays.append(paramClientHandshakeState.offeredCipherSuites, 255);
      }
      if ((bool1) && (!Arrays.contains(paramClientHandshakeState.offeredCipherSuites, 22016))) {
        paramClientHandshakeState.offeredCipherSuites = Arrays.append(paramClientHandshakeState.offeredCipherSuites, 22016);
      }
      TlsUtils.writeUint16ArrayWithUint16Length(paramClientHandshakeState.offeredCipherSuites, localByteArrayOutputStream);
      paramClientHandshakeState.offeredCompressionMethods = new short[] { 0 };
      TlsUtils.writeUint8ArrayWithUint8Length(paramClientHandshakeState.offeredCompressionMethods, localByteArrayOutputStream);
      if (paramClientHandshakeState.clientExtensions != null) {
        TlsProtocol.writeExtensions(localByteArrayOutputStream, paramClientHandshakeState.clientExtensions);
      }
      return localByteArrayOutputStream.toByteArray();
    }
    throw new TlsFatalAlert((short)80);
  }
  
  protected byte[] generateClientKeyExchange(ClientHandshakeState paramClientHandshakeState)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramClientHandshakeState.keyExchange.generateClientKeyExchange(localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  protected void invalidateSession(ClientHandshakeState paramClientHandshakeState)
  {
    if (paramClientHandshakeState.sessionParameters != null)
    {
      paramClientHandshakeState.sessionParameters.clear();
      paramClientHandshakeState.sessionParameters = null;
    }
    if (paramClientHandshakeState.tlsSession != null)
    {
      paramClientHandshakeState.tlsSession.invalidate();
      paramClientHandshakeState.tlsSession = null;
    }
  }
  
  protected void processCertificateRequest(ClientHandshakeState paramClientHandshakeState, byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramClientHandshakeState.authentication != null)
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      paramClientHandshakeState.certificateRequest = CertificateRequest.parse(paramClientHandshakeState.clientContext, paramArrayOfByte);
      TlsProtocol.assertEmpty(paramArrayOfByte);
      paramClientHandshakeState.keyExchange.validateCertificateRequest(paramClientHandshakeState.certificateRequest);
      return;
    }
    throw new TlsFatalAlert((short)40);
  }
  
  protected void processCertificateStatus(ClientHandshakeState paramClientHandshakeState, byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramClientHandshakeState.allowCertificateStatus)
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      paramClientHandshakeState.certificateStatus = CertificateStatus.parse(paramArrayOfByte);
      TlsProtocol.assertEmpty(paramArrayOfByte);
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
  
  protected byte[] processHelloVerifyRequest(ClientHandshakeState paramClientHandshakeState, byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    ProtocolVersion localProtocolVersion = TlsUtils.readVersion(paramArrayOfByte);
    byte[] arrayOfByte = TlsUtils.readOpaque8(paramArrayOfByte);
    TlsProtocol.assertEmpty(paramArrayOfByte);
    if (localProtocolVersion.isEqualOrEarlierVersionOf(paramClientHandshakeState.clientContext.getClientVersion()))
    {
      if (!ProtocolVersion.DTLSv12.isEqualOrEarlierVersionOf(localProtocolVersion))
      {
        if (arrayOfByte.length <= 32) {
          return arrayOfByte;
        }
        throw new TlsFatalAlert((short)47);
      }
      return arrayOfByte;
    }
    throw new TlsFatalAlert((short)47);
  }
  
  protected void processNewSessionTicket(ClientHandshakeState paramClientHandshakeState, byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    NewSessionTicket localNewSessionTicket = NewSessionTicket.parse(paramArrayOfByte);
    TlsProtocol.assertEmpty(paramArrayOfByte);
    paramClientHandshakeState.client.notifyNewSessionTicket(localNewSessionTicket);
  }
  
  protected Certificate processServerCertificate(ClientHandshakeState paramClientHandshakeState, byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    Certificate localCertificate = Certificate.parse(paramArrayOfByte);
    TlsProtocol.assertEmpty(paramArrayOfByte);
    paramClientHandshakeState.keyExchange.processServerCertificate(localCertificate);
    paramClientHandshakeState.authentication = paramClientHandshakeState.client.getAuthentication();
    paramClientHandshakeState.authentication.notifyServerCertificate(localCertificate);
    return localCertificate;
  }
  
  protected void processServerHello(ClientHandshakeState paramClientHandshakeState, byte[] paramArrayOfByte)
    throws IOException
  {
    SecurityParameters localSecurityParameters = paramClientHandshakeState.clientContext.getSecurityParameters();
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    reportServerVersion(paramClientHandshakeState, TlsUtils.readVersion(paramArrayOfByte));
    localSecurityParameters.serverRandom = TlsUtils.readFully(32, paramArrayOfByte);
    paramClientHandshakeState.selectedSessionID = TlsUtils.readOpaque8(paramArrayOfByte);
    if (paramClientHandshakeState.selectedSessionID.length <= 32)
    {
      paramClientHandshakeState.client.notifySessionID(paramClientHandshakeState.selectedSessionID);
      int i = paramClientHandshakeState.selectedSessionID.length;
      boolean bool2 = false;
      boolean bool1;
      if ((i > 0) && (paramClientHandshakeState.tlsSession != null) && (Arrays.areEqual(paramClientHandshakeState.selectedSessionID, paramClientHandshakeState.tlsSession.getSessionID()))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramClientHandshakeState.resumedSession = bool1;
      i = TlsUtils.readUint16(paramArrayOfByte);
      if ((Arrays.contains(paramClientHandshakeState.offeredCipherSuites, i)) && (i != 0) && (!CipherSuite.isSCSV(i)) && (TlsUtils.isValidCipherSuiteForVersion(i, paramClientHandshakeState.clientContext.getServerVersion())))
      {
        validateSelectedCipherSuite(i, (short)47);
        paramClientHandshakeState.client.notifySelectedCipherSuite(i);
        short s = TlsUtils.readUint8(paramArrayOfByte);
        if (Arrays.contains(paramClientHandshakeState.offeredCompressionMethods, s))
        {
          paramClientHandshakeState.client.notifySelectedCompressionMethod(s);
          paramClientHandshakeState.serverExtensions = TlsProtocol.readExtensions(paramArrayOfByte);
          if (paramClientHandshakeState.serverExtensions != null)
          {
            paramArrayOfByte = paramClientHandshakeState.serverExtensions.keys();
            while (paramArrayOfByte.hasMoreElements())
            {
              localObject = (Integer)paramArrayOfByte.nextElement();
              if (!((Integer)localObject).equals(TlsProtocol.EXT_RenegotiationInfo)) {
                if (TlsUtils.getExtensionData(paramClientHandshakeState.clientExtensions, (Integer)localObject) != null) {
                  bool1 = paramClientHandshakeState.resumedSession;
                } else {
                  throw new TlsFatalAlert((short)110);
                }
              }
            }
          }
          paramArrayOfByte = TlsUtils.getExtensionData(paramClientHandshakeState.serverExtensions, TlsProtocol.EXT_RenegotiationInfo);
          if (paramArrayOfByte != null)
          {
            paramClientHandshakeState.secure_renegotiation = true;
            if (!Arrays.constantTimeAreEqual(paramArrayOfByte, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
              throw new TlsFatalAlert((short)40);
            }
          }
          paramClientHandshakeState.client.notifySecureRenegotiation(paramClientHandshakeState.secure_renegotiation);
          paramArrayOfByte = paramClientHandshakeState.clientExtensions;
          Object localObject = paramClientHandshakeState.serverExtensions;
          if (paramClientHandshakeState.resumedSession) {
            if ((i == paramClientHandshakeState.sessionParameters.getCipherSuite()) && (s == paramClientHandshakeState.sessionParameters.getCompressionAlgorithm()))
            {
              paramArrayOfByte = null;
              localObject = paramClientHandshakeState.sessionParameters.readServerExtensions();
            }
            else
            {
              throw new TlsFatalAlert((short)47);
            }
          }
          localSecurityParameters.cipherSuite = i;
          localSecurityParameters.compressionAlgorithm = s;
          if (localObject != null)
          {
            bool1 = TlsExtensionsUtils.hasEncryptThenMACExtension((Hashtable)localObject);
            if ((bool1) && (!TlsUtils.isBlockCipherSuite(localSecurityParameters.getCipherSuite()))) {
              throw new TlsFatalAlert((short)47);
            }
            localSecurityParameters.encryptThenMAC = bool1;
            localSecurityParameters.extendedMasterSecret = TlsExtensionsUtils.hasExtendedMasterSecretExtension((Hashtable)localObject);
            localSecurityParameters.maxFragmentLength = evaluateMaxFragmentLengthExtension(paramClientHandshakeState.resumedSession, paramArrayOfByte, (Hashtable)localObject, (short)47);
            localSecurityParameters.truncatedHMac = TlsExtensionsUtils.hasTruncatedHMacExtension((Hashtable)localObject);
            if ((!paramClientHandshakeState.resumedSession) && (TlsUtils.hasExpectedEmptyExtensionData((Hashtable)localObject, TlsExtensionsUtils.EXT_status_request, (short)47))) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            paramClientHandshakeState.allowCertificateStatus = bool1;
            bool1 = bool2;
            if (!paramClientHandshakeState.resumedSession)
            {
              bool1 = bool2;
              if (TlsUtils.hasExpectedEmptyExtensionData((Hashtable)localObject, TlsProtocol.EXT_SessionTicket, (short)47)) {
                bool1 = true;
              }
            }
            paramClientHandshakeState.expectSessionTicket = bool1;
          }
          if (paramArrayOfByte != null) {
            paramClientHandshakeState.client.processServerExtensions((Hashtable)localObject);
          }
          localSecurityParameters.prfAlgorithm = TlsProtocol.getPRFAlgorithm(paramClientHandshakeState.clientContext, localSecurityParameters.getCipherSuite());
          localSecurityParameters.verifyDataLength = 12;
          return;
        }
        throw new TlsFatalAlert((short)47);
      }
      throw new TlsFatalAlert((short)47);
    }
    throw new TlsFatalAlert((short)47);
  }
  
  protected void processServerKeyExchange(ClientHandshakeState paramClientHandshakeState, byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    paramClientHandshakeState.keyExchange.processServerKeyExchange(paramArrayOfByte);
    TlsProtocol.assertEmpty(paramArrayOfByte);
  }
  
  protected void processServerSupplementalData(ClientHandshakeState paramClientHandshakeState, byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = TlsProtocol.readSupplementalDataMessage(new ByteArrayInputStream(paramArrayOfByte));
    paramClientHandshakeState.client.processServerSupplementalData(paramArrayOfByte);
  }
  
  protected void reportServerVersion(ClientHandshakeState paramClientHandshakeState, ProtocolVersion paramProtocolVersion)
    throws IOException
  {
    TlsClientContextImpl localTlsClientContextImpl = paramClientHandshakeState.clientContext;
    ProtocolVersion localProtocolVersion = localTlsClientContextImpl.getServerVersion();
    if (localProtocolVersion == null)
    {
      localTlsClientContextImpl.setServerVersion(paramProtocolVersion);
      paramClientHandshakeState.client.notifyServerVersion(paramProtocolVersion);
      return;
    }
    if (localProtocolVersion.equals(paramProtocolVersion)) {
      return;
    }
    throw new TlsFatalAlert((short)47);
  }
  
  protected static class ClientHandshakeState
  {
    boolean allowCertificateStatus = false;
    TlsAuthentication authentication = null;
    CertificateRequest certificateRequest = null;
    CertificateStatus certificateStatus = null;
    TlsClient client = null;
    TlsClientContextImpl clientContext = null;
    TlsCredentials clientCredentials = null;
    Hashtable clientExtensions = null;
    boolean expectSessionTicket = false;
    TlsKeyExchange keyExchange = null;
    int[] offeredCipherSuites = null;
    short[] offeredCompressionMethods = null;
    boolean resumedSession = false;
    boolean secure_renegotiation = false;
    byte[] selectedSessionID = null;
    Hashtable serverExtensions = null;
    SessionParameters sessionParameters = null;
    SessionParameters.Builder sessionParametersBuilder = null;
    TlsSession tlsSession = null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DTLSClientProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */