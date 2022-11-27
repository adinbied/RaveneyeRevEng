package dji.sdksharedlib.demo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import dji.sdksharedlib.extension.CacheHelper;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.store.DJISDKCacheParamValue;

public class EasyDemo2View
  extends LinearLayout
  implements DJIParamAccessListener
{
  DJISDKCacheKey keyPathISO = null;
  DJISDKCacheKey keyPathModel = null;
  
  public EasyDemo2View(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  /* Error */
  protected void onAttachedToWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    CacheHelper.removeListener(this);
  }
  
  public void onValueChange(DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue paramDJISDKCacheParamValue1, DJISDKCacheParamValue paramDJISDKCacheParamValue2)
  {
    if (!CacheHelper.isDataValid(paramDJISDKCacheKey, paramDJISDKCacheParamValue2)) {
      return;
    }
    paramDJISDKCacheKey = this.keyPathModel;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\demo\EasyDemo2View.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */