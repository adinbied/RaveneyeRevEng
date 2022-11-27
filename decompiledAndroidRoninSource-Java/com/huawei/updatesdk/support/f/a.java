package com.huawei.updatesdk.support.f;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.updatesdk.support.e.d;

public class a
{
  private b a;
  private Context b;
  private String c;
  private CharSequence d;
  private AlertDialog e;
  private AlertDialog.Builder f;
  private DialogInterface.OnShowListener g;
  private DialogInterface.OnDismissListener h;
  
  protected a(Context paramContext, String paramString, CharSequence paramCharSequence)
  {
    this.b = paramContext;
    this.c = paramString;
    this.d = paramCharSequence;
    paramString = new AlertDialog.Builder(paramContext);
    this.f = paramString;
    paramString.setTitle(this.c);
    this.f.setPositiveButton(d.b(paramContext, "upsdk_third_app_dl_sure_cancel_download"), null);
    this.f.setNegativeButton(d.b(paramContext, "upsdk_cancel"), null);
    this.f.setMessage(this.d);
  }
  
  public static a a(Context paramContext, String paramString, CharSequence paramCharSequence)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return new c(paramContext, paramString, paramCharSequence);
    }
    return new a(paramContext, paramString, paramCharSequence);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.h = paramOnDismissListener;
  }
  
  public void a(DialogInterface.OnKeyListener paramOnKeyListener)
  {
    AlertDialog localAlertDialog = this.e;
    if (localAlertDialog != null) {
      localAlertDialog.setOnKeyListener(paramOnKeyListener);
    }
  }
  
  public void a(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.g = paramOnShowListener;
  }
  
  /* Error */
  public void a(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(a arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(b paramb)
  {
    this.a = paramb;
  }
  
  public void a(boolean paramBoolean)
  {
    AlertDialog localAlertDialog = this.e;
    if (localAlertDialog != null) {
      localAlertDialog.setCancelable(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static enum a
  {
    static
    {
      a locala = new a("CANCEL", 1);
      b = locala;
      c = new a[] { a, locala };
    }
    
    private a() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\support\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */