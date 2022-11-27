package dji.sdksharedlib.demo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import dji.sdksharedlib.extension.CacheHelper;
import dji.sdksharedlib.extension.KeyHelper;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey.Builder;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.store.DJISDKCacheParamValue;

public class StandardDemoView
  extends LinearLayout
  implements DJIParamAccessListener
{
  DJISDKCacheKey keyPathISO = null;
  DJISDKCacheKey keyPathModel = null;
  
  public StandardDemoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new DJISDKCacheKey.Builder();
    paramContext.component("Product");
    paramContext.paramKey("ModelName");
    this.keyPathModel = paramContext.build();
    paramContext = new DJISDKCacheKey.Builder();
    paramContext.component("Camera");
    paramContext.paramKey("ISO");
    this.keyPathISO = KeyHelper.getCameraKey("ISO");
  }
  
  /* Error */
  protected void onAttachedToWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onDetachedFromWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onValueChange(DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue paramDJISDKCacheParamValue1, DJISDKCacheParamValue paramDJISDKCacheParamValue2)
  {
    if (!CacheHelper.isDataValid(paramDJISDKCacheKey, paramDJISDKCacheParamValue2)) {
      return;
    }
    if (paramDJISDKCacheKey.equals(this.keyPathModel)) {
      return;
    }
    paramDJISDKCacheKey.equals(this.keyPathISO);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\demo\StandardDemoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */