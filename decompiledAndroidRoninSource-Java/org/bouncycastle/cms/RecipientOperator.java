package org.bouncycastle.cms;

import java.io.InputStream;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.util.io.TeeInputStream;

public class RecipientOperator
{
  private final AlgorithmIdentifier algorithmIdentifier;
  private final Object operator;
  
  public RecipientOperator(InputDecryptor paramInputDecryptor)
  {
    this.algorithmIdentifier = paramInputDecryptor.getAlgorithmIdentifier();
    this.operator = paramInputDecryptor;
  }
  
  public RecipientOperator(MacCalculator paramMacCalculator)
  {
    this.algorithmIdentifier = paramMacCalculator.getAlgorithmIdentifier();
    this.operator = paramMacCalculator;
  }
  
  public InputStream getInputStream(InputStream paramInputStream)
  {
    Object localObject = this.operator;
    if ((localObject instanceof InputDecryptor)) {
      return ((InputDecryptor)localObject).getInputStream(paramInputStream);
    }
    return new TeeInputStream(paramInputStream, ((MacCalculator)this.operator).getOutputStream());
  }
  
  public byte[] getMac()
  {
    return ((MacCalculator)this.operator).getMac();
  }
  
  public boolean isMacBased()
  {
    return this.operator instanceof MacCalculator;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\RecipientOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */