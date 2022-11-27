package org.bouncycastle.crypto;

public class BufferedAsymmetricBlockCipher
{
  protected byte[] buf;
  protected int bufOff;
  private final AsymmetricBlockCipher cipher;
  
  public BufferedAsymmetricBlockCipher(AsymmetricBlockCipher paramAsymmetricBlockCipher)
  {
    this.cipher = paramAsymmetricBlockCipher;
  }
  
  public byte[] doFinal()
    throws InvalidCipherTextException
  {
    byte[] arrayOfByte = this.cipher.processBlock(this.buf, 0, this.bufOff);
    reset();
    return arrayOfByte;
  }
  
  public int getBufferPosition()
  {
    return this.bufOff;
  }
  
  public int getInputBlockSize()
  {
    return this.cipher.getInputBlockSize();
  }
  
  public int getOutputBlockSize()
  {
    return this.cipher.getOutputBlockSize();
  }
  
  public AsymmetricBlockCipher getUnderlyingCipher()
  {
    return this.cipher;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:598)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void processByte(byte paramByte)
  {
    int i = this.bufOff;
    byte[] arrayOfByte = this.buf;
    if (i < arrayOfByte.length)
    {
      this.bufOff = (i + 1);
      arrayOfByte[i] = paramByte;
      return;
    }
    throw new DataLengthException("attempt to process message too long for cipher");
  }
  
  public void processBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return;
    }
    if (paramInt2 >= 0)
    {
      int i = this.bufOff;
      byte[] arrayOfByte = this.buf;
      if (i + paramInt2 <= arrayOfByte.length)
      {
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, i, paramInt2);
        this.bufOff += paramInt2;
        return;
      }
      throw new DataLengthException("attempt to process message too long for cipher");
    }
    throw new IllegalArgumentException("Can't have a negative input length!");
  }
  
  public void reset()
  {
    if (this.buf != null)
    {
      int i = 0;
      for (;;)
      {
        byte[] arrayOfByte = this.buf;
        if (i >= arrayOfByte.length) {
          break;
        }
        arrayOfByte[i] = 0;
        i += 1;
      }
    }
    this.bufOff = 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\BufferedAsymmetricBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */