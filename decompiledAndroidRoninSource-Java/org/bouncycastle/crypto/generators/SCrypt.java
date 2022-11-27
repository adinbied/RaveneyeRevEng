package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.engines.Salsa20Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class SCrypt
{
  private static void BlockMix(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int paramInt)
  {
    System.arraycopy(paramArrayOfInt1, paramArrayOfInt1.length - 16, paramArrayOfInt2, 0, 16);
    int k = paramArrayOfInt1.length;
    paramInt *= 2;
    int i = 0;
    int j = 0;
    while (paramInt > 0)
    {
      Xor(paramArrayOfInt2, paramArrayOfInt1, i, paramArrayOfInt3);
      Salsa20Engine.salsaCore(8, paramArrayOfInt3, paramArrayOfInt2);
      System.arraycopy(paramArrayOfInt2, 0, paramArrayOfInt4, j, 16);
      j = (k >>> 1) + i - j;
      i += 16;
      paramInt -= 1;
    }
    System.arraycopy(paramArrayOfInt4, 0, paramArrayOfInt1, 0, paramArrayOfInt4.length);
  }
  
  private static void Clear(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      Arrays.fill(paramArrayOfByte, (byte)0);
    }
  }
  
  private static void Clear(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {
      Arrays.fill(paramArrayOfInt, 0);
    }
  }
  
  private static void ClearAll(int[][] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      Clear(paramArrayOfInt[i]);
      i += 1;
    }
  }
  
  private static byte[] MFcrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt2 * 128;
    byte[] arrayOfByte = SingleIterationPBKDF2(paramArrayOfByte1, paramArrayOfByte2, paramInt3 * i);
    int[] arrayOfInt = null;
    paramArrayOfByte2 = arrayOfInt;
    try
    {
      int j = arrayOfByte.length >>> 2;
      paramArrayOfByte2 = arrayOfInt;
      arrayOfInt = new int[j];
      paramArrayOfByte2 = arrayOfInt;
      Pack.littleEndianToInt(arrayOfByte, 0, arrayOfInt);
      paramInt3 = 0;
      while (paramInt3 < j)
      {
        paramArrayOfByte2 = arrayOfInt;
        SMix(arrayOfInt, paramInt3, paramInt1, paramInt2);
        paramInt3 += (i >>> 2);
      }
      paramArrayOfByte2 = arrayOfInt;
      Pack.intToLittleEndian(arrayOfInt, arrayOfByte, 0);
      paramArrayOfByte2 = arrayOfInt;
      paramArrayOfByte1 = SingleIterationPBKDF2(paramArrayOfByte1, arrayOfByte, paramInt4);
      return paramArrayOfByte1;
    }
    finally
    {
      Clear(arrayOfByte);
      Clear(paramArrayOfByte2);
    }
  }
  
  /* Error */
  private static void SMix(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: iload_3
    //   1: bipush 32
    //   3: imul
    //   4: istore 5
    //   6: bipush 16
    //   8: newarray <illegal type>
    //   10: astore 6
    //   12: bipush 16
    //   14: newarray <illegal type>
    //   16: astore 7
    //   18: iload 5
    //   20: newarray <illegal type>
    //   22: astore 8
    //   24: iload 5
    //   26: newarray <illegal type>
    //   28: astore 9
    //   30: iload_2
    //   31: anewarray 67	[I
    //   34: astore 10
    //   36: aload_0
    //   37: iload_1
    //   38: aload 9
    //   40: iconst_0
    //   41: iload 5
    //   43: invokestatic 17	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   46: iconst_0
    //   47: istore 4
    //   49: iload 4
    //   51: iload_2
    //   52: if_icmpge +162 -> 214
    //   55: aload 10
    //   57: iload 4
    //   59: aload 9
    //   61: invokestatic 71	org/bouncycastle/util/Arrays:clone	([I)[I
    //   64: aastore
    //   65: aload 9
    //   67: aload 6
    //   69: aload 7
    //   71: aload 8
    //   73: iload_3
    //   74: invokestatic 73	org/bouncycastle/crypto/generators/SCrypt:BlockMix	([I[I[I[II)V
    //   77: iload 4
    //   79: iconst_1
    //   80: iadd
    //   81: istore 4
    //   83: goto -34 -> 49
    //   86: iload 4
    //   88: iload_2
    //   89: if_icmpge +47 -> 136
    //   92: aload 9
    //   94: aload 10
    //   96: aload 9
    //   98: iload 5
    //   100: bipush 16
    //   102: isub
    //   103: iaload
    //   104: iload_2
    //   105: iconst_1
    //   106: isub
    //   107: iand
    //   108: aaload
    //   109: iconst_0
    //   110: aload 9
    //   112: invokestatic 21	org/bouncycastle/crypto/generators/SCrypt:Xor	([I[II[I)V
    //   115: aload 9
    //   117: aload 6
    //   119: aload 7
    //   121: aload 8
    //   123: iload_3
    //   124: invokestatic 73	org/bouncycastle/crypto/generators/SCrypt:BlockMix	([I[I[I[II)V
    //   127: iload 4
    //   129: iconst_1
    //   130: iadd
    //   131: istore 4
    //   133: goto -47 -> 86
    //   136: aload 9
    //   138: iconst_0
    //   139: aload_0
    //   140: iload_1
    //   141: iload 5
    //   143: invokestatic 17	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   146: aload 10
    //   148: invokestatic 75	org/bouncycastle/crypto/generators/SCrypt:ClearAll	([[I)V
    //   151: iconst_4
    //   152: anewarray 67	[I
    //   155: dup
    //   156: iconst_0
    //   157: aload 9
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: aload 6
    //   164: aastore
    //   165: dup
    //   166: iconst_2
    //   167: aload 7
    //   169: aastore
    //   170: dup
    //   171: iconst_3
    //   172: aload 8
    //   174: aastore
    //   175: invokestatic 75	org/bouncycastle/crypto/generators/SCrypt:ClearAll	([[I)V
    //   178: return
    //   179: astore_0
    //   180: aload 10
    //   182: invokestatic 75	org/bouncycastle/crypto/generators/SCrypt:ClearAll	([[I)V
    //   185: iconst_4
    //   186: anewarray 67	[I
    //   189: dup
    //   190: iconst_0
    //   191: aload 9
    //   193: aastore
    //   194: dup
    //   195: iconst_1
    //   196: aload 6
    //   198: aastore
    //   199: dup
    //   200: iconst_2
    //   201: aload 7
    //   203: aastore
    //   204: dup
    //   205: iconst_3
    //   206: aload 8
    //   208: aastore
    //   209: invokestatic 75	org/bouncycastle/crypto/generators/SCrypt:ClearAll	([[I)V
    //   212: aload_0
    //   213: athrow
    //   214: iconst_0
    //   215: istore 4
    //   217: goto -131 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramArrayOfInt	int[]
    //   0	220	1	paramInt1	int
    //   0	220	2	paramInt2	int
    //   0	220	3	paramInt3	int
    //   47	169	4	i	int
    //   4	138	5	j	int
    //   10	187	6	arrayOfInt1	int[]
    //   16	186	7	arrayOfInt2	int[]
    //   22	185	8	arrayOfInt3	int[]
    //   28	164	9	arrayOfInt4	int[]
    //   34	147	10	arrayOfInt	int[][]
    // Exception table:
    //   from	to	target	type
    //   36	46	179	finally
    //   55	77	179	finally
    //   92	127	179	finally
    //   136	146	179	finally
  }
  
  private static byte[] SingleIterationPBKDF2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    PKCS5S2ParametersGenerator localPKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(new SHA256Digest());
    localPKCS5S2ParametersGenerator.init(paramArrayOfByte1, paramArrayOfByte2, 1);
    return ((KeyParameter)localPKCS5S2ParametersGenerator.generateDerivedMacParameters(paramInt * 8)).getKey();
  }
  
  private static void Xor(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, int[] paramArrayOfInt3)
  {
    int i = paramArrayOfInt3.length - 1;
    while (i >= 0)
    {
      paramArrayOfInt1[i] ^= paramArrayOfInt2[(paramInt + i)];
      i -= 1;
    }
  }
  
  public static byte[] generate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 != null)
      {
        if (paramInt1 > 1)
        {
          if ((paramInt2 == 1) && (paramInt1 > 65536)) {
            throw new IllegalArgumentException("Cost parameter N must be > 1 and < 65536.");
          }
          if (paramInt2 >= 1)
          {
            int i = Integer.MAX_VALUE / (paramInt2 * 128 * 8);
            if ((paramInt3 >= 1) && (paramInt3 <= i))
            {
              if (paramInt4 >= 1) {
                return MFcrypt(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4);
              }
              throw new IllegalArgumentException("Generated key length dkLen must be >= 1.");
            }
            paramArrayOfByte1 = new StringBuilder();
            paramArrayOfByte1.append("Parallelisation parameter p must be >= 1 and <= ");
            paramArrayOfByte1.append(i);
            paramArrayOfByte1.append(" (based on block size r of ");
            paramArrayOfByte1.append(paramInt2);
            paramArrayOfByte1.append(")");
            throw new IllegalArgumentException(paramArrayOfByte1.toString());
          }
          throw new IllegalArgumentException("Block size r must be >= 1.");
        }
        throw new IllegalArgumentException("Cost parameter N must be > 1.");
      }
      throw new IllegalArgumentException("Salt S must be provided.");
    }
    throw new IllegalArgumentException("Passphrase P must be provided.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\SCrypt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */