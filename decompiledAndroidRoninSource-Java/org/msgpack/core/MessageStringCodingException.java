package org.msgpack.core;

import java.nio.charset.CharacterCodingException;

public class MessageStringCodingException
  extends MessagePackException
{
  public MessageStringCodingException(String paramString, CharacterCodingException paramCharacterCodingException)
  {
    super(paramString, paramCharacterCodingException);
  }
  
  public MessageStringCodingException(CharacterCodingException paramCharacterCodingException)
  {
    super(paramCharacterCodingException);
  }
  
  public CharacterCodingException getCause()
  {
    return (CharacterCodingException)super.getCause();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\MessageStringCodingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */