package com.xiaomi.push;

public enum hy
{
  public final String a;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushHy = new hy("Invalid", 0, "INVALID");
    b = new hy("BarClick", 1, "bar:click");
    c = new hy("BarCancel", 2, "bar:cancel");
    d = new hy("AppOpen", 3, "app:open");
    e = new hy("PackageUninstall", 4, "package uninstalled");
    f = new hy("AppUninstall", 5, "app_uninstalled");
    g = new hy("ClientInfoUpdate", 6, "client_info_update");
    h = new hy("ClientInfoUpdateOk", 7, "client_info_update_ok");
    i = new hy("ClientMIIDUpdate", 8, "client_miid_update");
    j = new hy("PullOfflineMessage", 9, "pull");
    k = new hy("IosSleep", 10, "ios_sleep");
    l = new hy("IosWakeUp", 11, "ios_wakeup");
    m = new hy("AwakeApp", 12, "awake_app");
    n = new hy("NormalClientConfigUpdate", 13, "normal_client_config_update");
    o = new hy("CustomClientConfigUpdate", 14, "custom_client_config_update");
    p = new hy("DailyCheckClientConfig", 15, "daily_check_client_config");
    q = new hy("DataCollection", 16, "data_collection");
    r = new hy("RegIdExpired", 17, "registration id expired");
    s = new hy("ConnectionDisabled", 18, "!!!MILINK CONNECTION DISABLED!!!");
    t = new hy("PackageUnregistered", 19, "package_unregistered");
    u = new hy("DecryptMessageFail", 20, "decrypt_msg_fail");
    v = new hy("SyncInfo", 21, "sync_info");
    w = new hy("SyncInfoResult", 22, "sync_info_result");
    x = new hy("ForceSync", 23, "force_sync");
    y = new hy("UploadClientLog", 24, "upload_client_log");
    z = new hy("NotificationBarInfo", 25, "notification_bar_info");
    A = new hy("SyncMIID", 26, "sync_miid");
    B = new hy("UploadTinyData", 27, "upload");
    C = new hy("CancelPushMessage", 28, "clear_push_message");
    D = new hy("DisablePushMessage", 29, "disable_push");
    E = new hy("EnablePushMessage", 30, "enable_push");
    F = new hy("ClientABTest", 31, "client_ab_test");
    G = new hy("AwakeSystemApp", 32, "awake_system_app");
    H = new hy("AwakeAppResponse", 33, "awake_app_response");
    I = new hy("HybridRegister", 34, "hb_register");
    J = new hy("HybridRegisterResult", 35, "hb_register_res");
    K = new hy("HybridUnregister", 36, "hb_unregister");
    L = new hy("HybridUnregisterResult", 37, "hb_unregister_res");
    M = new hy("ThirdPartyRegUpdate", 38, "3rd_party_reg_update");
    N = new hy("VRUpload", 39, "vr_upload");
    O = new hy("PushLogUpload", 40, "log_upload");
    P = new hy("APP_WAKEUP", 41, "app_wakeup");
    Q = new hy("APP_SLEEP", 42, "app_sleep");
    hy localhy = new hy("NOTIFICATION_SWITCH", 43, "notification_switch");
    R = localhy;
    jdField_a_of_type_ArrayOfComXiaomiPushHy = new hy[] { jdField_a_of_type_ComXiaomiPushHy, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, localhy };
  }
  
  private hy(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\hy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */