package org.bouncycastle.cms;

import java.util.Map;
import org.bouncycastle.asn1.cms.AttributeTable;

public abstract interface CMSAttributeTableGenerator
{
  public static final String CONTENT_TYPE = "contentType";
  public static final String DIGEST = "digest";
  public static final String DIGEST_ALGORITHM_IDENTIFIER = "digestAlgID";
  public static final String MAC_ALGORITHM_IDENTIFIER = "macAlgID";
  public static final String SIGNATURE = "encryptedDigest";
  public static final String SIGNATURE_ALGORITHM_IDENTIFIER = "signatureAlgID";
  
  public abstract AttributeTable getAttributes(Map paramMap)
    throws CMSAttributeTableGenerationException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSAttributeTableGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */