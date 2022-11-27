package com.huawei.appmarket.component.buoycircle.impl.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huawei.appmarket.component.buoycircle.api.AppInfo;
import com.huawei.appmarket.component.buoycircle.impl.cutout.BuoyCutoutHelper;
import com.huawei.appmarket.component.buoycircle.impl.log.BuoyLog;
import com.huawei.appmarket.component.buoycircle.impl.manager.BuoyAutoHideSensorManager.SensorCallback;
import com.huawei.appmarket.component.buoycircle.impl.storage.SharedInfoService;
import com.huawei.appmarket.component.buoycircle.impl.utils.ResourceLoaderUtil;
import com.huawei.appmarket.component.buoycircle.impl.utils.WindowUtil;

public class FloatWindowSmallView
  extends LinearLayout
{
  private static final int AUTO_HIDE_DELAY = 2000;
  private static final int BADGE_MARGIN_DP = 0;
  private static final int BADGE_WIDTH_DP = 6;
  private static final int HIDE_VIEW_WIDTH_DP = 24;
  private static final int SMALL_ALPHA = 153;
  private static final int SMALL_BADGE_MARGIN_X_DP = 30;
  private static final int SMALL_BADGE_MARGIN_Y_DP = 6;
  private static final int SMALL_VIEW_WIDTH_DP = 36;
  private static final String TAG = "FloatWindowSmallView";
  private static final int VIEW_WIDTH_DP = 48;
  private AppInfo appInfo;
  private Runnable autoHideRunnable = null;
  private Handler autoHideTimerHandler = null;
  private int currentPosition;
  private View floatWindow = null;
  private ImageView halfHideView = null;
  private boolean isHalfHide = true;
  private boolean isReadyAutoHide = false;
  private boolean isTouchMove = false;
  private Context mContext = null;
  private WindowManager.LayoutParams mParams;
  private ImageView normalView = null;
  private int orientation;
  private FloatWindowBadge redPointView;
  private int screenH;
  private int screenW;
  BuoyAutoHideSensorManager.SensorCallback sensorCallbacks = new BuoyAutoHideSensorManager.SensorCallback()
  {
    /* Error */
    public void onReverseUp()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private int topBarHeight;
  private WindowManager windowManager;
  private float xDownInScreen;
  private float xInScreen;
  private float xInView;
  private float yDownInScreen;
  private float yInScreen;
  private float yInView;
  
  public FloatWindowSmallView(Context paramContext, AppInfo paramAppInfo)
  {
    super(paramContext);
    BuoyLog.d("FloatWindowSmallView", "start create FloatWindowSmallView");
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    LayoutInflater.from(paramContext).inflate(ResourceLoaderUtil.getLayoutId("c_buoycircle_window_small"), this);
    this.floatWindow = findViewById(ResourceLoaderUtil.getIdId("small_window_layout"));
    setCenterXY(paramContext);
    this.mContext = paramContext;
    this.halfHideView = ((ImageView)findViewById(ResourceLoaderUtil.getIdId("half_hide_small_icon")));
    this.normalView = ((ImageView)findViewById(ResourceLoaderUtil.getIdId("small_icon")));
    this.halfHideView.setImageAlpha(153);
    this.redPointView = new FloatWindowBadge(paramContext);
    FloatWindowBadgeParams localFloatWindowBadgeParams = new FloatWindowBadgeParams();
    localFloatWindowBadgeParams.initParams(6, 6, 0, 0, 0, 0);
    this.redPointView.init(localFloatWindowBadgeParams);
    this.redPointView.setTargetView(this.floatWindow);
    this.orientation = paramContext.getResources().getConfiguration().orientation;
    this.topBarHeight = WindowUtil.getStatusBarHeight(paramContext);
    this.appInfo = paramAppInfo;
    BuoyLog.d("FloatWindowSmallView", "finish create FloatWindowSmallView");
  }
  
  /* Error */
  private void OpenBuoyHideDialog(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addAutoHideListener()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean checkTouchMoved()
  {
    return false;
  }
  
  /* Error */
  private void halfHide()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean hideSmallView(boolean paramBoolean)
  {
    return false;
  }
  
  /* Error */
  private void hideViewByRule()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isNeedReSetPosition()
  {
    return false;
  }
  
  /* Error */
  private void openHideDialog(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void processClickEvent(MotionEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void processUpEvent(MotionEvent arg1, float arg2, float arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void refreshTopBarHeight()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setBadgePosition()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setCenterXY(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void setParams(WindowManager.LayoutParams paramLayoutParams)
  {
    this.mParams = paramLayoutParams;
    refreshTopBarHeight();
  }
  
  /* Error */
  private void setPositionByRule(float arg1, float arg2, float arg3, float arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  /* Error */
  private void startBridgeActivityOpenHideDialog(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void startBridgeActivityUpdateApp(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void startRotateAnimation(View arg1, IAnimation arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateViewLayoutPosition()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void updateViewPosition()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void updateViewPosition(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    setPositionByRule(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    if ((BuoyCutoutHelper.getInstance().hasNotchInScreen(this.mContext)) && (isNeedReSetPosition())) {
      setCutoutLayout();
    }
    SharedInfoService localSharedInfoService = SharedInfoService.getInstance(getContext());
    localSharedInfoService.setPositionYPercent((this.mParams.y + this.topBarHeight) / this.screenH);
    localSharedInfoService.setPositionXPercent(this.mParams.x / this.screenW);
    updateViewLayoutPosition();
  }
  
  /* Error */
  private void updateViewPosition(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public int getTopBarHeight()
  {
    return this.topBarHeight;
  }
  
  /* Error */
  public void init(WindowManager.LayoutParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onConfigurationChanged(Configuration arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  /* Error */
  protected void onWindowVisibilityChanged(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void refreshVisible()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void removeAutoHideListener()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setCutoutLayout()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void showRedPoint(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private static class FWSAnimationListener
    implements Animation.AnimationListener
  {
    public void onAnimationEnd(Animation paramAnimation) {}
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  private static abstract interface IAnimation
  {
    public abstract void onFinish();
  }
  
  private static abstract interface Position
  {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    public static final int TOP = 1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\view\FloatWindowSmallView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */