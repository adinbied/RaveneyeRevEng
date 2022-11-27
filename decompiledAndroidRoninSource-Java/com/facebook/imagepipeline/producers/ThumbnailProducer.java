package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;

public abstract interface ThumbnailProducer<T>
  extends Producer<T>
{
  public abstract boolean canProvideImageForSize(ResizeOptions paramResizeOptions);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\ThumbnailProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */