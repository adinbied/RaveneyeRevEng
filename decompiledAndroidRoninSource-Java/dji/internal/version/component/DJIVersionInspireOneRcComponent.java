package dji.internal.version.component;

import dji.internal.version.DJIModelUpgradePackList;
import dji.internal.version.DJIModelUpgradePackList.DJIUpgradePack;
import dji.internal.version.DJIVersionBaseComponent;
import java.util.ArrayList;

public class DJIVersionInspireOneRcComponent
  extends DJIVersionBaseComponent
{
  protected String getComponentName()
  {
    return "DJIVersionInspireOneRcComponent";
  }
  
  protected ArrayList<DJIModelUpgradePackList.DJIUpgradePack> getDJIUpgradePackList(DJIModelUpgradePackList paramDJIModelUpgradePackList)
  {
    return paramDJIModelUpgradePackList.versionlist;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\version\component\DJIVersionInspireOneRcComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */