package io.flutter.embedding.engine.systemchannels;

import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class TextInputChannel
{
  private static final String TAG = "TextInputChannel";
  public final MethodChannel channel;
  private final MethodChannel.MethodCallHandler parsingMethodHandler = new MethodChannel.MethodCallHandler()
  {
    /* Error */
    public void onMethodCall(io.flutter.plugin.common.MethodCall arg1, io.flutter.plugin.common.MethodChannel.Result arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  };
  private TextInputMethodHandler textInputMethodHandler;
  
  public TextInputChannel(DartExecutor paramDartExecutor)
  {
    paramDartExecutor = new MethodChannel(paramDartExecutor, "flutter/textinput", JSONMethodCodec.INSTANCE);
    this.channel = paramDartExecutor;
    paramDartExecutor.setMethodCallHandler(this.parsingMethodHandler);
  }
  
  /* Error */
  public void done(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void go(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void newline(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void next(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void previous(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void requestExistingInputState()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void search(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void send(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setTextInputMethodHandler(TextInputMethodHandler paramTextInputMethodHandler)
  {
    this.textInputMethodHandler = paramTextInputMethodHandler;
  }
  
  /* Error */
  public void unspecifiedAction(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateEditingState(int arg1, String arg2, int arg3, int arg4, int arg5, int arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public static class Configuration
  {
    public final String actionLabel;
    public final boolean autocorrect;
    public final boolean enableSuggestions;
    public final Integer inputAction;
    public final TextInputChannel.InputType inputType;
    public final boolean obscureText;
    public final TextInputChannel.TextCapitalization textCapitalization;
    
    public Configuration(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TextInputChannel.TextCapitalization paramTextCapitalization, TextInputChannel.InputType paramInputType, Integer paramInteger, String paramString)
    {
      this.obscureText = paramBoolean1;
      this.autocorrect = paramBoolean2;
      this.enableSuggestions = paramBoolean3;
      this.textCapitalization = paramTextCapitalization;
      this.inputType = paramInputType;
      this.inputAction = paramInteger;
      this.actionLabel = paramString;
    }
    
    public static Configuration fromJson(JSONObject paramJSONObject)
      throws JSONException, NoSuchFieldException
    {
      Object localObject = paramJSONObject.getString("inputAction");
      if (localObject != null)
      {
        localObject = inputActionFromTextInputAction((String)localObject);
        boolean bool1 = paramJSONObject.optBoolean("obscureText");
        boolean bool2 = paramJSONObject.optBoolean("autocorrect", true);
        boolean bool3 = paramJSONObject.optBoolean("enableSuggestions");
        TextInputChannel.TextCapitalization localTextCapitalization = TextInputChannel.TextCapitalization.fromValue(paramJSONObject.getString("textCapitalization"));
        TextInputChannel.InputType localInputType = TextInputChannel.InputType.fromJson(paramJSONObject.getJSONObject("inputType"));
        if (paramJSONObject.isNull("actionLabel")) {
          paramJSONObject = null;
        } else {
          paramJSONObject = paramJSONObject.getString("actionLabel");
        }
        return new Configuration(bool1, bool2, bool3, localTextCapitalization, localInputType, (Integer)localObject, paramJSONObject);
      }
      throw new JSONException("Configuration JSON missing 'inputAction' property.");
    }
    
    private static Integer inputActionFromTextInputAction(String paramString)
    {
      int j = paramString.hashCode();
      int i = 0;
      Integer localInteger = Integer.valueOf(0);
      switch (j)
      {
      default: 
        break;
      case 2110497650: 
        if (paramString.equals("TextInputAction.previous")) {
          i = 8;
        }
        break;
      case 1539450297: 
        if (!paramString.equals("TextInputAction.newline")) {
          break;
        }
        break;
      case 1241689507: 
        if (paramString.equals("TextInputAction.go")) {
          i = 4;
        }
        break;
      case 469250275: 
        if (paramString.equals("TextInputAction.search")) {
          i = 5;
        }
        break;
      case -736940669: 
        if (paramString.equals("TextInputAction.send")) {
          i = 6;
        }
        break;
      case -737080013: 
        if (paramString.equals("TextInputAction.none")) {
          i = 1;
        }
        break;
      case -737089298: 
        if (paramString.equals("TextInputAction.next")) {
          i = 7;
        }
        break;
      case -737377923: 
        if (paramString.equals("TextInputAction.done")) {
          i = 3;
        }
        break;
      case -810971940: 
        if (paramString.equals("TextInputAction.unspecified")) {
          i = 2;
        }
        break;
      }
      i = -1;
      switch (i)
      {
      default: 
        return localInteger;
      case 8: 
        return Integer.valueOf(7);
      case 7: 
        return Integer.valueOf(5);
      case 6: 
        return Integer.valueOf(4);
      case 5: 
        return Integer.valueOf(3);
      case 4: 
        return Integer.valueOf(2);
      case 3: 
        return Integer.valueOf(6);
      case 2: 
        return localInteger;
      }
      return Integer.valueOf(1);
    }
  }
  
  public static class InputType
  {
    public final boolean isDecimal;
    public final boolean isSigned;
    public final TextInputChannel.TextInputType type;
    
    public InputType(TextInputChannel.TextInputType paramTextInputType, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.type = paramTextInputType;
      this.isSigned = paramBoolean1;
      this.isDecimal = paramBoolean2;
    }
    
    public static InputType fromJson(JSONObject paramJSONObject)
      throws JSONException, NoSuchFieldException
    {
      return new InputType(TextInputChannel.TextInputType.fromValue(paramJSONObject.getString("name")), paramJSONObject.optBoolean("signed", false), paramJSONObject.optBoolean("decimal", false));
    }
  }
  
  public static enum TextCapitalization
  {
    private final String encodedName;
    
    static
    {
      SENTENCES = new TextCapitalization("SENTENCES", 2, "TextCapitalization.sentences");
      TextCapitalization localTextCapitalization = new TextCapitalization("NONE", 3, "TextCapitalization.none");
      NONE = localTextCapitalization;
      $VALUES = new TextCapitalization[] { CHARACTERS, WORDS, SENTENCES, localTextCapitalization };
    }
    
    private TextCapitalization(String paramString)
    {
      this.encodedName = paramString;
    }
    
    static TextCapitalization fromValue(String paramString)
      throws NoSuchFieldException
    {
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        TextCapitalization localTextCapitalization = localObject[i];
        if (localTextCapitalization.encodedName.equals(paramString)) {
          return localTextCapitalization;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No such TextCapitalization: ");
      ((StringBuilder)localObject).append(paramString);
      throw new NoSuchFieldException(((StringBuilder)localObject).toString());
    }
  }
  
  public static class TextEditState
  {
    public final int selectionEnd;
    public final int selectionStart;
    public final String text;
    
    public TextEditState(String paramString, int paramInt1, int paramInt2)
    {
      this.text = paramString;
      this.selectionStart = paramInt1;
      this.selectionEnd = paramInt2;
    }
    
    public static TextEditState fromJson(JSONObject paramJSONObject)
      throws JSONException
    {
      return new TextEditState(paramJSONObject.getString("text"), paramJSONObject.getInt("selectionBase"), paramJSONObject.getInt("selectionExtent"));
    }
  }
  
  public static abstract interface TextInputMethodHandler
  {
    public abstract void clearClient();
    
    public abstract void hide();
    
    public abstract void setClient(int paramInt, TextInputChannel.Configuration paramConfiguration);
    
    public abstract void setEditingState(TextInputChannel.TextEditState paramTextEditState);
    
    public abstract void setPlatformViewClient(int paramInt);
    
    public abstract void show();
  }
  
  public static enum TextInputType
  {
    private final String encodedName;
    
    static
    {
      DATETIME = new TextInputType("DATETIME", 1, "TextInputType.datetime");
      NUMBER = new TextInputType("NUMBER", 2, "TextInputType.number");
      PHONE = new TextInputType("PHONE", 3, "TextInputType.phone");
      MULTILINE = new TextInputType("MULTILINE", 4, "TextInputType.multiline");
      EMAIL_ADDRESS = new TextInputType("EMAIL_ADDRESS", 5, "TextInputType.emailAddress");
      URL = new TextInputType("URL", 6, "TextInputType.url");
      TextInputType localTextInputType = new TextInputType("VISIBLE_PASSWORD", 7, "TextInputType.visiblePassword");
      VISIBLE_PASSWORD = localTextInputType;
      $VALUES = new TextInputType[] { TEXT, DATETIME, NUMBER, PHONE, MULTILINE, EMAIL_ADDRESS, URL, localTextInputType };
    }
    
    private TextInputType(String paramString)
    {
      this.encodedName = paramString;
    }
    
    static TextInputType fromValue(String paramString)
      throws NoSuchFieldException
    {
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        TextInputType localTextInputType = localObject[i];
        if (localTextInputType.encodedName.equals(paramString)) {
          return localTextInputType;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No such TextInputType: ");
      ((StringBuilder)localObject).append(paramString);
      throw new NoSuchFieldException(((StringBuilder)localObject).toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\systemchannels\TextInputChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */