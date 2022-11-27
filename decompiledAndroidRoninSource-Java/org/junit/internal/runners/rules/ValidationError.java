package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import org.junit.runners.model.FrameworkMember;

class ValidationError
  extends Exception
{
  public ValidationError(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, String paramString)
  {
    super(String.format("The @%s '%s' %s", new Object[] { paramClass.getSimpleName(), paramFrameworkMember.getName(), paramString }));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\runners\rules\ValidationError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */