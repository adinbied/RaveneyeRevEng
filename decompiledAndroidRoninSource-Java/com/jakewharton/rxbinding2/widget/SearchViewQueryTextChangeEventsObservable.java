package com.jakewharton.rxbinding2.widget;

import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class SearchViewQueryTextChangeEventsObservable
  extends InitialValueObservable<SearchViewQueryTextEvent>
{
  private final SearchView view;
  
  SearchViewQueryTextChangeEventsObservable(SearchView paramSearchView)
  {
    this.view = paramSearchView;
  }
  
  protected SearchViewQueryTextEvent getInitialValue()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeListener(Observer<? super SearchViewQueryTextEvent> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements SearchView.OnQueryTextListener
  {
    private final Observer<? super SearchViewQueryTextEvent> observer;
    private final SearchView view;
    
    Listener(SearchView paramSearchView, Observer<? super SearchViewQueryTextEvent> paramObserver)
    {
      this.view = paramSearchView;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnQueryTextListener(null);
    }
    
    public boolean onQueryTextChange(String paramString)
    {
      return false;
    }
    
    public boolean onQueryTextSubmit(String paramString)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\SearchViewQueryTextChangeEventsObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */