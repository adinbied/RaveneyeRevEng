package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PlugInBean
  implements Parcelable
{
  public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator() {};
  public final String a;
  public final String b;
  public final String c;
  
  public PlugInBean(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public PlugInBean(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("plid:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" plV:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" plUUID:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\common\info\PlugInBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */