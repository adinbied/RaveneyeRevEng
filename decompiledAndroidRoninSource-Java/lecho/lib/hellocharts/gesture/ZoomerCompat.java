package lecho.lib.hellocharts.gesture;

import android.content.Context;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class ZoomerCompat
{
  private static final int DEFAULT_SHORT_ANIMATION_DURATION = 200;
  private long mAnimationDurationMillis = 200L;
  private float mCurrentZoom;
  private float mEndZoom;
  private boolean mFinished = true;
  private Interpolator mInterpolator = new DecelerateInterpolator();
  private long mStartRTC;
  
  public ZoomerCompat(Context paramContext) {}
  
  public void abortAnimation()
  {
    this.mFinished = true;
    this.mCurrentZoom = this.mEndZoom;
  }
  
  public boolean computeZoom()
  {
    return false;
  }
  
  public void forceFinished(boolean paramBoolean)
  {
    this.mFinished = paramBoolean;
  }
  
  public float getCurrZoom()
  {
    return this.mCurrentZoom;
  }
  
  /* Error */
  public void startZoom(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\gesture\ZoomerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */