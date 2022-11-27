package com.facebook.drawee.backends.pipeline.info.internal;

import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;

public class ImagePerfRequestListener
  extends BaseRequestListener
{
  private final MonotonicClock mClock;
  private final ImagePerfState mImagePerfState;
  
  public ImagePerfRequestListener(MonotonicClock paramMonotonicClock, ImagePerfState paramImagePerfState)
  {
    this.mClock = paramMonotonicClock;
    this.mImagePerfState = paramImagePerfState;
  }
  
  public void onRequestCancellation(String paramString)
  {
    this.mImagePerfState.setImageRequestEndTimeMs(this.mClock.now());
    this.mImagePerfState.setRequestId(paramString);
  }
  
  public void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    this.mImagePerfState.setImageRequestEndTimeMs(this.mClock.now());
    this.mImagePerfState.setImageRequest(paramImageRequest);
    this.mImagePerfState.setRequestId(paramString);
    this.mImagePerfState.setPrefetch(paramBoolean);
  }
  
  public void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean)
  {
    this.mImagePerfState.setImageRequestStartTimeMs(this.mClock.now());
    this.mImagePerfState.setImageRequest(paramImageRequest);
    this.mImagePerfState.setCallerContext(paramObject);
    this.mImagePerfState.setRequestId(paramString);
    this.mImagePerfState.setPrefetch(paramBoolean);
  }
  
  public void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean)
  {
    this.mImagePerfState.setImageRequestEndTimeMs(this.mClock.now());
    this.mImagePerfState.setImageRequest(paramImageRequest);
    this.mImagePerfState.setRequestId(paramString);
    this.mImagePerfState.setPrefetch(paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\info\internal\ImagePerfRequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */