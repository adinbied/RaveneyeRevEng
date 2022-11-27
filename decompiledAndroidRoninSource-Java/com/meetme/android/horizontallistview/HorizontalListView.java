package com.meetme.android.horizontallistview;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.EdgeEffect;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class HorizontalListView
  extends AdapterView<ListAdapter>
{
  private static final String BUNDLE_ID_CURRENT_X = "BUNDLE_ID_CURRENT_X";
  private static final String BUNDLE_ID_PARENT_STATE = "BUNDLE_ID_PARENT_STATE";
  private static final float FLING_DEFAULT_ABSORB_VELOCITY = 30.0F;
  private static final float FLING_FRICTION = 0.009F;
  private static final int INSERT_AT_END_OF_LIST = -1;
  private static final int INSERT_AT_START_OF_LIST = 0;
  protected ListAdapter mAdapter;
  private DataSetObserver mAdapterDataObserver = new DataSetObserver()
  {
    /* Error */
    public void onChanged()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onInvalidated()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private boolean mBlockTouchAction = false;
  private HorizontalListView.OnScrollStateChangedListener.ScrollState mCurrentScrollState = HorizontalListView.OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE;
  protected int mCurrentX;
  private int mCurrentlySelectedAdapterIndex;
  private boolean mDataChanged = false;
  private Runnable mDelayedLayout = new Runnable()
  {
    public void run()
    {
      HorizontalListView.this.requestLayout();
    }
  };
  private int mDisplayOffset;
  private Drawable mDivider = null;
  private int mDividerWidth = 0;
  private EdgeEffect mEdgeGlowLeft;
  private EdgeEffect mEdgeGlowRight;
  protected Scroller mFlingTracker = new Scroller(getContext());
  private GestureDetector mGestureDetector;
  private final GestureListener mGestureListener = new GestureListener(null);
  private boolean mHasNotifiedRunningLowOnData = false;
  private int mHeightMeasureSpec;
  private boolean mIsParentVerticiallyScrollableViewDisallowingInterceptTouchEvent = false;
  private int mLeftViewAdapterIndex;
  private int mMaxX = Integer.MAX_VALUE;
  protected int mNextX;
  private View.OnClickListener mOnClickListener;
  private OnScrollStateChangedListener mOnScrollStateChangedListener = null;
  private Rect mRect = new Rect();
  private List<Queue<View>> mRemovedViewsCache = new ArrayList();
  private Integer mRestoreX = null;
  private int mRightViewAdapterIndex;
  private RunningOutOfDataListener mRunningOutOfDataListener = null;
  private int mRunningOutOfDataThreshold = 0;
  private View mViewBeingTouched = null;
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mEdgeGlowLeft = new EdgeEffect(paramContext);
    this.mEdgeGlowRight = new EdgeEffect(paramContext);
    this.mGestureDetector = new GestureDetector(paramContext, this.mGestureListener);
    bindGestureDetector();
    initView();
    retrieveXmlConfiguration(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    if (Build.VERSION.SDK_INT >= 11) {
      HoneycombPlus.setFriction(this.mFlingTracker, 0.009F);
    }
  }
  
  /* Error */
  private void addAndMeasureChild(View arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void bindGestureDetector()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private float determineFlingAbsorbVelocity()
  {
    return 0.0F;
  }
  
  /* Error */
  private void determineIfLowOnData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean determineMaxX()
  {
    return false;
  }
  
  /* Error */
  private void drawDivider(Canvas arg1, Rect arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawDividers(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawEdgeGlow(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void fillList(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void fillListLeft(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void fillListRight(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  private View getChild(int paramInt)
  {
    return null;
  }
  
  private int getChildIndex(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  private ViewGroup.LayoutParams getLayoutParams(View paramView)
  {
    return null;
  }
  
  private View getLeftmostChild()
  {
    return getChildAt(0);
  }
  
  private View getRecycledView(int paramInt)
  {
    return null;
  }
  
  private int getRenderHeight()
  {
    return 0;
  }
  
  private int getRenderWidth()
  {
    return 0;
  }
  
  private View getRightmostChild()
  {
    return null;
  }
  
  /* Error */
  private void initView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initializeRecycledViewCache(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private boolean isEdgeGlowEnabled()
  {
    return false;
  }
  
  private boolean isItemViewTypeValid(int paramInt)
  {
    return false;
  }
  
  private boolean isLastItemInAdapter(int paramInt)
  {
    return false;
  }
  
  /* Error */
  private void measureChild(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void positionChildren(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void recycleView(int arg1, View arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void releaseEdgeGlow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void removeNonVisibleChildren(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void requestParentListViewToNotInterceptTouchEvents(Boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void reset()
  {
    initView();
    removeAllViewsInLayout();
    requestLayout();
  }
  
  /* Error */
  private void retrieveXmlConfiguration(Context arg1, AttributeSet arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setCurrentScrollState(HorizontalListView.OnScrollStateChangedListener.ScrollState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void unpressTouchedChild()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateOverscrollAnimation(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void destroy()
  {
    this.mEdgeGlowLeft = null;
    this.mEdgeGlowRight = null;
    this.mGestureDetector = null;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    drawEdgeGlow(paramCanvas);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
  
  public ListAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.mLeftViewAdapterIndex;
  }
  
  public int getLastVisiblePosition()
  {
    return this.mRightViewAdapterIndex;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    return 0.0F;
  }
  
  protected float getRightFadingEdgeStrength()
  {
    return 0.0F;
  }
  
  public View getSelectedView()
  {
    return getChild(this.mCurrentlySelectedAdapterIndex);
  }
  
  protected boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    drawDividers(paramCanvas);
  }
  
  protected boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  /* Error */
  protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore 6
    //   3: goto -3 -> 0
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mHeightMeasureSpec = paramInt2;
  }
  
  /* Error */
  public void onRestoreInstanceState(Parcelable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  /* Error */
  public void scrollTo(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setAdapter(ListAdapter arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    this.mDivider = paramDrawable;
    if (paramDrawable != null)
    {
      setDividerWidth(paramDrawable.getIntrinsicWidth());
      return;
    }
    setDividerWidth(0);
  }
  
  public void setDividerWidth(int paramInt)
  {
    this.mDividerWidth = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setOnScrollStateChangedListener(OnScrollStateChangedListener paramOnScrollStateChangedListener)
  {
    this.mOnScrollStateChangedListener = paramOnScrollStateChangedListener;
  }
  
  public void setRunningOutOfDataListener(RunningOutOfDataListener paramRunningOutOfDataListener, int paramInt)
  {
    this.mRunningOutOfDataListener = paramRunningOutOfDataListener;
    this.mRunningOutOfDataThreshold = paramInt;
  }
  
  public void setSelection(int paramInt)
  {
    this.mCurrentlySelectedAdapterIndex = paramInt;
  }
  
  private class GestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    private GestureListener() {}
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return HorizontalListView.this.onDown(paramMotionEvent);
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return HorizontalListView.this.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    
    /* Error */
    public void onLongPress(MotionEvent arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  private static final class HoneycombPlus
  {
    static
    {
      if (Build.VERSION.SDK_INT >= 11) {
        return;
      }
      throw new RuntimeException("Should not get to HoneycombPlus class unless sdk is >= 11!");
    }
    
    public static void setFriction(Scroller paramScroller, float paramFloat)
    {
      if (paramScroller != null) {
        paramScroller.setFriction(paramFloat);
      }
    }
  }
  
  private static final class IceCreamSandwichPlus
  {
    static
    {
      if (Build.VERSION.SDK_INT >= 14) {
        return;
      }
      throw new RuntimeException("Should not get to IceCreamSandwichPlus class unless sdk is >= 14!");
    }
    
    public static float getCurrVelocity(Scroller paramScroller)
    {
      return paramScroller.getCurrVelocity();
    }
  }
  
  public static abstract interface OnScrollStateChangedListener
  {
    public abstract void onScrollStateChanged(ScrollState paramScrollState);
    
    public static enum ScrollState
    {
      static
      {
        ScrollState localScrollState = new ScrollState("SCROLL_STATE_FLING", 2);
        SCROLL_STATE_FLING = localScrollState;
        $VALUES = new ScrollState[] { SCROLL_STATE_IDLE, SCROLL_STATE_TOUCH_SCROLL, localScrollState };
      }
      
      private ScrollState() {}
    }
  }
  
  public static abstract interface RunningOutOfDataListener
  {
    public abstract void onRunningOutOfData();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\meetme\android\horizontallistview\HorizontalListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */