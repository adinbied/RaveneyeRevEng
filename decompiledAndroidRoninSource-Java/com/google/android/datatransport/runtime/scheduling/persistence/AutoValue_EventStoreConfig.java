package com.google.android.datatransport.runtime.scheduling.persistence;

final class AutoValue_EventStoreConfig
  extends EventStoreConfig
{
  private final int criticalSectionEnterTimeoutMs;
  private final long eventCleanUpAge;
  private final int loadBatchSize;
  private final int maxBlobByteSizePerRow;
  private final long maxStorageSizeInBytes;
  
  private AutoValue_EventStoreConfig(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3)
  {
    this.maxStorageSizeInBytes = paramLong1;
    this.loadBatchSize = paramInt1;
    this.criticalSectionEnterTimeoutMs = paramInt2;
    this.eventCleanUpAge = paramLong2;
    this.maxBlobByteSizePerRow = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof EventStoreConfig))
    {
      paramObject = (EventStoreConfig)paramObject;
      return (this.maxStorageSizeInBytes == ((EventStoreConfig)paramObject).getMaxStorageSizeInBytes()) && (this.loadBatchSize == ((EventStoreConfig)paramObject).getLoadBatchSize()) && (this.criticalSectionEnterTimeoutMs == ((EventStoreConfig)paramObject).getCriticalSectionEnterTimeoutMs()) && (this.eventCleanUpAge == ((EventStoreConfig)paramObject).getEventCleanUpAge()) && (this.maxBlobByteSizePerRow == ((EventStoreConfig)paramObject).getMaxBlobByteSizePerRow());
    }
    return false;
  }
  
  int getCriticalSectionEnterTimeoutMs()
  {
    return this.criticalSectionEnterTimeoutMs;
  }
  
  long getEventCleanUpAge()
  {
    return this.eventCleanUpAge;
  }
  
  int getLoadBatchSize()
  {
    return this.loadBatchSize;
  }
  
  int getMaxBlobByteSizePerRow()
  {
    return this.maxBlobByteSizePerRow;
  }
  
  long getMaxStorageSizeInBytes()
  {
    return this.maxStorageSizeInBytes;
  }
  
  public int hashCode()
  {
    long l = this.maxStorageSizeInBytes;
    int i = (int)(l ^ l >>> 32);
    int j = this.loadBatchSize;
    int k = this.criticalSectionEnterTimeoutMs;
    l = this.eventCleanUpAge;
    int m = (int)(l >>> 32 ^ l);
    return this.maxBlobByteSizePerRow ^ ((((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ m) * 1000003;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EventStoreConfig{maxStorageSizeInBytes=");
    localStringBuilder.append(this.maxStorageSizeInBytes);
    localStringBuilder.append(", loadBatchSize=");
    localStringBuilder.append(this.loadBatchSize);
    localStringBuilder.append(", criticalSectionEnterTimeoutMs=");
    localStringBuilder.append(this.criticalSectionEnterTimeoutMs);
    localStringBuilder.append(", eventCleanUpAge=");
    localStringBuilder.append(this.eventCleanUpAge);
    localStringBuilder.append(", maxBlobByteSizePerRow=");
    localStringBuilder.append(this.maxBlobByteSizePerRow);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends EventStoreConfig.Builder
  {
    private Integer criticalSectionEnterTimeoutMs;
    private Long eventCleanUpAge;
    private Integer loadBatchSize;
    private Integer maxBlobByteSizePerRow;
    private Long maxStorageSizeInBytes;
    
    EventStoreConfig build()
    {
      Object localObject2 = this.maxStorageSizeInBytes;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" maxStorageSizeInBytes");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.loadBatchSize == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" loadBatchSize");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.criticalSectionEnterTimeoutMs == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" criticalSectionEnterTimeoutMs");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.eventCleanUpAge == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" eventCleanUpAge");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.maxBlobByteSizePerRow == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" maxBlobByteSizePerRow");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_EventStoreConfig(this.maxStorageSizeInBytes.longValue(), this.loadBatchSize.intValue(), this.criticalSectionEnterTimeoutMs.intValue(), this.eventCleanUpAge.longValue(), this.maxBlobByteSizePerRow.intValue(), null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    EventStoreConfig.Builder setCriticalSectionEnterTimeoutMs(int paramInt)
    {
      this.criticalSectionEnterTimeoutMs = Integer.valueOf(paramInt);
      return this;
    }
    
    EventStoreConfig.Builder setEventCleanUpAge(long paramLong)
    {
      this.eventCleanUpAge = Long.valueOf(paramLong);
      return this;
    }
    
    EventStoreConfig.Builder setLoadBatchSize(int paramInt)
    {
      this.loadBatchSize = Integer.valueOf(paramInt);
      return this;
    }
    
    EventStoreConfig.Builder setMaxBlobByteSizePerRow(int paramInt)
    {
      this.maxBlobByteSizePerRow = Integer.valueOf(paramInt);
      return this;
    }
    
    EventStoreConfig.Builder setMaxStorageSizeInBytes(long paramLong)
    {
      this.maxStorageSizeInBytes = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\persistence\AutoValue_EventStoreConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */