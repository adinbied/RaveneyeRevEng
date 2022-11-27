package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.http.HttpDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Headers
{
  private final String[] namesAndValues;
  
  private Headers(Builder paramBuilder)
  {
    this.namesAndValues = ((String[])paramBuilder.namesAndValues.toArray(new String[paramBuilder.namesAndValues.size()]));
  }
  
  private Headers(String[] paramArrayOfString)
  {
    this.namesAndValues = paramArrayOfString;
  }
  
  private static String get(String[] paramArrayOfString, String paramString)
  {
    int i = paramArrayOfString.length - 2;
    while (i >= 0)
    {
      if (paramString.equalsIgnoreCase(paramArrayOfString[i])) {
        return paramArrayOfString[(i + 1)];
      }
      i -= 2;
    }
    return null;
  }
  
  public static Headers of(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      Object localObject1 = new String[paramMap.size() * 2];
      Iterator localIterator = paramMap.entrySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        if ((((Map.Entry)localObject2).getKey() != null) && (((Map.Entry)localObject2).getValue() != null))
        {
          paramMap = ((String)((Map.Entry)localObject2).getKey()).trim();
          localObject2 = ((String)((Map.Entry)localObject2).getValue()).trim();
          if ((paramMap.length() != 0) && (paramMap.indexOf(0) == -1) && (((String)localObject2).indexOf(0) == -1))
          {
            localObject1[i] = paramMap;
            localObject1[(i + 1)] = localObject2;
            i += 2;
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Unexpected header: ");
            ((StringBuilder)localObject1).append(paramMap);
            ((StringBuilder)localObject1).append(": ");
            ((StringBuilder)localObject1).append((String)localObject2);
            throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          throw new IllegalArgumentException("Headers cannot be null");
        }
      }
      return new Headers((String[])localObject1);
    }
    throw new IllegalArgumentException("Expected map with header names and values");
  }
  
  public static Headers of(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length % 2 == 0))
    {
      Object localObject = (String[])paramVarArgs.clone();
      int i = 0;
      while (i < localObject.length) {
        if (localObject[i] != null)
        {
          localObject[i] = localObject[i].trim();
          i += 1;
        }
        else
        {
          throw new IllegalArgumentException("Headers cannot be null");
        }
      }
      i = 0;
      while (i < localObject.length)
      {
        paramVarArgs = localObject[i];
        String str = localObject[(i + 1)];
        if ((paramVarArgs.length() != 0) && (paramVarArgs.indexOf(0) == -1) && (str.indexOf(0) == -1))
        {
          i += 2;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unexpected header: ");
          ((StringBuilder)localObject).append(paramVarArgs);
          ((StringBuilder)localObject).append(": ");
          ((StringBuilder)localObject).append(str);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      return new Headers((String[])localObject);
    }
    throw new IllegalArgumentException("Expected alternating header names and values");
  }
  
  public String get(String paramString)
  {
    return get(this.namesAndValues, paramString);
  }
  
  public Date getDate(String paramString)
  {
    paramString = get(paramString);
    if (paramString != null) {
      return HttpDate.parse(paramString);
    }
    return null;
  }
  
  public String name(int paramInt)
  {
    return this.namesAndValues[(paramInt * 2)];
  }
  
  public Set<String> names()
  {
    return null;
  }
  
  public Builder newBuilder()
  {
    return null;
  }
  
  public int size()
  {
    return this.namesAndValues.length / 2;
  }
  
  public Map<String, List<String>> toMultimap()
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
  
  public String value(int paramInt)
  {
    return null;
  }
  
  public List<String> values(String paramString)
  {
    return null;
  }
  
  public static final class Builder
  {
    private final List<String> namesAndValues = new ArrayList(20);
    
    /* Error */
    private void checkNameAndValue(String arg1, String arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public Builder add(String paramString)
    {
      return null;
    }
    
    public Builder add(String paramString1, String paramString2)
    {
      checkNameAndValue(paramString1, paramString2);
      return addLenient(paramString1, paramString2);
    }
    
    Builder addLenient(String paramString)
    {
      return null;
    }
    
    Builder addLenient(String paramString1, String paramString2)
    {
      return null;
    }
    
    public Headers build()
    {
      return new Headers(this, null);
    }
    
    public String get(String paramString)
    {
      return null;
    }
    
    public Builder removeAll(String paramString)
    {
      return null;
    }
    
    public Builder set(String paramString1, String paramString2)
    {
      checkNameAndValue(paramString1, paramString2);
      removeAll(paramString1);
      addLenient(paramString1, paramString2);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Headers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */