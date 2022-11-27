package io.flutter.view;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Global;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler;
import io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate;
import io.flutter.util.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccessibilityBridge
  extends AccessibilityNodeProvider
{
  private static final int ACTION_SHOW_ON_SCREEN = 16908342;
  private static int FIRST_RESOURCE_ID = 267386881;
  private static final int MIN_ENGINE_GENERATED_NODE_ID = 65536;
  private static final int ROOT_NODE_ID = 0;
  private static final float SCROLL_EXTENT_FOR_INFINITY = 100000.0F;
  private static final float SCROLL_POSITION_CAP_FOR_INFINITY = 70000.0F;
  private static final String TAG = "AccessibilityBridge";
  private final AccessibilityChannel accessibilityChannel;
  private int accessibilityFeatureFlags = 0;
  private SemanticsNode accessibilityFocusedSemanticsNode;
  private final AccessibilityManager accessibilityManager;
  private final AccessibilityChannel.AccessibilityMessageHandler accessibilityMessageHandler = new AccessibilityChannel.AccessibilityMessageHandler()
  {
    /* Error */
    public void announce(String arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onLongPress(int paramAnonymousInt)
    {
      AccessibilityBridge.this.sendAccessibilityEvent(paramAnonymousInt, 2);
    }
    
    public void onTap(int paramAnonymousInt)
    {
      AccessibilityBridge.this.sendAccessibilityEvent(paramAnonymousInt, 1);
    }
    
    /* Error */
    public void onTooltip(String arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void updateCustomAccessibilityActions(java.nio.ByteBuffer arg1, String[] arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void updateSemantics(java.nio.ByteBuffer arg1, String[] arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private final AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener()
  {
    /* Error */
    public void onAccessibilityStateChanged(boolean arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
  };
  private final AccessibilityViewEmbedder accessibilityViewEmbedder;
  private final ContentObserver animationScaleObserver = new ContentObserver(new Handler())
  {
    public void onChange(boolean paramAnonymousBoolean)
    {
      onChange(paramAnonymousBoolean, null);
    }
    
    /* Error */
    public void onChange(boolean arg1, android.net.Uri arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
  };
  private final ContentResolver contentResolver;
  private final Map<Integer, CustomAccessibilityAction> customAccessibilityActions = new HashMap();
  private Integer embeddedAccessibilityFocusedNodeId;
  private Integer embeddedInputFocusedNodeId;
  private final List<Integer> flutterNavigationStack = new ArrayList();
  private final Map<Integer, SemanticsNode> flutterSemanticsTree = new HashMap();
  private SemanticsNode hoveredObject;
  private SemanticsNode inputFocusedSemanticsNode;
  private SemanticsNode lastInputFocusedSemanticsNode;
  private Integer lastLeftFrameInset = Integer.valueOf(0);
  private OnAccessibilityChangeListener onAccessibilityChangeListener;
  private final PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate;
  private int previousRouteId = 0;
  private final View rootAccessibilityView;
  private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;
  
  public AccessibilityBridge(View paramView, AccessibilityChannel paramAccessibilityChannel, final AccessibilityManager paramAccessibilityManager, ContentResolver paramContentResolver, PlatformViewsAccessibilityDelegate paramPlatformViewsAccessibilityDelegate)
  {
    this.rootAccessibilityView = paramView;
    this.accessibilityChannel = paramAccessibilityChannel;
    this.accessibilityManager = paramAccessibilityManager;
    this.contentResolver = paramContentResolver;
    this.platformViewsAccessibilityDelegate = paramPlatformViewsAccessibilityDelegate;
    this.accessibilityStateChangeListener.onAccessibilityStateChanged(paramAccessibilityManager.isEnabled());
    this.accessibilityManager.addAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramAccessibilityChannel = new AccessibilityManager.TouchExplorationStateChangeListener()
      {
        /* Error */
        public void onTouchExplorationStateChanged(boolean arg1)
        {
          // Byte code:
          //   0: return
          //   1: astore_2
          //   2: goto -2 -> 0
        }
      };
      this.touchExplorationStateChangeListener = paramAccessibilityChannel;
      paramAccessibilityChannel.onTouchExplorationStateChanged(paramAccessibilityManager.isTouchExplorationEnabled());
      this.accessibilityManager.addTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
    }
    else
    {
      this.touchExplorationStateChangeListener = null;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      this.animationScaleObserver.onChange(false);
      paramAccessibilityChannel = Settings.Global.getUriFor("transition_animation_scale");
      this.contentResolver.registerContentObserver(paramAccessibilityChannel, false, this.animationScaleObserver);
    }
    if (paramPlatformViewsAccessibilityDelegate != null) {
      paramPlatformViewsAccessibilityDelegate.attachAccessibilityBridge(this);
    }
    this.accessibilityViewEmbedder = new AccessibilityViewEmbedder(paramView, 65536);
  }
  
  private AccessibilityEvent createTextChangedEvent(int paramInt, String paramString1, String paramString2)
  {
    return null;
  }
  
  private CustomAccessibilityAction getOrCreateAccessibilityAction(int paramInt)
  {
    return null;
  }
  
  private SemanticsNode getOrCreateSemanticsNode(int paramInt)
  {
    return null;
  }
  
  private SemanticsNode getRootSemanticsNode()
  {
    return null;
  }
  
  /* Error */
  private void handleTouchExploration(float arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  private AccessibilityEvent obtainAccessibilityEvent(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  /* Error */
  private void onTouchExplorationExit()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean performCursorMoveAction(SemanticsNode paramSemanticsNode, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    return false;
  }
  
  /* Error */
  private void sendAccessibilityEvent(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void sendAccessibilityEvent(AccessibilityEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void sendLatestAccessibilityFlagsToFlutter()
  {
    this.accessibilityChannel.setAccessibilityFeatures(this.accessibilityFeatureFlags);
  }
  
  /* Error */
  private void sendWindowChangeEvent(SemanticsNode arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void sendWindowContentChangeEvent(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private boolean shouldSetCollectionInfo(SemanticsNode paramSemanticsNode)
  {
    return false;
  }
  
  /* Error */
  private void willRemoveSemanticsNode(SemanticsNode arg1)
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
  
  public boolean externalViewRequestSendAccessibilityEvent(View paramView1, View paramView2, AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public AccessibilityNodeInfo findFocus(int paramInt)
  {
    return null;
  }
  
  public boolean isAccessibilityEnabled()
  {
    return this.accessibilityManager.isEnabled();
  }
  
  public boolean isTouchExplorationEnabled()
  {
    return this.accessibilityManager.isTouchExplorationEnabled();
  }
  
  public boolean onAccessibilityHoverEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setOnAccessibilityChangeListener(OnAccessibilityChangeListener paramOnAccessibilityChangeListener)
  {
    this.onAccessibilityChangeListener = paramOnAccessibilityChangeListener;
  }
  
  /* Error */
  void updateCustomAccessibilityActions(java.nio.ByteBuffer arg1, String[] arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void updateSemantics(java.nio.ByteBuffer arg1, String[] arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static enum AccessibilityFeature
  {
    final int value;
    
    static
    {
      AccessibilityFeature localAccessibilityFeature = new AccessibilityFeature("DISABLE_ANIMATIONS", 2, 4);
      DISABLE_ANIMATIONS = localAccessibilityFeature;
      $VALUES = new AccessibilityFeature[] { ACCESSIBLE_NAVIGATION, INVERT_COLORS, localAccessibilityFeature };
    }
    
    private AccessibilityFeature(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum Action
  {
    public final int value;
    
    static
    {
      LONG_PRESS = new Action("LONG_PRESS", 1, 2);
      SCROLL_LEFT = new Action("SCROLL_LEFT", 2, 4);
      SCROLL_RIGHT = new Action("SCROLL_RIGHT", 3, 8);
      SCROLL_UP = new Action("SCROLL_UP", 4, 16);
      SCROLL_DOWN = new Action("SCROLL_DOWN", 5, 32);
      INCREASE = new Action("INCREASE", 6, 64);
      DECREASE = new Action("DECREASE", 7, 128);
      SHOW_ON_SCREEN = new Action("SHOW_ON_SCREEN", 8, 256);
      MOVE_CURSOR_FORWARD_BY_CHARACTER = new Action("MOVE_CURSOR_FORWARD_BY_CHARACTER", 9, 512);
      MOVE_CURSOR_BACKWARD_BY_CHARACTER = new Action("MOVE_CURSOR_BACKWARD_BY_CHARACTER", 10, 1024);
      SET_SELECTION = new Action("SET_SELECTION", 11, 2048);
      COPY = new Action("COPY", 12, 4096);
      CUT = new Action("CUT", 13, 8192);
      PASTE = new Action("PASTE", 14, 16384);
      DID_GAIN_ACCESSIBILITY_FOCUS = new Action("DID_GAIN_ACCESSIBILITY_FOCUS", 15, 32768);
      DID_LOSE_ACCESSIBILITY_FOCUS = new Action("DID_LOSE_ACCESSIBILITY_FOCUS", 16, 65536);
      CUSTOM_ACTION = new Action("CUSTOM_ACTION", 17, 131072);
      DISMISS = new Action("DISMISS", 18, 262144);
      MOVE_CURSOR_FORWARD_BY_WORD = new Action("MOVE_CURSOR_FORWARD_BY_WORD", 19, 524288);
      Action localAction = new Action("MOVE_CURSOR_BACKWARD_BY_WORD", 20, 1048576);
      MOVE_CURSOR_BACKWARD_BY_WORD = localAction;
      $VALUES = new Action[] { TAP, LONG_PRESS, SCROLL_LEFT, SCROLL_RIGHT, SCROLL_UP, SCROLL_DOWN, INCREASE, DECREASE, SHOW_ON_SCREEN, MOVE_CURSOR_FORWARD_BY_CHARACTER, MOVE_CURSOR_BACKWARD_BY_CHARACTER, SET_SELECTION, COPY, CUT, PASTE, DID_GAIN_ACCESSIBILITY_FOCUS, DID_LOSE_ACCESSIBILITY_FOCUS, CUSTOM_ACTION, DISMISS, MOVE_CURSOR_FORWARD_BY_WORD, localAction };
    }
    
    private Action(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  private static class CustomAccessibilityAction
  {
    private String hint;
    private int id = -1;
    private String label;
    private int overrideId = -1;
    private int resourceId = -1;
  }
  
  private static enum Flag
  {
    final int value;
    
    static
    {
      IS_BUTTON = new Flag("IS_BUTTON", 3, 8);
      IS_TEXT_FIELD = new Flag("IS_TEXT_FIELD", 4, 16);
      IS_FOCUSED = new Flag("IS_FOCUSED", 5, 32);
      HAS_ENABLED_STATE = new Flag("HAS_ENABLED_STATE", 6, 64);
      IS_ENABLED = new Flag("IS_ENABLED", 7, 128);
      IS_IN_MUTUALLY_EXCLUSIVE_GROUP = new Flag("IS_IN_MUTUALLY_EXCLUSIVE_GROUP", 8, 256);
      IS_HEADER = new Flag("IS_HEADER", 9, 512);
      IS_OBSCURED = new Flag("IS_OBSCURED", 10, 1024);
      SCOPES_ROUTE = new Flag("SCOPES_ROUTE", 11, 2048);
      NAMES_ROUTE = new Flag("NAMES_ROUTE", 12, 4096);
      IS_HIDDEN = new Flag("IS_HIDDEN", 13, 8192);
      IS_IMAGE = new Flag("IS_IMAGE", 14, 16384);
      IS_LIVE_REGION = new Flag("IS_LIVE_REGION", 15, 32768);
      HAS_TOGGLED_STATE = new Flag("HAS_TOGGLED_STATE", 16, 65536);
      IS_TOGGLED = new Flag("IS_TOGGLED", 17, 131072);
      HAS_IMPLICIT_SCROLLING = new Flag("HAS_IMPLICIT_SCROLLING", 18, 262144);
      IS_READ_ONLY = new Flag("IS_READ_ONLY", 19, 1048576);
      IS_FOCUSABLE = new Flag("IS_FOCUSABLE", 20, 2097152);
      Flag localFlag = new Flag("IS_LINK", 21, 4194304);
      IS_LINK = localFlag;
      $VALUES = new Flag[] { HAS_CHECKED_STATE, IS_CHECKED, IS_SELECTED, IS_BUTTON, IS_TEXT_FIELD, IS_FOCUSED, HAS_ENABLED_STATE, IS_ENABLED, IS_IN_MUTUALLY_EXCLUSIVE_GROUP, IS_HEADER, IS_OBSCURED, SCOPES_ROUTE, NAMES_ROUTE, IS_HIDDEN, IS_IMAGE, IS_LIVE_REGION, HAS_TOGGLED_STATE, IS_TOGGLED, HAS_IMPLICIT_SCROLLING, IS_READ_ONLY, IS_FOCUSABLE, localFlag };
    }
    
    private Flag(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static abstract interface OnAccessibilityChangeListener
  {
    public abstract void onAccessibilityChanged(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  private static class SemanticsNode
  {
    final AccessibilityBridge accessibilityBridge;
    private int actions;
    private float bottom;
    private List<SemanticsNode> childrenInHitTestOrder = new ArrayList();
    private List<SemanticsNode> childrenInTraversalOrder = new ArrayList();
    private int currentValueLength;
    private List<AccessibilityBridge.CustomAccessibilityAction> customAccessibilityActions;
    private String decreasedValue;
    private int flags;
    private boolean globalGeometryDirty = true;
    private Rect globalRect;
    private float[] globalTransform;
    private boolean hadPreviousConfig = false;
    private String hint;
    private int id = -1;
    private String increasedValue;
    private float[] inverseTransform;
    private boolean inverseTransformDirty = true;
    private String label;
    private float left;
    private int maxValueLength;
    private AccessibilityBridge.CustomAccessibilityAction onLongPressOverride;
    private AccessibilityBridge.CustomAccessibilityAction onTapOverride;
    private SemanticsNode parent;
    private int platformViewId;
    private int previousActions;
    private int previousFlags;
    private String previousLabel;
    private float previousScrollExtentMax;
    private float previousScrollExtentMin;
    private float previousScrollPosition;
    private int previousTextSelectionBase;
    private int previousTextSelectionExtent;
    private String previousValue;
    private float right;
    private int scrollChildren;
    private float scrollExtentMax;
    private float scrollExtentMin;
    private int scrollIndex;
    private float scrollPosition;
    private AccessibilityBridge.TextDirection textDirection;
    private int textSelectionBase;
    private int textSelectionExtent;
    private float top;
    private float[] transform;
    private String value;
    
    SemanticsNode(AccessibilityBridge paramAccessibilityBridge)
    {
      this.accessibilityBridge = paramAccessibilityBridge;
    }
    
    /* Error */
    private void collectRoutes(List<SemanticsNode> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private boolean didChangeLabel()
    {
      return false;
    }
    
    private boolean didScroll()
    {
      return false;
    }
    
    /* Error */
    private void ensureInverseTransform()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private SemanticsNode getAncestor(Predicate<SemanticsNode> paramPredicate)
    {
      return null;
    }
    
    private Rect getGlobalRect()
    {
      return this.globalRect;
    }
    
    private String getRouteName()
    {
      return null;
    }
    
    private String getValueLabelHint()
    {
      return null;
    }
    
    private boolean hadAction(AccessibilityBridge.Action paramAction)
    {
      return false;
    }
    
    private boolean hadFlag(AccessibilityBridge.Flag paramFlag)
    {
      return false;
    }
    
    private boolean hasAction(AccessibilityBridge.Action paramAction)
    {
      return false;
    }
    
    private boolean hasFlag(AccessibilityBridge.Flag paramFlag)
    {
      return false;
    }
    
    private SemanticsNode hitTest(float[] paramArrayOfFloat)
    {
      return null;
    }
    
    private boolean isFocusable()
    {
      return false;
    }
    
    private void log(String paramString, boolean paramBoolean) {}
    
    private float max(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return Math.max(paramFloat1, Math.max(paramFloat2, Math.max(paramFloat3, paramFloat4)));
    }
    
    private float min(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return Math.min(paramFloat1, Math.min(paramFloat2, Math.min(paramFloat3, paramFloat4)));
    }
    
    private static boolean nullableHasAncestor(SemanticsNode paramSemanticsNode, Predicate<SemanticsNode> paramPredicate)
    {
      return (paramSemanticsNode != null) && (paramSemanticsNode.getAncestor(paramPredicate) != null);
    }
    
    /* Error */
    private void transformPoint(float[] arg1, float[] arg2, float[] arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void updateRecursively(float[] arg1, java.util.Set<SemanticsNode> arg2, boolean arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void updateWith(java.nio.ByteBuffer arg1, String[] arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private static enum TextDirection
  {
    static
    {
      LTR = new TextDirection("LTR", 1);
      TextDirection localTextDirection = new TextDirection("RTL", 2);
      RTL = localTextDirection;
      $VALUES = new TextDirection[] { UNKNOWN, LTR, localTextDirection };
    }
    
    private TextDirection() {}
    
    public static TextDirection fromInt(int paramInt)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return UNKNOWN;
        }
        return LTR;
      }
      return RTL;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\view\AccessibilityBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */