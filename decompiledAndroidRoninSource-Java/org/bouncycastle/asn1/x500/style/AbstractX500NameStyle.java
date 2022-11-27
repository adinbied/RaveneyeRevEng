package org.bouncycastle.asn1.x500.style;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;

public abstract class AbstractX500NameStyle
  implements X500NameStyle
{
  private int calcHashCode(ASN1Encodable paramASN1Encodable)
  {
    return IETFUtils.canonicalize(IETFUtils.valueToString(paramASN1Encodable)).hashCode();
  }
  
  public static Hashtable copyHashTable(Hashtable paramHashtable)
  {
    Hashtable localHashtable = new Hashtable();
    Enumeration localEnumeration = paramHashtable.keys();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = localEnumeration.nextElement();
      localHashtable.put(localObject, paramHashtable.get(localObject));
    }
    return localHashtable;
  }
  
  private boolean foundMatch(boolean paramBoolean, RDN paramRDN, RDN[] paramArrayOfRDN)
  {
    if (paramBoolean)
    {
      i = paramArrayOfRDN.length - 1;
      while (i >= 0)
      {
        if ((paramArrayOfRDN[i] != null) && (rdnAreEqual(paramRDN, paramArrayOfRDN[i])))
        {
          paramArrayOfRDN[i] = null;
          return true;
        }
        i -= 1;
      }
    }
    int i = 0;
    while (i != paramArrayOfRDN.length)
    {
      if ((paramArrayOfRDN[i] != null) && (rdnAreEqual(paramRDN, paramArrayOfRDN[i])))
      {
        paramArrayOfRDN[i] = null;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean areEqual(X500Name paramX500Name1, X500Name paramX500Name2)
  {
    paramX500Name1 = paramX500Name1.getRDNs();
    paramX500Name2 = paramX500Name2.getRDNs();
    if (paramX500Name1.length != paramX500Name2.length) {
      return false;
    }
    boolean bool;
    if ((paramX500Name1[0].getFirst() != null) && (paramX500Name2[0].getFirst() != null)) {
      bool = paramX500Name1[0].getFirst().getType().equals(paramX500Name2[0].getFirst().getType()) ^ true;
    } else {
      bool = false;
    }
    int i = 0;
    while (i != paramX500Name1.length)
    {
      if (!foundMatch(bool, paramX500Name1[i], paramX500Name2)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int calculateHashCode(X500Name paramX500Name)
  {
    paramX500Name = paramX500Name.getRDNs();
    int k = 0;
    int j;
    for (int i = 0; k != paramX500Name.length; i = j)
    {
      if (paramX500Name[k].isMultiValued())
      {
        AttributeTypeAndValue[] arrayOfAttributeTypeAndValue = paramX500Name[k].getTypesAndValues();
        int m = 0;
        for (;;)
        {
          j = i;
          if (m == arrayOfAttributeTypeAndValue.length) {
            break;
          }
          i = i ^ arrayOfAttributeTypeAndValue[m].getType().hashCode() ^ calcHashCode(arrayOfAttributeTypeAndValue[m].getValue());
          m += 1;
        }
      }
      j = i ^ paramX500Name[k].getFirst().getType().hashCode() ^ calcHashCode(paramX500Name[k].getFirst().getValue());
      k += 1;
    }
    return i;
  }
  
  protected ASN1Encodable encodeStringValue(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    return new DERUTF8String(paramString);
  }
  
  protected boolean rdnAreEqual(RDN paramRDN1, RDN paramRDN2)
  {
    return IETFUtils.rDNAreEqual(paramRDN1, paramRDN2);
  }
  
  public ASN1Encodable stringToValue(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    if ((paramString.length() != 0) && (paramString.charAt(0) == '#')) {}
    try
    {
      paramString = IETFUtils.valueFromHexString(paramString, 1);
      return paramString;
    }
    catch (IOException paramString)
    {
      String str;
      for (;;) {}
    }
    paramString = new StringBuilder();
    paramString.append("can't recode value for oid ");
    paramString.append(paramASN1ObjectIdentifier.getId());
    throw new ASN1ParsingException(paramString.toString());
    str = paramString;
    if (paramString.length() != 0)
    {
      str = paramString;
      if (paramString.charAt(0) == '\\') {
        str = paramString.substring(1);
      }
    }
    return encodeStringValue(paramASN1ObjectIdentifier, str);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\x500\style\AbstractX500NameStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */