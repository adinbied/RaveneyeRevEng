package com.xiaomi.push;

import android.content.Context;
import java.io.File;

final class w
  extends v
{
  w(Context paramContext, File paramFile, Runnable paramRunnable)
  {
    super(paramContext, paramFile, null);
  }
  
  protected void a(Context paramContext)
  {
    paramContext = this.a;
    if (paramContext != null) {
      paramContext.run();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */