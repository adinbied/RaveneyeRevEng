package dji.logic.utils;

import dji.logic.manager.DJIUSBWifiSwitchManager;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo.CameraType;
import dji.midware.data.model.P3.DataOsdGetPushCommon;
import java.util.HashMap;

public class DJIProductSupportUtil
{
  public static String getProductName(ProductType paramProductType)
  {
    if ((ProductType.Orange != paramProductType) && (ProductType.BigBanana != paramProductType) && (ProductType.OrangeRAW != paramProductType) && (ProductType.Olives != paramProductType))
    {
      if (ProductType.litchiS == paramProductType) {
        return "P3XS";
      }
      if (ProductType.litchiX == paramProductType) {
        return "P3XS";
      }
      if (ProductType.litchiC == paramProductType) {
        return "P3C";
      }
      if (ProductType.Longan == paramProductType) {
        return "OSMO";
      }
      if (ProductType.LonganPro == paramProductType) {
        return "OSMO_X5";
      }
      if (ProductType.LonganRaw == paramProductType) {
        return "OSMO_X5R";
      }
      if (ProductType.LonganMobile == paramProductType) {
        return "HG300";
      }
      if (ProductType.P34K == paramProductType) {
        return "P3XW";
      }
      if (ProductType.LonganZoom == paramProductType) {
        return "OSMO_FC350Z";
      }
      return null;
    }
    return "WM610";
  }
  
  public static ProductType getProductTypeFormExfMap(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      ProductType localProductType = ProductType.None;
      String str = (String)paramHashMap.get("mdl");
      paramHashMap = null;
      if ("FC300S".equals(str))
      {
        paramHashMap = DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC300S;
      }
      else if ("FC300X".equals(str))
      {
        paramHashMap = DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC300X;
      }
      else if ("FC260".equals(str))
      {
        paramHashMap = DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC260;
      }
      else if ("FC350".equals(str))
      {
        paramHashMap = DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC350;
      }
      else
      {
        if ("HG310".equals(str)) {
          return ProductType.Longan;
        }
        if ("OSMO RAW".equals(str)) {
          return ProductType.LonganRaw;
        }
        if ("OSMO PRO".equals(str)) {
          return ProductType.LonganPro;
        }
        if ("HF310Z".equalsIgnoreCase(str)) {
          return ProductType.LonganZoom;
        }
        if ("FC300XW".equalsIgnoreCase(str)) {
          paramHashMap = DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC300XW;
        } else if ("FC550RAW".equalsIgnoreCase(str)) {
          paramHashMap = DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw;
        } else if ("FC550".equalsIgnoreCase(str)) {
          paramHashMap = DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550;
        } else if ("FC330".equalsIgnoreCase(str)) {
          paramHashMap = DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC330X;
        }
      }
      if (localProductType != ProductType.None) {
        return localProductType;
      }
      if (paramHashMap == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC300S) {
        return ProductType.litchiS;
      }
      if (paramHashMap == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC300X) {
        return ProductType.litchiX;
      }
      if (paramHashMap == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC260) {
        return ProductType.litchiC;
      }
      if (paramHashMap == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC350) {
        return ProductType.Orange;
      }
      if (paramHashMap == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC300XW) {
        return ProductType.P34K;
      }
      if (paramHashMap == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550) {
        return ProductType.Orange;
      }
      if (paramHashMap == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw) {
        return ProductType.OrangeRAW;
      }
      if (paramHashMap == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC330X) {
        return ProductType.Tomato;
      }
      return ProductType.OTHER;
    }
    return ProductType.OTHER;
  }
  
  public static int getUpgradeBatteryLimit(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    if (localProductType == ProductType.LonganMobile) {
      return 30;
    }
    return 50;
  }
  
  public static boolean hasESC(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    return localProductType == ProductType.LonganZoom;
  }
  
  public static boolean isLonganPhone(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    return localProductType == ProductType.LonganMobile;
  }
  
  public static boolean isLonganSeries(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    return (localProductType == ProductType.Longan) || (localProductType == ProductType.LonganPro) || (localProductType == ProductType.LonganRaw) || (localProductType == ProductType.LonganZoom) || (localProductType == ProductType.LonganMobile);
  }
  
  public static boolean isNo368(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    paramProductType = ProductType.Longan;
    boolean bool = false;
    if (((localProductType == paramProductType) && (DataCameraGetPushStateInfo.getInstance().getVerstion(new int[0]) >= 4)) || (localProductType == ProductType.LonganZoom)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isProductLongan(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    return isLonganSeries(localProductType);
  }
  
  public static boolean isSupportAutoGotoPreview(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    return localProductType == ProductType.LonganMobile;
  }
  
  public static boolean isSupportGeoFlyforbid()
  {
    ProductType localProductType = DJIProductManager.getInstance().getType();
    if ((localProductType != ProductType.Tomato) && (localProductType != ProductType.litchiS) && (localProductType != ProductType.litchiX) && (localProductType != ProductType.Orange) && (localProductType != ProductType.BigBanana) && (localProductType != ProductType.Olives) && (localProductType != ProductType.OrangeRAW) && (localProductType != ProductType.OrangeCV600) && (localProductType != ProductType.KumquatX) && (localProductType != ProductType.KumquatS) && (localProductType != ProductType.Pomato) && (localProductType != ProductType.Potato) && (localProductType != ProductType.Orange2) && (localProductType != ProductType.M200) && (localProductType != ProductType.M210) && (localProductType != ProductType.M210RTK) && (localProductType != ProductType.Mammoth)) {
      return false;
    }
    return DataOsdGetPushCommon.getInstance().getFlycVersion() >= 9;
  }
  
  public static boolean isSupportMotionTlp(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    return localProductType == ProductType.LonganZoom;
  }
  
  public static boolean isSupportPano(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DJIProductManager.getInstance().getCameraType();
    }
    return localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC350;
  }
  
  public static boolean notSpprtGeoOnlineCheck()
  {
    return DJIUSBWifiSwitchManager.getInstance().isProductWifiConnected(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logi\\utils\DJIProductSupportUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */