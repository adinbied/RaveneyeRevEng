package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser
{
  /* Error */
  public static JsonElement parseReader(JsonReader paramJsonReader)
    throws JsonIOException, JsonSyntaxException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 27	com/google/gson/stream/JsonReader:isLenient	()Z
    //   4: istore_1
    //   5: aload_0
    //   6: iconst_1
    //   7: invokevirtual 31	com/google/gson/stream/JsonReader:setLenient	(Z)V
    //   10: aload_0
    //   11: invokestatic 36	com/google/gson/internal/Streams:parse	(Lcom/google/gson/stream/JsonReader;)Lcom/google/gson/JsonElement;
    //   14: astore_2
    //   15: aload_0
    //   16: iload_1
    //   17: invokevirtual 31	com/google/gson/stream/JsonReader:setLenient	(Z)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_2
    //   23: goto +87 -> 110
    //   26: astore_2
    //   27: new 38	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   34: astore_3
    //   35: aload_3
    //   36: ldc 41
    //   38: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_3
    //   43: aload_0
    //   44: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: ldc 50
    //   51: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: new 52	com/google/gson/JsonParseException
    //   58: dup
    //   59: aload_3
    //   60: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: aload_2
    //   64: invokespecial 59	com/google/gson/JsonParseException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   67: athrow
    //   68: astore_2
    //   69: new 38	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   76: astore_3
    //   77: aload_3
    //   78: ldc 41
    //   80: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_3
    //   85: aload_0
    //   86: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_3
    //   91: ldc 50
    //   93: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: new 52	com/google/gson/JsonParseException
    //   100: dup
    //   101: aload_3
    //   102: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: aload_2
    //   106: invokespecial 59	com/google/gson/JsonParseException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   109: athrow
    //   110: aload_0
    //   111: iload_1
    //   112: invokevirtual 31	com/google/gson/stream/JsonReader:setLenient	(Z)V
    //   115: aload_2
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramJsonReader	JsonReader
    //   4	108	1	bool	boolean
    //   14	7	2	localJsonElement	JsonElement
    //   22	1	2	localObject	Object
    //   26	38	2	localOutOfMemoryError	OutOfMemoryError
    //   68	48	2	localStackOverflowError	StackOverflowError
    //   34	68	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   10	15	22	finally
    //   27	68	22	finally
    //   69	110	22	finally
    //   10	15	26	java/lang/OutOfMemoryError
    //   10	15	68	java/lang/StackOverflowError
  }
  
  public static JsonElement parseReader(Reader paramReader)
    throws JsonIOException, JsonSyntaxException
  {
    try
    {
      paramReader = new JsonReader(paramReader);
      JsonElement localJsonElement = parseReader(paramReader);
      if (!localJsonElement.isJsonNull())
      {
        if (paramReader.peek() == JsonToken.END_DOCUMENT) {
          return localJsonElement;
        }
        throw new JsonSyntaxException("Did not consume the entire document.");
      }
      return localJsonElement;
    }
    catch (NumberFormatException paramReader)
    {
      throw new JsonSyntaxException(paramReader);
    }
    catch (IOException paramReader)
    {
      throw new JsonIOException(paramReader);
    }
    catch (MalformedJsonException paramReader)
    {
      throw new JsonSyntaxException(paramReader);
    }
  }
  
  public static JsonElement parseString(String paramString)
    throws JsonSyntaxException
  {
    return parseReader(new StringReader(paramString));
  }
  
  @Deprecated
  public JsonElement parse(JsonReader paramJsonReader)
    throws JsonIOException, JsonSyntaxException
  {
    return parseReader(paramJsonReader);
  }
  
  @Deprecated
  public JsonElement parse(Reader paramReader)
    throws JsonIOException, JsonSyntaxException
  {
    return parseReader(paramReader);
  }
  
  @Deprecated
  public JsonElement parse(String paramString)
    throws JsonSyntaxException
  {
    return parseString(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\gson\JsonParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */