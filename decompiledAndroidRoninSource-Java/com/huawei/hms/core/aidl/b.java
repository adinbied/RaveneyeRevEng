package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class b
  implements Parcelable
{
  public static final Parcelable.Creator<b> CREATOR = new c();
  public String a;
  public Bundle b = null;
  private int c = 1;
  private Bundle d = null;
  
  public b() {}
  
  private b(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public b(String paramString, int paramInt)
  {
    this.a = paramString;
    this.c = paramInt;
  }
  
  private static ClassLoader a(Class paramClass)
  {
    return paramClass.getClassLoader();
  }
  
  /* Error */
  private void a(Parcel arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Bundle a()
  {
    return this.d;
  }
  
  public b a(Bundle paramBundle)
  {
    this.d = paramBundle;
    return this;
  }
  
  public int b()
  {
    if (this.d == null) {
      return 0;
    }
    return 1;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.a);
    paramParcel.writeBundle(this.b);
    paramParcel.writeBundle(this.d);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\core\aidl\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */