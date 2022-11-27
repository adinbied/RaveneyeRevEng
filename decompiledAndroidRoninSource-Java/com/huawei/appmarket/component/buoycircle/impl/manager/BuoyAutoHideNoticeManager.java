package com.huawei.appmarket.component.buoycircle.impl.manager;

import android.content.Context;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.huawei.appmarket.component.buoycircle.impl.view.BuoyAutoHideNoticeView;

public class BuoyAutoHideNoticeManager
{
  public static final String BUOY_HIDE_GUIDE_SP_VALUE = "nomind";
  private static final String TAG = "BuoyAutoHideManager";
  private static BuoyAutoHideNoticeManager instance = new BuoyAutoHideNoticeManager();
  private WindowManager.LayoutParams layoutParams;
  private BuoyAutoHideNoticeView mView;
  
  public static BuoyAutoHideNoticeManager getInstance()
  {
    return instance;
  }
  
  private WindowManager.LayoutParams getLayoutParams()
  {
    return null;
  }
  
  private WindowManager getWindowManager(Context paramContext)
  {
    return null;
  }
  
  /* Error */
  private void updateViewLayout()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void createNotice(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void hideNotice()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isMoveOnNotice(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean isNeedShowGuideDialog(Context paramContext)
  {
    return false;
  }
  
  /* Error */
  public void removeNotice(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void showNotice()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void showNoticeBackground(boolean paramBoolean)
  {
    BuoyAutoHideNoticeView localBuoyAutoHideNoticeView = this.mView;
    if (localBuoyAutoHideNoticeView != null) {
      localBuoyAutoHideNoticeView.setShowBackground(paramBoolean);
    }
  }
  
  public void updateView(BuoyAutoHideNoticeView paramBuoyAutoHideNoticeView)
  {
    if (paramBuoyAutoHideNoticeView != null)
    {
      this.mView = paramBuoyAutoHideNoticeView;
      this.layoutParams = getLayoutParams();
      updateViewLayout();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\manager\BuoyAutoHideNoticeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */