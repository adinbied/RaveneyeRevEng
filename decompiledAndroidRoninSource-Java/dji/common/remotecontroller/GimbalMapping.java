package dji.common.remotecontroller;

public class GimbalMapping
{
  public GimbalMappingStyle gimbalMappingStyle = GimbalMappingStyle.CUSTOM;
  public GimbalStickMapping leftHorizontal;
  public GimbalStickMapping leftVertical;
  public GimbalStickMapping rightHorizontal;
  public GimbalStickMapping rightVertical;
  
  public GimbalMapping()
  {
    this.leftVertical = new GimbalStickMapping.Builder().mappingTarget(GimbalStickMappingTarget.NONE).isReversed(false).build();
    this.leftHorizontal = new GimbalStickMapping.Builder().mappingTarget(GimbalStickMappingTarget.PITCH).isReversed(false).build();
    this.rightVertical = new GimbalStickMapping.Builder().mappingTarget(GimbalStickMappingTarget.YAW).isReversed(false).build();
    this.rightHorizontal = new GimbalStickMapping.Builder().mappingTarget(GimbalStickMappingTarget.NONE).isReversed(false).build();
  }
  
  public GimbalMapping(GimbalStickMapping paramGimbalStickMapping1, GimbalStickMapping paramGimbalStickMapping2, GimbalStickMapping paramGimbalStickMapping3, GimbalStickMapping paramGimbalStickMapping4)
  {
    this.leftVertical = paramGimbalStickMapping1;
    this.leftHorizontal = paramGimbalStickMapping2;
    this.rightVertical = paramGimbalStickMapping3;
    this.rightHorizontal = paramGimbalStickMapping4;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\GimbalMapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */