package org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.BERSequenceGenerator;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.AuthenticatedData;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.util.io.TeeOutputStream;

public class CMSAuthenticatedDataStreamGenerator
  extends CMSAuthenticatedGenerator
{
  private boolean berEncodeRecipientSet;
  private int bufferSize;
  private MacCalculator macCalculator;
  
  public OutputStream open(OutputStream paramOutputStream, MacCalculator paramMacCalculator)
    throws CMSException
  {
    return open(CMSObjectIdentifiers.data, paramOutputStream, paramMacCalculator);
  }
  
  public OutputStream open(OutputStream paramOutputStream, MacCalculator paramMacCalculator, DigestCalculator paramDigestCalculator)
    throws CMSException
  {
    return open(CMSObjectIdentifiers.data, paramOutputStream, paramMacCalculator, paramDigestCalculator);
  }
  
  public OutputStream open(ASN1ObjectIdentifier paramASN1ObjectIdentifier, OutputStream paramOutputStream, MacCalculator paramMacCalculator)
    throws CMSException
  {
    return open(paramASN1ObjectIdentifier, paramOutputStream, paramMacCalculator, null);
  }
  
  public OutputStream open(ASN1ObjectIdentifier paramASN1ObjectIdentifier, OutputStream paramOutputStream, MacCalculator paramMacCalculator, DigestCalculator paramDigestCalculator)
    throws CMSException
  {
    this.macCalculator = paramMacCalculator;
    try
    {
      Object localObject2 = new ASN1EncodableVector();
      Object localObject1 = this.recipientInfoGenerators.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((ASN1EncodableVector)localObject2).add(((RecipientInfoGenerator)((Iterator)localObject1).next()).generate(paramMacCalculator.getKey()));
      }
      localObject1 = new BERSequenceGenerator(paramOutputStream);
      ((BERSequenceGenerator)localObject1).addObject(CMSObjectIdentifiers.authenticatedData);
      BERSequenceGenerator localBERSequenceGenerator = new BERSequenceGenerator(((BERSequenceGenerator)localObject1).getRawOutputStream(), 0, true);
      localBERSequenceGenerator.addObject(new ASN1Integer(AuthenticatedData.calculateVersion(this.originatorInfo)));
      if (this.originatorInfo != null) {
        localBERSequenceGenerator.addObject(new DERTaggedObject(false, 0, this.originatorInfo));
      }
      if (this.berEncodeRecipientSet) {
        localBERSequenceGenerator.getRawOutputStream().write(new BERSet((ASN1EncodableVector)localObject2).getEncoded());
      } else {
        localBERSequenceGenerator.getRawOutputStream().write(new DERSet((ASN1EncodableVector)localObject2).getEncoded());
      }
      paramOutputStream = paramMacCalculator.getAlgorithmIdentifier();
      localBERSequenceGenerator.getRawOutputStream().write(paramOutputStream.getEncoded());
      if (paramDigestCalculator != null) {
        localBERSequenceGenerator.addObject(new DERTaggedObject(false, 1, paramDigestCalculator.getAlgorithmIdentifier()));
      }
      localObject2 = new BERSequenceGenerator(localBERSequenceGenerator.getRawOutputStream());
      ((BERSequenceGenerator)localObject2).addObject(paramASN1ObjectIdentifier);
      paramOutputStream = CMSUtils.createBEROctetOutputStream(((BERSequenceGenerator)localObject2).getRawOutputStream(), 0, false, this.bufferSize);
      if (paramDigestCalculator != null) {
        paramOutputStream = new TeeOutputStream(paramOutputStream, paramDigestCalculator.getOutputStream());
      } else {
        paramOutputStream = new TeeOutputStream(paramOutputStream, paramMacCalculator.getOutputStream());
      }
      paramASN1ObjectIdentifier = new CmsAuthenticatedDataOutputStream(paramMacCalculator, paramDigestCalculator, paramASN1ObjectIdentifier, paramOutputStream, (BERSequenceGenerator)localObject1, localBERSequenceGenerator, (BERSequenceGenerator)localObject2);
      return paramASN1ObjectIdentifier;
    }
    catch (IOException paramASN1ObjectIdentifier)
    {
      throw new CMSException("exception decoding algorithm parameters.", paramASN1ObjectIdentifier);
    }
  }
  
  public void setBEREncodeRecipients(boolean paramBoolean)
  {
    this.berEncodeRecipientSet = paramBoolean;
  }
  
  public void setBufferSize(int paramInt)
  {
    this.bufferSize = paramInt;
  }
  
  private class CmsAuthenticatedDataOutputStream
    extends OutputStream
  {
    private BERSequenceGenerator cGen;
    private ASN1ObjectIdentifier contentType;
    private OutputStream dataStream;
    private DigestCalculator digestCalculator;
    private BERSequenceGenerator eiGen;
    private BERSequenceGenerator envGen;
    private MacCalculator macCalculator;
    
    public CmsAuthenticatedDataOutputStream(MacCalculator paramMacCalculator, DigestCalculator paramDigestCalculator, ASN1ObjectIdentifier paramASN1ObjectIdentifier, OutputStream paramOutputStream, BERSequenceGenerator paramBERSequenceGenerator1, BERSequenceGenerator paramBERSequenceGenerator2, BERSequenceGenerator paramBERSequenceGenerator3)
    {
      this.macCalculator = paramMacCalculator;
      this.digestCalculator = paramDigestCalculator;
      this.contentType = paramASN1ObjectIdentifier;
      this.dataStream = paramOutputStream;
      this.cGen = paramBERSequenceGenerator1;
      this.envGen = paramBERSequenceGenerator2;
      this.eiGen = paramBERSequenceGenerator3;
    }
    
    public void close()
      throws IOException
    {
      this.dataStream.close();
      this.eiGen.close();
      Object localObject = this.digestCalculator;
      if (localObject != null)
      {
        localObject = Collections.unmodifiableMap(CMSAuthenticatedDataStreamGenerator.this.getBaseParameters(this.contentType, ((DigestCalculator)localObject).getAlgorithmIdentifier(), this.macCalculator.getAlgorithmIdentifier(), this.digestCalculator.getDigest()));
        if (CMSAuthenticatedDataStreamGenerator.this.authGen == null) {
          CMSAuthenticatedDataStreamGenerator.this.authGen = new DefaultAuthenticatedAttributeTableGenerator();
        }
        DERSet localDERSet = new DERSet(CMSAuthenticatedDataStreamGenerator.this.authGen.getAttributes((Map)localObject).toASN1EncodableVector());
        OutputStream localOutputStream = this.macCalculator.getOutputStream();
        localOutputStream.write(localDERSet.getEncoded("DER"));
        localOutputStream.close();
        this.envGen.addObject(new DERTaggedObject(false, 2, localDERSet));
      }
      else
      {
        localObject = Collections.unmodifiableMap(new HashMap());
      }
      this.envGen.addObject(new DEROctetString(this.macCalculator.getMac()));
      if (CMSAuthenticatedDataStreamGenerator.this.unauthGen != null) {
        this.envGen.addObject(new DERTaggedObject(false, 3, new BERSet(CMSAuthenticatedDataStreamGenerator.this.unauthGen.getAttributes((Map)localObject).toASN1EncodableVector())));
      }
      this.envGen.close();
      this.cGen.close();
    }
    
    public void write(int paramInt)
      throws IOException
    {
      this.dataStream.write(paramInt);
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      this.dataStream.write(paramArrayOfByte);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this.dataStream.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSAuthenticatedDataStreamGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */