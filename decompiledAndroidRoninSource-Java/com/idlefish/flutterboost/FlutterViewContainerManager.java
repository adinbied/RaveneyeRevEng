package com.idlefish.flutterboost;

import com.idlefish.flutterboost.interfaces.IContainerManager;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import com.idlefish.flutterboost.interfaces.IOperateSyncer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class FlutterViewContainerManager
  implements IContainerManager
{
  private final Map<String, OnResult> mOnResults = new HashMap();
  private final Map<IFlutterViewContainer, IContainerRecord> mRecordMap = new LinkedHashMap();
  private final Stack<IContainerRecord> mRecordStack = new Stack();
  private final Set<ContainerRef> mRefs = new HashSet();
  
  IContainerRecord closeContainer(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    return null;
  }
  
  public IFlutterViewContainer findContainerById(String paramString)
  {
    return null;
  }
  
  public IOperateSyncer generateSyncer(IFlutterViewContainer paramIFlutterViewContainer)
  {
    return null;
  }
  
  public IContainerRecord getCurrentTopRecord()
  {
    return null;
  }
  
  public IContainerRecord getLastGenerateRecord()
  {
    return null;
  }
  
  public boolean hasContainerAppear()
  {
    return false;
  }
  
  /* Error */
  void onShownContainerChanged(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void openContainer(String arg1, Map<String, Object> arg2, Map<String, Object> arg3, OnResult arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void popRecord(IContainerRecord arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void pushRecord(IContainerRecord arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public IContainerRecord recordOf(IFlutterViewContainer paramIFlutterViewContainer)
  {
    return null;
  }
  
  /* Error */
  void removeRecord(IContainerRecord arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void setContainerResult(IContainerRecord arg1, int arg2, int arg3, Map<String, Object> arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class ContainerRef
  {
    public final WeakReference<IFlutterViewContainer> container;
    public final String uniqueId;
    
    ContainerRef(String paramString, IFlutterViewContainer paramIFlutterViewContainer)
    {
      this.uniqueId = paramString;
      this.container = new WeakReference(paramIFlutterViewContainer);
    }
  }
  
  static abstract interface OnResult
  {
    public abstract void onResult(Map<String, Object> paramMap);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\FlutterViewContainerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */