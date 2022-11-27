package com.idlefish.flutterboost.interfaces;

public abstract interface IContainerManager
{
  public abstract IFlutterViewContainer findContainerById(String paramString);
  
  public abstract IOperateSyncer generateSyncer(IFlutterViewContainer paramIFlutterViewContainer);
  
  public abstract IContainerRecord getCurrentTopRecord();
  
  public abstract IContainerRecord getLastGenerateRecord();
  
  public abstract boolean hasContainerAppear();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\interfaces\IContainerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */