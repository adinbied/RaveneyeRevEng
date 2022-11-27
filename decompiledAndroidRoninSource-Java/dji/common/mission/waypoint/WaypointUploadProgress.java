package dji.common.mission.waypoint;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class WaypointUploadProgress
{
  public static final int UNKNOWN = -1;
  public boolean isSummaryUploaded = false;
  public int totalWaypointCount = -1;
  public int uploadedWaypointIndex = -1;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface InitialValue {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointUploadProgress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */