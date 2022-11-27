package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import java.util.HashMap;

public class DataGimbalSetPushPeripheralStatus
  extends DataBase
{
  private static final String TAG = "DataGimbalSetPushPeripheralStatus";
  private static final DataGimbalSetPushPeripheralStatus mInstance = new DataGimbalSetPushPeripheralStatus();
  public HashMap<Integer, byte[]> mPushDataMap = new HashMap();
  private RequestType mRequestType = RequestType.StartContinuePush;
  
  public static DataGimbalSetPushPeripheralStatus getInstance()
  {
    return mInstance;
  }
  
  private int getIntValue(DataType paramDataType)
  {
    return 0;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getChannel1()
  {
    return getIntValue(DataType.Channel1);
  }
  
  public int getChannel2()
  {
    return getIntValue(DataType.Channel2);
  }
  
  public int getChannel3()
  {
    return getIntValue(DataType.Channel3);
  }
  
  public int getChannel4()
  {
    return getIntValue(DataType.Channel4);
  }
  
  public int getChannel5()
  {
    return getIntValue(DataType.Channel5);
  }
  
  public int getChannel6()
  {
    return getIntValue(DataType.Channel6);
  }
  
  public <T extends Number> T getData(byte[] paramArrayOfByte, Class<T> paramClass)
  {
    return null;
  }
  
  public byte[] getDataByType(DataType paramDataType)
  {
    return null;
  }
  
  public float getGpsEastAcceSpeed()
  {
    return 0.0F;
  }
  
  public float getGpsEastSpeed()
  {
    return 0.0F;
  }
  
  public double getGpsLat()
  {
    return 1.371929064E-315D;
  }
  
  public double getGpsLng()
  {
    return 1.37192909E-315D;
  }
  
  public float getGpsNorthAcceSpeed()
  {
    return 0.0F;
  }
  
  public float getGpsNorthSpeed()
  {
    return 0.0F;
  }
  
  public int getGpsNum()
  {
    return getIntValue(DataType.GpsNum);
  }
  
  public int getHandDeviceAngle()
  {
    return getIntValue(DataType.HandDeviceAngle);
  }
  
  public float getPAcceOut()
  {
    return 0.0F;
  }
  
  public float getPActualPose()
  {
    return 0.0F;
  }
  
  public float getPGyroBias()
  {
    return 0.0F;
  }
  
  public float getPGyroOut()
  {
    return 0.0F;
  }
  
  public float getPMotorAngle()
  {
    return 0.0F;
  }
  
  public void getPMotorCurrent() {}
  
  public int getPMotorPower()
  {
    return getIntValue(DataType.PMotorPower);
  }
  
  public int getPMotorTemp()
  {
    return getIntValue(DataType.PMotorTemp);
  }
  
  public float getPPoseBias()
  {
    return 0.0F;
  }
  
  public float getPTargetPos()
  {
    return 0.0F;
  }
  
  public float getRAcceOut()
  {
    return 0.0F;
  }
  
  public float getRActualPose()
  {
    return 0.0F;
  }
  
  public float getRGyroBias()
  {
    return 0.0F;
  }
  
  public float getRGyroOut()
  {
    return 0.0F;
  }
  
  public float getRMotorAngle()
  {
    return 0.0F;
  }
  
  public void getRMotorCurrent() {}
  
  public int getRMotorPower()
  {
    return getIntValue(DataType.RMotorPower);
  }
  
  public int getRMotorTemp()
  {
    return getIntValue(DataType.RMotorTemp);
  }
  
  public float getRPoseBias()
  {
    return 0.0F;
  }
  
  public float getRTargetPos()
  {
    return 0.0F;
  }
  
  public float getYAcceOut()
  {
    return 0.0F;
  }
  
  public float getYActualPose()
  {
    return 0.0F;
  }
  
  public float getYGyroBias()
  {
    return 0.0F;
  }
  
  public float getYGyroOut()
  {
    return 0.0F;
  }
  
  public float getYMotorAngle()
  {
    return 0.0F;
  }
  
  public int getYMotorPower()
  {
    return getIntValue(DataType.YMotorPower);
  }
  
  public int getYMotorTemp()
  {
    return getIntValue(DataType.YMotorTemp);
  }
  
  public void getYMototBattery() {}
  
  public float getYPoseBias()
  {
    return 0.0F;
  }
  
  public float getYTargetPos()
  {
    return 0.0F;
  }
  
  /* Error */
  protected void setPushRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setRequsetType(RequestType paramRequestType)
  {
    this.mRequestType = paramRequestType;
  }
  
  /* Error */
  protected void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum DataType
  {
    public int mId;
    
    static
    {
      PMotorTemp = new DataType("PMotorTemp", 9, 10);
      RMotorTemp = new DataType("RMotorTemp", 10, 11);
      YMotorTemp = new DataType("YMotorTemp", 11, 12);
      PMotorCurrent = new DataType("PMotorCurrent", 12, 13);
      RMotorCurrent = new DataType("RMotorCurrent", 13, 14);
      YMotorCurrent = new DataType("YMotorCurrent", 14, 15);
      PMotorAngle = new DataType("PMotorAngle", 15, 16);
      RMotorAngle = new DataType("RMotorAngle", 16, 17);
      YMotorAngle = new DataType("YMotorAngle", 17, 18);
      PGyroOut = new DataType("PGyroOut", 18, 19);
      RGyroOut = new DataType("RGyroOut", 19, 20);
      YGyroOut = new DataType("YGyroOut", 20, 21);
      PAcceOut = new DataType("PAcceOut", 21, 21);
      RAcceOut = new DataType("RAcceOut", 22, 23);
      YAcceOut = new DataType("YAcceOut", 23, 24);
      PGyroBias = new DataType("PGyroBias", 24, 25);
      RGyroBias = new DataType("RGyroBias", 25, 26);
      YGyroBias = new DataType("YGyroBias", 26, 27);
      PPoseBias = new DataType("PPoseBias", 27, 28);
      RPoseBias = new DataType("RPoseBias", 28, 29);
      YPoseBias = new DataType("YPoseBias", 29, 30);
      PTargetPose = new DataType("PTargetPose", 30, 31);
      RTargetPose = new DataType("RTargetPose", 31, 32);
      YTargetPose = new DataType("YTargetPose", 32, 33);
      PActualPose = new DataType("PActualPose", 33, 34);
      RActualPose = new DataType("RActualPose", 34, 35);
      YActualPose = new DataType("YActualPose", 35, 36);
      GpsNum = new DataType("GpsNum", 36, 37);
      GpsLong = new DataType("GpsLong", 37, 38);
      GpsLat = new DataType("GpsLat", 38, 39);
      GpsNorthSpeed = new DataType("GpsNorthSpeed", 39, 40);
      GpsEastSpeed = new DataType("GpsEastSpeed", 40, 41);
      GpsNorthAcceSpeed = new DataType("GpsNorthAcceSpeed", 41, 42);
      GpsEastAcceSpeed = new DataType("GpsEastAcceSpeed", 42, 43);
      HandDeviceAngle = new DataType("HandDeviceAngle", 43, 46);
      DataType localDataType = new DataType("Other", 44, 255);
      Other = localDataType;
      $VALUES = new DataType[] { Channel1, Channel2, Channel3, Channel4, Channel5, Channel6, PMotorPower, RMotorPower, YMotorPower, PMotorTemp, RMotorTemp, YMotorTemp, PMotorCurrent, RMotorCurrent, YMotorCurrent, PMotorAngle, RMotorAngle, YMotorAngle, PGyroOut, RGyroOut, YGyroOut, PAcceOut, RAcceOut, YAcceOut, PGyroBias, RGyroBias, YGyroBias, PPoseBias, RPoseBias, YPoseBias, PTargetPose, RTargetPose, YTargetPose, PActualPose, RActualPose, YActualPose, GpsNum, GpsLong, GpsLat, GpsNorthSpeed, GpsEastSpeed, GpsNorthAcceSpeed, GpsEastAcceSpeed, HandDeviceAngle, localDataType };
    }
    
    private DataType(int paramInt)
    {
      this.mId = paramInt;
    }
    
    public static DataType find(int paramInt)
    {
      DataType localDataType = Other;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i].mId == paramInt) {
          return values()[i];
        }
        i += 1;
      }
      return localDataType;
    }
  }
  
  public static enum RequestType
  {
    int data;
    
    static
    {
      RequestType localRequestType = new RequestType("RequestSinglePush", 2, 2);
      RequestSinglePush = localRequestType;
      $VALUES = new RequestType[] { StartContinuePush, StopContinuePush, localRequestType };
    }
    
    private RequestType(int paramInt)
    {
      this.data = paramInt;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalSetPushPeripheralStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */