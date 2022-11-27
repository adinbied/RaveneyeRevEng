package dji.publics.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import dji.publics.DJIUI.DJIRelativeLayout;

public class DJIDragLayout
  extends DJIRelativeLayout
{
  protected int mDeltaX = 0;
  protected int mDeltaY = 0;
  protected int mHeight = 0;
  protected boolean mIsDragging = false;
  protected boolean mSupportDrag = false;
  protected int mWidth = 0;
  
  public DJIDragLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  /* Error */
  protected void trackMotion(MotionEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void trackXY(float arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\layout\DJIDragLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */