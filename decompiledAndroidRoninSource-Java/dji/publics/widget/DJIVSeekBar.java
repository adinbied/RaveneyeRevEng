package dji.publics.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import dji.frame.widget.R.styleable;

public class DJIVSeekBar
  extends View
{
  private static final int MAX_LEVEL = 10000;
  protected int mGravity = 80;
  private boolean mIsDragging = false;
  protected int mMax = 1;
  private OnVSBChangeListener mOnChangedListener = null;
  protected int mProgress = 0;
  protected Drawable mProgressDrawable = null;
  protected int mProgressWidth = 0;
  private int mScaledTouchSlop = 0;
  protected int mSecondaryProgress = 0;
  protected Drawable mSecondaryThumb = null;
  protected Drawable mThumb = null;
  private float mTouchDownY = 0.0F;
  private float mTouchProgressOffset = 0.0F;
  
  public DJIVSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initAttrs(paramContext);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.VerticalSB, 0, 0);
    this.mProgressWidth = paramContext.getDimensionPixelSize(R.styleable.VerticalSB_progressHeight, this.mProgressWidth);
    paramAttributeSet = paramContext.getDrawable(R.styleable.VerticalSB_progressDrawable);
    if (paramAttributeSet != null) {
      setProgressDrawable(paramAttributeSet);
    }
    setMax(paramContext.getInt(R.styleable.VerticalSB_max, this.mMax));
    setProgress(paramContext.getInt(R.styleable.VerticalSB_progress, this.mProgress));
    setSecondaryProgress(paramContext.getInt(R.styleable.VerticalSB_secondaryProgress, this.mSecondaryProgress));
    paramAttributeSet = paramContext.getDrawable(R.styleable.VerticalSB_thumb);
    if (paramAttributeSet != null) {
      setThumb(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(R.styleable.VerticalSB_secondaryThumb);
    if (paramAttributeSet != null) {
      setSecondaryThumb(paramAttributeSet);
    }
    paramContext.recycle();
  }
  
  /* Error */
  private void attemptClaimDrag()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void doRefreshProgress(int arg1, int arg2, boolean arg3, boolean arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: return
  }
  
  private Shape getDrawableShape()
  {
    return null;
  }
  
  /* Error */
  private void setProgress(int arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  private Drawable tileify(Drawable paramDrawable, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  /* Error */
  private void trackTouchEvent(MotionEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getMax()
  {
    return this.mMax;
  }
  
  public int getProgress()
  {
    return this.mProgress;
  }
  
  public int getSecondaryProgress()
  {
    return this.mSecondaryProgress;
  }
  
  public Drawable getThumb()
  {
    return this.mThumb;
  }
  
  /* Error */
  protected void initAttrs(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void invalidateDrawable(Drawable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isInScrollingContainer()
  {
    return false;
  }
  
  /* Error */
  protected void onDraw(android.graphics.Canvas arg1)
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
  
  /* Error */
  protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  /* Error */
  void onStartTrackingTouch()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onStopTrackingTouch()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  /* Error */
  protected void setDrawableBounds(int arg1, int arg2, Drawable arg3, float arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setMax(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setOnChangeListener(OnVSBChangeListener paramOnVSBChangeListener)
  {
    this.mOnChangedListener = paramOnVSBChangeListener;
  }
  
  public void setProgress(int paramInt)
  {
    setProgress(paramInt, false);
  }
  
  /* Error */
  public void setProgressDrawable(Drawable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setSecondaryProgress(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setSecondaryThumb(Drawable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setThumb(Drawable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void updateDrawableBounds(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return false;
  }
  
  public static abstract interface OnVSBChangeListener
  {
    public abstract void onProgressChanged(DJIVSeekBar paramDJIVSeekBar, int paramInt, boolean paramBoolean);
    
    public abstract void onStartTrackingTouch(DJIVSeekBar paramDJIVSeekBar);
    
    public abstract void onStopTrackingTouch(DJIVSeekBar paramDJIVSeekBar);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widget\DJIVSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */