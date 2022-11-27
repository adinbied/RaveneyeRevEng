package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class AEADParameters
  implements CipherParameters
{
  private byte[] associatedText;
  private KeyParameter key;
  private int macSize;
  private byte[] nonce;
  
  public AEADParameters(KeyParameter paramKeyParameter, int paramInt, byte[] paramArrayOfByte)
  {
    this(paramKeyParameter, paramInt, paramArrayOfByte, null);
  }
  
  public AEADParameters(KeyParameter paramKeyParameter, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.key = paramKeyParameter;
    this.nonce = paramArrayOfByte1;
    this.macSize = paramInt;
    this.associatedText = paramArrayOfByte2;
  }
  
  public byte[] getAssociatedText()
  {
    return this.associatedText;
  }
  
  public KeyParameter getKey()
  {
    return this.key;
  }
  
  public int getMacSize()
  {
    return this.macSize;
  }
  
  public byte[] getNonce()
  {
    return this.nonce;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\AEADParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */