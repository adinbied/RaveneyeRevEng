package org.bouncycastle.asn1.smime;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

public class SMIMECapabilities
  extends ASN1Object
{
  public static final ASN1ObjectIdentifier aes128_CBC;
  public static final ASN1ObjectIdentifier aes192_CBC;
  public static final ASN1ObjectIdentifier aes256_CBC;
  public static final ASN1ObjectIdentifier canNotDecryptAny;
  public static final ASN1ObjectIdentifier cast5_CBC = new ASN1ObjectIdentifier("1.2.840.113533.7.66.10");
  public static final ASN1ObjectIdentifier dES_CBC = new ASN1ObjectIdentifier("1.3.14.3.2.7");
  public static final ASN1ObjectIdentifier dES_EDE3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC;
  public static final ASN1ObjectIdentifier idea_CBC;
  public static final ASN1ObjectIdentifier preferSignedData = PKCSObjectIdentifiers.preferSignedData;
  public static final ASN1ObjectIdentifier rC2_CBC = PKCSObjectIdentifiers.RC2_CBC;
  public static final ASN1ObjectIdentifier sMIMECapabilitesVersions;
  private ASN1Sequence capabilities;
  
  static
  {
    canNotDecryptAny = PKCSObjectIdentifiers.canNotDecryptAny;
    sMIMECapabilitesVersions = PKCSObjectIdentifiers.sMIMECapabilitiesVersions;
    aes256_CBC = NISTObjectIdentifiers.id_aes256_CBC;
    aes192_CBC = NISTObjectIdentifiers.id_aes192_CBC;
    aes128_CBC = NISTObjectIdentifiers.id_aes128_CBC;
    idea_CBC = new ASN1ObjectIdentifier("1.3.6.1.4.1.188.7.1.1.2");
  }
  
  public SMIMECapabilities(ASN1Sequence paramASN1Sequence)
  {
    this.capabilities = paramASN1Sequence;
  }
  
  public static SMIMECapabilities getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof SMIMECapabilities)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new SMIMECapabilities((ASN1Sequence)paramObject);
      }
      if ((paramObject instanceof Attribute)) {
        return new SMIMECapabilities((ASN1Sequence)((Attribute)paramObject).getAttrValues().getObjectAt(0));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object in factory: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (SMIMECapabilities)paramObject;
  }
  
  public Vector getCapabilities(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Enumeration localEnumeration = this.capabilities.getObjects();
    Vector localVector = new Vector();
    if (paramASN1ObjectIdentifier == null) {
      while (localEnumeration.hasMoreElements()) {
        localVector.addElement(SMIMECapability.getInstance(localEnumeration.nextElement()));
      }
    }
    while (localEnumeration.hasMoreElements())
    {
      SMIMECapability localSMIMECapability = SMIMECapability.getInstance(localEnumeration.nextElement());
      if (paramASN1ObjectIdentifier.equals(localSMIMECapability.getCapabilityID())) {
        localVector.addElement(localSMIMECapability);
      }
    }
    return localVector;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.capabilities;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\smime\SMIMECapabilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */