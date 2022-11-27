package org.bouncycastle.pqc.crypto.rainbow.util;

import java.lang.reflect.Array;

public class ComputeInField
{
  private short[][] A;
  short[] x;
  
  private void computeZerosAbove()
    throws RuntimeException
  {
    int i = this.A.length - 1;
    while (i > 0)
    {
      int j = i - 1;
      while (j >= 0)
      {
        short[][] arrayOfShort = this.A;
        short s1 = arrayOfShort[j][i];
        short s2 = GF2Field.invElem(arrayOfShort[i][i]);
        if (s2 != 0)
        {
          int k = i;
          for (;;)
          {
            arrayOfShort = this.A;
            if (k >= arrayOfShort.length * 2) {
              break;
            }
            short s3 = GF2Field.multElem(s1, GF2Field.multElem(arrayOfShort[i][k], s2));
            arrayOfShort = this.A;
            arrayOfShort[j][k] = GF2Field.addElem(arrayOfShort[j][k], s3);
            k += 1;
          }
          j -= 1;
        }
        else
        {
          throw new RuntimeException("The matrix is not invertible");
        }
      }
      i -= 1;
    }
  }
  
  private void computeZerosUnder(boolean paramBoolean)
    throws RuntimeException
  {
    int j;
    if (paramBoolean) {
      j = this.A.length * 2;
    } else {
      j = this.A.length + 1;
    }
    int k;
    label175:
    for (int i = 0; i < this.A.length - 1; i = k)
    {
      k = i + 1;
      int m = k;
      for (;;)
      {
        short[][] arrayOfShort = this.A;
        if (m >= arrayOfShort.length) {
          break label175;
        }
        short s1 = arrayOfShort[m][i];
        short s2 = GF2Field.invElem(arrayOfShort[i][i]);
        if (s2 == 0) {
          break;
        }
        int n = i;
        while (n < j)
        {
          short s3 = GF2Field.multElem(s1, GF2Field.multElem(this.A[i][n], s2));
          arrayOfShort = this.A;
          arrayOfShort[m][n] = GF2Field.addElem(arrayOfShort[m][n], s3);
          n += 1;
        }
        m += 1;
      }
      throw new RuntimeException("Matrix not invertible! We have to choose another one!");
    }
  }
  
  private void substitute()
    throws RuntimeException
  {
    Object localObject = this.A;
    short s1 = GF2Field.invElem(localObject[(localObject.length - 1)][(localObject.length - 1)]);
    if (s1 != 0)
    {
      localObject = this.x;
      short[][] arrayOfShort = this.A;
      localObject[(arrayOfShort.length - 1)] = GF2Field.multElem(arrayOfShort[(arrayOfShort.length - 1)][arrayOfShort.length], s1);
      int i = this.A.length - 2;
      while (i >= 0)
      {
        localObject = this.A;
        s1 = localObject[i][localObject.length];
        int j = localObject.length - 1;
        while (j > i)
        {
          s1 = GF2Field.addElem(s1, GF2Field.multElem(this.A[i][j], this.x[j]));
          j -= 1;
        }
        short s2 = GF2Field.invElem(this.A[i][i]);
        if (s2 != 0)
        {
          this.x[i] = GF2Field.multElem(s1, s2);
          i -= 1;
        }
        else
        {
          throw new RuntimeException("Not solvable equation system");
        }
      }
      return;
    }
    throw new RuntimeException("The equation system is not solvable");
  }
  
  public short[][] addSquareMatrix(short[][] paramArrayOfShort1, short[][] paramArrayOfShort2)
  {
    if ((paramArrayOfShort1.length == paramArrayOfShort2.length) && (paramArrayOfShort1[0].length == paramArrayOfShort2[0].length))
    {
      short[][] arrayOfShort = (short[][])Array.newInstance(Short.TYPE, new int[] { paramArrayOfShort1.length, paramArrayOfShort1.length });
      int i = 0;
      while (i < paramArrayOfShort1.length)
      {
        int j = 0;
        while (j < paramArrayOfShort2.length)
        {
          arrayOfShort[i][j] = GF2Field.addElem(paramArrayOfShort1[i][j], paramArrayOfShort2[i][j]);
          j += 1;
        }
        i += 1;
      }
      return arrayOfShort;
    }
    throw new RuntimeException("Addition is not possible!");
  }
  
  public short[] addVect(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    if (paramArrayOfShort1.length == paramArrayOfShort2.length)
    {
      int j = paramArrayOfShort1.length;
      short[] arrayOfShort = new short[j];
      int i = 0;
      while (i < j)
      {
        arrayOfShort[i] = GF2Field.addElem(paramArrayOfShort1[i], paramArrayOfShort2[i]);
        i += 1;
      }
      return arrayOfShort;
    }
    throw new RuntimeException("Multiplication is not possible!");
  }
  
  public short[][] inverse(short[][] paramArrayOfShort)
  {
    try
    {
      i = paramArrayOfShort.length;
      j = paramArrayOfShort.length;
      k = 0;
      this.A = ((short[][])Array.newInstance(Short.TYPE, new int[] { i, j * 2 }));
      if (paramArrayOfShort.length != paramArrayOfShort[0].length) {
        break label310;
      }
      i = 0;
      while (i < paramArrayOfShort.length)
      {
        j = 0;
        while (j < paramArrayOfShort.length)
        {
          this.A[i][j] = paramArrayOfShort[i][j];
          j += 1;
        }
        j = paramArrayOfShort.length;
        while (j < paramArrayOfShort.length * 2)
        {
          this.A[i][j] = 0;
          j += 1;
        }
        this.A[i][(this.A.length + i)] = 1;
        i += 1;
      }
      computeZerosUnder(true);
      i = 0;
    }
    catch (RuntimeException paramArrayOfShort)
    {
      for (;;)
      {
        int i;
        int j;
        int k;
        short s;
        label310:
        continue;
        i += 1;
        continue;
        i += 1;
      }
    }
    if (i < this.A.length)
    {
      s = GF2Field.invElem(this.A[i][i]);
      j = i;
      while (j < this.A.length * 2)
      {
        this.A[i][j] = GF2Field.multElem(this.A[i][j], s);
        j += 1;
      }
    }
    computeZerosAbove();
    paramArrayOfShort = (short[][])Array.newInstance(Short.TYPE, new int[] { this.A.length, this.A.length });
    i = k;
    if (i < this.A.length)
    {
      j = this.A.length;
      while (j < this.A.length * 2)
      {
        paramArrayOfShort[i][(j - this.A.length)] = this.A[i][j];
        j += 1;
      }
      throw new RuntimeException("The matrix is not invertible. Please choose another one!");
      return (short[][])null;
    }
    return paramArrayOfShort;
  }
  
  public short[][] multMatrix(short paramShort, short[][] paramArrayOfShort)
  {
    short[][] arrayOfShort = (short[][])Array.newInstance(Short.TYPE, new int[] { paramArrayOfShort.length, paramArrayOfShort[0].length });
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      int j = 0;
      while (j < paramArrayOfShort[0].length)
      {
        arrayOfShort[i][j] = GF2Field.multElem(paramShort, paramArrayOfShort[i][j]);
        j += 1;
      }
      i += 1;
    }
    return arrayOfShort;
  }
  
  public short[] multVect(short paramShort, short[] paramArrayOfShort)
  {
    int j = paramArrayOfShort.length;
    short[] arrayOfShort = new short[j];
    int i = 0;
    while (i < j)
    {
      arrayOfShort[i] = GF2Field.multElem(paramShort, paramArrayOfShort[i]);
      i += 1;
    }
    return arrayOfShort;
  }
  
  public short[][] multVects(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    if (paramArrayOfShort1.length == paramArrayOfShort2.length)
    {
      short[][] arrayOfShort = (short[][])Array.newInstance(Short.TYPE, new int[] { paramArrayOfShort1.length, paramArrayOfShort2.length });
      int i = 0;
      while (i < paramArrayOfShort1.length)
      {
        int j = 0;
        while (j < paramArrayOfShort2.length)
        {
          arrayOfShort[i][j] = GF2Field.multElem(paramArrayOfShort1[i], paramArrayOfShort2[j]);
          j += 1;
        }
        i += 1;
      }
      return arrayOfShort;
    }
    throw new RuntimeException("Multiplication is not possible!");
  }
  
  public short[] multiplyMatrix(short[][] paramArrayOfShort, short[] paramArrayOfShort1)
    throws RuntimeException
  {
    if (paramArrayOfShort[0].length == paramArrayOfShort1.length)
    {
      short[] arrayOfShort = new short[paramArrayOfShort.length];
      int i = 0;
      while (i < paramArrayOfShort.length)
      {
        int j = 0;
        while (j < paramArrayOfShort1.length)
        {
          short s = GF2Field.multElem(paramArrayOfShort[i][j], paramArrayOfShort1[j]);
          arrayOfShort[i] = GF2Field.addElem(arrayOfShort[i], s);
          j += 1;
        }
        i += 1;
      }
      return arrayOfShort;
    }
    throw new RuntimeException("Multiplication is not possible!");
  }
  
  public short[][] multiplyMatrix(short[][] paramArrayOfShort1, short[][] paramArrayOfShort2)
    throws RuntimeException
  {
    if (paramArrayOfShort1[0].length == paramArrayOfShort2.length)
    {
      this.A = ((short[][])Array.newInstance(Short.TYPE, new int[] { paramArrayOfShort1.length, paramArrayOfShort2[0].length }));
      int i = 0;
      while (i < paramArrayOfShort1.length)
      {
        int j = 0;
        while (j < paramArrayOfShort2.length)
        {
          int k = 0;
          while (k < paramArrayOfShort2[0].length)
          {
            short s = GF2Field.multElem(paramArrayOfShort1[i][j], paramArrayOfShort2[j][k]);
            short[][] arrayOfShort = this.A;
            arrayOfShort[i][k] = GF2Field.addElem(arrayOfShort[i][k], s);
            k += 1;
          }
          j += 1;
        }
        i += 1;
      }
      return this.A;
    }
    throw new RuntimeException("Multiplication is not possible!");
  }
  
  /* Error */
  public short[] solveEquation(short[][] paramArrayOfShort, short[] paramArrayOfShort1)
  {
    // Byte code:
    //   0: aload_1
    //   1: arraylength
    //   2: aload_2
    //   3: arraylength
    //   4: if_icmpne +134 -> 138
    //   7: aload_0
    //   8: getstatic 56	java/lang/Short:TYPE	Ljava/lang/Class;
    //   11: iconst_2
    //   12: newarray <illegal type>
    //   14: dup
    //   15: iconst_0
    //   16: aload_1
    //   17: arraylength
    //   18: iastore
    //   19: dup
    //   20: iconst_1
    //   21: aload_1
    //   22: arraylength
    //   23: iconst_1
    //   24: iadd
    //   25: iastore
    //   26: invokestatic 62	java/lang/reflect/Array:newInstance	(Ljava/lang/Class;[I)Ljava/lang/Object;
    //   29: checkcast 63	[[S
    //   32: putfield 18	org/bouncycastle/pqc/crypto/rainbow/util/ComputeInField:A	[[S
    //   35: aload_0
    //   36: aload_1
    //   37: arraylength
    //   38: newarray <illegal type>
    //   40: putfield 44	org/bouncycastle/pqc/crypto/rainbow/util/ComputeInField:x	[S
    //   43: iconst_0
    //   44: istore_3
    //   45: iload_3
    //   46: aload_1
    //   47: arraylength
    //   48: if_icmpge +113 -> 161
    //   51: iconst_0
    //   52: istore 4
    //   54: iload 4
    //   56: aload_1
    //   57: iconst_0
    //   58: aaload
    //   59: arraylength
    //   60: if_icmpge +94 -> 154
    //   63: aload_0
    //   64: getfield 18	org/bouncycastle/pqc/crypto/rainbow/util/ComputeInField:A	[[S
    //   67: iload_3
    //   68: aaload
    //   69: iload 4
    //   71: aload_1
    //   72: iload_3
    //   73: aaload
    //   74: iload 4
    //   76: saload
    //   77: sastore
    //   78: iload 4
    //   80: iconst_1
    //   81: iadd
    //   82: istore 4
    //   84: goto -30 -> 54
    //   87: iload_3
    //   88: aload_2
    //   89: arraylength
    //   90: if_icmpge +34 -> 124
    //   93: aload_0
    //   94: getfield 18	org/bouncycastle/pqc/crypto/rainbow/util/ComputeInField:A	[[S
    //   97: iload_3
    //   98: aaload
    //   99: aload_2
    //   100: arraylength
    //   101: aload_2
    //   102: iload_3
    //   103: saload
    //   104: aload_0
    //   105: getfield 18	org/bouncycastle/pqc/crypto/rainbow/util/ComputeInField:A	[[S
    //   108: iload_3
    //   109: aaload
    //   110: aload_2
    //   111: arraylength
    //   112: saload
    //   113: invokestatic 31	org/bouncycastle/pqc/crypto/rainbow/util/GF2Field:addElem	(SS)S
    //   116: sastore
    //   117: iload_3
    //   118: iconst_1
    //   119: iadd
    //   120: istore_3
    //   121: goto -34 -> 87
    //   124: aload_0
    //   125: iconst_0
    //   126: invokespecial 73	org/bouncycastle/pqc/crypto/rainbow/util/ComputeInField:computeZerosUnder	(Z)V
    //   129: aload_0
    //   130: invokespecial 88	org/bouncycastle/pqc/crypto/rainbow/util/ComputeInField:substitute	()V
    //   133: aload_0
    //   134: getfield 44	org/bouncycastle/pqc/crypto/rainbow/util/ComputeInField:x	[S
    //   137: areturn
    //   138: new 16	java/lang/RuntimeException
    //   141: dup
    //   142: ldc 48
    //   144: invokespecial 36	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   147: athrow
    //   148: aconst_null
    //   149: areturn
    //   150: astore_1
    //   151: goto -3 -> 148
    //   154: iload_3
    //   155: iconst_1
    //   156: iadd
    //   157: istore_3
    //   158: goto -113 -> 45
    //   161: iconst_0
    //   162: istore_3
    //   163: goto -76 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	ComputeInField
    //   0	166	1	paramArrayOfShort	short[][]
    //   0	166	2	paramArrayOfShort1	short[]
    //   44	119	3	i	int
    //   52	31	4	j	int
    // Exception table:
    //   from	to	target	type
    //   0	43	150	java/lang/RuntimeException
    //   45	51	150	java/lang/RuntimeException
    //   54	78	150	java/lang/RuntimeException
    //   87	117	150	java/lang/RuntimeException
    //   124	138	150	java/lang/RuntimeException
    //   138	148	150	java/lang/RuntimeException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\rainbo\\util\ComputeInField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */