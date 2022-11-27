package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendRequest.Builder;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class Uploader
{
  private static final String LOG_TAG = "Uploader";
  private final BackendRegistry backendRegistry;
  private final Clock clock;
  private final Context context;
  private final EventStore eventStore;
  private final Executor executor;
  private final SynchronizationGuard guard;
  private final WorkScheduler workScheduler;
  
  @Inject
  public Uploader(Context paramContext, BackendRegistry paramBackendRegistry, EventStore paramEventStore, WorkScheduler paramWorkScheduler, Executor paramExecutor, SynchronizationGuard paramSynchronizationGuard, Clock paramClock)
  {
    this.context = paramContext;
    this.backendRegistry = paramBackendRegistry;
    this.eventStore = paramEventStore;
    this.workScheduler = paramWorkScheduler;
    this.executor = paramExecutor;
    this.guard = paramSynchronizationGuard;
    this.clock = paramClock;
  }
  
  boolean isNetworkAvailable()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.context.getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }
  
  void logAndUpdateState(TransportContext paramTransportContext, int paramInt)
  {
    Object localObject = this.backendRegistry.get(paramTransportContext.getBackendName());
    Iterable localIterable = (Iterable)this.guard.runCriticalSection(Uploader..Lambda.2.lambdaFactory$(this, paramTransportContext));
    if (!localIterable.iterator().hasNext()) {
      return;
    }
    if (localObject == null)
    {
      Logging.d("Uploader", "Unknown backend for %s, deleting event batch for it...", paramTransportContext);
      localObject = BackendResponse.fatalError();
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localIterable.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((PersistedEvent)localIterator.next()).getEvent());
      }
      localObject = ((TransportBackend)localObject).send(BackendRequest.builder().setEvents(localArrayList).setExtras(paramTransportContext.getExtras()).build());
    }
    this.guard.runCriticalSection(Uploader..Lambda.3.lambdaFactory$(this, (BackendResponse)localObject, localIterable, paramTransportContext, paramInt));
  }
  
  public void upload(TransportContext paramTransportContext, int paramInt, Runnable paramRunnable)
  {
    this.executor.execute(Uploader..Lambda.1.lambdaFactory$(this, paramTransportContext, paramInt, paramRunnable));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\Uploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */