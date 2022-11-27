package org.greenrobot.eventbus.util;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import org.greenrobot.eventbus.EventBus;

public class ErrorDialogFragments
{
  public static int ERROR_DIALOG_ICON;
  public static Class<?> EVENT_TYPE_ON_CLICK;
  
  public static Dialog createDialog(Context paramContext, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new AlertDialog.Builder(paramContext);
    paramContext.setTitle(paramBundle.getString("de.greenrobot.eventbus.errordialog.title"));
    paramContext.setMessage(paramBundle.getString("de.greenrobot.eventbus.errordialog.message"));
    int i = ERROR_DIALOG_ICON;
    if (i != 0) {
      paramContext.setIcon(i);
    }
    paramContext.setPositiveButton(17039370, paramOnClickListener);
    return paramContext.create();
  }
  
  public static void handleOnClick(DialogInterface paramDialogInterface, int paramInt, Activity paramActivity, Bundle paramBundle)
  {
    paramDialogInterface = EVENT_TYPE_ON_CLICK;
    if (paramDialogInterface != null) {
      try
      {
        paramDialogInterface = paramDialogInterface.newInstance();
        ErrorDialogManager.factory.config.getEventBus().post(paramDialogInterface);
      }
      catch (Exception paramDialogInterface)
      {
        throw new RuntimeException("Event cannot be constructed", paramDialogInterface);
      }
    }
    if ((paramBundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false)) && (paramActivity != null)) {
      paramActivity.finish();
    }
  }
  
  public static class Honeycomb
    extends android.app.DialogFragment
    implements DialogInterface.OnClickListener
  {
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      ErrorDialogFragments.handleOnClick(paramDialogInterface, paramInt, getActivity(), getArguments());
    }
    
    public Dialog onCreateDialog(Bundle paramBundle)
    {
      return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
    }
  }
  
  public static class Support
    extends androidx.fragment.app.DialogFragment
    implements DialogInterface.OnClickListener
  {
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      ErrorDialogFragments.handleOnClick(paramDialogInterface, paramInt, getActivity(), getArguments());
    }
    
    public Dialog onCreateDialog(Bundle paramBundle)
    {
      return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbu\\util\ErrorDialogFragments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */