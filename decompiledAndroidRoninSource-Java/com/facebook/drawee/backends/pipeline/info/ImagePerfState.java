package com.facebook.drawee.backends.pipeline.info;

import com.facebook.fresco.ui.common.ControllerListener2.Extras;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;

public class ImagePerfState
{
  @Nullable
  private Object mCallerContext;
  @Nullable
  private String mComponentTag;
  private long mControllerCancelTimeMs = -1L;
  private long mControllerFailureTimeMs = -1L;
  private long mControllerFinalImageSetTimeMs = -1L;
  @Nullable
  private ImageRequest[] mControllerFirstAvailableImageRequests;
  @Nullable
  private String mControllerId;
  @Nullable
  private ImageRequest mControllerImageRequest;
  private long mControllerIntermediateImageSetTimeMs = -1L;
  @Nullable
  private ImageRequest mControllerLowResImageRequest;
  private long mControllerSubmitTimeMs = -1L;
  @Nullable
  private DimensionsInfo mDimensionsInfo;
  @Nullable
  private Throwable mErrorThrowable;
  @Nullable
  private ControllerListener2.Extras mExtraData;
  private long mImageDrawTimeMs = -1L;
  @Nullable
  private ImageInfo mImageInfo;
  private int mImageLoadStatus = -1;
  private int mImageOrigin = 1;
  @Nullable
  private ImageRequest mImageRequest;
  private long mImageRequestEndTimeMs = -1L;
  private long mImageRequestStartTimeMs = -1L;
  private long mInvisibilityEventTimeMs = -1L;
  private boolean mIsPrefetch;
  private int mOnScreenHeightPx = -1;
  private int mOnScreenWidthPx = -1;
  @Nullable
  private String mRequestId;
  @Nullable
  private String mUltimateProducerName;
  private long mVisibilityEventTimeMs = -1L;
  private int mVisibilityState = -1;
  
  @Nullable
  public DimensionsInfo getDimensionsInfo()
  {
    return this.mDimensionsInfo;
  }
  
  @Nullable
  public Object getExtraData()
  {
    return this.mExtraData;
  }
  
  public long getImageDrawTimeMs()
  {
    return this.mImageDrawTimeMs;
  }
  
  public int getImageLoadStatus()
  {
    return this.mImageLoadStatus;
  }
  
  public void reset()
  {
    this.mRequestId = null;
    this.mImageRequest = null;
    this.mCallerContext = null;
    this.mImageInfo = null;
    this.mControllerImageRequest = null;
    this.mControllerLowResImageRequest = null;
    this.mControllerFirstAvailableImageRequests = null;
    this.mImageOrigin = 1;
    this.mUltimateProducerName = null;
    this.mIsPrefetch = false;
    this.mOnScreenWidthPx = -1;
    this.mOnScreenHeightPx = -1;
    this.mErrorThrowable = null;
    this.mImageLoadStatus = -1;
    this.mVisibilityState = -1;
    this.mComponentTag = null;
    this.mDimensionsInfo = null;
    this.mExtraData = null;
    resetPointsTimestamps();
  }
  
  public void resetPointsTimestamps()
  {
    this.mImageRequestStartTimeMs = -1L;
    this.mImageRequestEndTimeMs = -1L;
    this.mControllerSubmitTimeMs = -1L;
    this.mControllerFinalImageSetTimeMs = -1L;
    this.mControllerFailureTimeMs = -1L;
    this.mControllerCancelTimeMs = -1L;
    this.mVisibilityEventTimeMs = -1L;
    this.mInvisibilityEventTimeMs = -1L;
    this.mImageDrawTimeMs = -1L;
  }
  
  public void setCallerContext(@Nullable Object paramObject)
  {
    this.mCallerContext = paramObject;
  }
  
  public void setComponentTag(@Nullable String paramString)
  {
    this.mComponentTag = paramString;
  }
  
  public void setControllerCancelTimeMs(long paramLong)
  {
    this.mControllerCancelTimeMs = paramLong;
  }
  
  public void setControllerFailureTimeMs(long paramLong)
  {
    this.mControllerFailureTimeMs = paramLong;
  }
  
  public void setControllerFinalImageSetTimeMs(long paramLong)
  {
    this.mControllerFinalImageSetTimeMs = paramLong;
  }
  
  public void setControllerId(@Nullable String paramString)
  {
    this.mControllerId = paramString;
  }
  
  public void setControllerImageRequests(@Nullable ImageRequest paramImageRequest1, @Nullable ImageRequest paramImageRequest2, @Nullable ImageRequest[] paramArrayOfImageRequest)
  {
    this.mControllerImageRequest = paramImageRequest1;
    this.mControllerLowResImageRequest = paramImageRequest2;
    this.mControllerFirstAvailableImageRequests = paramArrayOfImageRequest;
  }
  
  public void setControllerIntermediateImageSetTimeMs(long paramLong)
  {
    this.mControllerIntermediateImageSetTimeMs = paramLong;
  }
  
  public void setControllerSubmitTimeMs(long paramLong)
  {
    this.mControllerSubmitTimeMs = paramLong;
  }
  
  public void setDimensionsInfo(DimensionsInfo paramDimensionsInfo)
  {
    this.mDimensionsInfo = paramDimensionsInfo;
  }
  
  public void setErrorThrowable(@Nullable Throwable paramThrowable)
  {
    this.mErrorThrowable = paramThrowable;
  }
  
  public void setExtraData(@Nullable ControllerListener2.Extras paramExtras)
  {
    this.mExtraData = paramExtras;
  }
  
  public void setImageDrawTimeMs(long paramLong)
  {
    this.mImageDrawTimeMs = paramLong;
  }
  
  public void setImageInfo(@Nullable ImageInfo paramImageInfo)
  {
    this.mImageInfo = paramImageInfo;
  }
  
  public void setImageLoadStatus(int paramInt)
  {
    this.mImageLoadStatus = paramInt;
  }
  
  public void setImageOrigin(int paramInt)
  {
    this.mImageOrigin = paramInt;
  }
  
  public void setImageRequest(@Nullable ImageRequest paramImageRequest)
  {
    this.mImageRequest = paramImageRequest;
  }
  
  public void setImageRequestEndTimeMs(long paramLong)
  {
    this.mImageRequestEndTimeMs = paramLong;
  }
  
  public void setImageRequestStartTimeMs(long paramLong)
  {
    this.mImageRequestStartTimeMs = paramLong;
  }
  
  public void setInvisibilityEventTimeMs(long paramLong)
  {
    this.mInvisibilityEventTimeMs = paramLong;
  }
  
  public void setOnScreenHeight(int paramInt)
  {
    this.mOnScreenHeightPx = paramInt;
  }
  
  public void setOnScreenWidth(int paramInt)
  {
    this.mOnScreenWidthPx = paramInt;
  }
  
  public void setPrefetch(boolean paramBoolean)
  {
    this.mIsPrefetch = paramBoolean;
  }
  
  public void setRequestId(@Nullable String paramString)
  {
    this.mRequestId = paramString;
  }
  
  public void setUltimateProducerName(@Nullable String paramString)
  {
    this.mUltimateProducerName = paramString;
  }
  
  public void setVisibilityEventTimeMs(long paramLong)
  {
    this.mVisibilityEventTimeMs = paramLong;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    this.mVisibilityState = i;
  }
  
  public ImagePerfData snapshot()
  {
    return new ImagePerfData(this.mControllerId, this.mRequestId, this.mImageRequest, this.mCallerContext, this.mImageInfo, this.mControllerImageRequest, this.mControllerLowResImageRequest, this.mControllerFirstAvailableImageRequests, this.mControllerSubmitTimeMs, this.mControllerIntermediateImageSetTimeMs, this.mControllerFinalImageSetTimeMs, this.mControllerFailureTimeMs, this.mControllerCancelTimeMs, this.mImageRequestStartTimeMs, this.mImageRequestEndTimeMs, this.mImageOrigin, this.mUltimateProducerName, this.mIsPrefetch, this.mOnScreenWidthPx, this.mOnScreenHeightPx, this.mErrorThrowable, this.mVisibilityState, this.mVisibilityEventTimeMs, this.mInvisibilityEventTimeMs, this.mComponentTag, this.mImageDrawTimeMs, this.mDimensionsInfo, this.mExtraData);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\info\ImagePerfState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */