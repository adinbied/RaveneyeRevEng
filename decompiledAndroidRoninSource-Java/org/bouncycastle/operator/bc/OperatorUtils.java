package org.bouncycastle.operator.bc;

import java.security.Key;
import org.bouncycastle.operator.GenericKey;

class OperatorUtils
{
  static byte[] getKeyBytes(GenericKey paramGenericKey)
  {
    if ((paramGenericKey.getRepresentation() instanceof Key)) {
      return ((Key)paramGenericKey.getRepresentation()).getEncoded();
    }
    if ((paramGenericKey.getRepresentation() instanceof byte[])) {
      return (byte[])paramGenericKey.getRepresentation();
    }
    throw new IllegalArgumentException("unknown generic key type");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\OperatorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */