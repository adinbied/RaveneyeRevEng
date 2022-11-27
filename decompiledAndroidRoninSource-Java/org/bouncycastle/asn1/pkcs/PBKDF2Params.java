package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class PBKDF2Params
  extends ASN1Object
{
  private static final AlgorithmIdentifier algid_hmacWithSHA1 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA1, DERNull.INSTANCE);
  private final ASN1Integer iterationCount;
  private final ASN1Integer keyLength;
  private final ASN1OctetString octStr;
  private final AlgorithmIdentifier prf;
  
  private PBKDF2Params(ASN1Sequence paramASN1Sequence)
  {
    Enumeration localEnumeration = paramASN1Sequence.getObjects();
    this.octStr = ((ASN1OctetString)localEnumeration.nextElement());
    this.iterationCount = ((ASN1Integer)localEnumeration.nextElement());
    if (localEnumeration.hasMoreElements())
    {
      paramASN1Sequence = localEnumeration.nextElement();
      if ((paramASN1Sequence instanceof ASN1Integer))
      {
        this.keyLength = ASN1Integer.getInstance(paramASN1Sequence);
        if (localEnumeration.hasMoreElements()) {
          paramASN1Sequence = localEnumeration.nextElement();
        } else {
          paramASN1Sequence = null;
        }
      }
      else
      {
        this.keyLength = null;
      }
      if (paramASN1Sequence != null) {
        this.prf = AlgorithmIdentifier.getInstance(paramASN1Sequence);
      }
    }
    else
    {
      this.keyLength = null;
    }
    this.prf = null;
  }
  
  public PBKDF2Params(byte[] paramArrayOfByte, int paramInt)
  {
    this(paramArrayOfByte, paramInt, 0);
  }
  
  public PBKDF2Params(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(paramArrayOfByte, paramInt1, paramInt2, null);
  }
  
  public PBKDF2Params(byte[] paramArrayOfByte, int paramInt1, int paramInt2, AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this.octStr = new DEROctetString(Arrays.clone(paramArrayOfByte));
    this.iterationCount = new ASN1Integer(paramInt1);
    if (paramInt2 > 0) {
      paramArrayOfByte = new ASN1Integer(paramInt2);
    } else {
      paramArrayOfByte = null;
    }
    this.keyLength = paramArrayOfByte;
    this.prf = paramAlgorithmIdentifier;
  }
  
  public PBKDF2Params(byte[] paramArrayOfByte, int paramInt, AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this(paramArrayOfByte, paramInt, 0, paramAlgorithmIdentifier);
  }
  
  public static PBKDF2Params getInstance(Object paramObject)
  {
    if ((paramObject instanceof PBKDF2Params)) {
      return (PBKDF2Params)paramObject;
    }
    if (paramObject != null) {
      return new PBKDF2Params(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public BigInteger getIterationCount()
  {
    return this.iterationCount.getValue();
  }
  
  public BigInteger getKeyLength()
  {
    ASN1Integer localASN1Integer = this.keyLength;
    if (localASN1Integer != null) {
      return localASN1Integer.getValue();
    }
    return null;
  }
  
  public AlgorithmIdentifier getPrf()
  {
    AlgorithmIdentifier localAlgorithmIdentifier = this.prf;
    if (localAlgorithmIdentifier != null) {
      return localAlgorithmIdentifier;
    }
    return algid_hmacWithSHA1;
  }
  
  public byte[] getSalt()
  {
    return this.octStr.getOctets();
  }
  
  public boolean isDefaultPrf()
  {
    AlgorithmIdentifier localAlgorithmIdentifier = this.prf;
    return (localAlgorithmIdentifier == null) || (localAlgorithmIdentifier.equals(algid_hmacWithSHA1));
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.octStr);
    localASN1EncodableVector.add(this.iterationCount);
    Object localObject = this.keyLength;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.prf;
    if ((localObject != null) && (!((AlgorithmIdentifier)localObject).equals(algid_hmacWithSHA1))) {
      localASN1EncodableVector.add(this.prf);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\PBKDF2Params.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */