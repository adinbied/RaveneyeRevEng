package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.asn1.McElieceCCA2PrivateKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class BCMcElieceCCA2PrivateKey
  implements PrivateKey
{
  private static final long serialVersionUID = 1L;
  private McElieceCCA2PrivateKeyParameters params;
  
  public BCMcElieceCCA2PrivateKey(McElieceCCA2PrivateKeyParameters paramMcElieceCCA2PrivateKeyParameters)
  {
    this.params = paramMcElieceCCA2PrivateKeyParameters;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof BCMcElieceCCA2PrivateKey)) {
        return false;
      }
      paramObject = (BCMcElieceCCA2PrivateKey)paramObject;
      bool1 = bool2;
      if (getN() == ((BCMcElieceCCA2PrivateKey)paramObject).getN())
      {
        bool1 = bool2;
        if (getK() == ((BCMcElieceCCA2PrivateKey)paramObject).getK())
        {
          bool1 = bool2;
          if (getField().equals(((BCMcElieceCCA2PrivateKey)paramObject).getField()))
          {
            bool1 = bool2;
            if (getGoppaPoly().equals(((BCMcElieceCCA2PrivateKey)paramObject).getGoppaPoly()))
            {
              bool1 = bool2;
              if (getP().equals(((BCMcElieceCCA2PrivateKey)paramObject).getP()))
              {
                bool1 = bool2;
                if (getH().equals(((BCMcElieceCCA2PrivateKey)paramObject).getH())) {
                  bool1 = true;
                }
              }
            }
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
    try
    {
      Object localObject = new McElieceCCA2PrivateKey(getN(), getK(), getField(), getGoppaPoly(), getP(), Utils.getDigAlgId(this.params.getDigest()));
      localObject = new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.mcElieceCca2), (ASN1Encodable)localObject).getEncoded();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public GF2mField getField()
  {
    return this.params.getField();
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public PolynomialGF2mSmallM getGoppaPoly()
  {
    return this.params.getGoppaPoly();
  }
  
  public GF2Matrix getH()
  {
    return this.params.getH();
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
  
  public Permutation getP()
  {
    return this.params.getP();
  }
  
  public PolynomialGF2mSmallM[] getQInv()
  {
    return this.params.getQInv();
  }
  
  public int getT()
  {
    return this.params.getGoppaPoly().getDegree();
  }
  
  public int hashCode()
  {
    return ((((this.params.getK() * 37 + this.params.getN()) * 37 + this.params.getField().hashCode()) * 37 + this.params.getGoppaPoly().hashCode()) * 37 + this.params.getP().hashCode()) * 37 + this.params.getH().hashCode();
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(" extension degree of the field      : ");
    ((StringBuilder)localObject).append(getN());
    ((StringBuilder)localObject).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" dimension of the code              : ");
    localStringBuilder.append(getK());
    localStringBuilder.append("\n");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" irreducible Goppa polynomial       : ");
    localStringBuilder.append(getGoppaPoly());
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\BCMcElieceCCA2PrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */