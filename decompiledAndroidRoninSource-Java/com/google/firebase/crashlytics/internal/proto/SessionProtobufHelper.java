package com.google.firebase.crashlytics.internal.proto;

import android.app.ActivityManager.RunningAppProcessInfo;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SessionProtobufHelper
{
  private static final String SIGNAL_DEFAULT = "0";
  private static final ByteString SIGNAL_DEFAULT_BYTE_STRING = ByteString.copyFromUtf8("0");
  private static final ByteString UNITY_PLATFORM_BYTE_STRING = ByteString.copyFromUtf8("Unity");
  
  private static int getBinaryImageSize(ByteString paramByteString1, ByteString paramByteString2)
  {
    int j = CodedOutputStream.computeUInt64Size(1, 0L) + 0 + CodedOutputStream.computeUInt64Size(2, 0L) + CodedOutputStream.computeBytesSize(3, paramByteString1);
    int i = j;
    if (paramByteString2 != null) {
      i = j + CodedOutputStream.computeBytesSize(4, paramByteString2);
    }
    return i;
  }
  
  private static int getEventAppCustomAttributeSize(String paramString1, String paramString2)
  {
    int i = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(paramString1));
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    return i + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(paramString1));
  }
  
  private static int getEventAppExecutionExceptionSize(TrimmedThrowableData paramTrimmedThrowableData, int paramInt1, int paramInt2)
  {
    int i = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(paramTrimmedThrowableData.className));
    int k = 0;
    int j = i + 0;
    Object localObject = paramTrimmedThrowableData.localizedMessage;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8((String)localObject));
    }
    localObject = paramTrimmedThrowableData.stacktrace;
    int m = localObject.length;
    j = 0;
    while (j < m)
    {
      int n = getFrameSize(localObject[j], true);
      i += CodedOutputStream.computeTagSize(4) + CodedOutputStream.computeRawVarint32Size(n) + n;
      j += 1;
    }
    localObject = paramTrimmedThrowableData.cause;
    j = i;
    if (localObject != null)
    {
      j = k;
      paramTrimmedThrowableData = (TrimmedThrowableData)localObject;
      if (paramInt1 < paramInt2)
      {
        paramInt1 = getEventAppExecutionExceptionSize((TrimmedThrowableData)localObject, paramInt1 + 1, paramInt2);
        return i + (CodedOutputStream.computeTagSize(6) + CodedOutputStream.computeRawVarint32Size(paramInt1) + paramInt1);
      }
      while (paramTrimmedThrowableData != null)
      {
        paramTrimmedThrowableData = paramTrimmedThrowableData.cause;
        j += 1;
      }
      j = i + CodedOutputStream.computeUInt32Size(7, j);
    }
    return j;
  }
  
  private static int getEventAppExecutionSignalSize()
  {
    return CodedOutputStream.computeBytesSize(1, SIGNAL_DEFAULT_BYTE_STRING) + 0 + CodedOutputStream.computeBytesSize(2, SIGNAL_DEFAULT_BYTE_STRING) + CodedOutputStream.computeUInt64Size(3, 0L);
  }
  
  private static int getEventAppExecutionSize(TrimmedThrowableData paramTrimmedThrowableData, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List<StackTraceElement[]> paramList, int paramInt, ByteString paramByteString1, ByteString paramByteString2)
  {
    int i = getThreadSize(paramThread, paramArrayOfStackTraceElement, 4, true);
    i = CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(i) + i + 0;
    int k = paramArrayOfThread.length;
    int j = 0;
    while (j < k)
    {
      m = getThreadSize(paramArrayOfThread[j], (StackTraceElement[])paramList.get(j), 0, false);
      i += CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(m) + m;
      j += 1;
    }
    paramInt = getEventAppExecutionExceptionSize(paramTrimmedThrowableData, 1, paramInt);
    j = CodedOutputStream.computeTagSize(2);
    k = CodedOutputStream.computeRawVarint32Size(paramInt);
    int m = getEventAppExecutionSignalSize();
    int n = CodedOutputStream.computeTagSize(3);
    int i1 = CodedOutputStream.computeRawVarint32Size(m);
    int i2 = getBinaryImageSize(paramByteString1, paramByteString2);
    return i + (j + k + paramInt) + (n + i1 + m) + (CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeRawVarint32Size(i2) + i2);
  }
  
  private static int getEventAppSize(TrimmedThrowableData paramTrimmedThrowableData, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List<StackTraceElement[]> paramList, int paramInt1, ByteString paramByteString1, ByteString paramByteString2, Map<String, String> paramMap, ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, int paramInt2)
  {
    paramInt1 = getEventAppExecutionSize(paramTrimmedThrowableData, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt1, paramByteString1, paramByteString2);
    boolean bool = true;
    int i = CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(paramInt1) + paramInt1 + 0;
    paramInt1 = i;
    if (paramMap != null)
    {
      paramTrimmedThrowableData = paramMap.entrySet().iterator();
      for (;;)
      {
        paramInt1 = i;
        if (!paramTrimmedThrowableData.hasNext()) {
          break;
        }
        paramThread = (Map.Entry)paramTrimmedThrowableData.next();
        paramInt1 = getEventAppCustomAttributeSize((String)paramThread.getKey(), (String)paramThread.getValue());
        i += CodedOutputStream.computeTagSize(2) + CodedOutputStream.computeRawVarint32Size(paramInt1) + paramInt1;
      }
    }
    i = paramInt1;
    if (paramRunningAppProcessInfo != null)
    {
      if (paramRunningAppProcessInfo.importance == 100) {
        bool = false;
      }
      i = paramInt1 + CodedOutputStream.computeBoolSize(3, bool);
    }
    return i + CodedOutputStream.computeUInt32Size(4, paramInt2);
  }
  
  private static int getEventDeviceSize(Float paramFloat, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong1, long paramLong2)
  {
    int i = 0;
    if (paramFloat != null) {
      i = 0 + CodedOutputStream.computeFloatSize(1, paramFloat.floatValue());
    }
    return i + CodedOutputStream.computeSInt32Size(2, paramInt1) + CodedOutputStream.computeBoolSize(3, paramBoolean) + CodedOutputStream.computeUInt32Size(4, paramInt2) + CodedOutputStream.computeUInt64Size(5, paramLong1) + CodedOutputStream.computeUInt64Size(6, paramLong2);
  }
  
  private static int getEventLogSize(ByteString paramByteString)
  {
    return CodedOutputStream.computeBytesSize(1, paramByteString);
  }
  
  private static int getFrameSize(StackTraceElement paramStackTraceElement, boolean paramBoolean)
  {
    boolean bool = paramStackTraceElement.isNativeMethod();
    int k = 0;
    if (bool) {
      i = CodedOutputStream.computeUInt64Size(1, Math.max(paramStackTraceElement.getLineNumber(), 0));
    } else {
      i = CodedOutputStream.computeUInt64Size(1, 0L);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramStackTraceElement.getClassName());
    localStringBuilder.append(".");
    localStringBuilder.append(paramStackTraceElement.getMethodName());
    int j = i + 0 + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(localStringBuilder.toString()));
    int i = j;
    if (paramStackTraceElement.getFileName() != null) {
      i = j + CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(paramStackTraceElement.getFileName()));
    }
    j = i;
    if (!paramStackTraceElement.isNativeMethod())
    {
      j = i;
      if (paramStackTraceElement.getLineNumber() > 0) {
        j = i + CodedOutputStream.computeUInt64Size(4, paramStackTraceElement.getLineNumber());
      }
    }
    i = k;
    if (paramBoolean) {
      i = 2;
    }
    return j + CodedOutputStream.computeUInt32Size(5, i);
  }
  
  private static int getSessionAppSize(ByteString paramByteString1, ByteString paramByteString2, ByteString paramByteString3, ByteString paramByteString4, int paramInt, ByteString paramByteString5)
  {
    int j = CodedOutputStream.computeBytesSize(1, paramByteString1) + 0 + CodedOutputStream.computeBytesSize(2, paramByteString2) + CodedOutputStream.computeBytesSize(3, paramByteString3) + CodedOutputStream.computeBytesSize(6, paramByteString4);
    int i = j;
    if (paramByteString5 != null) {
      i = j + CodedOutputStream.computeBytesSize(8, UNITY_PLATFORM_BYTE_STRING) + CodedOutputStream.computeBytesSize(9, paramByteString5);
    }
    return i + CodedOutputStream.computeEnumSize(10, paramInt);
  }
  
  private static int getSessionDeviceSize(int paramInt1, ByteString paramByteString1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt3, ByteString paramByteString2, ByteString paramByteString3)
  {
    int j = CodedOutputStream.computeEnumSize(3, paramInt1);
    int i = 0;
    if (paramByteString1 == null) {
      paramInt1 = 0;
    } else {
      paramInt1 = CodedOutputStream.computeBytesSize(4, paramByteString1);
    }
    int k = CodedOutputStream.computeUInt32Size(5, paramInt2);
    int m = CodedOutputStream.computeUInt64Size(6, paramLong1);
    int n = CodedOutputStream.computeUInt64Size(7, paramLong2);
    int i1 = CodedOutputStream.computeBoolSize(10, paramBoolean);
    int i2 = CodedOutputStream.computeUInt32Size(12, paramInt3);
    if (paramByteString2 == null) {
      paramInt2 = 0;
    } else {
      paramInt2 = CodedOutputStream.computeBytesSize(13, paramByteString2);
    }
    if (paramByteString3 == null) {
      paramInt3 = i;
    } else {
      paramInt3 = CodedOutputStream.computeBytesSize(14, paramByteString3);
    }
    return j + 0 + paramInt1 + k + m + n + i1 + i2 + paramInt2 + paramInt3;
  }
  
  private static int getSessionEventSize(long paramLong1, String paramString, TrimmedThrowableData paramTrimmedThrowableData, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List<StackTraceElement[]> paramList, int paramInt1, Map<String, String> paramMap, ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, int paramInt2, ByteString paramByteString1, ByteString paramByteString2, Float paramFloat, int paramInt3, boolean paramBoolean, long paramLong2, long paramLong3, ByteString paramByteString3)
  {
    int i = CodedOutputStream.computeUInt64Size(1, paramLong1);
    int j = CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(paramString));
    paramInt1 = getEventAppSize(paramTrimmedThrowableData, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt1, paramByteString1, paramByteString2, paramMap, paramRunningAppProcessInfo, paramInt2);
    int k = CodedOutputStream.computeTagSize(3);
    int m = CodedOutputStream.computeRawVarint32Size(paramInt1);
    paramInt2 = getEventDeviceSize(paramFloat, paramInt3, paramBoolean, paramInt2, paramLong2, paramLong3);
    paramInt2 = i + 0 + j + (k + m + paramInt1) + (CodedOutputStream.computeTagSize(5) + CodedOutputStream.computeRawVarint32Size(paramInt2) + paramInt2);
    paramInt1 = paramInt2;
    if (paramByteString3 != null)
    {
      paramInt1 = getEventLogSize(paramByteString3);
      paramInt1 = paramInt2 + (CodedOutputStream.computeTagSize(6) + CodedOutputStream.computeRawVarint32Size(paramInt1) + paramInt1);
    }
    return paramInt1;
  }
  
  private static int getSessionOSSize(ByteString paramByteString1, ByteString paramByteString2, boolean paramBoolean)
  {
    return CodedOutputStream.computeEnumSize(1, 3) + 0 + CodedOutputStream.computeBytesSize(2, paramByteString1) + CodedOutputStream.computeBytesSize(3, paramByteString2) + CodedOutputStream.computeBoolSize(4, paramBoolean);
  }
  
  private static int getThreadSize(Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt, boolean paramBoolean)
  {
    int i = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(paramThread.getName())) + CodedOutputStream.computeUInt32Size(2, paramInt);
    int j = paramArrayOfStackTraceElement.length;
    paramInt = 0;
    while (paramInt < j)
    {
      int k = getFrameSize(paramArrayOfStackTraceElement[paramInt], paramBoolean);
      i += CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeRawVarint32Size(k) + k;
      paramInt += 1;
    }
    return i;
  }
  
  private static ByteString stringToByteString(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return ByteString.copyFromUtf8(paramString);
  }
  
  public static void writeBeginSession(CodedOutputStream paramCodedOutputStream, String paramString1, String paramString2, long paramLong)
    throws Exception
  {
    paramCodedOutputStream.writeBytes(1, ByteString.copyFromUtf8(paramString2));
    paramCodedOutputStream.writeBytes(2, ByteString.copyFromUtf8(paramString1));
    paramCodedOutputStream.writeUInt64(3, paramLong);
  }
  
  private static void writeFrame(CodedOutputStream paramCodedOutputStream, int paramInt, StackTraceElement paramStackTraceElement, boolean paramBoolean)
    throws Exception
  {
    paramCodedOutputStream.writeTag(paramInt, 2);
    paramCodedOutputStream.writeRawVarint32(getFrameSize(paramStackTraceElement, paramBoolean));
    boolean bool = paramStackTraceElement.isNativeMethod();
    paramInt = 0;
    if (bool) {
      paramCodedOutputStream.writeUInt64(1, Math.max(paramStackTraceElement.getLineNumber(), 0));
    } else {
      paramCodedOutputStream.writeUInt64(1, 0L);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramStackTraceElement.getClassName());
    localStringBuilder.append(".");
    localStringBuilder.append(paramStackTraceElement.getMethodName());
    paramCodedOutputStream.writeBytes(2, ByteString.copyFromUtf8(localStringBuilder.toString()));
    if (paramStackTraceElement.getFileName() != null) {
      paramCodedOutputStream.writeBytes(3, ByteString.copyFromUtf8(paramStackTraceElement.getFileName()));
    }
    if ((!paramStackTraceElement.isNativeMethod()) && (paramStackTraceElement.getLineNumber() > 0)) {
      paramCodedOutputStream.writeUInt64(4, paramStackTraceElement.getLineNumber());
    }
    if (paramBoolean) {
      paramInt = 4;
    }
    paramCodedOutputStream.writeUInt32(5, paramInt);
  }
  
  public static void writeSessionApp(CodedOutputStream paramCodedOutputStream, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
    throws Exception
  {
    ByteString localByteString = ByteString.copyFromUtf8(paramString1);
    paramString2 = ByteString.copyFromUtf8(paramString2);
    paramString3 = ByteString.copyFromUtf8(paramString3);
    paramString4 = ByteString.copyFromUtf8(paramString4);
    if (paramString5 != null) {
      paramString1 = ByteString.copyFromUtf8(paramString5);
    } else {
      paramString1 = null;
    }
    paramCodedOutputStream.writeTag(7, 2);
    paramCodedOutputStream.writeRawVarint32(getSessionAppSize(localByteString, paramString2, paramString3, paramString4, paramInt, paramString1));
    paramCodedOutputStream.writeBytes(1, localByteString);
    paramCodedOutputStream.writeBytes(2, paramString2);
    paramCodedOutputStream.writeBytes(3, paramString3);
    paramCodedOutputStream.writeBytes(6, paramString4);
    if (paramString1 != null)
    {
      paramCodedOutputStream.writeBytes(8, UNITY_PLATFORM_BYTE_STRING);
      paramCodedOutputStream.writeBytes(9, paramString1);
    }
    paramCodedOutputStream.writeEnum(10, paramInt);
  }
  
  public static void writeSessionAppClsId(CodedOutputStream paramCodedOutputStream, String paramString)
    throws Exception
  {
    paramString = ByteString.copyFromUtf8(paramString);
    paramCodedOutputStream.writeTag(7, 2);
    int i = CodedOutputStream.computeBytesSize(2, paramString);
    paramCodedOutputStream.writeRawVarint32(CodedOutputStream.computeTagSize(5) + CodedOutputStream.computeRawVarint32Size(i) + i);
    paramCodedOutputStream.writeTag(5, 2);
    paramCodedOutputStream.writeRawVarint32(i);
    paramCodedOutputStream.writeBytes(2, paramString);
  }
  
  public static void writeSessionDevice(CodedOutputStream paramCodedOutputStream, int paramInt1, String paramString1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt3, String paramString2, String paramString3)
    throws Exception
  {
    paramString1 = stringToByteString(paramString1);
    paramString3 = stringToByteString(paramString3);
    paramString2 = stringToByteString(paramString2);
    paramCodedOutputStream.writeTag(9, 2);
    paramCodedOutputStream.writeRawVarint32(getSessionDeviceSize(paramInt1, paramString1, paramInt2, paramLong1, paramLong2, paramBoolean, paramInt3, paramString2, paramString3));
    paramCodedOutputStream.writeEnum(3, paramInt1);
    paramCodedOutputStream.writeBytes(4, paramString1);
    paramCodedOutputStream.writeUInt32(5, paramInt2);
    paramCodedOutputStream.writeUInt64(6, paramLong1);
    paramCodedOutputStream.writeUInt64(7, paramLong2);
    paramCodedOutputStream.writeBool(10, paramBoolean);
    paramCodedOutputStream.writeUInt32(12, paramInt3);
    if (paramString2 != null) {
      paramCodedOutputStream.writeBytes(13, paramString2);
    }
    if (paramString3 != null) {
      paramCodedOutputStream.writeBytes(14, paramString3);
    }
  }
  
  public static void writeSessionEvent(CodedOutputStream paramCodedOutputStream, long paramLong1, String paramString1, TrimmedThrowableData paramTrimmedThrowableData, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List<StackTraceElement[]> paramList, int paramInt1, Map<String, String> paramMap, byte[] paramArrayOfByte, ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, int paramInt2, String paramString2, String paramString3, Float paramFloat, int paramInt3, boolean paramBoolean, long paramLong2, long paramLong3)
    throws Exception
  {
    ByteString localByteString = ByteString.copyFromUtf8(paramString2);
    Object localObject = null;
    if (paramString3 == null) {
      paramString2 = null;
    } else {
      paramString2 = ByteString.copyFromUtf8(paramString3.replace("-", ""));
    }
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = ByteString.copyFrom(paramArrayOfByte);
    }
    else
    {
      Logger.getLogger().d("No log data to include with this event.");
      paramArrayOfByte = (byte[])localObject;
    }
    paramCodedOutputStream.writeTag(10, 2);
    paramCodedOutputStream.writeRawVarint32(getSessionEventSize(paramLong1, paramString1, paramTrimmedThrowableData, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt1, paramMap, paramRunningAppProcessInfo, paramInt2, localByteString, paramString2, paramFloat, paramInt3, paramBoolean, paramLong2, paramLong3, paramArrayOfByte));
    paramCodedOutputStream.writeUInt64(1, paramLong1);
    paramCodedOutputStream.writeBytes(2, ByteString.copyFromUtf8(paramString1));
    writeSessionEventApp(paramCodedOutputStream, paramTrimmedThrowableData, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt1, localByteString, paramString2, paramMap, paramRunningAppProcessInfo, paramInt2);
    writeSessionEventDevice(paramCodedOutputStream, paramFloat, paramInt3, paramBoolean, paramInt2, paramLong2, paramLong3);
    writeSessionEventLog(paramCodedOutputStream, paramArrayOfByte);
  }
  
  private static void writeSessionEventApp(CodedOutputStream paramCodedOutputStream, TrimmedThrowableData paramTrimmedThrowableData, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List<StackTraceElement[]> paramList, int paramInt1, ByteString paramByteString1, ByteString paramByteString2, Map<String, String> paramMap, ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, int paramInt2)
    throws Exception
  {
    paramCodedOutputStream.writeTag(3, 2);
    paramCodedOutputStream.writeRawVarint32(getEventAppSize(paramTrimmedThrowableData, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt1, paramByteString1, paramByteString2, paramMap, paramRunningAppProcessInfo, paramInt2));
    writeSessionEventAppExecution(paramCodedOutputStream, paramTrimmedThrowableData, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt1, paramByteString1, paramByteString2);
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      writeSessionEventAppCustomAttributes(paramCodedOutputStream, paramMap);
    }
    if (paramRunningAppProcessInfo != null)
    {
      boolean bool;
      if (paramRunningAppProcessInfo.importance != 100) {
        bool = true;
      } else {
        bool = false;
      }
      paramCodedOutputStream.writeBool(3, bool);
    }
    paramCodedOutputStream.writeUInt32(4, paramInt2);
  }
  
  private static void writeSessionEventAppCustomAttributes(CodedOutputStream paramCodedOutputStream, Map<String, String> paramMap)
    throws Exception
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      paramCodedOutputStream.writeTag(2, 2);
      paramCodedOutputStream.writeRawVarint32(getEventAppCustomAttributeSize((String)paramMap.getKey(), (String)paramMap.getValue()));
      paramCodedOutputStream.writeBytes(1, ByteString.copyFromUtf8((String)paramMap.getKey()));
      String str = (String)paramMap.getValue();
      paramMap = str;
      if (str == null) {
        paramMap = "";
      }
      paramCodedOutputStream.writeBytes(2, ByteString.copyFromUtf8(paramMap));
    }
  }
  
  private static void writeSessionEventAppExecution(CodedOutputStream paramCodedOutputStream, TrimmedThrowableData paramTrimmedThrowableData, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List<StackTraceElement[]> paramList, int paramInt, ByteString paramByteString1, ByteString paramByteString2)
    throws Exception
  {
    paramCodedOutputStream.writeTag(1, 2);
    paramCodedOutputStream.writeRawVarint32(getEventAppExecutionSize(paramTrimmedThrowableData, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt, paramByteString1, paramByteString2));
    writeThread(paramCodedOutputStream, paramThread, paramArrayOfStackTraceElement, 4, true);
    int j = paramArrayOfThread.length;
    int i = 0;
    while (i < j)
    {
      writeThread(paramCodedOutputStream, paramArrayOfThread[i], (StackTraceElement[])paramList.get(i), 0, false);
      i += 1;
    }
    writeSessionEventAppExecutionException(paramCodedOutputStream, paramTrimmedThrowableData, 1, paramInt, 2);
    paramCodedOutputStream.writeTag(3, 2);
    paramCodedOutputStream.writeRawVarint32(getEventAppExecutionSignalSize());
    paramCodedOutputStream.writeBytes(1, SIGNAL_DEFAULT_BYTE_STRING);
    paramCodedOutputStream.writeBytes(2, SIGNAL_DEFAULT_BYTE_STRING);
    paramCodedOutputStream.writeUInt64(3, 0L);
    paramCodedOutputStream.writeTag(4, 2);
    paramCodedOutputStream.writeRawVarint32(getBinaryImageSize(paramByteString1, paramByteString2));
    paramCodedOutputStream.writeUInt64(1, 0L);
    paramCodedOutputStream.writeUInt64(2, 0L);
    paramCodedOutputStream.writeBytes(3, paramByteString1);
    if (paramByteString2 != null) {
      paramCodedOutputStream.writeBytes(4, paramByteString2);
    }
  }
  
  private static void writeSessionEventAppExecutionException(CodedOutputStream paramCodedOutputStream, TrimmedThrowableData paramTrimmedThrowableData, int paramInt1, int paramInt2, int paramInt3)
    throws Exception
  {
    paramCodedOutputStream.writeTag(paramInt3, 2);
    paramCodedOutputStream.writeRawVarint32(getEventAppExecutionExceptionSize(paramTrimmedThrowableData, 1, paramInt2));
    paramCodedOutputStream.writeBytes(1, ByteString.copyFromUtf8(paramTrimmedThrowableData.className));
    Object localObject = paramTrimmedThrowableData.localizedMessage;
    if (localObject != null) {
      paramCodedOutputStream.writeBytes(3, ByteString.copyFromUtf8((String)localObject));
    }
    localObject = paramTrimmedThrowableData.stacktrace;
    int j = localObject.length;
    int i = 0;
    paramInt3 = 0;
    while (paramInt3 < j)
    {
      writeFrame(paramCodedOutputStream, 4, localObject[paramInt3], true);
      paramInt3 += 1;
    }
    localObject = paramTrimmedThrowableData.cause;
    if (localObject != null)
    {
      paramInt3 = i;
      paramTrimmedThrowableData = (TrimmedThrowableData)localObject;
      if (paramInt1 < paramInt2)
      {
        writeSessionEventAppExecutionException(paramCodedOutputStream, (TrimmedThrowableData)localObject, paramInt1 + 1, paramInt2, 6);
        return;
      }
      while (paramTrimmedThrowableData != null)
      {
        paramTrimmedThrowableData = paramTrimmedThrowableData.cause;
        paramInt3 += 1;
      }
      paramCodedOutputStream.writeUInt32(7, paramInt3);
    }
  }
  
  private static void writeSessionEventDevice(CodedOutputStream paramCodedOutputStream, Float paramFloat, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong1, long paramLong2)
    throws Exception
  {
    paramCodedOutputStream.writeTag(5, 2);
    paramCodedOutputStream.writeRawVarint32(getEventDeviceSize(paramFloat, paramInt1, paramBoolean, paramInt2, paramLong1, paramLong2));
    if (paramFloat != null) {
      paramCodedOutputStream.writeFloat(1, paramFloat.floatValue());
    }
    paramCodedOutputStream.writeSInt32(2, paramInt1);
    paramCodedOutputStream.writeBool(3, paramBoolean);
    paramCodedOutputStream.writeUInt32(4, paramInt2);
    paramCodedOutputStream.writeUInt64(5, paramLong1);
    paramCodedOutputStream.writeUInt64(6, paramLong2);
  }
  
  private static void writeSessionEventLog(CodedOutputStream paramCodedOutputStream, ByteString paramByteString)
    throws Exception
  {
    if (paramByteString != null)
    {
      paramCodedOutputStream.writeTag(6, 2);
      paramCodedOutputStream.writeRawVarint32(getEventLogSize(paramByteString));
      paramCodedOutputStream.writeBytes(1, paramByteString);
    }
  }
  
  public static void writeSessionOS(CodedOutputStream paramCodedOutputStream, String paramString1, String paramString2, boolean paramBoolean)
    throws Exception
  {
    paramString1 = ByteString.copyFromUtf8(paramString1);
    paramString2 = ByteString.copyFromUtf8(paramString2);
    paramCodedOutputStream.writeTag(8, 2);
    paramCodedOutputStream.writeRawVarint32(getSessionOSSize(paramString1, paramString2, paramBoolean));
    paramCodedOutputStream.writeEnum(1, 3);
    paramCodedOutputStream.writeBytes(2, paramString1);
    paramCodedOutputStream.writeBytes(3, paramString2);
    paramCodedOutputStream.writeBool(4, paramBoolean);
  }
  
  public static void writeSessionUser(CodedOutputStream paramCodedOutputStream, String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "";
    }
    paramString1 = ByteString.copyFromUtf8((String)localObject);
    localObject = stringToByteString(paramString2);
    ByteString localByteString = stringToByteString(paramString3);
    int j = CodedOutputStream.computeBytesSize(1, paramString1) + 0;
    int i = j;
    if (paramString2 != null) {
      i = j + CodedOutputStream.computeBytesSize(2, (ByteString)localObject);
    }
    j = i;
    if (paramString3 != null) {
      j = i + CodedOutputStream.computeBytesSize(3, localByteString);
    }
    paramCodedOutputStream.writeTag(6, 2);
    paramCodedOutputStream.writeRawVarint32(j);
    paramCodedOutputStream.writeBytes(1, paramString1);
    if (paramString2 != null) {
      paramCodedOutputStream.writeBytes(2, (ByteString)localObject);
    }
    if (paramString3 != null) {
      paramCodedOutputStream.writeBytes(3, localByteString);
    }
  }
  
  private static void writeThread(CodedOutputStream paramCodedOutputStream, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt, boolean paramBoolean)
    throws Exception
  {
    paramCodedOutputStream.writeTag(1, 2);
    paramCodedOutputStream.writeRawVarint32(getThreadSize(paramThread, paramArrayOfStackTraceElement, paramInt, paramBoolean));
    paramCodedOutputStream.writeBytes(1, ByteString.copyFromUtf8(paramThread.getName()));
    paramCodedOutputStream.writeUInt32(2, paramInt);
    int i = paramArrayOfStackTraceElement.length;
    paramInt = 0;
    while (paramInt < i)
    {
      writeFrame(paramCodedOutputStream, 3, paramArrayOfStackTraceElement[paramInt], paramBoolean);
      paramInt += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\proto\SessionProtobufHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */