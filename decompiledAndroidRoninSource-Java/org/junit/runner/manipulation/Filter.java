package org.junit.runner.manipulation;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.runner.Description;

public abstract class Filter
{
  public static final Filter ALL = new Filter()
  {
    public void apply(Object paramAnonymousObject)
      throws NoTestsRemainException
    {}
    
    public String describe()
    {
      return "all tests";
    }
    
    public Filter intersect(Filter paramAnonymousFilter)
    {
      return paramAnonymousFilter;
    }
    
    public boolean shouldRun(Description paramAnonymousDescription)
    {
      return true;
    }
  };
  
  public static Filter matchMethodDescription(Description paramDescription)
  {
    new Filter()
    {
      public String describe()
      {
        return String.format("Method %s", new Object[] { this.val$desiredDescription.getDisplayName() });
      }
      
      public boolean shouldRun(Description paramAnonymousDescription)
      {
        if (paramAnonymousDescription.isTest()) {
          return this.val$desiredDescription.equals(paramAnonymousDescription);
        }
        paramAnonymousDescription = paramAnonymousDescription.getChildren().iterator();
        while (paramAnonymousDescription.hasNext()) {
          if (shouldRun((Description)paramAnonymousDescription.next())) {
            return true;
          }
        }
        return false;
      }
    };
  }
  
  public void apply(Object paramObject)
    throws NoTestsRemainException
  {
    if (!(paramObject instanceof Filterable)) {
      return;
    }
    ((Filterable)paramObject).filter(this);
  }
  
  public abstract String describe();
  
  public Filter intersect(final Filter paramFilter)
  {
    if (paramFilter != this)
    {
      if (paramFilter == ALL) {
        return this;
      }
      new Filter()
      {
        public String describe()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(jdField_this.describe());
          localStringBuilder.append(" and ");
          localStringBuilder.append(paramFilter.describe());
          return localStringBuilder.toString();
        }
        
        public boolean shouldRun(Description paramAnonymousDescription)
        {
          return (jdField_this.shouldRun(paramAnonymousDescription)) && (paramFilter.shouldRun(paramAnonymousDescription));
        }
      };
    }
    return this;
  }
  
  public abstract boolean shouldRun(Description paramDescription);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runner\manipulation\Filter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */