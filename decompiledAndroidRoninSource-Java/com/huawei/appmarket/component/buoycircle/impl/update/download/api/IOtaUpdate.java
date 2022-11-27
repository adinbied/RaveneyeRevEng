package com.huawei.appmarket.component.buoycircle.impl.update.download.api;

import android.content.Context;

public abstract interface IOtaUpdate
{
  public abstract void cancel();
  
  public abstract void downloadPackage(IUpdateCallback paramIUpdateCallback, UpdateInfo paramUpdateInfo);
  
  public abstract Context getContext();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\download\api\IOtaUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */