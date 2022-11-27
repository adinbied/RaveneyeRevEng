package dji.thirdparty.rx.internal.util.unsafe;

abstract interface MessagePassingQueue<M>
{
  public abstract boolean isEmpty();
  
  public abstract boolean offer(M paramM);
  
  public abstract M peek();
  
  public abstract M poll();
  
  public abstract int size();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\MessagePassingQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */