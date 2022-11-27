package dji.publics.DJIUI;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import dji.publics.interfaces.DJIViewAnimShowInterface;
import dji.publics.interfaces.DJIViewShowInterface;

public class DJIEditText
  extends EditText
  implements DJIViewShowInterface, DJIViewAnimShowInterface
{
  public static final int TYPEFACE_BOLD = 3;
  public static final int TYPEFACE_DEMI = 0;
  public static final int TYPEFACE_NBOLD = 2;
  public static final int TYPEFACE_NLIGHT = 1;
  public static final int TYPEFACE_NONE = -1;
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
      DJIEditText.this.show();
    }
  };
  
  public DJIEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public DJIEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initTypeface(paramContext, paramAttributeSet);
  }
  
  public DJIEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initTypeface(paramContext, paramAttributeSet);
  }
  
  /* Error */
  private void initTypeface(Context arg1, AttributeSet arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  public void show()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\DJIUI\DJIEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */