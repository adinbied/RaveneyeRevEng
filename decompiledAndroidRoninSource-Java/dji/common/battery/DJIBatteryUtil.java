package dji.common.battery;

import dji.common.product.Model;
import dji.sdksharedlib.extension.CacheHelper;

public class DJIBatteryUtil
{
  public static int getBatteryCellNumber()
  {
    Model localModel = (Model)CacheHelper.getProduct("ModelName");
    if (isInspireSeries(localModel)) {
      return 6;
    }
    if (isKumquatSeries(localModel)) {
      return 3;
    }
    if (isPhantomSeries(localModel)) {
      return 4;
    }
    return 0;
  }
  
  public static boolean isInspireSeries(Model paramModel)
  {
    Model localModel = paramModel;
    if (paramModel == null) {
      localModel = (Model)CacheHelper.getProduct("ModelName");
    }
    boolean bool = false;
    if (localModel == null) {
      return false;
    }
    if ((localModel == Model.INSPIRE_1) || (localModel == Model.INSPIRE_1_PRO) || (localModel == Model.INSPIRE_1_RAW) || (localModel == Model.MATRICE_100) || (localModel == Model.ZENMUSE_Z3) || (localModel == Model.INSPIRE_2) || (localModel == Model.M200)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isKumquatSeries(Model paramModel)
  {
    Model localModel = paramModel;
    if (paramModel == null) {
      localModel = (Model)CacheHelper.getProduct("ModelName");
    }
    boolean bool = false;
    if (localModel == null) {
      return false;
    }
    if (localModel == Model.MAVIC_PRO) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isPhantomSeries(Model paramModel)
  {
    Model localModel = paramModel;
    if (paramModel == null) {
      localModel = (Model)CacheHelper.getProduct("ModelName");
    }
    boolean bool = false;
    if (localModel == null) {
      return false;
    }
    if ((localModel == Model.Phantom_3_4K) || (localModel == Model.PHANTOM_3_ADVANCED) || (localModel == Model.PHANTOM_3_PROFESSIONAL) || (localModel == Model.PHANTOM_3_STANDARD) || (localModel == Model.PHANTOM_4) || (localModel == Model.PHANTOM_4_PRO) || (localModel == Model.PHANTOM_4_ADV)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\battery\DJIBatteryUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */