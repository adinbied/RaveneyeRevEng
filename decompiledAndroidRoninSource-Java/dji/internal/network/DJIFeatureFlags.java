package dji.internal.network;

import com.google.gson.annotations.SerializedName;
import dji.internal.DJIAnalyticsSharedPrefs;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DJIFeatureFlags
  implements Serializable
{
  public static final boolean DEFAULT_ANALYTICS_ENABLED = true;
  public static final boolean DEFAULT_BOOLEAN_VALUE = true;
  public static final int DEFAULT_EVENT_BLOCK_SIZE = 5;
  public static final int DEFAULT_EVENT_UPLOAD_MAXIMUM_FREQUENCY = 2;
  public static final int DEFAULT_INT_VALUE = 0;
  public static final int DEFAULT_MAXIMUM_CACHE_SIZE = 2000000;
  public static final boolean DEFAULT_SDKLOG_ENABLED = true;
  public static final int DEFAULT_SESSION_TIMEOUT = 300;
  private static final String EVENT_COUNT_PER_UPLOAD_KEY = "event_count_per_upload";
  private static final String EVENT_UPLOAD_MAXIMUM_FREQUENCY_KEY = "event_upload_maximum_frequency";
  private static final String IS_ANALYTICS_ENABLED_KEY = "is_analytics_enable";
  private static final String IS_COLLECTION_ENABLED_KEY = "is_collection_enabled";
  private static final String MAXIMUM_CACHE_SIZE_KEY = "maximum_cache_size";
  private static final String SESSION_TIME_INTERVAL = "session_reconnection_grace_period_time_interval";
  private static final String THROTTLING_PATH_KEY = "throttling_path_";
  private static final String THROTTLING_VALUE_KEY = "throttling_value_";
  @SerializedName("Analytics")
  private AnalyticsFlags analyticFlags;
  @SerializedName("SDKLogs")
  private SDKLogsFlags sdkLogsFlags;
  
  public DJIFeatureFlags()
  {
    this.sdkLogsFlags = new SDKLogsFlags();
    this.analyticFlags = new AnalyticsFlags();
  }
  
  public DJIFeatureFlags(SDKLogsFlags paramSDKLogsFlags, AnalyticsFlags paramAnalyticsFlags)
  {
    this.sdkLogsFlags = paramSDKLogsFlags;
    this.analyticFlags = paramAnalyticsFlags;
  }
  
  public static DJIFeatureFlags loadFromLocal()
  {
    DJIFeatureFlags localDJIFeatureFlags = new DJIFeatureFlags();
    boolean bool = DJIAnalyticsSharedPrefs.containsKey("is_analytics_enable");
    Object localObject1 = Boolean.valueOf(true);
    if (bool) {
      AnalyticsFlags.access$1202(localDJIFeatureFlags.analyticFlags, Boolean.valueOf(DJIAnalyticsSharedPrefs.getBooleanPref("is_analytics_enable")));
    } else {
      AnalyticsFlags.access$1202(localDJIFeatureFlags.analyticFlags, (Boolean)localObject1);
    }
    if (DJIAnalyticsSharedPrefs.containsKey("is_collection_enabled")) {
      SDKLogsFlags.access$002(localDJIFeatureFlags.sdkLogsFlags, Boolean.valueOf(DJIAnalyticsSharedPrefs.getBooleanPref("is_collection_enabled")));
    } else {
      SDKLogsFlags.access$002(localDJIFeatureFlags.sdkLogsFlags, (Boolean)localObject1);
    }
    if (DJIAnalyticsSharedPrefs.containsKey("event_count_per_upload")) {
      AnalyticsFlags.access$1602(localDJIFeatureFlags.analyticFlags, DJIAnalyticsSharedPrefs.getIntegerPref("event_count_per_upload"));
    } else {
      AnalyticsFlags.access$1602(localDJIFeatureFlags.analyticFlags, Integer.valueOf(5));
    }
    if (DJIAnalyticsSharedPrefs.containsKey("event_upload_maximum_frequency")) {
      AnalyticsFlags.access$1802(localDJIFeatureFlags.analyticFlags, DJIAnalyticsSharedPrefs.getIntegerPref("event_upload_maximum_frequency"));
    } else {
      AnalyticsFlags.access$1802(localDJIFeatureFlags.analyticFlags, Integer.valueOf(2));
    }
    if (DJIAnalyticsSharedPrefs.containsKey("maximum_cache_size")) {
      AnalyticsFlags.access$1902(localDJIFeatureFlags.analyticFlags, DJIAnalyticsSharedPrefs.getIntegerPref("maximum_cache_size"));
    } else {
      AnalyticsFlags.access$1902(localDJIFeatureFlags.analyticFlags, Integer.valueOf(2000000));
    }
    if (DJIAnalyticsSharedPrefs.containsKey("session_reconnection_grace_period_time_interval")) {
      AnalyticsFlags.access$2102(localDJIFeatureFlags.analyticFlags, DJIAnalyticsSharedPrefs.getIntegerPref("session_reconnection_grace_period_time_interval"));
    } else {
      AnalyticsFlags.access$2102(localDJIFeatureFlags.analyticFlags, Integer.valueOf(300));
    }
    int i = 0;
    for (;;)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("throttling_path_");
      ((StringBuilder)localObject1).append(i);
      if (!DJIAnalyticsSharedPrefs.containsKey(((StringBuilder)localObject1).toString())) {
        break;
      }
      if (localDJIFeatureFlags.analyticFlags.throttledKeypaths == null) {
        AnalyticsFlags.access$2002(localDJIFeatureFlags.analyticFlags, new HashMap());
      }
      localObject1 = localDJIFeatureFlags.analyticFlags.throttledKeypaths;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("throttling_path_");
      ((StringBuilder)localObject2).append(i);
      localObject2 = DJIAnalyticsSharedPrefs.getStringPref(((StringBuilder)localObject2).toString());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("throttling_value_");
      localStringBuilder.append(i);
      ((Map)localObject1).put(localObject2, Double.valueOf(DJIAnalyticsSharedPrefs.getStringPref(localStringBuilder.toString())));
      i += 1;
    }
    return localDJIFeatureFlags;
  }
  
  public List<String> getCacheBlackList()
  {
    return null;
  }
  
  public List<String> getCacheWhiteList()
  {
    return null;
  }
  
  public Integer getEventCountPerUpload()
  {
    return null;
  }
  
  public Integer getEventUploadMaximumFrequency()
  {
    return null;
  }
  
  public Integer getMaximumCacheSize()
  {
    return null;
  }
  
  public Integer getNumberOfBookEntriesBeforeSave()
  {
    return null;
  }
  
  public List<String> getPackBlackList()
  {
    return null;
  }
  
  public List<String> getPackWhiteList()
  {
    return null;
  }
  
  public Integer getPeriodicCacheFlushTimerInterval()
  {
    return null;
  }
  
  public Integer getSessionReconnectionGracePeriodTimeInterval()
  {
    return null;
  }
  
  public Map<String, Double> getThrottling()
  {
    return null;
  }
  
  public boolean hasFlags()
  {
    return false;
  }
  
  public Boolean isAnalyticsEnabled()
  {
    return null;
  }
  
  public Boolean isCollectionOfDelegateCallbackEnabled()
  {
    return null;
  }
  
  public Boolean isCollectionOfPackListenerEnabled()
  {
    return null;
  }
  
  public Boolean isCollectionOfPackReceptionEnabled()
  {
    return null;
  }
  
  public Boolean isCollectionOfPackSendEnabled()
  {
    return null;
  }
  
  public Boolean isCollectionOfPublicAPIEnabled()
  {
    return null;
  }
  
  public Boolean isCollectionOfSDKCacheEnabled()
  {
    return null;
  }
  
  public Boolean isDiskPersistenceEnabled()
  {
    return null;
  }
  
  public Boolean isFleetManagementEnabled()
  {
    return null;
  }
  
  public Boolean isNetworkingEnabled()
  {
    return null;
  }
  
  public Boolean isSDKLogsEnabled()
  {
    return null;
  }
  
  /* Error */
  public void saveToLocal()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public class AnalyticsFlags
  {
    private Integer eventCountPerUpload;
    private Integer eventUploadMaximumFrequency;
    private Boolean isDiskPersistenceEnabled;
    private Boolean isEnabled;
    private Boolean isFleetManagementEnabled;
    private Boolean isNetworkingEnabled;
    private Integer maximumCacheSize;
    private Integer periodicCacheFlushTimerInterval;
    private Integer sessionReconnectionGracePeriodTimeInterval;
    private Map<String, Double> throttledKeypaths;
    
    public AnalyticsFlags() {}
    
    public AnalyticsFlags(Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Map<String, Double> paramMap)
    {
      this.isEnabled = paramBoolean1;
      this.isFleetManagementEnabled = paramBoolean2;
      this.isNetworkingEnabled = paramBoolean3;
      this.isDiskPersistenceEnabled = paramInteger1;
      this.eventCountPerUpload = paramInteger2;
      this.periodicCacheFlushTimerInterval = paramInteger3;
      this.eventUploadMaximumFrequency = paramInteger4;
      this.maximumCacheSize = paramInteger5;
      this.sessionReconnectionGracePeriodTimeInterval = paramMap;
      Map localMap;
      this.throttledKeypaths = localMap;
    }
  }
  
  public class SDKLogsFlags
  {
    private List<String> cacheBlackList;
    private List<String> cacheWhiteList;
    private Boolean isCollectionOfDelegateCallbackEnabled;
    private Boolean isCollectionOfPackListenerEnabled;
    private Boolean isCollectionOfPackReceptionEnabled;
    private Boolean isCollectionOfPackSendEnabled;
    private Boolean isCollectionOfPublicAPIEnabled;
    private Boolean isCollectionOfSDKCacheEnabled;
    private Boolean isEnabled;
    private Integer numberOfBookEntriesBeforeSave;
    private List<String> packBlackList;
    private List<String> packWhiteList;
    
    public SDKLogsFlags() {}
    
    public SDKLogsFlags(Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Boolean paramBoolean4, Boolean paramBoolean5, Boolean paramBoolean6, Boolean paramBoolean7, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
    {
      this.numberOfBookEntriesBeforeSave = paramBoolean1;
      this.isEnabled = paramBoolean2;
      this.isCollectionOfPublicAPIEnabled = paramBoolean3;
      this.isCollectionOfDelegateCallbackEnabled = paramBoolean4;
      this.isCollectionOfSDKCacheEnabled = paramBoolean5;
      this.isCollectionOfPackListenerEnabled = paramBoolean6;
      this.isCollectionOfPackSendEnabled = paramBoolean7;
      this.isCollectionOfPackReceptionEnabled = paramList1;
      this.cacheBlackList = paramList2;
      this.cacheWhiteList = paramList3;
      this.packBlackList = paramList4;
      List localList;
      this.packWhiteList = localList;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\network\DJIFeatureFlags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */