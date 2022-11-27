package com.huawei.hms.update.b;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

final class e
  extends SSLSocketFactory
{
  private static final Object a = new Object();
  private static SocketFactory c;
  private final SSLContext b;
  
  private e()
    throws NoSuchAlgorithmException, KeyManagementException
  {
    SSLContext localSSLContext = SSLContext.getInstance("TLSv1.2");
    this.b = localSSLContext;
    localSSLContext.init(null, null, null);
  }
  
  /* Error */
  public static SocketFactory a()
  {
    // Byte code:
    //   0: getstatic 19	com/huawei/hms/update/b/e:a	Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: getstatic 43	com/huawei/hms/update/b/e:c	Ljavax/net/SocketFactory;
    //   9: ifnonnull +13 -> 22
    //   12: new 2	com/huawei/hms/update/b/e
    //   15: dup
    //   16: invokespecial 44	com/huawei/hms/update/b/e:<init>	()V
    //   19: putstatic 43	com/huawei/hms/update/b/e:c	Ljavax/net/SocketFactory;
    //   22: getstatic 43	com/huawei/hms/update/b/e:c	Ljavax/net/SocketFactory;
    //   25: astore_0
    //   26: aload_1
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: new 46	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   37: astore_2
    //   38: aload_2
    //   39: ldc 49
    //   41: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_2
    //   46: aload_0
    //   47: invokevirtual 59	java/security/GeneralSecurityException:getMessage	()Ljava/lang/String;
    //   50: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: ldc 61
    //   56: aload_2
    //   57: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 70	com/huawei/hms/support/log/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: invokestatic 73	javax/net/ssl/SSLSocketFactory:getDefault	()Ljavax/net/SocketFactory;
    //   66: astore_0
    //   67: aload_1
    //   68: monitorexit
    //   69: aload_0
    //   70: areturn
    //   71: aload_1
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    //   75: astore_0
    //   76: goto -5 -> 71
    //   79: astore_0
    //   80: goto -50 -> 30
    //   83: astore_0
    //   84: goto -54 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   25	49	0	localSocketFactory	SocketFactory
    //   75	1	0	localObject1	Object
    //   79	1	0	localNoSuchAlgorithmException	NoSuchAlgorithmException
    //   83	1	0	localKeyManagementException	KeyManagementException
    //   37	20	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	22	75	finally
    //   22	26	75	finally
    //   26	28	75	finally
    //   30	69	75	finally
    //   71	73	75	finally
    //   6	22	79	java/security/NoSuchAlgorithmException
    //   22	26	79	java/security/NoSuchAlgorithmException
    //   6	22	83	java/security/KeyManagementException
    //   22	26	83	java/security/KeyManagementException
  }
  
  /* Error */
  private void a(Socket arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static void a(SSLSocket paramSSLSocket)
  {
    String[] arrayOfString = paramSSLSocket.getEnabledCipherSuites();
    if (arrayOfString != null)
    {
      if (arrayOfString.length == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
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
  
  private static boolean a(String paramString)
  {
    return (paramString.contains("RC2")) || (paramString.contains("RC4")) || (paramString.contains("DES")) || (paramString.contains("MD2")) || (paramString.contains("MD4")) || (paramString.contains("MD5")) || (paramString.contains("ANON")) || (paramString.contains("NULL")) || (paramString.contains("SKIPJACK")) || (paramString.contains("SHA1")) || (paramString.contains("TEA")) || (paramString.contains("SHA0")) || (paramString.contains("RIPEMD")) || (paramString.contains("TLS_EMPTY_RENEGOTIATION_INFO_SCSV"));
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
    return new String[0];
  }
  
  public String[] getSupportedCipherSuites()
  {
    return new String[0];
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hm\\update\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */