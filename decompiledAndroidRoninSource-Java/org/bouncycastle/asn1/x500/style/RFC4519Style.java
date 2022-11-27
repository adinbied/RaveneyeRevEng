package org.bouncycastle.asn1.x500.style;

import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;

public class RFC4519Style
  extends AbstractX500NameStyle
{
  private static final Hashtable DefaultLookUp;
  private static final Hashtable DefaultSymbols;
  public static final X500NameStyle INSTANCE = new RFC4519Style();
  public static final ASN1ObjectIdentifier businessCategory = new ASN1ObjectIdentifier("2.5.4.15").intern();
  public static final ASN1ObjectIdentifier c = new ASN1ObjectIdentifier("2.5.4.6").intern();
  public static final ASN1ObjectIdentifier cn = new ASN1ObjectIdentifier("2.5.4.3").intern();
  public static final ASN1ObjectIdentifier dc = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25").intern();
  public static final ASN1ObjectIdentifier description = new ASN1ObjectIdentifier("2.5.4.13").intern();
  public static final ASN1ObjectIdentifier destinationIndicator = new ASN1ObjectIdentifier("2.5.4.27").intern();
  public static final ASN1ObjectIdentifier distinguishedName = new ASN1ObjectIdentifier("2.5.4.49").intern();
  public static final ASN1ObjectIdentifier dnQualifier = new ASN1ObjectIdentifier("2.5.4.46").intern();
  public static final ASN1ObjectIdentifier enhancedSearchGuide = new ASN1ObjectIdentifier("2.5.4.47").intern();
  public static final ASN1ObjectIdentifier facsimileTelephoneNumber = new ASN1ObjectIdentifier("2.5.4.23").intern();
  public static final ASN1ObjectIdentifier generationQualifier = new ASN1ObjectIdentifier("2.5.4.44").intern();
  public static final ASN1ObjectIdentifier givenName = new ASN1ObjectIdentifier("2.5.4.42").intern();
  public static final ASN1ObjectIdentifier houseIdentifier = new ASN1ObjectIdentifier("2.5.4.51").intern();
  public static final ASN1ObjectIdentifier initials = new ASN1ObjectIdentifier("2.5.4.43").intern();
  public static final ASN1ObjectIdentifier internationalISDNNumber = new ASN1ObjectIdentifier("2.5.4.25").intern();
  public static final ASN1ObjectIdentifier l = new ASN1ObjectIdentifier("2.5.4.7").intern();
  public static final ASN1ObjectIdentifier member = new ASN1ObjectIdentifier("2.5.4.31").intern();
  public static final ASN1ObjectIdentifier name = new ASN1ObjectIdentifier("2.5.4.41").intern();
  public static final ASN1ObjectIdentifier o = new ASN1ObjectIdentifier("2.5.4.10").intern();
  public static final ASN1ObjectIdentifier ou = new ASN1ObjectIdentifier("2.5.4.11").intern();
  public static final ASN1ObjectIdentifier owner = new ASN1ObjectIdentifier("2.5.4.32").intern();
  public static final ASN1ObjectIdentifier physicalDeliveryOfficeName = new ASN1ObjectIdentifier("2.5.4.19").intern();
  public static final ASN1ObjectIdentifier postOfficeBox;
  public static final ASN1ObjectIdentifier postalAddress = new ASN1ObjectIdentifier("2.5.4.16").intern();
  public static final ASN1ObjectIdentifier postalCode = new ASN1ObjectIdentifier("2.5.4.17").intern();
  public static final ASN1ObjectIdentifier preferredDeliveryMethod;
  public static final ASN1ObjectIdentifier registeredAddress;
  public static final ASN1ObjectIdentifier roleOccupant;
  public static final ASN1ObjectIdentifier searchGuide;
  public static final ASN1ObjectIdentifier seeAlso;
  public static final ASN1ObjectIdentifier serialNumber;
  public static final ASN1ObjectIdentifier sn;
  public static final ASN1ObjectIdentifier st;
  public static final ASN1ObjectIdentifier street;
  public static final ASN1ObjectIdentifier telephoneNumber;
  public static final ASN1ObjectIdentifier teletexTerminalIdentifier;
  public static final ASN1ObjectIdentifier telexNumber;
  public static final ASN1ObjectIdentifier title;
  public static final ASN1ObjectIdentifier uid;
  public static final ASN1ObjectIdentifier uniqueMember;
  public static final ASN1ObjectIdentifier userPassword;
  public static final ASN1ObjectIdentifier x121Address;
  public static final ASN1ObjectIdentifier x500UniqueIdentifier;
  protected final Hashtable defaultLookUp = copyHashTable(DefaultLookUp);
  protected final Hashtable defaultSymbols = copyHashTable(DefaultSymbols);
  
  static
  {
    postOfficeBox = new ASN1ObjectIdentifier("2.5.4.18").intern();
    preferredDeliveryMethod = new ASN1ObjectIdentifier("2.5.4.28").intern();
    registeredAddress = new ASN1ObjectIdentifier("2.5.4.26").intern();
    roleOccupant = new ASN1ObjectIdentifier("2.5.4.33").intern();
    searchGuide = new ASN1ObjectIdentifier("2.5.4.14").intern();
    seeAlso = new ASN1ObjectIdentifier("2.5.4.34").intern();
    serialNumber = new ASN1ObjectIdentifier("2.5.4.5").intern();
    sn = new ASN1ObjectIdentifier("2.5.4.4").intern();
    st = new ASN1ObjectIdentifier("2.5.4.8").intern();
    street = new ASN1ObjectIdentifier("2.5.4.9").intern();
    telephoneNumber = new ASN1ObjectIdentifier("2.5.4.20").intern();
    teletexTerminalIdentifier = new ASN1ObjectIdentifier("2.5.4.22").intern();
    telexNumber = new ASN1ObjectIdentifier("2.5.4.21").intern();
    title = new ASN1ObjectIdentifier("2.5.4.12").intern();
    uid = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1").intern();
    uniqueMember = new ASN1ObjectIdentifier("2.5.4.50").intern();
    userPassword = new ASN1ObjectIdentifier("2.5.4.35").intern();
    x121Address = new ASN1ObjectIdentifier("2.5.4.24").intern();
    x500UniqueIdentifier = new ASN1ObjectIdentifier("2.5.4.45").intern();
    DefaultSymbols = new Hashtable();
    DefaultLookUp = new Hashtable();
    DefaultSymbols.put(businessCategory, "businessCategory");
    DefaultSymbols.put(c, "c");
    DefaultSymbols.put(cn, "cn");
    DefaultSymbols.put(dc, "dc");
    DefaultSymbols.put(description, "description");
    DefaultSymbols.put(destinationIndicator, "destinationIndicator");
    DefaultSymbols.put(distinguishedName, "distinguishedName");
    DefaultSymbols.put(dnQualifier, "dnQualifier");
    DefaultSymbols.put(enhancedSearchGuide, "enhancedSearchGuide");
    DefaultSymbols.put(facsimileTelephoneNumber, "facsimileTelephoneNumber");
    DefaultSymbols.put(generationQualifier, "generationQualifier");
    DefaultSymbols.put(givenName, "givenName");
    DefaultSymbols.put(houseIdentifier, "houseIdentifier");
    DefaultSymbols.put(initials, "initials");
    DefaultSymbols.put(internationalISDNNumber, "internationalISDNNumber");
    DefaultSymbols.put(l, "l");
    DefaultSymbols.put(member, "member");
    DefaultSymbols.put(name, "name");
    DefaultSymbols.put(o, "o");
    DefaultSymbols.put(ou, "ou");
    DefaultSymbols.put(owner, "owner");
    DefaultSymbols.put(physicalDeliveryOfficeName, "physicalDeliveryOfficeName");
    DefaultSymbols.put(postalAddress, "postalAddress");
    DefaultSymbols.put(postalCode, "postalCode");
    DefaultSymbols.put(postOfficeBox, "postOfficeBox");
    DefaultSymbols.put(preferredDeliveryMethod, "preferredDeliveryMethod");
    DefaultSymbols.put(registeredAddress, "registeredAddress");
    DefaultSymbols.put(roleOccupant, "roleOccupant");
    DefaultSymbols.put(searchGuide, "searchGuide");
    DefaultSymbols.put(seeAlso, "seeAlso");
    DefaultSymbols.put(serialNumber, "serialNumber");
    DefaultSymbols.put(sn, "sn");
    DefaultSymbols.put(st, "st");
    DefaultSymbols.put(street, "street");
    DefaultSymbols.put(telephoneNumber, "telephoneNumber");
    DefaultSymbols.put(teletexTerminalIdentifier, "teletexTerminalIdentifier");
    DefaultSymbols.put(telexNumber, "telexNumber");
    DefaultSymbols.put(title, "title");
    DefaultSymbols.put(uid, "uid");
    DefaultSymbols.put(uniqueMember, "uniqueMember");
    DefaultSymbols.put(userPassword, "userPassword");
    DefaultSymbols.put(x121Address, "x121Address");
    DefaultSymbols.put(x500UniqueIdentifier, "x500UniqueIdentifier");
    DefaultLookUp.put("businesscategory", businessCategory);
    DefaultLookUp.put("c", c);
    DefaultLookUp.put("cn", cn);
    DefaultLookUp.put("dc", dc);
    DefaultLookUp.put("description", description);
    DefaultLookUp.put("destinationindicator", destinationIndicator);
    DefaultLookUp.put("distinguishedname", distinguishedName);
    DefaultLookUp.put("dnqualifier", dnQualifier);
    DefaultLookUp.put("enhancedsearchguide", enhancedSearchGuide);
    DefaultLookUp.put("facsimiletelephonenumber", facsimileTelephoneNumber);
    DefaultLookUp.put("generationqualifier", generationQualifier);
    DefaultLookUp.put("givenname", givenName);
    DefaultLookUp.put("houseidentifier", houseIdentifier);
    DefaultLookUp.put("initials", initials);
    DefaultLookUp.put("internationalisdnnumber", internationalISDNNumber);
    DefaultLookUp.put("l", l);
    DefaultLookUp.put("member", member);
    DefaultLookUp.put("name", name);
    DefaultLookUp.put("o", o);
    DefaultLookUp.put("ou", ou);
    DefaultLookUp.put("owner", owner);
    DefaultLookUp.put("physicaldeliveryofficename", physicalDeliveryOfficeName);
    DefaultLookUp.put("postaladdress", postalAddress);
    DefaultLookUp.put("postalcode", postalCode);
    DefaultLookUp.put("postofficebox", postOfficeBox);
    DefaultLookUp.put("preferreddeliverymethod", preferredDeliveryMethod);
    DefaultLookUp.put("registeredaddress", registeredAddress);
    DefaultLookUp.put("roleoccupant", roleOccupant);
    DefaultLookUp.put("searchguide", searchGuide);
    DefaultLookUp.put("seealso", seeAlso);
    DefaultLookUp.put("serialnumber", serialNumber);
    DefaultLookUp.put("sn", sn);
    DefaultLookUp.put("st", st);
    DefaultLookUp.put("street", street);
    DefaultLookUp.put("telephonenumber", telephoneNumber);
    DefaultLookUp.put("teletexterminalidentifier", teletexTerminalIdentifier);
    DefaultLookUp.put("telexnumber", telexNumber);
    DefaultLookUp.put("title", title);
    DefaultLookUp.put("uid", uid);
    DefaultLookUp.put("uniquemember", uniqueMember);
    DefaultLookUp.put("userpassword", userPassword);
    DefaultLookUp.put("x121address", x121Address);
    DefaultLookUp.put("x500uniqueidentifier", x500UniqueIdentifier);
  }
  
  public ASN1ObjectIdentifier attrNameToOID(String paramString)
  {
    return IETFUtils.decodeAttrName(paramString, this.defaultLookUp);
  }
  
  protected ASN1Encodable encodeStringValue(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    if (paramASN1ObjectIdentifier.equals(dc)) {
      return new DERIA5String(paramString);
    }
    if ((!paramASN1ObjectIdentifier.equals(c)) && (!paramASN1ObjectIdentifier.equals(serialNumber)) && (!paramASN1ObjectIdentifier.equals(dnQualifier)) && (!paramASN1ObjectIdentifier.equals(telephoneNumber))) {
      return super.encodeStringValue(paramASN1ObjectIdentifier, paramString);
    }
    return new DERPrintableString(paramString);
  }
  
  public RDN[] fromString(String paramString)
  {
    paramString = IETFUtils.rDNsFromString(paramString, this);
    int j = paramString.length;
    RDN[] arrayOfRDN = new RDN[j];
    int i = 0;
    while (i != paramString.length)
    {
      arrayOfRDN[(j - i - 1)] = paramString[i];
      i += 1;
    }
    return arrayOfRDN;
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
    int i = paramX500Name.length;
    int j = 1;
    i -= 1;
    while (i >= 0)
    {
      if (j != 0) {
        j = 0;
      } else {
        localStringBuffer.append(',');
      }
      IETFUtils.appendRDN(localStringBuffer, paramX500Name[i], this.defaultSymbols);
      i -= 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\x500\style\RFC4519Style.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */