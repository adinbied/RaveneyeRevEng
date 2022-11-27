package dji.thirdparty.afinal.core;

import java.util.Collection;

public abstract interface Queue<E>
  extends Collection<E>
{
  public abstract boolean add(E paramE);
  
  public abstract E element();
  
  public abstract boolean offer(E paramE);
  
  public abstract E peek();
  
  public abstract E poll();
  
  public abstract E remove();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\core\Queue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */