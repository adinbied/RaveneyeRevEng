package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.asn1.McEliecePrivateKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.bouncycastle.util.Strings;

public class BCMcEliecePrivateKey
  implements CipherParameters, PrivateKey
{
  private static final long serialVersionUID = 1L;
  private McEliecePrivateKeyParameters params;
  
  public BCMcEliecePrivateKey(McEliecePrivateKeyParameters paramMcEliecePrivateKeyParameters)
  {
    this.params = paramMcEliecePrivateKeyParameters;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof BCMcEliecePrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCMcEliecePrivateKey)paramObject;
    bool1 = bool2;
    if (getN() == ((BCMcEliecePrivateKey)paramObject).getN())
    {
      bool1 = bool2;
      if (getK() == ((BCMcEliecePrivateKey)paramObject).getK())
      {
        bool1 = bool2;
        if (getField().equals(((BCMcEliecePrivateKey)paramObject).getField()))
        {
          bool1 = bool2;
          if (getGoppaPoly().equals(((BCMcEliecePrivateKey)paramObject).getGoppaPoly()))
          {
            bool1 = bool2;
            if (getSInv().equals(((BCMcEliecePrivateKey)paramObject).getSInv()))
            {
              bool1 = bool2;
              if (getP1().equals(((BCMcEliecePrivateKey)paramObject).getP1()))
              {
                bool1 = bool2;
                if (getP2().equals(((BCMcEliecePrivateKey)paramObject).getP2())) {
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
    return "McEliece";
  }
  
  public byte[] getEncoded()
  {
    Object localObject = new McEliecePrivateKey(this.params.getN(), this.params.getK(), this.params.getField(), this.params.getGoppaPoly(), this.params.getP1(), this.params.getP2(), this.params.getSInv());
    try
    {
      localObject = new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.mcEliece), (ASN1Encodable)localObject);
      try
      {
        localObject = ((PrivateKeyInfo)localObject).getEncoded();
        return (byte[])localObject;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        return null;
      }
      return null;
    }
    catch (IOException localIOException2)
    {
      localIOException2.printStackTrace();
    }
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
  
  public Permutation getP1()
  {
    return this.params.getP1();
  }
  
  public Permutation getP2()
  {
    return this.params.getP2();
  }
  
  public PolynomialGF2mSmallM[] getQInv()
  {
    return this.params.getQInv();
  }
  
  public GF2Matrix getSInv()
  {
    return this.params.getSInv();
  }
  
  public int hashCode()
  {
    return (((((this.params.getK() * 37 + this.params.getN()) * 37 + this.params.getField().hashCode()) * 37 + this.params.getGoppaPoly().hashCode()) * 37 + this.params.getP1().hashCode()) * 37 + this.params.getP2().hashCode()) * 37 + this.params.getSInv().hashCode();
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" length of the code          : ");
    ((StringBuilder)localObject).append(getN());
    ((StringBuilder)localObject).append(Strings.lineSeparator());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" dimension of the code       : ");
    localStringBuilder.append(getK());
    localStringBuilder.append(Strings.lineSeparator());
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" irreducible Goppa polynomial: ");
    localStringBuilder.append(getGoppaPoly());
    localStringBuilder.append(Strings.lineSeparator());
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" permutation P1              : ");
    localStringBuilder.append(getP1());
    localStringBuilder.append(Strings.lineSeparator());
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" permutation P2              : ");
    localStringBuilder.append(getP2());
    localStringBuilder.append(Strings.lineSeparator());
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" (k x k)-matrix S^-1         : ");
    localStringBuilder.append(getSInv());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\BCMcEliecePrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */