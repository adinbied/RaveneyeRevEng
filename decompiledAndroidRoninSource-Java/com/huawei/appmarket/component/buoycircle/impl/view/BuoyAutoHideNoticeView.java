package com.huawei.appmarket.component.buoycircle.impl.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.huawei.appmarket.component.buoycircle.impl.log.BuoyLog;
import com.huawei.appmarket.component.buoycircle.impl.utils.ResourceLoaderUtil;

public class BuoyAutoHideNoticeView
  extends FrameLayout
{
  private static final String TAG = "BuoyAutoHideNoticeView";
  private int orientation;
  
  public BuoyAutoHideNoticeView(Context paramContext)
  {
    super(paramContext);
    BuoyLog.d("BuoyAutoHideNoticeView", "start create BuoyAutoHideNoticeView");
    LayoutInflater.from(paramContext).inflate(ResourceLoaderUtil.getLayoutId("c_buoycircle_hide_notice"), this);
    this.orientation = paramContext.getResources().getConfiguration().orientation;
  }
  
  public View getNoticeView()
  {
    return null;
  }
  
  /* Error */
  public void onConfigurationChanged(Configuration arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setShowBackground(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\view\BuoyAutoHideNoticeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */