package com.huawei.appmarket.component.buoycircle.impl.update.http;

import com.huawei.appmarket.component.buoycircle.impl.log.BuoyLog;
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

final class TLSSocketFactory
  extends SSLSocketFactory
{
  private static final Object LOCK_INST = new Object();
  private static final String TAG = "TLSSocketFactory";
  private static SocketFactory mSocketFactory;
  private final SSLContext mSSLContext;
  
  private TLSSocketFactory()
    throws NoSuchAlgorithmException, KeyManagementException
  {
    SSLContext localSSLContext = SSLContext.getInstance("TLSv1.2");
    this.mSSLContext = localSSLContext;
    localSSLContext.init(null, null, null);
  }
  
  public static SocketFactory getInstance()
  {
    synchronized (LOCK_INST)
    {
      try
      {
        if (mSocketFactory == null) {
          mSocketFactory = new TLSSocketFactory();
        }
        localSocketFactory = mSocketFactory;
        return localSocketFactory;
      }
      catch (KeyManagementException|NoSuchAlgorithmException localKeyManagementException)
      {
        SocketFactory localSocketFactory;
        for (;;) {}
      }
      BuoyLog.e("TLSSocketFactory", "Failed to new TLSSocketFactory instance");
      localSocketFactory = SSLSocketFactory.getDefault();
      return localSocketFactory;
      throw localSocketFactory;
    }
  }
  
  public static void setEnableSafeCipherSuites(SSLSocket paramSSLSocket)
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
        if ((!str.contains("RC2")) && (!str.contains("RC4")) && (!str.contains("DES")) && (!str.contains("MD2")) && (!str.contains("MD4")) && (!str.contains("MD5")) && (!str.contains("ANON")) && (!str.contains("NULL")) && (!str.contains("SKIPJACK")) && (!str.contains("SHA1")) && (!str.contains("TEA")) && (!str.contains("SHA0")) && (!str.contains("RIPEMD")) && (!str.contains("TLS_EMPTY_RENEGOTIATION_INFO_SCSV"))) {
          localArrayList.add(str);
        }
        i += 1;
      }
      paramSSLSocket.setEnabledCipherSuites((String[])localArrayList.toArray(new String[localArrayList.size()]));
    }
  }
  
  /* Error */
  private void setEnabledProtocols(SSLSocket arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setSocketOptions(Socket arg1)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\http\TLSSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */