package org.bouncycastle.asn1.x500.style;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DERUniversalString;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class IETFUtils
{
  public static void appendRDN(StringBuffer paramStringBuffer, RDN paramRDN, Hashtable paramHashtable)
  {
    if (paramRDN.isMultiValued())
    {
      paramRDN = paramRDN.getTypesAndValues();
      int j = 1;
      int i = 0;
      while (i != paramRDN.length)
      {
        if (j != 0) {
          j = 0;
        } else {
          paramStringBuffer.append('+');
        }
        appendTypeAndValue(paramStringBuffer, paramRDN[i], paramHashtable);
        i += 1;
      }
    }
    if (paramRDN.getFirst() != null) {
      appendTypeAndValue(paramStringBuffer, paramRDN.getFirst(), paramHashtable);
    }
  }
  
  public static void appendTypeAndValue(StringBuffer paramStringBuffer, AttributeTypeAndValue paramAttributeTypeAndValue, Hashtable paramHashtable)
  {
    paramHashtable = (String)paramHashtable.get(paramAttributeTypeAndValue.getType());
    if (paramHashtable == null) {
      paramHashtable = paramAttributeTypeAndValue.getType().getId();
    }
    paramStringBuffer.append(paramHashtable);
    paramStringBuffer.append('=');
    paramStringBuffer.append(valueToString(paramAttributeTypeAndValue.getValue()));
  }
  
  private static boolean atvAreEqual(AttributeTypeAndValue paramAttributeTypeAndValue1, AttributeTypeAndValue paramAttributeTypeAndValue2)
  {
    if (paramAttributeTypeAndValue1 == paramAttributeTypeAndValue2) {
      return true;
    }
    if (paramAttributeTypeAndValue1 == null) {
      return false;
    }
    if (paramAttributeTypeAndValue2 == null) {
      return false;
    }
    if (!paramAttributeTypeAndValue1.getType().equals(paramAttributeTypeAndValue2.getType())) {
      return false;
    }
    return canonicalize(valueToString(paramAttributeTypeAndValue1.getValue())).equals(canonicalize(valueToString(paramAttributeTypeAndValue2.getValue())));
  }
  
  private static String bytesToString(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i != j)
    {
      arrayOfChar[i] = ((char)(paramArrayOfByte[i] & 0xFF));
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String canonicalize(String paramString)
  {
    String str = Strings.toLowerCase(paramString);
    int j = str.length();
    int i = 0;
    paramString = str;
    if (j > 0)
    {
      paramString = str;
      if (str.charAt(0) == '#')
      {
        ASN1Primitive localASN1Primitive = decodeObject(str);
        paramString = str;
        if ((localASN1Primitive instanceof ASN1String)) {
          paramString = Strings.toLowerCase(((ASN1String)localASN1Primitive).getString());
        }
      }
    }
    str = paramString;
    if (paramString.length() > 1)
    {
      for (;;)
      {
        j = i + 1;
        if ((j >= paramString.length()) || (paramString.charAt(i) != '\\') || (paramString.charAt(j) != ' ')) {
          break;
        }
        i += 2;
      }
      j = paramString.length() - 1;
      for (;;)
      {
        int k = j - 1;
        if ((k <= 0) || (paramString.charAt(k) != '\\') || (paramString.charAt(j) != ' ')) {
          break;
        }
        j -= 2;
      }
      if (i <= 0)
      {
        str = paramString;
        if (j >= paramString.length() - 1) {}
      }
      else
      {
        str = paramString.substring(i, j + 1);
      }
    }
    return stripInternalSpaces(str);
  }
  
  private static int convertHex(char paramChar)
  {
    if (('0' <= paramChar) && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if (('a' <= paramChar) && (paramChar <= 'f')) {
      paramChar -= 'a';
    }
    for (;;)
    {
      return paramChar + '\n';
      paramChar -= 'A';
    }
  }
  
  public static ASN1ObjectIdentifier decodeAttrName(String paramString, Hashtable paramHashtable)
  {
    if (Strings.toUpperCase(paramString).startsWith("OID.")) {
      return new ASN1ObjectIdentifier(paramString.substring(4));
    }
    if ((paramString.charAt(0) >= '0') && (paramString.charAt(0) <= '9')) {
      return new ASN1ObjectIdentifier(paramString);
    }
    paramHashtable = (ASN1ObjectIdentifier)paramHashtable.get(Strings.toLowerCase(paramString));
    if (paramHashtable != null) {
      return paramHashtable;
    }
    paramHashtable = new StringBuilder();
    paramHashtable.append("Unknown object id - ");
    paramHashtable.append(paramString);
    paramHashtable.append(" - passed to distinguished name");
    throw new IllegalArgumentException(paramHashtable.toString());
  }
  
  private static ASN1Primitive decodeObject(String paramString)
  {
    try
    {
      paramString = ASN1Primitive.fromByteArray(Hex.decode(paramString.substring(1)));
      return paramString;
    }
    catch (IOException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown encoding in name: ");
      localStringBuilder.append(paramString);
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  public static String[] findAttrNamesForOID(ASN1ObjectIdentifier paramASN1ObjectIdentifier, Hashtable paramHashtable)
  {
    Object localObject = paramHashtable.elements();
    int j = 0;
    int i = 0;
    while (((Enumeration)localObject).hasMoreElements()) {
      if (paramASN1ObjectIdentifier.equals(((Enumeration)localObject).nextElement())) {
        i += 1;
      }
    }
    localObject = new String[i];
    Enumeration localEnumeration = paramHashtable.keys();
    i = j;
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      if (paramASN1ObjectIdentifier.equals(paramHashtable.get(str)))
      {
        localObject[i] = str;
        i += 1;
      }
    }
    return (String[])localObject;
  }
  
  private static boolean isHexDigit(char paramChar)
  {
    return (('0' <= paramChar) && (paramChar <= '9')) || (('a' <= paramChar) && (paramChar <= 'f')) || (('A' <= paramChar) && (paramChar <= 'F'));
  }
  
  public static boolean rDNAreEqual(RDN paramRDN1, RDN paramRDN2)
  {
    if (paramRDN1.isMultiValued())
    {
      if (paramRDN2.isMultiValued())
      {
        paramRDN1 = paramRDN1.getTypesAndValues();
        paramRDN2 = paramRDN2.getTypesAndValues();
        if (paramRDN1.length != paramRDN2.length) {
          return false;
        }
        int i = 0;
        while (i != paramRDN1.length)
        {
          if (!atvAreEqual(paramRDN1[i], paramRDN2[i])) {
            return false;
          }
          i += 1;
        }
        return true;
      }
      return false;
    }
    if (!paramRDN2.isMultiValued()) {
      return atvAreEqual(paramRDN1.getFirst(), paramRDN2.getFirst());
    }
    return false;
  }
  
  public static RDN[] rDNsFromString(String paramString, X500NameStyle paramX500NameStyle)
  {
    X500NameTokenizer localX500NameTokenizer1 = new X500NameTokenizer(paramString);
    X500NameBuilder localX500NameBuilder = new X500NameBuilder(paramX500NameStyle);
    while (localX500NameTokenizer1.hasMoreTokens())
    {
      paramString = localX500NameTokenizer1.nextToken();
      Object localObject;
      if (paramString.indexOf('+') > 0)
      {
        X500NameTokenizer localX500NameTokenizer2 = new X500NameTokenizer(paramString, '+');
        paramString = new X500NameTokenizer(localX500NameTokenizer2.nextToken(), '=');
        localObject = paramString.nextToken();
        if (paramString.hasMoreTokens())
        {
          paramString = paramString.nextToken();
          localObject = paramX500NameStyle.attrNameToOID(((String)localObject).trim());
          if (localX500NameTokenizer2.hasMoreTokens())
          {
            Vector localVector1 = new Vector();
            Vector localVector2 = new Vector();
            for (;;)
            {
              localVector1.addElement(localObject);
              localVector2.addElement(unescape(paramString));
              if (!localX500NameTokenizer2.hasMoreTokens()) {
                break label200;
              }
              paramString = new X500NameTokenizer(localX500NameTokenizer2.nextToken(), '=');
              localObject = paramString.nextToken();
              if (!paramString.hasMoreTokens()) {
                break;
              }
              paramString = paramString.nextToken();
              localObject = paramX500NameStyle.attrNameToOID(((String)localObject).trim());
            }
            throw new IllegalArgumentException("badly formatted directory string");
            label200:
            localX500NameBuilder.addMultiValuedRDN(toOIDArray(localVector1), toValueArray(localVector2));
          }
          else
          {
            localX500NameBuilder.addRDN((ASN1ObjectIdentifier)localObject, unescape(paramString));
          }
        }
        else
        {
          throw new IllegalArgumentException("badly formatted directory string");
        }
      }
      else
      {
        localObject = new X500NameTokenizer(paramString, '=');
        paramString = ((X500NameTokenizer)localObject).nextToken();
        if (((X500NameTokenizer)localObject).hasMoreTokens())
        {
          localObject = ((X500NameTokenizer)localObject).nextToken();
          localX500NameBuilder.addRDN(paramX500NameStyle.attrNameToOID(paramString.trim()), unescape((String)localObject));
        }
        else
        {
          throw new IllegalArgumentException("badly formatted directory string");
        }
      }
    }
    return localX500NameBuilder.build().getRDNs();
  }
  
  public static String stripInternalSpaces(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramString.length() != 0)
    {
      char c1 = paramString.charAt(0);
      localStringBuffer.append(c1);
      int i = 1;
      for (char c2 = c1; i < paramString.length(); c2 = c1)
      {
        c1 = paramString.charAt(i);
        if ((c2 != ' ') || (c1 != ' ')) {
          localStringBuffer.append(c1);
        }
        i += 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  private static ASN1ObjectIdentifier[] toOIDArray(Vector paramVector)
  {
    int j = paramVector.size();
    ASN1ObjectIdentifier[] arrayOfASN1ObjectIdentifier = new ASN1ObjectIdentifier[j];
    int i = 0;
    while (i != j)
    {
      arrayOfASN1ObjectIdentifier[i] = ((ASN1ObjectIdentifier)paramVector.elementAt(i));
      i += 1;
    }
    return arrayOfASN1ObjectIdentifier;
  }
  
  private static String[] toValueArray(Vector paramVector)
  {
    int j = paramVector.size();
    String[] arrayOfString = new String[j];
    int i = 0;
    while (i != j)
    {
      arrayOfString[i] = ((String)paramVector.elementAt(i));
      i += 1;
    }
    return arrayOfString;
  }
  
  private static String unescape(String paramString)
  {
    if ((paramString.length() != 0) && ((paramString.indexOf('\\') >= 0) || (paramString.indexOf('"') >= 0)))
    {
      char[] arrayOfChar = paramString.toCharArray();
      paramString = new StringBuffer(paramString.length());
      int i;
      if ((arrayOfChar[0] == '\\') && (arrayOfChar[1] == '#'))
      {
        i = 2;
        paramString.append("\\#");
      }
      else
      {
        i = 0;
      }
      int i1 = 0;
      int m = 0;
      int j = 0;
      int n = 0;
      char c1 = '\000';
      int k = i;
      while (k != arrayOfChar.length)
      {
        char c2 = arrayOfChar[k];
        if (c2 != ' ') {
          n = 1;
        }
        if (c2 == '"')
        {
          if (i1 != 0) {
            break label239;
          }
          j ^= 0x1;
        }
        for (;;)
        {
          i = 0;
          break;
          if ((c2 == '\\') && (i1 == 0) && (j == 0))
          {
            m = paramString.length();
            i = 1;
            break;
          }
          if ((c2 == ' ') && (i1 == 0) && (n == 0))
          {
            i = i1;
            break;
          }
          if ((i1 != 0) && (isHexDigit(c2)))
          {
            if (c1 != 0)
            {
              paramString.append((char)(convertHex(c1) * 16 + convertHex(c2)));
              i = 0;
              c1 = '\000';
              break;
            }
            c1 = c2;
            i = i1;
            break;
          }
          label239:
          paramString.append(c2);
        }
        k += 1;
        i1 = i;
      }
      if (paramString.length() > 0) {
        while ((paramString.charAt(paramString.length() - 1) == ' ') && (m != paramString.length() - 1)) {
          paramString.setLength(paramString.length() - 1);
        }
      }
      return paramString.toString();
    }
    return paramString.trim();
  }
  
  public static ASN1Encodable valueFromHexString(String paramString, int paramInt)
    throws IOException
  {
    int j = (paramString.length() - paramInt) / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i != j)
    {
      int k = i * 2 + paramInt;
      char c1 = paramString.charAt(k);
      char c2 = paramString.charAt(k + 1);
      k = convertHex(c1);
      arrayOfByte[i] = ((byte)(convertHex(c2) | k << 4));
      i += 1;
    }
    return ASN1Primitive.fromByteArray(arrayOfByte);
  }
  
  public static String valueToString(ASN1Encodable paramASN1Encodable)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    boolean bool = paramASN1Encodable instanceof ASN1String;
    int n = 0;
    Object localObject;
    if ((bool) && (!(paramASN1Encodable instanceof DERUniversalString)))
    {
      localObject = ((ASN1String)paramASN1Encodable).getString();
      paramASN1Encodable = (ASN1Encodable)localObject;
      if (((String)localObject).length() > 0)
      {
        paramASN1Encodable = (ASN1Encodable)localObject;
        if (((String)localObject).charAt(0) == '#')
        {
          paramASN1Encodable = new StringBuilder();
          paramASN1Encodable.append("\\");
          paramASN1Encodable.append((String)localObject);
          paramASN1Encodable = paramASN1Encodable.toString();
        }
      }
      localStringBuffer.append(paramASN1Encodable);
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(bytesToString(Hex.encode(paramASN1Encodable.toASN1Primitive().getEncoded("DER"))));
      localStringBuffer.append(((StringBuilder)localObject).toString());
      int j = localStringBuffer.length();
      int k = localStringBuffer.length();
      int i = 2;
      if ((k < 2) || (localStringBuffer.charAt(0) != '\\') || (localStringBuffer.charAt(1) != '#')) {
        i = 0;
      }
      while (i != j)
      {
        int m;
        if ((localStringBuffer.charAt(i) != ',') && (localStringBuffer.charAt(i) != '"') && (localStringBuffer.charAt(i) != '\\') && (localStringBuffer.charAt(i) != '+') && (localStringBuffer.charAt(i) != '=') && (localStringBuffer.charAt(i) != '<') && (localStringBuffer.charAt(i) != '>'))
        {
          m = i;
          k = j;
          if (localStringBuffer.charAt(i) != ';') {}
        }
        else
        {
          localStringBuffer.insert(i, "\\");
          m = i + 1;
          k = j + 1;
        }
        i = m + 1;
        j = k;
      }
      if (localStringBuffer.length() > 0)
      {
        i = n;
        while ((localStringBuffer.length() > i) && (localStringBuffer.charAt(i) == ' '))
        {
          localStringBuffer.insert(i, "\\");
          i += 2;
        }
      }
      i = localStringBuffer.length() - 1;
      while ((i >= 0) && (localStringBuffer.charAt(i) == ' '))
      {
        localStringBuffer.insert(i, '\\');
        i -= 1;
      }
      return localStringBuffer.toString();
    }
    catch (IOException paramASN1Encodable)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("Other value has no encoded form");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\x500\style\IETFUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */