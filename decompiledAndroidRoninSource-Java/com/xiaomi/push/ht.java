package com.xiaomi.push;

public enum ht
{
  private final int jdField_a_of_type_Int;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushHt = new ht("UploadSwitch", 0, 1);
    b = new ht("UploadFrequency", 1, 2);
    c = new ht("ScreenSizeCollectionSwitch", 2, 3);
    d = new ht("MacCollectionSwitch", 3, 4);
    e = new ht("IMSICollectionSwitch", 4, 5);
    f = new ht("AndroidVnCollectionSwitch", 5, 6);
    g = new ht("AndroidVcCollectionSwitch", 6, 7);
    h = new ht("AndroidIdCollectionSwitch", 7, 8);
    i = new ht("DeviceInfoCollectionFrequency", 8, 9);
    j = new ht("AppInstallListCollectionSwitch", 9, 10);
    k = new ht("AppInstallListCollectionFrequency", 10, 11);
    l = new ht("AppActiveListCollectionSwitch", 11, 12);
    m = new ht("AppActiveListCollectionFrequency", 12, 13);
    n = new ht("BluetoothCollectionSwitch", 13, 14);
    o = new ht("BluetoothCollectionFrequency", 14, 15);
    p = new ht("LocationCollectionSwitch", 15, 16);
    q = new ht("LocationCollectionFrequency", 16, 17);
    r = new ht("AccountCollectionSwitch", 17, 18);
    s = new ht("AccountCollectionFrequency", 18, 19);
    t = new ht("WifiCollectionSwitch", 19, 20);
    u = new ht("WifiCollectionFrequency", 20, 21);
    v = new ht("CellularCollectionSwitch", 21, 22);
    w = new ht("CellularCollectionFrequency", 22, 23);
    x = new ht("TopAppCollectionSwitch", 23, 24);
    y = new ht("TopAppCollectionFrequency", 24, 25);
    z = new ht("DataCollectionSwitch", 25, 26);
    A = new ht("OcVersionCheckFrequency", 26, 27);
    B = new ht("SyncInfoFrequency", 27, 28);
    C = new ht("UploadNotificationInfoFrequency", 28, 29);
    D = new ht("UploadNotificationInfoMaxNum", 29, 30);
    E = new ht("CollectionNotificationInfoBaseSwitch", 30, 31);
    F = new ht("CollectionNotificationInfoAppSwitch", 31, 32);
    G = new ht("CollectionNotificationInfoRemovedSwitch", 32, 33);
    H = new ht("ForegroundServiceSwitch", 33, 34);
    I = new ht("SyncMIIDFrequency", 34, 35);
    J = new ht("Upload4GSwitch", 35, 36);
    K = new ht("Upload4GFrequency", 36, 37);
    L = new ht("Upload3GSwitch", 37, 38);
    M = new ht("Upload3GFrequency", 38, 39);
    N = new ht("ShieldTypeConfig", 39, 40);
    O = new ht("UploadWIFIGeoLocFrequency", 40, 41);
    P = new ht("UploadNOWIFIGeoLocFrequency", 41, 42);
    Q = new ht("BroadcastActionCollectionSwitch", 42, 43);
    R = new ht("BroadcastActionCollectionFrequency", 43, 44);
    S = new ht("UploadGeoLocSwitch", 44, 45);
    T = new ht("ServiceBootMode", 45, 46);
    U = new ht("AppPermissionCollectionSwitch", 46, 47);
    V = new ht("AppPermissionCollectionFrequency", 47, 48);
    W = new ht("WifiDevicesMacCollectionSwitch", 48, 49);
    X = new ht("WifiDevicesMacCollectionFrequency", 49, 50);
    Y = new ht("WifiDevicesMacWifiUnchangedCollectionFrequency", 50, 51);
    Z = new ht("AggregationSdkMonitorSwitch", 51, 52);
    aa = new ht("AggregationSdkMonitorFrequency", 52, 53);
    ab = new ht("AggregationSdkMonitorDepth", 53, 54);
    ac = new ht("UploadGeoAppLocSwitch", 54, 55);
    ad = new ht("ThirdPushControlSwitch", 55, 56);
    ae = new ht("ThirdPushComponentKeyWords", 56, 57);
    af = new ht("ThirdPushWhiteList", 57, 58);
    ag = new ht("XmsfScanWhitelist", 58, 59);
    ah = new ht("IccidCollectionSwitch", 59, 60);
    ai = new ht("LimitThridPushStrategyMode", 60, 61);
    aj = new ht("GlobalPushChannelException", 61, 62);
    ak = new ht("TinyDataUploadSwitch", 62, 63);
    al = new ht("TinyDataUploadFrequency", 63, 64);
    am = new ht("GlobalRegionIOSwitch", 64, 65);
    an = new ht("GlobalRegionIOWait", 65, 66);
    ao = new ht("AggregatePushSwitch", 66, 67);
    ap = new ht("ActivityTSSwitch", 67, 68);
    aq = new ht("OperatorSwitch", 68, 69);
    ar = new ht("DeviceIdSwitch", 69, 70);
    as = new ht("DeviceBaseInfoCollectionFrequency", 70, 71);
    at = new ht("UsageStatsCollectionFrequency", 71, 72);
    au = new ht("UsageStatsCollectionWhiteList", 72, 73);
    av = new ht("ForceHandleCrashSwitch", 73, 74);
    aw = new ht("Crash4GUploadSwitch", 74, 75);
    ax = new ht("Crash4GUploadFrequency", 75, 76);
    ay = new ht("CrashWIFIUploadFrequency", 76, 77);
    az = new ht("EventUploadSwitch", 77, 78);
    aA = new ht("PerfUploadSwitch", 78, 79);
    aB = new ht("EventUploadFrequency", 79, 80);
    aC = new ht("PerfUploadFrequency", 80, 81);
    aD = new ht("BatteryCollectionSwitch", 81, 82);
    aE = new ht("BatteryCollectionFrequency", 82, 83);
    aF = new ht("AwakeInfoUploadWaySwitch", 83, 84);
    aG = new ht("AwakeAppPingSwitch", 84, 85);
    aH = new ht("AwakeAppPingFrequency", 85, 86);
    aI = new ht("StorageCollectionSwitch", 86, 87);
    aJ = new ht("StorageCollectionFrequency", 87, 88);
    aK = new ht("PopupDialogWhiteList", 88, 94);
    aL = new ht("PopupDialogContent", 89, 95);
    aM = new ht("PopupDialogSwitch", 90, 96);
    aN = new ht("FallDownTimeRange", 91, 97);
    aO = new ht("AppIsInstalledCollectionSwitch", 92, 98);
    aP = new ht("AppIsInstalledCollectionFrequency", 93, 99);
    aQ = new ht("AppIsInstalledList", 94, 100);
    aR = new ht("StatDataUploadFrequency", 95, 120);
    aS = new ht("StatDataUploadNum", 96, 121);
    aT = new ht("StatDataProcessFrequency", 97, 122);
    aU = new ht("StatDataSwitch", 98, 123);
    aV = new ht("StatDataUploadWay", 99, 124);
    aW = new ht("StatDataDeleteFrequency", 100, 125);
    aX = new ht("CollectionDataPluginVersion", 101, 1001);
    aY = new ht("CollectionPluginDownloadUrl", 102, 1002);
    aZ = new ht("CollectionPluginMd5", 103, 1003);
    ht localht = new ht("CollectionPluginForceStop", 104, 1004);
    ba = localht;
    jdField_a_of_type_ArrayOfComXiaomiPushHt = new ht[] { jdField_a_of_type_ComXiaomiPushHt, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an, ao, ap, aq, ar, as, at, au, av, aw, ax, ay, az, aA, aB, aC, aD, aE, aF, aG, aH, aI, aJ, aK, aL, aM, aN, aO, aP, aQ, aR, aS, aT, aU, aV, aW, aX, aY, aZ, localht };
  }
  
  private ht(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */