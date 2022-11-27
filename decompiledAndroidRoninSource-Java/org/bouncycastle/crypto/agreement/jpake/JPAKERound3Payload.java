package org.bouncycastle.crypto.agreement.jpake;

import java.math.BigInteger;

public class JPAKERound3Payload
{
  private final BigInteger macTag;
  private final String participantId;
  
  public JPAKERound3Payload(String paramString, BigInteger paramBigInteger)
  {
    this.participantId = paramString;
    this.macTag = paramBigInteger;
  }
  
  public BigInteger getMacTag()
  {
    return this.macTag;
  }
  
  public String getParticipantId()
  {
    return this.participantId;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\jpake\JPAKERound3Payload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */