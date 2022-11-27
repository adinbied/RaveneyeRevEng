package com.facebook.imagepipeline.producers;

import android.content.res.Resources;
import android.net.Uri;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

public class LocalResourceFetchProducer
  extends LocalFetchProducer
{
  public static final String PRODUCER_NAME = "LocalResourceFetchProducer";
  private final Resources mResources;
  
  public LocalResourceFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, Resources paramResources)
  {
    super(paramExecutor, paramPooledByteBufferFactory);
    this.mResources = paramResources;
  }
  
  /* Error */
  private int getLength(ImageRequest paramImageRequest)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 17	com/facebook/imagepipeline/producers/LocalResourceFetchProducer:mResources	Landroid/content/res/Resources;
    //   10: aload_1
    //   11: invokestatic 27	com/facebook/imagepipeline/producers/LocalResourceFetchProducer:getResourceId	(Lcom/facebook/imagepipeline/request/ImageRequest;)I
    //   14: invokevirtual 33	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   17: astore_1
    //   18: aload_1
    //   19: astore 5
    //   21: aload_1
    //   22: astore 6
    //   24: aload_1
    //   25: invokevirtual 38	android/content/res/AssetFileDescriptor:getLength	()J
    //   28: lstore_3
    //   29: lload_3
    //   30: l2i
    //   31: istore_2
    //   32: aload_1
    //   33: ifnull +7 -> 40
    //   36: aload_1
    //   37: invokevirtual 42	android/content/res/AssetFileDescriptor:close	()V
    //   40: iload_2
    //   41: ireturn
    //   42: astore_1
    //   43: aload 5
    //   45: ifnull +8 -> 53
    //   48: aload 5
    //   50: invokevirtual 42	android/content/res/AssetFileDescriptor:close	()V
    //   53: aload_1
    //   54: athrow
    //   55: aload 6
    //   57: ifnull +8 -> 65
    //   60: aload 6
    //   62: invokevirtual 42	android/content/res/AssetFileDescriptor:close	()V
    //   65: iconst_m1
    //   66: ireturn
    //   67: astore_1
    //   68: goto -13 -> 55
    //   71: astore_1
    //   72: iload_2
    //   73: ireturn
    //   74: astore 5
    //   76: goto -23 -> 53
    //   79: astore_1
    //   80: iconst_m1
    //   81: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	LocalResourceFetchProducer
    //   0	82	1	paramImageRequest	ImageRequest
    //   31	42	2	i	int
    //   28	2	3	l	long
    //   4	45	5	localImageRequest1	ImageRequest
    //   74	1	5	localIOException	IOException
    //   1	60	6	localImageRequest2	ImageRequest
    // Exception table:
    //   from	to	target	type
    //   6	18	42	finally
    //   24	29	42	finally
    //   6	18	67	android/content/res/Resources$NotFoundException
    //   24	29	67	android/content/res/Resources$NotFoundException
    //   36	40	71	java/io/IOException
    //   48	53	74	java/io/IOException
    //   60	65	79	java/io/IOException
  }
  
  private static int getResourceId(ImageRequest paramImageRequest)
  {
    return Integer.parseInt(paramImageRequest.getSourceUri().getPath().substring(1));
  }
  
  protected EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException
  {
    return getEncodedImage(this.mResources.openRawResource(getResourceId(paramImageRequest)), getLength(paramImageRequest));
  }
  
  protected String getProducerName()
  {
    return "LocalResourceFetchProducer";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\LocalResourceFetchProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */