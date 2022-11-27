package dji.internal.mission.fsm;

import dji.common.mission.MissionState;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Subscription;

public class FSMTempStateTimer
{
  private MissionState currentState;
  private Observable<Long> observable;
  private Subscription subscription;
  private Runnable successOperation;
  
  /* Error */
  public void notifyStateChange(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startTimer(MissionState arg1, boolean arg2, double arg3, Runnable arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startTimer(MissionState arg1, boolean arg2, Runnable arg3, double arg4, Runnable arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\fsm\FSMTempStateTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */