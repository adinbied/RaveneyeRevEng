package io.flutter.plugin.platform;

import android.content.Context;
import io.flutter.plugin.common.MessageCodec;

public abstract class PlatformViewFactory
{
  private final MessageCodec<Object> createArgsCodec;
  
  public PlatformViewFactory(MessageCodec<Object> paramMessageCodec)
  {
    this.createArgsCodec = paramMessageCodec;
  }
  
  public abstract PlatformView create(Context paramContext, int paramInt, Object paramObject);
  
  public final MessageCodec<Object> getCreateArgsCodec()
  {
    return this.createArgsCodec;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\platform\PlatformViewFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */