package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class CamelliaLightEngine
  implements BlockCipher
{
  private static final int BLOCK_SIZE = 16;
  private static final int MASK8 = 255;
  private static final byte[] SBOX1 = { 112, -126, 44, -20, -77, 39, -64, -27, -28, -123, 87, 53, -22, 12, -82, 65, 35, -17, 107, -109, 69, 25, -91, 33, -19, 14, 79, 78, 29, 101, -110, -67, -122, -72, -81, -113, 124, -21, 31, -50, 62, 48, -36, 95, 94, -59, 11, 26, -90, -31, 57, -54, -43, 71, 93, 61, -39, 1, 90, -42, 81, 86, 108, 77, -117, 13, -102, 102, -5, -52, -80, 45, 116, 18, 43, 32, -16, -79, -124, -103, -33, 76, -53, -62, 52, 126, 118, 5, 109, -73, -87, 49, -47, 23, 4, -41, 20, 88, 58, 97, -34, 27, 17, 28, 50, 15, -100, 22, 83, 24, -14, 34, -2, 68, -49, -78, -61, -75, 122, -111, 36, 8, -24, -88, 96, -4, 105, 80, -86, -48, -96, 125, -95, -119, 98, -105, 84, 91, 30, -107, -32, -1, 100, -46, 16, -60, 0, 72, -93, -9, 117, -37, -118, 3, -26, -38, 9, 63, -35, -108, -121, 92, -125, 2, -51, 74, -112, 51, 115, 103, -10, -13, -99, 127, -65, -30, 82, -101, -40, 38, -56, 55, -58, 59, -127, -106, 111, 75, 19, -66, 99, 46, -23, 121, -89, -116, -97, 110, -68, -114, 41, -11, -7, -74, 47, -3, -76, 89, 120, -104, 6, 106, -25, 70, 113, -70, -44, 37, -85, 66, -120, -94, -115, -6, 114, 7, -71, 85, -8, -18, -84, 10, 54, 73, 42, 104, 60, 56, -15, -92, 64, 40, -45, 123, -69, -55, 67, -63, 21, -29, -83, -12, 119, -57, -128, -98 };
  private static final int[] SIGMA = { -1600231809, 1003262091, -1233459112, 1286239154, -957401297, -380665154, 1426019237, -237801700, 283453434, -563598051, -1336506174, -1276722691 };
  private boolean _keyis128;
  private boolean initialized;
  private int[] ke = new int[12];
  private int[] kw = new int[8];
  private int[] state = new int[4];
  private int[] subkey = new int[96];
  
  private int bytes2int(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j = (j << 8) + (paramArrayOfByte[(i + paramInt)] & 0xFF);
      i += 1;
    }
    return j;
  }
  
  private void camelliaF2(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int m = paramArrayOfInt1[0] ^ paramArrayOfInt2[(paramInt + 0)];
    int i = sbox4(m & 0xFF);
    int j = sbox3(m >>> 8 & 0xFF);
    int k = sbox2(m >>> 16 & 0xFF);
    byte[] arrayOfByte = SBOX1;
    m = arrayOfByte[(m >>> 24 & 0xFF)];
    int n = paramArrayOfInt1[1] ^ paramArrayOfInt2[(paramInt + 1)];
    n = leftRotate(arrayOfByte[(n & 0xFF)] & 0xFF | sbox4(n >>> 8 & 0xFF) << 8 | sbox3(n >>> 16 & 0xFF) << 16 | sbox2(n >>> 24 & 0xFF) << 24, 8);
    j = ((m & 0xFF) << 24 | i | j << 8 | k << 16) ^ n;
    i = leftRotate(n, 8) ^ j;
    j = rightRotate(j, 8) ^ i;
    k = paramArrayOfInt1[2];
    paramArrayOfInt1[2] = (leftRotate(i, 16) ^ j ^ k);
    i = paramArrayOfInt1[3];
    paramArrayOfInt1[3] = (leftRotate(j, 8) ^ i);
    m = paramArrayOfInt1[2] ^ paramArrayOfInt2[(paramInt + 2)];
    i = sbox4(m & 0xFF);
    j = sbox3(m >>> 8 & 0xFF);
    k = sbox2(m >>> 16 & 0xFF);
    arrayOfByte = SBOX1;
    m = arrayOfByte[(m >>> 24 & 0xFF)];
    n = paramArrayOfInt1[3];
    paramInt = paramArrayOfInt2[(paramInt + 3)] ^ n;
    n = arrayOfByte[(paramInt & 0xFF)];
    int i1 = sbox4(paramInt >>> 8 & 0xFF);
    int i2 = sbox3(paramInt >>> 16 & 0xFF);
    paramInt = leftRotate(sbox2(paramInt >>> 24 & 0xFF) << 24 | n & 0xFF | i1 << 8 | i2 << 16, 8);
    i = ((m & 0xFF) << 24 | i | j << 8 | k << 16) ^ paramInt;
    paramInt = leftRotate(paramInt, 8) ^ i;
    i = rightRotate(i, 8) ^ paramInt;
    j = paramArrayOfInt1[0];
    paramArrayOfInt1[0] = (leftRotate(paramInt, 16) ^ i ^ j);
    paramArrayOfInt1[1] ^= leftRotate(i, 8);
  }
  
  private void camelliaFLs(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    paramArrayOfInt1[1] ^= leftRotate(paramArrayOfInt1[0] & paramArrayOfInt2[(paramInt + 0)], 1);
    paramArrayOfInt1[0] ^= (paramArrayOfInt2[(paramInt + 1)] | paramArrayOfInt1[1]);
    paramArrayOfInt1[2] ^= (paramArrayOfInt2[(paramInt + 3)] | paramArrayOfInt1[3]);
    int i = paramArrayOfInt1[3];
    paramArrayOfInt1[3] = (leftRotate(paramArrayOfInt2[(paramInt + 2)] & paramArrayOfInt1[2], 1) ^ i);
  }
  
  private static void decroldq(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3)
  {
    int i = paramInt3 + 2;
    int j = paramInt2 + 0;
    int n = paramArrayOfInt1[j];
    int k = paramInt2 + 1;
    int i1 = paramArrayOfInt1[k];
    int m = 32 - paramInt1;
    paramArrayOfInt2[i] = (n << paramInt1 | i1 >>> m);
    n = paramInt3 + 3;
    int i2 = paramArrayOfInt1[k];
    i1 = paramInt2 + 2;
    paramArrayOfInt2[n] = (i2 << paramInt1 | paramArrayOfInt1[i1] >>> m);
    i2 = paramInt3 + 0;
    int i3 = paramArrayOfInt1[i1];
    paramInt2 += 3;
    paramArrayOfInt2[i2] = (i3 << paramInt1 | paramArrayOfInt1[paramInt2] >>> m);
    paramInt3 += 1;
    paramArrayOfInt2[paramInt3] = (paramArrayOfInt1[paramInt2] << paramInt1 | paramArrayOfInt1[j] >>> m);
    paramArrayOfInt1[j] = paramArrayOfInt2[i];
    paramArrayOfInt1[k] = paramArrayOfInt2[n];
    paramArrayOfInt1[i1] = paramArrayOfInt2[i2];
    paramArrayOfInt1[paramInt2] = paramArrayOfInt2[paramInt3];
  }
  
  private static void decroldqo32(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3)
  {
    int i = paramInt3 + 2;
    int j = paramInt2 + 1;
    int n = paramArrayOfInt1[j];
    int k = paramInt1 - 32;
    int m = paramInt2 + 2;
    int i1 = paramArrayOfInt1[m];
    paramInt1 = 64 - paramInt1;
    paramArrayOfInt2[i] = (n << k | i1 >>> paramInt1);
    n = paramInt3 + 3;
    int i2 = paramArrayOfInt1[m];
    i1 = paramInt2 + 3;
    paramArrayOfInt2[n] = (i2 << k | paramArrayOfInt1[i1] >>> paramInt1);
    i2 = paramInt3 + 0;
    int i3 = paramArrayOfInt1[i1];
    paramInt2 += 0;
    paramArrayOfInt2[i2] = (i3 << k | paramArrayOfInt1[paramInt2] >>> paramInt1);
    paramInt3 += 1;
    i3 = paramArrayOfInt1[paramInt2];
    paramArrayOfInt2[paramInt3] = (paramArrayOfInt1[j] >>> paramInt1 | i3 << k);
    paramArrayOfInt1[paramInt2] = paramArrayOfInt2[i];
    paramArrayOfInt1[j] = paramArrayOfInt2[n];
    paramArrayOfInt1[m] = paramArrayOfInt2[i2];
    paramArrayOfInt1[i1] = paramArrayOfInt2[paramInt3];
  }
  
  private void int2bytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 < 4)
    {
      paramArrayOfByte[(3 - paramInt1 + paramInt2)] = ((byte)i);
      i >>>= 8;
      paramInt1 += 1;
    }
  }
  
  private byte lRot8(byte paramByte, int paramInt)
  {
    return (byte)((paramByte & 0xFF) >>> 8 - paramInt | paramByte << paramInt);
  }
  
  private static int leftRotate(int paramInt1, int paramInt2)
  {
    return (paramInt1 << paramInt2) + (paramInt1 >>> 32 - paramInt2);
  }
  
  private int processBlock128(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = 0;
    while (i < 4)
    {
      this.state[i] = bytes2int(paramArrayOfByte1, i * 4 + paramInt1);
      arrayOfInt = this.state;
      arrayOfInt[i] ^= this.kw[i];
      i += 1;
    }
    camelliaF2(this.state, this.subkey, 0);
    camelliaF2(this.state, this.subkey, 4);
    camelliaF2(this.state, this.subkey, 8);
    camelliaFLs(this.state, this.ke, 0);
    camelliaF2(this.state, this.subkey, 12);
    camelliaF2(this.state, this.subkey, 16);
    camelliaF2(this.state, this.subkey, 20);
    camelliaFLs(this.state, this.ke, 4);
    camelliaF2(this.state, this.subkey, 24);
    camelliaF2(this.state, this.subkey, 28);
    camelliaF2(this.state, this.subkey, 32);
    paramArrayOfByte1 = this.state;
    paramInt1 = paramArrayOfByte1[2];
    int[] arrayOfInt = this.kw;
    paramArrayOfByte1[2] = (arrayOfInt[4] ^ paramInt1);
    paramArrayOfByte1[3] ^= arrayOfInt[5];
    paramArrayOfByte1[0] ^= arrayOfInt[6];
    paramInt1 = paramArrayOfByte1[1];
    paramArrayOfByte1[1] = (arrayOfInt[7] ^ paramInt1);
    int2bytes(paramArrayOfByte1[2], paramArrayOfByte2, paramInt2);
    int2bytes(this.state[3], paramArrayOfByte2, paramInt2 + 4);
    int2bytes(this.state[0], paramArrayOfByte2, paramInt2 + 8);
    int2bytes(this.state[1], paramArrayOfByte2, paramInt2 + 12);
    return 16;
  }
  
  private int processBlock192or256(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = 0;
    while (i < 4)
    {
      this.state[i] = bytes2int(paramArrayOfByte1, i * 4 + paramInt1);
      arrayOfInt = this.state;
      arrayOfInt[i] ^= this.kw[i];
      i += 1;
    }
    camelliaF2(this.state, this.subkey, 0);
    camelliaF2(this.state, this.subkey, 4);
    camelliaF2(this.state, this.subkey, 8);
    camelliaFLs(this.state, this.ke, 0);
    camelliaF2(this.state, this.subkey, 12);
    camelliaF2(this.state, this.subkey, 16);
    camelliaF2(this.state, this.subkey, 20);
    camelliaFLs(this.state, this.ke, 4);
    camelliaF2(this.state, this.subkey, 24);
    camelliaF2(this.state, this.subkey, 28);
    camelliaF2(this.state, this.subkey, 32);
    camelliaFLs(this.state, this.ke, 8);
    camelliaF2(this.state, this.subkey, 36);
    camelliaF2(this.state, this.subkey, 40);
    camelliaF2(this.state, this.subkey, 44);
    paramArrayOfByte1 = this.state;
    paramInt1 = paramArrayOfByte1[2];
    int[] arrayOfInt = this.kw;
    paramArrayOfByte1[2] = (paramInt1 ^ arrayOfInt[4]);
    paramArrayOfByte1[3] ^= arrayOfInt[5];
    paramArrayOfByte1[0] ^= arrayOfInt[6];
    paramInt1 = paramArrayOfByte1[1];
    paramArrayOfByte1[1] = (arrayOfInt[7] ^ paramInt1);
    int2bytes(paramArrayOfByte1[2], paramArrayOfByte2, paramInt2);
    int2bytes(this.state[3], paramArrayOfByte2, paramInt2 + 4);
    int2bytes(this.state[0], paramArrayOfByte2, paramInt2 + 8);
    int2bytes(this.state[1], paramArrayOfByte2, paramInt2 + 12);
    return 16;
  }
  
  private static int rightRotate(int paramInt1, int paramInt2)
  {
    return (paramInt1 >>> paramInt2) + (paramInt1 << 32 - paramInt2);
  }
  
  private static void roldq(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3)
  {
    int i = paramInt3 + 0;
    int j = paramInt2 + 0;
    int n = paramArrayOfInt1[j];
    int k = paramInt2 + 1;
    int i1 = paramArrayOfInt1[k];
    int m = 32 - paramInt1;
    paramArrayOfInt2[i] = (n << paramInt1 | i1 >>> m);
    n = paramInt3 + 1;
    int i2 = paramArrayOfInt1[k];
    i1 = paramInt2 + 2;
    paramArrayOfInt2[n] = (i2 << paramInt1 | paramArrayOfInt1[i1] >>> m);
    i2 = paramInt3 + 2;
    int i3 = paramArrayOfInt1[i1];
    paramInt2 += 3;
    paramArrayOfInt2[i2] = (i3 << paramInt1 | paramArrayOfInt1[paramInt2] >>> m);
    paramInt3 += 3;
    paramArrayOfInt2[paramInt3] = (paramArrayOfInt1[paramInt2] << paramInt1 | paramArrayOfInt1[j] >>> m);
    paramArrayOfInt1[j] = paramArrayOfInt2[i];
    paramArrayOfInt1[k] = paramArrayOfInt2[n];
    paramArrayOfInt1[i1] = paramArrayOfInt2[i2];
    paramArrayOfInt1[paramInt2] = paramArrayOfInt2[paramInt3];
  }
  
  private static void roldqo32(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3)
  {
    int i = paramInt3 + 0;
    int j = paramInt2 + 1;
    int n = paramArrayOfInt1[j];
    int k = paramInt1 - 32;
    int m = paramInt2 + 2;
    int i1 = paramArrayOfInt1[m];
    paramInt1 = 64 - paramInt1;
    paramArrayOfInt2[i] = (n << k | i1 >>> paramInt1);
    n = paramInt3 + 1;
    int i2 = paramArrayOfInt1[m];
    i1 = paramInt2 + 3;
    paramArrayOfInt2[n] = (i2 << k | paramArrayOfInt1[i1] >>> paramInt1);
    i2 = paramInt3 + 2;
    int i3 = paramArrayOfInt1[i1];
    paramInt2 += 0;
    paramArrayOfInt2[i2] = (i3 << k | paramArrayOfInt1[paramInt2] >>> paramInt1);
    paramInt3 += 3;
    i3 = paramArrayOfInt1[paramInt2];
    paramArrayOfInt2[paramInt3] = (paramArrayOfInt1[j] >>> paramInt1 | i3 << k);
    paramArrayOfInt1[paramInt2] = paramArrayOfInt2[i];
    paramArrayOfInt1[j] = paramArrayOfInt2[n];
    paramArrayOfInt1[m] = paramArrayOfInt2[i2];
    paramArrayOfInt1[i1] = paramArrayOfInt2[paramInt3];
  }
  
  private int sbox2(int paramInt)
  {
    return lRot8(SBOX1[paramInt], 1) & 0xFF;
  }
  
  private int sbox3(int paramInt)
  {
    return lRot8(SBOX1[paramInt], 7) & 0xFF;
  }
  
  private int sbox4(int paramInt)
  {
    return SBOX1[(lRot8((byte)paramInt, 1) & 0xFF)] & 0xFF;
  }
  
  private void setKey(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int[] arrayOfInt4 = new int[8];
    int[] arrayOfInt1 = new int[4];
    int[] arrayOfInt3 = new int[4];
    int[] arrayOfInt2 = new int[4];
    int i = paramArrayOfByte.length;
    if (i != 16)
    {
      if (i != 24)
      {
        if (i == 32)
        {
          arrayOfInt4[0] = bytes2int(paramArrayOfByte, 0);
          arrayOfInt4[1] = bytes2int(paramArrayOfByte, 4);
          arrayOfInt4[2] = bytes2int(paramArrayOfByte, 8);
          arrayOfInt4[3] = bytes2int(paramArrayOfByte, 12);
          arrayOfInt4[4] = bytes2int(paramArrayOfByte, 16);
          arrayOfInt4[5] = bytes2int(paramArrayOfByte, 20);
          arrayOfInt4[6] = bytes2int(paramArrayOfByte, 24);
          arrayOfInt4[7] = bytes2int(paramArrayOfByte, 28);
        }
        else
        {
          throw new IllegalArgumentException("key sizes are only 16/24/32 bytes.");
        }
      }
      else
      {
        arrayOfInt4[0] = bytes2int(paramArrayOfByte, 0);
        arrayOfInt4[1] = bytes2int(paramArrayOfByte, 4);
        arrayOfInt4[2] = bytes2int(paramArrayOfByte, 8);
        arrayOfInt4[3] = bytes2int(paramArrayOfByte, 12);
        arrayOfInt4[4] = bytes2int(paramArrayOfByte, 16);
        arrayOfInt4[5] = bytes2int(paramArrayOfByte, 20);
        arrayOfInt4[6] = arrayOfInt4[4];
        arrayOfInt4[7] = arrayOfInt4[5];
      }
      this._keyis128 = false;
    }
    else
    {
      this._keyis128 = true;
      arrayOfInt4[0] = bytes2int(paramArrayOfByte, 0);
      arrayOfInt4[1] = bytes2int(paramArrayOfByte, 4);
      arrayOfInt4[2] = bytes2int(paramArrayOfByte, 8);
      arrayOfInt4[3] = bytes2int(paramArrayOfByte, 12);
      arrayOfInt4[7] = 0;
      arrayOfInt4[6] = 0;
      arrayOfInt4[5] = 0;
      arrayOfInt4[4] = 0;
    }
    i = 0;
    while (i < 4)
    {
      arrayOfInt4[i] ^= arrayOfInt4[(i + 4)];
      i += 1;
    }
    camelliaF2(arrayOfInt1, SIGMA, 0);
    i = 0;
    while (i < 4)
    {
      arrayOfInt1[i] ^= arrayOfInt4[i];
      i += 1;
    }
    camelliaF2(arrayOfInt1, SIGMA, 4);
    if (this._keyis128)
    {
      paramArrayOfByte = this.kw;
      if (paramBoolean)
      {
        paramArrayOfByte[0] = arrayOfInt4[0];
        paramArrayOfByte[1] = arrayOfInt4[1];
        paramArrayOfByte[2] = arrayOfInt4[2];
        paramArrayOfByte[3] = arrayOfInt4[3];
        roldq(15, arrayOfInt4, 0, this.subkey, 4);
        roldq(30, arrayOfInt4, 0, this.subkey, 12);
        roldq(15, arrayOfInt4, 0, arrayOfInt2, 0);
        paramArrayOfByte = this.subkey;
        paramArrayOfByte[18] = arrayOfInt2[2];
        paramArrayOfByte[19] = arrayOfInt2[3];
        roldq(17, arrayOfInt4, 0, this.ke, 4);
        roldq(17, arrayOfInt4, 0, this.subkey, 24);
        roldq(17, arrayOfInt4, 0, this.subkey, 32);
        paramArrayOfByte = this.subkey;
        paramArrayOfByte[0] = arrayOfInt1[0];
        paramArrayOfByte[1] = arrayOfInt1[1];
        paramArrayOfByte[2] = arrayOfInt1[2];
        paramArrayOfByte[3] = arrayOfInt1[3];
        roldq(15, arrayOfInt1, 0, paramArrayOfByte, 8);
        roldq(15, arrayOfInt1, 0, this.ke, 0);
        roldq(15, arrayOfInt1, 0, arrayOfInt2, 0);
        paramArrayOfByte = this.subkey;
        paramArrayOfByte[16] = arrayOfInt2[0];
        paramArrayOfByte[17] = arrayOfInt2[1];
        roldq(15, arrayOfInt1, 0, paramArrayOfByte, 20);
        roldqo32(34, arrayOfInt1, 0, this.subkey, 28);
        roldq(17, arrayOfInt1, 0, this.kw, 4);
        return;
      }
      paramArrayOfByte[4] = arrayOfInt4[0];
      paramArrayOfByte[5] = arrayOfInt4[1];
      paramArrayOfByte[6] = arrayOfInt4[2];
      paramArrayOfByte[7] = arrayOfInt4[3];
      decroldq(15, arrayOfInt4, 0, this.subkey, 28);
      decroldq(30, arrayOfInt4, 0, this.subkey, 20);
      decroldq(15, arrayOfInt4, 0, arrayOfInt2, 0);
      paramArrayOfByte = this.subkey;
      paramArrayOfByte[16] = arrayOfInt2[0];
      paramArrayOfByte[17] = arrayOfInt2[1];
      decroldq(17, arrayOfInt4, 0, this.ke, 0);
      decroldq(17, arrayOfInt4, 0, this.subkey, 8);
      decroldq(17, arrayOfInt4, 0, this.subkey, 0);
      paramArrayOfByte = this.subkey;
      paramArrayOfByte[34] = arrayOfInt1[0];
      paramArrayOfByte[35] = arrayOfInt1[1];
      paramArrayOfByte[32] = arrayOfInt1[2];
      paramArrayOfByte[33] = arrayOfInt1[3];
      decroldq(15, arrayOfInt1, 0, paramArrayOfByte, 24);
      decroldq(15, arrayOfInt1, 0, this.ke, 4);
      decroldq(15, arrayOfInt1, 0, arrayOfInt2, 0);
      paramArrayOfByte = this.subkey;
      paramArrayOfByte[18] = arrayOfInt2[2];
      paramArrayOfByte[19] = arrayOfInt2[3];
      decroldq(15, arrayOfInt1, 0, paramArrayOfByte, 12);
      decroldqo32(34, arrayOfInt1, 0, this.subkey, 4);
      roldq(17, arrayOfInt1, 0, this.kw, 0);
      return;
    }
    i = 0;
    while (i < 4)
    {
      arrayOfInt1[i] ^= arrayOfInt4[(i + 4)];
      i += 1;
    }
    camelliaF2(arrayOfInt3, SIGMA, 8);
    paramArrayOfByte = this.kw;
    if (paramBoolean)
    {
      paramArrayOfByte[0] = arrayOfInt4[0];
      paramArrayOfByte[1] = arrayOfInt4[1];
      paramArrayOfByte[2] = arrayOfInt4[2];
      paramArrayOfByte[3] = arrayOfInt4[3];
      roldqo32(45, arrayOfInt4, 0, this.subkey, 16);
      roldq(15, arrayOfInt4, 0, this.ke, 4);
      roldq(17, arrayOfInt4, 0, this.subkey, 32);
      roldqo32(34, arrayOfInt4, 0, this.subkey, 44);
      roldq(15, arrayOfInt4, 4, this.subkey, 4);
      roldq(15, arrayOfInt4, 4, this.ke, 0);
      roldq(30, arrayOfInt4, 4, this.subkey, 24);
      roldqo32(34, arrayOfInt4, 4, this.subkey, 36);
      roldq(15, arrayOfInt1, 0, this.subkey, 8);
      roldq(30, arrayOfInt1, 0, this.subkey, 20);
      paramArrayOfByte = this.ke;
      paramArrayOfByte[8] = arrayOfInt1[1];
      paramArrayOfByte[9] = arrayOfInt1[2];
      paramArrayOfByte[10] = arrayOfInt1[3];
      paramArrayOfByte[11] = arrayOfInt1[0];
      roldqo32(49, arrayOfInt1, 0, this.subkey, 40);
      paramArrayOfByte = this.subkey;
      paramArrayOfByte[0] = arrayOfInt3[0];
      paramArrayOfByte[1] = arrayOfInt3[1];
      paramArrayOfByte[2] = arrayOfInt3[2];
      paramArrayOfByte[3] = arrayOfInt3[3];
      roldq(30, arrayOfInt3, 0, paramArrayOfByte, 12);
      roldq(30, arrayOfInt3, 0, this.subkey, 28);
      roldqo32(51, arrayOfInt3, 0, this.kw, 4);
      return;
    }
    paramArrayOfByte[4] = arrayOfInt4[0];
    paramArrayOfByte[5] = arrayOfInt4[1];
    paramArrayOfByte[6] = arrayOfInt4[2];
    paramArrayOfByte[7] = arrayOfInt4[3];
    decroldqo32(45, arrayOfInt4, 0, this.subkey, 28);
    decroldq(15, arrayOfInt4, 0, this.ke, 4);
    decroldq(17, arrayOfInt4, 0, this.subkey, 12);
    decroldqo32(34, arrayOfInt4, 0, this.subkey, 0);
    decroldq(15, arrayOfInt4, 4, this.subkey, 40);
    decroldq(15, arrayOfInt4, 4, this.ke, 8);
    decroldq(30, arrayOfInt4, 4, this.subkey, 20);
    decroldqo32(34, arrayOfInt4, 4, this.subkey, 8);
    decroldq(15, arrayOfInt1, 0, this.subkey, 36);
    decroldq(30, arrayOfInt1, 0, this.subkey, 24);
    paramArrayOfByte = this.ke;
    paramArrayOfByte[2] = arrayOfInt1[1];
    paramArrayOfByte[3] = arrayOfInt1[2];
    paramArrayOfByte[0] = arrayOfInt1[3];
    paramArrayOfByte[1] = arrayOfInt1[0];
    decroldqo32(49, arrayOfInt1, 0, this.subkey, 4);
    paramArrayOfByte = this.subkey;
    paramArrayOfByte[46] = arrayOfInt3[0];
    paramArrayOfByte[47] = arrayOfInt3[1];
    paramArrayOfByte[44] = arrayOfInt3[2];
    paramArrayOfByte[45] = arrayOfInt3[3];
    decroldq(30, arrayOfInt3, 0, paramArrayOfByte, 32);
    decroldq(30, arrayOfInt3, 0, this.subkey, 16);
    roldqo32(51, arrayOfInt3, 0, this.kw, 0);
  }
  
  public String getAlgorithmName()
  {
    return "Camellia";
  }
  
  public int getBlockSize()
  {
    return 16;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof KeyParameter))
    {
      setKey(paramBoolean, ((KeyParameter)paramCipherParameters).getKey());
      this.initialized = true;
      return;
    }
    throw new IllegalArgumentException("only simple KeyParameter expected.");
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws IllegalStateException
  {
    if (this.initialized)
    {
      if (paramInt1 + 16 <= paramArrayOfByte1.length)
      {
        if (paramInt2 + 16 <= paramArrayOfByte2.length)
        {
          if (this._keyis128) {
            return processBlock128(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
          }
          return processBlock192or256(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
        }
        throw new OutputLengthException("output buffer too short");
      }
      throw new DataLengthException("input buffer too short");
    }
    throw new IllegalStateException("Camellia is not initialized");
  }
  
  public void reset() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\CamelliaLightEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */