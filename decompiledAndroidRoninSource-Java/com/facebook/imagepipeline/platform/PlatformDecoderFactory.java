package com.facebook.imagepipeline.platform;

import android.os.Build.VERSION;
import androidx.core.util.Pools.SynchronizedPool;
import com.facebook.imagepipeline.core.NativeCodeSetup;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.PoolFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PlatformDecoderFactory
{
  public static PlatformDecoder buildPlatformDecoder(PoolFactory paramPoolFactory, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      i = paramPoolFactory.getFlexByteArrayPoolMaxNumThreads();
      return new OreoDecoder(paramPoolFactory.getBitmapPool(), i, new Pools.SynchronizedPool(i));
    }
    if ((Build.VERSION.SDK_INT < 21) && (NativeCodeSetup.getUseNativeCode()))
    {
      if (paramBoolean) {}
      try
      {
        if (Build.VERSION.SDK_INT < 19) {
          return (PlatformDecoder)Class.forName("com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder").getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        paramPoolFactory = (PlatformDecoder)Class.forName("com.facebook.imagepipeline.platform.KitKatPurgeableDecoder").getConstructor(new Class[] { FlexByteArrayPool.class }).newInstance(new Object[] { paramPoolFactory.getFlexByteArrayPool() });
        return paramPoolFactory;
      }
      catch (InstantiationException paramPoolFactory)
      {
        throw new RuntimeException("Wrong Native code setup, reflection failed.", paramPoolFactory);
      }
      catch (InvocationTargetException paramPoolFactory)
      {
        throw new RuntimeException("Wrong Native code setup, reflection failed.", paramPoolFactory);
      }
      catch (NoSuchMethodException paramPoolFactory)
      {
        throw new RuntimeException("Wrong Native code setup, reflection failed.", paramPoolFactory);
      }
      catch (IllegalAccessException paramPoolFactory)
      {
        throw new RuntimeException("Wrong Native code setup, reflection failed.", paramPoolFactory);
      }
      catch (ClassNotFoundException paramPoolFactory)
      {
        throw new RuntimeException("Wrong Native code setup, reflection failed.", paramPoolFactory);
      }
    }
    int i = paramPoolFactory.getFlexByteArrayPoolMaxNumThreads();
    return new ArtDecoder(paramPoolFactory.getBitmapPool(), i, new Pools.SynchronizedPool(i));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\platform\PlatformDecoderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */