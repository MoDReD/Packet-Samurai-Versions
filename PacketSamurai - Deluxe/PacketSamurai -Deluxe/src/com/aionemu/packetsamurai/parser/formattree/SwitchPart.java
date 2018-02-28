package com.aionemu.packetsamurai.parser.formattree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Gilles Duboscq
 *
 */
public class SwitchPart extends AbstractSwitchPart
{
    public SwitchPart(int id, String analyzerName) 
    {
    	super(id, analyzerName);
    }

    @Override
    public List<SwitchCaseBlock> getCases(int switchCase)
    {
        SwitchCaseBlock c = casesMap.get(switchCase);
        if(c == null)
        {
            if(_default == null)
            	return Collections.emptyList();
            c = _default;
        }
        return Arrays.asList(c);
    }
}