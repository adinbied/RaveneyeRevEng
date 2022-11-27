package dji.midware.encryption.util;

public class SDKRegistration
{
  private static SDKRegistration instance;
  
  public static SDKRegistration getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new SDKRegistration();
      }
      SDKRegistration localSDKRegistration = instance;
      return localSDKRegistration;
    }
    finally {}
  }
  
  public String getFileContentforServer(String paramString1, String paramString2)
  {
    return null;
  }
  
  public String getLocalFileContent(String paramString1, String paramString2)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\encryptio\\util\SDKRegistration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */