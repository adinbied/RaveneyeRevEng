package org.bouncycastle.cert.dane;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class DANEEntrySelectorFactory
{
  private final DigestCalculator digestCalculator;
  
  public DANEEntrySelectorFactory(DigestCalculator paramDigestCalculator)
  {
    this.digestCalculator = paramDigestCalculator;
  }
  
  public DANEEntrySelector createSelector(String paramString)
    throws DANEException
  {
    Object localObject1 = Strings.toUTF8ByteArray(paramString.substring(0, paramString.indexOf('@')));
    try
    {
      Object localObject2 = this.digestCalculator.getOutputStream();
      ((OutputStream)localObject2).write((byte[])localObject1);
      ((OutputStream)localObject2).close();
      localObject1 = this.digestCalculator.getDigest();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(Strings.fromByteArray(Hex.encode((byte[])localObject1)));
      ((StringBuilder)localObject2).append("._smimecert.");
      ((StringBuilder)localObject2).append(paramString.substring(paramString.indexOf('@') + 1));
      return new DANEEntrySelector(((StringBuilder)localObject2).toString());
    }
    catch (IOException paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Unable to calculate digest string: ");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      throw new DANEException(((StringBuilder)localObject1).toString(), paramString);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\dane\DANEEntrySelectorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */