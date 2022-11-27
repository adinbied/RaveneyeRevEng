package com.huawei.updatesdk.sdk.service.download;

import com.huawei.updatesdk.sdk.service.download.bean.DownloadTask;
import com.huawei.updatesdk.sdk.service.download.bean.b;
import java.io.IOException;
import java.util.concurrent.Future;

public class f
  implements Runnable
{
  String a = "";
  String b = "";
  private DownloadTask c;
  private b d;
  private j e = null;
  private volatile boolean f = false;
  private volatile boolean g = true;
  private volatile boolean h = true;
  private boolean i = false;
  private int j = 0;
  private long k = 0L;
  private long l = 0L;
  private Future<?> m = null;
  
  public f(DownloadTask paramDownloadTask, b paramb, j paramj)
  {
    this.c = paramDownloadTask;
    this.d = paramb;
    this.e = paramj;
    this.g = true;
  }
  
  private long a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    return 1006646420L;
  }
  
  /* Error */
  private void a(int arg1, long arg2, long arg4)
    throws c
  {
    // Byte code:
    //   0: return
    //   1: astore 6
    //   3: goto -3 -> 0
  }
  
  /* Error */
  private void a(int arg1, java.net.HttpURLConnection arg2)
    throws c
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(long arg1)
    throws c
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  /* Error */
  private void a(c arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void a(java.io.BufferedInputStream arg1, java.io.RandomAccessFile arg2)
    throws IOException, c
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private boolean a(IOException paramIOException)
  {
    return false;
  }
  
  /* Error */
  private void f()
    throws c
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean g()
  {
    return false;
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void i()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void j()
    throws c
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void a(Future<?> paramFuture)
  {
    this.m = paramFuture;
  }
  
  public boolean a()
  {
    return this.i;
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public void c()
  {
    this.g = false;
  }
  
  public long d()
  {
    return this.k;
  }
  
  public long e()
  {
    return this.l;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\download\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */