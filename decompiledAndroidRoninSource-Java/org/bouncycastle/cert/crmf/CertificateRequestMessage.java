package org.bouncycastle.cert.crmf;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.crmf.AttributeTypeAndValue;
import org.bouncycastle.asn1.crmf.CRMFObjectIdentifiers;
import org.bouncycastle.asn1.crmf.CertReqMsg;
import org.bouncycastle.asn1.crmf.CertRequest;
import org.bouncycastle.asn1.crmf.CertTemplate;
import org.bouncycastle.asn1.crmf.Controls;
import org.bouncycastle.asn1.crmf.PKIArchiveOptions;
import org.bouncycastle.asn1.crmf.PKMACValue;
import org.bouncycastle.asn1.crmf.POPOSigningKey;
import org.bouncycastle.asn1.crmf.POPOSigningKeyInput;
import org.bouncycastle.asn1.crmf.ProofOfPossession;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Encodable;

public class CertificateRequestMessage
  implements Encodable
{
  public static final int popKeyAgreement = 3;
  public static final int popKeyEncipherment = 2;
  public static final int popRaVerified = 0;
  public static final int popSigningKey = 1;
  private final CertReqMsg certReqMsg;
  private final Controls controls;
  
  public CertificateRequestMessage(CertReqMsg paramCertReqMsg)
  {
    this.certReqMsg = paramCertReqMsg;
    this.controls = paramCertReqMsg.getCertReq().getControls();
  }
  
  public CertificateRequestMessage(byte[] paramArrayOfByte)
    throws IOException
  {
    this(parseBytes(paramArrayOfByte));
  }
  
  private AttributeTypeAndValue findControl(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Object localObject = this.controls;
    if (localObject == null) {
      return null;
    }
    localObject = ((Controls)localObject).toAttributeTypeAndValueArray();
    int i = 0;
    while (i != localObject.length)
    {
      if (localObject[i].getType().equals(paramASN1ObjectIdentifier)) {
        return localObject[i];
      }
      i += 1;
    }
    return null;
  }
  
  private static CertReqMsg parseBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = CertReqMsg.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
    catch (ClassCastException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
  }
  
  private boolean verifySignature(ContentVerifierProvider paramContentVerifierProvider, POPOSigningKey paramPOPOSigningKey)
    throws CRMFException
  {
    try
    {
      ContentVerifier localContentVerifier = paramContentVerifierProvider.get(paramPOPOSigningKey.getAlgorithmIdentifier());
      if (paramPOPOSigningKey.getPoposkInput() != null) {
        paramContentVerifierProvider = paramPOPOSigningKey.getPoposkInput();
      } else {
        paramContentVerifierProvider = this.certReqMsg.getCertReq();
      }
      CRMFUtil.derEncodeToStream(paramContentVerifierProvider, localContentVerifier.getOutputStream());
      return localContentVerifier.verify(paramPOPOSigningKey.getSignature().getOctets());
    }
    catch (OperatorCreationException paramContentVerifierProvider)
    {
      paramPOPOSigningKey = new StringBuilder();
      paramPOPOSigningKey.append("unable to create verifier: ");
      paramPOPOSigningKey.append(paramContentVerifierProvider.getMessage());
      throw new CRMFException(paramPOPOSigningKey.toString(), paramContentVerifierProvider);
    }
  }
  
  public CertTemplate getCertTemplate()
  {
    return this.certReqMsg.getCertReq().getCertTemplate();
  }
  
  public Control getControl(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    paramASN1ObjectIdentifier = findControl(paramASN1ObjectIdentifier);
    if (paramASN1ObjectIdentifier != null)
    {
      if (paramASN1ObjectIdentifier.getType().equals(CRMFObjectIdentifiers.id_regCtrl_pkiArchiveOptions)) {
        return new PKIArchiveControl(PKIArchiveOptions.getInstance(paramASN1ObjectIdentifier.getValue()));
      }
      if (paramASN1ObjectIdentifier.getType().equals(CRMFObjectIdentifiers.id_regCtrl_regToken)) {
        return new RegTokenControl(DERUTF8String.getInstance(paramASN1ObjectIdentifier.getValue()));
      }
      if (paramASN1ObjectIdentifier.getType().equals(CRMFObjectIdentifiers.id_regCtrl_authenticator)) {
        return new AuthenticatorControl(DERUTF8String.getInstance(paramASN1ObjectIdentifier.getValue()));
      }
    }
    return null;
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.certReqMsg.getEncoded();
  }
  
  public int getProofOfPossessionType()
  {
    return this.certReqMsg.getPopo().getType();
  }
  
  public boolean hasControl(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return findControl(paramASN1ObjectIdentifier) != null;
  }
  
  public boolean hasControls()
  {
    return this.controls != null;
  }
  
  public boolean hasProofOfPossession()
  {
    return this.certReqMsg.getPopo() != null;
  }
  
  public boolean hasSigningKeyProofOfPossessionWithPKMAC()
  {
    ProofOfPossession localProofOfPossession = this.certReqMsg.getPopo();
    int i = localProofOfPossession.getType();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 1)
    {
      bool1 = bool2;
      if (POPOSigningKey.getInstance(localProofOfPossession.getObject()).getPoposkInput().getPublicKeyMAC() != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isValidSigningKeyPOP(ContentVerifierProvider paramContentVerifierProvider)
    throws CRMFException, IllegalStateException
  {
    Object localObject = this.certReqMsg.getPopo();
    if (((ProofOfPossession)localObject).getType() == 1)
    {
      localObject = POPOSigningKey.getInstance(((ProofOfPossession)localObject).getObject());
      if ((((POPOSigningKey)localObject).getPoposkInput() != null) && (((POPOSigningKey)localObject).getPoposkInput().getPublicKeyMAC() != null)) {
        throw new IllegalStateException("verification requires password check");
      }
      return verifySignature(paramContentVerifierProvider, (POPOSigningKey)localObject);
    }
    throw new IllegalStateException("not Signing Key type of proof of possession");
  }
  
  public boolean isValidSigningKeyPOP(ContentVerifierProvider paramContentVerifierProvider, PKMACBuilder paramPKMACBuilder, char[] paramArrayOfChar)
    throws CRMFException, IllegalStateException
  {
    Object localObject = this.certReqMsg.getPopo();
    if (((ProofOfPossession)localObject).getType() == 1)
    {
      localObject = POPOSigningKey.getInstance(((ProofOfPossession)localObject).getObject());
      if ((((POPOSigningKey)localObject).getPoposkInput() != null) && (((POPOSigningKey)localObject).getPoposkInput().getSender() == null))
      {
        PKMACValue localPKMACValue = ((POPOSigningKey)localObject).getPoposkInput().getPublicKeyMAC();
        if (new PKMACValueVerifier(paramPKMACBuilder).isValid(localPKMACValue, paramArrayOfChar, getCertTemplate().getPublicKey())) {
          return verifySignature(paramContentVerifierProvider, (POPOSigningKey)localObject);
        }
        return false;
      }
      throw new IllegalStateException("no PKMAC present in proof of possession");
    }
    throw new IllegalStateException("not Signing Key type of proof of possession");
  }
  
  public CertReqMsg toASN1Structure()
  {
    return this.certReqMsg;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\CertificateRequestMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */