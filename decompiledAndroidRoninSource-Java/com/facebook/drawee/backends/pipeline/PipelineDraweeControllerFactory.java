package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class PipelineDraweeControllerFactory
{
  private DrawableFactory mAnimatedDrawableFactory;
  @Nullable
  private Supplier<Boolean> mDebugOverlayEnabledSupplier;
  private DeferredReleaser mDeferredReleaser;
  @Nullable
  private ImmutableList<DrawableFactory> mDrawableFactories;
  private MemoryCache<CacheKey, CloseableImage> mMemoryCache;
  private Resources mResources;
  private Executor mUiThreadExecutor;
  
  public void init(Resources paramResources, DeferredReleaser paramDeferredReleaser, DrawableFactory paramDrawableFactory, Executor paramExecutor, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, @Nullable ImmutableList<DrawableFactory> paramImmutableList, @Nullable Supplier<Boolean> paramSupplier)
  {
    this.mResources = paramResources;
    this.mDeferredReleaser = paramDeferredReleaser;
    this.mAnimatedDrawableFactory = paramDrawableFactory;
    this.mUiThreadExecutor = paramExecutor;
    this.mMemoryCache = paramMemoryCache;
    this.mDrawableFactories = paramImmutableList;
    this.mDebugOverlayEnabledSupplier = paramSupplier;
  }
  
  protected PipelineDraweeController internalCreateController(Resources paramResources, DeferredReleaser paramDeferredReleaser, DrawableFactory paramDrawableFactory, Executor paramExecutor, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, @Nullable ImmutableList<DrawableFactory> paramImmutableList)
  {
    return new PipelineDraweeController(paramResources, paramDeferredReleaser, paramDrawableFactory, paramExecutor, paramMemoryCache, paramImmutableList);
  }
  
  public PipelineDraweeController newController()
  {
    PipelineDraweeController localPipelineDraweeController = internalCreateController(this.mResources, this.mDeferredReleaser, this.mAnimatedDrawableFactory, this.mUiThreadExecutor, this.mMemoryCache, this.mDrawableFactories);
    Supplier localSupplier = this.mDebugOverlayEnabledSupplier;
    if (localSupplier != null) {
      localPipelineDraweeController.setDrawDebugOverlay(((Boolean)localSupplier.get()).booleanValue());
    }
    return localPipelineDraweeController;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\PipelineDraweeControllerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */