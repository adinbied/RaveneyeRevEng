package dji.sdksharedlib.store;

public class DJISDKCacheParamValue
{
  private static final String TAG = "DJISDKCacheParamValue";
  private long createdAt;
  private Object data;
  private long expireDurationInMillis = -1L;
  private Source source;
  private Status status;
  
  @Deprecated
  public DJISDKCacheParamValue(Object paramObject)
  {
    this.data = paramObject;
  }
  
  public DJISDKCacheParamValue(Object paramObject, Status paramStatus, Source paramSource)
  {
    this.data = paramObject;
    this.status = paramStatus;
    this.source = paramSource;
    this.createdAt = System.currentTimeMillis();
  }
  
  public DJISDKCacheParamValue(Object paramObject, Status paramStatus, Source paramSource, long paramLong)
  {
    this.data = paramObject;
    this.status = paramStatus;
    this.source = paramSource;
    this.createdAt = System.currentTimeMillis();
    this.expireDurationInMillis = paramLong;
  }
  
  private boolean arrayEquals(Object paramObject1, Object paramObject2)
  {
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public long getCreatedAt()
  {
    return this.createdAt;
  }
  
  public Object getData()
  {
    return this.data;
  }
  
  public long getExpireDurationInMillis()
  {
    return this.expireDurationInMillis;
  }
  
  public Source getSource()
  {
    return this.source;
  }
  
  public boolean isDataEquals(Object paramObject)
  {
    return false;
  }
  
  public boolean isValid()
  {
    return false;
  }
  
  public void updateCreatedAt()
  {
    this.createdAt = System.currentTimeMillis();
  }
  
  public static enum Source
  {
    static
    {
      Get = new Source("Get", 1);
      Source localSource = new Source("Set", 2);
      Set = localSource;
      $VALUES = new Source[] { Push, Get, localSource };
    }
    
    private Source() {}
  }
  
  public static enum Status
  {
    static
    {
      Status localStatus = new Status("Conflicted", 2);
      Conflicted = localStatus;
      $VALUES = new Status[] { Empty, Valid, localStatus };
    }
    
    private Status() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\store\DJISDKCacheParamValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */