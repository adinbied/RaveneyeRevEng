package io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract interface SplashScreen
{
  public abstract View createSplashView(Context paramContext, Bundle paramBundle);
  
  public abstract boolean doesSplashViewRememberItsTransition();
  
  public abstract Bundle saveSplashScreenState();
  
  public abstract void transitionToFlutter(Runnable paramRunnable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\android\SplashScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */