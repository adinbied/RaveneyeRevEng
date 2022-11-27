package com.facebook.imagepipeline.producers;

import java.util.Map;
import javax.annotation.Nullable;

public class InternalProducerListener
  implements ProducerListener2
{
  private final ProducerListener mProducerListener;
  @Nullable
  private final ProducerListener2 mProducerListener2;
  
  public InternalProducerListener(ProducerListener paramProducerListener, @Nullable ProducerListener2 paramProducerListener2)
  {
    this.mProducerListener = paramProducerListener;
    this.mProducerListener2 = paramProducerListener2;
  }
  
  public ProducerListener getProducerListener()
  {
    return this.mProducerListener;
  }
  
  @Nullable
  public ProducerListener2 getProducerListener2()
  {
    return this.mProducerListener2;
  }
  
  public void onProducerEvent(ProducerContext paramProducerContext, String paramString1, String paramString2)
  {
    Object localObject = this.mProducerListener;
    if (localObject != null) {
      ((ProducerListener)localObject).onProducerEvent(paramProducerContext.getId(), paramString1, paramString2);
    }
    localObject = this.mProducerListener2;
    if (localObject != null) {
      ((ProducerListener2)localObject).onProducerEvent(paramProducerContext, paramString1, paramString2);
    }
  }
  
  public void onProducerFinishWithCancellation(ProducerContext paramProducerContext, String paramString, @Nullable Map<String, String> paramMap)
  {
    Object localObject = this.mProducerListener;
    if (localObject != null) {
      ((ProducerListener)localObject).onProducerFinishWithCancellation(paramProducerContext.getId(), paramString, paramMap);
    }
    localObject = this.mProducerListener2;
    if (localObject != null) {
      ((ProducerListener2)localObject).onProducerFinishWithCancellation(paramProducerContext, paramString, paramMap);
    }
  }
  
  public void onProducerFinishWithFailure(ProducerContext paramProducerContext, String paramString, Throwable paramThrowable, @Nullable Map<String, String> paramMap)
  {
    Object localObject = this.mProducerListener;
    if (localObject != null) {
      ((ProducerListener)localObject).onProducerFinishWithFailure(paramProducerContext.getId(), paramString, paramThrowable, paramMap);
    }
    localObject = this.mProducerListener2;
    if (localObject != null) {
      ((ProducerListener2)localObject).onProducerFinishWithFailure(paramProducerContext, paramString, paramThrowable, paramMap);
    }
  }
  
  public void onProducerFinishWithSuccess(ProducerContext paramProducerContext, String paramString, @Nullable Map<String, String> paramMap)
  {
    Object localObject = this.mProducerListener;
    if (localObject != null) {
      ((ProducerListener)localObject).onProducerFinishWithSuccess(paramProducerContext.getId(), paramString, paramMap);
    }
    localObject = this.mProducerListener2;
    if (localObject != null) {
      ((ProducerListener2)localObject).onProducerFinishWithSuccess(paramProducerContext, paramString, paramMap);
    }
  }
  
  public void onProducerStart(ProducerContext paramProducerContext, String paramString)
  {
    Object localObject = this.mProducerListener;
    if (localObject != null) {
      ((ProducerListener)localObject).onProducerStart(paramProducerContext.getId(), paramString);
    }
    localObject = this.mProducerListener2;
    if (localObject != null) {
      ((ProducerListener2)localObject).onProducerStart(paramProducerContext, paramString);
    }
  }
  
  public void onUltimateProducerReached(ProducerContext paramProducerContext, String paramString, boolean paramBoolean)
  {
    Object localObject = this.mProducerListener;
    if (localObject != null) {
      ((ProducerListener)localObject).onUltimateProducerReached(paramProducerContext.getId(), paramString, paramBoolean);
    }
    localObject = this.mProducerListener2;
    if (localObject != null) {
      ((ProducerListener2)localObject).onUltimateProducerReached(paramProducerContext, paramString, paramBoolean);
    }
  }
  
  public boolean requiresExtraMap(ProducerContext paramProducerContext, String paramString)
  {
    Object localObject = this.mProducerListener;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((ProducerListener)localObject).requiresExtraMap(paramProducerContext.getId());
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      localObject = this.mProducerListener2;
      bool2 = bool1;
      if (localObject != null) {
        bool2 = ((ProducerListener2)localObject).requiresExtraMap(paramProducerContext, paramString);
      }
    }
    return bool2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\InternalProducerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */