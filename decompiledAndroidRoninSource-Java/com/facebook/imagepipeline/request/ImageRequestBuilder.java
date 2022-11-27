package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineConfig.DefaultImageRequestConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import javax.annotation.Nullable;

public class ImageRequestBuilder
{
  @Nullable
  private BytesRange mBytesRange = null;
  private ImageRequest.CacheChoice mCacheChoice = ImageRequest.CacheChoice.DEFAULT;
  @Nullable
  private Boolean mDecodePrefetches = null;
  private boolean mDiskCacheEnabled = true;
  private ImageDecodeOptions mImageDecodeOptions = ImageDecodeOptions.defaults();
  private boolean mLocalThumbnailPreviewsEnabled = false;
  private ImageRequest.RequestLevel mLowestPermittedRequestLevel = ImageRequest.RequestLevel.FULL_FETCH;
  private boolean mMemoryCacheEnabled = true;
  @Nullable
  private Postprocessor mPostprocessor = null;
  private boolean mProgressiveRenderingEnabled = ImagePipelineConfig.getDefaultImageRequestConfig().isProgressiveRenderingEnabled();
  @Nullable
  private RequestListener mRequestListener;
  private Priority mRequestPriority = Priority.HIGH;
  @Nullable
  private ResizeOptions mResizeOptions = null;
  @Nullable
  private Boolean mResizingAllowedOverride = null;
  @Nullable
  private RotationOptions mRotationOptions = null;
  private Uri mSourceUri = null;
  
  public static ImageRequestBuilder fromRequest(ImageRequest paramImageRequest)
  {
    return newBuilderWithSource(paramImageRequest.getSourceUri()).setImageDecodeOptions(paramImageRequest.getImageDecodeOptions()).setBytesRange(paramImageRequest.getBytesRange()).setCacheChoice(paramImageRequest.getCacheChoice()).setLocalThumbnailPreviewsEnabled(paramImageRequest.getLocalThumbnailPreviewsEnabled()).setLowestPermittedRequestLevel(paramImageRequest.getLowestPermittedRequestLevel()).setPostprocessor(paramImageRequest.getPostprocessor()).setProgressiveRenderingEnabled(paramImageRequest.getProgressiveRenderingEnabled()).setRequestPriority(paramImageRequest.getPriority()).setResizeOptions(paramImageRequest.getResizeOptions()).setRequestListener(paramImageRequest.getRequestListener()).setRotationOptions(paramImageRequest.getRotationOptions()).setShouldDecodePrefetches(paramImageRequest.shouldDecodePrefetches());
  }
  
  public static ImageRequestBuilder newBuilderWithResourceId(int paramInt)
  {
    return newBuilderWithSource(UriUtil.getUriForResourceId(paramInt));
  }
  
  public static ImageRequestBuilder newBuilderWithSource(Uri paramUri)
  {
    return new ImageRequestBuilder().setSource(paramUri);
  }
  
  public ImageRequest build()
  {
    validate();
    return new ImageRequest(this);
  }
  
  public ImageRequestBuilder disableDiskCache()
  {
    this.mDiskCacheEnabled = false;
    return this;
  }
  
  public ImageRequestBuilder disableMemoryCache()
  {
    this.mMemoryCacheEnabled = false;
    return this;
  }
  
  @Nullable
  public BytesRange getBytesRange()
  {
    return this.mBytesRange;
  }
  
  public ImageRequest.CacheChoice getCacheChoice()
  {
    return this.mCacheChoice;
  }
  
  public ImageDecodeOptions getImageDecodeOptions()
  {
    return this.mImageDecodeOptions;
  }
  
  public ImageRequest.RequestLevel getLowestPermittedRequestLevel()
  {
    return this.mLowestPermittedRequestLevel;
  }
  
  @Nullable
  public Postprocessor getPostprocessor()
  {
    return this.mPostprocessor;
  }
  
  @Nullable
  public RequestListener getRequestListener()
  {
    return this.mRequestListener;
  }
  
  public Priority getRequestPriority()
  {
    return this.mRequestPriority;
  }
  
  @Nullable
  public ResizeOptions getResizeOptions()
  {
    return this.mResizeOptions;
  }
  
  @Nullable
  public Boolean getResizingAllowedOverride()
  {
    return this.mResizingAllowedOverride;
  }
  
  @Nullable
  public RotationOptions getRotationOptions()
  {
    return this.mRotationOptions;
  }
  
  public Uri getSourceUri()
  {
    return this.mSourceUri;
  }
  
  public boolean isDiskCacheEnabled()
  {
    return (this.mDiskCacheEnabled) && (UriUtil.isNetworkUri(this.mSourceUri));
  }
  
  public boolean isLocalThumbnailPreviewsEnabled()
  {
    return this.mLocalThumbnailPreviewsEnabled;
  }
  
  public boolean isMemoryCacheEnabled()
  {
    return this.mMemoryCacheEnabled;
  }
  
  public boolean isProgressiveRenderingEnabled()
  {
    return this.mProgressiveRenderingEnabled;
  }
  
  @Deprecated
  public ImageRequestBuilder setAutoRotateEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {
      return setRotationOptions(RotationOptions.autoRotate());
    }
    return setRotationOptions(RotationOptions.disableRotation());
  }
  
  public ImageRequestBuilder setBytesRange(@Nullable BytesRange paramBytesRange)
  {
    this.mBytesRange = paramBytesRange;
    return this;
  }
  
  public ImageRequestBuilder setCacheChoice(ImageRequest.CacheChoice paramCacheChoice)
  {
    this.mCacheChoice = paramCacheChoice;
    return this;
  }
  
  public ImageRequestBuilder setImageDecodeOptions(ImageDecodeOptions paramImageDecodeOptions)
  {
    this.mImageDecodeOptions = paramImageDecodeOptions;
    return this;
  }
  
  public ImageRequestBuilder setLocalThumbnailPreviewsEnabled(boolean paramBoolean)
  {
    this.mLocalThumbnailPreviewsEnabled = paramBoolean;
    return this;
  }
  
  public ImageRequestBuilder setLowestPermittedRequestLevel(ImageRequest.RequestLevel paramRequestLevel)
  {
    this.mLowestPermittedRequestLevel = paramRequestLevel;
    return this;
  }
  
  public ImageRequestBuilder setPostprocessor(@Nullable Postprocessor paramPostprocessor)
  {
    this.mPostprocessor = paramPostprocessor;
    return this;
  }
  
  public ImageRequestBuilder setProgressiveRenderingEnabled(boolean paramBoolean)
  {
    this.mProgressiveRenderingEnabled = paramBoolean;
    return this;
  }
  
  public ImageRequestBuilder setRequestListener(RequestListener paramRequestListener)
  {
    this.mRequestListener = paramRequestListener;
    return this;
  }
  
  public ImageRequestBuilder setRequestPriority(Priority paramPriority)
  {
    this.mRequestPriority = paramPriority;
    return this;
  }
  
  public ImageRequestBuilder setResizeOptions(@Nullable ResizeOptions paramResizeOptions)
  {
    this.mResizeOptions = paramResizeOptions;
    return this;
  }
  
  public ImageRequestBuilder setResizingAllowedOverride(@Nullable Boolean paramBoolean)
  {
    this.mResizingAllowedOverride = paramBoolean;
    return this;
  }
  
  public ImageRequestBuilder setRotationOptions(@Nullable RotationOptions paramRotationOptions)
  {
    this.mRotationOptions = paramRotationOptions;
    return this;
  }
  
  public ImageRequestBuilder setShouldDecodePrefetches(@Nullable Boolean paramBoolean)
  {
    this.mDecodePrefetches = paramBoolean;
    return this;
  }
  
  public ImageRequestBuilder setSource(Uri paramUri)
  {
    Preconditions.checkNotNull(paramUri);
    this.mSourceUri = paramUri;
    return this;
  }
  
  @Nullable
  public Boolean shouldDecodePrefetches()
  {
    return this.mDecodePrefetches;
  }
  
  protected void validate()
  {
    Uri localUri = this.mSourceUri;
    if ((localUri == null) || ((!UriUtil.isLocalResourceUri(localUri)) || ((!this.mSourceUri.isAbsolute()) || (!this.mSourceUri.getPath().isEmpty())))) {}
    try
    {
      Integer.parseInt(this.mSourceUri.getPath().substring(1));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    throw new BuilderException("Resource URI path must be a resource id.");
    throw new BuilderException("Resource URI must not be empty");
    throw new BuilderException("Resource URI path must be absolute.");
    if (UriUtil.isLocalAssetUri(this.mSourceUri))
    {
      if (this.mSourceUri.isAbsolute()) {
        return;
      }
      throw new BuilderException("Asset URI path must be absolute.");
    }
    return;
    throw new BuilderException("Source must be set!");
  }
  
  public static class BuilderException
    extends RuntimeException
  {
    public BuilderException(String paramString)
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\request\ImageRequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */