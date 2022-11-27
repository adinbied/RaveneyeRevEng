package org.bouncycastle.asn1.x509;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

public class Extension
  extends ASN1Object
{
  public static final ASN1ObjectIdentifier auditIdentity;
  public static final ASN1ObjectIdentifier authorityInfoAccess;
  public static final ASN1ObjectIdentifier authorityKeyIdentifier;
  public static final ASN1ObjectIdentifier basicConstraints;
  public static final ASN1ObjectIdentifier biometricInfo;
  public static final ASN1ObjectIdentifier cRLDistributionPoints;
  public static final ASN1ObjectIdentifier cRLNumber;
  public static final ASN1ObjectIdentifier certificateIssuer;
  public static final ASN1ObjectIdentifier certificatePolicies;
  public static final ASN1ObjectIdentifier deltaCRLIndicator;
  public static final ASN1ObjectIdentifier expiredCertsOnCRL = new ASN1ObjectIdentifier("2.5.29.60").intern();
  public static final ASN1ObjectIdentifier extendedKeyUsage;
  public static final ASN1ObjectIdentifier freshestCRL;
  public static final ASN1ObjectIdentifier inhibitAnyPolicy;
  public static final ASN1ObjectIdentifier instructionCode;
  public static final ASN1ObjectIdentifier invalidityDate;
  public static final ASN1ObjectIdentifier issuerAlternativeName;
  public static final ASN1ObjectIdentifier issuingDistributionPoint;
  public static final ASN1ObjectIdentifier keyUsage;
  public static final ASN1ObjectIdentifier logoType;
  public static final ASN1ObjectIdentifier nameConstraints;
  public static final ASN1ObjectIdentifier noRevAvail;
  public static final ASN1ObjectIdentifier policyConstraints;
  public static final ASN1ObjectIdentifier policyMappings;
  public static final ASN1ObjectIdentifier privateKeyUsagePeriod;
  public static final ASN1ObjectIdentifier qCStatements;
  public static final ASN1ObjectIdentifier reasonCode;
  public static final ASN1ObjectIdentifier subjectAlternativeName;
  public static final ASN1ObjectIdentifier subjectDirectoryAttributes = new ASN1ObjectIdentifier("2.5.29.9").intern();
  public static final ASN1ObjectIdentifier subjectInfoAccess;
  public static final ASN1ObjectIdentifier subjectKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.14").intern();
  public static final ASN1ObjectIdentifier targetInformation;
  private boolean critical;
  private ASN1ObjectIdentifier extnId;
  private ASN1OctetString value;
  
  static
  {
    keyUsage = new ASN1ObjectIdentifier("2.5.29.15").intern();
    privateKeyUsagePeriod = new ASN1ObjectIdentifier("2.5.29.16").intern();
    subjectAlternativeName = new ASN1ObjectIdentifier("2.5.29.17").intern();
    issuerAlternativeName = new ASN1ObjectIdentifier("2.5.29.18").intern();
    basicConstraints = new ASN1ObjectIdentifier("2.5.29.19").intern();
    cRLNumber = new ASN1ObjectIdentifier("2.5.29.20").intern();
    reasonCode = new ASN1ObjectIdentifier("2.5.29.21").intern();
    instructionCode = new ASN1ObjectIdentifier("2.5.29.23").intern();
    invalidityDate = new ASN1ObjectIdentifier("2.5.29.24").intern();
    deltaCRLIndicator = new ASN1ObjectIdentifier("2.5.29.27").intern();
    issuingDistributionPoint = new ASN1ObjectIdentifier("2.5.29.28").intern();
    certificateIssuer = new ASN1ObjectIdentifier("2.5.29.29").intern();
    nameConstraints = new ASN1ObjectIdentifier("2.5.29.30").intern();
    cRLDistributionPoints = new ASN1ObjectIdentifier("2.5.29.31").intern();
    certificatePolicies = new ASN1ObjectIdentifier("2.5.29.32").intern();
    policyMappings = new ASN1ObjectIdentifier("2.5.29.33").intern();
    authorityKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.35").intern();
    policyConstraints = new ASN1ObjectIdentifier("2.5.29.36").intern();
    extendedKeyUsage = new ASN1ObjectIdentifier("2.5.29.37").intern();
    freshestCRL = new ASN1ObjectIdentifier("2.5.29.46").intern();
    inhibitAnyPolicy = new ASN1ObjectIdentifier("2.5.29.54").intern();
    authorityInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1").intern();
    subjectInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11").intern();
    logoType = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12").intern();
    biometricInfo = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2").intern();
    qCStatements = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3").intern();
    auditIdentity = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4").intern();
    noRevAvail = new ASN1ObjectIdentifier("2.5.29.56").intern();
    targetInformation = new ASN1ObjectIdentifier("2.5.29.55").intern();
  }
  
  public Extension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Boolean paramASN1Boolean, ASN1OctetString paramASN1OctetString)
  {
    this(paramASN1ObjectIdentifier, paramASN1Boolean.isTrue(), paramASN1OctetString);
  }
  
  public Extension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, ASN1OctetString paramASN1OctetString)
  {
    this.extnId = paramASN1ObjectIdentifier;
    this.critical = paramBoolean;
    this.value = paramASN1OctetString;
  }
  
  public Extension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    this(paramASN1ObjectIdentifier, paramBoolean, new DEROctetString(paramArrayOfByte));
  }
  
  private Extension(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.extnId = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      this.critical = false;
    }
    for (paramASN1Sequence = paramASN1Sequence.getObjectAt(1);; paramASN1Sequence = paramASN1Sequence.getObjectAt(2))
    {
      this.value = ASN1OctetString.getInstance(paramASN1Sequence);
      return;
      if (paramASN1Sequence.size() != 3) {
        break;
      }
      this.extnId = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      this.critical = ASN1Boolean.getInstance(paramASN1Sequence.getObjectAt(1)).isTrue();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static ASN1Primitive convertValueToObject(Extension paramExtension)
    throws IllegalArgumentException
  {
    try
    {
      paramExtension = ASN1Primitive.fromByteArray(paramExtension.getExtnValue().getOctets());
      return paramExtension;
    }
    catch (IOException paramExtension)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("can't convert extension: ");
      localStringBuilder.append(paramExtension);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  public static Extension getInstance(Object paramObject)
  {
    if ((paramObject instanceof Extension)) {
      return (Extension)paramObject;
    }
    if (paramObject != null) {
      return new Extension(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Extension;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (Extension)paramObject;
    bool1 = bool2;
    if (((Extension)paramObject).getExtnId().equals(getExtnId()))
    {
      bool1 = bool2;
      if (((Extension)paramObject).getExtnValue().equals(getExtnValue()))
      {
        bool1 = bool2;
        if (((Extension)paramObject).isCritical() == isCritical()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public ASN1ObjectIdentifier getExtnId()
  {
    return this.extnId;
  }
  
  public ASN1OctetString getExtnValue()
  {
    return this.value;
  }
  
  public ASN1Encodable getParsedValue()
  {
    return convertValueToObject(this);
  }
  
  public int hashCode()
  {
    if (isCritical()) {
      return getExtnValue().hashCode() ^ getExtnId().hashCode();
    }
    return getExtnValue().hashCode() ^ getExtnId().hashCode();
  }
  
  public boolean isCritical()
  {
    return this.critical;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.extnId);
    if (this.critical) {
      localASN1EncodableVector.add(ASN1Boolean.getInstance(true));
    }
    localASN1EncodableVector.add(this.value);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\Extension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */