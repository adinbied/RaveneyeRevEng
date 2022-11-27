package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.util.Strings;

public class DESUtil
{
  private static final Set<String> des;
  
  static
  {
    HashSet localHashSet = new HashSet();
    des = localHashSet;
    localHashSet.add("DES");
    des.add("DESEDE");
    des.add(OIWObjectIdentifiers.desCBC.getId());
    des.add(PKCSObjectIdentifiers.des_EDE3_CBC.getId());
    des.add(PKCSObjectIdentifiers.des_EDE3_CBC.getId());
    des.add(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId());
  }
  
  public static boolean isDES(String paramString)
  {
    paramString = Strings.toUpperCase(paramString);
    return des.contains(paramString);
  }
  
  public static void setOddParity(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      paramArrayOfByte[i] = ((byte)((j >> 7 ^ j >> 1 ^ j >> 2 ^ j >> 3 ^ j >> 4 ^ j >> 5 ^ j >> 6 ^ 0x1) & 0x1 | j & 0xFE));
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetri\\util\DESUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */