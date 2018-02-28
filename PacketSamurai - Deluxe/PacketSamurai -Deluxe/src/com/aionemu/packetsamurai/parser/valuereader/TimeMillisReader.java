package com.aionemu.packetsamurai.parser.valuereader;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

import com.aionemu.packetsamurai.parser.datatree.IntValuePart;
import com.aionemu.packetsamurai.parser.datatree.ValuePart;

public class TimeMillisReader extends TimeReader 
{
    @Override
    public String read(ValuePart part)  
    {
        if (!(part instanceof IntValuePart))
            return "";

        long result = ((IntValuePart) part).getIntValue();
        Duration duration = null;
		try 
		{
			duration = DatatypeFactory.newInstance().newDuration(result);
			SimpleDateFormat formatter =  new SimpleDateFormat("HH:mm:ss");
			Date date = formatter.parse(duration.getHours() + ":" + duration.getMinutes() + ":" + duration.getSeconds());
			return formatter.format(date);
		} 
		catch (Exception e) 
		{
		}
		return "";
    }
}
