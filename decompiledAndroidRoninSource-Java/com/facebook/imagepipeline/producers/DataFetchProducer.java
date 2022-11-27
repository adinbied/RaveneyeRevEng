package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.util.Base64;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class DataFetchProducer
  extends LocalFetchProducer
{
  public static final String PRODUCER_NAME = "DataFetchProducer";
  
  public DataFetchProducer(PooledByteBufferFactory paramPooledByteBufferFactory)
  {
    super(CallerThreadExecutor.getInstance(), paramPooledByteBufferFactory);
  }
  
  static byte[] getData(String paramString)
  {
    Preconditions.checkArgument(paramString.substring(0, 5).equals("data:"));
    int i = paramString.indexOf(',');
    String str = paramString.substring(i + 1, paramString.length());
    if (isBase64(paramString.substring(0, i))) {
      return Base64.decode(str, 0);
    }
    return Uri.decode(str).getBytes();
  }
  
  static boolean isBase64(String paramString)
  {
    if (!paramString.contains(";")) {
      return false;
    }
    paramString = paramString.split(";");
    return paramString[(paramString.length - 1)].equals("base64");
  }
  
  protected EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException
  {
    paramImageRequest = getData(paramImageRequest.getSourceUri().toString());
    return getByteBufferBackedEncodedImage(new ByteArrayInputStream(paramImageRequest), paramImageRequest.length);
  }
  
  protected String getProducerName()
  {
    return "DataFetchProducer";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\DataFetchProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */