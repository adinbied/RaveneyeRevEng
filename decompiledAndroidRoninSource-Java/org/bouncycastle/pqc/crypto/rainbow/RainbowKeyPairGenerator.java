package org.bouncycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;

public class RainbowKeyPairGenerator
  implements AsymmetricCipherKeyPairGenerator
{
  private short[][] A1;
  private short[][] A1inv;
  private short[][] A2;
  private short[][] A2inv;
  private short[] b1;
  private short[] b2;
  private boolean initialized = false;
  private Layer[] layers;
  private int numOfLayers;
  private short[][] pub_quadratic;
  private short[] pub_scalar;
  private short[][] pub_singular;
  private RainbowKeyGenerationParameters rainbowParams;
  private SecureRandom sr;
  private int[] vi;
  
  private void compactPublicKey(short[][][] paramArrayOfShort)
  {
    int n = paramArrayOfShort.length;
    int i1 = paramArrayOfShort[0].length;
    this.pub_quadratic = ((short[][])Array.newInstance(Short.TYPE, new int[] { n, (i1 + 1) * i1 / 2 }));
    int j = 0;
    while (j < n)
    {
      int i = 0;
      int k = 0;
      while (i < i1)
      {
        int m = i;
        while (m < i1)
        {
          short[][] arrayOfShort = this.pub_quadratic;
          if (m == i) {
            arrayOfShort[j][k] = paramArrayOfShort[j][i][m];
          } else {
            arrayOfShort[j][k] = GF2Field.addElem(paramArrayOfShort[j][i][m], paramArrayOfShort[j][m][i]);
          }
          k += 1;
          m += 1;
        }
        i += 1;
      }
      j += 1;
    }
  }
  
  private void computePublicKey()
  {
    Object localObject1 = Short.TYPE;
    ComputeInField localComputeInField = new ComputeInField();
    Object localObject2 = this.vi;
    int j = localObject2[(localObject2.length - 1)] - localObject2[0];
    int k = localObject2[(localObject2.length - 1)];
    short[][][] arrayOfShort = (short[][][])Array.newInstance(Short.TYPE, new int[] { j, k, k });
    this.pub_singular = ((short[][])Array.newInstance(Short.TYPE, new int[] { j, k }));
    this.pub_scalar = new short[j];
    localObject2 = new short[k];
    int i = 0;
    int m = 0;
    Object localObject4;
    for (;;)
    {
      int n = 0;
      localObject2 = this.layers;
      if (i >= localObject2.length) {
        break;
      }
      localObject3 = localObject2[i].getCoeffAlpha();
      localObject4 = this.layers[i].getCoeffBeta();
      short[][] arrayOfShort1 = this.layers[i].getCoeffGamma();
      localObject2 = this.layers[i].getCoeffEta();
      int i3 = localObject3[0].length;
      int i4 = localObject4[0].length;
      while (n < i3)
      {
        int i1 = 0;
        int i2;
        short s;
        int i5;
        short[][] arrayOfShort2;
        while (i1 < i3)
        {
          i2 = 0;
          while (i2 < i4)
          {
            s = localObject3[n][i1][i2];
            localObject5 = this.A2;
            i5 = i1 + i4;
            localObject5 = localComputeInField.multVect(s, localObject5[i5]);
            int i6 = m + n;
            arrayOfShort[i6] = localComputeInField.addSquareMatrix(arrayOfShort[i6], localComputeInField.multVects((short[])localObject5, this.A2[i2]));
            localObject5 = localComputeInField.multVect(this.b2[i2], (short[])localObject5);
            arrayOfShort2 = this.pub_singular;
            arrayOfShort2[i6] = localComputeInField.addVect((short[])localObject5, arrayOfShort2[i6]);
            localObject5 = localComputeInField.multVect(localObject3[n][i1][i2], this.A2[i2]);
            localObject5 = localComputeInField.multVect(this.b2[i5], (short[])localObject5);
            arrayOfShort2 = this.pub_singular;
            arrayOfShort2[i6] = localComputeInField.addVect((short[])localObject5, arrayOfShort2[i6]);
            s = GF2Field.multElem(localObject3[n][i1][i2], this.b2[i5]);
            localObject5 = this.pub_scalar;
            localObject5[i6] = GF2Field.addElem(localObject5[i6], GF2Field.multElem(s, this.b2[i2]));
            i2 += 1;
          }
          i1 += 1;
        }
        i1 = 0;
        while (i1 < i4)
        {
          i2 = 0;
          while (i2 < i4)
          {
            localObject5 = localComputeInField.multVect(localObject4[n][i1][i2], this.A2[i1]);
            i5 = m + n;
            arrayOfShort[i5] = localComputeInField.addSquareMatrix(arrayOfShort[i5], localComputeInField.multVects((short[])localObject5, this.A2[i2]));
            localObject5 = localComputeInField.multVect(this.b2[i2], (short[])localObject5);
            arrayOfShort2 = this.pub_singular;
            arrayOfShort2[i5] = localComputeInField.addVect((short[])localObject5, arrayOfShort2[i5]);
            localObject5 = localComputeInField.multVect(localObject4[n][i1][i2], this.A2[i2]);
            localObject5 = localComputeInField.multVect(this.b2[i1], (short[])localObject5);
            arrayOfShort2 = this.pub_singular;
            arrayOfShort2[i5] = localComputeInField.addVect((short[])localObject5, arrayOfShort2[i5]);
            s = GF2Field.multElem(localObject4[n][i1][i2], this.b2[i1]);
            localObject5 = this.pub_scalar;
            localObject5[i5] = GF2Field.addElem(localObject5[i5], GF2Field.multElem(s, this.b2[i2]));
            i2 += 1;
          }
          i1 += 1;
        }
        i1 = 0;
        while (i1 < i4 + i3)
        {
          localObject5 = localComputeInField.multVect(arrayOfShort1[n][i1], this.A2[i1]);
          arrayOfShort2 = this.pub_singular;
          i2 = m + n;
          arrayOfShort2[i2] = localComputeInField.addVect((short[])localObject5, arrayOfShort2[i2]);
          localObject5 = this.pub_scalar;
          localObject5[i2] = GF2Field.addElem(localObject5[i2], GF2Field.multElem(arrayOfShort1[n][i1], this.b2[i1]));
          i1 += 1;
        }
        Object localObject5 = this.pub_scalar;
        i1 = m + n;
        localObject5[i1] = GF2Field.addElem(localObject5[i1], localObject2[n]);
        n += 1;
      }
      m += i3;
      i += 1;
    }
    localObject2 = (short[][][])Array.newInstance((Class)localObject1, new int[] { j, k, k });
    localObject1 = (short[][])Array.newInstance((Class)localObject1, new int[] { j, k });
    Object localObject3 = new short[j];
    i = 0;
    while (i < j)
    {
      k = 0;
      for (;;)
      {
        localObject4 = this.A1;
        if (k >= localObject4.length) {
          break;
        }
        localObject2[i] = localComputeInField.addSquareMatrix(localObject2[i], localComputeInField.multMatrix(localObject4[i][k], arrayOfShort[k]));
        localObject1[i] = localComputeInField.addVect(localObject1[i], localComputeInField.multVect(this.A1[i][k], this.pub_singular[k]));
        localObject3[i] = GF2Field.addElem(localObject3[i], GF2Field.multElem(this.A1[i][k], this.pub_scalar[k]));
        k += 1;
      }
      localObject3[i] = GF2Field.addElem(localObject3[i], this.b1[i]);
      i += 1;
    }
    this.pub_singular = ((short[][])localObject1);
    this.pub_scalar = ((short[])localObject3);
    compactPublicKey((short[][][])localObject2);
  }
  
  private void generateF()
  {
    this.layers = new Layer[this.numOfLayers];
    int j;
    for (int i = 0; i < this.numOfLayers; i = j)
    {
      Layer[] arrayOfLayer = this.layers;
      int[] arrayOfInt = this.vi;
      int k = arrayOfInt[i];
      j = i + 1;
      arrayOfLayer[i] = new Layer(k, arrayOfInt[j], this.sr);
    }
  }
  
  private void generateL1()
  {
    Object localObject = this.vi;
    int i = localObject[(localObject.length - 1)];
    int k = 0;
    int m = i - localObject[0];
    this.A1 = ((short[][])Array.newInstance(Short.TYPE, new int[] { m, m }));
    this.A1inv = ((short[][])null);
    localObject = new ComputeInField();
    while (this.A1inv == null)
    {
      i = 0;
      while (i < m)
      {
        int j = 0;
        while (j < m)
        {
          this.A1[i][j] = ((short)(this.sr.nextInt() & 0xFF));
          j += 1;
        }
        i += 1;
      }
      this.A1inv = ((ComputeInField)localObject).inverse(this.A1);
    }
    this.b1 = new short[m];
    i = k;
    while (i < m)
    {
      this.b1[i] = ((short)(this.sr.nextInt() & 0xFF));
      i += 1;
    }
  }
  
  private void generateL2()
  {
    Object localObject = this.vi;
    int m = localObject[(localObject.length - 1)];
    int k = 0;
    this.A2 = ((short[][])Array.newInstance(Short.TYPE, new int[] { m, m }));
    this.A2inv = ((short[][])null);
    localObject = new ComputeInField();
    while (this.A2inv == null)
    {
      i = 0;
      while (i < m)
      {
        int j = 0;
        while (j < m)
        {
          this.A2[i][j] = ((short)(this.sr.nextInt() & 0xFF));
          j += 1;
        }
        i += 1;
      }
      this.A2inv = ((ComputeInField)localObject).inverse(this.A2);
    }
    this.b2 = new short[m];
    int i = k;
    while (i < m)
    {
      this.b2[i] = ((short)(this.sr.nextInt() & 0xFF));
      i += 1;
    }
  }
  
  private void initializeDefault()
  {
    initialize(new RainbowKeyGenerationParameters(new SecureRandom(), new RainbowParameters()));
  }
  
  private void keygen()
  {
    generateL1();
    generateL2();
    generateF();
    computePublicKey();
  }
  
  public AsymmetricCipherKeyPair genKeyPair()
  {
    if (!this.initialized) {
      initializeDefault();
    }
    keygen();
    RainbowPrivateKeyParameters localRainbowPrivateKeyParameters = new RainbowPrivateKeyParameters(this.A1inv, this.b1, this.A2inv, this.b2, this.vi, this.layers);
    int[] arrayOfInt = this.vi;
    return new AsymmetricCipherKeyPair(new RainbowPublicKeyParameters(arrayOfInt[(arrayOfInt.length - 1)] - arrayOfInt[0], this.pub_quadratic, this.pub_singular, this.pub_scalar), localRainbowPrivateKeyParameters);
  }
  
  public AsymmetricCipherKeyPair generateKeyPair()
  {
    return genKeyPair();
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    initialize(paramKeyGenerationParameters);
  }
  
  public void initialize(KeyGenerationParameters paramKeyGenerationParameters)
  {
    this.rainbowParams = ((RainbowKeyGenerationParameters)paramKeyGenerationParameters);
    this.sr = new SecureRandom();
    this.vi = this.rainbowParams.getParameters().getVi();
    this.numOfLayers = this.rainbowParams.getParameters().getNumOfLayers();
    this.initialized = true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\rainbow\RainbowKeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */