package lecho.lib.hellocharts.animation;

import java.util.EventListener;

public abstract interface ChartAnimationListener
  extends EventListener
{
  public abstract void onAnimationFinished();
  
  public abstract void onAnimationStarted();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\animation\ChartAnimationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */