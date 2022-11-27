package com.facebook.imagepipeline.image;

import android.net.Uri;
import javax.annotation.Nullable;

public class OriginalEncodedImageInfo
{
  public static final OriginalEncodedImageInfo EMPTY = new OriginalEncodedImageInfo();
  @Nullable
  private final Object mCallerContext;
  private final int mHeight;
  @Nullable
  private final EncodedImageOrigin mOrigin;
  private final int mSize;
  @Nullable
  private final Uri mUri;
  private final int mWidth;
  
  private OriginalEncodedImageInfo()
  {
    this.mUri = null;
    this.mOrigin = EncodedImageOrigin.NOT_SET;
    this.mCallerContext = null;
    this.mWidth = -1;
    this.mHeight = -1;
    this.mSize = -1;
  }
  
  public OriginalEncodedImageInfo(Uri paramUri, EncodedImageOrigin paramEncodedImageOrigin, @Nullable Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mUri = paramUri;
    this.mOrigin = paramEncodedImageOrigin;
    this.mCallerContext = paramObject;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mSize = paramInt3;
  }
  
  @Nullable
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public EncodedImageOrigin getOrigin()
  {
    return this.mOrigin;
  }
  
  public int getSize()
  {
    return this.mSize;
  }
  
  @Nullable
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\image\OriginalEncodedImageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */