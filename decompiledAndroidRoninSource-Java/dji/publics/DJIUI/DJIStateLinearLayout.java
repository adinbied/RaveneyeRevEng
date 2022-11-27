package dji.publics.DJIUI;

import android.content.Context;
import android.util.AttributeSet;

public class DJIStateLinearLayout
  extends DJILinearLayout
{
  private float mStateAlpha = 0.3F;
  
  public DJIStateLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  /* Error */
  protected void drawableStateChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setStateAlpha(float paramFloat)
  {
    this.mStateAlpha = paramFloat;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\DJIUI\DJIStateLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */