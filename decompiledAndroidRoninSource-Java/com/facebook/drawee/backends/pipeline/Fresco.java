package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.core.NativeCodeSetup;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.soloader.nativeloader.NativeLoader;
import com.facebook.soloader.nativeloader.SystemDelegate;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

public class Fresco
{
  private static final Class<?> TAG = Fresco.class;
  private static PipelineDraweeControllerBuilderSupplier sDraweeControllerBuilderSupplier;
  private static volatile boolean sIsInitialized;
  
  public static PipelineDraweeControllerBuilderSupplier getDraweeControllerBuilderSupplier()
  {
    return sDraweeControllerBuilderSupplier;
  }
  
  public static ImagePipeline getImagePipeline()
  {
    return getImagePipelineFactory().getImagePipeline();
  }
  
  public static ImagePipelineFactory getImagePipelineFactory()
  {
    return ImagePipelineFactory.getInstance();
  }
  
  public static boolean hasBeenInitialized()
  {
    return sIsInitialized;
  }
  
  public static void initialize(Context paramContext)
  {
    initialize(paramContext, null, null);
  }
  
  public static void initialize(Context paramContext, @Nullable ImagePipelineConfig paramImagePipelineConfig)
  {
    initialize(paramContext, paramImagePipelineConfig, null);
  }
  
  public static void initialize(Context paramContext, @Nullable ImagePipelineConfig paramImagePipelineConfig, @Nullable DraweeConfig paramDraweeConfig)
  {
    initialize(paramContext, paramImagePipelineConfig, paramDraweeConfig, true);
  }
  
  public static void initialize(Context paramContext, @Nullable ImagePipelineConfig paramImagePipelineConfig, @Nullable DraweeConfig paramDraweeConfig, boolean paramBoolean)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("Fresco#initialize");
    }
    if (sIsInitialized) {
      FLog.w(TAG, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
    } else {
      sIsInitialized = true;
    }
    NativeCodeSetup.setUseNativeCode(paramBoolean);
    if (!NativeLoader.isInitialized()) {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("Fresco.initialize->SoLoader.init");
      }
    }
    try
    {
      try
      {
        Class.forName("com.facebook.imagepipeline.nativecode.NativeCodeInitializer").getMethod("init", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
        if (!FrescoSystrace.isTracing()) {
          break label188;
        }
      }
      finally
      {
        break label177;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    NativeLoader.init(new SystemDelegate());
    if (FrescoSystrace.isTracing())
    {
      break label171;
      NativeLoader.init(new SystemDelegate());
      if (FrescoSystrace.isTracing())
      {
        break label171;
        NativeLoader.init(new SystemDelegate());
        if (FrescoSystrace.isTracing())
        {
          break label171;
          NativeLoader.init(new SystemDelegate());
          if (FrescoSystrace.isTracing())
          {
            label171:
            FrescoSystrace.endSection();
            break label188;
            label177:
            if (FrescoSystrace.isTracing()) {
              FrescoSystrace.endSection();
            }
            throw paramContext;
          }
        }
      }
    }
    label188:
    paramContext = paramContext.getApplicationContext();
    if (paramImagePipelineConfig == null) {
      ImagePipelineFactory.initialize(paramContext);
    } else {
      ImagePipelineFactory.initialize(paramImagePipelineConfig);
    }
    initializeDrawee(paramContext, paramDraweeConfig);
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
  }
  
  private static void initializeDrawee(Context paramContext, @Nullable DraweeConfig paramDraweeConfig)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("Fresco.initializeDrawee");
    }
    paramContext = new PipelineDraweeControllerBuilderSupplier(paramContext, paramDraweeConfig);
    sDraweeControllerBuilderSupplier = paramContext;
    SimpleDraweeView.initialize(paramContext);
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
  }
  
  public static PipelineDraweeControllerBuilder newDraweeControllerBuilder()
  {
    return sDraweeControllerBuilderSupplier.get();
  }
  
  public static void shutDown()
  {
    sDraweeControllerBuilderSupplier = null;
    SimpleDraweeView.shutDown();
    ImagePipelineFactory.shutDown();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\Fresco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */