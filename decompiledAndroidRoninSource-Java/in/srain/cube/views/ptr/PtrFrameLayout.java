package in.srain.cube.views.ptr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Scroller;
import dji.frame.widget.R.styleable;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

public class PtrFrameLayout
  extends ViewGroup
{
  private static final boolean DEBUG_LAYOUT = true;
  private static final byte FLAG_AUTO_REFRESH_AT_ONCE = 1;
  private static final byte FLAG_AUTO_REFRESH_BUT_LATER = 2;
  private static final byte FLAG_ENABLE_NEXT_PTR_AT_ONCE = 4;
  private static final byte FLAG_PIN_CONTENT = 8;
  private static final String LOG_TAG = "ptr-frame";
  private static final byte MASK_AUTO_REFRESH = 3;
  public static final byte PTR_STATUS_COMPLETE = 4;
  public static final byte PTR_STATUS_INIT = 1;
  public static final byte PTR_STATUS_LOADING = 3;
  public static final byte PTR_STATUS_PREPARE = 2;
  private int mContainerId = 0;
  protected View mContent;
  private boolean mDisableWhenHorizontalMove = false;
  private int mDurationToClose = 200;
  private int mDurationToCloseHeader = 1000;
  private int mFlag = 0;
  private boolean mHasSendCancelEvent = false;
  private int mHeaderHeight;
  private int mHeaderId = 0;
  private View mHeaderView;
  private boolean mIsDebugEnabled = false;
  private boolean mKeepHeaderWhenRefresh = true;
  private MotionEvent mLastMoveEvent;
  private int mLoadingMinTime = 500;
  private long mLoadingStartTime = 0L;
  private int mPagingTouchSlop;
  private final Runnable mPerformRefreshCompleteDelay = new Runnable()
  {
    public void run()
    {
      PtrFrameLayout.this.performRefreshComplete();
    }
  };
  private boolean mPreventForHorizontal = false;
  private PtrHandler mPtrHandler;
  private PtrIndicator mPtrIndicator = new PtrIndicator();
  private PtrUIHandlerHolder mPtrUIHandlerHolder = PtrUIHandlerHolder.create();
  private boolean mPullToRefresh = false;
  private PtrUIHandlerHook mRefreshCompleteHook;
  private ScrollChecker mScrollChecker;
  private byte mStatus = 1;
  
  public PtrFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PtrFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PtrFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PtrFrameLayout, 0, 0);
    if (paramContext != null)
    {
      this.mHeaderId = paramContext.getResourceId(R.styleable.PtrFrameLayout_ptr_header, this.mHeaderId);
      this.mContainerId = paramContext.getResourceId(R.styleable.PtrFrameLayout_ptr_content, this.mContainerId);
      this.mPtrIndicator.setResistance(paramContext.getFloat(R.styleable.PtrFrameLayout_ptr_resistance, this.mPtrIndicator.getResistance()));
      this.mDurationToClose = paramContext.getInt(R.styleable.PtrFrameLayout_ptr_duration_to_close, this.mDurationToClose);
      this.mDurationToCloseHeader = paramContext.getInt(R.styleable.PtrFrameLayout_ptr_duration_to_close_header, this.mDurationToCloseHeader);
      float f = this.mPtrIndicator.getRatioOfHeaderToHeightRefresh();
      f = paramContext.getFloat(R.styleable.PtrFrameLayout_ptr_ratio_of_header_height_to_refresh, f);
      this.mPtrIndicator.setRatioOfHeaderHeightToRefresh(f);
      this.mKeepHeaderWhenRefresh = paramContext.getBoolean(R.styleable.PtrFrameLayout_ptr_keep_header_when_refresh, this.mKeepHeaderWhenRefresh);
      this.mPullToRefresh = paramContext.getBoolean(R.styleable.PtrFrameLayout_ptr_pull_to_fresh, this.mPullToRefresh);
      paramContext.recycle();
    }
    this.mScrollChecker = new ScrollChecker();
    this.mPagingTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void clearFlag()
  {
    this.mFlag &= 0xFFFFFFFC;
  }
  
  private boolean isDebug()
  {
    return this.mIsDebugEnabled;
  }
  
  /* Error */
  private void layoutChildren()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void measureContentView(View arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void movePos(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void notifyUIRefreshComplete(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void onRelease(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private boolean performAutoRefreshButLater()
  {
    return false;
  }
  
  /* Error */
  private void performRefresh()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void performRefreshComplete()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void sendCancelEvent()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void sendDownEvent()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void tryScrollBackToTop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void tryScrollBackToTopAbortRefresh()
  {
    tryScrollBackToTop();
  }
  
  private void tryScrollBackToTopAfterComplete()
  {
    tryScrollBackToTop();
  }
  
  private void tryScrollBackToTopWhileLoading()
  {
    tryScrollBackToTop();
  }
  
  private boolean tryToNotifyReset()
  {
    return false;
  }
  
  private boolean tryToPerformRefresh()
  {
    return false;
  }
  
  /* Error */
  private void updatePos(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void addPtrUIHandler(PtrUIHandler paramPtrUIHandler)
  {
    PtrUIHandlerHolder.addHandler(this.mPtrUIHandlerHolder, paramPtrUIHandler);
  }
  
  public void autoRefresh()
  {
    autoRefresh(true, this.mDurationToCloseHeader);
  }
  
  public void autoRefresh(boolean paramBoolean)
  {
    autoRefresh(paramBoolean, this.mDurationToCloseHeader);
  }
  
  /* Error */
  public void autoRefresh(boolean arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public void disableWhenHorizontalMove(boolean paramBoolean)
  {
    this.mDisableWhenHorizontalMove = paramBoolean;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean dispatchTouchEventSupper(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return null;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public View getContentView()
  {
    return this.mContent;
  }
  
  public float getDurationToClose()
  {
    return this.mDurationToClose;
  }
  
  public long getDurationToCloseHeader()
  {
    return this.mDurationToCloseHeader;
  }
  
  public int getHeaderHeight()
  {
    return this.mHeaderHeight;
  }
  
  public View getHeaderView()
  {
    return this.mHeaderView;
  }
  
  public int getOffsetToKeepHeaderWhileLoading()
  {
    return this.mPtrIndicator.getOffsetToKeepHeaderWhileLoading();
  }
  
  public int getOffsetToRefresh()
  {
    return this.mPtrIndicator.getOffsetToRefresh();
  }
  
  public float getRatioOfHeaderToHeightRefresh()
  {
    return this.mPtrIndicator.getRatioOfHeaderToHeightRefresh();
  }
  
  public float getResistance()
  {
    return this.mPtrIndicator.getResistance();
  }
  
  public boolean isAutoRefresh()
  {
    return false;
  }
  
  public boolean isEnabledNextPtrAtOnce()
  {
    return false;
  }
  
  public boolean isKeepHeaderWhenRefresh()
  {
    return this.mKeepHeaderWhenRefresh;
  }
  
  public boolean isPinContent()
  {
    return false;
  }
  
  public boolean isPullToRefresh()
  {
    return this.mPullToRefresh;
  }
  
  public boolean isRefreshing()
  {
    return false;
  }
  
  /* Error */
  protected void onDetachedFromWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onFinishInflate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layoutChildren();
  }
  
  /* Error */
  protected void onMeasure(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  protected void onPositionChange(boolean paramBoolean, byte paramByte, PtrIndicator paramPtrIndicator) {}
  
  /* Error */
  protected void onPtrScrollAbort()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onPtrScrollFinish()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void refreshComplete()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void removePtrUIHandler(PtrUIHandler arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setDurationToClose(int paramInt)
  {
    this.mDurationToClose = paramInt;
  }
  
  public void setDurationToCloseHeader(int paramInt)
  {
    this.mDurationToCloseHeader = paramInt;
  }
  
  public void setEnabledNextPtrAtOnce(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFlag |= 0x4;
      return;
    }
    this.mFlag &= 0xFFFFFFFB;
  }
  
  /* Error */
  public void setHeaderView(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Deprecated
  public void setInterceptEventWhileWorking(boolean paramBoolean) {}
  
  public void setKeepHeaderWhenRefresh(boolean paramBoolean)
  {
    this.mKeepHeaderWhenRefresh = paramBoolean;
  }
  
  public void setLoadingMinTime(int paramInt)
  {
    this.mLoadingMinTime = paramInt;
  }
  
  public void setOffsetToKeepHeaderWhileLoading(int paramInt)
  {
    this.mPtrIndicator.setOffsetToKeepHeaderWhileLoading(paramInt);
  }
  
  public void setOffsetToRefresh(int paramInt)
  {
    this.mPtrIndicator.setOffsetToRefresh(paramInt);
  }
  
  public void setPinContent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFlag |= 0x8;
      return;
    }
    this.mFlag &= 0xFFFFFFF7;
  }
  
  public void setPtrHandler(PtrHandler paramPtrHandler)
  {
    this.mPtrHandler = paramPtrHandler;
  }
  
  /* Error */
  public void setPtrIndicator(PtrIndicator arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setPullToRefresh(boolean paramBoolean)
  {
    this.mPullToRefresh = paramBoolean;
  }
  
  public void setRatioOfHeaderHeightToRefresh(float paramFloat)
  {
    this.mPtrIndicator.setRatioOfHeaderHeightToRefresh(paramFloat);
  }
  
  /* Error */
  public void setRefreshCompleteHook(PtrUIHandlerHook arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setResistance(float paramFloat)
  {
    this.mPtrIndicator.setResistance(paramFloat);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  class ScrollChecker
    implements Runnable
  {
    private boolean mIsRunning = false;
    private int mLastFlingY;
    private Scroller mScroller = new Scroller(PtrFrameLayout.this.getContext());
    private int mStart;
    private int mTo;
    
    public ScrollChecker() {}
    
    /* Error */
    private void destroy()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void finish()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void reset()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void abortIfWorking()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void tryToScrollTo(int arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\in\srain\cube\views\ptr\PtrFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */