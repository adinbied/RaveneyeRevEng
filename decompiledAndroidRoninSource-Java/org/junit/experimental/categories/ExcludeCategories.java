package org.junit.experimental.categories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.manipulation.Filter;

public final class ExcludeCategories
  extends CategoryFilterFactory
{
  protected Filter createFilter(List<Class<?>> paramList)
  {
    return new ExcludesAny(paramList);
  }
  
  private static class ExcludesAny
    extends Categories.CategoryFilter
  {
    public ExcludesAny(List<Class<?>> paramList)
    {
      this(new HashSet(paramList));
    }
    
    public ExcludesAny(Set<Class<?>> paramSet)
    {
      super(null, true, paramSet);
    }
    
    public String describe()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("excludes ");
      localStringBuilder.append(super.describe());
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\experimental\categories\ExcludeCategories.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */