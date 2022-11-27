package org.bouncycastle.crypto.agreement.kdf;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.DigestDerivationFunction;
import org.bouncycastle.crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.util.Pack;

public class ECDHKEKGenerator
  implements DigestDerivationFunction
{
  private ASN1ObjectIdentifier algorithm;
  private DigestDerivationFunction kdf;
  private int keySize;
  private byte[] z;
  
  public ECDHKEKGenerator(Digest paramDigest)
  {
    this.kdf = new KDF2BytesGenerator(paramDigest);
  }
  
  public int generateBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataLengthException, IllegalArgumentException
  {
    Object localObject = new ASN1EncodableVector();
    ((ASN1EncodableVector)localObject).add(new AlgorithmIdentifier(this.algorithm, DERNull.INSTANCE));
    ((ASN1EncodableVector)localObject).add(new DERTaggedObject(true, 2, new DEROctetString(Pack.intToBigEndian(this.keySize))));
    try
    {
      this.kdf.init(new KDFParameters(this.z, new DERSequence((ASN1EncodableVector)localObject).getEncoded("DER")));
      return this.kdf.generateBytes(paramArrayOfByte, paramInt1, paramInt2);
    }
    catch (IOException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to initialise kdf: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
  }
  
  public Digest getDigest()
  {
    return this.kdf.getDigest();
  }
  
  public void init(DerivationParameters paramDerivationParameters)
  {
    paramDerivationParameters = (DHKDFParameters)paramDerivationParameters;
    this.algorithm = paramDerivationParameters.getAlgorithm();
    this.keySize = paramDerivationParameters.getKeySize();
    this.z = paramDerivationParameters.getZ();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\kdf\ECDHKEKGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */