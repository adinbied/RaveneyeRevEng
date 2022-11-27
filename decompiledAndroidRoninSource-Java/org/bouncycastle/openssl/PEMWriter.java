package org.bouncycastle.openssl;

import java.io.IOException;
import java.io.Writer;
import org.bouncycastle.openssl.jcajce.JcaMiscPEMGenerator;
import org.bouncycastle.util.io.pem.PemGenerationException;
import org.bouncycastle.util.io.pem.PemObjectGenerator;
import org.bouncycastle.util.io.pem.PemWriter;

public class PEMWriter
  extends PemWriter
{
  public PEMWriter(Writer paramWriter)
  {
    super(paramWriter);
  }
  
  public void writeObject(Object paramObject)
    throws IOException
  {
    writeObject(paramObject, null);
  }
  
  public void writeObject(Object paramObject, PEMEncryptor paramPEMEncryptor)
    throws IOException
  {
    try
    {
      super.writeObject(new JcaMiscPEMGenerator(paramObject, paramPEMEncryptor));
      return;
    }
    catch (PemGenerationException paramObject)
    {
      if ((((PemGenerationException)paramObject).getCause() instanceof IOException)) {
        throw ((IOException)((PemGenerationException)paramObject).getCause());
      }
      throw ((Throwable)paramObject);
    }
  }
  
  public void writeObject(PemObjectGenerator paramPemObjectGenerator)
    throws IOException
  {
    super.writeObject(paramPemObjectGenerator);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\PEMWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */