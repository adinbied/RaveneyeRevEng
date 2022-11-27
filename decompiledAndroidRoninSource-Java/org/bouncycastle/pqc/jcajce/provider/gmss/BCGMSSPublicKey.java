package org.bouncycastle.pqc.jcajce.provider.gmss;

import java.security.PublicKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.asn1.GMSSPublicKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.ParSet;
import org.bouncycastle.pqc.crypto.gmss.GMSSParameters;
import org.bouncycastle.pqc.crypto.gmss.GMSSPublicKeyParameters;
import org.bouncycastle.pqc.jcajce.provider.util.KeyUtil;
import org.bouncycastle.util.encoders.Hex;

public class BCGMSSPublicKey
  implements CipherParameters, PublicKey
{
  private static final long serialVersionUID = 1L;
  private GMSSParameters gmssParameterSet;
  private GMSSParameters gmssParams;
  private byte[] publicKeyBytes;
  
  public BCGMSSPublicKey(GMSSPublicKeyParameters paramGMSSPublicKeyParameters)
  {
    this(paramGMSSPublicKeyParameters.getPublicKey(), paramGMSSPublicKeyParameters.getParameters());
  }
  
  public BCGMSSPublicKey(byte[] paramArrayOfByte, GMSSParameters paramGMSSParameters)
  {
    this.gmssParameterSet = paramGMSSParameters;
    this.publicKeyBytes = paramArrayOfByte;
  }
  
  public String getAlgorithm()
  {
    return "GMSS";
  }
  
  public byte[] getEncoded()
  {
    return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.gmss, new ParSet(this.gmssParameterSet.getNumOfLayers(), this.gmssParameterSet.getHeightOfTrees(), this.gmssParameterSet.getWinternitzParameter(), this.gmssParameterSet.getK()).toASN1Primitive()), new GMSSPublicKey(this.publicKeyBytes));
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public GMSSParameters getParameterSet()
  {
    return this.gmssParameterSet;
  }
  
  public byte[] getPublicKeyBytes()
  {
    return this.publicKeyBytes;
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GMSS public key : ");
    ((StringBuilder)localObject).append(new String(Hex.encode(this.publicKeyBytes)));
    ((StringBuilder)localObject).append("\n");
    ((StringBuilder)localObject).append("Height of Trees: \n");
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    while (i < this.gmssParameterSet.getHeightOfTrees().length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("Layer ");
      localStringBuilder.append(i);
      localStringBuilder.append(" : ");
      localStringBuilder.append(this.gmssParameterSet.getHeightOfTrees()[i]);
      localStringBuilder.append(" WinternitzParameter: ");
      localStringBuilder.append(this.gmssParameterSet.getWinternitzParameter()[i]);
      localStringBuilder.append(" K: ");
      localStringBuilder.append(this.gmssParameterSet.getK()[i]);
      localStringBuilder.append("\n");
      localObject = localStringBuilder.toString();
      i += 1;
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\gmss\BCGMSSPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */