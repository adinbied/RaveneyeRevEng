package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.crypto.params.GOST3410ValidationParameters;

public class GOST3410ParametersGenerator
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private static final BigInteger TWO = BigInteger.valueOf(2L);
  private SecureRandom init_random;
  private int size;
  private int typeproc;
  
  private int procedure_A(int paramInt1, int paramInt2, BigInteger[] paramArrayOfBigInteger, int paramInt3)
  {
    for (;;)
    {
      if ((paramInt1 >= 0) && (paramInt1 <= 65536)) {
        for (;;)
        {
          if ((paramInt2 >= 0) && (paramInt2 <= 65536) && (paramInt2 / 2 != 0))
          {
            BigInteger localBigInteger2 = new BigInteger(Integer.toString(paramInt2));
            BigInteger localBigInteger1 = new BigInteger("19381");
            BigInteger[] arrayOfBigInteger1 = new BigInteger[1];
            arrayOfBigInteger1[0] = new BigInteger(Integer.toString(paramInt1));
            int[] arrayOfInt = new int[1];
            arrayOfInt[0] = paramInt3;
            paramInt2 = 0;
            paramInt1 = 0;
            Object localObject;
            while (arrayOfInt[paramInt2] >= 17)
            {
              paramInt1 = arrayOfInt.length + 1;
              localObject = new int[paramInt1];
              System.arraycopy(arrayOfInt, 0, localObject, 0, arrayOfInt.length);
              arrayOfInt = new int[paramInt1];
              System.arraycopy(localObject, 0, arrayOfInt, 0, paramInt1);
              paramInt1 = paramInt2 + 1;
              arrayOfInt[paramInt2] /= 2;
              paramInt2 = paramInt1;
            }
            BigInteger[] arrayOfBigInteger2 = new BigInteger[paramInt1 + 1];
            arrayOfBigInteger2[paramInt1] = new BigInteger("8003", 16);
            paramInt3 = paramInt1 - 1;
            paramInt2 = 0;
            int i;
            for (;;)
            {
              if (paramInt2 < paramInt1)
              {
                int k = arrayOfInt[paramInt3] / 16;
                int j;
                long l;
                do
                {
                  i = arrayOfBigInteger1.length;
                  localObject = new BigInteger[i];
                  System.arraycopy(arrayOfBigInteger1, 0, localObject, 0, arrayOfBigInteger1.length);
                  arrayOfBigInteger1 = new BigInteger[k + 1];
                  System.arraycopy(localObject, 0, arrayOfBigInteger1, 0, i);
                  for (i = 0; i < k; i = j)
                  {
                    j = i + 1;
                    arrayOfBigInteger1[j] = arrayOfBigInteger1[i].multiply(localBigInteger1).add(localBigInteger2).mod(TWO.pow(16));
                  }
                  localObject = new BigInteger("0");
                  i = 0;
                  while (i < k)
                  {
                    localObject = ((BigInteger)localObject).add(arrayOfBigInteger1[i].multiply(TWO.pow(i * 16)));
                    i += 1;
                  }
                  arrayOfBigInteger1[0] = arrayOfBigInteger1[k];
                  BigInteger localBigInteger3 = TWO.pow(arrayOfInt[paramInt3] - 1);
                  j = paramInt3 + 1;
                  localBigInteger3 = localBigInteger3.divide(arrayOfBigInteger2[j]).add(TWO.pow(arrayOfInt[paramInt3] - 1).multiply((BigInteger)localObject).divide(arrayOfBigInteger2[j].multiply(TWO.pow(k * 16))));
                  localObject = localBigInteger3;
                  if (localBigInteger3.mod(TWO).compareTo(ONE) == 0) {
                    localObject = localBigInteger3.add(ONE);
                  }
                  i = 0;
                  localBigInteger3 = arrayOfBigInteger2[j];
                  l = i;
                  arrayOfBigInteger2[paramInt3] = localBigInteger3.multiply(((BigInteger)localObject).add(BigInteger.valueOf(l))).add(ONE);
                } while (arrayOfBigInteger2[paramInt3].compareTo(TWO.pow(arrayOfInt[paramInt3])) == 1);
                if ((TWO.modPow(arrayOfBigInteger2[j].multiply(((BigInteger)localObject).add(BigInteger.valueOf(l))), arrayOfBigInteger2[paramInt3]).compareTo(ONE) == 0) && (TWO.modPow(((BigInteger)localObject).add(BigInteger.valueOf(l)), arrayOfBigInteger2[paramInt3]).compareTo(ONE) != 0))
                {
                  paramInt3 -= 1;
                  if (paramInt3 >= 0)
                  {
                    paramInt2 += 1;
                    continue;
                  }
                  paramArrayOfBigInteger[0] = arrayOfBigInteger2[0];
                  paramArrayOfBigInteger[1] = arrayOfBigInteger2[1];
                }
              }
            }
            for (paramArrayOfBigInteger = arrayOfBigInteger1[0];; paramArrayOfBigInteger = arrayOfBigInteger1[0])
            {
              return paramArrayOfBigInteger.intValue();
              i += 2;
              break;
            }
          }
          paramInt2 = this.init_random.nextInt() / 32768 + 1;
        }
      }
      paramInt1 = this.init_random.nextInt() / 32768;
    }
  }
  
  private long procedure_Aa(long paramLong1, long paramLong2, BigInteger[] paramArrayOfBigInteger, int paramInt)
  {
    for (;;)
    {
      if ((paramLong1 >= 0L) && (paramLong1 <= 4294967296L)) {
        for (;;)
        {
          if ((paramLong2 >= 0L) && (paramLong2 <= 4294967296L) && (paramLong2 / 2L != 0L))
          {
            BigInteger localBigInteger2 = new BigInteger(Long.toString(paramLong2));
            BigInteger localBigInteger1 = new BigInteger("97781173");
            BigInteger[] arrayOfBigInteger1 = new BigInteger[1];
            arrayOfBigInteger1[0] = new BigInteger(Long.toString(paramLong1));
            int[] arrayOfInt = new int[1];
            arrayOfInt[0] = paramInt;
            int i = 0;
            paramInt = 0;
            Object localObject;
            while (arrayOfInt[i] >= 33)
            {
              paramInt = arrayOfInt.length + 1;
              localObject = new int[paramInt];
              System.arraycopy(arrayOfInt, 0, localObject, 0, arrayOfInt.length);
              arrayOfInt = new int[paramInt];
              System.arraycopy(localObject, 0, arrayOfInt, 0, paramInt);
              paramInt = i + 1;
              arrayOfInt[i] /= 2;
              i = paramInt;
            }
            BigInteger[] arrayOfBigInteger2 = new BigInteger[paramInt + 1];
            arrayOfBigInteger2[paramInt] = new BigInteger("8000000B", 16);
            int j = paramInt - 1;
            i = 0;
            int k;
            for (;;)
            {
              if (i < paramInt)
              {
                int n = arrayOfInt[j] / 32;
                int m;
                do
                {
                  k = arrayOfBigInteger1.length;
                  localObject = new BigInteger[k];
                  System.arraycopy(arrayOfBigInteger1, 0, localObject, 0, arrayOfBigInteger1.length);
                  arrayOfBigInteger1 = new BigInteger[n + 1];
                  System.arraycopy(localObject, 0, arrayOfBigInteger1, 0, k);
                  for (k = 0; k < n; k = m)
                  {
                    m = k + 1;
                    arrayOfBigInteger1[m] = arrayOfBigInteger1[k].multiply(localBigInteger1).add(localBigInteger2).mod(TWO.pow(32));
                  }
                  localObject = new BigInteger("0");
                  k = 0;
                  while (k < n)
                  {
                    localObject = ((BigInteger)localObject).add(arrayOfBigInteger1[k].multiply(TWO.pow(k * 32)));
                    k += 1;
                  }
                  arrayOfBigInteger1[0] = arrayOfBigInteger1[n];
                  BigInteger localBigInteger3 = TWO.pow(arrayOfInt[j] - 1);
                  m = j + 1;
                  localBigInteger3 = localBigInteger3.divide(arrayOfBigInteger2[m]).add(TWO.pow(arrayOfInt[j] - 1).multiply((BigInteger)localObject).divide(arrayOfBigInteger2[m].multiply(TWO.pow(n * 32))));
                  localObject = localBigInteger3;
                  if (localBigInteger3.mod(TWO).compareTo(ONE) == 0) {
                    localObject = localBigInteger3.add(ONE);
                  }
                  k = 0;
                  localBigInteger3 = arrayOfBigInteger2[m];
                  paramLong1 = k;
                  arrayOfBigInteger2[j] = localBigInteger3.multiply(((BigInteger)localObject).add(BigInteger.valueOf(paramLong1))).add(ONE);
                } while (arrayOfBigInteger2[j].compareTo(TWO.pow(arrayOfInt[j])) == 1);
                if ((TWO.modPow(arrayOfBigInteger2[m].multiply(((BigInteger)localObject).add(BigInteger.valueOf(paramLong1))), arrayOfBigInteger2[j]).compareTo(ONE) == 0) && (TWO.modPow(((BigInteger)localObject).add(BigInteger.valueOf(paramLong1)), arrayOfBigInteger2[j]).compareTo(ONE) != 0))
                {
                  j -= 1;
                  if (j >= 0)
                  {
                    i += 1;
                    continue;
                  }
                  paramArrayOfBigInteger[0] = arrayOfBigInteger2[0];
                  paramArrayOfBigInteger[1] = arrayOfBigInteger2[1];
                }
              }
            }
            for (paramArrayOfBigInteger = arrayOfBigInteger1[0];; paramArrayOfBigInteger = arrayOfBigInteger1[0])
            {
              return paramArrayOfBigInteger.longValue();
              k += 2;
              break;
            }
          }
          paramLong2 = this.init_random.nextInt() * 2 + 1;
        }
      }
      paramLong1 = this.init_random.nextInt() * 2;
    }
  }
  
  private void procedure_B(int paramInt1, int paramInt2, BigInteger[] paramArrayOfBigInteger)
  {
    for (;;)
    {
      if ((paramInt1 >= 0) && (paramInt1 <= 65536)) {
        for (;;)
        {
          if ((paramInt2 >= 0) && (paramInt2 <= 65536) && (paramInt2 / 2 != 0))
          {
            Object localObject1 = new BigInteger[2];
            BigInteger localBigInteger2 = new BigInteger(Integer.toString(paramInt2));
            BigInteger localBigInteger3 = new BigInteger("19381");
            paramInt1 = procedure_A(paramInt1, paramInt2, (BigInteger[])localObject1, 256);
            Object localObject2 = localObject1[0];
            paramInt1 = procedure_A(paramInt1, paramInt2, (BigInteger[])localObject1, 512);
            BigInteger localBigInteger4 = localObject1[0];
            BigInteger[] arrayOfBigInteger = new BigInteger[65];
            arrayOfBigInteger[0] = new BigInteger(Integer.toString(paramInt1));
            for (paramInt1 = 0; paramInt1 < 64; paramInt1 = paramInt2)
            {
              paramInt2 = paramInt1 + 1;
              arrayOfBigInteger[paramInt2] = arrayOfBigInteger[paramInt1].multiply(localBigInteger3).add(localBigInteger2).mod(TWO.pow(16));
            }
            localObject1 = new BigInteger("0");
            paramInt1 = 0;
            while (paramInt1 < 64)
            {
              localObject1 = ((BigInteger)localObject1).add(arrayOfBigInteger[paramInt1].multiply(TWO.pow(paramInt1 * 16)));
              paramInt1 += 1;
            }
            arrayOfBigInteger[0] = arrayOfBigInteger[64];
            BigInteger localBigInteger1 = TWO.pow(1023).divide(((BigInteger)localObject2).multiply(localBigInteger4)).add(TWO.pow(1023).multiply((BigInteger)localObject1).divide(((BigInteger)localObject2).multiply(localBigInteger4).multiply(TWO.pow(1024))));
            localObject1 = localBigInteger1;
            if (localBigInteger1.mod(TWO).compareTo(ONE) == 0) {
              localObject1 = localBigInteger1.add(ONE);
            }
            paramInt1 = 0;
            for (;;)
            {
              localBigInteger1 = ((BigInteger)localObject2).multiply(localBigInteger4);
              long l = paramInt1;
              localBigInteger1 = localBigInteger1.multiply(((BigInteger)localObject1).add(BigInteger.valueOf(l))).add(ONE);
              if (localBigInteger1.compareTo(TWO.pow(1024)) == 1) {
                break;
              }
              if ((TWO.modPow(((BigInteger)localObject2).multiply(localBigInteger4).multiply(((BigInteger)localObject1).add(BigInteger.valueOf(l))), localBigInteger1).compareTo(ONE) == 0) && (TWO.modPow(((BigInteger)localObject2).multiply(((BigInteger)localObject1).add(BigInteger.valueOf(l))), localBigInteger1).compareTo(ONE) != 0))
              {
                paramArrayOfBigInteger[0] = localBigInteger1;
                paramArrayOfBigInteger[1] = localObject2;
                return;
              }
              paramInt1 += 2;
            }
          }
          paramInt2 = this.init_random.nextInt() / 32768 + 1;
        }
      }
      paramInt1 = this.init_random.nextInt() / 32768;
    }
  }
  
  private void procedure_Bb(long paramLong1, long paramLong2, BigInteger[] paramArrayOfBigInteger)
  {
    for (;;)
    {
      if ((paramLong1 >= 0L) && (paramLong1 <= 4294967296L)) {
        for (;;)
        {
          if ((paramLong2 >= 0L) && (paramLong2 <= 4294967296L) && (paramLong2 / 2L != 0L))
          {
            Object localObject1 = new BigInteger[2];
            BigInteger localBigInteger2 = new BigInteger(Long.toString(paramLong2));
            BigInteger localBigInteger3 = new BigInteger("97781173");
            paramLong1 = procedure_Aa(paramLong1, paramLong2, (BigInteger[])localObject1, 256);
            Object localObject2 = localObject1[0];
            paramLong1 = procedure_Aa(paramLong1, paramLong2, (BigInteger[])localObject1, 512);
            BigInteger localBigInteger4 = localObject1[0];
            BigInteger[] arrayOfBigInteger = new BigInteger[33];
            arrayOfBigInteger[0] = new BigInteger(Long.toString(paramLong1));
            int j;
            for (int i = 0; i < 32; i = j)
            {
              j = i + 1;
              arrayOfBigInteger[j] = arrayOfBigInteger[i].multiply(localBigInteger3).add(localBigInteger2).mod(TWO.pow(32));
            }
            localObject1 = new BigInteger("0");
            i = 0;
            while (i < 32)
            {
              localObject1 = ((BigInteger)localObject1).add(arrayOfBigInteger[i].multiply(TWO.pow(i * 32)));
              i += 1;
            }
            arrayOfBigInteger[0] = arrayOfBigInteger[32];
            BigInteger localBigInteger1 = TWO.pow(1023).divide(((BigInteger)localObject2).multiply(localBigInteger4)).add(TWO.pow(1023).multiply((BigInteger)localObject1).divide(((BigInteger)localObject2).multiply(localBigInteger4).multiply(TWO.pow(1024))));
            localObject1 = localBigInteger1;
            if (localBigInteger1.mod(TWO).compareTo(ONE) == 0) {
              localObject1 = localBigInteger1.add(ONE);
            }
            i = 0;
            for (;;)
            {
              localBigInteger1 = ((BigInteger)localObject2).multiply(localBigInteger4);
              paramLong1 = i;
              localBigInteger1 = localBigInteger1.multiply(((BigInteger)localObject1).add(BigInteger.valueOf(paramLong1))).add(ONE);
              if (localBigInteger1.compareTo(TWO.pow(1024)) == 1) {
                break;
              }
              if ((TWO.modPow(((BigInteger)localObject2).multiply(localBigInteger4).multiply(((BigInteger)localObject1).add(BigInteger.valueOf(paramLong1))), localBigInteger1).compareTo(ONE) == 0) && (TWO.modPow(((BigInteger)localObject2).multiply(((BigInteger)localObject1).add(BigInteger.valueOf(paramLong1))), localBigInteger1).compareTo(ONE) != 0))
              {
                paramArrayOfBigInteger[0] = localBigInteger1;
                paramArrayOfBigInteger[1] = localObject2;
                return;
              }
              i += 2;
            }
          }
          paramLong2 = this.init_random.nextInt() * 2 + 1;
        }
      }
      paramLong1 = this.init_random.nextInt() * 2;
    }
  }
  
  private BigInteger procedure_C(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    BigInteger localBigInteger1 = paramBigInteger1.subtract(ONE);
    paramBigInteger2 = localBigInteger1.divide(paramBigInteger2);
    int i = paramBigInteger1.bitLength();
    BigInteger localBigInteger2;
    do
    {
      do
      {
        localBigInteger2 = new BigInteger(i, this.init_random);
      } while ((localBigInteger2.compareTo(ONE) <= 0) || (localBigInteger2.compareTo(localBigInteger1) >= 0));
      localBigInteger2 = localBigInteger2.modPow(paramBigInteger2, paramBigInteger1);
    } while (localBigInteger2.compareTo(ONE) == 0);
    return localBigInteger2;
  }
  
  public GOST3410Parameters generateParameters()
  {
    Object localObject = new BigInteger[2];
    if (this.typeproc == 1)
    {
      i = this.init_random.nextInt();
      int j = this.init_random.nextInt();
      int k = this.size;
      if (k != 512)
      {
        if (k == 1024) {
          procedure_B(i, j, (BigInteger[])localObject);
        } else {
          throw new IllegalArgumentException("Ooops! key size 512 or 1024 bit.");
        }
      }
      else {
        procedure_A(i, j, (BigInteger[])localObject, 512);
      }
      localBigInteger = localObject[0];
      localObject = localObject[1];
      return new GOST3410Parameters(localBigInteger, (BigInteger)localObject, procedure_C(localBigInteger, (BigInteger)localObject), new GOST3410ValidationParameters(i, j));
    }
    long l1 = this.init_random.nextLong();
    long l2 = this.init_random.nextLong();
    int i = this.size;
    if (i != 512)
    {
      if (i == 1024) {
        procedure_Bb(l1, l2, (BigInteger[])localObject);
      } else {
        throw new IllegalStateException("Ooops! key size 512 or 1024 bit.");
      }
    }
    else {
      procedure_Aa(l1, l2, (BigInteger[])localObject, 512);
    }
    BigInteger localBigInteger = localObject[0];
    localObject = localObject[1];
    return new GOST3410Parameters(localBigInteger, (BigInteger)localObject, procedure_C(localBigInteger, (BigInteger)localObject), new GOST3410ValidationParameters(l1, l2));
  }
  
  public void init(int paramInt1, int paramInt2, SecureRandom paramSecureRandom)
  {
    this.size = paramInt1;
    this.typeproc = paramInt2;
    this.init_random = paramSecureRandom;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\GOST3410ParametersGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */