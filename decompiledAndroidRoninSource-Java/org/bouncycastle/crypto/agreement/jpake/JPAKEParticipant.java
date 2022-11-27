package org.bouncycastle.crypto.agreement.jpake;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.util.Arrays;

public class JPAKEParticipant
{
  public static final int STATE_INITIALIZED = 0;
  public static final int STATE_KEY_CALCULATED = 50;
  public static final int STATE_ROUND_1_CREATED = 10;
  public static final int STATE_ROUND_1_VALIDATED = 20;
  public static final int STATE_ROUND_2_CREATED = 30;
  public static final int STATE_ROUND_2_VALIDATED = 40;
  public static final int STATE_ROUND_3_CREATED = 60;
  public static final int STATE_ROUND_3_VALIDATED = 70;
  private BigInteger b;
  private final Digest digest;
  private final BigInteger g;
  private BigInteger gx1;
  private BigInteger gx2;
  private BigInteger gx3;
  private BigInteger gx4;
  private final BigInteger p;
  private final String participantId;
  private String partnerParticipantId;
  private char[] password;
  private final BigInteger q;
  private final SecureRandom random;
  private int state;
  private BigInteger x1;
  private BigInteger x2;
  
  public JPAKEParticipant(String paramString, char[] paramArrayOfChar)
  {
    this(paramString, paramArrayOfChar, JPAKEPrimeOrderGroups.NIST_3072);
  }
  
  public JPAKEParticipant(String paramString, char[] paramArrayOfChar, JPAKEPrimeOrderGroup paramJPAKEPrimeOrderGroup)
  {
    this(paramString, paramArrayOfChar, paramJPAKEPrimeOrderGroup, new SHA256Digest(), new SecureRandom());
  }
  
  public JPAKEParticipant(String paramString, char[] paramArrayOfChar, JPAKEPrimeOrderGroup paramJPAKEPrimeOrderGroup, Digest paramDigest, SecureRandom paramSecureRandom)
  {
    JPAKEUtil.validateNotNull(paramString, "participantId");
    JPAKEUtil.validateNotNull(paramArrayOfChar, "password");
    JPAKEUtil.validateNotNull(paramJPAKEPrimeOrderGroup, "p");
    JPAKEUtil.validateNotNull(paramDigest, "digest");
    JPAKEUtil.validateNotNull(paramSecureRandom, "random");
    if (paramArrayOfChar.length != 0)
    {
      this.participantId = paramString;
      this.password = Arrays.copyOf(paramArrayOfChar, paramArrayOfChar.length);
      this.p = paramJPAKEPrimeOrderGroup.getP();
      this.q = paramJPAKEPrimeOrderGroup.getQ();
      this.g = paramJPAKEPrimeOrderGroup.getG();
      this.digest = paramDigest;
      this.random = paramSecureRandom;
      this.state = 0;
      return;
    }
    throw new IllegalArgumentException("Password must not be empty.");
  }
  
  public BigInteger calculateKeyingMaterial()
  {
    int i = this.state;
    if (i < 50)
    {
      if (i >= 40)
      {
        localObject = JPAKEUtil.calculateS(this.password);
        Arrays.fill(this.password, '\000');
        this.password = null;
        localObject = JPAKEUtil.calculateKeyingMaterial(this.p, this.q, this.gx4, this.x2, (BigInteger)localObject, this.b);
        this.x1 = null;
        this.x2 = null;
        this.b = null;
        this.state = 50;
        return (BigInteger)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Round2 payload must be validated prior to creating key for ");
      ((StringBuilder)localObject).append(this.participantId);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Key already calculated for ");
    ((StringBuilder)localObject).append(this.participantId);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public JPAKERound1Payload createRound1PayloadToSend()
  {
    if (this.state < 10)
    {
      this.x1 = JPAKEUtil.generateX1(this.q, this.random);
      this.x2 = JPAKEUtil.generateX2(this.q, this.random);
      this.gx1 = JPAKEUtil.calculateGx(this.p, this.g, this.x1);
      this.gx2 = JPAKEUtil.calculateGx(this.p, this.g, this.x2);
      localObject = JPAKEUtil.calculateZeroKnowledgeProof(this.p, this.q, this.g, this.gx1, this.x1, this.participantId, this.digest, this.random);
      BigInteger[] arrayOfBigInteger = JPAKEUtil.calculateZeroKnowledgeProof(this.p, this.q, this.g, this.gx2, this.x2, this.participantId, this.digest, this.random);
      this.state = 10;
      return new JPAKERound1Payload(this.participantId, this.gx1, this.gx2, (BigInteger[])localObject, arrayOfBigInteger);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Round1 payload already created for ");
    ((StringBuilder)localObject).append(this.participantId);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public JPAKERound2Payload createRound2PayloadToSend()
  {
    int i = this.state;
    if (i < 30)
    {
      if (i >= 20)
      {
        localObject = JPAKEUtil.calculateGA(this.p, this.gx1, this.gx3, this.gx4);
        BigInteger localBigInteger1 = JPAKEUtil.calculateS(this.password);
        BigInteger localBigInteger2 = JPAKEUtil.calculateX2s(this.q, this.x2, localBigInteger1);
        localBigInteger1 = JPAKEUtil.calculateA(this.p, this.q, (BigInteger)localObject, localBigInteger2);
        localObject = JPAKEUtil.calculateZeroKnowledgeProof(this.p, this.q, (BigInteger)localObject, localBigInteger1, localBigInteger2, this.participantId, this.digest, this.random);
        this.state = 30;
        return new JPAKERound2Payload(this.participantId, localBigInteger1, (BigInteger[])localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Round1 payload must be validated prior to creating Round2 payload for ");
      ((StringBuilder)localObject).append(this.participantId);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Round2 payload already created for ");
    ((StringBuilder)localObject).append(this.participantId);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public JPAKERound3Payload createRound3PayloadToSend(BigInteger paramBigInteger)
  {
    int i = this.state;
    if (i < 60)
    {
      if (i >= 50)
      {
        paramBigInteger = JPAKEUtil.calculateMacTag(this.participantId, this.partnerParticipantId, this.gx1, this.gx2, this.gx3, this.gx4, paramBigInteger, this.digest);
        this.state = 60;
        return new JPAKERound3Payload(this.participantId, paramBigInteger);
      }
      paramBigInteger = new StringBuilder();
      paramBigInteger.append("Keying material must be calculated prior to creating Round3 payload for ");
      paramBigInteger.append(this.participantId);
      throw new IllegalStateException(paramBigInteger.toString());
    }
    paramBigInteger = new StringBuilder();
    paramBigInteger.append("Round3 payload already created for ");
    paramBigInteger.append(this.participantId);
    throw new IllegalStateException(paramBigInteger.toString());
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public void validateRound1PayloadReceived(JPAKERound1Payload paramJPAKERound1Payload)
    throws CryptoException
  {
    if (this.state < 20)
    {
      this.partnerParticipantId = paramJPAKERound1Payload.getParticipantId();
      this.gx3 = paramJPAKERound1Payload.getGx1();
      this.gx4 = paramJPAKERound1Payload.getGx2();
      BigInteger[] arrayOfBigInteger1 = paramJPAKERound1Payload.getKnowledgeProofForX1();
      BigInteger[] arrayOfBigInteger2 = paramJPAKERound1Payload.getKnowledgeProofForX2();
      JPAKEUtil.validateParticipantIdsDiffer(this.participantId, paramJPAKERound1Payload.getParticipantId());
      JPAKEUtil.validateGx4(this.gx4);
      JPAKEUtil.validateZeroKnowledgeProof(this.p, this.q, this.g, this.gx3, arrayOfBigInteger1, paramJPAKERound1Payload.getParticipantId(), this.digest);
      JPAKEUtil.validateZeroKnowledgeProof(this.p, this.q, this.g, this.gx4, arrayOfBigInteger2, paramJPAKERound1Payload.getParticipantId(), this.digest);
      this.state = 20;
      return;
    }
    paramJPAKERound1Payload = new StringBuilder();
    paramJPAKERound1Payload.append("Validation already attempted for round1 payload for");
    paramJPAKERound1Payload.append(this.participantId);
    throw new IllegalStateException(paramJPAKERound1Payload.toString());
  }
  
  public void validateRound2PayloadReceived(JPAKERound2Payload paramJPAKERound2Payload)
    throws CryptoException
  {
    int i = this.state;
    if (i < 40)
    {
      if (i >= 20)
      {
        BigInteger localBigInteger = JPAKEUtil.calculateGA(this.p, this.gx3, this.gx1, this.gx2);
        this.b = paramJPAKERound2Payload.getA();
        BigInteger[] arrayOfBigInteger = paramJPAKERound2Payload.getKnowledgeProofForX2s();
        JPAKEUtil.validateParticipantIdsDiffer(this.participantId, paramJPAKERound2Payload.getParticipantId());
        JPAKEUtil.validateParticipantIdsEqual(this.partnerParticipantId, paramJPAKERound2Payload.getParticipantId());
        JPAKEUtil.validateGa(localBigInteger);
        JPAKEUtil.validateZeroKnowledgeProof(this.p, this.q, localBigInteger, this.b, arrayOfBigInteger, paramJPAKERound2Payload.getParticipantId(), this.digest);
        this.state = 40;
        return;
      }
      paramJPAKERound2Payload = new StringBuilder();
      paramJPAKERound2Payload.append("Round1 payload must be validated prior to validating Round2 payload for ");
      paramJPAKERound2Payload.append(this.participantId);
      throw new IllegalStateException(paramJPAKERound2Payload.toString());
    }
    paramJPAKERound2Payload = new StringBuilder();
    paramJPAKERound2Payload.append("Validation already attempted for round2 payload for");
    paramJPAKERound2Payload.append(this.participantId);
    throw new IllegalStateException(paramJPAKERound2Payload.toString());
  }
  
  public void validateRound3PayloadReceived(JPAKERound3Payload paramJPAKERound3Payload, BigInteger paramBigInteger)
    throws CryptoException
  {
    int i = this.state;
    if (i < 70)
    {
      if (i >= 50)
      {
        JPAKEUtil.validateParticipantIdsDiffer(this.participantId, paramJPAKERound3Payload.getParticipantId());
        JPAKEUtil.validateParticipantIdsEqual(this.partnerParticipantId, paramJPAKERound3Payload.getParticipantId());
        JPAKEUtil.validateMacTag(this.participantId, this.partnerParticipantId, this.gx1, this.gx2, this.gx3, this.gx4, paramBigInteger, this.digest, paramJPAKERound3Payload.getMacTag());
        this.gx1 = null;
        this.gx2 = null;
        this.gx3 = null;
        this.gx4 = null;
        this.state = 70;
        return;
      }
      paramJPAKERound3Payload = new StringBuilder();
      paramJPAKERound3Payload.append("Keying material must be calculated validated prior to validating Round3 payload for ");
      paramJPAKERound3Payload.append(this.participantId);
      throw new IllegalStateException(paramJPAKERound3Payload.toString());
    }
    paramJPAKERound3Payload = new StringBuilder();
    paramJPAKERound3Payload.append("Validation already attempted for round3 payload for");
    paramJPAKERound3Payload.append(this.participantId);
    throw new IllegalStateException(paramJPAKERound3Payload.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\jpake\JPAKEParticipant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */