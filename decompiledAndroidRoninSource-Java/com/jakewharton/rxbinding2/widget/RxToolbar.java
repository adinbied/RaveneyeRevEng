package com.jakewharton.rxbinding2.widget;

import android.view.MenuItem;
import android.widget.Toolbar;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public final class RxToolbar
{
  private RxToolbar()
  {
    throw new AssertionError("No instances.");
  }
  
  public static Observable<MenuItem> itemClicks(Toolbar paramToolbar)
  {
    Preconditions.checkNotNull(paramToolbar, "view == null");
    return new ToolbarItemClickObservable(paramToolbar);
  }
  
  public static Observable<Object> navigationClicks(Toolbar paramToolbar)
  {
    Preconditions.checkNotNull(paramToolbar, "view == null");
    return new ToolbarNavigationClickObservable(paramToolbar);
  }
  
  @Deprecated
  public static Consumer<? super CharSequence> subtitle(Toolbar paramToolbar)
  {
    Preconditions.checkNotNull(paramToolbar, "view == null");
    paramToolbar.getClass();
    return new -..Lambda.flKUwXJSly0Q-N-A-iSWp9DQU90(paramToolbar);
  }
  
  @Deprecated
  public static Consumer<? super Integer> subtitleRes(Toolbar paramToolbar)
  {
    Preconditions.checkNotNull(paramToolbar, "view == null");
    paramToolbar.getClass();
    return new -..Lambda.zPKBgtJ98vlY0zrjehIMBKh0UxM(paramToolbar);
  }
  
  @Deprecated
  public static Consumer<? super CharSequence> title(Toolbar paramToolbar)
  {
    Preconditions.checkNotNull(paramToolbar, "view == null");
    paramToolbar.getClass();
    return new -..Lambda.y0AqlAyAzuzeYoVr_wyoHZ5LlYw(paramToolbar);
  }
  
  @Deprecated
  public static Consumer<? super Integer> titleRes(Toolbar paramToolbar)
  {
    Preconditions.checkNotNull(paramToolbar, "view == null");
    paramToolbar.getClass();
    return new -..Lambda.qzsPcFvheq9Owu_WK_7vktf0Hy4(paramToolbar);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RxToolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */