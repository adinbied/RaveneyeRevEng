package dji.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class LanguageUtils
{
  public static final String KEY_LOCALE_APP_LANGUAGE = "KEY_LOCALE_APP_LANGUAGE";
  public static final String KEY_LOCALE_APP_SYSYTEM_DEDAULT = "KEY_LOCALE_APP_SYSYTEM_DEDAULT";
  public static final String LANGUAGE_DEFAULT = "DEFAULT";
  public static final String LANGUAGE_ENGLISH = "en-US";
  public static final String LANGUAGE_FRENCH = "fr";
  public static final String LANGUAGE_GERMAN = "de";
  public static final String LANGUAGE_ITALY = "it";
  public static final String LANGUAGE_JAPANESE = "ja";
  public static final String LANGUAGE_KOREAN = "ko";
  public static final String LANGUAGE_PORTUGAL = "pt";
  public static final String LANGUAGE_RUSSIAN = "ru";
  public static final String LANGUAGE_SIMPLIFIED_CHINESE = "zh-Hans";
  public static final String LANGUAGE_SPANISH = "es";
  public static final String LANGUAGE_THAILAND = "th";
  public static final String LANGUAGE_TRADITIONAL_CHINESE = "zh-Hant";
  private static final Map<String, Locale> LOCALE_MAP = Collections.unmodifiableMap(new HashMap(8) {});
  
  public static String getI18NLanguage(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramContext = paramContext.getResources().getConfiguration().getLocales().get(0);
    } else {
      paramContext = paramContext.getResources().getConfiguration().locale;
    }
    paramContext = paramContext.toLanguageTag();
    if (TextUtils.isEmpty(paramContext)) {
      return "en";
    }
    if (paramContext.startsWith("zh"))
    {
      paramContext = paramContext.toLowerCase(Locale.US);
      if (paramContext.contains("hans")) {
        return "zh";
      }
      if (paramContext.contains("hant")) {
        return "zh-Hant";
      }
      if (paramContext.contains("cn")) {
        return "zh";
      }
      return "zh-Hant";
    }
    if (paramContext.contains("en")) {
      return "en";
    }
    if (paramContext.contains("fr")) {
      return "fr";
    }
    if (paramContext.contains("de")) {
      return "de";
    }
    if (paramContext.contains("ko")) {
      return "ko";
    }
    if (paramContext.contains("ja")) {
      return "ja";
    }
    if (paramContext.contains("ru")) {
      return "ru";
    }
    if (paramContext.contains("es")) {
      return "es";
    }
    if (paramContext.contains("it")) {
      return "it";
    }
    if (paramContext.contains("pt")) {
      return "pt";
    }
    if (paramContext.contains("th")) {
      return "th";
    }
    return "en";
  }
  
  public static String getLanguage(Context paramContext)
  {
    return getLanguage_ISO_369_1(getLanguageSetting(paramContext));
  }
  
  public static String getLanguageSetting(Context paramContext)
  {
    paramContext = Locale.getDefault().toLanguageTag();
    return SharedPreferenceUtils.getInstance().getString("KEY_LOCALE_APP_LANGUAGE", paramContext);
  }
  
  public static String getLanguage_ISO_369_1(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "en-US";
    }
    if (paramString.equals("DEFAULT")) {
      return "DEFAULT";
    }
    if ((!"zh".equals(paramString)) && (!paramString.contains("CN")) && (!paramString.contains("Hans")) && (!paramString.contains("cn")))
    {
      if (paramString.contains("en")) {
        return "en-US";
      }
      if (paramString.contains("fr")) {
        return "fr";
      }
      if (paramString.contains("de")) {
        return "de";
      }
      if (paramString.contains("ko")) {
        return "ko";
      }
      if (paramString.contains("ja")) {
        return "ja";
      }
      if (paramString.contains("ru")) {
        return "ru";
      }
      if (paramString.contains("es")) {
        return "es";
      }
      if (paramString.contains("zh")) {
        return "zh-Hant";
      }
      if (paramString.contains("it")) {
        return "it";
      }
      if (paramString.contains("pt")) {
        return "pt";
      }
      return "en-US";
    }
    return "zh-Hans";
  }
  
  public static String getLanguage_ISO_369_1_2()
  {
    String str = getSystemLocale().toLanguageTag();
    if (TextUtils.isEmpty(str)) {
      return "en-US";
    }
    if (str.equals("DEFAULT")) {
      return "DEFAULT";
    }
    if (str.contains("zh"))
    {
      str = str.toLowerCase(Locale.US);
      if (str.contains("hans")) {
        return "zh-Hans";
      }
      if (str.contains("hant")) {
        return "zh-Hant";
      }
      if (str.contains("cn")) {
        return "zh-Hans";
      }
      return "zh-Hant";
    }
    if (str.contains("en")) {
      return "en-US";
    }
    if (str.contains("fr")) {
      return "fr";
    }
    if (str.contains("de")) {
      return "de";
    }
    if (str.contains("ko")) {
      return "ko";
    }
    if (str.contains("ja")) {
      return "ja";
    }
    if (str.contains("ru")) {
      return "ru";
    }
    if (str.contains("es")) {
      return "es";
    }
    if (str.contains("it")) {
      return "it";
    }
    if (str.contains("pt")) {
      return "pt";
    }
    return "en-US";
  }
  
  public static String getPushReportLanguage(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramContext = paramContext.getResources().getConfiguration().getLocales().get(0);
    } else {
      paramContext = paramContext.getResources().getConfiguration().locale;
    }
    paramContext = paramContext.toLanguageTag();
    if (TextUtils.isEmpty(paramContext)) {
      return "en";
    }
    if (paramContext.startsWith("zh"))
    {
      if (paramContext.startsWith("zh-Hant")) {
        return "zh-TW";
      }
      return "zh-CN";
    }
    if (paramContext.contains("en")) {
      return "en";
    }
    if (paramContext.contains("fr")) {
      return "fr";
    }
    if (paramContext.contains("de")) {
      return "de";
    }
    if (paramContext.contains("ko")) {
      return "ko";
    }
    if (paramContext.contains("ja")) {
      return "ja";
    }
    if (paramContext.contains("ru")) {
      return "ru";
    }
    if (paramContext.contains("es")) {
      return "es";
    }
    if (paramContext.contains("it")) {
      return "it";
    }
    if (paramContext.contains("pt")) {
      return "pt";
    }
    return "en";
  }
  
  private static Locale getSystemLocale()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return Resources.getSystem().getConfiguration().getLocales().get(0);
    }
    return Resources.getSystem().getConfiguration().locale;
  }
  
  public static boolean isChineseLanguage()
  {
    String str = getSystemLocale().toLanguageTag();
    boolean bool2 = TextUtils.isEmpty(str);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((str.contains("zh")) || (str.contains("CN")) || (str.contains("Hans")) || (str.contains("cn"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static String saveLanguageSetting(Context paramContext, String paramString)
  {
    paramContext = getLanguage_ISO_369_1(paramString);
    SharedPreferenceUtils.getInstance().put("KEY_LOCALE_APP_LANGUAGE", paramContext);
    return paramContext;
  }
  
  public static void setConfig(Context paramContext, Configuration paramConfiguration)
  {
    String str = getLanguageSetting(paramContext);
    paramContext = (Locale)LOCALE_MAP.get(str);
    if (TextUtils.equals(str, "DEFAULT")) {
      paramContext = getSystemLocale();
    }
    if (paramContext == null) {
      paramContext = (Locale)LOCALE_MAP.get("DEFAULT");
    }
    paramConfiguration.setLocale(getSystemLocale());
  }
  
  private static void setLanguage(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    Configuration localConfiguration = localResources.getConfiguration();
    setConfig(paramContext, localConfiguration);
    localResources.updateConfiguration(localConfiguration, localResources.getDisplayMetrics());
  }
  
  public static void switchLanguage(Context paramContext)
  {
    setLanguage(paramContext);
    if (Build.VERSION.SDK_INT >= 24) {
      setLanguage(paramContext.getApplicationContext());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\LanguageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */