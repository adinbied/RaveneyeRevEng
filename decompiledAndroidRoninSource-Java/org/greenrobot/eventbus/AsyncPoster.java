package org.greenrobot.eventbus;

import java.util.concurrent.ExecutorService;

class AsyncPoster
  implements Runnable, Poster
{
  private final EventBus eventBus;
  private final PendingPostQueue queue;
  
  AsyncPoster(EventBus paramEventBus)
  {
    this.eventBus = paramEventBus;
    this.queue = new PendingPostQueue();
  }
  
  public void enqueue(Subscription paramSubscription, Object paramObject)
  {
    paramSubscription = PendingPost.obtainPendingPost(paramSubscription, paramObject);
    this.queue.enqueue(paramSubscription);
    this.eventBus.getExecutorService().execute(this);
  }
  
  public void run()
  {
    PendingPost localPendingPost = this.queue.poll();
    if (localPendingPost != null)
    {
      this.eventBus.invokeSubscriber(localPendingPost);
      return;
    }
    throw new IllegalStateException("No pending post available");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbus\AsyncPoster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */