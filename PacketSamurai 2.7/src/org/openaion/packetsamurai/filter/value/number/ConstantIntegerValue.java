package org.openaion.packetsamurai.filter.value.number;

import org.openaion.packetsamurai.parser.DataStructure;

/**
 * 
 * @author Gilles Duboscq
 *
 */
public class ConstantIntegerValue extends IntegerNumberValue
{
    private long _value;
    
    public ConstantIntegerValue(long val)
    {
        _value = val;
    }
    
    @Override
    public long getIntegerValue(DataStructure dp)
    {
        return _value;
    }
    
}