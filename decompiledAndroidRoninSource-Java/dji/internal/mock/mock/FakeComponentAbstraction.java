package dji.internal.mock.mock;

import dji.common.error.DJIError;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.Setter;

public class FakeComponentAbstraction
  extends DJISDKCacheHWAbstraction
{
  private static final String TAG = "FakeComponentAbstraction";
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("FakeValue")
  public void getFakeValue(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void initializeComponentCharacteristics()
  {
    addCharacteristics(FakeComponentKeys.class, FakeComponentAbstraction.class);
  }
  
  /* Error */
  protected void initializeSubComponents(dji.sdksharedlib.store.DJISDKCacheStoreLayer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Setter("FakeValue")
  public void setFakeValue(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null)
    {
      if (paramInt > 0)
      {
        paramInnerCallback.onSuccess(null);
        return;
      }
      paramInnerCallback.onFails(DJIError.COMMON_PARAM_ILLEGAL);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\mock\FakeComponentAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */