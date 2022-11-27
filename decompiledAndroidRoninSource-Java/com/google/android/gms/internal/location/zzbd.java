package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public final class zzbd
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbd> CREATOR = new zzbe();
  static final List<ClientIdentity> zzcd = ;
  private String moduleId;
  private String tag;
  private LocationRequest zzdg;
  private boolean zzdh;
  private boolean zzdi;
  private boolean zzdj;
  private boolean zzdk = true;
  private List<ClientIdentity> zzm;
  
  zzbd(LocationRequest paramLocationRequest, List<ClientIdentity> paramList, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    this.zzdg = paramLocationRequest;
    this.zzm = paramList;
    this.tag = paramString1;
    this.zzdh = paramBoolean1;
    this.zzdi = paramBoolean2;
    this.zzdj = paramBoolean3;
    this.moduleId = paramString2;
  }
  
  @Deprecated
  public static zzbd zza(LocationRequest paramLocationRequest)
  {
    return new zzbd(paramLocationRequest, zzcd, null, false, false, false, null);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzbd)) {
      return false;
    }
    paramObject = (zzbd)paramObject;
    return (Objects.equal(this.zzdg, ((zzbd)paramObject).zzdg)) && (Objects.equal(this.zzm, ((zzbd)paramObject).zzm)) && (Objects.equal(this.tag, ((zzbd)paramObject).tag)) && (this.zzdh == ((zzbd)paramObject).zzdh) && (this.zzdi == ((zzbd)paramObject).zzdi) && (this.zzdj == ((zzbd)paramObject).zzdj) && (Objects.equal(this.moduleId, ((zzbd)paramObject).moduleId));
  }
  
  public final int hashCode()
  {
    return this.zzdg.hashCode();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.zzdg);
    if (this.tag != null)
    {
      localStringBuilder.append(" tag=");
      localStringBuilder.append(this.tag);
    }
    if (this.moduleId != null)
    {
      localStringBuilder.append(" moduleId=");
      localStringBuilder.append(this.moduleId);
    }
    localStringBuilder.append(" hideAppOps=");
    localStringBuilder.append(this.zzdh);
    localStringBuilder.append(" clients=");
    localStringBuilder.append(this.zzm);
    localStringBuilder.append(" forceCoarseLocation=");
    localStringBuilder.append(this.zzdi);
    if (this.zzdj) {
      localStringBuilder.append(" exemptFromBackgroundThrottle");
    }
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, this.zzdg, paramInt, false);
    SafeParcelWriter.writeTypedList(paramParcel, 5, this.zzm, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.tag, false);
    SafeParcelWriter.writeBoolean(paramParcel, 7, this.zzdh);
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzdi);
    SafeParcelWriter.writeBoolean(paramParcel, 9, this.zzdj);
    SafeParcelWriter.writeString(paramParcel, 10, this.moduleId, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzbd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */