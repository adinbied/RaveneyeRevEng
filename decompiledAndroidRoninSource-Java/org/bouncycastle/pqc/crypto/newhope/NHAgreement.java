package org.bouncycastle.pqc.crypto.newhope;

import org.bouncycastle.crypto.CipherParameters;

public class NHAgreement
{
  private NHPrivateKeyParameters privKey;
  
  public byte[] calculateAgreement(CipherParameters paramCipherParameters)
  {
    paramCipherParameters = (NHPublicKeyParameters)paramCipherParameters;
    byte[] arrayOfByte = new byte[32];
    NewHope.sharedA(arrayOfByte, this.privKey.secData, paramCipherParameters.pubData);
    return arrayOfByte;
  }
  
  public void init(CipherParameters paramCipherParameters)
  {
    this.privKey = ((NHPrivateKeyParameters)paramCipherParameters);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\newhope\NHAgreement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */