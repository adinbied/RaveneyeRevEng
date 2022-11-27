package io.reactivex.internal.util;

import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;

public final class BackpressureHelper
{
  private BackpressureHelper()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static long add(AtomicLong paramAtomicLong, long paramLong)
  {
    long l;
    do
    {
      l = paramAtomicLong.get();
      if (l == Long.MAX_VALUE) {
        return Long.MAX_VALUE;
      }
    } while (!paramAtomicLong.compareAndSet(l, addCap(l, paramLong)));
    return l;
  }
  
  public static long addCancel(AtomicLong paramAtomicLong, long paramLong)
  {
    long l;
    do
    {
      l = paramAtomicLong.get();
      if (l == Long.MIN_VALUE) {
        return Long.MIN_VALUE;
      }
      if (l == Long.MAX_VALUE) {
        return Long.MAX_VALUE;
      }
    } while (!paramAtomicLong.compareAndSet(l, addCap(l, paramLong)));
    return l;
  }
  
  public static long addCap(long paramLong1, long paramLong2)
  {
    paramLong2 = paramLong1 + paramLong2;
    paramLong1 = paramLong2;
    if (paramLong2 < 0L) {
      paramLong1 = Long.MAX_VALUE;
    }
    return paramLong1;
  }
  
  public static long multiplyCap(long paramLong1, long paramLong2)
  {
    long l = paramLong1 * paramLong2;
    if (((paramLong1 | paramLong2) >>> 31 != 0L) && (l / paramLong1 != paramLong2)) {
      return Long.MAX_VALUE;
    }
    return l;
  }
  
  public static long produced(AtomicLong paramAtomicLong, long paramLong)
  {
    long l3;
    long l1;
    do
    {
      l3 = paramAtomicLong.get();
      if (l3 == Long.MAX_VALUE) {
        return Long.MAX_VALUE;
      }
      long l2 = l3 - paramLong;
      l1 = l2;
      if (l2 < 0L)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("More produced than requested: ");
        localStringBuilder.append(l2);
        RxJavaPlugins.onError(new IllegalStateException(localStringBuilder.toString()));
        l1 = 0L;
      }
    } while (!paramAtomicLong.compareAndSet(l3, l1));
    return l1;
  }
  
  public static long producedCancel(AtomicLong paramAtomicLong, long paramLong)
  {
    long l3;
    long l1;
    do
    {
      l3 = paramAtomicLong.get();
      if (l3 == Long.MIN_VALUE) {
        return Long.MIN_VALUE;
      }
      if (l3 == Long.MAX_VALUE) {
        return Long.MAX_VALUE;
      }
      long l2 = l3 - paramLong;
      l1 = l2;
      if (l2 < 0L)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("More produced than requested: ");
        localStringBuilder.append(l2);
        RxJavaPlugins.onError(new IllegalStateException(localStringBuilder.toString()));
        l1 = 0L;
      }
    } while (!paramAtomicLong.compareAndSet(l3, l1));
    return l1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\BackpressureHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */