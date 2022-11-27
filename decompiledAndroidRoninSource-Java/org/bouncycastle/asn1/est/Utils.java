package org.bouncycastle.asn1.est;

class Utils
{
  static AttrOrOID[] clone(AttrOrOID[] paramArrayOfAttrOrOID)
  {
    AttrOrOID[] arrayOfAttrOrOID = new AttrOrOID[paramArrayOfAttrOrOID.length];
    System.arraycopy(paramArrayOfAttrOrOID, 0, arrayOfAttrOrOID, 0, paramArrayOfAttrOrOID.length);
    return arrayOfAttrOrOID;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\est\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */