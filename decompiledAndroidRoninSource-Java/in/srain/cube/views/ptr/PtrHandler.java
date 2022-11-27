package in.srain.cube.views.ptr;

import android.view.View;

public abstract interface PtrHandler
{
  public abstract boolean checkCanDoRefresh(PtrFrameLayout paramPtrFrameLayout, View paramView1, View paramView2);
  
  public abstract void onRefreshBegin(PtrFrameLayout paramPtrFrameLayout);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\in\srain\cube\views\ptr\PtrHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */