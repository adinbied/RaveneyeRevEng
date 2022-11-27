package org.bouncycastle.cms;

import org.bouncycastle.util.Arrays;

public class KEKRecipientId
  extends RecipientId
{
  private byte[] keyIdentifier;
  
  public KEKRecipientId(byte[] paramArrayOfByte)
  {
    super(1);
    this.keyIdentifier = paramArrayOfByte;
  }
  
  public Object clone()
  {
    return new KEKRecipientId(this.keyIdentifier);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof KEKRecipientId)) {
      return false;
    }
    paramObject = (KEKRecipientId)paramObject;
    return Arrays.areEqual(this.keyIdentifier, ((KEKRecipientId)paramObject).keyIdentifier);
  }
  
  public byte[] getKeyIdentifier()
  {
    return Arrays.clone(this.keyIdentifier);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.keyIdentifier);
  }
  
  public boolean match(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return Arrays.areEqual(this.keyIdentifier, (byte[])paramObject);
    }
    if ((paramObject instanceof KEKRecipientInformation)) {
      return ((KEKRecipientInformation)paramObject).getRID().equals(this);
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\KEKRecipientId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */