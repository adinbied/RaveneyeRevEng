package org.greenrobot.eventbus;

import android.os.Looper;

public abstract interface MainThreadSupport
{
  public abstract Poster createPoster(EventBus paramEventBus);
  
  public abstract boolean isMainThread();
  
  public static class AndroidHandlerMainThreadSupport
    implements MainThreadSupport
  {
    private final Looper looper;
    
    public AndroidHandlerMainThreadSupport(Looper paramLooper)
    {
      this.looper = paramLooper;
    }
    
    public Poster createPoster(EventBus paramEventBus)
    {
      return new HandlerPoster(paramEventBus, this.looper, 10);
    }
    
    public boolean isMainThread()
    {
      return this.looper == Looper.myLooper();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbus\MainThreadSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */