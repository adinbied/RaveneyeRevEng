package org.bouncycastle.cms;

import java.math.BigInteger;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Selector;

class OriginatorId
  implements Selector
{
  private X500Name issuer;
  private BigInteger serialNumber;
  private byte[] subjectKeyId;
  
  public OriginatorId(X500Name paramX500Name, BigInteger paramBigInteger)
  {
    setIssuerAndSerial(paramX500Name, paramBigInteger);
  }
  
  public OriginatorId(X500Name paramX500Name, BigInteger paramBigInteger, byte[] paramArrayOfByte)
  {
    setIssuerAndSerial(paramX500Name, paramBigInteger);
    setSubjectKeyID(paramArrayOfByte);
  }
  
  public OriginatorId(byte[] paramArrayOfByte)
  {
    setSubjectKeyID(paramArrayOfByte);
  }
  
  private boolean equalsObj(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null) {
      return paramObject1.equals(paramObject2);
    }
    return paramObject2 == null;
  }
  
  private void setIssuerAndSerial(X500Name paramX500Name, BigInteger paramBigInteger)
  {
    this.issuer = paramX500Name;
    this.serialNumber = paramBigInteger;
  }
  
  private void setSubjectKeyID(byte[] paramArrayOfByte)
  {
    this.subjectKeyId = paramArrayOfByte;
  }
  
  public Object clone()
  {
    return new OriginatorId(this.issuer, this.serialNumber, this.subjectKeyId);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof OriginatorId;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (OriginatorId)paramObject;
    bool1 = bool2;
    if (Arrays.areEqual(this.subjectKeyId, ((OriginatorId)paramObject).subjectKeyId))
    {
      bool1 = bool2;
      if (equalsObj(this.serialNumber, ((OriginatorId)paramObject).serialNumber))
      {
        bool1 = bool2;
        if (equalsObj(this.issuer, ((OriginatorId)paramObject).issuer)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public X500Name getIssuer()
  {
    return this.issuer;
  }
  
  public int hashCode()
  {
    int j = Arrays.hashCode(this.subjectKeyId);
    Object localObject = this.serialNumber;
    int i = j;
    if (localObject != null) {
      i = j ^ ((BigInteger)localObject).hashCode();
    }
    localObject = this.issuer;
    j = i;
    if (localObject != null) {
      j = i ^ ((X500Name)localObject).hashCode();
    }
    return j;
  }
  
  public boolean match(Object paramObject)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\OriginatorId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */