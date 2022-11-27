package org.bouncycastle.asn1.x509.sigi;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.DirectoryString;

public class NameOrPseudonym
  extends ASN1Object
  implements ASN1Choice
{
  private ASN1Sequence givenName;
  private DirectoryString pseudonym;
  private DirectoryString surname;
  
  public NameOrPseudonym(String paramString)
  {
    this(new DirectoryString(paramString));
  }
  
  private NameOrPseudonym(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      if ((paramASN1Sequence.getObjectAt(0) instanceof ASN1String))
      {
        this.surname = DirectoryString.getInstance(paramASN1Sequence.getObjectAt(0));
        this.givenName = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(1));
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Bad object encountered: ");
      localStringBuilder.append(paramASN1Sequence.getObjectAt(0).getClass());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public NameOrPseudonym(DirectoryString paramDirectoryString)
  {
    this.pseudonym = paramDirectoryString;
  }
  
  public NameOrPseudonym(DirectoryString paramDirectoryString, ASN1Sequence paramASN1Sequence)
  {
    this.surname = paramDirectoryString;
    this.givenName = paramASN1Sequence;
  }
  
  public static NameOrPseudonym getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof NameOrPseudonym)))
    {
      if ((paramObject instanceof ASN1String)) {
        return new NameOrPseudonym(DirectoryString.getInstance(paramObject));
      }
      if ((paramObject instanceof ASN1Sequence)) {
        return new NameOrPseudonym((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (NameOrPseudonym)paramObject;
  }
  
  public DirectoryString[] getGivenName()
  {
    DirectoryString[] arrayOfDirectoryString = new DirectoryString[this.givenName.size()];
    Enumeration localEnumeration = this.givenName.getObjects();
    int i = 0;
    while (localEnumeration.hasMoreElements())
    {
      arrayOfDirectoryString[i] = DirectoryString.getInstance(localEnumeration.nextElement());
      i += 1;
    }
    return arrayOfDirectoryString;
  }
  
  public DirectoryString getPseudonym()
  {
    return this.pseudonym;
  }
  
  public DirectoryString getSurname()
  {
    return this.surname;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    Object localObject = this.pseudonym;
    if (localObject != null) {
      return ((DirectoryString)localObject).toASN1Primitive();
    }
    localObject = new ASN1EncodableVector();
    ((ASN1EncodableVector)localObject).add(this.surname);
    ((ASN1EncodableVector)localObject).add(this.givenName);
    return new DERSequence((ASN1EncodableVector)localObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\sigi\NameOrPseudonym.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */