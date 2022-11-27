package kotlin.collections.unsigned;

import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractList.Companion;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000>\n\000\n\002\020 \n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\026\032\034\020\000\032\b\022\004\022\0020\0020\001*\0020\003H\007ø\001\000¢\006\004\b\004\020\005\032\034\020\000\032\b\022\004\022\0020\0060\001*\0020\007H\007ø\001\000¢\006\004\b\b\020\t\032\034\020\000\032\b\022\004\022\0020\n0\001*\0020\013H\007ø\001\000¢\006\004\b\f\020\r\032\034\020\000\032\b\022\004\022\0020\0160\001*\0020\017H\007ø\001\000¢\006\004\b\020\020\021\0322\020\022\032\0020\023*\0020\0032\006\020\024\032\0020\0022\b\b\002\020\025\032\0020\0232\b\b\002\020\026\032\0020\023H\007ø\001\000¢\006\004\b\027\020\030\0322\020\022\032\0020\023*\0020\0072\006\020\024\032\0020\0062\b\b\002\020\025\032\0020\0232\b\b\002\020\026\032\0020\023H\007ø\001\000¢\006\004\b\031\020\032\0322\020\022\032\0020\023*\0020\0132\006\020\024\032\0020\n2\b\b\002\020\025\032\0020\0232\b\b\002\020\026\032\0020\023H\007ø\001\000¢\006\004\b\033\020\034\0322\020\022\032\0020\023*\0020\0172\006\020\024\032\0020\0162\b\b\002\020\025\032\0020\0232\b\b\002\020\026\032\0020\023H\007ø\001\000¢\006\004\b\035\020\036\032\037\020\037\032\0020\002*\0020\0032\006\020 \032\0020\023H\bø\001\000¢\006\004\b!\020\"\032\037\020\037\032\0020\006*\0020\0072\006\020 \032\0020\023H\bø\001\000¢\006\004\b#\020$\032\037\020\037\032\0020\n*\0020\0132\006\020 \032\0020\023H\bø\001\000¢\006\004\b%\020&\032\037\020\037\032\0020\016*\0020\0172\006\020 \032\0020\023H\bø\001\000¢\006\004\b'\020(\002\004\n\002\b\031¨\006)"}, d2={"asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, pn="kotlin.collections", xi=1, xs="kotlin/collections/unsigned/UArraysKt")
class UArraysKt___UArraysJvmKt
{
  public static final List<UInt> asList--ajY-9A(int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$asList");
    (List)new AbstractList()
    {
      public boolean contains-WZ4Q5Ns(int paramAnonymousInt)
      {
        return UIntArray.contains-WZ4Q5Ns(this.$this_asList, paramAnonymousInt);
      }
      
      public UInt get(int paramAnonymousInt)
      {
        return UInt.box-impl(UIntArray.get-impl(this.$this_asList, paramAnonymousInt));
      }
      
      public int getSize()
      {
        return UIntArray.getSize-impl(this.$this_asList);
      }
      
      public int indexOf-WZ4Q5Ns(int paramAnonymousInt)
      {
        return ArraysKt.indexOf(this.$this_asList, paramAnonymousInt);
      }
      
      public boolean isEmpty()
      {
        return UIntArray.isEmpty-impl(this.$this_asList);
      }
      
      public int lastIndexOf-WZ4Q5Ns(int paramAnonymousInt)
      {
        return ArraysKt.lastIndexOf(this.$this_asList, paramAnonymousInt);
      }
    };
  }
  
  public static final List<UByte> asList-GBYM_sE(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$asList");
    (List)new AbstractList()
    {
      public boolean contains-7apg3OU(byte paramAnonymousByte)
      {
        return UByteArray.contains-7apg3OU(this.$this_asList, paramAnonymousByte);
      }
      
      public UByte get(int paramAnonymousInt)
      {
        return UByte.box-impl(UByteArray.get-impl(this.$this_asList, paramAnonymousInt));
      }
      
      public int getSize()
      {
        return UByteArray.getSize-impl(this.$this_asList);
      }
      
      public int indexOf-7apg3OU(byte paramAnonymousByte)
      {
        return ArraysKt.indexOf(this.$this_asList, paramAnonymousByte);
      }
      
      public boolean isEmpty()
      {
        return UByteArray.isEmpty-impl(this.$this_asList);
      }
      
      public int lastIndexOf-7apg3OU(byte paramAnonymousByte)
      {
        return ArraysKt.lastIndexOf(this.$this_asList, paramAnonymousByte);
      }
    };
  }
  
  public static final List<ULong> asList-QwZRm1k(long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$asList");
    (List)new AbstractList()
    {
      public boolean contains-VKZWuLQ(long paramAnonymousLong)
      {
        return ULongArray.contains-VKZWuLQ(this.$this_asList, paramAnonymousLong);
      }
      
      public ULong get(int paramAnonymousInt)
      {
        return ULong.box-impl(ULongArray.get-impl(this.$this_asList, paramAnonymousInt));
      }
      
      public int getSize()
      {
        return ULongArray.getSize-impl(this.$this_asList);
      }
      
      public int indexOf-VKZWuLQ(long paramAnonymousLong)
      {
        return ArraysKt.indexOf(this.$this_asList, paramAnonymousLong);
      }
      
      public boolean isEmpty()
      {
        return ULongArray.isEmpty-impl(this.$this_asList);
      }
      
      public int lastIndexOf-VKZWuLQ(long paramAnonymousLong)
      {
        return ArraysKt.lastIndexOf(this.$this_asList, paramAnonymousLong);
      }
    };
  }
  
  public static final List<UShort> asList-rL5Bavg(short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$asList");
    (List)new AbstractList()
    {
      public boolean contains-xj2QHRw(short paramAnonymousShort)
      {
        return UShortArray.contains-xj2QHRw(this.$this_asList, paramAnonymousShort);
      }
      
      public UShort get(int paramAnonymousInt)
      {
        return UShort.box-impl(UShortArray.get-impl(this.$this_asList, paramAnonymousInt));
      }
      
      public int getSize()
      {
        return UShortArray.getSize-impl(this.$this_asList);
      }
      
      public int indexOf-xj2QHRw(short paramAnonymousShort)
      {
        return ArraysKt.indexOf(this.$this_asList, paramAnonymousShort);
      }
      
      public boolean isEmpty()
      {
        return UShortArray.isEmpty-impl(this.$this_asList);
      }
      
      public int lastIndexOf-xj2QHRw(short paramAnonymousShort)
      {
        return ArraysKt.lastIndexOf(this.$this_asList, paramAnonymousShort);
      }
    };
  }
  
  public static final int binarySearch-2fe2U9s(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$binarySearch");
    AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(paramInt2, paramInt3, UIntArray.getSize-impl(paramArrayOfInt));
    paramInt3 -= 1;
    while (paramInt2 <= paramInt3)
    {
      int i = paramInt2 + paramInt3 >>> 1;
      int j = UnsignedKt.uintCompare(paramArrayOfInt[i], paramInt1);
      if (j < 0) {
        paramInt2 = i + 1;
      } else if (j > 0) {
        paramInt3 = i - 1;
      } else {
        return i;
      }
    }
    return -(paramInt2 + 1);
  }
  
  public static final int binarySearch-EtDCXyQ(short[] paramArrayOfShort, short paramShort, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$binarySearch");
    AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(paramInt1, paramInt2, UShortArray.getSize-impl(paramArrayOfShort));
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      int j = UnsignedKt.uintCompare(paramArrayOfShort[i], paramShort & 0xFFFF);
      if (j < 0) {
        paramInt1 = i + 1;
      } else if (j > 0) {
        paramInt2 = i - 1;
      } else {
        return i;
      }
    }
    return -(paramInt1 + 1);
  }
  
  public static final int binarySearch-K6DWlUc(long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$binarySearch");
    AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(paramInt1, paramInt2, ULongArray.getSize-impl(paramArrayOfLong));
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      int j = UnsignedKt.ulongCompare(paramArrayOfLong[i], paramLong);
      if (j < 0) {
        paramInt1 = i + 1;
      } else if (j > 0) {
        paramInt2 = i - 1;
      } else {
        return i;
      }
    }
    return -(paramInt1 + 1);
  }
  
  public static final int binarySearch-WpHrYlw(byte[] paramArrayOfByte, byte paramByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$binarySearch");
    AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(paramInt1, paramInt2, UByteArray.getSize-impl(paramArrayOfByte));
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      int j = UnsignedKt.uintCompare(paramArrayOfByte[i], paramByte & 0xFF);
      if (j < 0) {
        paramInt1 = i + 1;
      } else if (j > 0) {
        paramInt2 = i - 1;
      } else {
        return i;
      }
    }
    return -(paramInt1 + 1);
  }
  
  private static final byte elementAt-PpDY95g(byte[] paramArrayOfByte, int paramInt)
  {
    return UByteArray.get-impl(paramArrayOfByte, paramInt);
  }
  
  private static final short elementAt-nggk6HY(short[] paramArrayOfShort, int paramInt)
  {
    return UShortArray.get-impl(paramArrayOfShort, paramInt);
  }
  
  private static final int elementAt-qFRl0hI(int[] paramArrayOfInt, int paramInt)
  {
    return UIntArray.get-impl(paramArrayOfInt, paramInt);
  }
  
  private static final long elementAt-r7IrZao(long[] paramArrayOfLong, int paramInt)
  {
    return ULongArray.get-impl(paramArrayOfLong, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collection\\unsigned\UArraysKt___UArraysJvmKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */