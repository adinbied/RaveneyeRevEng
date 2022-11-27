package dji.thirdparty.rx.subjects;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Observer;

public abstract class Subject<T, R>
  extends Observable<R>
  implements Observer<T>
{
  protected Subject(Observable.OnSubscribe<R> paramOnSubscribe)
  {
    super(paramOnSubscribe);
  }
  
  public abstract boolean hasObservers();
  
  public final SerializedSubject<T, R> toSerialized()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\subjects\Subject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */