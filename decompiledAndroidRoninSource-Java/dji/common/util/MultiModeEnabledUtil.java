package dji.common.util;

import dji.midware.component.DJIComponentManager;
import dji.midware.component.DJIComponentManager.PlatformType;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataFlycSetParams;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;

public class MultiModeEnabledUtil
{
  private static final String INTERNAL_FIRMWARE_VERSION = "03.01";
  
  public static void setMultiModeEnabled(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    DataFlycSetParams localDataFlycSetParams = new DataFlycSetParams();
    localDataFlycSetParams.setIndexs(new String[] { "g_config.novice_cfg.novice_func_enabled_0", "g_config.control.multi_control_mode_enable_0" });
    localDataFlycSetParams.setValues(new Number[] { Integer.valueOf(0), Integer.valueOf(1) });
    localDataFlycSetParams.start(new DJIDataCallBack()
    {
      public void onFailure(Ccode paramAnonymousCcode)
      {
        CallbackUtils.onFailure(this.val$callback, paramAnonymousCcode);
      }
      
      public void onSuccess(Object paramAnonymousObject)
      {
        CallbackUtils.onSuccess(this.val$callback, null);
      }
    });
  }
  
  public static boolean verifyRCMode(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    return (DJIComponentManager.getInstance().getPlatformType() == null) || (!DJIComponentManager.getInstance().getPlatformType().equals(DJIComponentManager.PlatformType.OSMO));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\commo\\util\MultiModeEnabledUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */