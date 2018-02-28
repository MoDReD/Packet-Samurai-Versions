package org.openaion.packetsamurai.filter.value.number;

import org.openaion.packetsamurai.parser.DataStructure;

/**
 * 
 * @author Gilles Duboscq
 *
 */
public abstract class IntegerNumberValue extends NumberValue
{
    public abstract long getIntegerValue(DataStructure dp);
}