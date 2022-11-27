package org.bouncycastle.asn1.isismtt.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x500.DirectoryString;

public class AdditionalInformationSyntax
  extends ASN1Object
{
  private DirectoryString information;
  
  public AdditionalInformationSyntax(String paramString)
  {
    this(new DirectoryString(paramString));
  }
  
  private AdditionalInformationSyntax(DirectoryString paramDirectoryString)
  {
    this.information = paramDirectoryString;
  }
  
  public static AdditionalInformationSyntax getInstance(Object paramObject)
  {
    if ((paramObject instanceof AdditionalInformationSyntax)) {
      return (AdditionalInformationSyntax)paramObject;
    }
    if (paramObject != null) {
      return new AdditionalInformationSyntax(DirectoryString.getInstance(paramObject));
    }
    return null;
  }
  
  public DirectoryString getInformation()
  {
    return this.information;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.information.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\isismtt\x509\AdditionalInformationSyntax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */