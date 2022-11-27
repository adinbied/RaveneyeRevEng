package org.junit.runner;

import org.junit.runner.manipulation.Filter;

public abstract interface FilterFactory
{
  public abstract Filter createFilter(FilterFactoryParams paramFilterFactoryParams)
    throws FilterFactory.FilterNotCreatedException;
  
  public static class FilterNotCreatedException
    extends Exception
  {
    public FilterNotCreatedException(Exception paramException)
    {
      super(paramException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runner\FilterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */