package com.huawei.updatesdk.sdk.service.download;

import com.huawei.updatesdk.sdk.a.c.a.a.a;
import com.huawei.updatesdk.sdk.a.d.e;
import com.huawei.updatesdk.sdk.service.download.bean.DownloadTask;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class g
{
  private static volatile g a;
  
  public static long a(String paramString)
  {
    boolean bool = e.a(paramString);
    long l1 = -1L;
    int i;
    if ((!bool) && (paramString.startsWith("bytes")))
    {
      i = paramString.indexOf('/');
      if (-1 == i) {}
    }
    try
    {
      long l2 = Long.parseLong(paramString.substring(i + 1));
      l1 = l2;
      paramString = new StringBuilder();
      l1 = l2;
      paramString.append("get new filelength by Content-Range:");
      l1 = l2;
      paramString.append(l2);
      l1 = l2;
      a.a("HiAppDownload", paramString.toString());
      return l2;
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    for (paramString = "getEntityLegth NumberFormatException";; paramString = "getEntityLegth failed Content-Range")
    {
      a.d("HiAppDownload", paramString);
      return l1;
    }
    return -1L;
  }
  
  public static a a(DownloadTask paramDownloadTask, HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    if (paramHttpURLConnection == null) {
      return null;
    }
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    a locala = new a();
    paramHttpURLConnection = localExecutorService.submit(new Callable()
    {
      public g.a a()
      {
        return null;
      }
    });
    if ((paramDownloadTask != null) && (paramBoolean)) {
      paramDownloadTask.b(paramHttpURLConnection);
    }
    try
    {
      paramDownloadTask = (a)paramHttpURLConnection.get(8000L, TimeUnit.MILLISECONDS);
      return paramDownloadTask;
    }
    catch (Exception paramDownloadTask)
    {
      a.d("HiAppDownload", paramDownloadTask.toString());
    }
    catch (TimeoutException paramDownloadTask)
    {
      a.d("HiAppDownload", paramDownloadTask.toString());
      paramDownloadTask = new SocketTimeoutException("connect timeout");
    }
    locala.a(paramDownloadTask);
    return locala;
  }
  
  public static g a()
  {
    try
    {
      if (a == null) {
        a = new g();
      }
      g localg = a;
      return localg;
    }
    finally {}
  }
  
  private Proxy b()
  {
    return null;
  }
  
  public HttpURLConnection a(String paramString, boolean paramBoolean)
    throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IllegalAccessException
  {
    return null;
  }
  
  public static class a
  {
    private boolean a = false;
    private Exception b = null;
    
    public void a(Exception paramException)
    {
      this.b = paramException;
    }
    
    public void a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public boolean a()
    {
      return this.a;
    }
    
    public Exception b()
    {
      return this.b;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\download\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */