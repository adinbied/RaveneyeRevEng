package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;

public class AddImageTransformMetaDataProducer
  implements Producer<EncodedImage>
{
  private final Producer<EncodedImage> mInputProducer;
  
  public AddImageTransformMetaDataProducer(Producer<EncodedImage> paramProducer)
  {
    this.mInputProducer = paramProducer;
  }
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mInputProducer.produceResults(new AddImageTransformMetaDataConsumer(paramConsumer, null), paramProducerContext);
  }
  
  private static class AddImageTransformMetaDataConsumer
    extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private AddImageTransformMetaDataConsumer(Consumer<EncodedImage> paramConsumer)
    {
      super();
    }
    
    protected void onNewResultImpl(EncodedImage paramEncodedImage, int paramInt)
    {
      if (paramEncodedImage == null)
      {
        getConsumer().onNewResult(null, paramInt);
        return;
      }
      if (!EncodedImage.isMetaDataAvailable(paramEncodedImage)) {
        paramEncodedImage.parseMetaData();
      }
      getConsumer().onNewResult(paramEncodedImage, paramInt);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\AddImageTransformMetaDataProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */