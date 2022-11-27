package com.xiaomi.push;

public enum ho
{
  private final int jdField_a_of_type_Int;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushHo = new ho("Registration", 0, 1);
    b = new ho("UnRegistration", 1, 2);
    c = new ho("Subscription", 2, 3);
    d = new ho("UnSubscription", 3, 4);
    e = new ho("SendMessage", 4, 5);
    f = new ho("AckMessage", 5, 6);
    g = new ho("SetConfig", 6, 7);
    h = new ho("ReportFeedback", 7, 8);
    i = new ho("Notification", 8, 9);
    j = new ho("Command", 9, 10);
    k = new ho("MultiConnectionBroadcast", 10, 11);
    l = new ho("MultiConnectionResult", 11, 12);
    m = new ho("ConnectionKick", 12, 13);
    n = new ho("ApnsMessage", 13, 14);
    o = new ho("IOSDeviceTokenWrite", 14, 15);
    p = new ho("SaveInvalidRegId", 15, 16);
    q = new ho("ApnsCertChanged", 16, 17);
    r = new ho("RegisterDevice", 17, 18);
    s = new ho("ExpandTopicInXmq", 18, 19);
    t = new ho("SendMessageNew", 19, 22);
    u = new ho("ExpandTopicInXmqNew", 20, 23);
    v = new ho("DeleteInvalidMessage", 21, 24);
    w = new ho("BadAction", 22, 99);
    x = new ho("Presence", 23, 100);
    y = new ho("FetchOfflineMessage", 24, 101);
    z = new ho("SaveJob", 25, 102);
    A = new ho("Broadcast", 26, 103);
    B = new ho("BatchPresence", 27, 104);
    C = new ho("BatchMessage", 28, 105);
    D = new ho("StatCounter", 29, 107);
    E = new ho("FetchTopicMessage", 30, 108);
    F = new ho("DeleteAliasCache", 31, 109);
    G = new ho("UpdateRegistration", 32, 110);
    H = new ho("BatchMessageNew", 33, 112);
    I = new ho("PublicWelfareMessage", 34, 113);
    J = new ho("RevokeMessage", 35, 114);
    ho localho = new ho("SimulatorJob", 36, 200);
    K = localho;
    jdField_a_of_type_ArrayOfComXiaomiPushHo = new ho[] { jdField_a_of_type_ComXiaomiPushHo, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, localho };
  }
  
  private ho(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static ho a(int paramInt)
  {
    if (paramInt != 200)
    {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                return null;
              case 114: 
                return J;
              case 113: 
                return I;
              }
              return H;
            case 110: 
              return G;
            case 109: 
              return F;
            case 108: 
              return E;
            }
            return D;
          case 105: 
            return C;
          case 104: 
            return B;
          case 103: 
            return A;
          case 102: 
            return z;
          case 101: 
            return y;
          case 100: 
            return x;
          }
          return w;
        case 24: 
          return v;
        case 23: 
          return u;
        }
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
      return jdField_a_of_type_ComXiaomiPushHo;
    }
    return K;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */