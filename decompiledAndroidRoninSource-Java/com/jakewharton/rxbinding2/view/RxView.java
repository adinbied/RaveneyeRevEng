package com.jakewharton.rxbinding2.view;

import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Functions;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.concurrent.Callable;

public final class RxView
{
  private RxView()
  {
    throw new AssertionError("No instances.");
  }
  
  @Deprecated
  public static Consumer<? super Boolean> activated(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    paramView.getClass();
    return new -..Lambda.NtkGcUoes2eULElo9uCOeuJRkmY(paramView);
  }
  
  public static Observable<ViewAttachEvent> attachEvents(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewAttachEventObservable(paramView);
  }
  
  public static Observable<Object> attaches(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewAttachesObservable(paramView, true);
  }
  
  @Deprecated
  public static Consumer<? super Boolean> clickable(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    paramView.getClass();
    return new -..Lambda.uaXr2Liy6tHu8F4PUEq82PN4yuU(paramView);
  }
  
  public static Observable<Object> clicks(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewClickObservable(paramView);
  }
  
  public static Observable<Object> detaches(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewAttachesObservable(paramView, false);
  }
  
  public static Observable<DragEvent> drags(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewDragObservable(paramView, Functions.PREDICATE_ALWAYS_TRUE);
  }
  
  public static Observable<DragEvent> drags(View paramView, Predicate<? super DragEvent> paramPredicate)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    Preconditions.checkNotNull(paramPredicate, "handled == null");
    return new ViewDragObservable(paramView, paramPredicate);
  }
  
  public static Observable<Object> draws(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewTreeObserverDrawObservable(paramView);
  }
  
  @Deprecated
  public static Consumer<? super Boolean> enabled(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    paramView.getClass();
    return new -..Lambda.7sli7apx3NyCWzGvWKC5phvd_II(paramView);
  }
  
  public static InitialValueObservable<Boolean> focusChanges(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewFocusChangeObservable(paramView);
  }
  
  public static Observable<Object> globalLayouts(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewTreeObserverGlobalLayoutObservable(paramView);
  }
  
  public static Observable<MotionEvent> hovers(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewHoverObservable(paramView, Functions.PREDICATE_ALWAYS_TRUE);
  }
  
  public static Observable<MotionEvent> hovers(View paramView, Predicate<? super MotionEvent> paramPredicate)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    Preconditions.checkNotNull(paramPredicate, "handled == null");
    return new ViewHoverObservable(paramView, paramPredicate);
  }
  
  public static Observable<KeyEvent> keys(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewKeyObservable(paramView, Functions.PREDICATE_ALWAYS_TRUE);
  }
  
  public static Observable<KeyEvent> keys(View paramView, Predicate<? super KeyEvent> paramPredicate)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    Preconditions.checkNotNull(paramPredicate, "handled == null");
    return new ViewKeyObservable(paramView, paramPredicate);
  }
  
  public static Observable<ViewLayoutChangeEvent> layoutChangeEvents(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewLayoutChangeEventObservable(paramView);
  }
  
  public static Observable<Object> layoutChanges(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewLayoutChangeObservable(paramView);
  }
  
  public static Observable<Object> longClicks(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewLongClickObservable(paramView, Functions.CALLABLE_ALWAYS_TRUE);
  }
  
  public static Observable<Object> longClicks(View paramView, Callable<Boolean> paramCallable)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    Preconditions.checkNotNull(paramCallable, "handled == null");
    return new ViewLongClickObservable(paramView, paramCallable);
  }
  
  public static Observable<Object> preDraws(View paramView, Callable<Boolean> paramCallable)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    Preconditions.checkNotNull(paramCallable, "proceedDrawingPass == null");
    return new ViewTreeObserverPreDrawObservable(paramView, paramCallable);
  }
  
  @Deprecated
  public static Consumer<? super Boolean> pressed(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    paramView.getClass();
    return new -..Lambda.pfx1HM5rr67c0a1FOZ-Gn_GvG1U(paramView);
  }
  
  public static Observable<ViewScrollChangeEvent> scrollChangeEvents(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewScrollChangeEventObservable(paramView);
  }
  
  @Deprecated
  public static Consumer<? super Boolean> selected(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    paramView.getClass();
    return new -..Lambda.TOfBQzwhTy9B8KBrE9uATKdzdy4(paramView);
  }
  
  public static Observable<Integer> systemUiVisibilityChanges(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewSystemUiVisibilityChangeObservable(paramView);
  }
  
  public static Observable<MotionEvent> touches(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return new ViewTouchObservable(paramView, Functions.PREDICATE_ALWAYS_TRUE);
  }
  
  public static Observable<MotionEvent> touches(View paramView, Predicate<? super MotionEvent> paramPredicate)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    Preconditions.checkNotNull(paramPredicate, "handled == null");
    return new ViewTouchObservable(paramView, paramPredicate);
  }
  
  public static Consumer<? super Boolean> visibility(View paramView)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    return visibility(paramView, 8);
  }
  
  public static Consumer<? super Boolean> visibility(View paramView, int paramInt)
  {
    Preconditions.checkNotNull(paramView, "view == null");
    if (paramInt != 0)
    {
      if ((paramInt != 4) && (paramInt != 8)) {
        throw new IllegalArgumentException("Must set visibility to INVISIBLE or GONE when false.");
      }
      return new -..Lambda.RxView.tVyy7UGSCON2fogxSc7ztbne1tc(paramView, paramInt);
    }
    throw new IllegalArgumentException("Setting visibility to VISIBLE when false would have no effect.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\RxView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */