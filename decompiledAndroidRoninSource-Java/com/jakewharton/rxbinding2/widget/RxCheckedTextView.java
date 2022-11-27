package com.jakewharton.rxbinding2.widget;

import android.widget.CheckedTextView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

public final class RxCheckedTextView
{
  private RxCheckedTextView()
  {
    throw new AssertionError("No instances.");
  }
  
  @Deprecated
  public static Consumer<? super Boolean> check(CheckedTextView paramCheckedTextView)
  {
    Preconditions.checkNotNull(paramCheckedTextView, "view == null");
    paramCheckedTextView.getClass();
    return new -..Lambda.7oFX7YZZ0g5nkYxEz3FX8Xui2tc(paramCheckedTextView);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RxCheckedTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */