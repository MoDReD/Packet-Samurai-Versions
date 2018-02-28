package org.openaion.packetsamurai.filter.booleanoperator;

import java.util.List;

import org.openaion.packetsamurai.filter.Condition;
import org.openaion.packetsamurai.parser.DataStructure;




/**
 * 
 * @author Gilles Duboscq
 *
 */
public interface BooleanOperator
{
    public boolean execute(List<Condition> conditions, DataStructure dp);
}