package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.Base64;
import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrashlyticsReportJsonTransform
{
  private static final DataEncoder CRASHLYTICS_REPORT_JSON_ENCODER = new JsonDataEncoderBuilder().configureWith(AutoCrashlyticsReportEncoder.CONFIG).ignoreNullValues(true).build();
  
  private static CrashlyticsReport.Session.Application parseApp(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Application.Builder localBuilder = CrashlyticsReport.Session.Application.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 1975623094: 
        if (str.equals("displayVersion")) {
          i = 2;
        }
        break;
      case 719853845: 
        if (str.equals("installationUuid")) {
          i = 3;
        }
        break;
      case 351608024: 
        if (str.equals("version")) {
          i = 1;
        }
        break;
      case -1618432855: 
        if (str.equals("identifier")) {
          i = 0;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              paramJsonReader.skipValue();
            } else {
              localBuilder.setInstallationUuid(paramJsonReader.nextString());
            }
          }
          else {
            localBuilder.setDisplayVersion(paramJsonReader.nextString());
          }
        }
        else {
          localBuilder.setVersion(paramJsonReader.nextString());
        }
      }
      else {
        localBuilder.setIdentifier(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static <T> ImmutableList<T> parseArray(JsonReader paramJsonReader, ObjectParser<T> paramObjectParser)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext()) {
      localArrayList.add(paramObjectParser.parse(paramJsonReader));
    }
    paramJsonReader.endArray();
    return ImmutableList.from(localArrayList);
  }
  
  private static CrashlyticsReport.CustomAttribute parseCustomAttribute(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.CustomAttribute.Builder localBuilder = CrashlyticsReport.CustomAttribute.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      int j = str.hashCode();
      if (j != 106079)
      {
        if ((j == 111972721) && (str.equals("value"))) {
          i = 1;
        }
      }
      else if (str.equals("key")) {
        i = 0;
      }
      if (i != 0)
      {
        if (i != 1) {
          paramJsonReader.skipValue();
        } else {
          localBuilder.setValue(paramJsonReader.nextString());
        }
      }
      else {
        localBuilder.setKey(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.Session.Device parseDevice(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Device.Builder localBuilder = CrashlyticsReport.Session.Device.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 2078953423: 
        if (str.equals("modelClass")) {
          i = 8;
        }
        break;
      case 109757585: 
        if (str.equals("state")) {
          i = 6;
        }
        break;
      case 104069929: 
        if (str.equals("model")) {
          i = 1;
        }
        break;
      case 94848180: 
        if (str.equals("cores")) {
          i = 2;
        }
        break;
      case 81784169: 
        if (str.equals("diskSpace")) {
          i = 4;
        }
        break;
      case 3002454: 
        if (str.equals("arch")) {
          i = 0;
        }
        break;
      case 112670: 
        if (str.equals("ram")) {
          i = 3;
        }
        break;
      case -1969347631: 
        if (str.equals("manufacturer")) {
          i = 7;
        }
        break;
      case -1981332476: 
        if (str.equals("simulator")) {
          i = 5;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 8: 
        localBuilder.setModelClass(paramJsonReader.nextString());
        break;
      case 7: 
        localBuilder.setManufacturer(paramJsonReader.nextString());
        break;
      case 6: 
        localBuilder.setState(paramJsonReader.nextInt());
        break;
      case 5: 
        localBuilder.setSimulator(paramJsonReader.nextBoolean());
        break;
      case 4: 
        localBuilder.setDiskSpace(paramJsonReader.nextLong());
        break;
      case 3: 
        localBuilder.setRam(paramJsonReader.nextLong());
        break;
      case 2: 
        localBuilder.setCores(paramJsonReader.nextInt());
        break;
      case 1: 
        localBuilder.setModel(paramJsonReader.nextString());
        break;
      case 0: 
        localBuilder.setArch(paramJsonReader.nextInt());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.Session.Event parseEvent(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Builder localBuilder = CrashlyticsReport.Session.Event.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 55126294: 
        if (str.equals("timestamp")) {
          i = 0;
        }
        break;
      case 3575610: 
        if (str.equals("type")) {
          i = 1;
        }
        break;
      case 107332: 
        if (str.equals("log")) {
          i = 4;
        }
        break;
      case 96801: 
        if (str.equals("app")) {
          i = 2;
        }
        break;
      case -1335157162: 
        if (str.equals("device")) {
          i = 3;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                paramJsonReader.skipValue();
              } else {
                localBuilder.setLog(parseEventLog(paramJsonReader));
              }
            }
            else {
              localBuilder.setDevice(parseEventDevice(paramJsonReader));
            }
          }
          else {
            localBuilder.setApp(parseEventApp(paramJsonReader));
          }
        }
        else {
          localBuilder.setType(paramJsonReader.nextString());
        }
      }
      else {
        localBuilder.setTimestamp(paramJsonReader.nextLong());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.Session.Event.Application parseEventApp(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Application.Builder localBuilder = CrashlyticsReport.Session.Event.Application.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 928737948: 
        if (str.equals("uiOrientation")) {
          i = 1;
        }
        break;
      case 555169704: 
        if (str.equals("customAttributes")) {
          i = 3;
        }
        break;
      case -1090974952: 
        if (str.equals("execution")) {
          i = 2;
        }
        break;
      case -1332194002: 
        if (str.equals("background")) {
          i = 0;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              paramJsonReader.skipValue();
            } else {
              localBuilder.setCustomAttributes(parseArray(paramJsonReader, CrashlyticsReportJsonTransform..Lambda.3.lambdaFactory$()));
            }
          }
          else {
            localBuilder.setExecution(parseEventExecution(paramJsonReader));
          }
        }
        else {
          localBuilder.setUiOrientation(paramJsonReader.nextInt());
        }
      }
      else {
        localBuilder.setBackground(Boolean.valueOf(paramJsonReader.nextBoolean()));
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.Session.Event.Application.Execution.BinaryImage parseEventBinaryImage(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder localBuilder = CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 1153765347: 
        if (str.equals("baseAddress")) {
          i = 1;
        }
        break;
      case 3601339: 
        if (str.equals("uuid")) {
          i = 3;
        }
        break;
      case 3530753: 
        if (str.equals("size")) {
          i = 2;
        }
        break;
      case 3373707: 
        if (str.equals("name")) {
          i = 0;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              paramJsonReader.skipValue();
            } else {
              localBuilder.setUuidFromUtf8Bytes(Base64.decode(paramJsonReader.nextString(), 2));
            }
          }
          else {
            localBuilder.setSize(paramJsonReader.nextLong());
          }
        }
        else {
          localBuilder.setBaseAddress(paramJsonReader.nextLong());
        }
      }
      else {
        localBuilder.setName(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.Session.Event.Device parseEventDevice(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Device.Builder localBuilder = CrashlyticsReport.Session.Event.Device.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 1516795582: 
        if (str.equals("proximityOn")) {
          i = 3;
        }
        break;
      case 976541947: 
        if (str.equals("ramUsed")) {
          i = 5;
        }
        break;
      case 279795450: 
        if (str.equals("diskUsed")) {
          i = 2;
        }
        break;
      case -1439500848: 
        if (str.equals("orientation")) {
          i = 4;
        }
        break;
      case -1455558134: 
        if (str.equals("batteryVelocity")) {
          i = 1;
        }
        break;
      case -1708606089: 
        if (str.equals("batteryLevel")) {
          i = 0;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 5) {
                  paramJsonReader.skipValue();
                } else {
                  localBuilder.setRamUsed(paramJsonReader.nextLong());
                }
              }
              else {
                localBuilder.setOrientation(paramJsonReader.nextInt());
              }
            }
            else {
              localBuilder.setProximityOn(paramJsonReader.nextBoolean());
            }
          }
          else {
            localBuilder.setDiskUsed(paramJsonReader.nextLong());
          }
        }
        else {
          localBuilder.setBatteryVelocity(paramJsonReader.nextInt());
        }
      }
      else {
        localBuilder.setBatteryLevel(Double.valueOf(paramJsonReader.nextDouble()));
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.Session.Event.Application.Execution parseEventExecution(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Application.Execution.Builder localBuilder = CrashlyticsReport.Session.Event.Application.Execution.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 1481625679: 
        if (str.equals("exception")) {
          i = 1;
        }
        break;
      case 937615455: 
        if (str.equals("binaries")) {
          i = 3;
        }
        break;
      case -902467928: 
        if (str.equals("signal")) {
          i = 2;
        }
        break;
      case -1337936983: 
        if (str.equals("threads")) {
          i = 0;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              paramJsonReader.skipValue();
            } else {
              localBuilder.setBinaries(parseArray(paramJsonReader, CrashlyticsReportJsonTransform..Lambda.5.lambdaFactory$()));
            }
          }
          else {
            localBuilder.setSignal(parseEventSignal(paramJsonReader));
          }
        }
        else {
          localBuilder.setException(parseEventExecutionException(paramJsonReader));
        }
      }
      else {
        localBuilder.setThreads(parseArray(paramJsonReader, CrashlyticsReportJsonTransform..Lambda.4.lambdaFactory$()));
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.Session.Event.Application.Execution.Exception parseEventExecutionException(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder localBuilder = CrashlyticsReport.Session.Event.Application.Execution.Exception.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 581754413: 
        if (str.equals("overflowCount")) {
          i = 2;
        }
        break;
      case 91997906: 
        if (str.equals("causedBy")) {
          i = 0;
        }
        break;
      case 3575610: 
        if (str.equals("type")) {
          i = 3;
        }
        break;
      case -934964668: 
        if (str.equals("reason")) {
          i = 4;
        }
        break;
      case -1266514778: 
        if (str.equals("frames")) {
          i = 1;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                paramJsonReader.skipValue();
              } else {
                localBuilder.setReason(paramJsonReader.nextString());
              }
            }
            else {
              localBuilder.setType(paramJsonReader.nextString());
            }
          }
          else {
            localBuilder.setOverflowCount(paramJsonReader.nextInt());
          }
        }
        else {
          localBuilder.setFrames(parseArray(paramJsonReader, CrashlyticsReportJsonTransform..Lambda.6.lambdaFactory$()));
        }
      }
      else {
        localBuilder.setCausedBy(parseEventExecutionException(paramJsonReader));
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame parseEventFrame(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder localBuilder = CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 2125650548: 
        if (str.equals("importance")) {
          i = 0;
        }
        break;
      case 3143036: 
        if (str.equals("file")) {
          i = 1;
        }
        break;
      case 3571: 
        if (str.equals("pc")) {
          i = 3;
        }
        break;
      case -887523944: 
        if (str.equals("symbol")) {
          i = 4;
        }
        break;
      case -1019779949: 
        if (str.equals("offset")) {
          i = 2;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                paramJsonReader.skipValue();
              } else {
                localBuilder.setSymbol(paramJsonReader.nextString());
              }
            }
            else {
              localBuilder.setPc(paramJsonReader.nextLong());
            }
          }
          else {
            localBuilder.setOffset(paramJsonReader.nextLong());
          }
        }
        else {
          localBuilder.setFile(paramJsonReader.nextString());
        }
      }
      else {
        localBuilder.setImportance(paramJsonReader.nextInt());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.Session.Event.Log parseEventLog(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Log.Builder localBuilder = CrashlyticsReport.Session.Event.Log.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      if ((str.hashCode() == 951530617) && (str.equals("content"))) {
        i = 0;
      }
      if (i != 0) {
        paramJsonReader.skipValue();
      } else {
        localBuilder.setContent(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.Session.Event.Application.Execution.Signal parseEventSignal(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder localBuilder = CrashlyticsReport.Session.Event.Application.Execution.Signal.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      int j = str.hashCode();
      if (j != -1147692044)
      {
        if (j != 3059181)
        {
          if ((j == 3373707) && (str.equals("name"))) {
            i = 0;
          }
        }
        else if (str.equals("code")) {
          i = 1;
        }
      }
      else if (str.equals("address")) {
        i = 2;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            paramJsonReader.skipValue();
          } else {
            localBuilder.setAddress(paramJsonReader.nextLong());
          }
        }
        else {
          localBuilder.setCode(paramJsonReader.nextString());
        }
      }
      else {
        localBuilder.setName(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.Session.Event.Application.Execution.Thread parseEventThread(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder localBuilder = CrashlyticsReport.Session.Event.Application.Execution.Thread.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      int j = str.hashCode();
      if (j != -1266514778)
      {
        if (j != 3373707)
        {
          if ((j == 2125650548) && (str.equals("importance"))) {
            i = 0;
          }
        }
        else if (str.equals("name")) {
          i = 1;
        }
      }
      else if (str.equals("frames")) {
        i = 2;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            paramJsonReader.skipValue();
          } else {
            localBuilder.setFrames(parseArray(paramJsonReader, CrashlyticsReportJsonTransform..Lambda.7.lambdaFactory$()));
          }
        }
        else {
          localBuilder.setName(paramJsonReader.nextString());
        }
      }
      else {
        localBuilder.setImportance(paramJsonReader.nextInt());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.FilesPayload.File parseFile(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.FilesPayload.File.Builder localBuilder = CrashlyticsReport.FilesPayload.File.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      int j = str.hashCode();
      if (j != -734768633)
      {
        if ((j == -567321830) && (str.equals("contents"))) {
          i = 1;
        }
      }
      else if (str.equals("filename")) {
        i = 0;
      }
      if (i != 0)
      {
        if (i != 1) {
          paramJsonReader.skipValue();
        } else {
          localBuilder.setContents(Base64.decode(paramJsonReader.nextString(), 2));
        }
      }
      else {
        localBuilder.setFilename(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.FilesPayload parseNdkPayload(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.FilesPayload.Builder localBuilder = CrashlyticsReport.FilesPayload.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      int j = str.hashCode();
      if (j != 97434231)
      {
        if ((j == 106008351) && (str.equals("orgId"))) {
          i = 1;
        }
      }
      else if (str.equals("files")) {
        i = 0;
      }
      if (i != 0)
      {
        if (i != 1) {
          paramJsonReader.skipValue();
        } else {
          localBuilder.setOrgId(paramJsonReader.nextString());
        }
      }
      else {
        localBuilder.setFiles(parseArray(paramJsonReader, CrashlyticsReportJsonTransform..Lambda.2.lambdaFactory$()));
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.Session.OperatingSystem parseOs(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.OperatingSystem.Builder localBuilder = CrashlyticsReport.Session.OperatingSystem.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 1874684019: 
        if (str.equals("platform")) {
          i = 0;
        }
        break;
      case 351608024: 
        if (str.equals("version")) {
          i = 1;
        }
        break;
      case -293026577: 
        if (str.equals("jailbroken")) {
          i = 3;
        }
        break;
      case -911706486: 
        if (str.equals("buildVersion")) {
          i = 2;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              paramJsonReader.skipValue();
            } else {
              localBuilder.setJailbroken(paramJsonReader.nextBoolean());
            }
          }
          else {
            localBuilder.setBuildVersion(paramJsonReader.nextString());
          }
        }
        else {
          localBuilder.setVersion(paramJsonReader.nextString());
        }
      }
      else {
        localBuilder.setPlatform(paramJsonReader.nextInt());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport parseReport(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Builder localBuilder = CrashlyticsReport.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 1984987798: 
        if (str.equals("session")) {
          i = 6;
        }
        break;
      case 1975623094: 
        if (str.equals("displayVersion")) {
          i = 5;
        }
        break;
      case 1874684019: 
        if (str.equals("platform")) {
          i = 2;
        }
        break;
      case 719853845: 
        if (str.equals("installationUuid")) {
          i = 3;
        }
        break;
      case 344431858: 
        if (str.equals("gmpAppId")) {
          i = 1;
        }
        break;
      case -911706486: 
        if (str.equals("buildVersion")) {
          i = 4;
        }
        break;
      case -1962630338: 
        if (str.equals("sdkVersion")) {
          i = 0;
        }
        break;
      case -2118372775: 
        if (str.equals("ndkPayload")) {
          i = 7;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 7: 
        localBuilder.setNdkPayload(parseNdkPayload(paramJsonReader));
        break;
      case 6: 
        localBuilder.setSession(parseSession(paramJsonReader));
        break;
      case 5: 
        localBuilder.setDisplayVersion(paramJsonReader.nextString());
        break;
      case 4: 
        localBuilder.setBuildVersion(paramJsonReader.nextString());
        break;
      case 3: 
        localBuilder.setInstallationUuid(paramJsonReader.nextString());
        break;
      case 2: 
        localBuilder.setPlatform(paramJsonReader.nextInt());
        break;
      case 1: 
        localBuilder.setGmpAppId(paramJsonReader.nextString());
        break;
      case 0: 
        localBuilder.setSdkVersion(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.Session parseSession(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Builder localBuilder = CrashlyticsReport.Session.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 2047016109: 
        if (str.equals("generatorType")) {
          i = 10;
        }
        break;
      case 1025385094: 
        if (str.equals("crashed")) {
          i = 4;
        }
        break;
      case 286956243: 
        if (str.equals("generator")) {
          i = 0;
        }
        break;
      case 3599307: 
        if (str.equals("user")) {
          i = 5;
        }
        break;
      case 96801: 
        if (str.equals("app")) {
          i = 6;
        }
        break;
      case 3556: 
        if (str.equals("os")) {
          i = 7;
        }
        break;
      case -1291329255: 
        if (str.equals("events")) {
          i = 9;
        }
        break;
      case -1335157162: 
        if (str.equals("device")) {
          i = 8;
        }
        break;
      case -1606742899: 
        if (str.equals("endedAt")) {
          i = 3;
        }
        break;
      case -1618432855: 
        if (str.equals("identifier")) {
          i = 1;
        }
        break;
      case -2128794476: 
        if (str.equals("startedAt")) {
          i = 2;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 10: 
        localBuilder.setGeneratorType(paramJsonReader.nextInt());
        break;
      case 9: 
        localBuilder.setEvents(parseArray(paramJsonReader, CrashlyticsReportJsonTransform..Lambda.1.lambdaFactory$()));
        break;
      case 8: 
        localBuilder.setDevice(parseDevice(paramJsonReader));
        break;
      case 7: 
        localBuilder.setOs(parseOs(paramJsonReader));
        break;
      case 6: 
        localBuilder.setApp(parseApp(paramJsonReader));
        break;
      case 5: 
        localBuilder.setUser(parseUser(paramJsonReader));
        break;
      case 4: 
        localBuilder.setCrashed(paramJsonReader.nextBoolean());
        break;
      case 3: 
        localBuilder.setEndedAt(Long.valueOf(paramJsonReader.nextLong()));
        break;
      case 2: 
        localBuilder.setStartedAt(paramJsonReader.nextLong());
        break;
      case 1: 
        localBuilder.setIdentifierFromUtf8Bytes(Base64.decode(paramJsonReader.nextString(), 2));
        break;
      case 0: 
        localBuilder.setGenerator(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  private static CrashlyticsReport.Session.User parseUser(JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.User.Builder localBuilder = CrashlyticsReport.Session.User.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      if ((str.hashCode() == -1618432855) && (str.equals("identifier"))) {
        i = 0;
      }
      if (i != 0) {
        paramJsonReader.skipValue();
      } else {
        localBuilder.setIdentifier(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  /* Error */
  public CrashlyticsReport.Session.Event eventFromJson(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: new 81	android/util/JsonReader
    //   3: dup
    //   4: new 889	java/io/StringReader
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 892	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 895	android/util/JsonReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_1
    //   16: aload_1
    //   17: invokestatic 43	com/google/firebase/crashlytics/internal/model/serialization/CrashlyticsReportJsonTransform:parseEvent	(Landroid/util/JsonReader;)Lcom/google/firebase/crashlytics/internal/model/CrashlyticsReport$Session$Event;
    //   20: astore_2
    //   21: aload_1
    //   22: invokevirtual 898	android/util/JsonReader:close	()V
    //   25: aload_2
    //   26: areturn
    //   27: astore_2
    //   28: aload_1
    //   29: invokevirtual 898	android/util/JsonReader:close	()V
    //   32: aload_2
    //   33: athrow
    //   34: astore_1
    //   35: new 73	java/io/IOException
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 901	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   43: athrow
    //   44: astore_1
    //   45: goto -13 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	CrashlyticsReportJsonTransform
    //   0	48	1	paramString	String
    //   20	6	2	localEvent	CrashlyticsReport.Session.Event
    //   27	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	21	27	finally
    //   0	16	34	java/lang/IllegalStateException
    //   21	25	34	java/lang/IllegalStateException
    //   32	34	34	java/lang/IllegalStateException
    //   28	32	44	finally
  }
  
  public String eventToJson(CrashlyticsReport.Session.Event paramEvent)
  {
    return CRASHLYTICS_REPORT_JSON_ENCODER.encode(paramEvent);
  }
  
  /* Error */
  public CrashlyticsReport reportFromJson(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: new 81	android/util/JsonReader
    //   3: dup
    //   4: new 889	java/io/StringReader
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 892	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 895	android/util/JsonReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_1
    //   16: aload_1
    //   17: invokestatic 913	com/google/firebase/crashlytics/internal/model/serialization/CrashlyticsReportJsonTransform:parseReport	(Landroid/util/JsonReader;)Lcom/google/firebase/crashlytics/internal/model/CrashlyticsReport;
    //   20: astore_2
    //   21: aload_1
    //   22: invokevirtual 898	android/util/JsonReader:close	()V
    //   25: aload_2
    //   26: areturn
    //   27: astore_2
    //   28: aload_1
    //   29: invokevirtual 898	android/util/JsonReader:close	()V
    //   32: aload_2
    //   33: athrow
    //   34: astore_1
    //   35: new 73	java/io/IOException
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 901	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   43: athrow
    //   44: astore_1
    //   45: goto -13 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	CrashlyticsReportJsonTransform
    //   0	48	1	paramString	String
    //   20	6	2	localCrashlyticsReport	CrashlyticsReport
    //   27	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	21	27	finally
    //   0	16	34	java/lang/IllegalStateException
    //   21	25	34	java/lang/IllegalStateException
    //   32	34	34	java/lang/IllegalStateException
    //   28	32	44	finally
  }
  
  public String reportToJson(CrashlyticsReport paramCrashlyticsReport)
  {
    return CRASHLYTICS_REPORT_JSON_ENCODER.encode(paramCrashlyticsReport);
  }
  
  private static abstract interface ObjectParser<T>
  {
    public abstract T parse(JsonReader paramJsonReader)
      throws IOException;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\serialization\CrashlyticsReportJsonTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */