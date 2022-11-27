package org.bouncycastle.asn1.util;

import java.io.FileInputStream;
import java.io.PrintStream;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;

public class Dump
{
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    paramArrayOfString = new ASN1InputStream(new FileInputStream(paramArrayOfString[0]));
    for (;;)
    {
      ASN1Primitive localASN1Primitive = paramArrayOfString.readObject();
      if (localASN1Primitive == null) {
        break;
      }
      System.out.println(ASN1Dump.dumpAsString(localASN1Primitive));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn\\util\Dump.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */