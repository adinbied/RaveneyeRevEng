package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\"\n\000\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\016\032\"\020\000\032\0020\0012\006\020\002\032\0020\0012\006\020\003\032\0020\001H\007ø\001\000¢\006\004\b\004\020\005\032+\020\000\032\0020\0012\006\020\002\032\0020\0012\006\020\003\032\0020\0012\006\020\006\032\0020\001H\bø\001\000¢\006\004\b\007\020\b\032\"\020\000\032\0020\t2\006\020\002\032\0020\t2\006\020\003\032\0020\tH\007ø\001\000¢\006\004\b\n\020\013\032+\020\000\032\0020\t2\006\020\002\032\0020\t2\006\020\003\032\0020\t2\006\020\006\032\0020\tH\bø\001\000¢\006\004\b\f\020\r\032\"\020\000\032\0020\0162\006\020\002\032\0020\0162\006\020\003\032\0020\016H\007ø\001\000¢\006\004\b\017\020\020\032+\020\000\032\0020\0162\006\020\002\032\0020\0162\006\020\003\032\0020\0162\006\020\006\032\0020\016H\bø\001\000¢\006\004\b\021\020\022\032\"\020\000\032\0020\0232\006\020\002\032\0020\0232\006\020\003\032\0020\023H\007ø\001\000¢\006\004\b\024\020\025\032+\020\000\032\0020\0232\006\020\002\032\0020\0232\006\020\003\032\0020\0232\006\020\006\032\0020\023H\bø\001\000¢\006\004\b\026\020\027\032\"\020\030\032\0020\0012\006\020\002\032\0020\0012\006\020\003\032\0020\001H\007ø\001\000¢\006\004\b\031\020\005\032+\020\030\032\0020\0012\006\020\002\032\0020\0012\006\020\003\032\0020\0012\006\020\006\032\0020\001H\bø\001\000¢\006\004\b\032\020\b\032\"\020\030\032\0020\t2\006\020\002\032\0020\t2\006\020\003\032\0020\tH\007ø\001\000¢\006\004\b\033\020\013\032+\020\030\032\0020\t2\006\020\002\032\0020\t2\006\020\003\032\0020\t2\006\020\006\032\0020\tH\bø\001\000¢\006\004\b\034\020\r\032\"\020\030\032\0020\0162\006\020\002\032\0020\0162\006\020\003\032\0020\016H\007ø\001\000¢\006\004\b\035\020\020\032+\020\030\032\0020\0162\006\020\002\032\0020\0162\006\020\003\032\0020\0162\006\020\006\032\0020\016H\bø\001\000¢\006\004\b\036\020\022\032\"\020\030\032\0020\0232\006\020\002\032\0020\0232\006\020\003\032\0020\023H\007ø\001\000¢\006\004\b\037\020\025\032+\020\030\032\0020\0232\006\020\002\032\0020\0232\006\020\003\032\0020\0232\006\020\006\032\0020\023H\bø\001\000¢\006\004\b \020\027\002\004\n\002\b\031¨\006!"}, d2={"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-5PvTz6A", "minOf-VKSA0NQ", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/comparisons/UComparisonsKt")
class UComparisonsKt___UComparisonsKt
{
  public static final short maxOf-5PvTz6A(short paramShort1, short paramShort2)
  {
    if (Intrinsics.compare(paramShort1 & 0xFFFF, 0xFFFF & paramShort2) >= 0) {
      return paramShort1;
    }
    return paramShort2;
  }
  
  public static final int maxOf-J1ME1BU(int paramInt1, int paramInt2)
  {
    if (UnsignedKt.uintCompare(paramInt1, paramInt2) >= 0) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static final byte maxOf-Kr8caGY(byte paramByte1, byte paramByte2)
  {
    if (Intrinsics.compare(paramByte1 & 0xFF, paramByte2 & 0xFF) >= 0) {
      return paramByte1;
    }
    return paramByte2;
  }
  
  private static final short maxOf-VKSA0NQ(short paramShort1, short paramShort2, short paramShort3)
  {
    return UComparisonsKt.maxOf-5PvTz6A(paramShort1, UComparisonsKt.maxOf-5PvTz6A(paramShort2, paramShort3));
  }
  
  private static final int maxOf-WZ9TVnA(int paramInt1, int paramInt2, int paramInt3)
  {
    return UComparisonsKt.maxOf-J1ME1BU(paramInt1, UComparisonsKt.maxOf-J1ME1BU(paramInt2, paramInt3));
  }
  
  private static final byte maxOf-b33U2AM(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    return UComparisonsKt.maxOf-Kr8caGY(paramByte1, UComparisonsKt.maxOf-Kr8caGY(paramByte2, paramByte3));
  }
  
  public static final long maxOf-eb3DHEI(long paramLong1, long paramLong2)
  {
    if (UnsignedKt.ulongCompare(paramLong1, paramLong2) >= 0) {
      return paramLong1;
    }
    return paramLong2;
  }
  
  private static final long maxOf-sambcqE(long paramLong1, long paramLong2, long paramLong3)
  {
    return UComparisonsKt.maxOf-eb3DHEI(paramLong1, UComparisonsKt.maxOf-eb3DHEI(paramLong2, paramLong3));
  }
  
  public static final short minOf-5PvTz6A(short paramShort1, short paramShort2)
  {
    if (Intrinsics.compare(paramShort1 & 0xFFFF, 0xFFFF & paramShort2) <= 0) {
      return paramShort1;
    }
    return paramShort2;
  }
  
  public static final int minOf-J1ME1BU(int paramInt1, int paramInt2)
  {
    if (UnsignedKt.uintCompare(paramInt1, paramInt2) <= 0) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static final byte minOf-Kr8caGY(byte paramByte1, byte paramByte2)
  {
    if (Intrinsics.compare(paramByte1 & 0xFF, paramByte2 & 0xFF) <= 0) {
      return paramByte1;
    }
    return paramByte2;
  }
  
  private static final short minOf-VKSA0NQ(short paramShort1, short paramShort2, short paramShort3)
  {
    return UComparisonsKt.minOf-5PvTz6A(paramShort1, UComparisonsKt.minOf-5PvTz6A(paramShort2, paramShort3));
  }
  
  private static final int minOf-WZ9TVnA(int paramInt1, int paramInt2, int paramInt3)
  {
    return UComparisonsKt.minOf-J1ME1BU(paramInt1, UComparisonsKt.minOf-J1ME1BU(paramInt2, paramInt3));
  }
  
  private static final byte minOf-b33U2AM(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    return UComparisonsKt.minOf-Kr8caGY(paramByte1, UComparisonsKt.minOf-Kr8caGY(paramByte2, paramByte3));
  }
  
  public static final long minOf-eb3DHEI(long paramLong1, long paramLong2)
  {
    if (UnsignedKt.ulongCompare(paramLong1, paramLong2) <= 0) {
      return paramLong1;
    }
    return paramLong2;
  }
  
  private static final long minOf-sambcqE(long paramLong1, long paramLong2, long paramLong3)
  {
    return UComparisonsKt.minOf-eb3DHEI(paramLong1, UComparisonsKt.minOf-eb3DHEI(paramLong2, paramLong3));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\comparisons\UComparisonsKt___UComparisonsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */