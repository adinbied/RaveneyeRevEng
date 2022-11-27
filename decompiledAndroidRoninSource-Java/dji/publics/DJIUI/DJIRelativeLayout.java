package dji.publics.DJIUI;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import dji.publics.interfaces.DJIViewAnimShowInterface;
import dji.publics.interfaces.DJIViewShowInterface;

public class DJIRelativeLayout
  extends RelativeLayout
  implements DJIViewShowInterface, DJIViewAnimShowInterface
{
  private AnimatorListenerAdapter animGoListener = new AnimatorListenerAdapter()
  {
    /* Error */
    public void onAnimationEnd(Animator arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private AnimatorListenerAdapter animShowListener = new AnimatorListenerAdapter()
  {
    /* Error */
    public void onAnimationEnd(Animator arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onAnimationStart(Animator paramAnonymousAnimator)
    {
      DJIRelativeLayout.this.show();
    }
  };
  private OnResizeListener resizeListener;
  
  public DJIRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public DJIRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DJIRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  /* Error */
  public void animGo()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void animShow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void go()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void hide()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
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
  
  public void setOnResizeListener(OnResizeListener paramOnResizeListener)
  {
    this.resizeListener = paramOnResizeListener;
  }
  
  /* Error */
  public void show()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface OnResizeListener
  {
    public abstract void onResizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\DJIUI\DJIRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */