package org.bouncycastle.asn1.x509;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Strings;

public class PKIXNameConstraintValidator
  implements NameConstraintValidator
{
  private Set excludedSubtreesDN = new HashSet();
  private Set excludedSubtreesDNS = new HashSet();
  private Set excludedSubtreesEmail = new HashSet();
  private Set excludedSubtreesIP = new HashSet();
  private Set excludedSubtreesURI = new HashSet();
  private Set permittedSubtreesDN;
  private Set permittedSubtreesDNS;
  private Set permittedSubtreesEmail;
  private Set permittedSubtreesIP;
  private Set permittedSubtreesURI;
  
  private void checkExcludedDN(Set paramSet, ASN1Sequence paramASN1Sequence)
    throws NameConstraintValidatorException
  {
    if (paramSet.isEmpty()) {
      return;
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      if (withinDNSubtree(paramASN1Sequence, (ASN1Sequence)paramSet.next())) {
        throw new NameConstraintValidatorException("Subject distinguished name is from an excluded subtree");
      }
    }
  }
  
  private void checkExcludedDN(X500Name paramX500Name)
    throws NameConstraintValidatorException
  {
    checkExcludedDN(this.excludedSubtreesDN, ASN1Sequence.getInstance(paramX500Name));
  }
  
  private void checkExcludedDNS(Set paramSet, String paramString)
    throws NameConstraintValidatorException
  {
    if (paramSet.isEmpty()) {
      return;
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if ((withinDomain(paramString, str)) || (paramString.equalsIgnoreCase(str))) {
        throw new NameConstraintValidatorException("DNS is from an excluded subtree.");
      }
    }
  }
  
  private void checkExcludedEmail(Set paramSet, String paramString)
    throws NameConstraintValidatorException
  {
    if (paramSet.isEmpty()) {
      return;
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      if (emailIsConstrained(paramString, (String)paramSet.next())) {
        throw new NameConstraintValidatorException("Email address is from an excluded subtree.");
      }
    }
  }
  
  private void checkExcludedIP(Set paramSet, byte[] paramArrayOfByte)
    throws NameConstraintValidatorException
  {
    if (paramSet.isEmpty()) {
      return;
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      if (isIPConstrained(paramArrayOfByte, (byte[])paramSet.next())) {
        throw new NameConstraintValidatorException("IP is from an excluded subtree.");
      }
    }
  }
  
  private void checkExcludedURI(Set paramSet, String paramString)
    throws NameConstraintValidatorException
  {
    if (paramSet.isEmpty()) {
      return;
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      if (isUriConstrained(paramString, (String)paramSet.next())) {
        throw new NameConstraintValidatorException("URI is from an excluded subtree.");
      }
    }
  }
  
  private void checkPermittedDN(Set paramSet, ASN1Sequence paramASN1Sequence)
    throws NameConstraintValidatorException
  {
    if (paramSet == null) {
      return;
    }
    if ((paramSet.isEmpty()) && (paramASN1Sequence.size() == 0)) {
      return;
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      if (withinDNSubtree(paramASN1Sequence, (ASN1Sequence)paramSet.next())) {
        return;
      }
    }
    throw new NameConstraintValidatorException("Subject distinguished name is not from a permitted subtree");
  }
  
  private void checkPermittedDN(X500Name paramX500Name)
    throws NameConstraintValidatorException
  {
    checkPermittedDN(this.permittedSubtreesDN, ASN1Sequence.getInstance(paramX500Name.toASN1Primitive()));
  }
  
  private void checkPermittedDNS(Set paramSet, String paramString)
    throws NameConstraintValidatorException
  {
    if (paramSet == null) {
      return;
    }
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((withinDomain(paramString, str)) || (paramString.equalsIgnoreCase(str))) {
        return;
      }
    }
    if ((paramString.length() == 0) && (paramSet.size() == 0)) {
      return;
    }
    throw new NameConstraintValidatorException("DNS is not from a permitted subtree.");
  }
  
  private void checkPermittedEmail(Set paramSet, String paramString)
    throws NameConstraintValidatorException
  {
    if (paramSet == null) {
      return;
    }
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext()) {
      if (emailIsConstrained(paramString, (String)localIterator.next())) {
        return;
      }
    }
    if ((paramString.length() == 0) && (paramSet.size() == 0)) {
      return;
    }
    throw new NameConstraintValidatorException("Subject email address is not from a permitted subtree.");
  }
  
  private void checkPermittedIP(Set paramSet, byte[] paramArrayOfByte)
    throws NameConstraintValidatorException
  {
    if (paramSet == null) {
      return;
    }
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext()) {
      if (isIPConstrained(paramArrayOfByte, (byte[])localIterator.next())) {
        return;
      }
    }
    if ((paramArrayOfByte.length == 0) && (paramSet.size() == 0)) {
      return;
    }
    throw new NameConstraintValidatorException("IP is not from a permitted subtree.");
  }
  
  private void checkPermittedURI(Set paramSet, String paramString)
    throws NameConstraintValidatorException
  {
    if (paramSet == null) {
      return;
    }
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext()) {
      if (isUriConstrained(paramString, (String)localIterator.next())) {
        return;
      }
    }
    if ((paramString.length() == 0) && (paramSet.size() == 0)) {
      return;
    }
    throw new NameConstraintValidatorException("URI is not from a permitted subtree.");
  }
  
  private boolean collectionsAreEqual(Collection paramCollection1, Collection paramCollection2)
  {
    if (paramCollection1 == paramCollection2) {
      return true;
    }
    if (paramCollection1 != null)
    {
      if (paramCollection2 == null) {
        return false;
      }
      if (paramCollection1.size() != paramCollection2.size()) {
        return false;
      }
      paramCollection1 = paramCollection1.iterator();
      while (paramCollection1.hasNext())
      {
        Object localObject = paramCollection1.next();
        Iterator localIterator = paramCollection2.iterator();
        while (localIterator.hasNext()) {
          if (equals(localObject, localIterator.next()))
          {
            i = 1;
            break label99;
          }
        }
        int i = 0;
        label99:
        if (i == 0) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private static int compareTo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (Arrays.areEqual(paramArrayOfByte1, paramArrayOfByte2)) {
      return 0;
    }
    if (Arrays.areEqual(max(paramArrayOfByte1, paramArrayOfByte2), paramArrayOfByte1)) {
      return 1;
    }
    return -1;
  }
  
  private boolean emailIsConstrained(String paramString1, String paramString2)
  {
    String str = paramString1.substring(paramString1.indexOf('@') + 1);
    if (paramString2.indexOf('@') != -1)
    {
      if (paramString1.equalsIgnoreCase(paramString2)) {
        return true;
      }
    }
    else if (paramString2.charAt(0) != '.')
    {
      if (str.equalsIgnoreCase(paramString2)) {
        return true;
      }
    }
    else if (withinDomain(str, paramString2)) {
      return true;
    }
    return false;
  }
  
  private boolean equals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if ((paramObject1 != null) && (paramObject2 != null))
    {
      if (((paramObject1 instanceof byte[])) && ((paramObject2 instanceof byte[]))) {
        return Arrays.areEqual((byte[])paramObject1, (byte[])paramObject2);
      }
      return paramObject1.equals(paramObject2);
    }
    return false;
  }
  
  private static String extractHostFromURL(String paramString)
  {
    String str = paramString.substring(paramString.indexOf(':') + 1);
    paramString = str;
    if (str.indexOf("//") != -1) {
      paramString = str.substring(str.indexOf("//") + 2);
    }
    str = paramString;
    if (paramString.lastIndexOf(':') != -1) {
      str = paramString.substring(0, paramString.lastIndexOf(':'));
    }
    paramString = str.substring(str.indexOf(':') + 1);
    str = paramString.substring(paramString.indexOf('@') + 1);
    paramString = str;
    if (str.indexOf('/') != -1) {
      paramString = str.substring(0, str.indexOf('/'));
    }
    return paramString;
  }
  
  private byte[][] extractIPsAndSubnetMasks(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = paramArrayOfByte1.length / 2;
    byte[] arrayOfByte1 = new byte[i];
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte1, 0, i);
    System.arraycopy(paramArrayOfByte1, i, arrayOfByte2, 0, i);
    paramArrayOfByte1 = new byte[i];
    byte[] arrayOfByte3 = new byte[i];
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, i);
    System.arraycopy(paramArrayOfByte2, i, arrayOfByte3, 0, i);
    return new byte[][] { arrayOfByte1, arrayOfByte2, paramArrayOfByte1, arrayOfByte3 };
  }
  
  private String extractNameAsString(GeneralName paramGeneralName)
  {
    return DERIA5String.getInstance(paramGeneralName.getName()).getString();
  }
  
  private int hashCollection(Collection paramCollection)
  {
    int i = 0;
    if (paramCollection == null) {
      return 0;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      int j;
      if ((localObject instanceof byte[])) {
        j = Arrays.hashCode((byte[])localObject);
      } else {
        j = localObject.hashCode();
      }
      i += j;
    }
    return i;
  }
  
  private Set intersectDN(Set paramSet1, Set paramSet2)
  {
    HashSet localHashSet = new HashSet();
    paramSet2 = paramSet2.iterator();
    while (paramSet2.hasNext())
    {
      ASN1Sequence localASN1Sequence1 = ASN1Sequence.getInstance(((GeneralSubtree)paramSet2.next()).getBase().getName().toASN1Primitive());
      if (paramSet1 == null)
      {
        if (localASN1Sequence1 != null) {
          localHashSet.add(localASN1Sequence1);
        }
      }
      else
      {
        Iterator localIterator = paramSet1.iterator();
        while (localIterator.hasNext())
        {
          ASN1Sequence localASN1Sequence2 = (ASN1Sequence)localIterator.next();
          if (withinDNSubtree(localASN1Sequence1, localASN1Sequence2)) {
            localHashSet.add(localASN1Sequence1);
          } else if (withinDNSubtree(localASN1Sequence2, localASN1Sequence1)) {
            localHashSet.add(localASN1Sequence2);
          }
        }
      }
    }
    return localHashSet;
  }
  
  private Set intersectDNS(Set paramSet1, Set paramSet2)
  {
    HashSet localHashSet = new HashSet();
    paramSet2 = paramSet2.iterator();
    while (paramSet2.hasNext())
    {
      String str1 = extractNameAsString(((GeneralSubtree)paramSet2.next()).getBase());
      if (paramSet1 == null)
      {
        if (str1 != null) {
          localHashSet.add(str1);
        }
      }
      else
      {
        Iterator localIterator = paramSet1.iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          if (withinDomain(str2, str1)) {
            localHashSet.add(str2);
          } else if (withinDomain(str1, str2)) {
            localHashSet.add(str1);
          }
        }
      }
    }
    return localHashSet;
  }
  
  private Set intersectEmail(Set paramSet1, Set paramSet2)
  {
    HashSet localHashSet = new HashSet();
    paramSet2 = paramSet2.iterator();
    while (paramSet2.hasNext())
    {
      String str = extractNameAsString(((GeneralSubtree)paramSet2.next()).getBase());
      if (paramSet1 == null)
      {
        if (str != null) {
          localHashSet.add(str);
        }
      }
      else
      {
        Iterator localIterator = paramSet1.iterator();
        while (localIterator.hasNext()) {
          intersectEmail(str, (String)localIterator.next(), localHashSet);
        }
      }
    }
    return localHashSet;
  }
  
  private void intersectEmail(String paramString1, String paramString2, Set paramSet)
  {
    if (paramString1.indexOf('@') != -1)
    {
      String str = paramString1.substring(paramString1.indexOf('@') + 1);
      if (paramString2.indexOf('@') != -1)
      {
        if (!paramString1.equalsIgnoreCase(paramString2)) {
          return;
        }
      }
      else if (paramString2.startsWith("."))
      {
        if (!withinDomain(str, paramString2)) {
          return;
        }
      }
      else if (!str.equalsIgnoreCase(paramString2)) {
        return;
      }
    }
    else
    {
      if (paramString1.startsWith(".")) {
        if (paramString2.indexOf('@') != -1) {
          if (!withinDomain(paramString2.substring(paramString1.indexOf('@') + 1), paramString1)) {
            return;
          }
        }
      }
      for (;;)
      {
        break label171;
        if (paramString2.startsWith("."))
        {
          if ((withinDomain(paramString1, paramString2)) || (paramString1.equalsIgnoreCase(paramString2))) {
            break label241;
          }
          if (!withinDomain(paramString2, paramString1)) {
            return;
          }
        }
        else if (!withinDomain(paramString2, paramString1))
        {
          return;
        }
        label171:
        paramSet.add(paramString2);
        return;
        if (paramString2.indexOf('@') == -1) {
          break;
        }
        if (!paramString2.substring(paramString2.indexOf('@') + 1).equalsIgnoreCase(paramString1)) {
          return;
        }
      }
      if (paramString2.startsWith(".") ? !withinDomain(paramString1, paramString2) : !paramString1.equalsIgnoreCase(paramString2)) {
        return;
      }
    }
    label241:
    paramSet.add(paramString1);
  }
  
  private Set intersectIP(Set paramSet1, Set paramSet2)
  {
    HashSet localHashSet = new HashSet();
    paramSet2 = paramSet2.iterator();
    while (paramSet2.hasNext())
    {
      byte[] arrayOfByte = ASN1OctetString.getInstance(((GeneralSubtree)paramSet2.next()).getBase().getName()).getOctets();
      if (paramSet1 == null)
      {
        if (arrayOfByte != null) {
          localHashSet.add(arrayOfByte);
        }
      }
      else
      {
        Iterator localIterator = paramSet1.iterator();
        while (localIterator.hasNext()) {
          localHashSet.addAll(intersectIPRange((byte[])localIterator.next(), arrayOfByte));
        }
      }
    }
    return localHashSet;
  }
  
  private Set intersectIPRange(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
      return Collections.EMPTY_SET;
    }
    paramArrayOfByte2 = extractIPsAndSubnetMasks(paramArrayOfByte1, paramArrayOfByte2);
    byte b1 = paramArrayOfByte2[0];
    paramArrayOfByte1 = paramArrayOfByte2[1];
    byte b2 = paramArrayOfByte2[2];
    paramArrayOfByte2 = paramArrayOfByte2[3];
    byte[][] arrayOfByte = minMaxIPs(b1, paramArrayOfByte1, b2, paramArrayOfByte2);
    byte[] arrayOfByte1 = min(arrayOfByte[1], arrayOfByte[3]);
    if (compareTo(max(arrayOfByte[0], arrayOfByte[2]), arrayOfByte1) == 1) {
      return Collections.EMPTY_SET;
    }
    return Collections.singleton(ipWithSubnetMask(or(arrayOfByte[0], arrayOfByte[2]), or(paramArrayOfByte1, paramArrayOfByte2)));
  }
  
  private Set intersectURI(Set paramSet1, Set paramSet2)
  {
    HashSet localHashSet = new HashSet();
    paramSet2 = paramSet2.iterator();
    while (paramSet2.hasNext())
    {
      String str = extractNameAsString(((GeneralSubtree)paramSet2.next()).getBase());
      if (paramSet1 == null)
      {
        if (str != null) {
          localHashSet.add(str);
        }
      }
      else
      {
        Iterator localIterator = paramSet1.iterator();
        while (localIterator.hasNext()) {
          intersectURI((String)localIterator.next(), str, localHashSet);
        }
      }
    }
    return localHashSet;
  }
  
  private void intersectURI(String paramString1, String paramString2, Set paramSet)
  {
    if (paramString1.indexOf('@') != -1)
    {
      String str = paramString1.substring(paramString1.indexOf('@') + 1);
      if (paramString2.indexOf('@') != -1)
      {
        if (!paramString1.equalsIgnoreCase(paramString2)) {
          return;
        }
      }
      else if (paramString2.startsWith("."))
      {
        if (!withinDomain(str, paramString2)) {
          return;
        }
      }
      else if (!str.equalsIgnoreCase(paramString2)) {
        return;
      }
    }
    else
    {
      if (paramString1.startsWith(".")) {
        if (paramString2.indexOf('@') != -1) {
          if (!withinDomain(paramString2.substring(paramString1.indexOf('@') + 1), paramString1)) {
            return;
          }
        }
      }
      for (;;)
      {
        break label171;
        if (paramString2.startsWith("."))
        {
          if ((withinDomain(paramString1, paramString2)) || (paramString1.equalsIgnoreCase(paramString2))) {
            break label241;
          }
          if (!withinDomain(paramString2, paramString1)) {
            return;
          }
        }
        else if (!withinDomain(paramString2, paramString1))
        {
          return;
        }
        label171:
        paramSet.add(paramString2);
        return;
        if (paramString2.indexOf('@') == -1) {
          break;
        }
        if (!paramString2.substring(paramString2.indexOf('@') + 1).equalsIgnoreCase(paramString1)) {
          return;
        }
      }
      if (paramString2.startsWith(".") ? !withinDomain(paramString1, paramString2) : !paramString1.equalsIgnoreCase(paramString2)) {
        return;
      }
    }
    label241:
    paramSet.add(paramString1);
  }
  
  private byte[] ipWithSubnetMask(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = paramArrayOfByte1.length;
    byte[] arrayOfByte = new byte[i * 2];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, i);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i, i);
    return arrayOfByte;
  }
  
  private boolean isIPConstrained(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = paramArrayOfByte1.length;
    int k = paramArrayOfByte2.length / 2;
    int i = 0;
    if (j != k) {
      return false;
    }
    byte[] arrayOfByte1 = new byte[j];
    System.arraycopy(paramArrayOfByte2, j, arrayOfByte1, 0, j);
    byte[] arrayOfByte2 = new byte[j];
    byte[] arrayOfByte3 = new byte[j];
    while (i < j)
    {
      arrayOfByte2[i] = ((byte)(paramArrayOfByte2[i] & arrayOfByte1[i]));
      arrayOfByte3[i] = ((byte)(paramArrayOfByte1[i] & arrayOfByte1[i]));
      i += 1;
    }
    return Arrays.areEqual(arrayOfByte2, arrayOfByte3);
  }
  
  private boolean isUriConstrained(String paramString1, String paramString2)
  {
    paramString1 = extractHostFromURL(paramString1);
    if (!paramString2.startsWith("."))
    {
      if (paramString1.equalsIgnoreCase(paramString2)) {
        return true;
      }
    }
    else if (withinDomain(paramString1, paramString2)) {
      return true;
    }
    return false;
  }
  
  private static byte[] max(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      if ((paramArrayOfByte1[i] & 0xFFFF) > (0xFFFF & paramArrayOfByte2[i])) {
        return paramArrayOfByte1;
      }
      i += 1;
    }
    return paramArrayOfByte2;
  }
  
  private static byte[] min(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      if ((paramArrayOfByte1[i] & 0xFFFF) < (0xFFFF & paramArrayOfByte2[i])) {
        return paramArrayOfByte1;
      }
      i += 1;
    }
    return paramArrayOfByte2;
  }
  
  private byte[][] minMaxIPs(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    int j = paramArrayOfByte1.length;
    byte[] arrayOfByte1 = new byte[j];
    byte[] arrayOfByte2 = new byte[j];
    byte[] arrayOfByte3 = new byte[j];
    byte[] arrayOfByte4 = new byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] & paramArrayOfByte2[i]));
      arrayOfByte2[i] = ((byte)(paramArrayOfByte1[i] & paramArrayOfByte2[i] | paramArrayOfByte2[i]));
      arrayOfByte3[i] = ((byte)(paramArrayOfByte3[i] & paramArrayOfByte4[i]));
      arrayOfByte4[i] = ((byte)(paramArrayOfByte3[i] & paramArrayOfByte4[i] | paramArrayOfByte4[i]));
      i += 1;
    }
    return new byte[][] { arrayOfByte1, arrayOfByte2, arrayOfByte3, arrayOfByte4 };
  }
  
  private static byte[] or(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte1[i] | paramArrayOfByte2[i]));
      i += 1;
    }
    return arrayOfByte;
  }
  
  private String stringifyIP(byte[] paramArrayOfByte)
  {
    String str = "";
    int i = 0;
    while (i < paramArrayOfByte.length / 2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(Integer.toString(paramArrayOfByte[i] & 0xFF));
      localStringBuilder.append(".");
      str = localStringBuilder.toString();
      i += 1;
    }
    str = str.substring(0, str.length() - 1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/");
    str = localStringBuilder.toString();
    i = paramArrayOfByte.length / 2;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(Integer.toString(paramArrayOfByte[i] & 0xFF));
      localStringBuilder.append(".");
      str = localStringBuilder.toString();
      i += 1;
    }
    return str.substring(0, str.length() - 1);
  }
  
  private String stringifyIPCollection(Set paramSet)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append("[");
    localObject = ((StringBuilder)localObject).toString();
    Iterator localIterator = paramSet.iterator();
    for (paramSet = (Set)localObject; localIterator.hasNext(); paramSet = ((StringBuilder)localObject).toString())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramSet);
      ((StringBuilder)localObject).append(stringifyIP((byte[])localIterator.next()));
      ((StringBuilder)localObject).append(",");
    }
    localObject = paramSet;
    if (paramSet.length() > 1) {
      localObject = paramSet.substring(0, paramSet.length() - 1);
    }
    paramSet = new StringBuilder();
    paramSet.append((String)localObject);
    paramSet.append("]");
    return paramSet.toString();
  }
  
  private Set unionDN(Set paramSet, ASN1Sequence paramASN1Sequence)
  {
    if (paramSet.isEmpty())
    {
      if (paramASN1Sequence == null) {
        return paramSet;
      }
      paramSet.add(paramASN1Sequence);
      return paramSet;
    }
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ASN1Sequence localASN1Sequence = (ASN1Sequence)paramSet.next();
      if (withinDNSubtree(paramASN1Sequence, localASN1Sequence))
      {
        localHashSet.add(localASN1Sequence);
      }
      else
      {
        if (!withinDNSubtree(localASN1Sequence, paramASN1Sequence)) {
          localHashSet.add(localASN1Sequence);
        }
        localHashSet.add(paramASN1Sequence);
      }
    }
    return localHashSet;
  }
  
  private Set unionDNS(Set paramSet, String paramString)
  {
    if (paramSet.isEmpty())
    {
      if (paramString == null) {
        return paramSet;
      }
      paramSet.add(paramString);
      return paramSet;
    }
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (withinDomain(str, paramString)) {}
      boolean bool;
      do
      {
        localHashSet.add(paramString);
        break;
        bool = withinDomain(paramString, str);
        localHashSet.add(str);
      } while (!bool);
    }
    return localHashSet;
  }
  
  private Set unionEmail(Set paramSet, String paramString)
  {
    if (paramSet.isEmpty())
    {
      if (paramString == null) {
        return paramSet;
      }
      paramSet.add(paramString);
      return paramSet;
    }
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      unionEmail((String)paramSet.next(), paramString, localHashSet);
    }
    return localHashSet;
  }
  
  private void unionEmail(String paramString1, String paramString2, Set paramSet)
  {
    if (paramString1.indexOf('@') != -1)
    {
      String str = paramString1.substring(paramString1.indexOf('@') + 1);
      if (paramString2.indexOf('@') != -1)
      {
        if (!paramString1.equalsIgnoreCase(paramString2)) {
          break label244;
        }
        break label235;
      }
      if (paramString2.startsWith(".")) {
        if (!withinDomain(str, paramString2)) {
          break label244;
        }
      } else {
        if (!str.equalsIgnoreCase(paramString2)) {
          break label244;
        }
      }
    }
    else
    {
      if (paramString1.startsWith("."))
      {
        if (paramString2.indexOf('@') != -1)
        {
          if (!withinDomain(paramString2.substring(paramString1.indexOf('@') + 1), paramString1)) {
            break label244;
          }
          break label235;
        }
        if (paramString2.startsWith("."))
        {
          if ((withinDomain(paramString1, paramString2)) || (paramString1.equalsIgnoreCase(paramString2))) {
            break label252;
          }
          if (!withinDomain(paramString2, paramString1)) {
            break label244;
          }
          break label235;
        }
        if (!withinDomain(paramString2, paramString1)) {
          break label244;
        }
        break label235;
      }
      if (paramString2.indexOf('@') != -1)
      {
        if (!paramString2.substring(paramString1.indexOf('@') + 1).equalsIgnoreCase(paramString1)) {
          break label244;
        }
        break label235;
      }
      if (!paramString2.startsWith(".")) {
        break label227;
      }
      if (!withinDomain(paramString1, paramString2)) {
        break label244;
      }
    }
    break label252;
    label227:
    if (paramString1.equalsIgnoreCase(paramString2))
    {
      label235:
      paramSet.add(paramString1);
      return;
    }
    label244:
    paramSet.add(paramString1);
    label252:
    paramSet.add(paramString2);
  }
  
  private Set unionIP(Set paramSet, byte[] paramArrayOfByte)
  {
    if (paramSet.isEmpty())
    {
      if (paramArrayOfByte == null) {
        return paramSet;
      }
      paramSet.add(paramArrayOfByte);
      return paramSet;
    }
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localHashSet.addAll(unionIPRange((byte[])paramSet.next(), paramArrayOfByte));
    }
    return localHashSet;
  }
  
  private Set unionIPRange(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    HashSet localHashSet = new HashSet();
    boolean bool = Arrays.areEqual(paramArrayOfByte1, paramArrayOfByte2);
    localHashSet.add(paramArrayOfByte1);
    if (bool) {
      return localHashSet;
    }
    localHashSet.add(paramArrayOfByte2);
    return localHashSet;
  }
  
  private Set unionURI(Set paramSet, String paramString)
  {
    if (paramSet.isEmpty())
    {
      if (paramString == null) {
        return paramSet;
      }
      paramSet.add(paramString);
      return paramSet;
    }
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      unionURI((String)paramSet.next(), paramString, localHashSet);
    }
    return localHashSet;
  }
  
  private void unionURI(String paramString1, String paramString2, Set paramSet)
  {
    if (paramString1.indexOf('@') != -1)
    {
      String str = paramString1.substring(paramString1.indexOf('@') + 1);
      if (paramString2.indexOf('@') != -1)
      {
        if (!paramString1.equalsIgnoreCase(paramString2)) {
          break label244;
        }
        break label235;
      }
      if (paramString2.startsWith(".")) {
        if (!withinDomain(str, paramString2)) {
          break label244;
        }
      } else {
        if (!str.equalsIgnoreCase(paramString2)) {
          break label244;
        }
      }
    }
    else
    {
      if (paramString1.startsWith("."))
      {
        if (paramString2.indexOf('@') != -1)
        {
          if (!withinDomain(paramString2.substring(paramString1.indexOf('@') + 1), paramString1)) {
            break label244;
          }
          break label235;
        }
        if (paramString2.startsWith("."))
        {
          if ((withinDomain(paramString1, paramString2)) || (paramString1.equalsIgnoreCase(paramString2))) {
            break label252;
          }
          if (!withinDomain(paramString2, paramString1)) {
            break label244;
          }
          break label235;
        }
        if (!withinDomain(paramString2, paramString1)) {
          break label244;
        }
        break label235;
      }
      if (paramString2.indexOf('@') != -1)
      {
        if (!paramString2.substring(paramString1.indexOf('@') + 1).equalsIgnoreCase(paramString1)) {
          break label244;
        }
        break label235;
      }
      if (!paramString2.startsWith(".")) {
        break label227;
      }
      if (!withinDomain(paramString1, paramString2)) {
        break label244;
      }
    }
    break label252;
    label227:
    if (paramString1.equalsIgnoreCase(paramString2))
    {
      label235:
      paramSet.add(paramString1);
      return;
    }
    label244:
    paramSet.add(paramString1);
    label252:
    paramSet.add(paramString2);
  }
  
  private static boolean withinDNSubtree(ASN1Sequence paramASN1Sequence1, ASN1Sequence paramASN1Sequence2)
  {
    if (paramASN1Sequence2.size() < 1) {
      return false;
    }
    if (paramASN1Sequence2.size() > paramASN1Sequence1.size()) {
      return false;
    }
    int i = paramASN1Sequence2.size() - 1;
    while (i >= 0)
    {
      if (!paramASN1Sequence2.getObjectAt(i).equals(paramASN1Sequence1.getObjectAt(i))) {
        return false;
      }
      i -= 1;
    }
    return true;
  }
  
  private boolean withinDomain(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2.startsWith(".")) {
      str = paramString2.substring(1);
    }
    paramString2 = Strings.split(str, '.');
    paramString1 = Strings.split(paramString1, '.');
    if (paramString1.length <= paramString2.length) {
      return false;
    }
    int j = paramString1.length - paramString2.length;
    int i = -1;
    while (i < paramString2.length)
    {
      if (i == -1)
      {
        if (paramString1[(i + j)].equals("")) {
          return false;
        }
      }
      else if (!paramString2[i].equalsIgnoreCase(paramString1[(i + j)])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void addExcludedSubtree(GeneralSubtree paramGeneralSubtree)
  {
    paramGeneralSubtree = paramGeneralSubtree.getBase();
    int i = paramGeneralSubtree.getTagNo();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i != 6)
          {
            if (i != 7) {
              return;
            }
            this.excludedSubtreesIP = unionIP(this.excludedSubtreesIP, ASN1OctetString.getInstance(paramGeneralSubtree.getName()).getOctets());
            return;
          }
          this.excludedSubtreesURI = unionURI(this.excludedSubtreesURI, extractNameAsString(paramGeneralSubtree));
          return;
        }
        this.excludedSubtreesDN = unionDN(this.excludedSubtreesDN, (ASN1Sequence)paramGeneralSubtree.getName().toASN1Primitive());
        return;
      }
      this.excludedSubtreesDNS = unionDNS(this.excludedSubtreesDNS, extractNameAsString(paramGeneralSubtree));
      return;
    }
    this.excludedSubtreesEmail = unionEmail(this.excludedSubtreesEmail, extractNameAsString(paramGeneralSubtree));
  }
  
  public void checkExcluded(GeneralName paramGeneralName)
    throws NameConstraintValidatorException
  {
    int i = paramGeneralName.getTagNo();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i != 6)
          {
            if (i != 7) {
              return;
            }
            paramGeneralName = ASN1OctetString.getInstance(paramGeneralName.getName()).getOctets();
            checkExcludedIP(this.excludedSubtreesIP, paramGeneralName);
            return;
          }
          checkExcludedURI(this.excludedSubtreesURI, DERIA5String.getInstance(paramGeneralName.getName()).getString());
          return;
        }
        checkExcludedDN(X500Name.getInstance(paramGeneralName.getName()));
        return;
      }
      checkExcludedDNS(this.excludedSubtreesDNS, DERIA5String.getInstance(paramGeneralName.getName()).getString());
      return;
    }
    checkExcludedEmail(this.excludedSubtreesEmail, extractNameAsString(paramGeneralName));
  }
  
  public void checkPermitted(GeneralName paramGeneralName)
    throws NameConstraintValidatorException
  {
    int i = paramGeneralName.getTagNo();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i != 6)
          {
            if (i != 7) {
              return;
            }
            paramGeneralName = ASN1OctetString.getInstance(paramGeneralName.getName()).getOctets();
            checkPermittedIP(this.permittedSubtreesIP, paramGeneralName);
            return;
          }
          checkPermittedURI(this.permittedSubtreesURI, DERIA5String.getInstance(paramGeneralName.getName()).getString());
          return;
        }
        checkPermittedDN(X500Name.getInstance(paramGeneralName.getName()));
        return;
      }
      checkPermittedDNS(this.permittedSubtreesDNS, DERIA5String.getInstance(paramGeneralName.getName()).getString());
      return;
    }
    checkPermittedEmail(this.permittedSubtreesEmail, extractNameAsString(paramGeneralName));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof PKIXNameConstraintValidator;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (PKIXNameConstraintValidator)paramObject;
    bool1 = bool2;
    if (collectionsAreEqual(((PKIXNameConstraintValidator)paramObject).excludedSubtreesDN, this.excludedSubtreesDN))
    {
      bool1 = bool2;
      if (collectionsAreEqual(((PKIXNameConstraintValidator)paramObject).excludedSubtreesDNS, this.excludedSubtreesDNS))
      {
        bool1 = bool2;
        if (collectionsAreEqual(((PKIXNameConstraintValidator)paramObject).excludedSubtreesEmail, this.excludedSubtreesEmail))
        {
          bool1 = bool2;
          if (collectionsAreEqual(((PKIXNameConstraintValidator)paramObject).excludedSubtreesIP, this.excludedSubtreesIP))
          {
            bool1 = bool2;
            if (collectionsAreEqual(((PKIXNameConstraintValidator)paramObject).excludedSubtreesURI, this.excludedSubtreesURI))
            {
              bool1 = bool2;
              if (collectionsAreEqual(((PKIXNameConstraintValidator)paramObject).permittedSubtreesDN, this.permittedSubtreesDN))
              {
                bool1 = bool2;
                if (collectionsAreEqual(((PKIXNameConstraintValidator)paramObject).permittedSubtreesDNS, this.permittedSubtreesDNS))
                {
                  bool1 = bool2;
                  if (collectionsAreEqual(((PKIXNameConstraintValidator)paramObject).permittedSubtreesEmail, this.permittedSubtreesEmail))
                  {
                    bool1 = bool2;
                    if (collectionsAreEqual(((PKIXNameConstraintValidator)paramObject).permittedSubtreesIP, this.permittedSubtreesIP))
                    {
                      bool1 = bool2;
                      if (collectionsAreEqual(((PKIXNameConstraintValidator)paramObject).permittedSubtreesURI, this.permittedSubtreesURI)) {
                        bool1 = true;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return hashCollection(this.excludedSubtreesDN) + hashCollection(this.excludedSubtreesDNS) + hashCollection(this.excludedSubtreesEmail) + hashCollection(this.excludedSubtreesIP) + hashCollection(this.excludedSubtreesURI) + hashCollection(this.permittedSubtreesDN) + hashCollection(this.permittedSubtreesDNS) + hashCollection(this.permittedSubtreesEmail) + hashCollection(this.permittedSubtreesIP) + hashCollection(this.permittedSubtreesURI);
  }
  
  public void intersectEmptyPermittedSubtree(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 6)
          {
            if (paramInt != 7) {
              return;
            }
            this.permittedSubtreesIP = new HashSet();
            return;
          }
          this.permittedSubtreesURI = new HashSet();
          return;
        }
        this.permittedSubtreesDN = new HashSet();
        return;
      }
      this.permittedSubtreesDNS = new HashSet();
      return;
    }
    this.permittedSubtreesEmail = new HashSet();
  }
  
  public void intersectPermittedSubtree(GeneralSubtree paramGeneralSubtree)
  {
    intersectPermittedSubtree(new GeneralSubtree[] { paramGeneralSubtree });
  }
  
  public void intersectPermittedSubtree(GeneralSubtree[] paramArrayOfGeneralSubtree)
  {
    Object localObject = new HashMap();
    int i = 0;
    while (i != paramArrayOfGeneralSubtree.length)
    {
      GeneralSubtree localGeneralSubtree = paramArrayOfGeneralSubtree[i];
      Integer localInteger = Integers.valueOf(localGeneralSubtree.getBase().getTagNo());
      if (((Map)localObject).get(localInteger) == null) {
        ((Map)localObject).put(localInteger, new HashSet());
      }
      ((Set)((Map)localObject).get(localInteger)).add(localGeneralSubtree);
      i += 1;
    }
    paramArrayOfGeneralSubtree = ((Map)localObject).entrySet().iterator();
    while (paramArrayOfGeneralSubtree.hasNext())
    {
      localObject = (Map.Entry)paramArrayOfGeneralSubtree.next();
      i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 4)
          {
            if (i != 6)
            {
              if (i == 7) {
                this.permittedSubtreesIP = intersectIP(this.permittedSubtreesIP, (Set)((Map.Entry)localObject).getValue());
              }
            }
            else {
              this.permittedSubtreesURI = intersectURI(this.permittedSubtreesURI, (Set)((Map.Entry)localObject).getValue());
            }
          }
          else {
            this.permittedSubtreesDN = intersectDN(this.permittedSubtreesDN, (Set)((Map.Entry)localObject).getValue());
          }
        }
        else {
          this.permittedSubtreesDNS = intersectDNS(this.permittedSubtreesDNS, (Set)((Map.Entry)localObject).getValue());
        }
      }
      else {
        this.permittedSubtreesEmail = intersectEmail(this.permittedSubtreesEmail, (Set)((Map.Entry)localObject).getValue());
      }
    }
  }
  
  public String toString()
  {
    Object localObject2 = this.permittedSubtreesDN;
    Object localObject1 = "permitted:\n";
    if (localObject2 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("permitted:\n");
      ((StringBuilder)localObject1).append("DN:\n");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.permittedSubtreesDN.toString());
      ((StringBuilder)localObject2).append("\n");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    localObject2 = localObject1;
    if (this.permittedSubtreesDNS != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("DNS:\n");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.permittedSubtreesDNS.toString());
      ((StringBuilder)localObject2).append("\n");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (this.permittedSubtreesEmail != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("Email:\n");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.permittedSubtreesEmail.toString());
      ((StringBuilder)localObject2).append("\n");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    localObject2 = localObject1;
    if (this.permittedSubtreesURI != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("URI:\n");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.permittedSubtreesURI.toString());
      ((StringBuilder)localObject2).append("\n");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (this.permittedSubtreesIP != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("IP:\n");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(stringifyIPCollection(this.permittedSubtreesIP));
      ((StringBuilder)localObject2).append("\n");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("excluded:\n");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (!this.excludedSubtreesDN.isEmpty())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("DN:\n");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.excludedSubtreesDN.toString());
      ((StringBuilder)localObject2).append("\n");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    localObject2 = localObject1;
    if (!this.excludedSubtreesDNS.isEmpty())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("DNS:\n");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.excludedSubtreesDNS.toString());
      ((StringBuilder)localObject2).append("\n");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (!this.excludedSubtreesEmail.isEmpty())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("Email:\n");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.excludedSubtreesEmail.toString());
      ((StringBuilder)localObject2).append("\n");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    localObject2 = localObject1;
    if (!this.excludedSubtreesURI.isEmpty())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("URI:\n");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.excludedSubtreesURI.toString());
      ((StringBuilder)localObject2).append("\n");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (!this.excludedSubtreesIP.isEmpty())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("IP:\n");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(stringifyIPCollection(this.excludedSubtreesIP));
      ((StringBuilder)localObject2).append("\n");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    return (String)localObject1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\PKIXNameConstraintValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */