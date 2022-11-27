package com.jakewharton.rxbinding2.widget;

import android.widget.TextView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Functions;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public final class RxTextView
{
  private RxTextView()
  {
    throw new AssertionError("No instances.");
  }
  
  public static InitialValueObservable<TextViewAfterTextChangeEvent> afterTextChangeEvents(TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView, "view == null");
    return new TextViewAfterTextChangeEventObservable(paramTextView);
  }
  
  public static InitialValueObservable<TextViewBeforeTextChangeEvent> beforeTextChangeEvents(TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView, "view == null");
    return new TextViewBeforeTextChangeEventObservable(paramTextView);
  }
  
  @Deprecated
  public static Consumer<? super Integer> color(TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView, "view == null");
    paramTextView.getClass();
    return new -..Lambda.qB7FLs68jbv-Zbpr1mncsyqu76o(paramTextView);
  }
  
  public static Observable<TextViewEditorActionEvent> editorActionEvents(TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView, "view == null");
    return editorActionEvents(paramTextView, Functions.PREDICATE_ALWAYS_TRUE);
  }
  
  public static Observable<TextViewEditorActionEvent> editorActionEvents(TextView paramTextView, Predicate<? super TextViewEditorActionEvent> paramPredicate)
  {
    Preconditions.checkNotNull(paramTextView, "view == null");
    Preconditions.checkNotNull(paramPredicate, "handled == null");
    return new TextViewEditorActionEventObservable(paramTextView, paramPredicate);
  }
  
  public static Observable<Integer> editorActions(TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView, "view == null");
    return editorActions(paramTextView, Functions.PREDICATE_ALWAYS_TRUE);
  }
  
  public static Observable<Integer> editorActions(TextView paramTextView, Predicate<? super Integer> paramPredicate)
  {
    Preconditions.checkNotNull(paramTextView, "view == null");
    Preconditions.checkNotNull(paramPredicate, "handled == null");
    return new TextViewEditorActionObservable(paramTextView, paramPredicate);
  }
  
  @Deprecated
  public static Consumer<? super CharSequence> error(TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView, "view == null");
    paramTextView.getClass();
    return new -..Lambda.bUQzP4z3NbIbRCFm1ZSEoQaZb48(paramTextView);
  }
  
  @Deprecated
  public static Consumer<? super Integer> errorRes(TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView, "view == null");
    return new -..Lambda.RxTextView.kQ8lI6QY8MbHMsCEHorHYJO13fY(paramTextView);
  }
  
  @Deprecated
  public static Consumer<? super CharSequence> hint(TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView, "view == null");
    paramTextView.getClass();
    return new -..Lambda.7NIEI8IHGttGLhgT1qkxvKBVIN8(paramTextView);
  }
  
  @Deprecated
  public static Consumer<? super Integer> hintRes(TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView, "view == null");
    paramTextView.getClass();
    return new -..Lambda.fAbUhY88ka4VzxnV966iLa-RpqQ(paramTextView);
  }
  
  @Deprecated
  public static Consumer<? super CharSequence> text(TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView, "view == null");
    paramTextView.getClass();
    return new -..Lambda.Z0WOApe9t_GI-Nl7rWS-T4ChqkU(paramTextView);
  }
  
  public static InitialValueObservable<TextViewTextChangeEvent> textChangeEvents(TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView, "view == null");
    return new TextViewTextChangeEventObservable(paramTextView);
  }
  
  public static InitialValueObservable<CharSequence> textChanges(TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView, "view == null");
    return new TextViewTextObservable(paramTextView);
  }
  
  @Deprecated
  public static Consumer<? super Integer> textRes(TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView, "view == null");
    paramTextView.getClass();
    return new -..Lambda.3T9Oy5tHRPCurAB0D-kpi2DumeI(paramTextView);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RxTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */