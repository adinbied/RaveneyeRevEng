package com.facebook.common.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableList<E>
  extends ArrayList<E>
{
  private ImmutableList(int paramInt)
  {
    super(paramInt);
  }
  
  private ImmutableList(List<E> paramList)
  {
    super(paramList);
  }
  
  public static <E> ImmutableList<E> copyOf(List<E> paramList)
  {
    return new ImmutableList(paramList);
  }
  
  public static <E> ImmutableList<E> of(E... paramVarArgs)
  {
    ImmutableList localImmutableList = new ImmutableList(paramVarArgs.length);
    Collections.addAll(localImmutableList, paramVarArgs);
    return localImmutableList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\internal\ImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */