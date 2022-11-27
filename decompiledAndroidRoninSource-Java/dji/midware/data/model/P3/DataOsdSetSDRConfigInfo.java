package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;

public class DataOsdSetSDRConfigInfo
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataOsdSetSDRConfigInfo instance;
  private ArrayList<SDRConfigInfo> configInfoList;
  
  public static DataOsdSetSDRConfigInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdSetSDRConfigInfo();
      }
      DataOsdSetSDRConfigInfo localDataOsdSetSDRConfigInfo = instance;
      return localDataOsdSetSDRConfigInfo;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataOsdSetSDRConfigInfo setSDRConfigInfo(SDRConfigInfo paramSDRConfigInfo)
  {
    return null;
  }
  
  public DataOsdSetSDRConfigInfo setSDRConfigInfos(ArrayList<SDRConfigInfo> paramArrayList)
  {
    this.configInfoList = paramArrayList;
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
  
  public static class SDRConfigInfo
  {
    public DataOsdSetSDRConfigInfo.SDRConfigType type;
    public int value;
    
    public SDRConfigInfo(DataOsdSetSDRConfigInfo.SDRConfigType paramSDRConfigType, int paramInt)
    {
      this.type = paramSDRConfigType;
      this.value = paramInt;
    }
  }
  
  public static enum SDRConfigType
  {
    private int data;
    
    static
    {
      DownlinkFrequencyBand = new SDRConfigType("DownlinkFrequencyBand", 1, 2);
      SelectionMode = new SDRConfigType("SelectionMode", 2, 3);
      Bandwidth = new SDRConfigType("Bandwidth", 3, 4);
      UplinkFrequencyBand = new SDRConfigType("UplinkFrequencyBand", 4, 5);
      SDRConfigType localSDRConfigType = new SDRConfigType("Unknown", 5, 255);
      Unknown = localSDRConfigType;
      $VALUES = new SDRConfigType[] { NFIndex, DownlinkFrequencyBand, SelectionMode, Bandwidth, UplinkFrequencyBand, localSDRConfigType };
    }
    
    private SDRConfigType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static SDRConfigType find(int paramInt)
    {
      SDRConfigType localSDRConfigType = Unknown;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localSDRConfigType;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdSetSDRConfigInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */