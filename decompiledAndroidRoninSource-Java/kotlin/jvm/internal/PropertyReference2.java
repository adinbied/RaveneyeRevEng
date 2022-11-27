package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KProperty2.Getter;

public abstract class PropertyReference2
  extends PropertyReference
  implements KProperty2
{
  protected KCallable computeReflected()
  {
    return Reflection.property2(this);
  }
  
  public Object getDelegate(Object paramObject1, Object paramObject2)
  {
    return ((KProperty2)getReflected()).getDelegate(paramObject1, paramObject2);
  }
  
  public KProperty2.Getter getGetter()
  {
    return ((KProperty2)getReflected()).getGetter();
  }
  
  public Object invoke(Object paramObject1, Object paramObject2)
  {
    return get(paramObject1, paramObject2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\PropertyReference2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */