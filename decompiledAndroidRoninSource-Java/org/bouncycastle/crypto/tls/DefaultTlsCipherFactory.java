package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.engines.CamelliaEngine;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.engines.RC4Engine;
import org.bouncycastle.crypto.engines.SEEDEngine;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CCMBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.modes.OCBBlockCipher;

public class DefaultTlsCipherFactory
  extends AbstractTlsCipherFactory
{
  protected AEADBlockCipher createAEADBlockCipher_AES_CCM()
  {
    return new CCMBlockCipher(createAESEngine());
  }
  
  protected AEADBlockCipher createAEADBlockCipher_AES_GCM()
  {
    return new GCMBlockCipher(createAESEngine());
  }
  
  protected AEADBlockCipher createAEADBlockCipher_AES_OCB()
  {
    return new OCBBlockCipher(createAESEngine(), createAESEngine());
  }
  
  protected AEADBlockCipher createAEADBlockCipher_Camellia_GCM()
  {
    return new GCMBlockCipher(createCamelliaEngine());
  }
  
  protected BlockCipher createAESBlockCipher()
  {
    return new CBCBlockCipher(createAESEngine());
  }
  
  protected TlsBlockCipher createAESCipher(TlsContext paramTlsContext, int paramInt1, int paramInt2)
    throws IOException
  {
    return new TlsBlockCipher(paramTlsContext, createAESBlockCipher(), createAESBlockCipher(), createHMACDigest(paramInt2), createHMACDigest(paramInt2), paramInt1);
  }
  
  protected BlockCipher createAESEngine()
  {
    return new AESEngine();
  }
  
  protected BlockCipher createCamelliaBlockCipher()
  {
    return new CBCBlockCipher(createCamelliaEngine());
  }
  
  protected TlsBlockCipher createCamelliaCipher(TlsContext paramTlsContext, int paramInt1, int paramInt2)
    throws IOException
  {
    return new TlsBlockCipher(paramTlsContext, createCamelliaBlockCipher(), createCamelliaBlockCipher(), createHMACDigest(paramInt2), createHMACDigest(paramInt2), paramInt1);
  }
  
  protected BlockCipher createCamelliaEngine()
  {
    return new CamelliaEngine();
  }
  
  protected TlsCipher createChaCha20Poly1305(TlsContext paramTlsContext)
    throws IOException
  {
    return new Chacha20Poly1305(paramTlsContext);
  }
  
  public TlsCipher createCipher(TlsContext paramTlsContext, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 2)
      {
        switch (paramInt1)
        {
        default: 
          switch (paramInt1)
          {
          default: 
            throw new TlsFatalAlert((short)80);
          case 104: 
            return createCipher_AES_OCB(paramTlsContext, 32, 12);
          case 103: 
            return createCipher_AES_OCB(paramTlsContext, 16, 12);
          }
          return createChaCha20Poly1305(paramTlsContext);
        case 20: 
          return createCipher_Camellia_GCM(paramTlsContext, 32, 16);
        case 19: 
          return createCipher_Camellia_GCM(paramTlsContext, 16, 16);
        case 18: 
          return createCipher_AES_CCM(paramTlsContext, 32, 8);
        case 17: 
          return createCipher_AES_CCM(paramTlsContext, 32, 16);
        case 16: 
          return createCipher_AES_CCM(paramTlsContext, 16, 8);
        case 15: 
          return createCipher_AES_CCM(paramTlsContext, 16, 16);
        case 14: 
          return createSEEDCipher(paramTlsContext, paramInt2);
        case 13: 
          return createCamelliaCipher(paramTlsContext, 32, paramInt2);
        case 12: 
          return createCamelliaCipher(paramTlsContext, 16, paramInt2);
        case 11: 
          return createCipher_AES_GCM(paramTlsContext, 32, 16);
        case 10: 
          return createCipher_AES_GCM(paramTlsContext, 16, 16);
        case 9: 
          return createAESCipher(paramTlsContext, 32, paramInt2);
        case 8: 
          return createAESCipher(paramTlsContext, 16, paramInt2);
        }
        return createDESedeCipher(paramTlsContext, paramInt2);
      }
      return createRC4Cipher(paramTlsContext, 16, paramInt2);
    }
    return createNullCipher(paramTlsContext, paramInt2);
  }
  
  protected TlsAEADCipher createCipher_AES_CCM(TlsContext paramTlsContext, int paramInt1, int paramInt2)
    throws IOException
  {
    return new TlsAEADCipher(paramTlsContext, createAEADBlockCipher_AES_CCM(), createAEADBlockCipher_AES_CCM(), paramInt1, paramInt2);
  }
  
  protected TlsAEADCipher createCipher_AES_GCM(TlsContext paramTlsContext, int paramInt1, int paramInt2)
    throws IOException
  {
    return new TlsAEADCipher(paramTlsContext, createAEADBlockCipher_AES_GCM(), createAEADBlockCipher_AES_GCM(), paramInt1, paramInt2);
  }
  
  protected TlsAEADCipher createCipher_AES_OCB(TlsContext paramTlsContext, int paramInt1, int paramInt2)
    throws IOException
  {
    return new TlsAEADCipher(paramTlsContext, createAEADBlockCipher_AES_OCB(), createAEADBlockCipher_AES_OCB(), paramInt1, paramInt2, 2);
  }
  
  protected TlsAEADCipher createCipher_Camellia_GCM(TlsContext paramTlsContext, int paramInt1, int paramInt2)
    throws IOException
  {
    return new TlsAEADCipher(paramTlsContext, createAEADBlockCipher_Camellia_GCM(), createAEADBlockCipher_Camellia_GCM(), paramInt1, paramInt2);
  }
  
  protected BlockCipher createDESedeBlockCipher()
  {
    return new CBCBlockCipher(new DESedeEngine());
  }
  
  protected TlsBlockCipher createDESedeCipher(TlsContext paramTlsContext, int paramInt)
    throws IOException
  {
    return new TlsBlockCipher(paramTlsContext, createDESedeBlockCipher(), createDESedeBlockCipher(), createHMACDigest(paramInt), createHMACDigest(paramInt), 24);
  }
  
  protected Digest createHMACDigest(int paramInt)
    throws IOException
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt == 5) {
                return TlsUtils.createHash((short)6);
              }
              throw new TlsFatalAlert((short)80);
            }
            return TlsUtils.createHash((short)5);
          }
          return TlsUtils.createHash((short)4);
        }
        return TlsUtils.createHash((short)2);
      }
      return TlsUtils.createHash((short)1);
    }
    return null;
  }
  
  protected TlsNullCipher createNullCipher(TlsContext paramTlsContext, int paramInt)
    throws IOException
  {
    return new TlsNullCipher(paramTlsContext, createHMACDigest(paramInt), createHMACDigest(paramInt));
  }
  
  protected TlsStreamCipher createRC4Cipher(TlsContext paramTlsContext, int paramInt1, int paramInt2)
    throws IOException
  {
    return new TlsStreamCipher(paramTlsContext, createRC4StreamCipher(), createRC4StreamCipher(), createHMACDigest(paramInt2), createHMACDigest(paramInt2), paramInt1, false);
  }
  
  protected StreamCipher createRC4StreamCipher()
  {
    return new RC4Engine();
  }
  
  protected BlockCipher createSEEDBlockCipher()
  {
    return new CBCBlockCipher(new SEEDEngine());
  }
  
  protected TlsBlockCipher createSEEDCipher(TlsContext paramTlsContext, int paramInt)
    throws IOException
  {
    return new TlsBlockCipher(paramTlsContext, createSEEDBlockCipher(), createSEEDBlockCipher(), createHMACDigest(paramInt), createHMACDigest(paramInt), 16);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DefaultTlsCipherFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */