package dji.common.mission.activetrack;

public enum ActiveTrackTargetType
{
  static
  {
    CAR = new ActiveTrackTargetType("CAR", 1);
    VAN = new ActiveTrackTargetType("VAN", 2);
    BIKE = new ActiveTrackTargetType("BIKE", 3);
    BOAT = new ActiveTrackTargetType("BOAT", 4);
    ActiveTrackTargetType localActiveTrackTargetType = new ActiveTrackTargetType("UNKNOWN", 5);
    UNKNOWN = localActiveTrackTargetType;
    $VALUES = new ActiveTrackTargetType[] { HUMAN, CAR, VAN, BIKE, BOAT, localActiveTrackTargetType };
  }
  
  private ActiveTrackTargetType() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\activetrack\ActiveTrackTargetType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */