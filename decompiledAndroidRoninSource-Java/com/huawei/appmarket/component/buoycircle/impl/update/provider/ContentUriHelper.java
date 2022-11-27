package com.huawei.appmarket.component.buoycircle.impl.update.provider;

import android.content.Context;
import android.net.Uri;
import com.huawei.appmarket.component.buoycircle.impl.utils.Checker;
import java.io.File;
import java.io.IOException;

class ContentUriHelper
{
  private static final String TAG = "ContentUriHelper";
  private Context mContext;
  private String mUpdateRoot;
  
  private static File getCanonicalFile(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = paramFile.getCanonicalFile();
      return paramFile;
    }
    catch (IOException paramFile) {}
    return null;
  }
  
  private static String getCanonicalPath(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = paramFile.getCanonicalPath();
      return paramFile;
    }
    catch (IOException paramFile) {}
    return null;
  }
  
  private String getUpdateRoot()
  {
    return null;
  }
  
  private String mapPath(String paramString)
  {
    return null;
  }
  
  private String unmapPath(String paramString)
  {
    return null;
  }
  
  File getFileForUri(Uri paramUri)
  {
    return null;
  }
  
  public File getLocalFile(String paramString)
  {
    return null;
  }
  
  public Uri getUriForFile(File paramFile, String paramString)
  {
    return null;
  }
  
  public void setContext(Context paramContext)
  {
    Checker.checkNonNull(paramContext, "context nust not be null.");
    this.mContext = paramContext;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\provider\ContentUriHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */