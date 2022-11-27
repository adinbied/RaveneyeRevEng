package org.bouncycastle.pqc.crypto.xmss;

public final class WOTSPlusSignature
{
  private byte[][] signature;
  
  protected WOTSPlusSignature(WOTSPlusParameters paramWOTSPlusParameters, byte[][] paramArrayOfByte)
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
                throw new IllegalArgumentException("wrong signature format");
              }
            }
            this.signature = XMSSUtil.cloneArray(paramArrayOfByte);
            return;
          }
          throw new IllegalArgumentException("wrong signature size");
        }
        throw new NullPointerException("signature byte array == null");
      }
      throw new NullPointerException("signature == null");
    }
    throw new NullPointerException("params == null");
  }
  
  public byte[][] toByteArray()
  {
    return XMSSUtil.cloneArray(this.signature);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\WOTSPlusSignature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */