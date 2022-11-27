package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.image.EncodedImageOrigin;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.lang.annotation.Annotation;
import java.util.Map;
import javax.annotation.Nullable;

public abstract interface ProducerContext
{
  public abstract void addCallbacks(ProducerContextCallbacks paramProducerContextCallbacks);
  
  public abstract Object getCallerContext();
  
  public abstract EncodedImageOrigin getEncodedImageOrigin();
  
  @Nullable
  public abstract <E> E getExtra(String paramString);
  
  @Nullable
  public abstract <E> E getExtra(String paramString, @Nullable E paramE);
  
  public abstract Map<String, Object> getExtras();
  
  public abstract String getId();
  
  public abstract ImagePipelineConfig getImagePipelineConfig();
  
  public abstract ImageRequest getImageRequest();
  
  public abstract ImageRequest.RequestLevel getLowestPermittedRequestLevel();
  
  public abstract Priority getPriority();
  
  public abstract ProducerListener2 getProducerListener();
  
  @Nullable
  public abstract String getUiComponentId();
  
  public abstract boolean isIntermediateResultExpected();
  
  public abstract boolean isPrefetch();
  
  public abstract void putExtras(@Nullable Map<String, ?> paramMap);
  
  public abstract void putOriginExtra(@Nullable String paramString);
  
  public abstract void putOriginExtra(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void setEncodedImageOrigin(EncodedImageOrigin paramEncodedImageOrigin);
  
  public abstract <E> void setExtra(String paramString, @Nullable E paramE);
  
  public static @interface ExtraKeys
  {
    public static final String ENCODED_HEIGHT = "encoded_height";
    public static final String ENCODED_SIZE = "encoded_size";
    public static final String ENCODED_WIDTH = "encoded_width";
    public static final String MULTIPLEX_BITMAP_COUNT = "multiplex_bmp_cnt";
    public static final String MULTIPLEX_ENCODED_COUNT = "multiplex_enc_cnt";
    public static final String NORMALIZED_URI = "uri_norm";
    public static final String ORIGIN = "origin";
    public static final String ORIGIN_SUBCATEGORY = "origin_sub";
    public static final String SOURCE_URI = "uri_source";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\ProducerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */