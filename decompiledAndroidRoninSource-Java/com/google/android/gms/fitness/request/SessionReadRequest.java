package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzck;
import com.google.android.gms.internal.fitness.zzcl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<SessionReadRequest> CREATOR = new zzaw();
  private final List<DataType> zzah;
  private final List<DataSource> zzgm;
  private final boolean zzgw;
  private final String zzic;
  private final String zzid;
  private boolean zzie;
  private final List<String> zzif;
  private final zzck zzig;
  private final long zzs;
  private final long zzt;
  
  private SessionReadRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder), Builder.zze(paramBuilder), Builder.zzf(paramBuilder), Builder.zzg(paramBuilder), Builder.zzh(paramBuilder), Builder.zzi(paramBuilder), null);
  }
  
  public SessionReadRequest(SessionReadRequest paramSessionReadRequest, zzck paramzzck)
  {
    this(paramSessionReadRequest.zzic, paramSessionReadRequest.zzid, paramSessionReadRequest.zzs, paramSessionReadRequest.zzt, paramSessionReadRequest.zzah, paramSessionReadRequest.zzgm, paramSessionReadRequest.zzie, paramSessionReadRequest.zzgw, paramSessionReadRequest.zzif, paramzzck);
  }
  
  SessionReadRequest(String paramString1, String paramString2, long paramLong1, long paramLong2, List<DataType> paramList, List<DataSource> paramList1, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList2, IBinder paramIBinder)
  {
    this.zzic = paramString1;
    this.zzid = paramString2;
    this.zzs = paramLong1;
    this.zzt = paramLong2;
    this.zzah = paramList;
    this.zzgm = paramList1;
    this.zzie = paramBoolean1;
    this.zzgw = paramBoolean2;
    this.zzif = paramList2;
    this.zzig = zzcl.zzh(paramIBinder);
  }
  
  private SessionReadRequest(String paramString1, String paramString2, long paramLong1, long paramLong2, List<DataType> paramList, List<DataSource> paramList1, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList2, zzck paramzzck)
  {
    this(paramString1, paramString2, paramLong1, paramLong2, paramList, paramList1, paramBoolean1, paramBoolean2, paramList2, paramzzck);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof SessionReadRequest))
      {
        paramObject = (SessionReadRequest)paramObject;
        int i;
        if ((Objects.equal(this.zzic, ((SessionReadRequest)paramObject).zzic)) && (this.zzid.equals(((SessionReadRequest)paramObject).zzid)) && (this.zzs == ((SessionReadRequest)paramObject).zzs) && (this.zzt == ((SessionReadRequest)paramObject).zzt) && (Objects.equal(this.zzah, ((SessionReadRequest)paramObject).zzah)) && (Objects.equal(this.zzgm, ((SessionReadRequest)paramObject).zzgm)) && (this.zzie == ((SessionReadRequest)paramObject).zzie) && (this.zzif.equals(((SessionReadRequest)paramObject).zzif)) && (this.zzgw == ((SessionReadRequest)paramObject).zzgw)) {
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
  
  public List<DataSource> getDataSources()
  {
    return this.zzgm;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.zzah;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzt, TimeUnit.MILLISECONDS);
  }
  
  public List<String> getExcludedPackages()
  {
    return this.zzif;
  }
  
  public String getSessionId()
  {
    return this.zzid;
  }
  
  public String getSessionName()
  {
    return this.zzic;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzs, TimeUnit.MILLISECONDS);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzic, this.zzid, Long.valueOf(this.zzs), Long.valueOf(this.zzt) });
  }
  
  public boolean includeSessionsFromAllApps()
  {
    return this.zzie;
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("sessionName", this.zzic).add("sessionId", this.zzid).add("startTimeMillis", Long.valueOf(this.zzs)).add("endTimeMillis", Long.valueOf(this.zzt)).add("dataTypes", this.zzah).add("dataSources", this.zzgm).add("sessionsFromAllApps", Boolean.valueOf(this.zzie)).add("excludedPackages", this.zzif).add("useServer", Boolean.valueOf(this.zzgw)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getSessionName(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getSessionId(), false);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzs);
    SafeParcelWriter.writeLong(paramParcel, 4, this.zzt);
    SafeParcelWriter.writeTypedList(paramParcel, 5, getDataTypes(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 6, getDataSources(), false);
    SafeParcelWriter.writeBoolean(paramParcel, 7, includeSessionsFromAllApps());
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzgw);
    SafeParcelWriter.writeStringList(paramParcel, 9, getExcludedPackages(), false);
    Object localObject = this.zzig;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzck)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 10, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private List<DataType> zzah = new ArrayList();
    private List<DataSource> zzgm = new ArrayList();
    private boolean zzgw = false;
    private String zzic;
    private String zzid;
    private List<String> zzif = new ArrayList();
    private boolean zzih = false;
    private long zzs = 0L;
    private long zzt = 0L;
    
    public SessionReadRequest build()
    {
      boolean bool;
      if (this.zzs > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid start time: %s", new Object[] { Long.valueOf(this.zzs) });
      long l = this.zzt;
      if ((l > 0L) && (l > this.zzs)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid end time: %s", new Object[] { Long.valueOf(this.zzt) });
      return new SessionReadRequest(this, null);
    }
    
    public Builder enableServerQueries()
    {
      this.zzgw = true;
      return this;
    }
    
    public Builder excludePackage(String paramString)
    {
      Preconditions.checkNotNull(paramString, "Attempting to use a null package name");
      if (!this.zzif.contains(paramString)) {
        this.zzif.add(paramString);
      }
      return this;
    }
    
    public Builder read(DataSource paramDataSource)
    {
      Preconditions.checkNotNull(paramDataSource, "Attempting to add a null data source");
      if (!this.zzgm.contains(paramDataSource)) {
        this.zzgm.add(paramDataSource);
      }
      return this;
    }
    
    public Builder read(DataType paramDataType)
    {
      Preconditions.checkNotNull(paramDataType, "Attempting to use a null data type");
      if (!this.zzah.contains(paramDataType)) {
        this.zzah.add(paramDataType);
      }
      return this;
    }
    
    public Builder readSessionsFromAllApps()
    {
      this.zzih = true;
      return this;
    }
    
    public Builder setSessionId(String paramString)
    {
      this.zzid = paramString;
      return this;
    }
    
    public Builder setSessionName(String paramString)
    {
      this.zzic = paramString;
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      this.zzs = paramTimeUnit.toMillis(paramLong1);
      this.zzt = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\SessionReadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */