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

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.aionemu.packetsamurai.PacketSamurai;
import com.aionemu.packetsamurai.parser.datatree.ValuePart;
import com.aionemu.packetsamurai.session.DataPacket;

/**
 * @Original author ATracer - Kamui
 */

/**
 * @author editor Magenik
 */

public class NpcTitleExporter
{
	private List<DataPacket> packets;
	private String sessionName;
	private SortedMap<String, String> npcIdTitleMap = new TreeMap<String, String>();

	public NpcTitleExporter(List<DataPacket> packets, String sessionName) 
	{
		super();
		this.packets = packets;
		this.sessionName = sessionName;
	}

	public void parse()
	{
		String fileName = "npc_titles_" + sessionName + ".xml";

		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

			for(DataPacket packet : packets)
			{
				String name = packet.getName();
				if("SM_NPC_INFO".equals(name))
				{
					String npcId = "";
					String npcTemplateTitleId = "";

					List<ValuePart> valuePartList = packet.getValuePartList();

					for(ValuePart valuePart : valuePartList)
					{
						String partName = valuePart.getModelPart().getName();
						if("npcId".equals(partName))
						{
							npcId = valuePart.readValue();
						}
						else if("npcTemplateTitleId".equals(partName))
						{
							npcTemplateTitleId = valuePart.readValue();
						}
					}
					if(!"0".equals(npcTemplateTitleId))
					{
						npcIdTitleMap.put(npcId, npcTemplateTitleId);
					}
				}
			}

			out.write("<titles>\n");

			for(Entry<String, String> entry : npcIdTitleMap.entrySet())
			{
				StringBuilder sb = new StringBuilder();
				sb.append("<info npcid=\"");
				sb.append(entry.getKey());
				sb.append("\" title_id=\"");
				sb.append(entry.getValue());
				sb.append("\" />\n");
				out.write(sb.toString());
			}

			out.write("</titles>");

			out.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		PacketSamurai.getUserInterface().log("NPC Titles Has Been Written Successful");
	}
}
