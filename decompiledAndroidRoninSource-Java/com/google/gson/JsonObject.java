package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class JsonObject
  extends JsonElement
{
  private final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap();
  
  public void add(String paramString, JsonElement paramJsonElement)
  {
    LinkedTreeMap localLinkedTreeMap = this.members;
    Object localObject = paramJsonElement;
    if (paramJsonElement == null) {
      localObject = JsonNull.INSTANCE;
    }
    localLinkedTreeMap.put(paramString, localObject);
  }
  
  public void addProperty(String paramString, Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      paramBoolean = JsonNull.INSTANCE;
    } else {
      paramBoolean = new JsonPrimitive(paramBoolean);
    }
    add(paramString, paramBoolean);
  }
  
  public void addProperty(String paramString, Character paramCharacter)
  {
    if (paramCharacter == null) {
      paramCharacter = JsonNull.INSTANCE;
    } else {
      paramCharacter = new JsonPrimitive(paramCharacter);
    }
    add(paramString, paramCharacter);
  }
  
  public void addProperty(String paramString, Number paramNumber)
  {
    if (paramNumber == null) {
      paramNumber = JsonNull.INSTANCE;
    } else {
      paramNumber = new JsonPrimitive(paramNumber);
    }
    add(paramString, paramNumber);
  }
  
  public void addProperty(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      paramString2 = JsonNull.INSTANCE;
    } else {
      paramString2 = new JsonPrimitive(paramString2);
    }
    add(paramString1, paramString2);
  }
  
  public JsonObject deepCopy()
  {
    JsonObject localJsonObject = new JsonObject();
    Iterator localIterator = this.members.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localJsonObject.add((String)localEntry.getKey(), ((JsonElement)localEntry.getValue()).deepCopy());
    }
    return localJsonObject;
  }
  
  public Set<Map.Entry<String, JsonElement>> entrySet()
  {
    return this.members.entrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof JsonObject)) && (((JsonObject)paramObject).members.equals(this.members)));
  }
  
  public JsonElement get(String paramString)
  {
    return (JsonElement)this.members.get(paramString);
  }
  
  public JsonArray getAsJsonArray(String paramString)
  {
    return (JsonArray)this.members.get(paramString);
  }
  
  public JsonObject getAsJsonObject(String paramString)
  {
    return (JsonObject)this.members.get(paramString);
  }
  
  public JsonPrimitive getAsJsonPrimitive(String paramString)
  {
    return (JsonPrimitive)this.members.get(paramString);
  }
  
  public boolean has(String paramString)
  {
    return this.members.containsKey(paramString);
  }
  
  public int hashCode()
  {
    return this.members.hashCode();
  }
  
  public Set<String> keySet()
  {
    return this.members.keySet();
  }
  
  public JsonElement remove(String paramString)
  {
    return (JsonElement)this.members.remove(paramString);
  }
  
  public int size()
  {
    return this.members.size();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\gson\JsonObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */