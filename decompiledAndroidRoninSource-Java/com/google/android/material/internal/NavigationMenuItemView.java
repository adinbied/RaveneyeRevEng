package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.R.attr;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView.ItemView;
import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R.dimen;
import com.google.android.material.R.drawable;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;

public class NavigationMenuItemView
  extends ForegroundLinearLayout
  implements MenuView.ItemView
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private final AccessibilityDelegateCompat accessibilityDelegate = new AccessibilityDelegateCompat()
  {
    public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
      paramAnonymousAccessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.checkable);
    }
  };
  private FrameLayout actionArea;
  boolean checkable;
  private Drawable emptyDrawable;
  private boolean hasIconTintList;
  private final int iconSize;
  private ColorStateList iconTintList;
  private MenuItemImpl itemData;
  private boolean needsEmptyIcon;
  private final CheckedTextView textView;
  
  public NavigationMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(R.layout.design_navigation_menu_item, this, true);
    this.iconSize = paramContext.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size);
    paramContext = (CheckedTextView)findViewById(R.id.design_menu_item_text);
    this.textView = paramContext;
    paramContext.setDuplicateParentStateEnabled(true);
    ViewCompat.setAccessibilityDelegate(this.textView, this.accessibilityDelegate);
  }
  
  private void adjustAppearance()
  {
    Object localObject;
    if (shouldExpandActionArea())
    {
      this.textView.setVisibility(8);
      localObject = this.actionArea;
      if (localObject != null)
      {
        localObject = (LinearLayoutCompat.LayoutParams)((FrameLayout)localObject).getLayoutParams();
        ((LinearLayoutCompat.LayoutParams)localObject).width = -1;
        this.actionArea.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      this.textView.setVisibility(0);
      localObject = this.actionArea;
      if (localObject != null)
      {
        localObject = (LinearLayoutCompat.LayoutParams)((FrameLayout)localObject).getLayoutParams();
        ((LinearLayoutCompat.LayoutParams)localObject).width = -2;
        this.actionArea.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private StateListDrawable createDefaultBackground()
  {
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, localTypedValue, true))
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(CHECKED_STATE_SET, new ColorDrawable(localTypedValue.data));
      localStateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
      return localStateListDrawable;
    }
    return null;
  }
  
  private void setActionView(View paramView)
  {
    if (paramView != null)
    {
      if (this.actionArea == null) {
        this.actionArea = ((FrameLayout)((ViewStub)findViewById(R.id.design_menu_item_action_area_stub)).inflate());
      }
      this.actionArea.removeAllViews();
      this.actionArea.addView(paramView);
    }
  }
  
  private boolean shouldExpandActionArea()
  {
    return (this.itemData.getTitle() == null) && (this.itemData.getIcon() == null) && (this.itemData.getActionView() != null);
  }
  
  public MenuItemImpl getItemData()
  {
    return this.itemData;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.itemData = paramMenuItemImpl;
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
    if (getBackground() == null) {
      ViewCompat.setBackground(this, createDefaultBackground());
    }
    setCheckable(paramMenuItemImpl.isCheckable());
    setChecked(paramMenuItemImpl.isChecked());
    setEnabled(paramMenuItemImpl.isEnabled());
    setTitle(paramMenuItemImpl.getTitle());
    setIcon(paramMenuItemImpl.getIcon());
    setActionView(paramMenuItemImpl.getActionView());
    setContentDescription(paramMenuItemImpl.getContentDescription());
    TooltipCompat.setTooltipText(this, paramMenuItemImpl.getTooltipText());
    adjustAppearance();
  }
  
  protected int[] onCreateDrawableState(int paramInt)
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
  
  public void recycle()
  {
    FrameLayout localFrameLayout = this.actionArea;
    if (localFrameLayout != null) {
      localFrameLayout.removeAllViews();
    }
    this.textView.setCompoundDrawables(null, null, null, null);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (this.checkable != paramBoolean)
    {
      this.checkable = paramBoolean;
      this.accessibilityDelegate.sendAccessibilityEvent(this.textView, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    this.textView.setChecked(paramBoolean);
  }
  
  public void setHorizontalPadding(int paramInt)
  {
    setPadding(paramInt, 0, paramInt, 0);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i;
    if (paramDrawable != null)
    {
      Object localObject = paramDrawable;
      if (this.hasIconTintList)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject != null) {
          paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
        }
        localObject = DrawableCompat.wrap(paramDrawable).mutate();
        DrawableCompat.setTintList((Drawable)localObject, this.iconTintList);
      }
      i = this.iconSize;
      ((Drawable)localObject).setBounds(0, 0, i, i);
      paramDrawable = (Drawable)localObject;
    }
    else if (this.needsEmptyIcon)
    {
      if (this.emptyDrawable == null)
      {
        paramDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.navigation_empty_icon, getContext().getTheme());
        this.emptyDrawable = paramDrawable;
        if (paramDrawable != null)
        {
          i = this.iconSize;
          paramDrawable.setBounds(0, 0, i, i);
        }
      }
      paramDrawable = this.emptyDrawable;
    }
    TextViewCompat.setCompoundDrawablesRelative(this.textView, paramDrawable, null, null, null);
  }
  
  public void setIconPadding(int paramInt)
  {
    this.textView.setCompoundDrawablePadding(paramInt);
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    this.iconTintList = paramColorStateList;
    boolean bool;
    if (paramColorStateList != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.hasIconTintList = bool;
    paramColorStateList = this.itemData;
    if (paramColorStateList != null) {
      setIcon(paramColorStateList.getIcon());
    }
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.needsEmptyIcon = paramBoolean;
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTextAppearance(int paramInt)
  {
    TextViewCompat.setTextAppearance(this.textView, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.textView.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.textView.setText(paramCharSequence);
  }
  
  public boolean showsIcon()
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\internal\NavigationMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */