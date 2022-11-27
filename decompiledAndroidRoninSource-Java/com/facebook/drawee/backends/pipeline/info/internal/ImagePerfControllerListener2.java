package com.facebook.drawee.backends.pipeline.info.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.internal.Supplier;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.info.ImagePerfNotifier;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.fresco.ui.common.BaseControllerListener2;
import com.facebook.fresco.ui.common.ControllerListener2.Extras;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.fresco.ui.common.OnDrawControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.Map;
import javax.annotation.Nullable;

public class ImagePerfControllerListener2
  extends BaseControllerListener2<ImageInfo>
  implements OnDrawControllerListener<ImageInfo>
{
  private static final String TAG = "ImagePerfControllerListener2";
  private static final int WHAT_STATUS = 1;
  private static final int WHAT_VISIBILITY = 2;
  private final Supplier<Boolean> mAsyncLogging;
  private final MonotonicClock mClock;
  @Nullable
  private Handler mHandler;
  private final ImagePerfNotifier mImagePerfNotifier;
  private final ImagePerfState mImagePerfState;
  
  public ImagePerfControllerListener2(MonotonicClock paramMonotonicClock, ImagePerfState paramImagePerfState, ImagePerfNotifier paramImagePerfNotifier, Supplier<Boolean> paramSupplier)
  {
    this.mClock = paramMonotonicClock;
    this.mImagePerfState = paramImagePerfState;
    this.mImagePerfNotifier = paramImagePerfNotifier;
    this.mAsyncLogging = paramSupplier;
  }
  
  private void initHandler()
  {
    try
    {
      Object localObject1 = this.mHandler;
      if (localObject1 != null) {
        return;
      }
      localObject1 = new HandlerThread("ImagePerfControllerListener2Thread");
      ((HandlerThread)localObject1).start();
      this.mHandler = new LogHandler(((HandlerThread)localObject1).getLooper(), this.mImagePerfNotifier);
      return;
    }
    finally {}
  }
  
  private void reportViewInvisible(long paramLong)
  {
    this.mImagePerfState.setVisible(false);
    this.mImagePerfState.setInvisibilityEventTimeMs(paramLong);
    updateVisibility(2);
  }
  
  private boolean shouldDispatchAsync()
  {
    boolean bool = ((Boolean)this.mAsyncLogging.get()).booleanValue();
    if ((bool) && (this.mHandler == null)) {
      initHandler();
    }
    return bool;
  }
  
  private void updateStatus(int paramInt)
  {
    if (shouldDispatchAsync())
    {
      Message localMessage = this.mHandler.obtainMessage();
      localMessage.what = 1;
      localMessage.arg1 = paramInt;
      localMessage.obj = this.mImagePerfState;
      this.mHandler.sendMessage(localMessage);
      return;
    }
    this.mImagePerfNotifier.notifyStatusUpdated(this.mImagePerfState, paramInt);
  }
  
  private void updateVisibility(int paramInt)
  {
    if (shouldDispatchAsync())
    {
      Message localMessage = this.mHandler.obtainMessage();
      localMessage.what = 2;
      localMessage.arg1 = paramInt;
      localMessage.obj = this.mImagePerfState;
      this.mHandler.sendMessage(localMessage);
      return;
    }
    this.mImagePerfNotifier.notifyListenersOfVisibilityStateUpdate(this.mImagePerfState, paramInt);
  }
  
  public void onFailure(String paramString, Throwable paramThrowable, @Nullable ControllerListener2.Extras paramExtras)
  {
    long l = this.mClock.now();
    this.mImagePerfState.setExtraData(paramExtras);
    this.mImagePerfState.setControllerFailureTimeMs(l);
    this.mImagePerfState.setControllerId(paramString);
    this.mImagePerfState.setErrorThrowable(paramThrowable);
    updateStatus(5);
    reportViewInvisible(l);
  }
  
  public void onFinalImageSet(String paramString, @Nullable ImageInfo paramImageInfo, @Nullable ControllerListener2.Extras paramExtras)
  {
    long l = this.mClock.now();
    paramExtras.view.size();
    this.mImagePerfState.setExtraData(paramExtras);
    this.mImagePerfState.setControllerFinalImageSetTimeMs(l);
    this.mImagePerfState.setImageRequestEndTimeMs(l);
    this.mImagePerfState.setControllerId(paramString);
    this.mImagePerfState.setImageInfo(paramImageInfo);
    updateStatus(3);
  }
  
  public void onImageDrawn(String paramString, ImageInfo paramImageInfo, DimensionsInfo paramDimensionsInfo)
  {
    this.mImagePerfState.setImageDrawTimeMs(this.mClock.now());
    this.mImagePerfState.setDimensionsInfo(paramDimensionsInfo);
    updateStatus(6);
  }
  
  public void onIntermediateImageSet(String paramString, @Nullable ImageInfo paramImageInfo)
  {
    long l = this.mClock.now();
    this.mImagePerfState.setControllerIntermediateImageSetTimeMs(l);
    this.mImagePerfState.setControllerId(paramString);
    this.mImagePerfState.setImageInfo(paramImageInfo);
    updateStatus(2);
  }
  
  public void onRelease(String paramString, ControllerListener2.Extras paramExtras)
  {
    long l = this.mClock.now();
    this.mImagePerfState.setExtraData(paramExtras);
    int i = this.mImagePerfState.getImageLoadStatus();
    if ((i != 3) && (i != 5) && (i != 6))
    {
      this.mImagePerfState.setControllerCancelTimeMs(l);
      this.mImagePerfState.setControllerId(paramString);
      updateStatus(4);
    }
    reportViewInvisible(l);
  }
  
  public void onSubmit(String paramString, @Nullable Object paramObject, @Nullable ControllerListener2.Extras paramExtras)
  {
    long l = this.mClock.now();
    this.mImagePerfState.resetPointsTimestamps();
    this.mImagePerfState.setControllerSubmitTimeMs(l);
    this.mImagePerfState.setControllerId(paramString);
    this.mImagePerfState.setCallerContext(paramObject);
    this.mImagePerfState.setExtraData(paramExtras);
    updateStatus(0);
    reportViewVisible(l);
  }
  
  public void reportViewVisible(long paramLong)
  {
    this.mImagePerfState.setVisible(true);
    this.mImagePerfState.setVisibilityEventTimeMs(paramLong);
    updateVisibility(1);
  }
  
  static class LogHandler
    extends Handler
  {
    private final ImagePerfNotifier mNotifier;
    
    public LogHandler(Looper paramLooper, ImagePerfNotifier paramImagePerfNotifier)
    {
      super();
      this.mNotifier = paramImagePerfNotifier;
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        this.mNotifier.notifyListenersOfVisibilityStateUpdate((ImagePerfState)paramMessage.obj, paramMessage.arg1);
        return;
      }
      this.mNotifier.notifyStatusUpdated((ImagePerfState)paramMessage.obj, paramMessage.arg1);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\info\internal\ImagePerfControllerListener2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */