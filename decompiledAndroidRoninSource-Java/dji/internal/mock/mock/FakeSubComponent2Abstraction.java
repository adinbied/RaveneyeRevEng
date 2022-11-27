package dji.internal.mock.mock;

import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.Setter;

public class FakeSubComponent2Abstraction
  extends DJISDKCacheHWAbstraction
{
  private static final String TAG = "FakeComponentAbstraction";
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("FakePush")
  public void getFakeSubValue(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void initializeComponentCharacteristics()
  {
    addCharacteristics(FakeSubComponentKeys.class, FakeSubComponent2Abstraction.class);
  }
  
  @Setter("FakePush")
  public void setFakeSubValue(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onSuccess(null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\mock\FakeSubComponent2Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */