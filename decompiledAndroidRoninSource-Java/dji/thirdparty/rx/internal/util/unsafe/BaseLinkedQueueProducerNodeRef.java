package dji.thirdparty.rx.internal.util.unsafe;

import dji.thirdparty.rx.internal.util.atomic.LinkedQueueNode;

abstract class BaseLinkedQueueProducerNodeRef<E>
  extends BaseLinkedQueuePad0<E>
{
  protected static final long P_NODE_OFFSET = UnsafeAccess.addressOf(BaseLinkedQueueProducerNodeRef.class, "producerNode");
  protected LinkedQueueNode<E> producerNode;
  
  protected final LinkedQueueNode<E> lpProducerNode()
  {
    return this.producerNode;
  }
  
  protected final LinkedQueueNode<E> lvProducerNode()
  {
    return null;
  }
  
  protected final void spProducerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    this.producerNode = paramLinkedQueueNode;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\BaseLinkedQueueProducerNodeRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */