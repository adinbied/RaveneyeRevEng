package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public final class zzbh
  extends AbstractSafeParcelable
  implements Geofence
{
  public static final Parcelable.Creator<zzbh> CREATOR = new zzbi();
  private final String zzad;
  private final int zzae;
  private final short zzag;
  private final double zzah;
  private final double zzai;
  private final float zzaj;
  private final int zzak;
  private final int zzal;
  private final long zzdo;
  
  public zzbh(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3)
  {
    if ((paramString != null) && (paramString.length() <= 100))
    {
      if (paramFloat > 0.0F)
      {
        if ((paramDouble1 <= 90.0D) && (paramDouble1 >= -90.0D))
        {
          if ((paramDouble2 <= 180.0D) && (paramDouble2 >= -180.0D))
          {
            int i = paramInt1 & 0x7;
            if (i != 0)
            {
              this.zzag = paramShort;
              this.zzad = paramString;
              this.zzah = paramDouble1;
              this.zzai = paramDouble2;
              this.zzaj = paramFloat;
              this.zzdo = paramLong;
              this.zzae = i;
              this.zzak = paramInt2;
              this.zzal = paramInt3;
              return;
            }
            paramString = new StringBuilder(46);
            paramString.append("No supported transition specified: ");
            paramString.append(paramInt1);
            throw new IllegalArgumentException(paramString.toString());
          }
          paramString = new StringBuilder(43);
          paramString.append("invalid longitude: ");
          paramString.append(paramDouble2);
          throw new IllegalArgumentException(paramString.toString());
        }
        paramString = new StringBuilder(42);
        paramString.append("invalid latitude: ");
        paramString.append(paramDouble1);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = new StringBuilder(31);
      paramString.append("invalid radius: ");
      paramString.append(paramFloat);
      throw new IllegalArgumentException(paramString.toString());
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "requestId is null or too long: ".concat(paramString);
    } else {
      paramString = new String("requestId is null or too long: ");
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static zzbh zza(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = (zzbh)CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof zzbh)) {
      return false;
    }
    paramObject = (zzbh)paramObject;
    if (this.zzaj != ((zzbh)paramObject).zzaj) {
      return false;
    }
    if (this.zzah != ((zzbh)paramObject).zzah) {
      return false;
    }
    if (this.zzai != ((zzbh)paramObject).zzai) {
      return false;
    }
    return this.zzag == ((zzbh)paramObject).zzag;
  }
  
  public final String getRequestId()
  {
    return this.zzad;
  }
  
  public final int hashCode()
  {
    long l = Double.doubleToLongBits(this.zzah);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.zzai);
    return ((((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(this.zzaj)) * 31 + this.zzag) * 31 + this.zzae;
  }
  
  public final String toString()
  {
    Locale localLocale = Locale.US;
    String str;
    if (this.zzag != 1) {
      str = null;
    } else {
      str = "CIRCLE";
    }
    return String.format(localLocale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] { str, this.zzad.replaceAll("\\p{C}", "?"), Integer.valueOf(this.zzae), Double.valueOf(this.zzah), Double.valueOf(this.zzai), Float.valueOf(this.zzaj), Integer.valueOf(this.zzak / 1000), Integer.valueOf(this.zzal), Long.valueOf(this.zzdo) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getRequestId(), false);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzdo);
    SafeParcelWriter.writeShort(paramParcel, 3, this.zzag);
    SafeParcelWriter.writeDouble(paramParcel, 4, this.zzah);
    SafeParcelWriter.writeDouble(paramParcel, 5, this.zzai);
    SafeParcelWriter.writeFloat(paramParcel, 6, this.zzaj);
    SafeParcelWriter.writeInt(paramParcel, 7, this.zzae);
    SafeParcelWriter.writeInt(paramParcel, 8, this.zzak);
    SafeParcelWriter.writeInt(paramParcel, 9, this.zzal);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */