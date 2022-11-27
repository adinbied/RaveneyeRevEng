package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Component<T>
{
  private final Set<Dependency> dependencies;
  private final ComponentFactory<T> factory;
  private final int instantiation;
  private final Set<Class<? super T>> providedInterfaces;
  private final Set<Class<?>> publishedEvents;
  private final int type;
  
  private Component(Set<Class<? super T>> paramSet, Set<Dependency> paramSet1, int paramInt1, int paramInt2, ComponentFactory<T> paramComponentFactory, Set<Class<?>> paramSet2)
  {
    this.providedInterfaces = Collections.unmodifiableSet(paramSet);
    this.dependencies = Collections.unmodifiableSet(paramSet1);
    this.instantiation = paramInt1;
    this.type = paramInt2;
    this.factory = paramComponentFactory;
    this.publishedEvents = Collections.unmodifiableSet(paramSet2);
  }
  
  public static <T> Builder<T> builder(Class<T> paramClass)
  {
    return new Builder(paramClass, new Class[0], null);
  }
  
  @SafeVarargs
  public static <T> Builder<T> builder(Class<T> paramClass, Class<? super T>... paramVarArgs)
  {
    return new Builder(paramClass, paramVarArgs, null);
  }
  
  public static <T> Component<T> intoSet(T paramT, Class<T> paramClass)
  {
    return intoSetBuilder(paramClass).factory(Component..Lambda.3.lambdaFactory$(paramT)).build();
  }
  
  public static <T> Builder<T> intoSetBuilder(Class<T> paramClass)
  {
    return builder(paramClass).intoSet();
  }
  
  @Deprecated
  public static <T> Component<T> of(Class<T> paramClass, T paramT)
  {
    return builder(paramClass).factory(Component..Lambda.1.lambdaFactory$(paramT)).build();
  }
  
  @SafeVarargs
  public static <T> Component<T> of(T paramT, Class<T> paramClass, Class<? super T>... paramVarArgs)
  {
    return builder(paramClass, paramVarArgs).factory(Component..Lambda.2.lambdaFactory$(paramT)).build();
  }
  
  public Set<Dependency> getDependencies()
  {
    return this.dependencies;
  }
  
  public ComponentFactory<T> getFactory()
  {
    return this.factory;
  }
  
  public Set<Class<? super T>> getProvidedInterfaces()
  {
    return this.providedInterfaces;
  }
  
  public Set<Class<?>> getPublishedEvents()
  {
    return this.publishedEvents;
  }
  
  public boolean isAlwaysEager()
  {
    return this.instantiation == 1;
  }
  
  public boolean isEagerInDefaultApp()
  {
    return this.instantiation == 2;
  }
  
  public boolean isLazy()
  {
    return this.instantiation == 0;
  }
  
  public boolean isValue()
  {
    return this.type == 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Component<");
    localStringBuilder.append(Arrays.toString(this.providedInterfaces.toArray()));
    localStringBuilder.append(">{");
    localStringBuilder.append(this.instantiation);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", deps=");
    localStringBuilder.append(Arrays.toString(this.dependencies.toArray()));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static class Builder<T>
  {
    private final Set<Dependency> dependencies = new HashSet();
    private ComponentFactory<T> factory;
    private int instantiation;
    private final Set<Class<? super T>> providedInterfaces = new HashSet();
    private Set<Class<?>> publishedEvents;
    private int type;
    
    @SafeVarargs
    private Builder(Class<T> paramClass, Class<? super T>... paramVarArgs)
    {
      int i = 0;
      this.instantiation = 0;
      this.type = 0;
      this.publishedEvents = new HashSet();
      Preconditions.checkNotNull(paramClass, "Null interface");
      this.providedInterfaces.add(paramClass);
      int j = paramVarArgs.length;
      while (i < j)
      {
        Preconditions.checkNotNull(paramVarArgs[i], "Null interface");
        i += 1;
      }
      Collections.addAll(this.providedInterfaces, paramVarArgs);
    }
    
    private Builder<T> intoSet()
    {
      this.type = 1;
      return this;
    }
    
    private Builder<T> setInstantiation(int paramInt)
    {
      boolean bool;
      if (this.instantiation == 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Instantiation type has already been set.");
      this.instantiation = paramInt;
      return this;
    }
    
    private void validateInterface(Class<?> paramClass)
    {
      Preconditions.checkArgument(this.providedInterfaces.contains(paramClass) ^ true, "Components are not allowed to depend on interfaces they themselves provide.");
    }
    
    public Builder<T> add(Dependency paramDependency)
    {
      Preconditions.checkNotNull(paramDependency, "Null dependency");
      validateInterface(paramDependency.getInterface());
      this.dependencies.add(paramDependency);
      return this;
    }
    
    public Builder<T> alwaysEager()
    {
      return setInstantiation(1);
    }
    
    public Component<T> build()
    {
      boolean bool;
      if (this.factory != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Missing required property: factory.");
      return new Component(new HashSet(this.providedInterfaces), new HashSet(this.dependencies), this.instantiation, this.type, this.factory, this.publishedEvents, null);
    }
    
    public Builder<T> eagerInDefaultApp()
    {
      return setInstantiation(2);
    }
    
    public Builder<T> factory(ComponentFactory<T> paramComponentFactory)
    {
      this.factory = ((ComponentFactory)Preconditions.checkNotNull(paramComponentFactory, "Null factory"));
      return this;
    }
    
    public Builder<T> publishes(Class<?> paramClass)
    {
      this.publishedEvents.add(paramClass);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\components\Component.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */