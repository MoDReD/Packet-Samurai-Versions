/*
 * This file is part of aion-engine <aion-engine.net>
 *
 *   aion-engine is private software: you can redistribute it and or modify
 *   it under the terms of the GNU Lesser Public License as published by
 *   the Private Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   aion-engine is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Lesser Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser Public License
 *   along with aion-engine.  If not, see <http://www.gnu.org/licenses/>.
 */


package com.aionemu.packetsamurai.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javolution.util.FastList;

import com.aionemu.packetsamurai.PacketSamurai;
import com.aionemu.packetsamurai.parser.datatree.ValuePart;
import com.aionemu.packetsamurai.session.DataPacket;

/**
 * @author Magenik
 */

public class NpcPositionExporter
{
	private List<DataPacket> packets;
	private String sessionName;
	private FastList<NpcInfo> npcInfoList = new FastList<NpcInfo>();

	public NpcPositionExporter(List<DataPacket> packets, String sessionName) 
	{
		super();
		this.packets = packets;
		this.sessionName = sessionName;
	}

	public void parse()
	{
		String fileName = "npc_position_" + sessionName + ".xml";

		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

			for(DataPacket packet : packets)
			{
				String name = packet.getName();
				if("SM_NPC_INFO".equals(name))
				{
					List<ValuePart> valuePartList = packet.getValuePartList();
					NpcInfo npc = new NpcInfo();

					for(ValuePart valuePart : valuePartList)
					{
						String partName = valuePart.getModelPart().getName();
						if("npcId".equals(partName))
						{
							npc.npcId = Integer.parseInt(valuePart.readValue());
						}
						else if("x".equals(partName)) 
						{
							npc.x = Float.parseFloat(valuePart.readValue());
						}
						else if("y".equals(partName)) 
						{
							npc.y = Float.parseFloat(valuePart.readValue());
						}
						else if("z".equals(partName)) 
						{
							npc.z = Float.parseFloat(valuePart.readValue());
						}
						else if("npcHeading".equals(partName))
						{
							npc.npcHeading = Integer.parseInt(valuePart.readValue());
						}
					}
					npcInfoList.add(npc);
				}
			}

			for(NpcInfo npc : npcInfoList)
			{
				StringBuilder sb = new StringBuilder();
				sb.append("<info npcid=\"");
				sb.append(npc.npcId);
				sb.append("\" x=\"");
				sb.append(npc.x);
				sb.append("\" y=\"");
				sb.append(npc.y);
				sb.append("\" z=\"");
				sb.append(npc.z);
				sb.append("\" heading=\"");
				sb.append(npc.npcHeading);
				sb.append("\" />\n");
				out.write(sb.toString());
			}
			out.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		PacketSamurai.getUserInterface().log("NPC Positions Has Been Written Successful");
	}

	class NpcInfo
	{
		int npcId;
		float x;
		float y;
		float z;
		int npcHeading;
	}
}
