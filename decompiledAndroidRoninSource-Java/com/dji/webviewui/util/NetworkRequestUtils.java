package com.dji.webviewui.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import dji.log.DJILog;
import dji.log.DJILogHelper;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetworkRequestUtils
  extends INetworkRequestProtocol
{
  public static final boolean FEEDBACK_DEBUG_FLAG = false;
  private static Pattern mPattern1 = Pattern.compile("country=[\\w]*");
  private static Pattern mPattern2 = Pattern.compile("lang=[\\w|-]*");
  
  public static String convertUrlWithParams(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(1024);
    Matcher localMatcher = Pattern.compile("\\{.*?\\}").matcher(paramString);
    while (localMatcher.find()) {
      if (paramString.substring(localMatcher.start(), localMatcher.end()).equals("{dji_lang}"))
      {
        if ("CN".equals(Locale.getDefault().getCountry())) {
          localMatcher.appendReplacement(localStringBuffer, "cn");
        } else if ("JP".equals(Locale.getDefault().getCountry())) {
          localMatcher.appendReplacement(localStringBuffer, "jp");
        } else if ("MO,TW,HK".contains(Locale.getDefault().getCountry())) {
          localMatcher.appendReplacement(localStringBuffer, "hant");
        } else {
          localMatcher.appendReplacement(localStringBuffer, "en");
        }
      }
      else {
        localMatcher.appendReplacement(localStringBuffer, "");
      }
    }
    localMatcher.appendTail(localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static String getAcademyLanguString(Context paramContext)
  {
    Object localObject1 = paramContext.getResources().getConfiguration().locale.getCountry();
    Object localObject2 = DJILogHelper.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAcademyLanguString country = ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(" Locale.SIMPLIFIED_CHINESE.getLanguage() = ");
    localStringBuilder.append(Locale.SIMPLIFIED_CHINESE.getLanguage());
    localStringBuilder.append(" Locale.TRADITIONAL_CHINESE.getLanguage()");
    localStringBuilder.append(Locale.TRADITIONAL_CHINESE.getLanguage());
    ((DJILogHelper)localObject2).LOGI("bob", localStringBuilder.toString());
    if (((String)localObject1).equalsIgnoreCase("CN"))
    {
      paramContext = paramContext.getResources().getConfiguration().locale.getVariant();
      localObject1 = DJILogHelper.getInstance();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAcademyLanguString Language = ");
      ((StringBuilder)localObject2).append(paramContext);
      ((DJILogHelper)localObject1).LOGI("bob", ((StringBuilder)localObject2).toString());
      return "cn";
    }
    if ((!((String)localObject1).equalsIgnoreCase("TW")) && (!((String)localObject1).equalsIgnoreCase("HK")))
    {
      if (((String)localObject1).equalsIgnoreCase("JP")) {
        return "jp";
      }
      if (((String)localObject1).equalsIgnoreCase("fr")) {
        return "fr";
      }
      return "en";
    }
    return "hant";
  }
  
  public static String getBBSUrlByTokenForShare(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("?");
    localStringBuilder.append("token");
    localStringBuilder.append("=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("&app=2&mobile=YES&from=djigo_share");
    return localStringBuilder.toString();
  }
  
  private static String getCookie(String paramString1, String paramString2)
  {
    CookieManager localCookieManager = CookieManager.getInstance();
    Object localObject = localCookieManager.getCookie(paramString1);
    localCookieManager.setCookie(paramString1, (String)localObject);
    paramString1 = null;
    if (localObject == null) {
      return null;
    }
    localObject = ((String)localObject).split(";");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localCookieManager = localObject[i];
      if (localCookieManager.contains(paramString2)) {
        paramString1 = localCookieManager.split("=")[1];
      }
      i += 1;
    }
    return paramString1;
  }
  
  public static String getLive800Url(Context paramContext)
  {
    paramContext = paramContext.getResources().getConfiguration().locale.getCountry().toLowerCase();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://djigoapi.djiservice.org/livechat_redirection/");
    localStringBuilder.append(paramContext);
    return localStringBuilder.toString();
  }
  
  public static String getLocaleString(Context paramContext)
  {
    paramContext = paramContext.getResources().getConfiguration().locale;
    if (paramContext.getCountry().equalsIgnoreCase(Locale.CHINA.getCountry())) {
      return "zh_CN";
    }
    if (paramContext.getLanguage().equalsIgnoreCase(Locale.JAPAN.getLanguage())) {
      return "ja";
    }
    if ((!paramContext.getCountry().equalsIgnoreCase(Locale.TAIWAN.getCountry())) && (!paramContext.getCountry().equalsIgnoreCase("HK")) && (!paramContext.getCountry().equalsIgnoreCase("MO"))) {
      return "en";
    }
    return "zh_TW";
  }
  
  public static String getPrivatePolicy(String paramString)
  {
    return String.format(Locale.US, "https://djigoapi.djiservice.org/agreement/pp/%s", new Object[] { paramString });
  }
  
  public static String getRepairUrl(Context paramContext)
  {
    String str = paramContext.getResources().getConfiguration().locale.getCountry();
    paramContext = paramContext.getResources().getConfiguration().locale.getLanguage();
    if (str.equalsIgnoreCase(Locale.CHINA.getCountry())) {
      return "https://repair.dji.com/cn/support_wx/RepairTrace";
    }
    if (paramContext.equalsIgnoreCase(Locale.JAPAN.getLanguage())) {
      return "https://repair.dji.com/ja/support_wx/RepairTrace";
    }
    if ((!str.equalsIgnoreCase(Locale.TAIWAN.getCountry())) && (!str.equalsIgnoreCase("HK")) && (!str.equalsIgnoreCase("MO"))) {
      return "https://repair.dji.com/en/support_wx/RepairTrace";
    }
    return "https://repair.dji.com/zh-tw/support_wx/RepairTrace";
  }
  
  public static String getRepairUrlByUID(Context paramContext)
  {
    if (Locale.CHINA.getCountry().equalsIgnoreCase(paramContext.getResources().getConfiguration().locale.getCountry())) {
      return "https://repair.dji.com/cn/SelfRepair/ProductLine";
    }
    return "https://repair.dji.com/en/SelfRepair/Area";
  }
  
  public static String getTermsPrivacyUrl()
  {
    return "file:///android_asset/htmls/Terms&Privacy.html";
  }
  
  public static boolean isBBSUrl(String paramString)
  {
    return (paramString.contains("bbs.dji.com")) || (paramString.contains("bbs.dbeta.me")) || (paramString.contains("forum.dji.com"));
  }
  
  private static void logCookieLang(CookieManager paramCookieManager)
  {
    Object localObject = paramCookieManager.getCookie(".dji.com");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramCookieManager = mPattern1.matcher((CharSequence)localObject);
      localObject = mPattern2.matcher((CharSequence)localObject);
      if ((paramCookieManager.find()) && (((Matcher)localObject).find()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("before: .dji.com ");
        localStringBuilder.append(paramCookieManager.group(0));
        localStringBuilder.append("; ");
        localStringBuilder.append(((Matcher)localObject).group(0));
        DJILog.saveLog(localStringBuilder.toString(), "SAT-4720");
      }
    }
  }
  
  private static void setLanguageCookie(CookieManager paramCookieManager, String paramString)
  {
    String str1 = Locale.getDefault().getCountry();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Locale.getDefault().getLanguage());
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(str1);
    String str2 = ((StringBuilder)localObject).toString();
    localObject = paramString;
    if (Objects.equals(paramString, ".skypixel.com"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("www");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new StringBuilder();
    paramString.append("country=");
    paramString.append(str1);
    paramCookieManager.setCookie((String)localObject, paramString.toString());
    paramString = new StringBuilder();
    paramString.append("lang=");
    paramString.append(str2);
    paramCookieManager.setCookie((String)localObject, paramString.toString());
  }
  
  public static void setNoLoginCookie(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = CookieSyncManager.createInstance(paramContext);
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    String[] arrayOfString = NEED_SET_COOKIE_DOMAIN;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      localCookieManager.setCookie(str, "secure(https)");
      if (!str.equals(".djicorp.com")) {
        localCookieManager.setCookie(str, "HttpOnly");
      }
      localCookieManager.setCookie(str, "_logged=yes");
      setLanguageCookie(localCookieManager, str);
      i += 1;
    }
    paramContext.sync();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\webviewu\\util\NetworkRequestUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */