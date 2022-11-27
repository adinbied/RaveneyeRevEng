package org.bouncycastle.crypto.tls;

public class AlertDescription
{
  public static final short access_denied = 49;
  public static final short bad_certificate = 42;
  public static final short bad_certificate_hash_value = 114;
  public static final short bad_certificate_status_response = 113;
  public static final short bad_record_mac = 20;
  public static final short certificate_expired = 45;
  public static final short certificate_revoked = 44;
  public static final short certificate_unknown = 46;
  public static final short certificate_unobtainable = 111;
  public static final short close_notify = 0;
  public static final short decode_error = 50;
  public static final short decompression_failure = 30;
  public static final short decrypt_error = 51;
  public static final short decryption_failed = 21;
  public static final short export_restriction = 60;
  public static final short handshake_failure = 40;
  public static final short illegal_parameter = 47;
  public static final short inappropriate_fallback = 86;
  public static final short insufficient_security = 71;
  public static final short internal_error = 80;
  public static final short no_certificate = 41;
  public static final short no_renegotiation = 100;
  public static final short protocol_version = 70;
  public static final short record_overflow = 22;
  public static final short unexpected_message = 10;
  public static final short unknown_ca = 48;
  public static final short unknown_psk_identity = 115;
  public static final short unrecognized_name = 112;
  public static final short unsupported_certificate = 43;
  public static final short unsupported_extension = 110;
  public static final short user_canceled = 90;
  
  public static String getName(short paramShort)
  {
    if (paramShort != 0)
    {
      if (paramShort != 10)
      {
        if (paramShort != 30)
        {
          if (paramShort != 60)
          {
            if (paramShort != 80)
            {
              if (paramShort != 86)
              {
                if (paramShort != 90)
                {
                  if (paramShort != 100)
                  {
                    if (paramShort != 70)
                    {
                      if (paramShort != 71)
                      {
                        switch (paramShort)
                        {
                        default: 
                          switch (paramShort)
                          {
                          default: 
                            switch (paramShort)
                            {
                            default: 
                              return "UNKNOWN";
                            case 115: 
                              return "unknown_psk_identity";
                            case 114: 
                              return "bad_certificate_hash_value";
                            case 113: 
                              return "bad_certificate_status_response";
                            case 112: 
                              return "unrecognized_name";
                            case 111: 
                              return "certificate_unobtainable";
                            }
                            return "unsupported_extension";
                          case 51: 
                            return "decrypt_error";
                          case 50: 
                            return "decode_error";
                          case 49: 
                            return "access_denied";
                          case 48: 
                            return "unknown_ca";
                          case 47: 
                            return "illegal_parameter";
                          case 46: 
                            return "certificate_unknown";
                          case 45: 
                            return "certificate_expired";
                          case 44: 
                            return "certificate_revoked";
                          case 43: 
                            return "unsupported_certificate";
                          case 42: 
                            return "bad_certificate";
                          case 41: 
                            return "no_certificate";
                          }
                          return "handshake_failure";
                        case 22: 
                          return "record_overflow";
                        case 21: 
                          return "decryption_failed";
                        }
                        return "bad_record_mac";
                      }
                      return "insufficient_security";
                    }
                    return "protocol_version";
                  }
                  return "no_renegotiation";
                }
                return "user_canceled";
              }
              return "inappropriate_fallback";
            }
            return "internal_error";
          }
          return "export_restriction";
        }
        return "decompression_failure";
      }
      return "unexpected_message";
    }
    return "close_notify";
  }
  
  public static String getText(short paramShort)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getName(paramShort));
    localStringBuilder.append("(");
    localStringBuilder.append(paramShort);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\AlertDescription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */