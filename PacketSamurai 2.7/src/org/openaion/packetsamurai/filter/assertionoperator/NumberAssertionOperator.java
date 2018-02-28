package org.openaion.packetsamurai.filter.assertionoperator;


import org.openaion.packetsamurai.filter.value.number.NumberValue;
import org.openaion.packetsamurai.parser.DataStructure;

/**
 * 
 * @author Gilles Duboscq
 *
 */
public interface NumberAssertionOperator extends AssertionOperator
{
    public boolean execute(NumberValue value1, NumberValue value2, DataStructure dp);
}