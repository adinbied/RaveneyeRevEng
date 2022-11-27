package com.google.gson;

import com.google.gson.internal..Gson.Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

public final class FieldAttributes
{
  private final Field field;
  
  public FieldAttributes(Field paramField)
  {
    .Gson.Preconditions.checkNotNull(paramField);
    this.field = paramField;
  }
  
  Object get(Object paramObject)
    throws IllegalAccessException
  {
    return this.field.get(paramObject);
  }
  
  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    return this.field.getAnnotation(paramClass);
  }
  
  public Collection<Annotation> getAnnotations()
  {
    return Arrays.asList(this.field.getAnnotations());
  }
  
  public Class<?> getDeclaredClass()
  {
    return this.field.getType();
  }
  
  public Type getDeclaredType()
  {
    return this.field.getGenericType();
  }
  
  public Class<?> getDeclaringClass()
  {
    return this.field.getDeclaringClass();
  }
  
  public String getName()
  {
    return this.field.getName();
  }
  
  public boolean hasModifier(int paramInt)
  {
    return (paramInt & this.field.getModifiers()) != 0;
  }
  
  boolean isSynthetic()
  {
    return this.field.isSynthetic();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\gson\FieldAttributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */