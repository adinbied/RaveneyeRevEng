package com.facebook.imagepipeline.producers;

import java.util.Map;
import javax.annotation.Nullable;

public abstract interface ProducerListener2
{
  public abstract void onProducerEvent(ProducerContext paramProducerContext, String paramString1, String paramString2);
  
  public abstract void onProducerFinishWithCancellation(ProducerContext paramProducerContext, String paramString, @Nullable Map<String, String> paramMap);
  
  public abstract void onProducerFinishWithFailure(ProducerContext paramProducerContext, String paramString, Throwable paramThrowable, @Nullable Map<String, String> paramMap);
  
  public abstract void onProducerFinishWithSuccess(ProducerContext paramProducerContext, String paramString, @Nullable Map<String, String> paramMap);
  
  public abstract void onProducerStart(ProducerContext paramProducerContext, String paramString);
  
  public abstract void onUltimateProducerReached(ProducerContext paramProducerContext, String paramString, boolean paramBoolean);
  
  public abstract boolean requiresExtraMap(ProducerContext paramProducerContext, String paramString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\ProducerListener2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */