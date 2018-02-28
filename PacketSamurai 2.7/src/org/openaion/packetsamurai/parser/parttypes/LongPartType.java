package org.openaion.packetsamurai.parser.parttypes;


import org.openaion.packetsamurai.parser.PartType;
import org.openaion.packetsamurai.parser.datatree.DataTreeNodeContainer;
import org.openaion.packetsamurai.parser.datatree.LongValuePart;
import org.openaion.packetsamurai.parser.datatree.ValuePart;
import org.openaion.packetsamurai.parser.formattree.Part;

/**
 * 
 * @author Gilles Duboscq
 *
 */
public class LongPartType extends PartType
{
    public LongPartType(String name)
    {
        super(name);
    }

    @Override
    public ValuePart getValuePart(DataTreeNodeContainer parent, Part part)
    {
        return new LongValuePart(parent, part);
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
        return 8;
    }

}
