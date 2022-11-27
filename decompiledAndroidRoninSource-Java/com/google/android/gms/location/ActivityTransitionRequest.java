package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class ActivityTransitionRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new zzf();
  public static final Comparator<ActivityTransition> IS_SAME_TRANSITION = new zze();
  private final String tag;
  private final List<ActivityTransition> zzl;
  private final List<ClientIdentity> zzm;
  
  public ActivityTransitionRequest(List<ActivityTransition> paramList)
  {
    this(paramList, null, null);
  }
  
  public ActivityTransitionRequest(List<ActivityTransition> paramList, String paramString, List<ClientIdentity> paramList1)
  {
    Preconditions.checkNotNull(paramList, "transitions can't be null");
    boolean bool;
    if (paramList.size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "transitions can't be empty.");
    TreeSet localTreeSet = new TreeSet(IS_SAME_TRANSITION);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ActivityTransition localActivityTransition = (ActivityTransition)localIterator.next();
      Preconditions.checkArgument(localTreeSet.add(localActivityTransition), String.format("Found duplicated transition: %s.", new Object[] { localActivityTransition }));
    }
    this.zzl = Collections.unmodifiableList(paramList);
    this.tag = paramString;
    if (paramList1 == null) {
      paramList = Collections.emptyList();
    } else {
      paramList = Collections.unmodifiableList(paramList1);
    }
    this.zzm = paramList;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ActivityTransitionRequest)paramObject;
      if ((Objects.equal(this.zzl, ((ActivityTransitionRequest)paramObject).zzl)) && (Objects.equal(this.tag, ((ActivityTransitionRequest)paramObject).tag)) && (Objects.equal(this.zzm, ((ActivityTransitionRequest)paramObject).zzm))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    int k = this.zzl.hashCode();
    Object localObject = this.tag;
    int j = 0;
    int i;
    if (localObject != null) {
      i = ((String)localObject).hashCode();
    } else {
      i = 0;
    }
    localObject = this.zzm;
    if (localObject != null) {
      j = ((List)localObject).hashCode();
    }
    return (k * 31 + i) * 31 + j;
  }
  
  public void serializeToIntentExtra(Intent paramIntent)
  {
    SafeParcelableSerializer.serializeToIntentExtra(this, paramIntent, "com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_REQUEST");
  }
  
  public String toString()
  {
    String str1 = String.valueOf(this.zzl);
    String str2 = this.tag;
    String str3 = String.valueOf(this.zzm);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 61 + String.valueOf(str2).length() + String.valueOf(str3).length());
    localStringBuilder.append("ActivityTransitionRequest [mTransitions=");
    localStringBuilder.append(str1);
    localStringBuilder.append(", mTag='");
    localStringBuilder.append(str2);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mClients=");
    localStringBuilder.append(str3);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, this.zzl, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.tag, false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zzm, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\ActivityTransitionRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */