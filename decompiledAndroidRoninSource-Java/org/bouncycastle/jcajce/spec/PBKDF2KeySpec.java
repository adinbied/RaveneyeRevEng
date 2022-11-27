package org.bouncycastle.jcajce.spec;

import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class PBKDF2KeySpec
  extends PBEKeySpec
{
  private static final AlgorithmIdentifier defaultPRF = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA1, DERNull.INSTANCE);
  private AlgorithmIdentifier prf;
  
  public PBKDF2KeySpec(char[] paramArrayOfChar, byte[] paramArrayOfByte, int paramInt1, int paramInt2, AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    super(paramArrayOfChar, paramArrayOfByte, paramInt1, paramInt2);
    this.prf = paramAlgorithmIdentifier;
  }
  
  public AlgorithmIdentifier getPrf()
  {
    return this.prf;
  }
  
  public boolean isDefaultPrf()
  {
    return defaultPRF.equals(this.prf);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\spec\PBKDF2KeySpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */