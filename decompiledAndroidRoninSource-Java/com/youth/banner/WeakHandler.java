package com.youth.banner;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WeakHandler
{
  private final Handler.Callback mCallback;
  private final ExecHandler mExec;
  private Lock mLock;
  final ChainedRef mRunnables;
  
  public WeakHandler()
  {
    ReentrantLock localReentrantLock = new ReentrantLock();
    this.mLock = localReentrantLock;
    this.mRunnables = new ChainedRef(localReentrantLock, null);
    this.mCallback = null;
    this.mExec = new ExecHandler();
  }
  
  public WeakHandler(Handler.Callback paramCallback)
  {
    ReentrantLock localReentrantLock = new ReentrantLock();
    this.mLock = localReentrantLock;
    this.mRunnables = new ChainedRef(localReentrantLock, null);
    this.mCallback = paramCallback;
    this.mExec = new ExecHandler(new WeakReference(paramCallback));
  }
  
  public WeakHandler(Looper paramLooper)
  {
    ReentrantLock localReentrantLock = new ReentrantLock();
    this.mLock = localReentrantLock;
    this.mRunnables = new ChainedRef(localReentrantLock, null);
    this.mCallback = null;
    this.mExec = new ExecHandler(paramLooper);
  }
  
  public WeakHandler(Looper paramLooper, Handler.Callback paramCallback)
  {
    ReentrantLock localReentrantLock = new ReentrantLock();
    this.mLock = localReentrantLock;
    this.mRunnables = new ChainedRef(localReentrantLock, null);
    this.mCallback = paramCallback;
    this.mExec = new ExecHandler(paramLooper, new WeakReference(paramCallback));
  }
  
  private WeakRunnable wrapRunnable(Runnable paramRunnable)
  {
    return null;
  }
  
  public final Looper getLooper()
  {
    return this.mExec.getLooper();
  }
  
  public final boolean hasMessages(int paramInt)
  {
    return this.mExec.hasMessages(paramInt);
  }
  
  public final boolean hasMessages(int paramInt, Object paramObject)
  {
    return this.mExec.hasMessages(paramInt, paramObject);
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    return false;
  }
  
  public final boolean postAtFrontOfQueue(Runnable paramRunnable)
  {
    return false;
  }
  
  public final boolean postAtTime(Runnable paramRunnable, long paramLong)
  {
    return false;
  }
  
  public final boolean postAtTime(Runnable paramRunnable, Object paramObject, long paramLong)
  {
    return false;
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    return false;
  }
  
  /* Error */
  public final void removeCallbacks(Runnable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void removeCallbacks(Runnable arg1, Object arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final void removeCallbacksAndMessages(Object paramObject)
  {
    this.mExec.removeCallbacksAndMessages(paramObject);
  }
  
  public final void removeMessages(int paramInt)
  {
    this.mExec.removeMessages(paramInt);
  }
  
  public final void removeMessages(int paramInt, Object paramObject)
  {
    this.mExec.removeMessages(paramInt, paramObject);
  }
  
  public final boolean sendEmptyMessage(int paramInt)
  {
    return this.mExec.sendEmptyMessage(paramInt);
  }
  
  public final boolean sendEmptyMessageAtTime(int paramInt, long paramLong)
  {
    return this.mExec.sendEmptyMessageAtTime(paramInt, paramLong);
  }
  
  public final boolean sendEmptyMessageDelayed(int paramInt, long paramLong)
  {
    return this.mExec.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public final boolean sendMessage(Message paramMessage)
  {
    return this.mExec.sendMessage(paramMessage);
  }
  
  public final boolean sendMessageAtFrontOfQueue(Message paramMessage)
  {
    return this.mExec.sendMessageAtFrontOfQueue(paramMessage);
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    return this.mExec.sendMessageAtTime(paramMessage, paramLong);
  }
  
  public final boolean sendMessageDelayed(Message paramMessage, long paramLong)
  {
    return this.mExec.sendMessageDelayed(paramMessage, paramLong);
  }
  
  static class ChainedRef
  {
    Lock lock;
    ChainedRef next;
    ChainedRef prev;
    final Runnable runnable;
    final WeakHandler.WeakRunnable wrapper;
    
    public ChainedRef(Lock paramLock, Runnable paramRunnable)
    {
      this.runnable = paramRunnable;
      this.lock = paramLock;
      this.wrapper = new WeakHandler.WeakRunnable(new WeakReference(paramRunnable), new WeakReference(this));
    }
    
    /* Error */
    public void insertAfter(ChainedRef arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public WeakHandler.WeakRunnable remove()
    {
      return null;
    }
    
    public WeakHandler.WeakRunnable remove(Runnable paramRunnable)
    {
      return null;
    }
  }
  
  private static class ExecHandler
    extends Handler
  {
    private final WeakReference<Handler.Callback> mCallback;
    
    ExecHandler()
    {
      this.mCallback = null;
    }
    
    ExecHandler(Looper paramLooper)
    {
      super();
      this.mCallback = null;
    }
    
    ExecHandler(Looper paramLooper, WeakReference<Handler.Callback> paramWeakReference)
    {
      super();
      this.mCallback = paramWeakReference;
    }
    
    ExecHandler(WeakReference<Handler.Callback> paramWeakReference)
    {
      this.mCallback = paramWeakReference;
    }
    
    /* Error */
    public void handleMessage(Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static class WeakRunnable
    implements Runnable
  {
    private final WeakReference<Runnable> mDelegate;
    private final WeakReference<WeakHandler.ChainedRef> mReference;
    
    WeakRunnable(WeakReference<Runnable> paramWeakReference, WeakReference<WeakHandler.ChainedRef> paramWeakReference1)
    {
      this.mDelegate = paramWeakReference;
      this.mReference = paramWeakReference1;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\youth\banner\WeakHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */