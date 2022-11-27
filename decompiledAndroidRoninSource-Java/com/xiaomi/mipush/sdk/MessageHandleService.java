package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai;
import com.xiaomi.push.fd;
import com.xiaomi.push.fi;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MessageHandleService
  extends BaseService
{
  private static ConcurrentLinkedQueue<a> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private static ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  
  protected static void a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    b(paramContext);
  }
  
  public static void addJob(Context paramContext, a parama)
  {
    if (parama != null)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(parama);
      b(paramContext);
      startService(paramContext);
    }
  }
  
  private static void b(Context paramContext)
  {
    if (!jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()) {
      jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ab(paramContext));
    }
  }
  
  private static void c(Context paramContext)
  {
    try
    {
      Object localObject1 = (a)jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localObject1 == null) {
        return;
      }
      PushMessageReceiver localPushMessageReceiver = ((a)localObject1).a();
      Intent localIntent = ((a)localObject1).a();
      int i = localIntent.getIntExtra("message_type", 1);
      Object localObject2;
      if (i != 1)
      {
        if (i != 3)
        {
          if (i != 5) {
            return;
          }
          if ("error_lack_of_permission".equals(localIntent.getStringExtra("error_type")))
          {
            localObject1 = localIntent.getStringArrayExtra("error_message");
            if (localObject1 != null)
            {
              b.a("begin execute onRequirePermissions, lack of necessary permissions");
              localPushMessageReceiver.onRequirePermissions(paramContext, (String[])localObject1);
            }
          }
        }
        else
        {
          localObject1 = (MiPushCommandMessage)localIntent.getSerializableExtra("key_command");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("(Local) begin execute onCommandResult, command=");
          ((StringBuilder)localObject2).append(((MiPushCommandMessage)localObject1).getCommand());
          ((StringBuilder)localObject2).append(", resultCode=");
          ((StringBuilder)localObject2).append(((MiPushCommandMessage)localObject1).getResultCode());
          ((StringBuilder)localObject2).append(", reason=");
          ((StringBuilder)localObject2).append(((MiPushCommandMessage)localObject1).getReason());
          b.a(((StringBuilder)localObject2).toString());
          localPushMessageReceiver.onCommandResult(paramContext, (MiPushCommandMessage)localObject1);
          if (TextUtils.equals(((MiPushCommandMessage)localObject1).getCommand(), fi.jdField_a_of_type_ComXiaomiPushFi.jdField_a_of_type_JavaLangString))
          {
            localPushMessageReceiver.onReceiveRegisterResult(paramContext, (MiPushCommandMessage)localObject1);
            if (((MiPushCommandMessage)localObject1).getResultCode() != 0L) {}
          }
        }
      }
      else
      {
        long l;
        do
        {
          h.b(paramContext);
          return;
          localObject1 = at.a(paramContext).a(localIntent);
          i = localIntent.getIntExtra("eventMessageType", -1);
          if (localObject1 == null) {
            break;
          }
          if ((localObject1 instanceof MiPushMessage))
          {
            MiPushMessage localMiPushMessage = (MiPushMessage)localObject1;
            if (!localMiPushMessage.isArrivedMessage()) {
              localPushMessageReceiver.onReceiveMessage(paramContext, localMiPushMessage);
            }
            if (localMiPushMessage.getPassThrough() == 1)
            {
              fd.a(paramContext.getApplicationContext()).a(paramContext.getPackageName(), localIntent, 2004, "call passThrough callBack");
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("begin execute onReceivePassThroughMessage from ");
              ((StringBuilder)localObject1).append(localMiPushMessage.getMessageId());
              b.a(((StringBuilder)localObject1).toString());
              localPushMessageReceiver.onReceivePassThroughMessage(paramContext, localMiPushMessage);
              return;
            }
            if (localMiPushMessage.isNotified())
            {
              if (i == 1000)
              {
                localObject1 = fd.a(paramContext.getApplicationContext());
                localObject2 = paramContext.getPackageName();
                i = 1007;
              }
              for (String str = "call notification callBack";; str = "call business callBack")
              {
                ((fd)localObject1).a((String)localObject2, localIntent, i, str);
                break;
                localObject1 = fd.a(paramContext.getApplicationContext());
                localObject2 = paramContext.getPackageName();
                i = 3007;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("begin execute onNotificationMessageClicked from　");
              ((StringBuilder)localObject1).append(localMiPushMessage.getMessageId());
              b.a(((StringBuilder)localObject1).toString());
              localPushMessageReceiver.onNotificationMessageClicked(paramContext, localMiPushMessage);
              return;
            }
            localPushMessageReceiver.onNotificationMessageArrived(paramContext, localMiPushMessage);
            return;
          }
          if (!(localObject1 instanceof MiPushCommandMessage)) {
            break;
          }
          localObject1 = (MiPushCommandMessage)localObject1;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("begin execute onCommandResult, command=");
          ((StringBuilder)localObject2).append(((MiPushCommandMessage)localObject1).getCommand());
          ((StringBuilder)localObject2).append(", resultCode=");
          ((StringBuilder)localObject2).append(((MiPushCommandMessage)localObject1).getResultCode());
          ((StringBuilder)localObject2).append(", reason=");
          ((StringBuilder)localObject2).append(((MiPushCommandMessage)localObject1).getReason());
          b.a(((StringBuilder)localObject2).toString());
          localPushMessageReceiver.onCommandResult(paramContext, (MiPushCommandMessage)localObject1);
          if (!TextUtils.equals(((MiPushCommandMessage)localObject1).getCommand(), fi.jdField_a_of_type_ComXiaomiPushFi.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localPushMessageReceiver.onReceiveRegisterResult(paramContext, (MiPushCommandMessage)localObject1);
          l = ((MiPushCommandMessage)localObject1).getResultCode();
        } while (l == 0L);
      }
      return;
    }
    catch (RuntimeException paramContext)
    {
      b.a(paramContext);
    }
  }
  
  public static void startService(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(paramContext, MessageHandleService.class));
    ai.a(paramContext).a(new aa(paramContext, localIntent));
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
  }
  
  public static class a
  {
    private Intent jdField_a_of_type_AndroidContentIntent;
    private PushMessageReceiver jdField_a_of_type_ComXiaomiMipushSdkPushMessageReceiver;
    
    public a(Intent paramIntent, PushMessageReceiver paramPushMessageReceiver)
    {
      this.jdField_a_of_type_ComXiaomiMipushSdkPushMessageReceiver = paramPushMessageReceiver;
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
    
    public Intent a()
    {
      return this.jdField_a_of_type_AndroidContentIntent;
    }
    
    public PushMessageReceiver a()
    {
      return this.jdField_a_of_type_ComXiaomiMipushSdkPushMessageReceiver;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\MessageHandleService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */