package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.HasBitmap;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;

public class CloseableStaticBitmap
  extends CloseableBitmap
  implements HasBitmap
{
  private volatile Bitmap mBitmap;
  private CloseableReference<Bitmap> mBitmapReference;
  private final int mExifOrientation;
  private final QualityInfo mQualityInfo;
  private final int mRotationAngle;
  
  public CloseableStaticBitmap(Bitmap paramBitmap, ResourceReleaser<Bitmap> paramResourceReleaser, QualityInfo paramQualityInfo, int paramInt)
  {
    this(paramBitmap, paramResourceReleaser, paramQualityInfo, paramInt, 0);
  }
  
  public CloseableStaticBitmap(Bitmap paramBitmap, ResourceReleaser<Bitmap> paramResourceReleaser, QualityInfo paramQualityInfo, int paramInt1, int paramInt2)
  {
    this.mBitmap = ((Bitmap)Preconditions.checkNotNull(paramBitmap));
    this.mBitmapReference = CloseableReference.of(this.mBitmap, (ResourceReleaser)Preconditions.checkNotNull(paramResourceReleaser));
    this.mQualityInfo = paramQualityInfo;
    this.mRotationAngle = paramInt1;
    this.mExifOrientation = paramInt2;
  }
  
  public CloseableStaticBitmap(CloseableReference<Bitmap> paramCloseableReference, QualityInfo paramQualityInfo, int paramInt)
  {
    this(paramCloseableReference, paramQualityInfo, paramInt, 0);
  }
  
  public CloseableStaticBitmap(CloseableReference<Bitmap> paramCloseableReference, QualityInfo paramQualityInfo, int paramInt1, int paramInt2)
  {
    paramCloseableReference = (CloseableReference)Preconditions.checkNotNull(paramCloseableReference.cloneOrNull());
    this.mBitmapReference = paramCloseableReference;
    this.mBitmap = ((Bitmap)paramCloseableReference.get());
    this.mQualityInfo = paramQualityInfo;
    this.mRotationAngle = paramInt1;
    this.mExifOrientation = paramInt2;
  }
  
  private CloseableReference<Bitmap> detachBitmapReference()
  {
    try
    {
      CloseableReference localCloseableReference = this.mBitmapReference;
      this.mBitmapReference = null;
      this.mBitmap = null;
      return localCloseableReference;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static int getBitmapHeight(@Nullable Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    return paramBitmap.getHeight();
  }
  
  private static int getBitmapWidth(@Nullable Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    return paramBitmap.getWidth();
  }
  
  @Nullable
  public CloseableReference<Bitmap> cloneUnderlyingBitmapReference()
  {
    try
    {
      CloseableReference localCloseableReference = CloseableReference.cloneOrNull(this.mBitmapReference);
      return localCloseableReference;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void close()
  {
    CloseableReference localCloseableReference = detachBitmapReference();
    if (localCloseableReference != null) {
      localCloseableReference.close();
    }
  }
  
  public CloseableReference<Bitmap> convertToBitmapReference()
  {
    try
    {
      Preconditions.checkNotNull(this.mBitmapReference, "Cannot convert a closed static bitmap");
      CloseableReference localCloseableReference = detachBitmapReference();
      return localCloseableReference;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getExifOrientation()
  {
    return this.mExifOrientation;
  }
  
  public int getHeight()
  {
    if (this.mRotationAngle % 180 == 0)
    {
      int i = this.mExifOrientation;
      if ((i != 5) && (i != 7)) {
        return getBitmapHeight(this.mBitmap);
      }
    }
    return getBitmapWidth(this.mBitmap);
  }
  
  public QualityInfo getQualityInfo()
  {
    return this.mQualityInfo;
  }
  
  public int getRotationAngle()
  {
    return this.mRotationAngle;
  }
  
  public int getSizeInBytes()
  {
    return BitmapUtil.getSizeInBytes(this.mBitmap);
  }
  
  public Bitmap getUnderlyingBitmap()
  {
    return this.mBitmap;
  }
  
  public int getWidth()
  {
    if (this.mRotationAngle % 180 == 0)
    {
      int i = this.mExifOrientation;
      if ((i != 5) && (i != 7)) {
        return getBitmapWidth(this.mBitmap);
      }
    }
    return getBitmapHeight(this.mBitmap);
  }
  
  public boolean isClosed()
  {
    try
    {
      CloseableReference localCloseableReference = this.mBitmapReference;
      boolean bool;
      if (localCloseableReference == null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\image\CloseableStaticBitmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */