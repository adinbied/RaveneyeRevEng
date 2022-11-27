package com.jakewharton.rxbinding2.widget;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;

public final class RxPopupMenu
{
  private RxPopupMenu()
  {
    throw new AssertionError("No instances.");
  }
  
  public static Observable<Object> dismisses(PopupMenu paramPopupMenu)
  {
    Preconditions.checkNotNull(paramPopupMenu, "view == null");
    return new PopupMenuDismissObservable(paramPopupMenu);
  }
  
  public static Observable<MenuItem> itemClicks(PopupMenu paramPopupMenu)
  {
    Preconditions.checkNotNull(paramPopupMenu, "view == null");
    return new PopupMenuItemClickObservable(paramPopupMenu);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RxPopupMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */