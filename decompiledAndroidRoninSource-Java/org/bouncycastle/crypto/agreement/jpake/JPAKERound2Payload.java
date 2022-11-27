package org.bouncycastle.crypto.agreement.jpake;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

public class JPAKERound2Payload
{
  private final BigInteger a;
  private final BigInteger[] knowledgeProofForX2s;
  private final String participantId;
  
  public JPAKERound2Payload(String paramString, BigInteger paramBigInteger, BigInteger[] paramArrayOfBigInteger)
  {
    JPAKEUtil.validateNotNull(paramString, "participantId");
    JPAKEUtil.validateNotNull(paramBigInteger, "a");
    JPAKEUtil.validateNotNull(paramArrayOfBigInteger, "knowledgeProofForX2s");
    this.participantId = paramString;
    this.a = paramBigInteger;
    this.knowledgeProofForX2s = Arrays.copyOf(paramArrayOfBigInteger, paramArrayOfBigInteger.length);
  }
  
  public BigInteger getA()
  {
    return this.a;
  }
  
  public BigInteger[] getKnowledgeProofForX2s()
  {
    BigInteger[] arrayOfBigInteger = this.knowledgeProofForX2s;
    return Arrays.copyOf(arrayOfBigInteger, arrayOfBigInteger.length);
  }
  
  public String getParticipantId()
  {
    return this.participantId;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\jpake\JPAKERound2Payload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */