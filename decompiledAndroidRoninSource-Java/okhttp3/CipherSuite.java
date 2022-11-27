package okhttp3;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\006\030\000 \b2\0020\001:\001\bB\017\b\002\022\006\020\002\032\0020\003¢\006\002\020\004J\r\020\002\032\0020\003H\007¢\006\002\b\006J\b\020\007\032\0020\003H\026R\023\020\002\032\0020\0038\007¢\006\b\n\000\032\004\b\002\020\005¨\006\t"}, d2={"Lokhttp3/CipherSuite;", "", "javaName", "", "(Ljava/lang/String;)V", "()Ljava/lang/String;", "-deprecated_javaName", "toString", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class CipherSuite
{
  public static final Companion Companion = new Companion(null);
  private static final Map<String, CipherSuite> INSTANCES;
  private static final Comparator<String> ORDER_BY_NAME = (Comparator)new CipherSuite.Companion.ORDER_BY_NAME.1();
  public static final CipherSuite TLS_AES_128_CCM_8_SHA256 = Companion.access$init(Companion, "TLS_AES_128_CCM_8_SHA256", 4869);
  public static final CipherSuite TLS_AES_128_CCM_SHA256;
  public static final CipherSuite TLS_AES_128_GCM_SHA256;
  public static final CipherSuite TLS_AES_256_GCM_SHA384;
  public static final CipherSuite TLS_CHACHA20_POLY1305_SHA256;
  public static final CipherSuite TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA;
  public static final CipherSuite TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA;
  public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA;
  public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA256;
  public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_GCM_SHA256;
  public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA;
  public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA256;
  public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_GCM_SHA384;
  public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA;
  public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA;
  public static final CipherSuite TLS_DHE_DSS_WITH_DES_CBC_SHA;
  public static final CipherSuite TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA;
  public static final CipherSuite TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA;
  public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA;
  public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA256;
  public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_GCM_SHA256;
  public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA;
  public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA256;
  public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_GCM_SHA384;
  public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA;
  public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA;
  public static final CipherSuite TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
  public static final CipherSuite TLS_DHE_RSA_WITH_DES_CBC_SHA;
  public static final CipherSuite TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA;
  public static final CipherSuite TLS_DH_anon_EXPORT_WITH_RC4_40_MD5;
  public static final CipherSuite TLS_DH_anon_WITH_3DES_EDE_CBC_SHA;
  public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA;
  public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA256;
  public static final CipherSuite TLS_DH_anon_WITH_AES_128_GCM_SHA256;
  public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA;
  public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA256;
  public static final CipherSuite TLS_DH_anon_WITH_AES_256_GCM_SHA384;
  public static final CipherSuite TLS_DH_anon_WITH_DES_CBC_SHA;
  public static final CipherSuite TLS_DH_anon_WITH_RC4_128_MD5;
  public static final CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA;
  public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA;
  public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256;
  public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
  public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA;
  public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384;
  public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
  public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
  public static final CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA;
  public static final CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA;
  public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA;
  public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA;
  public static final CipherSuite TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256;
  public static final CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA;
  public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA;
  public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256;
  public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
  public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA;
  public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384;
  public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
  public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
  public static final CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA;
  public static final CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA;
  public static final CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA;
  public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA;
  public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256;
  public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256;
  public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA;
  public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384;
  public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384;
  public static final CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA;
  public static final CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA;
  public static final CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA;
  public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA;
  public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256;
  public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256;
  public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA;
  public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384;
  public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384;
  public static final CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA;
  public static final CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA;
  public static final CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA;
  public static final CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA;
  public static final CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA;
  public static final CipherSuite TLS_ECDH_anon_WITH_NULL_SHA;
  public static final CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA;
  public static final CipherSuite TLS_EMPTY_RENEGOTIATION_INFO_SCSV;
  public static final CipherSuite TLS_FALLBACK_SCSV;
  public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5;
  public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA;
  public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_MD5;
  public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_SHA;
  public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_MD5;
  public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_SHA;
  public static final CipherSuite TLS_KRB5_WITH_DES_CBC_MD5;
  public static final CipherSuite TLS_KRB5_WITH_DES_CBC_SHA;
  public static final CipherSuite TLS_KRB5_WITH_RC4_128_MD5;
  public static final CipherSuite TLS_KRB5_WITH_RC4_128_SHA;
  public static final CipherSuite TLS_PSK_WITH_3DES_EDE_CBC_SHA;
  public static final CipherSuite TLS_PSK_WITH_AES_128_CBC_SHA;
  public static final CipherSuite TLS_PSK_WITH_AES_256_CBC_SHA;
  public static final CipherSuite TLS_PSK_WITH_RC4_128_SHA;
  public static final CipherSuite TLS_RSA_EXPORT_WITH_DES40_CBC_SHA;
  public static final CipherSuite TLS_RSA_EXPORT_WITH_RC4_40_MD5;
  public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA;
  public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA;
  public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA256;
  public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256;
  public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA;
  public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA256;
  public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384;
  public static final CipherSuite TLS_RSA_WITH_CAMELLIA_128_CBC_SHA;
  public static final CipherSuite TLS_RSA_WITH_CAMELLIA_256_CBC_SHA;
  public static final CipherSuite TLS_RSA_WITH_DES_CBC_SHA;
  public static final CipherSuite TLS_RSA_WITH_NULL_MD5;
  public static final CipherSuite TLS_RSA_WITH_NULL_SHA;
  public static final CipherSuite TLS_RSA_WITH_NULL_SHA256;
  public static final CipherSuite TLS_RSA_WITH_RC4_128_MD5;
  public static final CipherSuite TLS_RSA_WITH_RC4_128_SHA;
  public static final CipherSuite TLS_RSA_WITH_SEED_CBC_SHA;
  private final String javaName;
  
  static
  {
    INSTANCES = (Map)new LinkedHashMap();
    TLS_RSA_WITH_NULL_MD5 = Companion.access$init(Companion, "SSL_RSA_WITH_NULL_MD5", 1);
    TLS_RSA_WITH_NULL_SHA = Companion.access$init(Companion, "SSL_RSA_WITH_NULL_SHA", 2);
    TLS_RSA_EXPORT_WITH_RC4_40_MD5 = Companion.access$init(Companion, "SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    TLS_RSA_WITH_RC4_128_MD5 = Companion.access$init(Companion, "SSL_RSA_WITH_RC4_128_MD5", 4);
    TLS_RSA_WITH_RC4_128_SHA = Companion.access$init(Companion, "SSL_RSA_WITH_RC4_128_SHA", 5);
    TLS_RSA_EXPORT_WITH_DES40_CBC_SHA = Companion.access$init(Companion, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    TLS_RSA_WITH_DES_CBC_SHA = Companion.access$init(Companion, "SSL_RSA_WITH_DES_CBC_SHA", 9);
    TLS_RSA_WITH_3DES_EDE_CBC_SHA = Companion.access$init(Companion, "SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = Companion.access$init(Companion, "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    TLS_DHE_DSS_WITH_DES_CBC_SHA = Companion.access$init(Companion, "SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA = Companion.access$init(Companion, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = Companion.access$init(Companion, "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    TLS_DHE_RSA_WITH_DES_CBC_SHA = Companion.access$init(Companion, "SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA = Companion.access$init(Companion, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    TLS_DH_anon_EXPORT_WITH_RC4_40_MD5 = Companion.access$init(Companion, "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    TLS_DH_anon_WITH_RC4_128_MD5 = Companion.access$init(Companion, "SSL_DH_anon_WITH_RC4_128_MD5", 24);
    TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA = Companion.access$init(Companion, "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    TLS_DH_anon_WITH_DES_CBC_SHA = Companion.access$init(Companion, "SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    TLS_DH_anon_WITH_3DES_EDE_CBC_SHA = Companion.access$init(Companion, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    TLS_KRB5_WITH_DES_CBC_SHA = Companion.access$init(Companion, "TLS_KRB5_WITH_DES_CBC_SHA", 30);
    TLS_KRB5_WITH_3DES_EDE_CBC_SHA = Companion.access$init(Companion, "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    TLS_KRB5_WITH_RC4_128_SHA = Companion.access$init(Companion, "TLS_KRB5_WITH_RC4_128_SHA", 32);
    TLS_KRB5_WITH_DES_CBC_MD5 = Companion.access$init(Companion, "TLS_KRB5_WITH_DES_CBC_MD5", 34);
    TLS_KRB5_WITH_3DES_EDE_CBC_MD5 = Companion.access$init(Companion, "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    TLS_KRB5_WITH_RC4_128_MD5 = Companion.access$init(Companion, "TLS_KRB5_WITH_RC4_128_MD5", 36);
    TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA = Companion.access$init(Companion, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    TLS_KRB5_EXPORT_WITH_RC4_40_SHA = Companion.access$init(Companion, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5 = Companion.access$init(Companion, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    TLS_KRB5_EXPORT_WITH_RC4_40_MD5 = Companion.access$init(Companion, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    TLS_RSA_WITH_AES_128_CBC_SHA = Companion.access$init(Companion, "TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    TLS_DHE_DSS_WITH_AES_128_CBC_SHA = Companion.access$init(Companion, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    TLS_DHE_RSA_WITH_AES_128_CBC_SHA = Companion.access$init(Companion, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    TLS_DH_anon_WITH_AES_128_CBC_SHA = Companion.access$init(Companion, "TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    TLS_RSA_WITH_AES_256_CBC_SHA = Companion.access$init(Companion, "TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    TLS_DHE_DSS_WITH_AES_256_CBC_SHA = Companion.access$init(Companion, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    TLS_DHE_RSA_WITH_AES_256_CBC_SHA = Companion.access$init(Companion, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    TLS_DH_anon_WITH_AES_256_CBC_SHA = Companion.access$init(Companion, "TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    TLS_RSA_WITH_NULL_SHA256 = Companion.access$init(Companion, "TLS_RSA_WITH_NULL_SHA256", 59);
    TLS_RSA_WITH_AES_128_CBC_SHA256 = Companion.access$init(Companion, "TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    TLS_RSA_WITH_AES_256_CBC_SHA256 = Companion.access$init(Companion, "TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    TLS_DHE_DSS_WITH_AES_128_CBC_SHA256 = Companion.access$init(Companion, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    TLS_RSA_WITH_CAMELLIA_128_CBC_SHA = Companion.access$init(Companion, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA = Companion.access$init(Companion, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA = Companion.access$init(Companion, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    TLS_DHE_RSA_WITH_AES_128_CBC_SHA256 = Companion.access$init(Companion, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 = Companion.access$init(Companion, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    TLS_DHE_RSA_WITH_AES_256_CBC_SHA256 = Companion.access$init(Companion, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    TLS_DH_anon_WITH_AES_128_CBC_SHA256 = Companion.access$init(Companion, "TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    TLS_DH_anon_WITH_AES_256_CBC_SHA256 = Companion.access$init(Companion, "TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    TLS_RSA_WITH_CAMELLIA_256_CBC_SHA = Companion.access$init(Companion, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA = Companion.access$init(Companion, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA = Companion.access$init(Companion, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    TLS_PSK_WITH_RC4_128_SHA = Companion.access$init(Companion, "TLS_PSK_WITH_RC4_128_SHA", 138);
    TLS_PSK_WITH_3DES_EDE_CBC_SHA = Companion.access$init(Companion, "TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    TLS_PSK_WITH_AES_128_CBC_SHA = Companion.access$init(Companion, "TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    TLS_PSK_WITH_AES_256_CBC_SHA = Companion.access$init(Companion, "TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    TLS_RSA_WITH_SEED_CBC_SHA = Companion.access$init(Companion, "TLS_RSA_WITH_SEED_CBC_SHA", 150);
    TLS_RSA_WITH_AES_128_GCM_SHA256 = Companion.access$init(Companion, "TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    TLS_RSA_WITH_AES_256_GCM_SHA384 = Companion.access$init(Companion, "TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 = Companion.access$init(Companion, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
    TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 = Companion.access$init(Companion, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 = Companion.access$init(Companion, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 = Companion.access$init(Companion, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    TLS_DH_anon_WITH_AES_128_GCM_SHA256 = Companion.access$init(Companion, "TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    TLS_DH_anon_WITH_AES_256_GCM_SHA384 = Companion.access$init(Companion, "TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    TLS_EMPTY_RENEGOTIATION_INFO_SCSV = Companion.access$init(Companion, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    TLS_FALLBACK_SCSV = Companion.access$init(Companion, "TLS_FALLBACK_SCSV", 22016);
    TLS_ECDH_ECDSA_WITH_NULL_SHA = Companion.access$init(Companion, "TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    TLS_ECDH_ECDSA_WITH_RC4_128_SHA = Companion.access$init(Companion, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = Companion.access$init(Companion, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = Companion.access$init(Companion, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = Companion.access$init(Companion, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    TLS_ECDHE_ECDSA_WITH_NULL_SHA = Companion.access$init(Companion, "TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = Companion.access$init(Companion, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = Companion.access$init(Companion, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = Companion.access$init(Companion, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = Companion.access$init(Companion, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    TLS_ECDH_RSA_WITH_NULL_SHA = Companion.access$init(Companion, "TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    TLS_ECDH_RSA_WITH_RC4_128_SHA = Companion.access$init(Companion, "TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = Companion.access$init(Companion, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = Companion.access$init(Companion, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = Companion.access$init(Companion, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    TLS_ECDHE_RSA_WITH_NULL_SHA = Companion.access$init(Companion, "TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    TLS_ECDHE_RSA_WITH_RC4_128_SHA = Companion.access$init(Companion, "TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = Companion.access$init(Companion, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = Companion.access$init(Companion, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = Companion.access$init(Companion, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    TLS_ECDH_anon_WITH_NULL_SHA = Companion.access$init(Companion, "TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    TLS_ECDH_anon_WITH_RC4_128_SHA = Companion.access$init(Companion, "TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = Companion.access$init(Companion, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    TLS_ECDH_anon_WITH_AES_128_CBC_SHA = Companion.access$init(Companion, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    TLS_ECDH_anon_WITH_AES_256_CBC_SHA = Companion.access$init(Companion, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 = Companion.access$init(Companion, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 = Companion.access$init(Companion, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 = Companion.access$init(Companion, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 = Companion.access$init(Companion, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 = Companion.access$init(Companion, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 = Companion.access$init(Companion, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 = Companion.access$init(Companion, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 = Companion.access$init(Companion, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = Companion.access$init(Companion, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = Companion.access$init(Companion, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 = Companion.access$init(Companion, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 = Companion.access$init(Companion, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = Companion.access$init(Companion, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = Companion.access$init(Companion, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 = Companion.access$init(Companion, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 = Companion.access$init(Companion, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA = Companion.access$init(Companion, "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA = Companion.access$init(Companion, "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.access$init(Companion, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.access$init(Companion, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.access$init(Companion, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
    TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256 = Companion.access$init(Companion, "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
    TLS_AES_128_GCM_SHA256 = Companion.access$init(Companion, "TLS_AES_128_GCM_SHA256", 4865);
    TLS_AES_256_GCM_SHA384 = Companion.access$init(Companion, "TLS_AES_256_GCM_SHA384", 4866);
    TLS_CHACHA20_POLY1305_SHA256 = Companion.access$init(Companion, "TLS_CHACHA20_POLY1305_SHA256", 4867);
    TLS_AES_128_CCM_SHA256 = Companion.access$init(Companion, "TLS_AES_128_CCM_SHA256", 4868);
  }
  
  private CipherSuite(String paramString)
  {
    this.javaName = paramString;
  }
  
  @JvmStatic
  public static final CipherSuite forJavaName(String paramString)
  {
    try
    {
      paramString = Companion.forJavaName(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="javaName", imports={}))
  public final String -deprecated_javaName()
  {
    return this.javaName;
  }
  
  public final String javaName()
  {
    return this.javaName;
  }
  
  public String toString()
  {
    return this.javaName;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000.\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020%\n\002\020\016\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b}\n\002\020\b\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\022\020\001\032\0020\0062\007\020\001\032\0020\005H\007J\034\020\001\032\0020\0062\007\020\001\032\0020\0052\b\020\001\032\0030\001H\002J\022\020\001\032\0020\0052\007\020\001\032\0020\005H\002R\032\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0060\004X\004¢\006\002\n\000R$\020\007\032\022\022\004\022\0020\0050\bj\b\022\004\022\0020\005`\tX\004¢\006\b\n\000\032\004\b\n\020\013R\020\020\f\032\0020\0068\006X\004¢\006\002\n\000R\020\020\r\032\0020\0068\006X\004¢\006\002\n\000R\020\020\016\032\0020\0068\006X\004¢\006\002\n\000R\020\020\017\032\0020\0068\006X\004¢\006\002\n\000R\020\020\020\032\0020\0068\006X\004¢\006\002\n\000R\020\020\021\032\0020\0068\006X\004¢\006\002\n\000R\020\020\022\032\0020\0068\006X\004¢\006\002\n\000R\020\020\023\032\0020\0068\006X\004¢\006\002\n\000R\020\020\024\032\0020\0068\006X\004¢\006\002\n\000R\020\020\025\032\0020\0068\006X\004¢\006\002\n\000R\020\020\026\032\0020\0068\006X\004¢\006\002\n\000R\020\020\027\032\0020\0068\006X\004¢\006\002\n\000R\020\020\030\032\0020\0068\006X\004¢\006\002\n\000R\020\020\031\032\0020\0068\006X\004¢\006\002\n\000R\020\020\032\032\0020\0068\006X\004¢\006\002\n\000R\020\020\033\032\0020\0068\006X\004¢\006\002\n\000R\020\020\034\032\0020\0068\006X\004¢\006\002\n\000R\020\020\035\032\0020\0068\006X\004¢\006\002\n\000R\020\020\036\032\0020\0068\006X\004¢\006\002\n\000R\020\020\037\032\0020\0068\006X\004¢\006\002\n\000R\020\020 \032\0020\0068\006X\004¢\006\002\n\000R\020\020!\032\0020\0068\006X\004¢\006\002\n\000R\020\020\"\032\0020\0068\006X\004¢\006\002\n\000R\020\020#\032\0020\0068\006X\004¢\006\002\n\000R\020\020$\032\0020\0068\006X\004¢\006\002\n\000R\020\020%\032\0020\0068\006X\004¢\006\002\n\000R\020\020&\032\0020\0068\006X\004¢\006\002\n\000R\020\020'\032\0020\0068\006X\004¢\006\002\n\000R\020\020(\032\0020\0068\006X\004¢\006\002\n\000R\020\020)\032\0020\0068\006X\004¢\006\002\n\000R\020\020*\032\0020\0068\006X\004¢\006\002\n\000R\020\020+\032\0020\0068\006X\004¢\006\002\n\000R\020\020,\032\0020\0068\006X\004¢\006\002\n\000R\020\020-\032\0020\0068\006X\004¢\006\002\n\000R\020\020.\032\0020\0068\006X\004¢\006\002\n\000R\020\020/\032\0020\0068\006X\004¢\006\002\n\000R\020\0200\032\0020\0068\006X\004¢\006\002\n\000R\020\0201\032\0020\0068\006X\004¢\006\002\n\000R\020\0202\032\0020\0068\006X\004¢\006\002\n\000R\020\0203\032\0020\0068\006X\004¢\006\002\n\000R\020\0204\032\0020\0068\006X\004¢\006\002\n\000R\020\0205\032\0020\0068\006X\004¢\006\002\n\000R\020\0206\032\0020\0068\006X\004¢\006\002\n\000R\020\0207\032\0020\0068\006X\004¢\006\002\n\000R\020\0208\032\0020\0068\006X\004¢\006\002\n\000R\020\0209\032\0020\0068\006X\004¢\006\002\n\000R\020\020:\032\0020\0068\006X\004¢\006\002\n\000R\020\020;\032\0020\0068\006X\004¢\006\002\n\000R\020\020<\032\0020\0068\006X\004¢\006\002\n\000R\020\020=\032\0020\0068\006X\004¢\006\002\n\000R\020\020>\032\0020\0068\006X\004¢\006\002\n\000R\020\020?\032\0020\0068\006X\004¢\006\002\n\000R\020\020@\032\0020\0068\006X\004¢\006\002\n\000R\020\020A\032\0020\0068\006X\004¢\006\002\n\000R\020\020B\032\0020\0068\006X\004¢\006\002\n\000R\020\020C\032\0020\0068\006X\004¢\006\002\n\000R\020\020D\032\0020\0068\006X\004¢\006\002\n\000R\020\020E\032\0020\0068\006X\004¢\006\002\n\000R\020\020F\032\0020\0068\006X\004¢\006\002\n\000R\020\020G\032\0020\0068\006X\004¢\006\002\n\000R\020\020H\032\0020\0068\006X\004¢\006\002\n\000R\020\020I\032\0020\0068\006X\004¢\006\002\n\000R\020\020J\032\0020\0068\006X\004¢\006\002\n\000R\020\020K\032\0020\0068\006X\004¢\006\002\n\000R\020\020L\032\0020\0068\006X\004¢\006\002\n\000R\020\020M\032\0020\0068\006X\004¢\006\002\n\000R\020\020N\032\0020\0068\006X\004¢\006\002\n\000R\020\020O\032\0020\0068\006X\004¢\006\002\n\000R\020\020P\032\0020\0068\006X\004¢\006\002\n\000R\020\020Q\032\0020\0068\006X\004¢\006\002\n\000R\020\020R\032\0020\0068\006X\004¢\006\002\n\000R\020\020S\032\0020\0068\006X\004¢\006\002\n\000R\020\020T\032\0020\0068\006X\004¢\006\002\n\000R\020\020U\032\0020\0068\006X\004¢\006\002\n\000R\020\020V\032\0020\0068\006X\004¢\006\002\n\000R\020\020W\032\0020\0068\006X\004¢\006\002\n\000R\020\020X\032\0020\0068\006X\004¢\006\002\n\000R\020\020Y\032\0020\0068\006X\004¢\006\002\n\000R\020\020Z\032\0020\0068\006X\004¢\006\002\n\000R\020\020[\032\0020\0068\006X\004¢\006\002\n\000R\020\020\\\032\0020\0068\006X\004¢\006\002\n\000R\020\020]\032\0020\0068\006X\004¢\006\002\n\000R\020\020^\032\0020\0068\006X\004¢\006\002\n\000R\020\020_\032\0020\0068\006X\004¢\006\002\n\000R\020\020`\032\0020\0068\006X\004¢\006\002\n\000R\020\020a\032\0020\0068\006X\004¢\006\002\n\000R\020\020b\032\0020\0068\006X\004¢\006\002\n\000R\020\020c\032\0020\0068\006X\004¢\006\002\n\000R\020\020d\032\0020\0068\006X\004¢\006\002\n\000R\020\020e\032\0020\0068\006X\004¢\006\002\n\000R\020\020f\032\0020\0068\006X\004¢\006\002\n\000R\020\020g\032\0020\0068\006X\004¢\006\002\n\000R\020\020h\032\0020\0068\006X\004¢\006\002\n\000R\020\020i\032\0020\0068\006X\004¢\006\002\n\000R\020\020j\032\0020\0068\006X\004¢\006\002\n\000R\020\020k\032\0020\0068\006X\004¢\006\002\n\000R\020\020l\032\0020\0068\006X\004¢\006\002\n\000R\020\020m\032\0020\0068\006X\004¢\006\002\n\000R\020\020n\032\0020\0068\006X\004¢\006\002\n\000R\020\020o\032\0020\0068\006X\004¢\006\002\n\000R\020\020p\032\0020\0068\006X\004¢\006\002\n\000R\020\020q\032\0020\0068\006X\004¢\006\002\n\000R\020\020r\032\0020\0068\006X\004¢\006\002\n\000R\020\020s\032\0020\0068\006X\004¢\006\002\n\000R\020\020t\032\0020\0068\006X\004¢\006\002\n\000R\020\020u\032\0020\0068\006X\004¢\006\002\n\000R\020\020v\032\0020\0068\006X\004¢\006\002\n\000R\020\020w\032\0020\0068\006X\004¢\006\002\n\000R\020\020x\032\0020\0068\006X\004¢\006\002\n\000R\020\020y\032\0020\0068\006X\004¢\006\002\n\000R\020\020z\032\0020\0068\006X\004¢\006\002\n\000R\020\020{\032\0020\0068\006X\004¢\006\002\n\000R\020\020|\032\0020\0068\006X\004¢\006\002\n\000R\020\020}\032\0020\0068\006X\004¢\006\002\n\000R\020\020~\032\0020\0068\006X\004¢\006\002\n\000R\020\020\032\0020\0068\006X\004¢\006\002\n\000R\021\020\001\032\0020\0068\006X\004¢\006\002\n\000R\021\020\001\032\0020\0068\006X\004¢\006\002\n\000R\021\020\001\032\0020\0068\006X\004¢\006\002\n\000¨\006\001"}, d2={"Lokhttp3/CipherSuite$Companion;", "", "()V", "INSTANCES", "", "", "Lokhttp3/CipherSuite;", "ORDER_BY_NAME", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getORDER_BY_NAME$okhttp", "()Ljava/util/Comparator;", "TLS_AES_128_CCM_8_SHA256", "TLS_AES_128_CCM_SHA256", "TLS_AES_128_GCM_SHA256", "TLS_AES_256_GCM_SHA384", "TLS_CHACHA20_POLY1305_SHA256", "TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", "TLS_DHE_DSS_WITH_DES_CBC_SHA", "TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_DHE_RSA_WITH_DES_CBC_SHA", "TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA", "TLS_DH_anon_EXPORT_WITH_RC4_40_MD5", "TLS_DH_anon_WITH_3DES_EDE_CBC_SHA", "TLS_DH_anon_WITH_AES_128_CBC_SHA", "TLS_DH_anon_WITH_AES_128_CBC_SHA256", "TLS_DH_anon_WITH_AES_128_GCM_SHA256", "TLS_DH_anon_WITH_AES_256_CBC_SHA", "TLS_DH_anon_WITH_AES_256_CBC_SHA256", "TLS_DH_anon_WITH_AES_256_GCM_SHA384", "TLS_DH_anon_WITH_DES_CBC_SHA", "TLS_DH_anon_WITH_RC4_128_MD5", "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_ECDSA_WITH_NULL_SHA", "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_NULL_SHA", "TLS_ECDHE_RSA_WITH_RC4_128_SHA", "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_ECDSA_WITH_NULL_SHA", "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_RSA_WITH_NULL_SHA", "TLS_ECDH_RSA_WITH_RC4_128_SHA", "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", "TLS_ECDH_anon_WITH_NULL_SHA", "TLS_ECDH_anon_WITH_RC4_128_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_FALLBACK_SCSV", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", "TLS_KRB5_WITH_DES_CBC_MD5", "TLS_KRB5_WITH_DES_CBC_SHA", "TLS_KRB5_WITH_RC4_128_MD5", "TLS_KRB5_WITH_RC4_128_SHA", "TLS_PSK_WITH_3DES_EDE_CBC_SHA", "TLS_PSK_WITH_AES_128_CBC_SHA", "TLS_PSK_WITH_AES_256_CBC_SHA", "TLS_PSK_WITH_RC4_128_SHA", "TLS_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_RSA_EXPORT_WITH_RC4_40_MD5", "TLS_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA256", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", "TLS_RSA_WITH_DES_CBC_SHA", "TLS_RSA_WITH_NULL_MD5", "TLS_RSA_WITH_NULL_SHA", "TLS_RSA_WITH_NULL_SHA256", "TLS_RSA_WITH_RC4_128_MD5", "TLS_RSA_WITH_RC4_128_SHA", "TLS_RSA_WITH_SEED_CBC_SHA", "forJavaName", "javaName", "init", "value", "", "secondaryName", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    private final CipherSuite init(String paramString, int paramInt)
    {
      CipherSuite localCipherSuite = new CipherSuite(paramString, null);
      CipherSuite.access$getINSTANCES$cp().put(paramString, localCipherSuite);
      return localCipherSuite;
    }
    
    private final String secondaryName(String paramString)
    {
      StringBuilder localStringBuilder;
      if (StringsKt.startsWith$default(paramString, "TLS_", false, 2, null))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("SSL_");
        if (paramString != null)
        {
          paramString = paramString.substring(4);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
          localStringBuilder.append(paramString);
          return localStringBuilder.toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      if (StringsKt.startsWith$default(paramString, "SSL_", false, 2, null))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("TLS_");
        if (paramString != null)
        {
          paramString = paramString.substring(4);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
          localStringBuilder.append(paramString);
          return localStringBuilder.toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      return paramString;
    }
    
    @JvmStatic
    public final CipherSuite forJavaName(String paramString)
    {
      try
      {
        Intrinsics.checkParameterIsNotNull(paramString, "javaName");
        CipherSuite localCipherSuite2 = (CipherSuite)CipherSuite.access$getINSTANCES$cp().get(paramString);
        CipherSuite localCipherSuite1 = localCipherSuite2;
        if (localCipherSuite2 == null)
        {
          localCipherSuite2 = (CipherSuite)CipherSuite.access$getINSTANCES$cp().get(((Companion)this).secondaryName(paramString));
          localCipherSuite1 = localCipherSuite2;
          if (localCipherSuite2 == null) {
            localCipherSuite1 = new CipherSuite(paramString, null);
          }
          CipherSuite.access$getINSTANCES$cp().put(paramString, localCipherSuite1);
        }
        return localCipherSuite1;
      }
      finally {}
    }
    
    public final Comparator<String> getORDER_BY_NAME$okhttp()
    {
      return CipherSuite.access$getORDER_BY_NAME$cp();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\CipherSuite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */