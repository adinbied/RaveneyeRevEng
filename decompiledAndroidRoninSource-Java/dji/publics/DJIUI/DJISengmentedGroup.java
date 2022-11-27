package dji.publics.DJIUI;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import dji.frame.widget.R.color;
import dji.frame.widget.R.dimen;
import dji.frame.widget.R.drawable;
import java.util.HashMap;

public class DJISengmentedGroup
  extends RadioGroup
{
  private RadioGroup.OnCheckedChangeListener mCheckedChangeListener;
  private int mCheckedTextColor = -1;
  private String[] mChildAr;
  private RadioButton[] mChilds;
  private float mChileTextSize;
  private Float mCornerRadius;
  private int mDisableColor;
  private HashMap<Integer, TransitionDrawable> mDrawableMap;
  private int mLastCheckId = -1;
  private LayoutSelector mLayoutSelector;
  private int mMarginDp;
  private OnSgCheckedChangeListener mSgCheckedChangeListener;
  private int mTintColor;
  private int mUnCheckedTintColor;
  private Resources resources;
  
  public DJISengmentedGroup(Context paramContext)
  {
    super(paramContext);
    paramContext = getResources();
    this.resources = paramContext;
    this.mTintColor = paramContext.getColor(17170443);
    this.mUnCheckedTintColor = this.resources.getColor(17170444);
    this.mDisableColor = this.resources.getColor(R.color.radio_text_disable_color);
    this.mMarginDp = ((int)getResources().getDimension(R.dimen.dp_1_in_sw320dp));
    paramContext = Float.valueOf(getResources().getDimension(R.dimen.dp_5_in_sw320dp));
    this.mCornerRadius = paramContext;
    this.mLayoutSelector = new LayoutSelector(paramContext.floatValue());
  }
  
  public DJISengmentedGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    this.resources = paramContext;
    this.mTintColor = paramContext.getColor(17170443);
    this.mUnCheckedTintColor = this.resources.getColor(17170444);
    this.mMarginDp = ((int)getResources().getDimension(R.dimen.dp_1_in_sw320dp));
    this.mCornerRadius = Float.valueOf(getResources().getDimension(R.dimen.dp_5_in_sw320dp));
    initAttrs(paramAttributeSet);
    this.mLayoutSelector = new LayoutSelector(this.mCornerRadius.floatValue());
  }
  
  /* Error */
  private void addButton(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initAttrs(AttributeSet arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void updateBackground(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void checkButton(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
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
  
  /* Error */
  public void onViewRemoved(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setChecked(int arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setDatas(String[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setEnabled(int arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setEnabled(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.mCheckedChangeListener = paramOnCheckedChangeListener;
  }
  
  public void setOnSgCheckedChangeListener(OnSgCheckedChangeListener paramOnSgCheckedChangeListener)
  {
    this.mSgCheckedChangeListener = paramOnSgCheckedChangeListener;
  }
  
  public void setTintColor(int paramInt)
  {
    this.mTintColor = paramInt;
    updateBackground();
  }
  
  public void setTintColor(int paramInt1, int paramInt2)
  {
    this.mTintColor = paramInt1;
    this.mCheckedTextColor = paramInt2;
    updateBackground();
  }
  
  public void setUnCheckedTintColor(int paramInt1, int paramInt2)
  {
    this.mUnCheckedTintColor = paramInt1;
    updateBackground();
  }
  
  /* Error */
  public void updateBackground()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class LayoutSelector
  {
    private final int DISABLE_LAYOUT = R.drawable.widget_radio_disable;
    private final int SELECTED_LAYOUT = R.drawable.widget_radio_checked;
    private final int UNSELECTED_LAYOUT = R.drawable.widget_radio_unchecked;
    private int child;
    private int children;
    private float r;
    private final float r1;
    private final float[] rBot;
    private final float[] rDefault;
    private final float[] rLeft;
    private final float[] rMiddle;
    private final float[] rRight;
    private final float[] rTop;
    private float[] radii;
    
    public LayoutSelector(float paramFloat)
    {
      float f = TypedValue.applyDimension(1, 0.1F, DJISengmentedGroup.this.getResources().getDisplayMetrics());
      this.r1 = f;
      this.children = -1;
      this.child = -1;
      this.r = paramFloat;
      this.rLeft = new float[] { paramFloat, paramFloat, f, f, f, f, paramFloat, paramFloat };
      this.rRight = new float[] { f, f, paramFloat, paramFloat, paramFloat, paramFloat, f, f };
      this.rMiddle = new float[] { f, f, f, f, f, f, f, f };
      this.rDefault = new float[] { paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat };
      this.rTop = new float[] { paramFloat, paramFloat, paramFloat, paramFloat, f, f, f, f };
      this.rBot = new float[] { f, f, f, f, paramFloat, paramFloat, paramFloat, paramFloat };
    }
    
    private int getChildIndex(View paramView)
    {
      return DJISengmentedGroup.this.indexOfChild(paramView);
    }
    
    private int getChildren()
    {
      return DJISengmentedGroup.this.getChildCount();
    }
    
    /* Error */
    private void setChildRadii(int arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    public float[] getChildRadii(View paramView)
    {
      return null;
    }
    
    public int getDisable()
    {
      return this.DISABLE_LAYOUT;
    }
    
    public int getSelected()
    {
      return this.SELECTED_LAYOUT;
    }
    
    public int getUnselected()
    {
      return this.UNSELECTED_LAYOUT;
    }
  }
  
  public static abstract interface OnSgCheckedChangeListener
  {
    public abstract void onCheckedChanged(DJISengmentedGroup paramDJISengmentedGroup, int paramInt1, int paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\DJIUI\DJISengmentedGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */