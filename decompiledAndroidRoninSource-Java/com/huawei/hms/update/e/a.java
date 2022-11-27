package com.huawei.hms.update.e;

import android.app.Activity;
import java.lang.ref.WeakReference;

public abstract class a
  implements com.huawei.hms.activity.a
{
  public WeakReference<Activity> a;
  public com.huawei.hms.activity.a b;
  protected u c = null;
  protected b d = null;
  protected boolean e = false;
  protected int f = -1;
  protected String g = null;
  protected String h = null;
  protected int i = 0;
  protected String j = null;
  
  public static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6) {
            return "";
          }
          return v.class.getName();
        }
        return l.class.getName();
      }
      return k.class.getName();
    }
    return s.class.getName();
  }
  
  /* Error */
  private void a(java.util.ArrayList arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private String c(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  protected Activity a()
  {
    return null;
  }
  
  /* Error */
  protected void a(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void a(b paramb) {}
  
  abstract void a(Class<? extends b> paramClass);
  
  protected boolean a(String paramString, int paramInt)
  {
    return false;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  /* Error */
  protected void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void b(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void b(b paramb) {}
  
  /* Error */
  public void onBridgeActivityCreate(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onBridgeActivityDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onBridgeConfigurationChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onKeyUp(int arg1, android.view.KeyEvent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hm\\update\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */