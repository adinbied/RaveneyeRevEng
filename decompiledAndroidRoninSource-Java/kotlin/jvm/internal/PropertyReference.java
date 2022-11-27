package kotlin.jvm.internal;

import kotlin.reflect.KProperty;

public abstract class PropertyReference
  extends CallableReference
  implements KProperty
{
  public PropertyReference() {}
  
  public PropertyReference(Object paramObject)
  {
    super(paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof PropertyReference))
    {
      paramObject = (PropertyReference)paramObject;
      return (getOwner().equals(((PropertyReference)paramObject).getOwner())) && (getName().equals(((PropertyReference)paramObject).getName())) && (getSignature().equals(((PropertyReference)paramObject).getSignature())) && (Intrinsics.areEqual(getBoundReceiver(), ((PropertyReference)paramObject).getBoundReceiver()));
    }
    if ((paramObject instanceof KProperty)) {
      return paramObject.equals(compute());
    }
    return false;
  }
  
  protected KProperty getReflected()
  {
    return (KProperty)super.getReflected();
  }
  
  public int hashCode()
  {
    return (getOwner().hashCode() * 31 + getName().hashCode()) * 31 + getSignature().hashCode();
  }
  
  public boolean isConst()
  {
    return getReflected().isConst();
  }
  
  public boolean isLateinit()
  {
    return getReflected().isLateinit();
  }
  
  public String toString()
  {
    Object localObject = compute();
    if (localObject != this) {
      return localObject.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("property ");
    ((StringBuilder)localObject).append(getName());
    ((StringBuilder)localObject).append(" (Kotlin reflection is not available)");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\PropertyReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */