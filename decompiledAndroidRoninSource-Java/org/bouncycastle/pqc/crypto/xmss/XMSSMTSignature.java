package org.bouncycastle.pqc.crypto.xmss;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class XMSSMTSignature
  implements XMSSStoreableObjectInterface
{
  private final long index;
  private final XMSSMTParameters params;
  private final byte[] random;
  private final List<XMSSReducedSignature> reducedSignatures;
  
  private XMSSMTSignature(Builder paramBuilder)
    throws ParseException
  {
    Object localObject = paramBuilder.params;
    this.params = ((XMSSMTParameters)localObject);
    if (localObject != null)
    {
      int i = ((XMSSMTParameters)localObject).getDigestSize();
      localObject = paramBuilder.signature;
      if (localObject != null)
      {
        int j = this.params.getWOTSPlus().getParams().getLen();
        int k = (int)Math.ceil(this.params.getHeight() / 8.0D);
        j = (this.params.getHeight() / this.params.getLayers() + j) * i;
        int m = this.params.getLayers();
        if (localObject.length == k + i + m * j)
        {
          this.index = XMSSUtil.bytesToXBigEndian((byte[])localObject, 0, k);
          if (XMSSUtil.isIndexValid(this.params.getHeight(), this.index))
          {
            k += 0;
            this.random = XMSSUtil.extractBytesAtOffset((byte[])localObject, k, i);
            i = k + i;
            this.reducedSignatures = new ArrayList();
            while (i < localObject.length)
            {
              paramBuilder = new XMSSReducedSignature.Builder(this.params.getXMSS().getParams()).withReducedSignature(XMSSUtil.extractBytesAtOffset((byte[])localObject, i, j)).build();
              this.reducedSignatures.add(paramBuilder);
              i += j;
            }
          }
          throw new ParseException("index out of bounds", 0);
        }
        throw new ParseException("signature has wrong size", 0);
      }
      this.index = paramBuilder.index;
      localObject = paramBuilder.random;
      if (localObject != null)
      {
        if (localObject.length == i) {
          this.random = ((byte[])localObject);
        } else {
          throw new IllegalArgumentException("size of random needs to be equal to size of digest");
        }
      }
      else {
        this.random = new byte[i];
      }
      paramBuilder = paramBuilder.reducedSignatures;
      if (paramBuilder == null) {
        paramBuilder = new ArrayList();
      }
      this.reducedSignatures = paramBuilder;
      return;
    }
    throw new NullPointerException("params == null");
  }
  
  public long getIndex()
  {
    return this.index;
  }
  
  public byte[] getRandom()
  {
    return XMSSUtil.cloneArray(this.random);
  }
  
  public List<XMSSReducedSignature> getReducedSignatures()
  {
    return this.reducedSignatures;
  }
  
  public byte[] toByteArray()
  {
    int i = this.params.getDigestSize();
    int j = this.params.getWOTSPlus().getParams().getLen();
    int k = (int)Math.ceil(this.params.getHeight() / 8.0D);
    j = (this.params.getHeight() / this.params.getLayers() + j) * i;
    byte[] arrayOfByte = new byte[k + i + this.params.getLayers() * j];
    XMSSUtil.copyBytesAtOffset(arrayOfByte, XMSSUtil.toBytesBigEndian(this.index, k), 0);
    k += 0;
    XMSSUtil.copyBytesAtOffset(arrayOfByte, this.random, k);
    i = k + i;
    Iterator localIterator = this.reducedSignatures.iterator();
    while (localIterator.hasNext())
    {
      XMSSUtil.copyBytesAtOffset(arrayOfByte, ((XMSSReducedSignature)localIterator.next()).toByteArray(), i);
      i += j;
    }
    return arrayOfByte;
  }
  
  public static class Builder
  {
    private long index = 0L;
    private final XMSSMTParameters params;
    private byte[] random = null;
    private List<XMSSReducedSignature> reducedSignatures = null;
    private byte[] signature = null;
    
    public Builder(XMSSMTParameters paramXMSSMTParameters)
    {
      this.params = paramXMSSMTParameters;
    }
    
    public XMSSMTSignature build()
      throws ParseException
    {
      return new XMSSMTSignature(this, null);
    }
    
    public Builder withIndex(long paramLong)
    {
      this.index = paramLong;
      return this;
    }
    
    public Builder withRandom(byte[] paramArrayOfByte)
    {
      this.random = XMSSUtil.cloneArray(paramArrayOfByte);
      return this;
    }
    
    public Builder withReducedSignatures(List<XMSSReducedSignature> paramList)
    {
      this.reducedSignatures = paramList;
      return this;
    }
    
    public Builder withSignature(byte[] paramArrayOfByte)
    {
      this.signature = paramArrayOfByte;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\XMSSMTSignature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */