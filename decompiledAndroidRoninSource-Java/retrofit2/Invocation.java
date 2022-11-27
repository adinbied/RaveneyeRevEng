package retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Invocation
{
  private final List<?> arguments;
  private final Method method;
  
  Invocation(Method paramMethod, List<?> paramList)
  {
    this.method = paramMethod;
    this.arguments = Collections.unmodifiableList(paramList);
  }
  
  public static Invocation of(Method paramMethod, List<?> paramList)
  {
    Objects.requireNonNull(paramMethod, "method == null");
    Objects.requireNonNull(paramList, "arguments == null");
    return new Invocation(paramMethod, new ArrayList(paramList));
  }
  
  public List<?> arguments()
  {
    return this.arguments;
  }
  
  public Method method()
  {
    return this.method;
  }
  
  public String toString()
  {
    return String.format("%s.%s() %s", new Object[] { this.method.getDeclaringClass().getName(), this.method.getName(), this.arguments });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\Invocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */