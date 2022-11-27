package dji.sdksharedlib.hardware.abstractions.airlink.lb;

import dji.common.airlink.ChannelSelectionMode;
import dji.common.airlink.LightbridgeFrequencyBand;
import dji.common.error.DJIError;
import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataRemoteControllerGetParam;
import dji.midware.data.model.P3.DataRemoteControllerGetParam.ParamType;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.extension.CacheHelper;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;

public class Lightbridge2Phantom4PAbstraction
  extends Lightbridge2Abstraction
{
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("ChannelRange")
  public void getChannelRange(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getDataRate(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("FrequencyBand")
  public void getFrequencyBand(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getSupportedFrequencyBands(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init(String paramString1, int paramInt1, String paramString2, int paramInt2, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString1, paramInt1, paramString2, paramInt2, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    CacheHelper.addLightbridgeLinkListener(this, new String[] { "FrequencyBand", "ChannelRange", "ChannelSelectionMode", "SupportedFrequencyBands" });
  }
  
  public void onValueChange(DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue paramDJISDKCacheParamValue1, DJISDKCacheParamValue paramDJISDKCacheParamValue2)
  {
    if (!CacheHelper.isDataValid(paramDJISDKCacheKey, paramDJISDKCacheParamValue2)) {
      return;
    }
    if ((paramDJISDKCacheParamValue2 != null) && (paramDJISDKCacheParamValue2.getData() != null))
    {
      if (paramDJISDKCacheKey.getParamKey().equals("FrequencyBand"))
      {
        this.currentFrequencyBand = ((LightbridgeFrequencyBand)CacheHelper.getLightbridgeLink("FrequencyBand"));
        getChannelRange(new DJISDKCacheHWAbstraction.InnerCallback()
        {
          public void onFails(DJIError paramAnonymousDJIError) {}
          
          public void onSuccess(Object paramAnonymousObject)
          {
            Lightbridge2Phantom4PAbstraction.this.setRange();
          }
        });
        return;
      }
      if (paramDJISDKCacheKey.getParamKey().equals("ChannelRange"))
      {
        setRange();
        return;
      }
      if (paramDJISDKCacheKey.getParamKey().equals("ChannelSelectionMode"))
      {
        this.mode = ((ChannelSelectionMode)CacheHelper.getLightbridgeLink("ChannelSelectionMode"));
        return;
      }
      if (!paramDJISDKCacheKey.getParamKey().equals("SupportedFrequencyBands")) {}
    }
    try
    {
      this.supportBand = ((LightbridgeFrequencyBand[])CacheHelper.getLightbridgeLink("SupportedFrequencyBands"));
      return;
    }
    catch (Exception paramDJISDKCacheKey)
    {
      for (;;) {}
    }
    this.supportBand = new LightbridgeFrequencyBand[] { LightbridgeFrequencyBand.UNKNOWN };
  }
  
  /* Error */
  public void setDataRate(dji.common.airlink.LightbridgeDataRate arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("FrequencyBand")
  public void setFrequencyBand(LightbridgeFrequencyBand arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\airlink\lb\Lightbridge2Phantom4PAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */