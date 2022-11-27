package org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class PBES2Parameters
  extends ASN1Object
  implements PKCSObjectIdentifiers
{
  private KeyDerivationFunc func;
  private EncryptionScheme scheme;
  
  private PBES2Parameters(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    ASN1Sequence localASN1Sequence = ASN1Sequence.getInstance(((ASN1Encodable)paramASN1Sequence.nextElement()).toASN1Primitive());
    if (localASN1Sequence.getObjectAt(0).equals(id_PBKDF2)) {
      this.func = new KeyDerivationFunc(id_PBKDF2, PBKDF2Params.getInstance(localASN1Sequence.getObjectAt(1)));
    } else {
      this.func = KeyDerivationFunc.getInstance(localASN1Sequence);
    }
    this.scheme = EncryptionScheme.getInstance(paramASN1Sequence.nextElement());
  }
  
  public PBES2Parameters(KeyDerivationFunc paramKeyDerivationFunc, EncryptionScheme paramEncryptionScheme)
  {
    this.func = paramKeyDerivationFunc;
    this.scheme = paramEncryptionScheme;
  }
  
  public static PBES2Parameters getInstance(Object paramObject)
  {
    if ((paramObject instanceof PBES2Parameters)) {
      return (PBES2Parameters)paramObject;
    }
    if (paramObject != null) {
      return new PBES2Parameters(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public EncryptionScheme getEncryptionScheme()
  {
    return this.scheme;
  }
  
  public KeyDerivationFunc getKeyDerivationFunc()
  {
    return this.func;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.func);
    localASN1EncodableVector.add(this.scheme);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\PBES2Parameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */