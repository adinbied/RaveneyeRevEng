package org.bouncycastle.asn1.x509;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERUniversalString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class X509Name
  extends ASN1Object
{
  public static final ASN1ObjectIdentifier BUSINESS_CATEGORY;
  public static final ASN1ObjectIdentifier C = new ASN1ObjectIdentifier("2.5.4.6");
  public static final ASN1ObjectIdentifier CN;
  public static final ASN1ObjectIdentifier COUNTRY_OF_CITIZENSHIP;
  public static final ASN1ObjectIdentifier COUNTRY_OF_RESIDENCE;
  public static final ASN1ObjectIdentifier DATE_OF_BIRTH;
  public static final ASN1ObjectIdentifier DC;
  public static final ASN1ObjectIdentifier DMD_NAME;
  public static final ASN1ObjectIdentifier DN_QUALIFIER;
  public static final Hashtable DefaultLookUp;
  public static boolean DefaultReverse;
  public static final Hashtable DefaultSymbols;
  public static final ASN1ObjectIdentifier E;
  public static final ASN1ObjectIdentifier EmailAddress;
  private static final Boolean FALSE;
  public static final ASN1ObjectIdentifier GENDER;
  public static final ASN1ObjectIdentifier GENERATION;
  public static final ASN1ObjectIdentifier GIVENNAME;
  public static final ASN1ObjectIdentifier INITIALS;
  public static final ASN1ObjectIdentifier L;
  public static final ASN1ObjectIdentifier NAME;
  public static final ASN1ObjectIdentifier NAME_AT_BIRTH;
  public static final ASN1ObjectIdentifier O = new ASN1ObjectIdentifier("2.5.4.10");
  public static final Hashtable OIDLookUp;
  public static final ASN1ObjectIdentifier OU = new ASN1ObjectIdentifier("2.5.4.11");
  public static final ASN1ObjectIdentifier PLACE_OF_BIRTH;
  public static final ASN1ObjectIdentifier POSTAL_ADDRESS;
  public static final ASN1ObjectIdentifier POSTAL_CODE;
  public static final ASN1ObjectIdentifier PSEUDONYM;
  public static final Hashtable RFC1779Symbols;
  public static final Hashtable RFC2253Symbols;
  public static final ASN1ObjectIdentifier SERIALNUMBER;
  public static final ASN1ObjectIdentifier SN;
  public static final ASN1ObjectIdentifier ST;
  public static final ASN1ObjectIdentifier STREET;
  public static final ASN1ObjectIdentifier SURNAME;
  public static final Hashtable SymbolLookUp;
  public static final ASN1ObjectIdentifier T = new ASN1ObjectIdentifier("2.5.4.12");
  public static final ASN1ObjectIdentifier TELEPHONE_NUMBER;
  private static final Boolean TRUE;
  public static final ASN1ObjectIdentifier UID;
  public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER;
  public static final ASN1ObjectIdentifier UnstructuredAddress;
  public static final ASN1ObjectIdentifier UnstructuredName;
  private Vector added = new Vector();
  private X509NameEntryConverter converter = null;
  private int hashCodeValue;
  private boolean isHashCodeCalculated;
  private Vector ordering = new Vector();
  private ASN1Sequence seq;
  private Vector values = new Vector();
  
  static
  {
    CN = new ASN1ObjectIdentifier("2.5.4.3");
    SN = new ASN1ObjectIdentifier("2.5.4.5");
    STREET = new ASN1ObjectIdentifier("2.5.4.9");
    SERIALNUMBER = SN;
    L = new ASN1ObjectIdentifier("2.5.4.7");
    ST = new ASN1ObjectIdentifier("2.5.4.8");
    SURNAME = new ASN1ObjectIdentifier("2.5.4.4");
    GIVENNAME = new ASN1ObjectIdentifier("2.5.4.42");
    INITIALS = new ASN1ObjectIdentifier("2.5.4.43");
    GENERATION = new ASN1ObjectIdentifier("2.5.4.44");
    UNIQUE_IDENTIFIER = new ASN1ObjectIdentifier("2.5.4.45");
    BUSINESS_CATEGORY = new ASN1ObjectIdentifier("2.5.4.15");
    POSTAL_CODE = new ASN1ObjectIdentifier("2.5.4.17");
    DN_QUALIFIER = new ASN1ObjectIdentifier("2.5.4.46");
    PSEUDONYM = new ASN1ObjectIdentifier("2.5.4.65");
    DATE_OF_BIRTH = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.1");
    PLACE_OF_BIRTH = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.2");
    GENDER = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.3");
    COUNTRY_OF_CITIZENSHIP = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.4");
    COUNTRY_OF_RESIDENCE = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.5");
    NAME_AT_BIRTH = new ASN1ObjectIdentifier("1.3.36.8.3.14");
    POSTAL_ADDRESS = new ASN1ObjectIdentifier("2.5.4.16");
    DMD_NAME = new ASN1ObjectIdentifier("2.5.4.54");
    TELEPHONE_NUMBER = X509ObjectIdentifiers.id_at_telephoneNumber;
    NAME = X509ObjectIdentifiers.id_at_name;
    EmailAddress = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
    UnstructuredName = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
    UnstructuredAddress = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
    E = EmailAddress;
    DC = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
    UID = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
    DefaultReverse = false;
    DefaultSymbols = new Hashtable();
    RFC2253Symbols = new Hashtable();
    RFC1779Symbols = new Hashtable();
    Hashtable localHashtable = new Hashtable();
    DefaultLookUp = localHashtable;
    OIDLookUp = DefaultSymbols;
    SymbolLookUp = localHashtable;
    TRUE = new Boolean(true);
    FALSE = new Boolean(false);
    DefaultSymbols.put(C, "C");
    DefaultSymbols.put(O, "O");
    DefaultSymbols.put(T, "T");
    DefaultSymbols.put(OU, "OU");
    DefaultSymbols.put(CN, "CN");
    DefaultSymbols.put(L, "L");
    DefaultSymbols.put(ST, "ST");
    DefaultSymbols.put(SN, "SERIALNUMBER");
    DefaultSymbols.put(EmailAddress, "E");
    DefaultSymbols.put(DC, "DC");
    DefaultSymbols.put(UID, "UID");
    DefaultSymbols.put(STREET, "STREET");
    DefaultSymbols.put(SURNAME, "SURNAME");
    DefaultSymbols.put(GIVENNAME, "GIVENNAME");
    DefaultSymbols.put(INITIALS, "INITIALS");
    DefaultSymbols.put(GENERATION, "GENERATION");
    DefaultSymbols.put(UnstructuredAddress, "unstructuredAddress");
    DefaultSymbols.put(UnstructuredName, "unstructuredName");
    DefaultSymbols.put(UNIQUE_IDENTIFIER, "UniqueIdentifier");
    DefaultSymbols.put(DN_QUALIFIER, "DN");
    DefaultSymbols.put(PSEUDONYM, "Pseudonym");
    DefaultSymbols.put(POSTAL_ADDRESS, "PostalAddress");
    DefaultSymbols.put(NAME_AT_BIRTH, "NameAtBirth");
    DefaultSymbols.put(COUNTRY_OF_CITIZENSHIP, "CountryOfCitizenship");
    DefaultSymbols.put(COUNTRY_OF_RESIDENCE, "CountryOfResidence");
    DefaultSymbols.put(GENDER, "Gender");
    DefaultSymbols.put(PLACE_OF_BIRTH, "PlaceOfBirth");
    DefaultSymbols.put(DATE_OF_BIRTH, "DateOfBirth");
    DefaultSymbols.put(POSTAL_CODE, "PostalCode");
    DefaultSymbols.put(BUSINESS_CATEGORY, "BusinessCategory");
    DefaultSymbols.put(TELEPHONE_NUMBER, "TelephoneNumber");
    DefaultSymbols.put(NAME, "Name");
    RFC2253Symbols.put(C, "C");
    RFC2253Symbols.put(O, "O");
    RFC2253Symbols.put(OU, "OU");
    RFC2253Symbols.put(CN, "CN");
    RFC2253Symbols.put(L, "L");
    RFC2253Symbols.put(ST, "ST");
    RFC2253Symbols.put(STREET, "STREET");
    RFC2253Symbols.put(DC, "DC");
    RFC2253Symbols.put(UID, "UID");
    RFC1779Symbols.put(C, "C");
    RFC1779Symbols.put(O, "O");
    RFC1779Symbols.put(OU, "OU");
    RFC1779Symbols.put(CN, "CN");
    RFC1779Symbols.put(L, "L");
    RFC1779Symbols.put(ST, "ST");
    RFC1779Symbols.put(STREET, "STREET");
    DefaultLookUp.put("c", C);
    DefaultLookUp.put("o", O);
    DefaultLookUp.put("t", T);
    DefaultLookUp.put("ou", OU);
    DefaultLookUp.put("cn", CN);
    DefaultLookUp.put("l", L);
    DefaultLookUp.put("st", ST);
    DefaultLookUp.put("sn", SN);
    DefaultLookUp.put("serialnumber", SN);
    DefaultLookUp.put("street", STREET);
    DefaultLookUp.put("emailaddress", E);
    DefaultLookUp.put("dc", DC);
    DefaultLookUp.put("e", E);
    DefaultLookUp.put("uid", UID);
    DefaultLookUp.put("surname", SURNAME);
    DefaultLookUp.put("givenname", GIVENNAME);
    DefaultLookUp.put("initials", INITIALS);
    DefaultLookUp.put("generation", GENERATION);
    DefaultLookUp.put("unstructuredaddress", UnstructuredAddress);
    DefaultLookUp.put("unstructuredname", UnstructuredName);
    DefaultLookUp.put("uniqueidentifier", UNIQUE_IDENTIFIER);
    DefaultLookUp.put("dn", DN_QUALIFIER);
    DefaultLookUp.put("pseudonym", PSEUDONYM);
    DefaultLookUp.put("postaladdress", POSTAL_ADDRESS);
    DefaultLookUp.put("nameofbirth", NAME_AT_BIRTH);
    DefaultLookUp.put("countryofcitizenship", COUNTRY_OF_CITIZENSHIP);
    DefaultLookUp.put("countryofresidence", COUNTRY_OF_RESIDENCE);
    DefaultLookUp.put("gender", GENDER);
    DefaultLookUp.put("placeofbirth", PLACE_OF_BIRTH);
    DefaultLookUp.put("dateofbirth", DATE_OF_BIRTH);
    DefaultLookUp.put("postalcode", POSTAL_CODE);
    DefaultLookUp.put("businesscategory", BUSINESS_CATEGORY);
    DefaultLookUp.put("telephonenumber", TELEPHONE_NUMBER);
    DefaultLookUp.put("name", NAME);
  }
  
  protected X509Name() {}
  
  public X509Name(String paramString)
  {
    this(DefaultReverse, DefaultLookUp, paramString);
  }
  
  public X509Name(String paramString, X509NameEntryConverter paramX509NameEntryConverter)
  {
    this(DefaultReverse, DefaultLookUp, paramString, paramX509NameEntryConverter);
  }
  
  public X509Name(Hashtable paramHashtable)
  {
    this(null, paramHashtable);
  }
  
  public X509Name(Vector paramVector, Hashtable paramHashtable)
  {
    this(paramVector, paramHashtable, new X509DefaultEntryConverter());
  }
  
  public X509Name(Vector paramVector, Hashtable paramHashtable, X509NameEntryConverter paramX509NameEntryConverter)
  {
    this.converter = paramX509NameEntryConverter;
    int k = 0;
    int j;
    if (paramVector != null)
    {
      int i = 0;
      for (;;)
      {
        j = k;
        if (i == paramVector.size()) {
          break;
        }
        this.ordering.addElement(paramVector.elementAt(i));
        this.added.addElement(FALSE);
        i += 1;
      }
    }
    paramVector = paramHashtable.keys();
    for (;;)
    {
      j = k;
      if (!paramVector.hasMoreElements()) {
        break;
      }
      this.ordering.addElement(paramVector.nextElement());
      this.added.addElement(FALSE);
    }
    while (j != this.ordering.size())
    {
      paramVector = (ASN1ObjectIdentifier)this.ordering.elementAt(j);
      if (paramHashtable.get(paramVector) != null)
      {
        this.values.addElement(paramHashtable.get(paramVector));
        j += 1;
      }
      else
      {
        paramHashtable = new StringBuilder();
        paramHashtable.append("No attribute for object id - ");
        paramHashtable.append(paramVector.getId());
        paramHashtable.append(" - passed to distinguished name");
        throw new IllegalArgumentException(paramHashtable.toString());
      }
    }
  }
  
  public X509Name(Vector paramVector1, Vector paramVector2)
  {
    this(paramVector1, paramVector2, new X509DefaultEntryConverter());
  }
  
  public X509Name(Vector paramVector1, Vector paramVector2, X509NameEntryConverter paramX509NameEntryConverter)
  {
    this.converter = paramX509NameEntryConverter;
    if (paramVector1.size() == paramVector2.size())
    {
      int i = 0;
      while (i < paramVector1.size())
      {
        this.ordering.addElement(paramVector1.elementAt(i));
        this.values.addElement(paramVector2.elementAt(i));
        this.added.addElement(FALSE);
        i += 1;
      }
      return;
    }
    throw new IllegalArgumentException("oids vector must be same length as values.");
  }
  
  public X509Name(ASN1Sequence paramASN1Sequence)
  {
    this.seq = paramASN1Sequence;
    Enumeration localEnumeration = paramASN1Sequence.getObjects();
    ASN1Set localASN1Set;
    int i;
    if (localEnumeration.hasMoreElements())
    {
      localASN1Set = ASN1Set.getInstance(((ASN1Encodable)localEnumeration.nextElement()).toASN1Primitive());
      i = 0;
    }
    while (i < localASN1Set.size())
    {
      paramASN1Sequence = ASN1Sequence.getInstance(localASN1Set.getObjectAt(i).toASN1Primitive());
      if (paramASN1Sequence.size() != 2) {
        break label331;
      }
      this.ordering.addElement(ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0)));
      paramASN1Sequence = paramASN1Sequence.getObjectAt(1);
      Vector localVector;
      StringBuilder localStringBuilder;
      if (((paramASN1Sequence instanceof ASN1String)) && (!(paramASN1Sequence instanceof DERUniversalString)))
      {
        paramASN1Sequence = ((ASN1String)paramASN1Sequence).getString();
        if ((paramASN1Sequence.length() > 0) && (paramASN1Sequence.charAt(0) == '#'))
        {
          localVector = this.values;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("\\");
          localStringBuilder.append(paramASN1Sequence);
          paramASN1Sequence = localStringBuilder.toString();
        }
        else
        {
          localVector = this.values;
        }
        localVector.addElement(paramASN1Sequence);
      }
      try
      {
        localVector = this.values;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("#");
        localStringBuilder.append(bytesToString(Hex.encode(paramASN1Sequence.toASN1Primitive().getEncoded("DER"))));
        localVector.addElement(localStringBuilder.toString());
        localVector = this.added;
        if (i != 0) {
          paramASN1Sequence = TRUE;
        } else {
          paramASN1Sequence = FALSE;
        }
        localVector.addElement(paramASN1Sequence);
        i += 1;
      }
      catch (IOException paramASN1Sequence)
      {
        label331:
        for (;;) {}
      }
    }
    throw new IllegalArgumentException("cannot encode value");
    throw new IllegalArgumentException("badly sized pair");
  }
  
  public X509Name(boolean paramBoolean, String paramString)
  {
    this(paramBoolean, DefaultLookUp, paramString);
  }
  
  public X509Name(boolean paramBoolean, String paramString, X509NameEntryConverter paramX509NameEntryConverter)
  {
    this(paramBoolean, DefaultLookUp, paramString, paramX509NameEntryConverter);
  }
  
  public X509Name(boolean paramBoolean, Hashtable paramHashtable, String paramString)
  {
    this(paramBoolean, paramHashtable, paramString, new X509DefaultEntryConverter());
  }
  
  public X509Name(boolean paramBoolean, Hashtable paramHashtable, String paramString, X509NameEntryConverter paramX509NameEntryConverter)
  {
    this.converter = paramX509NameEntryConverter;
    X509NameTokenizer localX509NameTokenizer1 = new X509NameTokenizer(paramString);
    while (localX509NameTokenizer1.hasMoreTokens())
    {
      paramString = localX509NameTokenizer1.nextToken();
      if (paramString.indexOf('+') > 0)
      {
        X509NameTokenizer localX509NameTokenizer2 = new X509NameTokenizer(paramString, '+');
        paramX509NameEntryConverter = localX509NameTokenizer2.nextToken();
        for (paramString = FALSE;; paramString = TRUE)
        {
          addEntry(paramHashtable, paramX509NameEntryConverter, paramString);
          if (!localX509NameTokenizer2.hasMoreTokens()) {
            break;
          }
          paramX509NameEntryConverter = localX509NameTokenizer2.nextToken();
        }
      }
      addEntry(paramHashtable, paramString, FALSE);
    }
    if (paramBoolean)
    {
      paramHashtable = new Vector();
      paramString = new Vector();
      paramX509NameEntryConverter = new Vector();
      int j = 0;
      int i = 1;
      while (j < this.ordering.size())
      {
        if (((Boolean)this.added.elementAt(j)).booleanValue())
        {
          paramHashtable.insertElementAt(this.ordering.elementAt(j), i);
          paramString.insertElementAt(this.values.elementAt(j), i);
          paramX509NameEntryConverter.insertElementAt(this.added.elementAt(j), i);
          i += 1;
        }
        else
        {
          paramHashtable.insertElementAt(this.ordering.elementAt(j), 0);
          paramString.insertElementAt(this.values.elementAt(j), 0);
          paramX509NameEntryConverter.insertElementAt(this.added.elementAt(j), 0);
          i = 1;
        }
        j += 1;
      }
      this.ordering = paramHashtable;
      this.values = paramString;
      this.added = paramX509NameEntryConverter;
    }
  }
  
  private void addEntry(Hashtable paramHashtable, String paramString, Boolean paramBoolean)
  {
    Object localObject = new X509NameTokenizer(paramString, '=');
    paramString = ((X509NameTokenizer)localObject).nextToken();
    if (((X509NameTokenizer)localObject).hasMoreTokens())
    {
      localObject = ((X509NameTokenizer)localObject).nextToken();
      paramHashtable = decodeOID(paramString, paramHashtable);
      this.ordering.addElement(paramHashtable);
      this.values.addElement(unescape((String)localObject));
      this.added.addElement(paramBoolean);
      return;
    }
    throw new IllegalArgumentException("badly formatted directory string");
  }
  
  private void appendValue(StringBuffer paramStringBuffer, Hashtable paramHashtable, ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    paramHashtable = (String)paramHashtable.get(paramASN1ObjectIdentifier);
    if (paramHashtable == null) {
      paramHashtable = paramASN1ObjectIdentifier.getId();
    }
    paramStringBuffer.append(paramHashtable);
    paramStringBuffer.append('=');
    int m = paramStringBuffer.length();
    paramStringBuffer.append(paramString);
    int k = paramStringBuffer.length();
    int i = m;
    int j = k;
    if (paramString.length() >= 2)
    {
      i = m;
      j = k;
      if (paramString.charAt(0) == '\\')
      {
        i = m;
        j = k;
        if (paramString.charAt(1) == '#')
        {
          i = m + 2;
          j = k;
        }
      }
    }
    for (;;)
    {
      m = j;
      if (i >= j) {
        break;
      }
      m = j;
      if (paramStringBuffer.charAt(i) != ' ') {
        break;
      }
      paramStringBuffer.insert(i, "\\");
      i += 2;
      j += 1;
    }
    for (;;)
    {
      m -= 1;
      j = i;
      k = m;
      if (m <= i) {
        break;
      }
      j = i;
      k = m;
      if (paramStringBuffer.charAt(m) != ' ') {
        break;
      }
      paramStringBuffer.insert(m, '\\');
    }
    while (j <= k)
    {
      i = paramStringBuffer.charAt(j);
      if ((i != 34) && (i != 92) && (i != 43) && (i != 44)) {}
      switch (i)
      {
      default: 
        j += 1;
        break;
      case 59: 
      case 60: 
      case 61: 
      case 62: 
        paramStringBuffer.insert(j, "\\");
        j += 2;
        k += 1;
      }
    }
  }
  
  private String bytesToString(byte[] paramArrayOfByte)
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
  
  private String canonicalize(String paramString)
  {
    String str = Strings.toLowerCase(paramString.trim());
    paramString = str;
    if (str.length() > 0)
    {
      paramString = str;
      if (str.charAt(0) == '#')
      {
        ASN1Primitive localASN1Primitive = decodeObject(str);
        paramString = str;
        if ((localASN1Primitive instanceof ASN1String)) {
          paramString = Strings.toLowerCase(((ASN1String)localASN1Primitive).getString().trim());
        }
      }
    }
    return paramString;
  }
  
  private ASN1ObjectIdentifier decodeOID(String paramString, Hashtable paramHashtable)
  {
    paramString = paramString.trim();
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
  
  private ASN1Primitive decodeObject(String paramString)
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
  
  private boolean equivalentStrings(String paramString1, String paramString2)
  {
    paramString1 = canonicalize(paramString1);
    paramString2 = canonicalize(paramString2);
    return (paramString1.equals(paramString2)) || (stripInternalSpaces(paramString1).equals(stripInternalSpaces(paramString2)));
  }
  
  public static X509Name getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof X509Name)))
    {
      if ((paramObject instanceof X500Name)) {
        return new X509Name(ASN1Sequence.getInstance(((X500Name)paramObject).toASN1Primitive()));
      }
      if (paramObject != null) {
        return new X509Name(ASN1Sequence.getInstance(paramObject));
      }
      return null;
    }
    return (X509Name)paramObject;
  }
  
  public static X509Name getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  private String stripInternalSpaces(String paramString)
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
  
  private String unescape(String paramString)
  {
    if ((paramString.length() != 0) && ((paramString.indexOf('\\') >= 0) || (paramString.indexOf('"') >= 0)))
    {
      char[] arrayOfChar = paramString.toCharArray();
      paramString = new StringBuffer(paramString.length());
      int j;
      if ((arrayOfChar[0] == '\\') && (arrayOfChar[1] == '#'))
      {
        j = 2;
        paramString.append("\\#");
      }
      else
      {
        j = 0;
      }
      int i1 = 0;
      int m = 0;
      int i = 0;
      int n = 0;
      int k = j;
      while (k != arrayOfChar.length)
      {
        char c = arrayOfChar[k];
        if (c != ' ') {
          n = 1;
        }
        if (c == '"')
        {
          if (i1 == 0)
          {
            i ^= 0x1;
            break label193;
          }
        }
        else
        {
          if ((c == '\\') && (i1 == 0) && (i == 0))
          {
            m = paramString.length();
            j = 1;
            break label196;
          }
          if ((c == ' ') && (i1 == 0) && (n == 0))
          {
            j = i1;
            break label196;
          }
        }
        paramString.append(c);
        label193:
        j = 0;
        label196:
        k += 1;
        i1 = j;
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
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((!(paramObject instanceof X509Name)) && (!(paramObject instanceof ASN1Sequence))) {
      return false;
    }
    Object localObject = ((ASN1Encodable)paramObject).toASN1Primitive();
    if (toASN1Primitive().equals(localObject)) {
      return true;
    }
    try
    {
      paramObject = getInstance(paramObject);
      int n = this.ordering.size();
      if (n != ((X509Name)paramObject).ordering.size()) {
        return false;
      }
      localObject = new boolean[n];
      boolean bool = this.ordering.elementAt(0).equals(((X509Name)paramObject).ordering.elementAt(0));
      int j = -1;
      int i;
      int k;
      if (bool)
      {
        j = n;
        i = 0;
        k = 1;
      }
      else
      {
        i = n - 1;
        k = -1;
      }
      while (i != j)
      {
        ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)this.ordering.elementAt(i);
        String str = (String)this.values.elementAt(i);
        int m = 0;
        while (m < n)
        {
          if ((localObject[m] == 0) && (localASN1ObjectIdentifier.equals((ASN1ObjectIdentifier)((X509Name)paramObject).ordering.elementAt(m))) && (equivalentStrings(str, (String)((X509Name)paramObject).values.elementAt(m))))
          {
            localObject[m] = 1;
            m = 1;
            break label246;
          }
          m += 1;
        }
        m = 0;
        label246:
        if (m == 0) {
          return false;
        }
        i += k;
      }
      return true;
    }
    catch (IllegalArgumentException paramObject) {}
    return false;
  }
  
  public boolean equals(Object paramObject, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return equals(paramObject);
    }
    if (paramObject == this) {
      return true;
    }
    if ((!(paramObject instanceof X509Name)) && (!(paramObject instanceof ASN1Sequence))) {
      return false;
    }
    ASN1Primitive localASN1Primitive = ((ASN1Encodable)paramObject).toASN1Primitive();
    if (toASN1Primitive().equals(localASN1Primitive)) {
      return true;
    }
    try
    {
      paramObject = getInstance(paramObject);
      int j = this.ordering.size();
      if (j != ((X509Name)paramObject).ordering.size()) {
        return false;
      }
      int i = 0;
      while (i < j) {
        if (((ASN1ObjectIdentifier)this.ordering.elementAt(i)).equals((ASN1ObjectIdentifier)((X509Name)paramObject).ordering.elementAt(i)))
        {
          if (!equivalentStrings((String)this.values.elementAt(i), (String)((X509Name)paramObject).values.elementAt(i))) {
            return false;
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    catch (IllegalArgumentException paramObject) {}
    return false;
  }
  
  public Vector getOIDs()
  {
    Vector localVector = new Vector();
    int i = 0;
    while (i != this.ordering.size())
    {
      localVector.addElement(this.ordering.elementAt(i));
      i += 1;
    }
    return localVector;
  }
  
  public Vector getValues()
  {
    Vector localVector = new Vector();
    int i = 0;
    while (i != this.values.size())
    {
      localVector.addElement(this.values.elementAt(i));
      i += 1;
    }
    return localVector;
  }
  
  public Vector getValues(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Vector localVector = new Vector();
    int i = 0;
    while (i != this.values.size())
    {
      if (this.ordering.elementAt(i).equals(paramASN1ObjectIdentifier))
      {
        String str2 = (String)this.values.elementAt(i);
        String str1 = str2;
        if (str2.length() > 2)
        {
          str1 = str2;
          if (str2.charAt(0) == '\\')
          {
            str1 = str2;
            if (str2.charAt(1) == '#') {
              str1 = str2.substring(1);
            }
          }
        }
        localVector.addElement(str1);
      }
      i += 1;
    }
    return localVector;
  }
  
  public int hashCode()
  {
    if (this.isHashCodeCalculated) {
      return this.hashCodeValue;
    }
    this.isHashCodeCalculated = true;
    int i = 0;
    while (i != this.ordering.size())
    {
      String str = stripInternalSpaces(canonicalize((String)this.values.elementAt(i)));
      int j = this.hashCodeValue ^ this.ordering.elementAt(i).hashCode();
      this.hashCodeValue = j;
      this.hashCodeValue = (str.hashCode() ^ j);
      i += 1;
    }
    return this.hashCodeValue;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    if (this.seq == null)
    {
      ASN1EncodableVector localASN1EncodableVector2 = new ASN1EncodableVector();
      ASN1EncodableVector localASN1EncodableVector1 = new ASN1EncodableVector();
      Object localObject = null;
      int i = 0;
      while (i != this.ordering.size())
      {
        ASN1EncodableVector localASN1EncodableVector3 = new ASN1EncodableVector();
        ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)this.ordering.elementAt(i);
        localASN1EncodableVector3.add(localASN1ObjectIdentifier);
        String str = (String)this.values.elementAt(i);
        localASN1EncodableVector3.add(this.converter.getConvertedValue(localASN1ObjectIdentifier, str));
        if ((localObject != null) && (!((Boolean)this.added.elementAt(i)).booleanValue()))
        {
          localASN1EncodableVector2.add(new DERSet(localASN1EncodableVector1));
          localASN1EncodableVector1 = new ASN1EncodableVector();
          localObject = new DERSequence(localASN1EncodableVector3);
        }
        else
        {
          localObject = new DERSequence(localASN1EncodableVector3);
        }
        localASN1EncodableVector1.add((ASN1Encodable)localObject);
        i += 1;
        localObject = localASN1ObjectIdentifier;
      }
      localASN1EncodableVector2.add(new DERSet(localASN1EncodableVector1));
      this.seq = new DERSequence(localASN1EncodableVector2);
    }
    return this.seq;
  }
  
  public String toString()
  {
    return toString(DefaultReverse, DefaultSymbols);
  }
  
  public String toString(boolean paramBoolean, Hashtable paramHashtable)
  {
    StringBuffer localStringBuffer2 = new StringBuffer();
    Vector localVector = new Vector();
    StringBuffer localStringBuffer1 = null;
    int i = 0;
    while (i < this.ordering.size())
    {
      if (((Boolean)this.added.elementAt(i)).booleanValue())
      {
        localStringBuffer1.append('+');
        appendValue(localStringBuffer1, paramHashtable, (ASN1ObjectIdentifier)this.ordering.elementAt(i), (String)this.values.elementAt(i));
      }
      else
      {
        localStringBuffer1 = new StringBuffer();
        appendValue(localStringBuffer1, paramHashtable, (ASN1ObjectIdentifier)this.ordering.elementAt(i), (String)this.values.elementAt(i));
        localVector.addElement(localStringBuffer1);
      }
      i += 1;
    }
    int k = 1;
    int j = 1;
    if (paramBoolean)
    {
      i = localVector.size() - 1;
      while (i >= 0)
      {
        if (j != 0) {
          j = 0;
        } else {
          localStringBuffer2.append(',');
        }
        localStringBuffer2.append(localVector.elementAt(i).toString());
        i -= 1;
      }
    }
    i = 0;
    j = k;
    while (i < localVector.size())
    {
      if (j != 0) {
        j = 0;
      } else {
        localStringBuffer2.append(',');
      }
      localStringBuffer2.append(localVector.elementAt(i).toString());
      i += 1;
    }
    return localStringBuffer2.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\X509Name.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */