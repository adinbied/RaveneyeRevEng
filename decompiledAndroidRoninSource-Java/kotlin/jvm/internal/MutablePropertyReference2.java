package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KMutableProperty2.Setter;
import kotlin.reflect.KProperty2.Getter;

public abstract class MutablePropertyReference2
  extends MutablePropertyReference
  implements KMutableProperty2
{
  protected KCallable computeReflected()
  {
    return Reflection.mutableProperty2(this);
  }
  
  public Object getDelegate(Object paramObject1, Object paramObject2)
  {
    return ((KMutableProperty2)getReflected()).getDelegate(paramObject1, paramObject2);
  }
  
  public KProperty2.Getter getGetter()
  {
    return ((KMutableProperty2)getReflected()).getGetter();
  }
  
  public KMutableProperty2.Setter getSetter()
  {
    return ((KMutableProperty2)getReflected()).getSetter();
  }
  
  public Object invoke(Object paramObject1, Object paramObject2)
  {
    return get(paramObject1, paramObject2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\MutablePropertyReference2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */