package com.jakewharton.rxbinding2.view;

import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import com.jakewharton.rxbinding2.internal.Functions;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public final class RxMenuItem
{
  private RxMenuItem()
  {
    throw new AssertionError("No instances.");
  }
  
  public static Observable<MenuItemActionViewEvent> actionViewEvents(MenuItem paramMenuItem)
  {
    Preconditions.checkNotNull(paramMenuItem, "menuItem == null");
    return new MenuItemActionViewEventObservable(paramMenuItem, Functions.PREDICATE_ALWAYS_TRUE);
  }
  
  public static Observable<MenuItemActionViewEvent> actionViewEvents(MenuItem paramMenuItem, Predicate<? super MenuItemActionViewEvent> paramPredicate)
  {
    Preconditions.checkNotNull(paramMenuItem, "menuItem == null");
    Preconditions.checkNotNull(paramPredicate, "handled == null");
    return new MenuItemActionViewEventObservable(paramMenuItem, paramPredicate);
  }
  
  @Deprecated
  public static Consumer<? super Boolean> checked(MenuItem paramMenuItem)
  {
    Preconditions.checkNotNull(paramMenuItem, "menuItem == null");
    paramMenuItem.getClass();
    return new -..Lambda.AjC8RqLJ3vbRaRP1ZisiPyTlNHY(paramMenuItem);
  }
  
  public static Observable<Object> clicks(MenuItem paramMenuItem)
  {
    Preconditions.checkNotNull(paramMenuItem, "menuItem == null");
    return new MenuItemClickOnSubscribe(paramMenuItem, Functions.PREDICATE_ALWAYS_TRUE);
  }
  
  public static Observable<Object> clicks(MenuItem paramMenuItem, Predicate<? super MenuItem> paramPredicate)
  {
    Preconditions.checkNotNull(paramMenuItem, "menuItem == null");
    Preconditions.checkNotNull(paramPredicate, "handled == null");
    return new MenuItemClickOnSubscribe(paramMenuItem, paramPredicate);
  }
  
  @Deprecated
  public static Consumer<? super Boolean> enabled(MenuItem paramMenuItem)
  {
    Preconditions.checkNotNull(paramMenuItem, "menuItem == null");
    paramMenuItem.getClass();
    return new -..Lambda.1RjUJ1peZVMgBvStJce4caGbyQ8(paramMenuItem);
  }
  
  @Deprecated
  public static Consumer<? super Drawable> icon(MenuItem paramMenuItem)
  {
    Preconditions.checkNotNull(paramMenuItem, "menuItem == null");
    paramMenuItem.getClass();
    return new -..Lambda.Q7LSUjl_T3WmJ6CX09WO-lpC54Y(paramMenuItem);
  }
  
  @Deprecated
  public static Consumer<? super Integer> iconRes(MenuItem paramMenuItem)
  {
    Preconditions.checkNotNull(paramMenuItem, "menuItem == null");
    paramMenuItem.getClass();
    return new -..Lambda.d48ZajymTj08V-uTy3Zkvr0IzfA(paramMenuItem);
  }
  
  @Deprecated
  public static Consumer<? super CharSequence> title(MenuItem paramMenuItem)
  {
    Preconditions.checkNotNull(paramMenuItem, "menuItem == null");
    paramMenuItem.getClass();
    return new -..Lambda.9IPCYuWszvmipuCQdY51Wr9oCRA(paramMenuItem);
  }
  
  @Deprecated
  public static Consumer<? super Integer> titleRes(MenuItem paramMenuItem)
  {
    Preconditions.checkNotNull(paramMenuItem, "menuItem == null");
    paramMenuItem.getClass();
    return new -..Lambda.NZvVLxUsGOQmGO7dmJhSjvlKRho(paramMenuItem);
  }
  
  @Deprecated
  public static Consumer<? super Boolean> visible(MenuItem paramMenuItem)
  {
    Preconditions.checkNotNull(paramMenuItem, "menuItem == null");
    paramMenuItem.getClass();
    return new -..Lambda.NiYKbJrnrZhbidMkg-gs4-HvOTg(paramMenuItem);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\RxMenuItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */