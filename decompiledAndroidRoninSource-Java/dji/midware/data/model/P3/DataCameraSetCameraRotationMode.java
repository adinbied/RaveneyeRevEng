package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetCameraRotationMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetCameraRotationMode instance;
  private int imageOrientationMod = -1;
  private RotationAngleType orientation;
  
  public static DataCameraSetCameraRotationMode getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetCameraRotationMode();
      }
      DataCameraSetCameraRotationMode localDataCameraSetCameraRotationMode = instance;
      return localDataCameraSetCameraRotationMode;
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
  
  public DataCameraSetCameraRotationMode setImageOrientationMode(int paramInt)
  {
    this.imageOrientationMod = paramInt;
    return this;
  }
  
  public DataCameraSetCameraRotationMode setOrientation(RotationAngleType paramRotationAngleType)
  {
    this.orientation = paramRotationAngleType;
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
  
  public static enum RotationAngleType
  {
    private int data;
    
    static
    {
      Rotate180 = new RotationAngleType("Rotate180", 2, 2);
      Rotate270 = new RotationAngleType("Rotate270", 3, 3);
      RotationAngleType localRotationAngleType = new RotationAngleType("Unknown", 4, 255);
      Unknown = localRotationAngleType;
      $VALUES = new RotationAngleType[] { Rotate0, Rotate90, Rotate180, Rotate270, localRotationAngleType };
    }
    
    private RotationAngleType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static RotationAngleType find(int paramInt)
    {
      RotationAngleType localRotationAngleType = Unknown;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localRotationAngleType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetCameraRotationMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */