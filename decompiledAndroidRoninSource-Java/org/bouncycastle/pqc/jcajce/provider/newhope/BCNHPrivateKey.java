package org.bouncycastle.pqc.jcajce.provider.newhope;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.newhope.NHPrivateKeyParameters;
import org.bouncycastle.pqc.jcajce.interfaces.NHPrivateKey;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class BCNHPrivateKey
  implements NHPrivateKey
{
  private static final long serialVersionUID = 1L;
  private final NHPrivateKeyParameters params;
  
  public BCNHPrivateKey(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    this.params = new NHPrivateKeyParameters(convert(ASN1OctetString.getInstance(paramPrivateKeyInfo.parsePrivateKey()).getOctets()));
  }
  
  public BCNHPrivateKey(NHPrivateKeyParameters paramNHPrivateKeyParameters)
  {
    this.params = paramNHPrivateKeyParameters;
  }
  
  private static short[] convert(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length / 2;
    short[] arrayOfShort = new short[j];
    int i = 0;
    while (i != j)
    {
      arrayOfShort[i] = Pack.littleEndianToShort(paramArrayOfByte, i * 2);
      i += 1;
    }
    return arrayOfShort;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof BCNHPrivateKey)))
    {
      paramObject = (BCNHPrivateKey)paramObject;
      return Arrays.areEqual(this.params.getSecData(), ((BCNHPrivateKey)paramObject).params.getSecData());
    }
    return false;
  }
  
  public final String getAlgorithm()
  {
    return "NH";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      Object localObject = new AlgorithmIdentifier(PQCObjectIdentifiers.newHope);
      short[] arrayOfShort = this.params.getSecData();
      byte[] arrayOfByte = new byte[arrayOfShort.length * 2];
      int i = 0;
      while (i != arrayOfShort.length)
      {
        Pack.shortToLittleEndian(arrayOfShort[i], arrayOfByte, i * 2);
        i += 1;
      }
      localObject = new PrivateKeyInfo((AlgorithmIdentifier)localObject, new DEROctetString(arrayOfByte)).getEncoded();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  CipherParameters getKeyParams()
  {
    return this.params;
  }
  
  public short[] getSecretData()
  {
    return this.params.getSecData();
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.params.getSecData());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\newhope\BCNHPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */