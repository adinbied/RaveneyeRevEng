package com.facebook.imagepipeline.producers;

import java.util.Map;
import javax.annotation.Nullable;

public abstract interface ProducerListener
{
  public abstract void onProducerEvent(String paramString1, String paramString2, String paramString3);
  
  public abstract void onProducerFinishWithCancellation(String paramString1, String paramString2, @Nullable Map<String, String> paramMap);
  
  public abstract void onProducerFinishWithFailure(String paramString1, String paramString2, Throwable paramThrowable, @Nullable Map<String, String> paramMap);
  
  public abstract void onProducerFinishWithSuccess(String paramString1, String paramString2, @Nullable Map<String, String> paramMap);
  
  public abstract void onProducerStart(String paramString1, String paramString2);
  
  public abstract void onUltimateProducerReached(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract boolean requiresExtraMap(String paramString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\ProducerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */