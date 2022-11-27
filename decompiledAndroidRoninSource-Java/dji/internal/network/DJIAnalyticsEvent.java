package dji.internal.network;

import android.database.Cursor;
import dji.thirdparty.rx.functions.Func1;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;

public class DJIAnalyticsEvent
  implements Serializable
{
  public static final String EVENT_DATA = "event_data";
  public static final String ID = "_id";
  public static final Func1<Cursor, DJIAnalyticsEvent> MAPPER = new Func1()
  {
    public DJIAnalyticsEvent call(Cursor paramAnonymousCursor)
    {
      return AnalyticsEventHelper.deserializeEvent(paramAnonymousCursor);
    }
  };
  public static final String TABLE = "event_item";
  private String appKey;
  private String cameraName;
  private String category;
  private String connectedSessionId;
  private String displayName;
  private String event;
  private String eventCreatedTimestamp;
  private String eventId;
  private Map<String, Object> extra;
  private String installId;
  private Boolean isReleaseMode;
  private String locale;
  private String platform;
  private String productFirmwareVersion;
  private String productId;
  private String productName;
  private String registeredSessionId;
  private String remoteControllerId;
  private String remoteControllerName;
  private String sdkVersion;
  
  public DJIAnalyticsEvent() {}
  
  public DJIAnalyticsEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, Boolean paramBoolean, Map<String, Object> paramMap)
  {
    this.eventCreatedTimestamp = paramString1;
    this.installId = paramString2;
    this.eventId = paramString3;
    this.displayName = paramString4;
    this.appKey = paramString5;
    this.platform = paramString6;
    this.sdkVersion = paramString7;
    this.locale = paramString8;
    this.registeredSessionId = paramString9;
    this.connectedSessionId = paramString10;
    this.productId = paramString11;
    this.productName = paramString12;
    this.remoteControllerId = paramString13;
    this.remoteControllerName = paramString14;
    this.cameraName = paramString15;
    this.category = paramString16;
    this.event = paramString17;
    this.extra = paramMap;
    this.productFirmwareVersion = paramString18;
    this.isReleaseMode = paramBoolean;
  }
  
  public String getEvent()
  {
    return this.event;
  }
  
  public String getEventCategory()
  {
    return this.category;
  }
  
  public String getEventCreatedTimestamp()
  {
    return this.eventCreatedTimestamp;
  }
  
  public String getEventId()
  {
    return this.eventId;
  }
  
  public String printString()
  {
    return null;
  }
  
  public static class EventBuilder
  {
    private String appKey;
    private String cameraName;
    private String category;
    private String connectedSessionId;
    private String displayName;
    private String event;
    private String eventId;
    private Map<String, Object> extra;
    private String installId;
    private boolean isReleaseMode;
    private String locale;
    private String platform;
    private String productFirmwareVersion;
    private String productId;
    private String productName;
    private String registeredSessionId;
    private String remoteControllerId;
    private String remoteControllerName;
    private String sdkVersion;
    private String time;
    
    public EventBuilder appKey(String paramString)
    {
      this.appKey = paramString;
      return this;
    }
    
    public DJIAnalyticsEvent build()
    {
      return null;
    }
    
    public EventBuilder cameraName(String paramString)
    {
      this.cameraName = paramString;
      return this;
    }
    
    public EventBuilder category(String paramString)
    {
      this.category = paramString;
      return this;
    }
    
    public EventBuilder connectedSessionId(String paramString)
    {
      this.connectedSessionId = paramString;
      return this;
    }
    
    public EventBuilder displayName(String paramString)
    {
      this.displayName = paramString;
      return this;
    }
    
    public EventBuilder event(String paramString)
    {
      this.event = paramString;
      return this;
    }
    
    public EventBuilder extra(Map<String, Object> paramMap)
    {
      this.extra = paramMap;
      return this;
    }
    
    public EventBuilder extra(JSONObject paramJSONObject)
    {
      return null;
    }
    
    public EventBuilder installId(String paramString)
    {
      this.installId = paramString;
      return this;
    }
    
    public EventBuilder isReleaseMode(boolean paramBoolean)
    {
      this.isReleaseMode = paramBoolean;
      return this;
    }
    
    public EventBuilder locale(String paramString)
    {
      this.locale = paramString;
      return this;
    }
    
    public EventBuilder platform(String paramString)
    {
      this.platform = paramString;
      return this;
    }
    
    public EventBuilder productFirmwareVersion(String paramString)
    {
      this.productFirmwareVersion = paramString;
      return this;
    }
    
    public EventBuilder productId(String paramString)
    {
      this.productId = paramString;
      return this;
    }
    
    public EventBuilder productName(String paramString)
    {
      this.productName = paramString;
      return this;
    }
    
    public EventBuilder registeredSessionId(String paramString)
    {
      this.registeredSessionId = paramString;
      return this;
    }
    
    public EventBuilder remoteControllerId(String paramString)
    {
      this.remoteControllerId = paramString;
      return this;
    }
    
    public EventBuilder remoteControllerName(String paramString)
    {
      this.remoteControllerName = paramString;
      return this;
    }
    
    public EventBuilder sdkVersion(String paramString)
    {
      this.sdkVersion = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\network\DJIAnalyticsEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */