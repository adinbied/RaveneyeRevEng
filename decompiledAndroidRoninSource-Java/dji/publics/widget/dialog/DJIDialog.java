package dji.publics.widget.dialog;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import dji.publics.DJIUI.DJIImageView;
import dji.publics.DJIUI.DJILinearLayout;
import dji.publics.DJIUI.DJITextView;
import dji.publics.DJIUI.DJIView;
import dji.publics.widget.DJIScrollTextView;

public class DJIDialog
  extends DJINewBaseDialog
{
  public static final int TYPE_BACKHOME = 5;
  public static final int TYPE_ICON_MAX = 10;
  public static final int TYPE_NOFLYZONE = 4;
  public static final int TYPE_NOTIFY = 1;
  public static final int TYPE_OKTIPS = 2;
  public static final int TYPE_WARNING = 3;
  private static boolean sForbidShowDialog;
  protected DJILinearLayout mBottomBtnLy;
  protected DJIView mBtnDivider;
  private DJIImageView mCloseView;
  protected DJIScrollTextView mContent;
  protected DJIView mContentCustomMargin;
  private int mContentCustomMarginHeight;
  protected DJIView mContentDivider;
  private DJIView mContentSpaceBottom;
  private DJIView mContentSpaceTop;
  private boolean mIsAuto = true;
  private boolean mIsShow = false;
  protected DJITextView mLeftBtn;
  protected DialogInterface.OnClickListener mLeftListener;
  private int mMaxMiddleContentHeight;
  private int mMaxTopCustomHeight;
  protected DJILinearLayout mMiddleContentLy;
  protected DJITextView mRightBtn;
  protected DialogInterface.OnClickListener mRightListener;
  private DJITextView mTitle;
  protected DJIView mTitleContentMargin;
  private int mTitleContentMarginHeight;
  private DJIImageView mTitleIcon;
  private DJILinearLayout mTitleLayout;
  private DJILinearLayout mTopCustomContainer;
  protected DJILinearLayout mViewContainer;
  
  public DJIDialog(Context paramContext)
  {
    super(paramContext, R.style.LogDialog);
    init();
  }
  
  public DJIDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialogTheme paramDJIDialogTheme)
  {
    super(paramContext, paramDJIDialogType, paramDJIDialogTheme);
    init();
  }
  
  /* Error */
  private void adjustViewType()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void hideContentView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void hideTitleView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initThemeBackGround()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initTitleColor()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isActivityFinish()
  {
    return false;
  }
  
  public static boolean isForbidShowDialog()
  {
    return sForbidShowDialog;
  }
  
  /* Error */
  private void measureMiddleHeight()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void measureTopHeight()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void onClickEvent(DialogInterface.OnClickListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void requestMeasureHeight()
  {
    measureTopHeight();
    measureMiddleHeight();
  }
  
  public static void setForbidShowDialog(boolean paramBoolean)
  {
    sForbidShowDialog = paramBoolean;
  }
  
  /* Error */
  private void setTheme(DJIDialogTheme arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addTopView(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void addView(View paramView)
  {
    addView(paramView, -1);
  }
  
  /* Error */
  protected void addView(View arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DJIDialog hideBottomBtn()
  {
    return null;
  }
  
  public DJIDialog hideLeftBtn()
  {
    return null;
  }
  
  public DJIDialog hideRightBtn()
  {
    return null;
  }
  
  /* Error */
  protected void initBtnTextColor(DJITextView arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void initContentColor(android.widget.TextView arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.MAIN)
  public void onEvent3MainThread(dji.publics.widget.util.CommonEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DJIDialog setBtnHighlight(boolean paramBoolean1, boolean paramBoolean2)
  {
    DJITextView localDJITextView;
    if (paramBoolean1) {
      localDJITextView = this.mLeftBtn;
    } else {
      localDJITextView = this.mRightBtn;
    }
    initBtnTextColor(localDJITextView, paramBoolean2);
    return this;
  }
  
  /* Error */
  public void setCloseVisibility(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public DJIDialog setContent(int paramInt)
  {
    return null;
  }
  
  public DJIDialog setContent(CharSequence paramCharSequence)
  {
    return null;
  }
  
  /* Error */
  public void setContentMaxHeight(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setContentTextGravity(int paramInt)
  {
    this.mContent.setGravity(paramInt);
  }
  
  protected void setCustomView(View paramView)
  {
    addView(paramView);
  }
  
  public void setDialogAutoDismiss(boolean paramBoolean)
  {
    this.mIsAuto = paramBoolean;
  }
  
  /* Error */
  public void setIconType(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public DJIDialog setLeftBtn(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    return null;
  }
  
  public DJIDialog setLeftBtn(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    return setLeftBtn(paramString, paramOnClickListener, false);
  }
  
  public DJIDialog setLeftBtn(String paramString, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    return null;
  }
  
  public DJIDialog setLeftBtnText(int paramInt, boolean paramBoolean)
  {
    return null;
  }
  
  public DJIDialog setLeftBtnText(CharSequence paramCharSequence)
  {
    this.mLeftBtn.setText(paramCharSequence);
    return this;
  }
  
  /* Error */
  public void setMiddleMaxHeight(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public DJIDialog setRightBtn(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    return null;
  }
  
  public DJIDialog setRightBtn(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    return setRightBtn(paramString, paramOnClickListener, true);
  }
  
  public DJIDialog setRightBtn(String paramString, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    return null;
  }
  
  public DJIDialog setRightBtnText(int paramInt, boolean paramBoolean)
  {
    return null;
  }
  
  /* Error */
  public void setTitle(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setTitle(CharSequence arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setTitleBold(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setTitleIcon(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setTitleSize(float paramFloat)
  {
    this.mTitle.setTextSize(paramFloat);
  }
  
  /* Error */
  public void show()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DJIDialog showLeftBtn()
  {
    return null;
  }
  
  public DJIDialog showRightBtn()
  {
    return null;
  }
  
  /* Error */
  protected void updateDividerHeight(View arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum DJIDialogTheme
  {
    static
    {
      DJIDialogTheme localDJIDialogTheme = new DJIDialogTheme("WHITE", 1);
      WHITE = localDJIDialogTheme;
      $VALUES = new DJIDialogTheme[] { BLACK, localDJIDialogTheme };
    }
    
    private DJIDialogTheme() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widget\dialog\DJIDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */