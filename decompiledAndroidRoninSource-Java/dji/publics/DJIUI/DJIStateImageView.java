package dji.publics.DJIUI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class DJIStateImageView
  extends DJIImageView
{
  private boolean mOnlyDisable = false;
  private float mStateAlpha = 0.3F;
  private View mView = null;
  
  public DJIStateImageView(Context paramContext, AttributeSet paramAttributeSet)
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
  
  public void setOnlyDisable(boolean paramBoolean)
  {
    this.mOnlyDisable = paramBoolean;
  }
  
  public void setRelativeStateView(View paramView)
  {
    this.mView = paramView;
  }
  
  public void setStateAlpha(float paramFloat)
  {
    this.mStateAlpha = paramFloat;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\DJIUI\DJIStateImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */