package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

public class HandlerPoster
  extends Handler
  implements Poster
{
  private final EventBus eventBus;
  private boolean handlerActive;
  private final int maxMillisInsideHandleMessage;
  private final PendingPostQueue queue;
  
  protected HandlerPoster(EventBus paramEventBus, Looper paramLooper, int paramInt)
  {
    super(paramLooper);
    this.eventBus = paramEventBus;
    this.maxMillisInsideHandleMessage = paramInt;
    this.queue = new PendingPostQueue();
  }
  
  public void enqueue(Subscription paramSubscription, Object paramObject)
  {
    paramSubscription = PendingPost.obtainPendingPost(paramSubscription, paramObject);
    try
    {
      this.queue.enqueue(paramSubscription);
      if (!this.handlerActive)
      {
        this.handlerActive = true;
        if (!sendMessage(obtainMessage())) {
          throw new EventBusException("Could not send handler message");
        }
      }
      return;
    }
    finally {}
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      long l = SystemClock.uptimeMillis();
      do
      {
        PendingPost localPendingPost = this.queue.poll();
        paramMessage = localPendingPost;
        if (localPendingPost == null) {
          try
          {
            paramMessage = this.queue.poll();
            if (paramMessage == null)
            {
              this.handlerActive = false;
              return;
            }
          }
          finally {}
        }
        this.eventBus.invokeSubscriber(paramMessage);
      } while (SystemClock.uptimeMillis() - l < this.maxMillisInsideHandleMessage);
      boolean bool = sendMessage(obtainMessage());
      if (bool)
      {
        this.handlerActive = true;
        return;
      }
      throw new EventBusException("Could not send handler message");
    }
    finally
    {
      this.handlerActive = false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbus\HandlerPoster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */