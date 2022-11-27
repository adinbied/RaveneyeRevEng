package org.bouncycastle.tsp.cms;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.cms.Attributes;
import org.bouncycastle.asn1.cms.MetaData;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.DigestCalculator;

class MetaDataUtil
{
  private final MetaData metaData;
  
  MetaDataUtil(MetaData paramMetaData)
  {
    this.metaData = paramMetaData;
  }
  
  private String convertString(ASN1String paramASN1String)
  {
    if (paramASN1String != null) {
      return paramASN1String.toString();
    }
    return null;
  }
  
  String getFileName()
  {
    MetaData localMetaData = this.metaData;
    if (localMetaData != null) {
      return convertString(localMetaData.getFileName());
    }
    return null;
  }
  
  String getMediaType()
  {
    MetaData localMetaData = this.metaData;
    if (localMetaData != null) {
      return convertString(localMetaData.getMediaType());
    }
    return null;
  }
  
  Attributes getOtherMetaData()
  {
    MetaData localMetaData = this.metaData;
    if (localMetaData != null) {
      return localMetaData.getOtherMetaData();
    }
    return null;
  }
  
  void initialiseMessageImprintDigestCalculator(DigestCalculator paramDigestCalculator)
    throws CMSException
  {
    Object localObject = this.metaData;
    if ((localObject != null) && (((MetaData)localObject).isHashProtected())) {
      try
      {
        paramDigestCalculator.getOutputStream().write(this.metaData.getEncoded("DER"));
        return;
      }
      catch (IOException paramDigestCalculator)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unable to initialise calculator from metaData: ");
        ((StringBuilder)localObject).append(paramDigestCalculator.getMessage());
        throw new CMSException(((StringBuilder)localObject).toString(), paramDigestCalculator);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\cms\MetaDataUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */