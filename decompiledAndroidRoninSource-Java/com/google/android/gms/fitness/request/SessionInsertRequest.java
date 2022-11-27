package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;
import com.google.android.gms.internal.fitness.zze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionInsertRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<SessionInsertRequest> CREATOR = new zzau();
  private static final TimeUnit zzhz = TimeUnit.MILLISECONDS;
  private final List<DataSet> zzaj;
  private final zzcq zzgj;
  private final List<DataPoint> zzia;
  private final Session zzz;
  
  SessionInsertRequest(Session paramSession, List<DataSet> paramList, List<DataPoint> paramList1, IBinder paramIBinder)
  {
    this.zzz = paramSession;
    this.zzaj = Collections.unmodifiableList(paramList);
    this.zzia = Collections.unmodifiableList(paramList1);
    this.zzgj = zzcr.zzj(paramIBinder);
  }
  
  private SessionInsertRequest(Session paramSession, List<DataSet> paramList, List<DataPoint> paramList1, zzcq paramzzcq)
  {
    this.zzz = paramSession;
    this.zzaj = Collections.unmodifiableList(paramList);
    this.zzia = Collections.unmodifiableList(paramList1);
    this.zzgj = paramzzcq;
  }
  
  private SessionInsertRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), null);
  }
  
  public SessionInsertRequest(SessionInsertRequest paramSessionInsertRequest, zzcq paramzzcq)
  {
    this(paramSessionInsertRequest.zzz, paramSessionInsertRequest.zzaj, paramSessionInsertRequest.zzia, paramzzcq);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof SessionInsertRequest))
      {
        paramObject = (SessionInsertRequest)paramObject;
        int i;
        if ((Objects.equal(this.zzz, ((SessionInsertRequest)paramObject).zzz)) && (Objects.equal(this.zzaj, ((SessionInsertRequest)paramObject).zzaj)) && (Objects.equal(this.zzia, ((SessionInsertRequest)paramObject).zzia))) {
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
  
  public List<DataPoint> getAggregateDataPoints()
  {
    return this.zzia;
  }
  
  public List<DataSet> getDataSets()
  {
    return this.zzaj;
  }
  
  public Session getSession()
  {
    return this.zzz;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzz, this.zzaj, this.zzia });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("session", this.zzz).add("dataSets", this.zzaj).add("aggregateDataPoints", this.zzia).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getSession(), paramInt, false);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getDataSets(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, getAggregateDataPoints(), false);
    Object localObject = this.zzgj;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzcq)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 4, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public static class Builder
  {
    private List<DataSet> zzaj = new ArrayList();
    private List<DataPoint> zzia = new ArrayList();
    private List<DataSource> zzib = new ArrayList();
    private Session zzz;
    
    private final void zzd(DataPoint paramDataPoint)
    {
      long l3 = this.zzz.getStartTime(TimeUnit.NANOSECONDS);
      long l4 = this.zzz.getEndTime(TimeUnit.NANOSECONDS);
      long l2 = paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS);
      long l1;
      boolean bool;
      if (l2 != 0L)
      {
        if (l2 >= l3)
        {
          l1 = l2;
          if (l2 <= l4) {}
        }
        else
        {
          l1 = zze.zza(l2, TimeUnit.NANOSECONDS, SessionInsertRequest.zzy());
        }
        if ((l1 >= l3) && (l1 <= l4)) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkState(bool, "Data point %s has time stamp outside session interval [%d, %d]", new Object[] { paramDataPoint, Long.valueOf(l3), Long.valueOf(l4) });
        if (paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS) != l1)
        {
          Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[] { Long.valueOf(paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS)), Long.valueOf(l1), SessionInsertRequest.zzy() }));
          paramDataPoint.setTimestamp(l1, TimeUnit.NANOSECONDS);
        }
      }
      l3 = this.zzz.getStartTime(TimeUnit.NANOSECONDS);
      l4 = this.zzz.getEndTime(TimeUnit.NANOSECONDS);
      long l5 = paramDataPoint.getStartTime(TimeUnit.NANOSECONDS);
      l2 = paramDataPoint.getEndTime(TimeUnit.NANOSECONDS);
      if ((l5 != 0L) && (l2 != 0L))
      {
        l1 = l2;
        if (l2 > l4) {
          l1 = zze.zza(l2, TimeUnit.NANOSECONDS, SessionInsertRequest.zzy());
        }
        if ((l5 >= l3) && (l1 <= l4)) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkState(bool, "Data point %s has start and end times outside session interval [%d, %d]", new Object[] { paramDataPoint, Long.valueOf(l3), Long.valueOf(l4) });
        if (l1 != paramDataPoint.getEndTime(TimeUnit.NANOSECONDS))
        {
          Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[] { Long.valueOf(paramDataPoint.getEndTime(TimeUnit.NANOSECONDS)), Long.valueOf(l1), SessionInsertRequest.zzy() }));
          paramDataPoint.setTimeInterval(l5, l1, TimeUnit.NANOSECONDS);
        }
      }
    }
    
    public Builder addAggregateDataPoint(DataPoint paramDataPoint)
    {
      boolean bool;
      if (paramDataPoint != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Must specify a valid aggregate data point.");
      DataSource localDataSource = paramDataPoint.getDataSource();
      Preconditions.checkState(this.zzib.contains(localDataSource) ^ true, "Data set/Aggregate data point for this data source %s is already added.", new Object[] { localDataSource });
      DataSet.zzb(paramDataPoint);
      this.zzib.add(localDataSource);
      this.zzia.add(paramDataPoint);
      return this;
    }
    
    public Builder addDataSet(DataSet paramDataSet)
    {
      boolean bool;
      if (paramDataSet != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Must specify a valid data set.");
      DataSource localDataSource = paramDataSet.getDataSource();
      Preconditions.checkState(this.zzib.contains(localDataSource) ^ true, "Data set for this data source %s is already added.", new Object[] { localDataSource });
      Preconditions.checkArgument(paramDataSet.getDataPoints().isEmpty() ^ true, "No data points specified in the input data set.");
      this.zzib.add(localDataSource);
      this.zzaj.add(paramDataSet);
      return this;
    }
    
    public SessionInsertRequest build()
    {
      Object localObject = this.zzz;
      boolean bool2 = true;
      boolean bool1;
      if (localObject != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Must specify a valid session.");
      if (this.zzz.getEndTime(TimeUnit.MILLISECONDS) != 0L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Must specify a valid end time, cannot insert a continuing session.");
      localObject = this.zzaj.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Iterator localIterator = ((DataSet)((Iterator)localObject).next()).getDataPoints().iterator();
        while (localIterator.hasNext()) {
          zzd((DataPoint)localIterator.next());
        }
      }
      localObject = this.zzia.iterator();
      while (((Iterator)localObject).hasNext()) {
        zzd((DataPoint)((Iterator)localObject).next());
      }
      return new SessionInsertRequest(this, null);
    }
    
    public Builder setSession(Session paramSession)
    {
      this.zzz = paramSession;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\SessionInsertRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */