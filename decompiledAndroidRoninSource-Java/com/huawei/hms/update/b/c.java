package com.huawei.hms.update.b;

import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

final class c
{
  public static void a(HttpsURLConnection paramHttpsURLConnection)
  {
    SocketFactory localSocketFactory = e.a();
    if ((localSocketFactory instanceof SSLSocketFactory)) {
      paramHttpsURLConnection.setSSLSocketFactory((SSLSocketFactory)localSocketFactory);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hm\\update\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */