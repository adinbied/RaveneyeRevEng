package com.google.firebase.encoders;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class FieldDescriptor
{
  private final String name;
  private final Map<Class<?>, Object> properties;
  
  private FieldDescriptor(String paramString, Map<Class<?>, Object> paramMap)
  {
    this.name = paramString;
    this.properties = paramMap;
  }
  
  public static Builder builder(String paramString)
  {
    return new Builder(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof FieldDescriptor)) {
      return false;
    }
    paramObject = (FieldDescriptor)paramObject;
    return (this.name.equals(((FieldDescriptor)paramObject).name)) && (this.properties.equals(((FieldDescriptor)paramObject).properties));
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public <T extends Annotation> T getProperty(Class<T> paramClass)
  {
    return (Annotation)this.properties.get(paramClass);
  }
  
  public int hashCode()
  {
    return this.name.hashCode() * 31 + this.properties.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FieldDescriptor{name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", properties=");
    localStringBuilder.append(this.properties.values());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static final class Builder
  {
    private final String name;
    private Map<Class<?>, Object> properties = null;
    
    Builder(String paramString)
    {
      this.name = paramString;
    }
    
    public FieldDescriptor build()
    {
      String str = this.name;
      Map localMap;
      if (this.properties == null) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(new HashMap(this.properties));
      }
      return new FieldDescriptor(str, localMap, null);
    }
    
    public <T extends Annotation> Builder withProperty(T paramT)
    {
      if (this.properties == null) {
        this.properties = new HashMap();
      }
      this.properties.put(paramT.annotationType(), paramT);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\encoders\FieldDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */