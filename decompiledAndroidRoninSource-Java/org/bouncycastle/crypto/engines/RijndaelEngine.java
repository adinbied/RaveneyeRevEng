package org.bouncycastle.crypto.engines;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class RijndaelEngine
  implements BlockCipher
{
  private static final int MAXKC = 64;
  private static final int MAXROUNDS = 14;
  private static final byte[] S;
  private static final byte[] Si;
  private static final byte[] aLogtable;
  private static final byte[] logtable = { 0, 0, 25, 1, 50, 2, 26, -58, 75, -57, 27, 104, 51, -18, -33, 3, 100, 4, -32, 14, 52, -115, -127, -17, 76, 113, 8, -56, -8, 105, 28, -63, 125, -62, 29, -75, -7, -71, 39, 106, 77, -28, -90, 114, -102, -55, 9, 120, 101, 47, -118, 5, 33, 15, -31, 36, 18, -16, -126, 69, 53, -109, -38, -114, -106, -113, -37, -67, 54, -48, -50, -108, 19, 92, -46, -15, 64, 70, -125, 56, 102, -35, -3, 48, -65, 6, -117, 98, -77, 37, -30, -104, 34, -120, -111, 16, 126, 110, 72, -61, -93, -74, 30, 66, 58, 107, 40, 84, -6, -123, 61, -70, 43, 121, 10, 21, -101, -97, 94, -54, 78, -44, -84, -27, -13, 115, -89, 87, -81, 88, -88, 80, -12, -22, -42, 116, 79, -82, -23, -43, -25, -26, -83, -24, 44, -41, 117, 122, -21, 22, 11, -11, 89, -53, 95, -80, -100, -87, 81, -96, 127, 12, -10, 111, 23, -60, 73, -20, -40, 67, 31, 45, -92, 118, 123, -73, -52, -69, 62, 90, -5, 96, -79, -122, 59, 82, -95, 108, -86, 85, 41, -99, -105, -78, -121, -112, 97, -66, -36, -4, -68, -107, -49, -51, 55, 63, 91, -47, 83, 57, -124, 60, 65, -94, 109, 71, 20, 42, -98, 93, 86, -14, -45, -85, 68, 17, -110, -39, 35, 32, 46, -119, -76, 124, -72, 38, 119, -103, -29, -91, 103, 74, -19, -34, -59, 49, -2, 24, 13, 99, -116, -128, -64, -9, 112, 7 };
  private static final int[] rcon;
  static byte[][] shifts0;
  static byte[][] shifts1;
  private long A0;
  private long A1;
  private long A2;
  private long A3;
  private int BC;
  private long BC_MASK;
  private int ROUNDS;
  private int blockBits;
  private boolean forEncryption;
  private byte[] shifts0SC;
  private byte[] shifts1SC;
  private long[][] workingKey;
  
  static
  {
    aLogtable = new byte[] { 0, 3, 5, 15, 17, 51, 85, -1, 26, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, 30, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 4, 12, 20, 60, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, 24, 40, 120, -120, -125, -98, -71, -48, 107, -67, -36, 127, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, 16, 48, 80, -16, 11, 29, 39, 105, -69, -42, 97, -93, -2, 25, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, 96, -96, -5, 22, 58, 78, -46, 109, -73, -62, 93, -25, 50, 86, -6, 21, 63, 65, -61, 94, -30, 61, 71, -55, 64, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, -68, -33, 122, -114, -119, -128, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, -59, 84, -4, 31, 33, 99, -91, -12, 7, 9, 27, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, -111, -88, -29, 62, 66, -58, 81, -13, 14, 18, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, 13, 23, 57, 75, -35, 124, -124, -105, -94, -3, 28, 36, 108, -76, -57, 82, -10, 1, 3, 5, 15, 17, 51, 85, -1, 26, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, 30, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 4, 12, 20, 60, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, 24, 40, 120, -120, -125, -98, -71, -48, 107, -67, -36, 127, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, 16, 48, 80, -16, 11, 29, 39, 105, -69, -42, 97, -93, -2, 25, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, 96, -96, -5, 22, 58, 78, -46, 109, -73, -62, 93, -25, 50, 86, -6, 21, 63, 65, -61, 94, -30, 61, 71, -55, 64, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, -68, -33, 122, -114, -119, -128, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, -59, 84, -4, 31, 33, 99, -91, -12, 7, 9, 27, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, -111, -88, -29, 62, 66, -58, 81, -13, 14, 18, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, 13, 23, 57, 75, -35, 124, -124, -105, -94, -3, 28, 36, 108, -76, -57, 82, -10, 1 };
    S = new byte[] { 99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, -128, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, 127, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, -68, -74, -38, 33, 16, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, 61, 100, 93, 25, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, 22 };
    Si = new byte[] { 82, 9, 106, -43, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, 61, -18, 76, -107, 11, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, -68, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, 63, 15, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, 49, -79, 18, 16, 89, 39, -128, -20, 95, 96, 81, 127, -87, 25, -75, 74, 13, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 20, 99, 85, 33, 12, 125 };
    rcon = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145 };
    shifts0 = new byte[][] { { 0, 8, 16, 24 }, { 0, 8, 16, 24 }, { 0, 8, 16, 24 }, { 0, 8, 16, 32 }, { 0, 8, 24, 32 } };
    byte[] arrayOfByte1 = { 0, 32, 24, 16 };
    byte[] arrayOfByte2 = { 0, 48, 40, 24 };
    byte[] arrayOfByte3 = { 0, 56, 40, 32 };
    shifts1 = new byte[][] { { 0, 24, 16, 8 }, arrayOfByte1, { 0, 40, 32, 24 }, arrayOfByte2, arrayOfByte3 };
  }
  
  public RijndaelEngine()
  {
    this(128);
  }
  
  public RijndaelEngine(int paramInt)
  {
    if (paramInt != 128)
    {
      if (paramInt != 160)
      {
        if (paramInt != 192)
        {
          if (paramInt != 224)
          {
            if (paramInt == 256)
            {
              this.BC = 64;
              this.BC_MASK = -1L;
              this.shifts0SC = shifts0[4];
              this.shifts1SC = shifts1[4];
            }
            else
            {
              throw new IllegalArgumentException("unknown blocksize to Rijndael");
            }
          }
          else
          {
            this.BC = 56;
            this.BC_MASK = 72057594037927935L;
            this.shifts0SC = shifts0[3];
            this.shifts1SC = shifts1[3];
          }
        }
        else
        {
          this.BC = 48;
          this.BC_MASK = 281474976710655L;
          this.shifts0SC = shifts0[2];
          this.shifts1SC = shifts1[2];
        }
      }
      else
      {
        this.BC = 40;
        this.BC_MASK = 1099511627775L;
        this.shifts0SC = shifts0[1];
        this.shifts1SC = shifts1[1];
      }
    }
    else
    {
      this.BC = 32;
      this.BC_MASK = 4294967295L;
      this.shifts0SC = shifts0[0];
      this.shifts1SC = shifts1[0];
    }
    this.blockBits = paramInt;
  }
  
  private void InvMixColumn()
  {
    long l4 = 0L;
    long l3 = 0L;
    long l1 = l3;
    long l2 = l1;
    int i = 0;
    while (i < this.BC)
    {
      int j = (int)(this.A0 >> i & 0xFF);
      int k = (int)(this.A1 >> i & 0xFF);
      int m = (int)(this.A2 >> i & 0xFF);
      int i1 = (int)(this.A3 >> i & 0xFF);
      int n = -1;
      if (j != 0) {
        j = logtable[(j & 0xFF)] & 0xFF;
      } else {
        j = -1;
      }
      if (k != 0) {
        k = logtable[(k & 0xFF)] & 0xFF;
      } else {
        k = -1;
      }
      if (m != 0) {
        m = logtable[(m & 0xFF)] & 0xFF;
      } else {
        m = -1;
      }
      if (i1 != 0) {
        n = logtable[(i1 & 0xFF)] & 0xFF;
      }
      l4 |= ((mul0xe(j) ^ mul0xb(k) ^ mul0xd(m) ^ mul0x9(n)) & 0xFF) << i;
      l3 |= ((mul0xe(k) ^ mul0xb(m) ^ mul0xd(n) ^ mul0x9(j)) & 0xFF) << i;
      l1 |= ((mul0xe(m) ^ mul0xb(n) ^ mul0xd(j) ^ mul0x9(k)) & 0xFF) << i;
      l2 |= ((mul0xe(n) ^ mul0xb(j) ^ mul0xd(k) ^ mul0x9(m)) & 0xFF) << i;
      i += 8;
    }
    this.A0 = l4;
    this.A1 = l3;
    this.A2 = l1;
    this.A3 = l2;
  }
  
  private void KeyAddition(long[] paramArrayOfLong)
  {
    this.A0 ^= paramArrayOfLong[0];
    this.A1 ^= paramArrayOfLong[1];
    this.A2 ^= paramArrayOfLong[2];
    this.A3 ^= paramArrayOfLong[3];
  }
  
  private void MixColumn()
  {
    long l4 = 0L;
    long l3 = 0L;
    long l1 = l3;
    long l2 = l1;
    int i = 0;
    while (i < this.BC)
    {
      int j = (int)(this.A0 >> i & 0xFF);
      int k = (int)(this.A1 >> i & 0xFF);
      int m = (int)(this.A2 >> i & 0xFF);
      int n = (int)(this.A3 >> i & 0xFF);
      l4 |= ((mul0x2(j) ^ mul0x3(k) ^ m ^ n) & 0xFF) << i;
      l3 |= ((mul0x2(k) ^ mul0x3(m) ^ n ^ j) & 0xFF) << i;
      l1 |= ((mul0x2(m) ^ mul0x3(n) ^ j ^ k) & 0xFF) << i;
      l2 |= ((mul0x2(n) ^ mul0x3(j) ^ k ^ m) & 0xFF) << i;
      i += 8;
    }
    this.A0 = l4;
    this.A1 = l3;
    this.A2 = l1;
    this.A3 = l2;
  }
  
  private void ShiftRow(byte[] paramArrayOfByte)
  {
    this.A1 = shift(this.A1, paramArrayOfByte[1]);
    this.A2 = shift(this.A2, paramArrayOfByte[2]);
    this.A3 = shift(this.A3, paramArrayOfByte[3]);
  }
  
  private void Substitution(byte[] paramArrayOfByte)
  {
    this.A0 = applyS(this.A0, paramArrayOfByte);
    this.A1 = applyS(this.A1, paramArrayOfByte);
    this.A2 = applyS(this.A2, paramArrayOfByte);
    this.A3 = applyS(this.A3, paramArrayOfByte);
  }
  
  private long applyS(long paramLong, byte[] paramArrayOfByte)
  {
    long l = 0L;
    int i = 0;
    while (i < this.BC)
    {
      l |= (paramArrayOfByte[((int)(paramLong >> i & 0xFF))] & 0xFF) << i;
      i += 8;
    }
    return l;
  }
  
  private void decryptBlock(long[][] paramArrayOfLong)
  {
    KeyAddition(paramArrayOfLong[this.ROUNDS]);
    Substitution(Si);
    ShiftRow(this.shifts1SC);
    int i = this.ROUNDS - 1;
    while (i > 0)
    {
      KeyAddition(paramArrayOfLong[i]);
      InvMixColumn();
      Substitution(Si);
      ShiftRow(this.shifts1SC);
      i -= 1;
    }
    KeyAddition(paramArrayOfLong[0]);
  }
  
  private void encryptBlock(long[][] paramArrayOfLong)
  {
    KeyAddition(paramArrayOfLong[0]);
    int i = 1;
    while (i < this.ROUNDS)
    {
      Substitution(S);
      ShiftRow(this.shifts0SC);
      MixColumn();
      KeyAddition(paramArrayOfLong[i]);
      i += 1;
    }
    Substitution(S);
    ShiftRow(this.shifts0SC);
    KeyAddition(paramArrayOfLong[this.ROUNDS]);
  }
  
  private long[][] generateWorkingKey(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length * 8;
    byte[][] arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 4, 64 });
    long[][] arrayOfLong = (long[][])Array.newInstance(Long.TYPE, new int[] { 15, 4 });
    int i;
    if (j != 128)
    {
      if (j != 160)
      {
        if (j != 192)
        {
          if (j != 224)
          {
            if (j == 256) {
              i = 8;
            } else {
              throw new IllegalArgumentException("Key length not 128/160/192/224/256 bits.");
            }
          }
          else {
            i = 7;
          }
        }
        else {
          i = 6;
        }
      }
      else {
        i = 5;
      }
    }
    else {
      i = 4;
    }
    if (j >= this.blockBits) {
      j = i + 6;
    } else {
      j = this.BC / 8 + 6;
    }
    this.ROUNDS = j;
    int k = 0;
    j = 0;
    while (k < paramArrayOfByte.length)
    {
      arrayOfByte[(k % 4)][(k / 4)] = paramArrayOfByte[j];
      k += 1;
      j += 1;
    }
    k = 0;
    j = 0;
    int n;
    long l;
    while ((k < i) && (j < (this.ROUNDS + 1) * (this.BC / 8)))
    {
      m = 0;
      while (m < 4)
      {
        n = this.BC;
        paramArrayOfByte = arrayOfLong[(j / (n / 8))];
        l = paramArrayOfByte[m];
        paramArrayOfByte[m] = ((arrayOfByte[m][k] & 0xFF) << j * 8 % n | l);
        m += 1;
      }
      k += 1;
      j += 1;
    }
    int m = 0;
    k = j;
    j = m;
    while (k < (this.ROUNDS + 1) * (this.BC / 8))
    {
      m = 0;
      while (m < 4)
      {
        paramArrayOfByte = arrayOfByte[m];
        n = paramArrayOfByte[0];
        byte[] arrayOfByte1 = S;
        m += 1;
        paramArrayOfByte[0] = ((byte)(n ^ arrayOfByte1[(arrayOfByte[(m % 4)][(i - 1)] & 0xFF)]));
      }
      paramArrayOfByte = arrayOfByte[0];
      m = paramArrayOfByte[0];
      paramArrayOfByte[0] = ((byte)(rcon[j] ^ m));
      m = 1;
      n = 1;
      if (i <= 6)
      {
        m = n;
        while (m < i)
        {
          n = 0;
          while (n < 4)
          {
            paramArrayOfByte = arrayOfByte[n];
            paramArrayOfByte[m] = ((byte)(paramArrayOfByte[m] ^ arrayOfByte[n][(m - 1)]));
            n += 1;
          }
          m += 1;
        }
      }
      while (m < 4)
      {
        n = 0;
        while (n < 4)
        {
          paramArrayOfByte = arrayOfByte[n];
          paramArrayOfByte[m] = ((byte)(paramArrayOfByte[m] ^ arrayOfByte[n][(m - 1)]));
          n += 1;
        }
        m += 1;
      }
      m = 0;
      while (m < 4)
      {
        paramArrayOfByte = arrayOfByte[m];
        paramArrayOfByte[4] = ((byte)(paramArrayOfByte[4] ^ S[(arrayOfByte[m][3] & 0xFF)]));
        m += 1;
      }
      m = 5;
      while (m < i)
      {
        n = 0;
        while (n < 4)
        {
          paramArrayOfByte = arrayOfByte[n];
          paramArrayOfByte[m] = ((byte)(paramArrayOfByte[m] ^ arrayOfByte[n][(m - 1)]));
          n += 1;
        }
        m += 1;
      }
      m = 0;
      while ((m < i) && (k < (this.ROUNDS + 1) * (this.BC / 8)))
      {
        n = 0;
        while (n < 4)
        {
          int i1 = this.BC;
          paramArrayOfByte = arrayOfLong[(k / (i1 / 8))];
          l = paramArrayOfByte[n];
          paramArrayOfByte[n] = ((arrayOfByte[n][m] & 0xFF) << k * 8 % i1 | l);
          n += 1;
        }
        m += 1;
        k += 1;
      }
      j += 1;
    }
    return arrayOfLong;
  }
  
  private byte mul0x2(int paramInt)
  {
    if (paramInt != 0) {
      return aLogtable[((logtable[paramInt] & 0xFF) + 25)];
    }
    return 0;
  }
  
  private byte mul0x3(int paramInt)
  {
    if (paramInt != 0) {
      return aLogtable[((logtable[paramInt] & 0xFF) + 1)];
    }
    return 0;
  }
  
  private byte mul0x9(int paramInt)
  {
    if (paramInt >= 0) {
      return aLogtable[(paramInt + 199)];
    }
    return 0;
  }
  
  private byte mul0xb(int paramInt)
  {
    if (paramInt >= 0) {
      return aLogtable[(paramInt + 104)];
    }
    return 0;
  }
  
  private byte mul0xd(int paramInt)
  {
    if (paramInt >= 0) {
      return aLogtable[(paramInt + 238)];
    }
    return 0;
  }
  
  private byte mul0xe(int paramInt)
  {
    if (paramInt >= 0) {
      return aLogtable[(paramInt + 223)];
    }
    return 0;
  }
  
  private void packBlock(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt != this.BC)
    {
      j = i + 1;
      paramArrayOfByte[i] = ((byte)(int)(this.A0 >> paramInt));
      i = j + 1;
      paramArrayOfByte[j] = ((byte)(int)(this.A1 >> paramInt));
      j = i + 1;
      paramArrayOfByte[i] = ((byte)(int)(this.A2 >> paramInt));
      i = j + 1;
      paramArrayOfByte[j] = ((byte)(int)(this.A3 >> paramInt));
      paramInt += 8;
    }
  }
  
  private long shift(long paramLong, int paramInt)
  {
    return (paramLong << this.BC - paramInt | paramLong >>> paramInt) & this.BC_MASK;
  }
  
  private void unpackBlock(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    this.A0 = (paramArrayOfByte[paramInt] & 0xFF);
    paramInt = i + 1;
    this.A1 = (paramArrayOfByte[i] & 0xFF);
    int j = paramInt + 1;
    this.A2 = (paramArrayOfByte[paramInt] & 0xFF);
    i = j + 1;
    this.A3 = (paramArrayOfByte[j] & 0xFF);
    paramInt = 8;
    while (paramInt != this.BC)
    {
      long l = this.A0;
      j = i + 1;
      this.A0 = (l | (paramArrayOfByte[i] & 0xFF) << paramInt);
      l = this.A1;
      i = j + 1;
      this.A1 = (l | (paramArrayOfByte[j] & 0xFF) << paramInt);
      l = this.A2;
      j = i + 1;
      this.A2 = (l | (paramArrayOfByte[i] & 0xFF) << paramInt);
      l = this.A3;
      i = j + 1;
      this.A3 = (l | (paramArrayOfByte[j] & 0xFF) << paramInt);
      paramInt += 8;
    }
  }
  
  public String getAlgorithmName()
  {
    return "Rijndael";
  }
  
  public int getBlockSize()
  {
    return this.BC / 2;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof KeyParameter))
    {
      this.workingKey = generateWorkingKey(((KeyParameter)paramCipherParameters).getKey());
      this.forEncryption = paramBoolean;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameter passed to Rijndael init - ");
    localStringBuilder.append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    if (this.workingKey != null)
    {
      int i = this.BC;
      if (i / 2 + paramInt1 <= paramArrayOfByte1.length)
      {
        if (i / 2 + paramInt2 <= paramArrayOfByte2.length)
        {
          boolean bool = this.forEncryption;
          unpackBlock(paramArrayOfByte1, paramInt1);
          paramArrayOfByte1 = this.workingKey;
          if (bool) {
            encryptBlock(paramArrayOfByte1);
          } else {
            decryptBlock(paramArrayOfByte1);
          }
          packBlock(paramArrayOfByte2, paramInt2);
          return this.BC / 2;
        }
        throw new OutputLengthException("output buffer too short");
      }
      throw new DataLengthException("input buffer too short");
    }
    throw new IllegalStateException("Rijndael engine not initialised");
  }
  
  public void reset() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\RijndaelEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */