package org.bouncycastle.asn1.x500.style;

import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;

public class BCStyle
  extends AbstractX500NameStyle
{
  public static final ASN1ObjectIdentifier BUSINESS_CATEGORY;
  public static final ASN1ObjectIdentifier C = new ASN1ObjectIdentifier("2.5.4.6").intern();
  public static final ASN1ObjectIdentifier CN;
  public static final ASN1ObjectIdentifier COUNTRY_OF_CITIZENSHIP;
  public static final ASN1ObjectIdentifier COUNTRY_OF_RESIDENCE;
  public static final ASN1ObjectIdentifier DATE_OF_BIRTH;
  public static final ASN1ObjectIdentifier DC;
  public static final ASN1ObjectIdentifier DMD_NAME;
  public static final ASN1ObjectIdentifier DN_QUALIFIER;
  private static final Hashtable DefaultLookUp;
  private static final Hashtable DefaultSymbols;
  public static final ASN1ObjectIdentifier E;
  public static final ASN1ObjectIdentifier EmailAddress;
  public static final ASN1ObjectIdentifier GENDER;
  public static final ASN1ObjectIdentifier GENERATION;
  public static final ASN1ObjectIdentifier GIVENNAME;
  public static final ASN1ObjectIdentifier INITIALS;
  public static final X500NameStyle INSTANCE = new BCStyle();
  public static final ASN1ObjectIdentifier L;
  public static final ASN1ObjectIdentifier NAME;
  public static final ASN1ObjectIdentifier NAME_AT_BIRTH;
  public static final ASN1ObjectIdentifier O = new ASN1ObjectIdentifier("2.5.4.10").intern();
  public static final ASN1ObjectIdentifier OU = new ASN1ObjectIdentifier("2.5.4.11").intern();
  public static final ASN1ObjectIdentifier PLACE_OF_BIRTH;
  public static final ASN1ObjectIdentifier POSTAL_ADDRESS;
  public static final ASN1ObjectIdentifier POSTAL_CODE;
  public static final ASN1ObjectIdentifier PSEUDONYM;
  public static final ASN1ObjectIdentifier SERIALNUMBER;
  public static final ASN1ObjectIdentifier SN;
  public static final ASN1ObjectIdentifier ST;
  public static final ASN1ObjectIdentifier STREET;
  public static final ASN1ObjectIdentifier SURNAME;
  public static final ASN1ObjectIdentifier T = new ASN1ObjectIdentifier("2.5.4.12").intern();
  public static final ASN1ObjectIdentifier TELEPHONE_NUMBER;
  public static final ASN1ObjectIdentifier UID;
  public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER;
  public static final ASN1ObjectIdentifier UnstructuredAddress;
  public static final ASN1ObjectIdentifier UnstructuredName;
  protected final Hashtable defaultLookUp = copyHashTable(DefaultLookUp);
  protected final Hashtable defaultSymbols = copyHashTable(DefaultSymbols);
  
  static
  {
    CN = new ASN1ObjectIdentifier("2.5.4.3").intern();
    SN = new ASN1ObjectIdentifier("2.5.4.5").intern();
    STREET = new ASN1ObjectIdentifier("2.5.4.9").intern();
    SERIALNUMBER = SN;
    L = new ASN1ObjectIdentifier("2.5.4.7").intern();
    ST = new ASN1ObjectIdentifier("2.5.4.8").intern();
    SURNAME = new ASN1ObjectIdentifier("2.5.4.4").intern();
    GIVENNAME = new ASN1ObjectIdentifier("2.5.4.42").intern();
    INITIALS = new ASN1ObjectIdentifier("2.5.4.43").intern();
    GENERATION = new ASN1ObjectIdentifier("2.5.4.44").intern();
    UNIQUE_IDENTIFIER = new ASN1ObjectIdentifier("2.5.4.45").intern();
    BUSINESS_CATEGORY = new ASN1ObjectIdentifier("2.5.4.15").intern();
    POSTAL_CODE = new ASN1ObjectIdentifier("2.5.4.17").intern();
    DN_QUALIFIER = new ASN1ObjectIdentifier("2.5.4.46").intern();
    PSEUDONYM = new ASN1ObjectIdentifier("2.5.4.65").intern();
    DATE_OF_BIRTH = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.1").intern();
    PLACE_OF_BIRTH = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.2").intern();
    GENDER = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.3").intern();
    COUNTRY_OF_CITIZENSHIP = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.4").intern();
    COUNTRY_OF_RESIDENCE = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.5").intern();
    NAME_AT_BIRTH = new ASN1ObjectIdentifier("1.3.36.8.3.14").intern();
    POSTAL_ADDRESS = new ASN1ObjectIdentifier("2.5.4.16").intern();
    DMD_NAME = new ASN1ObjectIdentifier("2.5.4.54").intern();
    TELEPHONE_NUMBER = X509ObjectIdentifiers.id_at_telephoneNumber;
    NAME = X509ObjectIdentifiers.id_at_name;
    EmailAddress = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
    UnstructuredName = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
    UnstructuredAddress = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
    E = EmailAddress;
    DC = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
    UID = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
    DefaultSymbols = new Hashtable();
    DefaultLookUp = new Hashtable();
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
  
  public ASN1ObjectIdentifier attrNameToOID(String paramString)
  {
    return IETFUtils.decodeAttrName(paramString, this.defaultLookUp);
  }
  
  protected ASN1Encodable encodeStringValue(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    if ((!paramASN1ObjectIdentifier.equals(EmailAddress)) && (!paramASN1ObjectIdentifier.equals(DC)))
    {
      if (paramASN1ObjectIdentifier.equals(DATE_OF_BIRTH)) {
        return new ASN1GeneralizedTime(paramString);
      }
      if ((!paramASN1ObjectIdentifier.equals(C)) && (!paramASN1ObjectIdentifier.equals(SN)) && (!paramASN1ObjectIdentifier.equals(DN_QUALIFIER)) && (!paramASN1ObjectIdentifier.equals(TELEPHONE_NUMBER))) {
        return super.encodeStringValue(paramASN1ObjectIdentifier, paramString);
      }
      return new DERPrintableString(paramString);
    }
    return new DERIA5String(paramString);
  }
  
  public RDN[] fromString(String paramString)
  {
    return IETFUtils.rDNsFromString(paramString, this);
  }
  
  public String[] oidToAttrNames(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return IETFUtils.findAttrNamesForOID(paramASN1ObjectIdentifier, this.defaultLookUp);
  }
  
  public String oidToDisplayName(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return (String)DefaultSymbols.get(paramASN1ObjectIdentifier);
  }
  
  public String toString(X500Name paramX500Name)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramX500Name = paramX500Name.getRDNs();
    int j = 1;
    int i = 0;
    while (i < paramX500Name.length)
    {
      if (j != 0) {
        j = 0;
      } else {
        localStringBuffer.append(',');
      }
      IETFUtils.appendRDN(localStringBuffer, paramX500Name[i], this.defaultSymbols);
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\x500\style\BCStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */