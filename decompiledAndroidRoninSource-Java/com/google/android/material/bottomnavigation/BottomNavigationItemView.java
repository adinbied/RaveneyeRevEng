package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView.ItemView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R.dimen;
import com.google.android.material.R.drawable;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;

public class BottomNavigationItemView
  extends FrameLayout
  implements MenuView.ItemView
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  public static final int INVALID_ITEM_POSITION = -1;
  private final int defaultMargin;
  private ImageView icon;
  private ColorStateList iconTint;
  private boolean isShifting;
  private MenuItemImpl itemData;
  private int itemPosition = -1;
  private int labelVisibilityMode;
  private final TextView largeLabel;
  private float scaleDownFactor;
  private float scaleUpFactor;
  private float shiftAmount;
  private final TextView smallLabel;
  
  public BottomNavigationItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BottomNavigationItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = getResources();
    LayoutInflater.from(paramContext).inflate(R.layout.design_bottom_navigation_item, this, true);
    setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
    this.defaultMargin = paramAttributeSet.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
    this.icon = ((ImageView)findViewById(R.id.icon));
    this.smallLabel = ((TextView)findViewById(R.id.smallLabel));
    this.largeLabel = ((TextView)findViewById(R.id.largeLabel));
    ViewCompat.setImportantForAccessibility(this.smallLabel, 2);
    ViewCompat.setImportantForAccessibility(this.largeLabel, 2);
    setFocusable(true);
    calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
  }
  
  private void calculateTextScaleFactors(float paramFloat1, float paramFloat2)
  {
    this.shiftAmount = (paramFloat1 - paramFloat2);
    this.scaleUpFactor = (paramFloat2 * 1.0F / paramFloat1);
    this.scaleDownFactor = (paramFloat1 * 1.0F / paramFloat2);
  }
  
  private void setViewLayoutParams(View paramView, int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin = paramInt1;
    localLayoutParams.gravity = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void setViewValues(View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    paramView.setScaleX(paramFloat1);
    paramView.setScaleY(paramFloat2);
    paramView.setVisibility(paramInt);
  }
  
  public MenuItemImpl getItemData()
  {
    return this.itemData;
  }
  
  public int getItemPosition()
  {
    return this.itemPosition;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.itemData = paramMenuItemImpl;
    setCheckable(paramMenuItemImpl.isCheckable());
    setChecked(paramMenuItemImpl.isChecked());
    setEnabled(paramMenuItemImpl.isEnabled());
    setIcon(paramMenuItemImpl.getIcon());
    setTitle(paramMenuItemImpl.getTitle());
    setId(paramMenuItemImpl.getItemId());
    if (!TextUtils.isEmpty(paramMenuItemImpl.getContentDescription())) {
      setContentDescription(paramMenuItemImpl.getContentDescription());
    }
    TooltipCompat.setTooltipText(this, paramMenuItemImpl.getTooltipText());
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    MenuItemImpl localMenuItemImpl = this.itemData;
    if ((localMenuItemImpl != null) && (localMenuItemImpl.isCheckable()) && (this.itemData.isChecked())) {
      mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  public boolean prefersCondensedTitle()
  {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    TextView localTextView = this.largeLabel;
    localTextView.setPivotX(localTextView.getWidth() / 2);
    localTextView = this.largeLabel;
    localTextView.setPivotY(localTextView.getBaseline());
    localTextView = this.smallLabel;
    localTextView.setPivotX(localTextView.getWidth() / 2);
    localTextView = this.smallLabel;
    localTextView.setPivotY(localTextView.getBaseline());
    int i = this.labelVisibilityMode;
    float f;
    if (i != -1)
    {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            setViewLayoutParams(this.icon, this.defaultMargin, 17);
            this.largeLabel.setVisibility(8);
            this.smallLabel.setVisibility(8);
          }
        }
        else if (paramBoolean)
        {
          setViewLayoutParams(this.icon, (int)(this.defaultMargin + this.shiftAmount), 49);
          setViewValues(this.largeLabel, 1.0F, 1.0F, 0);
          localTextView = this.smallLabel;
          f = this.scaleUpFactor;
          setViewValues(localTextView, f, f, 4);
        }
        else
        {
          setViewLayoutParams(this.icon, this.defaultMargin, 49);
          localTextView = this.largeLabel;
          f = this.scaleDownFactor;
          setViewValues(localTextView, f, f, 4);
          setViewValues(this.smallLabel, 1.0F, 1.0F, 0);
        }
      }
      else
      {
        if (paramBoolean)
        {
          setViewLayoutParams(this.icon, this.defaultMargin, 49);
          setViewValues(this.largeLabel, 1.0F, 1.0F, 0);
        }
        else
        {
          setViewLayoutParams(this.icon, this.defaultMargin, 17);
          setViewValues(this.largeLabel, 0.5F, 0.5F, 4);
        }
        this.smallLabel.setVisibility(4);
      }
    }
    else if (this.isShifting)
    {
      if (paramBoolean)
      {
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        setViewValues(this.largeLabel, 1.0F, 1.0F, 0);
      }
      else
      {
        setViewLayoutParams(this.icon, this.defaultMargin, 17);
        setViewValues(this.largeLabel, 0.5F, 0.5F, 4);
      }
      this.smallLabel.setVisibility(4);
    }
    else if (paramBoolean)
    {
      setViewLayoutParams(this.icon, (int)(this.defaultMargin + this.shiftAmount), 49);
      setViewValues(this.largeLabel, 1.0F, 1.0F, 0);
      localTextView = this.smallLabel;
      f = this.scaleUpFactor;
      setViewValues(localTextView, f, f, 4);
    }
    else
    {
      setViewLayoutParams(this.icon, this.defaultMargin, 49);
      localTextView = this.largeLabel;
      f = this.scaleDownFactor;
      setViewValues(localTextView, f, f, 4);
      setViewValues(this.smallLabel, 1.0F, 1.0F, 0);
    }
    refreshDrawableState();
    setSelected(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.smallLabel.setEnabled(paramBoolean);
    this.largeLabel.setEnabled(paramBoolean);
    this.icon.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
      return;
    }
    ViewCompat.setPointerIcon(this, null);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable.getConstantState();
      if (localObject != null) {
        paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      }
      localObject = DrawableCompat.wrap(paramDrawable).mutate();
      DrawableCompat.setTintList((Drawable)localObject, this.iconTint);
    }
    this.icon.setImageDrawable((Drawable)localObject);
  }
  
  public void setIconSize(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.icon.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.icon.setLayoutParams(localLayoutParams);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.iconTint = paramColorStateList;
    paramColorStateList = this.itemData;
    if (paramColorStateList != null) {
      setIcon(paramColorStateList.getIcon());
    }
  }
  
  public void setItemBackground(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt == 0) {
      localDrawable = null;
    } else {
      localDrawable = ContextCompat.getDrawable(getContext(), paramInt);
    }
    setItemBackground(localDrawable);
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    ViewCompat.setBackground(this, paramDrawable);
  }
  
  public void setItemPosition(int paramInt)
  {
    this.itemPosition = paramInt;
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.labelVisibilityMode != paramInt)
    {
      this.labelVisibilityMode = paramInt;
      if (this.itemData != null) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        setChecked(this.itemData.isChecked());
      }
    }
  }
  
  public void setShifting(boolean paramBoolean)
  {
    if (this.isShifting != paramBoolean)
    {
      this.isShifting = paramBoolean;
      int i;
      if (this.itemData != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        setChecked(this.itemData.isChecked());
      }
    }
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTextAppearanceActive(int paramInt)
  {
    TextViewCompat.setTextAppearance(this.largeLabel, paramInt);
    calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
  }
  
  public void setTextAppearanceInactive(int paramInt)
  {
    TextViewCompat.setTextAppearance(this.smallLabel, paramInt);
    calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      this.smallLabel.setTextColor(paramColorStateList);
      this.largeLabel.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.smallLabel.setText(paramCharSequence);
    this.largeLabel.setText(paramCharSequence);
    MenuItemImpl localMenuItemImpl = this.itemData;
    if ((localMenuItemImpl == null) || (TextUtils.isEmpty(localMenuItemImpl.getContentDescription()))) {
      setContentDescription(paramCharSequence);
    }
  }
  
  public boolean showsIcon()
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\bottomnavigation\BottomNavigationItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */