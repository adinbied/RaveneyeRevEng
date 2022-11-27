package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Objects
{
  private Objects()
  {
    throw new AssertionError("Uninstantiable");
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static int hashCode(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static ToStringHelper toStringHelper(Object paramObject)
  {
    return new ToStringHelper(paramObject, null);
  }
  
  public static final class ToStringHelper
  {
    private final List<String> zzer;
    private final Object zzes;
    
    private ToStringHelper(Object paramObject)
    {
      this.zzes = Preconditions.checkNotNull(paramObject);
      this.zzer = new ArrayList();
    }
    
    public final ToStringHelper add(String paramString, Object paramObject)
    {
      List localList = this.zzer;
      paramString = (String)Preconditions.checkNotNull(paramString);
      paramObject = String.valueOf(paramObject);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 1 + String.valueOf(paramObject).length());
      localStringBuilder.append(paramString);
      localStringBuilder.append("=");
      localStringBuilder.append((String)paramObject);
      localList.add(localStringBuilder.toString());
      return this;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(this.zzes.getClass().getSimpleName());
      localStringBuilder.append('{');
      int j = this.zzer.size();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)this.zzer.get(i));
        if (i < j - 1) {
          localStringBuilder.append(", ");
        }
        i += 1;
      }
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\Objects.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */