/*
 * This file is part of aion-engine <aion-engine.net>
 *
 * aion-engine is private software: you can redistribute it and or modify
 * it under the terms of the GNU Lesser Public License as published by
 * the Private Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * aion-engine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser Public License for more details.
 *
 * You should have received a copy of the GNU Lesser Public License
 * along with aion-engine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.aionemu.packetsamurai.crypt;

/**
 *
 * @author Magenik
 */
public class AionGame4_5_0_15Crypter extends AionGameCrypter {

	@Override
	int decodeOpcodec(int op) {
		return (op ^ 0xDD) - 0xCC;
	}

	@Override
	byte getStaticServerPacketCode() {
		return 0x46;
	}

	@Override
	byte getStaticClientPacketCode() {
		return 0x65;
	}
}
