package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class zzeu
  extends zzkj
{
  private final SSLSocketFactory zzb;
  
  public zzeu(zzki paramzzki)
  {
    super(paramzzki);
    if (Build.VERSION.SDK_INT < 19) {
      paramzzki = new zzky();
    } else {
      paramzzki = null;
    }
    this.zzb = paramzzki;
  }
  
  private static byte[] zza(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    byte[] arrayOfByte = null;
    Object localObject = arrayOfByte;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = arrayOfByte;
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      localObject = paramHttpURLConnection;
      arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        localObject = paramHttpURLConnection;
        int i = paramHttpURLConnection.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localObject = paramHttpURLConnection;
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localObject = paramHttpURLConnection;
      arrayOfByte = localByteArrayOutputStream.toByteArray();
      if (paramHttpURLConnection != null) {
        paramHttpURLConnection.close();
      }
      return arrayOfByte;
    }
    finally
    {
      if (localObject != null) {
        ((InputStream)localObject).close();
      }
    }
  }
  
  protected final HttpURLConnection zza(URL paramURL)
    throws IOException
  {
    paramURL = paramURL.openConnection();
    if ((paramURL instanceof HttpURLConnection))
    {
      SSLSocketFactory localSSLSocketFactory = this.zzb;
      if ((localSSLSocketFactory != null) && ((paramURL instanceof HttpsURLConnection))) {
        ((HttpsURLConnection)paramURL).setSSLSocketFactory(localSSLSocketFactory);
      }
      paramURL = (HttpURLConnection)paramURL;
      paramURL.setDefaultUseCaches(false);
      paramURL.setConnectTimeout(60000);
      paramURL.setReadTimeout(61000);
      paramURL.setInstanceFollowRedirects(false);
      paramURL.setDoInput(true);
      return paramURL;
    }
    throw new IOException("Failed to obtain HTTP connection");
  }
  
  protected final boolean zzd()
  {
    return false;
  }
  
  public final boolean zze()
  {
    zzaj();
    Object localObject = (ConnectivityManager)zzm().getSystemService("connectivity");
    try
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    }
    catch (SecurityException localSecurityException)
    {
      for (;;) {}
    }
    localObject = null;
    return (localObject != null) && (((NetworkInfo)localObject).isConnected());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzeu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */