package org.openaion.packetsamurai.filter.assertionoperator;


import org.openaion.packetsamurai.filter.value.string.StringValue;
import org.openaion.packetsamurai.parser.DataStructure;

/**
 * 
 * @author Gilles Duboscq
 *
 */
public interface StringAssertionOperator extends AssertionOperator
{
    public boolean execute(StringValue value1, StringValue value2, DataStructure dp);
}