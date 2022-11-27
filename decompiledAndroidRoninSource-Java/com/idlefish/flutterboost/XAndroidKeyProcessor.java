package com.idlefish.flutterboost;

import io.flutter.embedding.engine.systemchannels.KeyEventChannel;

public class XAndroidKeyProcessor
{
  private int combiningCharacter;
  private final KeyEventChannel keyEventChannel;
  private final XTextInputPlugin textInputPlugin;
  
  public XAndroidKeyProcessor(KeyEventChannel paramKeyEventChannel, XTextInputPlugin paramXTextInputPlugin)
  {
    this.keyEventChannel = paramKeyEventChannel;
    this.textInputPlugin = paramXTextInputPlugin;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\XAndroidKeyProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */