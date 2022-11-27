package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.zzu;
import com.google.android.gms.location.zzv;
import com.google.android.gms.location.zzx;
import com.google.android.gms.location.zzy;

public final class zzbf
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbf> CREATOR = new zzbg();
  private PendingIntent zzbv;
  private int zzcg;
  private zzaj zzcj;
  private zzbd zzdl;
  private zzx zzdm;
  private zzu zzdn;
  
  zzbf(int paramInt, zzbd paramzzbd, IBinder paramIBinder1, PendingIntent paramPendingIntent, IBinder paramIBinder2, IBinder paramIBinder3)
  {
    this.zzcg = paramInt;
    this.zzdl = paramzzbd;
    Object localObject = null;
    if (paramIBinder1 == null) {
      paramzzbd = null;
    } else {
      paramzzbd = zzy.zzc(paramIBinder1);
    }
    this.zzdm = paramzzbd;
    this.zzbv = paramPendingIntent;
    if (paramIBinder2 == null) {
      paramzzbd = null;
    } else {
      paramzzbd = zzv.zzb(paramIBinder2);
    }
    this.zzdn = paramzzbd;
    if (paramIBinder3 == null)
    {
      paramzzbd = (zzbd)localObject;
    }
    else if (paramIBinder3 == null)
    {
      paramzzbd = (zzbd)localObject;
    }
    else
    {
      paramzzbd = paramIBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
      if ((paramzzbd instanceof zzaj)) {
        paramzzbd = (zzaj)paramzzbd;
      } else {
        paramzzbd = new zzal(paramIBinder3);
      }
    }
    this.zzcj = paramzzbd;
  }
  
  public static zzbf zza(zzu paramzzu, zzaj paramzzaj)
  {
    IBinder localIBinder = paramzzu.asBinder();
    if (paramzzaj != null) {
      paramzzu = paramzzaj.asBinder();
    } else {
      paramzzu = null;
    }
    return new zzbf(2, null, null, null, localIBinder, paramzzu);
  }
  
  public static zzbf zza(zzx paramzzx, zzaj paramzzaj)
  {
    IBinder localIBinder = paramzzx.asBinder();
    if (paramzzaj != null) {
      paramzzx = paramzzaj.asBinder();
    } else {
      paramzzx = null;
    }
    return new zzbf(2, null, localIBinder, null, null, paramzzx);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzcg);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzdl, paramInt, false);
    Object localObject1 = this.zzdm;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((zzx)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject1, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, this.zzbv, paramInt, false);
    localObject1 = this.zzdn;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((zzu)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 5, (IBinder)localObject1, false);
    localObject1 = this.zzcj;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((zzaj)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 6, (IBinder)localObject1, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzbf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */