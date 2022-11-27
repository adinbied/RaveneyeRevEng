package org.bouncycastle.asn1.eac;

import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.util.Integers;

public class CertificateHolderAuthorization
  extends ASN1Object
{
  static BidirectionalMap AuthorizationRole;
  public static final int CVCA = 192;
  public static final int DV_DOMESTIC = 128;
  public static final int DV_FOREIGN = 64;
  public static final int IS = 0;
  public static final int RADG3 = 1;
  public static final int RADG4 = 2;
  static Hashtable ReverseMap;
  static Hashtable RightsDecodeMap;
  public static final ASN1ObjectIdentifier id_role_EAC = EACObjectIdentifiers.bsi_de.branch("3.1.2.1");
  DERApplicationSpecific accessRights;
  ASN1ObjectIdentifier oid;
  
  static
  {
    RightsDecodeMap = new Hashtable();
    AuthorizationRole = new BidirectionalMap();
    ReverseMap = new Hashtable();
    RightsDecodeMap.put(Integers.valueOf(2), "RADG4");
    RightsDecodeMap.put(Integers.valueOf(1), "RADG3");
    AuthorizationRole.put(Integers.valueOf(192), "CVCA");
    AuthorizationRole.put(Integers.valueOf(128), "DV_DOMESTIC");
    AuthorizationRole.put(Integers.valueOf(64), "DV_FOREIGN");
    AuthorizationRole.put(Integers.valueOf(0), "IS");
  }
  
  public CertificateHolderAuthorization(ASN1ObjectIdentifier paramASN1ObjectIdentifier, int paramInt)
    throws IOException
  {
    setOid(paramASN1ObjectIdentifier);
    setAccessRights((byte)paramInt);
  }
  
  public CertificateHolderAuthorization(DERApplicationSpecific paramDERApplicationSpecific)
    throws IOException
  {
    if (paramDERApplicationSpecific.getApplicationTag() == 76) {
      setPrivateData(new ASN1InputStream(paramDERApplicationSpecific.getContents()));
    }
  }
  
  public static int getFlag(String paramString)
  {
    Object localObject = (Integer)AuthorizationRole.getReverse(paramString);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unknown value ");
    ((StringBuilder)localObject).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static String getRoleDescription(int paramInt)
  {
    return (String)AuthorizationRole.get(Integers.valueOf(paramInt));
  }
  
  private void setAccessRights(byte paramByte)
  {
    this.accessRights = new DERApplicationSpecific(19, new byte[] { paramByte });
  }
  
  private void setOid(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.oid = paramASN1ObjectIdentifier;
  }
  
  private void setPrivateData(ASN1InputStream paramASN1InputStream)
    throws IOException
  {
    ASN1Primitive localASN1Primitive = paramASN1InputStream.readObject();
    if ((localASN1Primitive instanceof ASN1ObjectIdentifier))
    {
      this.oid = ((ASN1ObjectIdentifier)localASN1Primitive);
      paramASN1InputStream = paramASN1InputStream.readObject();
      if ((paramASN1InputStream instanceof DERApplicationSpecific))
      {
        this.accessRights = ((DERApplicationSpecific)paramASN1InputStream);
        return;
      }
      throw new IllegalArgumentException("No access rights in CerticateHolderAuthorization");
    }
    throw new IllegalArgumentException("no Oid in CerticateHolderAuthorization");
  }
  
  public int getAccessRights()
  {
    return this.accessRights.getContents()[0] & 0xFF;
  }
  
  public ASN1ObjectIdentifier getOid()
  {
    return this.oid;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.oid);
    localASN1EncodableVector.add(this.accessRights);
    return new DERApplicationSpecific(76, localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\eac\CertificateHolderAuthorization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */