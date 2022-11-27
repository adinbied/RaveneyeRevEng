package com.huawei.hms.update.provider;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;

class a
{
  private Context a;
  private String b;
  
  private String a()
  {
    return null;
  }
  
  private static String a(File paramFile)
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
  
  private static File b(File paramFile)
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
  
  private String b(String paramString)
  {
    return null;
  }
  
  private String c(String paramString)
  {
    return null;
  }
  
  public Uri a(File paramFile, String paramString)
  {
    return null;
  }
  
  File a(Uri paramUri)
  {
    return null;
  }
  
  public File a(String paramString)
  {
    return null;
  }
  
  public void a(Context paramContext)
  {
    com.huawei.hms.c.a.a(paramContext, "context nust not be null.");
    this.a = paramContext;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hm\\update\provider\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */