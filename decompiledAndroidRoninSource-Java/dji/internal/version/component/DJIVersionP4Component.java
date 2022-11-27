package dji.internal.version.component;

import dji.internal.version.DJIModelUpgradePackList;
import dji.internal.version.DJIModelUpgradePackList.DJIUpgradePack;
import dji.internal.version.DJIVersionBaseComponent;
import dji.midware.data.model.P3.DataCommonGetCfgFile;
import dji.midware.interfaces.DJIDataCallBack;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class DJIVersionP4Component
  extends DJIVersionBaseComponent
{
  private static final String TAG = "DJIVersionP4Component";
  byte[] buffer = new byte['Ѐ'];
  int bufferSize = 0;
  File cfgFile = null;
  private FileOutputStream cfgFos = null;
  long cfgOffset = 0L;
  private String cfgPath = null;
  private DJIDataCallBack getCfgCallBack = new DJIDataCallBack()
  {
    /* Error */
    public void onFailure(dji.midware.data.config.P3.Ccode arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSuccess(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  };
  DataCommonGetCfgFile getCfgFile = DataCommonGetCfgFile.getInstance();
  private boolean isGetDevices = false;
  private String packageVersion = "";
  long readLen = -1L;
  long remainLen = 0L;
  
  /* Error */
  private void getCfgModel(File arg1)
    throws java.io.FileNotFoundException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void getDeviceCFG()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected String getComponentName()
  {
    return DJIVersionP4Component.class.getSimpleName();
  }
  
  public String getComponentVersion()
  {
    return this.packageVersion;
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
    return this.packageVersion;
  }
  
  /* Error */
  public void init(android.content.Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void uninit() {}
  
  /* Error */
  protected void writeToLocal()
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\version\component\DJIVersionP4Component.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */