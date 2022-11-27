package io.flutter.embedding.android;

import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.plugin.editing.TextInputPlugin;

public class AndroidKeyProcessor
{
  private int combiningCharacter;
  private final KeyEventChannel keyEventChannel;
  private final TextInputPlugin textInputPlugin;
  
  public AndroidKeyProcessor(KeyEventChannel paramKeyEventChannel, TextInputPlugin paramTextInputPlugin)
  {
    this.keyEventChannel = paramKeyEventChannel;
    this.textInputPlugin = paramTextInputPlugin;
  }
  
  private Character applyCombiningCharacterToBaseCharacter(int paramInt)
  {
    return null;
  }
  
  /* Error */
  public void onKeyDown(android.view.KeyEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onKeyUp(android.view.KeyEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\android\AndroidKeyProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */