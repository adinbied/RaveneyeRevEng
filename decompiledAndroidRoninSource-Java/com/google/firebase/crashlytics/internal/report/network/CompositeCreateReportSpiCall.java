package com.google.firebase.crashlytics.internal.report.network;

import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;

public class CompositeCreateReportSpiCall
  implements CreateReportSpiCall
{
  private final DefaultCreateReportSpiCall javaReportSpiCall;
  private final NativeCreateReportSpiCall nativeReportSpiCall;
  
  public CompositeCreateReportSpiCall(DefaultCreateReportSpiCall paramDefaultCreateReportSpiCall, NativeCreateReportSpiCall paramNativeCreateReportSpiCall)
  {
    this.javaReportSpiCall = paramDefaultCreateReportSpiCall;
    this.nativeReportSpiCall = paramNativeCreateReportSpiCall;
  }
  
  public boolean invoke(CreateReportRequest paramCreateReportRequest, boolean paramBoolean)
  {
    int i = 1.$SwitchMap$com$google$firebase$crashlytics$internal$report$model$Report$Type[paramCreateReportRequest.report.getType().ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      this.nativeReportSpiCall.invoke(paramCreateReportRequest, paramBoolean);
      return true;
    }
    this.javaReportSpiCall.invoke(paramCreateReportRequest, paramBoolean);
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\report\network\CompositeCreateReportSpiCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */