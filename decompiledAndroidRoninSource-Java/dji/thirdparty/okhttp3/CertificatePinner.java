package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.Util;
import dji.thirdparty.okhttp3.internal.tls.TrustRootIndex;
import dji.thirdparty.okio.ByteString;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class CertificatePinner
{
  public static final CertificatePinner DEFAULT = new Builder().build();
  private final List<Pin> pins;
  private final TrustRootIndex trustRootIndex;
  
  private CertificatePinner(Builder paramBuilder)
  {
    this.pins = Util.immutableList(paramBuilder.pins);
    this.trustRootIndex = paramBuilder.trustRootIndex;
  }
  
  public static String pin(Certificate paramCertificate)
  {
    if ((paramCertificate instanceof X509Certificate))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sha256/");
      localStringBuilder.append(sha256((X509Certificate)paramCertificate).base64());
      return localStringBuilder.toString();
    }
    throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
  }
  
  static ByteString sha1(X509Certificate paramX509Certificate)
  {
    return Util.sha1(ByteString.of(paramX509Certificate.getPublicKey().getEncoded()));
  }
  
  static ByteString sha256(X509Certificate paramX509Certificate)
  {
    return Util.sha256(ByteString.of(paramX509Certificate.getPublicKey().getEncoded()));
  }
  
  /* Error */
  public void check(String arg1, List<Certificate> arg2)
    throws SSLPeerUnverifiedException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void check(String paramString, Certificate... paramVarArgs)
    throws SSLPeerUnverifiedException
  {
    check(paramString, Arrays.asList(paramVarArgs));
  }
  
  List<Pin> findMatchingPins(String paramString)
  {
    return null;
  }
  
  Builder newBuilder()
  {
    return new Builder(this);
  }
  
  public static final class Builder
  {
    private final List<CertificatePinner.Pin> pins;
    private TrustRootIndex trustRootIndex;
    
    public Builder()
    {
      this.pins = new ArrayList();
    }
    
    Builder(CertificatePinner paramCertificatePinner)
    {
      ArrayList localArrayList = new ArrayList();
      this.pins = localArrayList;
      localArrayList.addAll(paramCertificatePinner.pins);
      this.trustRootIndex = paramCertificatePinner.trustRootIndex;
    }
    
    public Builder add(String paramString, String... paramVarArgs)
    {
      return null;
    }
    
    public CertificatePinner build()
    {
      return new CertificatePinner(this, null);
    }
    
    public Builder trustRootIndex(TrustRootIndex paramTrustRootIndex)
    {
      this.trustRootIndex = paramTrustRootIndex;
      return this;
    }
  }
  
  static final class Pin
  {
    final ByteString hash;
    final String hashAlgorithm;
    final String pattern;
    
    Pin(String paramString1, String paramString2)
    {
      this.pattern = paramString1;
      if (paramString2.startsWith("sha1/"))
      {
        this.hashAlgorithm = "sha1/";
        this.hash = ByteString.decodeBase64(paramString2.substring(5));
      }
      else
      {
        if (!paramString2.startsWith("sha256/")) {
          break label108;
        }
        this.hashAlgorithm = "sha256/";
        this.hash = ByteString.decodeBase64(paramString2.substring(7));
      }
      if (this.hash != null) {
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append("pins must be base64: ");
      paramString1.append(paramString2);
      throw new IllegalArgumentException(paramString1.toString());
      label108:
      paramString1 = new StringBuilder();
      paramString1.append("pins must start with 'sha256/' or 'sha1/': ");
      paramString1.append(paramString2);
      throw new IllegalArgumentException(paramString1.toString());
    }
    
    public boolean equals(Object paramObject)
    {
      return false;
    }
    
    public int hashCode()
    {
      return 0;
    }
    
    boolean matches(String paramString)
    {
      return false;
    }
    
    public String toString()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\CertificatePinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */