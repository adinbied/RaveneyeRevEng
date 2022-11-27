package com.idlefish.flutterboost.interfaces;

public abstract interface IContainerRecord
  extends IOperateSyncer
{
  public static final int STATE_APPEAR = 2;
  public static final int STATE_CREATED = 1;
  public static final int STATE_DESTROYED = 4;
  public static final int STATE_DISAPPEAR = 3;
  public static final int STATE_UNKNOW = 0;
  public static final String UNIQ_KEY = "__container_uniqueId_key__";
  
  public abstract IFlutterViewContainer getContainer();
  
  public abstract int getState();
  
  public abstract String uniqueId();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\interfaces\IContainerRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */