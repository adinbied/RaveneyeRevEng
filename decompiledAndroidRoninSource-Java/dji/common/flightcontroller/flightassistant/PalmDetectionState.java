package dji.common.flightcontroller.flightassistant;

public enum PalmDetectionState
{
  private final int data;
  
  static
  {
    CONTROLLING = new PalmDetectionState("CONTROLLING", 2, 2);
    PalmDetectionState localPalmDetectionState = new PalmDetectionState("OTHER", 3, 100);
    OTHER = localPalmDetectionState;
    $VALUES = new PalmDetectionState[] { IDLE, RECOGNIZING, CONTROLLING, localPalmDetectionState };
  }
  
  private PalmDetectionState(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static PalmDetectionState find(int paramInt)
  {
    PalmDetectionState localPalmDetectionState1 = IDLE;
    PalmDetectionState[] arrayOfPalmDetectionState = values();
    int j = arrayOfPalmDetectionState.length;
    int i = 0;
    while (i < j)
    {
      PalmDetectionState localPalmDetectionState2 = arrayOfPalmDetectionState[i];
      if (localPalmDetectionState2._equals(paramInt)) {
        return localPalmDetectionState2;
      }
      i += 1;
    }
    return localPalmDetectionState1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\flightassistant\PalmDetectionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */