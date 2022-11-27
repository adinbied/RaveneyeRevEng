package com.facebook.imagepipeline.request;

public abstract class BaseRepeatedPostProcessor
  extends BasePostprocessor
  implements RepeatedPostprocessor
{
  private RepeatedPostprocessorRunner mCallback;
  
  private RepeatedPostprocessorRunner getCallback()
  {
    try
    {
      RepeatedPostprocessorRunner localRepeatedPostprocessorRunner = this.mCallback;
      return localRepeatedPostprocessorRunner;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setCallback(RepeatedPostprocessorRunner paramRepeatedPostprocessorRunner)
  {
    try
    {
      this.mCallback = paramRepeatedPostprocessorRunner;
      return;
    }
    finally
    {
      paramRepeatedPostprocessorRunner = finally;
      throw paramRepeatedPostprocessorRunner;
    }
  }
  
  public void update()
  {
    RepeatedPostprocessorRunner localRepeatedPostprocessorRunner = getCallback();
    if (localRepeatedPostprocessorRunner != null) {
      localRepeatedPostprocessorRunner.update();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\request\BaseRepeatedPostProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */