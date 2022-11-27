package org.bouncycastle.pqc.crypto.xmss;

public final class WOTSPlusPrivateKeyParameters
{
  private final byte[][] privateKey;
  
  protected WOTSPlusPrivateKeyParameters(WOTSPlusParameters paramWOTSPlusParameters, byte[][] paramArrayOfByte)
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
                throw new IllegalArgumentException("wrong privateKey format");
              }
            }
            this.privateKey = XMSSUtil.cloneArray(paramArrayOfByte);
            return;
          }
          throw new IllegalArgumentException("wrong privateKey format");
        }
        throw new NullPointerException("privateKey byte array == null");
      }
      throw new NullPointerException("privateKey == null");
    }
    throw new NullPointerException("params == null");
  }
  
  protected byte[][] toByteArray()
  {
    return XMSSUtil.cloneArray(this.privateKey);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\WOTSPlusPrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */