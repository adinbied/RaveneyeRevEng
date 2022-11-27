package org.greenrobot.eventbus.util;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import org.greenrobot.eventbus.EventBus;

public class ErrorDialogManager
{
  public static final String KEY_EVENT_TYPE_ON_CLOSE = "de.greenrobot.eventbus.errordialog.event_type_on_close";
  public static final String KEY_FINISH_AFTER_DIALOG = "de.greenrobot.eventbus.errordialog.finish_after_dialog";
  public static final String KEY_ICON_ID = "de.greenrobot.eventbus.errordialog.icon_id";
  public static final String KEY_MESSAGE = "de.greenrobot.eventbus.errordialog.message";
  public static final String KEY_TITLE = "de.greenrobot.eventbus.errordialog.title";
  protected static final String TAG_ERROR_DIALOG = "de.greenrobot.eventbus.error_dialog";
  protected static final String TAG_ERROR_DIALOG_MANAGER = "de.greenrobot.eventbus.error_dialog_manager";
  public static ErrorDialogFragmentFactory<?> factory;
  
  public static void attachTo(Activity paramActivity)
  {
    attachTo(paramActivity, false, null);
  }
  
  public static void attachTo(Activity paramActivity, Object paramObject, boolean paramBoolean, Bundle paramBundle)
  {
    if (factory != null)
    {
      if (isSupportActivity(paramActivity))
      {
        SupportManagerFragment.attachTo(paramActivity, paramObject, paramBoolean, paramBundle);
        return;
      }
      HoneycombManagerFragment.attachTo(paramActivity, paramObject, paramBoolean, paramBundle);
      return;
    }
    throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
  }
  
  public static void attachTo(Activity paramActivity, boolean paramBoolean)
  {
    attachTo(paramActivity, paramBoolean, null);
  }
  
  public static void attachTo(Activity paramActivity, boolean paramBoolean, Bundle paramBundle)
  {
    attachTo(paramActivity, paramActivity.getClass(), paramBoolean, paramBundle);
  }
  
  protected static void checkLogException(ThrowableFailureEvent paramThrowableFailureEvent)
  {
    if (factory.config.logExceptions)
    {
      String str2 = factory.config.tagForLoggingExceptions;
      String str1 = str2;
      if (str2 == null) {
        str1 = EventBus.TAG;
      }
      Log.i(str1, "Error dialog manager received exception", paramThrowableFailureEvent.throwable);
    }
  }
  
  private static boolean isInExecutionScope(Object paramObject, ThrowableFailureEvent paramThrowableFailureEvent)
  {
    if (paramThrowableFailureEvent != null)
    {
      paramThrowableFailureEvent = paramThrowableFailureEvent.getExecutionScope();
      if ((paramThrowableFailureEvent != null) && (!paramThrowableFailureEvent.equals(paramObject))) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean isSupportActivity(Activity paramActivity)
  {
    Object localObject = paramActivity.getClass();
    String str;
    do
    {
      localObject = ((Class)localObject).getSuperclass();
      if (localObject == null) {
        break;
      }
      str = ((Class)localObject).getName();
      if (str.equals("androidx.fragment.app.FragmentActivity")) {
        return true;
      }
      if ((str.startsWith("com.actionbarsherlock.app")) && ((str.endsWith(".SherlockActivity")) || (str.endsWith(".SherlockListActivity")) || (str.endsWith(".SherlockPreferenceActivity"))))
      {
        paramActivity = new StringBuilder();
        paramActivity.append("Please use SherlockFragmentActivity. Illegal activity: ");
        paramActivity.append(str);
        throw new RuntimeException(paramActivity.toString());
      }
    } while (!str.equals("android.app.Activity"));
    if (Build.VERSION.SDK_INT >= 11) {
      return false;
    }
    throw new RuntimeException("Illegal activity without fragment support. Either use Android 3.0+ or android.support.v4.app.FragmentActivity.");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Illegal activity type: ");
    ((StringBuilder)localObject).append(paramActivity.getClass());
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  public static class HoneycombManagerFragment
    extends android.app.Fragment
  {
    protected Bundle argumentsForErrorDialog;
    private EventBus eventBus;
    private Object executionScope;
    protected boolean finishAfterDialog;
    
    public static void attachTo(Activity paramActivity, Object paramObject, boolean paramBoolean, Bundle paramBundle)
    {
      android.app.FragmentManager localFragmentManager = paramActivity.getFragmentManager();
      HoneycombManagerFragment localHoneycombManagerFragment = (HoneycombManagerFragment)localFragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog_manager");
      paramActivity = localHoneycombManagerFragment;
      if (localHoneycombManagerFragment == null)
      {
        paramActivity = new HoneycombManagerFragment();
        localFragmentManager.beginTransaction().add(paramActivity, "de.greenrobot.eventbus.error_dialog_manager").commit();
        localFragmentManager.executePendingTransactions();
      }
      paramActivity.finishAfterDialog = paramBoolean;
      paramActivity.argumentsForErrorDialog = paramBundle;
      paramActivity.executionScope = paramObject;
    }
    
    public void onEventMainThread(ThrowableFailureEvent paramThrowableFailureEvent)
    {
      if (!ErrorDialogManager.isInExecutionScope(this.executionScope, paramThrowableFailureEvent)) {
        return;
      }
      ErrorDialogManager.checkLogException(paramThrowableFailureEvent);
      android.app.FragmentManager localFragmentManager = getFragmentManager();
      localFragmentManager.executePendingTransactions();
      android.app.DialogFragment localDialogFragment = (android.app.DialogFragment)localFragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
      if (localDialogFragment != null) {
        localDialogFragment.dismiss();
      }
      paramThrowableFailureEvent = (android.app.DialogFragment)ErrorDialogManager.factory.prepareErrorFragment(paramThrowableFailureEvent, this.finishAfterDialog, this.argumentsForErrorDialog);
      if (paramThrowableFailureEvent != null) {
        paramThrowableFailureEvent.show(localFragmentManager, "de.greenrobot.eventbus.error_dialog");
      }
    }
    
    public void onPause()
    {
      this.eventBus.unregister(this);
      super.onPause();
    }
    
    public void onResume()
    {
      super.onResume();
      EventBus localEventBus = ErrorDialogManager.factory.config.getEventBus();
      this.eventBus = localEventBus;
      localEventBus.register(this);
    }
  }
  
  public static class SupportManagerFragment
    extends androidx.fragment.app.Fragment
  {
    protected Bundle argumentsForErrorDialog;
    private EventBus eventBus;
    private Object executionScope;
    protected boolean finishAfterDialog;
    private boolean skipRegisterOnNextResume;
    
    public static void attachTo(Activity paramActivity, Object paramObject, boolean paramBoolean, Bundle paramBundle)
    {
      androidx.fragment.app.FragmentManager localFragmentManager = ((FragmentActivity)paramActivity).getSupportFragmentManager();
      SupportManagerFragment localSupportManagerFragment = (SupportManagerFragment)localFragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog_manager");
      paramActivity = localSupportManagerFragment;
      if (localSupportManagerFragment == null)
      {
        paramActivity = new SupportManagerFragment();
        localFragmentManager.beginTransaction().add(paramActivity, "de.greenrobot.eventbus.error_dialog_manager").commit();
        localFragmentManager.executePendingTransactions();
      }
      paramActivity.finishAfterDialog = paramBoolean;
      paramActivity.argumentsForErrorDialog = paramBundle;
      paramActivity.executionScope = paramObject;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      paramBundle = ErrorDialogManager.factory.config.getEventBus();
      this.eventBus = paramBundle;
      paramBundle.register(this);
      this.skipRegisterOnNextResume = true;
    }
    
    public void onEventMainThread(ThrowableFailureEvent paramThrowableFailureEvent)
    {
      if (!ErrorDialogManager.isInExecutionScope(this.executionScope, paramThrowableFailureEvent)) {
        return;
      }
      ErrorDialogManager.checkLogException(paramThrowableFailureEvent);
      androidx.fragment.app.FragmentManager localFragmentManager = getFragmentManager();
      localFragmentManager.executePendingTransactions();
      androidx.fragment.app.DialogFragment localDialogFragment = (androidx.fragment.app.DialogFragment)localFragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
      if (localDialogFragment != null) {
        localDialogFragment.dismiss();
      }
      paramThrowableFailureEvent = (androidx.fragment.app.DialogFragment)ErrorDialogManager.factory.prepareErrorFragment(paramThrowableFailureEvent, this.finishAfterDialog, this.argumentsForErrorDialog);
      if (paramThrowableFailureEvent != null) {
        paramThrowableFailureEvent.show(localFragmentManager, "de.greenrobot.eventbus.error_dialog");
      }
    }
    
    public void onPause()
    {
      this.eventBus.unregister(this);
      super.onPause();
    }
    
    public void onResume()
    {
      super.onResume();
      if (this.skipRegisterOnNextResume)
      {
        this.skipRegisterOnNextResume = false;
        return;
      }
      EventBus localEventBus = ErrorDialogManager.factory.config.getEventBus();
      this.eventBus = localEventBus;
      localEventBus.register(this);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbu\\util\ErrorDialogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */