package dji.common.camera;

public enum SSDOperationState
{
  private int value;
  
  static
  {
    FORMATTING = new SSDOperationState("FORMATTING", 2, 4);
    INITIALIZING = new SSDOperationState("INITIALIZING", 3, 5);
    ERROR = new SSDOperationState("ERROR", 4, 7);
    FULL = new SSDOperationState("FULL", 5, 8);
    POOR_CONNECTION = new SSDOperationState("POOR_CONNECTION", 6, 9);
    SWITCHING_LICENSE = new SSDOperationState("SWITCHING_LICENSE", 7, 10);
    FORMATTING_REQUIRED = new SSDOperationState("FORMATTING_REQUIRED", 8, 11);
    NOT_FOUND = new SSDOperationState("NOT_FOUND", 9, 12);
    SSDOperationState localSSDOperationState = new SSDOperationState("UNKNOWN", 10, 255);
    UNKNOWN = localSSDOperationState;
    $VALUES = new SSDOperationState[] { IDLE, SAVING, FORMATTING, INITIALIZING, ERROR, FULL, POOR_CONNECTION, SWITCHING_LICENSE, FORMATTING_REQUIRED, NOT_FOUND, localSSDOperationState };
  }
  
  private SSDOperationState(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static SSDOperationState find(int paramInt)
  {
    SSDOperationState localSSDOperationState2 = UNKNOWN;
    int i = 0;
    SSDOperationState localSSDOperationState1;
    for (;;)
    {
      localSSDOperationState1 = localSSDOperationState2;
      if (i >= values().length) {
        break;
      }
      if (values()[i]._equals(paramInt))
      {
        localSSDOperationState1 = values()[i];
        break;
      }
      i += 1;
    }
    if (paramInt == 0) {
      return UNKNOWN;
    }
    if (paramInt == 6) {
      return ERROR;
    }
    return localSSDOperationState1;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\SSDOperationState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */