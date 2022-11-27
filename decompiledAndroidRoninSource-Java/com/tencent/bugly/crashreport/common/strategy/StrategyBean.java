package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.proguard.z;
import java.util.Map;

public class StrategyBean
  implements Parcelable
{
  public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator() {};
  public static String a = "https://android.bugly.qq.com/rqd/async";
  public static String b = "https://android.bugly.qq.com/rqd/async";
  public long c = -1L;
  public long d = -1L;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  public boolean m;
  public long n;
  public long o;
  public String p;
  public String q;
  public String r;
  public Map<String, String> s;
  public int t;
  public long u;
  public long v;
  
  public StrategyBean()
  {
    this.e = true;
    this.f = true;
    this.g = true;
    this.h = true;
    this.i = false;
    this.j = true;
    this.k = true;
    this.l = true;
    this.m = true;
    this.o = 30000L;
    this.p = a;
    this.q = b;
    this.t = 10;
    this.u = 300000L;
    this.v = -1L;
    this.d = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("S(@L@L");
    localStringBuilder.append("@)");
    localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("*^@K#K");
    localStringBuilder.append("@!");
    this.r = localStringBuilder.toString();
  }
  
  public StrategyBean(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.e = true;
    this.f = true;
    this.g = true;
    this.h = true;
    this.i = false;
    this.j = true;
    this.k = true;
    this.l = true;
    this.m = true;
    this.o = 30000L;
    this.p = a;
    this.q = b;
    this.t = 10;
    this.u = 300000L;
    this.v = -1L;
    for (;;)
    {
      try
      {
        this.d = paramParcel.readLong();
        if (paramParcel.readByte() == 1)
        {
          bool1 = true;
          this.e = bool1;
          if (paramParcel.readByte() != 1) {
            break label360;
          }
          bool1 = true;
          this.f = bool1;
          if (paramParcel.readByte() != 1) {
            break label365;
          }
          bool1 = true;
          this.g = bool1;
          this.p = paramParcel.readString();
          this.q = paramParcel.readString();
          this.r = paramParcel.readString();
          this.s = z.b(paramParcel);
          if (paramParcel.readByte() != 1) {
            break label370;
          }
          bool1 = true;
          this.h = bool1;
          if (paramParcel.readByte() != 1) {
            break label375;
          }
          bool1 = true;
          this.i = bool1;
          if (paramParcel.readByte() != 1) {
            break label380;
          }
          bool1 = true;
          this.l = bool1;
          if (paramParcel.readByte() != 1) {
            break label385;
          }
          bool1 = true;
          this.m = bool1;
          this.o = paramParcel.readLong();
          if (paramParcel.readByte() != 1) {
            break label390;
          }
          bool1 = true;
          this.j = bool1;
          if (paramParcel.readByte() != 1) {
            break label395;
          }
          bool1 = bool2;
          this.k = bool1;
          this.n = paramParcel.readLong();
          this.t = paramParcel.readInt();
          this.u = paramParcel.readLong();
          this.v = paramParcel.readLong();
          return;
        }
      }
      catch (Exception paramParcel)
      {
        paramParcel.printStackTrace();
        return;
      }
      boolean bool1 = false;
      continue;
      label360:
      bool1 = false;
      continue;
      label365:
      bool1 = false;
      continue;
      label370:
      bool1 = false;
      continue;
      label375:
      bool1 = false;
      continue;
      label380:
      bool1 = false;
      continue;
      label385:
      bool1 = false;
      continue;
      label390:
      bool1 = false;
      continue;
      label395:
      bool1 = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.d);
    paramParcel.writeByte((byte)this.e);
    paramParcel.writeByte((byte)this.f);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.r);
    z.b(paramParcel, this.s);
    paramParcel.writeByte((byte)this.h);
    paramParcel.writeByte((byte)this.i);
    paramParcel.writeByte((byte)this.l);
    paramParcel.writeByte((byte)this.m);
    paramParcel.writeLong(this.o);
    paramParcel.writeByte((byte)this.j);
    paramParcel.writeByte((byte)this.k);
    paramParcel.writeLong(this.n);
    paramParcel.writeInt(this.t);
    paramParcel.writeLong(this.u);
    paramParcel.writeLong(this.v);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\common\strategy\StrategyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */