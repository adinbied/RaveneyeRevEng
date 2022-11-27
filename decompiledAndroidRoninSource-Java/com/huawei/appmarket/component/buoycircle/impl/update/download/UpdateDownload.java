package com.huawei.appmarket.component.buoycircle.impl.update.download;

import android.content.Context;
import com.huawei.appmarket.component.buoycircle.impl.security.HEX;
import com.huawei.appmarket.component.buoycircle.impl.security.SHA256;
import com.huawei.appmarket.component.buoycircle.impl.update.download.api.IOtaUpdate;
import com.huawei.appmarket.component.buoycircle.impl.update.download.api.IUpdateCallback;
import com.huawei.appmarket.component.buoycircle.impl.update.http.HttpRequestHelper;
import com.huawei.appmarket.component.buoycircle.impl.update.http.IHttpRequestHelper;
import java.io.File;
import java.io.IOException;

public class UpdateDownload
  implements IOtaUpdate
{
  private static final String TAG = "UpdateDownload";
  private IUpdateCallback mCallback;
  private final Context mContext;
  private final IHttpRequestHelper mHttp = new HttpRequestHelper();
  private File mLocalFile;
  private final DownloadRecord mRecord = new DownloadRecord();
  
  public UpdateDownload(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  /* Error */
  private void fireDownloading(int arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: return
  }
  
  private RandomFileOutputStream newRandomFileOutputStream(File paramFile, int paramInt, String paramString)
    throws IOException
  {
    return null;
  }
  
  private void setListener(IUpdateCallback paramIUpdateCallback)
  {
    try
    {
      this.mCallback = paramIUpdateCallback;
      return;
    }
    finally
    {
      paramIUpdateCallback = finally;
      throw paramIUpdateCallback;
    }
  }
  
  private static boolean verifyHash(String paramString, File paramFile)
  {
    paramFile = SHA256.digest(paramFile);
    return (paramFile != null) && (HEX.encodeHexString(paramFile, true).equalsIgnoreCase(paramString));
  }
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void downloadPackage(IUpdateCallback arg1, com.huawei.appmarket.component.buoycircle.impl.update.download.api.UpdateInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void downloadPackage(com.huawei.appmarket.component.buoycircle.impl.update.download.api.UpdateInfo arg1)
    throws com.huawei.appmarket.component.buoycircle.impl.update.http.CanceledException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\download\UpdateDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */