package org.bouncycastle.operator.jcajce;

import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.operator.GenericKey;

class OperatorUtils
{
  static Key getJceKey(GenericKey paramGenericKey)
  {
    if ((paramGenericKey.getRepresentation() instanceof Key)) {
      return (Key)paramGenericKey.getRepresentation();
    }
    if ((paramGenericKey.getRepresentation() instanceof byte[])) {
      return new SecretKeySpec((byte[])paramGenericKey.getRepresentation(), "ENC");
    }
    throw new IllegalArgumentException("unknown generic key type");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\jcajce\OperatorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */