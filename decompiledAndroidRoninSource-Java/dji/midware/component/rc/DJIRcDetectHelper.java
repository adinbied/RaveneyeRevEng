package dji.midware.component.rc;

import dji.log.DJILogHelper;
import dji.logic.utils.DJIPublicUtils;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.model.P3.DataCommonGetVersion;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.link.DJILinkDaemonService;
import dji.midware.link.DJILinkType;
import dji.midware.util.BytesUtil;

public class DJIRcDetectHelper
{
  private static final String TAG = DJIRcDetectHelper.class.getSimpleName();
  public static final String VERSION_KUMQUAT_SUPPORT_ISO_SHUTTER = "01.04.00.00";
  private static DJIRcDetectHelper mInstance = null;
  private DataCommonGetVersion mKumquat1860Getter;
  private DataCommonGetVersion mOsdGetter;
  
  public static DJIRcDetectHelper getInstance()
  {
    if (mInstance == null) {
      mInstance = new DJIRcDetectHelper();
    }
    return mInstance;
  }
  
  public static ProductType getRcType(DataCommonGetVersion paramDataCommonGetVersion)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramDataCommonGetVersion != null)
    {
      if (paramDataCommonGetVersion.getRecData() == null) {
        return null;
      }
      int i = ((Integer)paramDataCommonGetVersion.get(20, 1, Integer.class, new int[0])).intValue();
      int j = ((Integer)paramDataCommonGetVersion.get(19, 1, Integer.class, new int[0])).intValue();
      int k = ((Integer)paramDataCommonGetVersion.get(18, 1, Integer.class, new int[0])).intValue();
      localObject1 = RcHardWareType.getByOsdData(paramDataCommonGetVersion.getRecData());
      if ((localObject1 != null) && (ProductType.isValidType(((RcHardWareType)localObject1).productType))) {
        return ((RcHardWareType)localObject1).productType;
      }
      if (hasSDRModule(paramDataCommonGetVersion)) {
        return ProductType.KumquatX;
      }
      localObject1 = DJILogHelper.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("1765 Loader[");
      localStringBuilder.append(BytesUtil.byte2hex(paramDataCommonGetVersion.getRecData()));
      localStringBuilder.append("]");
      ((DJILogHelper)localObject1).LOGD("Test", localStringBuilder.toString(), false, true);
      if ((j == 0) && (1 == k)) {
        return ProductType.Grape2;
      }
      if ((1 == j) && (50397447L < DJIPublicUtils.formatVersion(paramDataCommonGetVersion.getLoader(".")))) {
        return ProductType.Pomato;
      }
      if (10 == i) {
        return ProductType.Mammoth;
      }
      i = ((Integer)paramDataCommonGetVersion.get(24, 1, Integer.class, new int[0])).intValue();
      localObject1 = DJILogHelper.getInstance();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("1765 firmware type=");
      localStringBuilder.append(i);
      ((DJILogHelper)localObject1).LOGD("", localStringBuilder.toString(), true, true);
      if (i >= 4)
      {
        i = ((Integer)paramDataCommonGetVersion.get(20, 1, Integer.class, new int[0])).intValue() % 9;
        paramDataCommonGetVersion = DJILogHelper.getInstance();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("1765 loader version=");
        ((StringBuilder)localObject1).append(i);
        paramDataCommonGetVersion.LOGD("", ((StringBuilder)localObject1).toString(), true, true);
        if (i == 1) {
          return ProductType.Orange;
        }
        if (i == 2) {
          return ProductType.litchiX;
        }
        if (i == 3) {
          return ProductType.litchiX;
        }
        if (i == 4) {
          return ProductType.Orange;
        }
        if (i == 0)
        {
          localObject1 = localObject2;
          if (DJILinkDaemonService.getInstance().getLinkType().equals(DJILinkType.WIFI)) {
            return ProductType.litchiC;
          }
        }
        else
        {
          localObject1 = localObject2;
          if (i == 5) {
            return ProductType.P34K;
          }
        }
      }
      else
      {
        paramDataCommonGetVersion = new DM368GBlockRequest().getDM368();
        if (paramDataCommonGetVersion != null)
        {
          i = ((Integer)paramDataCommonGetVersion.get(24, 1, Integer.class, new int[0])).intValue();
          if (i == 1) {
            paramDataCommonGetVersion = ProductType.Orange;
          }
          for (;;)
          {
            return paramDataCommonGetVersion;
            if (i == 2) {
              paramDataCommonGetVersion = ProductType.litchiX;
            } else {
              paramDataCommonGetVersion = ProductType.Orange;
            }
          }
        }
        localObject1 = ProductType.litchiX;
      }
    }
    return (ProductType)localObject1;
  }
  
  private static boolean hasSDRModule(DataCommonGetVersion paramDataCommonGetVersion)
  {
    boolean bool = false;
    if (paramDataCommonGetVersion == null) {
      return false;
    }
    if (((Integer)paramDataCommonGetVersion.get(19, 1, Integer.class, new int[0])).intValue() == 6) {
      bool = true;
    }
    return bool;
  }
  
  public DataCommonGetVersion getKumquat1860Getter()
  {
    return this.mKumquat1860Getter;
  }
  
  public DataCommonGetVersion getOsdGetter()
  {
    return this.mOsdGetter;
  }
  
  public ProductType getProductTypeByOsd()
  {
    return null;
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.manager.P3.DataEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\component\rc\DJIRcDetectHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */