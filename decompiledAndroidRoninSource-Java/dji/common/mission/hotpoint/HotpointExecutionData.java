package dji.common.mission.hotpoint;

import dji.common.mission.MissionUtils;
import dji.midware.data.model.P3.DataFlycGetPushWayPointMissionInfo;

public class HotpointExecutionData
{
  private float angularVelocity;
  private float currentRadius;
  private boolean isInitializing;
  
  public HotpointExecutionData(DataFlycGetPushWayPointMissionInfo paramDataFlycGetPushWayPointMissionInfo)
  {
    if (paramDataFlycGetPushWayPointMissionInfo.getHotPointMissionStatus() == 0) {
      this.isInitializing = true;
    }
    this.currentRadius = (paramDataFlycGetPushWayPointMissionInfo.getHotPointRadius() / 100.0F);
    this.angularVelocity = ((int)(MissionUtils.Degree(paramDataFlycGetPushWayPointMissionInfo.getHotPointSpeed() * 0.1D / this.currentRadius) + 0.5D));
    if (paramDataFlycGetPushWayPointMissionInfo.isClockwise()) {
      this.angularVelocity *= -1.0F;
    }
  }
  
  public float getAngularVelocity()
  {
    return this.angularVelocity;
  }
  
  public float getCurrentDistanceToHotpoint()
  {
    return this.currentRadius;
  }
  
  public float getCurrentRadius()
  {
    return this.currentRadius;
  }
  
  public boolean getInitializing()
  {
    return this.isInitializing;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\hotpoint\HotpointExecutionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */