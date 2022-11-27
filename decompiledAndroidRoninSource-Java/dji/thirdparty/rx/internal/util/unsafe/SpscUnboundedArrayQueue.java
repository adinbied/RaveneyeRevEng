package dji.thirdparty.rx.internal.util.unsafe;

import java.lang.reflect.Field;
import java.util.Iterator;
import sun.misc.Unsafe;

public class SpscUnboundedArrayQueue<E>
  extends SpscUnboundedArrayQueueConsumerField<E>
  implements QueueProgressIndicators
{
  private static final long C_INDEX_OFFSET;
  private static final Object HAS_NEXT;
  static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
  private static final long P_INDEX_OFFSET;
  private static final long REF_ARRAY_BASE = UnsafeAccess.UNSAFE.arrayBaseOffset(Object[].class);
  private static final int REF_ELEMENT_SHIFT;
  
  static
  {
    HAS_NEXT = new Object();
    int i = UnsafeAccess.UNSAFE.arrayIndexScale(Object[].class);
    if (4 == i)
    {
      REF_ELEMENT_SHIFT = 2;
    }
    else
    {
      if (8 != i) {
        break label124;
      }
      REF_ELEMENT_SHIFT = 3;
    }
    try
    {
      Field localField = SpscUnboundedArrayQueueProducerFields.class.getDeclaredField("producerIndex");
      P_INDEX_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(localField);
      try
      {
        localField = SpscUnboundedArrayQueueConsumerField.class.getDeclaredField("consumerIndex");
        C_INDEX_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(localField);
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        throw new RuntimeException(localNoSuchFieldException1);
      }
      throw new IllegalStateException("Unknown pointer size");
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      throw new RuntimeException(localNoSuchFieldException2);
    }
  }
  
  public SpscUnboundedArrayQueue(int paramInt)
  {
    paramInt = Pow2.roundToPowerOfTwo(paramInt);
    long l = paramInt - 1;
    Object[] arrayOfObject = (Object[])new Object[paramInt + 1];
    this.producerBuffer = arrayOfObject;
    this.producerMask = l;
    adjustLookAheadStep(paramInt);
    this.consumerBuffer = arrayOfObject;
    this.consumerMask = l;
    this.producerLookAhead = (l - 1L);
    soProducerIndex(0L);
  }
  
  /* Error */
  private void adjustLookAheadStep(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private static long calcDirectOffset(long paramLong)
  {
    return REF_ARRAY_BASE + (paramLong << REF_ELEMENT_SHIFT);
  }
  
  private static long calcWrappedOffset(long paramLong1, long paramLong2)
  {
    return calcDirectOffset(paramLong1 & paramLong2);
  }
  
  private long lvConsumerIndex()
  {
    return 278041895L;
  }
  
  private static <E> Object lvElement(E[] paramArrayOfE, long paramLong)
  {
    return UnsafeAccess.UNSAFE.getObjectVolatile(paramArrayOfE, paramLong);
  }
  
  private E[] lvNext(E[] paramArrayOfE)
  {
    return null;
  }
  
  private long lvProducerIndex()
  {
    return 278041913L;
  }
  
  private E newBufferPeek(E[] paramArrayOfE, long paramLong1, long paramLong2)
  {
    this.consumerBuffer = paramArrayOfE;
    return (E)lvElement(paramArrayOfE, calcWrappedOffset(paramLong1, paramLong2));
  }
  
  private E newBufferPoll(E[] paramArrayOfE, long paramLong1, long paramLong2)
  {
    return null;
  }
  
  /* Error */
  private void resize(E[] arg1, long arg2, long arg4, E arg6, long arg7)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void soConsumerIndex(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  private static void soElement(Object[] paramArrayOfObject, long paramLong, Object paramObject)
  {
    UnsafeAccess.UNSAFE.putOrderedObject(paramArrayOfObject, paramLong, paramObject);
  }
  
  /* Error */
  private void soNext(E[] arg1, E[] arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void soProducerIndex(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  private boolean writeToQueue(E[] paramArrayOfE, E paramE, long paramLong1, long paramLong2)
  {
    return false;
  }
  
  public long currentConsumerIndex()
  {
    return lvConsumerIndex();
  }
  
  public long currentProducerIndex()
  {
    return lvProducerIndex();
  }
  
  public final Iterator<E> iterator()
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean offer(E paramE)
  {
    return false;
  }
  
  public final E peek()
  {
    return null;
  }
  
  public final E poll()
  {
    return null;
  }
  
  public final int size()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\SpscUnboundedArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */