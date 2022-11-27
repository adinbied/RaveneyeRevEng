package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import javax.annotation.Nullable;

public class SettableProducerContext
  extends BaseProducerContext
{
  public SettableProducerContext(ProducerContext paramProducerContext)
  {
    this(paramProducerContext.getImageRequest(), paramProducerContext.getId(), paramProducerContext.getUiComponentId(), paramProducerContext.getProducerListener(), paramProducerContext.getCallerContext(), paramProducerContext.getLowestPermittedRequestLevel(), paramProducerContext.isPrefetch(), paramProducerContext.isIntermediateResultExpected(), paramProducerContext.getPriority(), paramProducerContext.getImagePipelineConfig());
  }
  
  public SettableProducerContext(ImageRequest paramImageRequest, ProducerContext paramProducerContext)
  {
    this(paramImageRequest, paramProducerContext.getId(), paramProducerContext.getUiComponentId(), paramProducerContext.getProducerListener(), paramProducerContext.getCallerContext(), paramProducerContext.getLowestPermittedRequestLevel(), paramProducerContext.isPrefetch(), paramProducerContext.isIntermediateResultExpected(), paramProducerContext.getPriority(), paramProducerContext.getImagePipelineConfig());
  }
  
  public SettableProducerContext(ImageRequest paramImageRequest, String paramString, ProducerListener2 paramProducerListener2, Object paramObject, ImageRequest.RequestLevel paramRequestLevel, boolean paramBoolean1, boolean paramBoolean2, Priority paramPriority, ImagePipelineConfig paramImagePipelineConfig)
  {
    super(paramImageRequest, paramString, paramProducerListener2, paramObject, paramRequestLevel, paramBoolean1, paramBoolean2, paramPriority, paramImagePipelineConfig);
  }
  
  public SettableProducerContext(ImageRequest paramImageRequest, String paramString1, @Nullable String paramString2, ProducerListener2 paramProducerListener2, Object paramObject, ImageRequest.RequestLevel paramRequestLevel, boolean paramBoolean1, boolean paramBoolean2, Priority paramPriority, ImagePipelineConfig paramImagePipelineConfig)
  {
    super(paramImageRequest, paramString1, paramString2, paramProducerListener2, paramObject, paramRequestLevel, paramBoolean1, paramBoolean2, paramPriority, paramImagePipelineConfig);
  }
  
  public void setIsIntermediateResultExpected(boolean paramBoolean)
  {
    BaseProducerContext.callOnIsIntermediateResultExpectedChanged(setIsIntermediateResultExpectedNoCallbacks(paramBoolean));
  }
  
  public void setIsPrefetch(boolean paramBoolean)
  {
    BaseProducerContext.callOnIsPrefetchChanged(setIsPrefetchNoCallbacks(paramBoolean));
  }
  
  public void setPriority(Priority paramPriority)
  {
    BaseProducerContext.callOnPriorityChanged(setPriorityNoCallbacks(paramPriority));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\SettableProducerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */