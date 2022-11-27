package com.jakewharton.rxbinding2.widget;

import android.widget.SearchView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

public final class RxSearchView
{
  private RxSearchView()
  {
    throw new AssertionError("No instances.");
  }
  
  public static Consumer<? super CharSequence> query(SearchView paramSearchView, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramSearchView, "view == null");
    return new -..Lambda.RxSearchView.aWcTCoFsGOuWWwZNQrpKOMyWbYY(paramSearchView, paramBoolean);
  }
  
  public static InitialValueObservable<SearchViewQueryTextEvent> queryTextChangeEvents(SearchView paramSearchView)
  {
    Preconditions.checkNotNull(paramSearchView, "view == null");
    return new SearchViewQueryTextChangeEventsObservable(paramSearchView);
  }
  
  public static InitialValueObservable<CharSequence> queryTextChanges(SearchView paramSearchView)
  {
    Preconditions.checkNotNull(paramSearchView, "view == null");
    return new SearchViewQueryTextChangesObservable(paramSearchView);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RxSearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */