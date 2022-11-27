package io.flutter.plugin.editing;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.InputType;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextCapitalization;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType;
import io.flutter.plugin.platform.PlatformViewsController;

public class TextInputPlugin
{
  private TextInputChannel.Configuration configuration;
  private InputTarget inputTarget = new InputTarget(TextInputPlugin.InputTarget.Type.NO_TARGET, 0);
  private boolean isInputConnectionLocked;
  private InputConnection lastInputConnection;
  private Editable mEditable;
  private final InputMethodManager mImm;
  private boolean mRestartInputPending;
  private final View mView;
  private PlatformViewsController platformViewsController;
  private final boolean restartAlwaysRequired;
  private final TextInputChannel textInputChannel;
  
  public TextInputPlugin(View paramView, DartExecutor paramDartExecutor, PlatformViewsController paramPlatformViewsController)
  {
    this.mView = paramView;
    this.mImm = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    paramView = new TextInputChannel(paramDartExecutor);
    this.textInputChannel = paramView;
    paramView.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler()
    {
      public void clearClient()
      {
        TextInputPlugin.this.clearTextInputClient();
      }
      
      /* Error */
      public void hide()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void setClient(int paramAnonymousInt, TextInputChannel.Configuration paramAnonymousConfiguration)
      {
        TextInputPlugin.this.setTextInputClient(paramAnonymousInt, paramAnonymousConfiguration);
      }
      
      /* Error */
      public void setEditingState(io.flutter.embedding.engine.systemchannels.TextInputChannel.TextEditState arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void setPlatformViewClient(int paramAnonymousInt)
      {
        TextInputPlugin.this.setPlatformViewTextInputClient(paramAnonymousInt);
      }
      
      /* Error */
      public void show()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
    this.textInputChannel.requestExistingInputState();
    this.platformViewsController = paramPlatformViewsController;
    paramPlatformViewsController.attachTextInputPlugin(this);
    this.restartAlwaysRequired = isRestartAlwaysRequired();
  }
  
  /* Error */
  private void applyStateToSelection(io.flutter.embedding.engine.systemchannels.TextInputChannel.TextEditState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void clearTextInputClient()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void hideTextInput(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static int inputTypeFromTextInputType(TextInputChannel.InputType paramInputType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TextInputChannel.TextCapitalization paramTextCapitalization)
  {
    if (paramInputType.type == TextInputChannel.TextInputType.DATETIME) {
      return 4;
    }
    if (paramInputType.type == TextInputChannel.TextInputType.NUMBER)
    {
      i = 2;
      if (paramInputType.isSigned) {
        i = 4098;
      }
      j = i;
      if (paramInputType.isDecimal) {
        j = i | 0x2000;
      }
      return j;
    }
    if (paramInputType.type == TextInputChannel.TextInputType.PHONE) {
      return 3;
    }
    int i = 1;
    if (paramInputType.type == TextInputChannel.TextInputType.MULTILINE) {
      i = 131073;
    } else if (paramInputType.type == TextInputChannel.TextInputType.EMAIL_ADDRESS) {
      i = 33;
    } else if (paramInputType.type == TextInputChannel.TextInputType.URL) {
      i = 17;
    } else if (paramInputType.type == TextInputChannel.TextInputType.VISIBLE_PASSWORD) {
      i = 145;
    }
    if (paramBoolean1)
    {
      i = 0x80000 | i | 0x80;
    }
    else
    {
      j = i;
      if (paramBoolean2) {
        j = i | 0x8000;
      }
      if (!paramBoolean3) {
        i = 0x80000 | j;
      } else {
        i = j;
      }
    }
    if (paramTextCapitalization == TextInputChannel.TextCapitalization.CHARACTERS) {
      return i | 0x1000;
    }
    if (paramTextCapitalization == TextInputChannel.TextCapitalization.WORDS) {
      return i | 0x2000;
    }
    int j = i;
    if (paramTextCapitalization == TextInputChannel.TextCapitalization.SENTENCES) {
      j = i | 0x4000;
    }
    return j;
  }
  
  private boolean isRestartAlwaysRequired()
  {
    return false;
  }
  
  /* Error */
  private void setPlatformViewTextInputClient(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void showTextInput(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void clearPlatformViewClient(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public InputConnection createInputConnection(View paramView, EditorInfo paramEditorInfo)
  {
    return null;
  }
  
  public void destroy()
  {
    this.platformViewsController.detachTextInputPlugin();
  }
  
  Editable getEditable()
  {
    return this.mEditable;
  }
  
  public InputMethodManager getInputMethodManager()
  {
    return this.mImm;
  }
  
  public InputConnection getLastInputConnection()
  {
    return this.lastInputConnection;
  }
  
  /* Error */
  public void lockPlatformViewInputConnection()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void setTextInputClient(int arg1, TextInputChannel.Configuration arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void setTextInputEditingState(View arg1, io.flutter.embedding.engine.systemchannels.TextInputChannel.TextEditState arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void unlockPlatformViewInputConnection()
  {
    this.isInputConnectionLocked = false;
  }
  
  private static class InputTarget
  {
    int id;
    Type type;
    
    public InputTarget(Type paramType, int paramInt)
    {
      this.type = paramType;
      this.id = paramInt;
    }
    
    static enum Type
    {
      static
      {
        FRAMEWORK_CLIENT = new Type("FRAMEWORK_CLIENT", 1);
        Type localType = new Type("PLATFORM_VIEW", 2);
        PLATFORM_VIEW = localType;
        $VALUES = new Type[] { NO_TARGET, FRAMEWORK_CLIENT, localType };
      }
      
      private Type() {}
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\editing\TextInputPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */