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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javolution.util.FastList;
import javolution.util.FastMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.aionemu.packetsamurai.PacketSamurai;
import com.aionemu.packetsamurai.parser.datatree.ValuePart;
import com.aionemu.packetsamurai.session.DataPacket;
import com.sun.org.apache.xpath.internal.XPathAPI;

/**
 * @author Magenik
 */
public class NpcTestExporter
{
	private List<DataPacket> packets;
	private String sessionName;	
	private FastList<NpcSpawn> spawns = new FastList<NpcSpawn>();
	private int worldId = -1;

	public NpcTestExporter(List<DataPacket> packets, String sessionName)
	{
		this.packets = new FastList<DataPacket>(packets);
		this.sessionName = sessionName;
	}

	public void parse()
	{
		String filename = "npc_test_" + sessionName + ".xml";
		Long start = System.currentTimeMillis();

		try
		{			

			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			
			// Collect info about all seen NPCs
			for (DataPacket packet : packets)
			{
				String packetName = packet.getName();
				if ("SM_PLAYER_SPAWN".equals(packetName))
					this.worldId = Integer.parseInt(packet.getValuePartList().get(1).readValue());
				else if ("SM_NPC_INFO".equals(packetName))
				{
					NpcSpawn spawn = new NpcSpawn();
					FastList<ValuePart> valuePartList = new FastList<ValuePart>(packet.getValuePartList());
					
					for (ValuePart valuePart : valuePartList)
					{
						String partName = valuePart.getModelPart().getName();
						if ("x".equals(partName))
							spawn.x = Float.parseFloat(valuePart.readValue());
						else if ("y".equals(partName))
							spawn.y = Float.parseFloat(valuePart.readValue());
						else if ("z".equals(partName))
							spawn.z = Float.parseFloat(valuePart.readValue());
						else if ("npcId".equals(partName))
							spawn.npcId = Integer.parseInt(valuePart.readValue());
						else if("npcTemplateNameId".equals(partName))
						{
							try 
							{
								spawn.npcTemplateNameId = Integer.parseInt(valuePart.getValueAsString());
								spawn.npcName = valuePart.readValue();
							}
							catch (Exception e)
							{
								System.out.println(e);
							}
						}
						else if ("npcHeading".equals(partName))
							spawn.npcHeading = Byte.parseByte(valuePart.readValue());
						else if ("spawnStaticId".equals(partName))
							spawn.spawnStaticId = Integer.parseInt(valuePart.readValue());
						else if ("objectId".equals(partName))
							spawn.objectId = Long.parseLong(valuePart.readValue());
						spawn.worldId = this.worldId;
					}
					boolean exists = false;
					for (NpcSpawn n : spawns)
						if (n.objectId == spawn.objectId)
							exists = true;
					if (!exists)
						spawns.add(spawn);
				}
			}

			for (NpcSpawn n : spawns)
			{
				StringBuilder sb = new StringBuilder();
				sb.append("<npc_template npc_id=\"");
				sb.append(n.npcId);
				sb.append("\" name=\"");
				sb.append(n.npcName);
				sb.append("\" x=\"");
				sb.append(n.x);
				sb.append("\" y=\"");
				sb.append(n.y);
				sb.append("\" z=\"");
				sb.append(n.z);
				sb.append("\" npcHeading=\"");
				sb.append(n.npcHeading);
				sb.append("\" />\n");
				
				out.write(sb.toString());
			}
			out.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		PacketSamurai.getUserInterface().log("NPC Test IDs Has Been Written Successful");
	}

	class NpcSpawn
	{
		float x;
		float y;
		float z;
		byte npcHeading;
		int npcId;
		int worldId;
		long objectId;
		int spawnStaticId;
		String npcName;
		int npcTemplateNameId;
		int npcTemplateTitleId;
		byte level;
	}
}
