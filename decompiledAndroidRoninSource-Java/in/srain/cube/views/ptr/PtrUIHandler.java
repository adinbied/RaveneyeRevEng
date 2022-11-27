package in.srain.cube.views.ptr;

import in.srain.cube.views.ptr.indicator.PtrIndicator;

public abstract interface PtrUIHandler
{
  public abstract void onUIPositionChange(PtrFrameLayout paramPtrFrameLayout, boolean paramBoolean, byte paramByte, PtrIndicator paramPtrIndicator);
  
  public abstract void onUIRefreshBegin(PtrFrameLayout paramPtrFrameLayout);
  
  public abstract void onUIRefreshComplete(PtrFrameLayout paramPtrFrameLayout);
  
  public abstract void onUIRefreshPrepare(PtrFrameLayout paramPtrFrameLayout);
  
  public abstract void onUIReset(PtrFrameLayout paramPtrFrameLayout);
  
  public static class PtrDefaultUIHandler
    implements PtrUIHandler
  {
    public void onUIPositionChange(PtrFrameLayout paramPtrFrameLayout, boolean paramBoolean, byte paramByte, PtrIndicator paramPtrIndicator) {}
    
    public void onUIRefreshBegin(PtrFrameLayout paramPtrFrameLayout) {}
    
    public void onUIRefreshComplete(PtrFrameLayout paramPtrFrameLayout) {}
    
    public void onUIRefreshPrepare(PtrFrameLayout paramPtrFrameLayout) {}
    
    public void onUIReset(PtrFrameLayout paramPtrFrameLayout) {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\in\srain\cube\views\ptr\PtrUIHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */