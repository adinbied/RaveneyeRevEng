package org.bouncycastle.pqc.jcajce.provider.newhope;

import java.io.IOException;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import org.bouncycastle.pqc.jcajce.interfaces.NHPublicKey;
import org.bouncycastle.util.Arrays;

public class BCNHPublicKey
  implements NHPublicKey
{
  private static final long serialVersionUID = 1L;
  private final NHPublicKeyParameters params;
  
  public BCNHPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    this.params = new NHPublicKeyParameters(paramSubjectPublicKeyInfo.getPublicKeyData().getBytes());
  }
  
  public BCNHPublicKey(NHPublicKeyParameters paramNHPublicKeyParameters)
  {
    this.params = paramNHPublicKeyParameters;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof BCNHPublicKey)))
    {
      paramObject = (BCNHPublicKey)paramObject;
      return Arrays.areEqual(this.params.getPubData(), ((BCNHPublicKey)paramObject).params.getPubData());
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
      byte[] arrayOfByte = new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.newHope), this.params.getPubData()).getEncoded();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  CipherParameters getKeyParams()
  {
    return this.params;
  }
  
  public byte[] getPublicData()
  {
    return this.params.getPubData();
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.params.getPubData());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\newhope\BCNHPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */