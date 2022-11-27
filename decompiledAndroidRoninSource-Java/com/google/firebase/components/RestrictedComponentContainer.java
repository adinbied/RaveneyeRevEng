package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class RestrictedComponentContainer
  extends AbstractComponentContainer
{
  private final Set<Class<?>> allowedDirectInterfaces;
  private final Set<Class<?>> allowedProviderInterfaces;
  private final Set<Class<?>> allowedPublishedEvents;
  private final Set<Class<?>> allowedSetDirectInterfaces;
  private final Set<Class<?>> allowedSetProviderInterfaces;
  private final ComponentContainer delegateContainer;
  
  RestrictedComponentContainer(Component<?> paramComponent, ComponentContainer paramComponentContainer)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    HashSet localHashSet3 = new HashSet();
    HashSet localHashSet4 = new HashSet();
    Iterator localIterator = paramComponent.getDependencies().iterator();
    while (localIterator.hasNext())
    {
      Dependency localDependency = (Dependency)localIterator.next();
      if (localDependency.isDirectInjection())
      {
        if (localDependency.isSet()) {
          localHashSet3.add(localDependency.getInterface());
        } else {
          localHashSet1.add(localDependency.getInterface());
        }
      }
      else if (localDependency.isSet()) {
        localHashSet4.add(localDependency.getInterface());
      } else {
        localHashSet2.add(localDependency.getInterface());
      }
    }
    if (!paramComponent.getPublishedEvents().isEmpty()) {
      localHashSet1.add(Publisher.class);
    }
    this.allowedDirectInterfaces = Collections.unmodifiableSet(localHashSet1);
    this.allowedProviderInterfaces = Collections.unmodifiableSet(localHashSet2);
    this.allowedSetDirectInterfaces = Collections.unmodifiableSet(localHashSet3);
    this.allowedSetProviderInterfaces = Collections.unmodifiableSet(localHashSet4);
    this.allowedPublishedEvents = paramComponent.getPublishedEvents();
    this.delegateContainer = paramComponentContainer;
  }
  
  public <T> T get(Class<T> paramClass)
  {
    if (this.allowedDirectInterfaces.contains(paramClass))
    {
      Object localObject = this.delegateContainer.get(paramClass);
      if (!paramClass.equals(Publisher.class)) {
        return (T)localObject;
      }
      return new RestrictedPublisher(this.allowedPublishedEvents, (Publisher)localObject);
    }
    throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", new Object[] { paramClass }));
  }
  
  public <T> Provider<T> getProvider(Class<T> paramClass)
  {
    if (this.allowedProviderInterfaces.contains(paramClass)) {
      return this.delegateContainer.getProvider(paramClass);
    }
    throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[] { paramClass }));
  }
  
  public <T> Set<T> setOf(Class<T> paramClass)
  {
    if (this.allowedSetDirectInterfaces.contains(paramClass)) {
      return this.delegateContainer.setOf(paramClass);
    }
    throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[] { paramClass }));
  }
  
  public <T> Provider<Set<T>> setOfProvider(Class<T> paramClass)
  {
    if (this.allowedSetProviderInterfaces.contains(paramClass)) {
      return this.delegateContainer.setOfProvider(paramClass);
    }
    throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[] { paramClass }));
  }
  
  private static class RestrictedPublisher
    implements Publisher
  {
    private final Set<Class<?>> allowedPublishedEvents;
    private final Publisher delegate;
    
    public RestrictedPublisher(Set<Class<?>> paramSet, Publisher paramPublisher)
    {
      this.allowedPublishedEvents = paramSet;
      this.delegate = paramPublisher;
    }
    
    public void publish(Event<?> paramEvent)
    {
      if (this.allowedPublishedEvents.contains(paramEvent.getType()))
      {
        this.delegate.publish(paramEvent);
        return;
      }
      throw new IllegalArgumentException(String.format("Attempting to publish an undeclared event %s.", new Object[] { paramEvent }));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\components\RestrictedComponentContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */