package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty2.Setter;
import kotlin.reflect.KProperty2.Getter;

public class MutablePropertyReference2Impl
  extends MutablePropertyReference2
{
  private final String name;
  private final KDeclarationContainer owner;
  private final String signature;
  
  public MutablePropertyReference2Impl(KDeclarationContainer paramKDeclarationContainer, String paramString1, String paramString2)
  {
    this.owner = paramKDeclarationContainer;
    this.name = paramString1;
    this.signature = paramString2;
  }
  
  public Object get(Object paramObject1, Object paramObject2)
  {
    return getGetter().call(new Object[] { paramObject1, paramObject2 });
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public KDeclarationContainer getOwner()
  {
    return this.owner;
  }
  
  public String getSignature()
  {
    return this.signature;
  }
  
  public void set(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    getSetter().call(new Object[] { paramObject1, paramObject2, paramObject3 });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\MutablePropertyReference2Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */