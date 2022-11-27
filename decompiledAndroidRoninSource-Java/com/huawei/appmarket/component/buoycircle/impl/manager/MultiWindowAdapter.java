package com.huawei.appmarket.component.buoycircle.impl.manager;

import com.huawei.android.app.HwMultiWindowEx.StateChangeListener;
import java.util.ArrayList;
import java.util.List;

public class MultiWindowAdapter
{
  private static final String TAG = "MultiWindowAdapter";
  private static MultiWindowAdapter instance;
  private List<HwMultiWindowEx.StateChangeListener> data = new ArrayList();
  
  public static MultiWindowAdapter getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new MultiWindowAdapter();
      }
      MultiWindowAdapter localMultiWindowAdapter = instance;
      return localMultiWindowAdapter;
    }
    finally {}
  }
  
  public boolean isInMultiWindowMode()
  {
    return false;
  }
  
  public boolean isSupportListenMultiWindowMode()
  {
    return false;
  }
  
  /* Error */
  public void registerModeChangeListener(MultiWindowCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void unRegisterModeChangeListener()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static abstract interface MultiWindowCallBack
  {
    public abstract void endMultiWindow();
    
    public abstract void startMultiWindow();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\manager\MultiWindowAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */