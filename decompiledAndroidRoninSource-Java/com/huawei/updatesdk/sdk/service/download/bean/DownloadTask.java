package com.huawei.updatesdk.sdk.service.download.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.updatesdk.sdk.a.c.a.a.a;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;

public class DownloadTask
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadTask> CREATOR = new Parcelable.Creator()
  {
    public DownloadTask a(Parcel paramAnonymousParcel)
    {
      return new DownloadTask(paramAnonymousParcel);
    }
    
    public DownloadTask[] a(int paramAnonymousInt)
    {
      return new DownloadTask[paramAnonymousInt];
    }
  };
  private static int k = ;
  private static final Object l = new Object();
  @c
  private String A;
  @c
  private int B;
  private int C;
  private int D;
  private boolean E;
  private volatile boolean F;
  private volatile boolean G;
  private String H;
  private String I;
  private a J;
  private b K;
  private List<b> L;
  private long M;
  @c
  private boolean N;
  private boolean O;
  @c
  private boolean P;
  @c
  private String Q;
  private Future<?> R;
  private com.huawei.updatesdk.sdk.service.download.b S;
  public String a;
  @c
  protected String b;
  @c
  protected int c;
  @c
  protected long d;
  @c
  protected String e;
  @c
  protected int f;
  @c
  protected int g;
  public boolean h;
  @c
  public int i;
  private final String j = "DownloadTask";
  @c
  private int m = -1;
  @c
  private String n;
  @c
  private String o;
  @c
  private long p;
  @c
  private String q;
  @c
  private long r;
  @c
  private String s;
  @c
  private int t;
  private Future<?> u;
  @c
  private String v;
  @c
  private int w;
  @c
  private String x;
  private boolean y;
  private boolean z;
  
  public DownloadTask()
  {
    this.c = 0;
    this.p = 0L;
    this.r = 0L;
    this.d = 0L;
    this.t = 0;
    this.g = 0;
    this.h = false;
    this.u = null;
    this.i = 0;
    this.w = 0;
    this.y = false;
    this.z = true;
    this.C = 1;
    this.D = 0;
    this.E = true;
    this.F = false;
    this.G = false;
    this.H = null;
    this.I = null;
    this.J = new a();
    this.K = new b();
    this.L = new CopyOnWriteArrayList();
    this.M = 0L;
    this.N = false;
    this.O = false;
    this.P = false;
    this.R = null;
    this.S = new com.huawei.updatesdk.service.deamon.download.b();
  }
  
  protected DownloadTask(Bundle paramBundle)
  {
    int i1 = 0;
    this.c = 0;
    this.p = 0L;
    this.r = 0L;
    this.d = 0L;
    this.t = 0;
    this.g = 0;
    this.h = false;
    this.u = null;
    this.i = 0;
    this.w = 0;
    this.y = false;
    this.z = true;
    this.C = 1;
    this.D = 0;
    this.E = true;
    this.F = false;
    this.G = false;
    this.H = null;
    this.I = null;
    this.J = new a();
    this.K = new b();
    this.L = new CopyOnWriteArrayList();
    this.M = 0L;
    this.N = false;
    this.O = false;
    this.P = false;
    this.R = null;
    this.S = new com.huawei.updatesdk.service.deamon.download.b();
    Field[] arrayOfField = DownloadTask.class.getDeclaredFields();
    while (i1 < arrayOfField.length)
    {
      try
      {
        AccessController.doPrivileged(new c(arrayOfField[i1]));
        if (!arrayOfField[i1].isAnnotationPresent(c.class)) {
          break label432;
        }
        Object localObject1 = arrayOfField[i1].getType().getSimpleName();
        Object localObject2 = arrayOfField[i1].getName();
        if ("String".equals(localObject1))
        {
          localObject1 = arrayOfField[i1];
          localObject2 = paramBundle.getString((String)localObject2);
        }
        for (;;)
        {
          ((Field)localObject1).set(this, localObject2);
          break label432;
          if ("int".equals(localObject1))
          {
            localObject1 = arrayOfField[i1];
            localObject2 = Integer.valueOf(paramBundle.getInt((String)localObject2));
          }
          else if ("long".equals(localObject1))
          {
            localObject1 = arrayOfField[i1];
            localObject2 = Long.valueOf(paramBundle.getLong((String)localObject2));
          }
          else
          {
            if (!"float".equals(localObject1)) {
              break;
            }
            localObject1 = arrayOfField[i1];
            localObject2 = Float.valueOf(paramBundle.getFloat((String)localObject2));
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("unsupport field type:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append(arrayOfField[i1].getName());
        a.d("DownloadTask", ((StringBuilder)localObject2).toString());
      }
      catch (IllegalAccessException localIllegalAccessException) {}catch (RuntimeException localRuntimeException) {}
      a.a("DownloadTask", "DownloadTask exception:", localRuntimeException);
      label432:
      i1 += 1;
    }
  }
  
  protected DownloadTask(Parcel paramParcel)
  {
    this.c = 0;
    this.p = 0L;
    this.r = 0L;
    this.d = 0L;
    this.t = 0;
    this.g = 0;
    this.h = false;
    this.u = null;
    this.i = 0;
    this.w = 0;
    this.y = false;
    this.z = true;
    this.C = 1;
    this.D = 0;
    this.E = true;
    this.F = false;
    this.G = false;
    this.H = null;
    this.I = null;
    this.J = new a();
    this.K = new b();
    this.L = new CopyOnWriteArrayList();
    this.M = 0L;
    this.N = false;
    this.O = false;
    this.P = false;
    this.R = null;
    this.S = new com.huawei.updatesdk.service.deamon.download.b();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.o = paramParcel.readString();
    this.p = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readString();
    this.v = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.s = paramParcel.readString();
    this.A = paramParcel.readString();
    this.x = paramParcel.readString();
    this.i = paramParcel.readInt();
    this.w = paramParcel.readInt();
    this.q = paramParcel.readString();
    this.r = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.t = paramParcel.readInt();
    this.a = paramParcel.readString();
    this.B = paramParcel.readInt();
  }
  
  public static int a()
  {
    synchronized (l)
    {
      int i1 = k + 1;
      k = i1;
      if ((i1 == Integer.MIN_VALUE) || (i1 == -1)) {
        k = com.huawei.updatesdk.sdk.a.d.a.b.a();
      }
      i1 = k;
      return i1;
    }
  }
  
  public static DownloadTask a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return new DownloadTask(paramBundle);
  }
  
  public boolean A()
  {
    return this.G;
  }
  
  public boolean B()
  {
    return this.F;
  }
  
  public long C()
  {
    return this.M;
  }
  
  public boolean D()
  {
    return this.O;
  }
  
  public String E()
  {
    return this.b;
  }
  
  public int F()
  {
    return 0;
  }
  
  public boolean G()
  {
    return false;
  }
  
  public void a(int paramInt)
  {
    this.w = paramInt;
  }
  
  /* Error */
  public void a(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(android.net.NetworkInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(String paramString)
  {
    this.x = paramString;
  }
  
  public void a(Future<?> paramFuture)
  {
    this.u = paramFuture;
  }
  
  public void a(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  /* Error */
  public void a(boolean arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public List<b> b()
  {
    return this.L;
  }
  
  public void b(int paramInt)
  {
    this.C = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.d = paramLong;
  }
  
  /* Error */
  public void b(Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void b(String paramString)
  {
    this.A = paramString;
  }
  
  public void b(Future<?> paramFuture)
  {
    this.R = paramFuture;
  }
  
  public void b(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void c(int paramInt)
  {
    this.D = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.M = paramLong;
  }
  
  public void c(String paramString)
  {
    this.H = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.E = paramBoolean;
  }
  
  public a d()
  {
    return this.J;
  }
  
  /* Error */
  public void d(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void d(String paramString)
  {
    this.I = paramString;
  }
  
  public void d(boolean paramBoolean)
  {
    this.N = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public b e()
  {
    return this.K;
  }
  
  public void e(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void e(String paramString)
  {
    this.Q = paramString;
  }
  
  public void e(boolean paramBoolean)
  {
    this.P = paramBoolean;
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void f(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void f(String paramString)
  {
    this.n = paramString;
  }
  
  public int g()
  {
    return this.i;
  }
  
  public void g(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void g(String paramString)
  {
    this.o = paramString;
  }
  
  public String h()
  {
    return this.q;
  }
  
  public void h(String paramString)
  {
    this.e = paramString;
  }
  
  public long i()
  {
    return this.r;
  }
  
  public void i(String paramString)
  {
    this.v = paramString;
  }
  
  public int j()
  {
    return this.C;
  }
  
  public void j(String paramString)
  {
    this.s = paramString;
  }
  
  public int k()
  {
    return this.D;
  }
  
  public void k(String paramString)
  {
    this.b = paramString;
  }
  
  public String l()
  {
    return this.H;
  }
  
  public String m()
  {
    return this.I;
  }
  
  public String n()
  {
    return this.Q;
  }
  
  public int o()
  {
    return this.g;
  }
  
  public int p()
  {
    return this.m;
  }
  
  public int q()
  {
    return 0;
  }
  
  public String r()
  {
    return this.o;
  }
  
  public long s()
  {
    return this.p;
  }
  
  public long t()
  {
    return this.d;
  }
  
  public String toString()
  {
    return null;
  }
  
  public String u()
  {
    return this.e;
  }
  
  public String v()
  {
    return null;
  }
  
  public Future<?> w()
  {
    return this.u;
  }
  
  /* Error */
  public void writeToParcel(Parcel arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String x()
  {
    return this.v;
  }
  
  /* Error */
  public void y()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean z()
  {
    return this.E;
  }
  
  public static class a
  {
    public int a;
    public String b;
    
    public String toString()
    {
      return null;
    }
  }
  
  public static class b
  {
    private long a;
    private long b;
    private boolean c = false;
    
    public void a(long paramLong)
    {
      this.a = paramLong;
    }
    
    public void a(boolean paramBoolean)
    {
      this.c = paramBoolean;
    }
    
    public boolean a()
    {
      return this.c;
    }
    
    public void b(long paramLong)
    {
      this.b = paramLong;
    }
  }
  
  private static class c
    implements PrivilegedAction
  {
    private Field a;
    
    public c(Field paramField)
    {
      this.a = paramField;
    }
    
    public Object run()
    {
      this.a.setAccessible(true);
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\download\bean\DownloadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */