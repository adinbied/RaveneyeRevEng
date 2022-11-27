package dji.common.gimbal;

public enum EndpointDirection
{
  static
  {
    PITCH_DOWN = new EndpointDirection("PITCH_DOWN", 1);
    YAW_LEFT = new EndpointDirection("YAW_LEFT", 2);
    EndpointDirection localEndpointDirection = new EndpointDirection("YAW_RIGHT", 3);
    YAW_RIGHT = localEndpointDirection;
    $VALUES = new EndpointDirection[] { PITCH_UP, PITCH_DOWN, YAW_LEFT, localEndpointDirection };
  }
  
  private EndpointDirection() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\EndpointDirection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */