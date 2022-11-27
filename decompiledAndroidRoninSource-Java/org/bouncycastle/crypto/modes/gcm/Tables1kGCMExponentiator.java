package org.bouncycastle.crypto.modes.gcm;

import java.util.Vector;
import org.bouncycastle.util.Arrays;

public class Tables1kGCMExponentiator
  implements GCMExponentiator
{
  private Vector lookupPowX2;
  
  private void ensureAvailable(int paramInt)
  {
    int i = this.lookupPowX2.size();
    if (i <= paramInt)
    {
      int[] arrayOfInt = (int[])this.lookupPowX2.elementAt(i - 1);
      int j;
      do
      {
        arrayOfInt = Arrays.clone(arrayOfInt);
        GCMUtil.multiply(arrayOfInt, arrayOfInt);
        this.lookupPowX2.addElement(arrayOfInt);
        j = i + 1;
        i = j;
      } while (j <= paramInt);
    }
  }
  
  public void exponentiateX(long paramLong, byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = GCMUtil.oneAsInts();
    int i = 0;
    while (paramLong > 0L)
    {
      if ((1L & paramLong) != 0L)
      {
        ensureAvailable(i);
        GCMUtil.multiply(arrayOfInt, (int[])this.lookupPowX2.elementAt(i));
      }
      i += 1;
      paramLong >>>= 1;
    }
    GCMUtil.asBytes(arrayOfInt, paramArrayOfByte);
  }
  
  public void init(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = GCMUtil.asInts(paramArrayOfByte);
    Vector localVector = this.lookupPowX2;
    if ((localVector != null) && (Arrays.areEqual(paramArrayOfByte, (int[])localVector.elementAt(0)))) {
      return;
    }
    localVector = new Vector(8);
    this.lookupPowX2 = localVector;
    localVector.addElement(paramArrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\gcm\Tables1kGCMExponentiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */