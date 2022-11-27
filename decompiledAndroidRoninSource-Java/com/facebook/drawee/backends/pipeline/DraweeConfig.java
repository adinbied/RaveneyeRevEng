package com.facebook.drawee.backends.pipeline;

import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class DraweeConfig
{
  @Nullable
  private final ImmutableList<DrawableFactory> mCustomDrawableFactories;
  private final Supplier<Boolean> mDebugOverlayEnabledSupplier;
  @Nullable
  private final ImagePerfDataListener mImagePerfDataListener;
  @Nullable
  private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;
  
  private DraweeConfig(Builder paramBuilder)
  {
    Object localObject;
    if (paramBuilder.mCustomDrawableFactories != null) {
      localObject = ImmutableList.copyOf(paramBuilder.mCustomDrawableFactories);
    } else {
      localObject = null;
    }
    this.mCustomDrawableFactories = ((ImmutableList)localObject);
    if (paramBuilder.mDebugOverlayEnabledSupplier != null) {
      localObject = paramBuilder.mDebugOverlayEnabledSupplier;
    } else {
      localObject = Suppliers.of(Boolean.valueOf(false));
    }
    this.mDebugOverlayEnabledSupplier = ((Supplier)localObject);
    this.mPipelineDraweeControllerFactory = paramBuilder.mPipelineDraweeControllerFactory;
    this.mImagePerfDataListener = paramBuilder.mImagePerfDataListener;
  }
  
  public static Builder newBuilder()
  {
    return new Builder();
  }
  
  @Nullable
  public ImmutableList<DrawableFactory> getCustomDrawableFactories()
  {
    return this.mCustomDrawableFactories;
  }
  
  public Supplier<Boolean> getDebugOverlayEnabledSupplier()
  {
    return this.mDebugOverlayEnabledSupplier;
  }
  
  @Nullable
  public ImagePerfDataListener getImagePerfDataListener()
  {
    return this.mImagePerfDataListener;
  }
  
  @Nullable
  public PipelineDraweeControllerFactory getPipelineDraweeControllerFactory()
  {
    return this.mPipelineDraweeControllerFactory;
  }
  
  public static class Builder
  {
    private List<DrawableFactory> mCustomDrawableFactories;
    private Supplier<Boolean> mDebugOverlayEnabledSupplier;
    @Nullable
    private ImagePerfDataListener mImagePerfDataListener;
    private PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;
    
    public Builder addCustomDrawableFactory(DrawableFactory paramDrawableFactory)
    {
      if (this.mCustomDrawableFactories == null) {
        this.mCustomDrawableFactories = new ArrayList();
      }
      this.mCustomDrawableFactories.add(paramDrawableFactory);
      return this;
    }
    
    public DraweeConfig build()
    {
      return new DraweeConfig(this, null);
    }
    
    public Builder setDebugOverlayEnabledSupplier(Supplier<Boolean> paramSupplier)
    {
      Preconditions.checkNotNull(paramSupplier);
      this.mDebugOverlayEnabledSupplier = paramSupplier;
      return this;
    }
    
    public Builder setDrawDebugOverlay(boolean paramBoolean)
    {
      return setDebugOverlayEnabledSupplier(Suppliers.of(Boolean.valueOf(paramBoolean)));
    }
    
    public Builder setImagePerfDataListener(@Nullable ImagePerfDataListener paramImagePerfDataListener)
    {
      this.mImagePerfDataListener = paramImagePerfDataListener;
      return this;
    }
    
    public Builder setPipelineDraweeControllerFactory(PipelineDraweeControllerFactory paramPipelineDraweeControllerFactory)
    {
      this.mPipelineDraweeControllerFactory = paramPipelineDraweeControllerFactory;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\DraweeConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */