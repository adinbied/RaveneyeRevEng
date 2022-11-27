package dji.midware.data.model.hg702;

public enum CaptureStatus
{
  private int data;
  
  static
  {
    CaptureStatus localCaptureStatus = new CaptureStatus("OTHER", 4, 7);
    OTHER = localCaptureStatus;
    $VALUES = new CaptureStatus[] { NO, START, STARTING, STOP, localCaptureStatus };
  }
  
  private CaptureStatus(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static CaptureStatus find(int paramInt)
  {
    CaptureStatus localCaptureStatus = OTHER;
    CaptureStatus[] arrayOfCaptureStatus = values();
    int i = 0;
    while (i < arrayOfCaptureStatus.length)
    {
      if (arrayOfCaptureStatus[i]._equals(paramInt)) {
        return arrayOfCaptureStatus[i];
      }
      i += 1;
    }
    return localCaptureStatus;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\hg702\CaptureStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */