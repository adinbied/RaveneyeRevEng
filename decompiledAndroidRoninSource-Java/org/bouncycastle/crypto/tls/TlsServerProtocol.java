package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Hashtable;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.Arrays;

public class TlsServerProtocol
  extends TlsProtocol
{
  protected CertificateRequest certificateRequest = null;
  protected short clientCertificateType = -1;
  protected TlsKeyExchange keyExchange = null;
  protected TlsHandshakeHash prepareFinishHash = null;
  protected TlsCredentials serverCredentials = null;
  protected TlsServer tlsServer = null;
  TlsServerContextImpl tlsServerContext = null;
  
  public TlsServerProtocol(InputStream paramInputStream, OutputStream paramOutputStream, SecureRandom paramSecureRandom)
  {
    super(paramInputStream, paramOutputStream, paramSecureRandom);
  }
  
  public TlsServerProtocol(SecureRandom paramSecureRandom)
  {
    super(paramSecureRandom);
  }
  
  public void accept(TlsServer paramTlsServer)
    throws IOException
  {
    if (paramTlsServer != null)
    {
      if (this.tlsServer == null)
      {
        this.tlsServer = paramTlsServer;
        this.securityParameters = new SecurityParameters();
        this.securityParameters.entity = 0;
        this.tlsServerContext = new TlsServerContextImpl(this.secureRandom, this.securityParameters);
        this.securityParameters.serverRandom = createRandomBlock(paramTlsServer.shouldUseGMTUnixTime(), this.tlsServerContext.getNonceRandomGenerator());
        this.tlsServer.init(this.tlsServerContext);
        this.recordStream.init(this.tlsServerContext);
        this.recordStream.setRestrictReadVersion(false);
        blockForHandshake();
        return;
      }
      throw new IllegalStateException("'accept' can only be called once");
    }
    throw new IllegalArgumentException("'tlsServer' cannot be null");
  }
  
  protected void cleanupHandshake()
  {
    super.cleanupHandshake();
    this.keyExchange = null;
    this.serverCredentials = null;
    this.certificateRequest = null;
    this.prepareFinishHash = null;
  }
  
  protected boolean expectCertificateVerifyMessage()
  {
    short s = this.clientCertificateType;
    return (s >= 0) && (TlsUtils.hasSigningCapability(s));
  }
  
  protected TlsContext getContext()
  {
    return this.tlsServerContext;
  }
  
  AbstractTlsContext getContextAdmin()
  {
    return this.tlsServerContext;
  }
  
  protected TlsPeer getPeer()
  {
    return this.tlsServer;
  }
  
  protected void handleHandshakeMessage(short paramShort, ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    Object localObject = null;
    boolean bool1 = true;
    if (paramShort != 1)
    {
      if (paramShort != 11)
      {
        if (paramShort != 20)
        {
          if (paramShort != 23)
          {
            if (paramShort != 15)
            {
              if (paramShort == 16)
              {
                switch (this.connection_state)
                {
                default: 
                  throw new TlsFatalAlert((short)10);
                case 8: 
                  this.tlsServer.processClientSupplementalData(null);
                case 9: 
                  if (this.certificateRequest == null)
                  {
                    this.keyExchange.skipClientCredentials();
                  }
                  else
                  {
                    if (TlsUtils.isTLSv12(getContext())) {
                      break label170;
                    }
                    if (TlsUtils.isSSL(getContext()))
                    {
                      if (this.peerCertificate == null) {
                        throw new TlsFatalAlert((short)10);
                      }
                    }
                    else {
                      notifyClientCertificate(Certificate.EMPTY_CHAIN);
                    }
                  }
                  break;
                }
                receiveClientKeyExchangeMessage(paramByteArrayInputStream);
                this.connection_state = 11;
                return;
                label170:
                throw new TlsFatalAlert((short)10);
              }
              throw new TlsFatalAlert((short)10);
            }
            if (this.connection_state == 11)
            {
              if (expectCertificateVerifyMessage())
              {
                receiveCertificateVerifyMessage(paramByteArrayInputStream);
                this.connection_state = 12;
                return;
              }
              throw new TlsFatalAlert((short)10);
            }
            throw new TlsFatalAlert((short)10);
          }
          if (this.connection_state == 8)
          {
            this.tlsServer.processClientSupplementalData(readSupplementalDataMessage(paramByteArrayInputStream));
            this.connection_state = 9;
            return;
          }
          throw new TlsFatalAlert((short)10);
        }
        paramShort = this.connection_state;
        if (paramShort != 11)
        {
          if (paramShort != 12) {
            throw new TlsFatalAlert((short)10);
          }
        }
        else {
          if (expectCertificateVerifyMessage()) {
            break label370;
          }
        }
        processFinishedMessage(paramByteArrayInputStream);
        this.connection_state = 13;
        if (this.expectSessionTicket)
        {
          sendNewSessionTicketMessage(this.tlsServer.getNewSessionTicket());
          sendChangeCipherSpecMessage();
        }
        this.connection_state = 14;
        sendFinishedMessage();
        this.connection_state = 15;
        completeHandshake();
        return;
        label370:
        throw new TlsFatalAlert((short)10);
      }
      paramShort = this.connection_state;
      if (paramShort != 8)
      {
        if (paramShort != 9) {
          throw new TlsFatalAlert((short)10);
        }
      }
      else {
        this.tlsServer.processClientSupplementalData(null);
      }
      if (this.certificateRequest != null)
      {
        receiveCertificateMessage(paramByteArrayInputStream);
        this.connection_state = 10;
        return;
      }
      throw new TlsFatalAlert((short)10);
    }
    paramShort = this.connection_state;
    if (paramShort != 0)
    {
      if (paramShort == 16)
      {
        refuseRenegotiation();
        return;
      }
      throw new TlsFatalAlert((short)10);
    }
    receiveClientHelloMessage(paramByteArrayInputStream);
    this.connection_state = 1;
    sendServerHelloMessage();
    this.connection_state = 2;
    this.recordStream.notifyHelloComplete();
    paramByteArrayInputStream = this.tlsServer.getServerSupplementalData();
    if (paramByteArrayInputStream != null) {
      sendSupplementalDataMessage(paramByteArrayInputStream);
    }
    this.connection_state = 3;
    paramByteArrayInputStream = this.tlsServer.getKeyExchange();
    this.keyExchange = paramByteArrayInputStream;
    paramByteArrayInputStream.init(getContext());
    paramByteArrayInputStream = this.tlsServer.getCredentials();
    this.serverCredentials = paramByteArrayInputStream;
    if (paramByteArrayInputStream == null)
    {
      this.keyExchange.skipServerCredentials();
      paramByteArrayInputStream = (ByteArrayInputStream)localObject;
    }
    else
    {
      this.keyExchange.processServerCredentials(paramByteArrayInputStream);
      paramByteArrayInputStream = this.serverCredentials.getCertificate();
      sendCertificateMessage(paramByteArrayInputStream);
    }
    this.connection_state = 4;
    if ((paramByteArrayInputStream == null) || (paramByteArrayInputStream.isEmpty())) {
      this.allowCertificateStatus = false;
    }
    if (this.allowCertificateStatus)
    {
      paramByteArrayInputStream = this.tlsServer.getCertificateStatus();
      if (paramByteArrayInputStream != null) {
        sendCertificateStatusMessage(paramByteArrayInputStream);
      }
    }
    this.connection_state = 5;
    paramByteArrayInputStream = this.keyExchange.generateServerKeyExchange();
    if (paramByteArrayInputStream != null) {
      sendServerKeyExchangeMessage(paramByteArrayInputStream);
    }
    this.connection_state = 6;
    if (this.serverCredentials != null)
    {
      paramByteArrayInputStream = this.tlsServer.getCertificateRequest();
      this.certificateRequest = paramByteArrayInputStream;
      if (paramByteArrayInputStream != null)
      {
        boolean bool2 = TlsUtils.isTLSv12(getContext());
        if (this.certificateRequest.getSupportedSignatureAlgorithms() == null) {
          bool1 = false;
        }
        if (bool2 == bool1)
        {
          this.keyExchange.validateCertificateRequest(this.certificateRequest);
          sendCertificateRequestMessage(this.certificateRequest);
          TlsUtils.trackHashAlgorithms(this.recordStream.getHandshakeHash(), this.certificateRequest.getSupportedSignatureAlgorithms());
        }
        else
        {
          throw new TlsFatalAlert((short)80);
        }
      }
    }
    this.connection_state = 7;
    sendServerHelloDoneMessage();
    this.connection_state = 8;
    this.recordStream.getHandshakeHash().sealHashAlgorithms();
  }
  
  protected void handleWarningMessage(short paramShort)
    throws IOException
  {
    if (paramShort != 41)
    {
      super.handleWarningMessage(paramShort);
      return;
    }
    if ((TlsUtils.isSSL(getContext())) && (this.certificateRequest != null)) {
      notifyClientCertificate(Certificate.EMPTY_CHAIN);
    }
  }
  
  protected void notifyClientCertificate(Certificate paramCertificate)
    throws IOException
  {
    if (this.certificateRequest != null)
    {
      if (this.peerCertificate == null)
      {
        this.peerCertificate = paramCertificate;
        if (paramCertificate.isEmpty())
        {
          this.keyExchange.skipClientCredentials();
        }
        else
        {
          this.clientCertificateType = TlsUtils.getClientCertificateType(paramCertificate, this.serverCredentials.getCertificate());
          this.keyExchange.processClientCertificate(paramCertificate);
        }
        this.tlsServer.notifyClientCertificate(paramCertificate);
        return;
      }
      throw new TlsFatalAlert((short)10);
    }
    throw new IllegalStateException();
  }
  
  protected void receiveCertificateMessage(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    Certificate localCertificate = Certificate.parse(paramByteArrayInputStream);
    assertEmpty(paramByteArrayInputStream);
    notifyClientCertificate(localCertificate);
  }
  
  protected void receiveCertificateVerifyMessage(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    if (this.certificateRequest != null)
    {
      DigitallySigned localDigitallySigned = DigitallySigned.parse(getContext(), paramByteArrayInputStream);
      assertEmpty(paramByteArrayInputStream);
      try
      {
        SignatureAndHashAlgorithm localSignatureAndHashAlgorithm = localDigitallySigned.getAlgorithm();
        if (TlsUtils.isTLSv12(getContext()))
        {
          TlsUtils.verifySupportedSignatureAlgorithm(this.certificateRequest.getSupportedSignatureAlgorithms(), localSignatureAndHashAlgorithm);
          paramByteArrayInputStream = this.prepareFinishHash.getFinalHash(localSignatureAndHashAlgorithm.getHash());
        }
        else
        {
          paramByteArrayInputStream = this.securityParameters.getSessionHash();
        }
        AsymmetricKeyParameter localAsymmetricKeyParameter = PublicKeyFactory.createKey(this.peerCertificate.getCertificateAt(0).getSubjectPublicKeyInfo());
        TlsSigner localTlsSigner = TlsUtils.createTlsSigner(this.clientCertificateType);
        localTlsSigner.init(getContext());
        if (localTlsSigner.verifyRawSignature(localSignatureAndHashAlgorithm, localDigitallySigned.getSignature(), localAsymmetricKeyParameter, paramByteArrayInputStream)) {
          return;
        }
        throw new TlsFatalAlert((short)51);
      }
      catch (Exception paramByteArrayInputStream)
      {
        throw new TlsFatalAlert((short)51, paramByteArrayInputStream);
      }
      catch (TlsFatalAlert paramByteArrayInputStream)
      {
        throw paramByteArrayInputStream;
      }
    }
    throw new IllegalStateException();
  }
  
  protected void receiveClientHelloMessage(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    ProtocolVersion localProtocolVersion = TlsUtils.readVersion(paramByteArrayInputStream);
    this.recordStream.setWriteVersion(localProtocolVersion);
    if (!localProtocolVersion.isDTLS())
    {
      byte[] arrayOfByte = TlsUtils.readFully(32, paramByteArrayInputStream);
      if (TlsUtils.readOpaque8(paramByteArrayInputStream).length <= 32)
      {
        int i = TlsUtils.readUint16(paramByteArrayInputStream);
        if ((i >= 2) && ((i & 0x1) == 0))
        {
          this.offeredCipherSuites = TlsUtils.readUint16Array(i / 2, paramByteArrayInputStream);
          i = TlsUtils.readUint8(paramByteArrayInputStream);
          if (i >= 1)
          {
            this.offeredCompressionMethods = TlsUtils.readUint8Array(i, paramByteArrayInputStream);
            this.clientExtensions = readExtensions(paramByteArrayInputStream);
            this.securityParameters.extendedMasterSecret = TlsExtensionsUtils.hasExtendedMasterSecretExtension(this.clientExtensions);
            getContextAdmin().setClientVersion(localProtocolVersion);
            this.tlsServer.notifyClientVersion(localProtocolVersion);
            this.tlsServer.notifyFallback(Arrays.contains(this.offeredCipherSuites, 22016));
            this.securityParameters.clientRandom = arrayOfByte;
            this.tlsServer.notifyOfferedCipherSuites(this.offeredCipherSuites);
            this.tlsServer.notifyOfferedCompressionMethods(this.offeredCompressionMethods);
            if (Arrays.contains(this.offeredCipherSuites, 255)) {
              this.secure_renegotiation = true;
            }
            paramByteArrayInputStream = TlsUtils.getExtensionData(this.clientExtensions, EXT_RenegotiationInfo);
            if (paramByteArrayInputStream != null)
            {
              this.secure_renegotiation = true;
              if (!Arrays.constantTimeAreEqual(paramByteArrayInputStream, createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                throw new TlsFatalAlert((short)40);
              }
            }
            this.tlsServer.notifySecureRenegotiation(this.secure_renegotiation);
            if (this.clientExtensions != null)
            {
              TlsExtensionsUtils.getPaddingExtension(this.clientExtensions);
              this.tlsServer.processClientExtensions(this.clientExtensions);
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
  
  protected void receiveClientKeyExchangeMessage(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    this.keyExchange.processClientKeyExchange(paramByteArrayInputStream);
    assertEmpty(paramByteArrayInputStream);
    if (TlsUtils.isSSL(getContext())) {
      establishMasterSecret(getContext(), this.keyExchange);
    }
    this.prepareFinishHash = this.recordStream.prepareToFinish();
    this.securityParameters.sessionHash = getCurrentPRFHash(getContext(), this.prepareFinishHash, null);
    if (!TlsUtils.isSSL(getContext())) {
      establishMasterSecret(getContext(), this.keyExchange);
    }
    this.recordStream.setPendingConnectionState(getPeer().getCompression(), getPeer().getCipher());
    if (!this.expectSessionTicket) {
      sendChangeCipherSpecMessage();
    }
  }
  
  protected void sendCertificateRequestMessage(CertificateRequest paramCertificateRequest)
    throws IOException
  {
    TlsProtocol.HandshakeMessage localHandshakeMessage = new TlsProtocol.HandshakeMessage(this, (short)13);
    paramCertificateRequest.encode(localHandshakeMessage);
    localHandshakeMessage.writeToRecordStream();
  }
  
  protected void sendCertificateStatusMessage(CertificateStatus paramCertificateStatus)
    throws IOException
  {
    TlsProtocol.HandshakeMessage localHandshakeMessage = new TlsProtocol.HandshakeMessage(this, (short)22);
    paramCertificateStatus.encode(localHandshakeMessage);
    localHandshakeMessage.writeToRecordStream();
  }
  
  protected void sendNewSessionTicketMessage(NewSessionTicket paramNewSessionTicket)
    throws IOException
  {
    if (paramNewSessionTicket != null)
    {
      TlsProtocol.HandshakeMessage localHandshakeMessage = new TlsProtocol.HandshakeMessage(this, (short)4);
      paramNewSessionTicket.encode(localHandshakeMessage);
      localHandshakeMessage.writeToRecordStream();
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  protected void sendServerHelloDoneMessage()
    throws IOException
  {
    byte[] arrayOfByte = new byte[4];
    TlsUtils.writeUint8((short)14, arrayOfByte, 0);
    TlsUtils.writeUint24(0, arrayOfByte, 1);
    writeHandshakeMessage(arrayOfByte, 0, 4);
  }
  
  protected void sendServerHelloMessage()
    throws IOException
  {
    TlsProtocol.HandshakeMessage localHandshakeMessage = new TlsProtocol.HandshakeMessage(this, (short)2);
    ProtocolVersion localProtocolVersion = this.tlsServer.getServerVersion();
    if (localProtocolVersion.isEqualOrEarlierVersionOf(getContext().getClientVersion()))
    {
      this.recordStream.setReadVersion(localProtocolVersion);
      this.recordStream.setWriteVersion(localProtocolVersion);
      RecordStream localRecordStream = this.recordStream;
      boolean bool2 = true;
      localRecordStream.setRestrictReadVersion(true);
      getContextAdmin().setServerVersion(localProtocolVersion);
      TlsUtils.writeVersion(localProtocolVersion, localHandshakeMessage);
      localHandshakeMessage.write(this.securityParameters.serverRandom);
      TlsUtils.writeOpaque8(TlsUtils.EMPTY_BYTES, localHandshakeMessage);
      int i = this.tlsServer.getSelectedCipherSuite();
      if ((Arrays.contains(this.offeredCipherSuites, i)) && (i != 0) && (!CipherSuite.isSCSV(i)) && (TlsUtils.isValidCipherSuiteForVersion(i, getContext().getServerVersion())))
      {
        this.securityParameters.cipherSuite = i;
        short s = this.tlsServer.getSelectedCompressionMethod();
        if (Arrays.contains(this.offeredCompressionMethods, s))
        {
          this.securityParameters.compressionAlgorithm = s;
          TlsUtils.writeUint16(i, localHandshakeMessage);
          TlsUtils.writeUint8(s, localHandshakeMessage);
          this.serverExtensions = this.tlsServer.getServerExtensions();
          if (this.secure_renegotiation)
          {
            if (TlsUtils.getExtensionData(this.serverExtensions, EXT_RenegotiationInfo) == null) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0)
            {
              this.serverExtensions = TlsExtensionsUtils.ensureExtensionsInitialised(this.serverExtensions);
              this.serverExtensions.put(EXT_RenegotiationInfo, createRenegotiationInfo(TlsUtils.EMPTY_BYTES));
            }
          }
          if (this.securityParameters.extendedMasterSecret)
          {
            this.serverExtensions = TlsExtensionsUtils.ensureExtensionsInitialised(this.serverExtensions);
            TlsExtensionsUtils.addExtendedMasterSecretExtension(this.serverExtensions);
          }
          if (this.serverExtensions != null)
          {
            this.securityParameters.encryptThenMAC = TlsExtensionsUtils.hasEncryptThenMACExtension(this.serverExtensions);
            this.securityParameters.maxFragmentLength = processMaxFragmentLengthExtension(this.clientExtensions, this.serverExtensions, (short)80);
            this.securityParameters.truncatedHMac = TlsExtensionsUtils.hasTruncatedHMacExtension(this.serverExtensions);
            boolean bool1;
            if ((!this.resumedSession) && (TlsUtils.hasExpectedEmptyExtensionData(this.serverExtensions, TlsExtensionsUtils.EXT_status_request, (short)80))) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            this.allowCertificateStatus = bool1;
            if ((!this.resumedSession) && (TlsUtils.hasExpectedEmptyExtensionData(this.serverExtensions, TlsProtocol.EXT_SessionTicket, (short)80))) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
            this.expectSessionTicket = bool1;
            writeExtensions(localHandshakeMessage, this.serverExtensions);
          }
          this.securityParameters.prfAlgorithm = getPRFAlgorithm(getContext(), this.securityParameters.getCipherSuite());
          this.securityParameters.verifyDataLength = 12;
          applyMaxFragmentLengthExtension();
          localHandshakeMessage.writeToRecordStream();
          return;
        }
        throw new TlsFatalAlert((short)80);
      }
      throw new TlsFatalAlert((short)80);
    }
    throw new TlsFatalAlert((short)80);
  }
  
  protected void sendServerKeyExchangeMessage(byte[] paramArrayOfByte)
    throws IOException
  {
    TlsProtocol.HandshakeMessage localHandshakeMessage = new TlsProtocol.HandshakeMessage(this, (short)12, paramArrayOfByte.length);
    localHandshakeMessage.write(paramArrayOfByte);
    localHandshakeMessage.writeToRecordStream();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsServerProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */