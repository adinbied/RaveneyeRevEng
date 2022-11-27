package kotlin.collections;

import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@Deprecated(level=DeprecationLevel.HIDDEN, message="Provided for binary compatibility")
@Metadata(bv={1, 0, 3}, d1={"\000l\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\t\n\002\020\016\n\002\b\t\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\021\n\002\b\t\bÇ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\037\020\003\032\0020\004*\0020\0052\006\020\006\032\0020\005H\004ø\001\000¢\006\004\b\007\020\bJ\037\020\003\032\0020\004*\0020\t2\006\020\006\032\0020\tH\004ø\001\000¢\006\004\b\n\020\013J\037\020\003\032\0020\004*\0020\f2\006\020\006\032\0020\fH\004ø\001\000¢\006\004\b\r\020\016J\037\020\003\032\0020\004*\0020\0172\006\020\006\032\0020\017H\004ø\001\000¢\006\004\b\020\020\021J\026\020\022\032\0020\023*\0020\005H\007ø\001\000¢\006\004\b\024\020\025J\026\020\022\032\0020\023*\0020\tH\007ø\001\000¢\006\004\b\026\020\027J\026\020\022\032\0020\023*\0020\fH\007ø\001\000¢\006\004\b\030\020\031J\026\020\022\032\0020\023*\0020\017H\007ø\001\000¢\006\004\b\032\020\033J\026\020\034\032\0020\035*\0020\005H\007ø\001\000¢\006\004\b\036\020\037J\026\020\034\032\0020\035*\0020\tH\007ø\001\000¢\006\004\b \020!J\026\020\034\032\0020\035*\0020\fH\007ø\001\000¢\006\004\b\"\020#J\026\020\034\032\0020\035*\0020\017H\007ø\001\000¢\006\004\b$\020%J\036\020&\032\0020'*\0020\0052\006\020&\032\0020(H\007ø\001\000¢\006\004\b)\020*J\036\020&\032\0020+*\0020\t2\006\020&\032\0020(H\007ø\001\000¢\006\004\b,\020-J\036\020&\032\0020.*\0020\f2\006\020&\032\0020(H\007ø\001\000¢\006\004\b/\0200J\036\020&\032\00201*\0020\0172\006\020&\032\0020(H\007ø\001\000¢\006\004\b2\0203J\034\0204\032\b\022\004\022\0020'05*\0020\005H\007ø\001\000¢\006\004\b6\0207J\034\0204\032\b\022\004\022\0020+05*\0020\tH\007ø\001\000¢\006\004\b8\0209J\034\0204\032\b\022\004\022\0020.05*\0020\fH\007ø\001\000¢\006\004\b:\020;J\034\0204\032\b\022\004\022\0020105*\0020\017H\007ø\001\000¢\006\004\b<\020=\002\004\n\002\b\031¨\006>"}, d2={"Lkotlin/collections/UArraysKt;", "", "()V", "contentEquals", "", "Lkotlin/UByteArray;", "other", "contentEquals-kdPth3s", "([B[B)Z", "Lkotlin/UIntArray;", "contentEquals-ctEhBpI", "([I[I)Z", "Lkotlin/ULongArray;", "contentEquals-us8wMrg", "([J[J)Z", "Lkotlin/UShortArray;", "contentEquals-mazbYpA", "([S[S)Z", "contentHashCode", "", "contentHashCode-GBYM_sE", "([B)I", "contentHashCode--ajY-9A", "([I)I", "contentHashCode-QwZRm1k", "([J)I", "contentHashCode-rL5Bavg", "([S)I", "contentToString", "", "contentToString-GBYM_sE", "([B)Ljava/lang/String;", "contentToString--ajY-9A", "([I)Ljava/lang/String;", "contentToString-QwZRm1k", "([J)Ljava/lang/String;", "contentToString-rL5Bavg", "([S)Ljava/lang/String;", "random", "Lkotlin/UByte;", "Lkotlin/random/Random;", "random-oSF2wD8", "([BLkotlin/random/Random;)B", "Lkotlin/UInt;", "random-2D5oskM", "([ILkotlin/random/Random;)I", "Lkotlin/ULong;", "random-JzugnMA", "([JLkotlin/random/Random;)J", "Lkotlin/UShort;", "random-s5X_as8", "([SLkotlin/random/Random;)S", "toTypedArray", "", "toTypedArray-GBYM_sE", "([B)[Lkotlin/UByte;", "toTypedArray--ajY-9A", "([I)[Lkotlin/UInt;", "toTypedArray-QwZRm1k", "([J)[Lkotlin/ULong;", "toTypedArray-rL5Bavg", "([S)[Lkotlin/UShort;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class UArraysKt
{
  public static final UArraysKt INSTANCE = new UArraysKt();
  
  @JvmStatic
  public static final boolean contentEquals-ctEhBpI(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt1, "$this$contentEquals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt2, "other");
    return Arrays.equals(paramArrayOfInt1, paramArrayOfInt2);
  }
  
  @JvmStatic
  public static final boolean contentEquals-kdPth3s(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte1, "$this$contentEquals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte2, "other");
    return Arrays.equals(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  @JvmStatic
  public static final boolean contentEquals-mazbYpA(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort1, "$this$contentEquals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort2, "other");
    return Arrays.equals(paramArrayOfShort1, paramArrayOfShort2);
  }
  
  @JvmStatic
  public static final boolean contentEquals-us8wMrg(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong1, "$this$contentEquals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong2, "other");
    return Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
  }
  
  @JvmStatic
  public static final int contentHashCode--ajY-9A(int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$contentHashCode");
    return Arrays.hashCode(paramArrayOfInt);
  }
  
  @JvmStatic
  public static final int contentHashCode-GBYM_sE(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$contentHashCode");
    return Arrays.hashCode(paramArrayOfByte);
  }
  
  @JvmStatic
  public static final int contentHashCode-QwZRm1k(long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$contentHashCode");
    return Arrays.hashCode(paramArrayOfLong);
  }
  
  @JvmStatic
  public static final int contentHashCode-rL5Bavg(short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$contentHashCode");
    return Arrays.hashCode(paramArrayOfShort);
  }
  
  @JvmStatic
  public static final String contentToString--ajY-9A(int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$contentToString");
    return CollectionsKt.joinToString$default(UIntArray.box-impl(paramArrayOfInt), (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56, null);
  }
  
  @JvmStatic
  public static final String contentToString-GBYM_sE(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$contentToString");
    return CollectionsKt.joinToString$default(UByteArray.box-impl(paramArrayOfByte), (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56, null);
  }
  
  @JvmStatic
  public static final String contentToString-QwZRm1k(long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$contentToString");
    return CollectionsKt.joinToString$default(ULongArray.box-impl(paramArrayOfLong), (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56, null);
  }
  
  @JvmStatic
  public static final String contentToString-rL5Bavg(short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$contentToString");
    return CollectionsKt.joinToString$default(UShortArray.box-impl(paramArrayOfShort), (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56, null);
  }
  
  @JvmStatic
  public static final int random-2D5oskM(int[] paramArrayOfInt, Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (!UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return UIntArray.get-impl(paramArrayOfInt, paramRandom.nextInt(UIntArray.getSize-impl(paramArrayOfInt)));
    }
    throw ((Throwable)new NoSuchElementException("Array is empty."));
  }
  
  @JvmStatic
  public static final long random-JzugnMA(long[] paramArrayOfLong, Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (!ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return ULongArray.get-impl(paramArrayOfLong, paramRandom.nextInt(ULongArray.getSize-impl(paramArrayOfLong)));
    }
    throw ((Throwable)new NoSuchElementException("Array is empty."));
  }
  
  @JvmStatic
  public static final byte random-oSF2wD8(byte[] paramArrayOfByte, Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (!UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return UByteArray.get-impl(paramArrayOfByte, paramRandom.nextInt(UByteArray.getSize-impl(paramArrayOfByte)));
    }
    throw ((Throwable)new NoSuchElementException("Array is empty."));
  }
  
  @JvmStatic
  public static final short random-s5X_as8(short[] paramArrayOfShort, Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (!UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return UShortArray.get-impl(paramArrayOfShort, paramRandom.nextInt(UShortArray.getSize-impl(paramArrayOfShort)));
    }
    throw ((Throwable)new NoSuchElementException("Array is empty."));
  }
  
  @JvmStatic
  public static final UInt[] toTypedArray--ajY-9A(int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$toTypedArray");
    int j = UIntArray.getSize-impl(paramArrayOfInt);
    UInt[] arrayOfUInt = new UInt[j];
    int i = 0;
    while (i < j)
    {
      arrayOfUInt[i] = UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i));
      i += 1;
    }
    return arrayOfUInt;
  }
  
  @JvmStatic
  public static final UByte[] toTypedArray-GBYM_sE(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toTypedArray");
    int j = UByteArray.getSize-impl(paramArrayOfByte);
    UByte[] arrayOfUByte = new UByte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfUByte[i] = UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i));
      i += 1;
    }
    return arrayOfUByte;
  }
  
  @JvmStatic
  public static final ULong[] toTypedArray-QwZRm1k(long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$toTypedArray");
    int j = ULongArray.getSize-impl(paramArrayOfLong);
    ULong[] arrayOfULong = new ULong[j];
    int i = 0;
    while (i < j)
    {
      arrayOfULong[i] = ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i));
      i += 1;
    }
    return arrayOfULong;
  }
  
  @JvmStatic
  public static final UShort[] toTypedArray-rL5Bavg(short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$toTypedArray");
    int j = UShortArray.getSize-impl(paramArrayOfShort);
    UShort[] arrayOfUShort = new UShort[j];
    int i = 0;
    while (i < j)
    {
      arrayOfUShort[i] = UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i));
      i += 1;
    }
    return arrayOfUShort;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\UArraysKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */