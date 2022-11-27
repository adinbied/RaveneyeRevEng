package dji.midware.util;

import android.content.Context;
import java.lang.reflect.Method;

public class ContextUtil
{
  private static Context CONTEXT_INSTANCE;
  public final String TAG = "ContextUtil";
  
  public static Context getContext()
  {
    if (CONTEXT_INSTANCE == null) {
      try
      {
        Object localObject1 = CONTEXT_INSTANCE;
        if (localObject1 == null) {
          try
          {
            localObject1 = Class.forName("android.app.ActivityThread");
            localObject1 = ((Class)localObject1).getMethod("currentActivityThread", new Class[0]).invoke(localObject1, new Object[0]);
            CONTEXT_INSTANCE = (Context)localObject1.getClass().getMethod("getApplication", new Class[0]).invoke(localObject1, new Object[0]);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      finally {}
    }
    return CONTEXT_INSTANCE;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\ContextUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */