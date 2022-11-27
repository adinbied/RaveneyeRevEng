package io.flutter.embedding.android;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public final class DrawableSplashScreen
  implements SplashScreen
{
  private final long crossfadeDurationInMillis;
  private final Drawable drawable;
  private final ImageView.ScaleType scaleType;
  private DrawableSplashScreenView splashView;
  
  public DrawableSplashScreen(Drawable paramDrawable)
  {
    this(paramDrawable, ImageView.ScaleType.FIT_XY, 500L);
  }
  
  public DrawableSplashScreen(Drawable paramDrawable, ImageView.ScaleType paramScaleType, long paramLong)
  {
    this.drawable = paramDrawable;
    this.scaleType = paramScaleType;
    this.crossfadeDurationInMillis = paramLong;
  }
  
  public View createSplashView(Context paramContext, Bundle paramBundle)
  {
    return null;
  }
  
  /* Error */
  public void transitionToFlutter(Runnable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class DrawableSplashScreenView
    extends ImageView
  {
    public DrawableSplashScreenView(Context paramContext)
    {
      this(paramContext, null, 0);
    }
    
    public DrawableSplashScreenView(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, 0);
    }
    
    public DrawableSplashScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    public void setSplashDrawable(Drawable paramDrawable)
    {
      setSplashDrawable(paramDrawable, ImageView.ScaleType.FIT_XY);
    }
    
    public void setSplashDrawable(Drawable paramDrawable, ImageView.ScaleType paramScaleType)
    {
      setScaleType(paramScaleType);
      setImageDrawable(paramDrawable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\android\DrawableSplashScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */