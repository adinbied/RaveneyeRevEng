package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

public class LocalFileFetchProducer
  extends LocalFetchProducer
{
  public static final String PRODUCER_NAME = "LocalFileFetchProducer";
  
  public LocalFileFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory)
  {
    super(paramExecutor, paramPooledByteBufferFactory);
  }
  
  protected EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException
  {
    return getEncodedImage(new FileInputStream(paramImageRequest.getSourceFile().toString()), (int)paramImageRequest.getSourceFile().length());
  }
  
  protected String getProducerName()
  {
    return "LocalFileFetchProducer";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\LocalFileFetchProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */