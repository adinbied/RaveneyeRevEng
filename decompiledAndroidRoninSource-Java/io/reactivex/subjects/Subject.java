package io.reactivex.subjects;

import io.reactivex.Observable;
import io.reactivex.Observer;

public abstract class Subject<T>
  extends Observable<T>
  implements Observer<T>
{
  public abstract Throwable getThrowable();
  
  public abstract boolean hasComplete();
  
  public abstract boolean hasObservers();
  
  public abstract boolean hasThrowable();
  
  public final Subject<T> toSerialized()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\subjects\Subject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */