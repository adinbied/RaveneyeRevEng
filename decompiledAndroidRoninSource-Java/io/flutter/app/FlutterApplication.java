package io.flutter.app;

import android.app.Activity;
import android.app.Application;
import io.flutter.view.FlutterMain;

public class FlutterApplication
  extends Application
{
  private Activity mCurrentActivity = null;
  
  public Activity getCurrentActivity()
  {
    return this.mCurrentActivity;
  }
  
  public void onCreate()
  {
    super.onCreate();
    FlutterMain.startInitialization(this);
  }
  
  public void setCurrentActivity(Activity paramActivity)
  {
    this.mCurrentActivity = paramActivity;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\app\FlutterApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */