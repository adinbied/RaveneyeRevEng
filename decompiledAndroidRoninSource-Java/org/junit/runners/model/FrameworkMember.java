package org.junit.runners.model;

import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;

public abstract class FrameworkMember<T extends FrameworkMember<T>>
  implements Annotatable
{
  public abstract Class<?> getDeclaringClass();
  
  protected abstract int getModifiers();
  
  public abstract String getName();
  
  public abstract Class<?> getType();
  
  public boolean isPublic()
  {
    return Modifier.isPublic(getModifiers());
  }
  
  boolean isShadowedBy(List<T> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (isShadowedBy((FrameworkMember)paramList.next())) {
        return true;
      }
    }
    return false;
  }
  
  abstract boolean isShadowedBy(T paramT);
  
  public boolean isStatic()
  {
    return Modifier.isStatic(getModifiers());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runners\model\FrameworkMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */