package org.bouncycastle.cms;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.util.io.Streams;

public class CMSTypedStream
{
  private static final int BUF_SIZ = 32768;
  protected InputStream _in;
  private final ASN1ObjectIdentifier _oid;
  
  public CMSTypedStream(InputStream paramInputStream)
  {
    this(PKCSObjectIdentifiers.data.getId(), paramInputStream, 32768);
  }
  
  public CMSTypedStream(String paramString, InputStream paramInputStream)
  {
    this(new ASN1ObjectIdentifier(paramString), paramInputStream, 32768);
  }
  
  public CMSTypedStream(String paramString, InputStream paramInputStream, int paramInt)
  {
    this(new ASN1ObjectIdentifier(paramString), paramInputStream, paramInt);
  }
  
  protected CMSTypedStream(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this._oid = paramASN1ObjectIdentifier;
  }
  
  public CMSTypedStream(ASN1ObjectIdentifier paramASN1ObjectIdentifier, InputStream paramInputStream)
  {
    this(paramASN1ObjectIdentifier, paramInputStream, 32768);
  }
  
  public CMSTypedStream(ASN1ObjectIdentifier paramASN1ObjectIdentifier, InputStream paramInputStream, int paramInt)
  {
    this._oid = paramASN1ObjectIdentifier;
    this._in = new FullReaderStream(new BufferedInputStream(paramInputStream, paramInt));
  }
  
  public void drain()
    throws IOException
  {
    Streams.drain(this._in);
    this._in.close();
  }
  
  public InputStream getContentStream()
  {
    return this._in;
  }
  
  public ASN1ObjectIdentifier getContentType()
  {
    return this._oid;
  }
  
  private static class FullReaderStream
    extends FilterInputStream
  {
    FullReaderStream(InputStream paramInputStream)
    {
      super();
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 = Streams.readFully(this.in, paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 > 0) {
        return paramInt1;
      }
      return -1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSTypedStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */