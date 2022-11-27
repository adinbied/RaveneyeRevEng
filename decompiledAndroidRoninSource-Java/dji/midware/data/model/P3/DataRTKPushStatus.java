package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataRTKPushStatus
  extends DataBase
{
  private static DataRTKPushStatus mInstance;
  
  public static DataRTKPushStatus getInstance()
  {
    if (mInstance == null)
    {
      DataRTKPushStatus localDataRTKPushStatus = new DataRTKPushStatus();
      mInstance = localDataRTKPushStatus;
      localDataRTKPushStatus.isNeedPushLosed = true;
    }
    return mInstance;
  }
  
  protected void doPack() {}
  
  public int getAntannaMBeidouNum()
  {
    return 0;
  }
  
  public int getAntannaMGPSNum()
  {
    return 0;
  }
  
  public int getAntannaMGlonassNum()
  {
    return 0;
  }
  
  public int getAntannaSBeidouNum()
  {
    return 0;
  }
  
  public int getAntannaSGPSNum()
  {
    return 0;
  }
  
  public int getAntannaSGlonassNum()
  {
    return 0;
  }
  
  public int getBaseStationBeidouNum()
  {
    return 0;
  }
  
  public int getBaseStationGPSNum()
  {
    return 0;
  }
  
  public int getBaseStationGlonassNum()
  {
    return 0;
  }
  
  public int getErrorCode()
  {
    return 0;
  }
  
  public float getGroundHeight()
  {
    return 0.0F;
  }
  
  public double getGroundLat()
  {
    return 1.37195588E-315D;
  }
  
  public double getGroundLng()
  {
    return 1.371955907E-315D;
  }
  
  public float getLocateAngle()
  {
    return 0.0F;
  }
  
  public int getLocateEnable()
  {
    return 0;
  }
  
  public float getSkyHeight()
  {
    return 0.0F;
  }
  
  public double getSkyLat()
  {
    return 1.371956E-315D;
  }
  
  public double getSkyLng()
  {
    return 1.37195602E-315D;
  }
  
  public int getStatus()
  {
    return 0;
  }
  
  public boolean isDirectionEnabled()
  {
    return false;
  }
  
  public boolean isRTKOpen()
  {
    return false;
  }
  
  public boolean isRtkEnabled()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRTKPushStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */