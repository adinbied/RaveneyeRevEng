package dji.midware.data.model.P3;

import android.util.SparseArray;
import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;

public class DataCameraGetPushRequestUpgrade
  extends DataBase
{
  private static DataCameraGetPushRequestUpgrade instance;
  private SparseArray<UpgradeRequestModel> list = new SparseArray();
  
  public static DataCameraGetPushRequestUpgrade getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushRequestUpgrade();
      }
      DataCameraGetPushRequestUpgrade localDataCameraGetPushRequestUpgrade = instance;
      return localDataCameraGetPushRequestUpgrade;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public SparseArray<UpgradeRequestModel> getList()
  {
    return null;
  }
  
  public static class UpgradeRequestModel
  {
    public DeviceType deviceType;
    public long size;
    public DataCameraGetPushUpgradeStatus.FirmwareType type;
    public String version;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushRequestUpgrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */