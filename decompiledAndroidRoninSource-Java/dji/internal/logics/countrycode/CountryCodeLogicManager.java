package dji.internal.logics.countrycode;

import android.content.Context;
import dji.common.error.DJIError;
import dji.common.product.Model;
import dji.internal.network.BaseRemoteService.SDKRemoteServiceCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.listener.DJISetCallback;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Func1;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

public class CountryCodeLogicManager
{
  private static final int MAX_RETRY = 20;
  private static final Model[] SUPPORTED_MODEL = { Model.MAVIC_PRO, Model.INSPIRE_2, Model.PHANTOM_4_PRO, Model.RONIN2, Model.RONINS, Model.RONINSC };
  private static final String TAG = "CountryCodeLogicManager";
  private Map<CountryCodeSource, CountryCodeStatus> countryCodeStatus;
  private Map<CountryCodeSource, String> countryCodeValue;
  private Verifier countryCodeVerifier;
  private int gpsLevel = -1;
  private boolean isCallingNetwork = false;
  private boolean isEnabled = true;
  private boolean isOnAir = false;
  private String serialNumber;
  private Observable timer;
  private Subscription timerSubscription;
  
  private CountryCodeLogicManager()
  {
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
    this.countryCodeValue = new HashMap();
    this.countryCodeStatus = new HashMap();
  }
  
  /* Error */
  private void getCountryCode(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private int getGpsLevel()
  {
    return this.gpsLevel;
  }
  
  private int getGpsLevelForOldFlightController(int paramInt)
  {
    return 0;
  }
  
  public static CountryCodeLogicManager getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  /* Error */
  private void getOfflineCountryCode(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private boolean isOldMC()
  {
    return false;
  }
  
  private boolean isTargetDevice()
  {
    return false;
  }
  
  private boolean isValidStateToCommitCountryCode()
  {
    return false;
  }
  
  /* Error */
  private void startTimer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void stopTimer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void commitCountryCode(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getCountryCodeByGPS(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void getCountryCodeByIPAddress(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean getCountryCodeByMcc(Context paramContext, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    return false;
  }
  
  public void getRawSerialNumber() {}
  
  /* Error */
  public void init(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isGPSCoordinateValid()
  {
    return false;
  }
  
  public boolean isOnAir()
  {
    return this.isOnAir;
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
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataOsdGetPushCommon arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    try
    {
      this.isEnabled = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static class LazyHolder
  {
    private static final CountryCodeLogicManager INSTANCE = new CountryCodeLogicManager(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\countrycode\CountryCodeLogicManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */