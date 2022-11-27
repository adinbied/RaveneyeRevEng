package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
{
  private static Proxy e;
  protected HashMap<String, HashMap<String, byte[]>> a = new HashMap();
  protected String b;
  i c;
  private HashMap<String, Object> d;
  
  a()
  {
    new HashMap();
    this.d = new HashMap();
    this.b = "GBK";
    this.c = new i();
  }
  
  public static am a(Context paramContext, int paramInt, byte[] paramArrayOfByte)
  {
    com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
    StrategyBean localStrategyBean = com.tencent.bugly.crashreport.common.strategy.a.a().c();
    am localam;
    if ((locala != null) && (localStrategyBean != null)) {
      try
      {
        localam = new am();
        try
        {
          localam.a = 1;
          localam.b = locala.f();
          localam.c = locala.c;
          localam.d = locala.j;
          localam.e = locala.l;
          localam.f = locala.f;
          localam.g = paramInt;
          byte[] arrayOfByte = paramArrayOfByte;
          if (paramArrayOfByte == null) {
            arrayOfByte = "".getBytes();
          }
          localam.h = arrayOfByte;
          localam.i = locala.i();
          localam.j = locala.h;
          localam.k = new HashMap();
          localam.l = locala.e();
          localam.m = localStrategyBean.n;
          localam.o = locala.h();
          localam.p = com.tencent.bugly.crashreport.common.info.b.b(paramContext);
          localam.q = System.currentTimeMillis();
          localam.r = locala.j();
          paramContext = new StringBuilder();
          paramContext.append(locala.h());
          localam.s = paramContext.toString();
          localam.t = localam.p;
          locala.getClass();
          localam.n = "com.tencent.bugly";
          paramContext = localam.k;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(locala.t());
          paramContext.put("A26", paramArrayOfByte.toString());
          paramContext = localam.k;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(locala.E());
          paramContext.put("A62", paramArrayOfByte.toString());
          paramContext = localam.k;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(locala.F());
          paramContext.put("A63", paramArrayOfByte.toString());
          paramContext = localam.k;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(locala.A);
          paramContext.put("F11", paramArrayOfByte.toString());
          paramContext = localam.k;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(locala.z);
          paramContext.put("F12", paramArrayOfByte.toString());
          paramContext = localam.k;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(locala.k);
          paramContext.put("D3", paramArrayOfByte.toString());
          if (com.tencent.bugly.b.b != null)
          {
            paramContext = com.tencent.bugly.b.b.iterator();
            while (paramContext.hasNext())
            {
              paramArrayOfByte = (com.tencent.bugly.a)paramContext.next();
              if ((paramArrayOfByte.versionKey != null) && (paramArrayOfByte.version != null)) {
                localam.k.put(paramArrayOfByte.versionKey, paramArrayOfByte.version);
              }
            }
          }
          localam.k.put("G15", z.c("G15", ""));
          localam.k.put("G10", z.c("G10", ""));
          localam.k.put("D4", z.c("D4", "0"));
          paramContext = locala.y();
          if (paramContext == null) {
            break label712;
          }
          paramContext = paramContext.entrySet().iterator();
          while (paramContext.hasNext())
          {
            paramArrayOfByte = (Map.Entry)paramContext.next();
            localam.k.put(paramArrayOfByte.getKey(), paramArrayOfByte.getValue());
          }
          paramContext = finally;
        }
        finally {}
        x.e("Can not create request pkg for parameters is invalid.", new Object[0]);
      }
      finally
      {
        if (!x.b(paramContext)) {
          paramContext.printStackTrace();
        }
        return null;
      }
    }
    return null;
    label712:
    return localam;
  }
  
  public static aq a(UserInfoBean paramUserInfoBean)
  {
    if (paramUserInfoBean == null) {
      return null;
    }
    aq localaq = new aq();
    localaq.a = paramUserInfoBean.e;
    localaq.e = paramUserInfoBean.j;
    localaq.d = paramUserInfoBean.c;
    localaq.c = paramUserInfoBean.d;
    boolean bool;
    if (paramUserInfoBean.o == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localaq.g = bool;
    int i = paramUserInfoBean.b;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if ((paramUserInfoBean.b >= 10) && (paramUserInfoBean.b < 20))
            {
              localaq.b = ((byte)paramUserInfoBean.b);
            }
            else
            {
              x.e("unknown uinfo type %d ", new Object[] { Integer.valueOf(paramUserInfoBean.b) });
              return null;
            }
          }
          else {
            localaq.b = 3;
          }
        }
        else {
          localaq.b = 2;
        }
      }
      else {
        localaq.b = 4;
      }
    }
    else {
      localaq.b = 1;
    }
    localaq.f = new HashMap();
    if (paramUserInfoBean.p >= 0)
    {
      localObject1 = localaq.f;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramUserInfoBean.p);
      ((Map)localObject1).put("C01", ((StringBuilder)localObject2).toString());
    }
    if (paramUserInfoBean.q >= 0)
    {
      localObject1 = localaq.f;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramUserInfoBean.q);
      ((Map)localObject1).put("C02", ((StringBuilder)localObject2).toString());
    }
    Map localMap;
    StringBuilder localStringBuilder;
    if ((paramUserInfoBean.r != null) && (paramUserInfoBean.r.size() > 0))
    {
      localObject1 = paramUserInfoBean.r.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localMap = localaq.f;
        localStringBuilder = new StringBuilder("C03_");
        localStringBuilder.append((String)((Map.Entry)localObject2).getKey());
        localMap.put(localStringBuilder.toString(), ((Map.Entry)localObject2).getValue());
      }
    }
    if ((paramUserInfoBean.s != null) && (paramUserInfoBean.s.size() > 0))
    {
      localObject1 = paramUserInfoBean.s.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localMap = localaq.f;
        localStringBuilder = new StringBuilder("C04_");
        localStringBuilder.append((String)((Map.Entry)localObject2).getKey());
        localMap.put(localStringBuilder.toString(), ((Map.Entry)localObject2).getValue());
      }
    }
    Object localObject1 = localaq.f;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.l ^ true);
    ((Map)localObject1).put("A36", ((StringBuilder)localObject2).toString());
    localObject1 = localaq.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.g);
    ((Map)localObject1).put("F02", ((StringBuilder)localObject2).toString());
    localObject1 = localaq.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.h);
    ((Map)localObject1).put("F03", ((StringBuilder)localObject2).toString());
    localObject1 = localaq.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.j);
    ((Map)localObject1).put("F04", ((StringBuilder)localObject2).toString());
    localObject1 = localaq.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.i);
    ((Map)localObject1).put("F05", ((StringBuilder)localObject2).toString());
    localObject1 = localaq.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.m);
    ((Map)localObject1).put("F06", ((StringBuilder)localObject2).toString());
    localObject1 = localaq.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.k);
    ((Map)localObject1).put("F10", ((StringBuilder)localObject2).toString());
    x.c("summary type %d vm:%d", new Object[] { Byte.valueOf(localaq.b), Integer.valueOf(localaq.f.size()) });
    return localaq;
  }
  
  public static ar a(List<UserInfoBean> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return null;
      }
      Object localObject1 = com.tencent.bugly.crashreport.common.info.a.b();
      if (localObject1 == null) {
        return null;
      }
      ((com.tencent.bugly.crashreport.common.info.a)localObject1).p();
      ar localar = new ar();
      localar.b = ((com.tencent.bugly.crashreport.common.info.a)localObject1).d;
      localar.c = ((com.tencent.bugly.crashreport.common.info.a)localObject1).h();
      Object localObject2 = new ArrayList();
      paramList = paramList.iterator();
      Object localObject3;
      while (paramList.hasNext())
      {
        localObject3 = a((UserInfoBean)paramList.next());
        if (localObject3 != null) {
          ((ArrayList)localObject2).add(localObject3);
        }
      }
      localar.d = ((ArrayList)localObject2);
      localar.e = new HashMap();
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).g);
      paramList.put("A7", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).o());
      paramList.put("A6", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).n());
      paramList.put("A5", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).l());
      paramList.put("A2", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).l());
      paramList.put("A1", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).h);
      paramList.put("A24", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).m());
      paramList.put("A17", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).r());
      paramList.put("A15", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).s());
      paramList.put("A13", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).v);
      paramList.put("F08", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).w);
      paramList.put("F09", ((StringBuilder)localObject2).toString());
      paramList = ((com.tencent.bugly.crashreport.common.info.a)localObject1).z();
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = paramList.entrySet().iterator();
        while (paramList.hasNext())
        {
          localObject1 = (Map.Entry)paramList.next();
          localObject2 = localar.e;
          localObject3 = new StringBuilder("C04_");
          ((StringBuilder)localObject3).append((String)((Map.Entry)localObject1).getKey());
          ((Map)localObject2).put(((StringBuilder)localObject3).toString(), ((Map.Entry)localObject1).getValue());
        }
      }
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          x.e("unknown up type %d ", new Object[] { Integer.valueOf(paramInt) });
          return null;
        }
        localar.a = 2;
        return localar;
      }
      localar.a = 1;
      return localar;
    }
    return null;
  }
  
  public static <T extends k> T a(byte[] paramArrayOfByte, Class<T> paramClass)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return null;
      }
      try
      {
        paramClass = (k)paramClass.newInstance();
        paramArrayOfByte = new i(paramArrayOfByte);
        paramArrayOfByte.a("utf-8");
        paramClass.a(paramArrayOfByte);
        return paramClass;
      }
      finally
      {
        if (!x.b(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static String a(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j;
    Object localObject;
    for (;;)
    {
      j = paramArrayList.size();
      localObject = "map";
      if (i >= j) {
        break;
      }
      String str = (String)paramArrayList.get(i);
      if ((!str.equals("java.lang.Integer")) && (!str.equals("int")))
      {
        if ((!str.equals("java.lang.Boolean")) && (!str.equals("boolean")))
        {
          if ((!str.equals("java.lang.Byte")) && (!str.equals("byte")))
          {
            if ((!str.equals("java.lang.Double")) && (!str.equals("double")))
            {
              if ((!str.equals("java.lang.Float")) && (!str.equals("float")))
              {
                if ((!str.equals("java.lang.Long")) && (!str.equals("long")))
                {
                  if ((!str.equals("java.lang.Short")) && (!str.equals("short")))
                  {
                    if (!str.equals("java.lang.Character"))
                    {
                      if (str.equals("java.lang.String")) {
                        localObject = "string";
                      } else if (str.equals("java.util.List")) {
                        localObject = "list";
                      } else if (!str.equals("java.util.Map")) {
                        localObject = str;
                      }
                    }
                    else {
                      throw new IllegalArgumentException("can not support java.lang.Character");
                    }
                  }
                  else {
                    localObject = "short";
                  }
                }
                else {
                  localObject = "int64";
                }
              }
              else {
                localObject = "float";
              }
            }
            else {
              localObject = "double";
            }
          }
          else {
            localObject = "char";
          }
        }
        else {
          localObject = "bool";
        }
      }
      else {
        localObject = "int32";
      }
      paramArrayList.set(i, localObject);
      i += 1;
    }
    Collections.reverse(paramArrayList);
    i = 0;
    while (i < paramArrayList.size())
    {
      localObject = (String)paramArrayList.get(i);
      if (((String)localObject).equals("list"))
      {
        j = i - 1;
        localObject = new StringBuilder("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
      }
      else if (((String)localObject).equals("map"))
      {
        j = i - 1;
        localObject = new StringBuilder("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        ((StringBuilder)localObject).append(",");
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
      }
      else if (((String)localObject).equals("Array"))
      {
        j = i - 1;
        localObject = new StringBuilder("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
      }
      i += 1;
    }
    Collections.reverse(paramArrayList);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuffer.append((String)paramArrayList.next());
    }
    return localStringBuffer.toString();
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      e = null;
      return;
    }
    e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramString, paramInt));
  }
  
  public static void a(InetAddress paramInetAddress, int paramInt)
  {
    if (paramInetAddress == null)
    {
      e = null;
      return;
    }
    e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramInetAddress, paramInt));
  }
  
  private void a(ArrayList<String> paramArrayList, Object paramObject)
  {
    if (paramObject.getClass().isArray())
    {
      if (paramObject.getClass().getComponentType().toString().equals("byte"))
      {
        if (Array.getLength(paramObject) > 0)
        {
          paramArrayList.add("java.util.List");
          a(paramArrayList, Array.get(paramObject, 0));
          return;
        }
        paramArrayList.add("Array");
        paramArrayList.add("?");
        return;
      }
      throw new IllegalArgumentException("only byte[] is supported");
    }
    if (!(paramObject instanceof Array))
    {
      if ((paramObject instanceof List))
      {
        paramArrayList.add("java.util.List");
        paramObject = (List)paramObject;
        if (((List)paramObject).size() > 0)
        {
          a(paramArrayList, ((List)paramObject).get(0));
          return;
        }
        paramArrayList.add("?");
        return;
      }
      if ((paramObject instanceof Map))
      {
        paramArrayList.add("java.util.Map");
        Object localObject = (Map)paramObject;
        if (((Map)localObject).size() > 0)
        {
          paramObject = ((Map)localObject).keySet().iterator().next();
          localObject = ((Map)localObject).get(paramObject);
          paramArrayList.add(paramObject.getClass().getName());
          a(paramArrayList, localObject);
          return;
        }
        paramArrayList.add("?");
        paramArrayList.add("?");
        return;
      }
      paramArrayList.add(paramObject.getClass().getName());
      return;
    }
    throw new IllegalArgumentException("can not support Array, please use List");
  }
  
  public static byte[] a(k paramk)
  {
    try
    {
      j localj = new j();
      localj.a("utf-8");
      paramk.a(localj);
      paramk = localj.b();
      return paramk;
    }
    finally
    {
      if (!x.b(paramk)) {
        paramk.printStackTrace();
      }
    }
    return null;
  }
  
  public static byte[] a(Object paramObject)
  {
    try
    {
      d locald = new d();
      locald.c();
      locald.a("utf-8");
      locald.a(1);
      locald.b("RqdServer");
      locald.c("sync");
      locald.a("detail", paramObject);
      paramObject = locald.a();
      return (byte[])paramObject;
    }
    finally
    {
      if (!x.b((Throwable)paramObject)) {
        ((Throwable)paramObject).printStackTrace();
      }
    }
    return null;
  }
  
  public static an b(byte[] paramArrayOfByte)
  {
    Object localObject1 = null;
    if (paramArrayOfByte != null) {
      try
      {
        Object localObject2 = new d();
        ((d)localObject2).c();
        ((d)localObject2).a("utf-8");
        ((d)localObject2).a(paramArrayOfByte);
        localObject2 = ((d)localObject2).b("detail", new an());
        paramArrayOfByte = (byte[])localObject1;
        if (an.class.isInstance(localObject2)) {
          paramArrayOfByte = (an)an.class.cast(localObject2);
        }
        return paramArrayOfByte;
      }
      finally
      {
        if (!x.b(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static Proxy b()
  {
    return e;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public <T> void a(String paramString, T paramT)
  {
    if (paramString != null)
    {
      if (paramT != null)
      {
        if (!(paramT instanceof Set))
        {
          Object localObject = new j();
          ((j)localObject).a(this.b);
          ((j)localObject).a(paramT, 0);
          localObject = l.a(((j)localObject).a());
          HashMap localHashMap = new HashMap(1);
          ArrayList localArrayList = new ArrayList(1);
          a(localArrayList, paramT);
          localHashMap.put(a(localArrayList), localObject);
          this.d.remove(paramString);
          this.a.put(paramString, localHashMap);
          return;
        }
        throw new IllegalArgumentException("can not support Set");
      }
      throw new IllegalArgumentException("put value can not is null");
    }
    throw new IllegalArgumentException("put key can not is null");
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.c.a(paramArrayOfByte);
    this.c.a(this.b);
    paramArrayOfByte = new HashMap(1);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("", new byte[0]);
    paramArrayOfByte.put("", localHashMap);
    this.a = this.c.a(paramArrayOfByte, 0, false);
  }
  
  public byte[] a()
  {
    j localj = new j(0);
    localj.a(this.b);
    localj.a(this.a, 0);
    return l.a(localj.a());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */