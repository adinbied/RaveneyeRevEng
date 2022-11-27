package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Adler32;

public class JobInfoScheduler
  implements WorkScheduler
{
  static final String ATTEMPT_NUMBER = "attemptNumber";
  static final String BACKEND_NAME = "backendName";
  static final String EVENT_PRIORITY = "priority";
  static final String EXTRAS = "extras";
  private static final String LOG_TAG = "JobInfoScheduler";
  private final SchedulerConfig config;
  private final Context context;
  private final EventStore eventStore;
  
  public JobInfoScheduler(Context paramContext, EventStore paramEventStore, SchedulerConfig paramSchedulerConfig)
  {
    this.context = paramContext;
    this.eventStore = paramEventStore;
    this.config = paramSchedulerConfig;
  }
  
  private boolean isJobServiceOn(JobScheduler paramJobScheduler, int paramInt1, int paramInt2)
  {
    paramJobScheduler = paramJobScheduler.getAllPendingJobs().iterator();
    boolean bool2;
    JobInfo localJobInfo;
    int i;
    do
    {
      boolean bool3 = paramJobScheduler.hasNext();
      bool2 = false;
      bool1 = bool2;
      if (!bool3) {
        break;
      }
      localJobInfo = (JobInfo)paramJobScheduler.next();
      i = localJobInfo.getExtras().getInt("attemptNumber");
    } while (localJobInfo.getId() != paramInt1);
    boolean bool1 = bool2;
    if (i >= paramInt2) {
      bool1 = true;
    }
    return bool1;
  }
  
  int getJobId(TransportContext paramTransportContext)
  {
    Adler32 localAdler32 = new Adler32();
    localAdler32.update(this.context.getPackageName().getBytes(Charset.forName("UTF-8")));
    localAdler32.update(paramTransportContext.getBackendName().getBytes(Charset.forName("UTF-8")));
    localAdler32.update(ByteBuffer.allocate(4).putInt(PriorityMapping.toInt(paramTransportContext.getPriority())).array());
    if (paramTransportContext.getExtras() != null) {
      localAdler32.update(paramTransportContext.getExtras());
    }
    return (int)localAdler32.getValue();
  }
  
  public void schedule(TransportContext paramTransportContext, int paramInt)
  {
    Object localObject = new ComponentName(this.context, JobInfoSchedulerService.class);
    JobScheduler localJobScheduler = (JobScheduler)this.context.getSystemService("jobscheduler");
    int i = getJobId(paramTransportContext);
    if (isJobServiceOn(localJobScheduler, i, paramInt))
    {
      Logging.d("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", paramTransportContext);
      return;
    }
    long l = this.eventStore.getNextCallTime(paramTransportContext);
    localObject = this.config.configureJob(new JobInfo.Builder(i, (ComponentName)localObject), paramTransportContext.getPriority(), l, paramInt);
    PersistableBundle localPersistableBundle = new PersistableBundle();
    localPersistableBundle.putInt("attemptNumber", paramInt);
    localPersistableBundle.putString("backendName", paramTransportContext.getBackendName());
    localPersistableBundle.putInt("priority", PriorityMapping.toInt(paramTransportContext.getPriority()));
    if (paramTransportContext.getExtras() != null) {
      localPersistableBundle.putString("extras", Base64.encodeToString(paramTransportContext.getExtras(), 0));
    }
    ((JobInfo.Builder)localObject).setExtras(localPersistableBundle);
    Logging.d("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", new Object[] { paramTransportContext, Integer.valueOf(i), Long.valueOf(this.config.getScheduleDelay(paramTransportContext.getPriority(), l, paramInt)), Long.valueOf(l), Integer.valueOf(paramInt) });
    localJobScheduler.schedule(((JobInfo.Builder)localObject).build());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\JobInfoScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */