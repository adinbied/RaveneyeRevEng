package dji.thirdparty.rx.internal.util.unsafe;

import dji.thirdparty.rx.internal.util.atomic.LinkedQueueNode;

abstract class BaseLinkedQueueConsumerNodeRef<E>
  extends BaseLinkedQueuePad1<E>
{
  protected static final long C_NODE_OFFSET = UnsafeAccess.addressOf(BaseLinkedQueueConsumerNodeRef.class, "consumerNode");
  protected LinkedQueueNode<E> consumerNode;
  
  protected final LinkedQueueNode<E> lpConsumerNode()
  {
    return this.consumerNode;
  }
  
  protected final LinkedQueueNode<E> lvConsumerNode()
  {
    return null;
  }
  
  protected final void spConsumerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    this.consumerNode = paramLinkedQueueNode;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\BaseLinkedQueueConsumerNodeRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */