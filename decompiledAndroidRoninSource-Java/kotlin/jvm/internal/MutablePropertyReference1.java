package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty1.Setter;
import kotlin.reflect.KProperty1.Getter;

public abstract class MutablePropertyReference1
  extends MutablePropertyReference
  implements KMutableProperty1
{
  public MutablePropertyReference1() {}
  
  public MutablePropertyReference1(Object paramObject)
  {
    super(paramObject);
  }
  
  protected KCallable computeReflected()
  {
    return Reflection.mutableProperty1(this);
  }
  
  public Object getDelegate(Object paramObject)
  {
    return ((KMutableProperty1)getReflected()).getDelegate(paramObject);
  }
  
  public KProperty1.Getter getGetter()
  {
    return ((KMutableProperty1)getReflected()).getGetter();
  }
  
  public KMutableProperty1.Setter getSetter()
  {
    return ((KMutableProperty1)getReflected()).getSetter();
  }
  
  public Object invoke(Object paramObject)
  {
    return get(paramObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\MutablePropertyReference1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */