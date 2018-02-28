package org.openaion.packetsamurai.parser.parttypes;


import org.openaion.packetsamurai.parser.PartType;
import org.openaion.packetsamurai.parser.datatree.DataTreeNodeContainer;
import org.openaion.packetsamurai.parser.datatree.FloatValuePart;
import org.openaion.packetsamurai.parser.datatree.ValuePart;
import org.openaion.packetsamurai.parser.formattree.Part;

/**
 * 
 * @author Gilles Duboscq
 *
 */
public class FloatPartType extends PartType
{

    public FloatPartType(String name)
    {
        super(name);
    }

    @Override
    public ValuePart getValuePart(DataTreeNodeContainer parent, Part part)
    {
        return new FloatValuePart(parent, part);
    }

    @Override
    public boolean isBlockType()
    {
        return false;
    }

    @Override
    public boolean isReadableType()
    {
        return true;
    }

    @Override
    public int getTypeByteNumber()
    {
        return 4;
    }
    
}