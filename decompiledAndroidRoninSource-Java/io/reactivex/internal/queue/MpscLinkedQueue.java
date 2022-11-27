package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

public final class MpscLinkedQueue<T>
  implements SimplePlainQueue<T>
{
  private final AtomicReference<LinkedQueueNode<T>> consumerNode = new AtomicReference();
  private final AtomicReference<LinkedQueueNode<T>> producerNode = new AtomicReference();
  
  public MpscLinkedQueue()
  {
    LinkedQueueNode localLinkedQueueNode = new LinkedQueueNode();
    spConsumerNode(localLinkedQueueNode);
    xchgProducerNode(localLinkedQueueNode);
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  LinkedQueueNode<T> lpConsumerNode()
  {
    return null;
  }
  
  LinkedQueueNode<T> lvConsumerNode()
  {
    return null;
  }
  
  LinkedQueueNode<T> lvProducerNode()
  {
    return null;
  }
  
  public boolean offer(T paramT)
  {
    return false;
  }
  
  public boolean offer(T paramT1, T paramT2)
  {
    offer(paramT1);
    offer(paramT2);
    return true;
  }
  
  public T poll()
  {
    return null;
  }
  
  void spConsumerNode(LinkedQueueNode<T> paramLinkedQueueNode)
  {
    this.consumerNode.lazySet(paramLinkedQueueNode);
  }
  
  LinkedQueueNode<T> xchgProducerNode(LinkedQueueNode<T> paramLinkedQueueNode)
  {
    return null;
  }
  
  static final class LinkedQueueNode<E>
    extends AtomicReference<LinkedQueueNode<E>>
  {
    private static final long serialVersionUID = 2404266111789071508L;
    private E value;
    
    LinkedQueueNode() {}
    
    LinkedQueueNode(E paramE)
    {
      spValue(paramE);
    }
    
    public E getAndNullValue()
    {
      return null;
    }
    
    public E lpValue()
    {
      return (E)this.value;
    }
    
    public LinkedQueueNode<E> lvNext()
    {
      return (LinkedQueueNode)get();
    }
    
    public void soNext(LinkedQueueNode<E> paramLinkedQueueNode)
    {
      lazySet(paramLinkedQueueNode);
    }
    
    public void spValue(E paramE)
    {
      this.value = paramE;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\queue\MpscLinkedQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */