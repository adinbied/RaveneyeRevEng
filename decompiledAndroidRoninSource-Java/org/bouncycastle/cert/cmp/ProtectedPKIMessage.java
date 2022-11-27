package org.bouncycastle.cert.cmp;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cmp.CMPCertificate;
import org.bouncycastle.asn1.cmp.CMPObjectIdentifiers;
import org.bouncycastle.asn1.cmp.PBMParameter;
import org.bouncycastle.asn1.cmp.PKIBody;
import org.bouncycastle.asn1.cmp.PKIHeader;
import org.bouncycastle.asn1.cmp.PKIMessage;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.crmf.PKMACBuilder;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.util.Arrays;

public class ProtectedPKIMessage
{
  private PKIMessage pkiMessage;
  
  ProtectedPKIMessage(PKIMessage paramPKIMessage)
  {
    if (paramPKIMessage.getHeader().getProtectionAlg() != null)
    {
      this.pkiMessage = paramPKIMessage;
      return;
    }
    throw new IllegalArgumentException("PKIMessage not protected");
  }
  
  public ProtectedPKIMessage(GeneralPKIMessage paramGeneralPKIMessage)
  {
    if (paramGeneralPKIMessage.hasProtection())
    {
      this.pkiMessage = paramGeneralPKIMessage.toASN1Structure();
      return;
    }
    throw new IllegalArgumentException("PKIMessage not protected");
  }
  
  private boolean verifySignature(byte[] paramArrayOfByte, ContentVerifier paramContentVerifier)
    throws IOException
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.pkiMessage.getHeader());
    localASN1EncodableVector.add(this.pkiMessage.getBody());
    OutputStream localOutputStream = paramContentVerifier.getOutputStream();
    localOutputStream.write(new DERSequence(localASN1EncodableVector).getEncoded("DER"));
    localOutputStream.close();
    return paramContentVerifier.verify(paramArrayOfByte);
  }
  
  public PKIBody getBody()
  {
    return this.pkiMessage.getBody();
  }
  
  public X509CertificateHolder[] getCertificates()
  {
    CMPCertificate[] arrayOfCMPCertificate = this.pkiMessage.getExtraCerts();
    int i = 0;
    if (arrayOfCMPCertificate == null) {
      return new X509CertificateHolder[0];
    }
    X509CertificateHolder[] arrayOfX509CertificateHolder = new X509CertificateHolder[arrayOfCMPCertificate.length];
    while (i != arrayOfCMPCertificate.length)
    {
      arrayOfX509CertificateHolder[i] = new X509CertificateHolder(arrayOfCMPCertificate[i].getX509v3PKCert());
      i += 1;
    }
    return arrayOfX509CertificateHolder;
  }
  
  public PKIHeader getHeader()
  {
    return this.pkiMessage.getHeader();
  }
  
  public boolean hasPasswordBasedMacProtection()
  {
    return this.pkiMessage.getHeader().getProtectionAlg().getAlgorithm().equals(CMPObjectIdentifiers.passwordBasedMac);
  }
  
  public PKIMessage toASN1Structure()
  {
    return this.pkiMessage;
  }
  
  public boolean verify(PKMACBuilder paramPKMACBuilder, char[] paramArrayOfChar)
    throws CMPException
  {
    if (CMPObjectIdentifiers.passwordBasedMac.equals(this.pkiMessage.getHeader().getProtectionAlg().getAlgorithm())) {
      try
      {
        paramPKMACBuilder.setParameters(PBMParameter.getInstance(this.pkiMessage.getHeader().getProtectionAlg().getParameters()));
        paramPKMACBuilder = paramPKMACBuilder.build(paramArrayOfChar);
        paramArrayOfChar = paramPKMACBuilder.getOutputStream();
        ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
        localASN1EncodableVector.add(this.pkiMessage.getHeader());
        localASN1EncodableVector.add(this.pkiMessage.getBody());
        paramArrayOfChar.write(new DERSequence(localASN1EncodableVector).getEncoded("DER"));
        paramArrayOfChar.close();
        boolean bool = Arrays.areEqual(paramPKMACBuilder.getMac(), this.pkiMessage.getProtection().getBytes());
        return bool;
      }
      catch (Exception paramPKMACBuilder)
      {
        paramArrayOfChar = new StringBuilder();
        paramArrayOfChar.append("unable to verify MAC: ");
        paramArrayOfChar.append(paramPKMACBuilder.getMessage());
        throw new CMPException(paramArrayOfChar.toString(), paramPKMACBuilder);
      }
    }
    throw new CMPException("protection algorithm not mac based");
  }
  
  public boolean verify(ContentVerifierProvider paramContentVerifierProvider)
    throws CMPException
  {
    try
    {
      paramContentVerifierProvider = paramContentVerifierProvider.get(this.pkiMessage.getHeader().getProtectionAlg());
      boolean bool = verifySignature(this.pkiMessage.getProtection().getBytes(), paramContentVerifierProvider);
      return bool;
    }
    catch (Exception paramContentVerifierProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to verify signature: ");
      localStringBuilder.append(paramContentVerifierProvider.getMessage());
      throw new CMPException(localStringBuilder.toString(), paramContentVerifierProvider);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\cmp\ProtectedPKIMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */