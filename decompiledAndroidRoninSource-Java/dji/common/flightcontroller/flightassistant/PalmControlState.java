package dji.common.flightcontroller.flightassistant;

public enum PalmControlState
{
  private final int data;
  
  static
  {
    GO_BACK_SUCCESS = new PalmControlState("GO_BACK_SUCCESS", 1, 1);
    GO_BACK_IN_PROGRESS = new PalmControlState("GO_BACK_IN_PROGRESS", 2, 2);
    MOVING = new PalmControlState("MOVING", 3, 3);
    RELEASE_CONTROL_BY_JOYSTICK = new PalmControlState("RELEASE_CONTROL_BY_JOYSTICK", 4, 4);
    PalmControlState localPalmControlState = new PalmControlState("OTHER", 5, 100);
    OTHER = localPalmControlState;
    $VALUES = new PalmControlState[] { NONE, GO_BACK_SUCCESS, GO_BACK_IN_PROGRESS, MOVING, RELEASE_CONTROL_BY_JOYSTICK, localPalmControlState };
  }
  
  private PalmControlState(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static PalmControlState find(int paramInt)
  {
    PalmControlState localPalmControlState1 = NONE;
    PalmControlState[] arrayOfPalmControlState = values();
    int j = arrayOfPalmControlState.length;
    int i = 0;
    while (i < j)
    {
      PalmControlState localPalmControlState2 = arrayOfPalmControlState[i];
      if (localPalmControlState2._equals(paramInt)) {
        return localPalmControlState2;
      }
      i += 1;
    }
    return localPalmControlState1;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\flightassistant\PalmControlState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */