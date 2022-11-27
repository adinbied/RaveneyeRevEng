package com.huawei.hms.update.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;

public abstract class b
{
  private AlertDialog a;
  private a b;
  
  private static int a(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
  }
  
  protected abstract AlertDialog a();
  
  /* Error */
  public void a(a arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void b()
  {
    AlertDialog localAlertDialog = this.a;
    if (localAlertDialog != null) {
      localAlertDialog.cancel();
    }
  }
  
  public void c()
  {
    AlertDialog localAlertDialog = this.a;
    if (localAlertDialog != null) {
      localAlertDialog.dismiss();
    }
  }
  
  protected void d()
  {
    a locala = this.b;
    if (locala != null) {
      locala.a(this);
    }
  }
  
  protected void e()
  {
    a locala = this.b;
    if (locala != null) {
      locala.b(this);
    }
  }
  
  protected Activity f()
  {
    return null;
  }
  
  protected int g()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hm\\update\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */