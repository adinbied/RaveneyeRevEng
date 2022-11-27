package org.bouncycastle.pqc.crypto.xmss;

public final class WOTSPlusPublicKeyParameters
{
  private final byte[][] publicKey;
  
  protected WOTSPlusPublicKeyParameters(WOTSPlusParameters paramWOTSPlusParameters, byte[][] paramArrayOfByte)
  {
    if (paramWOTSPlusParameters != null)
    {
      if (paramArrayOfByte != null)
      {
        if (!XMSSUtil.hasNullPointer(paramArrayOfByte))
        {
          if (paramArrayOfByte.length == paramWOTSPlusParameters.getLen())
          {
            int i = 0;
            while (i < paramArrayOfByte.length) {
              if (paramArrayOfByte[i].length == paramWOTSPlusParameters.getDigestSize()) {
                i += 1;
              } else {
                throw new IllegalArgumentException("wrong publicKey format");
              }
            }
            this.publicKey = XMSSUtil.cloneArray(paramArrayOfByte);
            return;
          }
          throw new IllegalArgumentException("wrong publicKey size");
        }
        throw new NullPointerException("publicKey byte array == null");
      }
      throw new NullPointerException("publicKey == null");
    }
    throw new NullPointerException("params == null");
  }
  
  protected byte[][] toByteArray()
  {
    return XMSSUtil.cloneArray(this.publicKey);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\WOTSPlusPublicKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */