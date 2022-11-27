package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.DirectoryString;

public class ProfessionInfo
  extends ASN1Object
{
  public static final ASN1ObjectIdentifier Notar;
  public static final ASN1ObjectIdentifier Notariatsverwalter;
  public static final ASN1ObjectIdentifier Notariatsverwalterin;
  public static final ASN1ObjectIdentifier Notarin;
  public static final ASN1ObjectIdentifier Notarvertreter;
  public static final ASN1ObjectIdentifier Notarvertreterin;
  public static final ASN1ObjectIdentifier Patentanwalt;
  public static final ASN1ObjectIdentifier Patentanwltin;
  public static final ASN1ObjectIdentifier Rechtsanwalt;
  public static final ASN1ObjectIdentifier Rechtsanwltin;
  public static final ASN1ObjectIdentifier Rechtsbeistand;
  public static final ASN1ObjectIdentifier Steuerberater;
  public static final ASN1ObjectIdentifier Steuerberaterin;
  public static final ASN1ObjectIdentifier Steuerbevollmchtigte;
  public static final ASN1ObjectIdentifier Steuerbevollmchtigter;
  public static final ASN1ObjectIdentifier VereidigteBuchprferin;
  public static final ASN1ObjectIdentifier VereidigterBuchprfer;
  public static final ASN1ObjectIdentifier Wirtschaftsprfer;
  public static final ASN1ObjectIdentifier Wirtschaftsprferin;
  private ASN1OctetString addProfessionInfo;
  private NamingAuthority namingAuthority;
  private ASN1Sequence professionItems;
  private ASN1Sequence professionOIDs;
  private String registrationNumber;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".1");
    Rechtsanwltin = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".2");
    Rechtsanwalt = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".3");
    Rechtsbeistand = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".4");
    Steuerberaterin = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".5");
    Steuerberater = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".6");
    Steuerbevollmchtigte = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".7");
    Steuerbevollmchtigter = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".8");
    Notarin = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".9");
    Notar = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".10");
    Notarvertreterin = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".11");
    Notarvertreter = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".12");
    Notariatsverwalterin = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".13");
    Notariatsverwalter = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".14");
    Wirtschaftsprferin = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".15");
    Wirtschaftsprfer = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".16");
    VereidigteBuchprferin = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".17");
    VereidigterBuchprfer = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".18");
    Patentanwltin = new ASN1ObjectIdentifier(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern);
    localStringBuilder.append(".19");
    Patentanwalt = new ASN1ObjectIdentifier(localStringBuilder.toString());
  }
  
  private ProfessionInfo(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() <= 5)
    {
      Enumeration localEnumeration = paramASN1Sequence.getObjects();
      localObject = (ASN1Encodable)localEnumeration.nextElement();
      paramASN1Sequence = (ASN1Sequence)localObject;
      if ((localObject instanceof ASN1TaggedObject))
      {
        paramASN1Sequence = (ASN1TaggedObject)localObject;
        if (paramASN1Sequence.getTagNo() == 0)
        {
          this.namingAuthority = NamingAuthority.getInstance(paramASN1Sequence, true);
          paramASN1Sequence = (ASN1Encodable)localEnumeration.nextElement();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Bad tag number: ");
          ((StringBuilder)localObject).append(paramASN1Sequence.getTagNo());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      this.professionItems = ASN1Sequence.getInstance(paramASN1Sequence);
      if (localEnumeration.hasMoreElements())
      {
        paramASN1Sequence = (ASN1Encodable)localEnumeration.nextElement();
        if ((paramASN1Sequence instanceof ASN1Sequence))
        {
          this.professionOIDs = ASN1Sequence.getInstance(paramASN1Sequence);
        }
        else if ((paramASN1Sequence instanceof DERPrintableString))
        {
          this.registrationNumber = DERPrintableString.getInstance(paramASN1Sequence).getString();
        }
        else if ((paramASN1Sequence instanceof ASN1OctetString))
        {
          this.addProfessionInfo = ASN1OctetString.getInstance(paramASN1Sequence);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Bad object encountered: ");
          ((StringBuilder)localObject).append(paramASN1Sequence.getClass());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      if (localEnumeration.hasMoreElements())
      {
        paramASN1Sequence = (ASN1Encodable)localEnumeration.nextElement();
        if ((paramASN1Sequence instanceof DERPrintableString))
        {
          this.registrationNumber = DERPrintableString.getInstance(paramASN1Sequence).getString();
        }
        else if ((paramASN1Sequence instanceof DEROctetString))
        {
          this.addProfessionInfo = ((DEROctetString)paramASN1Sequence);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Bad object encountered: ");
          ((StringBuilder)localObject).append(paramASN1Sequence.getClass());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      if (localEnumeration.hasMoreElements())
      {
        paramASN1Sequence = (ASN1Encodable)localEnumeration.nextElement();
        if ((paramASN1Sequence instanceof DEROctetString))
        {
          this.addProfessionInfo = ((DEROctetString)paramASN1Sequence);
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Bad object encountered: ");
        ((StringBuilder)localObject).append(paramASN1Sequence.getClass());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramASN1Sequence.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public ProfessionInfo(NamingAuthority paramNamingAuthority, DirectoryString[] paramArrayOfDirectoryString, ASN1ObjectIdentifier[] paramArrayOfASN1ObjectIdentifier, String paramString, ASN1OctetString paramASN1OctetString)
  {
    this.namingAuthority = paramNamingAuthority;
    paramNamingAuthority = new ASN1EncodableVector();
    int j = 0;
    int i = 0;
    while (i != paramArrayOfDirectoryString.length)
    {
      paramNamingAuthority.add(paramArrayOfDirectoryString[i]);
      i += 1;
    }
    this.professionItems = new DERSequence(paramNamingAuthority);
    if (paramArrayOfASN1ObjectIdentifier != null)
    {
      paramNamingAuthority = new ASN1EncodableVector();
      i = j;
      while (i != paramArrayOfASN1ObjectIdentifier.length)
      {
        paramNamingAuthority.add(paramArrayOfASN1ObjectIdentifier[i]);
        i += 1;
      }
      this.professionOIDs = new DERSequence(paramNamingAuthority);
    }
    this.registrationNumber = paramString;
    this.addProfessionInfo = paramASN1OctetString;
  }
  
  public static ProfessionInfo getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ProfessionInfo)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new ProfessionInfo((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (ProfessionInfo)paramObject;
  }
  
  public ASN1OctetString getAddProfessionInfo()
  {
    return this.addProfessionInfo;
  }
  
  public NamingAuthority getNamingAuthority()
  {
    return this.namingAuthority;
  }
  
  public DirectoryString[] getProfessionItems()
  {
    DirectoryString[] arrayOfDirectoryString = new DirectoryString[this.professionItems.size()];
    Enumeration localEnumeration = this.professionItems.getObjects();
    int i = 0;
    while (localEnumeration.hasMoreElements())
    {
      arrayOfDirectoryString[i] = DirectoryString.getInstance(localEnumeration.nextElement());
      i += 1;
    }
    return arrayOfDirectoryString;
  }
  
  public ASN1ObjectIdentifier[] getProfessionOIDs()
  {
    Object localObject = this.professionOIDs;
    int i = 0;
    if (localObject == null) {
      return new ASN1ObjectIdentifier[0];
    }
    localObject = new ASN1ObjectIdentifier[((ASN1Sequence)localObject).size()];
    Enumeration localEnumeration = this.professionOIDs.getObjects();
    while (localEnumeration.hasMoreElements())
    {
      localObject[i] = ASN1ObjectIdentifier.getInstance(localEnumeration.nextElement());
      i += 1;
    }
    return (ASN1ObjectIdentifier[])localObject;
  }
  
  public String getRegistrationNumber()
  {
    return this.registrationNumber;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.namingAuthority;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, (ASN1Encodable)localObject));
    }
    localASN1EncodableVector.add(this.professionItems);
    localObject = this.professionOIDs;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.registrationNumber;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERPrintableString((String)localObject, true));
    }
    localObject = this.addProfessionInfo;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\isismtt\x509\ProfessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */