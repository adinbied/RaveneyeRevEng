package dji.publics.DJIUI;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import dji.frame.widget.R.styleable;
import dji.publics.interfaces.DJIViewAnimShowInterface;
import dji.publics.interfaces.DJIViewShowInterface;

public class DJITextView
  extends TextView
  implements DJIViewShowInterface, DJIViewAnimShowInterface
{
  public static Typeface BOLD;
  public static Typeface DEMI;
  public static Typeface NBOLD;
  public static Typeface NLIGHT;
  public static final int TYPEFACE_BOLD = 3;
  public static final int TYPEFACE_DEMI = 0;
  public static final int TYPEFACE_NBOLD = 2;
  public static final int TYPEFACE_NLIGHT = 1;
  public static final int TYPEFACE_NONE = -1;
  public static Typeface face;
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
      DJITextView.this.show();
    }
  };
  
  public DJITextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DJITextView);
    int i = paramContext.getInt(R.styleable.DJITextView_djiTextFace, -1);
    paramContext.recycle();
    paramContext = getTypeface();
    if (i == 0) {
      return;
    }
    if (1 == i)
    {
      paramContext = Typeface.create("sans-serif-light", 0);
      if (paramContext != null) {
        setTypeface(paramContext);
      }
    }
    else if (2 == i)
    {
      if ((paramContext != null) && (!paramContext.isBold())) {
        setTypeface(paramContext, 1);
      }
    }
    else if ((3 == i) && (paramContext != null) && (!paramContext.isBold()))
    {
      setTypeface(paramContext, 1);
    }
  }
  
  public static Typeface getTypface(Context paramContext, int paramInt)
  {
    initTypeface(paramContext);
    if (paramInt == 0) {
      return DEMI;
    }
    if (1 == paramInt) {
      return NLIGHT;
    }
    if (2 == paramInt) {
      return NBOLD;
    }
    if (3 == paramInt) {
      return BOLD;
    }
    return null;
  }
  
  public static void initTypeface(Context paramContext)
  {
    if (DEMI == null)
    {
      paramContext = paramContext.getAssets();
      DEMI = Typeface.createFromAsset(paramContext, "fonts/Dji-Demi.ttf");
      NLIGHT = Typeface.createFromAsset(paramContext, "fonts/Dji_NLight.ttf");
      NBOLD = Typeface.createFromAsset(paramContext, "fonts/Dji_NBold.ttf");
      BOLD = Typeface.createFromAsset(paramContext, "fonts/Dji-Bold.ttf");
      face = DEMI;
    }
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\DJIUI\DJITextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */