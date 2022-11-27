package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class Status
  extends AbstractSafeParcelable
  implements Result, ReflectedParcelable
{
  public static final Parcelable.Creator<Status> CREATOR = new zzb();
  public static final Status RESULT_CANCELED;
  public static final Status RESULT_DEAD_CLIENT;
  public static final Status RESULT_INTERNAL_ERROR;
  public static final Status RESULT_INTERRUPTED;
  public static final Status RESULT_SUCCESS = new Status(0);
  public static final Status RESULT_TIMEOUT;
  private static final Status zzar;
  private final int zzg;
  private final int zzh;
  private final PendingIntent zzi;
  private final String zzj;
  
  static
  {
    RESULT_INTERRUPTED = new Status(14);
    RESULT_INTERNAL_ERROR = new Status(8);
    RESULT_TIMEOUT = new Status(15);
    RESULT_CANCELED = new Status(16);
    zzar = new Status(17);
    RESULT_DEAD_CLIENT = new Status(18);
  }
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.zzg = paramInt1;
    this.zzh = paramInt2;
    this.zzj = paramString;
    this.zzi = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {
      return false;
    }
    paramObject = (Status)paramObject;
    return (this.zzg == ((Status)paramObject).zzg) && (this.zzh == ((Status)paramObject).zzh) && (Objects.equal(this.zzj, ((Status)paramObject).zzj)) && (Objects.equal(this.zzi, ((Status)paramObject).zzi));
  }
  
  public final PendingIntent getResolution()
  {
    return this.zzi;
  }
  
  public final Status getStatus()
  {
    return this;
  }
  
  public final int getStatusCode()
  {
    return this.zzh;
  }
  
  public final String getStatusMessage()
  {
    return this.zzj;
  }
  
  public final boolean hasResolution()
  {
    return this.zzi != null;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzg), Integer.valueOf(this.zzh), this.zzj, this.zzi });
  }
  
  public final boolean isCanceled()
  {
    return this.zzh == 16;
  }
  
  public final boolean isInterrupted()
  {
    return this.zzh == 14;
  }
  
  public final boolean isSuccess()
  {
    return this.zzh <= 0;
  }
  
  public final void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution()) {
      return;
    }
    paramActivity.startIntentSenderForResult(this.zzi.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).add("statusCode", zzg()).add("resolution", this.zzi).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getStatusCode());
    SafeParcelWriter.writeString(paramParcel, 2, getStatusMessage(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzi, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zzg);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final String zzg()
  {
    String str = this.zzj;
    if (str != null) {
      return str;
    }
    return CommonStatusCodes.getStatusCodeString(this.zzh);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */