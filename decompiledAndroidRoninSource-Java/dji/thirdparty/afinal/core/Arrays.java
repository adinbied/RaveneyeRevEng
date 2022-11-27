package dji.thirdparty.afinal.core;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

public class Arrays
{
  public static <T> List<T> asList(T... paramVarArgs)
  {
    return new ArrayList(paramVarArgs);
  }
  
  public static int binarySearch(byte[] paramArrayOfByte, byte paramByte)
  {
    return binarySearch(paramArrayOfByte, 0, paramArrayOfByte.length, paramByte);
  }
  
  public static int binarySearch(byte[] paramArrayOfByte, int paramInt1, int paramInt2, byte paramByte)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfByte.length);
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      byte b = paramArrayOfByte[i];
      if (b < paramByte) {
        paramInt1 = i + 1;
      } else if (b > paramByte) {
        paramInt2 = i - 1;
      } else {
        return i;
      }
    }
    return paramInt1;
  }
  
  public static int binarySearch(char[] paramArrayOfChar, char paramChar)
  {
    return binarySearch(paramArrayOfChar, 0, paramArrayOfChar.length, paramChar);
  }
  
  public static int binarySearch(char[] paramArrayOfChar, int paramInt1, int paramInt2, char paramChar)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfChar.length);
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      char c = paramArrayOfChar[i];
      if (c < paramChar) {
        paramInt1 = i + 1;
      } else if (c > paramChar) {
        paramInt2 = i - 1;
      } else {
        return i;
      }
    }
    return paramInt1;
  }
  
  public static int binarySearch(double[] paramArrayOfDouble, double paramDouble)
  {
    return binarySearch(paramArrayOfDouble, 0, paramArrayOfDouble.length, paramDouble);
  }
  
  public static int binarySearch(double[] paramArrayOfDouble, int paramInt1, int paramInt2, double paramDouble)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfDouble.length);
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      double d = paramArrayOfDouble[i];
      if (d < paramDouble)
      {
        label36:
        paramInt1 = i + 1;
      }
      else
      {
        boolean bool = d < paramDouble;
        if (bool) {}
        do
        {
          paramInt2 = i - 1;
          break;
          if ((d != 0.0D) && (!bool)) {
            return i;
          }
          bool = Double.doubleToLongBits(d) < Double.doubleToLongBits(paramDouble);
          if (bool) {
            break label36;
          }
        } while (bool);
        return i;
      }
    }
    return paramInt1;
  }
  
  public static int binarySearch(float[] paramArrayOfFloat, float paramFloat)
  {
    return binarySearch(paramArrayOfFloat, 0, paramArrayOfFloat.length, paramFloat);
  }
  
  public static int binarySearch(float[] paramArrayOfFloat, int paramInt1, int paramInt2, float paramFloat)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfFloat.length);
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      float f = paramArrayOfFloat[i];
      if (f < paramFloat)
      {
        label36:
        paramInt1 = i + 1;
      }
      else
      {
        boolean bool = f < paramFloat;
        if (bool) {}
        int j;
        int k;
        do
        {
          paramInt2 = i - 1;
          break;
          if ((f != 0.0F) && (!bool)) {
            return i;
          }
          j = Float.floatToIntBits(f);
          k = Float.floatToIntBits(paramFloat);
          if (j < k) {
            break label36;
          }
        } while (j > k);
        return i;
      }
    }
    return paramInt1;
  }
  
  public static int binarySearch(int[] paramArrayOfInt, int paramInt)
  {
    return binarySearch(paramArrayOfInt, 0, paramArrayOfInt.length, paramInt);
  }
  
  public static int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfInt.length);
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      int j = paramArrayOfInt[i];
      if (j < paramInt3) {
        paramInt1 = i + 1;
      } else if (j > paramInt3) {
        paramInt2 = i - 1;
      } else {
        return i;
      }
    }
    return paramInt1;
  }
  
  public static int binarySearch(long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfLong.length);
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      boolean bool = paramArrayOfLong[i] < paramLong;
      if (bool) {
        paramInt1 = i + 1;
      } else if (bool) {
        paramInt2 = i - 1;
      } else {
        return i;
      }
    }
    return paramInt1;
  }
  
  public static int binarySearch(long[] paramArrayOfLong, long paramLong)
  {
    return binarySearch(paramArrayOfLong, 0, paramArrayOfLong.length, paramLong);
  }
  
  public static int binarySearch(Object[] paramArrayOfObject, int paramInt1, int paramInt2, Object paramObject)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfObject.length);
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      int j = ((Comparable)paramArrayOfObject[i]).compareTo(paramObject);
      if (j < 0) {
        paramInt1 = i + 1;
      } else if (j > 0) {
        paramInt2 = i - 1;
      } else {
        return i;
      }
    }
    return paramInt1;
  }
  
  public static <T> int binarySearch(T[] paramArrayOfT, int paramInt1, int paramInt2, T paramT, Comparator<? super T> paramComparator)
  {
    if (paramComparator == null) {
      return binarySearch(paramArrayOfT, paramInt1, paramInt2, paramT);
    }
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfT.length);
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      int j = paramComparator.compare(paramArrayOfT[i], paramT);
      if (j < 0) {
        paramInt1 = i + 1;
      } else if (j > 0) {
        paramInt2 = i - 1;
      } else {
        return i;
      }
    }
    return paramInt1;
  }
  
  public static int binarySearch(Object[] paramArrayOfObject, Object paramObject)
  {
    return binarySearch(paramArrayOfObject, 0, paramArrayOfObject.length, paramObject);
  }
  
  public static <T> int binarySearch(T[] paramArrayOfT, T paramT, Comparator<? super T> paramComparator)
  {
    return binarySearch(paramArrayOfT, 0, paramArrayOfT.length, paramT, paramComparator);
  }
  
  public static int binarySearch(short[] paramArrayOfShort, int paramInt1, int paramInt2, short paramShort)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfShort.length);
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      short s = paramArrayOfShort[i];
      if (s < paramShort) {
        paramInt1 = i + 1;
      } else if (s > paramShort) {
        paramInt2 = i - 1;
      } else {
        return i;
      }
    }
    return paramInt1;
  }
  
  public static int binarySearch(short[] paramArrayOfShort, short paramShort)
  {
    return binarySearch(paramArrayOfShort, 0, paramArrayOfShort.length, paramShort);
  }
  
  private static void checkBinarySearchBounds(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= paramInt2)
    {
      if ((paramInt1 >= 0) && (paramInt2 <= paramInt3)) {
        return;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static byte[] copyOf(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt >= 0) {
      return copyOfRange(paramArrayOfByte, 0, paramInt);
    }
    throw new NegativeArraySizeException();
  }
  
  public static char[] copyOf(char[] paramArrayOfChar, int paramInt)
  {
    if (paramInt >= 0) {
      return copyOfRange(paramArrayOfChar, 0, paramInt);
    }
    throw new NegativeArraySizeException();
  }
  
  public static double[] copyOf(double[] paramArrayOfDouble, int paramInt)
  {
    if (paramInt >= 0) {
      return copyOfRange(paramArrayOfDouble, 0, paramInt);
    }
    throw new NegativeArraySizeException();
  }
  
  public static float[] copyOf(float[] paramArrayOfFloat, int paramInt)
  {
    if (paramInt >= 0) {
      return copyOfRange(paramArrayOfFloat, 0, paramInt);
    }
    throw new NegativeArraySizeException();
  }
  
  public static int[] copyOf(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt >= 0) {
      return copyOfRange(paramArrayOfInt, 0, paramInt);
    }
    throw new NegativeArraySizeException();
  }
  
  public static long[] copyOf(long[] paramArrayOfLong, int paramInt)
  {
    if (paramInt >= 0) {
      return copyOfRange(paramArrayOfLong, 0, paramInt);
    }
    throw new NegativeArraySizeException();
  }
  
  public static <T> T[] copyOf(T[] paramArrayOfT, int paramInt)
  {
    if (paramArrayOfT != null)
    {
      if (paramInt >= 0) {
        return copyOfRange(paramArrayOfT, 0, paramInt);
      }
      throw new NegativeArraySizeException();
    }
    throw null;
  }
  
  public static <T, U> T[] copyOf(U[] paramArrayOfU, int paramInt, Class<? extends T[]> paramClass)
  {
    if (paramInt >= 0) {
      return copyOfRange(paramArrayOfU, 0, paramInt, paramClass);
    }
    throw new NegativeArraySizeException();
  }
  
  public static short[] copyOf(short[] paramArrayOfShort, int paramInt)
  {
    if (paramInt >= 0) {
      return copyOfRange(paramArrayOfShort, 0, paramInt);
    }
    throw new NegativeArraySizeException();
  }
  
  public static boolean[] copyOf(boolean[] paramArrayOfBoolean, int paramInt)
  {
    if (paramInt >= 0) {
      return copyOfRange(paramArrayOfBoolean, 0, paramInt);
    }
    throw new NegativeArraySizeException();
  }
  
  public static byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      int i = paramArrayOfByte.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i))
      {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        byte[] arrayOfByte = new byte[paramInt2];
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, i);
        return arrayOfByte;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static char[] copyOfRange(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      int i = paramArrayOfChar.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i))
      {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        char[] arrayOfChar = new char[paramInt2];
        System.arraycopy(paramArrayOfChar, paramInt1, arrayOfChar, 0, i);
        return arrayOfChar;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static double[] copyOfRange(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      int i = paramArrayOfDouble.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i))
      {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        double[] arrayOfDouble = new double[paramInt2];
        System.arraycopy(paramArrayOfDouble, paramInt1, arrayOfDouble, 0, i);
        return arrayOfDouble;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static float[] copyOfRange(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      int i = paramArrayOfFloat.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i))
      {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        float[] arrayOfFloat = new float[paramInt2];
        System.arraycopy(paramArrayOfFloat, paramInt1, arrayOfFloat, 0, i);
        return arrayOfFloat;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static int[] copyOfRange(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      int i = paramArrayOfInt.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i))
      {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        int[] arrayOfInt = new int[paramInt2];
        System.arraycopy(paramArrayOfInt, paramInt1, arrayOfInt, 0, i);
        return arrayOfInt;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static long[] copyOfRange(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      int i = paramArrayOfLong.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i))
      {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        long[] arrayOfLong = new long[paramInt2];
        System.arraycopy(paramArrayOfLong, paramInt1, arrayOfLong, 0, i);
        return arrayOfLong;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static <T> T[] copyOfRange(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfT.length;
    if (paramInt1 <= paramInt2)
    {
      if ((paramInt1 >= 0) && (paramInt1 <= i))
      {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), paramInt2);
        System.arraycopy(paramArrayOfT, paramInt1, arrayOfObject, 0, i);
        return arrayOfObject;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static <T, U> T[] copyOfRange(U[] paramArrayOfU, int paramInt1, int paramInt2, Class<? extends T[]> paramClass)
  {
    if (paramInt1 <= paramInt2)
    {
      int i = paramArrayOfU.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i))
      {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        paramClass = (Object[])Array.newInstance(paramClass.getComponentType(), paramInt2);
        System.arraycopy(paramArrayOfU, paramInt1, paramClass, 0, i);
        return paramClass;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static short[] copyOfRange(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      int i = paramArrayOfShort.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i))
      {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        short[] arrayOfShort = new short[paramInt2];
        System.arraycopy(paramArrayOfShort, paramInt1, arrayOfShort, 0, i);
        return arrayOfShort;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static boolean[] copyOfRange(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      int i = paramArrayOfBoolean.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i))
      {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        boolean[] arrayOfBoolean = new boolean[paramInt2];
        System.arraycopy(paramArrayOfBoolean, paramInt1, arrayOfBoolean, 0, i);
        return arrayOfBoolean;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static boolean deepEquals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramArrayOfObject1 == paramArrayOfObject2) {
      return true;
    }
    if ((paramArrayOfObject1 != null) && (paramArrayOfObject2 != null))
    {
      if (paramArrayOfObject1.length != paramArrayOfObject2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfObject1.length)
      {
        if (!deepEqualsElements(paramArrayOfObject1[i], paramArrayOfObject2[i])) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private static boolean deepEqualsElements(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if (paramObject1 != null)
    {
      if (paramObject2 == null) {
        return false;
      }
      Class localClass = paramObject1.getClass().getComponentType();
      if (localClass != paramObject2.getClass().getComponentType()) {
        return false;
      }
      if (localClass == null) {
        return paramObject1.equals(paramObject2);
      }
      if (!localClass.isPrimitive()) {
        return deepEquals((Object[])paramObject1, (Object[])paramObject2);
      }
      if (localClass.equals(Integer.TYPE)) {
        return equals((int[])paramObject1, (int[])paramObject2);
      }
      if (localClass.equals(Character.TYPE)) {
        return equals((char[])paramObject1, (char[])paramObject2);
      }
      if (localClass.equals(Boolean.TYPE)) {
        return equals((boolean[])paramObject1, (boolean[])paramObject2);
      }
      if (localClass.equals(Byte.TYPE)) {
        return equals((byte[])paramObject1, (byte[])paramObject2);
      }
      if (localClass.equals(Long.TYPE)) {
        return equals((long[])paramObject1, (long[])paramObject2);
      }
      if (localClass.equals(Float.TYPE)) {
        return equals((float[])paramObject1, (float[])paramObject2);
      }
      if (localClass.equals(Double.TYPE)) {
        return equals((double[])paramObject1, (double[])paramObject2);
      }
      return equals((short[])paramObject1, (short[])paramObject2);
    }
    return false;
  }
  
  public static int deepHashCode(Object[] paramArrayOfObject)
  {
    int i = 0;
    if (paramArrayOfObject == null) {
      return 0;
    }
    int k = paramArrayOfObject.length;
    int j = 1;
    while (i < k)
    {
      j = j * 31 + deepHashCodeElement(paramArrayOfObject[i]);
      i += 1;
    }
    return j;
  }
  
  private static int deepHashCodeElement(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    Class localClass = paramObject.getClass().getComponentType();
    if (localClass == null) {
      return paramObject.hashCode();
    }
    if (!localClass.isPrimitive()) {
      return deepHashCode((Object[])paramObject);
    }
    if (localClass.equals(Integer.TYPE)) {
      return hashCode((int[])paramObject);
    }
    if (localClass.equals(Character.TYPE)) {
      return hashCode((char[])paramObject);
    }
    if (localClass.equals(Boolean.TYPE)) {
      return hashCode((boolean[])paramObject);
    }
    if (localClass.equals(Byte.TYPE)) {
      return hashCode((byte[])paramObject);
    }
    if (localClass.equals(Long.TYPE)) {
      return hashCode((long[])paramObject);
    }
    if (localClass.equals(Float.TYPE)) {
      return hashCode((float[])paramObject);
    }
    if (localClass.equals(Double.TYPE)) {
      return hashCode((double[])paramObject);
    }
    return hashCode((short[])paramObject);
  }
  
  public static String deepToString(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfObject.length * 9);
    deepToStringImpl(paramArrayOfObject, new Object[] { paramArrayOfObject }, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  private static void deepToStringImpl(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, StringBuilder paramStringBuilder)
  {
    if (paramArrayOfObject1 == null)
    {
      paramStringBuilder.append("null");
      return;
    }
    paramStringBuilder.append('[');
    int i = 0;
    while (i < paramArrayOfObject1.length)
    {
      if (i != 0) {
        paramStringBuilder.append(", ");
      }
      Object localObject1 = paramArrayOfObject1[i];
      if (localObject1 == null)
      {
        paramStringBuilder.append("null");
      }
      else
      {
        Object localObject2 = localObject1.getClass();
        if (((Class)localObject2).isArray())
        {
          localObject2 = ((Class)localObject2).getComponentType();
          if (((Class)localObject2).isPrimitive())
          {
            if (Boolean.TYPE.equals(localObject2)) {
              paramStringBuilder.append(toString((boolean[])localObject1));
            } else if (Byte.TYPE.equals(localObject2)) {
              paramStringBuilder.append(toString((byte[])localObject1));
            } else if (Character.TYPE.equals(localObject2)) {
              paramStringBuilder.append(toString((char[])localObject1));
            } else if (Double.TYPE.equals(localObject2)) {
              paramStringBuilder.append(toString((double[])localObject1));
            } else if (Float.TYPE.equals(localObject2)) {
              paramStringBuilder.append(toString((float[])localObject1));
            } else if (Integer.TYPE.equals(localObject2)) {
              paramStringBuilder.append(toString((int[])localObject1));
            } else if (Long.TYPE.equals(localObject2)) {
              paramStringBuilder.append(toString((long[])localObject1));
            } else if (Short.TYPE.equals(localObject2)) {
              paramStringBuilder.append(toString((short[])localObject1));
            } else {
              throw new AssertionError();
            }
          }
          else if (deepToStringImplContains(paramArrayOfObject2, localObject1))
          {
            paramStringBuilder.append("[...]");
          }
          else
          {
            localObject1 = (Object[])localObject1;
            localObject2 = new Object[paramArrayOfObject2.length + 1];
            System.arraycopy(paramArrayOfObject2, 0, localObject2, 0, paramArrayOfObject2.length);
            localObject2[paramArrayOfObject2.length] = localObject1;
            deepToStringImpl((Object[])localObject1, (Object[])localObject2, paramStringBuilder);
          }
        }
        else
        {
          paramStringBuilder.append(paramArrayOfObject1[i]);
        }
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  private static boolean deepToStringImplContains(Object[] paramArrayOfObject, Object paramObject)
  {
    if (paramArrayOfObject != null)
    {
      if (paramArrayOfObject.length == 0) {
        return false;
      }
      int j = paramArrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfObject[i] == paramObject) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean equals(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == paramArrayOfByte2) {
      return true;
    }
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfByte1.length)
      {
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean equals(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    if (paramArrayOfChar1 == paramArrayOfChar2) {
      return true;
    }
    if ((paramArrayOfChar1 != null) && (paramArrayOfChar2 != null))
    {
      if (paramArrayOfChar1.length != paramArrayOfChar2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfChar1.length)
      {
        if (paramArrayOfChar1[i] != paramArrayOfChar2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean equals(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    if (paramArrayOfDouble1 == paramArrayOfDouble2) {
      return true;
    }
    if ((paramArrayOfDouble1 != null) && (paramArrayOfDouble2 != null))
    {
      if (paramArrayOfDouble1.length != paramArrayOfDouble2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfDouble1.length)
      {
        if (Double.doubleToLongBits(paramArrayOfDouble1[i]) != Double.doubleToLongBits(paramArrayOfDouble2[i])) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean equals(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramArrayOfFloat1 == paramArrayOfFloat2) {
      return true;
    }
    if ((paramArrayOfFloat1 != null) && (paramArrayOfFloat2 != null))
    {
      if (paramArrayOfFloat1.length != paramArrayOfFloat2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfFloat1.length)
      {
        if (Float.floatToIntBits(paramArrayOfFloat1[i]) != Float.floatToIntBits(paramArrayOfFloat2[i])) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean equals(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1 == paramArrayOfInt2) {
      return true;
    }
    if ((paramArrayOfInt1 != null) && (paramArrayOfInt2 != null))
    {
      if (paramArrayOfInt1.length != paramArrayOfInt2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfInt1.length)
      {
        if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean equals(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (paramArrayOfLong1 == paramArrayOfLong2) {
      return true;
    }
    if ((paramArrayOfLong1 != null) && (paramArrayOfLong2 != null))
    {
      if (paramArrayOfLong1.length != paramArrayOfLong2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfLong1.length)
      {
        if (paramArrayOfLong1[i] != paramArrayOfLong2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramArrayOfObject1 == paramArrayOfObject2) {
      return true;
    }
    if ((paramArrayOfObject1 != null) && (paramArrayOfObject2 != null))
    {
      if (paramArrayOfObject1.length != paramArrayOfObject2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfObject1.length)
      {
        Object localObject1 = paramArrayOfObject1[i];
        Object localObject2 = paramArrayOfObject2[i];
        if (localObject1 == null ? localObject2 != null : !localObject1.equals(localObject2)) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean equals(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    if (paramArrayOfShort1 == paramArrayOfShort2) {
      return true;
    }
    if ((paramArrayOfShort1 != null) && (paramArrayOfShort2 != null))
    {
      if (paramArrayOfShort1.length != paramArrayOfShort2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfShort1.length)
      {
        if (paramArrayOfShort1[i] != paramArrayOfShort2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean equals(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    if (paramArrayOfBoolean1 == paramArrayOfBoolean2) {
      return true;
    }
    if ((paramArrayOfBoolean1 != null) && (paramArrayOfBoolean2 != null))
    {
      if (paramArrayOfBoolean1.length != paramArrayOfBoolean2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfBoolean1.length)
      {
        if (paramArrayOfBoolean1[i] != paramArrayOfBoolean2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static void fill(byte[] paramArrayOfByte, byte paramByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      paramArrayOfByte[i] = paramByte;
      i += 1;
    }
  }
  
  public static void fill(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      paramArrayOfInt[i] = paramInt;
      i += 1;
    }
  }
  
  public static void fill(Object[] paramArrayOfObject, Object paramObject)
  {
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      paramArrayOfObject[i] = paramObject;
      i += 1;
    }
  }
  
  public static void fill(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    int i = 0;
    while (i < paramArrayOfBoolean.length)
    {
      paramArrayOfBoolean[i] = paramBoolean;
      i += 1;
    }
  }
  
  public static int hashCode(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte == null) {
      return 0;
    }
    int k = paramArrayOfByte.length;
    int j = 1;
    while (i < k)
    {
      j = j * 31 + paramArrayOfByte[i];
      i += 1;
    }
    return j;
  }
  
  public static int hashCode(char[] paramArrayOfChar)
  {
    int i = 0;
    if (paramArrayOfChar == null) {
      return 0;
    }
    int k = paramArrayOfChar.length;
    int j = 1;
    while (i < k)
    {
      j = j * 31 + paramArrayOfChar[i];
      i += 1;
    }
    return j;
  }
  
  public static int hashCode(double[] paramArrayOfDouble)
  {
    int i = 0;
    if (paramArrayOfDouble == null) {
      return 0;
    }
    int k = paramArrayOfDouble.length;
    int j = 1;
    while (i < k)
    {
      long l = Double.doubleToLongBits(paramArrayOfDouble[i]);
      j = j * 31 + (int)(l ^ l >>> 32);
      i += 1;
    }
    return j;
  }
  
  public static int hashCode(float[] paramArrayOfFloat)
  {
    int i = 0;
    if (paramArrayOfFloat == null) {
      return 0;
    }
    int k = paramArrayOfFloat.length;
    int j = 1;
    while (i < k)
    {
      j = j * 31 + Float.floatToIntBits(paramArrayOfFloat[i]);
      i += 1;
    }
    return j;
  }
  
  public static int hashCode(int[] paramArrayOfInt)
  {
    int i = 0;
    if (paramArrayOfInt == null) {
      return 0;
    }
    int k = paramArrayOfInt.length;
    int j = 1;
    while (i < k)
    {
      j = j * 31 + paramArrayOfInt[i];
      i += 1;
    }
    return j;
  }
  
  public static int hashCode(long[] paramArrayOfLong)
  {
    int i = 0;
    if (paramArrayOfLong == null) {
      return 0;
    }
    int k = paramArrayOfLong.length;
    int j = 1;
    while (i < k)
    {
      long l = paramArrayOfLong[i];
      j = j * 31 + (int)(l ^ l >>> 32);
      i += 1;
    }
    return j;
  }
  
  public static int hashCode(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return 0;
    }
    int m = paramArrayOfObject.length;
    int j = 1;
    int i = 0;
    while (i < m)
    {
      Object localObject = paramArrayOfObject[i];
      int k;
      if (localObject == null) {
        k = 0;
      } else {
        k = localObject.hashCode();
      }
      j = j * 31 + k;
      i += 1;
    }
    return j;
  }
  
  public static int hashCode(short[] paramArrayOfShort)
  {
    int i = 0;
    if (paramArrayOfShort == null) {
      return 0;
    }
    int k = paramArrayOfShort.length;
    int j = 1;
    while (i < k)
    {
      j = j * 31 + paramArrayOfShort[i];
      i += 1;
    }
    return j;
  }
  
  public static int hashCode(boolean[] paramArrayOfBoolean)
  {
    int i = 0;
    if (paramArrayOfBoolean == null) {
      return 0;
    }
    int m = paramArrayOfBoolean.length;
    int j = 1;
    while (i < m)
    {
      int k;
      if (paramArrayOfBoolean[i] != 0) {
        k = 1231;
      } else {
        k = 1237;
      }
      j = j * 31 + k;
      i += 1;
    }
    return j;
  }
  
  public static String toString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "null";
    }
    if (paramArrayOfByte.length == 0) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 6);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfByte[0]);
    int i = 1;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfByte[i]);
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public static String toString(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return "null";
    }
    if (paramArrayOfChar.length == 0) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfChar.length * 3);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfChar[0]);
    int i = 1;
    while (i < paramArrayOfChar.length)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfChar[i]);
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public static String toString(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null) {
      return "null";
    }
    if (paramArrayOfDouble.length == 0) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfDouble.length * 7);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfDouble[0]);
    int i = 1;
    while (i < paramArrayOfDouble.length)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfDouble[i]);
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public static String toString(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null) {
      return "null";
    }
    if (paramArrayOfFloat.length == 0) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfFloat.length * 7);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfFloat[0]);
    int i = 1;
    while (i < paramArrayOfFloat.length)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfFloat[i]);
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public static String toString(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return "null";
    }
    if (paramArrayOfInt.length == 0) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfInt.length * 6);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfInt[0]);
    int i = 1;
    while (i < paramArrayOfInt.length)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfInt[i]);
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public static String toString(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null) {
      return "null";
    }
    if (paramArrayOfLong.length == 0) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfLong.length * 6);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfLong[0]);
    int i = 1;
    while (i < paramArrayOfLong.length)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfLong[i]);
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public static String toString(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return "null";
    }
    if (paramArrayOfObject.length == 0) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfObject.length * 7);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfObject[0]);
    int i = 1;
    while (i < paramArrayOfObject.length)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfObject[i]);
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public static String toString(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null) {
      return "null";
    }
    if (paramArrayOfShort.length == 0) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfShort.length * 6);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfShort[0]);
    int i = 1;
    while (i < paramArrayOfShort.length)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfShort[i]);
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public static String toString(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null) {
      return "null";
    }
    if (paramArrayOfBoolean.length == 0) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfBoolean.length * 7);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfBoolean[0]);
    int i = 1;
    while (i < paramArrayOfBoolean.length)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfBoolean[i]);
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  private static class ArrayList<E>
    extends AbstractList<E>
    implements List<E>, Serializable, RandomAccess
  {
    private static final long serialVersionUID = -2764017481108945198L;
    private final E[] a;
    
    ArrayList(E[] paramArrayOfE)
    {
      if (paramArrayOfE != null)
      {
        this.a = paramArrayOfE;
        return;
      }
      throw null;
    }
    
    public boolean contains(Object paramObject)
    {
      return false;
    }
    
    public E get(int paramInt)
    {
      try
      {
        Object localObject = this.a[paramInt];
        return (E)localObject;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        throw localArrayIndexOutOfBoundsException;
      }
    }
    
    public int indexOf(Object paramObject)
    {
      return 0;
    }
    
    public int lastIndexOf(Object paramObject)
    {
      return 0;
    }
    
    public E set(int paramInt, E paramE)
    {
      Object[] arrayOfObject = this.a;
      Object localObject = arrayOfObject[paramInt];
      arrayOfObject[paramInt] = paramE;
      return (E)localObject;
    }
    
    public int size()
    {
      return this.a.length;
    }
    
    public Object[] toArray()
    {
      return null;
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\core\Arrays.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */