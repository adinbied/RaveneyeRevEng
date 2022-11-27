package dji.sdksharedlib.hardware.abstractions.product;

import dji.common.product.Model;
import dji.internal.version.VersionController.VersionChangeObserver;
import dji.midware.component.DJIComponentManager.MonitorComponentType;
import dji.midware.component.DJIComponentManager.PlatformType;
import dji.midware.component.DJIComponentManager.RcComponentType;
import dji.midware.util.DJIEventBusUtil;
import dji.sdksharedlib.extension.KeyHelper;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DJIProductAbstraction
  extends DJISDKCacheHWAbstraction
  implements VersionController.VersionChangeObserver
{
  private static final String TAG = "DJISDKCacheProductAbstraction";
  private DJIComponentManager.MonitorComponentType lastMonitorType;
  private DJIComponentManager.PlatformType lastPlatformType;
  
  private Model getModel(DJIComponentManager.PlatformType paramPlatformType, DJIComponentManager.MonitorComponentType paramMonitorComponentType)
  {
    return null;
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected DJISDKCacheKey genKeyPath(String paramString)
  {
    return null;
  }
  
  public boolean hasMonitor(DJIComponentManager.PlatformType paramPlatformType, DJIComponentManager.MonitorComponentType paramMonitorComponentType)
  {
    return 1.$SwitchMap$dji$midware$component$DJIComponentManager$MonitorComponentType[paramMonitorComponentType.ordinal()] == 1;
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    DJIEventBusUtil.register(this);
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isHandle(DJIComponentManager.PlatformType paramPlatformType, DJIComponentManager.MonitorComponentType paramMonitorComponentType)
  {
    int i = 1.$SwitchMap$dji$midware$component$DJIComponentManager$PlatformType[paramPlatformType.ordinal()];
    return (i == 2) || (i == 3) || (i == 4) || (i == 5);
  }
  
  public boolean isMonitor(DJIComponentManager.PlatformType paramPlatformType, DJIComponentManager.MonitorComponentType paramMonitorComponentType)
  {
    return false;
  }
  
  public boolean isRonin(DJIComponentManager.PlatformType paramPlatformType, DJIComponentManager.MonitorComponentType paramMonitorComponentType)
  {
    return (isHandle(paramPlatformType, paramMonitorComponentType)) || (paramPlatformType == DJIComponentManager.PlatformType.Ronin2);
  }
  
  public boolean isRoninWithMonitor(DJIComponentManager.PlatformType paramPlatformType, DJIComponentManager.MonitorComponentType paramMonitorComponentType)
  {
    return false;
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.component.DJIComponentManager.CameraComponentType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DJIComponentManager.MonitorComponentType paramMonitorComponentType)
  {
    updateProduct();
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DJIComponentManager.PlatformType paramPlatformType)
  {
    updateProduct();
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DJIComponentManager.RcComponentType paramRcComponentType)
  {
    updateProduct();
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.manager.P3.DataEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataCameraActiveStatus arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataFlycActiveStatus arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataOsdActiveStatus arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onVersionChange(String paramString1, String paramString2)
  {
    notifyValueChangeForKeyPath(paramString2, KeyHelper.getProductKey("FirmwarePackageVersion"));
  }
  
  /* Error */
  public void syncPushDataFromMidware()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void updateProduct()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\product\DJIProductAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */