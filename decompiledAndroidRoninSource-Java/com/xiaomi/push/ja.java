package com.xiaomi.push;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class ja
{
  private static final Comparator a = new a(null);
  
  public static int a(byte paramByte1, byte paramByte2)
  {
    if (paramByte1 < paramByte2) {
      return -1;
    }
    if (paramByte2 < paramByte1) {
      return 1;
    }
    return 0;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt2 < paramInt1) {
      return 1;
    }
    return 0;
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong2 < paramLong1) {
      return 1;
    }
    return 0;
  }
  
  public static int a(Comparable paramComparable1, Comparable paramComparable2)
  {
    return paramComparable1.compareTo(paramComparable2);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    return paramString1.compareTo(paramString2);
  }
  
  public static int a(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramByteBuffer.remaining();
    System.arraycopy(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramArrayOfByte, paramInt, i);
    return i;
  }
  
  public static int a(List paramList1, List paramList2)
  {
    int i = a(paramList1.size(), paramList2.size());
    if (i != 0) {
      return i;
    }
    i = 0;
    while (i < paramList1.size())
    {
      int j = a.compare(paramList1.get(i), paramList2.get(i));
      if (j != 0) {
        return j;
      }
      i += 1;
    }
    return 0;
  }
  
  public static int a(Map paramMap1, Map paramMap2)
  {
    int i = a(paramMap1.size(), paramMap2.size());
    if (i != 0) {
      return i;
    }
    Object localObject = new TreeMap(a);
    ((SortedMap)localObject).putAll(paramMap1);
    paramMap1 = ((SortedMap)localObject).entrySet().iterator();
    localObject = new TreeMap(a);
    ((SortedMap)localObject).putAll(paramMap2);
    paramMap2 = ((SortedMap)localObject).entrySet().iterator();
    while ((paramMap1.hasNext()) && (paramMap2.hasNext()))
    {
      localObject = (Map.Entry)paramMap1.next();
      Map.Entry localEntry = (Map.Entry)paramMap2.next();
      i = a.compare(((Map.Entry)localObject).getKey(), localEntry.getKey());
      if (i != 0) {
        return i;
      }
      i = a.compare(((Map.Entry)localObject).getValue(), localEntry.getValue());
      if (i != 0) {
        return i;
      }
    }
    return 0;
  }
  
  public static int a(Set paramSet1, Set paramSet2)
  {
    int i = a(paramSet1.size(), paramSet2.size());
    if (i != 0) {
      return i;
    }
    TreeSet localTreeSet = new TreeSet(a);
    localTreeSet.addAll(paramSet1);
    paramSet1 = new TreeSet(a);
    paramSet1.addAll(paramSet2);
    paramSet2 = localTreeSet.iterator();
    paramSet1 = paramSet1.iterator();
    while ((paramSet2.hasNext()) && (paramSet1.hasNext()))
    {
      i = a.compare(paramSet2.next(), paramSet1.next());
      if (i != 0) {
        return i;
      }
    }
    return 0;
  }
  
  public static int a(short paramShort1, short paramShort2)
  {
    if (paramShort1 < paramShort2) {
      return -1;
    }
    if (paramShort2 < paramShort1) {
      return 1;
    }
    return 0;
  }
  
  public static int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return Boolean.valueOf(paramBoolean1).compareTo(Boolean.valueOf(paramBoolean2));
  }
  
  public static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = a(paramArrayOfByte1.length, paramArrayOfByte2.length);
    if (i != 0) {
      return i;
    }
    i = 0;
    while (i < paramArrayOfByte1.length)
    {
      int j = a(paramArrayOfByte1[i], paramArrayOfByte2[i]);
      if (j != 0) {
        return j;
      }
      i += 1;
    }
    return 0;
  }
  
  public static String a(byte paramByte)
  {
    return Integer.toHexString((paramByte | 0x100) & 0x1FF).toUpperCase().substring(1);
  }
  
  public static ByteBuffer a(ByteBuffer paramByteBuffer)
  {
    if (a(paramByteBuffer)) {
      return paramByteBuffer;
    }
    return ByteBuffer.wrap(a(paramByteBuffer));
  }
  
  public static void a(ByteBuffer paramByteBuffer, StringBuilder paramStringBuilder)
  {
    byte[] arrayOfByte = paramByteBuffer.array();
    int k = paramByteBuffer.arrayOffset();
    int m = paramByteBuffer.limit();
    int i;
    if (m - k > 128) {
      i = k + 128;
    } else {
      i = m;
    }
    int j = k;
    while (j < i)
    {
      if (j > k) {
        paramStringBuilder.append(" ");
      }
      paramStringBuilder.append(a(arrayOfByte[j]));
      j += 1;
    }
    if (m != i) {
      paramStringBuilder.append("...");
    }
  }
  
  public static boolean a(ByteBuffer paramByteBuffer)
  {
    return (paramByteBuffer.hasArray()) && (paramByteBuffer.position() == 0) && (paramByteBuffer.arrayOffset() == 0) && (paramByteBuffer.remaining() == paramByteBuffer.capacity());
  }
  
  public static byte[] a(ByteBuffer paramByteBuffer)
  {
    if (a(paramByteBuffer)) {
      return paramByteBuffer.array();
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    a(paramByteBuffer, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  private static class a
    implements Comparator
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */