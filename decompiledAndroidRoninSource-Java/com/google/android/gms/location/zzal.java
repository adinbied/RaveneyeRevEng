package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.List;

public final class zzal
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzal> CREATOR = new zzam();
  private final String tag;
  private final List<String> zzbu;
  private final PendingIntent zzbv;
  
  zzal(List<String> paramList, PendingIntent paramPendingIntent, String paramString)
  {
    if (paramList == null) {
      paramList = Collections.emptyList();
    } else {
      paramList = Collections.unmodifiableList(paramList);
    }
    this.zzbu = paramList;
    this.zzbv = paramPendingIntent;
    this.tag = paramString;
  }
  
  public static zzal zza(PendingIntent paramPendingIntent)
  {
    Preconditions.checkNotNull(paramPendingIntent, "PendingIntent can not be null.");
    return new zzal(null, paramPendingIntent, "");
  }
  
  public static zzal zza(List<String> paramList)
  {
    Preconditions.checkNotNull(paramList, "geofence can't be null.");
    Preconditions.checkArgument(paramList.isEmpty() ^ true, "Geofences must contains at least one id.");
    return new zzal(paramList, null, "");
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeStringList(paramParcel, 1, this.zzbu, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzbv, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.tag, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */