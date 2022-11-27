package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.functions.Predicate;
import org.reactivestreams.Subscriber;

public class AppendOnlyLinkedArrayList<T>
{
  final int capacity;
  final Object[] head;
  int offset;
  Object[] tail;
  
  public AppendOnlyLinkedArrayList(int paramInt)
  {
    this.capacity = paramInt;
    Object[] arrayOfObject = new Object[paramInt + 1];
    this.head = arrayOfObject;
    this.tail = arrayOfObject;
  }
  
  public <U> boolean accept(Observer<? super U> paramObserver)
  {
    return false;
  }
  
  public <U> boolean accept(Subscriber<? super U> paramSubscriber)
  {
    return false;
  }
  
  /* Error */
  public void add(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void forEachWhile(NonThrowingPredicate<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public <S> void forEachWhile(S arg1, io.reactivex.functions.BiPredicate<? super S, ? super T> arg2)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setFirst(T paramT)
  {
    this.head[0] = paramT;
  }
  
  public static abstract interface NonThrowingPredicate<T>
    extends Predicate<T>
  {
    public abstract boolean test(T paramT);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\AppendOnlyLinkedArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */