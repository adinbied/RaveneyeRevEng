package retrofit2;

import java.lang.annotation.Annotation;

final class SkipCallbackExecutorImpl
  implements SkipCallbackExecutor
{
  private static final SkipCallbackExecutor INSTANCE = new SkipCallbackExecutorImpl();
  
  static Annotation[] ensurePresent(Annotation[] paramArrayOfAnnotation)
  {
    if (Utils.isAnnotationPresent(paramArrayOfAnnotation, SkipCallbackExecutor.class)) {
      return paramArrayOfAnnotation;
    }
    Annotation[] arrayOfAnnotation = new Annotation[paramArrayOfAnnotation.length + 1];
    arrayOfAnnotation[0] = INSTANCE;
    System.arraycopy(paramArrayOfAnnotation, 0, arrayOfAnnotation, 1, paramArrayOfAnnotation.length);
    return arrayOfAnnotation;
  }
  
  public Class<? extends Annotation> annotationType()
  {
    return SkipCallbackExecutor.class;
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof SkipCallbackExecutor;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@");
    localStringBuilder.append(SkipCallbackExecutor.class.getName());
    localStringBuilder.append("()");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\SkipCallbackExecutorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */