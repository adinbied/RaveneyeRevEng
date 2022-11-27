package dji.thirdparty.afinal.utils;

import dji.tools.security.WhiteBoxAES;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.StrictHostnameVerifier;

public class HttpsHelper
{
  private static final String AMAZON_ROOT_CA1_ENCRYPTED = "AAA456F5C893695F977D5FFABE8DEEF82BC1799FC91EE0AF0FDB5DC42BAC4827320354B37DF55FD1652753684168D043";
  private static final String AMAZON_ROOT_CA2_ENCRYPTED = "420808630125CC03FBA09E86F2C896349930DD1300396E51D89FA041BDF1E2714F9B717A64D833E77E3E241E966D20B1";
  private static final String AMAZON_ROOT_CA3_ENCRYPTED = "18C0B1AC417F72ABBCFEA962E20591DBEC242881092E034C72F03E8C77BB1607E6BDD8386CDD535F91A0692311B27141";
  private static final String AMAZON_ROOT_CA4_ENCRYPTED = "01B17E2FDEC3634FF1DCA5738BBD6EF5027E78D2343F7094A09B8D0E393F01AB5C15F0A53B362DE2BC9316489EEB09C5";
  private static final String BALTIMORE_CYBER_TRUST_ROOT_ENCRYPTED = "FA12114F31C9F11E3DACDB9AFE040C6292C86C0A0562599C1A453DD8A5E1B951867BF1884FF02526386256085B4E63FD";
  private static final List<RootCA> CERTIFICATES;
  private static final List<String> CERTIFICATES_ENC_HASH;
  private static final List<byte[]> CERTIFICATES_HASH;
  private static final String COMODO_RSA_CERTIFICATION_AUTHORITY_ENCRYPTED = "404588F935078F6C1F8A7F1935299B1E807C6EFAEFF82CB5539CF7D388C293F2970477E1466DB8CA5B97CF83D378C08D";
  private static final String DIGICERT_HIGH_ASSURANCE_EV_ROOT_CA_ENCRYPTED = "B8A280C9AD5C97D65F7E477BC905E2EB404DEEBA06AD711AE0A8AA57E87E5AB16DB49633957F9C78DF1B6259E1B1768C";
  private static final String EQUIFAX_SECURE_CERTIFICATE_AUTHORITY_ENCRYPTED = "97AA8B31969719C504E11562F0F56255898A2B8CAADDAD7E54E492ACB9581F9AA07655FBF41DC268C231CF576934A7ED";
  private static final String GLOBAL_SIGN_ROOT_CA_ENCRYPTED = "7025885C622EB7FF3273EE6103100D98343D0A1EA6600224ABD3CA55770EA2B1166A1F013EEECC5CCF3FD239D54D6E4E";
  private static final String GO_DADDY_ROOT_CERTIFICATE_AUTHORITY_G2_ENCRYPTED = "382E746A02A5E1EC11D382A329FDDC16D28B750B1EBD3F591A097290EBB4B0C0696E6AD72C2C452AEDDF1C289102C4CD";
  private static final String GO_DADDY_SECURE_CERTIFICATE_AUTHORITY_G2_ENCRYPTED = "68D0068C816BE8325B08D37BB382D297E92E680B0FA8A8C325C8230ED9E44EE2888A8ADB85051A7A06068AF5A0110667";
  private static final List<RevokedCert> REVOKED_CERTIFICATES;
  private static final String SFSROOTCAG2_ENCRYPTED = "F93B086741B5270260C1BCE205A9F94F5FE3C3E31F1FBAD699ED216499803B5956BD6598AAB2A47B9348D6083FAE6BF4";
  private static final String STARFIELD_SERVICES_ROOT_CERTIFICATE_AUTHORITY_ENCRYPTED = "F93B086741B5270260C1BCE205A9F94F5FE3C3E31F1FBAD699ED216499803B5956BD6598AAB2A47B9348D6083FAE6BF4";
  private static final String STARFIELD_SERVICES_ROOT_CERTIFICATE_AUTHORITY_G2_INTERMEDIATE_ENCRYPTED = "483FB97E77E35061D10EC66EEA4BE90BC845FD5BB78A0C1E532E8B4B5813E79EA232ED872094511447E9F2B3D0CB14F0";
  private static final String TAG = HttpsHelper.class.getSimpleName();
  private static boolean sInit = false;
  private static KeyStore sKeyStore;
  private static List<X509Certificate> sRevokedCerts;
  private static List<X509Certificate> sRootCerts;
  
  static
  {
    CERTIFICATES = new ArrayList();
    REVOKED_CERTIFICATES = new ArrayList();
    CERTIFICATES_HASH = new ArrayList();
    CERTIFICATES_ENC_HASH = new ArrayList();
    sRootCerts = new ArrayList();
    sRevokedCerts = new ArrayList();
    Object localObject1 = RootCA.values();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = localObject1[i];
      CERTIFICATES.add(localObject2);
      i += 1;
    }
    localObject1 = RevokedCert.values();
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      REVOKED_CERTIFICATES.add(localObject2);
      i += 1;
    }
    Object localObject3;
    try
    {
      localObject1 = KeyStore.getInstance("AndroidKeyStore");
      sKeyStore = (KeyStore)localObject1;
      ((KeyStore)localObject1).load(null);
      localObject1 = CERTIFICATES.iterator();
      for (;;)
      {
        boolean bool = ((Iterator)localObject1).hasNext();
        if (!bool) {
          break;
        }
        localObject2 = (RootCA)((Iterator)localObject1).next();
        localObject3 = new ByteArrayInputStream(((RootCA)localObject2).certificate.getBytes());
        localObject3 = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate((InputStream)localObject3);
        sRootCerts.add(localObject3);
        sKeyStore.setCertificateEntry(((RootCA)localObject2).alias, (Certificate)localObject3);
      }
      localObject1 = REVOKED_CERTIFICATES.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = new ByteArrayInputStream(((RevokedCert)((Iterator)localObject1).next()).certificate.getBytes());
        localObject2 = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate((InputStream)localObject2);
        sRevokedCerts.add(localObject2);
      }
      sInit = true;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    catch (KeyStoreException localKeyStoreException)
    {
      localKeyStoreException.printStackTrace();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    catch (CertificateException localCertificateException)
    {
      localCertificateException.printStackTrace();
    }
    CERTIFICATES_ENC_HASH.add("7025885C622EB7FF3273EE6103100D98343D0A1EA6600224ABD3CA55770EA2B1166A1F013EEECC5CCF3FD239D54D6E4E");
    CERTIFICATES_ENC_HASH.add("404588F935078F6C1F8A7F1935299B1E807C6EFAEFF82CB5539CF7D388C293F2970477E1466DB8CA5B97CF83D378C08D");
    CERTIFICATES_ENC_HASH.add("B8A280C9AD5C97D65F7E477BC905E2EB404DEEBA06AD711AE0A8AA57E87E5AB16DB49633957F9C78DF1B6259E1B1768C");
    CERTIFICATES_ENC_HASH.add("382E746A02A5E1EC11D382A329FDDC16D28B750B1EBD3F591A097290EBB4B0C0696E6AD72C2C452AEDDF1C289102C4CD");
    CERTIFICATES_ENC_HASH.add("F93B086741B5270260C1BCE205A9F94F5FE3C3E31F1FBAD699ED216499803B5956BD6598AAB2A47B9348D6083FAE6BF4");
    CERTIFICATES_ENC_HASH.add("483FB97E77E35061D10EC66EEA4BE90BC845FD5BB78A0C1E532E8B4B5813E79EA232ED872094511447E9F2B3D0CB14F0");
    CERTIFICATES_ENC_HASH.add("68D0068C816BE8325B08D37BB382D297E92E680B0FA8A8C325C8230ED9E44EE2888A8ADB85051A7A06068AF5A0110667");
    CERTIFICATES_ENC_HASH.add("97AA8B31969719C504E11562F0F56255898A2B8CAADDAD7E54E492ACB9581F9AA07655FBF41DC268C231CF576934A7ED");
    CERTIFICATES_ENC_HASH.add("AAA456F5C893695F977D5FFABE8DEEF82BC1799FC91EE0AF0FDB5DC42BAC4827320354B37DF55FD1652753684168D043");
    CERTIFICATES_ENC_HASH.add("420808630125CC03FBA09E86F2C896349930DD1300396E51D89FA041BDF1E2714F9B717A64D833E77E3E241E966D20B1");
    CERTIFICATES_ENC_HASH.add("18C0B1AC417F72ABBCFEA962E20591DBEC242881092E034C72F03E8C77BB1607E6BDD8386CDD535F91A0692311B27141");
    CERTIFICATES_ENC_HASH.add("01B17E2FDEC3634FF1DCA5738BBD6EF5027E78D2343F7094A09B8D0E393F01AB5C15F0A53B362DE2BC9316489EEB09C5");
    CERTIFICATES_ENC_HASH.add("FA12114F31C9F11E3DACDB9AFE040C6292C86C0A0562599C1A453DD8A5E1B951867BF1884FF02526386256085B4E63FD");
    CERTIFICATES_ENC_HASH.add("F93B086741B5270260C1BCE205A9F94F5FE3C3E31F1FBAD699ED216499803B5956BD6598AAB2A47B9348D6083FAE6BF4");
    Iterator localIterator = CERTIFICATES_ENC_HASH.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = WhiteBoxAES.decryptFromWhiteBox(WhiteBoxAES.hex2byte((String)localIterator.next()));
      CERTIFICATES_HASH.add(localObject2);
    }
    localIterator = CERTIFICATES.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = sha256(((RootCA)localIterator.next()).certificate);
      localObject3 = CERTIFICATES_HASH.iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (Arrays.equals((byte[])((Iterator)localObject3).next(), (byte[])localObject2))
        {
          i = 1;
          break label638;
        }
      }
      i = 0;
      label638:
      if (i == 0) {
        throw new IllegalStateException("Invalid certificate in trust anchors.");
      }
    }
  }
  
  private static void checkCondition()
  {
    if (sInit) {
      return;
    }
    throw new IllegalStateException("Https context is not inited yet. Call HttpsHelper.loadCertificate() first");
  }
  
  public static org.apache.http.conn.ssl.SSLSocketFactory getDJISSLSocketFactoryForApache()
  {
    
    try
    {
      DJISSLSocketFactory localDJISSLSocketFactory = new DJISSLSocketFactory(sKeyStore);
      return localDJISSLSocketFactory;
    }
    catch (KeyManagementException localKeyManagementException)
    {
      localKeyManagementException.printStackTrace();
    }
    catch (UnrecoverableKeyException localUnrecoverableKeyException)
    {
      localUnrecoverableKeyException.printStackTrace();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    catch (KeyStoreException localKeyStoreException)
    {
      localKeyStoreException.printStackTrace();
    }
    return null;
  }
  
  public static javax.net.ssl.SSLSocketFactory getDJISSLSocketFactoryForJavax()
  {
    Object localObject = TrustManagerFactory.getDefaultAlgorithm();
    try
    {
      localObject = TrustManagerFactory.getInstance((String)localObject);
      ((TrustManagerFactory)localObject).init(sKeyStore);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, (TrustManager[])localObject, new SecureRandom());
      localObject = new DJISSLSocketFactoryJavaX(localSSLContext.getSocketFactory());
      return (javax.net.ssl.SSLSocketFactory)localObject;
    }
    catch (KeyManagementException localKeyManagementException)
    {
      localKeyManagementException.printStackTrace();
      return null;
    }
    catch (KeyStoreException localKeyStoreException)
    {
      localKeyStoreException.printStackTrace();
      return null;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return null;
  }
  
  public static List<X509Certificate> getRootCerts()
  {
    checkCondition();
    return sRootCerts;
  }
  
  public static DJIX509TrustManager getTrustManager()
  {
    try
    {
      DJIX509TrustManager localDJIX509TrustManager = new DJIX509TrustManager(sKeyStore);
      return localDJIX509TrustManager;
    }
    catch (NoSuchAlgorithmException|KeyStoreException localNoSuchAlgorithmException)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static byte[] sha256(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramString.getBytes());
      paramString = localMessageDigest.digest();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static final class DJISSLSocketFactory
    extends org.apache.http.conn.ssl.SSLSocketFactory
  {
    static final HostnameVerifier hostnameVerifier = new StrictHostnameVerifier();
    private KeyStore mKeystore;
    private SSLContext mSslContext;
    
    public DJISSLSocketFactory(KeyStore paramKeyStore)
      throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
      super();
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      this.mSslContext = localSSLContext;
      this.mKeystore = paramKeyStore;
      paramKeyStore = new HttpsHelper.DJIX509TrustManager(paramKeyStore);
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, new TrustManager[] { paramKeyStore }, localSecureRandom);
    }
    
    public Socket createSocket()
      throws IOException
    {
      return null;
    }
    
    public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
      throws IOException
    {
      return null;
    }
  }
  
  private static final class DJISSLSocketFactoryJavaX
    extends javax.net.ssl.SSLSocketFactory
  {
    final javax.net.ssl.SSLSocketFactory delegate;
    
    public DJISSLSocketFactoryJavaX(javax.net.ssl.SSLSocketFactory paramSSLSocketFactory)
    {
      this.delegate = paramSSLSocketFactory;
    }
    
    private Socket patch(Socket paramSocket)
    {
      return null;
    }
    
    public Socket createSocket(String paramString, int paramInt)
      throws IOException
    {
      return null;
    }
    
    public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
      throws IOException
    {
      return null;
    }
    
    public Socket createSocket(InetAddress paramInetAddress, int paramInt)
      throws IOException
    {
      return null;
    }
    
    public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
      throws IOException
    {
      return null;
    }
    
    public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
      throws IOException
    {
      return null;
    }
    
    public String[] getDefaultCipherSuites()
    {
      return this.delegate.getDefaultCipherSuites();
    }
    
    public String[] getSupportedCipherSuites()
    {
      return this.delegate.getSupportedCipherSuites();
    }
  }
  
  private static final class DJIX509TrustManager
    implements X509TrustManager
  {
    private X509TrustManager defaultTM = null;
    
    public DJIX509TrustManager(KeyStore paramKeyStore)
      throws NoSuchAlgorithmException, KeyStoreException
    {
      TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      localTrustManagerFactory.init(paramKeyStore);
      paramKeyStore = localTrustManagerFactory.getTrustManagers();
      if ((paramKeyStore != null) && (paramKeyStore.length > 0))
      {
        this.defaultTM = findTrustManager(paramKeyStore);
        return;
      }
      throw new NoSuchAlgorithmException("no trust manager found");
    }
    
    private X509TrustManager findTrustManager(TrustManager[] paramArrayOfTrustManager)
    {
      return null;
    }
    
    /* Error */
    private void searchCertificateRevocationList(X509Certificate[] arg1)
      throws java.security.cert.CertificateNotYetValidException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private boolean searchRootCert(X509Certificate paramX509Certificate)
    {
      return false;
    }
    
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      X509TrustManager localX509TrustManager = this.defaultTM;
      if (localX509TrustManager != null) {
        localX509TrustManager.checkClientTrusted(paramArrayOfX509Certificate, paramString);
      }
    }
    
    /* Error */
    public void checkServerTrusted(X509Certificate[] arg1, String arg2)
      throws CertificateException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return null;
    }
  }
  
  public static enum RevokedCert
  {
    private String alias;
    private String certificate;
    
    static
    {
      RevokedCert localRevokedCert = new RevokedCert("REVOKED_DJI", 0, "REVOKED_DJI", "-----BEGIN CERTIFICATE-----\nMIIHPjCCBiagAwIBAgIMWubaiw248B8E9jv7MA0GCSqGSIb3DQEBCwUAMEwxCzAJ\nBgNVBAYTAkJFMRkwFwYDVQQKExBHbG9iYWxTaWduIG52LXNhMSIwIAYDVQQDExlB\nbHBoYVNTTCBDQSAtIFNIQTI1NiAtIEcyMB4XDTE3MDYwNDEwMDAzMloXDTE4MDYw\nNTEwMDAzMlowNzEhMB8GA1UECxMYRG9tYWluIENvbnRyb2wgVmFsaWRhdGVkMRIw\nEAYDVQQDDAkqLmRqaS5jb20wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIB\nAQD5UuubTPqdEFtkvIhHbL999mlOncU7E9d1CTCllzUPso3Xo6KWHydK+YDGCtYP\nbyUuRGNnXkzz6U3TC9Nqh3n67BKYm3mKKzas8sDucdHTg4V36Xoors6HNgh/S3Pe\nDjUVktJlIrVhhTMboG7E3cv63a9kNofukyOxPSW8YKfK+GYz8KrSQ1aGK4CE79iH\n2QR/pPr4JRDyDpDo7G4+mQjrVovHz7UXMgONJV2527gnIGtfcGFdxCZweSF4gBWV\ni2ZrNzZKyMDJ07wMy7SSa0rUw7zoH6Dgbob+VBH4JUPSXgrlpIGSL9FCxBpMXAKK\n0bucyBRj7LBSqVJCunMhoPGNAgMBAAGjggQzMIIELzAOBgNVHQ8BAf8EBAMCBaAw\ngYkGCCsGAQUFBwEBBH0wezBCBggrBgEFBQcwAoY2aHR0cDovL3NlY3VyZTIuYWxw\naGFzc2wuY29tL2NhY2VydC9nc2FscGhhc2hhMmcycjEuY3J0MDUGCCsGAQUFBzAB\nhilodHRwOi8vb2NzcDIuZ2xvYmFsc2lnbi5jb20vZ3NhbHBoYXNoYTJnMjBXBgNV\nHSAEUDBOMEIGCisGAQQBoDIBCgowNDAyBggrBgEFBQcCARYmaHR0cHM6Ly93d3cu\nZ2xvYmFsc2lnbi5jb20vcmVwb3NpdG9yeS8wCAYGZ4EMAQIBMAkGA1UdEwQCMAAw\nPgYDVR0fBDcwNTAzoDGgL4YtaHR0cDovL2NybDIuYWxwaGFzc2wuY29tL2dzL2dz\nYWxwaGFzaGEyZzIuY3JsMB0GA1UdEQQWMBSCCSouZGppLmNvbYIHZGppLmNvbTAd\nBgNVHSUEFjAUBggrBgEFBQcDAQYIKwYBBQUHAwIwHQYDVR0OBBYEFLK7Uv6NQDk2\nnwivFf4WyHVYI8t9MB8GA1UdIwQYMBaAFPXN1TwIUPlqTzq3l9pWg+Zp0mj3MIIC\nbQYKKwYBBAHWeQIEAgSCAl0EggJZAlcAdwDd6x0reg1PpiCLga2BaHB+Lo6dAdVc\niI09EcTNtuy+zAAAAVxyjJIqAAAEAwBIMEYCIQCksVJcJhh2kjX6uObRNS0tH84M\nrHkjdrPMDZcCb7WKsQIhAPtqI206ksF3pArbVNxmNIjGkCBu5zhOgaaXBlltrvHo\nAHUApLkJkLQYWBSHuxOizGdwCjw1mAT5G9+443fNDsgN3BAAAAFccoySLQAABAMA\nRjBEAiBtebn2JimmAQ6mSdbejyQXtjMKNKTVIPf1FEJzpbA3HQIgBb42ymO6WQFf\nNdudwlbRufF7eN1KJo6mwvMzHgkdw48AdQBWFAaaL9fC7NP14b1Esj7HRna5vJkR\nXMDvlJhV1onQ3QAAAVxyjJJMAAAEAwBGMEQCIDA2gYzjc1AlS+EpW/33MBb2587E\n21V7lNScf6vYOVDNAiA0TdQ4KUVIXYo0KtBrqhLyFSdHQEiqR/2D3F4RJ2nYKwB2\nALvZ37wfinG1k5Qjl6qSe0c4V5UKq1LoGpCWZDaOHtGFAAABXHKMkvkAAAQDAEcw\nRQIgAUj70Of2kp/QJ4nfvCnWP3v9Ne5IXX3+OGcupeZugWYCIQDSeTvKRb7tsP8P\nubGTorpVOM11AKlZdDwTWarYlSSN6wB2AO5Lvbd1zmC64UJpH6vhnmajD35fsHLY\ngwDEe4l6qP3LAAABXHKMlVYAAAQDAEcwRQIhAKlwIpKCqc3/Evka9alOrMZWvSeS\nXvpAZt8MB4PV6uM0AiBXA4VfuaCoXtEbYRNESvLCqvwNA2J9Dhgw67v7KaZZNTAN\nBgkqhkiG9w0BAQsFAAOCAQEArKAniBPPdrMFsd40h3vD4Oka04XabrAOqI/rG2zv\n99YCWQFHLNjnVa13IKgg6Wc9B4fG6ARtQHVz/vfzsGPnq1oxZy9fRF6VC2kJVu/X\nZyFWFBGZQYBeJ24WFMR4rIz9ibzlaVlD4W6b8tdBuVIu8ymAza45NNT7R3p0i5Ve\noZJIpF7F/Lj5ggzU5i1FZyFGqzuLhRZJK8fTs7HiERQjCXKKxc9u2L3QtFd0CqVt\nCt3zRP4GK128aeBPs/KN2A94OafUvrfo69jAdyUgD7isclGKPonfRKvp4nStjhnb\n9eNgA4rgl4jpajuwPTWZB9cCXTOB4dxbYUSVaGq9sWkCwQ==\n-----END CERTIFICATE-----");
      REVOKED_DJI = localRevokedCert;
      $VALUES = new RevokedCert[] { localRevokedCert };
    }
    
    private RevokedCert(String paramString1, String paramString2)
    {
      this.alias = paramString1;
      this.certificate = paramString2;
    }
  }
  
  public static enum RootCA
  {
    private String alias;
    private String certificate;
    
    static
    {
      COMODO_RSA_CERTIFICATION_AUTHORITY = new RootCA("COMODO_RSA_CERTIFICATION_AUTHORITY", 1, "COMODO_RSA_CERTIFICATION_AUTHORITY", "-----BEGIN CERTIFICATE-----\nMIIF2DCCA8CgAwIBAgIQTKr5yttjb+Af907YWwOGnTANBgkqhkiG9w0BAQwFADCB\nhTELMAkGA1UEBhMCR0IxGzAZBgNVBAgTEkdyZWF0ZXIgTWFuY2hlc3RlcjEQMA4G\nA1UEBxMHU2FsZm9yZDEaMBgGA1UEChMRQ09NT0RPIENBIExpbWl0ZWQxKzApBgNV\nBAMTIkNPTU9ETyBSU0EgQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkwHhcNMTAwMTE5\nMDAwMDAwWhcNMzgwMTE4MjM1OTU5WjCBhTELMAkGA1UEBhMCR0IxGzAZBgNVBAgT\nEkdyZWF0ZXIgTWFuY2hlc3RlcjEQMA4GA1UEBxMHU2FsZm9yZDEaMBgGA1UEChMR\nQ09NT0RPIENBIExpbWl0ZWQxKzApBgNVBAMTIkNPTU9ETyBSU0EgQ2VydGlmaWNh\ndGlvbiBBdXRob3JpdHkwggIiMA0GCSqGSIb3DQEBAQUAA4ICDwAwggIKAoICAQCR\n6FSS0gpWsawNJN3Fz0RndJkrN6N9I3AAcbxT38T6KhKPS38QVr2fcHK3YX/JSw8X\npz3jsARh7v8Rl8f0hj4K+j5c+ZPmNHrZFGvnnLOFoIJ6dq9xkNfs/Q36nGz637CC\n9BR++b7Epi9Pf5l/tfxnQ3K9DADWietrLNPtj5gcFKt+5eNu/Nio5JIk2kNrYrhV\n/erBvGy2i/MOjZrkm2xpmfh4SDBF1a3hDTxFYPwyllEnvGfDyi62a+pGx8cgoLEf\nZd5ICLqkTqnyg0Y3hOvozIFIQ2dOciqbXL1MGyiKXCJ7tKuY2e7gUYPDCUZObT6Z\n+pUX2nwzV0E8jVHtC7ZcryxjGt9XyD+86V3Em69FmeKjWiS0uqlWPc9vqv9JWL7w\nqP/0uK3pN/u6uPQLOvnoQ0IeidiEyxPx2bvhiWC4jChWrBQdnArncevPDt09qZah\nSL0896+1DSJMwBGB7FY79tOi4lu3sgQiUpWAk2nojkxl8ZEDLXB0AuqLZxUpaVIC\nu9ffUGpVRr+goyhhf3DQw6KqLCGqR84onAZFdr+CGCe01a60y1Dma/RMhnEw6abf\nFobg2P9A3fvQQoh/ozM6LlweQRGBY84YcWsr7KaKtzFcOmpH4MN5WdYgGq/yapiq\ncrxXStJLnbsQ/LBMQeXtHT1eKJ2czL+zUdqnR+WEUwIDAQABo0IwQDAdBgNVHQ4E\nFgQUu69+Aj36pvE8hI6t7jiY7NkyMtQwDgYDVR0PAQH/BAQDAgEGMA8GA1UdEwEB\n/wQFMAMBAf8wDQYJKoZIhvcNAQEMBQADggIBAArx1UaEt65Ru2yyTUEUAJNMnMvl\nwFTPoCWOAvn9sKIN9SCYPBMtrFaisNZ+EZLpLrqeLppysb0ZRGxhNaKatBYSaVqM\n4dc+pBroLwP0rmEdEBsqpIt6xf4FpuHA1sj+nq6PK7o9mfjYcwlYRm6mnPTXJ9OV\n2jeDchzTc+CiR5kDOF3VSXkAKRzH7JsgHAckaVd4sjn8OoSgtZx8jb8uk2Intzna\nFxiuvTwJaP+EmzzV1gsD41eeFPfR60/IvYcjt7ZJQ3mFXLrrkguhxuhoqEwWsRqZ\nCuhTLJK7oQkYdQxlqHvLI7cawiiFwxv/0Cti76R7CZGYZ4wUAc1oBmpjIXUDgIiK\nboHGhfKppC3n9KUkEEeDys30jXlYsQab5xoq2Z0B15R97QNKyvDb6KkBPvVWmcke\njkk9u+UJueBPSZI9FoJAzMxZxuY67RIuaTxslbH9qh17f4a+Hg4yRvv7E491f0yL\nS0Zj/gA0QHDBw7mh3aZw4gSzQbzpgJHqZJx64SIDqZxubw5lT2yHh17zbqD5daWb\nQOhTsiedSrnAdyGN/4fy3ryM7xfft0kL0fJuMAsaDk527RH89elWsn2/x20Kk4yl\n0MC2Hb46TpSi125sC8KKfPog88Tk5c0NqMuRkrF8hey1FGlmDoLnzc7ILaZRfyHB\nNVOFBkpdn627G190\n-----END CERTIFICATE-----");
      DIGICERT_HIGH_ASSURANCE_EV_ROOT_CA = new RootCA("DIGICERT_HIGH_ASSURANCE_EV_ROOT_CA", 2, "DIGICERT_HIGH_ASSURANCE_EV_ROOT_CA", "-----BEGIN CERTIFICATE-----\nMIIDxTCCAq2gAwIBAgIQAqxcJmoLQJuPC3nyrkYldzANBgkqhkiG9w0BAQUFADBs\nMQswCQYDVQQGEwJVUzEVMBMGA1UEChMMRGlnaUNlcnQgSW5jMRkwFwYDVQQLExB3\nd3cuZGlnaWNlcnQuY29tMSswKQYDVQQDEyJEaWdpQ2VydCBIaWdoIEFzc3VyYW5j\nZSBFViBSb290IENBMB4XDTA2MTExMDAwMDAwMFoXDTMxMTExMDAwMDAwMFowbDEL\nMAkGA1UEBhMCVVMxFTATBgNVBAoTDERpZ2lDZXJ0IEluYzEZMBcGA1UECxMQd3d3\nLmRpZ2ljZXJ0LmNvbTErMCkGA1UEAxMiRGlnaUNlcnQgSGlnaCBBc3N1cmFuY2Ug\nRVYgUm9vdCBDQTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAMbM5XPm\n+9S75S0tMqbf5YE/yc0lSbZxKsPVlDRnogocsF9ppkCxxLeyj9CYpKlBWTrT3JTW\nPNt0OKRKzE0lgvdKpVMSOO7zSW1xkX5jtqumX8OkhPhPYlG++MXs2ziS4wblCJEM\nxChBVfvLWokVfnHoNb9Ncgk9vjo4UFt3MRuNs8ckRZqnrG0AFFoEt7oT61EKmEFB\nIk5lYYeBQVCmeVyJ3hlKV9Uu5l0cUyx+mM0aBhakaHPQNAQTXKFx01p8VdteZOE3\nhzBWBOURtCmAEvF5OYiiAhF8J2a3iLd48soKqDirCmTCv2ZdlYTBoSUeh10aUAsg\nEsxBu24LUTi4S8sCAwEAAaNjMGEwDgYDVR0PAQH/BAQDAgGGMA8GA1UdEwEB/wQF\nMAMBAf8wHQYDVR0OBBYEFLE+w2kD+L9HAdSYJhoIAu9jZCvDMB8GA1UdIwQYMBaA\nFLE+w2kD+L9HAdSYJhoIAu9jZCvDMA0GCSqGSIb3DQEBBQUAA4IBAQAcGgaX3Nec\nnzyIZgYIVyHbIUf4KmeqvxgydkAQV8GK83rZEWWONfqe/EW1ntlMMUu4kehDLI6z\neM7b41N5cdblIZQB2lWHmiRk9opmzN6cN82oNLFpmyPInngiK3BD41VHMWEZ71jF\nhS9OMPagMRYjyOfiZRYzy78aG6A9+MpeizGLYAiJLQwGXFK3xPkKmNEVX58Svnw2\nYzi9RKR/5CYrCsSXaQ3pjOLAEFe4yHYSkVXySGnYvCoCWw9E1CAx2/S6cCZdkGCe\nvEsXCS+0yx5DaMkHJ8HSXPfqIbloEpw8nL+e/IBcm2PN7EeqJSdnoDfzAIJ9VNep\n+OkuE6N36B9K\n-----END CERTIFICATE-----");
      GO_DADDY_ROOT_CERTIFICATE_AUTHORITY_G2 = new RootCA("GO_DADDY_ROOT_CERTIFICATE_AUTHORITY_G2", 3, "GO_DADDY_ROOT_CERTIFICATE_AUTHORITY_G2", "-----BEGIN CERTIFICATE-----\nMIIDxTCCAq2gAwIBAgIBADANBgkqhkiG9w0BAQsFADCBgzELMAkGA1UEBhMCVVMx\nEDAOBgNVBAgTB0FyaXpvbmExEzARBgNVBAcTClNjb3R0c2RhbGUxGjAYBgNVBAoT\nEUdvRGFkZHkuY29tLCBJbmMuMTEwLwYDVQQDEyhHbyBEYWRkeSBSb290IENlcnRp\nZmljYXRlIEF1dGhvcml0eSAtIEcyMB4XDTA5MDkwMTAwMDAwMFoXDTM3MTIzMTIz\nNTk1OVowgYMxCzAJBgNVBAYTAlVTMRAwDgYDVQQIEwdBcml6b25hMRMwEQYDVQQH\nEwpTY290dHNkYWxlMRowGAYDVQQKExFHb0RhZGR5LmNvbSwgSW5jLjExMC8GA1UE\nAxMoR28gRGFkZHkgUm9vdCBDZXJ0aWZpY2F0ZSBBdXRob3JpdHkgLSBHMjCCASIw\nDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAL9xYgjx+lk09xvJGKP3gElY6SKD\nE6bFIEMBO4Tx5oVJnyfq9oQbTqC023CYxzIBsQU+B07u9PpPL1kwIuerGVZr4oAH\n/PMWdYA5UXvl+TW2dE6pjYIT5LY/qQOD+qK+ihVqf94Lw7YZFAXK6sOoBJQ7Rnwy\nDfMAZiLIjWltNowRGLfTshxgtDj6AozO091GB94KPutdfMh8+7ArU6SSYmlRJQVh\nGkSBjCypQ5Yj36w6gZoOKcUcqeldHraenjAKOc7xiID7S13MMuyFYkMlNAJWJwGR\ntDtwKj9useiciAF9n9T521NtYJ2/LOdYq7hfRvzOxBsDPAnrSTFcaUaz4EcCAwEA\nAaNCMEAwDwYDVR0TAQH/BAUwAwEB/zAOBgNVHQ8BAf8EBAMCAQYwHQYDVR0OBBYE\nFDqahQcQZyi27/a9BUFuIMGU2g/eMA0GCSqGSIb3DQEBCwUAA4IBAQCZ21151fmX\nWWcDYfF+OwYxdS2hII5PZYe096acvNjpL9DbWu7PdIxztDhC2gV7+AJ1uP2lsdeu\n9tfeE8tTEH6KRtGX+rcuKxGrkLAngPnon1rpN5+r5N9ss4UXnT3ZJE95kTXWXwTr\ngIOrmgIttRD02JDHBHNA7XIloKmf7J6raBKZV8aPEjoJpL1E/QYVN8Gb5DKj7Tjo\n2GTzLH4U/ALqn83/B2gX2yKQOC16jdFU8WnjXzPKej17CuPKf1855eJ1usV2GDPO\nLPAvTK33sefOT6jEm0pUBsV/fdUID+Ic/n4XuKxe9tQWskMJDE32p2u0mYRlynqI\n4uJEvlz36hz1\n-----END CERTIFICATE-----");
      GO_DADDY_SECURE_CERTIFICATE_AUTHORITY_G2 = new RootCA("GO_DADDY_SECURE_CERTIFICATE_AUTHORITY_G2", 4, "GO_DADDY_SECURE_CERTIFICATE_AUTHORITY_G2", "-----BEGIN CERTIFICATE-----\nMIIE0DCCA7igAwIBAgIBBzANBgkqhkiG9w0BAQsFADCBgzELMAkGA1UEBhMCVVMx\nEDAOBgNVBAgTB0FyaXpvbmExEzARBgNVBAcTClNjb3R0c2RhbGUxGjAYBgNVBAoT\nEUdvRGFkZHkuY29tLCBJbmMuMTEwLwYDVQQDEyhHbyBEYWRkeSBSb290IENlcnRp\nZmljYXRlIEF1dGhvcml0eSAtIEcyMB4XDTExMDUwMzA3MDAwMFoXDTMxMDUwMzA3\nMDAwMFowgbQxCzAJBgNVBAYTAlVTMRAwDgYDVQQIEwdBcml6b25hMRMwEQYDVQQH\nEwpTY290dHNkYWxlMRowGAYDVQQKExFHb0RhZGR5LmNvbSwgSW5jLjEtMCsGA1UE\nCxMkaHR0cDovL2NlcnRzLmdvZGFkZHkuY29tL3JlcG9zaXRvcnkvMTMwMQYDVQQD\nEypHbyBEYWRkeSBTZWN1cmUgQ2VydGlmaWNhdGUgQXV0aG9yaXR5IC0gRzIwggEi\nMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQC54MsQ1K92vdSTYuswZLiBCGzD\nBNliF44v/z5lz4/OYuY8UhzaFkVLVat4a2ODYpDOD2lsmcgaFItMzEUz6ojcnqOv\nK/6AYZ15V8TPLvQ/MDxdR/yaFrzDN5ZBUY4RS1T4KL7QjL7wMDge87Am+GZHY23e\ncSZHjzhHU9FGHbTj3ADqRay9vHHZqm8A29vNMDp5T19MR/gd71vCxJ1gO7GyQ5HY\npDNO6rPWJ0+tJYqlxvTV0KaudAVkV4i1RFXULSo6Pvi4vekyCgKUZMQWOlDxSq7n\neTOvDCAHf+jfBDnCaQJsY1L6d8EbyHSHyLmTGFBUNUtpTrw700kuH9zB0lL7AgMB\nAAGjggEaMIIBFjAPBgNVHRMBAf8EBTADAQH/MA4GA1UdDwEB/wQEAwIBBjAdBgNV\nHQ4EFgQUQMK9J47MNIMwojPX+2yz8LQsgM4wHwYDVR0jBBgwFoAUOpqFBxBnKLbv\n9r0FQW4gwZTaD94wNAYIKwYBBQUHAQEEKDAmMCQGCCsGAQUFBzABhhhodHRwOi8v\nb2NzcC5nb2RhZGR5LmNvbS8wNQYDVR0fBC4wLDAqoCigJoYkaHR0cDovL2NybC5n\nb2RhZGR5LmNvbS9nZHJvb3QtZzIuY3JsMEYGA1UdIAQ/MD0wOwYEVR0gADAzMDEG\nCCsGAQUFBwIBFiVodHRwczovL2NlcnRzLmdvZGFkZHkuY29tL3JlcG9zaXRvcnkv\nMA0GCSqGSIb3DQEBCwUAA4IBAQAIfmyTEMg4uJapkEv/oV9PBO9sPpyIBslQj6Zz\n91cxG7685C/b+LrTW+C05+Z5Yg4MotdqY3MxtfWoSKQ7CC2iXZDXtHwlTxFWMMS2\nRJ17LJ3lXubvDGGqv+QqG+6EnriDfcFDzkSnE3ANkR/0yBOtg2DZ2HKocyQetawi\nDsoXiWJYRBuriSUBAA/NxBti21G00w9RKpv0vHP8ds42pM3Z2Czqrpv1KrKQ0U11\nGIo/ikGQI31bS/6kA1ibRrLDYGCD+H1QQc7CoZDDu+8CL9IVVO5EFdkKrqeKM+2x\nLXY2JtwE65/3YR8V3Idv7kaWKK2hJn0KCacuBKONvPi8BDAB\n-----END CERTIFICATE-----");
      STARFIELD_SERVICES_ROOT_CERTIFICATE_AUTHORITY = new RootCA("STARFIELD_SERVICES_ROOT_CERTIFICATE_AUTHORITY", 5, "STARFIELD_SERVICES_ROOT_CERTIFICATE_AUTHORITY", "-----BEGIN CERTIFICATE-----\nMIID7zCCAtegAwIBAgIBADANBgkqhkiG9w0BAQsFADCBmDELMAkGA1UEBhMCVVMx\nEDAOBgNVBAgTB0FyaXpvbmExEzARBgNVBAcTClNjb3R0c2RhbGUxJTAjBgNVBAoT\nHFN0YXJmaWVsZCBUZWNobm9sb2dpZXMsIEluYy4xOzA5BgNVBAMTMlN0YXJmaWVs\nZCBTZXJ2aWNlcyBSb290IENlcnRpZmljYXRlIEF1dGhvcml0eSAtIEcyMB4XDTA5\nMDkwMTAwMDAwMFoXDTM3MTIzMTIzNTk1OVowgZgxCzAJBgNVBAYTAlVTMRAwDgYD\nVQQIEwdBcml6b25hMRMwEQYDVQQHEwpTY290dHNkYWxlMSUwIwYDVQQKExxTdGFy\nZmllbGQgVGVjaG5vbG9naWVzLCBJbmMuMTswOQYDVQQDEzJTdGFyZmllbGQgU2Vy\ndmljZXMgUm9vdCBDZXJ0aWZpY2F0ZSBBdXRob3JpdHkgLSBHMjCCASIwDQYJKoZI\nhvcNAQEBBQADggEPADCCAQoCggEBANUMOsQq+U7i9b4Zl1+OiFOxHz/Lz58gE20p\nOsgPfTz3a3Y4Y9k2YKibXlwAgLIvWX/2h/klQ4bnaRtSmpDhcePYLQ1Ob/bISdm2\n8xpWriu2dBTrz/sm4xq6HZYuajtYlIlHVv8loJNwU4PahHQUw2eeBGg6345AWh1K\nTs9DkTvnVtYAcMtS7nt9rjrnvDH5RfbCYM8TWQIrgMw0R9+53pBlbQLPLJGmpufe\nhRhJfGZOozptqbXuNC66DQO4M99H67FrjSXZm86B0UVGMpZwh94CDklDhbZsc7tk\n6mFBrMnUVN+HL8cisibMn1lUaJ/8viovxFUcdUBgF4UCVTmLfwUCAwEAAaNCMEAw\nDwYDVR0TAQH/BAUwAwEB/zAOBgNVHQ8BAf8EBAMCAQYwHQYDVR0OBBYEFJxfAN+q\nAdcwKziIorhtSpzyEZGDMA0GCSqGSIb3DQEBCwUAA4IBAQBLNqaEd2ndOxmfZyMI\nbw5hyf2E3F/YNoHN2BtBLZ9g3ccaaNnRbobhiCPPE95Dz+I0swSdHynVv/heyNXB\nve6SbzJ08pGCL72CQnqtKrcgfU28elUSwhXqvfdqlS5sdJ/PHLTyxQGjhdByPq1z\nqwubdQxtRbeOlKyWN7Wg0I8VRw7j6IPdj/3vQQF3zCepYoUz8jcI73HPdwbeyBkd\niEDPfUYd/x7H4c7/I9vG+o1VTqkC50cRRj70/b17KSa7qWFiNyi2LSr2EIZkyXCn\n0q23KXB56jzaYyWf/Wi3MOxw+3WKt21gZ7IeyLnp2KhvAotnDU0mV3HaIPzBSlCN\nsSi6\n-----END CERTIFICATE-----");
      STARFIELD_SERVICES_ROOT_CERTIFICATE_AUTHORITY_G2_INTERMEDIATE = new RootCA("STARFIELD_SERVICES_ROOT_CERTIFICATE_AUTHORITY_G2_INTERMEDIATE", 6, "STARFIELD_SERVICES_ROOT_CERTIFICATE_AUTHORITY_G2_INTERMEDIATE", "-----BEGIN CERTIFICATE-----\nMIIEdTCCA12gAwIBAgIJAKcOSkw0grd/MA0GCSqGSIb3DQEBCwUAMGgxCzAJBgNV\nBAYTAlVTMSUwIwYDVQQKExxTdGFyZmllbGQgVGVjaG5vbG9naWVzLCBJbmMuMTIw\nMAYDVQQLEylTdGFyZmllbGQgQ2xhc3MgMiBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0\neTAeFw0wOTA5MDIwMDAwMDBaFw0zNDA2MjgxNzM5MTZaMIGYMQswCQYDVQQGEwJV\nUzEQMA4GA1UECBMHQXJpem9uYTETMBEGA1UEBxMKU2NvdHRzZGFsZTElMCMGA1UE\nChMcU3RhcmZpZWxkIFRlY2hub2xvZ2llcywgSW5jLjE7MDkGA1UEAxMyU3RhcmZp\nZWxkIFNlcnZpY2VzIFJvb3QgQ2VydGlmaWNhdGUgQXV0aG9yaXR5IC0gRzIwggEi\nMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDVDDrEKvlO4vW+GZdfjohTsR8/\ny8+fIBNtKTrID30892t2OGPZNmCom15cAICyL1l/9of5JUOG52kbUpqQ4XHj2C0N\nTm/2yEnZtvMaVq4rtnQU68/7JuMauh2WLmo7WJSJR1b/JaCTcFOD2oR0FMNnngRo\nOt+OQFodSk7PQ5E751bWAHDLUu57fa4657wx+UX2wmDPE1kCK4DMNEffud6QZW0C\nzyyRpqbn3oUYSXxmTqM6bam17jQuug0DuDPfR+uxa40l2ZvOgdFFRjKWcIfeAg5J\nQ4W2bHO7ZOphQazJ1FTfhy/HIrImzJ9ZVGif/L4qL8RVHHVAYBeFAlU5i38FAgMB\nAAGjgfAwge0wDwYDVR0TAQH/BAUwAwEB/zAOBgNVHQ8BAf8EBAMCAYYwHQYDVR0O\nBBYEFJxfAN+qAdcwKziIorhtSpzyEZGDMB8GA1UdIwQYMBaAFL9ft9HO3R+G9FtV\nrNzXEMIOqYjnME8GCCsGAQUFBwEBBEMwQTAcBggrBgEFBQcwAYYQaHR0cDovL28u\nc3MyLnVzLzAhBggrBgEFBQcwAoYVaHR0cDovL3guc3MyLnVzL3guY2VyMCYGA1Ud\nHwQfMB0wG6AZoBeGFWh0dHA6Ly9zLnNzMi51cy9yLmNybDARBgNVHSAECjAIMAYG\nBFUdIAAwDQYJKoZIhvcNAQELBQADggEBACMd44pXyn3pF3lM8R5V/cxTbj5HD9/G\nVfKyBDbtgB9TxF00KGu+x1X8Z+rLP3+QsjPNG1gQggL4+C/1E2DUBc7xgQjB3ad1\nl08YuW3e95ORCLp+QCztweq7dp4zBncdDQh/U90bZKuCJ/Fp1U1ervShw3WnWEQt\n8jxwmKy6abaVd38PMV4s/KCHOkdp8Hlf9BRUpJVeEXgSYCfOn8J3/yNTd126/+pZ\n59vPr5KW7ySaNRB6nJHGDn2Z9j8Z3/VyVOEVqQdZe4O/Ui5GjLIAZHYcSNPYeehu\nVsyuLAOQ1xk4meTKCRlb/weWsKh/NEnfVqn3sF/tM+2MR7cwA130A4w=\n-----END CERTIFICATE-----");
      EQUIFAX_SECURE_CERTIFICATE_AUTHORITY = new RootCA("EQUIFAX_SECURE_CERTIFICATE_AUTHORITY", 7, "EQUIFAX_SECURE_CERTIFICATE_AUTHORITY", "-----BEGIN CERTIFICATE-----\nMIIDIDCCAomgAwIBAgIENd70zzANBgkqhkiG9w0BAQUFADBOMQswCQYDVQQGEwJV\nUzEQMA4GA1UEChMHRXF1aWZheDEtMCsGA1UECxMkRXF1aWZheCBTZWN1cmUgQ2Vy\ndGlmaWNhdGUgQXV0aG9yaXR5MB4XDTk4MDgyMjE2NDE1MVoXDTE4MDgyMjE2NDE1\nMVowTjELMAkGA1UEBhMCVVMxEDAOBgNVBAoTB0VxdWlmYXgxLTArBgNVBAsTJEVx\ndWlmYXggU2VjdXJlIENlcnRpZmljYXRlIEF1dGhvcml0eTCBnzANBgkqhkiG9w0B\nAQEFAAOBjQAwgYkCgYEAwV2xWGcIYu6gmi0fCG2RFGiYCh7+2gRvE4RiIcPRfM6f\nBeC4AfBONOziipUEZKzxa1NfBbPLZ4C/QgKO/t0BCezhABRP/PvwDN1Dulsr4R+A\ncJkVV5MW8Q+XarfCaCMczE1ZMKxRHjuvK9buY0V7xdlfUNLjUA86iOe/FP3gx7kC\nAwEAAaOCAQkwggEFMHAGA1UdHwRpMGcwZaBjoGGkXzBdMQswCQYDVQQGEwJVUzEQ\nMA4GA1UEChMHRXF1aWZheDEtMCsGA1UECxMkRXF1aWZheCBTZWN1cmUgQ2VydGlm\naWNhdGUgQXV0aG9yaXR5MQ0wCwYDVQQDEwRDUkwxMBoGA1UdEAQTMBGBDzIwMTgw\nODIyMTY0MTUxWjALBgNVHQ8EBAMCAQYwHwYDVR0jBBgwFoAUSOZo+SvSspXXR9gj\nIBBPM5iQn9QwHQYDVR0OBBYEFEjmaPkr0rKV10fYIyAQTzOYkJ/UMAwGA1UdEwQF\nMAMBAf8wGgYJKoZIhvZ9B0EABA0wCxsFVjMuMGMDAgbAMA0GCSqGSIb3DQEBBQUA\nA4GBAFjOKer89961zgK5F7WF0bnj4JXMJTENAKaSbn+2kmOeUJXRmm/kEd5jhW6Y\n7qj/WsjTVbJmcVfewCHrPSqnI0kBBIZCe/zuf6IWUrVnZ9NA2zsmWLIodz2uFHdh\n1voqZiegDfqnc1zqcPGUIWVEX/r87yloqaKHee9570+sB3c4\n-----END CERTIFICATE-----");
      AMAZON_ROOT_CA1 = new RootCA("AMAZON_ROOT_CA1", 8, "AMAZON_ROOT_CA1", "-----BEGIN CERTIFICATE-----\nMIIDQTCCAimgAwIBAgITBmyfz5m/jAo54vB4ikPmljZbyjANBgkqhkiG9w0BAQsF\nADA5MQswCQYDVQQGEwJVUzEPMA0GA1UEChMGQW1hem9uMRkwFwYDVQQDExBBbWF6\nb24gUm9vdCBDQSAxMB4XDTE1MDUyNjAwMDAwMFoXDTM4MDExNzAwMDAwMFowOTEL\nMAkGA1UEBhMCVVMxDzANBgNVBAoTBkFtYXpvbjEZMBcGA1UEAxMQQW1hem9uIFJv\nb3QgQ0EgMTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBALJ4gHHKeNXj\nca9HgFB0fW7Y14h29Jlo91ghYPl0hAEvrAIthtOgQ3pOsqTQNroBvo3bSMgHFzZM\n9O6II8c+6zf1tRn4SWiw3te5djgdYZ6k/oI2peVKVuRF4fn9tBb6dNqcmzU5L/qw\nIFAGbHrQgLKm+a/sRxmPUDgH3KKHOVj4utWp+UhnMJbulHheb4mjUcAwhmahRWa6\nVOujw5H5SNz/0egwLX0tdHA114gk957EWW67c4cX8jJGKLhD+rcdqsq08p8kDi1L\n93FcXmn/6pUCyziKrlA4b9v7LWIbxcceVOF34GfID5yHI9Y/QCB/IIDEgEw+OyQm\njgSubJrIqg0CAwEAAaNCMEAwDwYDVR0TAQH/BAUwAwEB/zAOBgNVHQ8BAf8EBAMC\nAYYwHQYDVR0OBBYEFIQYzIU07LwMlJQuCFmcx7IQTgoIMA0GCSqGSIb3DQEBCwUA\nA4IBAQCY8jdaQZChGsV2USggNiMOruYou6r4lK5IpDB/G/wkjUu0yKGX9rbxenDI\nU5PMCCjjmCXPI6T53iHTfIUJrU6adTrCC2qJeHZERxhlbI1Bjjt/msv0tadQ1wUs\nN+gDS63pYaACbvXy8MWy7Vu33PqUXHeeE6V/Uq2V8viTO96LXFvKWlJbYK8U90vv\no/ufQJVtMVT8QtPHRh8jrdkPSHCa2XV4cdFyQzR1bldZwgJcJmApzyMZFo6IQ6XU\n5MsI+yMRQ+hDKXJioaldXgjUkK642M4UwtBV8ob2xJNDd2ZhwLnoQdeXeGADbkpy\nrqXRfboQnoZsG4q5WTP468SQvvG5\n-----END CERTIFICATE-----");
      AMAZON_ROOT_CA2 = new RootCA("AMAZON_ROOT_CA2", 9, "AMAZON_ROOT_CA2", "-----BEGIN CERTIFICATE-----\nMIIFQTCCAymgAwIBAgITBmyf0pY1hp8KD+WGePhbJruKNzANBgkqhkiG9w0BAQwF\nADA5MQswCQYDVQQGEwJVUzEPMA0GA1UEChMGQW1hem9uMRkwFwYDVQQDExBBbWF6\nb24gUm9vdCBDQSAyMB4XDTE1MDUyNjAwMDAwMFoXDTQwMDUyNjAwMDAwMFowOTEL\nMAkGA1UEBhMCVVMxDzANBgNVBAoTBkFtYXpvbjEZMBcGA1UEAxMQQW1hem9uIFJv\nb3QgQ0EgMjCCAiIwDQYJKoZIhvcNAQEBBQADggIPADCCAgoCggIBAK2Wny2cSkxK\ngXlRmeyKy2tgURO8TW0G/LAIjd0ZEGrHJgw12MBvIITplLGbhQPDW9tK6Mj4kHbZ\nW0/jTOgGNk3Mmqw9DJArktQGGWCsN0R5hYGCrVo34A3MnaZMUnbqQ523BNFQ9lXg\n1dKmSYXpN+nKfq5clU1Imj+uIFptiJXZNLhSGkOQsL9sBbm2eLfq0OQ6PBJTYv9K\n8nu+NQWpEjTj82R0Yiw9AElaKP4yRLuH3WUnAnE72kr3H9rN9yFVkE8P7K6C4Z9r\n2UXTu/Bfh+08LDmG2j/e7HJV63mjrdvdfLC6HM783k81ds8P+HgfajZRRidhW+me\nz/CiVX18JYpvL7TFz4QuK/0NURBs+18bvBt+xa47mAExkv8LV/SasrlX6avvDXbR\n8O70zoan4G7ptGmh32n2M8ZpLpcTnqWHsFcQgTfJU7O7f/aS0ZzQGPSSbtqDT6Zj\nmUyl+17vIWR6IF9sZIUVyzfpYgwLKhbcAS4y2j5L9Z469hdAlO+ekQiG+r5jqFoz\n7Mt0Q5X5bGlSNscpb/xVA1wf+5+9R+vnSUeVC06JIglJ4PVhHvG/LopyboBZ/1c6\n+XUyo05f7O0oYtlNc/LMgRdg7c3r3NunysV+Ar3yVAhU/bQtCSwXVEqY0VThUWcI\n0u1ufm8/0i2BWSlmy5A5lREedCf+3euvAgMBAAGjQjBAMA8GA1UdEwEB/wQFMAMB\nAf8wDgYDVR0PAQH/BAQDAgGGMB0GA1UdDgQWBBSwDPBMMPQFWAJI/TPlUq9LhONm\nUjANBgkqhkiG9w0BAQwFAAOCAgEAqqiAjw54o+Ci1M3m9Zh6O+oAA7CXDpO8Wqj2\nLIxyh6mx/H9z/WNxeKWHWc8w4Q0QshNabYL1auaAn6AFC2jkR2vHat+2/XcycuUY\n+gn0oJMsXdKMdYV2ZZAMA3m3MSNjrXiDCYZohMr/+c8mmpJ5581LxedhpxfL86kS\nk5Nrp+gvU5LEYFiwzAJRGFuFjWJZY7attN6a+yb3ACfAXVU3dJnJUH/jWS5E4ywl\n7uxMMne0nxrpS10gxdr9HIcWxkPo1LsmmkVwXqkLN1PiRnsn/eBG8om3zEK2yygm\nbtmlyTrIQRNg91CMFa6ybRoVGld45pIq2WWQgj9sAq+uEjonljYE1x2igGOpm/Hl\nurR8FLBOybEfdF849lHqm/osohHUqS0nGkWxr7JOcQ3AWEbWaQbLU8uz/mtBzUF+\nfUwPfHJ5elnNXkoOrJupmHN5fLT0zLm4BwyydFy4x2+IoZCn9Kr5v2c69BoVYh63\nn749sSmvZ6ES8lgQGVMDMBu4Gon2nL2XA46jCfMdiyHxtN/kHNGfZQIG6lzWE7OE\n76KlXIx3KadowGuuQNKotOrN8I1LOJwZmhsoVLiJkO/KdYE+HvJkJMcYr07/R54H\n9jVlpNMKVv/1F2Rs76giJUmTtt8AF9pYfl3uxRuw0dFfIRDH+fO6AgonB8Xx1sfT\n4PsJYGw=\n-----END CERTIFICATE-----");
      AMAZON_ROOT_CA3 = new RootCA("AMAZON_ROOT_CA3", 10, "AMAZON_ROOT_CA3", "-----BEGIN CERTIFICATE-----\nMIIBtjCCAVugAwIBAgITBmyf1XSXNmY/Owua2eiedgPySjAKBggqhkjOPQQDAjA5\nMQswCQYDVQQGEwJVUzEPMA0GA1UEChMGQW1hem9uMRkwFwYDVQQDExBBbWF6b24g\nUm9vdCBDQSAzMB4XDTE1MDUyNjAwMDAwMFoXDTQwMDUyNjAwMDAwMFowOTELMAkG\nA1UEBhMCVVMxDzANBgNVBAoTBkFtYXpvbjEZMBcGA1UEAxMQQW1hem9uIFJvb3Qg\nQ0EgMzBZMBMGByqGSM49AgEGCCqGSM49AwEHA0IABCmXp8ZBf8ANm+gBG1bG8lKl\nui2yEujSLtf6ycXYqm0fc4E7O5hrOXwzpcVOho6AF2hiRVd9RFgdszflZwjrZt6j\nQjBAMA8GA1UdEwEB/wQFMAMBAf8wDgYDVR0PAQH/BAQDAgGGMB0GA1UdDgQWBBSr\nttvXBp43rDCGB5Fwx5zEGbF4wDAKBggqhkjOPQQDAgNJADBGAiEA4IWSoxe3jfkr\nBqWTrBqYaGFy+uGh0PsceGCmQ5nFuMQCIQCcAu/xlJyzlvnrxir4tiz+OpAUFteM\nYyRIHN8wfdVoOw==\n-----END CERTIFICATE-----");
      AMAZON_ROOT_CA4 = new RootCA("AMAZON_ROOT_CA4", 11, "AMAZON_ROOT_CA4", "-----BEGIN CERTIFICATE-----\nMIIB8jCCAXigAwIBAgITBmyf18G7EEwpQ+Vxe3ssyBrBDjAKBggqhkjOPQQDAzA5\nMQswCQYDVQQGEwJVUzEPMA0GA1UEChMGQW1hem9uMRkwFwYDVQQDExBBbWF6b24g\nUm9vdCBDQSA0MB4XDTE1MDUyNjAwMDAwMFoXDTQwMDUyNjAwMDAwMFowOTELMAkG\nA1UEBhMCVVMxDzANBgNVBAoTBkFtYXpvbjEZMBcGA1UEAxMQQW1hem9uIFJvb3Qg\nQ0EgNDB2MBAGByqGSM49AgEGBSuBBAAiA2IABNKrijdPo1MN/sGKe0uoe0ZLY7Bi\n9i0b2whxIdIA6GO9mif78DluXeo9pcmBqqNbIJhFXRbb/egQbeOc4OO9X4Ri83Bk\nM6DLJC9wuoihKqB1+IGuYgbEgds5bimwHvouXKNCMEAwDwYDVR0TAQH/BAUwAwEB\n/zAOBgNVHQ8BAf8EBAMCAYYwHQYDVR0OBBYEFNPsxzplbszh2naaVvuc84ZtV+WB\nMAoGCCqGSM49BAMDA2gAMGUCMDqLIfG9fhGt0O9Yli/W651+kI0rz2ZVwyzjKKlw\nCkcO8DdZEv8tmZQoTipPNU0zWgIxAOp1AE47xDqUEpHJWEadIRNyp4iciuRMStuW\n1KyLa2tJElMzrdfkviT8tQp21KW8EA==\n-----END CERTIFICATE-----");
      BALTIMORE_CYBER_TRUST_ROOT = new RootCA("BALTIMORE_CYBER_TRUST_ROOT", 12, "BALTIMORE_CYBER_TRUST_ROOT", "-----BEGIN CERTIFICATE-----\nMIIDdzCCAl+gAwIBAgIEAgAAuTANBgkqhkiG9w0BAQUFADBaMQswCQYDVQQGEwJJ\nRTESMBAGA1UEChMJQmFsdGltb3JlMRMwEQYDVQQLEwpDeWJlclRydXN0MSIwIAYD\nVQQDExlCYWx0aW1vcmUgQ3liZXJUcnVzdCBSb290MB4XDTAwMDUxMjE4NDYwMFoX\nDTI1MDUxMjIzNTkwMFowWjELMAkGA1UEBhMCSUUxEjAQBgNVBAoTCUJhbHRpbW9y\nZTETMBEGA1UECxMKQ3liZXJUcnVzdDEiMCAGA1UEAxMZQmFsdGltb3JlIEN5YmVy\nVHJ1c3QgUm9vdDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKMEuyKr\nmD1X6CZymrV51Cni4eiVgLGw41uOKymaZN+hXe2wCQVt2yguzmKiYv60iNoS6zjr\nIZ3AQSsBUnuId9Mcj8e6uYi1agnnc+gRQKfRzMpijS3ljwumUNKoUMMo6vWrJYeK\nmpYcqWe4PwzV9/lSEy/CG9VwcPCPwBLKBsua4dnKM3p31vjsufFoREJIE9LAwqSu\nXmD+tqYF/LTdB1kC1FkYmGP1pWPgkAx9XbIGevOF6uvUA65ehD5f/xXtabz5OTZy\ndc93Uk3zyZAsuT3lySNTPx8kmCFcB5kpvcY67Oduhjprl3RjM71oGDHweI12v/ye\njl0qhqdNkNwnGjkCAwEAAaNFMEMwHQYDVR0OBBYEFOWdWTCCR1jMrPoIVDaGezq1\nBE3wMBIGA1UdEwEB/wQIMAYBAf8CAQMwDgYDVR0PAQH/BAQDAgEGMA0GCSqGSIb3\nDQEBBQUAA4IBAQCFDF2O5G9RaEIFoN27TyclhAO992T9Ldcw46QQF+vaKSm2eT92\n9hkTI7gQCvlYpNRhcL0EYWoSihfVCr3FvDB81ukMJY2GQE/szKN+OMY3EU/t3Wgx\njkzSswF07r51XgdIGn9w/xZchMB5hbgF/X++ZRGjD8ACtPhSNzkE1akxehi/oCr0\nEpn3o0WC4zxe9Z2etciefC7IpJ5OCBRLbf1wbWsaY71k5h+3zvDyny67G7fyUIhz\nksLi4xaNmjICq44Y3ekQEe5+NauQrz4wlHrQMz2nZQ/1/I6eYs9HRCwBXbsdtTLS\nR9I4LtD+gdwyah617jzV/OeBHRnDJELqYzmp\n-----END CERTIFICATE-----");
      RootCA localRootCA = new RootCA("SFSROOTCAG2", 13, "SFSROOTCAG2", "-----BEGIN CERTIFICATE-----\nMIID7zCCAtegAwIBAgIBADANBgkqhkiG9w0BAQsFADCBmDELMAkGA1UEBhMCVVMx\nEDAOBgNVBAgTB0FyaXpvbmExEzARBgNVBAcTClNjb3R0c2RhbGUxJTAjBgNVBAoT\nHFN0YXJmaWVsZCBUZWNobm9sb2dpZXMsIEluYy4xOzA5BgNVBAMTMlN0YXJmaWVs\nZCBTZXJ2aWNlcyBSb290IENlcnRpZmljYXRlIEF1dGhvcml0eSAtIEcyMB4XDTA5\nMDkwMTAwMDAwMFoXDTM3MTIzMTIzNTk1OVowgZgxCzAJBgNVBAYTAlVTMRAwDgYD\nVQQIEwdBcml6b25hMRMwEQYDVQQHEwpTY290dHNkYWxlMSUwIwYDVQQKExxTdGFy\nZmllbGQgVGVjaG5vbG9naWVzLCBJbmMuMTswOQYDVQQDEzJTdGFyZmllbGQgU2Vy\ndmljZXMgUm9vdCBDZXJ0aWZpY2F0ZSBBdXRob3JpdHkgLSBHMjCCASIwDQYJKoZI\nhvcNAQEBBQADggEPADCCAQoCggEBANUMOsQq+U7i9b4Zl1+OiFOxHz/Lz58gE20p\nOsgPfTz3a3Y4Y9k2YKibXlwAgLIvWX/2h/klQ4bnaRtSmpDhcePYLQ1Ob/bISdm2\n8xpWriu2dBTrz/sm4xq6HZYuajtYlIlHVv8loJNwU4PahHQUw2eeBGg6345AWh1K\nTs9DkTvnVtYAcMtS7nt9rjrnvDH5RfbCYM8TWQIrgMw0R9+53pBlbQLPLJGmpufe\nhRhJfGZOozptqbXuNC66DQO4M99H67FrjSXZm86B0UVGMpZwh94CDklDhbZsc7tk\n6mFBrMnUVN+HL8cisibMn1lUaJ/8viovxFUcdUBgF4UCVTmLfwUCAwEAAaNCMEAw\nDwYDVR0TAQH/BAUwAwEB/zAOBgNVHQ8BAf8EBAMCAQYwHQYDVR0OBBYEFJxfAN+q\nAdcwKziIorhtSpzyEZGDMA0GCSqGSIb3DQEBCwUAA4IBAQBLNqaEd2ndOxmfZyMI\nbw5hyf2E3F/YNoHN2BtBLZ9g3ccaaNnRbobhiCPPE95Dz+I0swSdHynVv/heyNXB\nve6SbzJ08pGCL72CQnqtKrcgfU28elUSwhXqvfdqlS5sdJ/PHLTyxQGjhdByPq1z\nqwubdQxtRbeOlKyWN7Wg0I8VRw7j6IPdj/3vQQF3zCepYoUz8jcI73HPdwbeyBkd\niEDPfUYd/x7H4c7/I9vG+o1VTqkC50cRRj70/b17KSa7qWFiNyi2LSr2EIZkyXCn\n0q23KXB56jzaYyWf/Wi3MOxw+3WKt21gZ7IeyLnp2KhvAotnDU0mV3HaIPzBSlCN\nsSi6\n-----END CERTIFICATE-----");
      SFSROOTCAG2 = localRootCA;
      $VALUES = new RootCA[] { GLOBAL_SIGN_ROOT_CA, COMODO_RSA_CERTIFICATION_AUTHORITY, DIGICERT_HIGH_ASSURANCE_EV_ROOT_CA, GO_DADDY_ROOT_CERTIFICATE_AUTHORITY_G2, GO_DADDY_SECURE_CERTIFICATE_AUTHORITY_G2, STARFIELD_SERVICES_ROOT_CERTIFICATE_AUTHORITY, STARFIELD_SERVICES_ROOT_CERTIFICATE_AUTHORITY_G2_INTERMEDIATE, EQUIFAX_SECURE_CERTIFICATE_AUTHORITY, AMAZON_ROOT_CA1, AMAZON_ROOT_CA2, AMAZON_ROOT_CA3, AMAZON_ROOT_CA4, BALTIMORE_CYBER_TRUST_ROOT, localRootCA };
    }
    
    private RootCA(String paramString1, String paramString2)
    {
      this.alias = paramString1;
      this.certificate = paramString2;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afina\\utils\HttpsHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */