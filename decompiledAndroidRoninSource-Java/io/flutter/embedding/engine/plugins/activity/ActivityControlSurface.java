package io.flutter.embedding.engine.plugins.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

public abstract interface ActivityControlSurface
{
  public abstract void attachToActivity(Activity paramActivity, Lifecycle paramLifecycle);
  
  public abstract void detachFromActivity();
  
  public abstract void detachFromActivityForConfigChanges();
  
  public abstract boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onNewIntent(Intent paramIntent);
  
  public abstract boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void onRestoreInstanceState(Bundle paramBundle);
  
  public abstract void onSaveInstanceState(Bundle paramBundle);
  
  public abstract void onUserLeaveHint();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\plugins\activity\ActivityControlSurface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */