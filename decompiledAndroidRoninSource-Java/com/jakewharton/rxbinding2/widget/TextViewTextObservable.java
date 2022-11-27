package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class TextViewTextObservable
  extends InitialValueObservable<CharSequence>
{
  private final TextView view;
  
  TextViewTextObservable(TextView paramTextView)
  {
    this.view = paramTextView;
  }
  
  protected CharSequence getInitialValue()
  {
    return this.view.getText();
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
    implements TextWatcher
  {
    private final Observer<? super CharSequence> observer;
    private final TextView view;
    
    Listener(TextView paramTextView, Observer<? super CharSequence> paramObserver)
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
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!isDisposed()) {
        this.observer.onNext(paramCharSequence);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\TextViewTextObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */