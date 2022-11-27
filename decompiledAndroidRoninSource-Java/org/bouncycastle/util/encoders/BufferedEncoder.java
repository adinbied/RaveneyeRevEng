package org.bouncycastle.util.encoders;

public class BufferedEncoder
{
  protected byte[] buf;
  protected int bufOff;
  protected Translator translator;
  
  public BufferedEncoder(Translator paramTranslator, int paramInt)
  {
    this.translator = paramTranslator;
    if (paramInt % paramTranslator.getEncodedBlockSize() == 0)
    {
      this.buf = new byte[paramInt];
      this.bufOff = 0;
      return;
    }
    throw new IllegalArgumentException("buffer size not multiple of input block size");
  }
  
  public int processByte(byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = this.buf;
    int i = this.bufOff;
    int j = i + 1;
    this.bufOff = j;
    arrayOfByte[i] = paramByte;
    int k = arrayOfByte.length;
    i = 0;
    if (j == k)
    {
      i = this.translator.encode(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte, paramInt);
      this.bufOff = 0;
    }
    return i;
  }
  
  public int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    if (paramInt2 >= 0)
    {
      Object localObject = this.buf;
      int i = localObject.length;
      int n = this.bufOff;
      int m = i - n;
      int k = 0;
      int j = paramInt1;
      i = paramInt2;
      if (paramInt2 > m)
      {
        System.arraycopy(paramArrayOfByte1, paramInt1, localObject, n, m);
        localObject = this.translator;
        byte[] arrayOfByte = this.buf;
        i = ((Translator)localObject).encode(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte2, paramInt3) + 0;
        this.bufOff = 0;
        paramInt2 -= m;
        paramInt1 += m;
        j = paramInt2 - paramInt2 % this.buf.length;
        k = i + this.translator.encode(paramArrayOfByte1, paramInt1, j, paramArrayOfByte2, paramInt3 + i);
        i = paramInt2 - j;
        j = paramInt1 + j;
      }
      if (i != 0)
      {
        System.arraycopy(paramArrayOfByte1, j, this.buf, this.bufOff, i);
        this.bufOff += i;
      }
      return k;
    }
    throw new IllegalArgumentException("Can't have a negative input length!");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\encoders\BufferedEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */