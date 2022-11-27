package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableSet;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.image.EncodedImageOrigin;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public class BaseProducerContext
  implements ProducerContext
{
  public static final Set<String> INITIAL_KEYS = ImmutableSet.of(new String[] { "id", "uri_source" });
  private static final String ORIGIN_SUBCATEGORY_DEFAULT = "default";
  private final List<ProducerContextCallbacks> mCallbacks;
  private final Object mCallerContext;
  private EncodedImageOrigin mEncodedImageOrigin = EncodedImageOrigin.NOT_SET;
  private final Map<String, Object> mExtras;
  private final String mId;
  private final ImagePipelineConfig mImagePipelineConfig;
  private final ImageRequest mImageRequest;
  private boolean mIsCancelled;
  private boolean mIsIntermediateResultExpected;
  private boolean mIsPrefetch;
  private final ImageRequest.RequestLevel mLowestPermittedRequestLevel;
  private Priority mPriority;
  private final ProducerListener2 mProducerListener;
  @Nullable
  private final String mUiComponentId;
  
  public BaseProducerContext(ImageRequest paramImageRequest, String paramString, ProducerListener2 paramProducerListener2, Object paramObject, ImageRequest.RequestLevel paramRequestLevel, boolean paramBoolean1, boolean paramBoolean2, Priority paramPriority, ImagePipelineConfig paramImagePipelineConfig)
  {
    this(paramImageRequest, paramString, null, paramProducerListener2, paramObject, paramRequestLevel, paramBoolean1, paramBoolean2, paramPriority, paramImagePipelineConfig);
  }
  
  public BaseProducerContext(ImageRequest paramImageRequest, String paramString1, @Nullable String paramString2, ProducerListener2 paramProducerListener2, Object paramObject, ImageRequest.RequestLevel paramRequestLevel, boolean paramBoolean1, boolean paramBoolean2, Priority paramPriority, ImagePipelineConfig paramImagePipelineConfig)
  {
    this.mImageRequest = paramImageRequest;
    this.mId = paramString1;
    paramString1 = new HashMap();
    this.mExtras = paramString1;
    paramString1.put("id", this.mId);
    paramString1 = this.mExtras;
    if (paramImageRequest == null) {
      paramImageRequest = "null-request";
    } else {
      paramImageRequest = paramImageRequest.getSourceUri();
    }
    paramString1.put("uri_source", paramImageRequest);
    this.mUiComponentId = paramString2;
    this.mProducerListener = paramProducerListener2;
    this.mCallerContext = paramObject;
    this.mLowestPermittedRequestLevel = paramRequestLevel;
    this.mIsPrefetch = paramBoolean1;
    this.mPriority = paramPriority;
    this.mIsIntermediateResultExpected = paramBoolean2;
    this.mIsCancelled = false;
    this.mCallbacks = new ArrayList();
    this.mImagePipelineConfig = paramImagePipelineConfig;
  }
  
  public static void callOnCancellationRequested(@Nullable List<ProducerContextCallbacks> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((ProducerContextCallbacks)paramList.next()).onCancellationRequested();
    }
  }
  
  public static void callOnIsIntermediateResultExpectedChanged(@Nullable List<ProducerContextCallbacks> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((ProducerContextCallbacks)paramList.next()).onIsIntermediateResultExpectedChanged();
    }
  }
  
  public static void callOnIsPrefetchChanged(@Nullable List<ProducerContextCallbacks> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((ProducerContextCallbacks)paramList.next()).onIsPrefetchChanged();
    }
  }
  
  public static void callOnPriorityChanged(@Nullable List<ProducerContextCallbacks> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((ProducerContextCallbacks)paramList.next()).onPriorityChanged();
    }
  }
  
  public void addCallbacks(ProducerContextCallbacks paramProducerContextCallbacks)
  {
    try
    {
      this.mCallbacks.add(paramProducerContextCallbacks);
      boolean bool = this.mIsCancelled;
      if (bool) {
        paramProducerContextCallbacks.onCancellationRequested();
      }
      return;
    }
    finally {}
  }
  
  public void cancel()
  {
    callOnCancellationRequested(cancelNoCallbacks());
  }
  
  @Nullable
  public List<ProducerContextCallbacks> cancelNoCallbacks()
  {
    try
    {
      boolean bool = this.mIsCancelled;
      if (bool) {
        return null;
      }
      this.mIsCancelled = true;
      ArrayList localArrayList = new ArrayList(this.mCallbacks);
      return localArrayList;
    }
    finally {}
  }
  
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }
  
  public EncodedImageOrigin getEncodedImageOrigin()
  {
    return this.mEncodedImageOrigin;
  }
  
  @Nullable
  public <T> T getExtra(String paramString)
  {
    return (T)this.mExtras.get(paramString);
  }
  
  @Nullable
  public <E> E getExtra(String paramString, E paramE)
  {
    paramString = this.mExtras.get(paramString);
    if (paramString == null) {
      return paramE;
    }
    return paramString;
  }
  
  public Map<String, Object> getExtras()
  {
    return this.mExtras;
  }
  
  public String getId()
  {
    return this.mId;
  }
  
  public ImagePipelineConfig getImagePipelineConfig()
  {
    return this.mImagePipelineConfig;
  }
  
  public ImageRequest getImageRequest()
  {
    return this.mImageRequest;
  }
  
  public ImageRequest.RequestLevel getLowestPermittedRequestLevel()
  {
    return this.mLowestPermittedRequestLevel;
  }
  
  public Priority getPriority()
  {
    try
    {
      Priority localPriority = this.mPriority;
      return localPriority;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public ProducerListener2 getProducerListener()
  {
    return this.mProducerListener;
  }
  
  @Nullable
  public String getUiComponentId()
  {
    return this.mUiComponentId;
  }
  
  public boolean isCancelled()
  {
    try
    {
      boolean bool = this.mIsCancelled;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isIntermediateResultExpected()
  {
    try
    {
      boolean bool = this.mIsIntermediateResultExpected;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isPrefetch()
  {
    try
    {
      boolean bool = this.mIsPrefetch;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void putExtras(@Nullable Map<String, ?> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      setExtra((String)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public void putOriginExtra(@Nullable String paramString)
  {
    putOriginExtra(paramString, "default");
  }
  
  public void putOriginExtra(@Nullable String paramString1, @Nullable String paramString2)
  {
    this.mExtras.put("origin", paramString1);
    this.mExtras.put("origin_sub", paramString2);
  }
  
  public void setEncodedImageOrigin(EncodedImageOrigin paramEncodedImageOrigin)
  {
    this.mEncodedImageOrigin = paramEncodedImageOrigin;
  }
  
  public void setExtra(String paramString, @Nullable Object paramObject)
  {
    if (INITIAL_KEYS.contains(paramString)) {
      return;
    }
    this.mExtras.put(paramString, paramObject);
  }
  
  @Nullable
  public List<ProducerContextCallbacks> setIsIntermediateResultExpectedNoCallbacks(boolean paramBoolean)
  {
    try
    {
      boolean bool = this.mIsIntermediateResultExpected;
      if (paramBoolean == bool) {
        return null;
      }
      this.mIsIntermediateResultExpected = paramBoolean;
      ArrayList localArrayList = new ArrayList(this.mCallbacks);
      return localArrayList;
    }
    finally {}
  }
  
  @Nullable
  public List<ProducerContextCallbacks> setIsPrefetchNoCallbacks(boolean paramBoolean)
  {
    try
    {
      boolean bool = this.mIsPrefetch;
      if (paramBoolean == bool) {
        return null;
      }
      this.mIsPrefetch = paramBoolean;
      ArrayList localArrayList = new ArrayList(this.mCallbacks);
      return localArrayList;
    }
    finally {}
  }
  
  @Nullable
  public List<ProducerContextCallbacks> setPriorityNoCallbacks(Priority paramPriority)
  {
    try
    {
      Priority localPriority = this.mPriority;
      if (paramPriority == localPriority) {
        return null;
      }
      this.mPriority = paramPriority;
      paramPriority = new ArrayList(this.mCallbacks);
      return paramPriority;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\BaseProducerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */