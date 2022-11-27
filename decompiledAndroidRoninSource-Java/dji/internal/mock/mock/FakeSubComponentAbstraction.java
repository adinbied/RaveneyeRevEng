package dji.internal.mock.mock;

import dji.common.error.DJIError;
import dji.sdksharedlib.hardware.abstractions.Action;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISubComponentHWAbstraction;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;

public class FakeSubComponentAbstraction
  extends DJISubComponentHWAbstraction
{
  private static final String TAG = "FakeComponentAbstraction";
  
  @Action("FakeAction")
  public void fakeAction(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback, int paramInt, FakeStructParam paramFakeStructParam, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramInt == this.defaultKeyPath.getSubComponentIndex())
      {
        paramInnerCallback.onSuccess(null);
        return;
      }
      paramInnerCallback.onFails(DJIError.COMMON_PARAM_ILLEGAL);
      return;
    }
    paramInnerCallback.onFails(DJIError.COMMON_UNDEFINED);
  }
  
  @Action("FakeActionNoParam")
  public void fakeActionNoParam(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onSuccess(null);
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("FakeSubValue")
  public void getFakeSubValue(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void initializeComponentCharacteristics()
  {
    addCharacteristics(FakeSubComponentKeys.class, FakeSubComponentAbstraction.class);
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("FakeSubValue")
  public void setFakeSubValue(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public static class FakeStructParam {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\mock\FakeSubComponentAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */