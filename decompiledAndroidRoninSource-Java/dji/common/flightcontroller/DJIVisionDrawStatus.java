package dji.common.flightcontroller;

public enum DJIVisionDrawStatus
{
  private final int data;
  
  static
  {
    PAUSE = new DJIVisionDrawStatus("PAUSE", 5, 5);
    DJIVisionDrawStatus localDJIVisionDrawStatus = new DJIVisionDrawStatus("OTHER", 6, 100);
    OTHER = localDJIVisionDrawStatus;
    $VALUES = new DJIVisionDrawStatus[] { INIT, PREPARE, READY_TO_GO, START_AUTO, START_MANUAL, PAUSE, localDJIVisionDrawStatus };
  }
  
  private DJIVisionDrawStatus(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static DJIVisionDrawStatus find(int paramInt)
  {
    DJIVisionDrawStatus localDJIVisionDrawStatus1 = INIT;
    DJIVisionDrawStatus[] arrayOfDJIVisionDrawStatus = values();
    int j = arrayOfDJIVisionDrawStatus.length;
    int i = 0;
    while (i < j)
    {
      DJIVisionDrawStatus localDJIVisionDrawStatus2 = arrayOfDJIVisionDrawStatus[i];
      if (localDJIVisionDrawStatus2._equals(paramInt)) {
        return localDJIVisionDrawStatus2;
      }
      i += 1;
    }
    return localDJIVisionDrawStatus1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\DJIVisionDrawStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */