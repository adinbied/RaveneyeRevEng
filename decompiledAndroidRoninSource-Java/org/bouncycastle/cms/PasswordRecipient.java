package org.bouncycastle.cms;

import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public abstract interface PasswordRecipient
  extends Recipient
{
  public static final int PKCS5_SCHEME2 = 0;
  public static final int PKCS5_SCHEME2_UTF8 = 1;
  
  public abstract byte[] calculateDerivedKey(int paramInt1, AlgorithmIdentifier paramAlgorithmIdentifier, int paramInt2)
    throws CMSException;
  
  public abstract char[] getPassword();
  
  public abstract int getPasswordConversionScheme();
  
  public abstract RecipientOperator getRecipientOperator(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws CMSException;
  
  public static final class PRF
  {
    public static final PRF HMacSHA1 = new PRF("HMacSHA1", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA1, DERNull.INSTANCE));
    public static final PRF HMacSHA224 = new PRF("HMacSHA224", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA224, DERNull.INSTANCE));
    public static final PRF HMacSHA256 = new PRF("HMacSHA256", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA256, DERNull.INSTANCE));
    public static final PRF HMacSHA384 = new PRF("HMacSHA384", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA384, DERNull.INSTANCE));
    public static final PRF HMacSHA512 = new PRF("HMacSHA512", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, DERNull.INSTANCE));
    private final String hmac;
    final AlgorithmIdentifier prfAlgID;
    
    private PRF(String paramString, AlgorithmIdentifier paramAlgorithmIdentifier)
    {
      this.hmac = paramString;
      this.prfAlgID = paramAlgorithmIdentifier;
    }
    
    public AlgorithmIdentifier getAlgorithmID()
    {
      return this.prfAlgID;
    }
    
    public String getName()
    {
      return this.hmac;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\PasswordRecipient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */