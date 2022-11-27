package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;

public final class d
  extends c
{
  private static HashMap<String, byte[]> f;
  private static HashMap<String, HashMap<String, byte[]>> g;
  private f e;
  
  public d()
  {
    f localf = new f();
    this.e = localf;
    localf.a = 2;
  }
  
  public final void a(int paramInt)
  {
    this.e.b = 1;
  }
  
  public final <T> void a(String paramString, T paramT)
  {
    if (!paramString.startsWith("."))
    {
      super.a(paramString, paramT);
      return;
    }
    paramT = new StringBuilder("put name can not startwith . , now is ");
    paramT.append(paramString);
    throw new IllegalArgumentException(paramT.toString());
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 4) {
      try
      {
        paramArrayOfByte = new i(paramArrayOfByte, 4);
        paramArrayOfByte.a(this.b);
        this.e.a(paramArrayOfByte);
        int i = this.e.a;
        HashMap localHashMap;
        if (i == 3)
        {
          paramArrayOfByte = new i(this.e.e);
          paramArrayOfByte.a(this.b);
          if (f == null)
          {
            localHashMap = new HashMap();
            f = localHashMap;
            localHashMap.put("", new byte[0]);
          }
          this.d = paramArrayOfByte.a(f, 0, false);
          return;
        }
        paramArrayOfByte = new i(this.e.e);
        paramArrayOfByte.a(this.b);
        if (g == null)
        {
          g = new HashMap();
          localHashMap = new HashMap();
          localHashMap.put("", new byte[0]);
          g.put("", localHashMap);
        }
        this.a = paramArrayOfByte.a(g, 0, false);
        new HashMap();
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        throw new RuntimeException(paramArrayOfByte);
      }
    }
    throw new IllegalArgumentException("decode package must include size head");
  }
  
  public final byte[] a()
  {
    if (this.e.a == 2)
    {
      if (!this.e.c.equals(""))
      {
        if (this.e.d.equals("")) {
          throw new IllegalArgumentException("funcName can not is null");
        }
      }
      else {
        throw new IllegalArgumentException("servantName can not is null");
      }
    }
    else
    {
      if (this.e.c == null) {
        this.e.c = "";
      }
      if (this.e.d == null) {
        this.e.d = "";
      }
    }
    Object localObject = new j(0);
    ((j)localObject).a(this.b);
    if (this.e.a == 2) {
      ((j)localObject).a(this.a, 0);
    } else {
      ((j)localObject).a(this.d, 0);
    }
    this.e.e = l.a(((j)localObject).a());
    localObject = new j(0);
    ((j)localObject).a(this.b);
    this.e.a((j)localObject);
    localObject = l.a(((j)localObject).a());
    int i = localObject.length + 4;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
    localByteBuffer.putInt(i).put((byte[])localObject).flip();
    return localByteBuffer.array();
  }
  
  public final void b(String paramString)
  {
    this.e.c = paramString;
  }
  
  public final void c()
  {
    super.c();
    this.e.a = 3;
  }
  
  public final void c(String paramString)
  {
    this.e.d = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */