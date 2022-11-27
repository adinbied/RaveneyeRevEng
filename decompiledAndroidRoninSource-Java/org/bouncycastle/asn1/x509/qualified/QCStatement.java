package org.bouncycastle.asn1.x509.qualified;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class QCStatement
  extends ASN1Object
  implements ETSIQCObjectIdentifiers, RFC3739QCObjectIdentifiers
{
  ASN1ObjectIdentifier qcStatementId;
  ASN1Encodable qcStatementInfo;
  
  public QCStatement(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.qcStatementId = paramASN1ObjectIdentifier;
    this.qcStatementInfo = null;
  }
  
  public QCStatement(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.qcStatementId = paramASN1ObjectIdentifier;
    this.qcStatementInfo = paramASN1Encodable;
  }
  
  private QCStatement(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.qcStatementId = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.nextElement());
    if (paramASN1Sequence.hasMoreElements()) {
      this.qcStatementInfo = ((ASN1Encodable)paramASN1Sequence.nextElement());
    }
  }
  
  public static QCStatement getInstance(Object paramObject)
  {
    if ((paramObject instanceof QCStatement)) {
      return (QCStatement)paramObject;
    }
    if (paramObject != null) {
      return new QCStatement(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getStatementId()
  {
    return this.qcStatementId;
  }
  
  public ASN1Encodable getStatementInfo()
  {
    return this.qcStatementInfo;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.qcStatementId);
    ASN1Encodable localASN1Encodable = this.qcStatementInfo;
    if (localASN1Encodable != null) {
      localASN1EncodableVector.add(localASN1Encodable);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\qualified\QCStatement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */