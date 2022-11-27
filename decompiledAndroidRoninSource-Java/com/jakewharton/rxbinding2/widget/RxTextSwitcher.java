package com.jakewharton.rxbinding2.widget;

import android.widget.TextSwitcher;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

public final class RxTextSwitcher
{
  private RxTextSwitcher()
  {
    throw new AssertionError("No instances.");
  }
  
  @Deprecated
  public static Consumer<? super CharSequence> currentText(TextSwitcher paramTextSwitcher)
  {
    Preconditions.checkNotNull(paramTextSwitcher, "view == null");
    paramTextSwitcher.getClass();
    return new -..Lambda.oRPJUWPFS1fiB7r5hirgyZnUUVI(paramTextSwitcher);
  }
  
  @Deprecated
  public static Consumer<? super CharSequence> text(TextSwitcher paramTextSwitcher)
  {
    Preconditions.checkNotNull(paramTextSwitcher, "view == null");
    paramTextSwitcher.getClass();
    return new -..Lambda.PWSKFLOpOK3wCCMb0YNVJ7VcSFY(paramTextSwitcher);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RxTextSwitcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */