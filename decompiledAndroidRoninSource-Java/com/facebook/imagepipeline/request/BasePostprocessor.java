package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.NativeCodeSetup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

public abstract class BasePostprocessor
  implements Postprocessor
{
  public static final Bitmap.Config FALLBACK_BITMAP_CONFIGURATION = Bitmap.Config.ARGB_8888;
  private static Method sCopyBitmap;
  
  private static void internalCopyBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((NativeCodeSetup.getUseNativeCode()) && (paramBitmap1.getConfig() == paramBitmap2.getConfig())) {
      try
      {
        if (sCopyBitmap == null) {
          sCopyBitmap = Class.forName("com.facebook.imagepipeline.nativecode.Bitmaps").getDeclaredMethod("copyBitmap", new Class[] { Bitmap.class, Bitmap.class });
        }
        sCopyBitmap.invoke(null, new Object[] { paramBitmap1, paramBitmap2 });
        return;
      }
      catch (InvocationTargetException paramBitmap1)
      {
        throw new RuntimeException("Wrong Native code setup, reflection failed.", paramBitmap1);
      }
      catch (NoSuchMethodException paramBitmap1)
      {
        throw new RuntimeException("Wrong Native code setup, reflection failed.", paramBitmap1);
      }
      catch (IllegalAccessException paramBitmap1)
      {
        throw new RuntimeException("Wrong Native code setup, reflection failed.", paramBitmap1);
      }
      catch (ClassNotFoundException paramBitmap1)
      {
        throw new RuntimeException("Wrong Native code setup, reflection failed.", paramBitmap1);
      }
    }
    new Canvas(paramBitmap1).drawBitmap(paramBitmap2, 0.0F, 0.0F, null);
  }
  
  public String getName()
  {
    return "Unknown postprocessor";
  }
  
  @Nullable
  public CacheKey getPostprocessorCacheKey()
  {
    return null;
  }
  
  public CloseableReference<Bitmap> process(Bitmap paramBitmap, PlatformBitmapFactory paramPlatformBitmapFactory)
  {
    Bitmap.Config localConfig = paramBitmap.getConfig();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (localConfig == null) {
      localConfig = FALLBACK_BITMAP_CONFIGURATION;
    }
    paramPlatformBitmapFactory = paramPlatformBitmapFactory.createBitmapInternal(i, j, localConfig);
    try
    {
      process((Bitmap)paramPlatformBitmapFactory.get(), paramBitmap);
      paramBitmap = CloseableReference.cloneOrNull(paramPlatformBitmapFactory);
      return paramBitmap;
    }
    finally
    {
      CloseableReference.closeSafely(paramPlatformBitmapFactory);
    }
  }
  
  public void process(Bitmap paramBitmap) {}
  
  public void process(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    internalCopyBitmap(paramBitmap1, paramBitmap2);
    process(paramBitmap1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\request\BasePostprocessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */