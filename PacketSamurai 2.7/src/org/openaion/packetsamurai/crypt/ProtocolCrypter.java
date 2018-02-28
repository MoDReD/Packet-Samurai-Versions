package org.openaion.packetsamurai.crypt;


import org.openaion.packetsamurai.protocol.Protocol;
import org.openaion.packetsamurai.protocol.protocoltree.PacketFamilly.packetDirection;

/**
 * This interface is used to interface with all the different protocol encryptions
 * @author Gilles Duboscq
 *
 */
public interface ProtocolCrypter
{
	/**
	 * this decrypts the packet, the data provided must be only one full packet
	 * @param raw
	 * @return
	 */
	public boolean decrypt(byte[] raw, packetDirection dir);
    
    public void setProtocol(Protocol protocol);
}