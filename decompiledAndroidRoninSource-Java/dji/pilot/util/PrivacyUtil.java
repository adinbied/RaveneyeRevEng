package dji.pilot.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Locale;

public class PrivacyUtil
{
  public static boolean getIsChina(Context paramContext)
  {
    paramContext = Locale.getDefault().getCountry();
    return (Locale.CHINA.getCountry().equals(paramContext)) || (Locale.TAIWAN.getCountry().equals(paramContext));
  }
  
  public static int getMCC(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getResources().getConfiguration().mcc;
    }
    return -1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\util\PrivacyUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */