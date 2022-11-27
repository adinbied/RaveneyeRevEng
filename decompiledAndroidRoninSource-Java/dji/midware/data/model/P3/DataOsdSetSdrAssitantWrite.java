package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataOsdSetSdrAssitantWrite
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataOsdSetSdrAssitantWrite instance;
  private int address = 0;
  private DataOsdSetSdrAssitantRead.SdrCpuType cpuType = DataOsdSetSdrAssitantRead.SdrCpuType.CP_A7;
  private DataOsdSetSdrAssitantRead.SdrDataType dataType = DataOsdSetSdrAssitantRead.SdrDataType.Int_Data;
  private DataOsdSetSdrAssitantRead.SdrDeviceType deviceType = DataOsdSetSdrAssitantRead.SdrDeviceType.Sky;
  private boolean isForce23G = false;
  private boolean isForce25G = false;
  private int writeValue = 0;
  
  public static DataOsdSetSdrAssitantWrite getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdSetSdrAssitantWrite();
      }
      DataOsdSetSdrAssitantWrite localDataOsdSetSdrAssitantWrite = instance;
      return localDataOsdSetSdrAssitantWrite;
    }
    finally {}
  }
  
  private void resetInnerFlags()
  {
    this.isForce23G = false;
    this.isForce25G = false;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public DataOsdSetSdrAssitantWrite setAddress(int paramInt)
  {
    this.address = paramInt;
    return this;
  }
  
  public DataOsdSetSdrAssitantWrite setForce23G()
  {
    this.deviceType = DataOsdSetSdrAssitantRead.SdrDeviceType.Sky;
    this.isForce23G = true;
    return this;
  }
  
  public DataOsdSetSdrAssitantWrite setForce25G()
  {
    this.deviceType = DataOsdSetSdrAssitantRead.SdrDeviceType.Sky;
    this.isForce25G = true;
    return this;
  }
  
  public DataOsdSetSdrAssitantWrite setForceFcc()
  {
    return null;
  }
  
  public DataOsdSetSdrAssitantWrite setSdrCpuType(DataOsdSetSdrAssitantRead.SdrCpuType paramSdrCpuType)
  {
    this.cpuType = paramSdrCpuType;
    return this;
  }
  
  public DataOsdSetSdrAssitantWrite setSdrDataType(DataOsdSetSdrAssitantRead.SdrDataType paramSdrDataType)
  {
    this.dataType = paramSdrDataType;
    return this;
  }
  
  public DataOsdSetSdrAssitantWrite setSdrDeviceType(DataOsdSetSdrAssitantRead.SdrDeviceType paramSdrDeviceType)
  {
    this.deviceType = paramSdrDeviceType;
    return this;
  }
  
  public DataOsdSetSdrAssitantWrite setWriteValue(int paramInt)
  {
    this.writeValue = paramInt;
    return this;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdSetSdrAssitantWrite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */