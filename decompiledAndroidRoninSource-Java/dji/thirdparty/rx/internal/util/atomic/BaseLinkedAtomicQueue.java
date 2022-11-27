package dji.thirdparty.rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

abstract class BaseLinkedAtomicQueue<E>
  extends AbstractQueue<E>
{
  private final AtomicReference<LinkedQueueNode<E>> consumerNode = new AtomicReference();
  private final AtomicReference<LinkedQueueNode<E>> producerNode = new AtomicReference();
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  public final Iterator<E> iterator()
  {
    throw new UnsupportedOperationException();
  }
  
  protected final LinkedQueueNode<E> lpConsumerNode()
  {
    return null;
  }
  
  protected final LinkedQueueNode<E> lpProducerNode()
  {
    return null;
  }
  
  protected final LinkedQueueNode<E> lvConsumerNode()
  {
    return null;
  }
  
  protected final LinkedQueueNode<E> lvProducerNode()
  {
    return null;
  }
  
  public final int size()
  {
    return 0;
  }
  
  protected final void spConsumerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    this.consumerNode.lazySet(paramLinkedQueueNode);
  }
  
  protected final void spProducerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    this.producerNode.lazySet(paramLinkedQueueNode);
  }
  
  protected final LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\atomic\BaseLinkedAtomicQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */