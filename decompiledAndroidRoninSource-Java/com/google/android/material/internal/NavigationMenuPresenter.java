package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.material.R.dimen;
import com.google.android.material.R.layout;
import java.util.ArrayList;

public class NavigationMenuPresenter
  implements MenuPresenter
{
  private static final String STATE_ADAPTER = "android:menu:adapter";
  private static final String STATE_HEADER = "android:menu:header";
  private static final String STATE_HIERARCHY = "android:menu:list";
  NavigationMenuAdapter adapter;
  private MenuPresenter.Callback callback;
  LinearLayout headerLayout;
  ColorStateList iconTintList;
  private int id;
  Drawable itemBackground;
  int itemHorizontalPadding;
  int itemIconPadding;
  LayoutInflater layoutInflater;
  MenuBuilder menu;
  private NavigationMenuView menuView;
  final View.OnClickListener onClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = (NavigationMenuItemView)paramAnonymousView;
      NavigationMenuPresenter.this.setUpdateSuspended(true);
      paramAnonymousView = paramAnonymousView.getItemData();
      boolean bool = NavigationMenuPresenter.this.menu.performItemAction(paramAnonymousView, NavigationMenuPresenter.this, 0);
      if ((paramAnonymousView != null) && (paramAnonymousView.isCheckable()) && (bool)) {
        NavigationMenuPresenter.this.adapter.setCheckedItem(paramAnonymousView);
      }
      NavigationMenuPresenter.this.setUpdateSuspended(false);
      NavigationMenuPresenter.this.updateMenuView(false);
    }
  };
  int paddingSeparator;
  private int paddingTopDefault;
  int textAppearance;
  boolean textAppearanceSet;
  ColorStateList textColor;
  
  public void addHeaderView(View paramView)
  {
    this.headerLayout.addView(paramView);
    paramView = this.menuView;
    paramView.setPadding(0, 0, 0, paramView.getPaddingBottom());
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public void dispatchApplyWindowInsets(WindowInsetsCompat paramWindowInsetsCompat)
  {
    int i = paramWindowInsetsCompat.getSystemWindowInsetTop();
    if (this.paddingTopDefault != i)
    {
      this.paddingTopDefault = i;
      if (this.headerLayout.getChildCount() == 0)
      {
        NavigationMenuView localNavigationMenuView = this.menuView;
        localNavigationMenuView.setPadding(0, this.paddingTopDefault, 0, localNavigationMenuView.getPaddingBottom());
      }
    }
    ViewCompat.dispatchApplyWindowInsets(this.headerLayout, paramWindowInsetsCompat);
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public MenuItemImpl getCheckedItem()
  {
    return this.adapter.getCheckedItem();
  }
  
  public int getHeaderCount()
  {
    return this.headerLayout.getChildCount();
  }
  
  public View getHeaderView(int paramInt)
  {
    return this.headerLayout.getChildAt(paramInt);
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public Drawable getItemBackground()
  {
    return this.itemBackground;
  }
  
  public int getItemHorizontalPadding()
  {
    return this.itemHorizontalPadding;
  }
  
  public int getItemIconPadding()
  {
    return this.itemIconPadding;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.textColor;
  }
  
  public ColorStateList getItemTintList()
  {
    return this.iconTintList;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    if (this.menuView == null)
    {
      this.menuView = ((NavigationMenuView)this.layoutInflater.inflate(R.layout.design_navigation_menu, paramViewGroup, false));
      if (this.adapter == null) {
        this.adapter = new NavigationMenuAdapter();
      }
      this.headerLayout = ((LinearLayout)this.layoutInflater.inflate(R.layout.design_navigation_item_header, this.menuView, false));
      this.menuView.setAdapter(this.adapter);
    }
    return this.menuView;
  }
  
  public View inflateHeaderView(int paramInt)
  {
    View localView = this.layoutInflater.inflate(paramInt, this.headerLayout, false);
    addHeaderView(localView);
    return localView;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    this.layoutInflater = LayoutInflater.from(paramContext);
    this.menu = paramMenuBuilder;
    this.paddingSeparator = paramContext.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    MenuPresenter.Callback localCallback = this.callback;
    if (localCallback != null) {
      localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      Object localObject = paramParcelable.getSparseParcelableArray("android:menu:list");
      if (localObject != null) {
        this.menuView.restoreHierarchyState((SparseArray)localObject);
      }
      localObject = paramParcelable.getBundle("android:menu:adapter");
      if (localObject != null) {
        this.adapter.restoreInstanceState((Bundle)localObject);
      }
      paramParcelable = paramParcelable.getSparseParcelableArray("android:menu:header");
      if (paramParcelable != null) {
        this.headerLayout.restoreHierarchyState(paramParcelable);
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    if (this.menuView != null)
    {
      localObject = new SparseArray();
      this.menuView.saveHierarchyState((SparseArray)localObject);
      localBundle.putSparseParcelableArray("android:menu:list", (SparseArray)localObject);
    }
    Object localObject = this.adapter;
    if (localObject != null) {
      localBundle.putBundle("android:menu:adapter", ((NavigationMenuAdapter)localObject).createInstanceState());
    }
    if (this.headerLayout != null)
    {
      localObject = new SparseArray();
      this.headerLayout.saveHierarchyState((SparseArray)localObject);
      localBundle.putSparseParcelableArray("android:menu:header", (SparseArray)localObject);
    }
    return localBundle;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    return false;
  }
  
  public void removeHeaderView(View paramView)
  {
    this.headerLayout.removeView(paramView);
    if (this.headerLayout.getChildCount() == 0)
    {
      paramView = this.menuView;
      paramView.setPadding(0, this.paddingTopDefault, 0, paramView.getPaddingBottom());
    }
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    this.callback = paramCallback;
  }
  
  public void setCheckedItem(MenuItemImpl paramMenuItemImpl)
  {
    this.adapter.setCheckedItem(paramMenuItemImpl);
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    this.itemBackground = paramDrawable;
    updateMenuView(false);
  }
  
  public void setItemHorizontalPadding(int paramInt)
  {
    this.itemHorizontalPadding = paramInt;
    updateMenuView(false);
  }
  
  public void setItemIconPadding(int paramInt)
  {
    this.itemIconPadding = paramInt;
    updateMenuView(false);
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.iconTintList = paramColorStateList;
    updateMenuView(false);
  }
  
  public void setItemTextAppearance(int paramInt)
  {
    this.textAppearance = paramInt;
    this.textAppearanceSet = true;
    updateMenuView(false);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.textColor = paramColorStateList;
    updateMenuView(false);
  }
  
  public void setUpdateSuspended(boolean paramBoolean)
  {
    NavigationMenuAdapter localNavigationMenuAdapter = this.adapter;
    if (localNavigationMenuAdapter != null) {
      localNavigationMenuAdapter.setUpdateSuspended(paramBoolean);
    }
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    NavigationMenuAdapter localNavigationMenuAdapter = this.adapter;
    if (localNavigationMenuAdapter != null) {
      localNavigationMenuAdapter.update();
    }
  }
  
  private static class HeaderViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public HeaderViewHolder(View paramView)
    {
      super();
    }
  }
  
  private class NavigationMenuAdapter
    extends RecyclerView.Adapter<NavigationMenuPresenter.ViewHolder>
  {
    private static final String STATE_ACTION_VIEWS = "android:menu:action_views";
    private static final String STATE_CHECKED_ITEM = "android:menu:checked";
    private static final int VIEW_TYPE_HEADER = 3;
    private static final int VIEW_TYPE_NORMAL = 0;
    private static final int VIEW_TYPE_SEPARATOR = 2;
    private static final int VIEW_TYPE_SUBHEADER = 1;
    private MenuItemImpl checkedItem;
    private final ArrayList<NavigationMenuPresenter.NavigationMenuItem> items = new ArrayList();
    private boolean updateSuspended;
    
    NavigationMenuAdapter()
    {
      prepareMenuItems();
    }
    
    private void appendTransparentIconIfMissing(int paramInt1, int paramInt2)
    {
      while (paramInt1 < paramInt2)
      {
        ((NavigationMenuPresenter.NavigationMenuTextItem)this.items.get(paramInt1)).needsEmptyIcon = true;
        paramInt1 += 1;
      }
    }
    
    private void prepareMenuItems()
    {
      if (this.updateSuspended) {
        return;
      }
      this.updateSuspended = true;
      this.items.clear();
      this.items.add(new NavigationMenuPresenter.NavigationMenuHeaderItem());
      int n = -1;
      int i2 = NavigationMenuPresenter.this.menu.getVisibleItems().size();
      int m = 0;
      boolean bool2 = false;
      int k;
      for (int j = 0; m < i2; j = k)
      {
        Object localObject = (MenuItemImpl)NavigationMenuPresenter.this.menu.getVisibleItems().get(m);
        if (((MenuItemImpl)localObject).isChecked()) {
          setCheckedItem((MenuItemImpl)localObject);
        }
        if (((MenuItemImpl)localObject).isCheckable()) {
          ((MenuItemImpl)localObject).setExclusiveCheckable(false);
        }
        int i1;
        boolean bool1;
        int i;
        if (((MenuItemImpl)localObject).hasSubMenu())
        {
          SubMenu localSubMenu = ((MenuItemImpl)localObject).getSubMenu();
          i1 = n;
          bool1 = bool2;
          k = j;
          if (localSubMenu.hasVisibleItems())
          {
            if (m != 0) {
              this.items.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(NavigationMenuPresenter.this.paddingSeparator, 0));
            }
            this.items.add(new NavigationMenuPresenter.NavigationMenuTextItem((MenuItemImpl)localObject));
            int i3 = this.items.size();
            int i4 = localSubMenu.size();
            i1 = 0;
            for (i = 0; i1 < i4; i = k)
            {
              MenuItemImpl localMenuItemImpl = (MenuItemImpl)localSubMenu.getItem(i1);
              k = i;
              if (localMenuItemImpl.isVisible())
              {
                k = i;
                if (i == 0)
                {
                  k = i;
                  if (localMenuItemImpl.getIcon() != null) {
                    k = 1;
                  }
                }
                if (localMenuItemImpl.isCheckable()) {
                  localMenuItemImpl.setExclusiveCheckable(false);
                }
                if (((MenuItemImpl)localObject).isChecked()) {
                  setCheckedItem((MenuItemImpl)localObject);
                }
                this.items.add(new NavigationMenuPresenter.NavigationMenuTextItem(localMenuItemImpl));
              }
              i1 += 1;
            }
            i1 = n;
            bool1 = bool2;
            k = j;
            if (i != 0)
            {
              appendTransparentIconIfMissing(i3, this.items.size());
              i1 = n;
              bool1 = bool2;
              k = j;
            }
          }
        }
        else
        {
          i1 = ((MenuItemImpl)localObject).getGroupId();
          if (i1 != n)
          {
            j = this.items.size();
            if (((MenuItemImpl)localObject).getIcon() != null) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            bool1 = bool2;
            i = j;
            if (m != 0)
            {
              i = j + 1;
              this.items.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(NavigationMenuPresenter.this.paddingSeparator, NavigationMenuPresenter.this.paddingSeparator));
              bool1 = bool2;
            }
          }
          else
          {
            bool1 = bool2;
            i = j;
            if (!bool2)
            {
              bool1 = bool2;
              i = j;
              if (((MenuItemImpl)localObject).getIcon() != null)
              {
                appendTransparentIconIfMissing(j, this.items.size());
                bool1 = true;
                i = j;
              }
            }
          }
          localObject = new NavigationMenuPresenter.NavigationMenuTextItem((MenuItemImpl)localObject);
          ((NavigationMenuPresenter.NavigationMenuTextItem)localObject).needsEmptyIcon = bool1;
          this.items.add(localObject);
          k = i;
        }
        m += 1;
        n = i1;
        bool2 = bool1;
      }
      this.updateSuspended = false;
    }
    
    public Bundle createInstanceState()
    {
      Bundle localBundle = new Bundle();
      Object localObject = this.checkedItem;
      if (localObject != null) {
        localBundle.putInt("android:menu:checked", ((MenuItemImpl)localObject).getItemId());
      }
      SparseArray localSparseArray = new SparseArray();
      int i = 0;
      int j = this.items.size();
      while (i < j)
      {
        localObject = (NavigationMenuPresenter.NavigationMenuItem)this.items.get(i);
        if ((localObject instanceof NavigationMenuPresenter.NavigationMenuTextItem))
        {
          MenuItemImpl localMenuItemImpl = ((NavigationMenuPresenter.NavigationMenuTextItem)localObject).getMenuItem();
          if (localMenuItemImpl != null) {
            localObject = localMenuItemImpl.getActionView();
          } else {
            localObject = null;
          }
          if (localObject != null)
          {
            ParcelableSparseArray localParcelableSparseArray = new ParcelableSparseArray();
            ((View)localObject).saveHierarchyState(localParcelableSparseArray);
            localSparseArray.put(localMenuItemImpl.getItemId(), localParcelableSparseArray);
          }
        }
        i += 1;
      }
      localBundle.putSparseParcelableArray("android:menu:action_views", localSparseArray);
      return localBundle;
    }
    
    public MenuItemImpl getCheckedItem()
    {
      return this.checkedItem;
    }
    
    public int getItemCount()
    {
      return this.items.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      NavigationMenuPresenter.NavigationMenuItem localNavigationMenuItem = (NavigationMenuPresenter.NavigationMenuItem)this.items.get(paramInt);
      if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuSeparatorItem)) {
        return 2;
      }
      if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuHeaderItem)) {
        return 3;
      }
      if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuTextItem))
      {
        if (((NavigationMenuPresenter.NavigationMenuTextItem)localNavigationMenuItem).getMenuItem().hasSubMenu()) {
          return 1;
        }
        return 0;
      }
      throw new RuntimeException("Unknown item type.");
    }
    
    public void onBindViewHolder(NavigationMenuPresenter.ViewHolder paramViewHolder, int paramInt)
    {
      int i = getItemViewType(paramInt);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          localObject = (NavigationMenuPresenter.NavigationMenuSeparatorItem)this.items.get(paramInt);
          paramViewHolder.itemView.setPadding(0, ((NavigationMenuPresenter.NavigationMenuSeparatorItem)localObject).getPaddingTop(), 0, ((NavigationMenuPresenter.NavigationMenuSeparatorItem)localObject).getPaddingBottom());
          return;
        }
        ((TextView)paramViewHolder.itemView).setText(((NavigationMenuPresenter.NavigationMenuTextItem)this.items.get(paramInt)).getMenuItem().getTitle());
        return;
      }
      Object localObject = (NavigationMenuItemView)paramViewHolder.itemView;
      ((NavigationMenuItemView)localObject).setIconTintList(NavigationMenuPresenter.this.iconTintList);
      if (NavigationMenuPresenter.this.textAppearanceSet) {
        ((NavigationMenuItemView)localObject).setTextAppearance(NavigationMenuPresenter.this.textAppearance);
      }
      if (NavigationMenuPresenter.this.textColor != null) {
        ((NavigationMenuItemView)localObject).setTextColor(NavigationMenuPresenter.this.textColor);
      }
      if (NavigationMenuPresenter.this.itemBackground != null) {
        paramViewHolder = NavigationMenuPresenter.this.itemBackground.getConstantState().newDrawable();
      } else {
        paramViewHolder = null;
      }
      ViewCompat.setBackground((View)localObject, paramViewHolder);
      paramViewHolder = (NavigationMenuPresenter.NavigationMenuTextItem)this.items.get(paramInt);
      ((NavigationMenuItemView)localObject).setNeedsEmptyIcon(paramViewHolder.needsEmptyIcon);
      ((NavigationMenuItemView)localObject).setHorizontalPadding(NavigationMenuPresenter.this.itemHorizontalPadding);
      ((NavigationMenuItemView)localObject).setIconPadding(NavigationMenuPresenter.this.itemIconPadding);
      ((NavigationMenuItemView)localObject).initialize(paramViewHolder.getMenuItem(), 0);
    }
    
    public NavigationMenuPresenter.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              return null;
            }
            return new NavigationMenuPresenter.HeaderViewHolder(NavigationMenuPresenter.this.headerLayout);
          }
          return new NavigationMenuPresenter.SeparatorViewHolder(NavigationMenuPresenter.this.layoutInflater, paramViewGroup);
        }
        return new NavigationMenuPresenter.SubheaderViewHolder(NavigationMenuPresenter.this.layoutInflater, paramViewGroup);
      }
      return new NavigationMenuPresenter.NormalViewHolder(NavigationMenuPresenter.this.layoutInflater, paramViewGroup, NavigationMenuPresenter.this.onClickListener);
    }
    
    public void onViewRecycled(NavigationMenuPresenter.ViewHolder paramViewHolder)
    {
      if ((paramViewHolder instanceof NavigationMenuPresenter.NormalViewHolder)) {
        ((NavigationMenuItemView)paramViewHolder.itemView).recycle();
      }
    }
    
    public void restoreInstanceState(Bundle paramBundle)
    {
      int j = 0;
      int k = paramBundle.getInt("android:menu:checked", 0);
      int i;
      Object localObject1;
      if (k != 0)
      {
        this.updateSuspended = true;
        int m = this.items.size();
        i = 0;
        while (i < m)
        {
          localObject1 = (NavigationMenuPresenter.NavigationMenuItem)this.items.get(i);
          if ((localObject1 instanceof NavigationMenuPresenter.NavigationMenuTextItem))
          {
            localObject1 = ((NavigationMenuPresenter.NavigationMenuTextItem)localObject1).getMenuItem();
            if ((localObject1 != null) && (((MenuItemImpl)localObject1).getItemId() == k))
            {
              setCheckedItem((MenuItemImpl)localObject1);
              break;
            }
          }
          i += 1;
        }
        this.updateSuspended = false;
        prepareMenuItems();
      }
      paramBundle = paramBundle.getSparseParcelableArray("android:menu:action_views");
      if (paramBundle != null)
      {
        k = this.items.size();
        i = j;
        while (i < k)
        {
          localObject1 = (NavigationMenuPresenter.NavigationMenuItem)this.items.get(i);
          if ((localObject1 instanceof NavigationMenuPresenter.NavigationMenuTextItem))
          {
            Object localObject2 = ((NavigationMenuPresenter.NavigationMenuTextItem)localObject1).getMenuItem();
            if (localObject2 != null)
            {
              localObject1 = ((MenuItemImpl)localObject2).getActionView();
              if (localObject1 != null)
              {
                localObject2 = (ParcelableSparseArray)paramBundle.get(((MenuItemImpl)localObject2).getItemId());
                if (localObject2 != null) {
                  ((View)localObject1).restoreHierarchyState((SparseArray)localObject2);
                }
              }
            }
          }
          i += 1;
        }
      }
    }
    
    public void setCheckedItem(MenuItemImpl paramMenuItemImpl)
    {
      if (this.checkedItem != paramMenuItemImpl)
      {
        if (!paramMenuItemImpl.isCheckable()) {
          return;
        }
        MenuItemImpl localMenuItemImpl = this.checkedItem;
        if (localMenuItemImpl != null) {
          localMenuItemImpl.setChecked(false);
        }
        this.checkedItem = paramMenuItemImpl;
        paramMenuItemImpl.setChecked(true);
      }
    }
    
    public void setUpdateSuspended(boolean paramBoolean)
    {
      this.updateSuspended = paramBoolean;
    }
    
    public void update()
    {
      prepareMenuItems();
      notifyDataSetChanged();
    }
  }
  
  private static class NavigationMenuHeaderItem
    implements NavigationMenuPresenter.NavigationMenuItem
  {}
  
  private static abstract interface NavigationMenuItem {}
  
  private static class NavigationMenuSeparatorItem
    implements NavigationMenuPresenter.NavigationMenuItem
  {
    private final int paddingBottom;
    private final int paddingTop;
    
    public NavigationMenuSeparatorItem(int paramInt1, int paramInt2)
    {
      this.paddingTop = paramInt1;
      this.paddingBottom = paramInt2;
    }
    
    public int getPaddingBottom()
    {
      return this.paddingBottom;
    }
    
    public int getPaddingTop()
    {
      return this.paddingTop;
    }
  }
  
  private static class NavigationMenuTextItem
    implements NavigationMenuPresenter.NavigationMenuItem
  {
    private final MenuItemImpl menuItem;
    boolean needsEmptyIcon;
    
    NavigationMenuTextItem(MenuItemImpl paramMenuItemImpl)
    {
      this.menuItem = paramMenuItemImpl;
    }
    
    public MenuItemImpl getMenuItem()
    {
      return this.menuItem;
    }
  }
  
  private static class NormalViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public NormalViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
    {
      super();
      this.itemView.setOnClickListener(paramOnClickListener);
    }
  }
  
  private static class SeparatorViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public SeparatorViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  private static class SubheaderViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public SubheaderViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  private static abstract class ViewHolder
    extends RecyclerView.ViewHolder
  {
    public ViewHolder(View paramView)
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\internal\NavigationMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */