package org.openaion.packetsamurai.filter.booleanoperator;

import java.util.List;

import org.openaion.packetsamurai.filter.Condition;
import org.openaion.packetsamurai.parser.DataStructure;




/**
 * 
 * @author Gilles Duboscq
 *
 */
public class AndOperator implements BooleanOperator
{

    public boolean execute(List<Condition> conditions, DataStructure dp)
    {
        for(Condition cond : conditions)
        {
            if(!cond.evaluate(dp))
                return false;
        }
        return true;
    }
    
}