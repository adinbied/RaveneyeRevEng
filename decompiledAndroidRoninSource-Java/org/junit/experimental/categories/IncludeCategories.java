package org.junit.experimental.categories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.manipulation.Filter;

public final class IncludeCategories
  extends CategoryFilterFactory
{
  protected Filter createFilter(List<Class<?>> paramList)
  {
    return new IncludesAny(paramList);
  }
  
  private static class IncludesAny
    extends Categories.CategoryFilter
  {
    public IncludesAny(List<Class<?>> paramList)
    {
      this(new HashSet(paramList));
    }
    
    public IncludesAny(Set<Class<?>> paramSet)
    {
      super(paramSet, true, null);
    }
    
    public String describe()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("includes ");
      localStringBuilder.append(super.describe());
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\experimental\categories\IncludeCategories.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */