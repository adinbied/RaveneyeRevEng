package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListSubscriptionsResult
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<ListSubscriptionsResult> CREATOR = new zzg();
  private final Status zzir;
  private final List<Subscription> zziv;
  
  public ListSubscriptionsResult(List<Subscription> paramList, Status paramStatus)
  {
    this.zziv = paramList;
    this.zzir = paramStatus;
  }
  
  public static ListSubscriptionsResult zzd(Status paramStatus)
  {
    return new ListSubscriptionsResult(Collections.emptyList(), paramStatus);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof ListSubscriptionsResult))
      {
        paramObject = (ListSubscriptionsResult)paramObject;
        int i;
        if ((this.zzir.equals(((ListSubscriptionsResult)paramObject).zzir)) && (Objects.equal(this.zziv, ((ListSubscriptionsResult)paramObject).zziv))) {
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
  
  public Status getStatus()
  {
    return this.zzir;
  }
  
  public List<Subscription> getSubscriptions()
  {
    return this.zziv;
  }
  
  public List<Subscription> getSubscriptions(DataType paramDataType)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zziv.iterator();
    while (localIterator.hasNext())
    {
      Subscription localSubscription = (Subscription)localIterator.next();
      if (paramDataType.equals(localSubscription.zzq())) {
        localArrayList.add(localSubscription);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzir, this.zziv });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("status", this.zzir).add("subscriptions", this.zziv).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getSubscriptions(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getStatus(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\result\ListSubscriptionsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */