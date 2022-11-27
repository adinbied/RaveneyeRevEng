package org.bouncycastle.tsp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.ess.ESSCertID;
import org.bouncycastle.asn1.ess.ESSCertIDv2;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.tsp.TSTInfo;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.IssuerSerial;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessable;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerId;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.cms.SignerInformationVerifier;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Store;

public class TimeStampToken
{
  CertID certID;
  Date genTime;
  CMSSignedData tsToken;
  SignerInformation tsaSignerInfo;
  TimeStampTokenInfo tstInfo;
  
  public TimeStampToken(ContentInfo paramContentInfo)
    throws TSPException, IOException
  {
    this(getSignedData(paramContentInfo));
  }
  
  public TimeStampToken(CMSSignedData paramCMSSignedData)
    throws TSPException, IOException
  {
    this.tsToken = paramCMSSignedData;
    if (paramCMSSignedData.getSignedContentTypeOID().equals(PKCSObjectIdentifiers.id_ct_TSTInfo.getId()))
    {
      paramCMSSignedData = this.tsToken.getSignerInfos().getSigners();
      if (paramCMSSignedData.size() == 1)
      {
        this.tsaSignerInfo = ((SignerInformation)paramCMSSignedData.iterator().next());
        try
        {
          paramCMSSignedData = this.tsToken.getSignedContent();
          localObject = new ByteArrayOutputStream();
          paramCMSSignedData.write((OutputStream)localObject);
          this.tstInfo = new TimeStampTokenInfo(TSTInfo.getInstance(new ASN1InputStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject).toByteArray())).readObject()));
          paramCMSSignedData = this.tsaSignerInfo.getSignedAttributes().get(PKCSObjectIdentifiers.id_aa_signingCertificate);
          if (paramCMSSignedData != null) {}
          for (paramCMSSignedData = new CertID(ESSCertID.getInstance(org.bouncycastle.asn1.ess.SigningCertificate.getInstance(paramCMSSignedData.getAttrValues().getObjectAt(0)).getCerts()[0]));; paramCMSSignedData = new CertID(ESSCertIDv2.getInstance(org.bouncycastle.asn1.ess.SigningCertificateV2.getInstance(paramCMSSignedData.getAttrValues().getObjectAt(0)).getCerts()[0])))
          {
            this.certID = paramCMSSignedData;
            return;
            paramCMSSignedData = this.tsaSignerInfo.getSignedAttributes().get(PKCSObjectIdentifiers.id_aa_signingCertificateV2);
            if (paramCMSSignedData == null) {
              break;
            }
          }
          throw new TSPValidationException("no signing certificate attribute found, time stamp invalid.");
        }
        catch (CMSException paramCMSSignedData)
        {
          throw new TSPException(paramCMSSignedData.getMessage(), paramCMSSignedData.getUnderlyingException());
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Time-stamp token signed by ");
      ((StringBuilder)localObject).append(paramCMSSignedData.size());
      ((StringBuilder)localObject).append(" signers, but it must contain just the TSA signature.");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new TSPValidationException("ContentInfo object not for a time stamp.");
  }
  
  private static CMSSignedData getSignedData(ContentInfo paramContentInfo)
    throws TSPException
  {
    try
    {
      paramContentInfo = new CMSSignedData(paramContentInfo);
      return paramContentInfo;
    }
    catch (CMSException paramContentInfo)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TSP parsing error: ");
      localStringBuilder.append(paramContentInfo.getMessage());
      throw new TSPException(localStringBuilder.toString(), paramContentInfo.getCause());
    }
  }
  
  public Store getAttributeCertificates()
  {
    return this.tsToken.getAttributeCertificates();
  }
  
  public Store getCRLs()
  {
    return this.tsToken.getCRLs();
  }
  
  public Store getCertificates()
  {
    return this.tsToken.getCertificates();
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.tsToken.getEncoded();
  }
  
  public SignerId getSID()
  {
    return this.tsaSignerInfo.getSID();
  }
  
  public AttributeTable getSignedAttributes()
  {
    return this.tsaSignerInfo.getSignedAttributes();
  }
  
  public TimeStampTokenInfo getTimeStampInfo()
  {
    return this.tstInfo;
  }
  
  public AttributeTable getUnsignedAttributes()
  {
    return this.tsaSignerInfo.getUnsignedAttributes();
  }
  
  public boolean isSignatureValid(SignerInformationVerifier paramSignerInformationVerifier)
    throws TSPException
  {
    try
    {
      boolean bool = this.tsaSignerInfo.verify(paramSignerInformationVerifier);
      return bool;
    }
    catch (CMSException paramSignerInformationVerifier)
    {
      if (paramSignerInformationVerifier.getUnderlyingException() != null) {
        throw new TSPException(paramSignerInformationVerifier.getMessage(), paramSignerInformationVerifier.getUnderlyingException());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CMS exception: ");
      localStringBuilder.append(paramSignerInformationVerifier);
      throw new TSPException(localStringBuilder.toString(), paramSignerInformationVerifier);
    }
  }
  
  public CMSSignedData toCMSSignedData()
  {
    return this.tsToken;
  }
  
  public void validate(SignerInformationVerifier paramSignerInformationVerifier)
    throws TSPException, TSPValidationException
  {
    if (paramSignerInformationVerifier.hasAssociatedCertificate()) {}
    for (;;)
    {
      int i;
      int j;
      try
      {
        localObject1 = paramSignerInformationVerifier.getAssociatedCertificate();
        Object localObject2 = paramSignerInformationVerifier.getDigestCalculator(this.certID.getHashAlgorithm());
        Object localObject3 = ((DigestCalculator)localObject2).getOutputStream();
        ((OutputStream)localObject3).write(((X509CertificateHolder)localObject1).getEncoded());
        ((OutputStream)localObject3).close();
        if (Arrays.constantTimeAreEqual(this.certID.getCertHash(), ((DigestCalculator)localObject2).getDigest()))
        {
          if (this.certID.getIssuerSerial() != null)
          {
            localObject2 = new IssuerAndSerialNumber(((X509CertificateHolder)localObject1).toASN1Structure());
            if (this.certID.getIssuerSerial().getSerial().equals(((IssuerAndSerialNumber)localObject2).getSerialNumber()))
            {
              localObject3 = this.certID.getIssuerSerial().getIssuer().getNames();
              int k = 0;
              i = 0;
              j = k;
              if (i == localObject3.length) {
                break label436;
              }
              if ((localObject3[i].getTagNo() != 4) || (!X500Name.getInstance(localObject3[i].getName()).equals(X500Name.getInstance(((IssuerAndSerialNumber)localObject2).getName())))) {
                break label429;
              }
              j = 1;
              break label436;
              throw new TSPValidationException("certificate name does not match certID for signature. ");
            }
            throw new TSPValidationException("certificate serial number does not match certID for signature.");
          }
          TSPUtil.validateCertificate((X509CertificateHolder)localObject1);
          if (((X509CertificateHolder)localObject1).isValidOn(this.tstInfo.getGenTime()))
          {
            if (this.tsaSignerInfo.verify(paramSignerInformationVerifier)) {
              return;
            }
            throw new TSPValidationException("signature not created by certificate.");
          }
          throw new TSPValidationException("certificate not valid when time stamp created.");
        }
        throw new TSPValidationException("certificate hash does not match certID hash.");
      }
      catch (OperatorCreationException paramSignerInformationVerifier)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("unable to create digest: ");
        ((StringBuilder)localObject1).append(paramSignerInformationVerifier.getMessage());
        throw new TSPException(((StringBuilder)localObject1).toString(), paramSignerInformationVerifier);
      }
      catch (IOException paramSignerInformationVerifier)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("problem processing certificate: ");
        ((StringBuilder)localObject1).append(paramSignerInformationVerifier);
        throw new TSPException(((StringBuilder)localObject1).toString(), paramSignerInformationVerifier);
      }
      catch (CMSException paramSignerInformationVerifier)
      {
        if (paramSignerInformationVerifier.getUnderlyingException() != null) {
          throw new TSPException(paramSignerInformationVerifier.getMessage(), paramSignerInformationVerifier.getUnderlyingException());
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("CMS exception: ");
        ((StringBuilder)localObject1).append(paramSignerInformationVerifier);
        throw new TSPException(((StringBuilder)localObject1).toString(), paramSignerInformationVerifier);
      }
      throw new IllegalArgumentException("verifier provider needs an associated certificate");
      label429:
      i += 1;
      continue;
      label436:
      if (j == 0) {}
    }
  }
  
  private class CertID
  {
    private ESSCertID certID;
    private ESSCertIDv2 certIDv2;
    
    CertID(ESSCertID paramESSCertID)
    {
      this.certID = paramESSCertID;
      this.certIDv2 = null;
    }
    
    CertID(ESSCertIDv2 paramESSCertIDv2)
    {
      this.certIDv2 = paramESSCertIDv2;
      this.certID = null;
    }
    
    public byte[] getCertHash()
    {
      ESSCertID localESSCertID = this.certID;
      if (localESSCertID != null) {
        return localESSCertID.getCertHash();
      }
      return this.certIDv2.getCertHash();
    }
    
    public AlgorithmIdentifier getHashAlgorithm()
    {
      if (this.certID != null) {
        return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1);
      }
      return this.certIDv2.getHashAlgorithm();
    }
    
    public String getHashAlgorithmName()
    {
      if (this.certID != null) {
        return "SHA-1";
      }
      if (NISTObjectIdentifiers.id_sha256.equals(this.certIDv2.getHashAlgorithm().getAlgorithm())) {
        return "SHA-256";
      }
      return this.certIDv2.getHashAlgorithm().getAlgorithm().getId();
    }
    
    public IssuerSerial getIssuerSerial()
    {
      ESSCertID localESSCertID = this.certID;
      if (localESSCertID != null) {
        return localESSCertID.getIssuerSerial();
      }
      return this.certIDv2.getIssuerSerial();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\TimeStampToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */