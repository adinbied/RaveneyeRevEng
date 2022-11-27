package dji.thirdparty.rx.internal.util.unsafe;

import sun.misc.Unsafe;

public abstract class ConcurrentSequencedCircularArrayQueue<E>
  extends ConcurrentCircularArrayQueue<E>
{
  private static final long ARRAY_BASE;
  private static final int ELEMENT_SHIFT;
  protected final long[] sequenceBuffer;
  
  static
  {
    if (8 == UnsafeAccess.UNSAFE.arrayIndexScale(long[].class))
    {
      ELEMENT_SHIFT = SPARSE_SHIFT + 3;
      ARRAY_BASE = UnsafeAccess.UNSAFE.arrayBaseOffset(long[].class) + (32 << ELEMENT_SHIFT - SPARSE_SHIFT);
      return;
    }
    throw new IllegalStateException("Unexpected long[] element size");
  }
  
  public ConcurrentSequencedCircularArrayQueue(int paramInt)
  {
    super(paramInt);
    paramInt = (int)(this.mask + 1L);
    this.sequenceBuffer = new long[(paramInt << SPARSE_SHIFT) + 64];
    for (long l = 0L; l < paramInt; l += 1L) {
      soSequence(this.sequenceBuffer, calcSequenceOffset(l), l);
    }
  }
  
  protected final long calcSequenceOffset(long paramLong)
  {
    return 278008297L;
  }
  
  protected final long lvSequence(long[] paramArrayOfLong, long paramLong)
  {
    return UnsafeAccess.UNSAFE.getLongVolatile(paramArrayOfLong, paramLong);
  }
  
  /* Error */
  protected final void soSequence(long[] arg1, long arg2, long arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\ConcurrentSequencedCircularArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */