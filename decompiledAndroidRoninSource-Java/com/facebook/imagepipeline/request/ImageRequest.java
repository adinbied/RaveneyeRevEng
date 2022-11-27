package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Fn;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.listener.RequestListener;
import java.io.File;
import javax.annotation.Nullable;

public class ImageRequest
{
  public static final Fn<ImageRequest, Uri> REQUEST_TO_URI_FN = new Fn()
  {
    @Nullable
    public Uri apply(@Nullable ImageRequest paramAnonymousImageRequest)
    {
      if (paramAnonymousImageRequest != null) {
        return paramAnonymousImageRequest.getSourceUri();
      }
      return null;
    }
  };
  @Nullable
  private final BytesRange mBytesRange;
  private final CacheChoice mCacheChoice;
  @Nullable
  private final Boolean mDecodePrefetches;
  private final ImageDecodeOptions mImageDecodeOptions;
  private final boolean mIsDiskCacheEnabled;
  private final boolean mIsMemoryCacheEnabled;
  private final boolean mLocalThumbnailPreviewsEnabled;
  private final RequestLevel mLowestPermittedRequestLevel;
  @Nullable
  private final Postprocessor mPostprocessor;
  private final boolean mProgressiveRenderingEnabled;
  @Nullable
  private final RequestListener mRequestListener;
  private final Priority mRequestPriority;
  @Nullable
  private final ResizeOptions mResizeOptions;
  @Nullable
  private final Boolean mResizingAllowedOverride;
  private final RotationOptions mRotationOptions;
  private File mSourceFile;
  private final Uri mSourceUri;
  private final int mSourceUriType;
  
  protected ImageRequest(ImageRequestBuilder paramImageRequestBuilder)
  {
    this.mCacheChoice = paramImageRequestBuilder.getCacheChoice();
    Object localObject = paramImageRequestBuilder.getSourceUri();
    this.mSourceUri = ((Uri)localObject);
    this.mSourceUriType = getSourceUriType((Uri)localObject);
    this.mProgressiveRenderingEnabled = paramImageRequestBuilder.isProgressiveRenderingEnabled();
    this.mLocalThumbnailPreviewsEnabled = paramImageRequestBuilder.isLocalThumbnailPreviewsEnabled();
    this.mImageDecodeOptions = paramImageRequestBuilder.getImageDecodeOptions();
    this.mResizeOptions = paramImageRequestBuilder.getResizeOptions();
    if (paramImageRequestBuilder.getRotationOptions() == null) {
      localObject = RotationOptions.autoRotate();
    } else {
      localObject = paramImageRequestBuilder.getRotationOptions();
    }
    this.mRotationOptions = ((RotationOptions)localObject);
    this.mBytesRange = paramImageRequestBuilder.getBytesRange();
    this.mRequestPriority = paramImageRequestBuilder.getRequestPriority();
    this.mLowestPermittedRequestLevel = paramImageRequestBuilder.getLowestPermittedRequestLevel();
    this.mIsDiskCacheEnabled = paramImageRequestBuilder.isDiskCacheEnabled();
    this.mIsMemoryCacheEnabled = paramImageRequestBuilder.isMemoryCacheEnabled();
    this.mDecodePrefetches = paramImageRequestBuilder.shouldDecodePrefetches();
    this.mPostprocessor = paramImageRequestBuilder.getPostprocessor();
    this.mRequestListener = paramImageRequestBuilder.getRequestListener();
    this.mResizingAllowedOverride = paramImageRequestBuilder.getResizingAllowedOverride();
  }
  
  @Nullable
  public static ImageRequest fromFile(@Nullable File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    return fromUri(UriUtil.getUriForFile(paramFile));
  }
  
  @Nullable
  public static ImageRequest fromUri(@Nullable Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    return ImageRequestBuilder.newBuilderWithSource(paramUri).build();
  }
  
  @Nullable
  public static ImageRequest fromUri(@Nullable String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return fromUri(Uri.parse(paramString));
    }
    return null;
  }
  
  private static int getSourceUriType(Uri paramUri)
  {
    if (paramUri == null) {
      return -1;
    }
    if (UriUtil.isNetworkUri(paramUri)) {
      return 0;
    }
    if (UriUtil.isLocalFileUri(paramUri))
    {
      if (MediaUtils.isVideo(MediaUtils.extractMime(paramUri.getPath()))) {
        return 2;
      }
      return 3;
    }
    if (UriUtil.isLocalContentUri(paramUri)) {
      return 4;
    }
    if (UriUtil.isLocalAssetUri(paramUri)) {
      return 5;
    }
    if (UriUtil.isLocalResourceUri(paramUri)) {
      return 6;
    }
    if (UriUtil.isDataUri(paramUri)) {
      return 7;
    }
    if (UriUtil.isQualifiedResourceUri(paramUri)) {
      return 8;
    }
    return -1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ImageRequest)) {
      return false;
    }
    Object localObject = (ImageRequest)paramObject;
    if (this.mLocalThumbnailPreviewsEnabled != ((ImageRequest)localObject).mLocalThumbnailPreviewsEnabled) {
      return false;
    }
    if (this.mIsDiskCacheEnabled != ((ImageRequest)localObject).mIsDiskCacheEnabled) {
      return false;
    }
    if (this.mIsMemoryCacheEnabled != ((ImageRequest)localObject).mIsMemoryCacheEnabled) {
      return false;
    }
    if ((Objects.equal(this.mSourceUri, ((ImageRequest)localObject).mSourceUri)) && (Objects.equal(this.mCacheChoice, ((ImageRequest)localObject).mCacheChoice)) && (Objects.equal(this.mSourceFile, ((ImageRequest)localObject).mSourceFile)) && (Objects.equal(this.mBytesRange, ((ImageRequest)localObject).mBytesRange)) && (Objects.equal(this.mImageDecodeOptions, ((ImageRequest)localObject).mImageDecodeOptions)) && (Objects.equal(this.mResizeOptions, ((ImageRequest)localObject).mResizeOptions)) && (Objects.equal(this.mRequestPriority, ((ImageRequest)localObject).mRequestPriority)) && (Objects.equal(this.mLowestPermittedRequestLevel, ((ImageRequest)localObject).mLowestPermittedRequestLevel)) && (Objects.equal(this.mDecodePrefetches, ((ImageRequest)localObject).mDecodePrefetches)) && (Objects.equal(this.mResizingAllowedOverride, ((ImageRequest)localObject).mResizingAllowedOverride)))
    {
      if (!Objects.equal(this.mRotationOptions, ((ImageRequest)localObject).mRotationOptions)) {
        return false;
      }
      paramObject = this.mPostprocessor;
      CacheKey localCacheKey = null;
      if (paramObject != null) {
        paramObject = ((Postprocessor)paramObject).getPostprocessorCacheKey();
      } else {
        paramObject = null;
      }
      localObject = ((ImageRequest)localObject).mPostprocessor;
      if (localObject != null) {
        localCacheKey = ((Postprocessor)localObject).getPostprocessorCacheKey();
      }
      return Objects.equal(paramObject, localCacheKey);
    }
    return false;
  }
  
  @Deprecated
  public boolean getAutoRotateEnabled()
  {
    return this.mRotationOptions.useImageMetadata();
  }
  
  @Nullable
  public BytesRange getBytesRange()
  {
    return this.mBytesRange;
  }
  
  public CacheChoice getCacheChoice()
  {
    return this.mCacheChoice;
  }
  
  public ImageDecodeOptions getImageDecodeOptions()
  {
    return this.mImageDecodeOptions;
  }
  
  public boolean getLocalThumbnailPreviewsEnabled()
  {
    return this.mLocalThumbnailPreviewsEnabled;
  }
  
  public RequestLevel getLowestPermittedRequestLevel()
  {
    return this.mLowestPermittedRequestLevel;
  }
  
  @Nullable
  public Postprocessor getPostprocessor()
  {
    return this.mPostprocessor;
  }
  
  public int getPreferredHeight()
  {
    ResizeOptions localResizeOptions = this.mResizeOptions;
    if (localResizeOptions != null) {
      return localResizeOptions.height;
    }
    return 2048;
  }
  
  public int getPreferredWidth()
  {
    ResizeOptions localResizeOptions = this.mResizeOptions;
    if (localResizeOptions != null) {
      return localResizeOptions.width;
    }
    return 2048;
  }
  
  public Priority getPriority()
  {
    return this.mRequestPriority;
  }
  
  public boolean getProgressiveRenderingEnabled()
  {
    return this.mProgressiveRenderingEnabled;
  }
  
  @Nullable
  public RequestListener getRequestListener()
  {
    return this.mRequestListener;
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
  
  public RotationOptions getRotationOptions()
  {
    return this.mRotationOptions;
  }
  
  public File getSourceFile()
  {
    try
    {
      if (this.mSourceFile == null) {
        this.mSourceFile = new File(this.mSourceUri.getPath());
      }
      File localFile = this.mSourceFile;
      return localFile;
    }
    finally {}
  }
  
  public Uri getSourceUri()
  {
    return this.mSourceUri;
  }
  
  public int getSourceUriType()
  {
    return this.mSourceUriType;
  }
  
  public int hashCode()
  {
    Object localObject = this.mPostprocessor;
    if (localObject != null) {
      localObject = ((Postprocessor)localObject).getPostprocessorCacheKey();
    } else {
      localObject = null;
    }
    return Objects.hashCode(new Object[] { this.mCacheChoice, this.mSourceUri, Boolean.valueOf(this.mLocalThumbnailPreviewsEnabled), this.mBytesRange, this.mRequestPriority, this.mLowestPermittedRequestLevel, Boolean.valueOf(this.mIsDiskCacheEnabled), Boolean.valueOf(this.mIsMemoryCacheEnabled), this.mImageDecodeOptions, this.mDecodePrefetches, this.mResizeOptions, this.mRotationOptions, localObject, this.mResizingAllowedOverride });
  }
  
  public boolean isDiskCacheEnabled()
  {
    return this.mIsDiskCacheEnabled;
  }
  
  public boolean isMemoryCacheEnabled()
  {
    return this.mIsMemoryCacheEnabled;
  }
  
  @Nullable
  public Boolean shouldDecodePrefetches()
  {
    return this.mDecodePrefetches;
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("uri", this.mSourceUri).add("cacheChoice", this.mCacheChoice).add("decodeOptions", this.mImageDecodeOptions).add("postprocessor", this.mPostprocessor).add("priority", this.mRequestPriority).add("resizeOptions", this.mResizeOptions).add("rotationOptions", this.mRotationOptions).add("bytesRange", this.mBytesRange).add("resizingAllowedOverride", this.mResizingAllowedOverride).add("progressiveRenderingEnabled", this.mProgressiveRenderingEnabled).add("localThumbnailPreviewsEnabled", this.mLocalThumbnailPreviewsEnabled).add("lowestPermittedRequestLevel", this.mLowestPermittedRequestLevel).add("isDiskCacheEnabled", this.mIsDiskCacheEnabled).add("isMemoryCacheEnabled", this.mIsMemoryCacheEnabled).add("decodePrefetches", this.mDecodePrefetches).toString();
  }
  
  public static enum CacheChoice
  {
    static
    {
      CacheChoice localCacheChoice = new CacheChoice("DEFAULT", 1);
      DEFAULT = localCacheChoice;
      $VALUES = new CacheChoice[] { SMALL, localCacheChoice };
    }
    
    private CacheChoice() {}
  }
  
  public static enum RequestLevel
  {
    private int mValue;
    
    static
    {
      DISK_CACHE = new RequestLevel("DISK_CACHE", 1, 2);
      ENCODED_MEMORY_CACHE = new RequestLevel("ENCODED_MEMORY_CACHE", 2, 3);
      RequestLevel localRequestLevel = new RequestLevel("BITMAP_MEMORY_CACHE", 3, 4);
      BITMAP_MEMORY_CACHE = localRequestLevel;
      $VALUES = new RequestLevel[] { FULL_FETCH, DISK_CACHE, ENCODED_MEMORY_CACHE, localRequestLevel };
    }
    
    private RequestLevel(int paramInt)
    {
      this.mValue = paramInt;
    }
    
    public static RequestLevel getMax(RequestLevel paramRequestLevel1, RequestLevel paramRequestLevel2)
    {
      if (paramRequestLevel1.getValue() > paramRequestLevel2.getValue()) {
        return paramRequestLevel1;
      }
      return paramRequestLevel2;
    }
    
    public int getValue()
    {
      return this.mValue;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\request\ImageRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */