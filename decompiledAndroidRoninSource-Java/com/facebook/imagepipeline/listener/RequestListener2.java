package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener2;

public abstract interface RequestListener2
  extends ProducerListener2
{
  public abstract void onRequestCancellation(ProducerContext paramProducerContext);
  
  public abstract void onRequestFailure(ProducerContext paramProducerContext, Throwable paramThrowable);
  
  public abstract void onRequestStart(ProducerContext paramProducerContext);
  
  public abstract void onRequestSuccess(ProducerContext paramProducerContext);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\listener\RequestListener2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */