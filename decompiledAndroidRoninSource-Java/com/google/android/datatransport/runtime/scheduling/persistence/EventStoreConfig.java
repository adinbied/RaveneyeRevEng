package com.google.android.datatransport.runtime.scheduling.persistence;

abstract class EventStoreConfig
{
  static final EventStoreConfig DEFAULT = builder().setMaxStorageSizeInBytes(10485760L).setLoadBatchSize(200).setCriticalSectionEnterTimeoutMs(10000).setEventCleanUpAge(604800000L).setMaxBlobByteSizePerRow(81920).build();
  private static final long DURATION_ONE_WEEK_MS = 604800000L;
  private static final int LOAD_BATCH_SIZE = 200;
  private static final int LOCK_TIME_OUT_MS = 10000;
  private static final int MAX_BLOB_BYTE_SIZE_PER_ROW = 81920;
  private static final long MAX_DB_STORAGE_SIZE_IN_BYTES = 10485760L;
  
  static Builder builder()
  {
    return new AutoValue_EventStoreConfig.Builder();
  }
  
  abstract int getCriticalSectionEnterTimeoutMs();
  
  abstract long getEventCleanUpAge();
  
  abstract int getLoadBatchSize();
  
  abstract int getMaxBlobByteSizePerRow();
  
  abstract long getMaxStorageSizeInBytes();
  
  Builder toBuilder()
  {
    return builder().setMaxStorageSizeInBytes(getMaxStorageSizeInBytes()).setLoadBatchSize(getLoadBatchSize()).setCriticalSectionEnterTimeoutMs(getCriticalSectionEnterTimeoutMs()).setEventCleanUpAge(getEventCleanUpAge()).setMaxBlobByteSizePerRow(getMaxBlobByteSizePerRow());
  }
  
  static abstract class Builder
  {
    abstract EventStoreConfig build();
    
    abstract Builder setCriticalSectionEnterTimeoutMs(int paramInt);
    
    abstract Builder setEventCleanUpAge(long paramLong);
    
    abstract Builder setLoadBatchSize(int paramInt);
    
    abstract Builder setMaxBlobByteSizePerRow(int paramInt);
    
    abstract Builder setMaxStorageSizeInBytes(long paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\persistence\EventStoreConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */