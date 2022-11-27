package com.xiaomi.push.service;

public abstract class aq
{
  public static String A = "ext_notify_id";
  public static String B = "ext_notify_type";
  public static String C = "ext_session";
  public static String D = "sig";
  public static String E = "ext_notify_title";
  public static String F = "ext_notify_description";
  public static String G = "ext_messenger";
  public static String H = "title";
  public static String I = "description";
  public static String J = "notifyId";
  public static String a = "1";
  public static String b = "2";
  public static String c = "3";
  public static String d = "com.xiaomi.push.OPEN_CHANNEL";
  public static String e = "com.xiaomi.push.SEND_MESSAGE";
  public static String f = "com.xiaomi.push.SEND_IQ";
  public static String g = "com.xiaomi.push.BATCH_SEND_MESSAGE";
  public static String h = "com.xiaomi.push.SEND_PRES";
  public static String i = "com.xiaomi.push.CLOSE_CHANNEL";
  public static String j = "com.xiaomi.push.FORCE_RECONN";
  public static String k = "com.xiaomi.push.RESET_CONN";
  public static String l = "com.xiaomi.push.UPDATE_CHANNEL_INFO";
  public static String m = "com.xiaomi.push.SEND_STATS";
  public static String n = "com.xiaomi.push.CHANGE_HOST";
  public static String o = "com.xiaomi.push.PING_TIMER";
  public static String p = "ext_user_id";
  public static String q = "ext_user_res";
  public static String r = "ext_chid";
  public static String s = "ext_sid";
  public static String t = "ext_token";
  public static String u = "ext_auth_method";
  public static String v = "ext_security";
  public static String w = "ext_kick";
  public static String x = "ext_client_attr";
  public static String y = "ext_cloud_attr";
  public static String z = "ext_pkg_name";
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return String.valueOf(paramInt);
    case 22: 
      return "ERROR_PING_TIMEOUT";
    case 21: 
      return "ERROR_BIND_TIMEOUT";
    case 20: 
      return "ERROR_REDIRECT";
    case 19: 
      return "ERROR_USER_BLOCKED";
    case 18: 
      return "ERROR_CONNECTIING_TIMEOUT";
    case 17: 
      return "ERROR_READ_TIMEOUT";
    case 16: 
      return "ERROR_SESSION_CHANGED";
    case 15: 
      return "ERROR_SERVICE_DESTROY";
    case 14: 
      return "ERROR_THREAD_BLOCK";
    case 13: 
      return "ERROR_SERVER_STREAM";
    case 12: 
      return "ERROR_NO_CLIENT";
    case 11: 
      return "ERROR_RESET";
    case 10: 
      return "ERROR_SEND_ERROR";
    case 9: 
      return "ERROR_READ_ERROR";
    case 8: 
      return "ERROR_RECEIVE_TIMEOUT";
    case 7: 
      return "ERROR_SERVER_ERROR";
    case 6: 
      return "ERROR_MULTI_LOGIN";
    case 5: 
      return "ERROR_AUTH_FAILED";
    case 4: 
      return "ERROR_ACCESS_DENIED";
    case 3: 
      return "ERROR_NETWORK_FAILED";
    case 2: 
      return "ERROR_NETWORK_NOT_AVAILABLE";
    case 1: 
      return "ERROR_SERVICE_NOT_INSTALLED";
    }
    return "ERROR_OK";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */