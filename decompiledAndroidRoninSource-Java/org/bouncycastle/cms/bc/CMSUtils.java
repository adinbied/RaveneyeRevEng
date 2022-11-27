package org.bouncycastle.cms.bc;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.operator.GenericKey;

class CMSUtils
{
  static CipherParameters getBcKey(GenericKey paramGenericKey)
  {
    if ((paramGenericKey.getRepresentation() instanceof CipherParameters)) {
      return (CipherParameters)paramGenericKey.getRepresentation();
    }
    if ((paramGenericKey.getRepresentation() instanceof byte[])) {
      return new KeyParameter((byte[])paramGenericKey.getRepresentation());
    }
    throw new IllegalArgumentException("unknown generic key type");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\bc\CMSUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */