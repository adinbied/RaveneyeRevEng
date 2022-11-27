package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty1.Getter;

public abstract class PropertyReference1
  extends PropertyReference
  implements KProperty1
{
  public PropertyReference1() {}
  
  public PropertyReference1(Object paramObject)
  {
    super(paramObject);
  }
  
  protected KCallable computeReflected()
  {
    return Reflection.property1(this);
  }
  
  public Object getDelegate(Object paramObject)
  {
    return ((KProperty1)getReflected()).getDelegate(paramObject);
  }
  
  public KProperty1.Getter getGetter()
  {
    return ((KProperty1)getReflected()).getGetter();
  }
  
  public Object invoke(Object paramObject)
  {
    return get(paramObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\PropertyReference1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */