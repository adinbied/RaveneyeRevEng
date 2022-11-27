package com.facebook.drawee.generic;

import com.facebook.common.internal.Preconditions;
import java.util.Arrays;
import javax.annotation.Nullable;

public class RoundingParams
{
  private int mBorderColor = 0;
  private float mBorderWidth = 0.0F;
  @Nullable
  private float[] mCornersRadii = null;
  private int mOverlayColor = 0;
  private float mPadding = 0.0F;
  private boolean mPaintFilterBitmap = false;
  private boolean mRoundAsCircle = false;
  private RoundingMethod mRoundingMethod = RoundingMethod.BITMAP_ONLY;
  private boolean mScaleDownInsideBorders = false;
  
  public static RoundingParams asCircle()
  {
    return new RoundingParams().setRoundAsCircle(true);
  }
  
  public static RoundingParams fromCornersRadii(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return new RoundingParams().setCornersRadii(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public static RoundingParams fromCornersRadii(float[] paramArrayOfFloat)
  {
    return new RoundingParams().setCornersRadii(paramArrayOfFloat);
  }
  
  public static RoundingParams fromCornersRadius(float paramFloat)
  {
    return new RoundingParams().setCornersRadius(paramFloat);
  }
  
  private float[] getOrCreateRoundedCornersRadii()
  {
    if (this.mCornersRadii == null) {
      this.mCornersRadii = new float[8];
    }
    return this.mCornersRadii;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (RoundingParams)paramObject;
      if (this.mRoundAsCircle != ((RoundingParams)paramObject).mRoundAsCircle) {
        return false;
      }
      if (this.mOverlayColor != ((RoundingParams)paramObject).mOverlayColor) {
        return false;
      }
      if (Float.compare(((RoundingParams)paramObject).mBorderWidth, this.mBorderWidth) != 0) {
        return false;
      }
      if (this.mBorderColor != ((RoundingParams)paramObject).mBorderColor) {
        return false;
      }
      if (Float.compare(((RoundingParams)paramObject).mPadding, this.mPadding) != 0) {
        return false;
      }
      if (this.mRoundingMethod != ((RoundingParams)paramObject).mRoundingMethod) {
        return false;
      }
      if (this.mScaleDownInsideBorders != ((RoundingParams)paramObject).mScaleDownInsideBorders) {
        return false;
      }
      if (this.mPaintFilterBitmap != ((RoundingParams)paramObject).mPaintFilterBitmap) {
        return false;
      }
      return Arrays.equals(this.mCornersRadii, ((RoundingParams)paramObject).mCornersRadii);
    }
    return false;
  }
  
  public int getBorderColor()
  {
    return this.mBorderColor;
  }
  
  public float getBorderWidth()
  {
    return this.mBorderWidth;
  }
  
  @Nullable
  public float[] getCornersRadii()
  {
    return this.mCornersRadii;
  }
  
  public int getOverlayColor()
  {
    return this.mOverlayColor;
  }
  
  public float getPadding()
  {
    return this.mPadding;
  }
  
  public boolean getPaintFilterBitmap()
  {
    return this.mPaintFilterBitmap;
  }
  
  public boolean getRoundAsCircle()
  {
    return this.mRoundAsCircle;
  }
  
  public RoundingMethod getRoundingMethod()
  {
    return this.mRoundingMethod;
  }
  
  public boolean getScaleDownInsideBorders()
  {
    return this.mScaleDownInsideBorders;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public RoundingParams setBorder(int paramInt, float paramFloat)
  {
    boolean bool;
    if (paramFloat >= 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "the border width cannot be < 0");
    this.mBorderWidth = paramFloat;
    this.mBorderColor = paramInt;
    return this;
  }
  
  public RoundingParams setBorderColor(int paramInt)
  {
    this.mBorderColor = paramInt;
    return this;
  }
  
  public RoundingParams setBorderWidth(float paramFloat)
  {
    boolean bool;
    if (paramFloat >= 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "the border width cannot be < 0");
    this.mBorderWidth = paramFloat;
    return this;
  }
  
  public RoundingParams setCornersRadii(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = getOrCreateRoundedCornersRadii();
    arrayOfFloat[1] = paramFloat1;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[3] = paramFloat2;
    arrayOfFloat[2] = paramFloat2;
    arrayOfFloat[5] = paramFloat3;
    arrayOfFloat[4] = paramFloat3;
    arrayOfFloat[7] = paramFloat4;
    arrayOfFloat[6] = paramFloat4;
    return this;
  }
  
  public RoundingParams setCornersRadii(float[] paramArrayOfFloat)
  {
    Preconditions.checkNotNull(paramArrayOfFloat);
    boolean bool;
    if (paramArrayOfFloat.length == 8) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "radii should have exactly 8 values");
    System.arraycopy(paramArrayOfFloat, 0, getOrCreateRoundedCornersRadii(), 0, 8);
    return this;
  }
  
  public RoundingParams setCornersRadius(float paramFloat)
  {
    Arrays.fill(getOrCreateRoundedCornersRadii(), paramFloat);
    return this;
  }
  
  public RoundingParams setOverlayColor(int paramInt)
  {
    this.mOverlayColor = paramInt;
    this.mRoundingMethod = RoundingMethod.OVERLAY_COLOR;
    return this;
  }
  
  public RoundingParams setPadding(float paramFloat)
  {
    boolean bool;
    if (paramFloat >= 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "the padding cannot be < 0");
    this.mPadding = paramFloat;
    return this;
  }
  
  public RoundingParams setPaintFilterBitmap(boolean paramBoolean)
  {
    this.mPaintFilterBitmap = paramBoolean;
    return this;
  }
  
  public RoundingParams setRoundAsCircle(boolean paramBoolean)
  {
    this.mRoundAsCircle = paramBoolean;
    return this;
  }
  
  public RoundingParams setRoundingMethod(RoundingMethod paramRoundingMethod)
  {
    this.mRoundingMethod = paramRoundingMethod;
    return this;
  }
  
  public RoundingParams setScaleDownInsideBorders(boolean paramBoolean)
  {
    this.mScaleDownInsideBorders = paramBoolean;
    return this;
  }
  
  public static enum RoundingMethod
  {
    static
    {
      RoundingMethod localRoundingMethod = new RoundingMethod("BITMAP_ONLY", 1);
      BITMAP_ONLY = localRoundingMethod;
      $VALUES = new RoundingMethod[] { OVERLAY_COLOR, localRoundingMethod };
    }
    
    private RoundingMethod() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\generic\RoundingParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */