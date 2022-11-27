package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.fresco.ui.common.ControllerListener2.Extras;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;

public class ImagePerfData
{
  public static final int UNSET = -1;
  @Nullable
  private final Object mCallerContext;
  @Nullable
  private final String mComponentTag;
  private final long mControllerCancelTimeMs;
  private final long mControllerFailureTimeMs;
  private final long mControllerFinalImageSetTimeMs;
  @Nullable
  private final ImageRequest[] mControllerFirstAvailableImageRequests;
  @Nullable
  private final String mControllerId;
  @Nullable
  private final ImageRequest mControllerImageRequest;
  private final long mControllerIntermediateImageSetTimeMs;
  @Nullable
  private final ImageRequest mControllerLowResImageRequest;
  private final long mControllerSubmitTimeMs;
  @Nullable
  private final DimensionsInfo mDimensionsInfo;
  @Nullable
  private final Throwable mErrorThrowable;
  @Nullable
  private final ControllerListener2.Extras mExtraData;
  private final long mImageDrawTimeMs;
  @Nullable
  private final ImageInfo mImageInfo;
  private final int mImageOrigin;
  @Nullable
  private final ImageRequest mImageRequest;
  private final long mImageRequestEndTimeMs;
  private final long mImageRequestStartTimeMs;
  private final long mInvisibilityEventTimeMs;
  private final boolean mIsPrefetch;
  private final int mOnScreenHeightPx;
  private final int mOnScreenWidthPx;
  @Nullable
  private final String mRequestId;
  @Nullable
  private final String mUltimateProducerName;
  private final long mVisibilityEventTimeMs;
  private final int mVisibilityState;
  
  public ImagePerfData(@Nullable String paramString1, @Nullable String paramString2, @Nullable ImageRequest paramImageRequest1, @Nullable Object paramObject, @Nullable ImageInfo paramImageInfo, @Nullable ImageRequest paramImageRequest2, @Nullable ImageRequest paramImageRequest3, @Nullable ImageRequest[] paramArrayOfImageRequest, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt1, @Nullable String paramString3, boolean paramBoolean, int paramInt2, int paramInt3, @Nullable Throwable paramThrowable, int paramInt4, long paramLong8, long paramLong9, @Nullable String paramString4, long paramLong10, @Nullable DimensionsInfo paramDimensionsInfo, @Nullable ControllerListener2.Extras paramExtras)
  {
    this.mControllerId = paramString1;
    this.mRequestId = paramString2;
    this.mImageRequest = paramImageRequest1;
    this.mCallerContext = paramObject;
    this.mImageInfo = paramImageInfo;
    this.mControllerImageRequest = paramImageRequest2;
    this.mControllerLowResImageRequest = paramImageRequest3;
    this.mControllerFirstAvailableImageRequests = paramArrayOfImageRequest;
    this.mControllerSubmitTimeMs = paramLong1;
    this.mControllerIntermediateImageSetTimeMs = paramLong2;
    this.mControllerFinalImageSetTimeMs = paramLong3;
    this.mControllerFailureTimeMs = paramLong4;
    this.mControllerCancelTimeMs = paramLong5;
    this.mImageRequestStartTimeMs = paramLong6;
    this.mImageRequestEndTimeMs = paramLong7;
    this.mImageOrigin = paramInt1;
    this.mUltimateProducerName = paramString3;
    this.mIsPrefetch = paramBoolean;
    this.mOnScreenWidthPx = paramInt2;
    this.mOnScreenHeightPx = paramInt3;
    this.mErrorThrowable = paramThrowable;
    this.mVisibilityState = paramInt4;
    this.mVisibilityEventTimeMs = paramLong8;
    this.mInvisibilityEventTimeMs = paramLong9;
    this.mComponentTag = paramString4;
    this.mImageDrawTimeMs = paramLong10;
    this.mDimensionsInfo = paramDimensionsInfo;
    this.mExtraData = paramExtras;
  }
  
  public String createDebugString()
  {
    return Objects.toStringHelper(this).add("controller ID", this.mControllerId).add("request ID", this.mRequestId).add("controller image request", this.mControllerImageRequest).add("controller low res image request", this.mControllerLowResImageRequest).add("controller first available image requests", this.mControllerFirstAvailableImageRequests).add("controller submit", this.mControllerSubmitTimeMs).add("controller final image", this.mControllerFinalImageSetTimeMs).add("controller failure", this.mControllerFailureTimeMs).add("controller cancel", this.mControllerCancelTimeMs).add("start time", this.mImageRequestStartTimeMs).add("end time", this.mImageRequestEndTimeMs).add("origin", ImageOriginUtils.toString(this.mImageOrigin)).add("ultimateProducerName", this.mUltimateProducerName).add("prefetch", this.mIsPrefetch).add("caller context", this.mCallerContext).add("image request", this.mImageRequest).add("image info", this.mImageInfo).add("on-screen width", this.mOnScreenWidthPx).add("on-screen height", this.mOnScreenHeightPx).add("visibility state", this.mVisibilityState).add("component tag", this.mComponentTag).add("visibility event", this.mVisibilityEventTimeMs).add("invisibility event", this.mInvisibilityEventTimeMs).add("image draw event", this.mImageDrawTimeMs).add("dimensions info", this.mDimensionsInfo).add("extra data", this.mExtraData).toString();
  }
  
  @Nullable
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }
  
  @Nullable
  public String getComponentTag()
  {
    return this.mComponentTag;
  }
  
  public long getControllerFailureTimeMs()
  {
    return this.mControllerFailureTimeMs;
  }
  
  public long getControllerFinalImageSetTimeMs()
  {
    return this.mControllerFinalImageSetTimeMs;
  }
  
  @Nullable
  public ImageRequest[] getControllerFirstAvailableImageRequests()
  {
    return this.mControllerFirstAvailableImageRequests;
  }
  
  @Nullable
  public String getControllerId()
  {
    return this.mControllerId;
  }
  
  @Nullable
  public ImageRequest getControllerImageRequest()
  {
    return this.mControllerImageRequest;
  }
  
  public long getControllerIntermediateImageSetTimeMs()
  {
    return this.mControllerIntermediateImageSetTimeMs;
  }
  
  @Nullable
  public ImageRequest getControllerLowResImageRequest()
  {
    return this.mControllerLowResImageRequest;
  }
  
  public long getControllerSubmitTimeMs()
  {
    return this.mControllerSubmitTimeMs;
  }
  
  @Nullable
  public DimensionsInfo getDimensionsInfo()
  {
    return this.mDimensionsInfo;
  }
  
  @Nullable
  public Throwable getErrorThrowable()
  {
    return this.mErrorThrowable;
  }
  
  @Nullable
  public ControllerListener2.Extras getExtraData()
  {
    return this.mExtraData;
  }
  
  public long getFinalImageLoadTimeMs()
  {
    if (getImageRequestEndTimeMs() != -1L)
    {
      if (getImageRequestStartTimeMs() == -1L) {
        return -1L;
      }
      return getImageRequestEndTimeMs() - getImageRequestStartTimeMs();
    }
    return -1L;
  }
  
  public long getImageDrawTimeMs()
  {
    return this.mImageDrawTimeMs;
  }
  
  @Nullable
  public ImageInfo getImageInfo()
  {
    return this.mImageInfo;
  }
  
  public int getImageOrigin()
  {
    return this.mImageOrigin;
  }
  
  @Nullable
  public ImageRequest getImageRequest()
  {
    return this.mImageRequest;
  }
  
  public long getImageRequestEndTimeMs()
  {
    return this.mImageRequestEndTimeMs;
  }
  
  public long getImageRequestStartTimeMs()
  {
    return this.mImageRequestStartTimeMs;
  }
  
  public long getIntermediateImageLoadTimeMs()
  {
    if (getControllerIntermediateImageSetTimeMs() != -1L)
    {
      if (getControllerSubmitTimeMs() == -1L) {
        return -1L;
      }
      return getControllerIntermediateImageSetTimeMs() - getControllerSubmitTimeMs();
    }
    return -1L;
  }
  
  public long getInvisibilityEventTimeMs()
  {
    return this.mInvisibilityEventTimeMs;
  }
  
  public int getOnScreenHeightPx()
  {
    return this.mOnScreenHeightPx;
  }
  
  public int getOnScreenWidthPx()
  {
    return this.mOnScreenWidthPx;
  }
  
  @Nullable
  public String getRequestId()
  {
    return this.mRequestId;
  }
  
  @Nullable
  public String getUltimateProducerName()
  {
    return this.mUltimateProducerName;
  }
  
  public long getVisibilityEventTimeMs()
  {
    return this.mVisibilityEventTimeMs;
  }
  
  public int getVisibilityState()
  {
    return this.mVisibilityState;
  }
  
  public boolean isPrefetch()
  {
    return this.mIsPrefetch;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\info\ImagePerfData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */