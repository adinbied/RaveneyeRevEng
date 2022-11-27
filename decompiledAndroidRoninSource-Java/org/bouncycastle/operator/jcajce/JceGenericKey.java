package org.bouncycastle.operator.jcajce;

import java.security.Key;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.GenericKey;

public class JceGenericKey
  extends GenericKey
{
  public JceGenericKey(AlgorithmIdentifier paramAlgorithmIdentifier, Key paramKey)
  {
    super(paramAlgorithmIdentifier, getRepresentation(paramKey));
  }
  
  private static Object getRepresentation(Key paramKey)
  {
    byte[] arrayOfByte = paramKey.getEncoded();
    if (arrayOfByte != null) {
      return arrayOfByte;
    }
    return paramKey;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\jcajce\JceGenericKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */