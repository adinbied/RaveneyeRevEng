package org.junit.experimental.categories;

import java.util.ArrayList;
import java.util.List;
import org.junit.internal.Classes;
import org.junit.runner.FilterFactory;
import org.junit.runner.FilterFactory.FilterNotCreatedException;
import org.junit.runner.FilterFactoryParams;
import org.junit.runner.manipulation.Filter;

abstract class CategoryFilterFactory
  implements FilterFactory
{
  private List<Class<?>> parseCategories(String paramString)
    throws ClassNotFoundException
  {
    ArrayList localArrayList = new ArrayList();
    paramString = paramString.split(",");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Classes.getClass(paramString[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  protected abstract Filter createFilter(List<Class<?>> paramList);
  
  public Filter createFilter(FilterFactoryParams paramFilterFactoryParams)
    throws FilterFactory.FilterNotCreatedException
  {
    try
    {
      paramFilterFactoryParams = createFilter(parseCategories(paramFilterFactoryParams.getArgs()));
      return paramFilterFactoryParams;
    }
    catch (ClassNotFoundException paramFilterFactoryParams)
    {
      throw new FilterFactory.FilterNotCreatedException(paramFilterFactoryParams);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\experimental\categories\CategoryFilterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */