package org.bouncycastle.asn1.util;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1ApplicationSpecific;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.BERApplicationSpecific;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERExternal;
import org.bouncycastle.asn1.DERGraphicString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERT61String;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.DERVideotexString;
import org.bouncycastle.asn1.DERVisibleString;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class ASN1Dump
{
  private static final int SAMPLE_SIZE = 32;
  private static final String TAB = "    ";
  
  static void _dumpAsString(String paramString, boolean paramBoolean, ASN1Primitive paramASN1Primitive, StringBuffer paramStringBuffer)
  {
    String str = Strings.lineSeparator();
    Object localObject1;
    Object localObject2;
    if ((paramASN1Primitive instanceof ASN1Sequence))
    {
      localObject1 = ((ASN1Sequence)paramASN1Primitive).getObjects();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("    ");
      localObject2 = ((StringBuilder)localObject2).toString();
      paramStringBuffer.append(paramString);
      if ((paramASN1Primitive instanceof BERSequence)) {
        paramString = "BER Sequence";
      }
      for (;;)
      {
        paramStringBuffer.append(paramString);
        break;
        if ((paramASN1Primitive instanceof DERSequence)) {
          paramString = "DER Sequence";
        } else {
          paramString = "Sequence";
        }
      }
      for (;;)
      {
        paramStringBuffer.append(str);
        for (;;)
        {
          if (!((Enumeration)localObject1).hasMoreElements()) {
            break label1793;
          }
          paramString = ((Enumeration)localObject1).nextElement();
          if ((paramString == null) || (paramString.equals(DERNull.INSTANCE))) {
            break;
          }
          if ((paramString instanceof ASN1Primitive)) {
            paramString = (ASN1Primitive)paramString;
          } else {
            paramString = ((ASN1Encodable)paramString).toASN1Primitive();
          }
          _dumpAsString((String)localObject2, paramBoolean, paramString, paramStringBuffer);
        }
        paramStringBuffer.append((String)localObject2);
        paramStringBuffer.append("NULL");
      }
    }
    if ((paramASN1Primitive instanceof ASN1TaggedObject))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("    ");
      localObject1 = ((StringBuilder)localObject1).toString();
      paramStringBuffer.append(paramString);
      if ((paramASN1Primitive instanceof BERTaggedObject)) {
        paramString = "BER Tagged [";
      } else {
        paramString = "Tagged [";
      }
      paramStringBuffer.append(paramString);
      paramString = (ASN1TaggedObject)paramASN1Primitive;
      paramStringBuffer.append(Integer.toString(paramString.getTagNo()));
      paramStringBuffer.append(']');
      if (!paramString.isExplicit()) {
        paramStringBuffer.append(" IMPLICIT ");
      }
      paramStringBuffer.append(str);
      if (paramString.isEmpty())
      {
        paramStringBuffer.append((String)localObject1);
        paramStringBuffer.append("EMPTY");
      }
    }
    do
    {
      paramStringBuffer.append(str);
      return;
      _dumpAsString((String)localObject1, paramBoolean, paramString.getObject(), paramStringBuffer);
      return;
      if ((paramASN1Primitive instanceof ASN1Set))
      {
        localObject1 = ((ASN1Set)paramASN1Primitive).getObjects();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("    ");
        localObject2 = ((StringBuilder)localObject2).toString();
        paramStringBuffer.append(paramString);
        if ((paramASN1Primitive instanceof BERSet)) {
          paramString = "BER Set";
        } else {
          paramString = "DER Set";
        }
        paramStringBuffer.append(paramString);
        paramStringBuffer.append(str);
        for (;;)
        {
          if (!((Enumeration)localObject1).hasMoreElements()) {
            break label1793;
          }
          paramString = ((Enumeration)localObject1).nextElement();
          if (paramString == null)
          {
            paramStringBuffer.append((String)localObject2);
            paramStringBuffer.append("NULL");
            break;
          }
          if ((paramString instanceof ASN1Primitive)) {
            paramString = (ASN1Primitive)paramString;
          } else {
            paramString = ((ASN1Encodable)paramString).toASN1Primitive();
          }
          _dumpAsString((String)localObject2, paramBoolean, paramString, paramStringBuffer);
        }
      }
      if (!(paramASN1Primitive instanceof ASN1OctetString)) {
        break;
      }
      localObject1 = (ASN1OctetString)paramASN1Primitive;
      int i;
      if ((paramASN1Primitive instanceof BEROctetString))
      {
        paramASN1Primitive = new StringBuilder();
        paramASN1Primitive.append(paramString);
        paramASN1Primitive.append("BER Constructed Octet String");
        paramASN1Primitive.append("[");
        i = ((ASN1OctetString)localObject1).getOctets().length;
      }
      else
      {
        paramASN1Primitive = new StringBuilder();
        paramASN1Primitive.append(paramString);
        paramASN1Primitive.append("DER Octet String");
        paramASN1Primitive.append("[");
        i = ((ASN1OctetString)localObject1).getOctets().length;
      }
      paramASN1Primitive.append(i);
      paramASN1Primitive.append("] ");
      paramStringBuffer.append(paramASN1Primitive.toString());
    } while (!paramBoolean);
    paramString = dumpBinaryDataAsString(paramString, ((ASN1OctetString)localObject1).getOctets());
    break label701;
    if ((paramASN1Primitive instanceof ASN1ObjectIdentifier))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("ObjectIdentifier(");
      ((StringBuilder)localObject1).append(((ASN1ObjectIdentifier)paramASN1Primitive).getId());
      paramString = (String)localObject1;
      label682:
      paramString.append(")");
    }
    for (;;)
    {
      paramString.append(str);
      paramString = paramString.toString();
      label701:
      paramStringBuffer.append(paramString);
      return;
      if ((paramASN1Primitive instanceof ASN1Boolean))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("Boolean(");
        ((StringBuilder)localObject1).append(((ASN1Boolean)paramASN1Primitive).isTrue());
        paramString = (String)localObject1;
        break label682;
      }
      if ((paramASN1Primitive instanceof ASN1Integer))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("Integer(");
        paramASN1Primitive = ((ASN1Integer)paramASN1Primitive).getValue();
      }
      for (paramString = (String)localObject1;; paramString = (String)localObject1)
      {
        paramString.append(paramASN1Primitive);
        break label682;
        if ((paramASN1Primitive instanceof DERBitString))
        {
          paramASN1Primitive = (DERBitString)paramASN1Primitive;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("DER Bit String");
          ((StringBuilder)localObject1).append("[");
          ((StringBuilder)localObject1).append(paramASN1Primitive.getBytes().length);
          ((StringBuilder)localObject1).append(", ");
          ((StringBuilder)localObject1).append(paramASN1Primitive.getPadBits());
          ((StringBuilder)localObject1).append("] ");
          paramStringBuffer.append(((StringBuilder)localObject1).toString());
          if (!paramBoolean) {
            break;
          }
          paramString = dumpBinaryDataAsString(paramString, paramASN1Primitive.getBytes());
          break label701;
        }
        if ((paramASN1Primitive instanceof DERIA5String))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("IA5String(");
          paramASN1Primitive = ((DERIA5String)paramASN1Primitive).getString();
          paramString = (String)localObject1;
        }
        for (;;)
        {
          paramString.append(paramASN1Primitive);
          paramString.append(") ");
          break;
          if ((paramASN1Primitive instanceof DERUTF8String))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("UTF8String(");
            paramASN1Primitive = ((DERUTF8String)paramASN1Primitive).getString();
            paramString = (String)localObject1;
          }
          else if ((paramASN1Primitive instanceof DERPrintableString))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("PrintableString(");
            paramASN1Primitive = ((DERPrintableString)paramASN1Primitive).getString();
            paramString = (String)localObject1;
          }
          else if ((paramASN1Primitive instanceof DERVisibleString))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("VisibleString(");
            paramASN1Primitive = ((DERVisibleString)paramASN1Primitive).getString();
            paramString = (String)localObject1;
          }
          else if ((paramASN1Primitive instanceof DERBMPString))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("BMPString(");
            paramASN1Primitive = ((DERBMPString)paramASN1Primitive).getString();
            paramString = (String)localObject1;
          }
          else if ((paramASN1Primitive instanceof DERT61String))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("T61String(");
            paramASN1Primitive = ((DERT61String)paramASN1Primitive).getString();
            paramString = (String)localObject1;
          }
          else if ((paramASN1Primitive instanceof DERGraphicString))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("GraphicString(");
            paramASN1Primitive = ((DERGraphicString)paramASN1Primitive).getString();
            paramString = (String)localObject1;
          }
          else if ((paramASN1Primitive instanceof DERVideotexString))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("VideotexString(");
            paramASN1Primitive = ((DERVideotexString)paramASN1Primitive).getString();
            paramString = (String)localObject1;
          }
          else if ((paramASN1Primitive instanceof ASN1UTCTime))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("UTCTime(");
            paramASN1Primitive = ((ASN1UTCTime)paramASN1Primitive).getTime();
            paramString = (String)localObject1;
          }
          else
          {
            if (!(paramASN1Primitive instanceof ASN1GeneralizedTime)) {
              break label1379;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("GeneralizedTime(");
            paramASN1Primitive = ((ASN1GeneralizedTime)paramASN1Primitive).getTime();
            paramString = (String)localObject1;
          }
        }
        label1379:
        if ((paramASN1Primitive instanceof BERApplicationSpecific)) {}
        for (localObject1 = "BER";; localObject1 = "DER")
        {
          paramString = outputApplicationSpecific((String)localObject1, paramString, paramBoolean, paramASN1Primitive, str);
          break;
          if (!(paramASN1Primitive instanceof DERApplicationSpecific)) {
            break label1419;
          }
        }
        label1419:
        if (!(paramASN1Primitive instanceof ASN1Enumerated)) {
          break label1467;
        }
        paramASN1Primitive = (ASN1Enumerated)paramASN1Primitive;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("DER Enumerated(");
        paramASN1Primitive = paramASN1Primitive.getValue();
      }
      label1467:
      if ((paramASN1Primitive instanceof DERExternal))
      {
        paramASN1Primitive = (DERExternal)paramASN1Primitive;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("External ");
        ((StringBuilder)localObject1).append(str);
        paramStringBuffer.append(((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("    ");
        paramString = ((StringBuilder)localObject1).toString();
        if (paramASN1Primitive.getDirectReference() != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("Direct Reference: ");
          ((StringBuilder)localObject1).append(paramASN1Primitive.getDirectReference().getId());
          ((StringBuilder)localObject1).append(str);
          paramStringBuffer.append(((StringBuilder)localObject1).toString());
        }
        if (paramASN1Primitive.getIndirectReference() != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("Indirect Reference: ");
          ((StringBuilder)localObject1).append(paramASN1Primitive.getIndirectReference().toString());
          ((StringBuilder)localObject1).append(str);
          paramStringBuffer.append(((StringBuilder)localObject1).toString());
        }
        if (paramASN1Primitive.getDataValueDescriptor() != null) {
          _dumpAsString(paramString, paramBoolean, paramASN1Primitive.getDataValueDescriptor(), paramStringBuffer);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("Encoding: ");
        ((StringBuilder)localObject1).append(paramASN1Primitive.getEncoding());
        ((StringBuilder)localObject1).append(str);
        paramStringBuffer.append(((StringBuilder)localObject1).toString());
        paramASN1Primitive = paramASN1Primitive.getExternalContent();
      }
      try
      {
        _dumpAsString(paramString, paramBoolean, paramASN1Primitive, paramStringBuffer);
        return;
      }
      finally {}
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(paramASN1Primitive.toString());
      paramString = (String)localObject1;
    }
    label1793:
  }
  
  private static String calculateAscString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramInt1;
    while (i != paramInt1 + paramInt2)
    {
      if ((paramArrayOfByte[i] >= 32) && (paramArrayOfByte[i] <= 126)) {
        localStringBuffer.append((char)paramArrayOfByte[i]);
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String dumpAsString(Object paramObject)
  {
    return dumpAsString(paramObject, false);
  }
  
  public static String dumpAsString(Object paramObject, boolean paramBoolean)
  {
    Object localObject = new StringBuffer();
    if ((paramObject instanceof ASN1Primitive)) {}
    for (paramObject = (ASN1Primitive)paramObject;; paramObject = ((ASN1Encodable)paramObject).toASN1Primitive())
    {
      _dumpAsString("", paramBoolean, (ASN1Primitive)paramObject, (StringBuffer)localObject);
      break;
      if (!(paramObject instanceof ASN1Encodable)) {
        break label57;
      }
    }
    return ((StringBuffer)localObject).toString();
    label57:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown object type ");
    ((StringBuilder)localObject).append(paramObject.toString());
    return ((StringBuilder)localObject).toString();
  }
  
  private static String dumpBinaryDataAsString(String paramString, byte[] paramArrayOfByte)
  {
    String str = Strings.lineSeparator();
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("    ");
    localObject = ((StringBuilder)localObject).toString();
    localStringBuffer.append(str);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte.length;
      localStringBuffer.append((String)localObject);
      if (j - i > 32)
      {
        localStringBuffer.append(Strings.fromByteArray(Hex.encode(paramArrayOfByte, i, 32)));
        localStringBuffer.append("    ");
      }
      for (paramString = calculateAscString(paramArrayOfByte, i, 32);; paramString = calculateAscString(paramArrayOfByte, i, paramArrayOfByte.length - i))
      {
        localStringBuffer.append(paramString);
        localStringBuffer.append(str);
        break;
        localStringBuffer.append(Strings.fromByteArray(Hex.encode(paramArrayOfByte, i, paramArrayOfByte.length - i)));
        j = paramArrayOfByte.length - i;
        while (j != 32)
        {
          localStringBuffer.append("  ");
          j += 1;
        }
        localStringBuffer.append("    ");
      }
      i += 32;
    }
    return localStringBuffer.toString();
  }
  
  private static String outputApplicationSpecific(String paramString1, String paramString2, boolean paramBoolean, ASN1Primitive paramASN1Primitive, String paramString3)
  {
    ASN1ApplicationSpecific localASN1ApplicationSpecific = ASN1ApplicationSpecific.getInstance(paramASN1Primitive);
    paramASN1Primitive = new StringBuffer();
    if (localASN1ApplicationSpecific.isConstructed()) {
      try
      {
        ASN1Sequence localASN1Sequence = ASN1Sequence.getInstance(localASN1ApplicationSpecific.getObject(16));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" ApplicationSpecific[");
        localStringBuilder.append(localASN1ApplicationSpecific.getApplicationTag());
        localStringBuilder.append("]");
        localStringBuilder.append(paramString3);
        paramASN1Primitive.append(localStringBuilder.toString());
        paramString1 = localASN1Sequence.getObjects();
        while (paramString1.hasMoreElements())
        {
          paramString3 = new StringBuilder();
          paramString3.append(paramString2);
          paramString3.append("    ");
          _dumpAsString(paramString3.toString(), paramBoolean, (ASN1Primitive)paramString1.nextElement(), paramASN1Primitive);
        }
        return paramASN1Primitive.toString();
      }
      catch (IOException paramString1)
      {
        paramASN1Primitive.append(paramString1);
      }
    }
    paramASN1Primitive = new StringBuilder();
    paramASN1Primitive.append(paramString2);
    paramASN1Primitive.append(paramString1);
    paramASN1Primitive.append(" ApplicationSpecific[");
    paramASN1Primitive.append(localASN1ApplicationSpecific.getApplicationTag());
    paramASN1Primitive.append("] (");
    paramASN1Primitive.append(Strings.fromByteArray(Hex.encode(localASN1ApplicationSpecific.getContents())));
    paramASN1Primitive.append(")");
    paramASN1Primitive.append(paramString3);
    return paramASN1Primitive.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn\\util\ASN1Dump.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */