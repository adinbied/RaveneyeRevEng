package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.pkcs.KeyDerivationFunc;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class PbkdMacIntegrityCheck
  extends ASN1Object
{
  private final ASN1OctetString mac;
  private final AlgorithmIdentifier macAlgorithm;
  private final KeyDerivationFunc pbkdAlgorithm;
  
  private PbkdMacIntegrityCheck(ASN1Sequence paramASN1Sequence)
  {
    this.macAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    this.pbkdAlgorithm = KeyDerivationFunc.getInstance(paramASN1Sequence.getObjectAt(1));
    this.mac = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(2));
  }
  
  public PbkdMacIntegrityCheck(AlgorithmIdentifier paramAlgorithmIdentifier, KeyDerivationFunc paramKeyDerivationFunc, byte[] paramArrayOfByte)
  {
    this.macAlgorithm = paramAlgorithmIdentifier;
    this.pbkdAlgorithm = paramKeyDerivationFunc;
    this.mac = new DEROctetString(Arrays.clone(paramArrayOfByte));
  }
  
  public static PbkdMacIntegrityCheck getInstance(Object paramObject)
  {
    if ((paramObject instanceof PbkdMacIntegrityCheck)) {
      return (PbkdMacIntegrityCheck)paramObject;
    }
    if (paramObject != null) {
      return new PbkdMacIntegrityCheck(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public byte[] getMac()
  {
    return Arrays.clone(this.mac.getOctets());
  }
  
  public AlgorithmIdentifier getMacAlgorithm()
  {
    return this.macAlgorithm;
  }
  
  public KeyDerivationFunc getPbkdAlgorithm()
  {
    return this.pbkdAlgorithm;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.macAlgorithm);
    localASN1EncodableVector.add(this.pbkdAlgorithm);
    localASN1EncodableVector.add(this.mac);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\bc\PbkdMacIntegrityCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */