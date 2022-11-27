package org.reactivestreams;

public abstract interface Publisher<T>
{
  public abstract void subscribe(Subscriber<? super T> paramSubscriber);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\reactivestreams\Publisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */