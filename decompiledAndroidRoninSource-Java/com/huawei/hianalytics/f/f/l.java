package com.huawei.hianalytics.f.f;

import android.util.Pair;
import com.huawei.hianalytics.f.b.h;
import com.huawei.hianalytics.f.b.i;
import com.huawei.hianalytics.f.b.j;
import com.huawei.hianalytics.f.d.a.a;
import com.huawei.hianalytics.f.g.f;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class l
{
  static h a(List<com.huawei.hianalytics.f.b.e> paramList, String paramString1, String paramString2)
  {
    com.huawei.hianalytics.f.c.a locala = g.a().b();
    long l1 = locala.c();
    if (l1 == 0L)
    {
      l1 = System.currentTimeMillis();
      localObject1 = com.huawei.hianalytics.f.g.e.a();
      localObject2 = f.a((String)localObject1);
      locala.a(l1);
      locala.a((String)localObject1);
      locala.b((String)localObject2);
    }
    else
    {
      l2 = System.currentTimeMillis();
      if (l2 - l1 > 43200000L)
      {
        localObject1 = com.huawei.hianalytics.f.g.e.a();
        localObject2 = f.a((String)localObject1);
        locala.a(l2);
        locala.a((String)localObject1);
        locala.b((String)localObject2);
      }
      else
      {
        localObject1 = locala.a();
        localObject2 = locala.b();
      }
    }
    Object localObject1 = new h((String)localObject1, paramString2, paramString1);
    ((h)localObject1).a(a((String)localObject2, paramString2, paramString1));
    ((h)localObject1).a(b(paramString1, paramString2));
    ((h)localObject1).a(a(paramString1, paramString2));
    Object localObject2 = new ArrayList();
    l1 = System.currentTimeMillis();
    long l2 = com.huawei.hianalytics.a.c.g(paramString2, paramString1);
    long l3 = Long.valueOf(86400000L).longValue();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramString1 = (com.huawei.hianalytics.f.b.e)paramList.next();
      if (!paramString1.a(l1, l2 * l3)) {
        ((List)localObject2).add(paramString1.a());
      }
    }
    ((h)localObject1).a((List)localObject2);
    return (h)localObject1;
  }
  
  private static i a(String paramString1, String paramString2, String paramString3)
  {
    i locali = new i();
    locali.b(paramString1);
    locali.d(com.huawei.hianalytics.a.b.e());
    locali.a(paramString2);
    paramString1 = new StringBuffer("hmshi");
    paramString1.append(paramString3);
    paramString1.append("qrt");
    locali.c(paramString1.toString());
    paramString1 = com.huawei.hianalytics.a.b.b(com.huawei.hianalytics.d.a.a().g(paramString2, paramString3));
    try
    {
      com.huawei.hianalytics.f.d.a.a(locali.a(), paramString1, new a(locali));
      return locali;
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      for (;;) {}
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      for (;;) {}
    }
    paramString1 = "generateHeadData(): UnsatisfiedLinkError";
    break label95;
    paramString1 = "generateHeadData(): NoSuchAlgorithmException";
    label95:
    com.huawei.hianalytics.g.b.c("HiAnalytics/event", paramString1);
    return locali;
  }
  
  private static j a(String paramString1, String paramString2)
  {
    j localj = new j();
    a(localj, paramString1, paramString2);
    return localj;
  }
  
  static List<com.huawei.hianalytics.f.b.e> a(com.huawei.hianalytics.f.b.c[] paramArrayOfc)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfc.length);
    int j = paramArrayOfc.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new com.huawei.hianalytics.f.b.g(paramArrayOfc[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  private static void a(com.huawei.hianalytics.f.b.b paramb, String paramString1, String paramString2)
  {
    if (paramb == null) {
      return;
    }
    String str2 = com.huawei.hianalytics.d.a.a().d(paramString2, paramString1);
    Object localObject1 = com.huawei.hianalytics.d.a.a().a(paramString2, paramString1);
    Object localObject2 = ((com.huawei.hianalytics.c.a)localObject1).a();
    int i = 1.a[localObject2.ordinal()];
    String str1 = "";
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          localObject1 = "";
          localObject2 = localObject1;
        }
        else
        {
          localObject1 = ((com.huawei.hianalytics.c.a)localObject1).b();
          localObject2 = "";
        }
      }
      else
      {
        str1 = ((com.huawei.hianalytics.c.a)localObject1).b();
        localObject2 = "";
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject2 = ((com.huawei.hianalytics.c.a)localObject1).b();
      localObject1 = "";
    }
    paramb.a(str2);
    paramb.c(com.huawei.hianalytics.a.b.b(com.huawei.hianalytics.d.a.a().g(paramString2, paramString1)));
    paramb.b(str1);
    paramb.d(com.huawei.hianalytics.d.a.a().c(paramString2, paramString1));
    paramString1 = com.huawei.hianalytics.a.c.a(paramString2, paramString1);
    paramb.e((String)localObject1);
    paramb.g((String)localObject2);
    paramb.f(paramString1);
  }
  
  private static void a(j paramj, String paramString1, String paramString2)
  {
    paramj.c(com.huawei.hianalytics.a.b.b());
    Pair localPair = com.huawei.hianalytics.d.a.a().b(paramString2, paramString1);
    paramj.f((String)localPair.first);
    paramj.g((String)localPair.second);
    paramj.d(com.huawei.hianalytics.a.b.d());
    paramj.e((String)com.huawei.hianalytics.f.g.g.b(com.huawei.hianalytics.f.g.g.b(g.a().c(), "global_v2"), "app_ver", ""));
    paramj.b(com.huawei.hianalytics.d.a.a().e(paramString2, paramString1));
    paramj.a(com.huawei.hianalytics.d.a.a().f(paramString2, paramString1));
  }
  
  private static com.huawei.hianalytics.f.b.b b(String paramString1, String paramString2)
  {
    com.huawei.hianalytics.f.b.b localb = new com.huawei.hianalytics.f.b.b();
    a(localb, paramString1, paramString2);
    return localb;
  }
  
  private static class a
    implements a.a
  {
    private i a;
    
    public a(i parami)
    {
      this.a = parami;
    }
    
    /* Error */
    public void a(long arg1, byte[] arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\f\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */