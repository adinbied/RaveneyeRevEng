package org.bouncycastle.pqc.crypto.xmss;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class XMSSReducedSignature
  implements XMSSStoreableObjectInterface
{
  private final List<XMSSNode> authPath;
  private final XMSSParameters params;
  private final WOTSPlusSignature wotsPlusSignature;
  
  protected XMSSReducedSignature(Builder paramBuilder)
    throws ParseException
  {
    Object localObject = paramBuilder.params;
    this.params = ((XMSSParameters)localObject);
    if (localObject != null)
    {
      int m = ((XMSSParameters)localObject).getDigestSize();
      int i1 = this.params.getWOTSPlus().getParams().getLen();
      int n = this.params.getHeight();
      byte[] arrayOfByte = paramBuilder.reducedSignature;
      int k = 0;
      if (arrayOfByte != null)
      {
        if (arrayOfByte.length == i1 * m + n * m)
        {
          paramBuilder = new byte[i1][];
          int j = 0;
          int i = 0;
          while (j < i1)
          {
            paramBuilder[j] = XMSSUtil.extractBytesAtOffset(arrayOfByte, i, m);
            i += m;
            j += 1;
          }
          this.wotsPlusSignature = new WOTSPlusSignature(this.params.getWOTSPlus().getParams(), paramBuilder);
          localObject = new ArrayList();
          j = i;
          i = k;
          for (;;)
          {
            paramBuilder = (Builder)localObject;
            if (i >= n) {
              break;
            }
            ((List)localObject).add(new XMSSNode(i, XMSSUtil.extractBytesAtOffset(arrayOfByte, j, m)));
            j += m;
            i += 1;
          }
        }
        throw new ParseException("signature has wrong size", 0);
      }
      localObject = paramBuilder.wotsPlusSignature;
      if (localObject == null) {
        localObject = new WOTSPlusSignature(this.params.getWOTSPlus().getParams(), (byte[][])Array.newInstance(Byte.TYPE, new int[] { i1, m }));
      }
      this.wotsPlusSignature = ((WOTSPlusSignature)localObject);
      paramBuilder = paramBuilder.authPath;
      if (paramBuilder != null)
      {
        if (paramBuilder.size() != n) {
          throw new IllegalArgumentException("size of authPath needs to be equal to height of tree");
        }
      }
      else {
        paramBuilder = new ArrayList();
      }
      this.authPath = paramBuilder;
      return;
    }
    throw new NullPointerException("params == null");
  }
  
  public List<XMSSNode> getAuthPath()
  {
    return this.authPath;
  }
  
  public XMSSParameters getParams()
  {
    return this.params;
  }
  
  public WOTSPlusSignature getWOTSPlusSignature()
  {
    return this.wotsPlusSignature;
  }
  
  public byte[] toByteArray()
  {
    int i1 = this.params.getDigestSize();
    byte[] arrayOfByte = new byte[this.params.getWOTSPlus().getParams().getLen() * i1 + this.params.getHeight() * i1];
    byte[][] arrayOfByte1 = this.wotsPlusSignature.toByteArray();
    int n = 0;
    int j = 0;
    int i = 0;
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
    while (k < this.authPath.size())
    {
      XMSSUtil.copyBytesAtOffset(arrayOfByte, ((XMSSNode)this.authPath.get(k)).getValue(), m);
      m += i1;
      k += 1;
    }
    return arrayOfByte;
  }
  
  public static class Builder
  {
    private List<XMSSNode> authPath = null;
    private final XMSSParameters params;
    private byte[] reducedSignature = null;
    private WOTSPlusSignature wotsPlusSignature = null;
    
    public Builder(XMSSParameters paramXMSSParameters)
    {
      this.params = paramXMSSParameters;
    }
    
    public XMSSReducedSignature build()
      throws ParseException
    {
      return new XMSSReducedSignature(this);
    }
    
    public Builder withAuthPath(List<XMSSNode> paramList)
    {
      this.authPath = paramList;
      return this;
    }
    
    public Builder withReducedSignature(byte[] paramArrayOfByte)
    {
      this.reducedSignature = XMSSUtil.cloneArray(paramArrayOfByte);
      return this;
    }
    
    public Builder withWOTSPlusSignature(WOTSPlusSignature paramWOTSPlusSignature)
    {
      this.wotsPlusSignature = paramWOTSPlusSignature;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\XMSSReducedSignature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */