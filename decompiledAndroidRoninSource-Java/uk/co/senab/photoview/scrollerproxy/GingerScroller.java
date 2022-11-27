package uk.co.senab.photoview.scrollerproxy;

import android.content.Context;
import android.widget.OverScroller;

public class GingerScroller
  extends ScrollerProxy
{
  protected final OverScroller mScroller;
  
  public GingerScroller(Context paramContext)
  {
    this.mScroller = new OverScroller(paramContext);
  }
  
  public boolean computeScrollOffset()
  {
    return this.mScroller.computeScrollOffset();
  }
  
  /* Error */
  public void fling(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10)
  {
    // Byte code:
    //   0: return
    //   1: astore 11
    //   3: goto -3 -> 0
  }
  
  public void forceFinished(boolean paramBoolean)
  {
    this.mScroller.forceFinished(paramBoolean);
  }
  
  public int getCurrX()
  {
    return this.mScroller.getCurrX();
  }
  
  public int getCurrY()
  {
    return this.mScroller.getCurrY();
  }
  
  public boolean isFinished()
  {
    return this.mScroller.isFinished();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar\\uk\co\senab\photoview\scrollerproxy\GingerScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */