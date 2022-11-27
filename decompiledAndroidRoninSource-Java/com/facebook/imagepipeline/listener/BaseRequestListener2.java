package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerContext;
import java.util.Map;
import javax.annotation.Nullable;

public class BaseRequestListener2
  implements RequestListener2
{
  public void onProducerEvent(ProducerContext paramProducerContext, String paramString1, String paramString2) {}
  
  public void onProducerFinishWithCancellation(ProducerContext paramProducerContext, String paramString, @Nullable Map<String, String> paramMap) {}
  
  public void onProducerFinishWithFailure(ProducerContext paramProducerContext, String paramString, Throwable paramThrowable, @Nullable Map<String, String> paramMap) {}
  
  public void onProducerFinishWithSuccess(ProducerContext paramProducerContext, String paramString, @Nullable Map<String, String> paramMap) {}
  
  public void onProducerStart(ProducerContext paramProducerContext, String paramString) {}
  
  public void onRequestCancellation(ProducerContext paramProducerContext) {}
  
  public void onRequestFailure(ProducerContext paramProducerContext, Throwable paramThrowable) {}
  
  public void onRequestStart(ProducerContext paramProducerContext) {}
  
  public void onRequestSuccess(ProducerContext paramProducerContext) {}
  
  public void onUltimateProducerReached(ProducerContext paramProducerContext, String paramString, boolean paramBoolean) {}
  
  public boolean requiresExtraMap(ProducerContext paramProducerContext, String paramString)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\listener\BaseRequestListener2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */