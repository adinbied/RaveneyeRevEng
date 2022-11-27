package dji.internal.mission.fsm;

import dji.common.mission.MissionState;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FiniteStateMachine
  implements FiniteStateMachineException
{
  private MissionState currentState;
  private boolean isLooseModeEnabled = false;
  private Set<MissionState> stateSet = Collections.newSetFromMap(new ConcurrentHashMap());
  private Set<MissionState> superStateSet = Collections.newSetFromMap(new ConcurrentHashMap());
  private List<MissionState> tempFromStateArray = new CopyOnWriteArrayList();
  private Map<MissionState, List<MissionState>> transitionMap = new ConcurrentHashMap();
  
  private boolean internalTransitTo(MissionState paramMissionState, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      if (!canTransitTo(paramMissionState))
      {
        paramBoolean = this.isLooseModeEnabled;
        if (!paramBoolean) {
          return false;
        }
      }
      this.currentState = paramMissionState;
      return true;
    }
    finally {}
  }
  
  public FiniteStateMachine add(MissionState paramMissionState)
  {
    this.stateSet.add(paramMissionState);
    return this;
  }
  
  public boolean canTransitTo(MissionState paramMissionState)
  {
    return false;
  }
  
  public void forceTransitTo(MissionState paramMissionState)
  {
    internalTransitTo(paramMissionState, true);
  }
  
  public FiniteStateMachine from(MissionState... paramVarArgs)
  {
    return null;
  }
  
  public FiniteStateMachine fromAll()
  {
    return null;
  }
  
  public MissionState getState()
  {
    try
    {
      MissionState localMissionState = this.currentState;
      return localMissionState;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setLooseModeEnabled(boolean paramBoolean)
  {
    this.isLooseModeEnabled = paramBoolean;
  }
  
  public FiniteStateMachine superState(MissionState... paramVarArgs)
  {
    return null;
  }
  
  public FiniteStateMachine to(MissionState... paramVarArgs)
  {
    return null;
  }
  
  public boolean transitTo(MissionState paramMissionState)
  {
    return internalTransitTo(paramMissionState, false);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\fsm\FiniteStateMachine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */