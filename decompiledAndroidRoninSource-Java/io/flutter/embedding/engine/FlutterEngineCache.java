package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;

public class FlutterEngineCache
{
  private static FlutterEngineCache instance;
  private final Map<String, FlutterEngine> cachedEngines = new HashMap();
  
  public static FlutterEngineCache getInstance()
  {
    if (instance == null) {
      instance = new FlutterEngineCache();
    }
    return instance;
  }
  
  public boolean contains(String paramString)
  {
    return this.cachedEngines.containsKey(paramString);
  }
  
  public FlutterEngine get(String paramString)
  {
    return null;
  }
  
  /* Error */
  public void put(String arg1, FlutterEngine arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void remove(String paramString)
  {
    put(paramString, null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\FlutterEngineCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */