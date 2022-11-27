package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.fitness.zzfa;
import java.util.concurrent.TimeUnit;

public class Session
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Session> CREATOR = new zzad();
  public static final String EXTRA_SESSION = "vnd.google.fitness.session";
  public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
  private final String description;
  private final String name;
  private final int zzai;
  private final zzb zzay;
  private final String zzdz;
  private final Long zzea;
  private final long zzs;
  private final long zzt;
  
  public Session(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt, zzb paramzzb, Long paramLong)
  {
    this.zzs = paramLong1;
    this.zzt = paramLong2;
    this.name = paramString1;
    this.zzdz = paramString2;
    this.description = paramString3;
    this.zzai = paramInt;
    this.zzay = paramzzb;
    this.zzea = paramLong;
  }
  
  private Session(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder), Builder.zze(paramBuilder), Builder.zzf(paramBuilder), null, Builder.zzg(paramBuilder));
  }
  
  public static Session extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (Session)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "vnd.google.fitness.session", CREATOR);
  }
  
  public static String getMimeType(String paramString)
  {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      return "vnd.google.fitness.session/".concat(paramString);
    }
    return new String("vnd.google.fitness.session/");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Session)) {
      return false;
    }
    paramObject = (Session)paramObject;
    return (this.zzs == ((Session)paramObject).zzs) && (this.zzt == ((Session)paramObject).zzt) && (Objects.equal(this.name, ((Session)paramObject).name)) && (Objects.equal(this.zzdz, ((Session)paramObject).zzdz)) && (Objects.equal(this.description, ((Session)paramObject).description)) && (Objects.equal(this.zzay, ((Session)paramObject).zzay)) && (this.zzai == ((Session)paramObject).zzai);
  }
  
  public long getActiveTime(TimeUnit paramTimeUnit)
  {
    boolean bool;
    if (this.zzea != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Active time is not set");
    return paramTimeUnit.convert(this.zzea.longValue(), TimeUnit.MILLISECONDS);
  }
  
  public String getActivity()
  {
    return zzfa.getName(this.zzai);
  }
  
  public String getAppPackageName()
  {
    zzb localzzb = this.zzay;
    if (localzzb == null) {
      return null;
    }
    return localzzb.getPackageName();
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzt, TimeUnit.MILLISECONDS);
  }
  
  public String getIdentifier()
  {
    return this.zzdz;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzs, TimeUnit.MILLISECONDS);
  }
  
  public boolean hasActiveTime()
  {
    return this.zzea != null;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(this.zzs), Long.valueOf(this.zzt), this.zzdz });
  }
  
  public boolean isOngoing()
  {
    return this.zzt == 0L;
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("startTime", Long.valueOf(this.zzs)).add("endTime", Long.valueOf(this.zzt)).add("name", this.name).add("identifier", this.zzdz).add("description", this.description).add("activity", Integer.valueOf(this.zzai)).add("application", this.zzay).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, this.zzs);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzt);
    SafeParcelWriter.writeString(paramParcel, 3, getName(), false);
    SafeParcelWriter.writeString(paramParcel, 4, getIdentifier(), false);
    SafeParcelWriter.writeString(paramParcel, 5, getDescription(), false);
    SafeParcelWriter.writeInt(paramParcel, 7, this.zzai);
    SafeParcelWriter.writeParcelable(paramParcel, 8, this.zzay, paramInt, false);
    SafeParcelWriter.writeLongObject(paramParcel, 9, this.zzea, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public static class Builder
  {
    private String description = "";
    private String name = null;
    private int zzai = 4;
    private String zzdz = null;
    private Long zzea;
    private long zzs = 0L;
    private long zzt = 0L;
    
    public Session build()
    {
      long l = this.zzs;
      boolean bool2 = true;
      if (l > 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Start time should be specified.");
      l = this.zzt;
      boolean bool1 = bool2;
      if (l != 0L) {
        if (l > this.zzs) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      Preconditions.checkState(bool1, "End time should be later than start time.");
      if (this.zzdz == null)
      {
        Object localObject2 = this.name;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        l = this.zzs;
        localObject2 = new StringBuilder(String.valueOf(localObject1).length() + 20);
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(l);
        this.zzdz = ((StringBuilder)localObject2).toString();
      }
      return new Session(this, null);
    }
    
    public Builder setActiveTime(long paramLong, TimeUnit paramTimeUnit)
    {
      this.zzea = Long.valueOf(paramTimeUnit.toMillis(paramLong));
      return this;
    }
    
    public Builder setActivity(String paramString)
    {
      this.zzai = zzfa.zzl(paramString);
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      boolean bool;
      if (paramString.length() <= 1000) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Session description cannot exceed %d characters", new Object[] { Integer.valueOf(1000) });
      this.description = paramString;
      return this;
    }
    
    public Builder setEndTime(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (paramLong >= 0L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "End time should be positive.");
      this.zzt = paramTimeUnit.toMillis(paramLong);
      return this;
    }
    
    public Builder setIdentifier(String paramString)
    {
      boolean bool;
      if ((paramString != null) && (TextUtils.getTrimmedLength(paramString) > 0)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool);
      this.zzdz = paramString;
      return this;
    }
    
    public Builder setName(String paramString)
    {
      boolean bool;
      if (paramString.length() <= 100) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Session name cannot exceed %d characters", new Object[] { Integer.valueOf(100) });
      this.name = paramString;
      return this;
    }
    
    public Builder setStartTime(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (paramLong > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Start time should be positive.");
      this.zzs = paramTimeUnit.toMillis(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\Session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */