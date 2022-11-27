package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

public class CloseableProducerToDataSourceAdapter<T>
  extends AbstractProducerToDataSourceAdapter<CloseableReference<T>>
{
  private CloseableProducerToDataSourceAdapter(Producer<CloseableReference<T>> paramProducer, SettableProducerContext paramSettableProducerContext, RequestListener2 paramRequestListener2)
  {
    super(paramProducer, paramSettableProducerContext, paramRequestListener2);
  }
  
  public static <T> DataSource<CloseableReference<T>> create(Producer<CloseableReference<T>> paramProducer, SettableProducerContext paramSettableProducerContext, RequestListener2 paramRequestListener2)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("CloseableProducerToDataSourceAdapter#create");
    }
    paramProducer = new CloseableProducerToDataSourceAdapter(paramProducer, paramSettableProducerContext, paramRequestListener2);
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
    return paramProducer;
  }
  
  protected void closeResult(CloseableReference<T> paramCloseableReference)
  {
    CloseableReference.closeSafely(paramCloseableReference);
  }
  
  @Nullable
  public CloseableReference<T> getResult()
  {
    return CloseableReference.cloneOrNull((CloseableReference)super.getResult());
  }
  
  protected void onNewResultImpl(CloseableReference<T> paramCloseableReference, int paramInt, ProducerContext paramProducerContext)
  {
    super.onNewResultImpl(CloseableReference.cloneOrNull(paramCloseableReference), paramInt, paramProducerContext);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\datasource\CloseableProducerToDataSourceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */