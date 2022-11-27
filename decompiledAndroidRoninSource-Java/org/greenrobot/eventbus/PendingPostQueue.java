package org.greenrobot.eventbus;

final class PendingPostQueue
{
  private PendingPost head;
  private PendingPost tail;
  
  void enqueue(PendingPost paramPendingPost)
  {
    if (paramPendingPost != null) {}
    try
    {
      if (this.tail != null)
      {
        this.tail.next = paramPendingPost;
        this.tail = paramPendingPost;
      }
      else
      {
        if (this.head != null) {
          break label53;
        }
        this.tail = paramPendingPost;
        this.head = paramPendingPost;
      }
      notifyAll();
      return;
      label53:
      throw new IllegalStateException("Head present, but no tail");
    }
    finally
    {
      for (;;) {}
    }
    throw new NullPointerException("null cannot be enqueued");
    throw paramPendingPost;
  }
  
  PendingPost poll()
  {
    try
    {
      PendingPost localPendingPost1 = this.head;
      if (this.head != null)
      {
        PendingPost localPendingPost2 = this.head.next;
        this.head = localPendingPost2;
        if (localPendingPost2 == null) {
          this.tail = null;
        }
      }
      return localPendingPost1;
    }
    finally {}
  }
  
  PendingPost poll(int paramInt)
    throws InterruptedException
  {
    try
    {
      if (this.head == null) {
        wait(paramInt);
      }
      PendingPost localPendingPost = poll();
      return localPendingPost;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbus\PendingPostQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */