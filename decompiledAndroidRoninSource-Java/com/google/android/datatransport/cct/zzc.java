package com.google.android.datatransport.cct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.a.zza.zza;
import com.google.android.datatransport.cct.a.zzo;
import com.google.android.datatransport.cct.a.zzp;
import com.google.android.datatransport.cct.a.zzp.zza;
import com.google.android.datatransport.cct.a.zzp.zzb;
import com.google.android.datatransport.cct.a.zzq;
import com.google.android.datatransport.cct.a.zzq.zza;
import com.google.android.datatransport.cct.a.zzr;
import com.google.android.datatransport.cct.a.zzr.zza;
import com.google.android.datatransport.cct.a.zzt;
import com.google.android.datatransport.cct.a.zzt.zza;
import com.google.android.datatransport.cct.a.zzt.zzb;
import com.google.android.datatransport.cct.a.zzt.zzc;
import com.google.android.datatransport.cct.a.zzu;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.EventInternal.Builder;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;

final class zzc
  implements TransportBackend
{
  private final DataEncoder zza = new JsonDataEncoderBuilder().configureWith(com.google.android.datatransport.cct.a.zzb.zza).ignoreNullValues(true).build();
  private final ConnectivityManager zzb;
  final URL zzc;
  private final Clock zzd;
  private final Clock zze;
  private final int zzf;
  
  zzc(Context paramContext, Clock paramClock1, Clock paramClock2)
  {
    this.zzb = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    this.zzc = zza(CCTDestination.zza);
    this.zzd = paramClock2;
    this.zze = paramClock1;
    this.zzf = 40000;
  }
  
  /* Error */
  private zzb zza(zza paramzza)
    throws IOException
  {
    // Byte code:
    //   0: ldc 83
    //   2: ldc 105
    //   4: aload_1
    //   5: getfield 107	com/google/android/datatransport/cct/zzc$zza:zza	Ljava/net/URL;
    //   8: invokestatic 91	com/google/android/datatransport/runtime/logging/Logging:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   11: aload_1
    //   12: getfield 107	com/google/android/datatransport/cct/zzc$zza:zza	Ljava/net/URL;
    //   15: invokevirtual 113	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   18: checkcast 115	java/net/HttpURLConnection
    //   21: astore 4
    //   23: aload 4
    //   25: sipush 30000
    //   28: invokevirtual 119	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   31: aload 4
    //   33: aload_0
    //   34: getfield 77	com/google/android/datatransport/cct/zzc:zzf	I
    //   37: invokevirtual 122	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   40: aload 4
    //   42: iconst_1
    //   43: invokevirtual 126	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   46: aload 4
    //   48: iconst_0
    //   49: invokevirtual 129	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   52: aload 4
    //   54: ldc -125
    //   56: invokevirtual 135	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   59: aload 4
    //   61: ldc -119
    //   63: ldc -117
    //   65: iconst_1
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc -115
    //   73: aastore
    //   74: invokestatic 147	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   77: invokevirtual 151	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload 4
    //   82: ldc -103
    //   84: ldc -101
    //   86: invokevirtual 151	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 4
    //   91: ldc -99
    //   93: ldc -97
    //   95: invokevirtual 151	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload 4
    //   100: ldc -95
    //   102: ldc -101
    //   104: invokevirtual 151	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_1
    //   108: getfield 163	com/google/android/datatransport/cct/zzc$zza:zzc	Ljava/lang/String;
    //   111: astore_3
    //   112: aload_3
    //   113: ifnull +11 -> 124
    //   116: aload 4
    //   118: ldc -91
    //   120: aload_3
    //   121: invokevirtual 151	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload 4
    //   126: invokevirtual 169	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   129: astore_3
    //   130: new 171	java/util/zip/GZIPOutputStream
    //   133: dup
    //   134: aload_3
    //   135: invokespecial 174	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   138: astore 5
    //   140: aload_0
    //   141: getfield 48	com/google/android/datatransport/cct/zzc:zza	Lcom/google/firebase/encoders/DataEncoder;
    //   144: aload_1
    //   145: getfield 177	com/google/android/datatransport/cct/zzc$zza:zzb	Lcom/google/android/datatransport/cct/a/zzo;
    //   148: new 179	java/io/BufferedWriter
    //   151: dup
    //   152: new 181	java/io/OutputStreamWriter
    //   155: dup
    //   156: aload 5
    //   158: invokespecial 182	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   161: invokespecial 185	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   164: invokeinterface 191 3 0
    //   169: aload 5
    //   171: invokevirtual 196	java/util/zip/DeflaterOutputStream:close	()V
    //   174: aload_3
    //   175: ifnull +7 -> 182
    //   178: aload_3
    //   179: invokevirtual 199	java/io/OutputStream:close	()V
    //   182: aload 4
    //   184: invokevirtual 203	java/net/HttpURLConnection:getResponseCode	()I
    //   187: istore_2
    //   188: new 205	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   195: astore_1
    //   196: aload_1
    //   197: ldc -48
    //   199: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_1
    //   204: iload_2
    //   205: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: ldc 83
    //   211: aload_1
    //   212: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 222	com/google/android/datatransport/runtime/logging/Logging:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: new 205	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   225: astore_1
    //   226: aload_1
    //   227: ldc -32
    //   229: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_1
    //   234: aload 4
    //   236: ldc -99
    //   238: invokevirtual 228	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   241: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: ldc 83
    //   247: aload_1
    //   248: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 222	com/google/android/datatransport/runtime/logging/Logging:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: new 205	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   261: astore_1
    //   262: aload_1
    //   263: ldc -26
    //   265: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_1
    //   270: aload 4
    //   272: ldc -103
    //   274: invokevirtual 228	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   277: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: ldc 83
    //   283: aload_1
    //   284: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 222	com/google/android/datatransport/runtime/logging/Logging:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: iload_2
    //   291: sipush 302
    //   294: if_icmpeq +148 -> 442
    //   297: iload_2
    //   298: sipush 301
    //   301: if_icmpeq +141 -> 442
    //   304: iload_2
    //   305: sipush 307
    //   308: if_icmpne +6 -> 314
    //   311: goto +131 -> 442
    //   314: iload_2
    //   315: sipush 200
    //   318: if_icmpeq +14 -> 332
    //   321: new 11	com/google/android/datatransport/cct/zzc$zzb
    //   324: dup
    //   325: iload_2
    //   326: aconst_null
    //   327: lconst_0
    //   328: invokespecial 233	com/google/android/datatransport/cct/zzc$zzb:<init>	(ILjava/net/URL;J)V
    //   331: areturn
    //   332: aload 4
    //   334: invokevirtual 237	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   337: astore_3
    //   338: ldc -101
    //   340: aload 4
    //   342: ldc -103
    //   344: invokevirtual 228	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   347: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   350: ifeq +15 -> 365
    //   353: new 243	java/util/zip/GZIPInputStream
    //   356: dup
    //   357: aload_3
    //   358: invokespecial 246	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   361: astore_1
    //   362: goto +5 -> 367
    //   365: aload_3
    //   366: astore_1
    //   367: new 11	com/google/android/datatransport/cct/zzc$zzb
    //   370: dup
    //   371: iload_2
    //   372: aconst_null
    //   373: new 248	java/io/BufferedReader
    //   376: dup
    //   377: new 250	java/io/InputStreamReader
    //   380: dup
    //   381: aload_1
    //   382: invokespecial 251	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   385: invokespecial 254	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   388: invokestatic 259	com/google/android/datatransport/cct/a/zzs:zza	(Ljava/io/Reader;)Lcom/google/android/datatransport/cct/a/zzs;
    //   391: invokevirtual 262	com/google/android/datatransport/cct/a/zzs:zza	()J
    //   394: invokespecial 233	com/google/android/datatransport/cct/zzc$zzb:<init>	(ILjava/net/URL;J)V
    //   397: astore 4
    //   399: aload_1
    //   400: ifnull +7 -> 407
    //   403: aload_1
    //   404: invokevirtual 265	java/io/InputStream:close	()V
    //   407: aload_3
    //   408: ifnull +7 -> 415
    //   411: aload_3
    //   412: invokevirtual 265	java/io/InputStream:close	()V
    //   415: aload 4
    //   417: areturn
    //   418: astore 4
    //   420: aload_1
    //   421: ifnull +7 -> 428
    //   424: aload_1
    //   425: invokevirtual 265	java/io/InputStream:close	()V
    //   428: aload 4
    //   430: athrow
    //   431: astore_1
    //   432: aload_3
    //   433: ifnull +7 -> 440
    //   436: aload_3
    //   437: invokevirtual 265	java/io/InputStream:close	()V
    //   440: aload_1
    //   441: athrow
    //   442: new 11	com/google/android/datatransport/cct/zzc$zzb
    //   445: dup
    //   446: iload_2
    //   447: new 109	java/net/URL
    //   450: dup
    //   451: aload 4
    //   453: ldc_w 267
    //   456: invokevirtual 228	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   459: invokespecial 269	java/net/URL:<init>	(Ljava/lang/String;)V
    //   462: lconst_0
    //   463: invokespecial 233	com/google/android/datatransport/cct/zzc$zzb:<init>	(ILjava/net/URL;J)V
    //   466: areturn
    //   467: astore_1
    //   468: aload 5
    //   470: invokevirtual 196	java/util/zip/DeflaterOutputStream:close	()V
    //   473: aload_1
    //   474: athrow
    //   475: astore_1
    //   476: aload_3
    //   477: ifnull +7 -> 484
    //   480: aload_3
    //   481: invokevirtual 199	java/io/OutputStream:close	()V
    //   484: aload_1
    //   485: athrow
    //   486: astore_1
    //   487: goto +4 -> 491
    //   490: astore_1
    //   491: ldc 83
    //   493: ldc_w 271
    //   496: aload_1
    //   497: invokestatic 275	com/google/android/datatransport/runtime/logging/Logging:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   500: new 11	com/google/android/datatransport/cct/zzc$zzb
    //   503: dup
    //   504: sipush 400
    //   507: aconst_null
    //   508: lconst_0
    //   509: invokespecial 233	com/google/android/datatransport/cct/zzc$zzb:<init>	(ILjava/net/URL;J)V
    //   512: areturn
    //   513: astore_1
    //   514: goto +4 -> 518
    //   517: astore_1
    //   518: ldc 83
    //   520: ldc_w 277
    //   523: aload_1
    //   524: invokestatic 275	com/google/android/datatransport/runtime/logging/Logging:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   527: new 11	com/google/android/datatransport/cct/zzc$zzb
    //   530: dup
    //   531: sipush 500
    //   534: aconst_null
    //   535: lconst_0
    //   536: invokespecial 233	com/google/android/datatransport/cct/zzc$zzb:<init>	(ILjava/net/URL;J)V
    //   539: areturn
    //   540: astore_1
    //   541: goto -113 -> 428
    //   544: astore_3
    //   545: goto -105 -> 440
    //   548: astore 4
    //   550: goto -77 -> 473
    //   553: astore_3
    //   554: goto -70 -> 484
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	557	0	this	zzc
    //   0	557	1	paramzza	zza
    //   187	260	2	i	int
    //   111	370	3	localObject1	Object
    //   544	1	3	localObject2	Object
    //   553	1	3	localObject3	Object
    //   21	395	4	localObject4	Object
    //   418	34	4	localObject5	Object
    //   548	1	4	localObject6	Object
    //   138	331	5	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    // Exception table:
    //   from	to	target	type
    //   367	399	418	finally
    //   338	362	431	finally
    //   403	407	431	finally
    //   428	431	431	finally
    //   140	169	467	finally
    //   130	140	475	finally
    //   169	174	475	finally
    //   473	475	475	finally
    //   124	130	486	java/io/IOException
    //   178	182	486	java/io/IOException
    //   484	486	486	java/io/IOException
    //   124	130	490	com/google/firebase/encoders/EncodingException
    //   178	182	490	com/google/firebase/encoders/EncodingException
    //   484	486	490	com/google/firebase/encoders/EncodingException
    //   124	130	513	java/net/UnknownHostException
    //   178	182	513	java/net/UnknownHostException
    //   484	486	513	java/net/UnknownHostException
    //   124	130	517	java/net/ConnectException
    //   178	182	517	java/net/ConnectException
    //   484	486	517	java/net/ConnectException
    //   424	428	540	finally
    //   436	440	544	finally
    //   468	473	548	finally
    //   480	484	553	finally
  }
  
  private static URL zza(String paramString)
  {
    try
    {
      URL localURL = new URL(paramString);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid url: ");
      localStringBuilder.append(paramString);
      throw new IllegalArgumentException(localStringBuilder.toString(), localMalformedURLException);
    }
  }
  
  public EventInternal decorate(EventInternal paramEventInternal)
  {
    NetworkInfo localNetworkInfo = this.zzb.getActiveNetworkInfo();
    paramEventInternal = paramEventInternal.toBuilder().addMetadata("sdk-version", Build.VERSION.SDK_INT).addMetadata("model", Build.MODEL).addMetadata("hardware", Build.HARDWARE).addMetadata("device", Build.DEVICE).addMetadata("product", Build.PRODUCT).addMetadata("os-uild", Build.ID).addMetadata("manufacturer", Build.MANUFACTURER).addMetadata("fingerprint", Build.FINGERPRINT);
    Calendar.getInstance();
    paramEventInternal = paramEventInternal.addMetadata("tz-offset", TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000);
    int i;
    if (localNetworkInfo == null) {
      i = zzt.zzc.zzs.zza();
    } else {
      i = localNetworkInfo.getType();
    }
    paramEventInternal = paramEventInternal.addMetadata("net-type", i);
    if (localNetworkInfo == null)
    {
      i = zzt.zzb.zza.zza();
    }
    else
    {
      i = localNetworkInfo.getSubtype();
      if (i == -1) {
        i = zzt.zzb.zzu.zza();
      } else if (zzt.zzb.zza(i) == null) {
        i = 0;
      }
    }
    return paramEventInternal.addMetadata("mobile-subtype", i).build();
  }
  
  public BackendResponse send(BackendRequest paramBackendRequest)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = paramBackendRequest.getEvents().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (EventInternal)((Iterator)localObject2).next();
      localObject4 = ((EventInternal)localObject3).getTransportName();
      if (!((HashMap)localObject1).containsKey(localObject4))
      {
        localObject5 = new ArrayList();
        ((List)localObject5).add(localObject3);
        ((HashMap)localObject1).put(localObject4, localObject5);
      }
      else
      {
        ((List)((HashMap)localObject1).get(localObject4)).add(localObject3);
      }
    }
    localObject2 = new ArrayList();
    Object localObject3 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject3).next();
      localObject4 = (EventInternal)((List)((Map.Entry)localObject1).getValue()).get(0);
      localObject4 = zzr.zza().zza(zzu.zza).zza(this.zze.getTime()).zzb(this.zzd.getTime()).zza(zzp.zza().zza(zzp.zzb.zzb).zza(com.google.android.datatransport.cct.a.zza.zza().zza(Integer.valueOf(((EventInternal)localObject4).getInteger("sdk-version"))).zze(((EventInternal)localObject4).get("model")).zzc(((EventInternal)localObject4).get("hardware")).zza(((EventInternal)localObject4).get("device")).zzg(((EventInternal)localObject4).get("product")).zzf(((EventInternal)localObject4).get("os-uild")).zzd(((EventInternal)localObject4).get("manufacturer")).zzb(((EventInternal)localObject4).get("fingerprint")).zza()).zza());
      try
      {
        ((zzr.zza)localObject4).zza(Integer.parseInt((String)((Map.Entry)localObject1).getKey()));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Object localObject6;
        int i;
        for (;;) {}
      }
      ((zzr.zza)localObject4).zzb((String)((Map.Entry)localObject1).getKey());
      localObject5 = new ArrayList();
      localObject6 = ((List)((Map.Entry)localObject1).getValue()).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        EventInternal localEventInternal = (EventInternal)((Iterator)localObject6).next();
        localObject1 = localEventInternal.getEncodedPayload();
        Encoding localEncoding = ((EncodedPayload)localObject1).getEncoding();
        if (localEncoding.equals(Encoding.of("proto")))
        {
          localObject1 = zzq.zza(((EncodedPayload)localObject1).getBytes());
        }
        else
        {
          if (!localEncoding.equals(Encoding.of("json"))) {
            break label573;
          }
          localObject1 = zzq.zza(new String(((EncodedPayload)localObject1).getBytes(), Charset.forName("UTF-8")));
        }
        ((zzq.zza)localObject1).zza(localEventInternal.getEventMillis()).zzb(localEventInternal.getUptimeMillis()).zzc(localEventInternal.getLong("tz-offset")).zza(zzt.zza().zza(zzt.zzc.zza(localEventInternal.getInteger("net-type"))).zza(zzt.zzb.zza(localEventInternal.getInteger("mobile-subtype"))).zza());
        if (localEventInternal.getCode() != null) {
          ((zzq.zza)localObject1).zza(localEventInternal.getCode());
        }
        ((List)localObject5).add(((zzq.zza)localObject1).zza());
        continue;
        label573:
        Logging.w("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", localEncoding);
      }
      ((zzr.zza)localObject4).zza((List)localObject5);
      ((List)localObject2).add(((zzr.zza)localObject4).zza());
    }
    Object localObject5 = zzo.zza((List)localObject2);
    localObject1 = null;
    Object localObject4 = null;
    localObject3 = this.zzc;
    localObject2 = localObject3;
    if (paramBackendRequest.getExtras() != null) {}
    try
    {
      localObject6 = CCTDestination.fromByteArray(paramBackendRequest.getExtras());
      paramBackendRequest = (BackendRequest)localObject4;
      if (((CCTDestination)localObject6).getAPIKey() != null) {
        paramBackendRequest = ((CCTDestination)localObject6).getAPIKey();
      }
      localObject1 = paramBackendRequest;
      localObject2 = localObject3;
      if (((CCTDestination)localObject6).getEndPoint() == null) {
        break label698;
      }
      localObject2 = zza(((CCTDestination)localObject6).getEndPoint());
      localObject1 = paramBackendRequest;
    }
    catch (IllegalArgumentException paramBackendRequest)
    {
      for (;;) {}
    }
    return BackendResponse.fatalError();
    try
    {
      label698:
      paramBackendRequest = (zzb)Retries.retry(5, new zza((URL)localObject2, (zzo)localObject5, (String)localObject1), zza.zza(this), zzb.zza());
      if (paramBackendRequest.zza == 200) {
        return BackendResponse.ok(paramBackendRequest.zzc);
      }
      i = paramBackendRequest.zza;
      if ((i < 500) && (i != 404)) {
        return BackendResponse.fatalError();
      }
      paramBackendRequest = BackendResponse.transientError();
      return paramBackendRequest;
    }
    catch (IOException paramBackendRequest)
    {
      Logging.e("CctTransportBackend", "Could not make request to the backend", paramBackendRequest);
      return BackendResponse.transientError();
    }
  }
  
  static final class zza
  {
    final URL zza;
    final zzo zzb;
    final String zzc;
    
    zza(URL paramURL, zzo paramzzo, String paramString)
    {
      this.zza = paramURL;
      this.zzb = paramzzo;
      this.zzc = paramString;
    }
    
    zza zza(URL paramURL)
    {
      return new zza(paramURL, this.zzb, this.zzc);
    }
  }
  
  static final class zzb
  {
    final int zza;
    final URL zzb;
    final long zzc;
    
    zzb(int paramInt, URL paramURL, long paramLong)
    {
      this.zza = paramInt;
      this.zzb = paramURL;
      this.zzc = paramLong;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\cct\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */