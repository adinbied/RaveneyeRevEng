package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class i
{
  private ByteBuffer a;
  private String b = "GBK";
  
  public i() {}
  
  public i(byte[] paramArrayOfByte)
  {
    this.a = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public i(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    this.a = paramArrayOfByte;
    paramArrayOfByte.position(4);
  }
  
  private double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      a locala = new a();
      a(locala, this.a);
      paramInt = locala.a;
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt == 12) {
            return 0.0D;
          }
          throw new g("type mismatch.");
        }
        return this.a.getDouble();
      }
      return this.a.getFloat();
    }
    if (!paramBoolean) {
      return paramDouble;
    }
    throw new g("require field not exist.");
  }
  
  private float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      a locala = new a();
      a(locala, this.a);
      paramInt = locala.a;
      if (paramInt != 4)
      {
        if (paramInt == 12) {
          return 0.0F;
        }
        throw new g("type mismatch.");
      }
      return this.a.getFloat();
    }
    if (!paramBoolean) {
      return paramFloat;
    }
    throw new g("require field not exist.");
  }
  
  private static int a(a parama, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.get();
    parama.a = ((byte)(i & 0xF));
    parama.b = ((i & 0xF0) >> 4);
    if (parama.b == 15)
    {
      parama.b = paramByteBuffer.get();
      return 2;
    }
    return 1;
  }
  
  private <K, V> Map<K, V> a(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean)
  {
    if ((paramMap2 != null) && (!paramMap2.isEmpty()))
    {
      Object localObject = (Map.Entry)paramMap2.entrySet().iterator().next();
      paramMap2 = ((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (a(paramInt))
      {
        a locala = new a();
        a(locala, this.a);
        if (locala.a == 8)
        {
          int i = a(0, 0, true);
          if (i >= 0)
          {
            paramInt = 0;
            while (paramInt < i)
            {
              paramMap1.put(a(paramMap2, 0, true), a(localObject, 1, true));
              paramInt += 1;
            }
          }
          paramMap1 = new StringBuilder("size invalid: ");
          paramMap1.append(i);
          throw new g(paramMap1.toString());
        }
        throw new g("type mismatch.");
      }
      if (!paramBoolean) {
        return paramMap1;
      }
      throw new g("require field not exist.");
    }
    return new HashMap();
  }
  
  private void a()
  {
    a locala = new a();
    do
    {
      a(locala, this.a);
      a(locala.a);
    } while (locala.a != 11);
  }
  
  private void a(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    switch (paramByte)
    {
    default: 
      throw new g("invalid type.");
    case 13: 
      localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 0)
      {
        paramByte = a(0, 0, true);
        localObject = this.a;
        ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + paramByte);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("skipField with invalid type, type value: ");
      localStringBuilder.append(paramByte);
      localStringBuilder.append(", ");
      localStringBuilder.append(((a)localObject).a);
      throw new g(localStringBuilder.toString());
    case 11: 
    case 12: 
      return;
    case 10: 
      a();
      return;
    case 9: 
      b2 = a(0, 0, true);
      paramByte = b1;
      while (paramByte < b2)
      {
        localObject = new a();
        a((a)localObject, this.a);
        a(((a)localObject).a);
        paramByte += 1;
      }
      return;
    case 8: 
      b1 = a(0, 0, true);
      paramByte = b2;
      while (paramByte < b1 << 1)
      {
        localObject = new a();
        a((a)localObject, this.a);
        a(((a)localObject).a);
        paramByte += 1;
      }
      return;
    case 7: 
      paramByte = this.a.getInt();
      localObject = this.a;
      ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + paramByte);
      return;
    case 6: 
      b1 = this.a.get();
      paramByte = b1;
      if (b1 < 0) {
        paramByte = b1 + 256;
      }
      localObject = this.a;
      ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + paramByte);
      return;
    case 5: 
      localObject = this.a;
      ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + 8);
      return;
    case 4: 
      localObject = this.a;
      ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + 4);
      return;
    case 3: 
      localObject = this.a;
      ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + 8);
      return;
    case 2: 
      localObject = this.a;
      ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + 4);
      return;
    case 1: 
      localObject = this.a;
      ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + 2);
      return;
    }
    Object localObject = this.a;
    ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + 1);
  }
  
  private boolean a(int paramInt)
  {
    try
    {
      a locala = new a();
      for (;;)
      {
        i = a(locala, this.a.duplicate());
        if ((paramInt <= locala.b) || (locala.a == 11)) {
          break;
        }
        this.a.position(this.a.position() + i);
        a(locala.a);
      }
      int i = locala.b;
      return paramInt == i;
    }
    catch (g|BufferUnderflowException localg) {}
    return false;
  }
  
  private <T> T[] a(T[] paramArrayOfT, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfT != null) && (paramArrayOfT.length != 0)) {
      return b(paramArrayOfT[0], paramInt, paramBoolean);
    }
    throw new g("unable to get type of key and value.");
  }
  
  private <T> T[] b(T paramT, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      Object localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          localObject = (Object[])Array.newInstance(paramT.getClass(), i);
          paramInt = 0;
          while (paramInt < i)
          {
            localObject[paramInt] = a(paramT, 0, true);
            paramInt += 1;
          }
          return (T[])localObject;
        }
        paramT = new StringBuilder("size invalid: ");
        paramT.append(i);
        throw new g(paramT.toString());
      }
      throw new g("type mismatch.");
    }
    if (!paramBoolean) {
      return null;
    }
    throw new g("require field not exist.");
  }
  
  private boolean[] d(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          boolean[] arrayOfBoolean = new boolean[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfBoolean;
            if (paramInt >= i) {
              break;
            }
            if (a((byte)0, 0, true) != 0) {
              paramBoolean = true;
            } else {
              paramBoolean = false;
            }
            arrayOfBoolean[paramInt] = paramBoolean;
            paramInt += 1;
          }
        }
        localObject = new StringBuilder("size invalid: ");
        ((StringBuilder)localObject).append(i);
        throw new g(((StringBuilder)localObject).toString());
      }
      throw new g("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return (boolean[])localObject;
    }
    throw new g("require field not exist.");
  }
  
  private short[] e(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          short[] arrayOfShort = new short[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfShort;
            if (paramInt >= i) {
              break;
            }
            arrayOfShort[paramInt] = a(arrayOfShort[0], 0, true);
            paramInt += 1;
          }
        }
        localObject = new StringBuilder("size invalid: ");
        ((StringBuilder)localObject).append(i);
        throw new g(((StringBuilder)localObject).toString());
      }
      throw new g("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return (short[])localObject;
    }
    throw new g("require field not exist.");
  }
  
  private int[] f(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          int[] arrayOfInt = new int[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfInt;
            if (paramInt >= i) {
              break;
            }
            arrayOfInt[paramInt] = a(arrayOfInt[0], 0, true);
            paramInt += 1;
          }
        }
        localObject = new StringBuilder("size invalid: ");
        ((StringBuilder)localObject).append(i);
        throw new g(((StringBuilder)localObject).toString());
      }
      throw new g("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return (int[])localObject;
    }
    throw new g("require field not exist.");
  }
  
  private long[] g(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          long[] arrayOfLong = new long[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfLong;
            if (paramInt >= i) {
              break;
            }
            arrayOfLong[paramInt] = a(arrayOfLong[0], 0, true);
            paramInt += 1;
          }
        }
        localObject = new StringBuilder("size invalid: ");
        ((StringBuilder)localObject).append(i);
        throw new g(((StringBuilder)localObject).toString());
      }
      throw new g("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return (long[])localObject;
    }
    throw new g("require field not exist.");
  }
  
  private float[] h(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          float[] arrayOfFloat = new float[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfFloat;
            if (paramInt >= i) {
              break;
            }
            arrayOfFloat[paramInt] = a(arrayOfFloat[0], 0, true);
            paramInt += 1;
          }
        }
        localObject = new StringBuilder("size invalid: ");
        ((StringBuilder)localObject).append(i);
        throw new g(((StringBuilder)localObject).toString());
      }
      throw new g("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return (float[])localObject;
    }
    throw new g("require field not exist.");
  }
  
  private double[] i(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          double[] arrayOfDouble = new double[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfDouble;
            if (paramInt >= i) {
              break;
            }
            arrayOfDouble[paramInt] = a(arrayOfDouble[0], 0, true);
            paramInt += 1;
          }
        }
        localObject = new StringBuilder("size invalid: ");
        ((StringBuilder)localObject).append(i);
        throw new g(((StringBuilder)localObject).toString());
      }
      throw new g("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return (double[])localObject;
    }
    throw new g("require field not exist.");
  }
  
  public final byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      a locala = new a();
      a(locala, this.a);
      paramInt = locala.a;
      if (paramInt != 0)
      {
        if (paramInt == 12) {
          return 0;
        }
        throw new g("type mismatch.");
      }
      return this.a.get();
    }
    if (!paramBoolean) {
      return paramByte;
    }
    throw new g("require field not exist.");
  }
  
  public final int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (a(paramInt2))
    {
      a locala = new a();
      a(locala, this.a);
      paramInt1 = locala.a;
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 == 12) {
              return 0;
            }
            throw new g("type mismatch.");
          }
          return this.a.getInt();
        }
        return this.a.getShort();
      }
      return this.a.get();
    }
    if (!paramBoolean) {
      return paramInt1;
    }
    throw new g("require field not exist.");
  }
  
  public final int a(String paramString)
  {
    this.b = paramString;
    return 0;
  }
  
  public final long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      a locala = new a();
      a(locala, this.a);
      paramInt = locala.a;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt == 12) {
                return 0L;
              }
              throw new g("type mismatch.");
            }
            return this.a.getLong();
          }
          paramInt = this.a.getInt();
        }
        else
        {
          paramInt = this.a.getShort();
        }
      }
      else {
        paramInt = this.a.get();
      }
      return paramInt;
    }
    if (!paramBoolean) {
      return paramLong;
    }
    throw new g("require field not exist.");
  }
  
  public final k a(k paramk, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt)) {
      try
      {
        paramk = (k)paramk.getClass().newInstance();
        a locala = new a();
        a(locala, this.a);
        if (locala.a == 10)
        {
          paramk.a(this);
          a();
          return paramk;
        }
        throw new g("type mismatch.");
      }
      catch (Exception paramk)
      {
        throw new g(paramk.getMessage());
      }
    }
    if (!paramBoolean) {
      return null;
    }
    throw new g("require field not exist.");
  }
  
  public final <T> Object a(T paramT, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = paramT instanceof Byte;
    int i = 0;
    boolean bool1 = false;
    if (bool2) {
      return Byte.valueOf(a((byte)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Boolean))
    {
      if (a((byte)0, paramInt, paramBoolean) != 0) {
        bool1 = true;
      }
      return Boolean.valueOf(bool1);
    }
    if ((paramT instanceof Short)) {
      return Short.valueOf(a((short)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Integer)) {
      return Integer.valueOf(a(0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Long)) {
      return Long.valueOf(a(0L, paramInt, paramBoolean));
    }
    if ((paramT instanceof Float)) {
      return Float.valueOf(a(0.0F, paramInt, paramBoolean));
    }
    if ((paramT instanceof Double)) {
      return Double.valueOf(a(0.0D, paramInt, paramBoolean));
    }
    if ((paramT instanceof String)) {
      return String.valueOf(b(paramInt, paramBoolean));
    }
    if ((paramT instanceof Map))
    {
      paramT = (Map)paramT;
      return (HashMap)a(new HashMap(), paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof List))
    {
      paramT = (List)paramT;
      if ((paramT != null) && (!paramT.isEmpty()))
      {
        paramT = b(paramT.get(0), paramInt, paramBoolean);
        if (paramT == null) {
          return null;
        }
        ArrayList localArrayList = new ArrayList();
        paramInt = i;
        while (paramInt < paramT.length)
        {
          localArrayList.add(paramT[paramInt]);
          paramInt += 1;
        }
        return localArrayList;
      }
      return new ArrayList();
    }
    if ((paramT instanceof k)) {
      return a((k)paramT, paramInt, paramBoolean);
    }
    if (paramT.getClass().isArray())
    {
      if ((!(paramT instanceof byte[])) && (!(paramT instanceof Byte[])))
      {
        if ((paramT instanceof boolean[])) {
          return d(paramInt, paramBoolean);
        }
        if ((paramT instanceof short[])) {
          return e(paramInt, paramBoolean);
        }
        if ((paramT instanceof int[])) {
          return f(paramInt, paramBoolean);
        }
        if ((paramT instanceof long[])) {
          return g(paramInt, paramBoolean);
        }
        if ((paramT instanceof float[])) {
          return h(paramInt, paramBoolean);
        }
        if ((paramT instanceof double[])) {
          return i(paramInt, paramBoolean);
        }
        return a((Object[])paramT, paramInt, paramBoolean);
      }
      return c(paramInt, paramBoolean);
    }
    throw new g("read object error: unsupport type.");
  }
  
  public final <K, V> HashMap<K, V> a(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    return (HashMap)a(new HashMap(), paramMap, paramInt, paramBoolean);
  }
  
  public final short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      a locala = new a();
      a(locala, this.a);
      paramInt = locala.a;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 12) {
            return 0;
          }
          throw new g("type mismatch.");
        }
        return this.a.getShort();
      }
      return (short)this.a.get();
    }
    if (!paramBoolean) {
      return paramShort;
    }
    throw new g("require field not exist.");
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = this.a;
    if (localByteBuffer != null) {
      localByteBuffer.clear();
    }
    this.a = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public final boolean a(int paramInt, boolean paramBoolean)
  {
    return a((byte)0, paramInt, paramBoolean) != 0;
  }
  
  public final String b(int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      paramInt = ((a)localObject).a;
      if (paramInt != 6) {
        if (paramInt == 7)
        {
          paramInt = this.a.getInt();
          if ((paramInt <= 104857600) && (paramInt >= 0))
          {
            localObject = new byte[paramInt];
            this.a.get((byte[])localObject);
          }
        }
      }
    }
    try
    {
      str = new String((byte[])localObject, this.b);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      String str;
      int i;
      for (;;) {}
    }
    return new String((byte[])localObject);
    Object localObject = new StringBuilder("String too long: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new g(((StringBuilder)localObject).toString());
    throw new g("type mismatch.");
    i = this.a.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    localObject = new byte[paramInt];
    this.a.get((byte[])localObject);
    try
    {
      str = new String((byte[])localObject, this.b);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      for (;;) {}
    }
    return new String((byte[])localObject);
    if (!paramBoolean) {
      return null;
    }
    throw new g("require field not exist.");
  }
  
  public final byte[] c(int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      Object localObject = new a();
      a((a)localObject, this.a);
      int i = ((a)localObject).a;
      if (i != 9)
      {
        if (i == 13)
        {
          a locala = new a();
          a(locala, this.a);
          if (locala.a == 0)
          {
            i = a(0, 0, true);
            if (i >= 0)
            {
              localObject = new byte[i];
              this.a.get((byte[])localObject);
              return (byte[])localObject;
            }
            localStringBuilder = new StringBuilder("invalid size, tag: ");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(", type: ");
            localStringBuilder.append(((a)localObject).a);
            localStringBuilder.append(", ");
            localStringBuilder.append(locala.a);
            localStringBuilder.append(", size: ");
            localStringBuilder.append(i);
            throw new g(localStringBuilder.toString());
          }
          StringBuilder localStringBuilder = new StringBuilder("type mismatch, tag: ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(", type: ");
          localStringBuilder.append(((a)localObject).a);
          localStringBuilder.append(", ");
          localStringBuilder.append(locala.a);
          throw new g(localStringBuilder.toString());
        }
        throw new g("type mismatch.");
      }
      i = a(0, 0, true);
      if (i >= 0)
      {
        localObject = new byte[i];
        paramInt = 0;
        while (paramInt < i)
        {
          localObject[paramInt] = a(localObject[0], 0, true);
          paramInt += 1;
        }
        return (byte[])localObject;
      }
      localObject = new StringBuilder("size invalid: ");
      ((StringBuilder)localObject).append(i);
      throw new g(((StringBuilder)localObject).toString());
    }
    if (!paramBoolean) {
      return null;
    }
    throw new g("require field not exist.");
  }
  
  public static final class a
  {
    public byte a;
    public int b;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */