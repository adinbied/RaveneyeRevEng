package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.k;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private Context a;
  private long b;
  private int c;
  private boolean d = true;
  
  public a(Context paramContext, boolean paramBoolean)
  {
    this.a = paramContext;
    this.d = paramBoolean;
  }
  
  private static ContentValues a(UserInfoBean paramUserInfoBean)
  {
    if (paramUserInfoBean == null) {
      return null;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      if (paramUserInfoBean.a > 0L) {
        localContentValues.put("_id", Long.valueOf(paramUserInfoBean.a));
      }
      localContentValues.put("_tm", Long.valueOf(paramUserInfoBean.e));
      localContentValues.put("_ut", Long.valueOf(paramUserInfoBean.f));
      localContentValues.put("_tp", Integer.valueOf(paramUserInfoBean.b));
      localContentValues.put("_pc", paramUserInfoBean.c);
      localContentValues.put("_dt", z.a(paramUserInfoBean));
      return localContentValues;
    }
    finally
    {
      if (!x.a(paramUserInfoBean)) {
        paramUserInfoBean.printStackTrace();
      }
    }
    return null;
  }
  
  private static UserInfoBean a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      if (arrayOfByte == null) {
        return null;
      }
      long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      paramCursor = (UserInfoBean)z.a(arrayOfByte, UserInfoBean.CREATOR);
      if (paramCursor != null) {
        paramCursor.a = l;
      }
      return paramCursor;
    }
    finally
    {
      if (!x.a(paramCursor)) {
        paramCursor.printStackTrace();
      }
    }
    return null;
  }
  
  private static void a(List<UserInfoBean> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while ((i < paramList.size()) && (i < 50))
      {
        localObject = (UserInfoBean)paramList.get(i);
        localStringBuilder.append(" or _id");
        localStringBuilder.append(" = ");
        localStringBuilder.append(((UserInfoBean)localObject).a);
        i += 1;
      }
      Object localObject = localStringBuilder.toString();
      paramList = (List<UserInfoBean>)localObject;
      if (((String)localObject).length() > 0) {
        paramList = ((String)localObject).substring(4);
      }
      localStringBuilder.setLength(0);
      try
      {
        x.c("[Database] deleted %s data %d", new Object[] { "t_ui", Integer.valueOf(p.a().a("t_ui", paramList, null, null, true)) });
        return;
      }
      finally
      {
        if (!x.a(paramList)) {
          paramList.printStackTrace();
        }
      }
    }
  }
  
  private void c()
  {
    for (;;)
    {
      int j;
      int k;
      try
      {
        bool = this.d;
        if (!bool) {
          return;
        }
        final Object localObject1 = u.a();
        if (localObject1 == null) {
          return;
        }
        Object localObject3 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (localObject3 == null) {
          return;
        }
        if (((com.tencent.bugly.crashreport.common.strategy.a)localObject3).b())
        {
          bool = ((u)localObject1).b(1001);
          if (!bool) {
            return;
          }
        }
        localObject1 = com.tencent.bugly.crashreport.common.info.a.a(this.a).d;
        Object localObject4 = new ArrayList();
        localObject3 = a((String)localObject1);
        Object localObject5;
        if (localObject3 != null)
        {
          int m = ((List)localObject3).size() - 20;
          if (m > 0)
          {
            i = 0;
            if (i >= ((List)localObject3).size() - 1) {
              break label681;
            }
            j = i + 1;
            k = j;
            if (k >= ((List)localObject3).size()) {
              break label676;
            }
            if (((UserInfoBean)((List)localObject3).get(i)).e <= ((UserInfoBean)((List)localObject3).get(k)).e) {
              break label669;
            }
            localObject1 = (UserInfoBean)((List)localObject3).get(i);
            ((List)localObject3).set(i, ((List)localObject3).get(k));
            ((List)localObject3).set(k, localObject1);
            break label669;
            if (i < m)
            {
              ((List)localObject4).add(((List)localObject3).get(i));
              i += 1;
              continue;
            }
          }
          localObject1 = ((List)localObject3).iterator();
          i = 0;
          if (((Iterator)localObject1).hasNext())
          {
            localObject5 = (UserInfoBean)((Iterator)localObject1).next();
            if (((UserInfoBean)localObject5).f != -1L)
            {
              ((Iterator)localObject1).remove();
              if (((UserInfoBean)localObject5).e < z.b()) {
                ((List)localObject4).add(localObject5);
              }
            }
            if (((UserInfoBean)localObject5).e <= System.currentTimeMillis() - 600000L) {
              continue;
            }
            if ((((UserInfoBean)localObject5).b == 1) || (((UserInfoBean)localObject5).b == 4)) {
              break label686;
            }
            if (((UserInfoBean)localObject5).b != 3) {
              continue;
            }
            break label686;
          }
          localObject1 = localObject3;
          if (i <= 15) {
            break label693;
          }
          x.d("[UserInfo] Upload user info too many times in 10 min: %d", new Object[] { Integer.valueOf(i) });
          i = 0;
          localObject1 = localObject3;
        }
        else
        {
          localObject1 = new ArrayList();
          break label693;
        }
        if (((List)localObject4).size() > 0) {
          a((List)localObject4);
        }
        if ((i != 0) && (((List)localObject1).size() != 0))
        {
          x.c("[UserInfo] Upload user info(size: %d)", new Object[] { Integer.valueOf(((List)localObject1).size()) });
          if (this.c != 1) {
            break label698;
          }
          i = 1;
          localObject3 = com.tencent.bugly.proguard.a.a((List)localObject1, i);
          if (localObject3 == null)
          {
            x.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
            return;
          }
          localObject3 = com.tencent.bugly.proguard.a.a((k)localObject3);
          if (localObject3 == null)
          {
            x.d("[UserInfo] Failed to encode data.", new Object[0]);
            return;
          }
          localObject3 = com.tencent.bugly.proguard.a.a(this.a, 840, (byte[])localObject3);
          if (localObject3 == null)
          {
            x.d("[UserInfo] Request package is null.", new Object[0]);
            return;
          }
          localObject1 = new t()
          {
            public final void a(boolean paramAnonymousBoolean)
            {
              if (paramAnonymousBoolean)
              {
                x.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                long l = System.currentTimeMillis();
                Iterator localIterator = localObject1.iterator();
                while (localIterator.hasNext())
                {
                  UserInfoBean localUserInfoBean = (UserInfoBean)localIterator.next();
                  localUserInfoBean.f = l;
                  a.a(a.this, localUserInfoBean, true);
                }
              }
            }
          };
          localObject4 = com.tencent.bugly.crashreport.common.strategy.a.a().c().p;
          localObject5 = StrategyBean.a;
          u localu = u.a();
          if (this.c != 1) {
            break label703;
          }
          bool = true;
          localu.a(1001, (am)localObject3, (String)localObject4, (String)localObject5, (t)localObject1, bool);
          return;
        }
        x.c("[UserInfo] There is no user info in local database.", new Object[0]);
        return;
      }
      finally {}
      label669:
      k += 1;
      continue;
      label676:
      int i = j;
      continue;
      label681:
      i = 0;
      continue;
      label686:
      i += 1;
      continue;
      label693:
      i = 1;
      continue;
      label698:
      i = 2;
      continue;
      label703:
      boolean bool = false;
    }
  }
  
  public final List<UserInfoBean> a(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if (z.a(paramString))
        {
          paramString = null;
        }
        else
        {
          localObject1 = new StringBuilder("_pc = '");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("'");
          paramString = ((StringBuilder)localObject1).toString();
        }
        paramString = p.a().a("t_ui", null, paramString, null, null, true);
        if (paramString == null)
        {
          if (paramString != null) {
            paramString.close();
          }
          return null;
        }
        try
        {
          localObject4 = new StringBuilder();
          localObject1 = new ArrayList();
          if (paramString.moveToNext())
          {
            UserInfoBean localUserInfoBean = a(paramString);
            if (localUserInfoBean != null) {
              ((List)localObject1).add(localUserInfoBean);
            }
          }
        }
        finally
        {
          Object localObject4;
          long l;
        }
      }
      finally
      {
        paramString = null;
      }
      try
      {
        l = paramString.getLong(paramString.getColumnIndex("_id"));
        ((StringBuilder)localObject4).append(" or _id");
        ((StringBuilder)localObject4).append(" = ");
        ((StringBuilder)localObject4).append(l);
        continue;
      }
      finally {}
      x.d("[Database] unknown id.", new Object[0]);
    }
    localObject4 = ((StringBuilder)localObject4).toString();
    if (((String)localObject4).length() > 0)
    {
      localObject4 = ((String)localObject4).substring(4);
      x.d("[Database] deleted %s error data %d", new Object[] { "t_ui", Integer.valueOf(p.a().a("t_ui", (String)localObject4, null, null, true)) });
    }
    if (paramString != null) {
      paramString.close();
    }
    return (List<UserInfoBean>)localObject1;
    try
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
      return null;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
    }
  }
  
  public final void a()
  {
    this.b = (z.b() + 86400000L);
    w.a().a(new b(), this.b - System.currentTimeMillis() + 5000L);
  }
  
  public final void a(int paramInt, boolean paramBoolean, long paramLong)
  {
    Object localObject = com.tencent.bugly.crashreport.common.strategy.a.a();
    int i = 0;
    if ((localObject != null) && (!((com.tencent.bugly.crashreport.common.strategy.a)localObject).c().f) && (paramInt != 1) && (paramInt != 3))
    {
      x.e("UserInfo is disable", new Object[0]);
      return;
    }
    if ((paramInt == 1) || (paramInt == 3)) {
      this.c += 1;
    }
    localObject = com.tencent.bugly.crashreport.common.info.a.a(this.a);
    UserInfoBean localUserInfoBean = new UserInfoBean();
    localUserInfoBean.b = paramInt;
    localUserInfoBean.c = ((com.tencent.bugly.crashreport.common.info.a)localObject).d;
    localUserInfoBean.d = ((com.tencent.bugly.crashreport.common.info.a)localObject).g();
    localUserInfoBean.e = System.currentTimeMillis();
    localUserInfoBean.f = -1L;
    localUserInfoBean.n = ((com.tencent.bugly.crashreport.common.info.a)localObject).j;
    if (paramInt == 1) {
      i = 1;
    }
    localUserInfoBean.o = i;
    localUserInfoBean.l = ((com.tencent.bugly.crashreport.common.info.a)localObject).a();
    localUserInfoBean.m = ((com.tencent.bugly.crashreport.common.info.a)localObject).p;
    localUserInfoBean.g = ((com.tencent.bugly.crashreport.common.info.a)localObject).q;
    localUserInfoBean.h = ((com.tencent.bugly.crashreport.common.info.a)localObject).r;
    localUserInfoBean.i = ((com.tencent.bugly.crashreport.common.info.a)localObject).s;
    localUserInfoBean.k = ((com.tencent.bugly.crashreport.common.info.a)localObject).t;
    localUserInfoBean.r = ((com.tencent.bugly.crashreport.common.info.a)localObject).u();
    localUserInfoBean.s = ((com.tencent.bugly.crashreport.common.info.a)localObject).z();
    localUserInfoBean.p = ((com.tencent.bugly.crashreport.common.info.a)localObject).A();
    localUserInfoBean.q = ((com.tencent.bugly.crashreport.common.info.a)localObject).B();
    w.a().a(new a(localUserInfoBean, paramBoolean), 0L);
  }
  
  public final void b()
  {
    w localw = w.a();
    if (localw != null) {
      localw.a(new Runnable()
      {
        public final void run()
        {
          try
          {
            a.a(a.this);
            return;
          }
          finally
          {
            x.a(localThrowable);
          }
        }
      });
    }
  }
  
  final class a
    implements Runnable
  {
    private boolean a;
    private UserInfoBean b;
    
    public a(UserInfoBean paramUserInfoBean, boolean paramBoolean)
    {
      this.b = paramUserInfoBean;
      this.a = paramBoolean;
    }
    
    public final void run()
    {
      try
      {
        Object localObject1;
        Object localObject2;
        if (this.b != null)
        {
          localObject1 = this.b;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.bugly.crashreport.common.info.a.b();
            if (localObject2 != null) {
              ((UserInfoBean)localObject1).j = ((com.tencent.bugly.crashreport.common.info.a)localObject2).e();
            }
          }
          x.c("[UserInfo] Record user info.", new Object[0]);
          a.a(a.this, this.b, false);
        }
        if (this.a)
        {
          localObject1 = a.this;
          localObject2 = w.a();
          if (localObject2 != null) {
            ((w)localObject2).a(new a.2((a)localObject1));
          }
        }
        return;
      }
      finally
      {
        if (!x.a(localThrowable)) {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      long l = System.currentTimeMillis();
      if (l < a.b(a.this))
      {
        w.a().a(new b(a.this), a.b(a.this) - l + 5000L);
        return;
      }
      a.this.a(3, false, 0L);
      a.this.a();
    }
  }
  
  final class c
    implements Runnable
  {
    private long a = 21600000L;
    
    public c(long paramLong)
    {
      this.a = paramLong;
    }
    
    public final void run()
    {
      a locala = a.this;
      w localw = w.a();
      if (localw != null) {
        localw.a(new a.2(locala));
      }
      locala = a.this;
      long l = this.a;
      w.a().a(new c(locala, l), l);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\biz\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */