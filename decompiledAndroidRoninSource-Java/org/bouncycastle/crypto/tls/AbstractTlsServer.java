package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.util.Arrays;

public abstract class AbstractTlsServer
  extends AbstractTlsPeer
  implements TlsServer
{
  protected TlsCipherFactory cipherFactory;
  protected short[] clientECPointFormats;
  protected Hashtable clientExtensions;
  protected ProtocolVersion clientVersion;
  protected TlsServerContext context;
  protected boolean eccCipherSuitesOffered;
  protected boolean encryptThenMACOffered;
  protected short maxFragmentLengthOffered;
  protected int[] namedCurves;
  protected int[] offeredCipherSuites;
  protected short[] offeredCompressionMethods;
  protected int selectedCipherSuite;
  protected short selectedCompressionMethod;
  protected short[] serverECPointFormats;
  protected Hashtable serverExtensions;
  protected ProtocolVersion serverVersion;
  protected Vector supportedSignatureAlgorithms;
  protected boolean truncatedHMacOffered;
  
  public AbstractTlsServer()
  {
    this(new DefaultTlsCipherFactory());
  }
  
  public AbstractTlsServer(TlsCipherFactory paramTlsCipherFactory)
  {
    this.cipherFactory = paramTlsCipherFactory;
  }
  
  protected boolean allowEncryptThenMAC()
  {
    return true;
  }
  
  protected boolean allowTruncatedHMac()
  {
    return false;
  }
  
  protected Hashtable checkServerExtensions()
  {
    Hashtable localHashtable = TlsExtensionsUtils.ensureExtensionsInitialised(this.serverExtensions);
    this.serverExtensions = localHashtable;
    return localHashtable;
  }
  
  public CertificateRequest getCertificateRequest()
    throws IOException
  {
    return null;
  }
  
  public CertificateStatus getCertificateStatus()
    throws IOException
  {
    return null;
  }
  
  public TlsCipher getCipher()
    throws IOException
  {
    int i = TlsUtils.getEncryptionAlgorithm(this.selectedCipherSuite);
    int j = TlsUtils.getMACAlgorithm(this.selectedCipherSuite);
    return this.cipherFactory.createCipher(this.context, i, j);
  }
  
  protected abstract int[] getCipherSuites();
  
  public TlsCompression getCompression()
    throws IOException
  {
    if (this.selectedCompressionMethod == 0) {
      return new TlsNullCompression();
    }
    throw new TlsFatalAlert((short)80);
  }
  
  protected short[] getCompressionMethods()
  {
    return new short[] { 0 };
  }
  
  protected ProtocolVersion getMaximumVersion()
  {
    return ProtocolVersion.TLSv11;
  }
  
  protected ProtocolVersion getMinimumVersion()
  {
    return ProtocolVersion.TLSv10;
  }
  
  public NewSessionTicket getNewSessionTicket()
    throws IOException
  {
    return new NewSessionTicket(0L, TlsUtils.EMPTY_BYTES);
  }
  
  public int getSelectedCipherSuite()
    throws IOException
  {
    Vector localVector = TlsUtils.getUsableSignatureAlgorithms(this.supportedSignatureAlgorithms);
    boolean bool = supportsClientECCCapabilities(this.namedCurves, this.clientECPointFormats);
    int[] arrayOfInt = getCipherSuites();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      int j = arrayOfInt[i];
      if ((Arrays.contains(this.offeredCipherSuites, j)) && ((bool) || (!TlsECCUtils.isECCCipherSuite(j))) && (TlsUtils.isValidCipherSuiteForVersion(j, this.serverVersion)) && (TlsUtils.isValidCipherSuiteForSignatureAlgorithms(j, localVector)))
      {
        this.selectedCipherSuite = j;
        return j;
      }
      i += 1;
    }
    throw new TlsFatalAlert((short)40);
  }
  
  public short getSelectedCompressionMethod()
    throws IOException
  {
    short[] arrayOfShort = getCompressionMethods();
    int i = 0;
    while (i < arrayOfShort.length)
    {
      if (Arrays.contains(this.offeredCompressionMethods, arrayOfShort[i]))
      {
        short s = arrayOfShort[i];
        this.selectedCompressionMethod = s;
        return s;
      }
      i += 1;
    }
    throw new TlsFatalAlert((short)40);
  }
  
  public Hashtable getServerExtensions()
    throws IOException
  {
    if ((this.encryptThenMACOffered) && (allowEncryptThenMAC()) && (TlsUtils.isBlockCipherSuite(this.selectedCipherSuite))) {
      TlsExtensionsUtils.addEncryptThenMACExtension(checkServerExtensions());
    }
    short s = this.maxFragmentLengthOffered;
    if ((s >= 0) && (MaxFragmentLength.isValid(s))) {
      TlsExtensionsUtils.addMaxFragmentLengthExtension(checkServerExtensions(), this.maxFragmentLengthOffered);
    }
    if ((this.truncatedHMacOffered) && (allowTruncatedHMac())) {
      TlsExtensionsUtils.addTruncatedHMacExtension(checkServerExtensions());
    }
    if ((this.clientECPointFormats != null) && (TlsECCUtils.isECCCipherSuite(this.selectedCipherSuite)))
    {
      this.serverECPointFormats = new short[] { 0, 1, 2 };
      TlsECCUtils.addSupportedPointFormatsExtension(checkServerExtensions(), this.serverECPointFormats);
    }
    return this.serverExtensions;
  }
  
  public Vector getServerSupplementalData()
    throws IOException
  {
    return null;
  }
  
  public ProtocolVersion getServerVersion()
    throws IOException
  {
    if (getMinimumVersion().isEqualOrEarlierVersionOf(this.clientVersion))
    {
      ProtocolVersion localProtocolVersion = getMaximumVersion();
      if (this.clientVersion.isEqualOrEarlierVersionOf(localProtocolVersion))
      {
        localProtocolVersion = this.clientVersion;
        this.serverVersion = localProtocolVersion;
        return localProtocolVersion;
      }
      if (this.clientVersion.isLaterVersionOf(localProtocolVersion))
      {
        this.serverVersion = localProtocolVersion;
        return localProtocolVersion;
      }
    }
    throw new TlsFatalAlert((short)70);
  }
  
  public void init(TlsServerContext paramTlsServerContext)
  {
    this.context = paramTlsServerContext;
  }
  
  public void notifyClientCertificate(Certificate paramCertificate)
    throws IOException
  {
    throw new TlsFatalAlert((short)80);
  }
  
  public void notifyClientVersion(ProtocolVersion paramProtocolVersion)
    throws IOException
  {
    this.clientVersion = paramProtocolVersion;
  }
  
  public void notifyFallback(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
    {
      if (!getMaximumVersion().isLaterVersionOf(this.clientVersion)) {
        return;
      }
      throw new TlsFatalAlert((short)86);
    }
  }
  
  public void notifyOfferedCipherSuites(int[] paramArrayOfInt)
    throws IOException
  {
    this.offeredCipherSuites = paramArrayOfInt;
    this.eccCipherSuitesOffered = TlsECCUtils.containsECCCipherSuites(paramArrayOfInt);
  }
  
  public void notifyOfferedCompressionMethods(short[] paramArrayOfShort)
    throws IOException
  {
    this.offeredCompressionMethods = paramArrayOfShort;
  }
  
  public void processClientExtensions(Hashtable paramHashtable)
    throws IOException
  {
    this.clientExtensions = paramHashtable;
    if (paramHashtable != null)
    {
      this.encryptThenMACOffered = TlsExtensionsUtils.hasEncryptThenMACExtension(paramHashtable);
      short s = TlsExtensionsUtils.getMaxFragmentLengthExtension(paramHashtable);
      this.maxFragmentLengthOffered = s;
      if ((s >= 0) && (!MaxFragmentLength.isValid(s))) {
        throw new TlsFatalAlert((short)47);
      }
      this.truncatedHMacOffered = TlsExtensionsUtils.hasTruncatedHMacExtension(paramHashtable);
      Vector localVector = TlsUtils.getSignatureAlgorithmsExtension(paramHashtable);
      this.supportedSignatureAlgorithms = localVector;
      if ((localVector != null) && (!TlsUtils.isSignatureAlgorithmsExtensionAllowed(this.clientVersion))) {
        throw new TlsFatalAlert((short)47);
      }
      this.namedCurves = TlsECCUtils.getSupportedEllipticCurvesExtension(paramHashtable);
      this.clientECPointFormats = TlsECCUtils.getSupportedPointFormatsExtension(paramHashtable);
    }
  }
  
  public void processClientSupplementalData(Vector paramVector)
    throws IOException
  {
    if (paramVector == null) {
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
  
  protected boolean supportsClientECCCapabilities(int[] paramArrayOfInt, short[] paramArrayOfShort)
  {
    if (paramArrayOfInt == null) {
      return TlsECCUtils.hasAnySupportedNamedCurves();
    }
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      int j = paramArrayOfInt[i];
      if ((NamedCurve.isValid(j)) && ((!NamedCurve.refersToASpecificNamedCurve(j)) || (TlsECCUtils.isSupportedNamedCurve(j)))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\AbstractTlsServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */