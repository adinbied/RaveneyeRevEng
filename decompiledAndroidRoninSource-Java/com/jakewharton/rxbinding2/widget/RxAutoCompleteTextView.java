package com.jakewharton.rxbinding2.widget;

import android.widget.AutoCompleteTextView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public final class RxAutoCompleteTextView
{
  private RxAutoCompleteTextView()
  {
    throw new AssertionError("No instances.");
  }
  
  @Deprecated
  public static Consumer<? super CharSequence> completionHint(AutoCompleteTextView paramAutoCompleteTextView)
  {
    Preconditions.checkNotNull(paramAutoCompleteTextView, "view == null");
    paramAutoCompleteTextView.getClass();
    return new -..Lambda.pyyqUmwj5A75qXewUUOfL_Qcims(paramAutoCompleteTextView);
  }
  
  public static Observable<AdapterViewItemClickEvent> itemClickEvents(AutoCompleteTextView paramAutoCompleteTextView)
  {
    Preconditions.checkNotNull(paramAutoCompleteTextView, "view == null");
    return new AutoCompleteTextViewItemClickEventObservable(paramAutoCompleteTextView);
  }
  
  @Deprecated
  public static Consumer<? super Integer> threshold(AutoCompleteTextView paramAutoCompleteTextView)
  {
    Preconditions.checkNotNull(paramAutoCompleteTextView, "view == null");
    paramAutoCompleteTextView.getClass();
    return new -..Lambda.-Z2-d7q90Wn08lyWTk5z-WCqLrI(paramAutoCompleteTextView);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RxAutoCompleteTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */