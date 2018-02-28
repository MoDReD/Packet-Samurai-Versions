package com.aionemu.packetsamurai.parser.valuereader;

import java.sql.Timestamp;
import com.aionemu.packetsamurai.parser.datatree.IntValuePart;
import com.aionemu.packetsamurai.parser.datatree.ValuePart;

public class UnixDateReader extends TimeReader 
{
	@SuppressWarnings("deprecation")
	@Override
	public String read(ValuePart part) 
	{
        if (!(part instanceof IntValuePart))
            return "";

        long result = ((IntValuePart) part).getIntValue();
        return new Timestamp(result * 1000).toGMTString();
	}
}
