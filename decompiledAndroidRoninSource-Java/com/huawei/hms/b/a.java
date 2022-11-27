package com.huawei.hms.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;

public abstract class a
{
  private Activity a;
  private AlertDialog b;
  private a c;
  
  private static int e(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
  }
  
  protected AlertDialog a(Activity paramActivity)
  {
    return null;
  }
  
  protected abstract String a(Context paramContext);
  
  public void a()
  {
    AlertDialog localAlertDialog = this.b;
    if (localAlertDialog != null) {
      localAlertDialog.cancel();
    }
  }
  
  public void a(Activity paramActivity, a parama)
  {
    this.a = paramActivity;
    this.c = parama;
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity = a(this.a);
      this.b = paramActivity;
      paramActivity.setCanceledOnTouchOutside(false);
      this.b.setOnCancelListener(new d(this));
      this.b.setOnKeyListener(new e(this));
      this.b.show();
      return;
    }
    com.huawei.hms.support.log.a.d("AbstractDialog", "In show, The activity is null or finishing.");
  }
  
  protected abstract String b(Context paramContext);
  
  public void b()
  {
    AlertDialog localAlertDialog = this.b;
    if (localAlertDialog != null) {
      localAlertDialog.dismiss();
    }
  }
  
  protected abstract String c(Context paramContext);
  
  protected void c()
  {
    a locala = this.c;
    if (locala != null) {
      locala.b(this);
    }
  }
  
  protected abstract String d(Context paramContext);
  
  protected void d()
  {
    a locala = this.c;
    if (locala != null) {
      locala.a(this);
    }
  }
  
  protected Activity e()
  {
    return this.a;
  }
  
  protected int f()
  {
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void b(a parama);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */