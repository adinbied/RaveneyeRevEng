package dji.common.bus;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.subjects.Subject;

public class EventBus<T>
{
  private final Subject<T, T> subject;
  
  EventBus(Subject<T, T> paramSubject)
  {
    this.subject = paramSubject;
  }
  
  public <E extends T> void post(E paramE)
  {
    this.subject.onNext(paramE);
  }
  
  public Observable<T> register()
  {
    return this.subject;
  }
  
  public <E> Observable<E> register(Class<E> paramClass)
  {
    return this.subject.ofType(paramClass);
  }
  
  public <E1, E2> Observable<Object> register(Class<E1> paramClass, Class<E2> paramClass1)
  {
    return Observable.merge(register(paramClass), register(paramClass1));
  }
  
  public <E1, E2, E3> Observable<Object> register(Class<E1> paramClass, Class<E2> paramClass1, Class<E3> paramClass2)
  {
    return Observable.merge(register(paramClass), register(paramClass1), register(paramClass2));
  }
  
  public <E1, E2, E3, E4> Observable<Object> register(Class<E1> paramClass, Class<E2> paramClass1, Class<E3> paramClass2, Class<E4> paramClass3)
  {
    return Observable.merge(register(paramClass), register(paramClass1), register(paramClass2), register(paramClass3));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\bus\EventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */