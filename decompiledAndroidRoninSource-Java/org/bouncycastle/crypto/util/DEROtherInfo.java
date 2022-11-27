package org.bouncycastle.crypto.util;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class DEROtherInfo
{
  private final DERSequence sequence;
  
  private DEROtherInfo(DERSequence paramDERSequence)
  {
    this.sequence = paramDERSequence;
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.sequence.getEncoded();
  }
  
  public static final class Builder
  {
    private final AlgorithmIdentifier algorithmID;
    private final ASN1OctetString partyUVInfo;
    private final ASN1OctetString partyVInfo;
    private ASN1TaggedObject suppPrivInfo;
    private ASN1TaggedObject suppPubInfo;
    
    public Builder(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      this.algorithmID = paramAlgorithmIdentifier;
      this.partyUVInfo = DerUtil.getOctetString(paramArrayOfByte1);
      this.partyVInfo = DerUtil.getOctetString(paramArrayOfByte2);
    }
    
    public DEROtherInfo build()
    {
      ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
      localASN1EncodableVector.add(this.algorithmID);
      localASN1EncodableVector.add(this.partyUVInfo);
      localASN1EncodableVector.add(this.partyVInfo);
      ASN1TaggedObject localASN1TaggedObject = this.suppPubInfo;
      if (localASN1TaggedObject != null) {
        localASN1EncodableVector.add(localASN1TaggedObject);
      }
      localASN1TaggedObject = this.suppPrivInfo;
      if (localASN1TaggedObject != null) {
        localASN1EncodableVector.add(localASN1TaggedObject);
      }
      return new DEROtherInfo(new DERSequence(localASN1EncodableVector), null);
    }
    
    public Builder withSuppPrivInfo(byte[] paramArrayOfByte)
    {
      this.suppPrivInfo = new DERTaggedObject(false, 1, DerUtil.getOctetString(paramArrayOfByte));
      return this;
    }
    
    public Builder withSuppPubInfo(byte[] paramArrayOfByte)
    {
      this.suppPubInfo = new DERTaggedObject(false, 0, DerUtil.getOctetString(paramArrayOfByte));
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypt\\util\DEROtherInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */