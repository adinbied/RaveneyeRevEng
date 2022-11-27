package org.java_websocket.util;

import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class Base64
{
  public static final int DECODE = 0;
  public static final int DONT_GUNZIP = 4;
  public static final int DO_BREAK_LINES = 8;
  public static final int ENCODE = 1;
  private static final byte EQUALS_SIGN = 61;
  private static final byte EQUALS_SIGN_ENC = -1;
  public static final int GZIP = 2;
  private static final int MAX_LINE_LENGTH = 76;
  private static final byte NEW_LINE = 10;
  public static final int NO_OPTIONS = 0;
  public static final int ORDERED = 32;
  private static final String PREFERRED_ENCODING = "US-ASCII";
  public static final int URL_SAFE = 16;
  private static final byte WHITE_SPACE_ENC = -5;
  private static final byte[] _ORDERED_ALPHABET = { 45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
  private static final byte[] _ORDERED_DECODABET = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
  private static final byte[] _STANDARD_ALPHABET = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] _STANDARD_DECODABET = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
  private static final byte[] _URL_SAFE_ALPHABET = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  private static final byte[] _URL_SAFE_DECODABET = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
  
  public static byte[] decode(String paramString)
    throws IOException
  {
    return decode(paramString, 0);
  }
  
  /* Error */
  public static byte[] decode(String paramString, int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +296 -> 297
    //   4: aload_0
    //   5: ldc 41
    //   7: invokevirtual 214	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   10: astore_2
    //   11: aload_2
    //   12: astore_0
    //   13: goto +8 -> 21
    //   16: aload_0
    //   17: invokevirtual 217	java/lang/String:getBytes	()[B
    //   20: astore_0
    //   21: aload_0
    //   22: iconst_0
    //   23: aload_0
    //   24: arraylength
    //   25: iload_1
    //   26: invokestatic 220	org/java_websocket/util/Base64:decode	([BIII)[B
    //   29: astore 7
    //   31: iload_1
    //   32: iconst_4
    //   33: iand
    //   34: ifeq +8 -> 42
    //   37: iconst_1
    //   38: istore_1
    //   39: goto +5 -> 44
    //   42: iconst_0
    //   43: istore_1
    //   44: aload 7
    //   46: ifnull +248 -> 294
    //   49: aload 7
    //   51: arraylength
    //   52: iconst_4
    //   53: if_icmplt +241 -> 294
    //   56: iload_1
    //   57: ifne +237 -> 294
    //   60: ldc -35
    //   62: aload 7
    //   64: iconst_0
    //   65: baload
    //   66: sipush 255
    //   69: iand
    //   70: aload 7
    //   72: iconst_1
    //   73: baload
    //   74: bipush 8
    //   76: ishl
    //   77: ldc -34
    //   79: iand
    //   80: ior
    //   81: if_icmpne +213 -> 294
    //   84: sipush 2048
    //   87: newarray <illegal type>
    //   89: astore_3
    //   90: aconst_null
    //   91: astore_0
    //   92: aconst_null
    //   93: astore 5
    //   95: new 224	java/io/ByteArrayOutputStream
    //   98: dup
    //   99: invokespecial 225	java/io/ByteArrayOutputStream:<init>	()V
    //   102: astore 4
    //   104: new 227	java/io/ByteArrayInputStream
    //   107: dup
    //   108: aload 7
    //   110: invokespecial 230	java/io/ByteArrayInputStream:<init>	([B)V
    //   113: astore_0
    //   114: new 232	java/util/zip/GZIPInputStream
    //   117: dup
    //   118: aload_0
    //   119: invokespecial 235	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   122: astore_2
    //   123: aload_2
    //   124: aload_3
    //   125: invokevirtual 239	java/util/zip/GZIPInputStream:read	([B)I
    //   128: istore_1
    //   129: iload_1
    //   130: iflt +14 -> 144
    //   133: aload 4
    //   135: aload_3
    //   136: iconst_0
    //   137: iload_1
    //   138: invokevirtual 243	java/io/ByteArrayOutputStream:write	([BII)V
    //   141: goto -18 -> 123
    //   144: aload 4
    //   146: invokevirtual 246	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   149: astore 8
    //   151: aload_0
    //   152: astore 6
    //   154: aload_2
    //   155: astore 5
    //   157: aload 8
    //   159: astore_3
    //   160: aload 4
    //   162: invokevirtual 249	java/io/ByteArrayOutputStream:close	()V
    //   165: aload 8
    //   167: astore_3
    //   168: aload_2
    //   169: invokevirtual 250	java/util/zip/GZIPInputStream:close	()V
    //   172: aload_0
    //   173: invokevirtual 251	java/io/ByteArrayInputStream:close	()V
    //   176: aload_3
    //   177: areturn
    //   178: astore 5
    //   180: aload_0
    //   181: astore_3
    //   182: aload 5
    //   184: astore_0
    //   185: goto +30 -> 215
    //   188: astore_3
    //   189: goto +37 -> 226
    //   192: astore 5
    //   194: aconst_null
    //   195: astore_2
    //   196: aload_0
    //   197: astore_3
    //   198: aload 5
    //   200: astore_0
    //   201: goto +14 -> 215
    //   204: astore_3
    //   205: aconst_null
    //   206: astore_2
    //   207: goto +19 -> 226
    //   210: astore_0
    //   211: aconst_null
    //   212: astore_3
    //   213: aload_3
    //   214: astore_2
    //   215: aload_0
    //   216: astore 5
    //   218: goto +60 -> 278
    //   221: astore_3
    //   222: aconst_null
    //   223: astore_0
    //   224: aload_0
    //   225: astore_2
    //   226: goto +24 -> 250
    //   229: astore 5
    //   231: aconst_null
    //   232: astore_3
    //   233: aload_3
    //   234: astore_2
    //   235: aload_0
    //   236: astore 4
    //   238: goto +40 -> 278
    //   241: astore_3
    //   242: aconst_null
    //   243: astore_0
    //   244: aload_0
    //   245: astore_2
    //   246: aload 5
    //   248: astore 4
    //   250: aload_3
    //   251: invokevirtual 254	java/io/IOException:printStackTrace	()V
    //   254: aload_0
    //   255: astore 6
    //   257: aload_2
    //   258: astore 5
    //   260: aload 7
    //   262: astore_3
    //   263: aload 4
    //   265: invokevirtual 249	java/io/ByteArrayOutputStream:close	()V
    //   268: aload 7
    //   270: astore_3
    //   271: goto -103 -> 168
    //   274: astore 5
    //   276: aload_0
    //   277: astore_3
    //   278: aload 4
    //   280: invokevirtual 249	java/io/ByteArrayOutputStream:close	()V
    //   283: aload_2
    //   284: invokevirtual 250	java/util/zip/GZIPInputStream:close	()V
    //   287: aload_3
    //   288: invokevirtual 251	java/io/ByteArrayInputStream:close	()V
    //   291: aload 5
    //   293: athrow
    //   294: aload 7
    //   296: areturn
    //   297: new 256	java/lang/NullPointerException
    //   300: dup
    //   301: ldc_w 258
    //   304: invokespecial 261	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   307: athrow
    //   308: astore_2
    //   309: goto -293 -> 16
    //   312: astore_0
    //   313: aload 6
    //   315: astore_0
    //   316: aload 5
    //   318: astore_2
    //   319: goto -151 -> 168
    //   322: astore_2
    //   323: goto -151 -> 172
    //   326: astore_0
    //   327: aload_3
    //   328: areturn
    //   329: astore_0
    //   330: goto -47 -> 283
    //   333: astore_0
    //   334: goto -47 -> 287
    //   337: astore_0
    //   338: goto -47 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramString	String
    //   0	341	1	paramInt	int
    //   10	274	2	localObject1	Object
    //   308	1	2	localUnsupportedEncodingException	UnsupportedEncodingException
    //   318	1	2	localObject2	Object
    //   322	1	2	localException	Exception
    //   89	93	3	localObject3	Object
    //   188	1	3	localIOException1	IOException
    //   197	1	3	str1	String
    //   204	1	3	localIOException2	IOException
    //   212	2	3	localObject4	Object
    //   221	1	3	localIOException3	IOException
    //   232	2	3	localObject5	Object
    //   241	10	3	localIOException4	IOException
    //   262	66	3	localObject6	Object
    //   102	177	4	localObject7	Object
    //   93	63	5	localObject8	Object
    //   178	5	5	localObject9	Object
    //   192	7	5	localObject10	Object
    //   216	1	5	str2	String
    //   229	18	5	localObject11	Object
    //   258	1	5	localObject12	Object
    //   274	43	5	localObject13	Object
    //   152	162	6	str3	String
    //   29	266	7	arrayOfByte1	byte[]
    //   149	17	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   123	129	178	finally
    //   133	141	178	finally
    //   144	151	178	finally
    //   123	129	188	java/io/IOException
    //   133	141	188	java/io/IOException
    //   144	151	188	java/io/IOException
    //   114	123	192	finally
    //   114	123	204	java/io/IOException
    //   104	114	210	finally
    //   104	114	221	java/io/IOException
    //   95	104	229	finally
    //   95	104	241	java/io/IOException
    //   250	254	274	finally
    //   4	11	308	java/io/UnsupportedEncodingException
    //   160	165	312	java/lang/Exception
    //   263	268	312	java/lang/Exception
    //   168	172	322	java/lang/Exception
    //   172	176	326	java/lang/Exception
    //   278	283	329	java/lang/Exception
    //   283	287	333	java/lang/Exception
    //   287	291	337	java/lang/Exception
  }
  
  public static byte[] decode(byte[] paramArrayOfByte)
    throws IOException
  {
    return decode(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      if (paramInt1 >= 0)
      {
        int m = paramInt1 + paramInt2;
        if (m <= paramArrayOfByte.length)
        {
          if (paramInt2 == 0) {
            return new byte[0];
          }
          if (paramInt2 >= 4)
          {
            byte[] arrayOfByte2 = getDecodabet(paramInt3);
            byte[] arrayOfByte1 = new byte[paramInt2 * 3 / 4];
            byte[] arrayOfByte3 = new byte[4];
            int j = 0;
            paramInt2 = 0;
            int i = paramInt1;
            int k;
            for (paramInt1 = paramInt2;; paramInt1 = k)
            {
              k = paramInt1;
              if (i >= m) {
                break label213;
              }
              int n = arrayOfByte2[(paramArrayOfByte[i] & 0xFF)];
              if (n < -5) {
                break;
              }
              paramInt2 = j;
              k = paramInt1;
              if (n >= -1)
              {
                paramInt2 = j + 1;
                arrayOfByte3[j] = paramArrayOfByte[i];
                if (paramInt2 > 3)
                {
                  k = paramInt1 + decode4to3(arrayOfByte3, 0, arrayOfByte1, paramInt1, paramInt3);
                  if (paramArrayOfByte[i] == 61) {
                    break label213;
                  }
                  paramInt2 = 0;
                }
                else
                {
                  k = paramInt1;
                }
              }
              i += 1;
              j = paramInt2;
            }
            throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", new Object[] { Integer.valueOf(paramArrayOfByte[i] & 0xFF), Integer.valueOf(i) }));
            label213:
            paramArrayOfByte = new byte[k];
            System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, 0, k);
            return paramArrayOfByte;
          }
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("Base64-encoded string must have at least four characters, but length specified was ");
          paramArrayOfByte.append(paramInt2);
          throw new IllegalArgumentException(paramArrayOfByte.toString());
        }
      }
      throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    throw new NullPointerException("Cannot decode null source array.");
  }
  
  private static int decode4to3(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 != null)
      {
        if (paramInt1 >= 0)
        {
          int j = paramInt1 + 3;
          if (j < paramArrayOfByte1.length)
          {
            if (paramInt2 >= 0)
            {
              int i = paramInt2 + 2;
              if (i < paramArrayOfByte2.length)
              {
                byte[] arrayOfByte = getDecodabet(paramInt3);
                paramInt3 = paramInt1 + 2;
                if (paramArrayOfByte1[paramInt3] == 61)
                {
                  paramInt3 = arrayOfByte[paramArrayOfByte1[paramInt1]];
                  paramArrayOfByte2[paramInt2] = ((byte)(((arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12 | (paramInt3 & 0xFF) << 18) >>> 16));
                  return 1;
                }
                if (paramArrayOfByte1[j] == 61)
                {
                  i = arrayOfByte[paramArrayOfByte1[paramInt1]];
                  paramInt1 = arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]];
                  paramInt1 = (arrayOfByte[paramArrayOfByte1[paramInt3]] & 0xFF) << 6 | (paramInt1 & 0xFF) << 12 | (i & 0xFF) << 18;
                  paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >>> 16));
                  paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 8));
                  return 2;
                }
                int k = arrayOfByte[paramArrayOfByte1[paramInt1]];
                paramInt1 = arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]];
                paramInt3 = arrayOfByte[paramArrayOfByte1[paramInt3]];
                paramInt1 = arrayOfByte[paramArrayOfByte1[j]] & 0xFF | (paramInt1 & 0xFF) << 12 | (k & 0xFF) << 18 | (paramInt3 & 0xFF) << 6;
                paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >> 16));
                paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8));
                paramArrayOfByte2[i] = ((byte)paramInt1);
                return 3;
              }
            }
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[] { Integer.valueOf(paramArrayOfByte2.length), Integer.valueOf(paramInt2) }));
          }
        }
        throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[] { Integer.valueOf(paramArrayOfByte1.length), Integer.valueOf(paramInt1) }));
      }
      throw new NullPointerException("Destination array was null.");
    }
    throw new NullPointerException("Source array was null.");
  }
  
  /* Error */
  public static void decodeFileToFile(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 317	org/java_websocket/util/Base64:decodeFromFile	(Ljava/lang/String;)[B
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore_0
    //   9: new 319	java/io/BufferedOutputStream
    //   12: dup
    //   13: new 321	java/io/FileOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 322	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   21: invokespecial 325	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_1
    //   25: aload_1
    //   26: aload_3
    //   27: invokevirtual 329	java/io/OutputStream:write	([B)V
    //   30: aload_1
    //   31: invokevirtual 330	java/io/OutputStream:close	()V
    //   34: return
    //   35: astore_2
    //   36: aload_1
    //   37: astore_0
    //   38: aload_2
    //   39: astore_1
    //   40: goto +20 -> 60
    //   43: astore_2
    //   44: aload_1
    //   45: astore_0
    //   46: aload_2
    //   47: astore_1
    //   48: goto +10 -> 58
    //   51: astore_1
    //   52: goto +8 -> 60
    //   55: astore_1
    //   56: aload_2
    //   57: astore_0
    //   58: aload_1
    //   59: athrow
    //   60: aload_0
    //   61: invokevirtual 330	java/io/OutputStream:close	()V
    //   64: aload_1
    //   65: athrow
    //   66: astore_0
    //   67: return
    //   68: astore_0
    //   69: goto -5 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramString1	String
    //   0	72	1	paramString2	String
    //   6	1	2	localObject1	Object
    //   35	4	2	localObject2	Object
    //   43	14	2	localIOException	IOException
    //   4	23	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   25	30	35	finally
    //   25	30	43	java/io/IOException
    //   9	25	51	finally
    //   58	60	51	finally
    //   9	25	55	java/io/IOException
    //   30	34	66	java/lang/Exception
    //   60	64	68	java/lang/Exception
  }
  
  /* Error */
  public static byte[] decodeFromFile(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore_3
    //   9: new 332	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 333	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload 5
    //   20: astore_3
    //   21: aload_0
    //   22: invokevirtual 337	java/io/File:length	()J
    //   25: ldc2_w 338
    //   28: lcmp
    //   29: ifgt +105 -> 134
    //   32: aload 5
    //   34: astore_3
    //   35: aload_0
    //   36: invokevirtual 337	java/io/File:length	()J
    //   39: l2i
    //   40: newarray <illegal type>
    //   42: astore 6
    //   44: aload 5
    //   46: astore_3
    //   47: new 8	org/java_websocket/util/Base64$InputStream
    //   50: dup
    //   51: new 341	java/io/BufferedInputStream
    //   54: dup
    //   55: new 343	java/io/FileInputStream
    //   58: dup
    //   59: aload_0
    //   60: invokespecial 346	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 347	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: iconst_0
    //   67: invokespecial 350	org/java_websocket/util/Base64$InputStream:<init>	(Ljava/io/InputStream;I)V
    //   70: astore_0
    //   71: iconst_0
    //   72: istore_1
    //   73: aload_0
    //   74: aload 6
    //   76: iload_1
    //   77: sipush 4096
    //   80: invokevirtual 353	org/java_websocket/util/Base64$InputStream:read	([BII)I
    //   83: istore_2
    //   84: iload_2
    //   85: iflt +10 -> 95
    //   88: iload_1
    //   89: iload_2
    //   90: iadd
    //   91: istore_1
    //   92: goto -19 -> 73
    //   95: iload_1
    //   96: newarray <illegal type>
    //   98: astore_3
    //   99: aload 6
    //   101: iconst_0
    //   102: aload_3
    //   103: iconst_0
    //   104: iload_1
    //   105: invokestatic 281	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   108: aload_0
    //   109: invokevirtual 354	org/java_websocket/util/Base64$InputStream:close	()V
    //   112: aload_3
    //   113: areturn
    //   114: astore 4
    //   116: aload_0
    //   117: astore_3
    //   118: aload 4
    //   120: astore_0
    //   121: goto +88 -> 209
    //   124: astore 4
    //   126: aload_0
    //   127: astore_3
    //   128: aload 4
    //   130: astore_0
    //   131: goto +76 -> 207
    //   134: aload 5
    //   136: astore_3
    //   137: new 283	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   144: astore 6
    //   146: aload 5
    //   148: astore_3
    //   149: aload 6
    //   151: ldc_w 356
    //   154: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 5
    //   160: astore_3
    //   161: aload 6
    //   163: aload_0
    //   164: invokevirtual 337	java/io/File:length	()J
    //   167: invokevirtual 359	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 5
    //   173: astore_3
    //   174: aload 6
    //   176: ldc_w 361
    //   179: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 5
    //   185: astore_3
    //   186: new 201	java/io/IOException
    //   189: dup
    //   190: aload 6
    //   192: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokespecial 275	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   198: athrow
    //   199: astore_0
    //   200: goto +9 -> 209
    //   203: astore_0
    //   204: aload 4
    //   206: astore_3
    //   207: aload_0
    //   208: athrow
    //   209: aload_3
    //   210: invokevirtual 354	org/java_websocket/util/Base64$InputStream:close	()V
    //   213: aload_0
    //   214: athrow
    //   215: astore_0
    //   216: aload_3
    //   217: areturn
    //   218: astore_3
    //   219: goto -6 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramString	String
    //   72	33	1	i	int
    //   83	8	2	j	int
    //   8	209	3	localObject1	Object
    //   218	1	3	localException	Exception
    //   1	1	4	localObject2	Object
    //   114	5	4	localObject3	Object
    //   124	81	4	localIOException	IOException
    //   4	180	5	localObject4	Object
    //   42	149	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   73	84	114	finally
    //   95	108	114	finally
    //   73	84	124	java/io/IOException
    //   95	108	124	java/io/IOException
    //   9	18	199	finally
    //   21	32	199	finally
    //   35	44	199	finally
    //   47	71	199	finally
    //   137	146	199	finally
    //   149	158	199	finally
    //   161	171	199	finally
    //   174	183	199	finally
    //   186	199	199	finally
    //   207	209	199	finally
    //   9	18	203	java/io/IOException
    //   21	32	203	java/io/IOException
    //   35	44	203	java/io/IOException
    //   47	71	203	java/io/IOException
    //   137	146	203	java/io/IOException
    //   149	158	203	java/io/IOException
    //   161	171	203	java/io/IOException
    //   174	183	203	java/io/IOException
    //   186	199	203	java/io/IOException
    //   108	112	215	java/lang/Exception
    //   209	213	218	java/lang/Exception
  }
  
  /* Error */
  public static void decodeToFile(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 11	org/java_websocket/util/Base64$OutputStream
    //   7: dup
    //   8: new 321	java/io/FileOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 322	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   16: iconst_0
    //   17: invokespecial 365	org/java_websocket/util/Base64$OutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   20: astore_1
    //   21: aload_1
    //   22: aload_0
    //   23: ldc 41
    //   25: invokevirtual 214	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   28: invokevirtual 366	org/java_websocket/util/Base64$OutputStream:write	([B)V
    //   31: aload_1
    //   32: invokevirtual 367	org/java_websocket/util/Base64$OutputStream:close	()V
    //   35: return
    //   36: astore_0
    //   37: aload_1
    //   38: astore_2
    //   39: goto +18 -> 57
    //   42: astore_0
    //   43: aload_1
    //   44: astore_2
    //   45: goto +10 -> 55
    //   48: astore_0
    //   49: goto +8 -> 57
    //   52: astore_0
    //   53: aload_3
    //   54: astore_2
    //   55: aload_0
    //   56: athrow
    //   57: aload_2
    //   58: invokevirtual 367	org/java_websocket/util/Base64$OutputStream:close	()V
    //   61: aload_0
    //   62: athrow
    //   63: astore_0
    //   64: return
    //   65: astore_1
    //   66: goto -5 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	paramString1	String
    //   0	69	1	paramString2	String
    //   3	55	2	localObject1	Object
    //   1	53	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	31	36	finally
    //   21	31	42	java/io/IOException
    //   4	21	48	finally
    //   55	57	48	finally
    //   4	21	52	java/io/IOException
    //   31	35	63	java/lang/Exception
    //   57	61	65	java/lang/Exception
  }
  
  public static Object decodeToObject(String paramString)
    throws IOException, ClassNotFoundException
  {
    return decodeToObject(paramString, 0, null);
  }
  
  /* Error */
  public static Object decodeToObject(String paramString, int paramInt, final ClassLoader paramClassLoader)
    throws IOException, ClassNotFoundException
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokestatic 204	org/java_websocket/util/Base64:decode	(Ljava/lang/String;I)[B
    //   5: astore_3
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore_0
    //   14: aconst_null
    //   15: astore 4
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore 8
    //   23: new 227	java/io/ByteArrayInputStream
    //   26: dup
    //   27: aload_3
    //   28: invokespecial 230	java/io/ByteArrayInputStream:<init>	([B)V
    //   31: astore_3
    //   32: aload_2
    //   33: ifnonnull +23 -> 56
    //   36: aload 8
    //   38: astore 4
    //   40: aload 7
    //   42: astore 5
    //   44: new 376	java/io/ObjectInputStream
    //   47: dup
    //   48: aload_3
    //   49: invokespecial 377	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore_0
    //   53: goto +21 -> 74
    //   56: aload 8
    //   58: astore 4
    //   60: aload 7
    //   62: astore 5
    //   64: new 6	org/java_websocket/util/Base64$1
    //   67: dup
    //   68: aload_3
    //   69: aload_2
    //   70: invokespecial 380	org/java_websocket/util/Base64$1:<init>	(Ljava/io/InputStream;Ljava/lang/ClassLoader;)V
    //   73: astore_0
    //   74: aload_0
    //   75: astore 4
    //   77: aload_0
    //   78: astore 5
    //   80: aload_0
    //   81: astore 6
    //   83: aload_0
    //   84: invokevirtual 384	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   87: astore_2
    //   88: aload_3
    //   89: invokevirtual 251	java/io/ByteArrayInputStream:close	()V
    //   92: aload_0
    //   93: invokevirtual 385	java/io/ObjectInputStream:close	()V
    //   96: aload_2
    //   97: areturn
    //   98: astore_0
    //   99: aload_3
    //   100: astore_2
    //   101: aload 4
    //   103: astore_3
    //   104: goto +54 -> 158
    //   107: astore 4
    //   109: aload 5
    //   111: astore_2
    //   112: aload_3
    //   113: astore_0
    //   114: aload 4
    //   116: astore_3
    //   117: goto +28 -> 145
    //   120: astore 4
    //   122: aload 6
    //   124: astore_2
    //   125: aload_3
    //   126: astore_0
    //   127: aload 4
    //   129: astore_3
    //   130: goto +17 -> 147
    //   133: astore_0
    //   134: aconst_null
    //   135: astore_3
    //   136: aload 5
    //   138: astore_2
    //   139: goto +19 -> 158
    //   142: astore_3
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_3
    //   146: athrow
    //   147: aload_3
    //   148: athrow
    //   149: astore 4
    //   151: aload_2
    //   152: astore_3
    //   153: aload_0
    //   154: astore_2
    //   155: aload 4
    //   157: astore_0
    //   158: aload_2
    //   159: invokevirtual 251	java/io/ByteArrayInputStream:close	()V
    //   162: aload_3
    //   163: invokevirtual 385	java/io/ObjectInputStream:close	()V
    //   166: aload_0
    //   167: athrow
    //   168: astore_3
    //   169: goto -77 -> 92
    //   172: astore_0
    //   173: aload_2
    //   174: areturn
    //   175: astore_2
    //   176: goto -14 -> 162
    //   179: astore_2
    //   180: goto -14 -> 166
    //   183: astore_3
    //   184: aconst_null
    //   185: astore_2
    //   186: aload 4
    //   188: astore_0
    //   189: goto -42 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramString	String
    //   0	192	1	paramInt	int
    //   0	192	2	paramClassLoader	ClassLoader
    //   5	131	3	localObject1	Object
    //   142	6	3	localClassNotFoundException1	ClassNotFoundException
    //   152	11	3	localClassLoader	ClassLoader
    //   168	1	3	localException	Exception
    //   183	1	3	localIOException1	IOException
    //   15	87	4	localObject2	Object
    //   107	8	4	localClassNotFoundException2	ClassNotFoundException
    //   120	8	4	localIOException2	IOException
    //   149	38	4	localObject3	Object
    //   18	119	5	localObject4	Object
    //   10	113	6	str	String
    //   7	54	7	localObject5	Object
    //   21	36	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   44	53	98	finally
    //   64	74	98	finally
    //   83	88	98	finally
    //   44	53	107	java/lang/ClassNotFoundException
    //   64	74	107	java/lang/ClassNotFoundException
    //   83	88	107	java/lang/ClassNotFoundException
    //   44	53	120	java/io/IOException
    //   64	74	120	java/io/IOException
    //   83	88	120	java/io/IOException
    //   23	32	133	finally
    //   23	32	142	java/lang/ClassNotFoundException
    //   145	147	149	finally
    //   147	149	149	finally
    //   88	92	168	java/lang/Exception
    //   92	96	172	java/lang/Exception
    //   158	162	175	java/lang/Exception
    //   162	166	179	java/lang/Exception
    //   23	32	183	java/io/IOException
  }
  
  public static void encode(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    byte[] arrayOfByte1 = new byte[3];
    byte[] arrayOfByte2 = new byte[4];
    while (paramByteBuffer1.hasRemaining())
    {
      int i = Math.min(3, paramByteBuffer1.remaining());
      paramByteBuffer1.get(arrayOfByte1, 0, i);
      encode3to4(arrayOfByte2, arrayOfByte1, i, 0);
      paramByteBuffer2.put(arrayOfByte2);
    }
  }
  
  public static void encode(ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer)
  {
    byte[] arrayOfByte1 = new byte[3];
    byte[] arrayOfByte2 = new byte[4];
    while (paramByteBuffer.hasRemaining())
    {
      int j = Math.min(3, paramByteBuffer.remaining());
      int i = 0;
      paramByteBuffer.get(arrayOfByte1, 0, j);
      encode3to4(arrayOfByte2, arrayOfByte1, j, 0);
      while (i < 4)
      {
        paramCharBuffer.put((char)(arrayOfByte2[i] & 0xFF));
        i += 1;
      }
    }
  }
  
  private static byte[] encode3to4(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = getAlphabet(paramInt4);
    int j = 0;
    if (paramInt2 > 0) {
      paramInt4 = paramArrayOfByte1[paramInt1] << 24 >>> 8;
    } else {
      paramInt4 = 0;
    }
    int i;
    if (paramInt2 > 1) {
      i = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;
    } else {
      i = 0;
    }
    if (paramInt2 > 2) {
      j = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
    }
    paramInt1 = paramInt4 | i | j;
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2)
      {
        if (paramInt2 != 3) {
          return paramArrayOfByte2;
        }
        paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
        paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
        paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
        paramArrayOfByte2[(paramInt3 + 3)] = arrayOfByte[(paramInt1 & 0x3F)];
        return paramArrayOfByte2;
      }
      paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
      paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
      paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
      paramArrayOfByte2[(paramInt3 + 3)] = 61;
      return paramArrayOfByte2;
    }
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }
  
  private static byte[] encode3to4(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    encode3to4(paramArrayOfByte2, 0, paramInt1, paramArrayOfByte1, 0, paramInt2);
    return paramArrayOfByte1;
  }
  
  public static String encodeBytes(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = encodeBytes(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static String encodeBytes(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    return encodeBytes(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static String encodeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = encodeBytes(paramArrayOfByte, paramInt1, paramInt2, 0);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static String encodeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    paramArrayOfByte = encodeBytesToBytes(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    try
    {
      String str = new String(paramArrayOfByte, "US-ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
    return new String(paramArrayOfByte);
  }
  
  public static byte[] encodeBytesToBytes(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = encodeBytesToBytes(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;) {}
    }
    return null;
  }
  
  /* Error */
  public static byte[] encodeBytesToBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +554 -> 555
    //   4: iload_1
    //   5: iflt +516 -> 521
    //   8: iload_2
    //   9: iflt +478 -> 487
    //   12: iload_1
    //   13: iload_2
    //   14: iadd
    //   15: aload_0
    //   16: arraylength
    //   17: if_icmpgt +430 -> 447
    //   20: iload_3
    //   21: iconst_2
    //   22: iand
    //   23: ifeq +205 -> 228
    //   26: aconst_null
    //   27: astore 13
    //   29: aconst_null
    //   30: astore 9
    //   32: new 224	java/io/ByteArrayOutputStream
    //   35: dup
    //   36: invokespecial 225	java/io/ByteArrayOutputStream:<init>	()V
    //   39: astore 10
    //   41: new 11	org/java_websocket/util/Base64$OutputStream
    //   44: dup
    //   45: aload 10
    //   47: iload_3
    //   48: iconst_1
    //   49: ior
    //   50: invokespecial 365	org/java_websocket/util/Base64$OutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   53: astore 11
    //   55: new 436	java/util/zip/GZIPOutputStream
    //   58: dup
    //   59: aload 11
    //   61: invokespecial 437	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   64: astore 12
    //   66: aload 12
    //   68: aload_0
    //   69: iload_1
    //   70: iload_2
    //   71: invokevirtual 438	java/util/zip/GZIPOutputStream:write	([BII)V
    //   74: aload 12
    //   76: invokevirtual 439	java/util/zip/GZIPOutputStream:close	()V
    //   79: aload 12
    //   81: invokevirtual 439	java/util/zip/GZIPOutputStream:close	()V
    //   84: aload 11
    //   86: invokevirtual 367	org/java_websocket/util/Base64$OutputStream:close	()V
    //   89: aload 10
    //   91: invokevirtual 249	java/io/ByteArrayOutputStream:close	()V
    //   94: aload 10
    //   96: invokevirtual 246	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   99: areturn
    //   100: astore_0
    //   101: aload 11
    //   103: astore 9
    //   105: goto +106 -> 211
    //   108: astore 9
    //   110: aload 12
    //   112: astore_0
    //   113: goto +41 -> 154
    //   116: astore_0
    //   117: aload 13
    //   119: astore 12
    //   121: aload 11
    //   123: astore 9
    //   125: goto +86 -> 211
    //   128: astore 9
    //   130: aconst_null
    //   131: astore_0
    //   132: goto +22 -> 154
    //   135: astore_0
    //   136: aconst_null
    //   137: astore 9
    //   139: aload 13
    //   141: astore 12
    //   143: goto +68 -> 211
    //   146: astore 9
    //   148: aconst_null
    //   149: astore 11
    //   151: aload 11
    //   153: astore_0
    //   154: aload 10
    //   156: astore 12
    //   158: aload 9
    //   160: astore 10
    //   162: aload 12
    //   164: astore 9
    //   166: goto +26 -> 192
    //   169: astore_0
    //   170: aconst_null
    //   171: astore 10
    //   173: aload 10
    //   175: astore 9
    //   177: aload 13
    //   179: astore 12
    //   181: goto +30 -> 211
    //   184: astore 10
    //   186: aconst_null
    //   187: astore 11
    //   189: aload 11
    //   191: astore_0
    //   192: aload 10
    //   194: athrow
    //   195: astore 13
    //   197: aload 9
    //   199: astore 10
    //   201: aload_0
    //   202: astore 12
    //   204: aload 11
    //   206: astore 9
    //   208: aload 13
    //   210: astore_0
    //   211: aload 12
    //   213: invokevirtual 439	java/util/zip/GZIPOutputStream:close	()V
    //   216: aload 9
    //   218: invokevirtual 367	org/java_websocket/util/Base64$OutputStream:close	()V
    //   221: aload 10
    //   223: invokevirtual 249	java/io/ByteArrayOutputStream:close	()V
    //   226: aload_0
    //   227: athrow
    //   228: iload_3
    //   229: bipush 8
    //   231: iand
    //   232: ifeq +9 -> 241
    //   235: iconst_1
    //   236: istore 6
    //   238: goto +6 -> 244
    //   241: iconst_0
    //   242: istore 6
    //   244: iload_2
    //   245: iconst_3
    //   246: idiv
    //   247: istore 5
    //   249: iload_2
    //   250: iconst_3
    //   251: irem
    //   252: ifle +9 -> 261
    //   255: iconst_4
    //   256: istore 4
    //   258: goto +6 -> 264
    //   261: iconst_0
    //   262: istore 4
    //   264: iload 5
    //   266: iconst_4
    //   267: imul
    //   268: iload 4
    //   270: iadd
    //   271: istore 4
    //   273: iload 4
    //   275: istore 7
    //   277: iload 6
    //   279: ifeq +13 -> 292
    //   282: iload 4
    //   284: iload 4
    //   286: bipush 76
    //   288: idiv
    //   289: iadd
    //   290: istore 7
    //   292: iload 7
    //   294: newarray <illegal type>
    //   296: astore 9
    //   298: iconst_0
    //   299: istore 8
    //   301: iconst_0
    //   302: istore 4
    //   304: iconst_0
    //   305: istore 5
    //   307: iload 8
    //   309: iload_2
    //   310: iconst_2
    //   311: isub
    //   312: if_icmpge +72 -> 384
    //   315: aload_0
    //   316: iload 8
    //   318: iload_1
    //   319: iadd
    //   320: iconst_3
    //   321: aload 9
    //   323: iload 4
    //   325: iload_3
    //   326: invokestatic 188	org/java_websocket/util/Base64:encode3to4	([BII[BII)[B
    //   329: pop
    //   330: iload 5
    //   332: iconst_4
    //   333: iadd
    //   334: istore 5
    //   336: iload 6
    //   338: ifeq +31 -> 369
    //   341: iload 5
    //   343: bipush 76
    //   345: if_icmplt +24 -> 369
    //   348: aload 9
    //   350: iload 4
    //   352: iconst_4
    //   353: iadd
    //   354: bipush 10
    //   356: bastore
    //   357: iload 4
    //   359: iconst_1
    //   360: iadd
    //   361: istore 4
    //   363: iconst_0
    //   364: istore 5
    //   366: goto +3 -> 369
    //   369: iload 8
    //   371: iconst_3
    //   372: iadd
    //   373: istore 8
    //   375: iload 4
    //   377: iconst_4
    //   378: iadd
    //   379: istore 4
    //   381: goto -74 -> 307
    //   384: iload 4
    //   386: istore 5
    //   388: iload 8
    //   390: iload_2
    //   391: if_icmpge +27 -> 418
    //   394: aload_0
    //   395: iload 8
    //   397: iload_1
    //   398: iadd
    //   399: iload_2
    //   400: iload 8
    //   402: isub
    //   403: aload 9
    //   405: iload 4
    //   407: iload_3
    //   408: invokestatic 188	org/java_websocket/util/Base64:encode3to4	([BII[BII)[B
    //   411: pop
    //   412: iload 4
    //   414: iconst_4
    //   415: iadd
    //   416: istore 5
    //   418: iload 5
    //   420: iload 7
    //   422: iconst_1
    //   423: isub
    //   424: if_icmpgt +20 -> 444
    //   427: iload 5
    //   429: newarray <illegal type>
    //   431: astore_0
    //   432: aload 9
    //   434: iconst_0
    //   435: aload_0
    //   436: iconst_0
    //   437: iload 5
    //   439: invokestatic 281	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   442: aload_0
    //   443: areturn
    //   444: aload 9
    //   446: areturn
    //   447: new 295	java/lang/IllegalArgumentException
    //   450: dup
    //   451: ldc_w 441
    //   454: iconst_3
    //   455: anewarray 4	java/lang/Object
    //   458: dup
    //   459: iconst_0
    //   460: iload_1
    //   461: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   464: aastore
    //   465: dup
    //   466: iconst_1
    //   467: iload_2
    //   468: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   471: aastore
    //   472: dup
    //   473: iconst_2
    //   474: aload_0
    //   475: arraylength
    //   476: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   479: aastore
    //   480: invokestatic 274	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   483: invokespecial 300	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   486: athrow
    //   487: new 283	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   494: astore_0
    //   495: aload_0
    //   496: ldc_w 443
    //   499: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload_0
    //   504: iload_2
    //   505: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: new 295	java/lang/IllegalArgumentException
    //   512: dup
    //   513: aload_0
    //   514: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokespecial 300	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   520: athrow
    //   521: new 283	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   528: astore_0
    //   529: aload_0
    //   530: ldc_w 445
    //   533: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload_0
    //   538: iload_1
    //   539: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: new 295	java/lang/IllegalArgumentException
    //   546: dup
    //   547: aload_0
    //   548: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokespecial 300	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   554: athrow
    //   555: new 256	java/lang/NullPointerException
    //   558: dup
    //   559: ldc_w 447
    //   562: invokespecial 261	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   565: athrow
    //   566: astore_0
    //   567: goto -483 -> 84
    //   570: astore_0
    //   571: goto -482 -> 89
    //   574: astore_0
    //   575: goto -481 -> 94
    //   578: astore 11
    //   580: goto -364 -> 216
    //   583: astore 9
    //   585: goto -364 -> 221
    //   588: astore 9
    //   590: goto -364 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	593	0	paramArrayOfByte	byte[]
    //   0	593	1	paramInt1	int
    //   0	593	2	paramInt2	int
    //   0	593	3	paramInt3	int
    //   256	160	4	i	int
    //   247	191	5	j	int
    //   236	101	6	k	int
    //   275	149	7	m	int
    //   299	104	8	n	int
    //   30	74	9	localObject1	Object
    //   108	1	9	localIOException1	IOException
    //   123	1	9	localObject2	Object
    //   128	1	9	localIOException2	IOException
    //   137	1	9	localObject3	Object
    //   146	13	9	localIOException3	IOException
    //   164	281	9	localObject4	Object
    //   583	1	9	localException1	Exception
    //   588	1	9	localException2	Exception
    //   39	135	10	localObject5	Object
    //   184	9	10	localIOException4	IOException
    //   199	23	10	localObject6	Object
    //   53	152	11	localOutputStream	OutputStream
    //   578	1	11	localException3	Exception
    //   64	148	12	localObject7	Object
    //   27	151	13	localObject8	Object
    //   195	14	13	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   66	79	100	finally
    //   66	79	108	java/io/IOException
    //   55	66	116	finally
    //   55	66	128	java/io/IOException
    //   41	55	135	finally
    //   41	55	146	java/io/IOException
    //   32	41	169	finally
    //   32	41	184	java/io/IOException
    //   192	195	195	finally
    //   79	84	566	java/lang/Exception
    //   84	89	570	java/lang/Exception
    //   89	94	574	java/lang/Exception
    //   211	216	578	java/lang/Exception
    //   216	221	583	java/lang/Exception
    //   221	226	588	java/lang/Exception
  }
  
  /* Error */
  public static void encodeFileToFile(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 452	org/java_websocket/util/Base64:encodeFromFile	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore_0
    //   9: new 319	java/io/BufferedOutputStream
    //   12: dup
    //   13: new 321	java/io/FileOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 322	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   21: invokespecial 325	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_1
    //   25: aload_1
    //   26: aload_3
    //   27: ldc 41
    //   29: invokevirtual 214	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   32: invokevirtual 329	java/io/OutputStream:write	([B)V
    //   35: aload_1
    //   36: invokevirtual 330	java/io/OutputStream:close	()V
    //   39: return
    //   40: astore_2
    //   41: aload_1
    //   42: astore_0
    //   43: aload_2
    //   44: astore_1
    //   45: goto +20 -> 65
    //   48: astore_2
    //   49: aload_1
    //   50: astore_0
    //   51: aload_2
    //   52: astore_1
    //   53: goto +10 -> 63
    //   56: astore_1
    //   57: goto +8 -> 65
    //   60: astore_1
    //   61: aload_2
    //   62: astore_0
    //   63: aload_1
    //   64: athrow
    //   65: aload_0
    //   66: invokevirtual 330	java/io/OutputStream:close	()V
    //   69: aload_1
    //   70: athrow
    //   71: astore_0
    //   72: return
    //   73: astore_0
    //   74: goto -5 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramString1	String
    //   0	77	1	paramString2	String
    //   6	1	2	localObject1	Object
    //   40	4	2	localObject2	Object
    //   48	14	2	localIOException	IOException
    //   4	23	3	str	String
    // Exception table:
    //   from	to	target	type
    //   25	35	40	finally
    //   25	35	48	java/io/IOException
    //   9	25	56	finally
    //   63	65	56	finally
    //   9	25	60	java/io/IOException
    //   35	39	71	java/lang/Exception
    //   65	69	73	java/lang/Exception
  }
  
  /* Error */
  public static String encodeFromFile(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore_3
    //   9: new 332	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 333	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload 5
    //   20: astore_3
    //   21: aload_0
    //   22: invokevirtual 337	java/io/File:length	()J
    //   25: l2d
    //   26: ldc2_w 453
    //   29: dmul
    //   30: dconst_1
    //   31: dadd
    //   32: d2i
    //   33: bipush 40
    //   35: invokestatic 457	java/lang/Math:max	(II)I
    //   38: newarray <illegal type>
    //   40: astore 6
    //   42: aload 5
    //   44: astore_3
    //   45: new 8	org/java_websocket/util/Base64$InputStream
    //   48: dup
    //   49: new 341	java/io/BufferedInputStream
    //   52: dup
    //   53: new 343	java/io/FileInputStream
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 346	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: invokespecial 347	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   64: iconst_1
    //   65: invokespecial 350	org/java_websocket/util/Base64$InputStream:<init>	(Ljava/io/InputStream;I)V
    //   68: astore_0
    //   69: iconst_0
    //   70: istore_1
    //   71: aload_0
    //   72: aload 6
    //   74: iload_1
    //   75: sipush 4096
    //   78: invokevirtual 353	org/java_websocket/util/Base64$InputStream:read	([BII)I
    //   81: istore_2
    //   82: iload_2
    //   83: iflt +10 -> 93
    //   86: iload_1
    //   87: iload_2
    //   88: iadd
    //   89: istore_1
    //   90: goto -19 -> 71
    //   93: new 211	java/lang/String
    //   96: dup
    //   97: aload 6
    //   99: iconst_0
    //   100: iload_1
    //   101: ldc 41
    //   103: invokespecial 460	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   106: astore_3
    //   107: aload_0
    //   108: invokevirtual 354	org/java_websocket/util/Base64$InputStream:close	()V
    //   111: aload_3
    //   112: areturn
    //   113: astore 4
    //   115: aload_0
    //   116: astore_3
    //   117: aload 4
    //   119: astore_0
    //   120: goto +23 -> 143
    //   123: astore 4
    //   125: aload_0
    //   126: astore_3
    //   127: aload 4
    //   129: astore_0
    //   130: goto +11 -> 141
    //   133: astore_0
    //   134: goto +9 -> 143
    //   137: astore_0
    //   138: aload 4
    //   140: astore_3
    //   141: aload_0
    //   142: athrow
    //   143: aload_3
    //   144: invokevirtual 354	org/java_websocket/util/Base64$InputStream:close	()V
    //   147: aload_0
    //   148: athrow
    //   149: astore_0
    //   150: aload_3
    //   151: areturn
    //   152: astore_3
    //   153: goto -6 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramString	String
    //   70	31	1	i	int
    //   81	8	2	j	int
    //   8	143	3	localObject1	Object
    //   152	1	3	localException	Exception
    //   1	1	4	localObject2	Object
    //   113	5	4	localObject3	Object
    //   123	16	4	localIOException	IOException
    //   4	39	5	localObject4	Object
    //   40	58	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   71	82	113	finally
    //   93	107	113	finally
    //   71	82	123	java/io/IOException
    //   93	107	123	java/io/IOException
    //   9	18	133	finally
    //   21	42	133	finally
    //   45	69	133	finally
    //   141	143	133	finally
    //   9	18	137	java/io/IOException
    //   21	42	137	java/io/IOException
    //   45	69	137	java/io/IOException
    //   107	111	149	java/lang/Exception
    //   143	147	152	java/lang/Exception
  }
  
  public static String encodeObject(Serializable paramSerializable)
    throws IOException
  {
    return encodeObject(paramSerializable, 0);
  }
  
  /* Error */
  public static String encodeObject(Serializable paramSerializable, int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +295 -> 296
    //   4: aconst_null
    //   5: astore 8
    //   7: aconst_null
    //   8: astore 6
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore 4
    //   16: new 224	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: invokespecial 225	java/io/ByteArrayOutputStream:<init>	()V
    //   23: astore_2
    //   24: new 11	org/java_websocket/util/Base64$OutputStream
    //   27: dup
    //   28: aload_2
    //   29: iload_1
    //   30: iconst_1
    //   31: ior
    //   32: invokespecial 365	org/java_websocket/util/Base64$OutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   35: astore 9
    //   37: iload_1
    //   38: iconst_2
    //   39: iand
    //   40: ifeq +64 -> 104
    //   43: new 436	java/util/zip/GZIPOutputStream
    //   46: dup
    //   47: aload 9
    //   49: invokespecial 437	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   52: astore_3
    //   53: aload 4
    //   55: astore 5
    //   57: aload_3
    //   58: astore 7
    //   60: aload_3
    //   61: astore 6
    //   63: new 467	java/io/ObjectOutputStream
    //   66: dup
    //   67: aload_3
    //   68: invokespecial 468	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   71: astore 4
    //   73: goto +44 -> 117
    //   76: astore_0
    //   77: aload 9
    //   79: astore 4
    //   81: aload 7
    //   83: astore_3
    //   84: goto +192 -> 276
    //   87: astore 5
    //   89: aload_2
    //   90: astore_0
    //   91: aload 8
    //   93: astore_2
    //   94: aload 9
    //   96: astore 4
    //   98: aload 6
    //   100: astore_3
    //   101: goto +154 -> 255
    //   104: new 467	java/io/ObjectOutputStream
    //   107: dup
    //   108: aload 9
    //   110: invokespecial 468	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   113: astore 4
    //   115: aconst_null
    //   116: astore_3
    //   117: aload 4
    //   119: astore 5
    //   121: aload_3
    //   122: astore 7
    //   124: aload 4
    //   126: astore 8
    //   128: aload_3
    //   129: astore 6
    //   131: aload 4
    //   133: aload_0
    //   134: invokevirtual 472	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   137: aload 4
    //   139: invokevirtual 473	java/io/ObjectOutputStream:close	()V
    //   142: aload_3
    //   143: invokevirtual 439	java/util/zip/GZIPOutputStream:close	()V
    //   146: aload 9
    //   148: invokevirtual 330	java/io/OutputStream:close	()V
    //   151: aload_2
    //   152: invokevirtual 249	java/io/ByteArrayOutputStream:close	()V
    //   155: new 211	java/lang/String
    //   158: dup
    //   159: aload_2
    //   160: invokevirtual 246	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   163: ldc 41
    //   165: invokespecial 433	java/lang/String:<init>	([BLjava/lang/String;)V
    //   168: astore_0
    //   169: aload_0
    //   170: areturn
    //   171: new 211	java/lang/String
    //   174: dup
    //   175: aload_2
    //   176: invokevirtual 246	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   179: invokespecial 434	java/lang/String:<init>	([B)V
    //   182: areturn
    //   183: astore_0
    //   184: aconst_null
    //   185: astore_3
    //   186: aload 9
    //   188: astore 4
    //   190: goto +86 -> 276
    //   193: astore 5
    //   195: aconst_null
    //   196: astore_3
    //   197: aload_2
    //   198: astore_0
    //   199: aload_3
    //   200: astore_2
    //   201: aload 9
    //   203: astore 4
    //   205: goto +50 -> 255
    //   208: astore_0
    //   209: aconst_null
    //   210: astore_3
    //   211: aload_3
    //   212: astore 4
    //   214: goto +62 -> 276
    //   217: astore 5
    //   219: aconst_null
    //   220: astore_3
    //   221: aload_3
    //   222: astore 4
    //   224: aload_2
    //   225: astore_0
    //   226: aload 4
    //   228: astore_2
    //   229: goto +26 -> 255
    //   232: astore_0
    //   233: aconst_null
    //   234: astore_3
    //   235: aload_3
    //   236: astore_2
    //   237: aload_2
    //   238: astore 4
    //   240: goto +36 -> 276
    //   243: astore 5
    //   245: aconst_null
    //   246: astore_3
    //   247: aload_3
    //   248: astore_2
    //   249: aload_2
    //   250: astore 4
    //   252: aload 6
    //   254: astore_0
    //   255: aload 5
    //   257: athrow
    //   258: astore 7
    //   260: aload_0
    //   261: astore 5
    //   263: aload_2
    //   264: astore 6
    //   266: aload 7
    //   268: astore_0
    //   269: aload 5
    //   271: astore_2
    //   272: aload 6
    //   274: astore 5
    //   276: aload 5
    //   278: invokevirtual 473	java/io/ObjectOutputStream:close	()V
    //   281: aload_3
    //   282: invokevirtual 439	java/util/zip/GZIPOutputStream:close	()V
    //   285: aload 4
    //   287: invokevirtual 330	java/io/OutputStream:close	()V
    //   290: aload_2
    //   291: invokevirtual 249	java/io/ByteArrayOutputStream:close	()V
    //   294: aload_0
    //   295: athrow
    //   296: new 256	java/lang/NullPointerException
    //   299: dup
    //   300: ldc_w 475
    //   303: invokespecial 261	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   306: athrow
    //   307: astore_0
    //   308: goto -166 -> 142
    //   311: astore_0
    //   312: goto -166 -> 146
    //   315: astore_0
    //   316: goto -165 -> 151
    //   319: astore_0
    //   320: goto -165 -> 155
    //   323: astore_0
    //   324: goto -153 -> 171
    //   327: astore 5
    //   329: goto -48 -> 281
    //   332: astore_3
    //   333: goto -48 -> 285
    //   336: astore_3
    //   337: goto -47 -> 290
    //   340: astore_2
    //   341: goto -47 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	paramSerializable	Serializable
    //   0	344	1	paramInt	int
    //   23	268	2	localObject1	Object
    //   340	1	2	localException1	Exception
    //   52	230	3	localObject2	Object
    //   332	1	3	localException2	Exception
    //   336	1	3	localException3	Exception
    //   14	272	4	localObject3	Object
    //   11	45	5	localObject4	Object
    //   87	1	5	localIOException1	IOException
    //   119	1	5	localObject5	Object
    //   193	1	5	localIOException2	IOException
    //   217	1	5	localIOException3	IOException
    //   243	13	5	localIOException4	IOException
    //   261	16	5	localObject6	Object
    //   327	1	5	localException4	Exception
    //   8	265	6	localObject7	Object
    //   58	65	7	localObject8	Object
    //   258	9	7	localObject9	Object
    //   5	122	8	localObject10	Object
    //   35	167	9	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   63	73	76	finally
    //   131	137	76	finally
    //   63	73	87	java/io/IOException
    //   131	137	87	java/io/IOException
    //   43	53	183	finally
    //   104	115	183	finally
    //   43	53	193	java/io/IOException
    //   104	115	193	java/io/IOException
    //   24	37	208	finally
    //   24	37	217	java/io/IOException
    //   16	24	232	finally
    //   16	24	243	java/io/IOException
    //   255	258	258	finally
    //   137	142	307	java/lang/Exception
    //   142	146	311	java/lang/Exception
    //   146	151	315	java/lang/Exception
    //   151	155	319	java/lang/Exception
    //   155	169	323	java/io/UnsupportedEncodingException
    //   276	281	327	java/lang/Exception
    //   281	285	332	java/lang/Exception
    //   285	290	336	java/lang/Exception
    //   290	294	340	java/lang/Exception
  }
  
  /* Error */
  public static void encodeToFile(byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +61 -> 62
    //   4: aconst_null
    //   5: astore_3
    //   6: aconst_null
    //   7: astore_2
    //   8: new 11	org/java_websocket/util/Base64$OutputStream
    //   11: dup
    //   12: new 321	java/io/FileOutputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 322	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: iconst_1
    //   21: invokespecial 365	org/java_websocket/util/Base64$OutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   24: astore_1
    //   25: aload_1
    //   26: aload_0
    //   27: invokevirtual 366	org/java_websocket/util/Base64$OutputStream:write	([B)V
    //   30: aload_1
    //   31: invokevirtual 367	org/java_websocket/util/Base64$OutputStream:close	()V
    //   34: return
    //   35: astore_0
    //   36: aload_1
    //   37: astore_2
    //   38: goto +18 -> 56
    //   41: astore_0
    //   42: aload_1
    //   43: astore_2
    //   44: goto +10 -> 54
    //   47: astore_0
    //   48: goto +8 -> 56
    //   51: astore_0
    //   52: aload_3
    //   53: astore_2
    //   54: aload_0
    //   55: athrow
    //   56: aload_2
    //   57: invokevirtual 367	org/java_websocket/util/Base64$OutputStream:close	()V
    //   60: aload_0
    //   61: athrow
    //   62: new 256	java/lang/NullPointerException
    //   65: dup
    //   66: ldc_w 478
    //   69: invokespecial 261	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   72: athrow
    //   73: astore_0
    //   74: return
    //   75: astore_1
    //   76: goto -16 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	paramArrayOfByte	byte[]
    //   0	79	1	paramString	String
    //   7	50	2	localObject1	Object
    //   5	48	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   25	30	35	finally
    //   25	30	41	java/io/IOException
    //   8	25	47	finally
    //   54	56	47	finally
    //   8	25	51	java/io/IOException
    //   30	34	73	java/lang/Exception
    //   56	60	75	java/lang/Exception
  }
  
  private static final byte[] getAlphabet(int paramInt)
  {
    if ((paramInt & 0x10) == 16) {
      return _URL_SAFE_ALPHABET;
    }
    if ((paramInt & 0x20) == 32) {
      return _ORDERED_ALPHABET;
    }
    return _STANDARD_ALPHABET;
  }
  
  private static final byte[] getDecodabet(int paramInt)
  {
    if ((paramInt & 0x10) == 16) {
      return _URL_SAFE_DECODABET;
    }
    if ((paramInt & 0x20) == 32) {
      return _ORDERED_DECODABET;
    }
    return _STANDARD_DECODABET;
  }
  
  public static class InputStream
    extends FilterInputStream
  {
    private boolean breakLines;
    private byte[] buffer;
    private int bufferLength;
    private byte[] decodabet;
    private boolean encode;
    private int lineLength;
    private int numSigBytes;
    private int options;
    private int position;
    
    public InputStream(InputStream paramInputStream)
    {
      this(paramInputStream, 0);
    }
    
    public InputStream(InputStream paramInputStream, int paramInt)
    {
      super();
      this.options = paramInt;
      boolean bool2 = true;
      boolean bool1;
      if ((paramInt & 0x8) > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.breakLines = bool1;
      if ((paramInt & 0x1) > 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.encode = bool1;
      int i;
      if (bool1) {
        i = 4;
      } else {
        i = 3;
      }
      this.bufferLength = i;
      this.buffer = new byte[i];
      this.position = -1;
      this.lineLength = 0;
      this.decodabet = Base64.getDecodabet(paramInt);
    }
    
    public int read()
      throws IOException
    {
      byte[] arrayOfByte;
      int j;
      if (this.position < 0) {
        if (this.encode)
        {
          arrayOfByte = new byte[3];
          i = 0;
          j = 0;
          while (i < 3)
          {
            int k = this.in.read();
            if (k < 0) {
              break;
            }
            arrayOfByte[i] = ((byte)k);
            j += 1;
            i += 1;
          }
          if (j > 0)
          {
            Base64.encode3to4(arrayOfByte, 0, j, this.buffer, 0, this.options);
            this.position = 0;
            this.numSigBytes = 4;
          }
          else
          {
            return -1;
          }
        }
        else
        {
          arrayOfByte = new byte[4];
          i = 0;
          while (i < 4)
          {
            do
            {
              j = this.in.read();
            } while ((j >= 0) && (this.decodabet[(j & 0x7F)] <= -5));
            if (j < 0) {
              break;
            }
            arrayOfByte[i] = ((byte)j);
            i += 1;
          }
          if (i == 4)
          {
            this.numSigBytes = Base64.decode4to3(arrayOfByte, 0, this.buffer, 0, this.options);
            this.position = 0;
          }
          else
          {
            if (i == 0) {
              return -1;
            }
            throw new IOException("Improperly padded Base64 input.");
          }
        }
      }
      int i = this.position;
      if (i >= 0)
      {
        if (i >= this.numSigBytes) {
          return -1;
        }
        if ((this.encode) && (this.breakLines) && (this.lineLength >= 76))
        {
          this.lineLength = 0;
          return 10;
        }
        this.lineLength += 1;
        arrayOfByte = this.buffer;
        j = this.position;
        i = j + 1;
        this.position = i;
        j = arrayOfByte[j];
        if (i >= this.bufferLength) {
          this.position = -1;
        }
        return j & 0xFF;
      }
      throw new IOException("Error in Base64 code reading stream.");
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      int i = 0;
      while (i < paramInt2)
      {
        int j = read();
        if (j >= 0)
        {
          paramArrayOfByte[(paramInt1 + i)] = ((byte)j);
          i += 1;
        }
        else if (i == 0)
        {
          return -1;
        }
      }
      return i;
    }
  }
  
  public static class OutputStream
    extends FilterOutputStream
  {
    private byte[] b4;
    private boolean breakLines;
    private byte[] buffer;
    private int bufferLength;
    private byte[] decodabet;
    private boolean encode;
    private int lineLength;
    private int options;
    private int position;
    private boolean suspendEncoding;
    
    public OutputStream(OutputStream paramOutputStream)
    {
      this(paramOutputStream, 1);
    }
    
    public OutputStream(OutputStream paramOutputStream, int paramInt)
    {
      super();
      boolean bool2 = true;
      boolean bool1;
      if ((paramInt & 0x8) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.breakLines = bool1;
      if ((paramInt & 0x1) != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.encode = bool1;
      int i;
      if (bool1) {
        i = 3;
      } else {
        i = 4;
      }
      this.bufferLength = i;
      this.buffer = new byte[i];
      this.position = 0;
      this.lineLength = 0;
      this.suspendEncoding = false;
      this.b4 = new byte[4];
      this.options = paramInt;
      this.decodabet = Base64.getDecodabet(paramInt);
    }
    
    public void close()
      throws IOException
    {
      flushBase64();
      super.close();
      this.buffer = null;
      this.out = null;
    }
    
    public void flushBase64()
      throws IOException
    {
      if (this.position > 0)
      {
        if (this.encode)
        {
          this.out.write(Base64.encode3to4(this.b4, this.buffer, this.position, this.options));
          this.position = 0;
          return;
        }
        throw new IOException("Base64 input not properly padded.");
      }
    }
    
    public void resumeEncoding()
    {
      this.suspendEncoding = false;
    }
    
    public void suspendEncoding()
      throws IOException
    {
      flushBase64();
      this.suspendEncoding = true;
    }
    
    public void write(int paramInt)
      throws IOException
    {
      if (this.suspendEncoding)
      {
        this.out.write(paramInt);
        return;
      }
      byte[] arrayOfByte;
      int i;
      int j;
      if (this.encode)
      {
        arrayOfByte = this.buffer;
        i = this.position;
        j = i + 1;
        this.position = j;
        arrayOfByte[i] = ((byte)paramInt);
        if (j >= this.bufferLength)
        {
          this.out.write(Base64.encode3to4(this.b4, this.buffer, this.bufferLength, this.options));
          paramInt = this.lineLength + 4;
          this.lineLength = paramInt;
          if ((this.breakLines) && (paramInt >= 76))
          {
            this.out.write(10);
            this.lineLength = 0;
          }
          this.position = 0;
        }
      }
      else
      {
        arrayOfByte = this.decodabet;
        i = paramInt & 0x7F;
        if (arrayOfByte[i] > -5)
        {
          arrayOfByte = this.buffer;
          i = this.position;
          j = i + 1;
          this.position = j;
          arrayOfByte[i] = ((byte)paramInt);
          if (j >= this.bufferLength)
          {
            paramInt = Base64.decode4to3(arrayOfByte, 0, this.b4, 0, this.options);
            this.out.write(this.b4, 0, paramInt);
            this.position = 0;
          }
        }
        else
        {
          if (arrayOfByte[i] != -5) {
            break label227;
          }
        }
      }
      return;
      label227:
      throw new IOException("Invalid character in Base64 data.");
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this.suspendEncoding)
      {
        this.out.write(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      int i = 0;
      while (i < paramInt2)
      {
        write(paramArrayOfByte[(paramInt1 + i)]);
        i += 1;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocke\\util\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */