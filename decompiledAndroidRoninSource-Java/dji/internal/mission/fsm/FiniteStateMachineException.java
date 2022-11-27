package dji.internal.mission.fsm;

public abstract interface FiniteStateMachineException
{
  public static final RuntimeException NOT_REACHABLE_STATE_EXCEPTION = new RuntimeException(new String("Could not transit state from %s to %s"));
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\fsm\FiniteStateMachineException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */