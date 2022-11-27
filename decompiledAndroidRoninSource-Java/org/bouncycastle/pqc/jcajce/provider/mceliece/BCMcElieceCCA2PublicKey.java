package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.asn1.McElieceCCA2PublicKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class BCMcElieceCCA2PublicKey
  implements CipherParameters, PublicKey
{
  private static final long serialVersionUID = 1L;
  private McElieceCCA2PublicKeyParameters params;
  
  public BCMcElieceCCA2PublicKey(McElieceCCA2PublicKeyParameters paramMcElieceCCA2PublicKeyParameters)
  {
    this.params = paramMcElieceCCA2PublicKeyParameters;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof BCMcElieceCCA2PublicKey)) {
        return false;
      }
      paramObject = (BCMcElieceCCA2PublicKey)paramObject;
      bool1 = bool2;
      if (this.params.getN() == ((BCMcElieceCCA2PublicKey)paramObject).getN())
      {
        bool1 = bool2;
        if (this.params.getT() == ((BCMcElieceCCA2PublicKey)paramObject).getT())
        {
          bool1 = bool2;
          if (this.params.getG().equals(((BCMcElieceCCA2PublicKey)paramObject).getG())) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return "McEliece-CCA2";
  }
  
  public byte[] getEncoded()
  {
    Object localObject = new McElieceCCA2PublicKey(this.params.getN(), this.params.getT(), this.params.getG(), Utils.getDigAlgId(this.params.getDigest()));
    AlgorithmIdentifier localAlgorithmIdentifier = new AlgorithmIdentifier(PQCObjectIdentifiers.mcElieceCca2);
    try
    {
      localObject = new SubjectPublicKeyInfo(localAlgorithmIdentifier, (ASN1Encodable)localObject).getEncoded();
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
    return "X.509";
  }
  
  public GF2Matrix getG()
  {
    return this.params.getG();
  }
  
  public int getK()
  {
    return this.params.getK();
  }
  
  AsymmetricKeyParameter getKeyParams()
  {
    return this.params;
  }
  
  public int getN()
  {
    return this.params.getN();
  }
  
  public int getT()
  {
    return this.params.getT();
  }
  
  public int hashCode()
  {
    return (this.params.getN() + this.params.getT() * 37) * 37 + this.params.getG().hashCode();
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("McEliecePublicKey:\n");
    ((StringBuilder)localObject).append(" length of the code         : ");
    ((StringBuilder)localObject).append(this.params.getN());
    ((StringBuilder)localObject).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" error correction capability: ");
    localStringBuilder.append(this.params.getT());
    localStringBuilder.append("\n");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" generator matrix           : ");
    localStringBuilder.append(this.params.getG().toString());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\BCMcElieceCCA2PublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */