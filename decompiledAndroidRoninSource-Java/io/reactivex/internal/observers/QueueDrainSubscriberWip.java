package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;

class QueueDrainSubscriberWip
  extends QueueDrainSubscriberPad0
{
  final AtomicInteger wip = new AtomicInteger();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\QueueDrainSubscriberWip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */