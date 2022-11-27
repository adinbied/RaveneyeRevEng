package com.huawei.appmarket.component.buoycircle.impl.update.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class HttpRequestHelper
  implements IHttpRequestHelper
{
  private static final int BUFF_SIZE = 4096;
  private static final int STATUS_CANCELED = 1;
  private static final int STATUS_CLOSED = -1;
  private static final int STATUS_OPENED = 0;
  private static final String TAG = "HttpRequestHelper";
  private static final int TIMEOUT = 30000;
  private HttpURLConnection mConnection;
  private volatile int mStatus = -1;
  
  /* Error */
  private void copy(InputStream arg1, OutputStream arg2)
    throws IOException, CanceledException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void openConnection(String arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void cancel()
  {
    this.mStatus = 1;
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int get(String paramString, OutputStream paramOutputStream)
    throws IOException, CanceledException
  {
    return get(paramString, paramOutputStream, 0, 0);
  }
  
  public int get(String paramString, OutputStream paramOutputStream, int paramInt1, int paramInt2)
    throws IOException, CanceledException
  {
    return 0;
  }
  
  public int post(String paramString, InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException, CanceledException
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\http\HttpRequestHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */