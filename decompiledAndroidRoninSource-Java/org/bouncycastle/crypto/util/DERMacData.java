package org.bouncycastle.crypto.util;

import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public final class DERMacData
{
  private final byte[] macData;
  
  private DERMacData(byte[] paramArrayOfByte)
  {
    this.macData = paramArrayOfByte;
  }
  
  public byte[] getMacData()
  {
    return Arrays.clone(this.macData);
  }
  
  public static final class Builder
  {
    private ASN1OctetString ephemDataU;
    private ASN1OctetString ephemDataV;
    private ASN1OctetString idU;
    private ASN1OctetString idV;
    private byte[] text;
    private final DERMacData.Type type;
    
    public Builder(DERMacData.Type paramType, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
    {
      this.type = paramType;
      this.idU = DerUtil.getOctetString(paramArrayOfByte1);
      this.idV = DerUtil.getOctetString(paramArrayOfByte2);
      this.ephemDataU = DerUtil.getOctetString(paramArrayOfByte3);
      this.ephemDataV = DerUtil.getOctetString(paramArrayOfByte4);
    }
    
    private byte[] concatenate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6)
    {
      return Arrays.concatenate(Arrays.concatenate(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3), Arrays.concatenate(paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6));
    }
    
    public DERMacData build()
    {
      int i = DERMacData.1.$SwitchMap$org$bouncycastle$crypto$util$DERMacData$Type[this.type.ordinal()];
      if ((i != 1) && (i != 2))
      {
        if ((i != 3) && (i != 4)) {
          throw new IllegalStateException("Unknown type encountered in build");
        }
        return new DERMacData(concatenate(this.type.getHeader(), DerUtil.toByteArray(this.idV), DerUtil.toByteArray(this.idU), DerUtil.toByteArray(this.ephemDataV), DerUtil.toByteArray(this.ephemDataU), this.text), null);
      }
      return new DERMacData(concatenate(this.type.getHeader(), DerUtil.toByteArray(this.idU), DerUtil.toByteArray(this.idV), DerUtil.toByteArray(this.ephemDataU), DerUtil.toByteArray(this.ephemDataV), this.text), null);
    }
    
    public Builder withText(byte[] paramArrayOfByte)
    {
      this.text = DerUtil.toByteArray(new DERTaggedObject(false, 0, DerUtil.getOctetString(paramArrayOfByte)));
      return this;
    }
  }
  
  public static enum Type
  {
    private final String enc;
    
    static
    {
      BILATERALU = new Type("BILATERALU", 2, "KC_2_U");
      Type localType = new Type("BILATERALV", 3, "KC_2_V");
      BILATERALV = localType;
      $VALUES = new Type[] { UNILATERALU, UNILATERALV, BILATERALU, localType };
    }
    
    private Type(String paramString)
    {
      this.enc = paramString;
    }
    
    public byte[] getHeader()
    {
      return Strings.toByteArray(this.enc);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypt\\util\DERMacData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */