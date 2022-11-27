package org.bouncycastle.pqc.math.linearalgebra;

import java.math.BigInteger;
import java.util.Random;

public class GF2Polynomial
{
  private static final int[] bitMask = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, Integer.MIN_VALUE, 0 };
  private static final boolean[] parity;
  private static Random rand = new Random();
  private static final int[] reverseRightMask = { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1 };
  private static final short[] squaringTable;
  private int blocks;
  private int len;
  private int[] value;
  
  static
  {
    parity = new boolean[] { 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0 };
    squaringTable = new short[] { 0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, 1024, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, 16384, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845 };
  }
  
  public GF2Polynomial(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    paramInt = (i - 1 >> 5) + 1;
    this.blocks = paramInt;
    this.value = new int[paramInt];
    this.len = i;
  }
  
  public GF2Polynomial(int paramInt, String paramString)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    paramInt = (i - 1 >> 5) + 1;
    this.blocks = paramInt;
    this.value = new int[paramInt];
    this.len = i;
    if (paramString.equalsIgnoreCase("ZERO"))
    {
      assignZero();
      return;
    }
    if (paramString.equalsIgnoreCase("ONE"))
    {
      assignOne();
      return;
    }
    if (paramString.equalsIgnoreCase("RANDOM"))
    {
      randomize();
      return;
    }
    if (paramString.equalsIgnoreCase("X"))
    {
      assignX();
      return;
    }
    if (paramString.equalsIgnoreCase("ALL"))
    {
      assignAll();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Error: GF2Polynomial was called using ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" as value!");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public GF2Polynomial(int paramInt, BigInteger paramBigInteger)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    paramInt = (i - 1 >> 5) + 1;
    this.blocks = paramInt;
    this.value = new int[paramInt];
    this.len = i;
    Object localObject = paramBigInteger.toByteArray();
    int j = 0;
    paramBigInteger = (BigInteger)localObject;
    if (localObject[0] == 0)
    {
      paramInt = localObject.length - 1;
      paramBigInteger = new byte[paramInt];
      System.arraycopy(localObject, 1, paramBigInteger, 0, paramInt);
    }
    int k = paramBigInteger.length & 0x3;
    int m = paramBigInteger.length;
    i = 0;
    for (;;)
    {
      paramInt = j;
      if (i >= k) {
        break;
      }
      localObject = this.value;
      paramInt = (m - 1 >> 2) + 1 - 1;
      localObject[paramInt] |= (paramBigInteger[i] & 0xFF) << (k - 1 - i << 3);
      i += 1;
    }
    while (paramInt <= paramBigInteger.length - 4 >> 2)
    {
      i = paramBigInteger.length - 1 - (paramInt << 2);
      localObject = this.value;
      paramBigInteger[i] &= 0xFF;
      localObject[paramInt] |= paramBigInteger[(i - 1)] << 8 & 0xFF00;
      localObject[paramInt] |= paramBigInteger[(i - 2)] << 16 & 0xFF0000;
      j = localObject[paramInt];
      localObject[paramInt] = (paramBigInteger[(i - 3)] << 24 & 0xFF000000 | j);
      paramInt += 1;
    }
    paramInt = this.len;
    if ((paramInt & 0x1F) != 0)
    {
      paramBigInteger = this.value;
      i = this.blocks - 1;
      j = paramBigInteger[i];
      paramBigInteger[i] = (reverseRightMask[(paramInt & 0x1F)] & j);
    }
    reduceN();
  }
  
  public GF2Polynomial(int paramInt, Random paramRandom)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    paramInt = (i - 1 >> 5) + 1;
    this.blocks = paramInt;
    this.value = new int[paramInt];
    this.len = i;
    randomize(paramRandom);
  }
  
  public GF2Polynomial(int paramInt, byte[] paramArrayOfByte)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    paramInt = (i - 1 >> 5) + 1;
    this.blocks = paramInt;
    this.value = new int[paramInt];
    this.len = i;
    i = Math.min((paramArrayOfByte.length - 1 >> 2) + 1, paramInt);
    paramInt = 0;
    int j;
    for (;;)
    {
      j = i - 1;
      if (paramInt >= j) {
        break;
      }
      j = paramArrayOfByte.length - (paramInt << 2) - 1;
      arrayOfInt = this.value;
      paramArrayOfByte[j] &= 0xFF;
      int k = arrayOfInt[paramInt];
      arrayOfInt[paramInt] = (0xFF00 & paramArrayOfByte[(j - 1)] << 8 | k);
      k = arrayOfInt[paramInt];
      arrayOfInt[paramInt] = (0xFF0000 & paramArrayOfByte[(j - 2)] << 16 | k);
      k = arrayOfInt[paramInt];
      arrayOfInt[paramInt] = (paramArrayOfByte[(j - 3)] << 24 & 0xFF000000 | k);
      paramInt += 1;
    }
    paramInt = paramArrayOfByte.length - (j << 2) - 1;
    int[] arrayOfInt = this.value;
    paramArrayOfByte[paramInt] &= 0xFF;
    if (paramInt > 0)
    {
      i = arrayOfInt[j];
      arrayOfInt[j] = (0xFF00 & paramArrayOfByte[(paramInt - 1)] << 8 | i);
    }
    if (paramInt > 1)
    {
      arrayOfInt = this.value;
      arrayOfInt[j] |= 0xFF0000 & paramArrayOfByte[(paramInt - 2)] << 16;
    }
    if (paramInt > 2)
    {
      arrayOfInt = this.value;
      i = arrayOfInt[j];
      arrayOfInt[j] = (paramArrayOfByte[(paramInt - 3)] << 24 & 0xFF000000 | i);
    }
    zeroUnusedBits();
    reduceN();
  }
  
  public GF2Polynomial(int paramInt, int[] paramArrayOfInt)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    paramInt = (i - 1 >> 5) + 1;
    this.blocks = paramInt;
    this.value = new int[paramInt];
    this.len = i;
    paramInt = Math.min(paramInt, paramArrayOfInt.length);
    System.arraycopy(paramArrayOfInt, 0, this.value, 0, paramInt);
    zeroUnusedBits();
  }
  
  public GF2Polynomial(GF2Polynomial paramGF2Polynomial)
  {
    this.len = paramGF2Polynomial.len;
    this.blocks = paramGF2Polynomial.blocks;
    this.value = IntUtils.clone(paramGF2Polynomial.value);
  }
  
  private void doShiftBlocksLeft(int paramInt)
  {
    int i = this.blocks;
    int[] arrayOfInt1 = this.value;
    if (i <= arrayOfInt1.length)
    {
      i -= 1;
      while (i >= paramInt)
      {
        arrayOfInt1 = this.value;
        arrayOfInt1[i] = arrayOfInt1[(i - paramInt)];
        i -= 1;
      }
      i = 0;
      while (i < paramInt)
      {
        this.value[i] = 0;
        i += 1;
      }
    }
    int[] arrayOfInt2 = new int[i];
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, paramInt, i - paramInt);
    this.value = null;
    this.value = arrayOfInt2;
  }
  
  private GF2Polynomial karaMult(GF2Polynomial paramGF2Polynomial)
  {
    GF2Polynomial localGF2Polynomial1 = new GF2Polynomial(this.len << 1);
    int i = this.len;
    if (i <= 32)
    {
      localGF2Polynomial1.value = mult32(this.value[0], paramGF2Polynomial.value[0]);
      return localGF2Polynomial1;
    }
    if (i <= 64)
    {
      localGF2Polynomial1.value = mult64(this.value, paramGF2Polynomial.value);
      return localGF2Polynomial1;
    }
    if (i <= 128)
    {
      localGF2Polynomial1.value = mult128(this.value, paramGF2Polynomial.value);
      return localGF2Polynomial1;
    }
    if (i <= 256)
    {
      localGF2Polynomial1.value = mult256(this.value, paramGF2Polynomial.value);
      return localGF2Polynomial1;
    }
    if (i <= 512)
    {
      localGF2Polynomial1.value = mult512(this.value, paramGF2Polynomial.value);
      return localGF2Polynomial1;
    }
    i = IntegerFunctions.floorLog(i - 1);
    i = bitMask[i];
    int j = (i - 1 >> 5) + 1;
    GF2Polynomial localGF2Polynomial2 = lower(j);
    GF2Polynomial localGF2Polynomial3 = upper(j);
    GF2Polynomial localGF2Polynomial4 = paramGF2Polynomial.lower(j);
    GF2Polynomial localGF2Polynomial6 = paramGF2Polynomial.upper(j);
    paramGF2Polynomial = localGF2Polynomial3.karaMult(localGF2Polynomial6);
    GF2Polynomial localGF2Polynomial5 = localGF2Polynomial2.karaMult(localGF2Polynomial4);
    localGF2Polynomial2.addToThis(localGF2Polynomial3);
    localGF2Polynomial4.addToThis(localGF2Polynomial6);
    localGF2Polynomial2 = localGF2Polynomial2.karaMult(localGF2Polynomial4);
    localGF2Polynomial1.shiftLeftAddThis(paramGF2Polynomial, i << 1);
    localGF2Polynomial1.shiftLeftAddThis(paramGF2Polynomial, i);
    localGF2Polynomial1.shiftLeftAddThis(localGF2Polynomial2, i);
    localGF2Polynomial1.shiftLeftAddThis(localGF2Polynomial5, i);
    localGF2Polynomial1.addToThis(localGF2Polynomial5);
    return localGF2Polynomial1;
  }
  
  private GF2Polynomial lower(int paramInt)
  {
    GF2Polynomial localGF2Polynomial = new GF2Polynomial(paramInt << 5);
    System.arraycopy(this.value, 0, localGF2Polynomial.value, 0, Math.min(paramInt, this.blocks));
    return localGF2Polynomial;
  }
  
  private static int[] mult128(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt1 = new int[8];
    int[] arrayOfInt2 = new int[2];
    System.arraycopy(paramArrayOfInt1, 0, arrayOfInt2, 0, Math.min(2, paramArrayOfInt1.length));
    int[] arrayOfInt3 = new int[2];
    if (paramArrayOfInt1.length > 2) {
      System.arraycopy(paramArrayOfInt1, 2, arrayOfInt3, 0, Math.min(2, paramArrayOfInt1.length - 2));
    }
    paramArrayOfInt1 = new int[2];
    System.arraycopy(paramArrayOfInt2, 0, paramArrayOfInt1, 0, Math.min(2, paramArrayOfInt2.length));
    int[] arrayOfInt4 = new int[2];
    if (paramArrayOfInt2.length > 2) {
      System.arraycopy(paramArrayOfInt2, 2, arrayOfInt4, 0, Math.min(2, paramArrayOfInt2.length - 2));
    }
    if ((arrayOfInt3[1] == 0) && (arrayOfInt4[1] == 0))
    {
      if ((arrayOfInt3[0] != 0) || (arrayOfInt4[0] != 0))
      {
        paramArrayOfInt2 = mult32(arrayOfInt3[0], arrayOfInt4[0]);
        arrayOfInt1[5] ^= paramArrayOfInt2[1];
        arrayOfInt1[4] ^= paramArrayOfInt2[0];
        arrayOfInt1[3] ^= paramArrayOfInt2[1];
        i = arrayOfInt1[2];
        arrayOfInt1[2] = (paramArrayOfInt2[0] ^ i);
      }
    }
    else
    {
      paramArrayOfInt2 = mult64(arrayOfInt3, arrayOfInt4);
      arrayOfInt1[7] ^= paramArrayOfInt2[3];
      arrayOfInt1[6] ^= paramArrayOfInt2[2];
      arrayOfInt1[5] ^= paramArrayOfInt2[1] ^ paramArrayOfInt2[3];
      arrayOfInt1[4] ^= paramArrayOfInt2[0] ^ paramArrayOfInt2[2];
      arrayOfInt1[3] ^= paramArrayOfInt2[1];
      i = arrayOfInt1[2];
      arrayOfInt1[2] = (paramArrayOfInt2[0] ^ i);
    }
    arrayOfInt3[0] ^= arrayOfInt2[0];
    arrayOfInt3[1] ^= arrayOfInt2[1];
    arrayOfInt4[0] ^= paramArrayOfInt1[0];
    arrayOfInt4[1] ^= paramArrayOfInt1[1];
    if ((arrayOfInt3[1] == 0) && (arrayOfInt4[1] == 0))
    {
      paramArrayOfInt2 = mult32(arrayOfInt3[0], arrayOfInt4[0]);
      arrayOfInt1[3] ^= paramArrayOfInt2[1];
      i = arrayOfInt1[2];
      arrayOfInt1[2] = (paramArrayOfInt2[0] ^ i);
    }
    else
    {
      paramArrayOfInt2 = mult64(arrayOfInt3, arrayOfInt4);
      arrayOfInt1[5] ^= paramArrayOfInt2[3];
      arrayOfInt1[4] ^= paramArrayOfInt2[2];
      arrayOfInt1[3] ^= paramArrayOfInt2[1];
      i = arrayOfInt1[2];
      arrayOfInt1[2] = (paramArrayOfInt2[0] ^ i);
    }
    if ((arrayOfInt2[1] == 0) && (paramArrayOfInt1[1] == 0))
    {
      paramArrayOfInt1 = mult32(arrayOfInt2[0], paramArrayOfInt1[0]);
      arrayOfInt1[3] ^= paramArrayOfInt1[1];
      arrayOfInt1[2] ^= paramArrayOfInt1[0];
      arrayOfInt1[1] ^= paramArrayOfInt1[1];
      i = arrayOfInt1[0];
      paramArrayOfInt1[0] ^= i;
      return arrayOfInt1;
    }
    paramArrayOfInt1 = mult64(arrayOfInt2, paramArrayOfInt1);
    arrayOfInt1[5] ^= paramArrayOfInt1[3];
    arrayOfInt1[4] ^= paramArrayOfInt1[2];
    arrayOfInt1[3] ^= paramArrayOfInt1[1] ^ paramArrayOfInt1[3];
    arrayOfInt1[2] ^= paramArrayOfInt1[0] ^ paramArrayOfInt1[2];
    arrayOfInt1[1] ^= paramArrayOfInt1[1];
    int i = arrayOfInt1[0];
    paramArrayOfInt1[0] ^= i;
    return arrayOfInt1;
  }
  
  private static int[] mult256(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt1 = new int[16];
    int[] arrayOfInt2 = new int[4];
    System.arraycopy(paramArrayOfInt1, 0, arrayOfInt2, 0, Math.min(4, paramArrayOfInt1.length));
    int[] arrayOfInt3 = new int[4];
    if (paramArrayOfInt1.length > 4) {
      System.arraycopy(paramArrayOfInt1, 4, arrayOfInt3, 0, Math.min(4, paramArrayOfInt1.length - 4));
    }
    paramArrayOfInt1 = new int[4];
    System.arraycopy(paramArrayOfInt2, 0, paramArrayOfInt1, 0, Math.min(4, paramArrayOfInt2.length));
    int[] arrayOfInt4 = new int[4];
    if (paramArrayOfInt2.length > 4) {
      System.arraycopy(paramArrayOfInt2, 4, arrayOfInt4, 0, Math.min(4, paramArrayOfInt2.length - 4));
    }
    if ((arrayOfInt3[3] == 0) && (arrayOfInt3[2] == 0) && (arrayOfInt4[3] == 0) && (arrayOfInt4[2] == 0))
    {
      if ((arrayOfInt3[1] == 0) && (arrayOfInt4[1] == 0))
      {
        if ((arrayOfInt3[0] != 0) || (arrayOfInt4[0] != 0))
        {
          paramArrayOfInt2 = mult32(arrayOfInt3[0], arrayOfInt4[0]);
          arrayOfInt1[9] ^= paramArrayOfInt2[1];
          arrayOfInt1[8] ^= paramArrayOfInt2[0];
          arrayOfInt1[5] ^= paramArrayOfInt2[1];
          i = arrayOfInt1[4];
          arrayOfInt1[4] = (paramArrayOfInt2[0] ^ i);
        }
      }
      else
      {
        paramArrayOfInt2 = mult64(arrayOfInt3, arrayOfInt4);
        arrayOfInt1[11] ^= paramArrayOfInt2[3];
        arrayOfInt1[10] ^= paramArrayOfInt2[2];
        arrayOfInt1[9] ^= paramArrayOfInt2[1];
        arrayOfInt1[8] ^= paramArrayOfInt2[0];
        arrayOfInt1[7] ^= paramArrayOfInt2[3];
        arrayOfInt1[6] ^= paramArrayOfInt2[2];
        arrayOfInt1[5] ^= paramArrayOfInt2[1];
        i = arrayOfInt1[4];
        arrayOfInt1[4] = (paramArrayOfInt2[0] ^ i);
      }
    }
    else
    {
      paramArrayOfInt2 = mult128(arrayOfInt3, arrayOfInt4);
      arrayOfInt1[15] ^= paramArrayOfInt2[7];
      arrayOfInt1[14] ^= paramArrayOfInt2[6];
      arrayOfInt1[13] ^= paramArrayOfInt2[5];
      arrayOfInt1[12] ^= paramArrayOfInt2[4];
      arrayOfInt1[11] ^= paramArrayOfInt2[3] ^ paramArrayOfInt2[7];
      arrayOfInt1[10] ^= paramArrayOfInt2[2] ^ paramArrayOfInt2[6];
      arrayOfInt1[9] ^= paramArrayOfInt2[1] ^ paramArrayOfInt2[5];
      arrayOfInt1[8] ^= paramArrayOfInt2[0] ^ paramArrayOfInt2[4];
      arrayOfInt1[7] ^= paramArrayOfInt2[3];
      arrayOfInt1[6] ^= paramArrayOfInt2[2];
      arrayOfInt1[5] ^= paramArrayOfInt2[1];
      i = arrayOfInt1[4];
      arrayOfInt1[4] = (paramArrayOfInt2[0] ^ i);
    }
    arrayOfInt3[0] ^= arrayOfInt2[0];
    arrayOfInt3[1] ^= arrayOfInt2[1];
    arrayOfInt3[2] ^= arrayOfInt2[2];
    arrayOfInt3[3] ^= arrayOfInt2[3];
    arrayOfInt4[0] ^= paramArrayOfInt1[0];
    arrayOfInt4[1] ^= paramArrayOfInt1[1];
    arrayOfInt4[2] ^= paramArrayOfInt1[2];
    arrayOfInt4[3] ^= paramArrayOfInt1[3];
    paramArrayOfInt2 = mult128(arrayOfInt3, arrayOfInt4);
    arrayOfInt1[11] ^= paramArrayOfInt2[7];
    arrayOfInt1[10] ^= paramArrayOfInt2[6];
    arrayOfInt1[9] ^= paramArrayOfInt2[5];
    arrayOfInt1[8] ^= paramArrayOfInt2[4];
    arrayOfInt1[7] ^= paramArrayOfInt2[3];
    arrayOfInt1[6] ^= paramArrayOfInt2[2];
    arrayOfInt1[5] ^= paramArrayOfInt2[1];
    int i = arrayOfInt1[4];
    arrayOfInt1[4] = (paramArrayOfInt2[0] ^ i);
    paramArrayOfInt1 = mult128(arrayOfInt2, paramArrayOfInt1);
    arrayOfInt1[11] ^= paramArrayOfInt1[7];
    arrayOfInt1[10] ^= paramArrayOfInt1[6];
    arrayOfInt1[9] ^= paramArrayOfInt1[5];
    arrayOfInt1[8] ^= paramArrayOfInt1[4];
    arrayOfInt1[7] ^= paramArrayOfInt1[3] ^ paramArrayOfInt1[7];
    arrayOfInt1[6] ^= paramArrayOfInt1[2] ^ paramArrayOfInt1[6];
    arrayOfInt1[5] ^= paramArrayOfInt1[1] ^ paramArrayOfInt1[5];
    arrayOfInt1[4] ^= paramArrayOfInt1[0] ^ paramArrayOfInt1[4];
    arrayOfInt1[3] ^= paramArrayOfInt1[3];
    arrayOfInt1[2] ^= paramArrayOfInt1[2];
    arrayOfInt1[1] ^= paramArrayOfInt1[1];
    i = arrayOfInt1[0];
    paramArrayOfInt1[0] ^= i;
    return arrayOfInt1;
  }
  
  private static int[] mult32(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return arrayOfInt;
      }
      long l1 = paramInt2 & 0xFFFFFFFF;
      long l2 = 0L;
      paramInt2 = 1;
      while (paramInt2 <= 32)
      {
        long l3 = l2;
        if ((bitMask[(paramInt2 - 1)] & paramInt1) != 0) {
          l3 = l2 ^ l1;
        }
        l1 <<= 1;
        paramInt2 += 1;
        l2 = l3;
      }
      arrayOfInt[1] = ((int)(l2 >>> 32));
      arrayOfInt[0] = ((int)(l2 & 0xFFFFFFFF));
    }
    return arrayOfInt;
  }
  
  private static int[] mult512(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt1 = new int[32];
    int[] arrayOfInt2 = new int[8];
    System.arraycopy(paramArrayOfInt1, 0, arrayOfInt2, 0, Math.min(8, paramArrayOfInt1.length));
    int[] arrayOfInt3 = new int[8];
    if (paramArrayOfInt1.length > 8) {
      System.arraycopy(paramArrayOfInt1, 8, arrayOfInt3, 0, Math.min(8, paramArrayOfInt1.length - 8));
    }
    paramArrayOfInt1 = new int[8];
    System.arraycopy(paramArrayOfInt2, 0, paramArrayOfInt1, 0, Math.min(8, paramArrayOfInt2.length));
    int[] arrayOfInt4 = new int[8];
    if (paramArrayOfInt2.length > 8) {
      System.arraycopy(paramArrayOfInt2, 8, arrayOfInt4, 0, Math.min(8, paramArrayOfInt2.length - 8));
    }
    paramArrayOfInt2 = mult256(arrayOfInt3, arrayOfInt4);
    arrayOfInt1[31] ^= paramArrayOfInt2[15];
    arrayOfInt1[30] ^= paramArrayOfInt2[14];
    arrayOfInt1[29] ^= paramArrayOfInt2[13];
    arrayOfInt1[28] ^= paramArrayOfInt2[12];
    arrayOfInt1[27] ^= paramArrayOfInt2[11];
    arrayOfInt1[26] ^= paramArrayOfInt2[10];
    arrayOfInt1[25] ^= paramArrayOfInt2[9];
    arrayOfInt1[24] ^= paramArrayOfInt2[8];
    arrayOfInt1[23] ^= paramArrayOfInt2[7] ^ paramArrayOfInt2[15];
    arrayOfInt1[22] ^= paramArrayOfInt2[6] ^ paramArrayOfInt2[14];
    arrayOfInt1[21] ^= paramArrayOfInt2[5] ^ paramArrayOfInt2[13];
    arrayOfInt1[20] ^= paramArrayOfInt2[4] ^ paramArrayOfInt2[12];
    arrayOfInt1[19] ^= paramArrayOfInt2[3] ^ paramArrayOfInt2[11];
    arrayOfInt1[18] ^= paramArrayOfInt2[2] ^ paramArrayOfInt2[10];
    arrayOfInt1[17] ^= paramArrayOfInt2[1] ^ paramArrayOfInt2[9];
    arrayOfInt1[16] ^= paramArrayOfInt2[0] ^ paramArrayOfInt2[8];
    arrayOfInt1[15] ^= paramArrayOfInt2[7];
    arrayOfInt1[14] ^= paramArrayOfInt2[6];
    arrayOfInt1[13] ^= paramArrayOfInt2[5];
    arrayOfInt1[12] ^= paramArrayOfInt2[4];
    arrayOfInt1[11] ^= paramArrayOfInt2[3];
    arrayOfInt1[10] ^= paramArrayOfInt2[2];
    arrayOfInt1[9] ^= paramArrayOfInt2[1];
    arrayOfInt1[8] ^= paramArrayOfInt2[0];
    arrayOfInt3[0] ^= arrayOfInt2[0];
    arrayOfInt3[1] ^= arrayOfInt2[1];
    arrayOfInt3[2] ^= arrayOfInt2[2];
    arrayOfInt3[3] ^= arrayOfInt2[3];
    arrayOfInt3[4] ^= arrayOfInt2[4];
    arrayOfInt3[5] ^= arrayOfInt2[5];
    arrayOfInt3[6] ^= arrayOfInt2[6];
    arrayOfInt3[7] ^= arrayOfInt2[7];
    arrayOfInt4[0] ^= paramArrayOfInt1[0];
    arrayOfInt4[1] ^= paramArrayOfInt1[1];
    arrayOfInt4[2] ^= paramArrayOfInt1[2];
    arrayOfInt4[3] ^= paramArrayOfInt1[3];
    arrayOfInt4[4] ^= paramArrayOfInt1[4];
    arrayOfInt4[5] ^= paramArrayOfInt1[5];
    arrayOfInt4[6] ^= paramArrayOfInt1[6];
    arrayOfInt4[7] ^= paramArrayOfInt1[7];
    paramArrayOfInt2 = mult256(arrayOfInt3, arrayOfInt4);
    arrayOfInt1[23] ^= paramArrayOfInt2[15];
    arrayOfInt1[22] ^= paramArrayOfInt2[14];
    arrayOfInt1[21] ^= paramArrayOfInt2[13];
    arrayOfInt1[20] ^= paramArrayOfInt2[12];
    arrayOfInt1[19] ^= paramArrayOfInt2[11];
    arrayOfInt1[18] ^= paramArrayOfInt2[10];
    arrayOfInt1[17] ^= paramArrayOfInt2[9];
    arrayOfInt1[16] ^= paramArrayOfInt2[8];
    arrayOfInt1[15] ^= paramArrayOfInt2[7];
    arrayOfInt1[14] ^= paramArrayOfInt2[6];
    arrayOfInt1[13] ^= paramArrayOfInt2[5];
    arrayOfInt1[12] ^= paramArrayOfInt2[4];
    arrayOfInt1[11] ^= paramArrayOfInt2[3];
    arrayOfInt1[10] ^= paramArrayOfInt2[2];
    arrayOfInt1[9] ^= paramArrayOfInt2[1];
    int i = arrayOfInt1[8];
    arrayOfInt1[8] = (paramArrayOfInt2[0] ^ i);
    paramArrayOfInt1 = mult256(arrayOfInt2, paramArrayOfInt1);
    arrayOfInt1[23] ^= paramArrayOfInt1[15];
    arrayOfInt1[22] ^= paramArrayOfInt1[14];
    arrayOfInt1[21] ^= paramArrayOfInt1[13];
    arrayOfInt1[20] ^= paramArrayOfInt1[12];
    arrayOfInt1[19] ^= paramArrayOfInt1[11];
    arrayOfInt1[18] ^= paramArrayOfInt1[10];
    arrayOfInt1[17] ^= paramArrayOfInt1[9];
    arrayOfInt1[16] ^= paramArrayOfInt1[8];
    arrayOfInt1[15] ^= paramArrayOfInt1[7] ^ paramArrayOfInt1[15];
    arrayOfInt1[14] ^= paramArrayOfInt1[6] ^ paramArrayOfInt1[14];
    arrayOfInt1[13] ^= paramArrayOfInt1[5] ^ paramArrayOfInt1[13];
    arrayOfInt1[12] ^= paramArrayOfInt1[4] ^ paramArrayOfInt1[12];
    arrayOfInt1[11] ^= paramArrayOfInt1[3] ^ paramArrayOfInt1[11];
    arrayOfInt1[10] ^= paramArrayOfInt1[2] ^ paramArrayOfInt1[10];
    arrayOfInt1[9] ^= paramArrayOfInt1[1] ^ paramArrayOfInt1[9];
    arrayOfInt1[8] ^= paramArrayOfInt1[0] ^ paramArrayOfInt1[8];
    arrayOfInt1[7] ^= paramArrayOfInt1[7];
    arrayOfInt1[6] ^= paramArrayOfInt1[6];
    arrayOfInt1[5] ^= paramArrayOfInt1[5];
    arrayOfInt1[4] ^= paramArrayOfInt1[4];
    arrayOfInt1[3] ^= paramArrayOfInt1[3];
    arrayOfInt1[2] ^= paramArrayOfInt1[2];
    arrayOfInt1[1] ^= paramArrayOfInt1[1];
    i = arrayOfInt1[0];
    paramArrayOfInt1[0] ^= i;
    return arrayOfInt1;
  }
  
  private static int[] mult64(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = new int[4];
    int k = paramArrayOfInt1[0];
    if (paramArrayOfInt1.length > 1) {
      i = paramArrayOfInt1[1];
    } else {
      i = 0;
    }
    int m = paramArrayOfInt2[0];
    int j;
    if (paramArrayOfInt2.length > 1) {
      j = paramArrayOfInt2[1];
    } else {
      j = 0;
    }
    if ((i != 0) || (j != 0))
    {
      paramArrayOfInt1 = mult32(i, j);
      arrayOfInt[3] ^= paramArrayOfInt1[1];
      arrayOfInt[2] ^= paramArrayOfInt1[0] ^ paramArrayOfInt1[1];
      int n = arrayOfInt[1];
      arrayOfInt[1] = (paramArrayOfInt1[0] ^ n);
    }
    paramArrayOfInt1 = mult32(i ^ k, j ^ m);
    arrayOfInt[2] ^= paramArrayOfInt1[1];
    int i = arrayOfInt[1];
    arrayOfInt[1] = (paramArrayOfInt1[0] ^ i);
    paramArrayOfInt1 = mult32(k, m);
    arrayOfInt[2] ^= paramArrayOfInt1[1];
    arrayOfInt[1] ^= paramArrayOfInt1[0] ^ paramArrayOfInt1[1];
    i = arrayOfInt[0];
    paramArrayOfInt1[0] ^= i;
    return arrayOfInt;
  }
  
  private GF2Polynomial upper(int paramInt)
  {
    int i = Math.min(paramInt, this.blocks - paramInt);
    GF2Polynomial localGF2Polynomial = new GF2Polynomial(i << 5);
    if (this.blocks >= paramInt) {
      System.arraycopy(this.value, paramInt, localGF2Polynomial.value, 0, i);
    }
    return localGF2Polynomial;
  }
  
  private void zeroUnusedBits()
  {
    int i = this.len;
    if ((i & 0x1F) != 0)
    {
      int[] arrayOfInt = this.value;
      int j = this.blocks - 1;
      int k = arrayOfInt[j];
      arrayOfInt[j] = (reverseRightMask[(i & 0x1F)] & k);
    }
  }
  
  public GF2Polynomial add(GF2Polynomial paramGF2Polynomial)
  {
    return xor(paramGF2Polynomial);
  }
  
  public void addToThis(GF2Polynomial paramGF2Polynomial)
  {
    expandN(paramGF2Polynomial.len);
    xorThisBy(paramGF2Polynomial);
  }
  
  public void assignAll()
  {
    int i = 0;
    while (i < this.blocks)
    {
      this.value[i] = -1;
      i += 1;
    }
    zeroUnusedBits();
  }
  
  public void assignOne()
  {
    int i = 1;
    while (i < this.blocks)
    {
      this.value[i] = 0;
      i += 1;
    }
    this.value[0] = 1;
  }
  
  public void assignX()
  {
    int i = 1;
    while (i < this.blocks)
    {
      this.value[i] = 0;
      i += 1;
    }
    this.value[0] = 2;
  }
  
  public void assignZero()
  {
    int i = 0;
    while (i < this.blocks)
    {
      this.value[i] = 0;
      i += 1;
    }
  }
  
  public Object clone()
  {
    return new GF2Polynomial(this);
  }
  
  public GF2Polynomial[] divide(GF2Polynomial paramGF2Polynomial)
    throws RuntimeException
  {
    GF2Polynomial[] arrayOfGF2Polynomial = new GF2Polynomial[2];
    GF2Polynomial localGF2Polynomial1 = new GF2Polynomial(this.len);
    GF2Polynomial localGF2Polynomial2 = new GF2Polynomial(this);
    paramGF2Polynomial = new GF2Polynomial(paramGF2Polynomial);
    if (!paramGF2Polynomial.isZero())
    {
      localGF2Polynomial2.reduceN();
      paramGF2Polynomial.reduceN();
      int i = localGF2Polynomial2.len;
      int j = paramGF2Polynomial.len;
      if (i < j)
      {
        arrayOfGF2Polynomial[0] = new GF2Polynomial(0);
        arrayOfGF2Polynomial[1] = localGF2Polynomial2;
        return arrayOfGF2Polynomial;
      }
      i -= j;
      localGF2Polynomial1.expandN(i + 1);
      while (i >= 0)
      {
        localGF2Polynomial2.subtractFromThis(paramGF2Polynomial.shiftLeft(i));
        localGF2Polynomial2.reduceN();
        localGF2Polynomial1.xorBit(i);
        i = localGF2Polynomial2.len - paramGF2Polynomial.len;
      }
      arrayOfGF2Polynomial[0] = localGF2Polynomial1;
      arrayOfGF2Polynomial[1] = localGF2Polynomial2;
      return arrayOfGF2Polynomial;
    }
    throw new RuntimeException();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof GF2Polynomial)) {
        return false;
      }
      paramObject = (GF2Polynomial)paramObject;
      if (this.len != ((GF2Polynomial)paramObject).len) {
        return false;
      }
      int i = 0;
      while (i < this.blocks)
      {
        if (this.value[i] != paramObject.value[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public void expandN(int paramInt)
  {
    if (this.len >= paramInt) {
      return;
    }
    this.len = paramInt;
    int i = (paramInt - 1 >>> 5) + 1;
    paramInt = this.blocks;
    if (paramInt >= i) {
      return;
    }
    int[] arrayOfInt1 = this.value;
    if (arrayOfInt1.length >= i)
    {
      while (paramInt < i)
      {
        this.value[paramInt] = 0;
        paramInt += 1;
      }
      this.blocks = i;
      return;
    }
    int[] arrayOfInt2 = new int[i];
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, paramInt);
    this.blocks = i;
    this.value = null;
    this.value = arrayOfInt2;
  }
  
  public GF2Polynomial gcd(GF2Polynomial paramGF2Polynomial)
    throws RuntimeException
  {
    if ((isZero()) && (paramGF2Polynomial.isZero())) {
      throw new ArithmeticException("Both operands of gcd equal zero.");
    }
    if (isZero()) {
      return new GF2Polynomial(paramGF2Polynomial);
    }
    if (paramGF2Polynomial.isZero()) {
      return new GF2Polynomial(this);
    }
    GF2Polynomial localGF2Polynomial1 = new GF2Polynomial(this);
    GF2Polynomial localGF2Polynomial2;
    for (paramGF2Polynomial = new GF2Polynomial(paramGF2Polynomial); !paramGF2Polynomial.isZero(); paramGF2Polynomial = localGF2Polynomial2)
    {
      localGF2Polynomial2 = localGF2Polynomial1.remainder(paramGF2Polynomial);
      localGF2Polynomial1 = paramGF2Polynomial;
    }
    return localGF2Polynomial1;
  }
  
  public int getBit(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > this.len - 1) {
        return 0;
      }
      int i = this.value[(paramInt >>> 5)];
      if ((bitMask[(paramInt & 0x1F)] & i) != 0) {
        return 1;
      }
      return 0;
    }
    throw new RuntimeException();
  }
  
  public int getLength()
  {
    return this.len;
  }
  
  public int hashCode()
  {
    return this.len + this.value.hashCode();
  }
  
  public GF2Polynomial increase()
  {
    GF2Polynomial localGF2Polynomial = new GF2Polynomial(this);
    localGF2Polynomial.increaseThis();
    return localGF2Polynomial;
  }
  
  public void increaseThis()
  {
    xorBit(0);
  }
  
  public boolean isIrreducible()
  {
    if (isZero()) {
      return false;
    }
    GF2Polynomial localGF2Polynomial2 = new GF2Polynomial(this);
    localGF2Polynomial2.reduceN();
    int j = localGF2Polynomial2.len;
    GF2Polynomial localGF2Polynomial1 = new GF2Polynomial(localGF2Polynomial2.len, "X");
    int i = 1;
    while (i <= j - 1 >> 1)
    {
      localGF2Polynomial1.squareThisPreCalc();
      localGF2Polynomial1 = localGF2Polynomial1.remainder(localGF2Polynomial2);
      GF2Polynomial localGF2Polynomial3 = localGF2Polynomial1.add(new GF2Polynomial(32, "X"));
      if (!localGF2Polynomial3.isZero())
      {
        if (!localGF2Polynomial2.gcd(localGF2Polynomial3).isOne()) {
          return false;
        }
        i += 1;
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public boolean isOne()
  {
    int i = 1;
    while (i < this.blocks)
    {
      if (this.value[i] != 0) {
        return false;
      }
      i += 1;
    }
    return this.value[0] == 1;
  }
  
  public boolean isZero()
  {
    if (this.len == 0) {
      return true;
    }
    int i = 0;
    while (i < this.blocks)
    {
      if (this.value[i] != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public GF2Polynomial multiply(GF2Polynomial paramGF2Polynomial)
  {
    int i = Math.max(this.len, paramGF2Polynomial.len);
    expandN(i);
    paramGF2Polynomial.expandN(i);
    return karaMult(paramGF2Polynomial);
  }
  
  public GF2Polynomial multiplyClassic(GF2Polynomial paramGF2Polynomial)
  {
    int j = Math.max(this.len, paramGF2Polynomial.len);
    int i = 1;
    GF2Polynomial localGF2Polynomial = new GF2Polynomial(j << 1);
    GF2Polynomial[] arrayOfGF2Polynomial = new GF2Polynomial[32];
    arrayOfGF2Polynomial[0] = new GF2Polynomial(this);
    while (i <= 31)
    {
      arrayOfGF2Polynomial[i] = arrayOfGF2Polynomial[(i - 1)].shiftLeft();
      i += 1;
    }
    i = 0;
    while (i < paramGF2Polynomial.blocks)
    {
      j = 0;
      while (j <= 31)
      {
        if ((paramGF2Polynomial.value[i] & bitMask[j]) != 0) {
          localGF2Polynomial.xorThisBy(arrayOfGF2Polynomial[j]);
        }
        j += 1;
      }
      j = 0;
      while (j <= 31)
      {
        arrayOfGF2Polynomial[j].shiftBlocksLeft();
        j += 1;
      }
      i += 1;
    }
    return localGF2Polynomial;
  }
  
  public GF2Polynomial quotient(GF2Polynomial paramGF2Polynomial)
    throws RuntimeException
  {
    GF2Polynomial localGF2Polynomial1 = new GF2Polynomial(this.len);
    GF2Polynomial localGF2Polynomial2 = new GF2Polynomial(this);
    paramGF2Polynomial = new GF2Polynomial(paramGF2Polynomial);
    if (!paramGF2Polynomial.isZero())
    {
      localGF2Polynomial2.reduceN();
      paramGF2Polynomial.reduceN();
      int i = localGF2Polynomial2.len;
      int j = paramGF2Polynomial.len;
      if (i < j) {
        return new GF2Polynomial(0);
      }
      i -= j;
      localGF2Polynomial1.expandN(i + 1);
      while (i >= 0)
      {
        localGF2Polynomial2.subtractFromThis(paramGF2Polynomial.shiftLeft(i));
        localGF2Polynomial2.reduceN();
        localGF2Polynomial1.xorBit(i);
        i = localGF2Polynomial2.len - paramGF2Polynomial.len;
      }
      return localGF2Polynomial1;
    }
    throw new RuntimeException();
  }
  
  public void randomize()
  {
    int i = 0;
    while (i < this.blocks)
    {
      this.value[i] = rand.nextInt();
      i += 1;
    }
    zeroUnusedBits();
  }
  
  public void randomize(Random paramRandom)
  {
    int i = 0;
    while (i < this.blocks)
    {
      this.value[i] = paramRandom.nextInt();
      i += 1;
    }
    zeroUnusedBits();
  }
  
  public void reduceN()
  {
    int i = this.blocks - 1;
    while ((this.value[i] == 0) && (i > 0)) {
      i -= 1;
    }
    int k = this.value[i];
    int j = 0;
    while (k != 0)
    {
      k >>>= 1;
      j += 1;
    }
    this.len = ((i << 5) + j);
    this.blocks = (i + 1);
  }
  
  void reducePentanomial(int paramInt, int[] paramArrayOfInt)
  {
    int j = paramInt >>> 5;
    int i = paramInt & 0x1F;
    int i4 = 32 - i;
    int i5 = paramInt - paramArrayOfInt[0] >>> 5;
    int i2 = 32 - (paramInt - paramArrayOfInt[0] & 0x1F);
    int i3 = paramInt - paramArrayOfInt[1] >>> 5;
    int n = 32 - (paramInt - paramArrayOfInt[1] & 0x1F);
    int i1 = paramInt - paramArrayOfInt[2] >>> 5;
    int m = 32 - (paramInt - paramArrayOfInt[2] & 0x1F);
    int k = (paramInt << 1) - 2 >>> 5;
    for (;;)
    {
      paramArrayOfInt = this;
      if (k <= j) {
        break;
      }
      paramArrayOfInt = paramArrayOfInt.value;
      l = paramArrayOfInt[k] & 0xFFFFFFFF;
      int i6 = k - j;
      int i7 = i6 - 1;
      paramArrayOfInt[i7] ^= (int)(l << i4);
      paramArrayOfInt[i6] = ((int)(paramArrayOfInt[i6] ^ l >>> 32 - i4));
      i6 = k - i5;
      i7 = i6 - 1;
      paramArrayOfInt[i7] ^= (int)(l << i2);
      paramArrayOfInt[i6] = ((int)(paramArrayOfInt[i6] ^ l >>> 32 - i2));
      i6 = k - i3;
      i7 = i6 - 1;
      paramArrayOfInt[i7] ^= (int)(l << n);
      paramArrayOfInt[i6] = ((int)(paramArrayOfInt[i6] ^ l >>> 32 - n));
      i6 = k - i1;
      i7 = i6 - 1;
      paramArrayOfInt[i7] ^= (int)(l << m);
      paramArrayOfInt[i6] = ((int)(l >>> 32 - m ^ paramArrayOfInt[i6]));
      paramArrayOfInt[k] = 0;
      k -= 1;
    }
    paramArrayOfInt = paramArrayOfInt.value;
    long l = paramArrayOfInt[j] & 0xFFFFFFFF & 4294967295L << i;
    paramArrayOfInt[0] = ((int)(l >>> 32 - i4 ^ paramArrayOfInt[0]));
    k = j - i5;
    i4 = k - 1;
    if (i4 >= 0) {
      paramArrayOfInt[i4] ^= (int)(l << i2);
    }
    paramArrayOfInt = this.value;
    paramArrayOfInt[k] = ((int)(paramArrayOfInt[k] ^ l >>> 32 - i2));
    k = j - i3;
    i2 = k - 1;
    if (i2 >= 0) {
      paramArrayOfInt[i2] ^= (int)(l << n);
    }
    paramArrayOfInt = this.value;
    paramArrayOfInt[k] = ((int)(paramArrayOfInt[k] ^ l >>> 32 - n));
    k = j - i1;
    n = k - 1;
    if (n >= 0) {
      paramArrayOfInt[n] ^= (int)(l << m);
    }
    paramArrayOfInt = this.value;
    paramArrayOfInt[k] = ((int)(l >>> 32 - m ^ paramArrayOfInt[k]));
    paramArrayOfInt[j] &= reverseRightMask[i];
    this.blocks = ((paramInt - 1 >>> 5) + 1);
    this.len = paramInt;
  }
  
  void reduceTrinomial(int paramInt1, int paramInt2)
  {
    int j = paramInt1 >>> 5;
    int k = paramInt1 & 0x1F;
    int m = 32 - k;
    paramInt2 = paramInt1 - paramInt2;
    int i1 = paramInt2 >>> 5;
    int n = 32 - (paramInt2 & 0x1F);
    int i = (paramInt1 << 1) - 2 >>> 5;
    paramInt2 = j;
    while (i > paramInt2)
    {
      arrayOfInt = this.value;
      l = 0xFFFFFFFF & arrayOfInt[i];
      j = i - paramInt2;
      int i2 = j - 1;
      arrayOfInt[i2] ^= (int)(l << m);
      arrayOfInt[j] = ((int)(arrayOfInt[j] ^ l >>> 32 - m));
      j = i - i1;
      i2 = j - 1;
      arrayOfInt[i2] ^= (int)(l << n);
      arrayOfInt[j] = ((int)(l >>> 32 - n ^ arrayOfInt[j]));
      arrayOfInt[i] = 0;
      i -= 1;
    }
    int[] arrayOfInt = this.value;
    long l = 4294967295L << k & arrayOfInt[paramInt2] & 0xFFFFFFFF;
    arrayOfInt[0] = ((int)(arrayOfInt[0] ^ l >>> 32 - m));
    i = paramInt2 - i1;
    j = i - 1;
    if (j >= 0) {
      arrayOfInt[j] ^= (int)(l << n);
    }
    arrayOfInt = this.value;
    arrayOfInt[i] = ((int)(l >>> 32 - n ^ arrayOfInt[i]));
    arrayOfInt[paramInt2] &= reverseRightMask[k];
    this.blocks = ((paramInt1 - 1 >>> 5) + 1);
    this.len = paramInt1;
  }
  
  public GF2Polynomial remainder(GF2Polynomial paramGF2Polynomial)
    throws RuntimeException
  {
    GF2Polynomial localGF2Polynomial = new GF2Polynomial(this);
    paramGF2Polynomial = new GF2Polynomial(paramGF2Polynomial);
    if (!paramGF2Polynomial.isZero())
    {
      localGF2Polynomial.reduceN();
      paramGF2Polynomial.reduceN();
      int k = localGF2Polynomial.len;
      int m = paramGF2Polynomial.len;
      int i = m;
      int j = k;
      if (k < m) {
        return localGF2Polynomial;
      }
      for (;;)
      {
        i = j - i;
        if (i < 0) {
          break;
        }
        localGF2Polynomial.subtractFromThis(paramGF2Polynomial.shiftLeft(i));
        localGF2Polynomial.reduceN();
        j = localGF2Polynomial.len;
        i = paramGF2Polynomial.len;
      }
      return localGF2Polynomial;
    }
    throw new RuntimeException();
  }
  
  public void resetBit(int paramInt)
    throws RuntimeException
  {
    if (paramInt >= 0)
    {
      if (paramInt > this.len - 1) {
        return;
      }
      int[] arrayOfInt = this.value;
      int i = paramInt >>> 5;
      int j = arrayOfInt[i];
      arrayOfInt[i] = (bitMask[(paramInt & 0x1F)] & j);
      return;
    }
    throw new RuntimeException();
  }
  
  public void setBit(int paramInt)
    throws RuntimeException
  {
    if ((paramInt >= 0) && (paramInt <= this.len - 1))
    {
      int[] arrayOfInt = this.value;
      int i = paramInt >>> 5;
      int j = arrayOfInt[i];
      arrayOfInt[i] = (bitMask[(paramInt & 0x1F)] | j);
      return;
    }
    throw new RuntimeException();
  }
  
  void shiftBlocksLeft()
  {
    int i = this.blocks + 1;
    this.blocks = i;
    this.len += 32;
    int[] arrayOfInt1 = this.value;
    if (i <= arrayOfInt1.length)
    {
      i -= 1;
      while (i >= 1)
      {
        arrayOfInt1 = this.value;
        arrayOfInt1[i] = arrayOfInt1[(i - 1)];
        i -= 1;
      }
      this.value[0] = 0;
      return;
    }
    int[] arrayOfInt2 = new int[i];
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 1, i - 1);
    this.value = null;
    this.value = arrayOfInt2;
  }
  
  public GF2Polynomial shiftLeft()
  {
    GF2Polynomial localGF2Polynomial = new GF2Polynomial(this.len + 1, this.value);
    int i = localGF2Polynomial.blocks - 1;
    while (i >= 1)
    {
      arrayOfInt = localGF2Polynomial.value;
      arrayOfInt[i] <<= 1;
      arrayOfInt[i] |= arrayOfInt[(i - 1)] >>> 31;
      i -= 1;
    }
    int[] arrayOfInt = localGF2Polynomial.value;
    arrayOfInt[0] <<= 1;
    return localGF2Polynomial;
  }
  
  public GF2Polynomial shiftLeft(int paramInt)
  {
    GF2Polynomial localGF2Polynomial = new GF2Polynomial(this.len + paramInt, this.value);
    if (paramInt >= 32) {
      localGF2Polynomial.doShiftBlocksLeft(paramInt >>> 5);
    }
    int i = paramInt & 0x1F;
    if (i != 0)
    {
      paramInt = localGF2Polynomial.blocks - 1;
      while (paramInt >= 1)
      {
        arrayOfInt = localGF2Polynomial.value;
        arrayOfInt[paramInt] <<= i;
        arrayOfInt[paramInt] |= arrayOfInt[(paramInt - 1)] >>> 32 - i;
        paramInt -= 1;
      }
      int[] arrayOfInt = localGF2Polynomial.value;
      arrayOfInt[0] <<= i;
    }
    return localGF2Polynomial;
  }
  
  public void shiftLeftAddThis(GF2Polynomial paramGF2Polynomial, int paramInt)
  {
    if (paramInt == 0)
    {
      addToThis(paramGF2Polynomial);
      return;
    }
    expandN(paramGF2Polynomial.len + paramInt);
    int i = paramGF2Polynomial.blocks - 1;
    while (i >= 0)
    {
      int j = i + (paramInt >>> 5);
      int k = j + 1;
      if (k < this.blocks)
      {
        int m = paramInt & 0x1F;
        if (m != 0)
        {
          arrayOfInt = this.value;
          int n = arrayOfInt[k];
          arrayOfInt[k] = (paramGF2Polynomial.value[i] >>> 32 - m ^ n);
        }
      }
      int[] arrayOfInt = this.value;
      arrayOfInt[j] ^= paramGF2Polynomial.value[i] << (paramInt & 0x1F);
      i -= 1;
    }
  }
  
  public void shiftLeftThis()
  {
    int i = this.len;
    this.len = (i + 1);
    int j = this.blocks;
    if ((i & 0x1F) == 0)
    {
      i = j + 1;
      this.blocks = i;
      arrayOfInt1 = this.value;
      if (i > arrayOfInt1.length)
      {
        int[] arrayOfInt2 = new int[i];
        System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
        this.value = null;
        this.value = arrayOfInt2;
      }
      i = this.blocks - 1;
      while (i >= 1)
      {
        arrayOfInt1 = this.value;
        j = arrayOfInt1[i];
        int k = i - 1;
        arrayOfInt1[i] = (j | arrayOfInt1[k] >>> 31);
        arrayOfInt1[k] <<= 1;
        i -= 1;
      }
    }
    i = j - 1;
    while (i >= 1)
    {
      arrayOfInt1 = this.value;
      arrayOfInt1[i] <<= 1;
      arrayOfInt1[i] |= arrayOfInt1[(i - 1)] >>> 31;
      i -= 1;
    }
    int[] arrayOfInt1 = this.value;
    arrayOfInt1[0] <<= 1;
  }
  
  public GF2Polynomial shiftRight()
  {
    GF2Polynomial localGF2Polynomial = new GF2Polynomial(this.len - 1);
    int[] arrayOfInt1 = this.value;
    int[] arrayOfInt2 = localGF2Polynomial.value;
    int j = localGF2Polynomial.blocks;
    int i = 0;
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, j);
    int k;
    for (;;)
    {
      j = localGF2Polynomial.blocks;
      if (i > j - 2) {
        break;
      }
      arrayOfInt1 = localGF2Polynomial.value;
      arrayOfInt1[i] >>>= 1;
      k = arrayOfInt1[i];
      j = i + 1;
      arrayOfInt1[i] = (k | arrayOfInt1[j] << 31);
      i = j;
    }
    arrayOfInt1 = localGF2Polynomial.value;
    i = j - 1;
    arrayOfInt1[i] >>>= 1;
    if (j < this.blocks)
    {
      i = j - 1;
      k = arrayOfInt1[i];
      arrayOfInt1[i] = (this.value[j] << 31 | k);
    }
    return localGF2Polynomial;
  }
  
  public void shiftRightThis()
  {
    int i = this.len - 1;
    this.len = i;
    this.blocks = ((i - 1 >>> 5) + 1);
    int j;
    int k;
    for (i = 0;; i = j)
    {
      j = this.blocks;
      if (i > j - 2) {
        break;
      }
      arrayOfInt = this.value;
      arrayOfInt[i] >>>= 1;
      k = arrayOfInt[i];
      j = i + 1;
      arrayOfInt[i] = (k | arrayOfInt[j] << 31);
    }
    int[] arrayOfInt = this.value;
    i = j - 1;
    arrayOfInt[i] >>>= 1;
    if ((this.len & 0x1F) == 0)
    {
      i = j - 1;
      k = arrayOfInt[i];
      arrayOfInt[i] = (arrayOfInt[j] << 31 | k);
    }
  }
  
  public void squareThisBitwise()
  {
    if (isZero()) {
      return;
    }
    int i = this.blocks;
    int n = i << 1;
    int[] arrayOfInt = new int[n];
    i -= 1;
    while (i >= 0)
    {
      int k = this.value[i];
      int j = 0;
      int m = 1;
      while (j < 16)
      {
        int i1;
        if ((k & 0x1) != 0)
        {
          i1 = i << 1;
          arrayOfInt[i1] |= m;
        }
        if ((0x10000 & k) != 0)
        {
          i1 = (i << 1) + 1;
          arrayOfInt[i1] |= m;
        }
        m <<= 2;
        k >>>= 1;
        j += 1;
      }
      i -= 1;
    }
    this.value = null;
    this.value = arrayOfInt;
    this.blocks = n;
    this.len = ((this.len << 1) - 1);
  }
  
  public void squareThisPreCalc()
  {
    if (isZero()) {
      return;
    }
    int i = this.value.length;
    int j = this.blocks;
    int[] arrayOfInt1;
    short[] arrayOfShort;
    if (i >= j << 1)
    {
      i = j - 1;
      while (i >= 0)
      {
        arrayOfInt1 = this.value;
        j = i << 1;
        arrayOfShort = squaringTable;
        arrayOfInt1[(j + 1)] = (arrayOfShort[((arrayOfInt1[i] & 0xFF0000) >>> 16)] | arrayOfShort[((arrayOfInt1[i] & 0xFF000000) >>> 24)] << 16);
        arrayOfInt1[j] = (arrayOfShort[(arrayOfInt1[i] & 0xFF)] | arrayOfShort[((arrayOfInt1[i] & 0xFF00) >>> 8)] << 16);
        i -= 1;
      }
      i = this.blocks << 1;
    }
    else
    {
      arrayOfInt1 = new int[j << 1];
      i = 0;
      for (;;)
      {
        j = this.blocks;
        if (i >= j) {
          break;
        }
        j = i << 1;
        arrayOfShort = squaringTable;
        int[] arrayOfInt2 = this.value;
        arrayOfInt1[j] = (arrayOfShort[(arrayOfInt2[i] & 0xFF)] | arrayOfShort[((arrayOfInt2[i] & 0xFF00) >>> 8)] << 16);
        int k = arrayOfShort[((arrayOfInt2[i] & 0xFF0000) >>> 16)];
        arrayOfInt1[(j + 1)] = (arrayOfShort[((arrayOfInt2[i] & 0xFF000000) >>> 24)] << 16 | k);
        i += 1;
      }
      this.value = null;
      this.value = arrayOfInt1;
      i = j << 1;
    }
    this.blocks = i;
    this.len = ((this.len << 1) - 1);
  }
  
  public GF2Polynomial subtract(GF2Polynomial paramGF2Polynomial)
  {
    return xor(paramGF2Polynomial);
  }
  
  public void subtractFromThis(GF2Polynomial paramGF2Polynomial)
  {
    expandN(paramGF2Polynomial.len);
    xorThisBy(paramGF2Polynomial);
  }
  
  public boolean testBit(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > this.len - 1) {
        return false;
      }
      int i = this.value[(paramInt >>> 5)];
      return (bitMask[(paramInt & 0x1F)] & i) != 0;
    }
    throw new RuntimeException();
  }
  
  public byte[] toByteArray()
  {
    int n = (this.len - 1 >> 3) + 1;
    int m = n & 0x3;
    byte[] arrayOfByte = new byte[n];
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= n >> 2) {
        break;
      }
      j = n - (i << 2) - 1;
      int[] arrayOfInt = this.value;
      arrayOfByte[j] = ((byte)(0xFF & arrayOfInt[i]));
      arrayOfByte[(j - 1)] = ((byte)((arrayOfInt[i] & 0xFF00) >>> 8));
      arrayOfByte[(j - 2)] = ((byte)((arrayOfInt[i] & 0xFF0000) >>> 16));
      arrayOfByte[(j - 3)] = ((byte)((arrayOfInt[i] & 0xFF000000) >>> 24));
      i += 1;
    }
    while (j < m)
    {
      i = m - j - 1 << 3;
      arrayOfByte[j] = ((byte)((this.value[(this.blocks - 1)] & 255 << i) >>> i));
      j += 1;
    }
    return arrayOfByte;
  }
  
  public BigInteger toFlexiBigInt()
  {
    if ((this.len != 0) && (!isZero())) {
      return new BigInteger(1, toByteArray());
    }
    return new BigInteger(0, new byte[0]);
  }
  
  public int[] toIntegerArray()
  {
    int i = this.blocks;
    int[] arrayOfInt = new int[i];
    System.arraycopy(this.value, 0, arrayOfInt, 0, i);
    return arrayOfInt;
  }
  
  public String toString(int paramInt)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp8_6 = arrayOfChar;
    tmp8_6[0] = 48;
    char[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 49;
    char[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 50;
    char[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 51;
    char[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 52;
    char[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 53;
    char[] tmp44_38 = tmp38_32;
    tmp44_38[6] = 54;
    char[] tmp51_44 = tmp44_38;
    tmp51_44[7] = 55;
    char[] tmp58_51 = tmp51_44;
    tmp58_51[8] = 56;
    char[] tmp65_58 = tmp58_51;
    tmp65_58[9] = 57;
    char[] tmp72_65 = tmp65_58;
    tmp72_65[10] = 97;
    char[] tmp79_72 = tmp72_65;
    tmp79_72[11] = 98;
    char[] tmp86_79 = tmp79_72;
    tmp86_79[12] = 99;
    char[] tmp93_86 = tmp86_79;
    tmp93_86[13] = 100;
    char[] tmp100_93 = tmp93_86;
    tmp100_93[14] = 101;
    char[] tmp107_100 = tmp100_93;
    tmp107_100[15] = 102;
    tmp107_100;
    String[] arrayOfString = new String[16];
    arrayOfString[0] = "0000";
    arrayOfString[1] = "0001";
    arrayOfString[2] = "0010";
    arrayOfString[3] = "0011";
    arrayOfString[4] = "0100";
    arrayOfString[5] = "0101";
    arrayOfString[6] = "0110";
    arrayOfString[7] = "0111";
    arrayOfString[8] = "1000";
    arrayOfString[9] = "1001";
    arrayOfString[10] = "1010";
    arrayOfString[11] = "1011";
    arrayOfString[12] = "1100";
    arrayOfString[13] = "1101";
    arrayOfString[14] = "1110";
    arrayOfString[15] = "1111";
    String str = new String();
    Object localObject;
    if (paramInt == 16)
    {
      paramInt = this.blocks - 1;
      for (;;)
      {
        localObject = str;
        if (paramInt < 0) {
          break;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(arrayOfChar[(this.value[paramInt] >>> 28 & 0xF)]);
        str = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(arrayOfChar[(this.value[paramInt] >>> 24 & 0xF)]);
        str = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(arrayOfChar[(this.value[paramInt] >>> 20 & 0xF)]);
        str = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(arrayOfChar[(this.value[paramInt] >>> 16 & 0xF)]);
        str = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(arrayOfChar[(this.value[paramInt] >>> 12 & 0xF)]);
        str = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(arrayOfChar[(this.value[paramInt] >>> 8 & 0xF)]);
        str = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(arrayOfChar[(this.value[paramInt] >>> 4 & 0xF)]);
        str = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(arrayOfChar[(this.value[paramInt] & 0xF)]);
        str = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(" ");
        str = ((StringBuilder)localObject).toString();
        paramInt -= 1;
      }
    }
    paramInt = this.blocks - 1;
    for (;;)
    {
      localObject = str;
      if (paramInt < 0) {
        break;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(arrayOfString[(this.value[paramInt] >>> 28 & 0xF)]);
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(arrayOfString[(this.value[paramInt] >>> 24 & 0xF)]);
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(arrayOfString[(this.value[paramInt] >>> 20 & 0xF)]);
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(arrayOfString[(this.value[paramInt] >>> 16 & 0xF)]);
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(arrayOfString[(this.value[paramInt] >>> 12 & 0xF)]);
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(arrayOfString[(this.value[paramInt] >>> 8 & 0xF)]);
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(arrayOfString[(this.value[paramInt] >>> 4 & 0xF)]);
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(arrayOfString[(this.value[paramInt] & 0xF)]);
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" ");
      str = ((StringBuilder)localObject).toString();
      paramInt -= 1;
    }
    return (String)localObject;
  }
  
  public boolean vectorMult(GF2Polynomial paramGF2Polynomial)
    throws RuntimeException
  {
    if (this.len == paramGF2Polynomial.len)
    {
      int i = 0;
      int k = 0;
      while (i < this.blocks)
      {
        int j = this.value[i] & paramGF2Polynomial.value[i];
        boolean[] arrayOfBoolean = parity;
        k = k ^ arrayOfBoolean[(j & 0xFF)] ^ arrayOfBoolean[(j >>> 8 & 0xFF)] ^ arrayOfBoolean[(j >>> 16 & 0xFF)] ^ arrayOfBoolean[(j >>> 24 & 0xFF)];
        i += 1;
      }
      return k;
    }
    throw new RuntimeException();
  }
  
  public GF2Polynomial xor(GF2Polynomial paramGF2Polynomial)
  {
    int k = Math.min(this.blocks, paramGF2Polynomial.blocks);
    int m = this.len;
    int n = paramGF2Polynomial.len;
    int j = 0;
    int i = 0;
    Object localObject;
    if (m >= n)
    {
      GF2Polynomial localGF2Polynomial = new GF2Polynomial(this);
      for (;;)
      {
        localObject = localGF2Polynomial;
        if (i >= k) {
          break;
        }
        localObject = localGF2Polynomial.value;
        localObject[i] ^= paramGF2Polynomial.value[i];
        i += 1;
      }
    }
    paramGF2Polynomial = new GF2Polynomial(paramGF2Polynomial);
    i = j;
    for (;;)
    {
      localObject = paramGF2Polynomial;
      if (i >= k) {
        break;
      }
      localObject = paramGF2Polynomial.value;
      localObject[i] ^= this.value[i];
      i += 1;
    }
    ((GF2Polynomial)localObject).zeroUnusedBits();
    return (GF2Polynomial)localObject;
  }
  
  public void xorBit(int paramInt)
    throws RuntimeException
  {
    if ((paramInt >= 0) && (paramInt <= this.len - 1))
    {
      int[] arrayOfInt = this.value;
      int i = paramInt >>> 5;
      int j = arrayOfInt[i];
      arrayOfInt[i] = (bitMask[(paramInt & 0x1F)] ^ j);
      return;
    }
    throw new RuntimeException();
  }
  
  public void xorThisBy(GF2Polynomial paramGF2Polynomial)
  {
    int i = 0;
    while (i < Math.min(this.blocks, paramGF2Polynomial.blocks))
    {
      int[] arrayOfInt = this.value;
      arrayOfInt[i] ^= paramGF2Polynomial.value[i];
      i += 1;
    }
    zeroUnusedBits();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\GF2Polynomial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */