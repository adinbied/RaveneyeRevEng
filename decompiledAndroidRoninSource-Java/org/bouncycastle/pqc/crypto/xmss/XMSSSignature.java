package org.bouncycastle.pqc.crypto.xmss;

import java.text.ParseException;
import java.util.List;
import org.bouncycastle.util.Pack;

public final class XMSSSignature
  extends XMSSReducedSignature
  implements XMSSStoreableObjectInterface
{
  private final int index;
  private final byte[] random;
  
  private XMSSSignature(Builder paramBuilder)
    throws ParseException
  {
    super(paramBuilder);
    this.index = paramBuilder.index;
    int i = getParams().getDigestSize();
    paramBuilder = paramBuilder.random;
    if (paramBuilder != null)
    {
      if (paramBuilder.length == i)
      {
        this.random = paramBuilder;
        return;
      }
      throw new IllegalArgumentException("size of random needs to be equal to size of digest");
    }
    this.random = new byte[i];
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public byte[] getRandom()
  {
    return XMSSUtil.cloneArray(this.random);
  }
  
  public byte[] toByteArray()
  {
    int i1 = getParams().getDigestSize();
    byte[] arrayOfByte = new byte[i1 + 4 + getParams().getWOTSPlus().getParams().getLen() * i1 + getParams().getHeight() * i1];
    int i = this.index;
    int n = 0;
    XMSSUtil.intToBytesBigEndianOffset(arrayOfByte, i, 0);
    XMSSUtil.copyBytesAtOffset(arrayOfByte, this.random, 4);
    i = 4 + i1;
    byte[][] arrayOfByte1 = getWOTSPlusSignature().toByteArray();
    int j = 0;
    int k;
    int m;
    for (;;)
    {
      k = n;
      m = i;
      if (j >= arrayOfByte1.length) {
        break;
      }
      XMSSUtil.copyBytesAtOffset(arrayOfByte, arrayOfByte1[j], i);
      i += i1;
      j += 1;
    }
    while (k < getAuthPath().size())
    {
      XMSSUtil.copyBytesAtOffset(arrayOfByte, ((XMSSNode)getAuthPath().get(k)).getValue(), m);
      m += i1;
      k += 1;
    }
    return arrayOfByte;
  }
  
  public static class Builder
    extends XMSSReducedSignature.Builder
  {
    private int index = 0;
    private final XMSSParameters params;
    private byte[] random = null;
    
    public Builder(XMSSParameters paramXMSSParameters)
    {
      super();
      this.params = paramXMSSParameters;
    }
    
    public XMSSSignature build()
      throws ParseException
    {
      return new XMSSSignature(this, null);
    }
    
    public Builder withIndex(int paramInt)
    {
      this.index = paramInt;
      return this;
    }
    
    public Builder withRandom(byte[] paramArrayOfByte)
    {
      this.random = XMSSUtil.cloneArray(paramArrayOfByte);
      return this;
    }
    
    public Builder withSignature(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null)
      {
        int i = this.params.getDigestSize();
        int j = this.params.getWOTSPlus().getParams().getLen();
        int k = this.params.getHeight();
        this.index = Pack.bigEndianToInt(paramArrayOfByte, 0);
        this.random = XMSSUtil.extractBytesAtOffset(paramArrayOfByte, 4, i);
        withReducedSignature(XMSSUtil.extractBytesAtOffset(paramArrayOfByte, 4 + i, j * i + k * i));
        return this;
      }
      throw new NullPointerException("signature == null");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\XMSSSignature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */