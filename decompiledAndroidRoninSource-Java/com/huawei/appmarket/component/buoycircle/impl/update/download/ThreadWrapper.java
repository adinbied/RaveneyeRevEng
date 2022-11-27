package com.huawei.appmarket.component.buoycircle.impl.update.download;

import android.content.Context;
import com.huawei.appmarket.component.buoycircle.impl.update.download.api.IOtaUpdate;
import com.huawei.appmarket.component.buoycircle.impl.update.download.api.IUpdateCallback;
import com.huawei.appmarket.component.buoycircle.impl.update.download.api.UpdateInfo;
import com.huawei.appmarket.component.buoycircle.impl.utils.Checker;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadWrapper
  implements IOtaUpdate
{
  private static final Executor mWorkThread = ;
  private final IOtaUpdate mOtaUpdate;
  
  public ThreadWrapper(IOtaUpdate paramIOtaUpdate)
  {
    Checker.checkNonNull(paramIOtaUpdate, "update must not be null.");
    this.mOtaUpdate = paramIOtaUpdate;
  }
  
  private static IUpdateCallback wrapUpdateCallback(IUpdateCallback paramIUpdateCallback)
  {
    new IUpdateCallback()
    {
      /* Error */
      public void onCheckUpdate(int arg1, UpdateInfo arg2)
      {
        // Byte code:
        //   0: return
        //   1: astore_2
        //   2: goto -2 -> 0
      }
      
      /* Error */
      public void onDownloadPackage(int arg1, int arg2, int arg3, File arg4)
      {
        // Byte code:
        //   0: return
        //   1: astore 4
        //   3: goto -3 -> 0
      }
    };
  }
  
  public void cancel()
  {
    this.mOtaUpdate.cancel();
  }
  
  /* Error */
  public void downloadPackage(IUpdateCallback arg1, UpdateInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Context getContext()
  {
    return this.mOtaUpdate.getContext();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\download\ThreadWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */