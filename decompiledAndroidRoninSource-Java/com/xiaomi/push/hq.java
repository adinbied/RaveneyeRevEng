package com.xiaomi.push;

public enum hq
{
  private final int jdField_a_of_type_Int;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushHq = new hq("DeviceInfo", 0, 1);
    b = new hq("AppInstallList", 1, 2);
    c = new hq("AppActiveList", 2, 3);
    d = new hq("Bluetooth", 3, 4);
    e = new hq("Location", 4, 5);
    f = new hq("Account", 5, 6);
    g = new hq("WIFI", 6, 7);
    h = new hq("Cellular", 7, 8);
    i = new hq("TopApp", 8, 9);
    j = new hq("BroadcastAction", 9, 10);
    k = new hq("BroadcastActionAdded", 10, 11);
    l = new hq("BroadcastActionRemoved", 11, 12);
    m = new hq("BroadcastActionReplaced", 12, 13);
    n = new hq("BroadcastActionDataCleared", 13, 14);
    o = new hq("BroadcastActionRestarted", 14, 15);
    p = new hq("BroadcastActionChanged", 15, 16);
    q = new hq("AppPermission", 16, 17);
    r = new hq("WifiDevicesMac", 17, 18);
    s = new hq("ActivityActiveTimeStamp", 18, 19);
    t = new hq("DeviceBaseInfo", 19, 20);
    u = new hq("DeviceInfoV2", 20, 21);
    v = new hq("Battery", 21, 22);
    w = new hq("Storage", 22, 23);
    hq localhq = new hq("AppIsInstalled", 23, 24);
    x = localhq;
    jdField_a_of_type_ArrayOfComXiaomiPushHq = new hq[] { jdField_a_of_type_ComXiaomiPushHq, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, localhq };
  }
  
  private hq(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static hq a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 23: 
      return w;
    case 22: 
      return v;
    case 21: 
      return u;
    case 20: 
      return t;
    case 19: 
      return s;
    case 18: 
      return r;
    case 17: 
      return q;
    case 16: 
      return p;
    case 15: 
      return o;
    case 14: 
      return n;
    case 13: 
      return m;
    case 12: 
      return l;
    case 11: 
      return k;
    case 10: 
      return j;
    case 9: 
      return i;
    case 8: 
      return h;
    case 7: 
      return g;
    case 6: 
      return f;
    case 5: 
      return e;
    case 4: 
      return d;
    case 3: 
      return c;
    case 2: 
      return b;
    }
    return jdField_a_of_type_ComXiaomiPushHq;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\hq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */