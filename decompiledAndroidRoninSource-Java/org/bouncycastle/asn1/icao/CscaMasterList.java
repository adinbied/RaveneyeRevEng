package org.bouncycastle.asn1.icao;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.x509.Certificate;

public class CscaMasterList
  extends ASN1Object
{
  private Certificate[] certList;
  private ASN1Integer version = new ASN1Integer(0L);
  
  private CscaMasterList(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence != null) && (paramASN1Sequence.size() != 0))
    {
      if (paramASN1Sequence.size() == 2)
      {
        int i = 0;
        this.version = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
        paramASN1Sequence = ASN1Set.getInstance(paramASN1Sequence.getObjectAt(1));
        this.certList = new Certificate[paramASN1Sequence.size()];
        for (;;)
        {
          localObject = this.certList;
          if (i >= localObject.length) {
            break;
          }
          localObject[i] = Certificate.getInstance(paramASN1Sequence.getObjectAt(i));
          i += 1;
        }
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Incorrect sequence size: ");
      ((StringBuilder)localObject).append(paramASN1Sequence.size());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("null or empty sequence passed.");
  }
  
  public CscaMasterList(Certificate[] paramArrayOfCertificate)
  {
    this.certList = copyCertList(paramArrayOfCertificate);
  }
  
  private Certificate[] copyCertList(Certificate[] paramArrayOfCertificate)
  {
    int j = paramArrayOfCertificate.length;
    Certificate[] arrayOfCertificate = new Certificate[j];
    int i = 0;
    while (i != j)
    {
      arrayOfCertificate[i] = paramArrayOfCertificate[i];
      i += 1;
    }
    return arrayOfCertificate;
  }
  
  public static CscaMasterList getInstance(Object paramObject)
  {
    if ((paramObject instanceof CscaMasterList)) {
      return (CscaMasterList)paramObject;
    }
    if (paramObject != null) {
      return new CscaMasterList(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public Certificate[] getCertStructs()
  {
    return copyCertList(this.certList);
  }
  
  public int getVersion()
  {
    return this.version.getValue().intValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector1 = new ASN1EncodableVector();
    localASN1EncodableVector1.add(this.version);
    ASN1EncodableVector localASN1EncodableVector2 = new ASN1EncodableVector();
    int i = 0;
    for (;;)
    {
      Certificate[] arrayOfCertificate = this.certList;
      if (i >= arrayOfCertificate.length) {
        break;
      }
      localASN1EncodableVector2.add(arrayOfCertificate[i]);
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSet(localASN1EncodableVector2));
    return new DERSequence(localASN1EncodableVector1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\icao\CscaMasterList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */