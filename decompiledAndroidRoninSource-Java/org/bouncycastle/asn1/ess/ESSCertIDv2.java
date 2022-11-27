package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.IssuerSerial;
import org.bouncycastle.util.Arrays;

public class ESSCertIDv2
  extends ASN1Object
{
  private static final AlgorithmIdentifier DEFAULT_ALG_ID = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
  private byte[] certHash;
  private AlgorithmIdentifier hashAlgorithm;
  private IssuerSerial issuerSerial;
  
  private ESSCertIDv2(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() <= 3)
    {
      int i = 0;
      if ((paramASN1Sequence.getObjectAt(0) instanceof ASN1OctetString))
      {
        this.hashAlgorithm = DEFAULT_ALG_ID;
      }
      else
      {
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0).toASN1Primitive());
        i = 1;
      }
      int j = i + 1;
      this.certHash = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(i).toASN1Primitive()).getOctets();
      if (paramASN1Sequence.size() > j) {
        this.issuerSerial = IssuerSerial.getInstance(paramASN1Sequence.getObjectAt(j));
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public ESSCertIDv2(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    this(paramAlgorithmIdentifier, paramArrayOfByte, null);
  }
  
  public ESSCertIDv2(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte, IssuerSerial paramIssuerSerial)
  {
    AlgorithmIdentifier localAlgorithmIdentifier = paramAlgorithmIdentifier;
    if (paramAlgorithmIdentifier == null) {
      localAlgorithmIdentifier = DEFAULT_ALG_ID;
    }
    this.hashAlgorithm = localAlgorithmIdentifier;
    this.certHash = Arrays.clone(paramArrayOfByte);
    this.issuerSerial = paramIssuerSerial;
  }
  
  public ESSCertIDv2(byte[] paramArrayOfByte)
  {
    this(null, paramArrayOfByte, null);
  }
  
  public ESSCertIDv2(byte[] paramArrayOfByte, IssuerSerial paramIssuerSerial)
  {
    this(null, paramArrayOfByte, paramIssuerSerial);
  }
  
  public static ESSCertIDv2 getInstance(Object paramObject)
  {
    if ((paramObject instanceof ESSCertIDv2)) {
      return (ESSCertIDv2)paramObject;
    }
    if (paramObject != null) {
      return new ESSCertIDv2(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public byte[] getCertHash()
  {
    return Arrays.clone(this.certHash);
  }
  
  public AlgorithmIdentifier getHashAlgorithm()
  {
    return this.hashAlgorithm;
  }
  
  public IssuerSerial getIssuerSerial()
  {
    return this.issuerSerial;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    if (!this.hashAlgorithm.equals(DEFAULT_ALG_ID)) {
      localASN1EncodableVector.add(this.hashAlgorithm);
    }
    localASN1EncodableVector.add(new DEROctetString(this.certHash).toASN1Primitive());
    IssuerSerial localIssuerSerial = this.issuerSerial;
    if (localIssuerSerial != null) {
      localASN1EncodableVector.add(localIssuerSerial);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ess\ESSCertIDv2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */