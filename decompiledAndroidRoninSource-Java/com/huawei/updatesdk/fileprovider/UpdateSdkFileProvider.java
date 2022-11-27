package com.huawei.updatesdk.fileprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileNotFoundException;

public class UpdateSdkFileProvider
  extends ContentProvider
{
  public static final String AUTHORITIES_SUFFIX = ".updateSdk.fileProvider";
  private static final String[] COLUMNS = { "_display_name", "_size" };
  private static final String TAG = "UpdateSdkFileProvider";
  private static a mWStrategy;
  private String authority;
  
  private static File buildPath(File paramFile, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      File localFile = paramFile;
      if (str != null) {
        localFile = new File(paramFile, str);
      }
      i += 1;
      paramFile = localFile;
    }
    return paramFile;
  }
  
  private static Object[] copyOf(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }
  
  private static String[] copyOf(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }
  
  private static a createWiseDistPathStrategy(Context paramContext, String paramString)
  {
    try
    {
      if (mWStrategy == null)
      {
        mWStrategy = new b(paramString);
        if (paramContext.getFilesDir() != null)
        {
          paramContext = buildPath(paramContext.getFilesDir(), new String[] { "/" });
          mWStrategy.a("updatesdkapk", paramContext);
        }
      }
      paramContext = mWStrategy;
      return paramContext;
    }
    finally {}
  }
  
  public static Uri getUriForFile(Context paramContext, String paramString, File paramFile)
  {
    createWiseDistPathStrategy(paramContext, paramString);
    return mWStrategy.a(paramFile);
  }
  
  /* Error */
  public void attachInfo(Context arg1, android.content.pm.ProviderInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
    throws FileNotFoundException
  {
    return null;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\fileprovider\UpdateSdkFileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */