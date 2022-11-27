package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.z;
import java.util.Map;
import java.util.UUID;

public class CrashDetailBean
  implements Parcelable, Comparable<CrashDetailBean>
{
  public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator() {};
  public String A;
  public String B;
  public long C;
  public long D;
  public long E;
  public long F;
  public long G;
  public long H;
  public String I;
  public String J;
  public String K;
  public String L;
  public long M;
  public boolean N;
  public Map<String, String> O;
  public Map<String, String> P;
  public int Q;
  public int R;
  public Map<String, String> S;
  public Map<String, String> T;
  public byte[] U;
  public String V;
  public String W;
  private String X;
  public long a = -1L;
  public int b;
  public String c;
  public boolean d;
  public String e;
  public String f;
  public String g;
  public Map<String, PlugInBean> h;
  public Map<String, PlugInBean> i;
  public boolean j;
  public boolean k;
  public int l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public long r;
  public String s;
  public int t;
  public String u;
  public String v;
  public String w;
  public String x;
  public byte[] y;
  public Map<String, String> z;
  
  public CrashDetailBean()
  {
    this.b = 0;
    this.c = UUID.randomUUID().toString();
    this.d = false;
    this.e = "";
    this.f = "";
    this.g = "";
    this.h = null;
    this.i = null;
    this.j = false;
    this.k = false;
    this.l = 0;
    this.m = "";
    this.n = "";
    this.o = "";
    this.p = "";
    this.q = "";
    this.r = -1L;
    this.s = null;
    this.t = 0;
    this.u = "";
    this.v = "";
    this.w = null;
    this.x = null;
    this.y = null;
    this.z = null;
    this.A = "";
    this.B = "";
    this.C = -1L;
    this.D = -1L;
    this.E = -1L;
    this.F = -1L;
    this.G = -1L;
    this.H = -1L;
    this.I = "";
    this.X = "";
    this.J = "";
    this.K = "";
    this.L = "";
    this.M = -1L;
    this.N = false;
    this.O = null;
    this.P = null;
    this.Q = -1;
    this.R = -1;
    this.S = null;
    this.T = null;
    this.U = null;
    this.V = null;
    this.W = null;
  }
  
  public CrashDetailBean(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.b = 0;
    this.c = UUID.randomUUID().toString();
    this.d = false;
    this.e = "";
    this.f = "";
    this.g = "";
    this.h = null;
    this.i = null;
    this.j = false;
    this.k = false;
    this.l = 0;
    this.m = "";
    this.n = "";
    this.o = "";
    this.p = "";
    this.q = "";
    this.r = -1L;
    this.s = null;
    this.t = 0;
    this.u = "";
    this.v = "";
    this.w = null;
    this.x = null;
    this.y = null;
    this.z = null;
    this.A = "";
    this.B = "";
    this.C = -1L;
    this.D = -1L;
    this.E = -1L;
    this.F = -1L;
    this.G = -1L;
    this.H = -1L;
    this.I = "";
    this.X = "";
    this.J = "";
    this.K = "";
    this.L = "";
    this.M = -1L;
    this.N = false;
    this.O = null;
    this.P = null;
    this.Q = -1;
    this.R = -1;
    this.S = null;
    this.T = null;
    this.U = null;
    this.V = null;
    this.W = null;
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.d = bool1;
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.j = bool1;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.k = bool1;
    this.l = paramParcel.readInt();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.q = paramParcel.readString();
    this.r = paramParcel.readLong();
    this.s = paramParcel.readString();
    this.t = paramParcel.readInt();
    this.u = paramParcel.readString();
    this.v = paramParcel.readString();
    this.w = paramParcel.readString();
    this.z = z.b(paramParcel);
    this.A = paramParcel.readString();
    this.B = paramParcel.readString();
    this.C = paramParcel.readLong();
    this.D = paramParcel.readLong();
    this.E = paramParcel.readLong();
    this.F = paramParcel.readLong();
    this.G = paramParcel.readLong();
    this.H = paramParcel.readLong();
    this.I = paramParcel.readString();
    this.X = paramParcel.readString();
    this.J = paramParcel.readString();
    this.K = paramParcel.readString();
    this.L = paramParcel.readString();
    this.M = paramParcel.readLong();
    boolean bool1 = bool2;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    }
    this.N = bool1;
    this.O = z.b(paramParcel);
    this.h = z.a(paramParcel);
    this.i = z.a(paramParcel);
    this.Q = paramParcel.readInt();
    this.R = paramParcel.readInt();
    this.S = z.b(paramParcel);
    this.T = z.b(paramParcel);
    this.U = paramParcel.createByteArray();
    this.y = paramParcel.createByteArray();
    this.V = paramParcel.readString();
    this.W = paramParcel.readString();
    this.x = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeByte((byte)this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeByte((byte)this.j);
    paramParcel.writeByte((byte)this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeLong(this.r);
    paramParcel.writeString(this.s);
    paramParcel.writeInt(this.t);
    paramParcel.writeString(this.u);
    paramParcel.writeString(this.v);
    paramParcel.writeString(this.w);
    z.b(paramParcel, this.z);
    paramParcel.writeString(this.A);
    paramParcel.writeString(this.B);
    paramParcel.writeLong(this.C);
    paramParcel.writeLong(this.D);
    paramParcel.writeLong(this.E);
    paramParcel.writeLong(this.F);
    paramParcel.writeLong(this.G);
    paramParcel.writeLong(this.H);
    paramParcel.writeString(this.I);
    paramParcel.writeString(this.X);
    paramParcel.writeString(this.J);
    paramParcel.writeString(this.K);
    paramParcel.writeString(this.L);
    paramParcel.writeLong(this.M);
    paramParcel.writeByte((byte)this.N);
    z.b(paramParcel, this.O);
    z.a(paramParcel, this.h);
    z.a(paramParcel, this.i);
    paramParcel.writeInt(this.Q);
    paramParcel.writeInt(this.R);
    z.b(paramParcel, this.S);
    z.b(paramParcel, this.T);
    paramParcel.writeByteArray(this.U);
    paramParcel.writeByteArray(this.y);
    paramParcel.writeString(this.V);
    paramParcel.writeString(this.W);
    paramParcel.writeString(this.x);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\crash\CrashDetailBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */