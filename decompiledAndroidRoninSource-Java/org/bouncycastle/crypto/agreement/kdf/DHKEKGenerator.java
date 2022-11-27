package org.bouncycastle.crypto.agreement.kdf;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Pack;

public class DHKEKGenerator
  implements DerivationFunction
{
  private ASN1ObjectIdentifier algorithm;
  private final Digest digest;
  private int keySize;
  private byte[] partyAInfo;
  private byte[] z;
  
  public DHKEKGenerator(Digest paramDigest)
  {
    this.digest = paramDigest;
  }
  
  public int generateBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataLengthException, IllegalArgumentException
  {
    int i = paramInt2;
    paramInt2 = paramArrayOfByte.length;
    int j = paramInt1;
    if (paramInt2 - i >= j)
    {
      long l1 = i;
      int k = this.digest.getDigestSize();
      if (l1 <= 8589934591L)
      {
        long l2 = k;
        int m = (int)((l1 + l2 - 1L) / l2);
        Object localObject1 = new byte[this.digest.getDigestSize()];
        paramInt1 = 0;
        paramInt2 = 1;
        while (paramInt1 < m)
        {
          Object localObject2 = this.digest;
          Object localObject3 = this.z;
          ((Digest)localObject2).update((byte[])localObject3, 0, localObject3.length);
          localObject2 = new ASN1EncodableVector();
          localObject3 = new ASN1EncodableVector();
          ((ASN1EncodableVector)localObject3).add(this.algorithm);
          ((ASN1EncodableVector)localObject3).add(new DEROctetString(Pack.intToBigEndian(paramInt2)));
          ((ASN1EncodableVector)localObject2).add(new DERSequence((ASN1EncodableVector)localObject3));
          localObject3 = this.partyAInfo;
          if (localObject3 != null) {
            ((ASN1EncodableVector)localObject2).add(new DERTaggedObject(true, 0, new DEROctetString((byte[])localObject3)));
          }
          ((ASN1EncodableVector)localObject2).add(new DERTaggedObject(true, 2, new DEROctetString(Pack.intToBigEndian(this.keySize))));
          try
          {
            localObject2 = new DERSequence((ASN1EncodableVector)localObject2).getEncoded("DER");
            this.digest.update((byte[])localObject2, 0, localObject2.length);
            this.digest.doFinal((byte[])localObject1, 0);
            if (i > k)
            {
              System.arraycopy(localObject1, 0, paramArrayOfByte, j, k);
              j += k;
              i -= k;
            }
            else
            {
              System.arraycopy(localObject1, 0, paramArrayOfByte, j, i);
            }
            paramInt2 += 1;
            paramInt1 += 1;
          }
          catch (IOException paramArrayOfByte)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("unable to encode parameter info: ");
            ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
            throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
          }
        }
        this.digest.reset();
        return (int)l1;
      }
      throw new IllegalArgumentException("Output length too large");
    }
    throw new DataLengthException("output buffer too small");
  }
  
  public Digest getDigest()
  {
    return this.digest;
  }
  
  public void init(DerivationParameters paramDerivationParameters)
  {
    paramDerivationParameters = (DHKDFParameters)paramDerivationParameters;
    this.algorithm = paramDerivationParameters.getAlgorithm();
    this.keySize = paramDerivationParameters.getKeySize();
    this.z = paramDerivationParameters.getZ();
    this.partyAInfo = paramDerivationParameters.getExtraInfo();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\kdf\DHKEKGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */