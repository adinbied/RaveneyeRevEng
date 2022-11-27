package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class ArrayUtils
{
  public static <T> T[] appendToArray(T[] paramArrayOfT, T paramT)
  {
    if ((paramArrayOfT == null) && (paramT == null)) {
      throw new IllegalArgumentException("Cannot generate array of generic type w/o class info");
    }
    if (paramArrayOfT == null) {
      paramArrayOfT = (Object[])Array.newInstance(paramT.getClass(), 1);
    } else {
      paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length + 1);
    }
    paramArrayOfT[(paramArrayOfT.length - 1)] = paramT;
    return paramArrayOfT;
  }
  
  public static <T> T[] concat(T[]... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return (Object[])Array.newInstance(paramVarArgs.getClass(), 0);
    }
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    Object[] arrayOfObject = Arrays.copyOf(paramVarArgs[0], j);
    j = paramVarArgs[0].length;
    i = 1;
    while (i < paramVarArgs.length)
    {
      T[] arrayOfT = paramVarArgs[i];
      System.arraycopy(arrayOfT, 0, arrayOfObject, j, arrayOfT.length);
      j += arrayOfT.length;
      i += 1;
    }
    return arrayOfObject;
  }
  
  public static byte[] concatByteArrays(byte[]... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return new byte[0];
    }
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    byte[] arrayOfByte1 = Arrays.copyOf(paramVarArgs[0], j);
    j = paramVarArgs[0].length;
    i = 1;
    while (i < paramVarArgs.length)
    {
      byte[] arrayOfByte2 = paramVarArgs[i];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, arrayOfByte2.length);
      j += arrayOfByte2.length;
      i += 1;
    }
    return arrayOfByte1;
  }
  
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return false;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static <T> boolean contains(T[] paramArrayOfT, T paramT)
  {
    int j;
    if (paramArrayOfT != null) {
      j = paramArrayOfT.length;
    } else {
      j = 0;
    }
    int i = 0;
    while (i < j)
    {
      if (Objects.equal(paramArrayOfT[i], paramT)) {
        break label41;
      }
      i += 1;
    }
    i = -1;
    label41:
    return i >= 0;
  }
  
  public static <T> ArrayList<T> newArrayList()
  {
    return new ArrayList();
  }
  
  public static <T> T[] removeAll(T[] paramArrayOfT1, T... paramVarArgs)
  {
    if (paramArrayOfT1 == null) {
      return null;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      Object[] arrayOfObject = (Object[])Array.newInstance(paramVarArgs.getClass().getComponentType(), paramArrayOfT1.length);
      int i = paramVarArgs.length;
      int j = 0;
      T ?;
      if (i == 1)
      {
        m = paramArrayOfT1.length;
        j = 0;
        for (i = 0;; i = k)
        {
          k = i;
          if (j >= m) {
            break;
          }
          ? = paramArrayOfT1[j];
          k = i;
          if (!Objects.equal(paramVarArgs[0], ?))
          {
            arrayOfObject[i] = ?;
            k = i + 1;
          }
          j += 1;
        }
      }
      int m = paramArrayOfT1.length;
      for (i = 0; j < m; i = k)
      {
        ? = paramArrayOfT1[j];
        k = i;
        if (!contains(paramVarArgs, ?))
        {
          arrayOfObject[i] = ?;
          k = i + 1;
        }
        j += 1;
      }
      int k = i;
      if (arrayOfObject == null) {
        return null;
      }
      paramArrayOfT1 = arrayOfObject;
      if (k != arrayOfObject.length) {
        paramArrayOfT1 = Arrays.copyOf(arrayOfObject, k);
      }
      return paramArrayOfT1;
    }
    return Arrays.copyOf(paramArrayOfT1, paramArrayOfT1.length);
  }
  
  public static <T> ArrayList<T> toArrayList(T[] paramArrayOfT)
  {
    int j = paramArrayOfT.length;
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfT[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public static int[] toPrimitiveArray(Collection<Integer> paramCollection)
  {
    int i = 0;
    if ((paramCollection != null) && (paramCollection.size() != 0))
    {
      int[] arrayOfInt = new int[paramCollection.size()];
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        arrayOfInt[i] = ((Integer)paramCollection.next()).intValue();
        i += 1;
      }
      return arrayOfInt;
    }
    return new int[0];
  }
  
  public static Integer[] toWrapperArray(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    int j = paramArrayOfInt.length;
    Integer[] arrayOfInteger = new Integer[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
      i += 1;
    }
    return arrayOfInteger;
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, double[] paramArrayOfDouble)
  {
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Double.toString(paramArrayOfDouble[i]));
      i += 1;
    }
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, float[] paramArrayOfFloat)
  {
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Float.toString(paramArrayOfFloat[i]));
      i += 1;
    }
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Integer.toString(paramArrayOfInt[i]));
      i += 1;
    }
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, long[] paramArrayOfLong)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Long.toString(paramArrayOfLong[i]));
      i += 1;
    }
  }
  
  public static <T> void writeArray(StringBuilder paramStringBuilder, T[] paramArrayOfT)
  {
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(paramArrayOfT[i].toString());
      i += 1;
    }
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, boolean[] paramArrayOfBoolean)
  {
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Boolean.toString(paramArrayOfBoolean[i]));
      i += 1;
    }
  }
  
  public static void writeStringArray(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append("\"");
      paramStringBuilder.append(paramArrayOfString[i]);
      paramStringBuilder.append("\"");
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\ArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */