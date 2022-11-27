package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public class ForwardingRequestListener2
  implements RequestListener2
{
  private static final String TAG = "ForwardingRequestListener2";
  private final List<RequestListener2> mRequestListeners;
  
  public ForwardingRequestListener2(Set<RequestListener2> paramSet)
  {
    this.mRequestListeners = new ArrayList(paramSet.size());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      RequestListener2 localRequestListener2 = (RequestListener2)paramSet.next();
      if (localRequestListener2 != null) {
        this.mRequestListeners.add(localRequestListener2);
      }
    }
  }
  
  public ForwardingRequestListener2(RequestListener2... paramVarArgs)
  {
    this.mRequestListeners = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      RequestListener2 localRequestListener2 = paramVarArgs[i];
      if (localRequestListener2 != null) {
        this.mRequestListeners.add(localRequestListener2);
      }
      i += 1;
    }
  }
  
  private void onException(String paramString, Throwable paramThrowable)
  {
    FLog.e("ForwardingRequestListener2", paramString, paramThrowable);
  }
  
  public void addRequestListener(RequestListener2 paramRequestListener2)
  {
    this.mRequestListeners.add(paramRequestListener2);
  }
  
  public void onProducerEvent(ProducerContext paramProducerContext, String paramString1, String paramString2)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener2 localRequestListener2 = (RequestListener2)this.mRequestListeners.get(i);
      try
      {
        localRequestListener2.onProducerEvent(paramProducerContext, paramString1, paramString2);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onIntermediateChunkStart", localException);
      }
      i += 1;
    }
  }
  
  public void onProducerFinishWithCancellation(ProducerContext paramProducerContext, String paramString, @Nullable Map<String, String> paramMap)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener2 localRequestListener2 = (RequestListener2)this.mRequestListeners.get(i);
      try
      {
        localRequestListener2.onProducerFinishWithCancellation(paramProducerContext, paramString, paramMap);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onProducerFinishWithCancellation", localException);
      }
      i += 1;
    }
  }
  
  public void onProducerFinishWithFailure(ProducerContext paramProducerContext, String paramString, Throwable paramThrowable, @Nullable Map<String, String> paramMap)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener2 localRequestListener2 = (RequestListener2)this.mRequestListeners.get(i);
      try
      {
        localRequestListener2.onProducerFinishWithFailure(paramProducerContext, paramString, paramThrowable, paramMap);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onProducerFinishWithFailure", localException);
      }
      i += 1;
    }
  }
  
  public void onProducerFinishWithSuccess(ProducerContext paramProducerContext, String paramString, @Nullable Map<String, String> paramMap)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener2 localRequestListener2 = (RequestListener2)this.mRequestListeners.get(i);
      try
      {
        localRequestListener2.onProducerFinishWithSuccess(paramProducerContext, paramString, paramMap);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onProducerFinishWithSuccess", localException);
      }
      i += 1;
    }
  }
  
  public void onProducerStart(ProducerContext paramProducerContext, String paramString)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener2 localRequestListener2 = (RequestListener2)this.mRequestListeners.get(i);
      try
      {
        localRequestListener2.onProducerStart(paramProducerContext, paramString);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onProducerStart", localException);
      }
      i += 1;
    }
  }
  
  public void onRequestCancellation(ProducerContext paramProducerContext)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener2 localRequestListener2 = (RequestListener2)this.mRequestListeners.get(i);
      try
      {
        localRequestListener2.onRequestCancellation(paramProducerContext);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onRequestCancellation", localException);
      }
      i += 1;
    }
  }
  
  public void onRequestFailure(ProducerContext paramProducerContext, Throwable paramThrowable)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener2 localRequestListener2 = (RequestListener2)this.mRequestListeners.get(i);
      try
      {
        localRequestListener2.onRequestFailure(paramProducerContext, paramThrowable);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onRequestFailure", localException);
      }
      i += 1;
    }
  }
  
  public void onRequestStart(ProducerContext paramProducerContext)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener2 localRequestListener2 = (RequestListener2)this.mRequestListeners.get(i);
      try
      {
        localRequestListener2.onRequestStart(paramProducerContext);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onRequestStart", localException);
      }
      i += 1;
    }
  }
  
  public void onRequestSuccess(ProducerContext paramProducerContext)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener2 localRequestListener2 = (RequestListener2)this.mRequestListeners.get(i);
      try
      {
        localRequestListener2.onRequestSuccess(paramProducerContext);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onRequestSuccess", localException);
      }
      i += 1;
    }
  }
  
  public void onUltimateProducerReached(ProducerContext paramProducerContext, String paramString, boolean paramBoolean)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener2 localRequestListener2 = (RequestListener2)this.mRequestListeners.get(i);
      try
      {
        localRequestListener2.onUltimateProducerReached(paramProducerContext, paramString, paramBoolean);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onProducerFinishWithSuccess", localException);
      }
      i += 1;
    }
  }
  
  public boolean requiresExtraMap(ProducerContext paramProducerContext, String paramString)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      if (((RequestListener2)this.mRequestListeners.get(i)).requiresExtraMap(paramProducerContext, paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\listener\ForwardingRequestListener2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */