package org.junit.experimental.categories;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runners.model.FrameworkMethod;
import org.junit.validator.AnnotationValidator;

public final class CategoryValidator
  extends AnnotationValidator
{
  private static final Set<Class<? extends Annotation>> INCOMPATIBLE_ANNOTATIONS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Class[] { BeforeClass.class, AfterClass.class, Before.class, After.class })));
  
  private void addErrorMessage(List<Exception> paramList, Class<?> paramClass)
  {
    paramList.add(new Exception(String.format("@%s can not be combined with @Category", new Object[] { paramClass.getSimpleName() })));
  }
  
  public List<Exception> validateAnnotatedMethod(FrameworkMethod paramFrameworkMethod)
  {
    ArrayList localArrayList = new ArrayList();
    paramFrameworkMethod = paramFrameworkMethod.getAnnotations();
    int j = paramFrameworkMethod.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramFrameworkMethod[i];
      Iterator localIterator = INCOMPATIBLE_ANNOTATIONS.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        if (((Annotation)localObject).annotationType().isAssignableFrom(localClass)) {
          addErrorMessage(localArrayList, localClass);
        }
      }
      i += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\experimental\categories\CategoryValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */