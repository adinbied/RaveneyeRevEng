package org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequenceGenerator;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.SignerInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CMSSignedDataStreamGenerator
  extends CMSSignedGenerator
{
  private int _bufferSize;
  
  private ASN1Integer calculateVersion(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Object localObject1 = this.certs;
    int i3 = 0;
    int i2 = 0;
    int i;
    if (localObject1 != null)
    {
      localObject1 = this.certs.iterator();
      int k = 0;
      j = 0;
      i = 0;
      for (;;)
      {
        i1 = k;
        n = j;
        m = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof ASN1TaggedObject))
        {
          localObject2 = (ASN1TaggedObject)localObject2;
          if (((ASN1TaggedObject)localObject2).getTagNo() == 1) {
            j = 1;
          } else if (((ASN1TaggedObject)localObject2).getTagNo() == 2) {
            i = 1;
          } else if (((ASN1TaggedObject)localObject2).getTagNo() == 3) {
            k = 1;
          }
        }
      }
    }
    int i1 = 0;
    int n = 0;
    int m = 0;
    if (i1 != 0) {
      return new ASN1Integer(5L);
    }
    int j = i3;
    if (this.crls != null)
    {
      localObject1 = this.crls.iterator();
      i = i2;
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        if ((((Iterator)localObject1).next() instanceof ASN1TaggedObject)) {
          i = 1;
        }
      }
    }
    if (j != 0) {
      return new ASN1Integer(5L);
    }
    if (m != 0) {
      return new ASN1Integer(4L);
    }
    if (n != 0) {
      return new ASN1Integer(3L);
    }
    if (checkForVersion3(this._signers, this.signerGens)) {
      return new ASN1Integer(3L);
    }
    if (!CMSObjectIdentifiers.data.equals(paramASN1ObjectIdentifier)) {
      return new ASN1Integer(3L);
    }
    return new ASN1Integer(1L);
  }
  
  private boolean checkForVersion3(List paramList1, List paramList2)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext()) {
      if (SignerInfo.getInstance(((SignerInformation)paramList1.next()).toASN1Structure()).getVersion().getValue().intValue() == 3) {
        return true;
      }
    }
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext()) {
      if (((SignerInfoGenerator)paramList1.next()).getGeneratedVersion() == 3) {
        return true;
      }
    }
    return false;
  }
  
  public OutputStream open(OutputStream paramOutputStream)
    throws IOException
  {
    return open(paramOutputStream, false);
  }
  
  public OutputStream open(OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException
  {
    return open(CMSObjectIdentifiers.data, paramOutputStream, paramBoolean);
  }
  
  public OutputStream open(OutputStream paramOutputStream1, boolean paramBoolean, OutputStream paramOutputStream2)
    throws IOException
  {
    return open(CMSObjectIdentifiers.data, paramOutputStream1, paramBoolean, paramOutputStream2);
  }
  
  public OutputStream open(ASN1ObjectIdentifier paramASN1ObjectIdentifier, OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException
  {
    return open(paramASN1ObjectIdentifier, paramOutputStream, paramBoolean, null);
  }
  
  public OutputStream open(ASN1ObjectIdentifier paramASN1ObjectIdentifier, OutputStream paramOutputStream1, boolean paramBoolean, OutputStream paramOutputStream2)
    throws IOException
  {
    BERSequenceGenerator localBERSequenceGenerator1 = new BERSequenceGenerator(paramOutputStream1);
    localBERSequenceGenerator1.addObject(CMSObjectIdentifiers.signedData);
    BERSequenceGenerator localBERSequenceGenerator2 = new BERSequenceGenerator(localBERSequenceGenerator1.getRawOutputStream(), 0, true);
    localBERSequenceGenerator2.addObject(calculateVersion(paramASN1ObjectIdentifier));
    paramOutputStream1 = new ASN1EncodableVector();
    Object localObject = this._signers.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SignerInformation localSignerInformation = (SignerInformation)((Iterator)localObject).next();
      paramOutputStream1.add(CMSSignedHelper.INSTANCE.fixAlgID(localSignerInformation.getDigestAlgorithmID()));
    }
    localObject = this.signerGens.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramOutputStream1.add(((SignerInfoGenerator)((Iterator)localObject).next()).getDigestAlgorithm());
    }
    localBERSequenceGenerator2.getRawOutputStream().write(new DERSet(paramOutputStream1).getEncoded());
    localObject = new BERSequenceGenerator(localBERSequenceGenerator2.getRawOutputStream());
    ((BERSequenceGenerator)localObject).addObject(paramASN1ObjectIdentifier);
    if (paramBoolean) {
      paramOutputStream1 = CMSUtils.createBEROctetOutputStream(((BERSequenceGenerator)localObject).getRawOutputStream(), 0, true, this._bufferSize);
    } else {
      paramOutputStream1 = null;
    }
    paramOutputStream1 = CMSUtils.getSafeTeeOutputStream(paramOutputStream2, paramOutputStream1);
    return new CmsSignedDataOutputStream(CMSUtils.attachSignersToOutputStream(this.signerGens, paramOutputStream1), paramASN1ObjectIdentifier, localBERSequenceGenerator1, localBERSequenceGenerator2, (BERSequenceGenerator)localObject);
  }
  
  public void setBufferSize(int paramInt)
  {
    this._bufferSize = paramInt;
  }
  
  private class CmsSignedDataOutputStream
    extends OutputStream
  {
    private ASN1ObjectIdentifier _contentOID;
    private BERSequenceGenerator _eiGen;
    private OutputStream _out;
    private BERSequenceGenerator _sGen;
    private BERSequenceGenerator _sigGen;
    
    public CmsSignedDataOutputStream(OutputStream paramOutputStream, ASN1ObjectIdentifier paramASN1ObjectIdentifier, BERSequenceGenerator paramBERSequenceGenerator1, BERSequenceGenerator paramBERSequenceGenerator2, BERSequenceGenerator paramBERSequenceGenerator3)
    {
      this._out = paramOutputStream;
      this._contentOID = paramASN1ObjectIdentifier;
      this._sGen = paramBERSequenceGenerator1;
      this._sigGen = paramBERSequenceGenerator2;
      this._eiGen = paramBERSequenceGenerator3;
    }
    
    public void close()
      throws IOException
    {
      this._out.close();
      this._eiGen.close();
      CMSSignedDataStreamGenerator.this.digests.clear();
      if (CMSSignedDataStreamGenerator.this.certs.size() != 0)
      {
        localObject1 = CMSUtils.createBerSetFromList(CMSSignedDataStreamGenerator.this.certs);
        this._sigGen.getRawOutputStream().write(new BERTaggedObject(false, 0, (ASN1Encodable)localObject1).getEncoded());
      }
      if (CMSSignedDataStreamGenerator.this.crls.size() != 0)
      {
        localObject1 = CMSUtils.createBerSetFromList(CMSSignedDataStreamGenerator.this.crls);
        this._sigGen.getRawOutputStream().write(new BERTaggedObject(false, 1, (ASN1Encodable)localObject1).getEncoded());
      }
      Object localObject1 = new ASN1EncodableVector();
      Object localObject2 = CMSSignedDataStreamGenerator.this.signerGens.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        SignerInfoGenerator localSignerInfoGenerator = (SignerInfoGenerator)((Iterator)localObject2).next();
        try
        {
          ((ASN1EncodableVector)localObject1).add(localSignerInfoGenerator.generate(this._contentOID));
          byte[] arrayOfByte = localSignerInfoGenerator.getCalculatedDigest();
          CMSSignedDataStreamGenerator.this.digests.put(localSignerInfoGenerator.getDigestAlgorithm().getAlgorithm().getId(), arrayOfByte);
        }
        catch (CMSException localCMSException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("exception generating signers: ");
          ((StringBuilder)localObject2).append(localCMSException.getMessage());
          throw new CMSStreamException(((StringBuilder)localObject2).toString(), localCMSException);
        }
      }
      localObject2 = CMSSignedDataStreamGenerator.this._signers.iterator();
      while (((Iterator)localObject2).hasNext()) {
        localCMSException.add(((SignerInformation)((Iterator)localObject2).next()).toASN1Structure());
      }
      this._sigGen.getRawOutputStream().write(new DERSet(localCMSException).getEncoded());
      this._sigGen.close();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSSignedDataStreamGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */