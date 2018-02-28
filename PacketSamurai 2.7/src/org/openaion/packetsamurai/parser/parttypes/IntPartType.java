package org.openaion.packetsamurai.parser.parttypes;


import org.openaion.packetsamurai.parser.PartType;
import org.openaion.packetsamurai.parser.datatree.DataTreeNodeContainer;
import org.openaion.packetsamurai.parser.datatree.IntValuePart;
import org.openaion.packetsamurai.parser.datatree.ValuePart;
import org.openaion.packetsamurai.parser.formattree.Part;

/**
 * 
 * @author Gilles Duboscq
 *
 */
public class IntPartType extends PartType
{
    public enum intType
    {
        c,
        h,
        d
    }
    
    intType _type;

    public IntPartType(String name, intType type)
    {
        super(name);
        _type = type;
    }

    @Override
    public ValuePart getValuePart(DataTreeNodeContainer parent, Part part)
    {
        return new IntValuePart(parent, part, _type);
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
        switch(_type)
        {
            case c:
                return 1;
            case h:
                return 2;
            case d:
                return 4;
        }
        return 0; //useless
    }
    
}