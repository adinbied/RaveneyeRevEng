package org.bouncycastle.crypto.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.generators.DESedeKeyGenerator;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.util.encoders.Hex;

public class DESExample
{
  private PaddedBufferedBlockCipher cipher;
  private boolean encrypt = true;
  private BufferedInputStream in;
  private byte[] key;
  private BufferedOutputStream out;
  
  public DESExample()
  {
    this.cipher = null;
    this.in = null;
    this.out = null;
    this.key = null;
  }
  
  public DESExample(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    str = null;
    this.cipher = null;
    this.in = null;
    this.out = null;
    this.key = null;
    this.encrypt = paramBoolean;
    try
    {
      this.in = new BufferedInputStream(new FileInputStream(paramString1));
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject;
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    localObject = System.err;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Input file not found [");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("]");
    ((PrintStream)localObject).println(localStringBuilder.toString());
    System.exit(1);
    try
    {
      this.out = new BufferedOutputStream(new FileOutputStream(paramString2));
    }
    catch (IOException paramString1)
    {
      for (;;) {}
    }
    paramString1 = System.err;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Output file not created [");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("]");
    paramString1.println(((StringBuilder)localObject).toString());
    System.exit(1);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramString1 = new SecureRandom();
      }
      catch (Exception paramString1)
      {
        int i;
        paramString1 = str;
        continue;
      }
      catch (IOException paramString1)
      {
        continue;
      }
      try
      {
        paramString1.setSeed("www.bouncycastle.org".getBytes());
      }
      catch (Exception paramString2) {}
    }
    System.err.println("Hmmm, no SHA1PRNG, you need the Sun implementation");
    System.exit(1);
    paramString1 = new KeyGenerationParameters(paramString1, 192);
    paramString2 = new DESedeKeyGenerator();
    paramString2.init(paramString1);
    this.key = paramString2.generateKey();
    paramString1 = new BufferedOutputStream(new FileOutputStream(paramString3));
    paramString2 = Hex.encode(this.key);
    paramString1.write(paramString2, 0, paramString2.length);
    paramString1.flush();
    paramString1.close();
    return;
    paramString1 = System.err;
    paramString2 = new StringBuilder();
    str = "Could not decryption create key file [";
    try
    {
      paramString1 = new BufferedInputStream(new FileInputStream(paramString3));
      i = paramString1.available();
      paramString2 = new byte[i];
      paramString1.read(paramString2, 0, i);
      this.key = Hex.decode(paramString2);
      return;
    }
    catch (IOException paramString1)
    {
      for (;;) {}
    }
    paramString1 = System.err;
    paramString2 = new StringBuilder();
    str = "Decryption key file not found, or not valid [";
    paramString2.append(str);
    paramString2.append(paramString3);
    paramString2.append("]");
    paramString1.println(paramString2.toString());
    System.exit(1);
  }
  
  public static void main(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    boolean bool = true;
    if (i < 2)
    {
      localObject1 = new DESExample();
      localObject2 = System.err;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Usage: java ");
      localStringBuilder.append(localObject1.getClass().getName());
      localStringBuilder.append(" infile outfile [keyfile]");
      ((PrintStream)localObject2).println(localStringBuilder.toString());
      System.exit(1);
    }
    Object localObject1 = paramArrayOfString[0];
    Object localObject2 = paramArrayOfString[1];
    if (paramArrayOfString.length > 2)
    {
      paramArrayOfString = paramArrayOfString[2];
      bool = false;
    }
    else
    {
      paramArrayOfString = "deskey.dat";
    }
    new DESExample((String)localObject1, (String)localObject2, paramArrayOfString, bool).process();
  }
  
  /* Error */
  private void performDecrypt(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	org/bouncycastle/crypto/examples/DESExample:cipher	Lorg/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher;
    //   4: iconst_0
    //   5: new 177	org/bouncycastle/crypto/params/KeyParameter
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 179	org/bouncycastle/crypto/params/KeyParameter:<init>	([B)V
    //   13: invokevirtual 184	org/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher:init	(ZLorg/bouncycastle/crypto/CipherParameters;)V
    //   16: new 186	java/io/BufferedReader
    //   19: dup
    //   20: new 188	java/io/InputStreamReader
    //   23: dup
    //   24: aload_0
    //   25: getfield 24	org/bouncycastle/crypto/examples/DESExample:in	Ljava/io/BufferedInputStream;
    //   28: invokespecial 189	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   31: invokespecial 192	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: astore 4
    //   36: aconst_null
    //   37: astore_1
    //   38: aload 4
    //   40: invokevirtual 195	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +55 -> 100
    //   48: aload_3
    //   49: invokestatic 198	org/bouncycastle/util/encoders/Hex:decode	(Ljava/lang/String;)[B
    //   52: astore_1
    //   53: aload_0
    //   54: getfield 22	org/bouncycastle/crypto/examples/DESExample:cipher	Lorg/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher;
    //   57: aload_1
    //   58: arraylength
    //   59: invokevirtual 202	org/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher:getOutputSize	(I)I
    //   62: newarray <illegal type>
    //   64: astore_3
    //   65: aload_0
    //   66: getfield 22	org/bouncycastle/crypto/examples/DESExample:cipher	Lorg/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher;
    //   69: aload_1
    //   70: iconst_0
    //   71: aload_1
    //   72: arraylength
    //   73: aload_3
    //   74: iconst_0
    //   75: invokevirtual 206	org/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher:processBytes	([BII[BI)I
    //   78: istore_2
    //   79: aload_3
    //   80: astore_1
    //   81: iload_2
    //   82: ifle -44 -> 38
    //   85: aload_0
    //   86: getfield 26	org/bouncycastle/crypto/examples/DESExample:out	Ljava/io/BufferedOutputStream;
    //   89: aload_3
    //   90: iconst_0
    //   91: iload_2
    //   92: invokevirtual 128	java/io/BufferedOutputStream:write	([BII)V
    //   95: aload_3
    //   96: astore_1
    //   97: goto -59 -> 38
    //   100: aload_0
    //   101: getfield 22	org/bouncycastle/crypto/examples/DESExample:cipher	Lorg/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher;
    //   104: aload_1
    //   105: iconst_0
    //   106: invokevirtual 210	org/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher:doFinal	([BI)I
    //   109: istore_2
    //   110: iload_2
    //   111: ifle +19 -> 130
    //   114: aload_0
    //   115: getfield 26	org/bouncycastle/crypto/examples/DESExample:out	Ljava/io/BufferedOutputStream;
    //   118: aload_1
    //   119: iconst_0
    //   120: iload_2
    //   121: invokevirtual 128	java/io/BufferedOutputStream:write	([BII)V
    //   124: return
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   130: return
    //   131: astore_1
    //   132: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	DESExample
    //   0	133	1	paramArrayOfByte	byte[]
    //   78	43	2	i	int
    //   43	53	3	localObject	Object
    //   34	5	4	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   38	44	125	java/io/IOException
    //   48	79	125	java/io/IOException
    //   85	95	125	java/io/IOException
    //   100	110	125	java/io/IOException
    //   114	124	125	java/io/IOException
    //   100	110	131	org/bouncycastle/crypto/CryptoException
    //   114	124	131	org/bouncycastle/crypto/CryptoException
  }
  
  /* Error */
  private void performEncrypt(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	org/bouncycastle/crypto/examples/DESExample:cipher	Lorg/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher;
    //   4: iconst_1
    //   5: new 177	org/bouncycastle/crypto/params/KeyParameter
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 179	org/bouncycastle/crypto/params/KeyParameter:<init>	([B)V
    //   13: invokevirtual 184	org/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher:init	(ZLorg/bouncycastle/crypto/CipherParameters;)V
    //   16: aload_0
    //   17: getfield 22	org/bouncycastle/crypto/examples/DESExample:cipher	Lorg/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher;
    //   20: bipush 47
    //   22: invokevirtual 202	org/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher:getOutputSize	(I)I
    //   25: istore_2
    //   26: bipush 47
    //   28: newarray <illegal type>
    //   30: astore_1
    //   31: iload_2
    //   32: newarray <illegal type>
    //   34: astore_3
    //   35: aload_0
    //   36: getfield 24	org/bouncycastle/crypto/examples/DESExample:in	Ljava/io/BufferedInputStream;
    //   39: aload_1
    //   40: iconst_0
    //   41: bipush 47
    //   43: invokevirtual 144	java/io/BufferedInputStream:read	([BII)I
    //   46: istore_2
    //   47: iload_2
    //   48: ifle +53 -> 101
    //   51: aload_0
    //   52: getfield 22	org/bouncycastle/crypto/examples/DESExample:cipher	Lorg/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher;
    //   55: aload_1
    //   56: iconst_0
    //   57: iload_2
    //   58: aload_3
    //   59: iconst_0
    //   60: invokevirtual 206	org/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher:processBytes	([BII[BI)I
    //   63: istore_2
    //   64: iload_2
    //   65: ifle -30 -> 35
    //   68: aload_3
    //   69: iconst_0
    //   70: iload_2
    //   71: invokestatic 217	org/bouncycastle/util/encoders/Hex:encode	([BII)[B
    //   74: astore 4
    //   76: aload_0
    //   77: getfield 26	org/bouncycastle/crypto/examples/DESExample:out	Ljava/io/BufferedOutputStream;
    //   80: aload 4
    //   82: iconst_0
    //   83: aload 4
    //   85: arraylength
    //   86: invokevirtual 128	java/io/BufferedOutputStream:write	([BII)V
    //   89: aload_0
    //   90: getfield 26	org/bouncycastle/crypto/examples/DESExample:out	Ljava/io/BufferedOutputStream;
    //   93: bipush 10
    //   95: invokevirtual 219	java/io/BufferedOutputStream:write	(I)V
    //   98: goto -63 -> 35
    //   101: aload_0
    //   102: getfield 22	org/bouncycastle/crypto/examples/DESExample:cipher	Lorg/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher;
    //   105: aload_3
    //   106: iconst_0
    //   107: invokevirtual 210	org/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher:doFinal	([BI)I
    //   110: istore_2
    //   111: iload_2
    //   112: ifle +36 -> 148
    //   115: aload_3
    //   116: iconst_0
    //   117: iload_2
    //   118: invokestatic 217	org/bouncycastle/util/encoders/Hex:encode	([BII)[B
    //   121: astore_1
    //   122: aload_0
    //   123: getfield 26	org/bouncycastle/crypto/examples/DESExample:out	Ljava/io/BufferedOutputStream;
    //   126: aload_1
    //   127: iconst_0
    //   128: aload_1
    //   129: arraylength
    //   130: invokevirtual 128	java/io/BufferedOutputStream:write	([BII)V
    //   133: aload_0
    //   134: getfield 26	org/bouncycastle/crypto/examples/DESExample:out	Ljava/io/BufferedOutputStream;
    //   137: bipush 10
    //   139: invokevirtual 219	java/io/BufferedOutputStream:write	(I)V
    //   142: return
    //   143: astore_1
    //   144: aload_1
    //   145: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   148: return
    //   149: astore_1
    //   150: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	DESExample
    //   0	151	1	paramArrayOfByte	byte[]
    //   25	93	2	i	int
    //   34	82	3	arrayOfByte1	byte[]
    //   74	10	4	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   35	47	143	java/io/IOException
    //   51	64	143	java/io/IOException
    //   68	98	143	java/io/IOException
    //   101	111	143	java/io/IOException
    //   115	142	143	java/io/IOException
    //   101	111	149	org/bouncycastle/crypto/CryptoException
    //   115	142	149	org/bouncycastle/crypto/CryptoException
  }
  
  private void process()
  {
    this.cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new DESedeEngine()));
    if (this.encrypt) {
      performEncrypt(this.key);
    } else {
      performDecrypt(this.key);
    }
    try
    {
      this.in.close();
      this.out.flush();
      this.out.close();
      return;
    }
    catch (IOException localIOException)
    {
      PrintStream localPrintStream = System.err;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception closing resources: ");
      localStringBuilder.append(localIOException.getMessage());
      localPrintStream.println(localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\examples\DESExample.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */