package com.dji.webviewui.cable;

import java.util.Locale;

public class LanguageUtils
{
  public static final String CN_DJI_LANG_CODE = "cn";
  public static final String EN_DJI_LANG_CODE = "en";
  public static final String HK_DJI_LANG_CODE = "hk";
  public static final String JA_DJI_LANG_CODE = "ja";
  public static final String JP_DJI_LANG_CODE = "jp";
  public static final String MO_DJI_LANG_CODE = "mo";
  private static final String TAG = "LanguageUtils";
  public static final String TW_DJI_LANG_CODE = "tw";
  public static final String UK_DJI_LANG_CODE = "uk";
  public static final String ZH_DJI_LANG_CODE = "zh";
  
  public static String getLanguage()
  {
    String str2 = Locale.getDefault().getLanguage().toLowerCase();
    if ("zh".equals(str2))
    {
      str1 = Locale.getDefault().getCountry().toLowerCase();
      if ((!"tw".equals(str1)) && (!"hk".equals(str1)) && (!"mo".equals(str1))) {
        return "cn";
      }
      return "tw";
    }
    if ("ja".equals(str2)) {
      return "jp";
    }
    String str1 = str2;
    if ("en".equals(str2)) {
      str1 = "uk";
    }
    return str1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\webviewui\cable\LanguageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */