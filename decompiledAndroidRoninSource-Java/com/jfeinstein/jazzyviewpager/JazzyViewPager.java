package com.jfeinstein.jazzyviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.LayoutParams;
import dji.frame.widget.R.styleable;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class JazzyViewPager
  extends ViewPager
{
  private static final boolean API_11;
  private static final float ROT_MAX = 15.0F;
  private static final float SCALE_MAX = 0.5F;
  public static final String TAG = "JazzyViewPager";
  private static final float ZOOM_MAX = 0.5F;
  public static int sOutlineColor = -1;
  private Camera mCamera = new Camera();
  private TransitionEffect mEffect = TransitionEffect.Standard;
  private boolean mEnabled = true;
  private boolean mFadeEnabled = false;
  private View mLeft;
  private Matrix mMatrix = new Matrix();
  private HashMap<Integer, Object> mObjs = new LinkedHashMap();
  private boolean mOutlineEnabled = false;
  private View mRight;
  private float mRot;
  private float mScale;
  private State mState;
  private float[] mTempFloat2 = new float[2];
  private float mTrans;
  private int oldPage;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    } else {
      bool = false;
    }
    API_11 = bool;
  }
  
  public JazzyViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public JazzyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setClipChildren(false);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.JazzyViewPager);
    int i = paramContext.getInt(R.styleable.JazzyViewPager_style, 0);
    setTransitionEffect(TransitionEffect.valueOf(getResources().getStringArray(dji.frame.widget.R.array.jazzy_effects)[i]));
    setFadeEnabled(paramContext.getBoolean(R.styleable.JazzyViewPager_fadeEnabled, false));
    setOutlineEnabled(paramContext.getBoolean(R.styleable.JazzyViewPager_outlineEnabled, false));
    setOutlineColor(paramContext.getColor(R.styleable.JazzyViewPager_outlineColor, -1));
    i = 1.$SwitchMap$com$jfeinstein$jazzyviewpager$JazzyViewPager$TransitionEffect[this.mEffect.ordinal()];
    if ((i == 1) || (i == 2)) {
      setFadeEnabled(true);
    }
    paramContext.recycle();
  }
  
  /* Error */
  private void animateAccordion(View arg1, View arg2, float arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void animateCube(View arg1, View arg2, float arg3, boolean arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void animateFlipHorizontal(View arg1, View arg2, float arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void animateFlipVertical(View arg1, View arg2, float arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void animateRotate(View arg1, View arg2, float arg3, boolean arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void animateZoom(View arg1, View arg2, float arg3, boolean arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void disableHardwareLayer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isSmall(float paramFloat)
  {
    return false;
  }
  
  /* Error */
  private void logState(View arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void manageLayer(View arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private View wrapChild(View paramView)
  {
    return null;
  }
  
  /* Error */
  private void wrapWithOutlines()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void addView(View paramView)
  {
    super.addView(wrapChild(paramView));
  }
  
  public void addView(View paramView, int paramInt)
  {
    super.addView(wrapChild(paramView), paramInt);
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    super.addView(wrapChild(paramView), paramInt1, paramInt2);
  }
  
  public void addView(View paramView, int paramInt, ViewPager.LayoutParams paramLayoutParams)
  {
    super.addView(wrapChild(paramView), paramInt, paramLayoutParams);
  }
  
  public void addView(View paramView, ViewPager.LayoutParams paramLayoutParams)
  {
    super.addView(wrapChild(paramView), paramLayoutParams);
  }
  
  /* Error */
  protected void animateFade(View arg1, View arg2, float arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void animateOutline(View arg1, View arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void animateScroll(int arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void animateStack(View arg1, View arg2, float arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void animateTablet(View arg1, View arg2, float arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public View findViewFromObject(int paramInt)
  {
    return null;
  }
  
  public boolean getFadeEnabled()
  {
    return this.mFadeEnabled;
  }
  
  protected float getOffsetXForRotation(float paramFloat, int paramInt1, int paramInt2)
  {
    return 0.0F;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  /* Error */
  public void onPageScrolled(int arg1, float arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  public void setFadeEnabled(boolean paramBoolean)
  {
    this.mFadeEnabled = paramBoolean;
  }
  
  /* Error */
  public void setObjectForPosition(Object arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setOutlineColor(int paramInt)
  {
    sOutlineColor = paramInt;
  }
  
  public void setOutlineEnabled(boolean paramBoolean)
  {
    this.mOutlineEnabled = paramBoolean;
    wrapWithOutlines();
  }
  
  public void setPagingEnabled(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
  }
  
  public void setTransitionEffect(TransitionEffect paramTransitionEffect)
  {
    this.mEffect = paramTransitionEffect;
  }
  
  private static enum State
  {
    static
    {
      GOING_LEFT = new State("GOING_LEFT", 1);
      State localState = new State("GOING_RIGHT", 2);
      GOING_RIGHT = localState;
      $VALUES = new State[] { IDLE, GOING_LEFT, localState };
    }
    
    private State() {}
  }
  
  public static enum TransitionEffect
  {
    static
    {
      CubeIn = new TransitionEffect("CubeIn", 2);
      CubeOut = new TransitionEffect("CubeOut", 3);
      FlipVertical = new TransitionEffect("FlipVertical", 4);
      FlipHorizontal = new TransitionEffect("FlipHorizontal", 5);
      Stack = new TransitionEffect("Stack", 6);
      ZoomIn = new TransitionEffect("ZoomIn", 7);
      ZoomOut = new TransitionEffect("ZoomOut", 8);
      RotateUp = new TransitionEffect("RotateUp", 9);
      RotateDown = new TransitionEffect("RotateDown", 10);
      TransitionEffect localTransitionEffect = new TransitionEffect("Accordion", 11);
      Accordion = localTransitionEffect;
      $VALUES = new TransitionEffect[] { Standard, Tablet, CubeIn, CubeOut, FlipVertical, FlipHorizontal, Stack, ZoomIn, ZoomOut, RotateUp, RotateDown, localTransitionEffect };
    }
    
    private TransitionEffect() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jfeinstein\jazzyviewpager\JazzyViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */