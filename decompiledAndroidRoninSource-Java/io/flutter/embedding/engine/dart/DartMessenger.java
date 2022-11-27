package io.flutter.embedding.engine.dart;

import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler;
import io.flutter.plugin.common.BinaryMessenger.BinaryReply;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class DartMessenger
  implements BinaryMessenger, PlatformMessageHandler
{
  private static final String TAG = "DartMessenger";
  private final FlutterJNI flutterJNI;
  private final Map<String, BinaryMessenger.BinaryMessageHandler> messageHandlers;
  private int nextReplyId = 1;
  private final Map<Integer, BinaryMessenger.BinaryReply> pendingReplies;
  
  DartMessenger(FlutterJNI paramFlutterJNI)
  {
    this.flutterJNI = paramFlutterJNI;
    this.messageHandlers = new HashMap();
    this.pendingReplies = new HashMap();
  }
  
  public int getPendingChannelResponseCount()
  {
    return this.pendingReplies.size();
  }
  
  /* Error */
  public void handleMessageFromDart(String arg1, byte[] arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void handlePlatformMessageResponse(int arg1, byte[] arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void send(String arg1, java.nio.ByteBuffer arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void send(String arg1, java.nio.ByteBuffer arg2, BinaryMessenger.BinaryReply arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setMessageHandler(String arg1, BinaryMessenger.BinaryMessageHandler arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static class Reply
    implements BinaryMessenger.BinaryReply
  {
    private final AtomicBoolean done = new AtomicBoolean(false);
    private final FlutterJNI flutterJNI;
    private final int replyId;
    
    Reply(FlutterJNI paramFlutterJNI, int paramInt)
    {
      this.flutterJNI = paramFlutterJNI;
      this.replyId = paramInt;
    }
    
    /* Error */
    public void reply(java.nio.ByteBuffer arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\dart\DartMessenger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */