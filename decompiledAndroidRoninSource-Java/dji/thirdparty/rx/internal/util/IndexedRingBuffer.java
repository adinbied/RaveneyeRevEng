package dji.thirdparty.rx.internal.util;

import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Func1;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class IndexedRingBuffer<E>
  implements Subscription
{
  private static final ObjectPool<IndexedRingBuffer<?>> POOL = new ObjectPool()
  {
    protected IndexedRingBuffer<?> createObject()
    {
      return new IndexedRingBuffer();
    }
  };
  static final int SIZE = _size;
  static int _size = 256;
  private final ElementSection<E> elements = new ElementSection();
  final AtomicInteger index = new AtomicInteger();
  private final IndexSection removed = new IndexSection();
  final AtomicInteger removedIndex = new AtomicInteger();
  
  static
  {
    if (PlatformDependent.isAndroid()) {
      _size = 8;
    }
    String str = System.getProperty("rx.indexed-ring-buffer.size");
    if (str != null) {
      try
      {
        _size = Integer.parseInt(str);
      }
      catch (Exception localException)
      {
        PrintStream localPrintStream = System.err;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to set 'rx.indexed-ring-buffer.size' with value ");
        localStringBuilder.append(str);
        localStringBuilder.append(" => ");
        localStringBuilder.append(localException.getMessage());
        localPrintStream.println(localStringBuilder.toString());
      }
    }
  }
  
  private int forEach(Func1<? super E, Boolean> paramFunc1, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  private ElementSection<E> getElementSection(int paramInt)
  {
    return null;
  }
  
  private int getIndexForAdd()
  {
    return 0;
  }
  
  private int getIndexFromPreviouslyRemoved()
  {
    return 0;
  }
  
  private IndexSection getIndexSection(int paramInt)
  {
    return null;
  }
  
  public static <T> IndexedRingBuffer<T> getInstance()
  {
    return (IndexedRingBuffer)POOL.borrowObject();
  }
  
  /* Error */
  private void pushRemovedIndex(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  public int add(E paramE)
  {
    return 0;
  }
  
  public int forEach(Func1<? super E, Boolean> paramFunc1)
  {
    return forEach(paramFunc1, 0);
  }
  
  public int forEach(Func1<? super E, Boolean> paramFunc1, int paramInt)
  {
    return 0;
  }
  
  public boolean isUnsubscribed()
  {
    return false;
  }
  
  /* Error */
  public void releaseToPool()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public E remove(int paramInt)
  {
    return null;
  }
  
  public void unsubscribe()
  {
    releaseToPool();
  }
  
  private static class ElementSection<E>
  {
    final AtomicReferenceArray<E> array = new AtomicReferenceArray(IndexedRingBuffer.SIZE);
    final AtomicReference<ElementSection<E>> next = new AtomicReference();
    
    ElementSection<E> getNext()
    {
      return null;
    }
  }
  
  private static class IndexSection
  {
    private final AtomicReference<IndexSection> _next = new AtomicReference();
    private final AtomicIntegerArray unsafeArray = new AtomicIntegerArray(IndexedRingBuffer.SIZE);
    
    public int getAndSet(int paramInt1, int paramInt2)
    {
      return this.unsafeArray.getAndSet(paramInt1, paramInt2);
    }
    
    IndexSection getNext()
    {
      return null;
    }
    
    public void set(int paramInt1, int paramInt2)
    {
      this.unsafeArray.set(paramInt1, paramInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\IndexedRingBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */