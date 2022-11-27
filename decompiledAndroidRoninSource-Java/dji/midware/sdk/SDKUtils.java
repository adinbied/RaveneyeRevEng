package dji.midware.sdk;

import android.content.Context;
import android.content.res.Resources;

public class SDKUtils
{
  public static int getMidwareResourceId(Context paramContext, String paramString)
  {
    return paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
  }
  
  public static String getMidwareString(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getString(paramInt);
  }
  
  public static String getMidwareStringByName(Context paramContext, String paramString)
  {
    return getMidwareString(paramContext, getMidwareResourceId(paramContext, paramString));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\sdk\SDKUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */