package dji.internal.logics.whitelist;

import android.content.Context;
import dji.common.error.DJIError;
import dji.common.util.CommonCallbacks.CompletionCallback;
import dji.common.util.CommonCallbacks.CompletionCallbackWith;
import dji.internal.logics.whitelist.licenses.WhiteListLicense;
import dji.internal.logics.whitelist.listeners.FetchEncryptedListFromServerEventListener;
import dji.internal.logics.whitelist.listeners.SendEncryptedListToAircraftEventListener;
import dji.internal.logics.whitelist.listeners.WhiteListLicensesChangeListener;
import dji.midware.data.model.P3.DataWhiteListRequestLicense;
import dji.midware.data.model.P3.DataWhiteListSendWhiteList;
import dji.midware.data.model.P3.DataWhiteListSetLicenseEnabled;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import dji.thirdparty.afinal.http.AjaxCallBack;
import java.util.ArrayList;

public class DJIWhiteListManager
  implements DJIParamAccessListener
{
  public static final int FAIL_TO_CHECK_SN = 4;
  public static final int FAIL_TO_PASS_CRC = 3;
  public static final int FILE_SIZE_ERROR = 2;
  private static final int FRAGMENT_SIZE = 200;
  private static final int INDEX_IS_NOT_CONTINUOUS = 1;
  public static final int LOW_FLYC_VERSION = 5;
  public static final int SEND_COMMAND_FAIL = 255;
  private static final int SUCCESS = 0;
  private static final String URL_PARAM_PLATFORM = "platform";
  private static final String URL_PARAM_SN = "sn";
  private static final String URL_PARAM_TOKEN = "token";
  private static DJIWhiteListManager mInstance;
  private final DataWhiteListSendWhiteList instance = DataWhiteListSendWhiteList.getInstance();
  private boolean isGettingDataFromRemote = true;
  private byte[] licenseInBytes;
  ArrayList<WhiteListLicense> licenses;
  private Context mContext;
  private byte[] sendData = new byte['È'];
  private String serialNumber = "";
  private WhiteListLicensesChangeListener whiteListLicensesChangeListener;
  
  public DJIWhiteListManager(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public static DJIWhiteListManager getInstance(Context paramContext)
  {
    if (mInstance == null) {
      mInstance = new DJIWhiteListManager(paramContext);
    }
    return mInstance;
  }
  
  private int getNumberOfBlock(int paramInt)
  {
    return 0;
  }
  
  private byte[] getSendData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  /* Error */
  private void getWhiteListLicensesEnabled(CommonCallbacks.CompletionCallbackWith<WhiteListLicense[]> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private WhiteListLicense parseWhiteListLicense(DataWhiteListRequestLicense paramDataWhiteListRequestLicense, int paramInt)
  {
    return null;
  }
  
  /* Error */
  private void requestLicense(int arg1, CommonCallbacks.CompletionCallbackWith<WhiteListLicense[]> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void sendData(byte[] arg1, int arg2, int arg3, SendEncryptedListToAircraftEventListener arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setLicensesEnabled(DataWhiteListSetLicenseEnabled arg1, ArrayList<WhiteListLicense> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setLicensesValid(DataWhiteListSetLicenseEnabled arg1, ArrayList<WhiteListLicense> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setSth(int arg1, WhiteListLicense[] arg2, boolean arg3, CommonCallbacks.CompletionCallback arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void fetchEncryptedLicenseFromServer(String arg1, String arg2, boolean arg3, FetchEncryptedListFromServerEventListener arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public byte[] getLicenseInBytes()
  {
    return this.licenseInBytes;
  }
  
  public ArrayList<WhiteListLicense> getLicenses()
  {
    return this.licenses;
  }
  
  /* Error */
  public void getLicenses(CommonCallbacks.CompletionCallbackWith<WhiteListLicense[]> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getWhiteListLicense(String arg1, String arg2, boolean arg3, CommonCallbacks.CompletionCallbackWith<WhiteListLicense[]> arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onValueChange(DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue paramDJISDKCacheParamValue1, DJISDKCacheParamValue paramDJISDKCacheParamValue2)
  {
    if ((paramDJISDKCacheKey != null) && (paramDJISDKCacheKey.getParamKey() == "InternalSerialNumber") && (paramDJISDKCacheParamValue2 != null) && (paramDJISDKCacheParamValue2.getData() != null)) {
      this.serialNumber = ((String)paramDJISDKCacheParamValue2.getData());
    }
  }
  
  /* Error */
  public void sendEncryptedLicenseToAircraft(byte[] arg1, SendEncryptedListToAircraftEventListener arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setLicenseEnabled(WhiteListLicense arg1, boolean arg2, CommonCallbacks.CompletionCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setWhiteListEnabled(boolean arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setWhiteListLicensesChangeListener(WhiteListLicensesChangeListener paramWhiteListLicensesChangeListener)
  {
    this.whiteListLicensesChangeListener = paramWhiteListLicensesChangeListener;
  }
  
  /* Error */
  public void syncServerWhiteListToAircraft(String arg1, String arg2, boolean arg3, CommonCallbacks.CompletionCallback arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum EnableLicenseErrorType
  {
    private int data;
    
    static
    {
      NEED_TO_CONNECT_NETWORK = new EnableLicenseErrorType("NEED_TO_CONNECT_NETWORK", 3, 4);
      LICENSE_IS_NOT_SUPPORT = new EnableLicenseErrorType("LICENSE_IS_NOT_SUPPORT", 4, 5);
      EnableLicenseErrorType localEnableLicenseErrorType = new EnableLicenseErrorType("LICENSE_IS_INVALID", 5, 6);
      LICENSE_IS_INVALID = localEnableLicenseErrorType;
      $VALUES = new EnableLicenseErrorType[] { INDEX_ILLEGAL, OPERATE_CODE_ERROR, REQ_ID_NOT_MATCH, NEED_TO_CONNECT_NETWORK, LICENSE_IS_NOT_SUPPORT, localEnableLicenseErrorType };
    }
    
    private EnableLicenseErrorType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\whitelist\DJIWhiteListManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */