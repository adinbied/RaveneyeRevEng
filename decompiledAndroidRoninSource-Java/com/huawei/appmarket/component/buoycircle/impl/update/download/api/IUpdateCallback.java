package com.huawei.appmarket.component.buoycircle.impl.update.download.api;

import java.io.File;

public abstract interface IUpdateCallback
{
  public abstract void onCheckUpdate(int paramInt, UpdateInfo paramUpdateInfo);
  
  public abstract void onDownloadPackage(int paramInt1, int paramInt2, int paramInt3, File paramFile);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\download\api\IUpdateCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */