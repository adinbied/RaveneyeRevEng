package com.google.firebase.components;

import java.util.List;

public class DependencyCycleException
  extends DependencyException
{
  private final List<Component<?>> componentsInCycle;
  
  public DependencyCycleException(List<Component<?>> paramList)
  {
    super(localStringBuilder.toString());
    this.componentsInCycle = paramList;
  }
  
  public List<Component<?>> getComponentsInCycle()
  {
    return this.componentsInCycle;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\components\DependencyCycleException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */