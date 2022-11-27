package io.flutter.embedding.engine.dart;

public abstract interface PlatformMessageHandler
{
  public abstract void handleMessageFromDart(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public abstract void handlePlatformMessageResponse(int paramInt, byte[] paramArrayOfByte);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\dart\PlatformMessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */