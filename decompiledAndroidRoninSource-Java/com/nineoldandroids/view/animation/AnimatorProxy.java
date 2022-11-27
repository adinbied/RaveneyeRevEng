package com.nineoldandroids.view.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class AnimatorProxy
  extends Animation
{
  public static final boolean NEEDS_PROXY;
  private static final WeakHashMap<View, AnimatorProxy> PROXIES = new WeakHashMap();
  private final RectF mAfter = new RectF();
  private float mAlpha = 1.0F;
  private final RectF mBefore = new RectF();
  private final Camera mCamera = new Camera();
  private boolean mHasPivot;
  private float mPivotX;
  private float mPivotY;
  private float mRotationX;
  private float mRotationY;
  private float mRotationZ;
  private float mScaleX = 1.0F;
  private float mScaleY = 1.0F;
  private final Matrix mTempMatrix = new Matrix();
  private float mTranslationX;
  private float mTranslationY;
  private final WeakReference<View> mView;
  
  static
  {
    boolean bool;
    if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11) {
      bool = true;
    } else {
      bool = false;
    }
    NEEDS_PROXY = bool;
  }
  
  private AnimatorProxy(View paramView)
  {
    setDuration(0L);
    setFillAfter(true);
    paramView.setAnimation(this);
    this.mView = new WeakReference(paramView);
  }
  
  /* Error */
  private void computeRect(RectF arg1, View arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void invalidateAfterUpdate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void prepareForUpdate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void transformMatrix(Matrix arg1, View arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static AnimatorProxy wrap(View paramView)
  {
    AnimatorProxy localAnimatorProxy2 = (AnimatorProxy)PROXIES.get(paramView);
    AnimatorProxy localAnimatorProxy1;
    if (localAnimatorProxy2 != null)
    {
      localAnimatorProxy1 = localAnimatorProxy2;
      if (localAnimatorProxy2 == paramView.getAnimation()) {}
    }
    else
    {
      localAnimatorProxy1 = new AnimatorProxy(paramView);
      PROXIES.put(paramView, localAnimatorProxy1);
    }
    return localAnimatorProxy1;
  }
  
  /* Error */
  protected void applyTransformation(float arg1, android.view.animation.Transformation arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public float getPivotX()
  {
    return this.mPivotX;
  }
  
  public float getPivotY()
  {
    return this.mPivotY;
  }
  
  public float getRotation()
  {
    return this.mRotationZ;
  }
  
  public float getRotationX()
  {
    return this.mRotationX;
  }
  
  public float getRotationY()
  {
    return this.mRotationY;
  }
  
  public float getScaleX()
  {
    return this.mScaleX;
  }
  
  public float getScaleY()
  {
    return this.mScaleY;
  }
  
  public int getScrollX()
  {
    return 0;
  }
  
  public int getScrollY()
  {
    return 0;
  }
  
  public float getTranslationX()
  {
    return this.mTranslationX;
  }
  
  public float getTranslationY()
  {
    return this.mTranslationY;
  }
  
  public float getX()
  {
    return 0.0F;
  }
  
  public float getY()
  {
    return 0.0F;
  }
  
  /* Error */
  public void setAlpha(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setPivotX(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setPivotY(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setRotation(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setRotationX(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setRotationY(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setScaleX(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setScaleY(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setScrollX(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setScrollY(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setTranslationX(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setTranslationY(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setX(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setY(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\nineoldandroids\view\animation\AnimatorProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */