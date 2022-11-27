package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;

public abstract interface RequestListener
  extends ProducerListener
{
  public abstract void onRequestCancellation(String paramString);
  
  public abstract void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean);
  
  public abstract void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean);
  
  public abstract void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\listener\RequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */