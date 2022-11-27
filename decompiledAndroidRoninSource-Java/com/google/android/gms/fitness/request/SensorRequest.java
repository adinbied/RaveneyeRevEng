package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest
{
  public static final int ACCURACY_MODE_DEFAULT = 2;
  public static final int ACCURACY_MODE_HIGH = 3;
  public static final int ACCURACY_MODE_LOW = 1;
  private final long zzec;
  private final int zzed;
  private final long zzhs;
  private final long zzht;
  private final long zzhx;
  private final DataType zzq;
  private final DataSource zzr;
  
  private SensorRequest(DataSource paramDataSource, LocationRequest paramLocationRequest)
  {
    this.zzec = TimeUnit.MILLISECONDS.toMicros(paramLocationRequest.getInterval());
    this.zzht = TimeUnit.MILLISECONDS.toMicros(paramLocationRequest.getFastestInterval());
    this.zzhs = this.zzec;
    this.zzq = paramDataSource.getDataType();
    int i = paramLocationRequest.getPriority();
    if (i != 100)
    {
      if (i != 104) {
        i = 2;
      } else {
        i = 1;
      }
    }
    else {
      i = 3;
    }
    this.zzed = i;
    this.zzr = paramDataSource;
    long l = paramLocationRequest.getExpirationTime();
    if (l == Long.MAX_VALUE)
    {
      this.zzhx = Long.MAX_VALUE;
      return;
    }
    this.zzhx = TimeUnit.MILLISECONDS.toMicros(l - SystemClock.elapsedRealtime());
  }
  
  private SensorRequest(Builder paramBuilder)
  {
    this.zzr = Builder.zza(paramBuilder);
    this.zzq = Builder.zzb(paramBuilder);
    this.zzec = Builder.zzc(paramBuilder);
    this.zzht = Builder.zzd(paramBuilder);
    this.zzhs = Builder.zze(paramBuilder);
    this.zzed = Builder.zzf(paramBuilder);
    this.zzhx = Builder.zzg(paramBuilder);
  }
  
  @Deprecated
  public static SensorRequest fromLocationRequest(DataSource paramDataSource, LocationRequest paramLocationRequest)
  {
    return new SensorRequest(paramDataSource, paramLocationRequest);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof SensorRequest))
      {
        paramObject = (SensorRequest)paramObject;
        int i;
        if ((Objects.equal(this.zzr, ((SensorRequest)paramObject).zzr)) && (Objects.equal(this.zzq, ((SensorRequest)paramObject).zzq)) && (this.zzec == ((SensorRequest)paramObject).zzec) && (this.zzht == ((SensorRequest)paramObject).zzht) && (this.zzhs == ((SensorRequest)paramObject).zzhs) && (this.zzed == ((SensorRequest)paramObject).zzed) && (this.zzhx == ((SensorRequest)paramObject).zzhx)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public int getAccuracyMode()
  {
    return this.zzed;
  }
  
  public DataSource getDataSource()
  {
    return this.zzr;
  }
  
  public DataType getDataType()
  {
    return this.zzq;
  }
  
  public long getFastestRate(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzht, TimeUnit.MICROSECONDS);
  }
  
  public long getMaxDeliveryLatency(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzhs, TimeUnit.MICROSECONDS);
  }
  
  public long getSamplingRate(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzec, TimeUnit.MICROSECONDS);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzr, this.zzq, Long.valueOf(this.zzec), Long.valueOf(this.zzht), Long.valueOf(this.zzhs), Integer.valueOf(this.zzed), Long.valueOf(this.zzhx) });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("dataSource", this.zzr).add("dataType", this.zzq).add("samplingRateMicros", Long.valueOf(this.zzec)).add("deliveryLatencyMicros", Long.valueOf(this.zzhs)).add("timeOutMicros", Long.valueOf(this.zzhx)).toString();
  }
  
  public final long zzx()
  {
    return this.zzhx;
  }
  
  public static class Builder
  {
    private long zzec = -1L;
    private int zzed = 2;
    private long zzhs = 0L;
    private long zzht = 0L;
    private long zzhx = Long.MAX_VALUE;
    private boolean zzhy = false;
    private DataType zzq;
    private DataSource zzr;
    
    public SensorRequest build()
    {
      Object localObject = this.zzr;
      boolean bool2 = false;
      if ((localObject == null) && (this.zzq == null)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      Preconditions.checkState(bool1, "Must call setDataSource() or setDataType()");
      localObject = this.zzq;
      if (localObject != null)
      {
        DataSource localDataSource = this.zzr;
        if (localDataSource != null)
        {
          bool1 = bool2;
          if (!((DataType)localObject).equals(localDataSource.getDataType())) {
            break label70;
          }
        }
      }
      boolean bool1 = true;
      label70:
      Preconditions.checkState(bool1, "Specified data type is incompatible with specified data source");
      return new SensorRequest(this, null);
    }
    
    public Builder setAccuracyMode(int paramInt)
    {
      int i = paramInt;
      if (paramInt != 1)
      {
        i = paramInt;
        if (paramInt != 3) {
          i = 2;
        }
      }
      this.zzed = i;
      return this;
    }
    
    public Builder setDataSource(DataSource paramDataSource)
    {
      this.zzr = paramDataSource;
      return this;
    }
    
    public Builder setDataType(DataType paramDataType)
    {
      this.zzq = paramDataType;
      return this;
    }
    
    public Builder setFastestRate(int paramInt, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (paramInt >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Cannot use a negative interval");
      this.zzhy = true;
      this.zzht = paramTimeUnit.toMicros(paramInt);
      return this;
    }
    
    public Builder setMaxDeliveryLatency(int paramInt, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (paramInt >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Cannot use a negative delivery interval");
      this.zzhs = paramTimeUnit.toMicros(paramInt);
      return this;
    }
    
    public Builder setSamplingRate(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (paramLong >= 0L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Cannot use a negative sampling interval");
      paramLong = paramTimeUnit.toMicros(paramLong);
      this.zzec = paramLong;
      if (!this.zzhy) {
        this.zzht = (paramLong / 2L);
      }
      return this;
    }
    
    public Builder setTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool2 = true;
      boolean bool1;
      if (paramLong > 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Invalid time out value specified: %d", new Object[] { Long.valueOf(paramLong) });
      if (paramTimeUnit != null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Invalid time unit specified");
      this.zzhx = paramTimeUnit.toMicros(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\SensorRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */