package org.bouncycastle.cert.cmp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.cmp.CertStatus;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Arrays;

public class CertificateStatus
{
  private CertStatus certStatus;
  private DigestAlgorithmIdentifierFinder digestAlgFinder;
  
  CertificateStatus(DigestAlgorithmIdentifierFinder paramDigestAlgorithmIdentifierFinder, CertStatus paramCertStatus)
  {
    this.digestAlgFinder = paramDigestAlgorithmIdentifierFinder;
    this.certStatus = paramCertStatus;
  }
  
  public BigInteger getCertRequestID()
  {
    return this.certStatus.getCertReqId().getValue();
  }
  
  public PKIStatusInfo getStatusInfo()
  {
    return this.certStatus.getStatusInfo();
  }
  
  public boolean isVerified(X509CertificateHolder paramX509CertificateHolder, DigestCalculatorProvider paramDigestCalculatorProvider)
    throws CMPException
  {
    AlgorithmIdentifier localAlgorithmIdentifier = this.digestAlgFinder.find(paramX509CertificateHolder.toASN1Structure().getSignatureAlgorithm());
    if (localAlgorithmIdentifier != null) {
      try
      {
        paramDigestCalculatorProvider = paramDigestCalculatorProvider.get(localAlgorithmIdentifier);
        CMPUtil.derEncodeToStream(paramX509CertificateHolder.toASN1Structure(), paramDigestCalculatorProvider.getOutputStream());
        return Arrays.areEqual(this.certStatus.getCertHash().getOctets(), paramDigestCalculatorProvider.getDigest());
      }
      catch (OperatorCreationException paramX509CertificateHolder)
      {
        paramDigestCalculatorProvider = new StringBuilder();
        paramDigestCalculatorProvider.append("unable to create digester: ");
        paramDigestCalculatorProvider.append(paramX509CertificateHolder.getMessage());
        throw new CMPException(paramDigestCalculatorProvider.toString(), paramX509CertificateHolder);
      }
    }
    throw new CMPException("cannot find algorithm for digest from signature");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\cmp\CertificateStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */