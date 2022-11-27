package dji.internal.version.component;

import dji.internal.version.DJIModelUpgradePackList;
import dji.internal.version.DJIModelUpgradePackList.DJIUpgradePack;
import dji.internal.version.DJIVersionBaseComponent;
import java.util.ArrayList;

public class DJIVersionP4RcComponent
  extends DJIVersionBaseComponent
{
  protected String getComponentName()
  {
    return DJIVersionP4RcComponent.class.getSimpleName();
  }
  
  protected ArrayList<DJIModelUpgradePackList.DJIUpgradePack> getDJIUpgradePackList(DJIModelUpgradePackList paramDJIModelUpgradePackList)
  {
    return null;
  }
  
  protected String[] getFirmwareList()
  {
    return null;
  }
  
  protected String getVersion(DJIModelUpgradePackList.DJIUpgradePack paramDJIUpgradePack)
  {
    if (paramDJIUpgradePack == null) {
      return null;
    }
    return paramDJIUpgradePack.rcversion;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.manager.P3.DataEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\version\component\DJIVersionP4RcComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */