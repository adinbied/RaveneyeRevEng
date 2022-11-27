package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.appcompat.R.attr;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools.Pool;
import androidx.core.util.Pools.SynchronizedPool;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R.dimen;
import com.google.android.material.internal.TextScale;
import java.util.ArrayList;

public class BottomNavigationMenuView
  extends ViewGroup
  implements MenuView
{
  private static final long ACTIVE_ANIMATION_DURATION_MS = 115L;
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final int[] DISABLED_STATE_SET = { -16842910 };
  private final int activeItemMaxWidth;
  private final int activeItemMinWidth;
  private BottomNavigationItemView[] buttons;
  private final int inactiveItemMaxWidth;
  private final int inactiveItemMinWidth;
  private Drawable itemBackground;
  private int itemBackgroundRes;
  private final int itemHeight;
  private boolean itemHorizontalTranslationEnabled;
  private int itemIconSize;
  private ColorStateList itemIconTint;
  private final Pools.Pool<BottomNavigationItemView> itemPool = new Pools.SynchronizedPool(5);
  private int itemTextAppearanceActive;
  private int itemTextAppearanceInactive;
  private final ColorStateList itemTextColorDefault;
  private ColorStateList itemTextColorFromUser;
  private int labelVisibilityMode;
  private MenuBuilder menu;
  private final View.OnClickListener onClickListener;
  private BottomNavigationPresenter presenter;
  private int selectedItemId = 0;
  private int selectedItemPosition = 0;
  private final TransitionSet set;
  private int[] tempChildWidths;
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    this.inactiveItemMaxWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
    this.inactiveItemMinWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
    this.activeItemMaxWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
    this.activeItemMinWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    this.itemHeight = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
    this.itemTextColorDefault = createDefaultColorStateList(16842808);
    paramContext = new AutoTransition();
    this.set = paramContext;
    paramContext.setOrdering(0);
    this.set.setDuration(115L);
    this.set.setInterpolator(new FastOutSlowInInterpolator());
    this.set.addTransition(new TextScale());
    this.onClickListener = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = ((BottomNavigationItemView)paramAnonymousView).getItemData();
        if (!BottomNavigationMenuView.this.menu.performItemAction(paramAnonymousView, BottomNavigationMenuView.this.presenter, 0)) {
          paramAnonymousView.setChecked(true);
        }
      }
    };
    this.tempChildWidths = new int[5];
  }
  
  private BottomNavigationItemView getNewItem()
  {
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)this.itemPool.acquire();
    BottomNavigationItemView localBottomNavigationItemView1 = localBottomNavigationItemView2;
    if (localBottomNavigationItemView2 == null) {
      localBottomNavigationItemView1 = new BottomNavigationItemView(getContext());
    }
    return localBottomNavigationItemView1;
  }
  
  private boolean isShifting(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1)
    {
      if (paramInt2 > 3) {
        return true;
      }
    }
    else if (paramInt1 == 0) {
      return true;
    }
    return false;
  }
  
  public void buildMenuView()
  {
    removeAllViews();
    Object localObject1 = this.buttons;
    Object localObject2;
    if (localObject1 != null)
    {
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null) {
          this.itemPool.release(localObject2);
        }
        i += 1;
      }
    }
    if (this.menu.size() == 0)
    {
      this.selectedItemId = 0;
      this.selectedItemPosition = 0;
      this.buttons = null;
      return;
    }
    this.buttons = new BottomNavigationItemView[this.menu.size()];
    boolean bool = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
    int i = 0;
    while (i < this.menu.size())
    {
      this.presenter.setUpdateSuspended(true);
      this.menu.getItem(i).setCheckable(true);
      this.presenter.setUpdateSuspended(false);
      localObject1 = getNewItem();
      this.buttons[i] = localObject1;
      ((BottomNavigationItemView)localObject1).setIconTintList(this.itemIconTint);
      ((BottomNavigationItemView)localObject1).setIconSize(this.itemIconSize);
      ((BottomNavigationItemView)localObject1).setTextColor(this.itemTextColorDefault);
      ((BottomNavigationItemView)localObject1).setTextAppearanceInactive(this.itemTextAppearanceInactive);
      ((BottomNavigationItemView)localObject1).setTextAppearanceActive(this.itemTextAppearanceActive);
      ((BottomNavigationItemView)localObject1).setTextColor(this.itemTextColorFromUser);
      localObject2 = this.itemBackground;
      if (localObject2 != null) {
        ((BottomNavigationItemView)localObject1).setItemBackground((Drawable)localObject2);
      } else {
        ((BottomNavigationItemView)localObject1).setItemBackground(this.itemBackgroundRes);
      }
      ((BottomNavigationItemView)localObject1).setShifting(bool);
      ((BottomNavigationItemView)localObject1).setLabelVisibilityMode(this.labelVisibilityMode);
      ((BottomNavigationItemView)localObject1).initialize((MenuItemImpl)this.menu.getItem(i), 0);
      ((BottomNavigationItemView)localObject1).setItemPosition(i);
      ((BottomNavigationItemView)localObject1).setOnClickListener(this.onClickListener);
      addView((View)localObject1);
      i += 1;
    }
    i = Math.min(this.menu.size() - 1, this.selectedItemPosition);
    this.selectedItemPosition = i;
    this.menu.getItem(i).setChecked(true);
  }
  
  public ColorStateList createDefaultColorStateList(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {
      return null;
    }
    ColorStateList localColorStateList = AppCompatResources.getColorStateList(getContext(), ((TypedValue)localObject).resourceId);
    if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, (TypedValue)localObject, true)) {
      return null;
    }
    paramInt = ((TypedValue)localObject).data;
    int i = localColorStateList.getDefaultColor();
    localObject = DISABLED_STATE_SET;
    int[] arrayOfInt1 = CHECKED_STATE_SET;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int j = localColorStateList.getColorForState(DISABLED_STATE_SET, i);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { j, paramInt, i });
  }
  
  public ColorStateList getIconTintList()
  {
    return this.itemIconTint;
  }
  
  public Drawable getItemBackground()
  {
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if ((arrayOfBottomNavigationItemView != null) && (arrayOfBottomNavigationItemView.length > 0)) {
      return arrayOfBottomNavigationItemView[0].getBackground();
    }
    return this.itemBackground;
  }
  
  @Deprecated
  public int getItemBackgroundRes()
  {
    return this.itemBackgroundRes;
  }
  
  public int getItemIconSize()
  {
    return this.itemIconSize;
  }
  
  public int getItemTextAppearanceActive()
  {
    return this.itemTextAppearanceActive;
  }
  
  public int getItemTextAppearanceInactive()
  {
    return this.itemTextAppearanceInactive;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.itemTextColorFromUser;
  }
  
  public int getLabelVisibilityMode()
  {
    return this.labelVisibilityMode;
  }
  
  public int getSelectedItemId()
  {
    return this.selectedItemId;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    this.menu = paramMenuBuilder;
  }
  
  public boolean isItemHorizontalTranslationEnabled()
  {
    return this.itemHorizontalTranslationEnabled;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = paramInt4 - paramInt2;
    paramInt2 = 0;
    paramInt4 = 0;
    while (paramInt2 < i)
    {
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        if (ViewCompat.getLayoutDirection(this) == 1)
        {
          int k = paramInt3 - paramInt1 - paramInt4;
          localView.layout(k - localView.getMeasuredWidth(), 0, k, j);
        }
        else
        {
          localView.layout(paramInt4, 0, localView.getMeasuredWidth() + paramInt4, j);
        }
        paramInt4 += localView.getMeasuredWidth();
      }
      paramInt2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getSize(paramInt1);
    int i = this.menu.getVisibleItems().size();
    int m = getChildCount();
    int n = View.MeasureSpec.makeMeasureSpec(this.itemHeight, 1073741824);
    Object localObject;
    int j;
    if ((isShifting(this.labelVisibilityMode, i)) && (this.itemHorizontalTranslationEnabled))
    {
      localObject = getChildAt(this.selectedItemPosition);
      paramInt2 = this.activeItemMinWidth;
      paramInt1 = paramInt2;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), n);
        paramInt1 = Math.max(paramInt2, ((View)localObject).getMeasuredWidth());
      }
      if (((View)localObject).getVisibility() != 8) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      paramInt2 = i - paramInt2;
      j = Math.min(k - this.inactiveItemMinWidth * paramInt2, Math.min(paramInt1, this.activeItemMaxWidth));
      i = k - j;
      if (paramInt2 == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = paramInt2;
      }
      k = Math.min(i / paramInt1, this.inactiveItemMaxWidth);
      paramInt2 = i - paramInt2 * k;
      paramInt1 = 0;
    }
    while (paramInt1 < m)
    {
      if (getChildAt(paramInt1).getVisibility() != 8)
      {
        localObject = this.tempChildWidths;
        if (paramInt1 == this.selectedItemPosition) {
          i = j;
        } else {
          i = k;
        }
        localObject[paramInt1] = i;
        i = paramInt2;
        if (paramInt2 > 0)
        {
          localObject = this.tempChildWidths;
          localObject[paramInt1] += 1;
          i = paramInt2 - 1;
        }
      }
      else
      {
        this.tempChildWidths[paramInt1] = 0;
        i = paramInt2;
      }
      paramInt1 += 1;
      paramInt2 = i;
      continue;
      if (i == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = i;
      }
      j = Math.min(k / paramInt1, this.activeItemMaxWidth);
      paramInt2 = k - i * j;
      paramInt1 = 0;
      while (paramInt1 < m)
      {
        if (getChildAt(paramInt1).getVisibility() != 8)
        {
          localObject = this.tempChildWidths;
          localObject[paramInt1] = j;
          i = paramInt2;
          if (paramInt2 > 0)
          {
            localObject[paramInt1] += 1;
            i = paramInt2 - 1;
          }
        }
        else
        {
          this.tempChildWidths[paramInt1] = 0;
          i = paramInt2;
        }
        paramInt1 += 1;
        paramInt2 = i;
      }
    }
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < m)
    {
      localObject = getChildAt(paramInt1);
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[paramInt1], 1073741824), n);
        ((View)localObject).getLayoutParams().width = ((View)localObject).getMeasuredWidth();
        paramInt2 += ((View)localObject).getMeasuredWidth();
      }
      paramInt1 += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(this.itemHeight, n, 0));
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.itemIconTint = paramColorStateList;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setIconTintList(paramColorStateList);
        i += 1;
      }
    }
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    this.itemBackground = paramDrawable;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setItemBackground(paramDrawable);
        i += 1;
      }
    }
  }
  
  public void setItemBackgroundRes(int paramInt)
  {
    this.itemBackgroundRes = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setItemBackground(paramInt);
        i += 1;
      }
    }
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    this.itemHorizontalTranslationEnabled = paramBoolean;
  }
  
  public void setItemIconSize(int paramInt)
  {
    this.itemIconSize = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setIconSize(paramInt);
        i += 1;
      }
    }
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    this.itemTextAppearanceActive = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceActive(paramInt);
        ColorStateList localColorStateList = this.itemTextColorFromUser;
        if (localColorStateList != null) {
          localBottomNavigationItemView.setTextColor(localColorStateList);
        }
        i += 1;
      }
    }
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    this.itemTextAppearanceInactive = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceInactive(paramInt);
        ColorStateList localColorStateList = this.itemTextColorFromUser;
        if (localColorStateList != null) {
          localBottomNavigationItemView.setTextColor(localColorStateList);
        }
        i += 1;
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.itemTextColorFromUser = paramColorStateList;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setTextColor(paramColorStateList);
        i += 1;
      }
    }
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    this.labelVisibilityMode = paramInt;
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    this.presenter = paramBottomNavigationPresenter;
  }
  
  void tryRestoreSelectedItemId(int paramInt)
  {
    int j = this.menu.size();
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = this.menu.getItem(i);
      if (paramInt == localMenuItem.getItemId())
      {
        this.selectedItemId = paramInt;
        this.selectedItemPosition = i;
        localMenuItem.setChecked(true);
        return;
      }
      i += 1;
    }
  }
  
  public void updateMenuView()
  {
    Object localObject = this.menu;
    if (localObject != null)
    {
      if (this.buttons == null) {
        return;
      }
      int j = ((MenuBuilder)localObject).size();
      if (j != this.buttons.length)
      {
        buildMenuView();
        return;
      }
      int k = this.selectedItemId;
      int i = 0;
      while (i < j)
      {
        localObject = this.menu.getItem(i);
        if (((MenuItem)localObject).isChecked())
        {
          this.selectedItemId = ((MenuItem)localObject).getItemId();
          this.selectedItemPosition = i;
        }
        i += 1;
      }
      if (k != this.selectedItemId) {
        TransitionManager.beginDelayedTransition(this, this.set);
      }
      boolean bool = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
      i = 0;
      while (i < j)
      {
        this.presenter.setUpdateSuspended(true);
        this.buttons[i].setLabelVisibilityMode(this.labelVisibilityMode);
        this.buttons[i].setShifting(bool);
        this.buttons[i].initialize((MenuItemImpl)this.menu.getItem(i), 0);
        this.presenter.setUpdateSuspended(false);
        i += 1;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\bottomnavigation\BottomNavigationMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */