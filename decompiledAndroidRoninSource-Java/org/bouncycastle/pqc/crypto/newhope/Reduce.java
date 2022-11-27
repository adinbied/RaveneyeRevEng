package org.bouncycastle.pqc.crypto.newhope;

class Reduce
{
  static final int QInv = 12287;
  static final int RLog = 18;
  static final int RMask = 262143;
  
  static short barrett(short paramShort)
  {
    paramShort &= 0xFFFF;
    return (short)(paramShort - (paramShort * 5 >>> 16) * 12289);
  }
  
  static short montgomery(int paramInt)
  {
    return (short)((paramInt * 12287 & 0x3FFFF) * 12289 + paramInt >>> 18);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\newhope\Reduce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */