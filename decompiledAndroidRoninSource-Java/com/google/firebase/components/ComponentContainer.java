package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

public abstract interface ComponentContainer
{
  public abstract <T> T get(Class<T> paramClass);
  
  public abstract <T> Provider<T> getProvider(Class<T> paramClass);
  
  public abstract <T> Set<T> setOf(Class<T> paramClass);
  
  public abstract <T> Provider<Set<T>> setOfProvider(Class<T> paramClass);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\components\ComponentContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */