package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.agreement.srp.SRP6VerifierGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.SRP6GroupParameters;
import org.bouncycastle.util.Strings;

public class SimulatedTlsSRPIdentityManager
  implements TlsSRPIdentityManager
{
  private static final byte[] PREFIX_PASSWORD = Strings.toByteArray("password");
  private static final byte[] PREFIX_SALT = Strings.toByteArray("salt");
  protected SRP6GroupParameters group;
  protected Mac mac;
  protected SRP6VerifierGenerator verifierGenerator;
  
  public SimulatedTlsSRPIdentityManager(SRP6GroupParameters paramSRP6GroupParameters, SRP6VerifierGenerator paramSRP6VerifierGenerator, Mac paramMac)
  {
    this.group = paramSRP6GroupParameters;
    this.verifierGenerator = paramSRP6VerifierGenerator;
    this.mac = paramMac;
  }
  
  public static SimulatedTlsSRPIdentityManager getRFC5054Default(SRP6GroupParameters paramSRP6GroupParameters, byte[] paramArrayOfByte)
  {
    SRP6VerifierGenerator localSRP6VerifierGenerator = new SRP6VerifierGenerator();
    localSRP6VerifierGenerator.init(paramSRP6GroupParameters, TlsUtils.createHash((short)2));
    HMac localHMac = new HMac(TlsUtils.createHash((short)2));
    localHMac.init(new KeyParameter(paramArrayOfByte));
    return new SimulatedTlsSRPIdentityManager(paramSRP6GroupParameters, localSRP6VerifierGenerator, localHMac);
  }
  
  public TlsSRPLoginParameters getLoginParameters(byte[] paramArrayOfByte)
  {
    Object localObject1 = this.mac;
    Object localObject2 = PREFIX_SALT;
    ((Mac)localObject1).update((byte[])localObject2, 0, localObject2.length);
    this.mac.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    localObject1 = new byte[this.mac.getMacSize()];
    this.mac.doFinal((byte[])localObject1, 0);
    localObject2 = this.mac;
    byte[] arrayOfByte = PREFIX_PASSWORD;
    ((Mac)localObject2).update(arrayOfByte, 0, arrayOfByte.length);
    this.mac.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    localObject2 = new byte[this.mac.getMacSize()];
    this.mac.doFinal((byte[])localObject2, 0);
    paramArrayOfByte = this.verifierGenerator.generateVerifier((byte[])localObject1, paramArrayOfByte, (byte[])localObject2);
    return new TlsSRPLoginParameters(this.group, paramArrayOfByte, (byte[])localObject1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\SimulatedTlsSRPIdentityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */