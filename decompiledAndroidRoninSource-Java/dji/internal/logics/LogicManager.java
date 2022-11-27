package dji.internal.logics;

import android.content.Context;
import dji.common.bus.LogicEventBus;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.data.model.P3.Data2100GetPushCheckStatus;
import dji.midware.data.model.P3.DataFlycGetPushCheckStatus;
import dji.midware.data.model.P3.DataGimbalGetPushParams;
import dji.midware.data.model.P3.DataOsdGetPushChannalStatus;
import dji.midware.data.model.P3.DataWifiGetPushElecSignal;
import dji.midware.interfaces.DJIDataCallBack;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class LogicManager
{
  final String[] SENSOR_CONFIG = { "g_status.topology_verify.user_interface.imu_status_0", "g_status.topology_verify.user_interface.mag_status_0" };
  private CompositeSubscription subscriptions = new CompositeSubscription();
  
  private LogicManager()
  {
    if (!org.greenrobot.eventbus.EventBus.getDefault().isRegistered(this)) {
      org.greenrobot.eventbus.EventBus.getDefault().register(this);
    }
  }
  
  public static LogicManager getInstance()
  {
    return HOLDER.logicManager;
  }
  
  private Observable<Boolean> getSensorStatus()
  {
    return null;
  }
  
  static boolean isA3()
  {
    return (DJIProductManager.getInstance().getType() == ProductType.A3) || (DJIProductManager.getInstance().getType() == ProductType.PM820);
  }
  
  private static boolean isKumquatSeries(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    return (localProductType == ProductType.KumquatX) || (localProductType == ProductType.KumquatS);
  }
  
  static boolean supportRedundancySenor()
  {
    ProductType localProductType = DJIProductManager.getInstance().getType();
    return (localProductType == ProductType.Tomato) || (localProductType == ProductType.Pomato) || (isA3()) || (isKumquatSeries(localProductType));
  }
  
  public void addSubscription(Subscription paramSubscription)
  {
    this.subscriptions.add(paramSubscription);
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
  public void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(ProductType paramProductType)
  {
    LogicEventBus.getInstance().post(paramProductType);
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(Data2100GetPushCheckStatus paramData2100GetPushCheckStatus)
  {
    LogicEventBus.getInstance().post(paramData2100GetPushCheckStatus);
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataFlycGetPushCheckStatus paramDataFlycGetPushCheckStatus)
  {
    LogicEventBus.getInstance().post(paramDataFlycGetPushCheckStatus);
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataGimbalGetPushParams paramDataGimbalGetPushParams)
  {
    LogicEventBus.getInstance().post(paramDataGimbalGetPushParams);
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataOsdGetPushChannalStatus paramDataOsdGetPushChannalStatus)
  {
    LogicEventBus.getInstance().post(paramDataOsdGetPushChannalStatus);
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataOsdGetPushCommon arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataWifiGetPushElecSignal paramDataWifiGetPushElecSignal)
  {
    LogicEventBus.getInstance().post(paramDataWifiGetPushElecSignal);
  }
  
  public void startCompassLogic()
  {
    CompassLogic.getInstance().init();
  }
  
  public void startESCLogic()
  {
    ESCLogic.getInstance().init();
  }
  
  public void startFPVTipLogic(Context paramContext)
  {
    FPVTipLogic.getInstance().init(paramContext);
  }
  
  public void startGimbalLogic()
  {
    GimbalLogic.getInstance().init();
  }
  
  public void startIMULogic()
  {
    IMULogic.getInstance().init();
  }
  
  public void startRadioChannelQualityLogic()
  {
    RadioChannelQualityLogic.getInstance().init();
  }
  
  public void startVisionLogic()
  {
    VisionLogic.getInstance().init();
  }
  
  public void stopFPVTipLogic()
  {
    FPVTipLogic.getInstance().destroy();
  }
  
  private static class HOLDER
  {
    private static final LogicManager logicManager = new LogicManager(null);
  }
  
  public static final class SensorShouldUpdateEvent {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\LogicManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */