package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class TextViewTextChangeEventObservable
  extends InitialValueObservable<TextViewTextChangeEvent>
{
  private final TextView view;
  
  TextViewTextChangeEventObservable(TextView paramTextView)
  {
    this.view = paramTextView;
  }
  
  protected TextViewTextChangeEvent getInitialValue()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeListener(Observer<? super TextViewTextChangeEvent> arg1)
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
    private final Observer<? super TextViewTextChangeEvent> observer;
    private final TextView view;
    
    Listener(TextView paramTextView, Observer<? super TextViewTextChangeEvent> paramObserver)
    {
      this.view = paramTextView;
      this.observer = paramObserver;
    }
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    protected void onDispose()
    {
      this.view.removeTextChangedListener(this);
    }
    
    /* Error */
    public void onTextChanged(CharSequence arg1, int arg2, int arg3, int arg4)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\TextViewTextChangeEventObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */