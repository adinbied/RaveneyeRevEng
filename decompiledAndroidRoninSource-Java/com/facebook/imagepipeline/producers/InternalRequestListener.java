package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import javax.annotation.Nullable;

public class InternalRequestListener
  extends InternalProducerListener
  implements RequestListener2
{
  @Nullable
  private final RequestListener mRequestListener;
  @Nullable
  private final RequestListener2 mRequestListener2;
  
  public InternalRequestListener(@Nullable RequestListener paramRequestListener, @Nullable RequestListener2 paramRequestListener2)
  {
    super(paramRequestListener, paramRequestListener2);
    this.mRequestListener = paramRequestListener;
    this.mRequestListener2 = paramRequestListener2;
  }
  
  public void onRequestCancellation(ProducerContext paramProducerContext)
  {
    Object localObject = this.mRequestListener;
    if (localObject != null) {
      ((RequestListener)localObject).onRequestCancellation(paramProducerContext.getId());
    }
    localObject = this.mRequestListener2;
    if (localObject != null) {
      ((RequestListener2)localObject).onRequestCancellation(paramProducerContext);
    }
  }
  
  public void onRequestFailure(ProducerContext paramProducerContext, Throwable paramThrowable)
  {
    Object localObject = this.mRequestListener;
    if (localObject != null) {
      ((RequestListener)localObject).onRequestFailure(paramProducerContext.getImageRequest(), paramProducerContext.getId(), paramThrowable, paramProducerContext.isPrefetch());
    }
    localObject = this.mRequestListener2;
    if (localObject != null) {
      ((RequestListener2)localObject).onRequestFailure(paramProducerContext, paramThrowable);
    }
  }
  
  public void onRequestStart(ProducerContext paramProducerContext)
  {
    Object localObject = this.mRequestListener;
    if (localObject != null) {
      ((RequestListener)localObject).onRequestStart(paramProducerContext.getImageRequest(), paramProducerContext.getCallerContext(), paramProducerContext.getId(), paramProducerContext.isPrefetch());
    }
    localObject = this.mRequestListener2;
    if (localObject != null) {
      ((RequestListener2)localObject).onRequestStart(paramProducerContext);
    }
  }
  
  public void onRequestSuccess(ProducerContext paramProducerContext)
  {
    Object localObject = this.mRequestListener;
    if (localObject != null) {
      ((RequestListener)localObject).onRequestSuccess(paramProducerContext.getImageRequest(), paramProducerContext.getId(), paramProducerContext.isPrefetch());
    }
    localObject = this.mRequestListener2;
    if (localObject != null) {
      ((RequestListener2)localObject).onRequestSuccess(paramProducerContext);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\InternalRequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */