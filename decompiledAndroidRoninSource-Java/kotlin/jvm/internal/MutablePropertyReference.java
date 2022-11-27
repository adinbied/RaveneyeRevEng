package kotlin.jvm.internal;

import kotlin.reflect.KMutableProperty;

public abstract class MutablePropertyReference
  extends PropertyReference
  implements KMutableProperty
{
  public MutablePropertyReference() {}
  
  public MutablePropertyReference(Object paramObject)
  {
    super(paramObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\MutablePropertyReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */