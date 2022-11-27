package org.junit.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.junit.Assert;

public abstract class ComparisonCriteria
{
  private int assertArraysAreSameLength(Object paramObject1, Object paramObject2, String paramString)
  {
    StringBuilder localStringBuilder;
    if (paramObject1 == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("expected array was null");
      Assert.fail(localStringBuilder.toString());
    }
    if (paramObject2 == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("actual array was null");
      Assert.fail(localStringBuilder.toString());
    }
    int i = Array.getLength(paramObject2);
    int j = Array.getLength(paramObject1);
    if (i != j)
    {
      paramObject1 = new StringBuilder();
      ((StringBuilder)paramObject1).append(paramString);
      ((StringBuilder)paramObject1).append("array lengths differed, expected.length=");
      ((StringBuilder)paramObject1).append(j);
      ((StringBuilder)paramObject1).append(" actual.length=");
      ((StringBuilder)paramObject1).append(i);
      Assert.fail(((StringBuilder)paramObject1).toString());
    }
    return j;
  }
  
  private boolean isArray(Object paramObject)
  {
    return (paramObject != null) && (paramObject.getClass().isArray());
  }
  
  public void arrayEquals(String paramString, Object paramObject1, Object paramObject2)
    throws ArrayComparisonFailure
  {
    if (paramObject1 != paramObject2)
    {
      int i = 0;
      if (Arrays.deepEquals(new Object[] { paramObject1 }, new Object[] { paramObject2 })) {
        return;
      }
      Object localObject1;
      if (paramString == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(": ");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      int j = assertArraysAreSameLength(paramObject1, paramObject2, (String)localObject1);
      while (i < j)
      {
        Object localObject2 = Array.get(paramObject1, i);
        Object localObject3 = Array.get(paramObject2, i);
        if ((isArray(localObject2)) && (isArray(localObject3))) {
          try
          {
            arrayEquals(paramString, localObject2, localObject3);
          }
          catch (ArrayComparisonFailure paramString)
          {
            paramString.addDimension(i);
            throw paramString;
          }
        }
        try
        {
          assertElementsEqual(localObject2, localObject3);
          i += 1;
        }
        catch (AssertionError paramString)
        {
          throw new ArrayComparisonFailure((String)localObject1, paramString, i);
        }
      }
    }
  }
  
  protected abstract void assertElementsEqual(Object paramObject1, Object paramObject2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\ComparisonCriteria.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */