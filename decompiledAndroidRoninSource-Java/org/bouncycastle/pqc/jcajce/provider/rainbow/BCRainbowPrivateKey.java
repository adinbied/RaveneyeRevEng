package org.bouncycastle.pqc.jcajce.provider.rainbow;

import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.RainbowPrivateKey;
import org.bouncycastle.pqc.crypto.rainbow.Layer;
import org.bouncycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.bouncycastle.pqc.jcajce.spec.RainbowPrivateKeySpec;

public class BCRainbowPrivateKey
  implements PrivateKey
{
  private static final long serialVersionUID = 1L;
  private short[][] A1inv;
  private short[][] A2inv;
  private short[] b1;
  private short[] b2;
  private Layer[] layers;
  private int[] vi;
  
  public BCRainbowPrivateKey(RainbowPrivateKeyParameters paramRainbowPrivateKeyParameters)
  {
    this(paramRainbowPrivateKeyParameters.getInvA1(), paramRainbowPrivateKeyParameters.getB1(), paramRainbowPrivateKeyParameters.getInvA2(), paramRainbowPrivateKeyParameters.getB2(), paramRainbowPrivateKeyParameters.getVi(), paramRainbowPrivateKeyParameters.getLayers());
  }
  
  public BCRainbowPrivateKey(RainbowPrivateKeySpec paramRainbowPrivateKeySpec)
  {
    this(paramRainbowPrivateKeySpec.getInvA1(), paramRainbowPrivateKeySpec.getB1(), paramRainbowPrivateKeySpec.getInvA2(), paramRainbowPrivateKeySpec.getB2(), paramRainbowPrivateKeySpec.getVi(), paramRainbowPrivateKeySpec.getLayers());
  }
  
  public BCRainbowPrivateKey(short[][] paramArrayOfShort1, short[] paramArrayOfShort2, short[][] paramArrayOfShort3, short[] paramArrayOfShort4, int[] paramArrayOfInt, Layer[] paramArrayOfLayer)
  {
    this.A1inv = paramArrayOfShort1;
    this.b1 = paramArrayOfShort2;
    this.A2inv = paramArrayOfShort3;
    this.b2 = paramArrayOfShort4;
    this.vi = paramArrayOfInt;
    this.layers = paramArrayOfLayer;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof BCRainbowPrivateKey)) {
        return false;
      }
      paramObject = (BCRainbowPrivateKey)paramObject;
      if (RainbowUtil.equals(this.A1inv, ((BCRainbowPrivateKey)paramObject).getInvA1())) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (RainbowUtil.equals(this.A2inv, ((BCRainbowPrivateKey)paramObject).getInvA2()))) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (RainbowUtil.equals(this.b1, ((BCRainbowPrivateKey)paramObject).getB1()))) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (RainbowUtil.equals(this.b2, ((BCRainbowPrivateKey)paramObject).getB2()))) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool;
      if ((i != 0) && (java.util.Arrays.equals(this.vi, ((BCRainbowPrivateKey)paramObject).getVi()))) {
        bool = true;
      } else {
        bool = false;
      }
      if (this.layers.length != ((BCRainbowPrivateKey)paramObject).getLayers().length) {
        return false;
      }
      int i = this.layers.length - 1;
      while (i >= 0)
      {
        bool &= this.layers[i].equals(paramObject.getLayers()[i]);
        i -= 1;
      }
      return bool;
    }
    return false;
  }
  
  public final String getAlgorithm()
  {
    return "Rainbow";
  }
  
  public short[] getB1()
  {
    return this.b1;
  }
  
  public short[] getB2()
  {
    return this.b2;
  }
  
  public byte[] getEncoded()
  {
    Object localObject = new RainbowPrivateKey(this.A1inv, this.b1, this.A2inv, this.b2, this.vi, this.layers);
    try
    {
      localObject = new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.rainbow, DERNull.INSTANCE), (ASN1Encodable)localObject);
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
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public short[][] getInvA1()
  {
    return this.A1inv;
  }
  
  public short[][] getInvA2()
  {
    return this.A2inv;
  }
  
  public Layer[] getLayers()
  {
    return this.layers;
  }
  
  public int[] getVi()
  {
    return this.vi;
  }
  
  public int hashCode()
  {
    int j = ((((this.layers.length * 37 + org.bouncycastle.util.Arrays.hashCode(this.A1inv)) * 37 + org.bouncycastle.util.Arrays.hashCode(this.b1)) * 37 + org.bouncycastle.util.Arrays.hashCode(this.A2inv)) * 37 + org.bouncycastle.util.Arrays.hashCode(this.b2)) * 37 + org.bouncycastle.util.Arrays.hashCode(this.vi);
    int i = this.layers.length - 1;
    while (i >= 0)
    {
      j = j * 37 + this.layers[i].hashCode();
      i -= 1;
    }
    return j;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\rainbow\BCRainbowPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */