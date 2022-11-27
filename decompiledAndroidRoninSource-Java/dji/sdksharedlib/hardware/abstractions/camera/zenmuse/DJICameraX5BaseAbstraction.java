package dji.sdksharedlib.hardware.abstractions.camera.zenmuse;

import dji.common.camera.CameraSSDVideoLicense;
import dji.common.camera.CameraUtils;
import dji.common.error.DJIError;
import dji.common.util.DJILensFeatureUtils;
import dji.common.util.LatchHelper;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.camera.DJICameraBaseAbstraction;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

public class DJICameraX5BaseAbstraction
  extends DJICameraBaseAbstraction
{
  private ArrayList<CameraSSDVideoLicense> cameraSSDVideoLicenseArrayList = new ArrayList(3);
  protected LatchHelper latchHelper = LatchHelper.getInstance();
  
  protected int checkColIndex(int paramInt)
  {
    return 0;
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    this.apertureMap = CameraUtils.buildApertureMap();
    this.lensFeatureUtils = new DJILensFeatureUtils();
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
  }
  
  protected boolean isAdjustableApertureSupported()
  {
    return true;
  }
  
  protected boolean isAdjustableFocalPointSupported()
  {
    return true;
  }
  
  protected boolean isAudioRecordSupported()
  {
    return true;
  }
  
  protected boolean isChangeableLensSupported()
  {
    return true;
  }
  
  protected boolean isHandHeldProduct()
  {
    return false;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataCameraGetPushRawParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void syncPushDataFromMidware()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\zenmuse\DJICameraX5BaseAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */