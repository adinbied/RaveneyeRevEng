package org.bouncycastle.cms;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class CMSAuthenticatedGenerator
  extends CMSEnvelopedGenerator
{
  protected CMSAttributeTableGenerator authGen;
  protected CMSAttributeTableGenerator unauthGen;
  
  protected Map getBaseParameters(ASN1ObjectIdentifier paramASN1ObjectIdentifier, AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contentType", paramASN1ObjectIdentifier);
    localHashMap.put("digestAlgID", paramAlgorithmIdentifier1);
    localHashMap.put("digest", Arrays.clone(paramArrayOfByte));
    localHashMap.put("macAlgID", paramAlgorithmIdentifier2);
    return localHashMap;
  }
  
  public void setAuthenticatedAttributeGenerator(CMSAttributeTableGenerator paramCMSAttributeTableGenerator)
  {
    this.authGen = paramCMSAttributeTableGenerator;
  }
  
  public void setUnauthenticatedAttributeGenerator(CMSAttributeTableGenerator paramCMSAttributeTableGenerator)
  {
    this.unauthGen = paramCMSAttributeTableGenerator;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSAuthenticatedGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */