package com.google.android.gms.common.server.response;

import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FastParser<T extends FastJsonResponse>
{
  private static final char[] zaqg = { 117, 108, 108 };
  private static final char[] zaqh = { 114, 117, 101 };
  private static final char[] zaqi = { 114, 117, 101, 34 };
  private static final char[] zaqj = { 97, 108, 115, 101 };
  private static final char[] zaqk = { 97, 108, 115, 101, 34 };
  private static final char[] zaql = { '\n' };
  private static final zaa<Integer> zaqn = new zaa();
  private static final zaa<Long> zaqo = new zab();
  private static final zaa<Float> zaqp = new zac();
  private static final zaa<Double> zaqq = new zad();
  private static final zaa<Boolean> zaqr = new zae();
  private static final zaa<String> zaqs = new zaf();
  private static final zaa<BigInteger> zaqt = new zag();
  private static final zaa<BigDecimal> zaqu = new zah();
  private final char[] zaqb = new char[1];
  private final char[] zaqc = new char[32];
  private final char[] zaqd = new char['Ѐ'];
  private final StringBuilder zaqe = new StringBuilder(32);
  private final StringBuilder zaqf = new StringBuilder(1024);
  private final Stack<Integer> zaqm = new Stack();
  
  private final int zaa(BufferedReader paramBufferedReader, char[] paramArrayOfChar)
    throws FastParser.ParseException, IOException
  {
    char c = zaj(paramBufferedReader);
    if (c != 0)
    {
      if (c != ',')
      {
        if (c == 'n')
        {
          zab(paramBufferedReader, zaqg);
          return 0;
        }
        paramBufferedReader.mark(1024);
        int k;
        if (c == '"')
        {
          i = 0;
          int j = 0;
          for (;;)
          {
            k = i;
            if (i >= paramArrayOfChar.length) {
              break label260;
            }
            k = i;
            if (paramBufferedReader.read(paramArrayOfChar, i, 1) == -1) {
              break label260;
            }
            c = paramArrayOfChar[i];
            if (Character.isISOControl(c)) {
              break;
            }
            if ((c == '"') && (j == 0))
            {
              paramBufferedReader.reset();
              paramBufferedReader.skip(i + 1);
              return i;
            }
            if (c == '\\') {
              j ^= 0x1;
            } else {
              j = 0;
            }
            i += 1;
          }
          throw new ParseException("Unexpected control character while reading string");
        }
        paramArrayOfChar[0] = c;
        int i = 1;
        for (;;)
        {
          k = i;
          if (i >= paramArrayOfChar.length) {
            break label260;
          }
          k = i;
          if (paramBufferedReader.read(paramArrayOfChar, i, 1) == -1) {
            break label260;
          }
          if ((paramArrayOfChar[i] == '}') || (paramArrayOfChar[i] == ',') || (Character.isWhitespace(paramArrayOfChar[i])) || (paramArrayOfChar[i] == ']')) {
            break;
          }
          i += 1;
        }
        paramBufferedReader.reset();
        paramBufferedReader.skip(i - 1);
        paramArrayOfChar[i] = '\000';
        return i;
        label260:
        if (k == paramArrayOfChar.length) {
          throw new ParseException("Absurdly long value");
        }
        throw new ParseException("Unexpected EOF");
      }
      throw new ParseException("Missing value");
    }
    throw new ParseException("Unexpected EOF");
  }
  
  private final String zaa(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    this.zaqm.push(Integer.valueOf(2));
    char c = zaj(paramBufferedReader);
    if (c != '"')
    {
      if (c != ']')
      {
        if (c == '}')
        {
          zak(2);
          return null;
        }
        paramBufferedReader = new StringBuilder(19);
        paramBufferedReader.append("Unexpected token: ");
        paramBufferedReader.append(c);
        throw new ParseException(paramBufferedReader.toString());
      }
      zak(2);
      zak(1);
      zak(5);
      return null;
    }
    this.zaqm.push(Integer.valueOf(3));
    String str = zab(paramBufferedReader, this.zaqc, this.zaqe, null);
    zak(3);
    if (zaj(paramBufferedReader) == ':') {
      return str;
    }
    throw new ParseException("Expected key/value separator");
  }
  
  private final String zaa(BufferedReader paramBufferedReader, char[] paramArrayOfChar1, StringBuilder paramStringBuilder, char[] paramArrayOfChar2)
    throws FastParser.ParseException, IOException
  {
    int i = zaj(paramBufferedReader);
    if (i != 34)
    {
      if (i == 110)
      {
        zab(paramBufferedReader, zaqg);
        return null;
      }
      throw new ParseException("Expected string");
    }
    return zab(paramBufferedReader, paramArrayOfChar1, paramStringBuilder, paramArrayOfChar2);
  }
  
  private final <T extends FastJsonResponse> ArrayList<T> zaa(BufferedReader paramBufferedReader, FastJsonResponse.Field<?, ?> paramField)
    throws FastParser.ParseException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    char c = zaj(paramBufferedReader);
    if (c != ']')
    {
      if (c != 'n')
      {
        if (c == '{')
        {
          this.zaqm.push(Integer.valueOf(1));
          try
          {
            for (;;)
            {
              FastJsonResponse localFastJsonResponse = paramField.zacp();
              if (!zaa(paramBufferedReader, localFastJsonResponse)) {
                break label165;
              }
              localArrayList.add(localFastJsonResponse);
              c = zaj(paramBufferedReader);
              if (c != ',')
              {
                if (c == ']')
                {
                  zak(5);
                  return localArrayList;
                }
                paramBufferedReader = new StringBuilder(19);
                paramBufferedReader.append("Unexpected token: ");
                paramBufferedReader.append(c);
                throw new ParseException(paramBufferedReader.toString());
              }
              if (zaj(paramBufferedReader) != '{') {
                break;
              }
              this.zaqm.push(Integer.valueOf(1));
            }
            throw new ParseException("Expected start of next object in array");
            label165:
            return localArrayList;
          }
          catch (IllegalAccessException paramBufferedReader)
          {
            throw new ParseException("Error instantiating inner object", paramBufferedReader);
          }
          catch (InstantiationException paramBufferedReader)
          {
            throw new ParseException("Error instantiating inner object", paramBufferedReader);
          }
        }
        paramBufferedReader = new StringBuilder(19);
        paramBufferedReader.append("Unexpected token: ");
        paramBufferedReader.append(c);
        throw new ParseException(paramBufferedReader.toString());
      }
      zab(paramBufferedReader, zaqg);
      zak(5);
      return null;
    }
    zak(5);
    return localArrayList;
  }
  
  private final <O> ArrayList<O> zaa(BufferedReader paramBufferedReader, zaa<O> paramzaa)
    throws FastParser.ParseException, IOException
  {
    int i = zaj(paramBufferedReader);
    if (i == 110)
    {
      zab(paramBufferedReader, zaqg);
      return null;
    }
    if (i == 91)
    {
      this.zaqm.push(Integer.valueOf(5));
      ArrayList localArrayList = new ArrayList();
      for (;;)
      {
        paramBufferedReader.mark(1024);
        i = zaj(paramBufferedReader);
        if (i == 0) {
          break label107;
        }
        if (i != 44)
        {
          if (i == 93) {
            break;
          }
          paramBufferedReader.reset();
          localArrayList.add(paramzaa.zah(this, paramBufferedReader));
        }
      }
      zak(5);
      return localArrayList;
      label107:
      throw new ParseException("Unexpected EOF");
    }
    throw new ParseException("Expected start of array");
  }
  
  private final boolean zaa(BufferedReader paramBufferedReader, FastJsonResponse paramFastJsonResponse)
    throws FastParser.ParseException, IOException
  {
    Map localMap = paramFastJsonResponse.getFieldMappings();
    Object localObject = zaa(paramBufferedReader);
    Integer localInteger = Integer.valueOf(1);
    if (localObject == null)
    {
      zak(1);
      return false;
    }
    while (localObject != null)
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localMap.get(localObject);
      if (localField == null)
      {
        localObject = zab(paramBufferedReader);
      }
      else
      {
        this.zaqm.push(Integer.valueOf(4));
        int i;
        switch (localField.zapr)
        {
        default: 
          i = localField.zapr;
          paramBufferedReader = new StringBuilder(30);
          paramBufferedReader.append("Invalid field type ");
          paramBufferedReader.append(i);
          throw new ParseException(paramBufferedReader.toString());
        case 11: 
          if (localField.zaps)
          {
            i = zaj(paramBufferedReader);
            if (i == 110)
            {
              zab(paramBufferedReader, zaqg);
              paramFastJsonResponse.addConcreteTypeArrayInternal(localField, localField.zapv, null);
              break;
            }
            this.zaqm.push(Integer.valueOf(5));
            if (i == 91)
            {
              paramFastJsonResponse.addConcreteTypeArrayInternal(localField, localField.zapv, zaa(paramBufferedReader, localField));
              break;
            }
            throw new ParseException("Expected array start");
          }
          i = zaj(paramBufferedReader);
          if (i == 110)
          {
            zab(paramBufferedReader, zaqg);
            paramFastJsonResponse.addConcreteTypeInternal(localField, localField.zapv, null);
            break;
          }
          this.zaqm.push(localInteger);
          if (i == 123) {
            try
            {
              localObject = localField.zacp();
              zaa(paramBufferedReader, (FastJsonResponse)localObject);
              paramFastJsonResponse.addConcreteTypeInternal(localField, localField.zapv, (FastJsonResponse)localObject);
            }
            catch (IllegalAccessException paramBufferedReader)
            {
              throw new ParseException("Error instantiating inner object", paramBufferedReader);
            }
            catch (InstantiationException paramBufferedReader)
            {
              throw new ParseException("Error instantiating inner object", paramBufferedReader);
            }
          }
          throw new ParseException("Expected start of object");
        case 10: 
          i = zaj(paramBufferedReader);
          if (i == 110)
          {
            zab(paramBufferedReader, zaqg);
            localObject = null;
          }
          else
          {
            if (i != 123) {
              break label722;
            }
            this.zaqm.push(localInteger);
            localObject = new HashMap();
          }
          for (;;)
          {
            i = zaj(paramBufferedReader);
            if (i == 0) {
              break;
            }
            if (i != 34)
            {
              if (i != 125) {
                break label709;
              }
              zak(1);
            }
            else
            {
              String str = zab(paramBufferedReader, this.zaqc, this.zaqe, null);
              if (zaj(paramBufferedReader) != ':')
              {
                paramBufferedReader = String.valueOf(str);
                if (paramBufferedReader.length() != 0) {
                  paramBufferedReader = "No map value found for key ".concat(paramBufferedReader);
                } else {
                  paramBufferedReader = new String("No map value found for key ");
                }
                throw new ParseException(paramBufferedReader);
              }
              if (zaj(paramBufferedReader) != '"')
              {
                paramBufferedReader = String.valueOf(str);
                if (paramBufferedReader.length() != 0) {
                  paramBufferedReader = "Expected String value for key ".concat(paramBufferedReader);
                } else {
                  paramBufferedReader = new String("Expected String value for key ");
                }
                throw new ParseException(paramBufferedReader);
              }
              ((HashMap)localObject).put(str, zab(paramBufferedReader, this.zaqc, this.zaqe, null));
              c = zaj(paramBufferedReader);
              if (c == ',') {
                break label709;
              }
              if (c != '}') {
                break label673;
              }
              zak(1);
            }
            paramFastJsonResponse.zaa(localField, (Map)localObject);
            break label786;
            paramBufferedReader = new StringBuilder(48);
            paramBufferedReader.append("Unexpected character while parsing string map: ");
            paramBufferedReader.append(c);
            throw new ParseException(paramBufferedReader.toString());
          }
          throw new ParseException("Unexpected EOF");
          throw new ParseException("Expected start of a map object");
        case 9: 
          paramFastJsonResponse.zaa(localField, Base64Utils.decodeUrlSafe(zaa(paramBufferedReader, this.zaqd, this.zaqf, zaql)));
          break;
        case 8: 
          label673:
          label709:
          label722:
          paramFastJsonResponse.zaa(localField, Base64Utils.decode(zaa(paramBufferedReader, this.zaqd, this.zaqf, zaql)));
        }
        for (;;)
        {
          label786:
          break;
          if (localField.zaps)
          {
            paramFastJsonResponse.zah(localField, zaa(paramBufferedReader, zaqs));
          }
          else
          {
            paramFastJsonResponse.zaa(localField, zac(paramBufferedReader));
            continue;
            if (localField.zaps)
            {
              paramFastJsonResponse.zag(localField, zaa(paramBufferedReader, zaqr));
            }
            else
            {
              paramFastJsonResponse.zaa(localField, zaa(paramBufferedReader, false));
              break;
              if (localField.zaps)
              {
                paramFastJsonResponse.zaf(localField, zaa(paramBufferedReader, zaqu));
              }
              else
              {
                paramFastJsonResponse.zaa(localField, zai(paramBufferedReader));
                break;
                if (localField.zaps)
                {
                  paramFastJsonResponse.zae(localField, zaa(paramBufferedReader, zaqq));
                }
                else
                {
                  paramFastJsonResponse.zaa(localField, zah(paramBufferedReader));
                  break;
                  if (localField.zaps)
                  {
                    paramFastJsonResponse.zad(localField, zaa(paramBufferedReader, zaqp));
                  }
                  else
                  {
                    paramFastJsonResponse.zaa(localField, zag(paramBufferedReader));
                    break;
                    if (localField.zaps)
                    {
                      paramFastJsonResponse.zac(localField, zaa(paramBufferedReader, zaqo));
                    }
                    else
                    {
                      paramFastJsonResponse.zaa(localField, zae(paramBufferedReader));
                      break;
                      if (localField.zaps)
                      {
                        paramFastJsonResponse.zab(localField, zaa(paramBufferedReader, zaqt));
                      }
                      else
                      {
                        paramFastJsonResponse.zaa(localField, zaf(paramBufferedReader));
                        break;
                        if (localField.zaps) {
                          paramFastJsonResponse.zaa(localField, zaa(paramBufferedReader, zaqn));
                        } else {
                          paramFastJsonResponse.zaa(localField, zad(paramBufferedReader));
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        zak(4);
        zak(2);
        char c = zaj(paramBufferedReader);
        if (c != ',')
        {
          if (c == '}')
          {
            localObject = null;
          }
          else
          {
            paramBufferedReader = new StringBuilder(55);
            paramBufferedReader.append("Expected end of object or field separator, but found: ");
            paramBufferedReader.append(c);
            throw new ParseException(paramBufferedReader.toString());
          }
        }
        else {
          localObject = zaa(paramBufferedReader);
        }
      }
    }
    zak(1);
    return true;
  }
  
  private final boolean zaa(BufferedReader paramBufferedReader, boolean paramBoolean)
    throws FastParser.ParseException, IOException
  {
    for (;;)
    {
      char c = zaj(paramBufferedReader);
      if (c != '"')
      {
        char[] arrayOfChar;
        if (c != 'f')
        {
          if (c != 'n')
          {
            if (c == 't')
            {
              if (paramBoolean) {
                arrayOfChar = zaqi;
              } else {
                arrayOfChar = zaqh;
              }
              zab(paramBufferedReader, arrayOfChar);
              return true;
            }
            paramBufferedReader = new StringBuilder(19);
            paramBufferedReader.append("Unexpected token: ");
            paramBufferedReader.append(c);
            throw new ParseException(paramBufferedReader.toString());
          }
          zab(paramBufferedReader, zaqg);
          return false;
        }
        if (paramBoolean) {
          arrayOfChar = zaqk;
        } else {
          arrayOfChar = zaqj;
        }
        zab(paramBufferedReader, arrayOfChar);
        return false;
      }
      if (paramBoolean) {
        break;
      }
      paramBoolean = true;
    }
    throw new ParseException("No boolean value found in string");
  }
  
  private final String zab(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    paramBufferedReader.mark(1024);
    int j = zaj(paramBufferedReader);
    int k;
    int i;
    if (j != 34)
    {
      if (j != 44)
      {
        k = 1;
        if (j != 91)
        {
          if (j != 123)
          {
            paramBufferedReader.reset();
            zaa(paramBufferedReader, this.zaqd);
          }
          else
          {
            this.zaqm.push(Integer.valueOf(1));
            paramBufferedReader.mark(32);
            i = zaj(paramBufferedReader);
            if (i == 125)
            {
              zak(1);
            }
            else if (i == 34)
            {
              paramBufferedReader.reset();
              zaa(paramBufferedReader);
              while (zab(paramBufferedReader) != null) {}
              zak(1);
            }
            else
            {
              paramBufferedReader = new StringBuilder(18);
              paramBufferedReader.append("Unexpected token ");
              paramBufferedReader.append(i);
              throw new ParseException(paramBufferedReader.toString());
            }
          }
        }
        else
        {
          this.zaqm.push(Integer.valueOf(5));
          paramBufferedReader.mark(32);
          if (zaj(paramBufferedReader) == ']')
          {
            zak(5);
          }
          else
          {
            paramBufferedReader.reset();
            j = 0;
            int m = 0;
            while (k > 0)
            {
              i = zaj(paramBufferedReader);
              if (i != 0)
              {
                if (!Character.isISOControl(i))
                {
                  int n = m;
                  if (i == 34)
                  {
                    n = m;
                    if (j == 0) {
                      n = m ^ 0x1;
                    }
                  }
                  m = k;
                  if (i == 91)
                  {
                    m = k;
                    if (n == 0) {
                      m = k + 1;
                    }
                  }
                  k = m;
                  if (i == 93)
                  {
                    k = m;
                    if (n == 0) {
                      k = m - 1;
                    }
                  }
                  if ((i == 92) && (n != 0))
                  {
                    j ^= 0x1;
                    m = n;
                  }
                  else
                  {
                    j = 0;
                    m = n;
                  }
                }
                else
                {
                  throw new ParseException("Unexpected control character while reading array");
                }
              }
              else {
                throw new ParseException("Unexpected EOF while parsing array");
              }
            }
            zak(5);
          }
        }
      }
      else
      {
        throw new ParseException("Missing value");
      }
    }
    else
    {
      if (paramBufferedReader.read(this.zaqb) == -1) {
        break label552;
      }
      k = this.zaqb[0];
      j = 0;
    }
    for (;;)
    {
      if ((k == 34) && (j == 0))
      {
        i = zaj(paramBufferedReader);
        if (i != 44)
        {
          if (i == 125)
          {
            zak(2);
            return null;
          }
          paramBufferedReader = new StringBuilder(18);
          paramBufferedReader.append("Unexpected token ");
          paramBufferedReader.append(i);
          throw new ParseException(paramBufferedReader.toString());
        }
        zak(2);
        return zaa(paramBufferedReader);
      }
      if (k == 92) {
        j ^= 0x1;
      } else {
        j = 0;
      }
      if (paramBufferedReader.read(this.zaqb) == -1) {
        break label541;
      }
      i = this.zaqb[0];
      if (Character.isISOControl(i)) {
        break;
      }
      k = i;
    }
    throw new ParseException("Unexpected control character while reading string");
    label541:
    throw new ParseException("Unexpected EOF while parsing string");
    label552:
    throw new ParseException("Unexpected EOF while parsing string");
  }
  
  private static String zab(BufferedReader paramBufferedReader, char[] paramArrayOfChar1, StringBuilder paramStringBuilder, char[] paramArrayOfChar2)
    throws FastParser.ParseException, IOException
  {
    paramStringBuilder.setLength(0);
    paramBufferedReader.mark(paramArrayOfChar1.length);
    int k = 0;
    int i = 0;
    for (;;)
    {
      int n = paramBufferedReader.read(paramArrayOfChar1);
      if (n == -1) {
        break;
      }
      int j = 0;
      while (j < n)
      {
        char c = paramArrayOfChar1[j];
        int m;
        if (Character.isISOControl(c))
        {
          if (paramArrayOfChar2 != null)
          {
            m = 0;
            while (m < paramArrayOfChar2.length)
            {
              if (paramArrayOfChar2[m] == c)
              {
                m = 1;
                break label95;
              }
              m += 1;
            }
          }
          m = 0;
          label95:
          if (m == 0) {
            throw new ParseException("Unexpected control character while reading string");
          }
        }
        if ((c == '"') && (k == 0))
        {
          paramStringBuilder.append(paramArrayOfChar1, 0, j);
          paramBufferedReader.reset();
          paramBufferedReader.skip(j + 1);
          if (i != 0) {
            return JsonUtils.unescapeString(paramStringBuilder.toString());
          }
          return paramStringBuilder.toString();
        }
        if (c == '\\')
        {
          i = k ^ 0x1;
          m = 1;
        }
        else
        {
          k = 0;
          m = i;
          i = k;
        }
        j += 1;
        k = i;
        i = m;
      }
      paramStringBuilder.append(paramArrayOfChar1, 0, n);
      paramBufferedReader.mark(paramArrayOfChar1.length);
    }
    throw new ParseException("Unexpected EOF while parsing string");
  }
  
  private final void zab(BufferedReader paramBufferedReader, char[] paramArrayOfChar)
    throws FastParser.ParseException, IOException
  {
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      int k = paramBufferedReader.read(this.zaqc, 0, paramArrayOfChar.length - i);
      if (k != -1)
      {
        int j = 0;
        while (j < k) {
          if (paramArrayOfChar[(j + i)] == this.zaqc[j]) {
            j += 1;
          } else {
            throw new ParseException("Unexpected character");
          }
        }
        i += k;
      }
      else
      {
        throw new ParseException("Unexpected EOF");
      }
    }
  }
  
  private final String zac(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    return zaa(paramBufferedReader, this.zaqc, this.zaqe, null);
  }
  
  private final int zad(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i1 = zaa(paramBufferedReader, this.zaqd);
    int j = 0;
    if (i1 == 0) {
      return 0;
    }
    paramBufferedReader = this.zaqd;
    if (i1 > 0)
    {
      int m;
      int i;
      int n;
      if (paramBufferedReader[0] == '-')
      {
        m = Integer.MIN_VALUE;
        i = 1;
        n = 1;
      }
      else
      {
        m = -2147483647;
        i = 0;
        n = 0;
      }
      int k = i;
      if (i < i1)
      {
        j = Character.digit(paramBufferedReader[i], 10);
        if (j >= 0)
        {
          j = -j;
          k = i + 1;
        }
        else
        {
          throw new ParseException("Unexpected non-digit character");
        }
      }
      while (k < i1)
      {
        i = Character.digit(paramBufferedReader[k], 10);
        if (i >= 0)
        {
          if (j >= -214748364)
          {
            j *= 10;
            if (j >= m + i)
            {
              j -= i;
              k += 1;
            }
            else
            {
              throw new ParseException("Number too large");
            }
          }
          else
          {
            throw new ParseException("Number too large");
          }
        }
        else {
          throw new ParseException("Unexpected non-digit character");
        }
      }
      if (n != 0)
      {
        if (k > 1) {
          return j;
        }
        throw new ParseException("No digits to parse");
      }
      return -j;
    }
    throw new ParseException("No number to parse");
  }
  
  private final long zae(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int m = zaa(paramBufferedReader, this.zaqd);
    long l1 = 0L;
    if (m == 0) {
      return 0L;
    }
    paramBufferedReader = this.zaqd;
    if (m > 0)
    {
      int i = 0;
      long l2;
      int k;
      if (paramBufferedReader[0] == '-')
      {
        l2 = Long.MIN_VALUE;
        i = 1;
        k = 1;
      }
      else
      {
        l2 = -9223372036854775807L;
        k = 0;
      }
      int j = i;
      if (i < m)
      {
        j = Character.digit(paramBufferedReader[i], 10);
        if (j >= 0)
        {
          l1 = -j;
          j = i + 1;
        }
        else
        {
          throw new ParseException("Unexpected non-digit character");
        }
      }
      while (j < m)
      {
        i = Character.digit(paramBufferedReader[j], 10);
        if (i >= 0)
        {
          if (l1 >= -922337203685477580L)
          {
            l1 *= 10L;
            long l3 = i;
            if (l1 >= l2 + l3)
            {
              l1 -= l3;
              j += 1;
            }
            else
            {
              throw new ParseException("Number too large");
            }
          }
          else
          {
            throw new ParseException("Number too large");
          }
        }
        else {
          throw new ParseException("Unexpected non-digit character");
        }
      }
      if (k != 0)
      {
        if (j > 1) {
          return l1;
        }
        throw new ParseException("No digits to parse");
      }
      return -l1;
    }
    throw new ParseException("No number to parse");
  }
  
  private final BigInteger zaf(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zaa(paramBufferedReader, this.zaqd);
    if (i == 0) {
      return null;
    }
    return new BigInteger(new String(this.zaqd, 0, i));
  }
  
  private final float zag(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zaa(paramBufferedReader, this.zaqd);
    if (i == 0) {
      return 0.0F;
    }
    return Float.parseFloat(new String(this.zaqd, 0, i));
  }
  
  private final double zah(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zaa(paramBufferedReader, this.zaqd);
    if (i == 0) {
      return 0.0D;
    }
    return Double.parseDouble(new String(this.zaqd, 0, i));
  }
  
  private final BigDecimal zai(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zaa(paramBufferedReader, this.zaqd);
    if (i == 0) {
      return null;
    }
    return new BigDecimal(new String(this.zaqd, 0, i));
  }
  
  private final char zaj(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    if (paramBufferedReader.read(this.zaqb) == -1) {
      return '\000';
    }
    while (Character.isWhitespace(this.zaqb[0])) {
      if (paramBufferedReader.read(this.zaqb) == -1) {
        return '\000';
      }
    }
    return this.zaqb[0];
  }
  
  private final void zak(int paramInt)
    throws FastParser.ParseException
  {
    if (!this.zaqm.isEmpty())
    {
      int i = ((Integer)this.zaqm.pop()).intValue();
      if (i == paramInt) {
        return;
      }
      localStringBuilder = new StringBuilder(46);
      localStringBuilder.append("Expected state ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" but had ");
      localStringBuilder.append(i);
      throw new ParseException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder(46);
    localStringBuilder.append("Expected state ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" but had empty stack");
    throw new ParseException(localStringBuilder.toString());
  }
  
  /* Error */
  public void parse(java.io.InputStream paramInputStream, T paramT)
    throws FastParser.ParseException
  {
    // Byte code:
    //   0: new 148	java/io/BufferedReader
    //   3: dup
    //   4: new 516	java/io/InputStreamReader
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 519	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: sipush 1024
    //   15: invokespecial 522	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 129	com/google/android/gms/common/server/response/FastParser:zaqm	Ljava/util/Stack;
    //   23: iconst_0
    //   24: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: invokevirtual 193	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: pop
    //   31: aload_0
    //   32: aload_1
    //   33: invokespecial 142	com/google/android/gms/common/server/response/FastParser:zaj	(Ljava/io/BufferedReader;)C
    //   36: istore_3
    //   37: iload_3
    //   38: ifeq +185 -> 223
    //   41: iload_3
    //   42: bipush 91
    //   44: if_icmpeq +66 -> 110
    //   47: iload_3
    //   48: bipush 123
    //   50: if_icmpne +25 -> 75
    //   53: aload_0
    //   54: getfield 129	com/google/android/gms/common/server/response/FastParser:zaqm	Ljava/util/Stack;
    //   57: iconst_1
    //   58: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: invokevirtual 193	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: pop
    //   65: aload_0
    //   66: aload_1
    //   67: aload_2
    //   68: invokespecial 233	com/google/android/gms/common/server/response/FastParser:zaa	(Ljava/io/BufferedReader;Lcom/google/android/gms/common/server/response/FastJsonResponse;)Z
    //   71: pop
    //   72: goto +119 -> 191
    //   75: new 117	java/lang/StringBuilder
    //   78: dup
    //   79: bipush 19
    //   81: invokespecial 120	java/lang/StringBuilder:<init>	(I)V
    //   84: astore_2
    //   85: aload_2
    //   86: ldc -58
    //   88: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_2
    //   93: iload_3
    //   94: invokevirtual 205	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: new 7	com/google/android/gms/common/server/response/FastParser$ParseException
    //   101: dup
    //   102: aload_2
    //   103: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokespecial 173	com/google/android/gms/common/server/response/FastParser$ParseException:<init>	(Ljava/lang/String;)V
    //   109: athrow
    //   110: aload_0
    //   111: getfield 129	com/google/android/gms/common/server/response/FastParser:zaqm	Ljava/util/Stack;
    //   114: iconst_5
    //   115: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: invokevirtual 193	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: aload_2
    //   123: invokevirtual 264	com/google/android/gms/common/server/response/FastJsonResponse:getFieldMappings	()Ljava/util/Map;
    //   126: astore 4
    //   128: aload 4
    //   130: invokeinterface 525 1 0
    //   135: iconst_1
    //   136: if_icmpne +76 -> 212
    //   139: aload 4
    //   141: invokeinterface 529 1 0
    //   146: invokeinterface 535 1 0
    //   151: invokeinterface 540 1 0
    //   156: checkcast 542	java/util/Map$Entry
    //   159: invokeinterface 545 1 0
    //   164: checkcast 226	com/google/android/gms/common/server/response/FastJsonResponse$Field
    //   167: astore 4
    //   169: aload_0
    //   170: aload_1
    //   171: aload 4
    //   173: invokespecial 296	com/google/android/gms/common/server/response/FastParser:zaa	(Ljava/io/BufferedReader;Lcom/google/android/gms/common/server/response/FastJsonResponse$Field;)Ljava/util/ArrayList;
    //   176: astore 5
    //   178: aload_2
    //   179: aload 4
    //   181: aload 4
    //   183: getfield 290	com/google/android/gms/common/server/response/FastJsonResponse$Field:zapv	Ljava/lang/String;
    //   186: aload 5
    //   188: invokevirtual 294	com/google/android/gms/common/server/response/FastJsonResponse:addConcreteTypeArrayInternal	(Lcom/google/android/gms/common/server/response/FastJsonResponse$Field;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   191: aload_0
    //   192: iconst_0
    //   193: invokespecial 196	com/google/android/gms/common/server/response/FastParser:zak	(I)V
    //   196: aload_1
    //   197: invokevirtual 548	java/io/BufferedReader:close	()V
    //   200: return
    //   201: ldc_w 550
    //   204: ldc_w 552
    //   207: invokestatic 558	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   210: pop
    //   211: return
    //   212: new 7	com/google/android/gms/common/server/response/FastParser$ParseException
    //   215: dup
    //   216: ldc_w 560
    //   219: invokespecial 173	com/google/android/gms/common/server/response/FastParser$ParseException:<init>	(Ljava/lang/String;)V
    //   222: athrow
    //   223: new 7	com/google/android/gms/common/server/response/FastParser$ParseException
    //   226: dup
    //   227: ldc_w 562
    //   230: invokespecial 173	com/google/android/gms/common/server/response/FastParser$ParseException:<init>	(Ljava/lang/String;)V
    //   233: athrow
    //   234: astore_2
    //   235: goto +13 -> 248
    //   238: astore_2
    //   239: new 7	com/google/android/gms/common/server/response/FastParser$ParseException
    //   242: dup
    //   243: aload_2
    //   244: invokespecial 565	com/google/android/gms/common/server/response/FastParser$ParseException:<init>	(Ljava/lang/Throwable;)V
    //   247: athrow
    //   248: aload_1
    //   249: invokevirtual 548	java/io/BufferedReader:close	()V
    //   252: goto +13 -> 265
    //   255: ldc_w 550
    //   258: ldc_w 552
    //   261: invokestatic 558	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   264: pop
    //   265: aload_2
    //   266: athrow
    //   267: astore_1
    //   268: goto -67 -> 201
    //   271: astore_1
    //   272: goto -17 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	FastParser
    //   0	275	1	paramInputStream	java.io.InputStream
    //   0	275	2	paramT	T
    //   36	58	3	c	char
    //   126	56	4	localObject	Object
    //   176	11	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   19	37	234	finally
    //   53	72	234	finally
    //   75	110	234	finally
    //   110	191	234	finally
    //   191	196	234	finally
    //   212	223	234	finally
    //   223	234	234	finally
    //   239	248	234	finally
    //   19	37	238	java/io/IOException
    //   53	72	238	java/io/IOException
    //   75	110	238	java/io/IOException
    //   110	191	238	java/io/IOException
    //   191	196	238	java/io/IOException
    //   212	223	238	java/io/IOException
    //   223	234	238	java/io/IOException
    //   196	200	267	java/io/IOException
    //   248	252	271	java/io/IOException
  }
  
  public static class ParseException
    extends Exception
  {
    public ParseException(String paramString)
    {
      super();
    }
    
    public ParseException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    public ParseException(Throwable paramThrowable)
    {
      super();
    }
  }
  
  private static abstract interface zaa<O>
  {
    public abstract O zah(FastParser paramFastParser, BufferedReader paramBufferedReader)
      throws FastParser.ParseException, IOException;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\server\response\FastParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */