package com.huawei.updatesdk.sdk.a.b;

import android.content.Context;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class b
  extends SSLSocketFactory
{
  public static final X509HostnameVerifier a = new BrowserCompatHostnameVerifier();
  public static final X509HostnameVerifier b = new StrictHostnameVerifier();
  private static final String[] c = { "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "aNULL", "eNULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "NULL", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV" };
  private static volatile b d = null;
  private static String[] e = null;
  private SSLContext f = null;
  private Context g;
  
  private b(Context paramContext)
    throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException
  {
    this.g = paramContext;
    this.f = SSLContext.getInstance("TLS");
    paramContext = new c(this.g);
    this.f.init(null, new X509TrustManager[] { paramContext }, null);
  }
  
  public static b a(Context paramContext)
    throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new b(paramContext);
        }
      }
      finally {}
    }
    return d;
  }
  
  /* Error */
  private void a(Socket arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static void a(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {
      return;
    }
    String[] arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
    ArrayList localArrayList = new ArrayList();
    int k = arrayOfString1.length;
    int i = 0;
    while (i < k)
    {
      String str1 = arrayOfString1[i];
      String str2 = str1.toUpperCase(Locale.US);
      String[] arrayOfString2 = c;
      int m = arrayOfString2.length;
      int j = 0;
      while (j < m)
      {
        if (str2.contains(arrayOfString2[j]))
        {
          j = 1;
          break label91;
        }
        j += 1;
      }
      j = 0;
      label91:
      if (j == 0) {
        localArrayList.add(str1);
      }
      i += 1;
    }
    arrayOfString1 = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    e = arrayOfString1;
    paramSSLSocket.setEnabledCipherSuites(arrayOfString1);
  }
  
  /* Error */
  private void b(SSLSocket arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Socket createSocket(String paramString, int paramInt)
    throws IOException, UnknownHostException
  {
    return null;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException, UnknownHostException
  {
    return createSocket(paramString, paramInt1);
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    return createSocket(paramInetAddress.getHostAddress(), paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    return createSocket(paramInetAddress1.getHostAddress(), paramInt1);
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    return null;
  }
  
  public String[] getDefaultCipherSuites()
  {
    return null;
  }
  
  public String[] getSupportedCipherSuites()
  {
    return new String[0];
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */