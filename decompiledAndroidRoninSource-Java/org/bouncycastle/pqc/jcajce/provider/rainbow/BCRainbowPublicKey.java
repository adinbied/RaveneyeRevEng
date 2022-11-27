package org.bouncycastle.pqc.jcajce.provider.rainbow;

import java.security.PublicKey;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.RainbowPublicKey;
import org.bouncycastle.pqc.crypto.rainbow.RainbowParameters;
import org.bouncycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;
import org.bouncycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.bouncycastle.pqc.jcajce.provider.util.KeyUtil;
import org.bouncycastle.pqc.jcajce.spec.RainbowPublicKeySpec;
import org.bouncycastle.util.Arrays;

public class BCRainbowPublicKey
  implements PublicKey
{
  private static final long serialVersionUID = 1L;
  private short[][] coeffquadratic;
  private short[] coeffscalar;
  private short[][] coeffsingular;
  private int docLength;
  private RainbowParameters rainbowParams;
  
  public BCRainbowPublicKey(int paramInt, short[][] paramArrayOfShort1, short[][] paramArrayOfShort2, short[] paramArrayOfShort)
  {
    this.docLength = paramInt;
    this.coeffquadratic = paramArrayOfShort1;
    this.coeffsingular = paramArrayOfShort2;
    this.coeffscalar = paramArrayOfShort;
  }
  
  public BCRainbowPublicKey(RainbowPublicKeyParameters paramRainbowPublicKeyParameters)
  {
    this(paramRainbowPublicKeyParameters.getDocLength(), paramRainbowPublicKeyParameters.getCoeffQuadratic(), paramRainbowPublicKeyParameters.getCoeffSingular(), paramRainbowPublicKeyParameters.getCoeffScalar());
  }
  
  public BCRainbowPublicKey(RainbowPublicKeySpec paramRainbowPublicKeySpec)
  {
    this(paramRainbowPublicKeySpec.getDocLength(), paramRainbowPublicKeySpec.getCoeffQuadratic(), paramRainbowPublicKeySpec.getCoeffSingular(), paramRainbowPublicKeySpec.getCoeffScalar());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof BCRainbowPublicKey)) {
        return false;
      }
      paramObject = (BCRainbowPublicKey)paramObject;
      bool1 = bool2;
      if (this.docLength == ((BCRainbowPublicKey)paramObject).getDocLength())
      {
        bool1 = bool2;
        if (RainbowUtil.equals(this.coeffquadratic, ((BCRainbowPublicKey)paramObject).getCoeffQuadratic()))
        {
          bool1 = bool2;
          if (RainbowUtil.equals(this.coeffsingular, ((BCRainbowPublicKey)paramObject).getCoeffSingular()))
          {
            bool1 = bool2;
            if (RainbowUtil.equals(this.coeffscalar, ((BCRainbowPublicKey)paramObject).getCoeffScalar())) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public final String getAlgorithm()
  {
    return "Rainbow";
  }
  
  public short[][] getCoeffQuadratic()
  {
    return this.coeffquadratic;
  }
  
  public short[] getCoeffScalar()
  {
    return Arrays.clone(this.coeffscalar);
  }
  
  public short[][] getCoeffSingular()
  {
    short[][] arrayOfShort1 = new short[this.coeffsingular.length][];
    int i = 0;
    for (;;)
    {
      short[][] arrayOfShort2 = this.coeffsingular;
      if (i == arrayOfShort2.length) {
        break;
      }
      arrayOfShort1[i] = Arrays.clone(arrayOfShort2[i]);
      i += 1;
    }
    return arrayOfShort1;
  }
  
  public int getDocLength()
  {
    return this.docLength;
  }
  
  public byte[] getEncoded()
  {
    RainbowPublicKey localRainbowPublicKey = new RainbowPublicKey(this.docLength, this.coeffquadratic, this.coeffsingular, this.coeffscalar);
    return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.rainbow, DERNull.INSTANCE), localRainbowPublicKey);
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public int hashCode()
  {
    return ((this.docLength * 37 + Arrays.hashCode(this.coeffquadratic)) * 37 + Arrays.hashCode(this.coeffsingular)) * 37 + Arrays.hashCode(this.coeffscalar);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\rainbow\BCRainbowPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */