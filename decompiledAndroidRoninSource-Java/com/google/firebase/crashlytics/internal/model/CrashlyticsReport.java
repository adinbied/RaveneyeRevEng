package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.annotations.Encodable.Field;
import com.google.firebase.encoders.annotations.Encodable.Ignore;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;

@Encodable
public abstract class CrashlyticsReport
{
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  
  public static Builder builder()
  {
    return new AutoValue_CrashlyticsReport.Builder();
  }
  
  public abstract String getBuildVersion();
  
  public abstract String getDisplayVersion();
  
  public abstract String getGmpAppId();
  
  public abstract String getInstallationUuid();
  
  public abstract FilesPayload getNdkPayload();
  
  public abstract int getPlatform();
  
  public abstract String getSdkVersion();
  
  public abstract Session getSession();
  
  @Encodable.Ignore
  public Type getType()
  {
    if (getSession() != null) {
      return Type.JAVA;
    }
    if (getNdkPayload() != null) {
      return Type.NATIVE;
    }
    return Type.INCOMPLETE;
  }
  
  protected abstract Builder toBuilder();
  
  public CrashlyticsReport withEvents(ImmutableList<CrashlyticsReport.Session.Event> paramImmutableList)
  {
    if (getSession() != null) {
      return toBuilder().setSession(getSession().withEvents(paramImmutableList)).build();
    }
    throw new IllegalStateException("Reports without sessions cannot have events added to them.");
  }
  
  public CrashlyticsReport withNdkPayload(FilesPayload paramFilesPayload)
  {
    return toBuilder().setSession(null).setNdkPayload(paramFilesPayload).build();
  }
  
  public CrashlyticsReport withOrganizationId(String paramString)
  {
    Builder localBuilder = toBuilder();
    Object localObject = getNdkPayload();
    if (localObject != null) {
      localBuilder.setNdkPayload(((FilesPayload)localObject).toBuilder().setOrgId(paramString).build());
    }
    localObject = getSession();
    if (localObject != null) {
      localBuilder.setSession(((Session)localObject).withOrganizationId(paramString));
    }
    return localBuilder.build();
  }
  
  public CrashlyticsReport withSessionEndFields(long paramLong, boolean paramBoolean, String paramString)
  {
    Builder localBuilder = toBuilder();
    if (getSession() != null) {
      localBuilder.setSession(getSession().withSessionEndFields(paramLong, paramBoolean, paramString));
    }
    return localBuilder.build();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Architecture
  {
    public static final int ARM64 = 9;
    public static final int ARMV6 = 5;
    public static final int ARMV7 = 6;
    public static final int UNKNOWN = 7;
    public static final int X86_32 = 0;
    public static final int X86_64 = 1;
  }
  
  public static abstract class Builder
  {
    public abstract CrashlyticsReport build();
    
    public abstract Builder setBuildVersion(String paramString);
    
    public abstract Builder setDisplayVersion(String paramString);
    
    public abstract Builder setGmpAppId(String paramString);
    
    public abstract Builder setInstallationUuid(String paramString);
    
    public abstract Builder setNdkPayload(CrashlyticsReport.FilesPayload paramFilesPayload);
    
    public abstract Builder setPlatform(int paramInt);
    
    public abstract Builder setSdkVersion(String paramString);
    
    public abstract Builder setSession(CrashlyticsReport.Session paramSession);
  }
  
  public static abstract class CustomAttribute
  {
    public static Builder builder()
    {
      return new AutoValue_CrashlyticsReport_CustomAttribute.Builder();
    }
    
    public abstract String getKey();
    
    public abstract String getValue();
    
    public static abstract class Builder
    {
      public abstract CrashlyticsReport.CustomAttribute build();
      
      public abstract Builder setKey(String paramString);
      
      public abstract Builder setValue(String paramString);
    }
  }
  
  public static abstract class FilesPayload
  {
    public static Builder builder()
    {
      return new AutoValue_CrashlyticsReport_FilesPayload.Builder();
    }
    
    public abstract ImmutableList<File> getFiles();
    
    public abstract String getOrgId();
    
    abstract Builder toBuilder();
    
    public static abstract class Builder
    {
      public abstract CrashlyticsReport.FilesPayload build();
      
      public abstract Builder setFiles(ImmutableList<CrashlyticsReport.FilesPayload.File> paramImmutableList);
      
      public abstract Builder setOrgId(String paramString);
    }
    
    public static abstract class File
    {
      public static Builder builder()
      {
        return new AutoValue_CrashlyticsReport_FilesPayload_File.Builder();
      }
      
      public abstract byte[] getContents();
      
      public abstract String getFilename();
      
      public static abstract class Builder
      {
        public abstract CrashlyticsReport.FilesPayload.File build();
        
        public abstract Builder setContents(byte[] paramArrayOfByte);
        
        public abstract Builder setFilename(String paramString);
      }
    }
  }
  
  public static abstract class Session
  {
    public static Builder builder()
    {
      return new AutoValue_CrashlyticsReport_Session.Builder().setCrashed(false);
    }
    
    public abstract Application getApp();
    
    public abstract Device getDevice();
    
    public abstract Long getEndedAt();
    
    public abstract ImmutableList<Event> getEvents();
    
    public abstract String getGenerator();
    
    public abstract int getGeneratorType();
    
    @Encodable.Ignore
    public abstract String getIdentifier();
    
    @Encodable.Field(name="identifier")
    public byte[] getIdentifierUtf8Bytes()
    {
      return getIdentifier().getBytes(CrashlyticsReport.UTF_8);
    }
    
    public abstract OperatingSystem getOs();
    
    public abstract long getStartedAt();
    
    public abstract User getUser();
    
    public abstract boolean isCrashed();
    
    public abstract Builder toBuilder();
    
    Session withEvents(ImmutableList<Event> paramImmutableList)
    {
      return toBuilder().setEvents(paramImmutableList).build();
    }
    
    Session withOrganizationId(String paramString)
    {
      paramString = getApp().withOrganizationId(paramString);
      return toBuilder().setApp(paramString).build();
    }
    
    Session withSessionEndFields(long paramLong, boolean paramBoolean, String paramString)
    {
      Builder localBuilder = toBuilder();
      localBuilder.setEndedAt(Long.valueOf(paramLong));
      localBuilder.setCrashed(paramBoolean);
      if (paramString != null) {
        localBuilder.setUser(User.builder().setIdentifier(paramString).build()).build();
      }
      return localBuilder.build();
    }
    
    public static abstract class Application
    {
      public static Builder builder()
      {
        return new AutoValue_CrashlyticsReport_Session_Application.Builder();
      }
      
      public abstract String getDisplayVersion();
      
      public abstract String getIdentifier();
      
      public abstract String getInstallationUuid();
      
      public abstract Organization getOrganization();
      
      public abstract String getVersion();
      
      protected abstract Builder toBuilder();
      
      Application withOrganizationId(String paramString)
      {
        Object localObject = getOrganization();
        if (localObject != null) {
          localObject = ((Organization)localObject).toBuilder();
        } else {
          localObject = Organization.builder();
        }
        return toBuilder().setOrganization(((CrashlyticsReport.Session.Application.Organization.Builder)localObject).setClsId(paramString).build()).build();
      }
      
      public static abstract class Builder
      {
        public abstract CrashlyticsReport.Session.Application build();
        
        public abstract Builder setDisplayVersion(String paramString);
        
        public abstract Builder setIdentifier(String paramString);
        
        public abstract Builder setInstallationUuid(String paramString);
        
        public abstract Builder setOrganization(CrashlyticsReport.Session.Application.Organization paramOrganization);
        
        public abstract Builder setVersion(String paramString);
      }
      
      public static abstract class Organization
      {
        public static Builder builder()
        {
          return new AutoValue_CrashlyticsReport_Session_Application_Organization.Builder();
        }
        
        public abstract String getClsId();
        
        protected abstract Builder toBuilder();
        
        public static abstract class Builder
        {
          public abstract CrashlyticsReport.Session.Application.Organization build();
          
          public abstract Builder setClsId(String paramString);
        }
      }
    }
    
    public static abstract class Builder
    {
      public abstract CrashlyticsReport.Session build();
      
      public abstract Builder setApp(CrashlyticsReport.Session.Application paramApplication);
      
      public abstract Builder setCrashed(boolean paramBoolean);
      
      public abstract Builder setDevice(CrashlyticsReport.Session.Device paramDevice);
      
      public abstract Builder setEndedAt(Long paramLong);
      
      public abstract Builder setEvents(ImmutableList<CrashlyticsReport.Session.Event> paramImmutableList);
      
      public abstract Builder setGenerator(String paramString);
      
      public abstract Builder setGeneratorType(int paramInt);
      
      public abstract Builder setIdentifier(String paramString);
      
      public Builder setIdentifierFromUtf8Bytes(byte[] paramArrayOfByte)
      {
        return setIdentifier(new String(paramArrayOfByte, CrashlyticsReport.UTF_8));
      }
      
      public abstract Builder setOs(CrashlyticsReport.Session.OperatingSystem paramOperatingSystem);
      
      public abstract Builder setStartedAt(long paramLong);
      
      public abstract Builder setUser(CrashlyticsReport.Session.User paramUser);
    }
    
    public static abstract class Device
    {
      public static Builder builder()
      {
        return new AutoValue_CrashlyticsReport_Session_Device.Builder();
      }
      
      public abstract int getArch();
      
      public abstract int getCores();
      
      public abstract long getDiskSpace();
      
      public abstract String getManufacturer();
      
      public abstract String getModel();
      
      public abstract String getModelClass();
      
      public abstract long getRam();
      
      public abstract int getState();
      
      public abstract boolean isSimulator();
      
      public static abstract class Builder
      {
        public abstract CrashlyticsReport.Session.Device build();
        
        public abstract Builder setArch(int paramInt);
        
        public abstract Builder setCores(int paramInt);
        
        public abstract Builder setDiskSpace(long paramLong);
        
        public abstract Builder setManufacturer(String paramString);
        
        public abstract Builder setModel(String paramString);
        
        public abstract Builder setModelClass(String paramString);
        
        public abstract Builder setRam(long paramLong);
        
        public abstract Builder setSimulator(boolean paramBoolean);
        
        public abstract Builder setState(int paramInt);
      }
    }
    
    public static abstract class Event
    {
      public static Builder builder()
      {
        return new AutoValue_CrashlyticsReport_Session_Event.Builder();
      }
      
      public abstract Application getApp();
      
      public abstract Device getDevice();
      
      public abstract Log getLog();
      
      public abstract long getTimestamp();
      
      public abstract String getType();
      
      public abstract Builder toBuilder();
      
      public static abstract class Application
      {
        public static Builder builder()
        {
          return new AutoValue_CrashlyticsReport_Session_Event_Application.Builder();
        }
        
        public abstract Boolean getBackground();
        
        public abstract ImmutableList<CrashlyticsReport.CustomAttribute> getCustomAttributes();
        
        public abstract Execution getExecution();
        
        public abstract int getUiOrientation();
        
        public abstract Builder toBuilder();
        
        public static abstract class Builder
        {
          public abstract CrashlyticsReport.Session.Event.Application build();
          
          public abstract Builder setBackground(Boolean paramBoolean);
          
          public abstract Builder setCustomAttributes(ImmutableList<CrashlyticsReport.CustomAttribute> paramImmutableList);
          
          public abstract Builder setExecution(CrashlyticsReport.Session.Event.Application.Execution paramExecution);
          
          public abstract Builder setUiOrientation(int paramInt);
        }
        
        public static abstract class Execution
        {
          public static Builder builder()
          {
            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution.Builder();
          }
          
          public abstract ImmutableList<BinaryImage> getBinaries();
          
          public abstract Exception getException();
          
          public abstract Signal getSignal();
          
          public abstract ImmutableList<Thread> getThreads();
          
          public static abstract class BinaryImage
          {
            public static Builder builder()
            {
              return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.Builder();
            }
            
            public abstract long getBaseAddress();
            
            public abstract String getName();
            
            public abstract long getSize();
            
            @Encodable.Ignore
            public abstract String getUuid();
            
            @Encodable.Field(name="uuid")
            public byte[] getUuidUtf8Bytes()
            {
              String str = getUuid();
              if (str != null) {
                return str.getBytes(CrashlyticsReport.UTF_8);
              }
              return null;
            }
            
            public static abstract class Builder
            {
              public abstract CrashlyticsReport.Session.Event.Application.Execution.BinaryImage build();
              
              public abstract Builder setBaseAddress(long paramLong);
              
              public abstract Builder setName(String paramString);
              
              public abstract Builder setSize(long paramLong);
              
              public abstract Builder setUuid(String paramString);
              
              public Builder setUuidFromUtf8Bytes(byte[] paramArrayOfByte)
              {
                return setUuid(new String(paramArrayOfByte, CrashlyticsReport.UTF_8));
              }
            }
          }
          
          public static abstract class Builder
          {
            public abstract CrashlyticsReport.Session.Event.Application.Execution build();
            
            public abstract Builder setBinaries(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> paramImmutableList);
            
            public abstract Builder setException(CrashlyticsReport.Session.Event.Application.Execution.Exception paramException);
            
            public abstract Builder setSignal(CrashlyticsReport.Session.Event.Application.Execution.Signal paramSignal);
            
            public abstract Builder setThreads(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> paramImmutableList);
          }
          
          public static abstract class Exception
          {
            public static Builder builder()
            {
              return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.Builder();
            }
            
            public abstract Exception getCausedBy();
            
            public abstract ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> getFrames();
            
            public abstract int getOverflowCount();
            
            public abstract String getReason();
            
            public abstract String getType();
            
            public static abstract class Builder
            {
              public abstract CrashlyticsReport.Session.Event.Application.Execution.Exception build();
              
              public abstract Builder setCausedBy(CrashlyticsReport.Session.Event.Application.Execution.Exception paramException);
              
              public abstract Builder setFrames(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> paramImmutableList);
              
              public abstract Builder setOverflowCount(int paramInt);
              
              public abstract Builder setReason(String paramString);
              
              public abstract Builder setType(String paramString);
            }
          }
          
          public static abstract class Signal
          {
            public static Builder builder()
            {
              return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.Builder();
            }
            
            public abstract long getAddress();
            
            public abstract String getCode();
            
            public abstract String getName();
            
            public static abstract class Builder
            {
              public abstract CrashlyticsReport.Session.Event.Application.Execution.Signal build();
              
              public abstract Builder setAddress(long paramLong);
              
              public abstract Builder setCode(String paramString);
              
              public abstract Builder setName(String paramString);
            }
          }
          
          public static abstract class Thread
          {
            public static Builder builder()
            {
              return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.Builder();
            }
            
            public abstract ImmutableList<Frame> getFrames();
            
            public abstract int getImportance();
            
            public abstract String getName();
            
            public static abstract class Builder
            {
              public abstract CrashlyticsReport.Session.Event.Application.Execution.Thread build();
              
              public abstract Builder setFrames(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> paramImmutableList);
              
              public abstract Builder setImportance(int paramInt);
              
              public abstract Builder setName(String paramString);
            }
            
            public static abstract class Frame
            {
              public static Builder builder()
              {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.Builder();
              }
              
              public abstract String getFile();
              
              public abstract int getImportance();
              
              public abstract long getOffset();
              
              public abstract long getPc();
              
              public abstract String getSymbol();
              
              public static abstract class Builder
              {
                public abstract CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame build();
                
                public abstract Builder setFile(String paramString);
                
                public abstract Builder setImportance(int paramInt);
                
                public abstract Builder setOffset(long paramLong);
                
                public abstract Builder setPc(long paramLong);
                
                public abstract Builder setSymbol(String paramString);
              }
            }
          }
        }
      }
      
      public static abstract class Builder
      {
        public abstract CrashlyticsReport.Session.Event build();
        
        public abstract Builder setApp(CrashlyticsReport.Session.Event.Application paramApplication);
        
        public abstract Builder setDevice(CrashlyticsReport.Session.Event.Device paramDevice);
        
        public abstract Builder setLog(CrashlyticsReport.Session.Event.Log paramLog);
        
        public abstract Builder setTimestamp(long paramLong);
        
        public abstract Builder setType(String paramString);
      }
      
      public static abstract class Device
      {
        public static Builder builder()
        {
          return new AutoValue_CrashlyticsReport_Session_Event_Device.Builder();
        }
        
        public abstract Double getBatteryLevel();
        
        public abstract int getBatteryVelocity();
        
        public abstract long getDiskUsed();
        
        public abstract int getOrientation();
        
        public abstract long getRamUsed();
        
        public abstract boolean isProximityOn();
        
        public static abstract class Builder
        {
          public abstract CrashlyticsReport.Session.Event.Device build();
          
          public abstract Builder setBatteryLevel(Double paramDouble);
          
          public abstract Builder setBatteryVelocity(int paramInt);
          
          public abstract Builder setDiskUsed(long paramLong);
          
          public abstract Builder setOrientation(int paramInt);
          
          public abstract Builder setProximityOn(boolean paramBoolean);
          
          public abstract Builder setRamUsed(long paramLong);
        }
      }
      
      public static abstract class Log
      {
        public static Builder builder()
        {
          return new AutoValue_CrashlyticsReport_Session_Event_Log.Builder();
        }
        
        public abstract String getContent();
        
        public static abstract class Builder
        {
          public abstract CrashlyticsReport.Session.Event.Log build();
          
          public abstract Builder setContent(String paramString);
        }
      }
    }
    
    public static abstract class OperatingSystem
    {
      public static Builder builder()
      {
        return new AutoValue_CrashlyticsReport_Session_OperatingSystem.Builder();
      }
      
      public abstract String getBuildVersion();
      
      public abstract int getPlatform();
      
      public abstract String getVersion();
      
      public abstract boolean isJailbroken();
      
      public static abstract class Builder
      {
        public abstract CrashlyticsReport.Session.OperatingSystem build();
        
        public abstract Builder setBuildVersion(String paramString);
        
        public abstract Builder setJailbroken(boolean paramBoolean);
        
        public abstract Builder setPlatform(int paramInt);
        
        public abstract Builder setVersion(String paramString);
      }
    }
    
    public static abstract class User
    {
      public static Builder builder()
      {
        return new AutoValue_CrashlyticsReport_Session_User.Builder();
      }
      
      public abstract String getIdentifier();
      
      public static abstract class Builder
      {
        public abstract CrashlyticsReport.Session.User build();
        
        public abstract Builder setIdentifier(String paramString);
      }
    }
  }
  
  public static enum Type
  {
    static
    {
      Type localType = new Type("NATIVE", 2);
      NATIVE = localType;
      $VALUES = new Type[] { INCOMPLETE, JAVA, localType };
    }
    
    private Type() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\CrashlyticsReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */