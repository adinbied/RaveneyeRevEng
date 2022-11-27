package dji.internal.version.component;

import dji.internal.version.DJIModelUpgradePackList;
import dji.internal.version.DJIModelUpgradePackList.DJIUpgradePack;
import dji.internal.version.DJIVersionBaseComponent;
import java.util.ArrayList;

public class DJIVersionInspire1X5Component
  extends DJIVersionBaseComponent
{
  protected String getComponentName()
  {
    return "DJIVersionInspire1X5Component";
  }
  
  protected ArrayList<DJIModelUpgradePackList.DJIUpgradePack> getDJIUpgradePackList(DJIModelUpgradePackList paramDJIModelUpgradePackList)
  {
    return paramDJIModelUpgradePackList.versionlistx5;
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
    return paramDJIUpgradePack.version;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\version\component\DJIVersionInspire1X5Component.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */