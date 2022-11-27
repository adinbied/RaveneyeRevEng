package dji.thirdparty.rx.internal.util.unsafe;

import dji.thirdparty.rx.internal.util.atomic.LinkedQueueNode;

public final class SpscLinkedQueue<E>
  extends BaseLinkedQueue<E>
{
  public SpscLinkedQueue()
  {
    spProducerNode(new LinkedQueueNode());
    spConsumerNode(this.producerNode);
    this.consumerNode.soNext(null);
  }
  
  public boolean offer(E paramE)
  {
    return false;
  }
  
  public E peek()
  {
    return null;
  }
  
  public E poll()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\SpscLinkedQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */