package com.dji.webviewui.buymonitor;

import android.app.Application;
import com.dji.livedatabase.live.BaseRepository;
import com.dji.livedatabase.live.BaseRxViewModel;

public class BuyMonitorViewModel
  extends BaseRxViewModel<BaseRepository>
{
  private static final String TAG = "BuyMonitorViewModel";
  
  public BuyMonitorViewModel(Application paramApplication)
  {
    super(paramApplication);
    init();
  }
  
  private void init() {}
  
  protected BaseRepository buildRepository()
  {
    new BaseRepository()
    {
      protected void onViewModelClear() {}
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\webviewui\buymonitor\BuyMonitorViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */