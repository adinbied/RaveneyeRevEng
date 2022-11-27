package io.flutter.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

final class AccessibilityViewEmbedder
{
  private static final String TAG = "AccessibilityBridge";
  private final Map<View, Rect> embeddedViewToDisplayBounds;
  private final SparseArray<ViewAndId> flutterIdToOrigin = new SparseArray();
  private int nextFlutterId;
  private final Map<ViewAndId, Integer> originToFlutterId;
  private final ReflectionAccessors reflectionAccessors = new ReflectionAccessors(null);
  private final View rootAccessibilityView;
  
  AccessibilityViewEmbedder(View paramView, int paramInt)
  {
    this.rootAccessibilityView = paramView;
    this.nextFlutterId = paramInt;
    this.originToFlutterId = new HashMap();
    this.embeddedViewToDisplayBounds = new HashMap();
  }
  
  /* Error */
  private void addChildrenToFlutterNode(AccessibilityNodeInfo arg1, View arg2, AccessibilityNodeInfo arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void cacheVirtualIdMappings(View arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private AccessibilityNodeInfo convertToFlutterNode(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt, View paramView)
  {
    return null;
  }
  
  /* Error */
  private void copyAccessibilityFields(AccessibilityNodeInfo arg1, AccessibilityNodeInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setFlutterNodeParent(AccessibilityNodeInfo arg1, View arg2, AccessibilityNodeInfo arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setFlutterNodesTranslateBounds(AccessibilityNodeInfo arg1, Rect arg2, AccessibilityNodeInfo arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    return null;
  }
  
  public Integer getRecordFlutterId(View paramView, AccessibilityRecord paramAccessibilityRecord)
  {
    return null;
  }
  
  public AccessibilityNodeInfo getRootNode(View paramView, int paramInt, Rect paramRect)
  {
    return null;
  }
  
  public boolean onAccessibilityHoverEvent(int paramInt, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
  
  public boolean requestSendAccessibilityEvent(View paramView1, View paramView2, AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  private static class ReflectionAccessors
  {
    private final Field childNodeIdsField;
    private final Method getChildId;
    private final Method getParentNodeId;
    private final Method getRecordSourceNodeId;
    private final Method getSourceNodeId;
    private final Method longArrayGetIndex;
    
    private ReflectionAccessors()
    {
      Object localObject3 = null;
      Object localObject2 = null;
      try
      {
        localMethod1 = AccessibilityNodeInfo.class.getMethod("getSourceNodeId", new Class[0]);
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        Method localMethod1;
        for (;;) {}
      }
      Log.w("AccessibilityBridge", "can't invoke AccessibilityNodeInfo#getSourceNodeId with reflection");
      localMethod1 = null;
      try
      {
        localMethod2 = AccessibilityRecord.class.getMethod("getSourceNodeId", new Class[0]);
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        Method localMethod2;
        for (;;) {}
      }
      Log.w("AccessibilityBridge", "can't invoke AccessibiiltyRecord#getSourceNodeId with reflection");
      localMethod2 = null;
      if (Build.VERSION.SDK_INT <= 26) {}
      try
      {
        localObject1 = AccessibilityNodeInfo.class.getMethod("getParentNodeId", new Class[0]);
      }
      catch (NoSuchMethodException localNoSuchMethodException3)
      {
        Object localObject1;
        for (;;) {}
      }
      Log.w("AccessibilityBridge", "can't invoke getParentNodeId with reflection");
      localObject1 = null;
      try
      {
        localObject2 = AccessibilityNodeInfo.class.getMethod("getChildId", new Class[] { Integer.TYPE });
      }
      catch (NoSuchMethodException localNoSuchMethodException4)
      {
        for (;;) {}
      }
      Log.w("AccessibilityBridge", "can't invoke getChildId with reflection");
      localObject2 = null;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      try
      {
        localField = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
        localField.setAccessible(true);
        localObject1 = Class.forName("android.util.LongArray").getMethod("get", new Class[] { Integer.TYPE });
        localObject2 = localObject1;
        localObject1 = null;
      }
      catch (NoSuchFieldException|ClassNotFoundException|NoSuchMethodException|NullPointerException localNoSuchFieldException)
      {
        Field localField;
        Object localObject4;
        for (;;) {}
      }
      Log.w("AccessibilityBridge", "can't access childNodeIdsField with reflection");
      localObject1 = null;
      localObject4 = null;
      localField = null;
      localObject3 = localObject2;
      localObject2 = localObject4;
      this.getSourceNodeId = localMethod1;
      this.getParentNodeId = ((Method)localObject3);
      this.getRecordSourceNodeId = localMethod2;
      this.getChildId = ((Method)localObject1);
      this.childNodeIdsField = localField;
      this.longArrayGetIndex = ((Method)localObject2);
    }
    
    private Long getChildId(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt)
    {
      return null;
    }
    
    private Long getParentNodeId(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      return null;
    }
    
    private Long getRecordSourceNodeId(AccessibilityRecord paramAccessibilityRecord)
    {
      return null;
    }
    
    private Long getSourceNodeId(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      return null;
    }
    
    private static int getVirtualNodeId(long paramLong)
    {
      return (int)(paramLong >> 32);
    }
    
    private static boolean isBitSet(long paramLong, int paramInt)
    {
      return (paramLong & 1L << paramInt) != 0L;
    }
    
    private static Long yoinkParentIdFromParcel(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      int i = Build.VERSION.SDK_INT;
      Object localObject = null;
      if (i < 26)
      {
        Log.w("AccessibilityBridge", "Unexpected Android version. Unable to find the parent ID.");
        return null;
      }
      paramAccessibilityNodeInfo = AccessibilityNodeInfo.obtain(paramAccessibilityNodeInfo);
      Parcel localParcel = Parcel.obtain();
      localParcel.setDataPosition(0);
      paramAccessibilityNodeInfo.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      long l = localParcel.readLong();
      if (isBitSet(l, 0)) {
        localParcel.readInt();
      }
      if (isBitSet(l, 1)) {
        localParcel.readLong();
      }
      if (isBitSet(l, 2)) {
        localParcel.readInt();
      }
      paramAccessibilityNodeInfo = (AccessibilityNodeInfo)localObject;
      if (isBitSet(l, 3)) {
        paramAccessibilityNodeInfo = Long.valueOf(localParcel.readLong());
      }
      localParcel.recycle();
      return paramAccessibilityNodeInfo;
    }
  }
  
  private static class ViewAndId
  {
    final int id;
    final View view;
    
    private ViewAndId(View paramView, int paramInt)
    {
      this.view = paramView;
      this.id = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      return false;
    }
    
    public int hashCode()
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\view\AccessibilityViewEmbedder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */