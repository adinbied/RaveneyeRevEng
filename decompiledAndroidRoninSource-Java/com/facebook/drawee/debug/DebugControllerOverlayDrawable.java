package com.facebook.drawee.debug;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.debug.listener.ImageLoadingTimeListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public class DebugControllerOverlayDrawable
  extends Drawable
  implements ImageLoadingTimeListener
{
  private static final float IMAGE_SIZE_THRESHOLD_NOT_OK = 0.5F;
  private static final float IMAGE_SIZE_THRESHOLD_OK = 0.1F;
  private static final int MAX_LINE_WIDTH_EM = 8;
  private static final int MAX_NUMBER_OF_LINES = 9;
  private static final int MAX_TEXT_SIZE_PX = 40;
  private static final int MIN_TEXT_SIZE_PX = 10;
  private static final String NO_CONTROLLER_ID = "none";
  private static final int OUTLINE_COLOR = -26624;
  private static final int OUTLINE_STROKE_WIDTH_PX = 2;
  private static final int TEXT_BACKGROUND_COLOR = 1711276032;
  private static final int TEXT_COLOR = -1;
  static final int TEXT_COLOR_IMAGE_ALMOST_OK = -256;
  static final int TEXT_COLOR_IMAGE_NOT_OK = -65536;
  static final int TEXT_COLOR_IMAGE_OK = -16711936;
  private static final int TEXT_LINE_SPACING_PX = 8;
  private static final int TEXT_PADDING_PX = 10;
  private HashMap<String, String> mAdditionalData = new HashMap();
  private String mControllerId;
  private int mCurrentTextXPx;
  private int mCurrentTextYPx;
  private long mFinalImageTimeMs;
  private int mFrameCount;
  private int mHeightPx;
  private String mImageFormat;
  private String mImageId;
  private int mImageSizeBytes;
  private int mLineIncrementPx;
  private int mLoopCount;
  private final Matrix mMatrix = new Matrix();
  private int mOriginColor = -1;
  private String mOriginText;
  private int mOverlayColor = 0;
  private final Paint mPaint = new Paint(1);
  private final Rect mRect = new Rect();
  private final RectF mRectF = new RectF();
  private ScalingUtils.ScaleType mScaleType;
  private int mStartTextXPx;
  private int mStartTextYPx;
  private int mTextGravity = 80;
  private int mWidthPx;
  
  public DebugControllerOverlayDrawable()
  {
    reset();
  }
  
  private void addDebugText(Canvas paramCanvas, String paramString, Object paramObject)
  {
    addDebugText(paramCanvas, paramString, String.valueOf(paramObject), -1);
  }
  
  private void addDebugText(Canvas paramCanvas, String paramString1, String paramString2)
  {
    addDebugText(paramCanvas, paramString1, paramString2, -1);
  }
  
  private void addDebugText(Canvas paramCanvas, String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(": ");
    paramString1 = localStringBuilder.toString();
    float f1 = this.mPaint.measureText(paramString1);
    float f2 = this.mPaint.measureText(paramString2);
    this.mPaint.setColor(1711276032);
    int i = this.mCurrentTextXPx;
    float f3 = i - 4;
    int j = this.mCurrentTextYPx;
    paramCanvas.drawRect(f3, j + 8, i + f1 + f2 + 4.0F, j + this.mLineIncrementPx + 8, this.mPaint);
    this.mPaint.setColor(-1);
    paramCanvas.drawText(paramString1, this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
    this.mPaint.setColor(paramInt);
    paramCanvas.drawText(paramString2, this.mCurrentTextXPx + f1, this.mCurrentTextYPx, this.mPaint);
    this.mCurrentTextYPx += this.mLineIncrementPx;
  }
  
  private static String format(String paramString, @Nullable Object... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return paramString;
    }
    return String.format(Locale.US, paramString, paramVarArgs);
  }
  
  private void prepareDebugTextParameters(Rect paramRect, int paramInt1, int paramInt2)
  {
    paramInt1 = Math.min(40, Math.max(10, Math.min(paramRect.width() / paramInt2, paramRect.height() / paramInt1)));
    this.mPaint.setTextSize(paramInt1);
    paramInt1 += 8;
    this.mLineIncrementPx = paramInt1;
    if (this.mTextGravity == 80) {
      this.mLineIncrementPx = (paramInt1 * -1);
    }
    this.mStartTextXPx = (paramRect.left + 10);
    if (this.mTextGravity == 80) {
      paramInt1 = paramRect.bottom - 10;
    } else {
      paramInt1 = paramRect.top + 10 + 10;
    }
    this.mStartTextYPx = paramInt1;
  }
  
  public void addAdditionalData(String paramString1, String paramString2)
  {
    this.mAdditionalData.put(paramString1, paramString2);
  }
  
  int determineSizeHintColor(int paramInt1, int paramInt2, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    int m = getBounds().width();
    int k = getBounds().height();
    if ((m > 0) && (k > 0) && (paramInt1 > 0))
    {
      if (paramInt2 <= 0) {
        return -65536;
      }
      int j = m;
      int i = k;
      if (paramScaleType != null)
      {
        Rect localRect = this.mRect;
        localRect.top = 0;
        localRect.left = 0;
        this.mRect.right = m;
        this.mRect.bottom = k;
        this.mMatrix.reset();
        paramScaleType.getTransform(this.mMatrix, this.mRect, paramInt1, paramInt2, 0.0F, 0.0F);
        paramScaleType = this.mRectF;
        paramScaleType.top = 0.0F;
        paramScaleType.left = 0.0F;
        this.mRectF.right = paramInt1;
        this.mRectF.bottom = paramInt2;
        this.mMatrix.mapRect(this.mRectF);
        j = (int)this.mRectF.width();
        i = (int)this.mRectF.height();
        j = Math.min(m, j);
        i = Math.min(k, i);
      }
      float f1 = j;
      float f2 = i;
      paramInt1 = Math.abs(paramInt1 - j);
      paramInt2 = Math.abs(paramInt2 - i);
      float f3 = paramInt1;
      if ((f3 < f1 * 0.1F) && (paramInt2 < 0.1F * f2)) {
        return -16711936;
      }
      if ((f3 < f1 * 0.5F) && (paramInt2 < f2 * 0.5F)) {
        return 65280;
      }
    }
    return -65536;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject1 = getBounds();
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(2.0F);
    this.mPaint.setColor(38912);
    paramCanvas.drawRect(((Rect)localObject1).left, ((Rect)localObject1).top, ((Rect)localObject1).right, ((Rect)localObject1).bottom, this.mPaint);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(this.mOverlayColor);
    paramCanvas.drawRect(((Rect)localObject1).left, ((Rect)localObject1).top, ((Rect)localObject1).right, ((Rect)localObject1).bottom, this.mPaint);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setStrokeWidth(0.0F);
    this.mPaint.setColor(-1);
    this.mCurrentTextXPx = this.mStartTextXPx;
    this.mCurrentTextYPx = this.mStartTextYPx;
    Object localObject2 = this.mImageId;
    if (localObject2 != null) {
      addDebugText(paramCanvas, "IDs", format("%s, %s", new Object[] { this.mControllerId, localObject2 }));
    } else {
      addDebugText(paramCanvas, "ID", this.mControllerId);
    }
    addDebugText(paramCanvas, "D", format("%dx%d", new Object[] { Integer.valueOf(((Rect)localObject1).width()), Integer.valueOf(((Rect)localObject1).height()) }));
    int i = determineSizeHintColor(this.mWidthPx, this.mHeightPx, this.mScaleType);
    addDebugText(paramCanvas, "I", format("%dx%d", new Object[] { Integer.valueOf(this.mWidthPx), Integer.valueOf(this.mHeightPx) }), i);
    addDebugText(paramCanvas, "I", format("%d KiB", new Object[] { Integer.valueOf(this.mImageSizeBytes / 1024) }));
    localObject1 = this.mImageFormat;
    if (localObject1 != null) {
      addDebugText(paramCanvas, "i format", (String)localObject1);
    }
    i = this.mFrameCount;
    if (i > 0) {
      addDebugText(paramCanvas, "anim", format("f %d, l %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mLoopCount) }));
    }
    localObject1 = this.mScaleType;
    if (localObject1 != null) {
      addDebugText(paramCanvas, "scale", localObject1);
    }
    long l = this.mFinalImageTimeMs;
    if (l >= 0L) {
      addDebugText(paramCanvas, "t", format("%d ms", new Object[] { Long.valueOf(l) }));
    }
    localObject1 = this.mOriginText;
    if (localObject1 != null) {
      addDebugText(paramCanvas, "origin", (String)localObject1, this.mOriginColor);
    }
    localObject1 = this.mAdditionalData.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      addDebugText(paramCanvas, (String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    prepareDebugTextParameters(paramRect, 9, 8);
  }
  
  public void onFinalImageSet(long paramLong)
  {
    this.mFinalImageTimeMs = paramLong;
    invalidateSelf();
  }
  
  public void reset()
  {
    this.mWidthPx = -1;
    this.mHeightPx = -1;
    this.mImageSizeBytes = -1;
    this.mAdditionalData = new HashMap();
    this.mFrameCount = -1;
    this.mLoopCount = -1;
    this.mImageFormat = null;
    setControllerId(null);
    this.mFinalImageTimeMs = -1L;
    this.mOriginText = null;
    this.mOriginColor = -1;
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setAnimationInfo(int paramInt1, int paramInt2)
  {
    this.mFrameCount = paramInt1;
    this.mLoopCount = paramInt2;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setControllerId(@Nullable String paramString)
  {
    if (paramString == null) {
      paramString = "none";
    }
    this.mControllerId = paramString;
    invalidateSelf();
  }
  
  public void setDimensions(int paramInt1, int paramInt2)
  {
    this.mWidthPx = paramInt1;
    this.mHeightPx = paramInt2;
    invalidateSelf();
  }
  
  public void setFinalImageTimeMs(long paramLong)
  {
    this.mFinalImageTimeMs = paramLong;
  }
  
  public void setImageFormat(@Nullable String paramString)
  {
    this.mImageFormat = paramString;
  }
  
  public void setImageId(@Nullable String paramString)
  {
    this.mImageId = paramString;
    invalidateSelf();
  }
  
  public void setImageSize(int paramInt)
  {
    this.mImageSizeBytes = paramInt;
  }
  
  public void setOrigin(String paramString, int paramInt)
  {
    this.mOriginText = paramString;
    this.mOriginColor = paramInt;
    invalidateSelf();
  }
  
  public void setOverlayColor(int paramInt)
  {
    this.mOverlayColor = paramInt;
  }
  
  public void setScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    this.mScaleType = paramScaleType;
  }
  
  public void setTextGravity(int paramInt)
  {
    this.mTextGravity = paramInt;
    invalidateSelf();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\debug\DebugControllerOverlayDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */