package org.bouncycastle.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cms.KeyAgreeRecipientInfo;
import org.bouncycastle.asn1.cms.OriginatorIdentifierOrKey;
import org.bouncycastle.asn1.cms.OriginatorPublicKey;
import org.bouncycastle.asn1.cms.RecipientInfo;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.operator.GenericKey;

public abstract class KeyAgreeRecipientInfoGenerator
  implements RecipientInfoGenerator
{
  private ASN1ObjectIdentifier keyAgreementOID;
  private ASN1ObjectIdentifier keyEncryptionOID;
  private SubjectPublicKeyInfo originatorKeyInfo;
  
  protected KeyAgreeRecipientInfoGenerator(ASN1ObjectIdentifier paramASN1ObjectIdentifier1, SubjectPublicKeyInfo paramSubjectPublicKeyInfo, ASN1ObjectIdentifier paramASN1ObjectIdentifier2)
  {
    this.originatorKeyInfo = paramSubjectPublicKeyInfo;
    this.keyAgreementOID = paramASN1ObjectIdentifier1;
    this.keyEncryptionOID = paramASN1ObjectIdentifier2;
  }
  
  protected OriginatorPublicKey createOriginatorPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    return new OriginatorPublicKey(new AlgorithmIdentifier(paramSubjectPublicKeyInfo.getAlgorithm().getAlgorithm(), DERNull.INSTANCE), paramSubjectPublicKeyInfo.getPublicKeyData().getBytes());
  }
  
  public RecipientInfo generate(GenericKey paramGenericKey)
    throws CMSException
  {
    OriginatorIdentifierOrKey localOriginatorIdentifierOrKey = new OriginatorIdentifierOrKey(createOriginatorPublicKey(this.originatorKeyInfo));
    if ((!CMSUtils.isDES(this.keyEncryptionOID.getId())) && (!this.keyEncryptionOID.equals(PKCSObjectIdentifiers.id_alg_CMSRC2wrap))) {
      localObject = new AlgorithmIdentifier(this.keyEncryptionOID);
    } else {
      localObject = new AlgorithmIdentifier(this.keyEncryptionOID, DERNull.INSTANCE);
    }
    AlgorithmIdentifier localAlgorithmIdentifier = new AlgorithmIdentifier(this.keyAgreementOID, (ASN1Encodable)localObject);
    paramGenericKey = generateRecipientEncryptedKeys(localAlgorithmIdentifier, (AlgorithmIdentifier)localObject, paramGenericKey);
    Object localObject = getUserKeyingMaterial(localAlgorithmIdentifier);
    if (localObject != null) {
      return new RecipientInfo(new KeyAgreeRecipientInfo(localOriginatorIdentifierOrKey, new DEROctetString((byte[])localObject), localAlgorithmIdentifier, paramGenericKey));
    }
    return new RecipientInfo(new KeyAgreeRecipientInfo(localOriginatorIdentifierOrKey, null, localAlgorithmIdentifier, paramGenericKey));
  }
  
  protected abstract ASN1Sequence generateRecipientEncryptedKeys(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, GenericKey paramGenericKey)
    throws CMSException;
  
  protected abstract byte[] getUserKeyingMaterial(AlgorithmIdentifier paramAlgorithmIdentifier)
    throws CMSException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\KeyAgreeRecipientInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */