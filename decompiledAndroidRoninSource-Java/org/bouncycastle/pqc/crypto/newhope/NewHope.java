package org.bouncycastle.pqc.crypto.newhope;

import java.security.SecureRandom;
import org.bouncycastle.crypto.digests.SHA3Digest;

class NewHope
{
  public static final int AGREEMENT_SIZE = 32;
  public static final int POLY_SIZE = 1024;
  public static final int SENDA_BYTES = 1824;
  public static final int SENDB_BYTES = 2048;
  private static final boolean STATISTICAL_TEST = false;
  
  static void decodeA(short[] paramArrayOfShort, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Poly.fromBytes(paramArrayOfShort, paramArrayOfByte2);
    System.arraycopy(paramArrayOfByte2, 1792, paramArrayOfByte1, 0, 32);
  }
  
  static void decodeB(short[] paramArrayOfShort1, short[] paramArrayOfShort2, byte[] paramArrayOfByte)
  {
    Poly.fromBytes(paramArrayOfShort1, paramArrayOfByte);
    int i = 0;
    while (i < 256)
    {
      int j = i * 4;
      int k = paramArrayOfByte[(i + 1792)] & 0xFF;
      paramArrayOfShort2[(j + 0)] = ((short)(k & 0x3));
      paramArrayOfShort2[(j + 1)] = ((short)(k >>> 2 & 0x3));
      paramArrayOfShort2[(j + 2)] = ((short)(k >>> 4 & 0x3));
      paramArrayOfShort2[(j + 3)] = ((short)(k >>> 6));
      i += 1;
    }
  }
  
  static void encodeA(byte[] paramArrayOfByte1, short[] paramArrayOfShort, byte[] paramArrayOfByte2)
  {
    Poly.toBytes(paramArrayOfByte1, paramArrayOfShort);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 1792, 32);
  }
  
  static void encodeB(byte[] paramArrayOfByte, short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    Poly.toBytes(paramArrayOfByte, paramArrayOfShort1);
    int i = 0;
    while (i < 256)
    {
      int j = i * 4;
      int k = paramArrayOfShort2[j];
      int m = paramArrayOfShort2[(j + 1)];
      int n = paramArrayOfShort2[(j + 2)];
      paramArrayOfByte[(i + 1792)] = ((byte)(paramArrayOfShort2[(j + 3)] << 6 | k | m << 2 | n << 4));
      i += 1;
    }
  }
  
  static void generateA(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    Poly.uniform(paramArrayOfShort, paramArrayOfByte);
  }
  
  public static void keygen(SecureRandom paramSecureRandom, byte[] paramArrayOfByte, short[] paramArrayOfShort)
  {
    byte[] arrayOfByte = new byte[32];
    paramSecureRandom.nextBytes(arrayOfByte);
    short[] arrayOfShort = new short['Ѐ'];
    generateA(arrayOfShort, arrayOfByte);
    Object localObject = new byte[32];
    paramSecureRandom.nextBytes((byte[])localObject);
    Poly.getNoise(paramArrayOfShort, (byte[])localObject, (byte)0);
    Poly.toNTT(paramArrayOfShort);
    paramSecureRandom = new short['Ѐ'];
    Poly.getNoise(paramSecureRandom, (byte[])localObject, (byte)1);
    Poly.toNTT(paramSecureRandom);
    localObject = new short['Ѐ'];
    Poly.pointWise(arrayOfShort, paramArrayOfShort, (short[])localObject);
    paramArrayOfShort = new short['Ѐ'];
    Poly.add((short[])localObject, paramSecureRandom, paramArrayOfShort);
    encodeA(paramArrayOfByte, paramArrayOfShort, arrayOfByte);
  }
  
  static void sha3(byte[] paramArrayOfByte)
  {
    SHA3Digest localSHA3Digest = new SHA3Digest(256);
    localSHA3Digest.update(paramArrayOfByte, 0, 32);
    localSHA3Digest.doFinal(paramArrayOfByte, 0);
  }
  
  public static void sharedA(byte[] paramArrayOfByte1, short[] paramArrayOfShort, byte[] paramArrayOfByte2)
  {
    short[] arrayOfShort1 = new short['Ѐ'];
    short[] arrayOfShort2 = new short['Ѐ'];
    decodeB(arrayOfShort1, arrayOfShort2, paramArrayOfByte2);
    paramArrayOfByte2 = new short['Ѐ'];
    Poly.pointWise(paramArrayOfShort, arrayOfShort1, paramArrayOfByte2);
    Poly.fromNTT(paramArrayOfByte2);
    ErrorCorrection.rec(paramArrayOfByte1, paramArrayOfByte2, arrayOfShort2);
    sha3(paramArrayOfByte1);
  }
  
  public static void sharedB(SecureRandom paramSecureRandom, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    short[] arrayOfShort1 = new short['Ѐ'];
    Object localObject = new byte[32];
    decodeA(arrayOfShort1, (byte[])localObject, paramArrayOfByte3);
    short[] arrayOfShort2 = new short['Ѐ'];
    generateA(arrayOfShort2, (byte[])localObject);
    paramArrayOfByte3 = new byte[32];
    paramSecureRandom.nextBytes(paramArrayOfByte3);
    localObject = new short['Ѐ'];
    Poly.getNoise((short[])localObject, paramArrayOfByte3, (byte)0);
    Poly.toNTT((short[])localObject);
    short[] arrayOfShort3 = new short['Ѐ'];
    Poly.getNoise(arrayOfShort3, paramArrayOfByte3, (byte)1);
    Poly.toNTT(arrayOfShort3);
    paramSecureRandom = new short['Ѐ'];
    Poly.pointWise(arrayOfShort2, (short[])localObject, paramSecureRandom);
    Poly.add(paramSecureRandom, arrayOfShort3, paramSecureRandom);
    arrayOfShort2 = new short['Ѐ'];
    Poly.pointWise(arrayOfShort1, (short[])localObject, arrayOfShort2);
    Poly.fromNTT(arrayOfShort2);
    arrayOfShort1 = new short['Ѐ'];
    Poly.getNoise(arrayOfShort1, paramArrayOfByte3, (byte)2);
    Poly.add(arrayOfShort2, arrayOfShort1, arrayOfShort2);
    arrayOfShort1 = new short['Ѐ'];
    ErrorCorrection.helpRec(arrayOfShort1, arrayOfShort2, paramArrayOfByte3, (byte)3);
    encodeB(paramArrayOfByte2, paramSecureRandom, arrayOfShort1);
    ErrorCorrection.rec(paramArrayOfByte1, arrayOfShort2, arrayOfShort1);
    sha3(paramArrayOfByte1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\newhope\NewHope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */