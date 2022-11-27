package org.bouncycastle.cms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.SignedData;
import org.bouncycastle.asn1.cms.SignerInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CMSSignedDataGenerator
  extends CMSSignedGenerator
{
  private List signerInfs = new ArrayList();
  
  public CMSSignedData generate(CMSTypedData paramCMSTypedData)
    throws CMSException
  {
    return generate(paramCMSTypedData, false);
  }
  
  public CMSSignedData generate(CMSTypedData paramCMSTypedData, boolean paramBoolean)
    throws CMSException
  {
    if (this.signerInfs.isEmpty())
    {
      ASN1EncodableVector localASN1EncodableVector1 = new ASN1EncodableVector();
      ASN1EncodableVector localASN1EncodableVector2 = new ASN1EncodableVector();
      this.digests.clear();
      Object localObject1 = this._signers.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SignerInformation)((Iterator)localObject1).next();
        localASN1EncodableVector1.add(CMSSignedHelper.INSTANCE.fixAlgID(((SignerInformation)localObject2).getDigestAlgorithmID()));
        localASN1EncodableVector2.add(((SignerInformation)localObject2).toASN1Structure());
      }
      ASN1ObjectIdentifier localASN1ObjectIdentifier = paramCMSTypedData.getContentType();
      localObject1 = paramCMSTypedData.getContent();
      ASN1Set localASN1Set = null;
      if (localObject1 != null)
      {
        if (paramBoolean) {
          localObject1 = new ByteArrayOutputStream();
        } else {
          localObject1 = null;
        }
        localObject2 = CMSUtils.getSafeOutputStream(CMSUtils.attachSignersToOutputStream(this.signerGens, (OutputStream)localObject1));
        try
        {
          paramCMSTypedData.write((OutputStream)localObject2);
          ((OutputStream)localObject2).close();
          if (paramBoolean) {
            localObject1 = new BEROctetString(((ByteArrayOutputStream)localObject1).toByteArray());
          }
        }
        catch (IOException paramCMSTypedData)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("data processing exception: ");
          ((StringBuilder)localObject1).append(paramCMSTypedData.getMessage());
          throw new CMSException(((StringBuilder)localObject1).toString(), paramCMSTypedData);
        }
      }
      localObject1 = null;
      Object localObject2 = this.signerGens.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (SignerInfoGenerator)((Iterator)localObject2).next();
        SignerInfo localSignerInfo = ((SignerInfoGenerator)localObject3).generate(localASN1ObjectIdentifier);
        localASN1EncodableVector1.add(localSignerInfo.getDigestAlgorithm());
        localASN1EncodableVector2.add(localSignerInfo);
        localObject3 = ((SignerInfoGenerator)localObject3).getCalculatedDigest();
        if (localObject3 != null) {
          this.digests.put(localSignerInfo.getDigestAlgorithm().getAlgorithm().getId(), localObject3);
        }
      }
      if (this.certs.size() != 0) {
        localObject2 = CMSUtils.createBerSetFromList(this.certs);
      } else {
        localObject2 = null;
      }
      if (this.crls.size() != 0) {
        localASN1Set = CMSUtils.createBerSetFromList(this.crls);
      }
      localObject1 = new ContentInfo(localASN1ObjectIdentifier, (ASN1Encodable)localObject1);
      localObject1 = new SignedData(new DERSet(localASN1EncodableVector1), (ContentInfo)localObject1, (ASN1Set)localObject2, localASN1Set, new DERSet(localASN1EncodableVector2));
      return new CMSSignedData(paramCMSTypedData, new ContentInfo(CMSObjectIdentifiers.signedData, (ASN1Encodable)localObject1));
    }
    throw new IllegalStateException("this method can only be used with SignerInfoGenerator");
  }
  
  public SignerInformationStore generateCounterSigners(SignerInformation paramSignerInformation)
    throws CMSException
  {
    return generate(new CMSProcessableByteArray(null, paramSignerInformation.getSignature()), false).getSignerInfos();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSSignedDataGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */