package dji.internal.mock.mock;

import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.keycatalog.DJISDKCacheKeys;
import dji.sdksharedlib.keycatalog.extension.Key;

public class FakeComponentKeys
  extends DJISDKCacheKeys
{
  public static final String COMPONENT_KEY = "FakeComponent";
  @Key(accessType=3, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FAKE_VALUE = "FakeValue";
  
  public FakeComponentKeys(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\mock\FakeComponentKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */