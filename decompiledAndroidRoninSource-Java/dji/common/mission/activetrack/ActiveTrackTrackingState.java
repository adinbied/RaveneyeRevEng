package dji.common.mission.activetrack;

import android.graphics.RectF;

public class ActiveTrackTrackingState
{
  private final ActiveTrackCannotConfirmReason reason;
  private final ActiveTrackTargetState state;
  private final int targetIndex;
  private final RectF targetRect;
  private final ActiveTrackTargetType type;
  
  public ActiveTrackTrackingState(ActiveTrackTargetState paramActiveTrackTargetState, ActiveTrackTargetType paramActiveTrackTargetType, RectF paramRectF, int paramInt, ActiveTrackCannotConfirmReason paramActiveTrackCannotConfirmReason)
  {
    this.state = paramActiveTrackTargetState;
    this.type = paramActiveTrackTargetType;
    this.targetRect = paramRectF;
    this.targetIndex = paramInt;
    this.reason = paramActiveTrackCannotConfirmReason;
  }
  
  public ActiveTrackCannotConfirmReason getReason()
  {
    return this.reason;
  }
  
  public ActiveTrackTargetState getState()
  {
    return this.state;
  }
  
  public int getTargetIndex()
  {
    return this.targetIndex;
  }
  
  public RectF getTargetRect()
  {
    return this.targetRect;
  }
  
  public ActiveTrackTargetType getType()
  {
    return this.type;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\activetrack\ActiveTrackTrackingState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */