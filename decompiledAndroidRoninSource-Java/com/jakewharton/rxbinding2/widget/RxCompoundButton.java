package com.jakewharton.rxbinding2.widget;

import android.widget.CompoundButton;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

public final class RxCompoundButton
{
  private RxCompoundButton()
  {
    throw new AssertionError("No instances.");
  }
  
  @Deprecated
  public static Consumer<? super Boolean> checked(CompoundButton paramCompoundButton)
  {
    Preconditions.checkNotNull(paramCompoundButton, "view == null");
    paramCompoundButton.getClass();
    return new -..Lambda.QNOSR1jvBNYMtXo8K1SS-H1C83M(paramCompoundButton);
  }
  
  public static InitialValueObservable<Boolean> checkedChanges(CompoundButton paramCompoundButton)
  {
    Preconditions.checkNotNull(paramCompoundButton, "view == null");
    return new CompoundButtonCheckedChangeObservable(paramCompoundButton);
  }
  
  public static Consumer<? super Object> toggle(CompoundButton paramCompoundButton)
  {
    Preconditions.checkNotNull(paramCompoundButton, "view == null");
    return new -..Lambda.RxCompoundButton.bf8lgga6gBvEKmfrbkNdvPmp3Q8(paramCompoundButton);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RxCompoundButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */