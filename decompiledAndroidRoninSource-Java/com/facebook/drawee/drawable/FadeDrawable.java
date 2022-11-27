package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import java.util.Arrays;
import javax.annotation.Nullable;

public class FadeDrawable
  extends ArrayDrawable
{
  public static final int TRANSITION_NONE = 2;
  public static final int TRANSITION_RUNNING = 1;
  public static final int TRANSITION_STARTING = 0;
  private final int ACTUAL_IMAGE_INDEX = 2;
  int mAlpha;
  int[] mAlphas;
  private boolean mCallOnFadeFinishedListener;
  private final int mDefaultLayerAlpha;
  private final boolean mDefaultLayerIsOn;
  int mDurationMs;
  boolean[] mIsLayerOn;
  private final Drawable[] mLayers;
  @Nullable
  private OnFadeFinishedListener mOnFadeFinishedListener;
  int mPreventInvalidateCount;
  int[] mStartAlphas;
  long mStartTimeMs;
  int mTransitionState;
  
  public FadeDrawable(Drawable[] paramArrayOfDrawable)
  {
    this(paramArrayOfDrawable, false);
  }
  
  public FadeDrawable(Drawable[] paramArrayOfDrawable, boolean paramBoolean)
  {
    super(paramArrayOfDrawable);
    int j = paramArrayOfDrawable.length;
    boolean bool = true;
    int i = 0;
    if (j < 1) {
      bool = false;
    }
    Preconditions.checkState(bool, "At least one layer required!");
    this.mLayers = paramArrayOfDrawable;
    this.mStartAlphas = new int[paramArrayOfDrawable.length];
    this.mAlphas = new int[paramArrayOfDrawable.length];
    this.mAlpha = 255;
    this.mIsLayerOn = new boolean[paramArrayOfDrawable.length];
    this.mPreventInvalidateCount = 0;
    this.mDefaultLayerIsOn = paramBoolean;
    if (paramBoolean) {
      i = 255;
    }
    this.mDefaultLayerAlpha = i;
    resetInternal();
  }
  
  private void drawDrawableWithAlpha(Canvas paramCanvas, Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable != null) && (paramInt > 0))
    {
      this.mPreventInvalidateCount += 1;
      paramDrawable.mutate().setAlpha(paramInt);
      this.mPreventInvalidateCount -= 1;
      paramDrawable.draw(paramCanvas);
    }
  }
  
  private void maybeNotifyOnFadeFinished()
  {
    OnFadeFinishedListener localOnFadeFinishedListener = this.mOnFadeFinishedListener;
    if ((localOnFadeFinishedListener != null) && (this.mCallOnFadeFinishedListener))
    {
      localOnFadeFinishedListener.onFadeFinished();
      this.mCallOnFadeFinishedListener = false;
    }
  }
  
  private void resetInternal()
  {
    this.mTransitionState = 2;
    Arrays.fill(this.mStartAlphas, this.mDefaultLayerAlpha);
    this.mStartAlphas[0] = 255;
    Arrays.fill(this.mAlphas, this.mDefaultLayerAlpha);
    this.mAlphas[0] = 255;
    Arrays.fill(this.mIsLayerOn, this.mDefaultLayerIsOn);
    this.mIsLayerOn[0] = true;
  }
  
  private boolean updateAlphas(float paramFloat)
  {
    int i = 0;
    boolean bool2 = true;
    while (i < this.mLayers.length)
    {
      int j;
      if (this.mIsLayerOn[i] != 0) {
        j = 1;
      } else {
        j = -1;
      }
      int[] arrayOfInt = this.mAlphas;
      arrayOfInt[i] = ((int)(this.mStartAlphas[i] + j * 255 * paramFloat));
      if (arrayOfInt[i] < 0) {
        arrayOfInt[i] = 0;
      }
      arrayOfInt = this.mAlphas;
      if (arrayOfInt[i] > 255) {
        arrayOfInt[i] = 255;
      }
      boolean bool1 = bool2;
      if (this.mIsLayerOn[i] != 0)
      {
        bool1 = bool2;
        if (this.mAlphas[i] < 255) {
          bool1 = false;
        }
      }
      bool2 = bool1;
      if (this.mIsLayerOn[i] == 0)
      {
        bool2 = bool1;
        if (this.mAlphas[i] > 0) {
          bool2 = false;
        }
      }
      i += 1;
    }
    return bool2;
  }
  
  public void beginBatchMode()
  {
    this.mPreventInvalidateCount += 1;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = this.mTransitionState;
    int i = 2;
    int j = 0;
    boolean bool1 = true;
    boolean bool2;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          i = j;
          break label207;
        }
        maybeNotifyOnFadeFinished();
        i = j;
        break label207;
      }
      if (this.mDurationMs > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1);
      bool2 = updateAlphas((float)(getCurrentTimeMs() - this.mStartTimeMs) / this.mDurationMs);
      if (!bool2) {
        i = 1;
      }
      this.mTransitionState = i;
      bool1 = bool2;
      if (bool2)
      {
        maybeNotifyOnFadeFinished();
        bool1 = bool2;
      }
    }
    else
    {
      System.arraycopy(this.mAlphas, 0, this.mStartAlphas, 0, this.mLayers.length);
      this.mStartTimeMs = getCurrentTimeMs();
      float f;
      if (this.mDurationMs == 0) {
        f = 1.0F;
      } else {
        f = 0.0F;
      }
      bool2 = updateAlphas(f);
      if (!bool2) {
        i = 1;
      }
      this.mTransitionState = i;
      bool1 = bool2;
      if (bool2)
      {
        maybeNotifyOnFadeFinished();
        bool1 = bool2;
      }
    }
    i = j;
    for (;;)
    {
      label207:
      Drawable[] arrayOfDrawable = this.mLayers;
      if (i >= arrayOfDrawable.length) {
        break;
      }
      drawDrawableWithAlpha(paramCanvas, arrayOfDrawable[i], this.mAlphas[i] * this.mAlpha / 255);
      i += 1;
    }
    if (!bool1) {
      invalidateSelf();
    }
  }
  
  public void endBatchMode()
  {
    this.mPreventInvalidateCount -= 1;
    invalidateSelf();
  }
  
  public void fadeInAllLayers()
  {
    this.mTransitionState = 0;
    Arrays.fill(this.mIsLayerOn, true);
    invalidateSelf();
  }
  
  public void fadeInLayer(int paramInt)
  {
    boolean bool;
    if (paramInt == 2) {
      bool = true;
    } else {
      bool = false;
    }
    this.mCallOnFadeFinishedListener = bool;
    this.mTransitionState = 0;
    this.mIsLayerOn[paramInt] = true;
    invalidateSelf();
  }
  
  public void fadeOutAllLayers()
  {
    this.mTransitionState = 0;
    Arrays.fill(this.mIsLayerOn, false);
    invalidateSelf();
  }
  
  public void fadeOutLayer(int paramInt)
  {
    this.mTransitionState = 0;
    this.mIsLayerOn[paramInt] = false;
    invalidateSelf();
  }
  
  public void fadeToLayer(int paramInt)
  {
    this.mTransitionState = 0;
    Arrays.fill(this.mIsLayerOn, false);
    this.mIsLayerOn[paramInt] = true;
    invalidateSelf();
  }
  
  public void fadeUpToLayer(int paramInt)
  {
    this.mTransitionState = 0;
    boolean[] arrayOfBoolean = this.mIsLayerOn;
    paramInt += 1;
    Arrays.fill(arrayOfBoolean, 0, paramInt, true);
    Arrays.fill(this.mIsLayerOn, paramInt, this.mLayers.length, false);
    invalidateSelf();
  }
  
  public void finishTransitionImmediately()
  {
    this.mTransitionState = 2;
    int i = 0;
    while (i < this.mLayers.length)
    {
      int[] arrayOfInt = this.mAlphas;
      int j;
      if (this.mIsLayerOn[i] != 0) {
        j = 255;
      } else {
        j = 0;
      }
      arrayOfInt[i] = j;
      i += 1;
    }
    invalidateSelf();
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  protected long getCurrentTimeMs()
  {
    return SystemClock.uptimeMillis();
  }
  
  public int getTransitionDuration()
  {
    return this.mDurationMs;
  }
  
  public int getTransitionState()
  {
    return this.mTransitionState;
  }
  
  public void hideLayerImmediately(int paramInt)
  {
    this.mIsLayerOn[paramInt] = false;
    this.mAlphas[paramInt] = 0;
    invalidateSelf();
  }
  
  public void invalidateSelf()
  {
    if (this.mPreventInvalidateCount == 0) {
      super.invalidateSelf();
    }
  }
  
  public boolean isDefaultLayerIsOn()
  {
    return this.mDefaultLayerIsOn;
  }
  
  public boolean isLayerOn(int paramInt)
  {
    return this.mIsLayerOn[paramInt];
  }
  
  public void reset()
  {
    resetInternal();
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.mAlpha != paramInt)
    {
      this.mAlpha = paramInt;
      invalidateSelf();
    }
  }
  
  public void setOnFadeFinishedListener(OnFadeFinishedListener paramOnFadeFinishedListener)
  {
    this.mOnFadeFinishedListener = paramOnFadeFinishedListener;
  }
  
  public void setTransitionDuration(int paramInt)
  {
    this.mDurationMs = paramInt;
    if (this.mTransitionState == 1) {
      this.mTransitionState = 0;
    }
  }
  
  public void showLayerImmediately(int paramInt)
  {
    this.mIsLayerOn[paramInt] = true;
    this.mAlphas[paramInt] = 255;
    invalidateSelf();
  }
  
  public static abstract interface OnFadeFinishedListener
  {
    public abstract void onFadeFinished();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\drawable\FadeDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */