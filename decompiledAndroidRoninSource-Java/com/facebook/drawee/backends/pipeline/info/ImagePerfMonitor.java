package com.facebook.drawee.backends.pipeline.info;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfControllerListener2;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfRequestListener;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;

public class ImagePerfMonitor
  implements ImagePerfNotifier
{
  private final Supplier<Boolean> mAsyncLogging;
  private boolean mEnabled;
  @Nullable
  private ForwardingRequestListener mForwardingRequestListener;
  @Nullable
  private ImageOriginListener mImageOriginListener;
  @Nullable
  private ImageOriginRequestListener mImageOriginRequestListener;
  @Nullable
  private ImagePerfControllerListener2 mImagePerfControllerListener2;
  @Nullable
  private List<ImagePerfDataListener> mImagePerfDataListeners;
  @Nullable
  private ImagePerfRequestListener mImagePerfRequestListener;
  private final ImagePerfState mImagePerfState;
  private final MonotonicClock mMonotonicClock;
  private final PipelineDraweeController mPipelineDraweeController;
  
  public ImagePerfMonitor(MonotonicClock paramMonotonicClock, PipelineDraweeController paramPipelineDraweeController, Supplier<Boolean> paramSupplier)
  {
    this.mMonotonicClock = paramMonotonicClock;
    this.mPipelineDraweeController = paramPipelineDraweeController;
    this.mImagePerfState = new ImagePerfState();
    this.mAsyncLogging = paramSupplier;
  }
  
  private void setupListeners()
  {
    if (this.mImagePerfControllerListener2 == null) {
      this.mImagePerfControllerListener2 = new ImagePerfControllerListener2(this.mMonotonicClock, this.mImagePerfState, this, this.mAsyncLogging);
    }
    if (this.mImagePerfRequestListener == null) {
      this.mImagePerfRequestListener = new ImagePerfRequestListener(this.mMonotonicClock, this.mImagePerfState);
    }
    if (this.mImageOriginListener == null) {
      this.mImageOriginListener = new ImagePerfImageOriginListener(this.mImagePerfState, this);
    }
    ImageOriginRequestListener localImageOriginRequestListener = this.mImageOriginRequestListener;
    if (localImageOriginRequestListener == null) {
      this.mImageOriginRequestListener = new ImageOriginRequestListener(this.mPipelineDraweeController.getId(), this.mImageOriginListener);
    } else {
      localImageOriginRequestListener.init(this.mPipelineDraweeController.getId());
    }
    if (this.mForwardingRequestListener == null) {
      this.mForwardingRequestListener = new ForwardingRequestListener(new RequestListener[] { this.mImagePerfRequestListener, this.mImageOriginRequestListener });
    }
  }
  
  public void addImagePerfDataListener(@Nullable ImagePerfDataListener paramImagePerfDataListener)
  {
    if (paramImagePerfDataListener == null) {
      return;
    }
    if (this.mImagePerfDataListeners == null) {
      this.mImagePerfDataListeners = new CopyOnWriteArrayList();
    }
    this.mImagePerfDataListeners.add(paramImagePerfDataListener);
  }
  
  public void addViewportData()
  {
    Object localObject = this.mPipelineDraweeController.getHierarchy();
    if ((localObject != null) && (((DraweeHierarchy)localObject).getTopLevelDrawable() != null))
    {
      localObject = ((DraweeHierarchy)localObject).getTopLevelDrawable().getBounds();
      this.mImagePerfState.setOnScreenWidth(((Rect)localObject).width());
      this.mImagePerfState.setOnScreenHeight(((Rect)localObject).height());
    }
  }
  
  public void clearImagePerfDataListeners()
  {
    List localList = this.mImagePerfDataListeners;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void notifyListenersOfVisibilityStateUpdate(ImagePerfState paramImagePerfState, int paramInt)
  {
    if (this.mEnabled)
    {
      Object localObject = this.mImagePerfDataListeners;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        paramImagePerfState = paramImagePerfState.snapshot();
        localObject = this.mImagePerfDataListeners.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ImagePerfDataListener)((Iterator)localObject).next()).onImageVisibilityUpdated(paramImagePerfState, paramInt);
        }
      }
    }
  }
  
  public void notifyStatusUpdated(ImagePerfState paramImagePerfState, int paramInt)
  {
    paramImagePerfState.setImageLoadStatus(paramInt);
    if (this.mEnabled)
    {
      Object localObject = this.mImagePerfDataListeners;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        if (paramInt == 3) {
          addViewportData();
        }
        paramImagePerfState = paramImagePerfState.snapshot();
        localObject = this.mImagePerfDataListeners.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ImagePerfDataListener)((Iterator)localObject).next()).onImageLoadStatusUpdated(paramImagePerfState, paramInt);
        }
      }
    }
  }
  
  public void removeImagePerfDataListener(ImagePerfDataListener paramImagePerfDataListener)
  {
    List localList = this.mImagePerfDataListeners;
    if (localList == null) {
      return;
    }
    localList.remove(paramImagePerfDataListener);
  }
  
  public void reset()
  {
    clearImagePerfDataListeners();
    setEnabled(false);
    this.mImagePerfState.reset();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
    Object localObject;
    if (paramBoolean)
    {
      setupListeners();
      localObject = this.mImageOriginListener;
      if (localObject != null) {
        this.mPipelineDraweeController.addImageOriginListener((ImageOriginListener)localObject);
      }
      localObject = this.mImagePerfControllerListener2;
      if (localObject != null) {
        this.mPipelineDraweeController.addControllerListener2((ControllerListener2)localObject);
      }
      localObject = this.mForwardingRequestListener;
      if (localObject != null) {
        this.mPipelineDraweeController.addRequestListener((RequestListener)localObject);
      }
    }
    else
    {
      localObject = this.mImageOriginListener;
      if (localObject != null) {
        this.mPipelineDraweeController.removeImageOriginListener((ImageOriginListener)localObject);
      }
      localObject = this.mImagePerfControllerListener2;
      if (localObject != null) {
        this.mPipelineDraweeController.removeControllerListener2((ControllerListener2)localObject);
      }
      localObject = this.mForwardingRequestListener;
      if (localObject != null) {
        this.mPipelineDraweeController.removeRequestListener((RequestListener)localObject);
      }
    }
  }
  
  public void updateImageRequestData(AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> paramAbstractDraweeControllerBuilder)
  {
    this.mImagePerfState.setControllerImageRequests((ImageRequest)paramAbstractDraweeControllerBuilder.getImageRequest(), (ImageRequest)paramAbstractDraweeControllerBuilder.getLowResImageRequest(), (ImageRequest[])paramAbstractDraweeControllerBuilder.getFirstAvailableImageRequests());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\info\ImagePerfMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */