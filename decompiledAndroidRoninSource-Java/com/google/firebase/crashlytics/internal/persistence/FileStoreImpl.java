package com.google.firebase.crashlytics.internal.persistence;

import android.content.Context;
import android.os.Environment;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;

public class FileStoreImpl
  implements FileStore
{
  public static final String FILES_PATH = ".com.google.firebase.crashlytics";
  private final Context context;
  
  public FileStoreImpl(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public File getFilesDir()
  {
    return prepare(new File(this.context.getFilesDir(), ".com.google.firebase.crashlytics"));
  }
  
  public String getFilesDirPath()
  {
    return new File(this.context.getFilesDir(), ".com.google.firebase.crashlytics").getPath();
  }
  
  boolean isExternalStorageAvailable()
  {
    if (!"mounted".equals(Environment.getExternalStorageState()))
    {
      Logger.getLogger().w("External Storage is not mounted and/or writable\nHave you declared android.permission.WRITE_EXTERNAL_STORAGE in the manifest?");
      return false;
    }
    return true;
  }
  
  File prepare(File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists())
      {
        if (paramFile.mkdirs()) {
          return paramFile;
        }
        Logger.getLogger().w("Couldn't create file");
      }
      else
      {
        return paramFile;
      }
    }
    else {
      Logger.getLogger().d("Null File");
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\persistence\FileStoreImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */