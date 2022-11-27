package org.bouncycastle.cert.cmp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cmp.CertConfirmContent;
import org.bouncycastle.asn1.cmp.CertStatus;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;

public class CertificateConfirmationContentBuilder
{
  private List acceptedCerts = new ArrayList();
  private List acceptedReqIds = new ArrayList();
  private DigestAlgorithmIdentifierFinder digestAlgFinder;
  
  public CertificateConfirmationContentBuilder()
  {
    this(new DefaultDigestAlgorithmIdentifierFinder());
  }
  
  public CertificateConfirmationContentBuilder(DigestAlgorithmIdentifierFinder paramDigestAlgorithmIdentifierFinder)
  {
    this.digestAlgFinder = paramDigestAlgorithmIdentifierFinder;
  }
  
  public CertificateConfirmationContentBuilder addAcceptedCertificate(X509CertificateHolder paramX509CertificateHolder, BigInteger paramBigInteger)
  {
    this.acceptedCerts.add(paramX509CertificateHolder);
    this.acceptedReqIds.add(paramBigInteger);
    return this;
  }
  
  public CertificateConfirmationContent build(DigestCalculatorProvider paramDigestCalculatorProvider)
    throws CMPException
  {
    Object localObject1 = new ASN1EncodableVector();
    int i = 0;
    for (;;)
    {
      if (i == this.acceptedCerts.size()) {
        break label177;
      }
      X509CertificateHolder localX509CertificateHolder = (X509CertificateHolder)this.acceptedCerts.get(i);
      BigInteger localBigInteger = (BigInteger)this.acceptedReqIds.get(i);
      Object localObject2 = this.digestAlgFinder.find(localX509CertificateHolder.toASN1Structure().getSignatureAlgorithm());
      if (localObject2 != null) {
        try
        {
          localObject2 = paramDigestCalculatorProvider.get((AlgorithmIdentifier)localObject2);
          CMPUtil.derEncodeToStream(localX509CertificateHolder.toASN1Structure(), ((DigestCalculator)localObject2).getOutputStream());
          ((ASN1EncodableVector)localObject1).add(new CertStatus(((DigestCalculator)localObject2).getDigest(), localBigInteger));
          i += 1;
        }
        catch (OperatorCreationException paramDigestCalculatorProvider)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("unable to create digest: ");
          ((StringBuilder)localObject1).append(paramDigestCalculatorProvider.getMessage());
          throw new CMPException(((StringBuilder)localObject1).toString(), paramDigestCalculatorProvider);
        }
      }
    }
    throw new CMPException("cannot find algorithm for digest from signature");
    label177:
    return new CertificateConfirmationContent(CertConfirmContent.getInstance(new DERSequence((ASN1EncodableVector)localObject1)), this.digestAlgFinder);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\cmp\CertificateConfirmationContentBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */