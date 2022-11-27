package okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000$\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\t\n\002\b\006\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\003\bÁ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\020\032\0020\0212\006\020\022\032\0020\013J\006\020\023\032\0020\013R\016\020\003\032\0020\004XT¢\006\002\n\000R\032\020\005\032\0020\004X\016¢\006\016\n\000\032\004\b\006\020\007\"\004\b\b\020\tR\034\020\n\032\004\030\0010\013X\016¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017¨\006\024"}, d2={"Lokio/SegmentPool;", "", "()V", "MAX_SIZE", "", "byteCount", "getByteCount", "()J", "setByteCount", "(J)V", "next", "Lokio/Segment;", "getNext", "()Lokio/Segment;", "setNext", "(Lokio/Segment;)V", "recycle", "", "segment", "take", "okio"}, k=1, mv={1, 1, 16})
public final class SegmentPool
{
  public static final SegmentPool INSTANCE = new SegmentPool();
  public static final long MAX_SIZE = 65536L;
  private static long byteCount;
  private static Segment next;
  
  public final long getByteCount()
  {
    return byteCount;
  }
  
  public final Segment getNext()
  {
    return next;
  }
  
  public final void recycle(Segment paramSegment)
  {
    Intrinsics.checkParameterIsNotNull(paramSegment, "segment");
    int i;
    if ((paramSegment.next == null) && (paramSegment.prev == null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramSegment.shared) {
        return;
      }
      try
      {
        long l1 = byteCount;
        long l2 = ' ';
        if (l1 + l2 > 65536L) {
          return;
        }
        byteCount += l2;
        paramSegment.next = next;
        paramSegment.limit = 0;
        paramSegment.pos = paramSegment.limit;
        next = paramSegment;
        paramSegment = Unit.INSTANCE;
        return;
      }
      finally {}
    }
    throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
  }
  
  public final void setByteCount(long paramLong)
  {
    byteCount = paramLong;
  }
  
  public final void setNext(Segment paramSegment)
  {
    next = paramSegment;
  }
  
  public final Segment take()
  {
    try
    {
      Segment localSegment = next;
      if (localSegment != null)
      {
        next = localSegment.next;
        localSegment.next = ((Segment)null);
        byteCount -= ' ';
        return localSegment;
      }
      return new Segment();
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\SegmentPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */