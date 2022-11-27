package com.huawei.hms.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class e
  implements DialogInterface.OnKeyListener
{
  e(a parama) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramInt) && (paramKeyEvent.getAction() == 1))
    {
      this.a.a();
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */