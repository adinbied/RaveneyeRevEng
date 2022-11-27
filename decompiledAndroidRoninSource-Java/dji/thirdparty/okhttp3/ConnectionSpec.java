package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.Util;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpec
{
  private static final CipherSuite[] APPROVED_CIPHER_SUITES = { CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA };
  public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
  public static final ConnectionSpec COMPATIBLE_TLS;
  public static final ConnectionSpec MODERN_TLS;
  private final String[] cipherSuites;
  private final boolean supportsTlsExtensions;
  private final boolean tls;
  private final String[] tlsVersions;
  
  static
  {
    ConnectionSpec localConnectionSpec = new Builder(true).cipherSuites(APPROVED_CIPHER_SUITES).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0 }).supportsTlsExtensions(true).build();
    MODERN_TLS = localConnectionSpec;
    COMPATIBLE_TLS = new Builder(localConnectionSpec).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_0 }).supportsTlsExtensions(true).build();
  }
  
  private ConnectionSpec(Builder paramBuilder)
  {
    this.tls = paramBuilder.tls;
    this.cipherSuites = paramBuilder.cipherSuites;
    this.tlsVersions = paramBuilder.tlsVersions;
    this.supportsTlsExtensions = paramBuilder.supportsTlsExtensions;
  }
  
  private static boolean nonEmptyIntersection(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 != null) && (paramArrayOfString2 != null) && (paramArrayOfString1.length != 0))
    {
      if (paramArrayOfString2.length == 0) {
        return false;
      }
      int j = paramArrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        if (Util.contains(paramArrayOfString2, paramArrayOfString1[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private ConnectionSpec supportedSpec(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    return null;
  }
  
  /* Error */
  void apply(SSLSocket arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public List<CipherSuite> cipherSuites()
  {
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isCompatible(SSLSocket paramSSLSocket)
  {
    return false;
  }
  
  public boolean isTls()
  {
    return this.tls;
  }
  
  public boolean supportsTlsExtensions()
  {
    return this.supportsTlsExtensions;
  }
  
  public List<TlsVersion> tlsVersions()
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
  
  public static final class Builder
  {
    private String[] cipherSuites;
    private boolean supportsTlsExtensions;
    private boolean tls;
    private String[] tlsVersions;
    
    public Builder(ConnectionSpec paramConnectionSpec)
    {
      this.tls = paramConnectionSpec.tls;
      this.cipherSuites = paramConnectionSpec.cipherSuites;
      this.tlsVersions = paramConnectionSpec.tlsVersions;
      this.supportsTlsExtensions = paramConnectionSpec.supportsTlsExtensions;
    }
    
    Builder(boolean paramBoolean)
    {
      this.tls = paramBoolean;
    }
    
    public Builder allEnabledCipherSuites()
    {
      return null;
    }
    
    public Builder allEnabledTlsVersions()
    {
      return null;
    }
    
    public ConnectionSpec build()
    {
      return new ConnectionSpec(this, null);
    }
    
    public Builder cipherSuites(CipherSuite... paramVarArgs)
    {
      return null;
    }
    
    public Builder cipherSuites(String... paramVarArgs)
    {
      return null;
    }
    
    public Builder supportsTlsExtensions(boolean paramBoolean)
    {
      return null;
    }
    
    public Builder tlsVersions(TlsVersion... paramVarArgs)
    {
      return null;
    }
    
    public Builder tlsVersions(String... paramVarArgs)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\ConnectionSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */