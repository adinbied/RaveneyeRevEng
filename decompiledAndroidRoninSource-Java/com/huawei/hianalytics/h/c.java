package com.huawei.hianalytics.h;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

final class c
  extends SSLSocketFactory
{
  private static final String[] a = { "3DES", "DES", "MD5", "RC4", "aNULL", "eNULL", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "DESX", "DES40", "RC2", "ANON", "NULL", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV" };
  private static SocketFactory c;
  private final SSLContext b;
  
  private c()
  {
    SSLContext localSSLContext = SSLContext.getInstance("TLS");
    this.b = localSSLContext;
    localSSLContext.init(null, c(), null);
  }
  
  public static SocketFactory a()
  {
    return b();
  }
  
  /* Error */
  private void a(Socket arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(SSLSocket arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static boolean a(String paramString)
  {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.contains(arrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  /* Error */
  private static SocketFactory b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 93	com/huawei/hianalytics/h/c:c	Ljavax/net/SocketFactory;
    //   6: ifnonnull +13 -> 19
    //   9: new 2	com/huawei/hianalytics/h/c
    //   12: dup
    //   13: invokespecial 94	com/huawei/hianalytics/h/c:<init>	()V
    //   16: putstatic 93	com/huawei/hianalytics/h/c:c	Ljavax/net/SocketFactory;
    //   19: getstatic 93	com/huawei/hianalytics/h/c:c	Ljavax/net/SocketFactory;
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: goto +26 -> 55
    //   32: ldc 96
    //   34: astore_0
    //   35: ldc 98
    //   37: aload_0
    //   38: invokestatic 103	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: goto +9 -> 50
    //   44: ldc 105
    //   46: astore_0
    //   47: goto -12 -> 35
    //   50: ldc 2
    //   52: monitorexit
    //   53: aconst_null
    //   54: areturn
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    //   60: astore_0
    //   61: goto -17 -> 44
    //   64: astore_0
    //   65: goto +27 -> 92
    //   68: astore_0
    //   69: goto +17 -> 86
    //   72: astore_0
    //   73: goto +7 -> 80
    //   76: astore_0
    //   77: goto -45 -> 32
    //   80: ldc 107
    //   82: astore_0
    //   83: goto -48 -> 35
    //   86: ldc 109
    //   88: astore_0
    //   89: goto -54 -> 35
    //   92: ldc 111
    //   94: astore_0
    //   95: goto -60 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	5	0	localSocketFactory	SocketFactory
    //   28	1	0	localObject	Object
    //   34	25	0	str1	String
    //   60	1	0	localKeyManagementException	java.security.KeyManagementException
    //   64	1	0	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   68	1	0	localKeyStoreException	java.security.KeyStoreException
    //   72	1	0	localGeneralSecurityException	java.security.GeneralSecurityException
    //   76	1	0	localIOException	java.io.IOException
    //   82	13	0	str2	String
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
    //   35	41	28	finally
    //   3	19	60	java/security/KeyManagementException
    //   19	23	60	java/security/KeyManagementException
    //   3	19	64	java/security/NoSuchAlgorithmException
    //   19	23	64	java/security/NoSuchAlgorithmException
    //   3	19	68	java/security/KeyStoreException
    //   19	23	68	java/security/KeyStoreException
    //   3	19	72	java/security/GeneralSecurityException
    //   19	23	72	java/security/GeneralSecurityException
    //   3	19	76	java/io/IOException
    //   19	23	76	java/io/IOException
  }
  
  private static void b(SSLSocket paramSSLSocket)
  {
    String[] arrayOfString = paramSSLSocket.getEnabledCipherSuites();
    if (arrayOfString != null)
    {
      if (arrayOfString.length == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < arrayOfString.length)
      {
        String str = arrayOfString[i];
        if (!a(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
      paramSSLSocket.setEnabledCipherSuites((String[])localArrayList.toArray(new String[localArrayList.size()]));
    }
  }
  
  private static TrustManager[] c()
  {
    TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance("X509");
    localTrustManagerFactory.init(b.a());
    return localTrustManagerFactory.getTrustManagers();
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    return null;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    return createSocket(paramString, paramInt1);
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return createSocket(paramInetAddress.getHostAddress(), paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return createSocket(paramInetAddress1.getHostAddress(), paramInt1);
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return null;
  }
  
  public String[] getDefaultCipherSuites()
  {
    return new String[0];
  }
  
  public String[] getSupportedCipherSuites()
  {
    return new String[0];
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\h\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */