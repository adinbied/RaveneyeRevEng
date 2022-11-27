package dji.thirdparty.afinal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import dji.thirdparty.afinal.bitmap.core.BitmapCache;
import dji.thirdparty.afinal.bitmap.core.BitmapDisplayConfig;
import dji.thirdparty.afinal.bitmap.core.BitmapProcess;
import dji.thirdparty.afinal.bitmap.display.Displayer;
import dji.thirdparty.afinal.bitmap.display.SimpleDisplayer;
import dji.thirdparty.afinal.bitmap.download.Downloader;
import dji.thirdparty.afinal.bitmap.download.SimpleDownloader;
import dji.thirdparty.afinal.core.AsyncTask;
import dji.thirdparty.afinal.utils.Utils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class FinalBitmap
{
  private static FinalBitmap mFinalBitmap;
  private ExecutorService bitmapLoadAndDisplayExecutor;
  private HashMap<String, BitmapDisplayConfig> configMap = new HashMap();
  private BitmapProcess mBitmapProcess;
  private FinalBitmapConfig mConfig;
  private Context mContext;
  private boolean mExitTasksEarly = false;
  private BitmapCache mImageCache;
  private boolean mInit = false;
  private boolean mPauseWork = false;
  private final Object mPauseWorkLock = new Object();
  
  private FinalBitmap(Context paramContext)
  {
    this.mContext = paramContext;
    this.mConfig = new FinalBitmapConfig(paramContext);
    configDiskCachePath(Utils.getDiskCacheDir(paramContext, "afinalCache").getAbsolutePath());
    configDisplayer(new SimpleDisplayer());
    configDownlader(new SimpleDownloader());
  }
  
  private static boolean checkImageTask(Object paramObject, View paramView)
  {
    paramView = getBitmapTaskFromImageView(paramView);
    if (paramView != null)
    {
      Object localObject = paramView.data;
      if ((localObject != null) && (localObject.equals(paramObject))) {
        return false;
      }
      paramView.cancel(true);
    }
    return true;
  }
  
  private void clearCacheInBackgroud(String paramString)
  {
    BitmapCache localBitmapCache = this.mImageCache;
    if (localBitmapCache != null) {
      localBitmapCache.clearCache(paramString);
    }
  }
  
  private void clearCacheInternalInBackgroud()
  {
    BitmapCache localBitmapCache = this.mImageCache;
    if (localBitmapCache != null) {
      localBitmapCache.clearCache();
    }
  }
  
  private void clearDiskCacheInBackgroud()
  {
    BitmapCache localBitmapCache = this.mImageCache;
    if (localBitmapCache != null) {
      localBitmapCache.clearDiskCache();
    }
  }
  
  private void clearDiskCacheInBackgroud(String paramString)
  {
    BitmapCache localBitmapCache = this.mImageCache;
    if (localBitmapCache != null) {
      localBitmapCache.clearDiskCache(paramString);
    }
  }
  
  /* Error */
  private void closeCache()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void closeCacheInternalInBackgroud()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static FinalBitmap create(Context paramContext)
  {
    try
    {
      if (mFinalBitmap == null) {
        mFinalBitmap = new FinalBitmap(paramContext.getApplicationContext());
      }
      paramContext = mFinalBitmap;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private void doDisplay(View arg1, String arg2, BitmapDisplayConfig arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static BitmapLoadAndDisplayTask getBitmapTaskFromImageView(View paramView)
  {
    if (paramView != null)
    {
      if ((paramView instanceof ImageView)) {
        paramView = ((ImageView)paramView).getDrawable();
      } else {
        paramView = paramView.getBackground();
      }
      if ((paramView instanceof AsyncDrawable)) {
        return ((AsyncDrawable)paramView).getBitmapWorkerTask();
      }
    }
    return null;
  }
  
  private BitmapDisplayConfig getDisplayConfig()
  {
    return null;
  }
  
  private FinalBitmap init()
  {
    return null;
  }
  
  private Bitmap processBitmap(String paramString, BitmapDisplayConfig paramBitmapDisplayConfig)
  {
    return null;
  }
  
  private void setExitTasksEarly(boolean paramBoolean)
  {
    this.mExitTasksEarly = paramBoolean;
  }
  
  /* Error */
  public void clearCache()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void clearCache(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void clearDiskCache()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void clearDiskCache(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void clearMemoryCache()
  {
    BitmapCache localBitmapCache = this.mImageCache;
    if (localBitmapCache != null) {
      localBitmapCache.clearMemoryCache();
    }
  }
  
  public void clearMemoryCache(String paramString)
  {
    BitmapCache localBitmapCache = this.mImageCache;
    if (localBitmapCache != null) {
      localBitmapCache.clearMemoryCache(paramString);
    }
  }
  
  public FinalBitmap configBitmapLoadThreadSize(int paramInt)
  {
    if (paramInt >= 1) {
      this.mConfig.poolSize = paramInt;
    }
    return this;
  }
  
  public FinalBitmap configBitmapMaxHeight(int paramInt)
  {
    this.mConfig.defaultDisplayConfig.setBitmapHeight(paramInt);
    return this;
  }
  
  public FinalBitmap configBitmapMaxWidth(int paramInt)
  {
    this.mConfig.defaultDisplayConfig.setBitmapWidth(paramInt);
    return this;
  }
  
  public FinalBitmap configDiskCachePath(String paramString)
  {
    return null;
  }
  
  public FinalBitmap configDiskCacheSize(int paramInt)
  {
    this.mConfig.diskCacheSize = paramInt;
    return this;
  }
  
  public FinalBitmap configDisplayer(Displayer paramDisplayer)
  {
    this.mConfig.displayer = paramDisplayer;
    return this;
  }
  
  public FinalBitmap configDownlader(Downloader paramDownloader)
  {
    this.mConfig.downloader = paramDownloader;
    return this;
  }
  
  public FinalBitmap configLoadfailImage(int paramInt)
  {
    return null;
  }
  
  public FinalBitmap configLoadfailImage(Bitmap paramBitmap)
  {
    this.mConfig.defaultDisplayConfig.setLoadfailBitmap(paramBitmap);
    return this;
  }
  
  public FinalBitmap configLoadingImage(int paramInt)
  {
    return null;
  }
  
  public FinalBitmap configLoadingImage(Bitmap paramBitmap)
  {
    this.mConfig.defaultDisplayConfig.setLoadingBitmap(paramBitmap);
    return this;
  }
  
  public FinalBitmap configMemoryCachePercent(float paramFloat)
  {
    this.mConfig.memCacheSizePercent = paramFloat;
    return this;
  }
  
  public FinalBitmap configMemoryCacheSize(int paramInt)
  {
    this.mConfig.memCacheSize = paramInt;
    return this;
  }
  
  public FinalBitmap configRecycleImmediately(boolean paramBoolean)
  {
    this.mConfig.recycleImmediately = paramBoolean;
    return this;
  }
  
  public void display(View paramView, String paramString)
  {
    doDisplay(paramView, paramString, null);
  }
  
  /* Error */
  public void display(View arg1, String arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void display(View arg1, String arg2, int arg3, int arg4, Bitmap arg5, Bitmap arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void display(View arg1, String arg2, Bitmap arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void display(View arg1, String arg2, Bitmap arg3, Bitmap arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void display(View paramView, String paramString, BitmapDisplayConfig paramBitmapDisplayConfig)
  {
    doDisplay(paramView, paramString, paramBitmapDisplayConfig);
  }
  
  public void exitTasksEarly(boolean paramBoolean)
  {
    this.mExitTasksEarly = paramBoolean;
    if (paramBoolean) {
      pauseWork(false);
    }
  }
  
  public Bitmap getBitmapFromCache(String paramString)
  {
    return null;
  }
  
  public Bitmap getBitmapFromDiskCache(String paramString)
  {
    return getBitmapFromDiskCache(paramString, null);
  }
  
  public Bitmap getBitmapFromDiskCache(String paramString, BitmapDisplayConfig paramBitmapDisplayConfig)
  {
    return this.mBitmapProcess.getFromDisk(paramString, paramBitmapDisplayConfig);
  }
  
  public Bitmap getBitmapFromMemoryCache(String paramString)
  {
    return this.mImageCache.getBitmapFromMemoryCache(paramString);
  }
  
  public void onDestroy()
  {
    closeCache();
  }
  
  public void onPause()
  {
    setExitTasksEarly(true);
  }
  
  public void onResume()
  {
    setExitTasksEarly(false);
  }
  
  /* Error */
  public void pauseWork(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  private static class AsyncDrawable
    extends BitmapDrawable
  {
    private final WeakReference<FinalBitmap.BitmapLoadAndDisplayTask> bitmapWorkerTaskReference;
    
    public AsyncDrawable(Resources paramResources, Bitmap paramBitmap, FinalBitmap.BitmapLoadAndDisplayTask paramBitmapLoadAndDisplayTask)
    {
      super(paramBitmap);
      this.bitmapWorkerTaskReference = new WeakReference(paramBitmapLoadAndDisplayTask);
    }
    
    public FinalBitmap.BitmapLoadAndDisplayTask getBitmapWorkerTask()
    {
      return null;
    }
  }
  
  private class BitmapLoadAndDisplayTask
    extends AsyncTask<Object, Void, Bitmap>
  {
    private Object data;
    private final BitmapDisplayConfig displayConfig;
    private final WeakReference<View> imageViewReference;
    
    public BitmapLoadAndDisplayTask(View paramView, BitmapDisplayConfig paramBitmapDisplayConfig)
    {
      this.imageViewReference = new WeakReference(paramView);
      this.displayConfig = paramBitmapDisplayConfig;
    }
    
    private View getAttachedImageView()
    {
      return null;
    }
    
    protected Bitmap doInBackground(Object... paramVarArgs)
    {
      return null;
    }
    
    /* Error */
    protected void onCancelled(Bitmap arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    protected void onPostExecute(Bitmap arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private class CacheExecutecTask
    extends AsyncTask<Object, Void, Void>
  {
    public static final int MESSAGE_CLEAR = 1;
    public static final int MESSAGE_CLEAR_DISK = 3;
    public static final int MESSAGE_CLEAR_KEY = 4;
    public static final int MESSAGE_CLEAR_KEY_IN_DISK = 5;
    public static final int MESSAGE_CLOSE = 2;
    
    private CacheExecutecTask() {}
    
    protected Void doInBackground(Object... paramVarArgs)
    {
      return null;
    }
  }
  
  private class FinalBitmapConfig
  {
    public String cachePath;
    public BitmapDisplayConfig defaultDisplayConfig;
    public int diskCacheSize;
    public Displayer displayer;
    public Downloader downloader;
    public int memCacheSize;
    public float memCacheSizePercent;
    public int poolSize = 3;
    public boolean recycleImmediately = true;
    
    public FinalBitmapConfig(Context paramContext)
    {
      this$1 = new BitmapDisplayConfig();
      this.defaultDisplayConfig = FinalBitmap.this;
      FinalBitmap.this.setAnimation(null);
      this.defaultDisplayConfig.setAnimationType(1);
      int i = (int)Math.floor(paramContext.getResources().getDisplayMetrics().widthPixels / 2);
      this.defaultDisplayConfig.setBitmapHeight(i);
      this.defaultDisplayConfig.setBitmapWidth(i);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\FinalBitmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */