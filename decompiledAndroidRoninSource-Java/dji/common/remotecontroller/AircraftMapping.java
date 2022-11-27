package dji.common.remotecontroller;

public class AircraftMapping
{
  private static final int DJI_RC_CONTROL_CHANNEL_SIZE = 4;
  public AircraftMappingStyle aircraftMappingStyle;
  public AircraftStickMapping leftHorizontal;
  public AircraftStickMapping leftVertical;
  public AircraftStickMapping rightHorizontal;
  public AircraftStickMapping rightVertical;
  
  public AircraftMapping(AircraftMappingStyle paramAircraftMappingStyle)
  {
    this.aircraftMappingStyle = paramAircraftMappingStyle;
    if (paramAircraftMappingStyle == AircraftMappingStyle.STYLE_1)
    {
      this.leftVertical = new AircraftStickMapping.Builder().mappingTarget(AircraftStickMappingTarget.PITCH).isReversed(false).build();
      this.leftHorizontal = new AircraftStickMapping.Builder().mappingTarget(AircraftStickMappingTarget.YAW).isReversed(false).build();
      this.rightVertical = new AircraftStickMapping.Builder().mappingTarget(AircraftStickMappingTarget.THROTTLE).isReversed(false).build();
      this.rightHorizontal = new AircraftStickMapping.Builder().mappingTarget(AircraftStickMappingTarget.ROLL).isReversed(false).build();
      return;
    }
    if (paramAircraftMappingStyle == AircraftMappingStyle.STYLE_2)
    {
      this.leftVertical = new AircraftStickMapping.Builder().mappingTarget(AircraftStickMappingTarget.THROTTLE).isReversed(false).build();
      this.leftHorizontal = new AircraftStickMapping.Builder().mappingTarget(AircraftStickMappingTarget.YAW).isReversed(false).build();
      this.rightVertical = new AircraftStickMapping.Builder().mappingTarget(AircraftStickMappingTarget.PITCH).isReversed(false).build();
      this.rightHorizontal = new AircraftStickMapping.Builder().mappingTarget(AircraftStickMappingTarget.ROLL).isReversed(false).build();
      return;
    }
    if (paramAircraftMappingStyle == AircraftMappingStyle.STYLE_3)
    {
      this.leftVertical = new AircraftStickMapping.Builder().mappingTarget(AircraftStickMappingTarget.PITCH).isReversed(false).build();
      this.leftHorizontal = new AircraftStickMapping.Builder().mappingTarget(AircraftStickMappingTarget.ROLL).isReversed(false).build();
      this.rightVertical = new AircraftStickMapping.Builder().mappingTarget(AircraftStickMappingTarget.THROTTLE).isReversed(false).build();
      this.rightHorizontal = new AircraftStickMapping.Builder().mappingTarget(AircraftStickMappingTarget.YAW).isReversed(false).build();
    }
  }
  
  public AircraftMapping(AircraftStickMapping paramAircraftStickMapping1, AircraftStickMapping paramAircraftStickMapping2, AircraftStickMapping paramAircraftStickMapping3, AircraftStickMapping paramAircraftStickMapping4)
  {
    this.aircraftMappingStyle = AircraftMappingStyle.STYLE_CUSTOM;
    this.leftVertical = paramAircraftStickMapping1;
    this.leftHorizontal = paramAircraftStickMapping2;
    this.rightVertical = paramAircraftStickMapping3;
    this.rightHorizontal = paramAircraftStickMapping4;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\AircraftMapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */