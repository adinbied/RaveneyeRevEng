package dji.midware.util;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.model.P3.Data1860GetPushCheckStatus;
import dji.midware.data.model.P3.Data2100GetPushCheckStatus;
import dji.midware.data.model.P3.Data2150GetPushCheckStatus;
import dji.midware.data.model.P3.DataBatteryGetPushCheckStatus;
import dji.midware.data.model.P3.DataCenterGetPushCheckStatus;
import dji.midware.data.model.P3.DataDm368_gGetPushCheckStatus;
import dji.midware.data.model.P3.DataFlycGetPushCheckStatus;
import dji.midware.data.model.P3.DataGimbalGetPushCheckStatus;
import dji.midware.data.model.P3.DataOfdmGetPushCheckStatus;
import dji.midware.data.packages.P3.Pack;

public class NewCheckStatusHelper
{
  public static Pack findNewCheckStatus(Pack paramPack)
  {
    if (paramPack != null)
    {
      if (paramPack.data.length < 2) {
        return null;
      }
      int i = paramPack.data[0] & 0x1F;
      int j = paramPack.data[0] >> 5;
      int k = paramPack.data[1];
      byte[] arrayOfByte = new byte[k];
      System.arraycopy(paramPack.data, 2, arrayOfByte, 0, k);
      paramPack.data = arrayOfByte;
      if (i == DeviceType.CAMERA.value())
      {
        DataGimbalGetPushCheckStatus.getInstance().outerSetPushRecPack(paramPack);
        return null;
      }
      if (i == DeviceType.FLYC.value())
      {
        DataFlycGetPushCheckStatus.getInstance().outerSetPushRecPack(paramPack);
        return null;
      }
      if (i == DeviceType.GIMBAL.value())
      {
        DataGimbalGetPushCheckStatus.getInstance().outerSetPushRecPack(paramPack);
        return null;
      }
      if (i == DeviceType.CENTER.value())
      {
        DataCenterGetPushCheckStatus.getInstance().outerSetPushRecPack(paramPack);
        return null;
      }
      if (i == DeviceType.RC.value()) {
        return null;
      }
      if (i == DeviceType.OFDM.value())
      {
        DataOfdmGetPushCheckStatus.getInstance().outerSetPushRecPack(paramPack);
        return null;
      }
      if (i == DeviceType.BATTERY.value())
      {
        DataBatteryGetPushCheckStatus.getInstance().outerSetPushRecPack(paramPack);
        return null;
      }
      if (i == DeviceType.DM368_G.value())
      {
        DataDm368_gGetPushCheckStatus.getInstance().outerSetPushRecPack(paramPack);
        return null;
      }
      if (i == DeviceType.OSD.value()) {
        return paramPack;
      }
      if (i == DeviceType.TRANSFORM_G.value())
      {
        DataDm368_gGetPushCheckStatus.getInstance().outerSetPushRecPack(paramPack);
        return null;
      }
      if (i == DeviceType.DM368.value())
      {
        if (j == 0)
        {
          Data2100GetPushCheckStatus.getInstance().outerSetPushRecPack(paramPack);
          return null;
        }
        if (j == 1)
        {
          Data1860GetPushCheckStatus.getInstance().outerSetPushRecPack(paramPack);
          return null;
        }
      }
      else if (i == DeviceType.DOUBLE.value())
      {
        Data2150GetPushCheckStatus.getInstance().outerSetPushRecPack(paramPack);
      }
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\NewCheckStatusHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */