package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Internal
{
  public static void checkElementsNotNull(List<?> paramList)
  {
    if (paramList != null)
    {
      int i = 0;
      int j = paramList.size();
      while (i < j) {
        if (paramList.get(i) != null)
        {
          i += 1;
        }
        else
        {
          paramList = new StringBuilder();
          paramList.append("Element at index ");
          paramList.append(i);
          paramList.append(" is null");
          throw new NullPointerException(paramList.toString());
        }
      }
      return;
    }
    throw new NullPointerException("list == null");
  }
  
  public static void checkElementsNotNull(Map<?, ?> paramMap)
  {
    if (paramMap != null)
    {
      Object localObject = paramMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramMap = (Map.Entry)((Iterator)localObject).next();
        if (paramMap.getKey() != null)
        {
          if (paramMap.getValue() == null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Value for key ");
            ((StringBuilder)localObject).append(paramMap.getKey());
            ((StringBuilder)localObject).append(" is null");
            throw new NullPointerException(((StringBuilder)localObject).toString());
          }
        }
        else {
          throw new NullPointerException("map.containsKey(null)");
        }
      }
      return;
    }
    throw new NullPointerException("map == null");
  }
  
  public static <T> List<T> copyOf(String paramString, List<T> paramList)
  {
    if (paramList != null)
    {
      if ((paramList != Collections.emptyList()) && (!(paramList instanceof ImmutableList))) {
        return new ArrayList(paramList);
      }
      return new MutableOnWriteList(paramList);
    }
    paramList = new StringBuilder();
    paramList.append(paramString);
    paramList.append(" == null");
    throw new NullPointerException(paramList.toString());
  }
  
  public static <K, V> Map<K, V> copyOf(String paramString, Map<K, V> paramMap)
  {
    if (paramMap != null) {
      return new LinkedHashMap(paramMap);
    }
    paramMap = new StringBuilder();
    paramMap.append(paramString);
    paramMap.append(" == null");
    throw new NullPointerException(paramMap.toString());
  }
  
  public static int countNonNull(Object paramObject1, Object paramObject2)
  {
    int j = 1;
    int i;
    if (paramObject1 != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramObject2 == null) {
      j = 0;
    }
    return i + j;
  }
  
  public static int countNonNull(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    int k = 1;
    int i;
    if (paramObject1 != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramObject2 != null) {
      j = 1;
    } else {
      j = 0;
    }
    if (paramObject3 == null) {
      k = 0;
    }
    return i + j + k;
  }
  
  public static int countNonNull(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object... paramVarArgs)
  {
    int k = 0;
    if (paramObject1 != null) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if (paramObject2 != null) {
      i = j + 1;
    }
    int j = i;
    if (paramObject3 != null) {
      j = i + 1;
    }
    i = j;
    if (paramObject4 != null) {
      i = j + 1;
    }
    int m = paramVarArgs.length;
    j = i;
    i = k;
    while (i < m)
    {
      k = j;
      if (paramVarArgs[i] != null) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static <T> List<T> immutableCopyOf(String paramString, List<T> paramList)
  {
    if (paramList != null)
    {
      Object localObject = paramList;
      if ((paramList instanceof MutableOnWriteList)) {
        localObject = ((MutableOnWriteList)paramList).mutableList;
      }
      if (localObject != Collections.emptyList())
      {
        if ((localObject instanceof ImmutableList)) {
          return (List<T>)localObject;
        }
        paramList = new ImmutableList((List)localObject);
        if (!paramList.contains(null)) {
          return paramList;
        }
        paramList = new StringBuilder();
        paramList.append(paramString);
        paramList.append(".contains(null)");
        throw new IllegalArgumentException(paramList.toString());
      }
      return (List<T>)localObject;
    }
    paramList = new StringBuilder();
    paramList.append(paramString);
    paramList.append(" == null");
    throw new NullPointerException(paramList.toString());
  }
  
  public static <K, V> Map<K, V> immutableCopyOf(String paramString, Map<K, V> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.isEmpty()) {
        return Collections.emptyMap();
      }
      paramMap = new LinkedHashMap(paramMap);
      if (!paramMap.containsKey(null))
      {
        if (!paramMap.containsValue(null)) {
          return Collections.unmodifiableMap(paramMap);
        }
        paramMap = new StringBuilder();
        paramMap.append(paramString);
        paramMap.append(".containsValue(null)");
        throw new IllegalArgumentException(paramMap.toString());
      }
      paramMap = new StringBuilder();
      paramMap.append(paramString);
      paramMap.append(".containsKey(null)");
      throw new IllegalArgumentException(paramMap.toString());
    }
    paramMap = new StringBuilder();
    paramMap.append(paramString);
    paramMap.append(" == null");
    throw new NullPointerException(paramMap.toString());
  }
  
  public static IllegalStateException missingRequiredFields(Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length;
    Object localObject1 = "";
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1;
      if (paramVarArgs[i] == null)
      {
        if (localStringBuilder.length() > 0) {
          localObject1 = "s";
        }
        localStringBuilder.append("\n  ");
        localStringBuilder.append(paramVarArgs[(i + 1)]);
        localObject2 = localObject1;
      }
      i += 2;
      localObject1 = localObject2;
    }
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("Required field");
    paramVarArgs.append((String)localObject1);
    paramVarArgs.append(" not set:");
    paramVarArgs.append(localStringBuilder);
    throw new IllegalStateException(paramVarArgs.toString());
  }
  
  public static <T> List<T> newMutableList()
  {
    return new MutableOnWriteList(Collections.emptyList());
  }
  
  public static <K, V> Map<K, V> newMutableMap()
  {
    return new LinkedHashMap();
  }
  
  public static <T> void redactElements(List<T> paramList, ProtoAdapter<T> paramProtoAdapter)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      paramList.set(i, paramProtoAdapter.redact(paramList.get(i)));
      i += 1;
    }
  }
  
  public static <T> void redactElements(Map<?, T> paramMap, ProtoAdapter<T> paramProtoAdapter)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localEntry.setValue(paramProtoAdapter.redact(localEntry.getValue()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\wire\internal\Internal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */