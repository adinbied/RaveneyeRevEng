package dji.internal.logics;

import dji.logic.manager.DJIUSBWifiSwitchManager;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.data.model.P3.DataOsdGetPushChannalStatus.CHANNEL_STATUS;
import dji.midware.data.model.P3.DataOsdGetPushCommon;
import dji.midware.data.model.P3.DataOsdGetPushCommon.DroneType;
import dji.midware.data.model.P3.DataOsdGetPushCommon.FLYC_STATE;
import dji.midware.data.model.P3.DataOsdGetPushCommon.NON_GPS_CAUSE;
import dji.midware.data.model.P3.DataOsdGetPushCommon.RcModeChannel;
import dji.sdksharedlib.DJISDKCache;
import dji.sdksharedlib.extension.KeyHelper;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.store.DJISDKCacheParamValue;

public class CommonUtil
{
  public static boolean checkGpsNumValid(int paramInt)
  {
    if (DJIProductManager.getInstance().getType() == ProductType.litchiC) {
      return (paramInt >= 6) && (paramInt < 50);
    }
    return (paramInt >= 8) && (paramInt < 50);
  }
  
  public static boolean checkGpsValid()
  {
    DataOsdGetPushCommon localDataOsdGetPushCommon = DataOsdGetPushCommon.getInstance();
    boolean bool3 = localDataOsdGetPushCommon.isGetted();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3) {
      if ((!isOldMC()) && (localDataOsdGetPushCommon.getFlycVersion() >= 6))
      {
        bool1 = bool2;
        if (localDataOsdGetPushCommon.getGpsLevel() >= 4) {
          return true;
        }
      }
      else
      {
        bool1 = checkGpsNumValid(localDataOsdGetPushCommon.getGpsNum());
      }
    }
    return bool1;
  }
  
  public static boolean checkIsAttiMode(DataOsdGetPushCommon.FLYC_STATE paramFLYC_STATE)
  {
    return (paramFLYC_STATE == DataOsdGetPushCommon.FLYC_STATE.Atti) || (paramFLYC_STATE == DataOsdGetPushCommon.FLYC_STATE.Atti_CL) || (paramFLYC_STATE == DataOsdGetPushCommon.FLYC_STATE.Atti_Hover) || (paramFLYC_STATE == DataOsdGetPushCommon.FLYC_STATE.Atti_Limited) || (paramFLYC_STATE == DataOsdGetPushCommon.FLYC_STATE.AttiLangding);
  }
  
  public static boolean checkIsPAttiMode(DataOsdGetPushCommon.FLYC_STATE paramFLYC_STATE)
  {
    if ((checkIsAttiMode(paramFLYC_STATE)) && (!useModePToSmart(DJIProductManager.getInstance().getType())))
    {
      boolean bool = isMultipleModeOpen();
      paramFLYC_STATE = DataOsdGetPushCommon.getInstance().getModeChannel();
      if ((!bool) || (paramFLYC_STATE != DataOsdGetPushCommon.RcModeChannel.CHANNEL_A)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean checkRcBatteryLow(int paramInt)
  {
    if (isKumquatSeries(null)) {
      return paramInt < 15;
    }
    return paramInt < 30;
  }
  
  public static boolean checkUseNewModeChannel(DataOsdGetPushCommon paramDataOsdGetPushCommon)
  {
    return paramDataOsdGetPushCommon.getFlycVersion() >= 7;
  }
  
  public static boolean isChannelPoor(DataOsdGetPushChannalStatus.CHANNEL_STATUS paramCHANNEL_STATUS)
  {
    return (DataOsdGetPushChannalStatus.CHANNEL_STATUS.Excellent != paramCHANNEL_STATUS) && (DataOsdGetPushChannalStatus.CHANNEL_STATUS.Good != paramCHANNEL_STATUS) && (DataOsdGetPushChannalStatus.CHANNEL_STATUS.Medium != paramCHANNEL_STATUS);
  }
  
  public static boolean isCompassDisturb(DataOsdGetPushCommon.NON_GPS_CAUSE paramNON_GPS_CAUSE)
  {
    return (paramNON_GPS_CAUSE == DataOsdGetPushCommon.NON_GPS_CAUSE.COMPASS_ERROR_LARGE) || (paramNON_GPS_CAUSE == DataOsdGetPushCommon.NON_GPS_CAUSE.SPEED_ERROR_LARGE) || (paramNON_GPS_CAUSE == DataOsdGetPushCommon.NON_GPS_CAUSE.YAW_ERROR_LARGE);
  }
  
  public static boolean isKumquatSeries(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    return (localProductType == ProductType.KumquatX) || (localProductType == ProductType.KumquatS);
  }
  
  public static boolean isMultipleModeOpen()
  {
    Object localObject = KeyHelper.getFlightControllerKey("MultiModeOpen");
    localObject = DJISDKCache.getInstance().getAvailableValue((DJISDKCacheKey)localObject);
    if (localObject != null) {
      return ((Boolean)((DJISDKCacheParamValue)localObject).getData()).booleanValue();
    }
    return false;
  }
  
  public static boolean isNewA3FlightMode()
  {
    int i = DataOsdGetPushCommon.getInstance().getFlycVersion();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= 16)
    {
      ProductType localProductType = DJIProductManager.getInstance().getType();
      if (localProductType != ProductType.A3)
      {
        bool1 = bool2;
        if (localProductType != ProductType.N3) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isOldMC()
  {
    return isOldMC(DataOsdGetPushCommon.getInstance().getDroneType());
  }
  
  public static boolean isOldMC(DataOsdGetPushCommon.DroneType paramDroneType)
  {
    return (paramDroneType == DataOsdGetPushCommon.DroneType.A2) || (paramDroneType == DataOsdGetPushCommon.DroneType.WKM) || (paramDroneType == DataOsdGetPushCommon.DroneType.NAZA);
  }
  
  public static boolean isProductM600Series(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    return (localProductType == ProductType.PM820) || (localProductType == ProductType.PM820PRO);
  }
  
  public static boolean isSdrProducts(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    return (isKumquatSeries(localProductType)) && (!DJIUSBWifiSwitchManager.getInstance().isProductWifiConnected(localProductType));
  }
  
  public static boolean isWifiProduct(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    return (localProductType.isFromWifi()) || (DJIUSBWifiSwitchManager.getInstance().isProductWifiConnected(localProductType));
  }
  
  public static boolean supportRedundancySenor()
  {
    ProductType localProductType = DJIProductManager.getInstance().getType();
    return (localProductType == ProductType.Tomato) || (localProductType == ProductType.Pomato) || (LogicManager.isA3()) || (isKumquatSeries(localProductType));
  }
  
  public static boolean useModePToSmart(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    return (localProductType == ProductType.Tomato) || (localProductType == ProductType.Pomato) || (isKumquatSeries(localProductType)) || (isNewA3FlightMode());
  }
  
  public static boolean useNewBattery()
  {
    ProductType localProductType = DJIProductManager.getInstance().getType();
    return (isProductM600Series(localProductType)) || (isKumquatSeries(localProductType));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\CommonUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */