package org.bouncycastle.tsp.cms;

import java.net.URI;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.cms.Attributes;
import org.bouncycastle.asn1.cms.MetaData;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.DigestCalculator;

public class CMSTimeStampedGenerator
{
  protected URI dataUri;
  protected MetaData metaData;
  
  private void setMetaData(boolean paramBoolean, DERUTF8String paramDERUTF8String, DERIA5String paramDERIA5String, Attributes paramAttributes)
  {
    this.metaData = new MetaData(ASN1Boolean.getInstance(paramBoolean), paramDERUTF8String, paramDERIA5String, paramAttributes);
  }
  
  public void initialiseMessageImprintDigestCalculator(DigestCalculator paramDigestCalculator)
    throws CMSException
  {
    new MetaDataUtil(this.metaData).initialiseMessageImprintDigestCalculator(paramDigestCalculator);
  }
  
  public void setDataUri(URI paramURI)
  {
    this.dataUri = paramURI;
  }
  
  public void setMetaData(boolean paramBoolean, String paramString1, String paramString2)
  {
    setMetaData(paramBoolean, paramString1, paramString2, null);
  }
  
  public void setMetaData(boolean paramBoolean, String paramString1, String paramString2, Attributes paramAttributes)
  {
    DERIA5String localDERIA5String = null;
    if (paramString1 != null) {
      paramString1 = new DERUTF8String(paramString1);
    } else {
      paramString1 = null;
    }
    if (paramString2 != null) {
      localDERIA5String = new DERIA5String(paramString2);
    }
    setMetaData(paramBoolean, paramString1, localDERIA5String, paramAttributes);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\cms\CMSTimeStampedGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */