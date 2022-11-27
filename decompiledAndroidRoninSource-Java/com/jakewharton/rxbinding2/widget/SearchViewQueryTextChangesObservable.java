package com.jakewharton.rxbinding2.widget;

import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class SearchViewQueryTextChangesObservable
  extends InitialValueObservable<CharSequence>
{
  private final SearchView view;
  
  SearchViewQueryTextChangesObservable(SearchView paramSearchView)
  {
    this.view = paramSearchView;
  }
  
  protected CharSequence getInitialValue()
  {
    return this.view.getQuery();
  }
  
  /* Error */
  protected void subscribeListener(Observer<? super CharSequence> arg1)
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
    private final Observer<? super CharSequence> observer;
    private final SearchView view;
    
    Listener(SearchView paramSearchView, Observer<? super CharSequence> paramObserver)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\SearchViewQueryTextChangesObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */