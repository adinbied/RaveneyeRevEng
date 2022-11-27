package org.bouncycastle.asn1.icao;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class LDSSecurityObject
  extends ASN1Object
  implements ICAOObjectIdentifiers
{
  public static final int ub_DataGroups = 16;
  private DataGroupHash[] datagroupHash;
  private AlgorithmIdentifier digestAlgorithmIdentifier;
  private ASN1Integer version = new ASN1Integer(0L);
  private LDSVersionInfo versionInfo;
  
  private LDSSecurityObject(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence != null) && (paramASN1Sequence.size() != 0))
    {
      paramASN1Sequence = paramASN1Sequence.getObjects();
      this.version = ASN1Integer.getInstance(paramASN1Sequence.nextElement());
      this.digestAlgorithmIdentifier = AlgorithmIdentifier.getInstance(paramASN1Sequence.nextElement());
      ASN1Sequence localASN1Sequence = ASN1Sequence.getInstance(paramASN1Sequence.nextElement());
      if (this.version.getValue().intValue() == 1) {
        this.versionInfo = LDSVersionInfo.getInstance(paramASN1Sequence.nextElement());
      }
      checkDatagroupHashSeqSize(localASN1Sequence.size());
      this.datagroupHash = new DataGroupHash[localASN1Sequence.size()];
      int i = 0;
      while (i < localASN1Sequence.size())
      {
        this.datagroupHash[i] = DataGroupHash.getInstance(localASN1Sequence.getObjectAt(i));
        i += 1;
      }
      return;
    }
    throw new IllegalArgumentException("null or empty sequence passed.");
  }
  
  public LDSSecurityObject(AlgorithmIdentifier paramAlgorithmIdentifier, DataGroupHash[] paramArrayOfDataGroupHash)
  {
    this.version = new ASN1Integer(0L);
    this.digestAlgorithmIdentifier = paramAlgorithmIdentifier;
    this.datagroupHash = paramArrayOfDataGroupHash;
    checkDatagroupHashSeqSize(paramArrayOfDataGroupHash.length);
  }
  
  public LDSSecurityObject(AlgorithmIdentifier paramAlgorithmIdentifier, DataGroupHash[] paramArrayOfDataGroupHash, LDSVersionInfo paramLDSVersionInfo)
  {
    this.version = new ASN1Integer(1L);
    this.digestAlgorithmIdentifier = paramAlgorithmIdentifier;
    this.datagroupHash = paramArrayOfDataGroupHash;
    this.versionInfo = paramLDSVersionInfo;
    checkDatagroupHashSeqSize(paramArrayOfDataGroupHash.length);
  }
  
  private void checkDatagroupHashSeqSize(int paramInt)
  {
    if ((paramInt >= 2) && (paramInt <= 16)) {
      return;
    }
    throw new IllegalArgumentException("wrong size in DataGroupHashValues : not in (2..16)");
  }
  
  public static LDSSecurityObject getInstance(Object paramObject)
  {
    if ((paramObject instanceof LDSSecurityObject)) {
      return (LDSSecurityObject)paramObject;
    }
    if (paramObject != null) {
      return new LDSSecurityObject(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public DataGroupHash[] getDatagroupHash()
  {
    return this.datagroupHash;
  }
  
  public AlgorithmIdentifier getDigestAlgorithmIdentifier()
  {
    return this.digestAlgorithmIdentifier;
  }
  
  public int getVersion()
  {
    return this.version.getValue().intValue();
  }
  
  public LDSVersionInfo getVersionInfo()
  {
    return this.versionInfo;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.version);
    localASN1EncodableVector.add(this.digestAlgorithmIdentifier);
    Object localObject = new ASN1EncodableVector();
    int i = 0;
    for (;;)
    {
      DataGroupHash[] arrayOfDataGroupHash = this.datagroupHash;
      if (i >= arrayOfDataGroupHash.length) {
        break;
      }
      ((ASN1EncodableVector)localObject).add(arrayOfDataGroupHash[i]);
      i += 1;
    }
    localASN1EncodableVector.add(new DERSequence((ASN1EncodableVector)localObject));
    localObject = this.versionInfo;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\icao\LDSSecurityObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */