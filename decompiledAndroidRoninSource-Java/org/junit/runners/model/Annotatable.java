package org.junit.runners.model;

import java.lang.annotation.Annotation;

public abstract interface Annotatable
{
  public abstract <T extends Annotation> T getAnnotation(Class<T> paramClass);
  
  public abstract Annotation[] getAnnotations();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runners\model\Annotatable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */