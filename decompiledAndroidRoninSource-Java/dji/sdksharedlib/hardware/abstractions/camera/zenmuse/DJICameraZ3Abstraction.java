package dji.sdksharedlib.hardware.abstractions.camera.zenmuse;

import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import org.greenrobot.eventbus.EventBus;

public class DJICameraZ3Abstraction
  extends DJICameraX3Abstraction
{
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected String getDisplayName()
  {
    return "Zenmuse Z3";
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isAFSupported()
  {
    return true;
  }
  
  protected boolean isAdjustableFocalPointSupported()
  {
    return true;
  }
  
  protected boolean isDigitalZoomScaleSupported()
  {
    return true;
  }
  
  protected boolean isMFSupported()
  {
    return false;
  }
  
  protected boolean isMediaDownloadModeSupported()
  {
    return true;
  }
  
  protected boolean isOpticalZoomSupported()
  {
    return true;
  }
  
  protected boolean isPlaybackSupported()
  {
    return true;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\zenmuse\DJICameraZ3Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */