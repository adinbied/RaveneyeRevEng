package uk.co.senab.photoview.scrollerproxy;

import android.content.Context;
import android.widget.OverScroller;

public class IcsScroller
  extends GingerScroller
{
  public IcsScroller(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean computeScrollOffset()
  {
    return this.mScroller.computeScrollOffset();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar\\uk\co\senab\photoview\scrollerproxy\IcsScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */