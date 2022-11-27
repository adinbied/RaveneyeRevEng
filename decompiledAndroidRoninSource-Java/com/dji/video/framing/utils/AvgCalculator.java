package com.dji.video.framing.utils;

import java.util.concurrent.ArrayBlockingQueue;

public class AvgCalculator
{
  private static final String TAG = "AvgCalculator";
  private double currentAvg = 0.0D;
  private ArrayBlockingQueue<Number> dataQueue;
  private long firstInputTime = 0L;
  private long lastInputTime = 0L;
  private int maxCalcNum;
  private long maxCalcTimeInMs;
  private boolean needRemoveLast = false;
  private double validValMax;
  private double validValMin;
  
  public AvgCalculator(double paramDouble1, double paramDouble2, int paramInt)
  {
    this.validValMin = paramDouble1;
    this.validValMax = paramDouble2;
    this.maxCalcNum = paramInt;
    this.dataQueue = new ArrayBlockingQueue(paramInt + 1);
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void feedData(double arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public double getAvgValue()
  {
    return this.currentAvg;
  }
  
  public int getCalcNum()
  {
    return this.dataQueue.size();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\AvgCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */