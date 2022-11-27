package org.bouncycastle.est;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.est.AttrOrOID;
import org.bouncycastle.asn1.est.CsrAttrs;
import org.bouncycastle.asn1.pkcs.Attribute;
import org.bouncycastle.util.Encodable;

public class CSRAttributesResponse
  implements Encodable
{
  private final CsrAttrs csrAttrs;
  private final HashMap<ASN1ObjectIdentifier, AttrOrOID> index;
  
  public CSRAttributesResponse(CsrAttrs paramCsrAttrs)
    throws ESTException
  {
    this.csrAttrs = paramCsrAttrs;
    this.index = new HashMap(paramCsrAttrs.size());
    AttrOrOID[] arrayOfAttrOrOID = paramCsrAttrs.getAttrOrOIDs();
    int i = 0;
    while (i != arrayOfAttrOrOID.length)
    {
      AttrOrOID localAttrOrOID = arrayOfAttrOrOID[i];
      ASN1ObjectIdentifier localASN1ObjectIdentifier;
      if (localAttrOrOID.isOid())
      {
        paramCsrAttrs = this.index;
        localASN1ObjectIdentifier = localAttrOrOID.getOid();
      }
      else
      {
        paramCsrAttrs = this.index;
        localASN1ObjectIdentifier = localAttrOrOID.getAttribute().getAttrType();
      }
      paramCsrAttrs.put(localASN1ObjectIdentifier, localAttrOrOID);
      i += 1;
    }
  }
  
  public CSRAttributesResponse(byte[] paramArrayOfByte)
    throws ESTException
  {
    this(parseBytes(paramArrayOfByte));
  }
  
  private static CsrAttrs parseBytes(byte[] paramArrayOfByte)
    throws ESTException
  {
    try
    {
      paramArrayOfByte = CsrAttrs.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new ESTException(localStringBuilder.toString(), paramArrayOfByte);
    }
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.csrAttrs.getEncoded();
  }
  
  public Collection<ASN1ObjectIdentifier> getRequirements()
  {
    return this.index.keySet();
  }
  
  public boolean hasRequirement(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return this.index.containsKey(paramASN1ObjectIdentifier);
  }
  
  public boolean isAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    if (this.index.containsKey(paramASN1ObjectIdentifier)) {
      return ((AttrOrOID)this.index.get(paramASN1ObjectIdentifier)).isOid() ^ true;
    }
    return false;
  }
  
  public boolean isEmpty()
  {
    return this.csrAttrs.size() == 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\CSRAttributesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */