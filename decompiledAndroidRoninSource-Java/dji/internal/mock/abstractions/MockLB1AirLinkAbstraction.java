package dji.internal.mock.abstractions;

import dji.sdksharedlib.hardware.abstractions.airlink.lb.Lightbridge1Abstraction;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.functions.Func1;

public class MockLB1AirLinkAbstraction
  extends Lightbridge1Abstraction
{
  private boolean goingUp = true;
  private int videoSignalPercentage = 0;
  
  public MockLB1AirLinkAbstraction()
  {
    generateFakeVideoSignalPercentage();
  }
  
  /* Error */
  private void generateFakeVideoSignalPercentage()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\abstractions\MockLB1AirLinkAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */