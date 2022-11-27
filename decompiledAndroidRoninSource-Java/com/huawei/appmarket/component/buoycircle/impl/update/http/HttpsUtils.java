package com.huawei.appmarket.component.buoycircle.impl.update.http;

import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

final class HttpsUtils
{
  public static void setSSLSocketFactory(HttpsURLConnection paramHttpsURLConnection)
  {
    SocketFactory localSocketFactory = TLSSocketFactory.getInstance();
    if ((localSocketFactory instanceof SSLSocketFactory)) {
      paramHttpsURLConnection.setSSLSocketFactory((SSLSocketFactory)localSocketFactory);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\http\HttpsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */