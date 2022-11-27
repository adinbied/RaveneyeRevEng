package org.bouncycastle.cms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.AuthenticatedData;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.io.TeeOutputStream;

public class CMSAuthenticatedDataGenerator
  extends CMSAuthenticatedGenerator
{
  public CMSAuthenticatedData generate(CMSTypedData paramCMSTypedData, MacCalculator paramMacCalculator)
    throws CMSException
  {
    return generate(paramCMSTypedData, paramMacCalculator, null);
  }
  
  public CMSAuthenticatedData generate(CMSTypedData paramCMSTypedData, MacCalculator paramMacCalculator, final DigestCalculator paramDigestCalculator)
    throws CMSException
  {
    localASN1EncodableVector = new ASN1EncodableVector();
    localObject1 = this.recipientInfoGenerators.iterator();
    while (((Iterator)localObject1).hasNext()) {
      localASN1EncodableVector.add(((RecipientInfoGenerator)((Iterator)localObject1).next()).generate(paramMacCalculator.getKey()));
    }
    localObject2 = null;
    localObject1 = null;
    if (paramDigestCalculator != null) {
      try
      {
        localObject2 = new ByteArrayOutputStream();
        Object localObject3 = new TeeOutputStream(paramDigestCalculator.getOutputStream(), (OutputStream)localObject2);
        paramCMSTypedData.write((OutputStream)localObject3);
        ((OutputStream)localObject3).close();
        localObject2 = new BEROctetString(((ByteArrayOutputStream)localObject2).toByteArray());
        Map localMap = getBaseParameters(paramCMSTypedData.getContentType(), paramDigestCalculator.getAlgorithmIdentifier(), paramMacCalculator.getAlgorithmIdentifier(), paramDigestCalculator.getDigest());
        if (this.authGen == null) {
          this.authGen = new DefaultAuthenticatedAttributeTableGenerator();
        }
        localObject3 = new DERSet(this.authGen.getAttributes(Collections.unmodifiableMap(localMap)).toASN1EncodableVector());
        try
        {
          paramCMSTypedData = paramMacCalculator.getOutputStream();
          paramCMSTypedData.write(((ASN1Set)localObject3).getEncoded("DER"));
          paramCMSTypedData.close();
          DEROctetString localDEROctetString = new DEROctetString(paramMacCalculator.getMac());
          paramCMSTypedData = (CMSTypedData)localObject1;
          if (this.unauthGen != null) {
            paramCMSTypedData = new BERSet(this.unauthGen.getAttributes(Collections.unmodifiableMap(localMap)).toASN1EncodableVector());
          }
          localObject1 = new ContentInfo(CMSObjectIdentifiers.data, (ASN1Encodable)localObject2);
          paramCMSTypedData = new AuthenticatedData(this.originatorInfo, new DERSet(localASN1EncodableVector), paramMacCalculator.getAlgorithmIdentifier(), paramDigestCalculator.getAlgorithmIdentifier(), (ContentInfo)localObject1, (ASN1Set)localObject3, localDEROctetString, paramCMSTypedData);
        }
        catch (IOException paramCMSTypedData)
        {
          throw new CMSException("exception decoding algorithm parameters.", paramCMSTypedData);
        }
        try
        {
          localObject1 = new ByteArrayOutputStream();
          localObject3 = new TeeOutputStream((OutputStream)localObject1, paramMacCalculator.getOutputStream());
          paramCMSTypedData.write((OutputStream)localObject3);
          ((OutputStream)localObject3).close();
          localObject3 = new BEROctetString(((ByteArrayOutputStream)localObject1).toByteArray());
          localObject1 = new DEROctetString(paramMacCalculator.getMac());
          paramCMSTypedData = (CMSTypedData)localObject2;
          if (this.unauthGen != null) {
            paramCMSTypedData = new BERSet(this.unauthGen.getAttributes(new HashMap()).toASN1EncodableVector());
          }
          localObject2 = new ContentInfo(CMSObjectIdentifiers.data, (ASN1Encodable)localObject3);
          paramCMSTypedData = new AuthenticatedData(this.originatorInfo, new DERSet(localASN1EncodableVector), paramMacCalculator.getAlgorithmIdentifier(), null, (ContentInfo)localObject2, null, (ASN1OctetString)localObject1, paramCMSTypedData);
          new CMSAuthenticatedData(new ContentInfo(CMSObjectIdentifiers.authenticatedData, paramCMSTypedData), new DigestCalculatorProvider()
          {
            public DigestCalculator get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
              throws OperatorCreationException
            {
              return paramDigestCalculator;
            }
          });
        }
        catch (IOException paramCMSTypedData)
        {
          throw new CMSException("exception decoding algorithm parameters.", paramCMSTypedData);
        }
      }
      catch (IOException paramCMSTypedData)
      {
        paramMacCalculator = new StringBuilder();
        paramMacCalculator.append("unable to perform digest calculation: ");
        paramMacCalculator.append(paramCMSTypedData.getMessage());
        throw new CMSException(paramMacCalculator.toString(), paramCMSTypedData);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSAuthenticatedDataGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */