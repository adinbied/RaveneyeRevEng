package dji.internal.mock.abstractions;

import dji.sdksharedlib.hardware.abstractions.battery.BatteryAbstraction;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.functions.Func1;

public class MockBatteryAbstraction
  extends BatteryAbstraction
{
  public static int remainingPercentage;
  
  public MockBatteryAbstraction()
  {
    remainingPercentage = 0;
    generateFakeRemainingPercentage();
  }
  
  /* Error */
  private void generateFakeRemainingPercentage()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("ChargeRemaining")
  public void getChargeRemaining(dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("ChargeRemainingInPercent")
  public void getChargeRemainingInPercent(dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("Current")
  public void getCurrent(dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("FullChargeCapacity")
  public void getFullChargeCapacity(dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("LifetimeRemaining")
  public void getLifetimeRemaining(dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("NumberOfDischarges")
  public void getNumberOfDischarges(dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("Voltage")
  public void getVoltage(dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\abstractions\MockBatteryAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */