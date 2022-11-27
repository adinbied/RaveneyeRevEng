package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zam
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zam> CREATOR = new zaj();
  private final int versionCode;
  final String zaqz;
  final FastJsonResponse.Field<?, ?> zara;
  
  zam(int paramInt, String paramString, FastJsonResponse.Field<?, ?> paramField)
  {
    this.versionCode = paramInt;
    this.zaqz = paramString;
    this.zara = paramField;
  }
  
  zam(String paramString, FastJsonResponse.Field<?, ?> paramField)
  {
    this.versionCode = 1;
    this.zaqz = paramString;
    this.zara = paramField;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, this.zaqz, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zara, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\server\response\zam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */