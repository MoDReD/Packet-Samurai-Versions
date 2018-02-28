package org.openaion.packetsamurai.crypt;


import org.openaion.packetsamurai.protocol.Protocol;
import org.openaion.packetsamurai.protocol.protocoltree.PacketFamilly.packetDirection;

/**
 * 
 * @author Gilles Duboscq
 *
 */
public class NullCrypter implements ProtocolCrypter
{

	public boolean decrypt(byte[] raw, packetDirection dir)
	{
		return true;
	}

    public void setProtocol(Protocol protocol)
    {
        
    }
}