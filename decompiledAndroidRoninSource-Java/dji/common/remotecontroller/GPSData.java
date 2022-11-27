package dji.common.remotecontroller;

public class GPSData
{
  private float eastSpeed;
  private boolean isValid;
  private GPSLocation location;
  private float locationAccuracy;
  private float northSpeed;
  private int satelliteCount;
  private Time time;
  
  private GPSData(Builder paramBuilder)
  {
    this.time = paramBuilder.time;
    this.eastSpeed = paramBuilder.eastSpeed;
    this.northSpeed = paramBuilder.northSpeed;
    this.location = paramBuilder.location;
    this.isValid = paramBuilder.isValid;
    this.locationAccuracy = paramBuilder.locationAccuracy;
    this.satelliteCount = paramBuilder.satelliteCount;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public float getEastSpeed()
  {
    return this.eastSpeed;
  }
  
  public GPSLocation getLocation()
  {
    return this.location;
  }
  
  public float getLocationAccuracy()
  {
    return this.locationAccuracy;
  }
  
  public float getNorthSpeed()
  {
    return this.northSpeed;
  }
  
  public int getSatelliteCount()
  {
    return this.satelliteCount;
  }
  
  public Time getTime()
  {
    return this.time;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isValid()
  {
    return this.isValid;
  }
  
  public static final class Builder
  {
    private float eastSpeed;
    private boolean isValid;
    private GPSData.GPSLocation location;
    private float locationAccuracy;
    private float northSpeed;
    private int satelliteCount;
    private GPSData.Time time;
    
    public GPSData build()
    {
      return new GPSData(this, null);
    }
    
    public Builder eastSpeed(float paramFloat)
    {
      this.eastSpeed = paramFloat;
      return this;
    }
    
    public Builder isValid(boolean paramBoolean)
    {
      this.isValid = paramBoolean;
      return this;
    }
    
    public Builder location(GPSData.GPSLocation paramGPSLocation)
    {
      this.location = paramGPSLocation;
      return this;
    }
    
    public Builder locationAccuracy(float paramFloat)
    {
      this.locationAccuracy = paramFloat;
      return this;
    }
    
    public Builder northSpeed(float paramFloat)
    {
      this.northSpeed = paramFloat;
      return this;
    }
    
    public Builder satelliteCount(int paramInt)
    {
      this.satelliteCount = paramInt;
      return this;
    }
    
    public Builder time(GPSData.Time paramTime)
    {
      this.time = paramTime;
      return this;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(GPSData paramGPSData);
  }
  
  public static class GPSLocation
  {
    private double latitude;
    private double longitude;
    
    public double getLatitude()
    {
      return this.latitude;
    }
    
    public double getLongitude()
    {
      return this.longitude;
    }
    
    public void setLatitude(double paramDouble)
    {
      this.latitude = paramDouble;
    }
    
    public void setLongitude(double paramDouble)
    {
      this.longitude = paramDouble;
    }
  }
  
  public static class Time
  {
    private byte day;
    private byte hour;
    private byte minute;
    private byte month;
    private byte second;
    private int year;
    
    private Time(Builder paramBuilder)
    {
      this.hour = paramBuilder.hour;
      this.minute = paramBuilder.minute;
      this.second = paramBuilder.second;
      this.year = paramBuilder.year;
      this.month = paramBuilder.month;
      this.day = paramBuilder.day;
    }
    
    public boolean equals(Object paramObject)
    {
      return false;
    }
    
    public byte getDay()
    {
      return this.day;
    }
    
    public byte getHour()
    {
      return this.hour;
    }
    
    public byte getMinute()
    {
      return this.minute;
    }
    
    public byte getMonth()
    {
      return this.month;
    }
    
    public byte getSecond()
    {
      return this.second;
    }
    
    public int getYear()
    {
      return this.year;
    }
    
    public int hashCode()
    {
      return 0;
    }
    
    public String toString()
    {
      return null;
    }
    
    public static final class Builder
    {
      private byte day;
      private byte hour;
      private byte minute;
      private byte month;
      private byte second;
      private int year;
      
      public GPSData.Time build()
      {
        return new GPSData.Time(this, null);
      }
      
      public Builder day(byte paramByte)
      {
        this.day = paramByte;
        return this;
      }
      
      public Builder hour(byte paramByte)
      {
        this.hour = paramByte;
        return this;
      }
      
      public Builder minute(byte paramByte)
      {
        this.minute = paramByte;
        return this;
      }
      
      public Builder month(byte paramByte)
      {
        this.month = paramByte;
        return this;
      }
      
      public Builder second(byte paramByte)
      {
        this.second = paramByte;
        return this;
      }
      
      public Builder year(int paramInt)
      {
        this.year = paramInt;
        return this;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\GPSData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */