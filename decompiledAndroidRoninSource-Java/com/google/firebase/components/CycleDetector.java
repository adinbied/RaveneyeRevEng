package com.google.firebase.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CycleDetector
{
  static void detect(List<Component<?>> paramList)
  {
    Object localObject1 = toGraph(paramList);
    Object localObject2 = getRoots((Set)localObject1);
    int i = 0;
    if (!((Set)localObject2).isEmpty())
    {
      ComponentNode localComponentNode1 = (ComponentNode)((Set)localObject2).iterator().next();
      ((Set)localObject2).remove(localComponentNode1);
      int j = i + 1;
      Iterator localIterator = localComponentNode1.getDependencies().iterator();
      for (;;)
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        ComponentNode localComponentNode2 = (ComponentNode)localIterator.next();
        localComponentNode2.removeDependent(localComponentNode1);
        if (localComponentNode2.isRoot()) {
          ((Set)localObject2).add(localComponentNode2);
        }
      }
    }
    if (i == paramList.size()) {
      return;
    }
    paramList = new ArrayList();
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ComponentNode)((Iterator)localObject1).next();
      if ((!((ComponentNode)localObject2).isRoot()) && (!((ComponentNode)localObject2).isLeaf())) {
        paramList.add(((ComponentNode)localObject2).getComponent());
      }
    }
    throw new DependencyCycleException(paramList);
  }
  
  private static Set<ComponentNode> getRoots(Set<ComponentNode> paramSet)
  {
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ComponentNode localComponentNode = (ComponentNode)paramSet.next();
      if (localComponentNode.isRoot()) {
        localHashSet.add(localComponentNode);
      }
    }
    return localHashSet;
  }
  
  private static Set<ComponentNode> toGraph(List<Component<?>> paramList)
  {
    Object localObject1 = new HashMap(paramList.size());
    paramList = paramList.iterator();
    Object localObject2;
    ComponentNode localComponentNode;
    Iterator localIterator;
    Object localObject3;
    Object localObject4;
    while (paramList.hasNext())
    {
      localObject2 = (Component)paramList.next();
      localComponentNode = new ComponentNode((Component)localObject2);
      localIterator = ((Component)localObject2).getProvidedInterfaces().iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (Class)localIterator.next();
        localObject4 = new Dep((Class)localObject3, ((Component)localObject2).isValue() ^ true, null);
        if (!((Map)localObject1).containsKey(localObject4)) {
          ((Map)localObject1).put(localObject4, new HashSet());
        }
        Set localSet = (Set)((Map)localObject1).get(localObject4);
        if ((!localSet.isEmpty()) && (!((Dep)localObject4).set)) {
          throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[] { localObject3 }));
        }
        localSet.add(localComponentNode);
      }
    }
    paramList = ((Map)localObject1).values().iterator();
    while (paramList.hasNext())
    {
      label230:
      localObject2 = ((Set)paramList.next()).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localComponentNode = (ComponentNode)((Iterator)localObject2).next();
        localIterator = localComponentNode.getComponent().getDependencies().iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (Dependency)localIterator.next();
          if (!((Dependency)localObject3).isDirectInjection()) {
            break label230;
          }
          localObject3 = (Set)((Map)localObject1).get(new Dep(((Dependency)localObject3).getInterface(), ((Dependency)localObject3).isSet(), null));
          if (localObject3 == null) {
            break label230;
          }
          localObject3 = ((Set)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (ComponentNode)((Iterator)localObject3).next();
            localComponentNode.addDependency((ComponentNode)localObject4);
            ((ComponentNode)localObject4).addDependent(localComponentNode);
          }
        }
      }
    }
    paramList = new HashSet();
    localObject1 = ((Map)localObject1).values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.addAll((Set)((Iterator)localObject1).next());
    }
    return paramList;
  }
  
  private static class ComponentNode
  {
    private final Component<?> component;
    private final Set<ComponentNode> dependencies = new HashSet();
    private final Set<ComponentNode> dependents = new HashSet();
    
    ComponentNode(Component<?> paramComponent)
    {
      this.component = paramComponent;
    }
    
    void addDependency(ComponentNode paramComponentNode)
    {
      this.dependencies.add(paramComponentNode);
    }
    
    void addDependent(ComponentNode paramComponentNode)
    {
      this.dependents.add(paramComponentNode);
    }
    
    Component<?> getComponent()
    {
      return this.component;
    }
    
    Set<ComponentNode> getDependencies()
    {
      return this.dependencies;
    }
    
    boolean isLeaf()
    {
      return this.dependencies.isEmpty();
    }
    
    boolean isRoot()
    {
      return this.dependents.isEmpty();
    }
    
    void removeDependent(ComponentNode paramComponentNode)
    {
      this.dependents.remove(paramComponentNode);
    }
  }
  
  private static class Dep
  {
    private final Class<?> anInterface;
    private final boolean set;
    
    private Dep(Class<?> paramClass, boolean paramBoolean)
    {
      this.anInterface = paramClass;
      this.set = paramBoolean;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool3 = paramObject instanceof Dep;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        paramObject = (Dep)paramObject;
        bool1 = bool2;
        if (((Dep)paramObject).anInterface.equals(this.anInterface))
        {
          bool1 = bool2;
          if (((Dep)paramObject).set == this.set) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      return (this.anInterface.hashCode() ^ 0xF4243) * 1000003 ^ Boolean.valueOf(this.set).hashCode();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\components\CycleDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */