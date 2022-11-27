package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.util.Arrays;

public class TlsClientProtocol
  extends TlsProtocol
{
  protected TlsAuthentication authentication = null;
  protected CertificateRequest certificateRequest = null;
  protected CertificateStatus certificateStatus = null;
  protected TlsKeyExchange keyExchange = null;
  protected byte[] selectedSessionID = null;
  protected TlsClient tlsClient = null;
  TlsClientContextImpl tlsClientContext = null;
  
  public TlsClientProtocol(InputStream paramInputStream, OutputStream paramOutputStream, SecureRandom paramSecureRandom)
  {
    super(paramInputStream, paramOutputStream, paramSecureRandom);
  }
  
  public TlsClientProtocol(SecureRandom paramSecureRandom)
  {
    super(paramSecureRandom);
  }
  
  protected void cleanupHandshake()
  {
    super.cleanupHandshake();
    this.selectedSessionID = null;
    this.keyExchange = null;
    this.authentication = null;
    this.certificateStatus = null;
    this.certificateRequest = null;
  }
  
  public void connect(TlsClient paramTlsClient)
    throws IOException
  {
    if (paramTlsClient != null)
    {
      if (this.tlsClient == null)
      {
        this.tlsClient = paramTlsClient;
        this.securityParameters = new SecurityParameters();
        this.securityParameters.entity = 1;
        this.tlsClientContext = new TlsClientContextImpl(this.secureRandom, this.securityParameters);
        this.securityParameters.clientRandom = createRandomBlock(paramTlsClient.shouldUseGMTUnixTime(), this.tlsClientContext.getNonceRandomGenerator());
        this.tlsClient.init(this.tlsClientContext);
        this.recordStream.init(this.tlsClientContext);
        paramTlsClient = paramTlsClient.getSessionToResume();
        if ((paramTlsClient != null) && (paramTlsClient.isResumable()))
        {
          SessionParameters localSessionParameters = paramTlsClient.exportSessionParameters();
          if (localSessionParameters != null)
          {
            this.tlsSession = paramTlsClient;
            this.sessionParameters = localSessionParameters;
          }
        }
        sendClientHelloMessage();
        this.connection_state = 1;
        blockForHandshake();
        return;
      }
      throw new IllegalStateException("'connect' can only be called once");
    }
    throw new IllegalArgumentException("'tlsClient' cannot be null");
  }
  
  protected TlsContext getContext()
  {
    return this.tlsClientContext;
  }
  
  AbstractTlsContext getContextAdmin()
  {
    return this.tlsClientContext;
  }
  
  protected TlsPeer getPeer()
  {
    return this.tlsClient;
  }
  
  protected void handleHandshakeMessage(short paramShort, ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    if (this.resumedSession)
    {
      if ((paramShort == 20) && (this.connection_state == 2))
      {
        processFinishedMessage(paramByteArrayInputStream);
        this.connection_state = 15;
        sendFinishedMessage();
        this.connection_state = 13;
        completeHandshake();
        return;
      }
      throw new TlsFatalAlert((short)10);
    }
    if (paramShort != 0)
    {
      if (paramShort != 2)
      {
        if (paramShort != 4)
        {
          if (paramShort != 20)
          {
            if (paramShort != 22)
            {
              if (paramShort != 23)
              {
                switch (paramShort)
                {
                default: 
                  throw new TlsFatalAlert((short)10);
                case 14: 
                  switch (this.connection_state)
                  {
                  default: 
                    throw new TlsFatalAlert((short)10);
                  case 2: 
                    handleSupplementalData(null);
                  case 3: 
                    this.keyExchange.skipServerCredentials();
                    this.authentication = null;
                  case 4: 
                  case 5: 
                    this.keyExchange.skipServerKeyExchange();
                  }
                  assertEmpty(paramByteArrayInputStream);
                  this.connection_state = 8;
                  this.recordStream.getHandshakeHash().sealHashAlgorithms();
                  paramByteArrayInputStream = this.tlsClient.getClientSupplementalData();
                  if (paramByteArrayInputStream != null) {
                    sendSupplementalDataMessage(paramByteArrayInputStream);
                  }
                  this.connection_state = 9;
                  paramByteArrayInputStream = this.certificateRequest;
                  Object localObject;
                  if (paramByteArrayInputStream == null)
                  {
                    this.keyExchange.skipClientCredentials();
                    paramByteArrayInputStream = null;
                  }
                  else
                  {
                    localObject = this.authentication.getClientCredentials(paramByteArrayInputStream);
                    paramByteArrayInputStream = this.keyExchange;
                    if (localObject == null)
                    {
                      paramByteArrayInputStream.skipClientCredentials();
                      paramByteArrayInputStream = Certificate.EMPTY_CHAIN;
                    }
                    else
                    {
                      paramByteArrayInputStream.processClientCredentials((TlsCredentials)localObject);
                      paramByteArrayInputStream = ((TlsCredentials)localObject).getCertificate();
                    }
                    sendCertificateMessage(paramByteArrayInputStream);
                    paramByteArrayInputStream = (ByteArrayInputStream)localObject;
                  }
                  this.connection_state = 10;
                  sendClientKeyExchangeMessage();
                  this.connection_state = 11;
                  if (TlsUtils.isSSL(getContext())) {
                    establishMasterSecret(getContext(), this.keyExchange);
                  }
                  TlsHandshakeHash localTlsHandshakeHash = this.recordStream.prepareToFinish();
                  this.securityParameters.sessionHash = getCurrentPRFHash(getContext(), localTlsHandshakeHash, null);
                  if (!TlsUtils.isSSL(getContext())) {
                    establishMasterSecret(getContext(), this.keyExchange);
                  }
                  this.recordStream.setPendingConnectionState(getPeer().getCompression(), getPeer().getCipher());
                  if ((paramByteArrayInputStream != null) && ((paramByteArrayInputStream instanceof TlsSignerCredentials)))
                  {
                    localObject = (TlsSignerCredentials)paramByteArrayInputStream;
                    SignatureAndHashAlgorithm localSignatureAndHashAlgorithm = TlsUtils.getSignatureAndHashAlgorithm(getContext(), (TlsSignerCredentials)localObject);
                    if (localSignatureAndHashAlgorithm == null) {
                      paramByteArrayInputStream = this.securityParameters.getSessionHash();
                    } else {
                      paramByteArrayInputStream = localTlsHandshakeHash.getFinalHash(localSignatureAndHashAlgorithm.getHash());
                    }
                    sendCertificateVerifyMessage(new DigitallySigned(localSignatureAndHashAlgorithm, ((TlsSignerCredentials)localObject).generateCertificateSignature(paramByteArrayInputStream)));
                    this.connection_state = 12;
                  }
                  sendChangeCipherSpecMessage();
                  sendFinishedMessage();
                  this.connection_state = 13;
                  return;
                case 13: 
                  paramShort = this.connection_state;
                  if ((paramShort != 4) && (paramShort != 5))
                  {
                    if (paramShort != 6) {
                      throw new TlsFatalAlert((short)10);
                    }
                  }
                  else {
                    this.keyExchange.skipServerKeyExchange();
                  }
                  if (this.authentication != null)
                  {
                    this.certificateRequest = CertificateRequest.parse(getContext(), paramByteArrayInputStream);
                    assertEmpty(paramByteArrayInputStream);
                    this.keyExchange.validateCertificateRequest(this.certificateRequest);
                    TlsUtils.trackHashAlgorithms(this.recordStream.getHandshakeHash(), this.certificateRequest.getSupportedSignatureAlgorithms());
                    this.connection_state = 7;
                    return;
                  }
                  throw new TlsFatalAlert((short)40);
                case 12: 
                  paramShort = this.connection_state;
                  if (paramShort != 2)
                  {
                    if (paramShort != 3)
                    {
                      if ((paramShort == 4) || (paramShort == 5)) {
                        break label709;
                      }
                      throw new TlsFatalAlert((short)10);
                    }
                  }
                  else {
                    handleSupplementalData(null);
                  }
                  this.keyExchange.skipServerCredentials();
                  this.authentication = null;
                  label709:
                  this.keyExchange.processServerKeyExchange(paramByteArrayInputStream);
                  assertEmpty(paramByteArrayInputStream);
                  this.connection_state = 6;
                  return;
                }
                paramShort = this.connection_state;
                if (paramShort != 2)
                {
                  if (paramShort != 3) {
                    throw new TlsFatalAlert((short)10);
                  }
                }
                else {
                  handleSupplementalData(null);
                }
                this.peerCertificate = Certificate.parse(paramByteArrayInputStream);
                assertEmpty(paramByteArrayInputStream);
                if ((this.peerCertificate == null) || (this.peerCertificate.isEmpty())) {
                  this.allowCertificateStatus = false;
                }
                this.keyExchange.processServerCertificate(this.peerCertificate);
                paramByteArrayInputStream = this.tlsClient.getAuthentication();
                this.authentication = paramByteArrayInputStream;
                paramByteArrayInputStream.notifyServerCertificate(this.peerCertificate);
                this.connection_state = 4;
                return;
              }
              if (this.connection_state == 2)
              {
                handleSupplementalData(readSupplementalDataMessage(paramByteArrayInputStream));
                return;
              }
              throw new TlsFatalAlert((short)10);
            }
            if (this.connection_state == 4)
            {
              if (this.allowCertificateStatus)
              {
                this.certificateStatus = CertificateStatus.parse(paramByteArrayInputStream);
                assertEmpty(paramByteArrayInputStream);
                this.connection_state = 5;
                return;
              }
              throw new TlsFatalAlert((short)10);
            }
            throw new TlsFatalAlert((short)10);
          }
          paramShort = this.connection_state;
          if (paramShort != 13)
          {
            if (paramShort != 14) {
              throw new TlsFatalAlert((short)10);
            }
          }
          else {
            if (this.expectSessionTicket) {
              break label974;
            }
          }
          processFinishedMessage(paramByteArrayInputStream);
          this.connection_state = 15;
          completeHandshake();
          return;
          label974:
          throw new TlsFatalAlert((short)10);
        }
        if (this.connection_state == 13)
        {
          if (this.expectSessionTicket)
          {
            invalidateSession();
            receiveNewSessionTicketMessage(paramByteArrayInputStream);
            this.connection_state = 14;
            return;
          }
          throw new TlsFatalAlert((short)10);
        }
        throw new TlsFatalAlert((short)10);
      }
      if (this.connection_state == 1)
      {
        receiveServerHelloMessage(paramByteArrayInputStream);
        this.connection_state = 2;
        this.recordStream.notifyHelloComplete();
        applyMaxFragmentLengthExtension();
        if (this.resumedSession)
        {
          this.securityParameters.masterSecret = Arrays.clone(this.sessionParameters.getMasterSecret());
          this.recordStream.setPendingConnectionState(getPeer().getCompression(), getPeer().getCipher());
          sendChangeCipherSpecMessage();
          return;
        }
        invalidateSession();
        paramByteArrayInputStream = this.selectedSessionID;
        if (paramByteArrayInputStream.length > 0) {
          this.tlsSession = new TlsSessionImpl(paramByteArrayInputStream, null);
        }
      }
      else
      {
        throw new TlsFatalAlert((short)10);
      }
    }
    else
    {
      assertEmpty(paramByteArrayInputStream);
      if (this.connection_state == 16) {
        refuseRenegotiation();
      }
    }
  }
  
  protected void handleSupplementalData(Vector paramVector)
    throws IOException
  {
    this.tlsClient.processServerSupplementalData(paramVector);
    this.connection_state = 3;
    paramVector = this.tlsClient.getKeyExchange();
    this.keyExchange = paramVector;
    paramVector.init(getContext());
  }
  
  protected void receiveNewSessionTicketMessage(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    NewSessionTicket localNewSessionTicket = NewSessionTicket.parse(paramByteArrayInputStream);
    assertEmpty(paramByteArrayInputStream);
    this.tlsClient.notifyNewSessionTicket(localNewSessionTicket);
  }
  
  protected void receiveServerHelloMessage(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    Object localObject = TlsUtils.readVersion(paramByteArrayInputStream);
    if (!((ProtocolVersion)localObject).isDTLS())
    {
      if (((ProtocolVersion)localObject).equals(this.recordStream.getReadVersion()))
      {
        if (((ProtocolVersion)localObject).isEqualOrEarlierVersionOf(getContext().getClientVersion()))
        {
          this.recordStream.setWriteVersion((ProtocolVersion)localObject);
          getContextAdmin().setServerVersion((ProtocolVersion)localObject);
          this.tlsClient.notifyServerVersion((ProtocolVersion)localObject);
          this.securityParameters.serverRandom = TlsUtils.readFully(32, paramByteArrayInputStream);
          localObject = TlsUtils.readOpaque8(paramByteArrayInputStream);
          this.selectedSessionID = ((byte[])localObject);
          if (localObject.length <= 32)
          {
            this.tlsClient.notifySessionID((byte[])localObject);
            int i = this.selectedSessionID.length;
            boolean bool2 = false;
            boolean bool1;
            if ((i > 0) && (this.tlsSession != null) && (Arrays.areEqual(this.selectedSessionID, this.tlsSession.getSessionID()))) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            this.resumedSession = bool1;
            i = TlsUtils.readUint16(paramByteArrayInputStream);
            if ((Arrays.contains(this.offeredCipherSuites, i)) && (i != 0) && (!CipherSuite.isSCSV(i)) && (TlsUtils.isValidCipherSuiteForVersion(i, getContext().getServerVersion())))
            {
              this.tlsClient.notifySelectedCipherSuite(i);
              short s = TlsUtils.readUint8(paramByteArrayInputStream);
              if (Arrays.contains(this.offeredCompressionMethods, s))
              {
                this.tlsClient.notifySelectedCompressionMethod(s);
                this.serverExtensions = readExtensions(paramByteArrayInputStream);
                if (this.serverExtensions != null)
                {
                  paramByteArrayInputStream = this.serverExtensions.keys();
                  while (paramByteArrayInputStream.hasMoreElements())
                  {
                    localObject = (Integer)paramByteArrayInputStream.nextElement();
                    if (!((Integer)localObject).equals(EXT_RenegotiationInfo)) {
                      if (TlsUtils.getExtensionData(this.clientExtensions, (Integer)localObject) != null) {
                        bool1 = this.resumedSession;
                      } else {
                        throw new TlsFatalAlert((short)110);
                      }
                    }
                  }
                }
                paramByteArrayInputStream = TlsUtils.getExtensionData(this.serverExtensions, EXT_RenegotiationInfo);
                if (paramByteArrayInputStream != null)
                {
                  this.secure_renegotiation = true;
                  if (!Arrays.constantTimeAreEqual(paramByteArrayInputStream, createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                    throw new TlsFatalAlert((short)40);
                  }
                }
                this.tlsClient.notifySecureRenegotiation(this.secure_renegotiation);
                localObject = this.clientExtensions;
                paramByteArrayInputStream = this.serverExtensions;
                if (this.resumedSession) {
                  if ((i == this.sessionParameters.getCipherSuite()) && (s == this.sessionParameters.getCompressionAlgorithm()))
                  {
                    localObject = null;
                    paramByteArrayInputStream = this.sessionParameters.readServerExtensions();
                  }
                  else
                  {
                    throw new TlsFatalAlert((short)47);
                  }
                }
                this.securityParameters.cipherSuite = i;
                this.securityParameters.compressionAlgorithm = s;
                if (paramByteArrayInputStream != null)
                {
                  bool1 = TlsExtensionsUtils.hasEncryptThenMACExtension(paramByteArrayInputStream);
                  if ((bool1) && (!TlsUtils.isBlockCipherSuite(i))) {
                    throw new TlsFatalAlert((short)47);
                  }
                  this.securityParameters.encryptThenMAC = bool1;
                  this.securityParameters.extendedMasterSecret = TlsExtensionsUtils.hasExtendedMasterSecretExtension(paramByteArrayInputStream);
                  this.securityParameters.maxFragmentLength = processMaxFragmentLengthExtension((Hashtable)localObject, paramByteArrayInputStream, (short)47);
                  this.securityParameters.truncatedHMac = TlsExtensionsUtils.hasTruncatedHMacExtension(paramByteArrayInputStream);
                  if ((!this.resumedSession) && (TlsUtils.hasExpectedEmptyExtensionData(paramByteArrayInputStream, TlsExtensionsUtils.EXT_status_request, (short)47))) {
                    bool1 = true;
                  } else {
                    bool1 = false;
                  }
                  this.allowCertificateStatus = bool1;
                  bool1 = bool2;
                  if (!this.resumedSession)
                  {
                    bool1 = bool2;
                    if (TlsUtils.hasExpectedEmptyExtensionData(paramByteArrayInputStream, TlsProtocol.EXT_SessionTicket, (short)47)) {
                      bool1 = true;
                    }
                  }
                  this.expectSessionTicket = bool1;
                }
                if (localObject != null) {
                  this.tlsClient.processServerExtensions(paramByteArrayInputStream);
                }
                this.securityParameters.prfAlgorithm = getPRFAlgorithm(getContext(), this.securityParameters.getCipherSuite());
                this.securityParameters.verifyDataLength = 12;
                return;
              }
              throw new TlsFatalAlert((short)47);
            }
            throw new TlsFatalAlert((short)47);
          }
          throw new TlsFatalAlert((short)47);
        }
        throw new TlsFatalAlert((short)47);
      }
      throw new TlsFatalAlert((short)47);
    }
    throw new TlsFatalAlert((short)47);
  }
  
  protected void sendCertificateVerifyMessage(DigitallySigned paramDigitallySigned)
    throws IOException
  {
    TlsProtocol.HandshakeMessage localHandshakeMessage = new TlsProtocol.HandshakeMessage(this, (short)15);
    paramDigitallySigned.encode(localHandshakeMessage);
    localHandshakeMessage.writeToRecordStream();
  }
  
  protected void sendClientHelloMessage()
    throws IOException
  {
    this.recordStream.setWriteVersion(this.tlsClient.getClientHelloRecordLayerVersion());
    ProtocolVersion localProtocolVersion = this.tlsClient.getClientVersion();
    if (!localProtocolVersion.isDTLS())
    {
      getContextAdmin().setClientVersion(localProtocolVersion);
      Object localObject1 = TlsUtils.EMPTY_BYTES;
      if (this.tlsSession != null)
      {
        localObject2 = this.tlsSession.getSessionID();
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
      boolean bool1 = this.tlsClient.isFallback();
      this.offeredCipherSuites = this.tlsClient.getCipherSuites();
      this.offeredCompressionMethods = this.tlsClient.getCompressionMethods();
      Object localObject2 = localObject1;
      if (localObject1.length > 0)
      {
        localObject2 = localObject1;
        if (this.sessionParameters != null) {
          if (Arrays.contains(this.offeredCipherSuites, this.sessionParameters.getCipherSuite()))
          {
            localObject2 = localObject1;
            if (Arrays.contains(this.offeredCompressionMethods, this.sessionParameters.getCompressionAlgorithm())) {}
          }
          else
          {
            localObject2 = TlsUtils.EMPTY_BYTES;
          }
        }
      }
      this.clientExtensions = this.tlsClient.getClientExtensions();
      localObject1 = new TlsProtocol.HandshakeMessage(this, (short)1);
      TlsUtils.writeVersion(localProtocolVersion, (OutputStream)localObject1);
      ((TlsProtocol.HandshakeMessage)localObject1).write(this.securityParameters.getClientRandom());
      TlsUtils.writeOpaque8((byte[])localObject2, (OutputStream)localObject1);
      int i;
      if (TlsUtils.getExtensionData(this.clientExtensions, EXT_RenegotiationInfo) == null) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool2 = Arrays.contains(this.offeredCipherSuites, 255);
      if ((i != 0) && ((bool2 ^ true))) {
        this.offeredCipherSuites = Arrays.append(this.offeredCipherSuites, 255);
      }
      if ((bool1) && (!Arrays.contains(this.offeredCipherSuites, 22016))) {
        this.offeredCipherSuites = Arrays.append(this.offeredCipherSuites, 22016);
      }
      TlsUtils.writeUint16ArrayWithUint16Length(this.offeredCipherSuites, (OutputStream)localObject1);
      TlsUtils.writeUint8ArrayWithUint8Length(this.offeredCompressionMethods, (OutputStream)localObject1);
      if (this.clientExtensions != null) {
        writeExtensions((OutputStream)localObject1, this.clientExtensions);
      }
      ((TlsProtocol.HandshakeMessage)localObject1).writeToRecordStream();
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  protected void sendClientKeyExchangeMessage()
    throws IOException
  {
    TlsProtocol.HandshakeMessage localHandshakeMessage = new TlsProtocol.HandshakeMessage(this, (short)16);
    this.keyExchange.generateClientKeyExchange(localHandshakeMessage);
    localHandshakeMessage.writeToRecordStream();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsClientProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */