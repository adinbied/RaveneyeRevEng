package org.bouncycastle.util.encoders;

public class UrlBase64Encoder
  extends Base64Encoder
{
  public UrlBase64Encoder()
  {
    this.encodingTable[(this.encodingTable.length - 2)] = 45;
    this.encodingTable[(this.encodingTable.length - 1)] = 95;
    this.padding = 46;
    initialiseDecodingTable();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\encoders\UrlBase64Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */