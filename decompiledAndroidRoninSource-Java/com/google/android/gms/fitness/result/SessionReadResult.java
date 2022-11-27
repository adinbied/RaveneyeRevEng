package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.zzae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SessionReadResult
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<SessionReadResult> CREATOR = new zzh();
  private final List<Session> zzgn;
  private final Status zzir;
  private final List<zzae> zziw;
  
  public SessionReadResult(List<Session> paramList, List<zzae> paramList1, Status paramStatus)
  {
    this.zzgn = paramList;
    this.zziw = Collections.unmodifiableList(paramList1);
    this.zzir = paramStatus;
  }
  
  public static SessionReadResult zze(Status paramStatus)
  {
    return new SessionReadResult(new ArrayList(), new ArrayList(), paramStatus);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof SessionReadResult))
      {
        paramObject = (SessionReadResult)paramObject;
        int i;
        if ((this.zzir.equals(((SessionReadResult)paramObject).zzir)) && (Objects.equal(this.zzgn, ((SessionReadResult)paramObject).zzgn)) && (Objects.equal(this.zziw, ((SessionReadResult)paramObject).zziw))) {
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
  
  public List<DataSet> getDataSet(Session paramSession)
  {
    Preconditions.checkArgument(this.zzgn.contains(paramSession), "Attempting to read data for session %s which was not returned", new Object[] { paramSession });
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zziw.iterator();
    while (localIterator.hasNext())
    {
      zzae localzzae = (zzae)localIterator.next();
      if (Objects.equal(paramSession, localzzae.getSession())) {
        localArrayList.add(localzzae.getDataSet());
      }
    }
    return localArrayList;
  }
  
  public List<DataSet> getDataSet(Session paramSession, DataType paramDataType)
  {
    Preconditions.checkArgument(this.zzgn.contains(paramSession), "Attempting to read data for session %s which was not returned", new Object[] { paramSession });
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zziw.iterator();
    while (localIterator.hasNext())
    {
      zzae localzzae = (zzae)localIterator.next();
      if ((Objects.equal(paramSession, localzzae.getSession())) && (paramDataType.equals(localzzae.getDataSet().getDataType()))) {
        localArrayList.add(localzzae.getDataSet());
      }
    }
    return localArrayList;
  }
  
  public List<Session> getSessions()
  {
    return this.zzgn;
  }
  
  public Status getStatus()
  {
    return this.zzir;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzir, this.zzgn, this.zziw });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("status", this.zzir).add("sessions", this.zzgn).add("sessionDataSets", this.zziw).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getSessions(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 2, this.zziw, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getStatus(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\result\SessionReadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */