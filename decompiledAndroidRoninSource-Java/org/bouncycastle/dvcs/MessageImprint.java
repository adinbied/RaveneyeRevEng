package org.bouncycastle.dvcs;

import org.bouncycastle.asn1.x509.DigestInfo;

public class MessageImprint
{
  private final DigestInfo messageImprint;
  
  public MessageImprint(DigestInfo paramDigestInfo)
  {
    this.messageImprint = paramDigestInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof MessageImprint)) {
      return this.messageImprint.equals(((MessageImprint)paramObject).messageImprint);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.messageImprint.hashCode();
  }
  
  public DigestInfo toASN1Structure()
  {
    return this.messageImprint;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\MessageImprint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */