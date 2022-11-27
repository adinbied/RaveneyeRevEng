package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;

public class FetchState
{
  private final Consumer<EncodedImage> mConsumer;
  private final ProducerContext mContext;
  private long mLastIntermediateResultTimeMs;
  private int mOnNewResultStatusFlags;
  @Nullable
  private BytesRange mResponseBytesRange;
  
  public FetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mConsumer = paramConsumer;
    this.mContext = paramProducerContext;
    this.mLastIntermediateResultTimeMs = 0L;
  }
  
  public Consumer<EncodedImage> getConsumer()
  {
    return this.mConsumer;
  }
  
  public ProducerContext getContext()
  {
    return this.mContext;
  }
  
  public String getId()
  {
    return this.mContext.getId();
  }
  
  public long getLastIntermediateResultTimeMs()
  {
    return this.mLastIntermediateResultTimeMs;
  }
  
  public ProducerListener2 getListener()
  {
    return this.mContext.getProducerListener();
  }
  
  public int getOnNewResultStatusFlags()
  {
    return this.mOnNewResultStatusFlags;
  }
  
  @Nullable
  public BytesRange getResponseBytesRange()
  {
    return this.mResponseBytesRange;
  }
  
  public Uri getUri()
  {
    return this.mContext.getImageRequest().getSourceUri();
  }
  
  public void setLastIntermediateResultTimeMs(long paramLong)
  {
    this.mLastIntermediateResultTimeMs = paramLong;
  }
  
  public void setOnNewResultStatusFlags(int paramInt)
  {
    this.mOnNewResultStatusFlags = paramInt;
  }
  
  public void setResponseBytesRange(BytesRange paramBytesRange)
  {
    this.mResponseBytesRange = paramBytesRange;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\FetchState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */