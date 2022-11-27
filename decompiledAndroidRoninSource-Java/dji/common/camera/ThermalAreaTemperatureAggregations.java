package dji.common.camera;

import android.graphics.Point;

public class ThermalAreaTemperatureAggregations
{
  private float averageTemperature;
  private float maxTemperature;
  private Point maxTemperaturePosition;
  private float minTemperature;
  private Point minTemperaturePosition;
  
  public ThermalAreaTemperatureAggregations(float paramFloat1, float paramFloat2, Point paramPoint1, float paramFloat3, Point paramPoint2)
  {
    this.averageTemperature = paramFloat1;
    this.minTemperature = paramFloat2;
    this.maxTemperature = paramFloat3;
    this.minTemperaturePosition = paramPoint1;
    this.maxTemperaturePosition = paramPoint2;
  }
  
  public float getAverageAreaTemperature()
  {
    return this.averageTemperature;
  }
  
  public float getMaxAreaTemperature()
  {
    return this.maxTemperature;
  }
  
  public Point getMaxTemperaturePoint()
  {
    return this.maxTemperaturePosition;
  }
  
  public float getMinAreaTemperature()
  {
    return this.minTemperature;
  }
  
  public Point getMinTemperaturePoint()
  {
    return this.minTemperaturePosition;
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(ThermalAreaTemperatureAggregations paramThermalAreaTemperatureAggregations);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\ThermalAreaTemperatureAggregations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */