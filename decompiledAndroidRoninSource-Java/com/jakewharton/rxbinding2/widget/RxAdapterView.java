package com.jakewharton.rxbinding2.widget;

import android.widget.Adapter;
import android.widget.AdapterView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Functions;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.concurrent.Callable;

public final class RxAdapterView
{
  private RxAdapterView()
  {
    throw new AssertionError("No instances.");
  }
  
  public static <T extends Adapter> Observable<AdapterViewItemClickEvent> itemClickEvents(AdapterView<T> paramAdapterView)
  {
    Preconditions.checkNotNull(paramAdapterView, "view == null");
    return new AdapterViewItemClickEventObservable(paramAdapterView);
  }
  
  public static <T extends Adapter> Observable<Integer> itemClicks(AdapterView<T> paramAdapterView)
  {
    Preconditions.checkNotNull(paramAdapterView, "view == null");
    return new AdapterViewItemClickObservable(paramAdapterView);
  }
  
  public static <T extends Adapter> Observable<AdapterViewItemLongClickEvent> itemLongClickEvents(AdapterView<T> paramAdapterView)
  {
    Preconditions.checkNotNull(paramAdapterView, "view == null");
    return itemLongClickEvents(paramAdapterView, Functions.PREDICATE_ALWAYS_TRUE);
  }
  
  public static <T extends Adapter> Observable<AdapterViewItemLongClickEvent> itemLongClickEvents(AdapterView<T> paramAdapterView, Predicate<? super AdapterViewItemLongClickEvent> paramPredicate)
  {
    Preconditions.checkNotNull(paramAdapterView, "view == null");
    Preconditions.checkNotNull(paramPredicate, "handled == null");
    return new AdapterViewItemLongClickEventObservable(paramAdapterView, paramPredicate);
  }
  
  public static <T extends Adapter> Observable<Integer> itemLongClicks(AdapterView<T> paramAdapterView)
  {
    Preconditions.checkNotNull(paramAdapterView, "view == null");
    return itemLongClicks(paramAdapterView, Functions.CALLABLE_ALWAYS_TRUE);
  }
  
  public static <T extends Adapter> Observable<Integer> itemLongClicks(AdapterView<T> paramAdapterView, Callable<Boolean> paramCallable)
  {
    Preconditions.checkNotNull(paramAdapterView, "view == null");
    Preconditions.checkNotNull(paramCallable, "handled == null");
    return new AdapterViewItemLongClickObservable(paramAdapterView, paramCallable);
  }
  
  public static <T extends Adapter> InitialValueObservable<Integer> itemSelections(AdapterView<T> paramAdapterView)
  {
    Preconditions.checkNotNull(paramAdapterView, "view == null");
    return new AdapterViewItemSelectionObservable(paramAdapterView);
  }
  
  @Deprecated
  public static <T extends Adapter> Consumer<? super Integer> selection(AdapterView<T> paramAdapterView)
  {
    Preconditions.checkNotNull(paramAdapterView, "view == null");
    paramAdapterView.getClass();
    return new -..Lambda.tV15yTqx3X5BUESDUN1xmzCL5p4(paramAdapterView);
  }
  
  public static <T extends Adapter> InitialValueObservable<AdapterViewSelectionEvent> selectionEvents(AdapterView<T> paramAdapterView)
  {
    Preconditions.checkNotNull(paramAdapterView, "view == null");
    return new AdapterViewSelectionObservable(paramAdapterView);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RxAdapterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */