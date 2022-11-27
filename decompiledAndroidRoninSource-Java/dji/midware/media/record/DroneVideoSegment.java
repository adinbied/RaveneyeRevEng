package dji.midware.media.record;

import dji.midware.media.DJIVideoUtil;

public class DroneVideoSegment
{
  public static final int rectify = (int)(120.0D / DJIVideoUtil.getFPS() * 1000.0D - DJIVideoUtil.Midea_Signal_Delay_MSec);
  private final int endTime;
  private final int startTime;
  
  public DroneVideoSegment(int paramInt1, int paramInt2)
  {
    int i = rectify;
    this.startTime = (paramInt1 + i);
    this.endTime = (paramInt2 + i);
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int getEndTime()
  {
    return this.endTime;
  }
  
  public int getStartTime()
  {
    return this.startTime;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\record\DroneVideoSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */