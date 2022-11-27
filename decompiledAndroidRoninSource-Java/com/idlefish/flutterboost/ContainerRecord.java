package com.idlefish.flutterboost;

import android.content.Intent;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import java.util.Map;

public class ContainerRecord
  implements IContainerRecord
{
  private final IFlutterViewContainer mContainer;
  private final FlutterViewContainerManager mManager;
  private MethodChannelProxy mProxy = new MethodChannelProxy(null);
  private int mState = 0;
  private final String mUniqueId;
  
  ContainerRecord(FlutterViewContainerManager paramFlutterViewContainerManager, IFlutterViewContainer paramIFlutterViewContainer)
  {
    Map localMap = paramIFlutterViewContainer.getContainerUrlParams();
    if ((localMap != null) && (localMap.containsKey("__container_uniqueId_key__"))) {
      this.mUniqueId = String.valueOf(localMap.get("__container_uniqueId_key__"));
    } else {
      this.mUniqueId = genUniqueId(this);
    }
    this.mManager = paramFlutterViewContainerManager;
    this.mContainer = paramIFlutterViewContainer;
  }
  
  public static String genUniqueId(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("-");
    localStringBuilder.append(paramObject.hashCode());
    return localStringBuilder.toString();
  }
  
  public IFlutterViewContainer getContainer()
  {
    return this.mContainer;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  /* Error */
  public void onAppear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onBackPressed()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onContainerResult(int paramInt1, int paramInt2, Map<String, Object> paramMap)
  {
    this.mManager.setContainerResult(this, paramInt1, paramInt2, paramMap);
  }
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDisappear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onLowMemory() {}
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void onTrimMemory(int paramInt) {}
  
  public void onUserLeaveHint() {}
  
  public String uniqueId()
  {
    return this.mUniqueId;
  }
  
  private class MethodChannelProxy
  {
    private int mState = 0;
    
    private MethodChannelProxy() {}
    
    /* Error */
    private void appear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void create()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void destroy()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void disappear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void invokeChannel(String arg1, String arg2, Map arg3, String arg4)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void invokeChannelUnsafe(String arg1, String arg2, Map arg3, String arg4)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\ContainerRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */