package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.StatefulRunnable;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class StatefulProducerRunnable<T>
  extends StatefulRunnable<T>
{
  private final Consumer<T> mConsumer;
  private final ProducerContext mProducerContext;
  private final ProducerListener2 mProducerListener;
  private final String mProducerName;
  
  public StatefulProducerRunnable(Consumer<T> paramConsumer, ProducerListener2 paramProducerListener2, ProducerContext paramProducerContext, String paramString)
  {
    this.mConsumer = paramConsumer;
    this.mProducerListener = paramProducerListener2;
    this.mProducerName = paramString;
    this.mProducerContext = paramProducerContext;
    paramProducerListener2.onProducerStart(paramProducerContext, paramString);
  }
  
  protected abstract void disposeResult(T paramT);
  
  @Nullable
  protected Map<String, String> getExtraMapOnCancellation()
  {
    return null;
  }
  
  @Nullable
  protected Map<String, String> getExtraMapOnFailure(Exception paramException)
  {
    return null;
  }
  
  @Nullable
  protected Map<String, String> getExtraMapOnSuccess(T paramT)
  {
    return null;
  }
  
  protected void onCancellation()
  {
    ProducerListener2 localProducerListener2 = this.mProducerListener;
    ProducerContext localProducerContext = this.mProducerContext;
    String str = this.mProducerName;
    Map localMap;
    if (localProducerListener2.requiresExtraMap(localProducerContext, str)) {
      localMap = getExtraMapOnCancellation();
    } else {
      localMap = null;
    }
    localProducerListener2.onProducerFinishWithCancellation(localProducerContext, str, localMap);
    this.mConsumer.onCancellation();
  }
  
  protected void onFailure(Exception paramException)
  {
    ProducerListener2 localProducerListener2 = this.mProducerListener;
    ProducerContext localProducerContext = this.mProducerContext;
    String str = this.mProducerName;
    Map localMap;
    if (localProducerListener2.requiresExtraMap(localProducerContext, str)) {
      localMap = getExtraMapOnFailure(paramException);
    } else {
      localMap = null;
    }
    localProducerListener2.onProducerFinishWithFailure(localProducerContext, str, paramException, localMap);
    this.mConsumer.onFailure(paramException);
  }
  
  protected void onSuccess(T paramT)
  {
    ProducerListener2 localProducerListener2 = this.mProducerListener;
    ProducerContext localProducerContext = this.mProducerContext;
    String str = this.mProducerName;
    Map localMap;
    if (localProducerListener2.requiresExtraMap(localProducerContext, str)) {
      localMap = getExtraMapOnSuccess(paramT);
    } else {
      localMap = null;
    }
    localProducerListener2.onProducerFinishWithSuccess(localProducerContext, str, localMap);
    this.mConsumer.onNewResult(paramT, 1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\StatefulProducerRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */