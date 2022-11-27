package com.facebook.imagepipeline.datasource;

import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;

public class ProducerToDataSourceAdapter<T>
  extends AbstractProducerToDataSourceAdapter<T>
{
  private ProducerToDataSourceAdapter(Producer<T> paramProducer, SettableProducerContext paramSettableProducerContext, RequestListener2 paramRequestListener2)
  {
    super(paramProducer, paramSettableProducerContext, paramRequestListener2);
  }
  
  public static <T> DataSource<T> create(Producer<T> paramProducer, SettableProducerContext paramSettableProducerContext, RequestListener2 paramRequestListener2)
  {
    return new ProducerToDataSourceAdapter(paramProducer, paramSettableProducerContext, paramRequestListener2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\datasource\ProducerToDataSourceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */