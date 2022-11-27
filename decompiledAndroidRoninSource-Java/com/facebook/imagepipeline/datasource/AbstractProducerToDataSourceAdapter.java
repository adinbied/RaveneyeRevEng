package com.facebook.imagepipeline.datasource;

import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.HasImageRequest;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class AbstractProducerToDataSourceAdapter<T>
  extends AbstractDataSource<T>
  implements HasImageRequest
{
  private final RequestListener2 mRequestListener;
  private final SettableProducerContext mSettableProducerContext;
  
  protected AbstractProducerToDataSourceAdapter(Producer<T> paramProducer, SettableProducerContext paramSettableProducerContext, RequestListener2 paramRequestListener2)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()");
    }
    this.mSettableProducerContext = paramSettableProducerContext;
    this.mRequestListener = paramRequestListener2;
    setInitialExtras();
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->onRequestStart");
    }
    this.mRequestListener.onRequestStart(this.mSettableProducerContext);
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->produceResult");
    }
    paramProducer.produceResults(createConsumer(), paramSettableProducerContext);
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
  }
  
  private Consumer<T> createConsumer()
  {
    new BaseConsumer()
    {
      protected void onCancellationImpl()
      {
        AbstractProducerToDataSourceAdapter.this.onCancellationImpl();
      }
      
      protected void onFailureImpl(Throwable paramAnonymousThrowable)
      {
        AbstractProducerToDataSourceAdapter.this.onFailureImpl(paramAnonymousThrowable);
      }
      
      protected void onNewResultImpl(@Nullable T paramAnonymousT, int paramAnonymousInt)
      {
        AbstractProducerToDataSourceAdapter localAbstractProducerToDataSourceAdapter = AbstractProducerToDataSourceAdapter.this;
        localAbstractProducerToDataSourceAdapter.onNewResultImpl(paramAnonymousT, paramAnonymousInt, localAbstractProducerToDataSourceAdapter.mSettableProducerContext);
      }
      
      protected void onProgressUpdateImpl(float paramAnonymousFloat)
      {
        AbstractProducerToDataSourceAdapter.this.setProgress(paramAnonymousFloat);
      }
    };
  }
  
  private void onCancellationImpl()
  {
    try
    {
      Preconditions.checkState(isClosed());
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void onFailureImpl(Throwable paramThrowable)
  {
    if (super.setFailure(paramThrowable, getExtras(this.mSettableProducerContext))) {
      this.mRequestListener.onRequestFailure(this.mSettableProducerContext, paramThrowable);
    }
  }
  
  private void setInitialExtras()
  {
    setExtras(this.mSettableProducerContext.getExtras());
  }
  
  public boolean close()
  {
    if (!super.close()) {
      return false;
    }
    if (!super.isFinished())
    {
      this.mRequestListener.onRequestCancellation(this.mSettableProducerContext);
      this.mSettableProducerContext.cancel();
    }
    return true;
  }
  
  protected Map<String, Object> getExtras(ProducerContext paramProducerContext)
  {
    return paramProducerContext.getExtras();
  }
  
  public ImageRequest getImageRequest()
  {
    return this.mSettableProducerContext.getImageRequest();
  }
  
  protected void onNewResultImpl(@Nullable T paramT, int paramInt, ProducerContext paramProducerContext)
  {
    boolean bool = BaseConsumer.isLast(paramInt);
    if ((super.setResult(paramT, bool, getExtras(paramProducerContext))) && (bool)) {
      this.mRequestListener.onRequestSuccess(this.mSettableProducerContext);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\datasource\AbstractProducerToDataSourceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */