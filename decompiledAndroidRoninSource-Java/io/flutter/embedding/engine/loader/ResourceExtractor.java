package io.flutter.embedding.engine.loader;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

class ResourceExtractor
{
  private static final String[] SUPPORTED_ABIS = ;
  private static final String TAG = "ResourceExtractor";
  private static final String TIMESTAMP_PREFIX = "res_timestamp-";
  private final AssetManager mAssetManager;
  private final String mDataDirPath;
  private ExtractTask mExtractTask;
  private final PackageManager mPackageManager;
  private final String mPackageName;
  private final HashSet<String> mResources;
  
  ResourceExtractor(String paramString1, String paramString2, PackageManager paramPackageManager, AssetManager paramAssetManager)
  {
    this.mDataDirPath = paramString1;
    this.mPackageName = paramString2;
    this.mPackageManager = paramPackageManager;
    this.mAssetManager = paramAssetManager;
    this.mResources = new HashSet();
  }
  
  private static String checkTimestamp(File paramFile, PackageManager paramPackageManager, String paramString)
  {
    try
    {
      paramPackageManager = paramPackageManager.getPackageInfo(paramString, 0);
      if (paramPackageManager == null) {
        return "res_timestamp-";
      }
      paramString = new StringBuilder();
      paramString.append("res_timestamp-");
      paramString.append(getVersionCode(paramPackageManager));
      paramString.append("-");
      paramString.append(paramPackageManager.lastUpdateTime);
      paramPackageManager = paramString.toString();
      paramFile = getExistingTimestamps(paramFile);
      if (paramFile == null) {
        return paramPackageManager;
      }
      int i = paramFile.length;
      if (paramFile.length == 1)
      {
        if (!paramPackageManager.equals(paramFile[0])) {
          return paramPackageManager;
        }
        return null;
      }
      return paramPackageManager;
    }
    catch (PackageManager.NameNotFoundException paramFile) {}
    return "res_timestamp-";
  }
  
  private static void copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['䀀'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i < 0) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private static void deleteFiles(String paramString, HashSet<String> paramHashSet)
  {
    paramString = new File(paramString);
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      File localFile = new File(paramString, (String)paramHashSet.next());
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    paramHashSet = getExistingTimestamps(paramString);
    if (paramHashSet == null) {
      return;
    }
    int j = paramHashSet.length;
    int i = 0;
    while (i < j)
    {
      new File(paramString, paramHashSet[i]).delete();
      i += 1;
    }
  }
  
  private static String[] getExistingTimestamps(File paramFile)
  {
    paramFile.list(new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.startsWith("res_timestamp-");
      }
    });
  }
  
  private static String[] getSupportedAbis()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return Build.SUPPORTED_ABIS;
    }
    ArrayList localArrayList = new ArrayList(Arrays.asList(new String[] { Build.CPU_ABI, Build.CPU_ABI2 }));
    localArrayList.removeAll(Arrays.asList(new String[] { null, "" }));
    return (String[])localArrayList.toArray(new String[0]);
  }
  
  static long getVersionCode(PackageInfo paramPackageInfo)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramPackageInfo.getLongVersionCode();
    }
    return paramPackageInfo.versionCode;
  }
  
  ResourceExtractor addResource(String paramString)
  {
    this.mResources.add(paramString);
    return this;
  }
  
  ResourceExtractor addResources(Collection<String> paramCollection)
  {
    this.mResources.addAll(paramCollection);
    return this;
  }
  
  ResourceExtractor start()
  {
    return null;
  }
  
  /* Error */
  void waitForCompletion()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private static class ExtractTask
    extends AsyncTask<Void, Void, Void>
  {
    private final AssetManager mAssetManager;
    private final String mDataDirPath;
    private final PackageManager mPackageManager;
    private final String mPackageName;
    private final HashSet<String> mResources;
    
    ExtractTask(String paramString1, HashSet<String> paramHashSet, String paramString2, PackageManager paramPackageManager, AssetManager paramAssetManager)
    {
      this.mDataDirPath = paramString1;
      this.mResources = paramHashSet;
      this.mAssetManager = paramAssetManager;
      this.mPackageName = paramString2;
      this.mPackageManager = paramPackageManager;
    }
    
    private boolean extractAPK(File paramFile)
    {
      return false;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\loader\ResourceExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */