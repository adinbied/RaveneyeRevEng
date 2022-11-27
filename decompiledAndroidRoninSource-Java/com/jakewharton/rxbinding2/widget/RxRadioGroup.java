package com.jakewharton.rxbinding2.widget;

import android.widget.RadioGroup;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

public final class RxRadioGroup
{
  private RxRadioGroup()
  {
    throw new AssertionError("No instances.");
  }
  
  public static Consumer<? super Integer> checked(RadioGroup paramRadioGroup)
  {
    Preconditions.checkNotNull(paramRadioGroup, "view == null");
    return new -..Lambda.RxRadioGroup.SlsTRX-gUr_OgggM-nBodFL6DAM(paramRadioGroup);
  }
  
  public static InitialValueObservable<Integer> checkedChanges(RadioGroup paramRadioGroup)
  {
    Preconditions.checkNotNull(paramRadioGroup, "view == null");
    return new RadioGroupCheckedChangeObservable(paramRadioGroup);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RxRadioGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */