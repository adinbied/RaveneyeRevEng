package dji.common.mission.activetrack;

import android.graphics.RectF;

public class ActiveTrackMission
{
  private ActiveTrackMode mode;
  private int targetIndex;
  private RectF targetRect;
  
  public ActiveTrackMission() {}
  
  public ActiveTrackMission(RectF paramRectF, int paramInt, ActiveTrackMode paramActiveTrackMode)
  {
    this.targetIndex = paramInt;
    this.targetRect = paramRectF;
    this.mode = paramActiveTrackMode;
  }
  
  private boolean isNormalized(double paramDouble)
  {
    return false;
  }
  
  public ActiveTrackMode getMode()
  {
    return this.mode;
  }
  
  public int getTargetIndex()
  {
    return this.targetIndex;
  }
  
  public RectF getTargetRect()
  {
    return this.targetRect;
  }
  
  public boolean isValid()
  {
    return false;
  }
  
  public void setMode(ActiveTrackMode paramActiveTrackMode)
  {
    this.mode = paramActiveTrackMode;
  }
  
  public void setTargetIndex(int paramInt)
  {
    this.targetIndex = paramInt;
  }
  
  public void setTargetRect(RectF paramRectF)
  {
    this.targetRect = paramRectF;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\activetrack\ActiveTrackMission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */