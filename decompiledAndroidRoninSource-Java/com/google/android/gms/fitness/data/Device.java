package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.provider.Settings.Secure;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzi;

public final class Device
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Device> CREATOR = new zzo();
  public static final int TYPE_CHEST_STRAP = 4;
  public static final int TYPE_HEAD_MOUNTED = 6;
  public static final int TYPE_PHONE = 1;
  public static final int TYPE_SCALE = 5;
  public static final int TYPE_TABLET = 2;
  public static final int TYPE_UNKNOWN = 0;
  public static final int TYPE_WATCH = 3;
  private final int type;
  private final String zzcc;
  private final String zzcd;
  private final String zzce;
  private final int zzcf;
  
  public Device(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramInt, 0);
  }
  
  public Device(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.zzcc = ((String)Preconditions.checkNotNull(paramString1));
    this.zzcd = ((String)Preconditions.checkNotNull(paramString2));
    if (paramString3 != null)
    {
      this.zzce = paramString3;
      this.type = paramInt1;
      this.zzcf = paramInt2;
      return;
    }
    throw new IllegalStateException("Device UID is null.");
  }
  
  @Deprecated
  private Device(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    this(paramString1, paramString2, paramString4, paramInt1, 2);
  }
  
  public static Device getLocalDevice(Context paramContext)
  {
    int i = zzi.zza(paramContext);
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    return new Device(Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, paramContext, i, 2);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Device)) {
      return false;
    }
    paramObject = (Device)paramObject;
    return (Objects.equal(this.zzcc, ((Device)paramObject).zzcc)) && (Objects.equal(this.zzcd, ((Device)paramObject).zzcd)) && (Objects.equal(this.zzce, ((Device)paramObject).zzce)) && (this.type == ((Device)paramObject).type) && (this.zzcf == ((Device)paramObject).zzcf);
  }
  
  public final String getManufacturer()
  {
    return this.zzcc;
  }
  
  public final String getModel()
  {
    return this.zzcd;
  }
  
  final String getStreamIdentifier()
  {
    return String.format("%s:%s:%s", new Object[] { this.zzcc, this.zzcd, this.zzce });
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public final String getUid()
  {
    return this.zzce;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzcc, this.zzcd, this.zzce, Integer.valueOf(this.type) });
  }
  
  public final String toString()
  {
    return String.format("Device{%s:%s:%s}", new Object[] { getStreamIdentifier(), Integer.valueOf(this.type), Integer.valueOf(this.zzcf) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getManufacturer(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getModel(), false);
    SafeParcelWriter.writeString(paramParcel, 4, getUid(), false);
    SafeParcelWriter.writeInt(paramParcel, 5, getType());
    SafeParcelWriter.writeInt(paramParcel, 6, this.zzcf);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\Device.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */