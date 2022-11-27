package com.xiaomi.push;

public enum fj
{
  private final int jdField_a_of_type_Int;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushFj = new fj("TCP_CONN_FAIL", 0, 1);
    b = new fj("TCP_CONN_TIME", 1, 2);
    c = new fj("PING_RTT", 2, 3);
    d = new fj("CHANNEL_CON_FAIL", 3, 4);
    e = new fj("CHANNEL_CON_OK", 4, 5);
    f = new fj("ICMP_PING_FAIL", 5, 6);
    g = new fj("ICMP_PING_OK", 6, 7);
    h = new fj("CHANNEL_ONLINE_RATE", 7, 8);
    i = new fj("GSLB_REQUEST_SUCCESS", 8, 10000);
    j = new fj("GSLB_TCP_NOACCESS", 9, 10101);
    k = new fj("GSLB_TCP_NETUNREACH", 10, 10102);
    l = new fj("GSLB_TCP_CONNREFUSED", 11, 10103);
    m = new fj("GSLB_TCP_NOROUTETOHOST", 12, 10104);
    n = new fj("GSLB_TCP_TIMEOUT", 13, 10105);
    o = new fj("GSLB_TCP_INVALARG", 14, 10106);
    p = new fj("GSLB_TCP_UKNOWNHOST", 15, 10107);
    q = new fj("GSLB_TCP_ERR_OTHER", 16, 10199);
    r = new fj("GSLB_ERR", 17, 10999);
    s = new fj("CONN_SUCCESS", 18, 20000);
    t = new fj("CONN_TCP_NOACCESS", 19, 20101);
    u = new fj("CONN_TCP_NETUNREACH", 20, 20102);
    v = new fj("CONN_TCP_CONNREFUSED", 21, 20103);
    w = new fj("CONN_TCP_NOROUTETOHOST", 22, 20104);
    x = new fj("CONN_TCP_TIMEOUT", 23, 20105);
    y = new fj("CONN_TCP_INVALARG", 24, 20106);
    z = new fj("CONN_TCP_UKNOWNHOST", 25, 20107);
    A = new fj("CONN_TCP_ERR_OTHER", 26, 20199);
    B = new fj("CONN_XMPP_ERR", 27, 20399);
    C = new fj("CONN_BOSH_UNKNOWNHOST", 28, 20407);
    D = new fj("CONN_BOSH_ERR", 29, 20499);
    E = new fj("BIND_SUCCESS", 30, 30000);
    F = new fj("BIND_TCP_READ_TIMEOUT_DEPRECTED", 31, 30101);
    G = new fj("BIND_TCP_CONNRESET_DEPRECTED", 32, 30102);
    H = new fj("BIND_TCP_BROKEN_PIPE_DEPRECTED", 33, 30103);
    I = new fj("BIND_TCP_READ_TIMEOUT", 34, 30108);
    J = new fj("BIND_TCP_CONNRESET", 35, 30109);
    K = new fj("BIND_TCP_BROKEN_PIPE", 36, 30110);
    L = new fj("BIND_TCP_ERR", 37, 30199);
    M = new fj("BIND_XMPP_ERR", 38, 30399);
    N = new fj("BIND_BOSH_ITEM_NOT_FOUND", 39, 30401);
    O = new fj("BIND_BOSH_ERR", 40, 30499);
    P = new fj("BIND_TIMEOUT", 41, 30501);
    Q = new fj("BIND_INVALID_SIG", 42, 30502);
    R = new fj("CHANNEL_TCP_READTIMEOUT_DEPRECTED", 43, 40101);
    S = new fj("CHANNEL_TCP_CONNRESET_DEPRECTED", 44, 40102);
    T = new fj("CHANNEL_TCP_BROKEN_PIPE_DEPRECTED", 45, 40103);
    U = new fj("CHANNEL_TCP_READTIMEOUT", 46, 40108);
    V = new fj("CHANNEL_TCP_CONNRESET", 47, 40109);
    W = new fj("CHANNEL_TCP_BROKEN_PIPE", 48, 40110);
    X = new fj("CHANNEL_TCP_ERR", 49, 40199);
    Y = new fj("CHANNEL_XMPPEXCEPTION", 50, 40399);
    Z = new fj("CHANNEL_BOSH_ITEMNOTFIND", 51, 40401);
    aa = new fj("CHANNEL_BOSH_EXCEPTION", 52, 40499);
    ab = new fj("CHANNEL_TIMER_DELAYED", 53, 50001);
    fj localfj = new fj("CHANNEL_STATS_COUNTER", 54, 8000);
    ac = localfj;
    jdField_a_of_type_ArrayOfComXiaomiPushFj = new fj[] { jdField_a_of_type_ComXiaomiPushFj, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, localfj };
  }
  
  private fj(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static fj a(int paramInt)
  {
    if (paramInt != 30501)
    {
      if (paramInt != 30502)
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
                      case 40110: 
                        return W;
                      case 40109: 
                        return V;
                      }
                      return U;
                    case 40103: 
                      return T;
                    case 40102: 
                      return S;
                    }
                    return R;
                  case 30110: 
                    return K;
                  case 30109: 
                    return J;
                  }
                  return I;
                case 30103: 
                  return H;
                case 30102: 
                  return G;
                }
                return F;
              case 20107: 
                return z;
              case 20106: 
                return y;
              case 20105: 
                return x;
              case 20104: 
                return w;
              case 20103: 
                return v;
              case 20102: 
                return u;
              }
              return t;
            case 10107: 
              return p;
            case 10106: 
              return o;
            case 10105: 
              return n;
            case 10104: 
              return m;
            case 10103: 
              return l;
            case 10102: 
              return k;
            }
            return j;
          case 50001: 
            return ab;
          case 40499: 
            return aa;
          case 40401: 
            return Z;
          case 40399: 
            return Y;
          case 40199: 
            return X;
          case 30499: 
            return O;
          case 30401: 
            return N;
          case 30399: 
            return M;
          case 30199: 
            return L;
          case 30000: 
            return E;
          case 20499: 
            return D;
          case 20407: 
            return C;
          case 20399: 
            return B;
          case 20199: 
            return A;
          case 20000: 
            return s;
          case 10999: 
            return r;
          case 10199: 
            return q;
          case 10000: 
            return i;
          }
          return ac;
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
        return jdField_a_of_type_ComXiaomiPushFj;
      }
      return Q;
    }
    return P;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\fj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */