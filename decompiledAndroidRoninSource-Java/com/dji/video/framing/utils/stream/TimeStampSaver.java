package com.dji.video.framing.utils.stream;

import java.util.LinkedList;

public class TimeStampSaver
{
  private Object dataLock = new Object();
  private LinkedList<Long> keyList = new LinkedList();
  private TimeStampSavingManager.TimeStampSavePoint savePoint = TimeStampSavingManager.TimeStampSavePoint.Unknown;
  private LinkedList<Long> timeStampList = new LinkedList();
  
  public TimeStampSaver(TimeStampSavingManager.TimeStampSavePoint paramTimeStampSavePoint)
  {
    this.savePoint = paramTimeStampSavePoint;
  }
  
  public TimeStampSaverData fetchData()
  {
    return null;
  }
  
  /* Error */
  public void saveTimeStamp(long arg1, long arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: return
  }
  
  public static class TimeStampSaverData
  {
    public TimeStampSavingManager.TimeStampSavePoint savePoint;
    public Long[] timeStamps;
    public Long[] trackKeys;
    
    public TimeStampSaverData(TimeStampSavingManager.TimeStampSavePoint paramTimeStampSavePoint, Long[] paramArrayOfLong1, Long[] paramArrayOfLong2)
    {
      this.savePoint = paramTimeStampSavePoint;
      this.trackKeys = paramArrayOfLong1;
      this.timeStamps = paramArrayOfLong2;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\stream\TimeStampSaver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */