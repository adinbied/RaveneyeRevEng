package com.facebook.imagepipeline.common;

import com.facebook.common.util.HashCodeUtil;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

public class RotationOptions
{
  private static final int DISABLE_ROTATION = -2;
  public static final int NO_ROTATION = 0;
  public static final int ROTATE_180 = 180;
  public static final int ROTATE_270 = 270;
  public static final int ROTATE_90 = 90;
  private static final RotationOptions ROTATION_OPTIONS_AUTO_ROTATE = new RotationOptions(-1, false);
  private static final RotationOptions ROTATION_OPTIONS_DISABLE_ROTATION = new RotationOptions(-2, false);
  private static final RotationOptions ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME = new RotationOptions(-1, true);
  private static final int USE_EXIF_ROTATION_ANGLE = -1;
  private final boolean mDeferUntilRendered;
  private final int mRotation;
  
  private RotationOptions(int paramInt, boolean paramBoolean)
  {
    this.mRotation = paramInt;
    this.mDeferUntilRendered = paramBoolean;
  }
  
  public static RotationOptions autoRotate()
  {
    return ROTATION_OPTIONS_AUTO_ROTATE;
  }
  
  public static RotationOptions autoRotateAtRenderTime()
  {
    return ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME;
  }
  
  public static RotationOptions disableRotation()
  {
    return ROTATION_OPTIONS_DISABLE_ROTATION;
  }
  
  public static RotationOptions forceRotation(int paramInt)
  {
    return new RotationOptions(paramInt, false);
  }
  
  public boolean canDeferUntilRendered()
  {
    return this.mDeferUntilRendered;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof RotationOptions)) {
      return false;
    }
    paramObject = (RotationOptions)paramObject;
    return (this.mRotation == ((RotationOptions)paramObject).mRotation) && (this.mDeferUntilRendered == ((RotationOptions)paramObject).mDeferUntilRendered);
  }
  
  public int getForcedAngle()
  {
    if (!useImageMetadata()) {
      return this.mRotation;
    }
    throw new IllegalStateException("Rotation is set to use EXIF");
  }
  
  public int hashCode()
  {
    return HashCodeUtil.hashCode(Integer.valueOf(this.mRotation), Boolean.valueOf(this.mDeferUntilRendered));
  }
  
  public boolean rotationEnabled()
  {
    return this.mRotation != -2;
  }
  
  public String toString()
  {
    return String.format((Locale)null, "%d defer:%b", new Object[] { Integer.valueOf(this.mRotation), Boolean.valueOf(this.mDeferUntilRendered) });
  }
  
  public boolean useImageMetadata()
  {
    return this.mRotation == -1;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface RotationAngle {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\common\RotationOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */