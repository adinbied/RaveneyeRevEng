package com.huawei.hms.update.e;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.widget.ProgressBar;
import android.widget.TextView;

public class i
  extends b
{
  private ProgressBar a;
  private TextView b;
  private int c = 0;
  private DialogInterface.OnKeyListener d = new a(null);
  
  public AlertDialog a()
  {
    return null;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  /* Error */
  void b(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private static class a
    implements DialogInterface.OnKeyListener
  {
    public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
    {
      return (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hm\\update\e\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */