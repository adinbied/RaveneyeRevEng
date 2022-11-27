package org.bouncycastle.crypto.agreement.jpake;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

public class JPAKERound1Payload
{
  private final BigInteger gx1;
  private final BigInteger gx2;
  private final BigInteger[] knowledgeProofForX1;
  private final BigInteger[] knowledgeProofForX2;
  private final String participantId;
  
  public JPAKERound1Payload(String paramString, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger[] paramArrayOfBigInteger1, BigInteger[] paramArrayOfBigInteger2)
  {
    JPAKEUtil.validateNotNull(paramString, "participantId");
    JPAKEUtil.validateNotNull(paramBigInteger1, "gx1");
    JPAKEUtil.validateNotNull(paramBigInteger2, "gx2");
    JPAKEUtil.validateNotNull(paramArrayOfBigInteger1, "knowledgeProofForX1");
    JPAKEUtil.validateNotNull(paramArrayOfBigInteger2, "knowledgeProofForX2");
    this.participantId = paramString;
    this.gx1 = paramBigInteger1;
    this.gx2 = paramBigInteger2;
    this.knowledgeProofForX1 = Arrays.copyOf(paramArrayOfBigInteger1, paramArrayOfBigInteger1.length);
    this.knowledgeProofForX2 = Arrays.copyOf(paramArrayOfBigInteger2, paramArrayOfBigInteger2.length);
  }
  
  public BigInteger getGx1()
  {
    return this.gx1;
  }
  
  public BigInteger getGx2()
  {
    return this.gx2;
  }
  
  public BigInteger[] getKnowledgeProofForX1()
  {
    BigInteger[] arrayOfBigInteger = this.knowledgeProofForX1;
    return Arrays.copyOf(arrayOfBigInteger, arrayOfBigInteger.length);
  }
  
  public BigInteger[] getKnowledgeProofForX2()
  {
    BigInteger[] arrayOfBigInteger = this.knowledgeProofForX2;
    return Arrays.copyOf(arrayOfBigInteger, arrayOfBigInteger.length);
  }
  
  public String getParticipantId()
  {
    return this.participantId;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\jpake\JPAKERound1Payload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */