package dji.pilot.active;

import android.content.Context;
import com.dji.ronin.publics.AssistUIHandler;
import com.dji.ronin.util.CommonUtils;
import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.model.P3.DataCenterActiveStatus;
import dji.midware.data.model.P3.DataCommonGetVersion;
import dji.midware.data.model.P3.DataGimbalActiveStatus;
import dji.midware.data.model.common.DataAbstractGetPushActiveStatus;
import dji.midware.interfaces.DJIDataCallBack;
import dji.thirdparty.okhttp3.Call;
import dji.thirdparty.okhttp3.Callback;
import dji.thirdparty.okhttp3.OkHttpClient;
import dji.thirdparty.okhttp3.OkHttpClient.Builder;
import dji.thirdparty.okhttp3.RequestBody;
import dji.thirdparty.okhttp3.Response;
import java.io.IOException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Map;

public class ActiveWebController
{
  private static final String NEW_SIGN_KEY = "Q2Zk6umfm0isNgj9EY8QdNbC";
  private static final String TAG = "DJIActiveController";
  private static ArrayList<DeviceType> devices = new ArrayList(4);
  private static DeviceType mEnterDevice = DeviceType.CENTER;
  private int activeModelCount = 0;
  private DJIActiveSnModel activeSnModel;
  private DataAbstractGetPushActiveStatus centerActiveStatus;
  private Context context;
  private DJIActiveWebFailType failType;
  private DataAbstractGetPushActiveStatus gimbalActiveStatus = DataGimbalActiveStatus.getInstance();
  private DJIActiveWebListener listener;
  private DJIActiveErrorModel mErrorModel = new DJIActiveErrorModel();
  private boolean mIsNeedPhoneWhenActivate;
  private DJIMultiBatteryActiveManager mMultiBatteryActiveManager;
  private DataAbstractGetPushActiveStatus mainActiveStatus;
  private OkHttpClient okHttpClient;
  
  public ActiveWebController(Context paramContext, DJIActiveWebListener paramDJIActiveWebListener)
  {
    DataCenterActiveStatus localDataCenterActiveStatus = DataCenterActiveStatus.getInstance();
    this.centerActiveStatus = localDataCenterActiveStatus;
    this.mainActiveStatus = localDataCenterActiveStatus;
    this.mMultiBatteryActiveManager = DJIMultiBatteryActiveManager.getInstance();
    this.mIsNeedPhoneWhenActivate = false;
    this.failType = DJIActiveWebFailType.NoStart;
    this.context = paramContext;
    this.listener = paramDJIActiveWebListener;
    this.okHttpClient = new OkHttpClient.Builder().build();
  }
  
  /* Error */
  private void checkSnModels(DJIActiveSnModel arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private RequestBody generateActivateBody(String paramString)
    throws SignatureException
  {
    return null;
  }
  
  private RequestBody generateErrorBody(String paramString)
    throws SignatureException
  {
    return null;
  }
  
  private Map<String, String> generateParams(String paramString)
    throws SignatureException
  {
    return null;
  }
  
  private RequestBody generateTermsBody(String paramString1, String paramString2, String paramString3)
    throws SignatureException
  {
    return null;
  }
  
  private String getJson(ArrayList<DeviceType> paramArrayList)
  {
    return null;
  }
  
  private static String getProductName(ProductType paramProductType)
  {
    if (CommonUtils.isRonin2(null)) {
      return "Ronin2";
    }
    if (CommonUtils.isRoninS(null)) {
      return "ronin-s";
    }
    if (CommonUtils.isHG701(null)) {
      return "Ronin-SC";
    }
    if (CommonUtils.isHG702(null)) {
      return "DJI-RS-2";
    }
    if (CommonUtils.isHG710(null)) {
      return "DJI-RSC-2";
    }
    return "Ronin2";
  }
  
  /* Error */
  private void postToServer(String arg1, String arg2, String arg3)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DJIActiveWebFailType getFailedType()
  {
    return this.failType;
  }
  
  /* Error */
  public void getServerStatus()
    throws java.lang.Exception
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void postActiveTermsRecord(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void postErrorLog(String arg1, int arg2)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setDevices(ArrayList<DeviceType> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setIsNeedPhone(boolean paramBoolean)
  {
    this.mIsNeedPhoneWhenActivate = paramBoolean;
  }
  
  public static enum DJIActiveWebFailType
  {
    public int descIds;
    public int index;
    
    static
    {
      LocalMcFail = new DJIActiveWebFailType("LocalMcFail", 3, 3, 2131756801);
      NoConnectMc = new DJIActiveWebFailType("NoConnectMc", 4, 4, 2131756802);
      Noerror = new DJIActiveWebFailType("Noerror", 5, 5, 2131756799);
      ErrorSN = new DJIActiveWebFailType("ErrorSN", 6, 6, 2131756805);
      DJIActiveWebFailType localDJIActiveWebFailType = new DJIActiveWebFailType("FirmwareNotMatch", 7, 7, 2131756806);
      FirmwareNotMatch = localDJIActiveWebFailType;
      $VALUES = new DJIActiveWebFailType[] { NoStart, ServerBackFail, ServerNoAvailableDevices, LocalMcFail, NoConnectMc, Noerror, ErrorSN, localDJIActiveWebFailType };
    }
    
    private DJIActiveWebFailType(int paramInt1, int paramInt2)
    {
      this.index = paramInt1;
      this.descIds = paramInt2;
    }
  }
  
  public static abstract interface DJIActiveWebListener
  {
    public abstract void onFailed();
    
    public abstract void onSuccess(DJIActiveSnModel paramDJIActiveSnModel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot\active\ActiveWebController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */