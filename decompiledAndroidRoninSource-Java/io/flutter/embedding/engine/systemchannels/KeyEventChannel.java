package io.flutter.embedding.engine.systemchannels;

import android.os.Build.VERSION;
import android.view.InputDevice;
import android.view.KeyEvent;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;

public class KeyEventChannel
{
  public final BasicMessageChannel<Object> channel;
  
  public KeyEventChannel(DartExecutor paramDartExecutor)
  {
    this.channel = new BasicMessageChannel(paramDartExecutor, "flutter/keyevent", JSONMessageCodec.INSTANCE);
  }
  
  /* Error */
  private void encodeKeyEvent(FlutterKeyEvent arg1, java.util.Map<String, Object> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void keyDown(FlutterKeyEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void keyUp(FlutterKeyEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class FlutterKeyEvent
  {
    public final int codePoint;
    public final Character complexCharacter;
    public final int deviceId;
    public final int flags;
    public final int keyCode;
    public final int metaState;
    public final int plainCodePoint;
    public final int productId;
    public final int repeatCount;
    public final int scanCode;
    public final int source;
    public final int vendorId;
    
    public FlutterKeyEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Character paramCharacter, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      this.deviceId = paramInt1;
      this.flags = paramInt2;
      this.plainCodePoint = paramInt3;
      this.codePoint = paramInt4;
      this.keyCode = paramInt5;
      this.complexCharacter = paramCharacter;
      this.scanCode = paramInt6;
      this.metaState = paramInt7;
      this.source = paramInt8;
      this.repeatCount = paramInt9;
      paramCharacter = InputDevice.getDevice(paramInt1);
      if (paramCharacter != null)
      {
        if (Build.VERSION.SDK_INT >= 19)
        {
          this.vendorId = paramCharacter.getVendorId();
          this.productId = paramCharacter.getProductId();
          return;
        }
        this.vendorId = 0;
        this.productId = 0;
        return;
      }
      this.vendorId = 0;
      this.productId = 0;
    }
    
    public FlutterKeyEvent(KeyEvent paramKeyEvent)
    {
      this(paramKeyEvent, null);
    }
    
    public FlutterKeyEvent(KeyEvent paramKeyEvent, Character paramCharacter)
    {
      this(paramKeyEvent.getDeviceId(), paramKeyEvent.getFlags(), paramKeyEvent.getUnicodeChar(0), paramKeyEvent.getUnicodeChar(), paramKeyEvent.getKeyCode(), paramCharacter, paramKeyEvent.getScanCode(), paramKeyEvent.getMetaState(), paramKeyEvent.getSource(), paramKeyEvent.getRepeatCount());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\systemchannels\KeyEventChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */