package com.jakewharton.rxbinding2.widget;

import android.widget.SearchView;

final class AutoValue_SearchViewQueryTextEvent
  extends SearchViewQueryTextEvent
{
  private final boolean isSubmitted;
  private final CharSequence queryText;
  private final SearchView view;
  
  AutoValue_SearchViewQueryTextEvent(SearchView paramSearchView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramSearchView != null)
    {
      this.view = paramSearchView;
      if (paramCharSequence != null)
      {
        this.queryText = paramCharSequence;
        this.isSubmitted = paramBoolean;
        return;
      }
      throw new NullPointerException("Null queryText");
    }
    throw new NullPointerException("Null view");
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isSubmitted()
  {
    return this.isSubmitted;
  }
  
  public CharSequence queryText()
  {
    return this.queryText;
  }
  
  public String toString()
  {
    return null;
  }
  
  public SearchView view()
  {
    return this.view;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AutoValue_SearchViewQueryTextEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */