package com.google.firebase.components;

import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;

public class ComponentRuntime
  extends AbstractComponentContainer
{
  private static final Provider<Set<Object>> EMPTY_PROVIDER = ;
  private final Map<Component<?>, Lazy<?>> components = new HashMap();
  private final EventBus eventBus;
  private final Map<Class<?>, Lazy<?>> lazyInstanceMap = new HashMap();
  private final Map<Class<?>, Lazy<Set<?>>> lazySetMap = new HashMap();
  
  public ComponentRuntime(Executor paramExecutor, Iterable<ComponentRegistrar> paramIterable, Component<?>... paramVarArgs)
  {
    this.eventBus = new EventBus(paramExecutor);
    paramExecutor = new ArrayList();
    EventBus localEventBus = this.eventBus;
    int i = 0;
    paramExecutor.add(Component.of(localEventBus, EventBus.class, new Class[] { Subscriber.class, Publisher.class }));
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramExecutor.addAll(((ComponentRegistrar)paramIterable.next()).getComponents());
    }
    int j = paramVarArgs.length;
    while (i < j)
    {
      paramIterable = paramVarArgs[i];
      if (paramIterable != null) {
        paramExecutor.add(paramIterable);
      }
      i += 1;
    }
    CycleDetector.detect(paramExecutor);
    paramExecutor = paramExecutor.iterator();
    while (paramExecutor.hasNext())
    {
      paramIterable = (Component)paramExecutor.next();
      paramVarArgs = new Lazy(ComponentRuntime..Lambda.1.lambdaFactory$(this, paramIterable));
      this.components.put(paramIterable, paramVarArgs);
    }
    processInstanceComponents();
    processSetComponents();
  }
  
  private void processInstanceComponents()
  {
    Iterator localIterator = this.components.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      Object localObject2 = (Component)((Map.Entry)localObject1).getKey();
      if (((Component)localObject2).isValue())
      {
        localObject1 = (Lazy)((Map.Entry)localObject1).getValue();
        localObject2 = ((Component)localObject2).getProvidedInterfaces().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Class localClass = (Class)((Iterator)localObject2).next();
          this.lazyInstanceMap.put(localClass, localObject1);
        }
      }
    }
    validateDependencies();
  }
  
  private void processSetComponents()
  {
    Object localObject1 = new HashMap();
    Object localObject2 = this.components.entrySet().iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      Object localObject4 = (Component)((Map.Entry)localObject3).getKey();
      if (!((Component)localObject4).isValue())
      {
        localObject3 = (Lazy)((Map.Entry)localObject3).getValue();
        localObject4 = ((Component)localObject4).getProvidedInterfaces().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Class localClass = (Class)((Iterator)localObject4).next();
          if (!((Map)localObject1).containsKey(localClass)) {
            ((Map)localObject1).put(localClass, new HashSet());
          }
          ((Set)((Map)localObject1).get(localClass)).add(localObject3);
        }
      }
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (Set)((Map.Entry)localObject2).getValue();
      this.lazySetMap.put((Class)((Map.Entry)localObject2).getKey(), new Lazy(ComponentRuntime..Lambda.4.lambdaFactory$((Set)localObject3)));
    }
  }
  
  private void validateDependencies()
  {
    Component localComponent;
    Dependency localDependency;
    do
    {
      Iterator localIterator1 = this.components.keySet().iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localComponent = (Component)localIterator1.next();
        localIterator2 = localComponent.getDependencies().iterator();
      }
      localDependency = (Dependency)localIterator2.next();
    } while ((!localDependency.isRequired()) || (this.lazyInstanceMap.containsKey(localDependency.getInterface())));
    throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", new Object[] { localComponent, localDependency.getInterface() }));
  }
  
  public <T> Provider<T> getProvider(Class<T> paramClass)
  {
    Preconditions.checkNotNull(paramClass, "Null interface requested.");
    return (Provider)this.lazyInstanceMap.get(paramClass);
  }
  
  public void initializeEagerComponents(boolean paramBoolean)
  {
    Iterator localIterator = this.components.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      Component localComponent = (Component)((Map.Entry)localObject).getKey();
      localObject = (Lazy)((Map.Entry)localObject).getValue();
      if ((localComponent.isAlwaysEager()) || ((localComponent.isEagerInDefaultApp()) && (paramBoolean))) {
        ((Lazy)localObject).get();
      }
    }
    this.eventBus.enablePublishingAndFlushPending();
  }
  
  public <T> Provider<Set<T>> setOfProvider(Class<T> paramClass)
  {
    paramClass = (Lazy)this.lazySetMap.get(paramClass);
    if (paramClass != null) {
      return paramClass;
    }
    return EMPTY_PROVIDER;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\components\ComponentRuntime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */