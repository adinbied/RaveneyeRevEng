package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.List;

public enum ListAddBiConsumer
  implements BiFunction<List, Object, List>
{
  static
  {
    ListAddBiConsumer localListAddBiConsumer = new ListAddBiConsumer("INSTANCE", 0);
    INSTANCE = localListAddBiConsumer;
    $VALUES = new ListAddBiConsumer[] { localListAddBiConsumer };
  }
  
  private ListAddBiConsumer() {}
  
  public static <T> BiFunction<List<T>, T, List<T>> instance()
  {
    return INSTANCE;
  }
  
  public List apply(List paramList, Object paramObject)
    throws Exception
  {
    paramList.add(paramObject);
    return paramList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\ListAddBiConsumer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */