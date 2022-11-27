package io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicLong;

class QueueDrainSubscriberPad3
  extends QueueDrainSubscriberPad2
{
  final AtomicLong requested = new AtomicLong();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscribers\QueueDrainSubscriberPad3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */