package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import java.util.Set;
import javax.annotation.Nullable;

public class PipelineDraweeControllerBuilderSupplier
  implements Supplier<PipelineDraweeControllerBuilder>
{
  private final Set<ControllerListener> mBoundControllerListeners;
  private final Set<ControllerListener2> mBoundControllerListeners2;
  private final Context mContext;
  @Nullable
  private final ImagePerfDataListener mDefaultImagePerfDataListener;
  private final ImagePipeline mImagePipeline;
  private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;
  
  public PipelineDraweeControllerBuilderSupplier(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PipelineDraweeControllerBuilderSupplier(Context paramContext, @Nullable DraweeConfig paramDraweeConfig)
  {
    this(paramContext, ImagePipelineFactory.getInstance(), paramDraweeConfig);
  }
  
  public PipelineDraweeControllerBuilderSupplier(Context paramContext, ImagePipelineFactory paramImagePipelineFactory, @Nullable DraweeConfig paramDraweeConfig)
  {
    this(paramContext, paramImagePipelineFactory, null, null, paramDraweeConfig);
  }
  
  public PipelineDraweeControllerBuilderSupplier(Context paramContext, ImagePipelineFactory paramImagePipelineFactory, Set<ControllerListener> paramSet, Set<ControllerListener2> paramSet1, @Nullable DraweeConfig paramDraweeConfig)
  {
    this.mContext = paramContext;
    this.mImagePipeline = paramImagePipelineFactory.getImagePipeline();
    if ((paramDraweeConfig != null) && (paramDraweeConfig.getPipelineDraweeControllerFactory() != null)) {
      this.mPipelineDraweeControllerFactory = paramDraweeConfig.getPipelineDraweeControllerFactory();
    } else {
      this.mPipelineDraweeControllerFactory = new PipelineDraweeControllerFactory();
    }
    PipelineDraweeControllerFactory localPipelineDraweeControllerFactory = this.mPipelineDraweeControllerFactory;
    Resources localResources = paramContext.getResources();
    DeferredReleaser localDeferredReleaser = DeferredReleaser.getInstance();
    DrawableFactory localDrawableFactory = paramImagePipelineFactory.getAnimatedDrawableFactory(paramContext);
    UiThreadImmediateExecutorService localUiThreadImmediateExecutorService = UiThreadImmediateExecutorService.getInstance();
    MemoryCache localMemoryCache = this.mImagePipeline.getBitmapMemoryCache();
    Object localObject = null;
    if (paramDraweeConfig != null) {
      paramContext = paramDraweeConfig.getCustomDrawableFactories();
    } else {
      paramContext = null;
    }
    if (paramDraweeConfig != null) {
      paramImagePipelineFactory = paramDraweeConfig.getDebugOverlayEnabledSupplier();
    } else {
      paramImagePipelineFactory = null;
    }
    localPipelineDraweeControllerFactory.init(localResources, localDeferredReleaser, localDrawableFactory, localUiThreadImmediateExecutorService, localMemoryCache, paramContext, paramImagePipelineFactory);
    this.mBoundControllerListeners = paramSet;
    this.mBoundControllerListeners2 = paramSet1;
    paramContext = (Context)localObject;
    if (paramDraweeConfig != null) {
      paramContext = paramDraweeConfig.getImagePerfDataListener();
    }
    this.mDefaultImagePerfDataListener = paramContext;
  }
  
  public PipelineDraweeControllerBuilder get()
  {
    return new PipelineDraweeControllerBuilder(this.mContext, this.mPipelineDraweeControllerFactory, this.mImagePipeline, this.mBoundControllerListeners, this.mBoundControllerListeners2).setPerfDataListener(this.mDefaultImagePerfDataListener);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\PipelineDraweeControllerBuilderSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */