package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class TextViewBeforeTextChangeEventObservable
  extends InitialValueObservable<TextViewBeforeTextChangeEvent>
{
  private final TextView view;
  
  TextViewBeforeTextChangeEventObservable(TextView paramTextView)
  {
    this.view = paramTextView;
  }
  
  protected TextViewBeforeTextChangeEvent getInitialValue()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeListener(Observer<? super TextViewBeforeTextChangeEvent> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements TextWatcher
  {
    private final Observer<? super TextViewBeforeTextChangeEvent> observer;
    private final TextView view;
    
    Listener(TextView paramTextView, Observer<? super TextViewBeforeTextChangeEvent> paramObserver)
    {
      this.view = paramTextView;
      this.observer = paramObserver;
    }
    
    public void afterTextChanged(Editable paramEditable) {}
    
    /* Error */
    public void beforeTextChanged(CharSequence arg1, int arg2, int arg3, int arg4)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    protected void onDispose()
    {
      this.view.removeTextChangedListener(this);
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\TextViewBeforeTextChangeEventObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */