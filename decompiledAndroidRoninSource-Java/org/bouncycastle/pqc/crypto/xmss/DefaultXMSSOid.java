package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DefaultXMSSOid
  implements XMSSOid
{
  private static final Map<String, DefaultXMSSOid> oidLookupTable;
  private final int oid;
  private final String stringRepresentation;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(createKey("SHA-256", 32, 16, 67, 10), new DefaultXMSSOid(16777217, "XMSS_SHA2-256_W16_H10"));
    localHashMap.put(createKey("SHA-256", 32, 16, 67, 16), new DefaultXMSSOid(33554434, "XMSS_SHA2-256_W16_H16"));
    localHashMap.put(createKey("SHA-256", 32, 16, 67, 20), new DefaultXMSSOid(50331651, "XMSS_SHA2-256_W16_H20"));
    localHashMap.put(createKey("SHA-512", 64, 16, 131, 10), new DefaultXMSSOid(67108868, "XMSS_SHA2-512_W16_H10"));
    localHashMap.put(createKey("SHA-512", 64, 16, 131, 16), new DefaultXMSSOid(83886085, "XMSS_SHA2-512_W16_H16"));
    localHashMap.put(createKey("SHA-512", 64, 16, 131, 20), new DefaultXMSSOid(100663302, "XMSS_SHA2-512_W16_H20"));
    localHashMap.put(createKey("SHAKE128", 32, 16, 67, 10), new DefaultXMSSOid(117440519, "XMSS_SHAKE128_W16_H10"));
    localHashMap.put(createKey("SHAKE128", 32, 16, 67, 16), new DefaultXMSSOid(134217736, "XMSS_SHAKE128_W16_H16"));
    localHashMap.put(createKey("SHAKE128", 32, 16, 67, 20), new DefaultXMSSOid(150994953, "XMSS_SHAKE128_W16_H20"));
    localHashMap.put(createKey("SHAKE256", 64, 16, 131, 10), new DefaultXMSSOid(167772170, "XMSS_SHAKE256_W16_H10"));
    localHashMap.put(createKey("SHAKE256", 64, 16, 131, 16), new DefaultXMSSOid(184549387, "XMSS_SHAKE256_W16_H16"));
    localHashMap.put(createKey("SHAKE256", 64, 16, 131, 20), new DefaultXMSSOid(201326604, "XMSS_SHAKE256_W16_H20"));
    oidLookupTable = Collections.unmodifiableMap(localHashMap);
  }
  
  private DefaultXMSSOid(int paramInt, String paramString)
  {
    this.oid = paramInt;
    this.stringRepresentation = paramString;
  }
  
  private static String createKey(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt4);
      return localStringBuilder.toString();
    }
    throw new NullPointerException("algorithmName == null");
  }
  
  public static DefaultXMSSOid lookup(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramString != null) {
      return (DefaultXMSSOid)oidLookupTable.get(createKey(paramString, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    throw new NullPointerException("algorithmName == null");
  }
  
  public int getOid()
  {
    return this.oid;
  }
  
  public String toString()
  {
    return this.stringRepresentation;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\DefaultXMSSOid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */