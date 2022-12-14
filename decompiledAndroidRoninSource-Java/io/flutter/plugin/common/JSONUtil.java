package io.flutter.plugin.common;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONUtil
{
  public static Object unwrap(Object paramObject)
  {
    if (!JSONObject.NULL.equals(paramObject))
    {
      if (paramObject == null) {
        return null;
      }
      if ((!(paramObject instanceof Boolean)) && (!(paramObject instanceof Byte)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof Double)) && (!(paramObject instanceof Float)) && (!(paramObject instanceof Integer)) && (!(paramObject instanceof Long)) && (!(paramObject instanceof Short))) {
        if ((paramObject instanceof String)) {
          return paramObject;
        }
      }
    }
    Object localObject;
    try
    {
      if ((paramObject instanceof JSONArray))
      {
        localObject = new ArrayList();
        paramObject = (JSONArray)paramObject;
        int i = 0;
        while (i < ((JSONArray)paramObject).length())
        {
          ((List)localObject).add(unwrap(((JSONArray)paramObject).get(i)));
          i += 1;
        }
      }
      if ((paramObject instanceof JSONObject))
      {
        localObject = new HashMap();
        paramObject = (JSONObject)paramObject;
        Iterator localIterator = ((JSONObject)paramObject).keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((Map)localObject).put(str, unwrap(((JSONObject)paramObject).get(str)));
        }
        return localObject;
      }
      return null;
    }
    catch (Exception paramObject)
    {
      return null;
    }
    return paramObject;
    return null;
    return localObject;
  }
  
  public static Object wrap(Object paramObject)
  {
    if (paramObject == null) {
      return JSONObject.NULL;
    }
    Object localObject = paramObject;
    if (!(paramObject instanceof JSONArray))
    {
      if ((paramObject instanceof JSONObject)) {
        return paramObject;
      }
      if (paramObject.equals(JSONObject.NULL)) {
        return paramObject;
      }
    }
    try
    {
      if ((paramObject instanceof Collection))
      {
        localObject = new JSONArray();
        paramObject = ((Collection)paramObject).iterator();
        while (((Iterator)paramObject).hasNext()) {
          ((JSONArray)localObject).put(wrap(((Iterator)paramObject).next()));
        }
      }
      if (paramObject.getClass().isArray())
      {
        localObject = new JSONArray();
        int j = Array.getLength(paramObject);
        int i = 0;
        while (i < j)
        {
          ((JSONArray)localObject).put(wrap(Array.get(paramObject, i)));
          i += 1;
        }
      }
      if ((paramObject instanceof Map))
      {
        localObject = new JSONObject();
        paramObject = ((Map)paramObject).entrySet().iterator();
        while (((Iterator)paramObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)paramObject).next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), wrap(localEntry.getValue()));
        }
      }
      localObject = paramObject;
      if (!(paramObject instanceof Boolean))
      {
        localObject = paramObject;
        if (!(paramObject instanceof Byte))
        {
          localObject = paramObject;
          if (!(paramObject instanceof Character))
          {
            localObject = paramObject;
            if (!(paramObject instanceof Double))
            {
              localObject = paramObject;
              if (!(paramObject instanceof Float))
              {
                localObject = paramObject;
                if (!(paramObject instanceof Integer))
                {
                  localObject = paramObject;
                  if (!(paramObject instanceof Long))
                  {
                    localObject = paramObject;
                    if (!(paramObject instanceof Short))
                    {
                      if ((paramObject instanceof String)) {
                        return paramObject;
                      }
                      if (!paramObject.getClass().getPackage().getName().startsWith("java.")) {
                        break label323;
                      }
                      localObject = paramObject.toString();
                    }
                  }
                }
              }
            }
          }
        }
      }
      return localObject;
    }
    catch (Exception paramObject)
    {
      label323:
      for (;;) {}
    }
    localObject = null;
    return localObject;
    return localObject;
    return localObject;
    return localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\common\JSONUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */