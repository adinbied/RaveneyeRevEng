package in.srain.cube.views.ptr;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.AbsListView;

public abstract class PtrDefaultHandler
  implements PtrHandler
{
  public static boolean canChildScrollUp(View paramView)
  {
    if (Build.VERSION.SDK_INT < 14)
    {
      boolean bool2 = paramView instanceof AbsListView;
      boolean bool1 = true;
      if (bool2)
      {
        paramView = (AbsListView)paramView;
        if (paramView.getChildCount() > 0)
        {
          if (paramView.getFirstVisiblePosition() > 0) {
            break label57;
          }
          if (paramView.getChildAt(0).getTop() < paramView.getPaddingTop()) {
            return true;
          }
        }
        bool1 = false;
        label57:
        return bool1;
      }
      return paramView.getScrollY() > 0;
    }
    return paramView.canScrollVertically(-1);
  }
  
  public static boolean checkContentCanBePulledDown(PtrFrameLayout paramPtrFrameLayout, View paramView1, View paramView2)
  {
    return canChildScrollUp(paramView1) ^ true;
  }
  
  public boolean checkCanDoRefresh(PtrFrameLayout paramPtrFrameLayout, View paramView1, View paramView2)
  {
    return checkContentCanBePulledDown(paramPtrFrameLayout, paramView1, paramView2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\in\srain\cube\views\ptr\PtrDefaultHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */