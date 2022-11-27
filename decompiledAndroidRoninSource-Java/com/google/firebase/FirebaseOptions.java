package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

public final class FirebaseOptions
{
  private static final String API_KEY_RESOURCE_NAME = "google_api_key";
  private static final String APP_ID_RESOURCE_NAME = "google_app_id";
  private static final String DATABASE_URL_RESOURCE_NAME = "firebase_database_url";
  private static final String GA_TRACKING_ID_RESOURCE_NAME = "ga_trackingId";
  private static final String GCM_SENDER_ID_RESOURCE_NAME = "gcm_defaultSenderId";
  private static final String PROJECT_ID_RESOURCE_NAME = "project_id";
  private static final String STORAGE_BUCKET_RESOURCE_NAME = "google_storage_bucket";
  private final String apiKey;
  private final String applicationId;
  private final String databaseUrl;
  private final String gaTrackingId;
  private final String gcmSenderId;
  private final String projectId;
  private final String storageBucket;
  
  private FirebaseOptions(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Preconditions.checkState(Strings.isEmptyOrWhitespace(paramString1) ^ true, "ApplicationId must be set.");
    this.applicationId = paramString1;
    this.apiKey = paramString2;
    this.databaseUrl = paramString3;
    this.gaTrackingId = paramString4;
    this.gcmSenderId = paramString5;
    this.storageBucket = paramString6;
    this.projectId = paramString7;
  }
  
  public static FirebaseOptions fromResource(Context paramContext)
  {
    paramContext = new StringResourceValueReader(paramContext);
    String str = paramContext.getString("google_app_id");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return new FirebaseOptions(str, paramContext.getString("google_api_key"), paramContext.getString("firebase_database_url"), paramContext.getString("ga_trackingId"), paramContext.getString("gcm_defaultSenderId"), paramContext.getString("google_storage_bucket"), paramContext.getString("project_id"));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof FirebaseOptions;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (FirebaseOptions)paramObject;
    bool1 = bool2;
    if (Objects.equal(this.applicationId, ((FirebaseOptions)paramObject).applicationId))
    {
      bool1 = bool2;
      if (Objects.equal(this.apiKey, ((FirebaseOptions)paramObject).apiKey))
      {
        bool1 = bool2;
        if (Objects.equal(this.databaseUrl, ((FirebaseOptions)paramObject).databaseUrl))
        {
          bool1 = bool2;
          if (Objects.equal(this.gaTrackingId, ((FirebaseOptions)paramObject).gaTrackingId))
          {
            bool1 = bool2;
            if (Objects.equal(this.gcmSenderId, ((FirebaseOptions)paramObject).gcmSenderId))
            {
              bool1 = bool2;
              if (Objects.equal(this.storageBucket, ((FirebaseOptions)paramObject).storageBucket))
              {
                bool1 = bool2;
                if (Objects.equal(this.projectId, ((FirebaseOptions)paramObject).projectId)) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String getApiKey()
  {
    return this.apiKey;
  }
  
  public String getApplicationId()
  {
    return this.applicationId;
  }
  
  public String getDatabaseUrl()
  {
    return this.databaseUrl;
  }
  
  public String getGaTrackingId()
  {
    return this.gaTrackingId;
  }
  
  public String getGcmSenderId()
  {
    return this.gcmSenderId;
  }
  
  public String getProjectId()
  {
    return this.projectId;
  }
  
  public String getStorageBucket()
  {
    return this.storageBucket;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("applicationId", this.applicationId).add("apiKey", this.apiKey).add("databaseUrl", this.databaseUrl).add("gcmSenderId", this.gcmSenderId).add("storageBucket", this.storageBucket).add("projectId", this.projectId).toString();
  }
  
  public static final class Builder
  {
    private String apiKey;
    private String applicationId;
    private String databaseUrl;
    private String gaTrackingId;
    private String gcmSenderId;
    private String projectId;
    private String storageBucket;
    
    public Builder() {}
    
    public Builder(FirebaseOptions paramFirebaseOptions)
    {
      this.applicationId = paramFirebaseOptions.applicationId;
      this.apiKey = paramFirebaseOptions.apiKey;
      this.databaseUrl = paramFirebaseOptions.databaseUrl;
      this.gaTrackingId = paramFirebaseOptions.gaTrackingId;
      this.gcmSenderId = paramFirebaseOptions.gcmSenderId;
      this.storageBucket = paramFirebaseOptions.storageBucket;
      this.projectId = paramFirebaseOptions.projectId;
    }
    
    public FirebaseOptions build()
    {
      return new FirebaseOptions(this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId, null);
    }
    
    public Builder setApiKey(String paramString)
    {
      this.apiKey = Preconditions.checkNotEmpty(paramString, "ApiKey must be set.");
      return this;
    }
    
    public Builder setApplicationId(String paramString)
    {
      this.applicationId = Preconditions.checkNotEmpty(paramString, "ApplicationId must be set.");
      return this;
    }
    
    public Builder setDatabaseUrl(String paramString)
    {
      this.databaseUrl = paramString;
      return this;
    }
    
    public Builder setGaTrackingId(String paramString)
    {
      this.gaTrackingId = paramString;
      return this;
    }
    
    public Builder setGcmSenderId(String paramString)
    {
      this.gcmSenderId = paramString;
      return this;
    }
    
    public Builder setProjectId(String paramString)
    {
      this.projectId = paramString;
      return this;
    }
    
    public Builder setStorageBucket(String paramString)
    {
      this.storageBucket = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\FirebaseOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */