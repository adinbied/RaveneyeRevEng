package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class WOTSPlusOid
  implements XMSSOid
{
  private static final Map<String, WOTSPlusOid> oidLookupTable;
  private final int oid;
  private final String stringRepresentation;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(createKey("SHA-256", 32, 16, 67), new WOTSPlusOid(16777217, "WOTSP_SHA2-256_W16"));
    localHashMap.put(createKey("SHA-512", 64, 16, 131), new WOTSPlusOid(33554434, "WOTSP_SHA2-512_W16"));
    localHashMap.put(createKey("SHAKE128", 32, 16, 67), new WOTSPlusOid(50331651, "WOTSP_SHAKE128_W16"));
    localHashMap.put(createKey("SHAKE256", 64, 16, 131), new WOTSPlusOid(67108868, "WOTSP_SHAKE256_W16"));
    oidLookupTable = Collections.unmodifiableMap(localHashMap);
  }
  
  private WOTSPlusOid(int paramInt, String paramString)
  {
    this.oid = paramInt;
    this.stringRepresentation = paramString;
  }
  
  private static String createKey(String paramString, int paramInt1, int paramInt2, int paramInt3)
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
      return localStringBuilder.toString();
    }
    throw new NullPointerException("algorithmName == null");
  }
  
  protected static WOTSPlusOid lookup(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramString != null) {
      return (WOTSPlusOid)oidLookupTable.get(createKey(paramString, paramInt1, paramInt2, paramInt3));
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\WOTSPlusOid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */