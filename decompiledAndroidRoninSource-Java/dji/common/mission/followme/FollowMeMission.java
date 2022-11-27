package dji.common.mission.followme;

public class FollowMeMission
{
  private static FollowMeMission instance;
  private float altitude;
  private FollowMeHeading heading = FollowMeHeading.TOWARD_FOLLOW_POSITION;
  private double latitude = 181.0D;
  private double longitude = 181.0D;
  
  public static FollowMeMission getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new FollowMeMission();
      }
      FollowMeMission localFollowMeMission = instance;
      return localFollowMeMission;
    }
    finally {}
  }
  
  public float getAltitude()
  {
    return this.altitude;
  }
  
  public FollowMeHeading getHeading()
  {
    return this.heading;
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public FollowMeMission initUserData(double paramDouble1, double paramDouble2, float paramFloat)
  {
    this.latitude = paramDouble1;
    this.longitude = paramDouble2;
    this.altitude = paramFloat;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\followme\FollowMeMission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */