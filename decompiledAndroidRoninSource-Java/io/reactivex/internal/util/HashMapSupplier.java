package io.reactivex.internal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public enum HashMapSupplier
  implements Callable<Map<Object, Object>>
{
  static
  {
    HashMapSupplier localHashMapSupplier = new HashMapSupplier("INSTANCE", 0);
    INSTANCE = localHashMapSupplier;
    $VALUES = new HashMapSupplier[] { localHashMapSupplier };
  }
  
  private HashMapSupplier() {}
  
  public static <K, V> Callable<Map<K, V>> asCallable()
  {
    return INSTANCE;
  }
  
  public Map<Object, Object> call()
    throws Exception
  {
    return new HashMap();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\HashMapSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */