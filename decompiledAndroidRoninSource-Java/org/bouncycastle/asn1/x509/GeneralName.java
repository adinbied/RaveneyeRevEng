package org.bouncycastle.asn1.x509;

import java.io.IOException;
import java.util.StringTokenizer;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.IPAddress;

public class GeneralName
  extends ASN1Object
  implements ASN1Choice
{
  public static final int dNSName = 2;
  public static final int directoryName = 4;
  public static final int ediPartyName = 5;
  public static final int iPAddress = 7;
  public static final int otherName = 0;
  public static final int registeredID = 8;
  public static final int rfc822Name = 1;
  public static final int uniformResourceIdentifier = 6;
  public static final int x400Address = 3;
  private ASN1Encodable obj;
  private int tag;
  
  public GeneralName(int paramInt, String paramString)
  {
    this.tag = paramInt;
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 6))
    {
      if (paramInt == 8)
      {
        paramString = new ASN1ObjectIdentifier(paramString);
      }
      else if (paramInt == 4)
      {
        paramString = new X500Name(paramString);
      }
      else
      {
        if (paramInt == 7)
        {
          paramString = toGeneralNameEncoding(paramString);
          if (paramString != null)
          {
            this.obj = new DEROctetString(paramString);
            return;
          }
          throw new IllegalArgumentException("IP Address is invalid");
        }
        paramString = new StringBuilder();
        paramString.append("can't process String for tag: ");
        paramString.append(paramInt);
        throw new IllegalArgumentException(paramString.toString());
      }
    }
    else {
      paramString = new DERIA5String(paramString);
    }
    this.obj = paramString;
  }
  
  public GeneralName(int paramInt, ASN1Encodable paramASN1Encodable)
  {
    this.obj = paramASN1Encodable;
    this.tag = paramInt;
  }
  
  public GeneralName(X500Name paramX500Name)
  {
    this.obj = paramX500Name;
    this.tag = 4;
  }
  
  public GeneralName(X509Name paramX509Name)
  {
    this.obj = X500Name.getInstance(paramX509Name);
    this.tag = 4;
  }
  
  private void copyInts(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    while (i != paramArrayOfInt.length)
    {
      int j = i * 2;
      paramArrayOfByte[(j + paramInt)] = ((byte)(paramArrayOfInt[i] >> 8));
      paramArrayOfByte[(j + 1 + paramInt)] = ((byte)paramArrayOfInt[i]);
      i += 1;
    }
  }
  
  public static GeneralName getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof GeneralName)))
    {
      if ((paramObject instanceof ASN1TaggedObject))
      {
        localObject = (ASN1TaggedObject)paramObject;
        int i = ((ASN1TaggedObject)localObject).getTagNo();
        switch (i)
        {
        default: 
          break;
        case 8: 
          return new GeneralName(i, ASN1ObjectIdentifier.getInstance((ASN1TaggedObject)localObject, false));
        case 7: 
          return new GeneralName(i, ASN1OctetString.getInstance((ASN1TaggedObject)localObject, false));
        case 6: 
          return new GeneralName(i, DERIA5String.getInstance((ASN1TaggedObject)localObject, false));
        case 5: 
          return new GeneralName(i, ASN1Sequence.getInstance((ASN1TaggedObject)localObject, false));
        case 4: 
          return new GeneralName(i, X500Name.getInstance((ASN1TaggedObject)localObject, true));
        case 3: 
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append("unknown tag: ");
          ((StringBuilder)paramObject).append(i);
          throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
        case 2: 
          return new GeneralName(i, DERIA5String.getInstance((ASN1TaggedObject)localObject, false));
        case 1: 
          return new GeneralName(i, DERIA5String.getInstance((ASN1TaggedObject)localObject, false));
        case 0: 
          return new GeneralName(i, ASN1Sequence.getInstance((ASN1TaggedObject)localObject, false));
        }
      }
      if (!(paramObject instanceof byte[])) {}
    }
    try
    {
      paramObject = getInstance(ASN1Primitive.fromByteArray((byte[])paramObject));
      return (GeneralName)paramObject;
    }
    catch (IOException paramObject)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("unable to parse encoded general name");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown object in getInstance: ");
    ((StringBuilder)localObject).append(paramObject.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    return (GeneralName)paramObject;
  }
  
  public static GeneralName getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1TaggedObject.getInstance(paramASN1TaggedObject, true));
  }
  
  private void parseIPv4(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = new StringTokenizer(paramString, "./");
    int i = 0;
    while (paramString.hasMoreTokens())
    {
      paramArrayOfByte[(i + paramInt)] = ((byte)Integer.parseInt(paramString.nextToken()));
      i += 1;
    }
  }
  
  private void parseIPv4Mask(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    int j = Integer.parseInt(paramString);
    int i = 0;
    while (i != j)
    {
      int k = i / 8 + paramInt;
      paramArrayOfByte[k] = ((byte)(paramArrayOfByte[k] | 1 << 7 - i % 8));
      i += 1;
    }
  }
  
  private int[] parseIPv6(String paramString)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ":", true);
    int[] arrayOfInt = new int[8];
    if ((paramString.charAt(0) == ':') && (paramString.charAt(1) == ':')) {
      localStringTokenizer.nextToken();
    }
    int j = -1;
    int i = 0;
    int k;
    while (localStringTokenizer.hasMoreTokens())
    {
      paramString = localStringTokenizer.nextToken();
      if (paramString.equals(":"))
      {
        arrayOfInt[i] = 0;
        k = i + 1;
        j = i;
        i = k;
      }
      else if (paramString.indexOf('.') < 0)
      {
        arrayOfInt[i] = Integer.parseInt(paramString, 16);
        if (localStringTokenizer.hasMoreTokens()) {
          localStringTokenizer.nextToken();
        }
        i += 1;
      }
      else
      {
        paramString = new StringTokenizer(paramString, ".");
        k = i + 1;
        arrayOfInt[i] = (Integer.parseInt(paramString.nextToken()) << 8 | Integer.parseInt(paramString.nextToken()));
        i = k + 1;
        int m = Integer.parseInt(paramString.nextToken());
        arrayOfInt[k] = (Integer.parseInt(paramString.nextToken()) | m << 8);
      }
    }
    if (i != 8)
    {
      k = i - j;
      i = 8 - k;
      System.arraycopy(arrayOfInt, j, arrayOfInt, i, k);
      while (j != i)
      {
        arrayOfInt[j] = 0;
        j += 1;
      }
    }
    return arrayOfInt;
  }
  
  private int[] parseMask(String paramString)
  {
    int[] arrayOfInt = new int[8];
    int j = Integer.parseInt(paramString);
    int i = 0;
    while (i != j)
    {
      int k = i / 16;
      arrayOfInt[k] |= 1 << 15 - i % 16;
      i += 1;
    }
    return arrayOfInt;
  }
  
  private byte[] toGeneralNameEncoding(String paramString)
  {
    if ((!IPAddress.isValidIPv6WithNetmask(paramString)) && (!IPAddress.isValidIPv6(paramString)))
    {
      if ((!IPAddress.isValidIPv4WithNetmask(paramString)) && (!IPAddress.isValidIPv4(paramString))) {
        return null;
      }
      i = paramString.indexOf('/');
      if (i < 0)
      {
        arrayOfByte = new byte[4];
        parseIPv4(paramString, arrayOfByte, 0);
        return arrayOfByte;
      }
      arrayOfByte = new byte[8];
      parseIPv4(paramString.substring(0, i), arrayOfByte, 0);
      paramString = paramString.substring(i + 1);
      if (paramString.indexOf('.') > 0)
      {
        parseIPv4(paramString, arrayOfByte, 4);
        return arrayOfByte;
      }
      parseIPv4Mask(paramString, arrayOfByte, 4);
      return arrayOfByte;
    }
    int i = paramString.indexOf('/');
    if (i < 0)
    {
      arrayOfByte = new byte[16];
      copyInts(parseIPv6(paramString), arrayOfByte, 0);
      return arrayOfByte;
    }
    byte[] arrayOfByte = new byte[32];
    copyInts(parseIPv6(paramString.substring(0, i)), arrayOfByte, 0);
    paramString = paramString.substring(i + 1);
    if (paramString.indexOf(':') > 0) {
      paramString = parseIPv6(paramString);
    } else {
      paramString = parseMask(paramString);
    }
    copyInts(paramString, arrayOfByte, 16);
    return arrayOfByte;
  }
  
  public ASN1Encodable getName()
  {
    return this.obj;
  }
  
  public int getTagNo()
  {
    return this.tag;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    int i = this.tag;
    if (i == 4) {
      return new DERTaggedObject(true, i, this.obj);
    }
    return new DERTaggedObject(false, i, this.obj);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.tag);
    localStringBuffer.append(": ");
    int i = this.tag;
    if ((i != 1) && (i != 2)) {
      if (i != 4)
      {
        if (i != 6)
        {
          str = this.obj.toString();
          break label86;
        }
      }
      else
      {
        str = X500Name.getInstance(this.obj).toString();
        break label86;
      }
    }
    String str = DERIA5String.getInstance(this.obj).getString();
    label86:
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\GeneralName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */