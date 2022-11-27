package com.dji.webviewui.util;

public class INetworkRequestProtocol
{
  public static final String CN_DJI_LANG_CODE = "cn";
  public static final String COMMON_SERVER_URL = "";
  public static final String CUSTOM_TOKEN_COOKIE_KEY = "wn2grgIkKubUV044";
  public static final String DEBUG_DOMAIN = ".dbeta.me";
  public static final String DEVICE_MOBILE_CODE = "mobile";
  public static final String DEVICE_TABLET_CODE = "tablet";
  public static final String EN_DJI_LANG_CODE = "en";
  public static final String KEY_EMAIL = "email";
  public static final String KEY_LANG = "locale";
  public static final String KEY_TOKEN = "token";
  public static final String[] NEED_SET_COOKIE_DOMAIN = { ".dji.com", ".skypixel.com", ".dbeta.me", ".djicorp.com" };
  public static final String RELEASE_DJICORP_DOMAIN = ".djicorp.com";
  public static final String RELEASE_DOMAIN = ".dji.com";
  public static final String RELEASE_EXPLORE_SERVER_URL = "https://djigoflyingprofile.djiservice.org/";
  public static final String RELEASE_SKYPIXEL_DOMAIN = ".skypixel.com";
  public static final String ZH_CN_DJI_LANG_CODE = "zh-CN";
  
  public static void init() {}
  
  public static abstract interface Account
  {
    public static final String TERMS_PRIVACY_URL = "file:///android_asset/htmls/Terms&Privacy.html";
  }
  
  public static abstract interface Coupon
  {
    public static final String COUPON_GIFTCARD_IMMEDIATE_URL_PART1 = "https://m.dji.com/card_pack?coupon=";
    public static final String COUPON_GIFTCARD_IMMEDIATE_URL_PART1_DEBUG = "";
    public static final String COUPON_GIFTCARD_IMMEDIATE_URL_PART1_DEBUG_PAD = "";
    public static final String COUPON_GIFTCARD_IMMEDIATE_URL_PART1_PAD = "https://store.dji.com/coupons/";
    public static final String COUPON_GIFTCARD_USERULES = "https://content.djiservice.org/agreement/dji-giftcard-agreement-cn.html";
    public static final String COUPON_GIFTCARD_USERULES_EN = "https://content.djiservice.org/agreement/dji-giftcard-agreement-en.html";
  }
  
  public static class DjiCareV2
    extends INetworkRequestProtocol.DjiServiceSign
  {
    public static String URL_BUY_CARE;
    public static boolean isDebug;
    
    static
    {
      String str;
      if (0 != 0) {
        str = "";
      } else {
        str = "https://m.dji.com/product/";
      }
      URL_BUY_CARE = str;
    }
  }
  
  public static class DjiServiceSign
  {
    public static String SIGN_KEY;
    public static boolean isDebug;
    
    static
    {
      String str;
      if (0 != 0) {
        str = "TEST_KEY";
      } else {
        str = "5C4AtJjmSif5LePjWHpAhQeMFMbhld8F";
      }
      SIGN_KEY = str;
    }
  }
  
  public static abstract interface Equipment
  {
    public static final String[] EN_PRODUCT_CONNECT_TUTORIAL_URLS = { "file:///android_asset/htmls/connect_kumquat_en.html", "file:///android_asset/htmls/connect_inspire_1_en.html", "file:///android_asset/htmls/connect_inspire_1_en.html", "file:///android_asset/htmls/connect_inspire_1_en.html", "file:///android_asset/htmls/connect_phantom_4_en.html", "file:///android_asset/htmls/connect_phantom_4_en.html", "file:///android_asset/htmls/connect_phantom_3_en.html", "file:///android_asset/htmls/connect_phantom_3_en.html", "file:///android_asset/htmls/connect_phantom_3C_en.html", "file:///android_asset/htmls/connect_matrice_100_en.html", "file:///android_asset/htmls/connect_matrice_600.html", "file:///android_asset/htmls/connect_matrice_600.html", "file:///android_asset/htmls/connect_osmo_en.html", "file:///android_asset/htmls/connect_osmo_en.html", "file:///android_asset/htmls/connect_osmo_en.html", "file:///android_asset/htmls/connect_osmo_en.html" };
    public static final int INDEX_OF_P3C = 3;
    public static final String[] ZH_PRODUCT_CONNECT_TUTORIAL_URLS = { "file:///android_asset/htmls/connect_kumquat.html", "file:///android_asset/htmls/connect_inspire_1.html", "file:///android_asset/htmls/connect_inspire_1.html", "file:///android_asset/htmls/connect_inspire_1.html", "file:///android_asset/htmls/connect_phantom_4.html", "file:///android_asset/htmls/connect_phantom_4.html", "file:///android_asset/htmls/connect_phantom_3.html", "file:///android_asset/htmls/connect_phantom_3.html", "file:///android_asset/htmls/connect_phantom_3C.html", "file:///android_asset/htmls/connect_matrice_100.html", "file:///android_asset/htmls/connect_matrice_600.html", "file:///android_asset/htmls/connect_matrice_600.html", "file:///android_asset/htmls/connect_osmo.html", "file:///android_asset/htmls/connect_osmo.html", "file:///android_asset/htmls/connect_osmo.html", "file:///android_asset/htmls/connect_osmo.html" };
  }
  
  public static abstract interface FlyRecordUpload
  {
    public static final String PRIVATE_PLLICY_URL = "https://djigoapi.djiservice.org/agreement/pp";
    public static final String PRIVATE_POLICY_URL_WITH_LOCATION = "https://djigoapi.djiservice.org/agreement/pp/%s";
  }
  
  public static abstract interface Mine
  {
    public static final String BBS_URL = "https://bbs.dji.com/forum.php?";
    public static final String CIRCLE_URL = "https://circle.dji.com";
    public static final String DDS_DETAIL_URL = "https://u.dji.com/%1$s/pilot/orders?app=%2$s-Android-%3$s";
    public static final String DDS_SWITCH_URL = "https://stormsend.djicdn.com/api/components/djigo_dds_switch.json";
    public static final String DDS_URL = "https://u.dji.com/%1$s/pilot?app=%2$s-Android-%3$s";
    public static final String DEBUG_BBS_URL = "http://bbs.dbeta.me/forum.php?";
    public static final String DEBUG_CIRCLE_URL = "";
    public static final String DEBUG_DDS_DETAIL_URL = "https://u.dji.com/%1$s/pilot/orders?app=%2$s-Android-%3$s";
    public static final String DEBUG_DDS_SWITCH_URL = "";
    public static final String DEBUG_DDS_URL = "https://u.dbeta.me/%1$s/pilot?app=%2$s-Android-%3$s";
    public static final String DEBUG_STORE_HOME_PAGE = "http://%1$s.dbeta.me%2$s?dji_from=dji-pilot-app";
    public static final String EN_BBS_URL = "https://forum.dji.com/forum.php?";
    public static final String FEEDBACK_DEBUG_URL = "";
    public static final String FEEDBACK_URL = "https://feedback-external.djicorp.com/feedback/static/feedback.html";
    public static final String LIVE800_URL = "https://djigoapi.djiservice.org/livechat_redirection/";
    public static final String REPAIR_CN_URL = "https://repair.dji.com/cn/support_wx/RepairTrace";
    public static final String REPAIR_EN_URL = "https://repair.dji.com/en/support_wx/RepairTrace";
    public static final String REPAIR_JP_URL = "https://repair.dji.com/ja/support_wx/RepairTrace";
    public static final String REPAIR_TW_URL = "https://repair.dji.com/zh-tw/support_wx/RepairTrace";
    public static final String SELF_REPAIR_CN_URL = "https://repair.dji.com/cn/SelfRepair/ProductLine";
    public static final String SELF_REPAIR_EN_URL = "https://repair.dji.com/en/SelfRepair/Area";
    public static final String STORE_HOME_PAGE = "https://%1$s.dji.com%2$s?dji_from=dji-pilot-app";
  }
  
  public static abstract interface NativeExplore {}
  
  public static abstract interface NewAcademy
  {
    public static final String ACADEMY_FLIGHT_BOOK_D_RELEASE = "https://content.djiservice.org/academy/faq/?id=";
    public static final String ACADEMY_LAGUAGE_CN = "cn";
    public static final String ACADEMY_LAGUAGE_EN = "en";
    public static final String ACADEMY_LAGUAGE_FR = "fr";
    public static final String ACADEMY_LAGUAGE_HANT = "hant";
    public static final String ACADEMY_LAGUAGE_JP = "jp";
    public static final String ACADEMY_PARAMSTART = "&language=";
  }
  
  public static abstract interface Share {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\webviewu\\util\INetworkRequestProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */