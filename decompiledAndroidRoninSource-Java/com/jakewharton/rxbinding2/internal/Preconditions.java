package com.jakewharton.rxbinding2.internal;

import android.os.Looper;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposables;

public final class Preconditions
{
  private Preconditions()
  {
    throw new AssertionError("No instances.");
  }
  
  public static boolean checkMainThread(Observer<?> paramObserver)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramObserver.onSubscribe(Disposables.empty());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected to be called on the main thread but was ");
      localStringBuilder.append(Thread.currentThread().getName());
      paramObserver.onError(new IllegalStateException(localStringBuilder.toString()));
      return false;
    }
    return true;
  }
  
  public static void checkNotNull(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      return;
    }
    throw new NullPointerException(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\internal\Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */