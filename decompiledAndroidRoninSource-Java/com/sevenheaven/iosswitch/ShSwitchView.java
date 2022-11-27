package com.sevenheaven.iosswitch;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

public class ShSwitchView
  extends View
{
  private static final int backgroundColor = -3355444;
  private static final long commonDuration = 300L;
  private static final int foregroundColor = -657931;
  private static final int intrinsicHeight = 0;
  private static final int intrinsicWidth = 0;
  private int centerX;
  private int centerY;
  private int colorStep = -3355444;
  private float cornerRadius;
  private boolean dirtyAnimation = false;
  private GestureDetector gestureDetector;
  private GestureDetector.SimpleOnGestureListener gestureListener = new GestureDetector.SimpleOnGestureListener()
  {
    public boolean onDown(MotionEvent paramAnonymousMotionEvent)
    {
      return false;
    }
    
    public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      return false;
    }
    
    public void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
    
    public boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
    {
      return false;
    }
  };
  private int height;
  private ValueAnimator innerContentAnimator;
  private RectF innerContentBound;
  private float innerContentRate = 1.0F;
  private float intrinsicInnerHeight;
  private float intrinsicInnerWidth;
  private float intrinsicKnobWidth;
  private boolean isAttachedToWindow = false;
  private boolean isOn;
  private RectF knobBound;
  private ValueAnimator knobExpandAnimator;
  private float knobExpandRate;
  private float knobMaxExpandWidth;
  private ValueAnimator knobMoveAnimator;
  private float knobMoveRate;
  private boolean knobState;
  private OnSwitchStateChangeListener onSwitchStateChangeListener;
  private int outerStrokeWidth;
  private RectF ovalForPath;
  private Paint paint;
  private boolean preIsOn;
  private Path roundRectPath;
  private Drawable shadowDrawable;
  private int shadowSpace;
  private RectF tempForRoundRect;
  private int tempTintColor;
  private int tintColor;
  private int width;
  
  public ShSwitchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShSwitchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ShSwitchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ShSwitchView);
    paramInt = paramAttributeSet.getColor(R.styleable.ShSwitchView_tintColor, -6493879);
    this.tintColor = paramInt;
    this.tempTintColor = paramInt;
    paramInt = (int)TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics());
    int i = (int)TypedValue.applyDimension(1, 5.0F, paramContext.getResources().getDisplayMetrics());
    this.outerStrokeWidth = paramAttributeSet.getDimensionPixelOffset(R.styleable.ShSwitchView_outerStrokeWidth, paramInt);
    this.shadowSpace = paramAttributeSet.getDimensionPixelOffset(R.styleable.ShSwitchView_shadowSpace, i);
    paramAttributeSet.recycle();
    this.knobBound = new RectF();
    this.innerContentBound = new RectF();
    this.ovalForPath = new RectF();
    this.tempForRoundRect = new RectF();
    this.paint = new Paint(1);
    this.roundRectPath = new Path();
    paramAttributeSet = new GestureDetector(paramContext, this.gestureListener);
    this.gestureDetector = paramAttributeSet;
    paramAttributeSet.setIsLongpressEnabled(false);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    initAnimators();
    this.shadowDrawable = paramContext.getResources().getDrawable(R.drawable.shadow);
  }
  
  private int RGBColorTransform(float paramFloat, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  /* Error */
  private void drawRoundRect(float arg1, float arg2, float arg3, float arg4, float arg5, android.graphics.Canvas arg6, Paint arg7)
  {
    // Byte code:
    //   0: return
    //   1: astore 6
    //   3: goto -3 -> 0
  }
  
  /* Error */
  private void initAnimators()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  float getInnerContentRate()
  {
    return this.innerContentRate;
  }
  
  float getKnobExpandRate()
  {
    return this.knobExpandRate;
  }
  
  float getKnobMoveRate()
  {
    return this.knobMoveRate;
  }
  
  public OnSwitchStateChangeListener getOnSwitchStateChangeListener()
  {
    return this.onSwitchStateChangeListener;
  }
  
  public int getTintColor()
  {
    return this.tintColor;
  }
  
  public boolean isOn()
  {
    return this.isOn;
  }
  
  /* Error */
  protected void onAttachedToWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.isAttachedToWindow = false;
  }
  
  /* Error */
  public void onDraw(android.graphics.Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onMeasure(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  /* Error */
  public void setEnabled(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  void setInnerContentRate(float paramFloat)
  {
    this.innerContentRate = paramFloat;
    invalidate();
  }
  
  void setKnobExpandRate(float paramFloat)
  {
    this.knobExpandRate = paramFloat;
    invalidate();
  }
  
  void setKnobMoveRate(float paramFloat)
  {
    this.knobMoveRate = paramFloat;
    invalidate();
  }
  
  public void setOn(boolean paramBoolean)
  {
    setOn(paramBoolean, false);
  }
  
  /* Error */
  public void setOn(boolean arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void setOnSwitchStateChangeListener(OnSwitchStateChangeListener paramOnSwitchStateChangeListener)
  {
    this.onSwitchStateChangeListener = paramOnSwitchStateChangeListener;
  }
  
  public void setTintColor(int paramInt)
  {
    this.tintColor = paramInt;
    this.tempTintColor = paramInt;
  }
  
  public static abstract interface OnSwitchStateChangeListener
  {
    public abstract void onSwitchStateChange(boolean paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\sevenheaven\iosswitch\ShSwitchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */