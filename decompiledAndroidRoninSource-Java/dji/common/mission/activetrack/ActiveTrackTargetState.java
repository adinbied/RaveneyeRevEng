package dji.common.mission.activetrack;

public enum ActiveTrackTargetState
{
  static
  {
    TRACKING_WITH_HIGH_CONFIDENCE = new ActiveTrackTargetState("TRACKING_WITH_HIGH_CONFIDENCE", 2);
    TRACKING_WITH_LOW_CONFIDENCE = new ActiveTrackTargetState("TRACKING_WITH_LOW_CONFIDENCE", 3);
    ActiveTrackTargetState localActiveTrackTargetState = new ActiveTrackTargetState("UNKNOWN", 4);
    UNKNOWN = localActiveTrackTargetState;
    $VALUES = new ActiveTrackTargetState[] { CANNOT_CONFIRM, WAITING_FOR_CONFIRMATION, TRACKING_WITH_HIGH_CONFIDENCE, TRACKING_WITH_LOW_CONFIDENCE, localActiveTrackTargetState };
  }
  
  private ActiveTrackTargetState() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\activetrack\ActiveTrackTargetState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */