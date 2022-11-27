package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.isismtt.ISISMTTObjectIdentifiers;
import org.bouncycastle.asn1.x500.DirectoryString;

public class NamingAuthority
  extends ASN1Object
{
  public static final ASN1ObjectIdentifier id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern;
  private ASN1ObjectIdentifier namingAuthorityId;
  private DirectoryString namingAuthorityText;
  private String namingAuthorityUrl;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ISISMTTObjectIdentifiers.id_isismtt_at_namingAuthorities);
    localStringBuilder.append(".1");
    id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern = new ASN1ObjectIdentifier(localStringBuilder.toString());
  }
  
  public NamingAuthority(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString, DirectoryString paramDirectoryString)
  {
    this.namingAuthorityId = paramASN1ObjectIdentifier;
    this.namingAuthorityUrl = paramString;
    this.namingAuthorityText = paramDirectoryString;
  }
  
  private NamingAuthority(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() <= 3)
    {
      paramASN1Sequence = paramASN1Sequence.getObjects();
      if (paramASN1Sequence.hasMoreElements())
      {
        localObject = (ASN1Encodable)paramASN1Sequence.nextElement();
        if ((localObject instanceof ASN1ObjectIdentifier))
        {
          this.namingAuthorityId = ((ASN1ObjectIdentifier)localObject);
        }
        else if ((localObject instanceof DERIA5String))
        {
          this.namingAuthorityUrl = DERIA5String.getInstance(localObject).getString();
        }
        else if ((localObject instanceof ASN1String))
        {
          this.namingAuthorityText = DirectoryString.getInstance(localObject);
        }
        else
        {
          paramASN1Sequence = new StringBuilder();
          paramASN1Sequence.append("Bad object encountered: ");
          paramASN1Sequence.append(localObject.getClass());
          throw new IllegalArgumentException(paramASN1Sequence.toString());
        }
      }
      if (paramASN1Sequence.hasMoreElements())
      {
        localObject = (ASN1Encodable)paramASN1Sequence.nextElement();
        if ((localObject instanceof DERIA5String))
        {
          this.namingAuthorityUrl = DERIA5String.getInstance(localObject).getString();
        }
        else if ((localObject instanceof ASN1String))
        {
          this.namingAuthorityText = DirectoryString.getInstance(localObject);
        }
        else
        {
          paramASN1Sequence = new StringBuilder();
          paramASN1Sequence.append("Bad object encountered: ");
          paramASN1Sequence.append(localObject.getClass());
          throw new IllegalArgumentException(paramASN1Sequence.toString());
        }
      }
      if (paramASN1Sequence.hasMoreElements())
      {
        paramASN1Sequence = (ASN1Encodable)paramASN1Sequence.nextElement();
        if ((paramASN1Sequence instanceof ASN1String))
        {
          this.namingAuthorityText = DirectoryString.getInstance(paramASN1Sequence);
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
  
  public static NamingAuthority getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof NamingAuthority)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new NamingAuthority((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (NamingAuthority)paramObject;
  }
  
  public static NamingAuthority getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1ObjectIdentifier getNamingAuthorityId()
  {
    return this.namingAuthorityId;
  }
  
  public DirectoryString getNamingAuthorityText()
  {
    return this.namingAuthorityText;
  }
  
  public String getNamingAuthorityUrl()
  {
    return this.namingAuthorityUrl;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.namingAuthorityId;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.namingAuthorityUrl;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERIA5String((String)localObject, true));
    }
    localObject = this.namingAuthorityText;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\isismtt\x509\NamingAuthority.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */