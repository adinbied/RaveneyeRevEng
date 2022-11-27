package dji.publics.widget;

import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FpvPopWarnView
  extends RelativeLayout
{
  private static FpvPopWarnView mInstance;
  int continueTimeUnit = 2000;
  ObjectAnimator continusAnim;
  ObjectAnimator fadeInAnim;
  int fadeTimeUnit = 1000;
  boolean isPlaying = false;
  AnimatorSet mAnimSet;
  ImageView mIv;
  LinearLayout mLy;
  TextView mTv;
  AnimatorSet scaleSet;
  int scaleTimeUnit = 150;
  
  private FpvPopWarnView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public static void dispatchOnDestroy()
  {
    mInstance = null;
  }
  
  public static FpvPopWarnView getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new FpvPopWarnView(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initAnim()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isPlaying()
  {
    return this.isPlaying;
  }
  
  /* Error */
  protected void pop(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void pop(int arg1, int arg2, POPTIME arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void pop(int arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void pop(int arg1, String arg2, POPTIME arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public static enum POPTIME
  {
    static
    {
      POPTIME localPOPTIME = new POPTIME("LENGTH_LONG", 1);
      LENGTH_LONG = localPOPTIME;
      $VALUES = new POPTIME[] { LENGTH_SHORT, localPOPTIME };
    }
    
    private POPTIME() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widget\FpvPopWarnView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */