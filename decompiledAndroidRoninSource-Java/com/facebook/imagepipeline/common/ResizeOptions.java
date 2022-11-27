package com.facebook.imagepipeline.common;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import java.util.Locale;
import javax.annotation.Nullable;

public class ResizeOptions
{
  public static final float DEFAULT_ROUNDUP_FRACTION = 0.6666667F;
  public final int height;
  public final float maxBitmapSize;
  public final float roundUpFraction;
  public final int width;
  
  public ResizeOptions(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 2048.0F);
  }
  
  public ResizeOptions(int paramInt1, int paramInt2, float paramFloat)
  {
    this(paramInt1, paramInt2, paramFloat, 0.6666667F);
  }
  
  public ResizeOptions(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt1 > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramInt2 > 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    this.width = paramInt1;
    this.height = paramInt2;
    this.maxBitmapSize = paramFloat1;
    this.roundUpFraction = paramFloat2;
  }
  
  @Nullable
  public static ResizeOptions forDimensions(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      return new ResizeOptions(paramInt1, paramInt2);
    }
    return null;
  }
  
  @Nullable
  public static ResizeOptions forSquareSize(int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    return new ResizeOptions(paramInt, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ResizeOptions)) {
      return false;
    }
    paramObject = (ResizeOptions)paramObject;
    return (this.width == ((ResizeOptions)paramObject).width) && (this.height == ((ResizeOptions)paramObject).height);
  }
  
  public int hashCode()
  {
    return HashCodeUtil.hashCode(this.width, this.height);
  }
  
  public String toString()
  {
    return String.format((Locale)null, "%dx%d", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\common\ResizeOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */