package com.jakewharton.rxbinding2.widget;

import android.widget.SearchView;

public abstract class SearchViewQueryTextEvent
{
  public static SearchViewQueryTextEvent create(SearchView paramSearchView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    return new AutoValue_SearchViewQueryTextEvent(paramSearchView, paramCharSequence, paramBoolean);
  }
  
  public abstract boolean isSubmitted();
  
  public abstract CharSequence queryText();
  
  public abstract SearchView view();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\SearchViewQueryTextEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */