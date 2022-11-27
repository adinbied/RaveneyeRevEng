package dji.internal.mock.mock;

import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.keycatalog.DJISDKCacheKeys;
import dji.sdksharedlib.keycatalog.extension.ComplexKey;
import dji.sdksharedlib.keycatalog.extension.Key;

public class FakeSubComponentKeys
  extends DJISDKCacheKeys
{
  public static final String COMPONENT_KEY = "FakeSubComponent";
  @Key(accessType=8, types={Integer.class, FakeSubComponentAbstraction.FakeStructParam.class, Boolean.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FAKE_ACTION = "FakeAction";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FAKE_ACTION_NO_PARAM = "FakeActionNoParam";
  @ComplexKey({@Key(accessType=4, includedAbstractions={FakeSubComponentAbstraction.class}, updateType=DJISDKCacheUpdateType.DYNAMIC), @Key(accessType=3, includedAbstractions={FakeSubComponent2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)})
  public static final String FAKE_PUSH = "FakePush";
  @Key(accessType=3, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FAKE_SUB_VALUE = "FakeSubValue";
  
  public FakeSubComponentKeys(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\mock\FakeSubComponentKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */