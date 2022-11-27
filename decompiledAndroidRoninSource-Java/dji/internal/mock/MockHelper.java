package dji.internal.mock;

import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;

public class MockHelper
{
  public static void doOnResultForCallback(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback, Object paramObject)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onSuccess(paramObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\MockHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */