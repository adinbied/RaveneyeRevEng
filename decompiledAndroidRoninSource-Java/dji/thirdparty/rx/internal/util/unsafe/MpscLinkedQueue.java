package dji.thirdparty.rx.internal.util.unsafe;

import dji.thirdparty.rx.internal.util.atomic.LinkedQueueNode;

public final class MpscLinkedQueue<E>
  extends BaseLinkedQueue<E>
{
  public MpscLinkedQueue()
  {
    this.consumerNode = new LinkedQueueNode();
    xchgProducerNode(this.consumerNode);
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
  
  protected final LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\MpscLinkedQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */