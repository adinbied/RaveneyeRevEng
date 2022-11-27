package dji.internal.mission.abstraction;

import dji.common.mission.MissionEvent;
import dji.common.mission.MissionState;
import dji.common.util.CommonCallbacks.CompletionCallback;
import dji.internal.mission.MissionResultPicker;
import dji.internal.mission.fsm.FSMTempStateTimer;
import dji.internal.mission.fsm.FiniteStateMachine;
import dji.midware.interfaces.DJIDataCallBack;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class BaseMissionAbstraction
{
  protected static final double DEFAULT_TIMEOUT_FOR_OPERATION = 0.5D;
  private static final String NULL_FSM_EXCEPTION = "FSM is null!";
  private static final String NULL_TIMER_EXCEPTION = "Temp state timer is null!";
  protected List<MissionState> filteringStates = new CopyOnWriteArrayList();
  protected FiniteStateMachine fsm = buildFSM();
  protected AbstractionDataHolder previousDataHolder = new AbstractionDataHolder.Builder().currentState(getFSMState()).build();
  protected FSMTempStateTimer tempStateTimer = new FSMTempStateTimer();
  
  private void cleanAllFilteringStates()
  {
    this.filteringStates.clear();
  }
  
  private void failureOperation(MissionState paramMissionState, AbstractionDataHolder.Builder paramBuilder)
  {
    cleanAllFilteringStates();
    transitToState(paramMissionState, paramBuilder);
  }
  
  private boolean internalTransitToState(MissionState paramMissionState, AbstractionDataHolder.Builder paramBuilder, boolean paramBoolean)
  {
    return false;
  }
  
  /* Error */
  private void setFilteringStates(MissionState... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract FiniteStateMachine buildFSM();
  
  protected ArrayList<MissionState> desiredMissionStatesHelper(MissionState... paramVarArgs)
  {
    return null;
  }
  
  public void destroy()
  {
    this.tempStateTimer = null;
    this.filteringStates = null;
    this.previousDataHolder = null;
  }
  
  protected boolean doesProductSupportNavigationMode()
  {
    return false;
  }
  
  /* Error */
  protected void forceTransitToState(MissionState arg1, MissionEvent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void forceTransitToState(MissionState paramMissionState, AbstractionDataHolder.Builder paramBuilder)
  {
    internalTransitToState(paramMissionState, paramBuilder, true);
  }
  
  public DJIDataCallBack generateCommonCallBackForOperationWithCurrentState(int paramInt, MissionState paramMissionState1, MissionState paramMissionState2, MissionEvent paramMissionEvent, CommonCallbacks.CompletionCallback paramCompletionCallback)
  {
    return null;
  }
  
  protected DJIDataCallBack getDataCallbackForTempState(MissionResultPicker paramMissionResultPicker, MissionState paramMissionState1, ArrayList<MissionState> paramArrayList, double paramDouble, MissionState paramMissionState2, AbstractionDataHolder.Builder paramBuilder, CommonCallbacks.CompletionCallback paramCompletionCallback)
  {
    return null;
  }
  
  protected DJIDataCallBack getDataCallbackForTempState(MissionResultPicker paramMissionResultPicker, MissionState paramMissionState1, ArrayList<MissionState> paramArrayList, MissionState paramMissionState2, AbstractionDataHolder.Builder paramBuilder, CommonCallbacks.CompletionCallback paramCompletionCallback)
  {
    return null;
  }
  
  public MissionState getFSMState()
  {
    return null;
  }
  
  protected boolean isOsmo()
  {
    return false;
  }
  
  /* Error */
  protected void notifyListener(MissionEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void notifyListener(AbstractionDataHolder paramAbstractionDataHolder);
  
  /* Error */
  public void setupEnvironment(CommonCallbacks.CompletionCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract boolean transitToState(MissionState paramMissionState, MissionEvent paramMissionEvent);
  
  protected boolean transitToState(MissionState paramMissionState, AbstractionDataHolder.Builder paramBuilder)
  {
    return internalTransitToState(paramMissionState, paramBuilder, false);
  }
  
  protected boolean tryTransitToTempState(MissionState paramMissionState, AbstractionDataHolder.Builder paramBuilder)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\BaseMissionAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */