package dji.thirdparty.okio;

final class SegmentPool
{
  static final long MAX_SIZE = 65536L;
  static long byteCount;
  static Segment next;
  
  static void recycle(Segment paramSegment)
  {
    if ((paramSegment.next == null) && (paramSegment.prev == null))
    {
      if (paramSegment.shared) {
        return;
      }
      try
      {
        if (byteCount + 8192L > 65536L) {
          return;
        }
        byteCount += 8192L;
        paramSegment.next = next;
        paramSegment.limit = 0;
        paramSegment.pos = 0;
        next = paramSegment;
        return;
      }
      finally {}
    }
    throw new IllegalArgumentException();
  }
  
  static Segment take()
  {
    try
    {
      if (next != null)
      {
        Segment localSegment = next;
        next = localSegment.next;
        localSegment.next = null;
        byteCount -= 8192L;
        return localSegment;
      }
      return new Segment();
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okio\SegmentPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */