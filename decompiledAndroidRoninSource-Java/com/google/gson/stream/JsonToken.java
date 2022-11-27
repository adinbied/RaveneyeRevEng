package com.google.gson.stream;

public enum JsonToken
{
  static
  {
    BEGIN_OBJECT = new JsonToken("BEGIN_OBJECT", 2);
    END_OBJECT = new JsonToken("END_OBJECT", 3);
    NAME = new JsonToken("NAME", 4);
    STRING = new JsonToken("STRING", 5);
    NUMBER = new JsonToken("NUMBER", 6);
    BOOLEAN = new JsonToken("BOOLEAN", 7);
    NULL = new JsonToken("NULL", 8);
    JsonToken localJsonToken = new JsonToken("END_DOCUMENT", 9);
    END_DOCUMENT = localJsonToken;
    $VALUES = new JsonToken[] { BEGIN_ARRAY, END_ARRAY, BEGIN_OBJECT, END_OBJECT, NAME, STRING, NUMBER, BOOLEAN, NULL, localJsonToken };
  }
  
  private JsonToken() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\gson\stream\JsonToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */