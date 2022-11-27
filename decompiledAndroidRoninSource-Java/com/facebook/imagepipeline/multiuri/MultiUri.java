package com.facebook.imagepipeline.multiuri;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;

public class MultiUri
{
  @Nullable
  private ImageRequest mHighResImageRequest;
  @Nullable
  private ImageRequest mLowResImageRequest;
  @Nullable
  private ImageRequest[] mMultiImageRequests;
  
  private MultiUri(Builder paramBuilder)
  {
    this.mLowResImageRequest = paramBuilder.mLowResImageRequest;
    this.mHighResImageRequest = paramBuilder.mHighResImageRequest;
    this.mMultiImageRequests = paramBuilder.mMultiImageRequests;
  }
  
  public static Builder create()
  {
    return new Builder(null);
  }
  
  @Nullable
  public ImageRequest getHighResImageRequest()
  {
    return this.mHighResImageRequest;
  }
  
  @Nullable
  public ImageRequest getLowResImageRequest()
  {
    return this.mLowResImageRequest;
  }
  
  @Nullable
  public ImageRequest[] getMultiImageRequests()
  {
    return this.mMultiImageRequests;
  }
  
  public static class Builder
  {
    @Nullable
    private ImageRequest mHighResImageRequest;
    @Nullable
    private ImageRequest mLowResImageRequest;
    @Nullable
    private ImageRequest[] mMultiImageRequests;
    
    public MultiUri build()
    {
      return new MultiUri(this, null);
    }
    
    public Builder setHighResImageRequest(@Nullable ImageRequest paramImageRequest)
    {
      this.mHighResImageRequest = paramImageRequest;
      return this;
    }
    
    public Builder setImageRequests(@Nullable ImageRequest... paramVarArgs)
    {
      this.mMultiImageRequests = paramVarArgs;
      return this;
    }
    
    public Builder setLowResImageRequest(@Nullable ImageRequest paramImageRequest)
    {
      this.mLowResImageRequest = paramImageRequest;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\multiuri\MultiUri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */