package org.openaion.packetsamurai.filter.value.string;


import org.openaion.packetsamurai.filter.value.Value;
import org.openaion.packetsamurai.parser.DataStructure;

/**
 * 
 * @author Gilles Duboscq
 *
 */
public abstract class StringValue extends Value
{
    public abstract String getStringValue(DataStructure dp);
}