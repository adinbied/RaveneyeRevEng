package dji.internal.mock;

import dji.sdksharedlib.hardware.DJISDKCacheHWAbstractionLayer;

public class MockDJISDKCacheHWAbstractionLayer
  extends DJISDKCacheHWAbstractionLayer
{
  /* Error */
  protected void addAirLinkAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void addBatteryAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addCameraAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addFlightController()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addGimbalAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addRcAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void initProductAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void mockRemoveAbstraction(String paramString)
  {
    removeAbstraction(paramString);
  }
  
  public void notifyFakeComponentChanged()
  {
    notifyComponentChanged();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\MockDJISDKCacheHWAbstractionLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */