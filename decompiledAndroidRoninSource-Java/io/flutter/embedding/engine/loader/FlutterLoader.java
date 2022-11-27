package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Handler;

public class FlutterLoader
{
  private static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
  private static final String DEFAULT_AOT_SHARED_LIBRARY_NAME = "libapp.so";
  private static final String DEFAULT_FLUTTER_ASSETS_DIR = "flutter_assets";
  private static final String DEFAULT_ISOLATE_SNAPSHOT_DATA = "isolate_snapshot_data";
  private static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
  private static final String DEFAULT_LIBRARY = "libflutter.so";
  private static final String DEFAULT_VM_SNAPSHOT_DATA = "vm_snapshot_data";
  private static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
  private static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
  private static final String PUBLIC_AOT_SHARED_LIBRARY_NAME;
  private static final String PUBLIC_FLUTTER_ASSETS_DIR_KEY;
  private static final String PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY;
  private static final String PUBLIC_VM_SNAPSHOT_DATA_KEY;
  private static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
  private static final String TAG = "FlutterLoader";
  private static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
  private static FlutterLoader instance;
  private String aotSharedLibraryName = "libapp.so";
  private String flutterAssetsDir = "flutter_assets";
  private boolean initialized = false;
  private String isolateSnapshotData = "isolate_snapshot_data";
  private ResourceExtractor resourceExtractor;
  private Settings settings;
  private String vmSnapshotData = "vm_snapshot_data";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterLoader.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("aot-shared-library-name");
    PUBLIC_AOT_SHARED_LIBRARY_NAME = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterLoader.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("vm-snapshot-data");
    PUBLIC_VM_SNAPSHOT_DATA_KEY = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterLoader.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("isolate-snapshot-data");
    PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterLoader.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("flutter-assets-dir");
    PUBLIC_FLUTTER_ASSETS_DIR_KEY = localStringBuilder.toString();
  }
  
  private String fullAssetPathFrom(String paramString)
  {
    return null;
  }
  
  private ApplicationInfo getApplicationInfo(Context paramContext)
  {
    return null;
  }
  
  public static FlutterLoader getInstance()
  {
    if (instance == null) {
      instance = new FlutterLoader();
    }
    return instance;
  }
  
  /* Error */
  private void initConfig(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initResources(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void ensureInitializationComplete(Context arg1, String[] arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void ensureInitializationCompleteAsync(Context arg1, String[] arg2, Handler arg3, Runnable arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String findAppBundlePath()
  {
    return this.flutterAssetsDir;
  }
  
  public String getLookupKeyForAsset(String paramString)
  {
    return fullAssetPathFrom(paramString);
  }
  
  public String getLookupKeyForAsset(String paramString1, String paramString2)
  {
    return null;
  }
  
  /* Error */
  public void startInitialization(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startInitialization(Context arg1, Settings arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class Settings
  {
    private String logTag;
    
    public String getLogTag()
    {
      return this.logTag;
    }
    
    public void setLogTag(String paramString)
    {
      this.logTag = paramString;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\loader\FlutterLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */