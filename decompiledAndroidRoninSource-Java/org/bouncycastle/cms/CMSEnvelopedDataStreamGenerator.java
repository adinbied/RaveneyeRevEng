package org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.BERSequenceGenerator;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.EnvelopedData;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OutputEncryptor;

public class CMSEnvelopedDataStreamGenerator
  extends CMSEnvelopedGenerator
{
  private boolean _berEncodeRecipientSet;
  private int _bufferSize;
  private ASN1Set _unprotectedAttributes = null;
  
  private OutputStream doOpen(ASN1ObjectIdentifier paramASN1ObjectIdentifier, OutputStream paramOutputStream, OutputEncryptor paramOutputEncryptor)
    throws IOException, CMSException
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    GenericKey localGenericKey = paramOutputEncryptor.getKey();
    Iterator localIterator = this.recipientInfoGenerators.iterator();
    while (localIterator.hasNext()) {
      localASN1EncodableVector.add(((RecipientInfoGenerator)localIterator.next()).generate(localGenericKey));
    }
    return open(paramASN1ObjectIdentifier, paramOutputStream, localASN1EncodableVector, paramOutputEncryptor);
  }
  
  private ASN1Integer getVersion()
  {
    if ((this.originatorInfo == null) && (this._unprotectedAttributes == null)) {
      return new ASN1Integer(0L);
    }
    return new ASN1Integer(2L);
  }
  
  protected OutputStream open(OutputStream paramOutputStream, ASN1EncodableVector paramASN1EncodableVector, OutputEncryptor paramOutputEncryptor)
    throws CMSException
  {
    try
    {
      BERSequenceGenerator localBERSequenceGenerator1 = new BERSequenceGenerator(paramOutputStream);
      localBERSequenceGenerator1.addObject(CMSObjectIdentifiers.envelopedData);
      BERSequenceGenerator localBERSequenceGenerator2 = new BERSequenceGenerator(localBERSequenceGenerator1.getRawOutputStream(), 0, true);
      if (this._berEncodeRecipientSet) {
        paramOutputStream = new BERSet(paramASN1EncodableVector);
      } else {
        paramOutputStream = new DERSet(paramASN1EncodableVector);
      }
      localBERSequenceGenerator2.addObject(new ASN1Integer(EnvelopedData.calculateVersion(this.originatorInfo, paramOutputStream, this._unprotectedAttributes)));
      if (this.originatorInfo != null) {
        localBERSequenceGenerator2.addObject(new DERTaggedObject(false, 0, this.originatorInfo));
      }
      localBERSequenceGenerator2.getRawOutputStream().write(paramOutputStream.getEncoded());
      paramOutputStream = new BERSequenceGenerator(localBERSequenceGenerator2.getRawOutputStream());
      paramOutputStream.addObject(CMSObjectIdentifiers.data);
      paramASN1EncodableVector = paramOutputEncryptor.getAlgorithmIdentifier();
      paramOutputStream.getRawOutputStream().write(paramASN1EncodableVector.getEncoded());
      paramOutputStream = new CmsEnvelopedDataOutputStream(paramOutputEncryptor.getOutputStream(CMSUtils.createBEROctetOutputStream(paramOutputStream.getRawOutputStream(), 0, false, this._bufferSize)), localBERSequenceGenerator1, localBERSequenceGenerator2, paramOutputStream);
      return paramOutputStream;
    }
    catch (IOException paramOutputStream)
    {
      throw new CMSException("exception decoding algorithm parameters.", paramOutputStream);
    }
  }
  
  public OutputStream open(OutputStream paramOutputStream, OutputEncryptor paramOutputEncryptor)
    throws CMSException, IOException
  {
    return doOpen(new ASN1ObjectIdentifier(CMSObjectIdentifiers.data.getId()), paramOutputStream, paramOutputEncryptor);
  }
  
  protected OutputStream open(ASN1ObjectIdentifier paramASN1ObjectIdentifier, OutputStream paramOutputStream, ASN1EncodableVector paramASN1EncodableVector, OutputEncryptor paramOutputEncryptor)
    throws IOException
  {
    paramOutputStream = new BERSequenceGenerator(paramOutputStream);
    paramOutputStream.addObject(CMSObjectIdentifiers.envelopedData);
    BERSequenceGenerator localBERSequenceGenerator = new BERSequenceGenerator(paramOutputStream.getRawOutputStream(), 0, true);
    localBERSequenceGenerator.addObject(getVersion());
    if (this.originatorInfo != null) {
      localBERSequenceGenerator.addObject(new DERTaggedObject(false, 0, this.originatorInfo));
    }
    if (this._berEncodeRecipientSet) {
      localBERSequenceGenerator.getRawOutputStream().write(new BERSet(paramASN1EncodableVector).getEncoded());
    } else {
      localBERSequenceGenerator.getRawOutputStream().write(new DERSet(paramASN1EncodableVector).getEncoded());
    }
    paramASN1EncodableVector = new BERSequenceGenerator(localBERSequenceGenerator.getRawOutputStream());
    paramASN1EncodableVector.addObject(paramASN1ObjectIdentifier);
    paramASN1ObjectIdentifier = paramOutputEncryptor.getAlgorithmIdentifier();
    paramASN1EncodableVector.getRawOutputStream().write(paramASN1ObjectIdentifier.getEncoded());
    return new CmsEnvelopedDataOutputStream(paramOutputEncryptor.getOutputStream(CMSUtils.createBEROctetOutputStream(paramASN1EncodableVector.getRawOutputStream(), 0, false, this._bufferSize)), paramOutputStream, localBERSequenceGenerator, paramASN1EncodableVector);
  }
  
  public OutputStream open(ASN1ObjectIdentifier paramASN1ObjectIdentifier, OutputStream paramOutputStream, OutputEncryptor paramOutputEncryptor)
    throws CMSException, IOException
  {
    return doOpen(paramASN1ObjectIdentifier, paramOutputStream, paramOutputEncryptor);
  }
  
  public void setBEREncodeRecipients(boolean paramBoolean)
  {
    this._berEncodeRecipientSet = paramBoolean;
  }
  
  public void setBufferSize(int paramInt)
  {
    this._bufferSize = paramInt;
  }
  
  private class CmsEnvelopedDataOutputStream
    extends OutputStream
  {
    private BERSequenceGenerator _cGen;
    private BERSequenceGenerator _eiGen;
    private BERSequenceGenerator _envGen;
    private OutputStream _out;
    
    public CmsEnvelopedDataOutputStream(OutputStream paramOutputStream, BERSequenceGenerator paramBERSequenceGenerator1, BERSequenceGenerator paramBERSequenceGenerator2, BERSequenceGenerator paramBERSequenceGenerator3)
    {
      this._out = paramOutputStream;
      this._cGen = paramBERSequenceGenerator1;
      this._envGen = paramBERSequenceGenerator2;
      this._eiGen = paramBERSequenceGenerator3;
    }
    
    public void close()
      throws IOException
    {
      this._out.close();
      this._eiGen.close();
      if (CMSEnvelopedDataStreamGenerator.this.unprotectedAttributeGenerator != null)
      {
        BERSet localBERSet = new BERSet(CMSEnvelopedDataStreamGenerator.this.unprotectedAttributeGenerator.getAttributes(new HashMap()).toASN1EncodableVector());
        this._envGen.addObject(new DERTaggedObject(false, 1, localBERSet));
      }
      this._envGen.close();
      this._cGen.close();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSEnvelopedDataStreamGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */