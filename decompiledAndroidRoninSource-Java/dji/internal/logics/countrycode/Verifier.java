package dji.internal.logics.countrycode;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Verifier
{
  private static final Map<String, String> timeZoneMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    timeZoneMap = localHashMap;
    localHashMap.put("US", "America/New_York");
    timeZoneMap.put("TH", "Asia/Bangkok");
    timeZoneMap.put("CN", "Asia/Chongqing");
    timeZoneMap.put("AE", "Asia/Dubai");
    timeZoneMap.put("CN", "Asia/Harbin");
    timeZoneMap.put("ID", "Asia/Jakarta");
    timeZoneMap.put("MO", "Asia/Macao");
    timeZoneMap.put("MO", "Asia/Macau");
    timeZoneMap.put("KR", "Asia/Seoul");
    timeZoneMap.put("CN", "Asia/Shanghai");
    timeZoneMap.put("SG", "Asia/Singapore");
    timeZoneMap.put("TW", "Asia/Taipei");
    timeZoneMap.put("BR", "Brazil/Acre");
    timeZoneMap.put("BR", "Brazil/DeNoronha");
    timeZoneMap.put("BR", "Brazil/East");
    timeZoneMap.put("BR", "Brazil/West");
    timeZoneMap.put("CA", "Canada/Atlantic");
    timeZoneMap.put("CA", "Canada/Central");
    timeZoneMap.put("CA", "Canada/East-Saskatchewan");
    timeZoneMap.put("CA", "Canada/Eastern");
    timeZoneMap.put("CA", "Canada/Mountain");
    timeZoneMap.put("CA", "Canada/Newfoundland");
    timeZoneMap.put("CA", "Canada/Pacific");
    timeZoneMap.put("CA", "Canada/Saskatchewan");
    timeZoneMap.put("CA", "Canada/Yukon");
    timeZoneMap.put("GB", "Europe/London");
    timeZoneMap.put("RU", "Europe/Moscow");
    timeZoneMap.put("JP", "Japan");
    timeZoneMap.put("MX", "Mexico/BajaNorte");
    timeZoneMap.put("MX", "Mexico/BajaSur");
    timeZoneMap.put("MX", "Mexico/General");
    timeZoneMap.put("SG", "Singapore");
  }
  
  String getCountryCodeByLocale(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().locale.getCountry();
  }
  
  String getLanguageByLocale(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().locale.getLanguage();
  }
  
  String getMMC(Context paramContext)
  {
    return null;
  }
  
  String getTimeZoneByLocale()
  {
    return null;
  }
  
  boolean verifyConsistency(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return false;
  }
  
  String verifyIPWithCountryCode(String paramString, Context paramContext)
  {
    return null;
  }
  
  boolean verifyLanguageWithCountryCode(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2));
  }
  
  boolean verifyTimeZoneWithCountryCode(String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\countrycode\Verifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */