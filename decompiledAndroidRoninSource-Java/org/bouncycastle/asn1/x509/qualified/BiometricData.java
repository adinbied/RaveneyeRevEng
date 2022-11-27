package org.bouncycastle.asn1.x509.qualified;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class BiometricData
  extends ASN1Object
{
  private ASN1OctetString biometricDataHash;
  private AlgorithmIdentifier hashAlgorithm;
  private DERIA5String sourceDataUri;
  private TypeOfBiometricData typeOfBiometricData;
  
  private BiometricData(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.typeOfBiometricData = TypeOfBiometricData.getInstance(paramASN1Sequence.nextElement());
    this.hashAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.nextElement());
    this.biometricDataHash = ASN1OctetString.getInstance(paramASN1Sequence.nextElement());
    if (paramASN1Sequence.hasMoreElements()) {
      this.sourceDataUri = DERIA5String.getInstance(paramASN1Sequence.nextElement());
    }
  }
  
  public BiometricData(TypeOfBiometricData paramTypeOfBiometricData, AlgorithmIdentifier paramAlgorithmIdentifier, ASN1OctetString paramASN1OctetString)
  {
    this.typeOfBiometricData = paramTypeOfBiometricData;
    this.hashAlgorithm = paramAlgorithmIdentifier;
    this.biometricDataHash = paramASN1OctetString;
    this.sourceDataUri = null;
  }
  
  public BiometricData(TypeOfBiometricData paramTypeOfBiometricData, AlgorithmIdentifier paramAlgorithmIdentifier, ASN1OctetString paramASN1OctetString, DERIA5String paramDERIA5String)
  {
    this.typeOfBiometricData = paramTypeOfBiometricData;
    this.hashAlgorithm = paramAlgorithmIdentifier;
    this.biometricDataHash = paramASN1OctetString;
    this.sourceDataUri = paramDERIA5String;
  }
  
  public static BiometricData getInstance(Object paramObject)
  {
    if ((paramObject instanceof BiometricData)) {
      return (BiometricData)paramObject;
    }
    if (paramObject != null) {
      return new BiometricData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1OctetString getBiometricDataHash()
  {
    return this.biometricDataHash;
  }
  
  public AlgorithmIdentifier getHashAlgorithm()
  {
    return this.hashAlgorithm;
  }
  
  public DERIA5String getSourceDataUri()
  {
    return this.sourceDataUri;
  }
  
  public TypeOfBiometricData getTypeOfBiometricData()
  {
    return this.typeOfBiometricData;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.typeOfBiometricData);
    localASN1EncodableVector.add(this.hashAlgorithm);
    localASN1EncodableVector.add(this.biometricDataHash);
    DERIA5String localDERIA5String = this.sourceDataUri;
    if (localDERIA5String != null) {
      localASN1EncodableVector.add(localDERIA5String);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\qualified\BiometricData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */