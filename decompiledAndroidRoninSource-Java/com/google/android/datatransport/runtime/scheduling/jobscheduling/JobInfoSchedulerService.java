package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportContext.Builder;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;

public class JobInfoSchedulerService
  extends JobService
{
  public boolean onStartJob(JobParameters paramJobParameters)
  {
    Object localObject = paramJobParameters.getExtras().getString("backendName");
    String str = paramJobParameters.getExtras().getString("extras");
    int i = paramJobParameters.getExtras().getInt("priority");
    int j = paramJobParameters.getExtras().getInt("attemptNumber");
    TransportRuntime.initialize(getApplicationContext());
    localObject = TransportContext.builder().setBackendName((String)localObject).setPriority(PriorityMapping.valueOf(i));
    if (str != null) {
      ((TransportContext.Builder)localObject).setExtras(Base64.decode(str, 0));
    }
    TransportRuntime.getInstance().getUploader().upload(((TransportContext.Builder)localObject).build(), j, JobInfoSchedulerService..Lambda.1.lambdaFactory$(this, paramJobParameters));
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\JobInfoSchedulerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */