package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\0000\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\022\032*\020\000\032\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\0012\006\020\005\032\0020\001H\003ø\001\000¢\006\004\b\006\020\007\032*\020\000\032\0020\0012\006\020\002\032\0020\b2\006\020\004\032\0020\0012\006\020\005\032\0020\001H\003ø\001\000¢\006\004\b\t\020\n\032*\020\000\032\0020\0012\006\020\002\032\0020\0132\006\020\004\032\0020\0012\006\020\005\032\0020\001H\003ø\001\000¢\006\004\b\f\020\r\032*\020\000\032\0020\0012\006\020\002\032\0020\0162\006\020\004\032\0020\0012\006\020\005\032\0020\001H\003ø\001\000¢\006\004\b\017\020\020\032*\020\021\032\0020\0222\006\020\002\032\0020\0032\006\020\004\032\0020\0012\006\020\005\032\0020\001H\003ø\001\000¢\006\004\b\023\020\024\032*\020\021\032\0020\0222\006\020\002\032\0020\b2\006\020\004\032\0020\0012\006\020\005\032\0020\001H\003ø\001\000¢\006\004\b\025\020\026\032*\020\021\032\0020\0222\006\020\002\032\0020\0132\006\020\004\032\0020\0012\006\020\005\032\0020\001H\003ø\001\000¢\006\004\b\027\020\030\032*\020\021\032\0020\0222\006\020\002\032\0020\0162\006\020\004\032\0020\0012\006\020\005\032\0020\001H\003ø\001\000¢\006\004\b\031\020\032\032\032\020\033\032\0020\0222\006\020\002\032\0020\003H\001ø\001\000¢\006\004\b\034\020\035\032\032\020\033\032\0020\0222\006\020\002\032\0020\bH\001ø\001\000¢\006\004\b\036\020\037\032\032\020\033\032\0020\0222\006\020\002\032\0020\013H\001ø\001\000¢\006\004\b \020!\032\032\020\033\032\0020\0222\006\020\002\032\0020\016H\001ø\001\000¢\006\004\b\"\020#\002\004\n\002\b\031¨\006$"}, d2={"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "sortArray-GBYM_sE", "([B)V", "sortArray--ajY-9A", "([I)V", "sortArray-QwZRm1k", "([J)V", "sortArray-rL5Bavg", "([S)V", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class UArraySortingKt
{
  private static final int partition--nroSd4(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    long l1 = ULongArray.get-impl(paramArrayOfLong, (paramInt1 + paramInt2) / 2);
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1;
      int j;
      for (;;)
      {
        j = paramInt2;
        if (UnsignedKt.ulongCompare(ULongArray.get-impl(paramArrayOfLong, i), l1) >= 0) {
          break;
        }
        i += 1;
      }
      while (UnsignedKt.ulongCompare(ULongArray.get-impl(paramArrayOfLong, j), l1) > 0) {
        j -= 1;
      }
      paramInt1 = i;
      paramInt2 = j;
      if (i <= j)
      {
        long l2 = ULongArray.get-impl(paramArrayOfLong, i);
        ULongArray.set-k8EXiF4(paramArrayOfLong, i, ULongArray.get-impl(paramArrayOfLong, j));
        ULongArray.set-k8EXiF4(paramArrayOfLong, j, l2);
        paramInt1 = i + 1;
        paramInt2 = j - 1;
      }
    }
    return paramInt1;
  }
  
  private static final int partition-4UcCI2c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = UByteArray.get-impl(paramArrayOfByte, (paramInt1 + paramInt2) / 2);
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1;
      int j;
      for (;;)
      {
        int m = UByteArray.get-impl(paramArrayOfByte, i);
        paramInt1 = k & 0xFF;
        j = paramInt2;
        if (Intrinsics.compare(m & 0xFF, paramInt1) >= 0) {
          break;
        }
        i += 1;
      }
      while (Intrinsics.compare(UByteArray.get-impl(paramArrayOfByte, j) & 0xFF, paramInt1) > 0) {
        j -= 1;
      }
      paramInt1 = i;
      paramInt2 = j;
      if (i <= j)
      {
        byte b = UByteArray.get-impl(paramArrayOfByte, i);
        UByteArray.set-VurrAj0(paramArrayOfByte, i, UByteArray.get-impl(paramArrayOfByte, j));
        UByteArray.set-VurrAj0(paramArrayOfByte, j, b);
        paramInt1 = i + 1;
        paramInt2 = j - 1;
      }
    }
    return paramInt1;
  }
  
  private static final int partition-Aa5vz7o(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int k = UShortArray.get-impl(paramArrayOfShort, (paramInt1 + paramInt2) / 2);
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1;
      int j;
      for (;;)
      {
        int m = UShortArray.get-impl(paramArrayOfShort, i);
        paramInt1 = k & 0xFFFF;
        j = paramInt2;
        if (Intrinsics.compare(m & 0xFFFF, paramInt1) >= 0) {
          break;
        }
        i += 1;
      }
      while (Intrinsics.compare(UShortArray.get-impl(paramArrayOfShort, j) & 0xFFFF, paramInt1) > 0) {
        j -= 1;
      }
      paramInt1 = i;
      paramInt2 = j;
      if (i <= j)
      {
        short s = UShortArray.get-impl(paramArrayOfShort, i);
        UShortArray.set-01HTLdE(paramArrayOfShort, i, UShortArray.get-impl(paramArrayOfShort, j));
        UShortArray.set-01HTLdE(paramArrayOfShort, j, s);
        paramInt1 = i + 1;
        paramInt2 = j - 1;
      }
    }
    return paramInt1;
  }
  
  private static final int partition-oBK06Vg(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int k = UIntArray.get-impl(paramArrayOfInt, (paramInt1 + paramInt2) / 2);
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1;
      int j;
      for (;;)
      {
        j = paramInt2;
        if (UnsignedKt.uintCompare(UIntArray.get-impl(paramArrayOfInt, i), k) >= 0) {
          break;
        }
        i += 1;
      }
      while (UnsignedKt.uintCompare(UIntArray.get-impl(paramArrayOfInt, j), k) > 0) {
        j -= 1;
      }
      paramInt1 = i;
      paramInt2 = j;
      if (i <= j)
      {
        paramInt1 = UIntArray.get-impl(paramArrayOfInt, i);
        UIntArray.set-VXSXFK8(paramArrayOfInt, i, UIntArray.get-impl(paramArrayOfInt, j));
        UIntArray.set-VXSXFK8(paramArrayOfInt, j, paramInt1);
        paramInt1 = i + 1;
        paramInt2 = j - 1;
      }
    }
    return paramInt1;
  }
  
  private static final void quickSort--nroSd4(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    int i = partition--nroSd4(paramArrayOfLong, paramInt1, paramInt2);
    int j = i - 1;
    if (paramInt1 < j) {
      quickSort--nroSd4(paramArrayOfLong, paramInt1, j);
    }
    if (i < paramInt2) {
      quickSort--nroSd4(paramArrayOfLong, i, paramInt2);
    }
  }
  
  private static final void quickSort-4UcCI2c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = partition-4UcCI2c(paramArrayOfByte, paramInt1, paramInt2);
    int j = i - 1;
    if (paramInt1 < j) {
      quickSort-4UcCI2c(paramArrayOfByte, paramInt1, j);
    }
    if (i < paramInt2) {
      quickSort-4UcCI2c(paramArrayOfByte, i, paramInt2);
    }
  }
  
  private static final void quickSort-Aa5vz7o(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int i = partition-Aa5vz7o(paramArrayOfShort, paramInt1, paramInt2);
    int j = i - 1;
    if (paramInt1 < j) {
      quickSort-Aa5vz7o(paramArrayOfShort, paramInt1, j);
    }
    if (i < paramInt2) {
      quickSort-Aa5vz7o(paramArrayOfShort, i, paramInt2);
    }
  }
  
  private static final void quickSort-oBK06Vg(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = partition-oBK06Vg(paramArrayOfInt, paramInt1, paramInt2);
    int j = i - 1;
    if (paramInt1 < j) {
      quickSort-oBK06Vg(paramArrayOfInt, paramInt1, j);
    }
    if (i < paramInt2) {
      quickSort-oBK06Vg(paramArrayOfInt, i, paramInt2);
    }
  }
  
  public static final void sortArray--ajY-9A(int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "array");
    quickSort-oBK06Vg(paramArrayOfInt, 0, UIntArray.getSize-impl(paramArrayOfInt) - 1);
  }
  
  public static final void sortArray-GBYM_sE(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    quickSort-4UcCI2c(paramArrayOfByte, 0, UByteArray.getSize-impl(paramArrayOfByte) - 1);
  }
  
  public static final void sortArray-QwZRm1k(long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "array");
    quickSort--nroSd4(paramArrayOfLong, 0, ULongArray.getSize-impl(paramArrayOfLong) - 1);
  }
  
  public static final void sortArray-rL5Bavg(short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "array");
    quickSort-Aa5vz7o(paramArrayOfShort, 0, UShortArray.getSize-impl(paramArrayOfShort) - 1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\UArraySortingKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */