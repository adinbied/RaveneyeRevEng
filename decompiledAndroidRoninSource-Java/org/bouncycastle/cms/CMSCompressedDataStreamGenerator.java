package org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.BERSequenceGenerator;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.operator.OutputCompressor;

public class CMSCompressedDataStreamGenerator
{
  public static final String ZLIB = "1.2.840.113549.1.9.16.3.8";
  private int _bufferSize;
  
  public OutputStream open(OutputStream paramOutputStream, OutputCompressor paramOutputCompressor)
    throws IOException
  {
    return open(CMSObjectIdentifiers.data, paramOutputStream, paramOutputCompressor);
  }
  
  public OutputStream open(ASN1ObjectIdentifier paramASN1ObjectIdentifier, OutputStream paramOutputStream, OutputCompressor paramOutputCompressor)
    throws IOException
  {
    paramOutputStream = new BERSequenceGenerator(paramOutputStream);
    paramOutputStream.addObject(CMSObjectIdentifiers.compressedData);
    BERSequenceGenerator localBERSequenceGenerator1 = new BERSequenceGenerator(paramOutputStream.getRawOutputStream(), 0, true);
    localBERSequenceGenerator1.addObject(new ASN1Integer(0L));
    localBERSequenceGenerator1.addObject(paramOutputCompressor.getAlgorithmIdentifier());
    BERSequenceGenerator localBERSequenceGenerator2 = new BERSequenceGenerator(localBERSequenceGenerator1.getRawOutputStream());
    localBERSequenceGenerator2.addObject(paramASN1ObjectIdentifier);
    return new CmsCompressedOutputStream(paramOutputCompressor.getOutputStream(CMSUtils.createBEROctetOutputStream(localBERSequenceGenerator2.getRawOutputStream(), 0, true, this._bufferSize)), paramOutputStream, localBERSequenceGenerator1, localBERSequenceGenerator2);
  }
  
  public void setBufferSize(int paramInt)
  {
    this._bufferSize = paramInt;
  }
  
  private class CmsCompressedOutputStream
    extends OutputStream
  {
    private BERSequenceGenerator _cGen;
    private BERSequenceGenerator _eiGen;
    private OutputStream _out;
    private BERSequenceGenerator _sGen;
    
    CmsCompressedOutputStream(OutputStream paramOutputStream, BERSequenceGenerator paramBERSequenceGenerator1, BERSequenceGenerator paramBERSequenceGenerator2, BERSequenceGenerator paramBERSequenceGenerator3)
    {
      this._out = paramOutputStream;
      this._sGen = paramBERSequenceGenerator1;
      this._cGen = paramBERSequenceGenerator2;
      this._eiGen = paramBERSequenceGenerator3;
    }
    
    public void close()
      throws IOException
    {
      this._out.close();
      this._eiGen.close();
      this._cGen.close();
      this._sGen.close();
    }
    
    public void write(int paramInt)
      throws IOException
    {
      this._out.write(paramInt);
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      this._out.write(paramArrayOfByte);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this._out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSCompressedDataStreamGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */