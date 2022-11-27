package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalGetPushExternalDeviceData
  extends DataBase
  implements DJIDataSyncListener
{
  private int mCtrType;
  private int mPitchSpeed;
  private int mRollSpeed;
  private int mYawSpeed;
  
  public static int convertTwoSignInt(byte paramByte1, byte paramByte2)
  {
    return paramByte1 & 0xFF | paramByte2 << 8;
  }
  
  public static DataGimbalGetPushExternalDeviceData getInstance()
  {
    return InstanceHolder.sINSTANCE;
  }
  
  private void resetValue()
  {
    this.mPitchSpeed = 0;
    this.mRollSpeed = 0;
    this.mYawSpeed = 0;
  }
  
  protected void doPack() {}
  
  public int getPitchSpeed()
  {
    return this.mPitchSpeed;
  }
  
  public int getRollSpeed()
  {
    return this.mRollSpeed;
  }
  
  public SpeedControlType getSpeedControlType()
  {
    return SpeedControlType.find(this.mCtrType);
  }
  
  public int getYawSpeed()
  {
    return this.mYawSpeed;
  }
  
  /* Error */
  protected void setPushRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum DataType
  {
    private int data;
    
    static
    {
      BaseFloorHeight = new DataType("BaseFloorHeight", 3, 3);
      LocationCtrGimbal = new DataType("LocationCtrGimbal", 4, 4);
      AttitudeCtrGimbal = new DataType("AttitudeCtrGimbal", 5, 5);
      USBControl = new DataType("USBControl", 6, 6);
      CameraLensSetups = new DataType("CameraLensSetups", 7, 7);
      MouseValue = new DataType("MouseValue", 8, 8);
      ReceiveVersion = new DataType("ReceiveVersion", 9, 9);
      CameraStatus = new DataType("CameraStatus", 10, 10);
      DataType localDataType = new DataType("Other", 11, 255);
      Other = localDataType;
      $VALUES = new DataType[] { CameraFanPWM, CameraLensDust, SpeedControl, BaseFloorHeight, LocationCtrGimbal, AttitudeCtrGimbal, USBControl, CameraLensSetups, MouseValue, ReceiveVersion, CameraStatus, localDataType };
    }
    
    private DataType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DataType find(int paramInt)
    {
      DataType localDataType = Other;
      DataType[] arrayOfDataType = values();
      int i = 0;
      while (i < arrayOfDataType.length)
      {
        if (arrayOfDataType[i]._equals(paramInt)) {
          return arrayOfDataType[i];
        }
        i += 1;
      }
      return localDataType;
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
  
  private static class InstanceHolder
  {
    private static final DataGimbalGetPushExternalDeviceData sINSTANCE = new DataGimbalGetPushExternalDeviceData();
  }
  
  public static enum SpeedControlType
  {
    private int data;
    
    static
    {
      SpeedControlType localSpeedControlType = new SpeedControlType("Other", 3, 7);
      Other = localSpeedControlType;
      $VALUES = new SpeedControlType[] { CommonStick, RockWheel, Sensor, localSpeedControlType };
    }
    
    private SpeedControlType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static SpeedControlType find(int paramInt)
    {
      SpeedControlType localSpeedControlType = Other;
      SpeedControlType[] arrayOfSpeedControlType = values();
      int i = 0;
      while (i < arrayOfSpeedControlType.length)
      {
        if (arrayOfSpeedControlType[i]._equals(paramInt)) {
          return arrayOfSpeedControlType[i];
        }
        i += 1;
      }
      return localSpeedControlType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetPushExternalDeviceData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */