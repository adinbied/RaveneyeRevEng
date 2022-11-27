package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.util.Arrays;

public class MacData
  extends ASN1Object
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  DigestInfo digInfo;
  BigInteger iterationCount;
  byte[] salt;
  
  private MacData(ASN1Sequence paramASN1Sequence)
  {
    this.digInfo = DigestInfo.getInstance(paramASN1Sequence.getObjectAt(0));
    this.salt = Arrays.clone(((ASN1OctetString)paramASN1Sequence.getObjectAt(1)).getOctets());
    if (paramASN1Sequence.size() == 3) {
      paramASN1Sequence = ((ASN1Integer)paramASN1Sequence.getObjectAt(2)).getValue();
    } else {
      paramASN1Sequence = ONE;
    }
    this.iterationCount = paramASN1Sequence;
  }
  
  public MacData(DigestInfo paramDigestInfo, byte[] paramArrayOfByte, int paramInt)
  {
    this.digInfo = paramDigestInfo;
    this.salt = Arrays.clone(paramArrayOfByte);
    this.iterationCount = BigInteger.valueOf(paramInt);
  }
  
  public static MacData getInstance(Object paramObject)
  {
    if ((paramObject instanceof MacData)) {
      return (MacData)paramObject;
    }
    if (paramObject != null) {
      return new MacData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public BigInteger getIterationCount()
  {
    return this.iterationCount;
  }
  
  public DigestInfo getMac()
  {
    return this.digInfo;
  }
  
  public byte[] getSalt()
  {
    return Arrays.clone(this.salt);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.digInfo);
    localASN1EncodableVector.add(new DEROctetString(this.salt));
    if (!this.iterationCount.equals(ONE)) {
      localASN1EncodableVector.add(new ASN1Integer(this.iterationCount));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\MacData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */