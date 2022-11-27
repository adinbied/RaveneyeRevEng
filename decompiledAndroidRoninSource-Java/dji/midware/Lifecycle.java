package dji.midware;

import android.content.Context;
import android.content.Intent;

public class Lifecycle
{
  public static final String ACTION_APPLICATION = "com.dji.lifecycle.application";
  public static final String STATUS_CREATE = "create";
  public static final String STATUS_DESTROY = "destroy";
  
  public static void broadcast(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramString1);
    localIntent.setPackage(paramContext.getPackageName());
    if (paramString2 != null) {
      localIntent.putExtra("status", paramString2);
    }
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void broadcastCreate(Context paramContext, String paramString)
  {
    broadcast(paramContext, paramString, "create");
  }
  
  public static void broadcastDestroy(Context paramContext, String paramString)
  {
    broadcast(paramContext, paramString, "destroy");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\Lifecycle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */