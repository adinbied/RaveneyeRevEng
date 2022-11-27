package com.facebook.drawee.backends.pipeline.info.internal;

import android.graphics.drawable.Animatable;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.fresco.ui.common.OnDrawControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import javax.annotation.Nullable;

public class ImagePerfControllerListener
  extends BaseControllerListener<ImageInfo>
  implements OnDrawControllerListener<ImageInfo>
{
  private final MonotonicClock mClock;
  private final ImagePerfMonitor mImagePerfMonitor;
  private final ImagePerfState mImagePerfState;
  
  public ImagePerfControllerListener(MonotonicClock paramMonotonicClock, ImagePerfState paramImagePerfState, ImagePerfMonitor paramImagePerfMonitor)
  {
    this.mClock = paramMonotonicClock;
    this.mImagePerfState = paramImagePerfState;
    this.mImagePerfMonitor = paramImagePerfMonitor;
  }
  
  private void reportViewInvisible(long paramLong)
  {
    this.mImagePerfState.setVisible(false);
    this.mImagePerfState.setInvisibilityEventTimeMs(paramLong);
    this.mImagePerfMonitor.notifyListenersOfVisibilityStateUpdate(this.mImagePerfState, 2);
  }
  
  public void onFailure(String paramString, Throwable paramThrowable)
  {
    long l = this.mClock.now();
    this.mImagePerfState.setControllerFailureTimeMs(l);
    this.mImagePerfState.setControllerId(paramString);
    this.mImagePerfState.setErrorThrowable(paramThrowable);
    this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 5);
    reportViewInvisible(l);
  }
  
  public void onFinalImageSet(String paramString, @Nullable ImageInfo paramImageInfo, @Nullable Animatable paramAnimatable)
  {
    long l = this.mClock.now();
    this.mImagePerfState.setControllerFinalImageSetTimeMs(l);
    this.mImagePerfState.setImageRequestEndTimeMs(l);
    this.mImagePerfState.setControllerId(paramString);
    this.mImagePerfState.setImageInfo(paramImageInfo);
    this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 3);
  }
  
  public void onImageDrawn(String paramString, ImageInfo paramImageInfo, DimensionsInfo paramDimensionsInfo)
  {
    this.mImagePerfState.setImageDrawTimeMs(this.mClock.now());
    this.mImagePerfState.setDimensionsInfo(paramDimensionsInfo);
    this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 6);
  }
  
  public void onIntermediateImageSet(String paramString, @Nullable ImageInfo paramImageInfo)
  {
    long l = this.mClock.now();
    this.mImagePerfState.setControllerIntermediateImageSetTimeMs(l);
    this.mImagePerfState.setControllerId(paramString);
    this.mImagePerfState.setImageInfo(paramImageInfo);
    this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 2);
  }
  
  public void onRelease(String paramString)
  {
    super.onRelease(paramString);
    long l = this.mClock.now();
    int i = this.mImagePerfState.getImageLoadStatus();
    if ((i != 3) && (i != 5) && (i != 6))
    {
      this.mImagePerfState.setControllerCancelTimeMs(l);
      this.mImagePerfState.setControllerId(paramString);
      this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 4);
    }
    reportViewInvisible(l);
  }
  
  public void onSubmit(String paramString, Object paramObject)
  {
    long l = this.mClock.now();
    this.mImagePerfState.resetPointsTimestamps();
    this.mImagePerfState.setControllerSubmitTimeMs(l);
    this.mImagePerfState.setControllerId(paramString);
    this.mImagePerfState.setCallerContext(paramObject);
    this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 0);
    reportViewVisible(l);
  }
  
  public void reportViewVisible(long paramLong)
  {
    this.mImagePerfState.setVisible(true);
    this.mImagePerfState.setVisibilityEventTimeMs(paramLong);
    this.mImagePerfMonitor.notifyListenersOfVisibilityStateUpdate(this.mImagePerfState, 1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\info\internal\ImagePerfControllerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */