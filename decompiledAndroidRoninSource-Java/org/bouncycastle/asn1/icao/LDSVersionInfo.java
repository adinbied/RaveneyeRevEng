package org.bouncycastle.asn1.icao;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;

public class LDSVersionInfo
  extends ASN1Object
{
  private DERPrintableString ldsVersion;
  private DERPrintableString unicodeVersion;
  
  public LDSVersionInfo(String paramString1, String paramString2)
  {
    this.ldsVersion = new DERPrintableString(paramString1);
    this.unicodeVersion = new DERPrintableString(paramString2);
  }
  
  private LDSVersionInfo(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.ldsVersion = DERPrintableString.getInstance(paramASN1Sequence.getObjectAt(0));
      this.unicodeVersion = DERPrintableString.getInstance(paramASN1Sequence.getObjectAt(1));
      return;
    }
    throw new IllegalArgumentException("sequence wrong size for LDSVersionInfo");
  }
  
  public static LDSVersionInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof LDSVersionInfo)) {
      return (LDSVersionInfo)paramObject;
    }
    if (paramObject != null) {
      return new LDSVersionInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public String getLdsVersion()
  {
    return this.ldsVersion.getString();
  }
  
  public String getUnicodeVersion()
  {
    return this.unicodeVersion.getString();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.ldsVersion);
    localASN1EncodableVector.add(this.unicodeVersion);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\icao\LDSVersionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */