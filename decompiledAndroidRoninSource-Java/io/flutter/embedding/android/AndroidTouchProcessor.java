package io.flutter.embedding.android;

import android.view.MotionEvent;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.lang.annotation.Annotation;

public class AndroidTouchProcessor
{
  private static final int BYTES_PER_FIELD = 8;
  private static final int POINTER_DATA_FIELD_COUNT = 28;
  private static final int POINTER_DATA_FLAG_BATCHED = 1;
  private static final int _POINTER_BUTTON_PRIMARY = 1;
  private final FlutterRenderer renderer;
  
  public AndroidTouchProcessor(FlutterRenderer paramFlutterRenderer)
  {
    this.renderer = paramFlutterRenderer;
  }
  
  /* Error */
  private void addPointerForIndex(MotionEvent arg1, int arg2, int arg3, int arg4, java.nio.ByteBuffer arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private int getPointerChangeForAction(int paramInt)
  {
    return 0;
  }
  
  private int getPointerDeviceTypeForToolType(int paramInt)
  {
    return 0;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  private static @interface PointerChange
  {
    public static final int ADD = 1;
    public static final int CANCEL = 0;
    public static final int DOWN = 4;
    public static final int HOVER = 3;
    public static final int MOVE = 5;
    public static final int REMOVE = 2;
    public static final int UP = 6;
  }
  
  private static @interface PointerDeviceKind
  {
    public static final int INVERTED_STYLUS = 3;
    public static final int MOUSE = 1;
    public static final int STYLUS = 2;
    public static final int TOUCH = 0;
    public static final int UNKNOWN = 4;
  }
  
  private static @interface PointerSignalKind
  {
    public static final int NONE = 0;
    public static final int SCROLL = 1;
    public static final int UNKNOWN = 2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\android\AndroidTouchProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */