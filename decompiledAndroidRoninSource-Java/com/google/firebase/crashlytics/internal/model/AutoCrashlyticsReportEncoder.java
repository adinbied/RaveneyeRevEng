package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

public final class AutoCrashlyticsReportEncoder
  implements Configurator
{
  public static final int CODEGEN_VERSION = 1;
  public static final Configurator CONFIG = new AutoCrashlyticsReportEncoder();
  
  public void configure(EncoderConfig<?> paramEncoderConfig)
  {
    paramEncoderConfig.registerEncoder(CrashlyticsReport.class, CrashlyticsReportEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport.class, CrashlyticsReportEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.class, CrashlyticsReportSessionEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session.class, CrashlyticsReportSessionEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Application.class, CrashlyticsReportSessionApplicationEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Application.class, CrashlyticsReportSessionApplicationEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Application.Organization.class, CrashlyticsReportSessionApplicationOrganizationEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Application_Organization.class, CrashlyticsReportSessionApplicationOrganizationEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.User.class, CrashlyticsReportSessionUserEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_User.class, CrashlyticsReportSessionUserEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.OperatingSystem.class, CrashlyticsReportSessionOperatingSystemEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_OperatingSystem.class, CrashlyticsReportSessionOperatingSystemEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Device.class, CrashlyticsReportSessionDeviceEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Device.class, CrashlyticsReportSessionDeviceEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.class, CrashlyticsReportSessionEventEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event.class, CrashlyticsReportSessionEventEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.class, CrashlyticsReportSessionEventApplicationEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application.class, CrashlyticsReportSessionEventApplicationEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.class, CrashlyticsReportSessionEventApplicationExecutionEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution.class, CrashlyticsReportSessionEventApplicationExecutionEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Thread.class, CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.class, CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.class, CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class, CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Exception.class, CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.class, CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Signal.class, CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class, CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.class, CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class, CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.CustomAttribute.class, CrashlyticsReportCustomAttributeEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_CustomAttribute.class, CrashlyticsReportCustomAttributeEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Device.class, CrashlyticsReportSessionEventDeviceEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Device.class, CrashlyticsReportSessionEventDeviceEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Log.class, CrashlyticsReportSessionEventLogEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Log.class, CrashlyticsReportSessionEventLogEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.FilesPayload.class, CrashlyticsReportFilesPayloadEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_FilesPayload.class, CrashlyticsReportFilesPayloadEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(CrashlyticsReport.FilesPayload.File.class, CrashlyticsReportFilesPayloadFileEncoder.INSTANCE);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_FilesPayload_File.class, CrashlyticsReportFilesPayloadFileEncoder.INSTANCE);
  }
  
  private static final class CrashlyticsReportCustomAttributeEncoder
    implements ObjectEncoder<CrashlyticsReport.CustomAttribute>
  {
    static final CrashlyticsReportCustomAttributeEncoder INSTANCE = new CrashlyticsReportCustomAttributeEncoder();
    
    public void encode(CrashlyticsReport.CustomAttribute paramCustomAttribute, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("key", paramCustomAttribute.getKey());
      paramObjectEncoderContext.add("value", paramCustomAttribute.getValue());
    }
  }
  
  private static final class CrashlyticsReportEncoder
    implements ObjectEncoder<CrashlyticsReport>
  {
    static final CrashlyticsReportEncoder INSTANCE = new CrashlyticsReportEncoder();
    
    public void encode(CrashlyticsReport paramCrashlyticsReport, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("sdkVersion", paramCrashlyticsReport.getSdkVersion());
      paramObjectEncoderContext.add("gmpAppId", paramCrashlyticsReport.getGmpAppId());
      paramObjectEncoderContext.add("platform", paramCrashlyticsReport.getPlatform());
      paramObjectEncoderContext.add("installationUuid", paramCrashlyticsReport.getInstallationUuid());
      paramObjectEncoderContext.add("buildVersion", paramCrashlyticsReport.getBuildVersion());
      paramObjectEncoderContext.add("displayVersion", paramCrashlyticsReport.getDisplayVersion());
      paramObjectEncoderContext.add("session", paramCrashlyticsReport.getSession());
      paramObjectEncoderContext.add("ndkPayload", paramCrashlyticsReport.getNdkPayload());
    }
  }
  
  private static final class CrashlyticsReportFilesPayloadEncoder
    implements ObjectEncoder<CrashlyticsReport.FilesPayload>
  {
    static final CrashlyticsReportFilesPayloadEncoder INSTANCE = new CrashlyticsReportFilesPayloadEncoder();
    
    public void encode(CrashlyticsReport.FilesPayload paramFilesPayload, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("files", paramFilesPayload.getFiles());
      paramObjectEncoderContext.add("orgId", paramFilesPayload.getOrgId());
    }
  }
  
  private static final class CrashlyticsReportFilesPayloadFileEncoder
    implements ObjectEncoder<CrashlyticsReport.FilesPayload.File>
  {
    static final CrashlyticsReportFilesPayloadFileEncoder INSTANCE = new CrashlyticsReportFilesPayloadFileEncoder();
    
    public void encode(CrashlyticsReport.FilesPayload.File paramFile, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("filename", paramFile.getFilename());
      paramObjectEncoderContext.add("contents", paramFile.getContents());
    }
  }
  
  private static final class CrashlyticsReportSessionApplicationEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Application>
  {
    static final CrashlyticsReportSessionApplicationEncoder INSTANCE = new CrashlyticsReportSessionApplicationEncoder();
    
    public void encode(CrashlyticsReport.Session.Application paramApplication, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("identifier", paramApplication.getIdentifier());
      paramObjectEncoderContext.add("version", paramApplication.getVersion());
      paramObjectEncoderContext.add("displayVersion", paramApplication.getDisplayVersion());
      paramObjectEncoderContext.add("organization", paramApplication.getOrganization());
      paramObjectEncoderContext.add("installationUuid", paramApplication.getInstallationUuid());
    }
  }
  
  private static final class CrashlyticsReportSessionApplicationOrganizationEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Application.Organization>
  {
    static final CrashlyticsReportSessionApplicationOrganizationEncoder INSTANCE = new CrashlyticsReportSessionApplicationOrganizationEncoder();
    
    public void encode(CrashlyticsReport.Session.Application.Organization paramOrganization, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("clsId", paramOrganization.getClsId());
    }
  }
  
  private static final class CrashlyticsReportSessionDeviceEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Device>
  {
    static final CrashlyticsReportSessionDeviceEncoder INSTANCE = new CrashlyticsReportSessionDeviceEncoder();
    
    public void encode(CrashlyticsReport.Session.Device paramDevice, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("arch", paramDevice.getArch());
      paramObjectEncoderContext.add("model", paramDevice.getModel());
      paramObjectEncoderContext.add("cores", paramDevice.getCores());
      paramObjectEncoderContext.add("ram", paramDevice.getRam());
      paramObjectEncoderContext.add("diskSpace", paramDevice.getDiskSpace());
      paramObjectEncoderContext.add("simulator", paramDevice.isSimulator());
      paramObjectEncoderContext.add("state", paramDevice.getState());
      paramObjectEncoderContext.add("manufacturer", paramDevice.getManufacturer());
      paramObjectEncoderContext.add("modelClass", paramDevice.getModelClass());
    }
  }
  
  private static final class CrashlyticsReportSessionEncoder
    implements ObjectEncoder<CrashlyticsReport.Session>
  {
    static final CrashlyticsReportSessionEncoder INSTANCE = new CrashlyticsReportSessionEncoder();
    
    public void encode(CrashlyticsReport.Session paramSession, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("generator", paramSession.getGenerator());
      paramObjectEncoderContext.add("identifier", paramSession.getIdentifierUtf8Bytes());
      paramObjectEncoderContext.add("startedAt", paramSession.getStartedAt());
      paramObjectEncoderContext.add("endedAt", paramSession.getEndedAt());
      paramObjectEncoderContext.add("crashed", paramSession.isCrashed());
      paramObjectEncoderContext.add("app", paramSession.getApp());
      paramObjectEncoderContext.add("user", paramSession.getUser());
      paramObjectEncoderContext.add("os", paramSession.getOs());
      paramObjectEncoderContext.add("device", paramSession.getDevice());
      paramObjectEncoderContext.add("events", paramSession.getEvents());
      paramObjectEncoderContext.add("generatorType", paramSession.getGeneratorType());
    }
  }
  
  private static final class CrashlyticsReportSessionEventApplicationEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Application>
  {
    static final CrashlyticsReportSessionEventApplicationEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationEncoder();
    
    public void encode(CrashlyticsReport.Session.Event.Application paramApplication, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("execution", paramApplication.getExecution());
      paramObjectEncoderContext.add("customAttributes", paramApplication.getCustomAttributes());
      paramObjectEncoderContext.add("background", paramApplication.getBackground());
      paramObjectEncoderContext.add("uiOrientation", paramApplication.getUiOrientation());
    }
  }
  
  private static final class CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage>
  {
    static final CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder();
    
    public void encode(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage paramBinaryImage, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("baseAddress", paramBinaryImage.getBaseAddress());
      paramObjectEncoderContext.add("size", paramBinaryImage.getSize());
      paramObjectEncoderContext.add("name", paramBinaryImage.getName());
      paramObjectEncoderContext.add("uuid", paramBinaryImage.getUuidUtf8Bytes());
    }
  }
  
  private static final class CrashlyticsReportSessionEventApplicationExecutionEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution>
  {
    static final CrashlyticsReportSessionEventApplicationExecutionEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionEncoder();
    
    public void encode(CrashlyticsReport.Session.Event.Application.Execution paramExecution, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("threads", paramExecution.getThreads());
      paramObjectEncoderContext.add("exception", paramExecution.getException());
      paramObjectEncoderContext.add("signal", paramExecution.getSignal());
      paramObjectEncoderContext.add("binaries", paramExecution.getBinaries());
    }
  }
  
  private static final class CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Exception>
  {
    static final CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder();
    
    public void encode(CrashlyticsReport.Session.Event.Application.Execution.Exception paramException, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("type", paramException.getType());
      paramObjectEncoderContext.add("reason", paramException.getReason());
      paramObjectEncoderContext.add("frames", paramException.getFrames());
      paramObjectEncoderContext.add("causedBy", paramException.getCausedBy());
      paramObjectEncoderContext.add("overflowCount", paramException.getOverflowCount());
    }
  }
  
  private static final class CrashlyticsReportSessionEventApplicationExecutionSignalEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Signal>
  {
    static final CrashlyticsReportSessionEventApplicationExecutionSignalEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionSignalEncoder();
    
    public void encode(CrashlyticsReport.Session.Event.Application.Execution.Signal paramSignal, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("name", paramSignal.getName());
      paramObjectEncoderContext.add("code", paramSignal.getCode());
      paramObjectEncoderContext.add("address", paramSignal.getAddress());
    }
  }
  
  private static final class CrashlyticsReportSessionEventApplicationExecutionThreadEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread>
  {
    static final CrashlyticsReportSessionEventApplicationExecutionThreadEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionThreadEncoder();
    
    public void encode(CrashlyticsReport.Session.Event.Application.Execution.Thread paramThread, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("name", paramThread.getName());
      paramObjectEncoderContext.add("importance", paramThread.getImportance());
      paramObjectEncoderContext.add("frames", paramThread.getFrames());
    }
  }
  
  private static final class CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame>
  {
    static final CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder();
    
    public void encode(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame paramFrame, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("pc", paramFrame.getPc());
      paramObjectEncoderContext.add("symbol", paramFrame.getSymbol());
      paramObjectEncoderContext.add("file", paramFrame.getFile());
      paramObjectEncoderContext.add("offset", paramFrame.getOffset());
      paramObjectEncoderContext.add("importance", paramFrame.getImportance());
    }
  }
  
  private static final class CrashlyticsReportSessionEventDeviceEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Device>
  {
    static final CrashlyticsReportSessionEventDeviceEncoder INSTANCE = new CrashlyticsReportSessionEventDeviceEncoder();
    
    public void encode(CrashlyticsReport.Session.Event.Device paramDevice, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("batteryLevel", paramDevice.getBatteryLevel());
      paramObjectEncoderContext.add("batteryVelocity", paramDevice.getBatteryVelocity());
      paramObjectEncoderContext.add("proximityOn", paramDevice.isProximityOn());
      paramObjectEncoderContext.add("orientation", paramDevice.getOrientation());
      paramObjectEncoderContext.add("ramUsed", paramDevice.getRamUsed());
      paramObjectEncoderContext.add("diskUsed", paramDevice.getDiskUsed());
    }
  }
  
  private static final class CrashlyticsReportSessionEventEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event>
  {
    static final CrashlyticsReportSessionEventEncoder INSTANCE = new CrashlyticsReportSessionEventEncoder();
    
    public void encode(CrashlyticsReport.Session.Event paramEvent, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("timestamp", paramEvent.getTimestamp());
      paramObjectEncoderContext.add("type", paramEvent.getType());
      paramObjectEncoderContext.add("app", paramEvent.getApp());
      paramObjectEncoderContext.add("device", paramEvent.getDevice());
      paramObjectEncoderContext.add("log", paramEvent.getLog());
    }
  }
  
  private static final class CrashlyticsReportSessionEventLogEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Log>
  {
    static final CrashlyticsReportSessionEventLogEncoder INSTANCE = new CrashlyticsReportSessionEventLogEncoder();
    
    public void encode(CrashlyticsReport.Session.Event.Log paramLog, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("content", paramLog.getContent());
    }
  }
  
  private static final class CrashlyticsReportSessionOperatingSystemEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.OperatingSystem>
  {
    static final CrashlyticsReportSessionOperatingSystemEncoder INSTANCE = new CrashlyticsReportSessionOperatingSystemEncoder();
    
    public void encode(CrashlyticsReport.Session.OperatingSystem paramOperatingSystem, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("platform", paramOperatingSystem.getPlatform());
      paramObjectEncoderContext.add("version", paramOperatingSystem.getVersion());
      paramObjectEncoderContext.add("buildVersion", paramOperatingSystem.getBuildVersion());
      paramObjectEncoderContext.add("jailbroken", paramOperatingSystem.isJailbroken());
    }
  }
  
  private static final class CrashlyticsReportSessionUserEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.User>
  {
    static final CrashlyticsReportSessionUserEncoder INSTANCE = new CrashlyticsReportSessionUserEncoder();
    
    public void encode(CrashlyticsReport.Session.User paramUser, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add("identifier", paramUser.getIdentifier());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoCrashlyticsReportEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */