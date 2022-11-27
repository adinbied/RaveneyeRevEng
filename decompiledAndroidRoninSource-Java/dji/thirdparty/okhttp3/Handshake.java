package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.Util;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class Handshake
{
  private final CipherSuite cipherSuite;
  private final List<Certificate> localCertificates;
  private final List<Certificate> peerCertificates;
  private final TlsVersion tlsVersion;
  
  private Handshake(TlsVersion paramTlsVersion, CipherSuite paramCipherSuite, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    this.tlsVersion = paramTlsVersion;
    this.cipherSuite = paramCipherSuite;
    this.peerCertificates = paramList1;
    this.localCertificates = paramList2;
  }
  
  public static Handshake get(TlsVersion paramTlsVersion, CipherSuite paramCipherSuite, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    if (paramCipherSuite != null) {
      return new Handshake(paramTlsVersion, paramCipherSuite, Util.immutableList(paramList1), Util.immutableList(paramList2));
    }
    throw new IllegalArgumentException("cipherSuite == null");
  }
  
  public static Handshake get(SSLSession paramSSLSession)
  {
    Object localObject = paramSSLSession.getCipherSuite();
    CipherSuite localCipherSuite;
    TlsVersion localTlsVersion;
    if (localObject != null)
    {
      localCipherSuite = CipherSuite.forJavaName((String)localObject);
      localObject = paramSSLSession.getProtocol();
      if (localObject != null) {
        localTlsVersion = TlsVersion.forJavaName((String)localObject);
      }
    }
    try
    {
      localObject = paramSSLSession.getPeerCertificates();
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      for (;;) {}
    }
    localObject = null;
    if (localObject != null) {
      localObject = Util.immutableList((Object[])localObject);
    } else {
      localObject = Collections.emptyList();
    }
    paramSSLSession = paramSSLSession.getLocalCertificates();
    if (paramSSLSession != null) {
      paramSSLSession = Util.immutableList(paramSSLSession);
    } else {
      paramSSLSession = Collections.emptyList();
    }
    return new Handshake(localTlsVersion, localCipherSuite, (List)localObject, paramSSLSession);
    throw new IllegalStateException("tlsVersion == null");
    throw new IllegalStateException("cipherSuite == null");
  }
  
  public CipherSuite cipherSuite()
  {
    return this.cipherSuite;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public List<Certificate> localCertificates()
  {
    return this.localCertificates;
  }
  
  public Principal localPrincipal()
  {
    return null;
  }
  
  public List<Certificate> peerCertificates()
  {
    return this.peerCertificates;
  }
  
  public Principal peerPrincipal()
  {
    return null;
  }
  
  public TlsVersion tlsVersion()
  {
    return this.tlsVersion;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Handshake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */