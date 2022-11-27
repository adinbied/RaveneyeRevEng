package dji.internal.mock.abstractions;

import dji.common.airlink.OcuSyncWarningMessage;
import dji.sdksharedlib.hardware.abstractions.airlink.lb.DJIOcuSyncLinkAbstraction;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.functions.Func1;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MockOcuSyncLinkAbstraction
  extends DJIOcuSyncLinkAbstraction
{
  private boolean goingUp = true;
  private int videoSignalPercentage = 0;
  
  public MockOcuSyncLinkAbstraction()
  {
    generateFakeVideoSignalPercentage();
    if (this.currentWarningMessage == null) {
      this.currentWarningMessage = new ConcurrentHashMap();
    }
    generateFakeWarningMessage();
  }
  
  /* Error */
  private void generateFakeVideoSignalPercentage()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void generateFakeWarningMessage()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getTotalWarningMessage()
  {
    return this.currentWarningMessage.size();
  }
  
  public boolean isTimerRunning()
  {
    return this.isTimerRunning;
  }
  
  public boolean updateWarningMessageAndCheckIfShouldNotify(OcuSyncWarningMessage paramOcuSyncWarningMessage)
  {
    return super.updateWarningMessageAndCheckIfShouldNotify(paramOcuSyncWarningMessage);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\abstractions\MockOcuSyncLinkAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */