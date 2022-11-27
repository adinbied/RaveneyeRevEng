package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzfa;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Goal
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Goal> CREATOR = new zzs();
  public static final int OBJECTIVE_TYPE_DURATION = 2;
  public static final int OBJECTIVE_TYPE_FREQUENCY = 3;
  public static final int OBJECTIVE_TYPE_METRIC = 1;
  private final long zzdj;
  private final long zzdk;
  private final List<Integer> zzdl;
  private final Recurrence zzdm;
  private final int zzdn;
  private final MetricObjective zzdo;
  private final DurationObjective zzdp;
  private final FrequencyObjective zzdq;
  
  Goal(long paramLong1, long paramLong2, List<Integer> paramList, Recurrence paramRecurrence, int paramInt, MetricObjective paramMetricObjective, DurationObjective paramDurationObjective, FrequencyObjective paramFrequencyObjective)
  {
    this.zzdj = paramLong1;
    this.zzdk = paramLong2;
    this.zzdl = paramList;
    this.zzdm = paramRecurrence;
    this.zzdn = paramInt;
    this.zzdo = paramMetricObjective;
    this.zzdp = paramDurationObjective;
    this.zzdq = paramFrequencyObjective;
  }
  
  private static String zze(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            return "frequency";
          }
          throw new IllegalArgumentException("invalid objective type value");
        }
        return "duration";
      }
      return "metric";
    }
    return "unknown";
  }
  
  private final void zzf(int paramInt)
    throws Goal.MismatchedGoalException
  {
    if (paramInt == this.zzdn) {
      return;
    }
    throw new MismatchedGoalException(String.format("%s goal does not have %s objective", new Object[] { zze(this.zzdn), zze(paramInt) }));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Goal)) {
      return false;
    }
    paramObject = (Goal)paramObject;
    return (this.zzdj == ((Goal)paramObject).zzdj) && (this.zzdk == ((Goal)paramObject).zzdk) && (Objects.equal(this.zzdl, ((Goal)paramObject).zzdl)) && (Objects.equal(this.zzdm, ((Goal)paramObject).zzdm)) && (this.zzdn == ((Goal)paramObject).zzdn) && (Objects.equal(this.zzdo, ((Goal)paramObject).zzdo)) && (Objects.equal(this.zzdp, ((Goal)paramObject).zzdp)) && (Objects.equal(this.zzdq, ((Goal)paramObject).zzdq));
  }
  
  public String getActivityName()
  {
    if ((!this.zzdl.isEmpty()) && (this.zzdl.size() <= 1)) {
      return zzfa.getName(((Integer)this.zzdl.get(0)).intValue());
    }
    return null;
  }
  
  public long getCreateTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzdj, TimeUnit.NANOSECONDS);
  }
  
  public DurationObjective getDurationObjective()
  {
    zzf(2);
    return this.zzdp;
  }
  
  public long getEndTime(Calendar paramCalendar, TimeUnit paramTimeUnit)
  {
    if (this.zzdm != null)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramCalendar.getTime());
      int i = Recurrence.zza(this.zzdm);
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            localCalendar.add(2, 1);
            localCalendar.set(5, 1);
            localCalendar.set(11, 0);
            return paramTimeUnit.convert(localCalendar.getTimeInMillis(), TimeUnit.MILLISECONDS);
          }
          i = Recurrence.zza(this.zzdm);
          paramCalendar = new StringBuilder(24);
          paramCalendar.append("Invalid unit ");
          paramCalendar.append(i);
          throw new IllegalArgumentException(paramCalendar.toString());
        }
        localCalendar.add(4, 1);
        localCalendar.set(7, 2);
        localCalendar.set(11, 0);
        return paramTimeUnit.convert(localCalendar.getTimeInMillis(), TimeUnit.MILLISECONDS);
      }
      localCalendar.add(5, 1);
      localCalendar.set(11, 0);
      return paramTimeUnit.convert(localCalendar.getTimeInMillis(), TimeUnit.MILLISECONDS);
    }
    return paramTimeUnit.convert(this.zzdk, TimeUnit.NANOSECONDS);
  }
  
  public FrequencyObjective getFrequencyObjective()
  {
    zzf(3);
    return this.zzdq;
  }
  
  public MetricObjective getMetricObjective()
  {
    zzf(1);
    return this.zzdo;
  }
  
  public int getObjectiveType()
  {
    return this.zzdn;
  }
  
  public Recurrence getRecurrence()
  {
    return this.zzdm;
  }
  
  public long getStartTime(Calendar paramCalendar, TimeUnit paramTimeUnit)
  {
    if (this.zzdm != null)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramCalendar.getTime());
      int i = Recurrence.zza(this.zzdm);
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            localCalendar.set(5, 1);
            localCalendar.set(11, 0);
            return paramTimeUnit.convert(localCalendar.getTimeInMillis(), TimeUnit.MILLISECONDS);
          }
          i = Recurrence.zza(this.zzdm);
          paramCalendar = new StringBuilder(24);
          paramCalendar.append("Invalid unit ");
          paramCalendar.append(i);
          throw new IllegalArgumentException(paramCalendar.toString());
        }
        localCalendar.set(7, 2);
        localCalendar.set(11, 0);
        return paramTimeUnit.convert(localCalendar.getTimeInMillis(), TimeUnit.MILLISECONDS);
      }
      localCalendar.set(11, 0);
      return paramTimeUnit.convert(localCalendar.getTimeInMillis(), TimeUnit.MILLISECONDS);
    }
    return paramTimeUnit.convert(this.zzdj, TimeUnit.NANOSECONDS);
  }
  
  public int hashCode()
  {
    return this.zzdn;
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("activity", getActivityName()).add("recurrence", this.zzdm).add("metricObjective", this.zzdo).add("durationObjective", this.zzdp).add("frequencyObjective", this.zzdq).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, this.zzdj);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzdk);
    SafeParcelWriter.writeList(paramParcel, 3, this.zzdl, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, getRecurrence(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 5, getObjectiveType());
    SafeParcelWriter.writeParcelable(paramParcel, 6, this.zzdo, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 7, this.zzdp, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 8, this.zzdq, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public static class DurationObjective
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<DurationObjective> CREATOR = new zzp();
    private final long zzdr;
    
    DurationObjective(long paramLong)
    {
      this.zzdr = paramLong;
    }
    
    public DurationObjective(long paramLong, TimeUnit paramTimeUnit)
    {
      this(paramTimeUnit.toNanos(paramLong));
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof DurationObjective)) {
        return false;
      }
      paramObject = (DurationObjective)paramObject;
      return this.zzdr == ((DurationObjective)paramObject).zzdr;
    }
    
    public long getDuration(TimeUnit paramTimeUnit)
    {
      return paramTimeUnit.convert(this.zzdr, TimeUnit.NANOSECONDS);
    }
    
    public int hashCode()
    {
      return (int)this.zzdr;
    }
    
    public String toString()
    {
      return Objects.toStringHelper(this).add("duration", Long.valueOf(this.zzdr)).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeLong(paramParcel, 1, this.zzdr);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
  
  public static class FrequencyObjective
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<FrequencyObjective> CREATOR = new zzr();
    private final int frequency;
    
    public FrequencyObjective(int paramInt)
    {
      this.frequency = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof FrequencyObjective)) {
        return false;
      }
      paramObject = (FrequencyObjective)paramObject;
      return this.frequency == ((FrequencyObjective)paramObject).frequency;
    }
    
    public int getFrequency()
    {
      return this.frequency;
    }
    
    public int hashCode()
    {
      return this.frequency;
    }
    
    public String toString()
    {
      return Objects.toStringHelper(this).add("frequency", Integer.valueOf(this.frequency)).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeInt(paramParcel, 1, getFrequency());
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
  
  public static class MetricObjective
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<MetricObjective> CREATOR = new zzx();
    private final double value;
    private final String zzds;
    private final double zzdt;
    
    public MetricObjective(String paramString, double paramDouble)
    {
      this(paramString, paramDouble, 0.0D);
    }
    
    public MetricObjective(String paramString, double paramDouble1, double paramDouble2)
    {
      this.zzds = paramString;
      this.value = paramDouble1;
      this.zzdt = paramDouble2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof MetricObjective)) {
        return false;
      }
      paramObject = (MetricObjective)paramObject;
      return (Objects.equal(this.zzds, ((MetricObjective)paramObject).zzds)) && (this.value == ((MetricObjective)paramObject).value) && (this.zzdt == ((MetricObjective)paramObject).zzdt);
    }
    
    public String getDataTypeName()
    {
      return this.zzds;
    }
    
    public double getValue()
    {
      return this.value;
    }
    
    public int hashCode()
    {
      return this.zzds.hashCode();
    }
    
    public String toString()
    {
      return Objects.toStringHelper(this).add("dataTypeName", this.zzds).add("value", Double.valueOf(this.value)).add("initialValue", Double.valueOf(this.zzdt)).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeString(paramParcel, 1, getDataTypeName(), false);
      SafeParcelWriter.writeDouble(paramParcel, 2, getValue());
      SafeParcelWriter.writeDouble(paramParcel, 3, this.zzdt);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
  
  public static class MismatchedGoalException
    extends IllegalStateException
  {
    public MismatchedGoalException(String paramString)
    {
      super();
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ObjectiveType {}
  
  public static class Recurrence
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<Recurrence> CREATOR = new zzab();
    public static final int UNIT_DAY = 1;
    public static final int UNIT_MONTH = 3;
    public static final int UNIT_WEEK = 2;
    private final int count;
    private final int zzdu;
    
    public Recurrence(int paramInt1, int paramInt2)
    {
      this.count = paramInt1;
      boolean bool;
      if ((paramInt2 > 0) && (paramInt2 <= 3)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool);
      this.zzdu = paramInt2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof Recurrence)) {
        return false;
      }
      paramObject = (Recurrence)paramObject;
      return (this.count == ((Recurrence)paramObject).count) && (this.zzdu == ((Recurrence)paramObject).zzdu);
    }
    
    public int getCount()
    {
      return this.count;
    }
    
    public int getUnit()
    {
      return this.zzdu;
    }
    
    public int hashCode()
    {
      return this.zzdu;
    }
    
    public String toString()
    {
      Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this).add("count", Integer.valueOf(this.count));
      int i = this.zzdu;
      String str;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            str = "month";
          } else {
            throw new IllegalArgumentException("invalid unit value");
          }
        }
        else {
          str = "week";
        }
      }
      else {
        str = "day";
      }
      return localToStringHelper.add("unit", str).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeInt(paramParcel, 1, getCount());
      SafeParcelWriter.writeInt(paramParcel, 2, getUnit());
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface RecurrenceUnit {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\Goal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */