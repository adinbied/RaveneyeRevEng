package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class ClientIdentity
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ClientIdentity> CREATOR = new zab();
  private final String packageName;
  private final int uid;
  
  public ClientIdentity(int paramInt, String paramString)
  {
    this.uid = paramInt;
    this.packageName = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (paramObject != null)
    {
      if (!(paramObject instanceof ClientIdentity)) {
        return false;
      }
      paramObject = (ClientIdentity)paramObject;
      if ((((ClientIdentity)paramObject).uid == this.uid) && (Objects.equal(((ClientIdentity)paramObject).packageName, this.packageName))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.uid;
  }
  
  public String toString()
  {
    int i = this.uid;
    String str = this.packageName;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 12);
    localStringBuilder.append(i);
    localStringBuilder.append(":");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.uid);
    SafeParcelWriter.writeString(paramParcel, 2, this.packageName, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\ClientIdentity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */