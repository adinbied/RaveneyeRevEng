package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\"\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\032\034\020\000\032\0020\001*\b\022\004\022\0020\0030\002H\007ø\001\000¢\006\004\b\004\020\005\032\034\020\000\032\0020\001*\b\022\004\022\0020\0010\002H\007ø\001\000¢\006\004\b\006\020\005\032\034\020\000\032\0020\007*\b\022\004\022\0020\0070\002H\007ø\001\000¢\006\004\b\b\020\t\032\034\020\000\032\0020\001*\b\022\004\022\0020\n0\002H\007ø\001\000¢\006\004\b\013\020\005\002\004\n\002\b\031¨\006\f"}, d2={"sum", "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "Lkotlin/UByte;", "sumOfUByte", "(Lkotlin/sequences/Sequence;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/sequences/USequencesKt")
class USequencesKt___USequencesKt
{
  public static final int sumOfUByte(Sequence<UByte> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (int i = 0; paramSequence.hasNext(); i = UInt.constructor-impl(i + UInt.constructor-impl(((UByte)paramSequence.next()).unbox-impl() & 0xFF))) {}
    return i;
  }
  
  public static final int sumOfUInt(Sequence<UInt> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (int i = 0; paramSequence.hasNext(); i = UInt.constructor-impl(i + ((UInt)paramSequence.next()).unbox-impl())) {}
    return i;
  }
  
  public static final long sumOfULong(Sequence<ULong> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (long l = 0L; paramSequence.hasNext(); l = ULong.constructor-impl(l + ((ULong)paramSequence.next()).unbox-impl())) {}
    return l;
  }
  
  public static final int sumOfUShort(Sequence<UShort> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (int i = 0; paramSequence.hasNext(); i = UInt.constructor-impl(i + UInt.constructor-impl(((UShort)paramSequence.next()).unbox-impl() & 0xFFFF))) {}
    return i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\sequences\USequencesKt___USequencesKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */