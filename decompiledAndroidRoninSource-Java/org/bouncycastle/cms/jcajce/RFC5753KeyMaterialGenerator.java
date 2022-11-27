package org.bouncycastle.cms.jcajce;

import java.io.IOException;
import org.bouncycastle.asn1.cms.ecc.ECCCMSSharedInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Pack;

class RFC5753KeyMaterialGenerator
  implements KeyMaterialGenerator
{
  public byte[] generateKDFMaterial(AlgorithmIdentifier paramAlgorithmIdentifier, int paramInt, byte[] paramArrayOfByte)
  {
    paramAlgorithmIdentifier = new ECCCMSSharedInfo(paramAlgorithmIdentifier, paramArrayOfByte, Pack.intToBigEndian(paramInt));
    try
    {
      paramAlgorithmIdentifier = paramAlgorithmIdentifier.getEncoded("DER");
      return paramAlgorithmIdentifier;
    }
    catch (IOException paramAlgorithmIdentifier)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Unable to create KDF material: ");
      paramArrayOfByte.append(paramAlgorithmIdentifier);
      throw new IllegalStateException(paramArrayOfByte.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\RFC5753KeyMaterialGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */