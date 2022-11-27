package org.bouncycastle.pqc.crypto.rainbow;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.MessageSigner;
import org.bouncycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;

public class RainbowSigner
  implements MessageSigner
{
  private ComputeInField cf = new ComputeInField();
  RainbowKeyParameters key;
  private SecureRandom random;
  int signableDocumentLength;
  private short[] x;
  
  private short[] initSign(Layer[] paramArrayOfLayer, short[] paramArrayOfShort)
  {
    short[] arrayOfShort = new short[paramArrayOfShort.length];
    paramArrayOfShort = this.cf.addVect(((RainbowPrivateKeyParameters)this.key).getB1(), paramArrayOfShort);
    paramArrayOfShort = this.cf.multiplyMatrix(((RainbowPrivateKeyParameters)this.key).getInvA1(), paramArrayOfShort);
    int i = 0;
    while (i < paramArrayOfLayer[0].getVi())
    {
      this.x[i] = ((short)this.random.nextInt());
      arrayOfShort = this.x;
      arrayOfShort[i] = ((short)(arrayOfShort[i] & 0xFF));
      i += 1;
    }
    return paramArrayOfShort;
  }
  
  private short[] makeMessageRepresentative(byte[] paramArrayOfByte)
  {
    int m = this.signableDocumentLength;
    short[] arrayOfShort = new short[m];
    int i = 0;
    int j = 0;
    int k;
    do
    {
      if (i >= paramArrayOfByte.length) {
        return arrayOfShort;
      }
      arrayOfShort[i] = ((short)paramArrayOfByte[j]);
      arrayOfShort[i] = ((short)(arrayOfShort[i] & 0xFF));
      j += 1;
      k = i + 1;
      i = k;
    } while (k < m);
    return arrayOfShort;
  }
  
  private short[] verifySignatureIntern(short[] paramArrayOfShort)
  {
    short[][] arrayOfShort1 = ((RainbowPublicKeyParameters)this.key).getCoeffQuadratic();
    short[][] arrayOfShort2 = ((RainbowPublicKeyParameters)this.key).getCoeffSingular();
    short[] arrayOfShort3 = ((RainbowPublicKeyParameters)this.key).getCoeffScalar();
    short[] arrayOfShort4 = new short[arrayOfShort1.length];
    int n = arrayOfShort2[0].length;
    int j = 0;
    while (j < arrayOfShort1.length)
    {
      int i = 0;
      int k = 0;
      while (i < n)
      {
        int m = i;
        while (m < n)
        {
          s = GF2Field.multElem(arrayOfShort1[j][k], GF2Field.multElem(paramArrayOfShort[i], paramArrayOfShort[m]));
          arrayOfShort4[j] = GF2Field.addElem(arrayOfShort4[j], s);
          k += 1;
          m += 1;
        }
        short s = GF2Field.multElem(arrayOfShort2[j][i], paramArrayOfShort[i]);
        arrayOfShort4[j] = GF2Field.addElem(arrayOfShort4[j], s);
        i += 1;
      }
      arrayOfShort4[j] = GF2Field.addElem(arrayOfShort4[j], arrayOfShort3[j]);
      j += 1;
    }
    return arrayOfShort4;
  }
  
  public byte[] generateSignature(byte[] paramArrayOfByte)
  {
    Layer[] arrayOfLayer = ((RainbowPrivateKeyParameters)this.key).getLayers();
    int n = arrayOfLayer.length;
    this.x = new short[((RainbowPrivateKeyParameters)this.key).getInvA2().length];
    int i1 = arrayOfLayer[(n - 1)].getViNext();
    byte[] arrayOfByte = new byte[i1];
    paramArrayOfByte = makeMessageRepresentative(paramArrayOfByte);
    do
    {
      m = 0;
      try
      {
        arrayOfShort1 = initSign(arrayOfLayer, paramArrayOfByte);
        i = 0;
        j = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          short[] arrayOfShort1;
          int j;
          short[] arrayOfShort2;
          short[] arrayOfShort3;
          int k;
          int i = m;
          continue;
          i += 1;
        }
      }
      if (i < n)
      {
        arrayOfShort2 = new short[arrayOfLayer[i].getOi()];
        arrayOfShort3 = new short[arrayOfLayer[i].getOi()];
        k = 0;
        while (k < arrayOfLayer[i].getOi())
        {
          arrayOfShort2[k] = arrayOfShort1[j];
          j += 1;
          k += 1;
        }
        arrayOfShort2 = this.cf.solveEquation(arrayOfLayer[i].plugInVinegars(this.x), arrayOfShort2);
        if (arrayOfShort2 != null)
        {
          k = 0;
          while (k < arrayOfShort2.length)
          {
            this.x[(arrayOfLayer[i].getVi() + k)] = arrayOfShort2[k];
            k += 1;
          }
        }
        throw new Exception("LES is not solveable!");
      }
      arrayOfShort1 = this.cf.addVect(((RainbowPrivateKeyParameters)this.key).getB2(), this.x);
      arrayOfShort1 = this.cf.multiplyMatrix(((RainbowPrivateKeyParameters)this.key).getInvA2(), arrayOfShort1);
      i = 0;
      while (i < i1)
      {
        arrayOfByte[i] = ((byte)arrayOfShort1[i]);
        i += 1;
      }
      i = 1;
    } while (i == 0);
    return arrayOfByte;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if (paramBoolean)
    {
      if ((paramCipherParameters instanceof ParametersWithRandom))
      {
        paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
        this.random = paramCipherParameters.getRandom();
        this.key = ((RainbowPrivateKeyParameters)paramCipherParameters.getParameters());
        break label67;
      }
      this.random = new SecureRandom();
      paramCipherParameters = (RainbowPrivateKeyParameters)paramCipherParameters;
    }
    else
    {
      paramCipherParameters = (RainbowPublicKeyParameters)paramCipherParameters;
    }
    this.key = paramCipherParameters;
    label67:
    this.signableDocumentLength = this.key.getDocLength();
  }
  
  public boolean verifySignature(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    short[] arrayOfShort = new short[paramArrayOfByte2.length];
    int i = 0;
    while (i < paramArrayOfByte2.length)
    {
      arrayOfShort[i] = ((short)((short)paramArrayOfByte2[i] & 0xFF));
      i += 1;
    }
    paramArrayOfByte1 = makeMessageRepresentative(paramArrayOfByte1);
    paramArrayOfByte2 = verifySignatureIntern(arrayOfShort);
    if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
      return false;
    }
    i = 0;
    boolean bool = true;
    while (i < paramArrayOfByte1.length)
    {
      if ((bool) && (paramArrayOfByte1[i] == paramArrayOfByte2[i])) {
        bool = true;
      } else {
        bool = false;
      }
      i += 1;
    }
    return bool;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\rainbow\RainbowSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */