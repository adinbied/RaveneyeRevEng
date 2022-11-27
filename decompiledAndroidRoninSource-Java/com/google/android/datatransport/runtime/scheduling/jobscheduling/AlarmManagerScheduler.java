package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri.Builder;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;

public class AlarmManagerScheduler
  implements WorkScheduler
{
  static final String ATTEMPT_NUMBER = "attemptNumber";
  static final String BACKEND_NAME = "backendName";
  static final String EVENT_PRIORITY = "priority";
  static final String EXTRAS = "extras";
  private static final String LOG_TAG = "AlarmManagerScheduler";
  private AlarmManager alarmManager;
  private final Clock clock;
  private final SchedulerConfig config;
  private final Context context;
  private final EventStore eventStore;
  
  AlarmManagerScheduler(Context paramContext, EventStore paramEventStore, AlarmManager paramAlarmManager, Clock paramClock, SchedulerConfig paramSchedulerConfig)
  {
    this.context = paramContext;
    this.eventStore = paramEventStore;
    this.alarmManager = paramAlarmManager;
    this.clock = paramClock;
    this.config = paramSchedulerConfig;
  }
  
  public AlarmManagerScheduler(Context paramContext, EventStore paramEventStore, Clock paramClock, SchedulerConfig paramSchedulerConfig)
  {
    this(paramContext, paramEventStore, (AlarmManager)paramContext.getSystemService("alarm"), paramClock, paramSchedulerConfig);
  }
  
  boolean isJobServiceOn(Intent paramIntent)
  {
    Context localContext = this.context;
    boolean bool = false;
    if (PendingIntent.getBroadcast(localContext, 0, paramIntent, 536870912) != null) {
      bool = true;
    }
    return bool;
  }
  
  public void schedule(TransportContext paramTransportContext, int paramInt)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.appendQueryParameter("backendName", paramTransportContext.getBackendName());
    localBuilder.appendQueryParameter("priority", String.valueOf(PriorityMapping.toInt(paramTransportContext.getPriority())));
    if (paramTransportContext.getExtras() != null) {
      localBuilder.appendQueryParameter("extras", Base64.encodeToString(paramTransportContext.getExtras(), 0));
    }
    Intent localIntent = new Intent(this.context, AlarmManagerSchedulerBroadcastReceiver.class);
    localIntent.setData(localBuilder.build());
    localIntent.putExtra("attemptNumber", paramInt);
    if (isJobServiceOn(localIntent))
    {
      Logging.d("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", paramTransportContext);
      return;
    }
    long l1 = this.eventStore.getNextCallTime(paramTransportContext);
    long l2 = this.config.getScheduleDelay(paramTransportContext.getPriority(), l1, paramInt);
    Logging.d("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", new Object[] { paramTransportContext, Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(paramInt) });
    paramTransportContext = PendingIntent.getBroadcast(this.context, 0, localIntent, 0);
    this.alarmManager.set(3, this.clock.getTime() + l2, paramTransportContext);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\AlarmManagerScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */