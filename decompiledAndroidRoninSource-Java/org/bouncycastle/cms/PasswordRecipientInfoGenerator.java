package org.bouncycastle.cms;

import java.security.SecureRandom;
import java.util.Map;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import org.bouncycastle.asn1.cms.RecipientInfo;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.util.Arrays;

public abstract class PasswordRecipientInfoGenerator
  implements RecipientInfoGenerator
{
  private int blockSize;
  private int iterationCount;
  private ASN1ObjectIdentifier kekAlgorithm;
  private AlgorithmIdentifier keyDerivationAlgorithm;
  private int keySize;
  protected char[] password;
  private PasswordRecipient.PRF prf;
  private SecureRandom random;
  private byte[] salt;
  private int schemeID;
  
  protected PasswordRecipientInfoGenerator(ASN1ObjectIdentifier paramASN1ObjectIdentifier, char[] paramArrayOfChar)
  {
    this(paramASN1ObjectIdentifier, paramArrayOfChar, getKeySize(paramASN1ObjectIdentifier), ((Integer)PasswordRecipientInformation.BLOCKSIZES.get(paramASN1ObjectIdentifier)).intValue());
  }
  
  protected PasswordRecipientInfoGenerator(ASN1ObjectIdentifier paramASN1ObjectIdentifier, char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.password = paramArrayOfChar;
    this.schemeID = 1;
    this.kekAlgorithm = paramASN1ObjectIdentifier;
    this.keySize = paramInt1;
    this.blockSize = paramInt2;
    this.prf = PasswordRecipient.PRF.HMacSHA1;
    this.iterationCount = 1024;
  }
  
  private static int getKeySize(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Object localObject = (Integer)PasswordRecipientInformation.KEYSIZES.get(paramASN1ObjectIdentifier);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cannot find key size for algorithm: ");
    ((StringBuilder)localObject).append(paramASN1ObjectIdentifier);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  protected abstract byte[] calculateDerivedKey(int paramInt1, AlgorithmIdentifier paramAlgorithmIdentifier, int paramInt2)
    throws CMSException;
  
  public RecipientInfo generate(GenericKey paramGenericKey)
    throws CMSException
  {
    Object localObject1 = new byte[this.blockSize];
    if (this.random == null) {
      this.random = new SecureRandom();
    }
    this.random.nextBytes((byte[])localObject1);
    if (this.salt == null)
    {
      localObject2 = new byte[20];
      this.salt = ((byte[])localObject2);
      this.random.nextBytes((byte[])localObject2);
    }
    Object localObject2 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(this.salt, this.iterationCount, this.prf.prfAlgID));
    this.keyDerivationAlgorithm = ((AlgorithmIdentifier)localObject2);
    localObject2 = calculateDerivedKey(this.schemeID, (AlgorithmIdentifier)localObject2, this.keySize);
    paramGenericKey = new DEROctetString(generateEncryptedBytes(new AlgorithmIdentifier(this.kekAlgorithm, new DEROctetString((byte[])localObject1)), (byte[])localObject2, paramGenericKey));
    localObject2 = new ASN1EncodableVector();
    ((ASN1EncodableVector)localObject2).add(this.kekAlgorithm);
    ((ASN1EncodableVector)localObject2).add(new DEROctetString((byte[])localObject1));
    localObject1 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_PWRI_KEK, new DERSequence((ASN1EncodableVector)localObject2));
    return new RecipientInfo(new PasswordRecipientInfo(this.keyDerivationAlgorithm, (AlgorithmIdentifier)localObject1, paramGenericKey));
  }
  
  protected abstract byte[] generateEncryptedBytes(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte, GenericKey paramGenericKey)
    throws CMSException;
  
  public PasswordRecipientInfoGenerator setPRF(PasswordRecipient.PRF paramPRF)
  {
    this.prf = paramPRF;
    return this;
  }
  
  public PasswordRecipientInfoGenerator setPasswordConversionScheme(int paramInt)
  {
    this.schemeID = paramInt;
    return this;
  }
  
  public PasswordRecipientInfoGenerator setSaltAndIterationCount(byte[] paramArrayOfByte, int paramInt)
  {
    this.salt = Arrays.clone(paramArrayOfByte);
    this.iterationCount = paramInt;
    return this;
  }
  
  public PasswordRecipientInfoGenerator setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\PasswordRecipientInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */