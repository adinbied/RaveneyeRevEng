package dji.publics.LogReport;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.dji.analytics.DJIA;
import com.dji.ronin.RoninApplication;
import com.dji.ronin.util.CommonUtils;
import com.dji.upgrade.RoninUpgradeManager;
import dji.log.RoninLog;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.data.model.P3.DataCommonGetVersion;
import dji.midware.data.model.P3.DataFlycActiveStatus;
import dji.midware.data.model.common.DataAbstractGetPushActiveStatus;
import dji.midware.data.model.common.DataAbstractGetPushActiveStatus.TYPE;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.util.DjiSharedPreferencesManager;
import dji.midware.util.RepeatDataBase;
import java.util.HashMap;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DJIReportUtil
{
  public static boolean DEBUG_LOG_ENABLED = true;
  private static final String KEY_UUID_FOR_SERVER_LOG_DEVICE = "key_uuid_for_server_log_device";
  static final DataFlycActiveStatus activeStatus;
  private static String aes = "iu3aBApVzP19xQNlPYWblIaSo2D9xbRc";
  private static byte[] iv = new byte[16];
  private static String mLastReportProductName;
  private static ProductType mLastReportProductType;
  private static final Object mLock = new Object();
  private static String rcVer = "";
  private static String sn = "";
  
  static
  {
    activeStatus = new DataFlycActiveStatus();
    mLastReportProductType = null;
    mLastReportProductName = "DJI Device";
  }
  
  public static String decrypt(String paramString1, String paramString2)
    throws Exception
  {
    paramString2 = new SecretKeySpec(paramString2.getBytes("utf-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, paramString2, new IvParameterSpec(iv));
    return new String(localCipher.doFinal(Base64.decode(paramString1, 0)));
  }
  
  public static String encrypt(String paramString1, String paramString2)
    throws Exception
  {
    paramString1 = paramString1.getBytes("utf-8");
    paramString2 = new SecretKeySpec(paramString2.getBytes("utf-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(1, paramString2, new IvParameterSpec(iv));
    return Base64.encodeToString(localCipher.doFinal(paramString1), 0).replace("\n", "");
  }
  
  public static HashMap<String, String> getCommonData()
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    String str = "";
    localStringBuilder.append("");
    localHashMap.put("createtime", localStringBuilder.toString());
    if (CommonUtils.isRonin2(null)) {
      str = "ronin-2";
    } else if (CommonUtils.isRoninS(null)) {
      str = "ronin-s";
    } else if (CommonUtils.isHG701(null)) {
      str = "ronin-sc";
    } else if (CommonUtils.isHG702(null)) {
      str = "hg702";
    } else if (CommonUtils.isHG710(null)) {
      str = "hg710";
    }
    localHashMap.put("device_type", str);
    localHashMap.put("app_ver", "1.4.10");
    str = RoninUpgradeManager.getInstance().getDeviceVersionString();
    if ((str == null) || (str.length() <= 0)) {
      str = "unknow";
    }
    localHashMap.put("device_ver", str);
    return localHashMap;
  }
  
  private static void getRcVersion()
  {
    DataCommonGetVersion localDataCommonGetVersion = new DataCommonGetVersion();
    localDataCommonGetVersion.setDeviceType(DeviceType.RC);
    new RepeatDataBase(localDataCommonGetVersion, new DJIDataCallBack()
    {
      public void onFailure(Ccode paramAnonymousCcode) {}
      
      /* Error */
      public void onSuccess(Object arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    }).start();
  }
  
  public static String getReportAppVersion()
  {
    return "1.4.10";
  }
  
  public static String getReportDeviceVersion()
  {
    return RoninUpgradeManager.getInstance().getDeviceVersionString();
  }
  
  public static String getReportFCSn()
  {
    return sn;
  }
  
  public static String getReportProductName(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    if (localProductType != mLastReportProductType)
    {
      mLastReportProductType = localProductType;
      paramProductType = new StringBuilder();
      paramProductType.append(localProductType.value());
      paramProductType.append("");
      mLastReportProductName = paramProductType.toString();
    }
    return mLastReportProductName;
  }
  
  public static String getReportRcVersion()
  {
    return rcVer;
  }
  
  public static HashMap<String, String> getRoninsCommonData()
  {
    HashMap localHashMap = new HashMap();
    if (CommonUtils.isRonin2(null)) {
      str = "ronin-2";
    } else if (CommonUtils.isRoninS(null)) {
      str = "ronin-s";
    } else if (CommonUtils.isHG701(null)) {
      str = "ronin-sc";
    } else if (CommonUtils.isHG702(null)) {
      str = "hg702";
    } else if (CommonUtils.isHG710(null)) {
      str = "hg710";
    } else {
      str = "";
    }
    localHashMap.put("device_type", str);
    localHashMap.put("app_ver", "1.4.10");
    String str = RoninUpgradeManager.getInstance().getDeviceVersionString();
    if ((str == null) || (str.length() <= 0)) {
      str = "unknow";
    }
    localHashMap.put("device_ver", str);
    return localHashMap;
  }
  
  private static void getSN()
  {
    activeStatus.setVersion(DataFlycActiveStatus.getInstance().getVersion()).setType(DataAbstractGetPushActiveStatus.TYPE.GET);
    new RepeatDataBase(activeStatus, new DJIDataCallBack()
    {
      public void onFailure(Ccode paramAnonymousCcode) {}
      
      /* Error */
      public void onSuccess(Object arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    }).start();
  }
  
  public static String getSnEncrypt(String paramString)
  {
    try
    {
      String str = encrypt(paramString, aes);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  public static String getUUID()
  {
    return DJIA.getUUID();
  }
  
  public static String getUuid()
  {
    synchronized (mLock)
    {
      Context localContext = RoninApplication.getAppContext();
      String str2 = DjiSharedPreferencesManager.getString(localContext, "key_uuid_for_server_log_device", "");
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = UUID.randomUUID().toString();
        DjiSharedPreferencesManager.putString(localContext, "key_uuid_for_server_log_device", str1);
      }
      return str1;
    }
  }
  
  public static void initDJIReport(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int i;
    if (((paramString.startsWith("develop")) || (paramString.contains("freeline"))) && (!paramBoolean1)) {
      i = 1;
    } else {
      i = 0;
    }
    DJIA.init(paramContext, "437132", "NYSADRUHDSHAFSFC");
    if (i != 0)
    {
      DJIA.setIsDevelopMode(true);
      return;
    }
    DJIA.setDebug(paramBoolean1);
    if (paramBoolean1) {
      DJIA.setCanReport(true);
    }
    DJIA.addExtraData("flavor", paramString);
    DJIA.setIsEnableCellular(paramBoolean2);
  }
  
  public static boolean isCanReport()
  {
    return DJIA.getCanReport();
  }
  
  public static void logEvent(String paramString)
  {
    DJIA.logEvent(paramString);
  }
  
  public static void logEvent(String paramString, HashMap<String, String> paramHashMap)
  {
    DJIA.logEvent(paramString, paramHashMap);
  }
  
  public static void logEvent(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    DJIA.logEvent(paramString, paramHashMap, paramBoolean);
  }
  
  public static void onRemoteOK() {}
  
  public static void test()
  {
    RoninLog.logWriteE("testreport", "testreport", "getReportProductName=%s getReportAppVersion=%s getReportDeviceVersion=%s getReportFCSn=%s", new Object[] { getReportProductName(null), getReportAppVersion(), getReportDeviceVersion(), getReportFCSn() });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\LogReport\DJIReportUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */