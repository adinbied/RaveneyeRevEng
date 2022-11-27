package dji.internal.mock.abstractions;

import dji.common.product.Model;
import dji.midware.component.DJIComponentManager.PlatformType;
import dji.sdksharedlib.hardware.abstractions.product.DJIProductAbstraction;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.functions.Func1;

public class MockProductAbstraction
  extends DJIProductAbstraction
{
  private DJIComponentManager.PlatformType fakePlatformType = DJIComponentManager.PlatformType.FoldingDrone;
  private Model fakeProductModel = Model.MAVIC_PRO;
  private boolean isConnected = false;
  private boolean shouldFakeDisconnection = true;
  
  public MockProductAbstraction()
  {
    if (this.shouldFakeDisconnection)
    {
      generateFakeConnectivityData();
      return;
    }
    updateProduct();
  }
  
  /* Error */
  private void generateFakeConnectivityData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void updateProduct()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\abstractions\MockProductAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */