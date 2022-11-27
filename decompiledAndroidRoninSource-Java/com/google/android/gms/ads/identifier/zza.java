package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class zza
  extends Thread
{
  zza(AdvertisingIdClient paramAdvertisingIdClient, Map paramMap) {}
  
  public final void run()
  {
    new zzc();
    Object localObject1 = this.zzl;
    Object localObject2 = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
    localObject4 = ((Map)localObject1).keySet().iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (String)((Iterator)localObject4).next();
      ((Uri.Builder)localObject2).appendQueryParameter((String)localObject5, (String)((Map)localObject1).get(localObject5));
    }
    str2 = ((Uri.Builder)localObject2).build().toString();
    try
    {
      try
      {
        localObject1 = (HttpURLConnection)new URL(str2).openConnection();
        try
        {
          int i = ((HttpURLConnection)localObject1).getResponseCode();
          if ((i < 200) || (i >= 300))
          {
            localObject2 = new StringBuilder(String.valueOf(str2).length() + 65);
            ((StringBuilder)localObject2).append("Received non-success response code ");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(" from pinging URL: ");
            ((StringBuilder)localObject2).append(str2);
            Log.w("HttpUrlPinger", ((StringBuilder)localObject2).toString());
          }
          return;
        }
        finally
        {
          ((HttpURLConnection)localObject1).disconnect();
        }
        str1 = localIOException.getMessage();
      }
      catch (RuntimeException localRuntimeException) {}catch (IOException localIOException) {}
      localObject5 = new StringBuilder(String.valueOf(str2).length() + 27 + String.valueOf(str1).length());
      localObject4 = "Error while pinging URL: ";
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        String str1 = localIndexOutOfBoundsException.getMessage();
        localObject5 = new StringBuilder(String.valueOf(str2).length() + 32 + String.valueOf(str1).length());
        localObject4 = "Error while parsing ping URL: ";
      }
    }
    ((StringBuilder)localObject5).append((String)localObject4);
    ((StringBuilder)localObject5).append(str2);
    ((StringBuilder)localObject5).append(". ");
    ((StringBuilder)localObject5).append(str1);
    Log.w("HttpUrlPinger", ((StringBuilder)localObject5).toString(), localIOException);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\ads\identifier\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */