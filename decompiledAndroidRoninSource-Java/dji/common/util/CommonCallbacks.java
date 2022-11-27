package dji.common.util;

import dji.common.error.DJIError;

public class CommonCallbacks
{
  public static abstract interface CompletionCallback
  {
    public abstract void onResult(DJIError paramDJIError);
  }
  
  public static abstract interface CompletionCallbackWith<T>
  {
    public abstract void onFailure(DJIError paramDJIError);
    
    public abstract void onSuccess(T paramT);
  }
  
  public static abstract interface CompletionCallbackWithTwoParam<X, Y>
  {
    public abstract void onFailure(DJIError paramDJIError);
    
    public abstract void onSuccess(X paramX, Y paramY);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\commo\\util\CommonCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */