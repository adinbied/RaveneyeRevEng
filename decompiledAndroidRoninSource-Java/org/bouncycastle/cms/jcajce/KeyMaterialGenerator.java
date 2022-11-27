package org.bouncycastle.cms.jcajce;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

abstract interface KeyMaterialGenerator
{
  public abstract byte[] generateKDFMaterial(AlgorithmIdentifier paramAlgorithmIdentifier, int paramInt, byte[] paramArrayOfByte);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\KeyMaterialGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */