package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

public abstract class AbstractTlsClient
  extends AbstractTlsPeer
  implements TlsClient
{
  protected TlsCipherFactory cipherFactory;
  protected short[] clientECPointFormats;
  protected TlsClientContext context;
  protected int[] namedCurves;
  protected int selectedCipherSuite;
  protected short selectedCompressionMethod;
  protected short[] serverECPointFormats;
  protected Vector supportedSignatureAlgorithms;
  
  public AbstractTlsClient()
  {
    this(new DefaultTlsCipherFactory());
  }
  
  public AbstractTlsClient(TlsCipherFactory paramTlsCipherFactory)
  {
    this.cipherFactory = paramTlsCipherFactory;
  }
  
  protected boolean allowUnexpectedServerExtension(Integer paramInteger, byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramInteger.intValue() != 10) {
      return false;
    }
    TlsECCUtils.readSupportedEllipticCurvesExtension(paramArrayOfByte);
    return true;
  }
  
  protected void checkForUnexpectedServerExtension(Hashtable paramHashtable, Integer paramInteger)
    throws IOException
  {
    paramHashtable = TlsUtils.getExtensionData(paramHashtable, paramInteger);
    if (paramHashtable != null)
    {
      if (allowUnexpectedServerExtension(paramInteger, paramHashtable)) {
        return;
      }
      throw new TlsFatalAlert((short)47);
    }
  }
  
  public TlsCipher getCipher()
    throws IOException
  {
    int i = TlsUtils.getEncryptionAlgorithm(this.selectedCipherSuite);
    int j = TlsUtils.getMACAlgorithm(this.selectedCipherSuite);
    return this.cipherFactory.createCipher(this.context, i, j);
  }
  
  public Hashtable getClientExtensions()
    throws IOException
  {
    boolean bool = TlsUtils.isSignatureAlgorithmsExtensionAllowed(this.context.getClientVersion());
    Hashtable localHashtable1 = null;
    if (bool)
    {
      this.supportedSignatureAlgorithms = TlsUtils.getDefaultSupportedSignatureAlgorithms();
      localHashtable1 = TlsExtensionsUtils.ensureExtensionsInitialised(null);
      TlsUtils.addSignatureAlgorithmsExtension(localHashtable1, this.supportedSignatureAlgorithms);
    }
    Hashtable localHashtable2 = localHashtable1;
    if (TlsECCUtils.containsECCCipherSuites(getCipherSuites()))
    {
      this.namedCurves = new int[] { 23, 24 };
      this.clientECPointFormats = new short[] { 0, 1, 2 };
      localHashtable2 = TlsExtensionsUtils.ensureExtensionsInitialised(localHashtable1);
      TlsECCUtils.addSupportedEllipticCurvesExtension(localHashtable2, this.namedCurves);
      TlsECCUtils.addSupportedPointFormatsExtension(localHashtable2, this.clientECPointFormats);
    }
    return localHashtable2;
  }
  
  public ProtocolVersion getClientHelloRecordLayerVersion()
  {
    return getClientVersion();
  }
  
  public Vector getClientSupplementalData()
    throws IOException
  {
    return null;
  }
  
  public ProtocolVersion getClientVersion()
  {
    return ProtocolVersion.TLSv12;
  }
  
  public TlsCompression getCompression()
    throws IOException
  {
    if (this.selectedCompressionMethod == 0) {
      return new TlsNullCompression();
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public short[] getCompressionMethods()
  {
    return new short[] { 0 };
  }
  
  public ProtocolVersion getMinimumVersion()
  {
    return ProtocolVersion.TLSv10;
  }
  
  public TlsSession getSessionToResume()
  {
    return null;
  }
  
  public void init(TlsClientContext paramTlsClientContext)
  {
    this.context = paramTlsClientContext;
  }
  
  public boolean isFallback()
  {
    return false;
  }
  
  public void notifyNewSessionTicket(NewSessionTicket paramNewSessionTicket)
    throws IOException
  {}
  
  public void notifySelectedCipherSuite(int paramInt)
  {
    this.selectedCipherSuite = paramInt;
  }
  
  public void notifySelectedCompressionMethod(short paramShort)
  {
    this.selectedCompressionMethod = paramShort;
  }
  
  public void notifyServerVersion(ProtocolVersion paramProtocolVersion)
    throws IOException
  {
    if (getMinimumVersion().isEqualOrEarlierVersionOf(paramProtocolVersion)) {
      return;
    }
    throw new TlsFatalAlert((short)70);
  }
  
  public void notifySessionID(byte[] paramArrayOfByte) {}
  
  public void processServerExtensions(Hashtable paramHashtable)
    throws IOException
  {
    if (paramHashtable != null)
    {
      checkForUnexpectedServerExtension(paramHashtable, TlsUtils.EXT_signature_algorithms);
      checkForUnexpectedServerExtension(paramHashtable, TlsECCUtils.EXT_elliptic_curves);
      if (TlsECCUtils.isECCCipherSuite(this.selectedCipherSuite)) {
        this.serverECPointFormats = TlsECCUtils.getSupportedPointFormatsExtension(paramHashtable);
      } else {
        checkForUnexpectedServerExtension(paramHashtable, TlsECCUtils.EXT_ec_point_formats);
      }
      checkForUnexpectedServerExtension(paramHashtable, TlsExtensionsUtils.EXT_padding);
    }
  }
  
  public void processServerSupplementalData(Vector paramVector)
    throws IOException
  {
    if (paramVector == null) {
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\AbstractTlsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */