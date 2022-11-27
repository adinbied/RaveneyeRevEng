package dji.utils;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import dji.log.DJILog;
import java.io.Reader;
import java.lang.reflect.Type;

public final class GsonUtils
{
  private static final String TAG = "gson";
  private static volatile Gson sGson;
  
  public static <T> T fromJson(JsonElement paramJsonElement, Class<T> paramClass)
  {
    if (paramJsonElement != null) {
      if (paramClass == null) {
        return null;
      }
    }
    try
    {
      localObject = getInstance().fromJson(paramJsonElement, paramClass);
      return (T)localObject;
    }
    catch (JsonSyntaxException localJsonSyntaxException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fromJson Error: target[");
    ((StringBuilder)localObject).append(paramClass);
    ((StringBuilder)localObject).append("], src[");
    ((StringBuilder)localObject).append(paramJsonElement);
    ((StringBuilder)localObject).append("]");
    DJILog.logWriteE("gson", ((StringBuilder)localObject).toString(), new Object[0]);
    return null;
  }
  
  public static <T> T fromJson(JsonElement paramJsonElement, Type paramType)
  {
    if (paramJsonElement != null) {
      if (paramType == null) {
        return null;
      }
    }
    try
    {
      localObject = getInstance().fromJson(paramJsonElement, paramType);
      return (T)localObject;
    }
    catch (JsonSyntaxException localJsonSyntaxException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fromJson Error: target[");
    ((StringBuilder)localObject).append(paramType);
    ((StringBuilder)localObject).append("], src[");
    ((StringBuilder)localObject).append(paramJsonElement);
    ((StringBuilder)localObject).append("]");
    DJILog.logWriteE("gson", ((StringBuilder)localObject).toString(), new Object[0]);
    return null;
  }
  
  public static <T> T fromJson(JsonReader paramJsonReader, Type paramType)
  {
    if (paramJsonReader != null) {
      if (paramType == null) {
        return null;
      }
    }
    try
    {
      localObject = getInstance().fromJson(paramJsonReader, paramType);
      return (T)localObject;
    }
    catch (JsonIOException|JsonSyntaxException localJsonIOException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fromJson Error: target[");
    ((StringBuilder)localObject).append(paramType);
    ((StringBuilder)localObject).append("], src[");
    ((StringBuilder)localObject).append(paramJsonReader);
    ((StringBuilder)localObject).append("]");
    DJILog.logWriteE("gson", ((StringBuilder)localObject).toString(), new Object[0]);
    return null;
  }
  
  public static <T> T fromJson(Reader paramReader, Class<T> paramClass)
  {
    if (paramReader != null) {
      if (paramClass == null) {
        return null;
      }
    }
    try
    {
      localObject = getInstance().fromJson(paramReader, paramClass);
      return (T)localObject;
    }
    catch (JsonIOException|JsonSyntaxException localJsonIOException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fromJson Error: target[");
    ((StringBuilder)localObject).append(paramClass);
    ((StringBuilder)localObject).append("], src[");
    ((StringBuilder)localObject).append(paramReader);
    ((StringBuilder)localObject).append("]");
    DJILog.logWriteE("gson", ((StringBuilder)localObject).toString(), new Object[0]);
    return null;
  }
  
  public static <T> T fromJson(Reader paramReader, Type paramType)
  {
    if (paramReader != null) {
      if (paramType == null) {
        return null;
      }
    }
    try
    {
      localObject = getInstance().fromJson(paramReader, paramType);
      return (T)localObject;
    }
    catch (JsonIOException|JsonSyntaxException localJsonIOException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fromJson Error: target[");
    ((StringBuilder)localObject).append(paramType);
    ((StringBuilder)localObject).append("], src[");
    ((StringBuilder)localObject).append(paramReader);
    ((StringBuilder)localObject).append("]");
    DJILog.logWriteE("gson", ((StringBuilder)localObject).toString(), new Object[0]);
    return null;
  }
  
  public static <T> T fromJson(String paramString, Class<T> paramClass)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramClass == null) {
        return null;
      }
    }
    try
    {
      localObject = getInstance().fromJson(paramString, paramClass);
      return (T)localObject;
    }
    catch (JsonSyntaxException localJsonSyntaxException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fromJson Error: target[");
    ((StringBuilder)localObject).append(paramClass.getName());
    ((StringBuilder)localObject).append("], src[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    DJILog.logWriteE("gson", ((StringBuilder)localObject).toString(), new Object[0]);
    return null;
  }
  
  public static <T> T fromJson(String paramString, Type paramType)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramType == null) {
        return null;
      }
    }
    try
    {
      localObject = getInstance().fromJson(paramString, paramType);
      return (T)localObject;
    }
    catch (JsonSyntaxException localJsonSyntaxException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fromJson Error: target[");
    ((StringBuilder)localObject).append(paramType);
    ((StringBuilder)localObject).append("], src[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    DJILog.logWriteE("gson", ((StringBuilder)localObject).toString(), new Object[0]);
    return null;
  }
  
  public static Gson getInstance()
  {
    if (sGson == null) {
      try
      {
        if (sGson == null) {
          sGson = new GsonBuilder().create();
        }
      }
      finally {}
    }
    return sGson;
  }
  
  public static void init(GsonBuilder paramGsonBuilder)
  {
    try
    {
      sGson = paramGsonBuilder.create();
      return;
    }
    finally
    {
      paramGsonBuilder = finally;
      throw paramGsonBuilder;
    }
  }
  
  public static String toJson(JsonElement paramJsonElement)
  {
    return getInstance().toJson(paramJsonElement);
  }
  
  public static String toJson(Object paramObject)
  {
    return getInstance().toJson(paramObject);
  }
  
  public static String toJson(Object paramObject, Type paramType)
  {
    return getInstance().toJson(paramObject, paramType);
  }
  
  public static void toJson(JsonElement paramJsonElement, Appendable paramAppendable)
  {
    try
    {
      getInstance().toJson(paramJsonElement, paramAppendable);
      return;
    }
    catch (JsonIOException localJsonIOException)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("toJson Error: writer[");
    localStringBuilder.append(paramAppendable);
    localStringBuilder.append("], src[");
    localStringBuilder.append(paramJsonElement);
    localStringBuilder.append("]");
    DJILog.logWriteE("gson", localStringBuilder.toString(), new Object[0]);
  }
  
  public static void toJson(Object paramObject, Appendable paramAppendable)
  {
    try
    {
      getInstance().toJson(paramObject, paramAppendable);
      return;
    }
    catch (JsonIOException localJsonIOException)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("toJson Error: writer[");
    localStringBuilder.append(paramAppendable);
    localStringBuilder.append("], src[");
    localStringBuilder.append(paramObject);
    localStringBuilder.append("]");
    DJILog.logWriteE("gson", localStringBuilder.toString(), new Object[0]);
  }
  
  public static void toJson(Object paramObject, Type paramType, JsonWriter paramJsonWriter)
  {
    try
    {
      getInstance().toJson(paramObject, paramType, paramJsonWriter);
      return;
    }
    catch (JsonIOException localJsonIOException)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("toJson Error: writer[");
    localStringBuilder.append(paramJsonWriter);
    localStringBuilder.append("], src[");
    localStringBuilder.append(paramObject);
    localStringBuilder.append("], type[");
    localStringBuilder.append(paramType);
    localStringBuilder.append("]");
    DJILog.logWriteE("gson", localStringBuilder.toString(), new Object[0]);
  }
  
  public static void toJson(Object paramObject, Type paramType, Appendable paramAppendable)
  {
    try
    {
      getInstance().toJson(paramObject, paramType, paramAppendable);
      return;
    }
    catch (JsonIOException localJsonIOException)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("toJson Error: writer[");
    localStringBuilder.append(paramAppendable);
    localStringBuilder.append("], src[");
    localStringBuilder.append(paramObject);
    localStringBuilder.append("], type[");
    localStringBuilder.append(paramType);
    localStringBuilder.append("]");
    DJILog.logWriteE("gson", localStringBuilder.toString(), new Object[0]);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\GsonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */