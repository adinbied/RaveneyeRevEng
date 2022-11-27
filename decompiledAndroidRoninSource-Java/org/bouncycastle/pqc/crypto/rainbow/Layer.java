package org.bouncycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;
import org.bouncycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.bouncycastle.util.Arrays;

public class Layer
{
  private short[][][] coeff_alpha;
  private short[][][] coeff_beta;
  private short[] coeff_eta;
  private short[][] coeff_gamma;
  private int oi;
  private int vi;
  private int viNext;
  
  public Layer(byte paramByte1, byte paramByte2, short[][][] paramArrayOfShort1, short[][][] paramArrayOfShort2, short[][] paramArrayOfShort, short[] paramArrayOfShort3)
  {
    paramByte1 &= 0xFF;
    this.vi = paramByte1;
    paramByte2 &= 0xFF;
    this.viNext = paramByte2;
    this.oi = (paramByte2 - paramByte1);
    this.coeff_alpha = paramArrayOfShort1;
    this.coeff_beta = paramArrayOfShort2;
    this.coeff_gamma = paramArrayOfShort;
    this.coeff_eta = paramArrayOfShort3;
  }
  
  public Layer(int paramInt1, int paramInt2, SecureRandom paramSecureRandom)
  {
    this.vi = paramInt1;
    this.viNext = paramInt2;
    paramInt2 -= paramInt1;
    this.oi = paramInt2;
    int j = 0;
    this.coeff_alpha = ((short[][][])Array.newInstance(Short.TYPE, new int[] { paramInt2, paramInt2, paramInt1 }));
    paramInt1 = this.oi;
    paramInt2 = this.vi;
    this.coeff_beta = ((short[][][])Array.newInstance(Short.TYPE, new int[] { paramInt1, paramInt2, paramInt2 }));
    this.coeff_gamma = ((short[][])Array.newInstance(Short.TYPE, new int[] { this.oi, this.viNext }));
    int k = this.oi;
    this.coeff_eta = new short[k];
    paramInt1 = 0;
    int i;
    while (paramInt1 < k)
    {
      paramInt2 = 0;
      while (paramInt2 < this.oi)
      {
        i = 0;
        while (i < this.vi)
        {
          this.coeff_alpha[paramInt1][paramInt2][i] = ((short)(paramSecureRandom.nextInt() & 0xFF));
          i += 1;
        }
        paramInt2 += 1;
      }
      paramInt1 += 1;
    }
    paramInt1 = 0;
    while (paramInt1 < k)
    {
      paramInt2 = 0;
      while (paramInt2 < this.vi)
      {
        i = 0;
        while (i < this.vi)
        {
          this.coeff_beta[paramInt1][paramInt2][i] = ((short)(paramSecureRandom.nextInt() & 0xFF));
          i += 1;
        }
        paramInt2 += 1;
      }
      paramInt1 += 1;
    }
    paramInt1 = 0;
    for (;;)
    {
      paramInt2 = j;
      if (paramInt1 >= k) {
        break;
      }
      paramInt2 = 0;
      while (paramInt2 < this.viNext)
      {
        this.coeff_gamma[paramInt1][paramInt2] = ((short)(paramSecureRandom.nextInt() & 0xFF));
        paramInt2 += 1;
      }
      paramInt1 += 1;
    }
    while (paramInt2 < k)
    {
      this.coeff_eta[paramInt2] = ((short)(paramSecureRandom.nextInt() & 0xFF));
      paramInt2 += 1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof Layer)) {
        return false;
      }
      paramObject = (Layer)paramObject;
      bool1 = bool2;
      if (this.vi == ((Layer)paramObject).getVi())
      {
        bool1 = bool2;
        if (this.viNext == ((Layer)paramObject).getViNext())
        {
          bool1 = bool2;
          if (this.oi == ((Layer)paramObject).getOi())
          {
            bool1 = bool2;
            if (RainbowUtil.equals(this.coeff_alpha, ((Layer)paramObject).getCoeffAlpha()))
            {
              bool1 = bool2;
              if (RainbowUtil.equals(this.coeff_beta, ((Layer)paramObject).getCoeffBeta()))
              {
                bool1 = bool2;
                if (RainbowUtil.equals(this.coeff_gamma, ((Layer)paramObject).getCoeffGamma()))
                {
                  bool1 = bool2;
                  if (RainbowUtil.equals(this.coeff_eta, ((Layer)paramObject).getCoeffEta())) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public short[][][] getCoeffAlpha()
  {
    return this.coeff_alpha;
  }
  
  public short[][][] getCoeffBeta()
  {
    return this.coeff_beta;
  }
  
  public short[] getCoeffEta()
  {
    return this.coeff_eta;
  }
  
  public short[][] getCoeffGamma()
  {
    return this.coeff_gamma;
  }
  
  public int getOi()
  {
    return this.oi;
  }
  
  public int getVi()
  {
    return this.vi;
  }
  
  public int getViNext()
  {
    return this.viNext;
  }
  
  public int hashCode()
  {
    return (((((this.vi * 37 + this.viNext) * 37 + this.oi) * 37 + Arrays.hashCode(this.coeff_alpha)) * 37 + Arrays.hashCode(this.coeff_beta)) * 37 + Arrays.hashCode(this.coeff_gamma)) * 37 + Arrays.hashCode(this.coeff_eta);
  }
  
  public short[][] plugInVinegars(short[] paramArrayOfShort)
  {
    int i = this.oi;
    int m = 0;
    short[][] arrayOfShort = (short[][])Array.newInstance(Short.TYPE, new int[] { i, i + 1 });
    short[] arrayOfShort1 = new short[this.oi];
    i = 0;
    int k;
    short s;
    while (i < this.oi)
    {
      j = 0;
      while (j < this.vi)
      {
        k = 0;
        while (k < this.vi)
        {
          s = GF2Field.multElem(GF2Field.multElem(this.coeff_beta[i][j][k], paramArrayOfShort[j]), paramArrayOfShort[k]);
          arrayOfShort1[i] = GF2Field.addElem(arrayOfShort1[i], s);
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
    i = 0;
    while (i < this.oi)
    {
      j = 0;
      while (j < this.oi)
      {
        k = 0;
        while (k < this.vi)
        {
          s = GF2Field.multElem(this.coeff_alpha[i][j][k], paramArrayOfShort[k]);
          arrayOfShort[i][j] = GF2Field.addElem(arrayOfShort[i][j], s);
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
    i = 0;
    while (i < this.oi)
    {
      j = 0;
      while (j < this.vi)
      {
        s = GF2Field.multElem(this.coeff_gamma[i][j], paramArrayOfShort[j]);
        arrayOfShort1[i] = GF2Field.addElem(arrayOfShort1[i], s);
        j += 1;
      }
      i += 1;
    }
    i = 0;
    while (i < this.oi)
    {
      j = this.vi;
      while (j < this.viNext)
      {
        paramArrayOfShort = arrayOfShort[i];
        k = this.vi;
        paramArrayOfShort[(j - k)] = GF2Field.addElem(this.coeff_gamma[i][j], arrayOfShort[i][(j - k)]);
        j += 1;
      }
      i += 1;
    }
    int j = 0;
    for (;;)
    {
      i = m;
      if (j >= this.oi) {
        break;
      }
      arrayOfShort1[j] = GF2Field.addElem(arrayOfShort1[j], this.coeff_eta[j]);
      j += 1;
    }
    for (;;)
    {
      j = this.oi;
      if (i >= j) {
        break;
      }
      arrayOfShort[i][j] = arrayOfShort1[i];
      i += 1;
    }
    return arrayOfShort;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\rainbow\Layer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */