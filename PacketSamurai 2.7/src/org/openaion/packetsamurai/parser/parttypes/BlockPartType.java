package org.openaion.packetsamurai.parser.parttypes;


import org.openaion.packetsamurai.parser.PartType;
import org.openaion.packetsamurai.parser.datatree.DataTreeNodeContainer;
import org.openaion.packetsamurai.parser.datatree.ValuePart;
import org.openaion.packetsamurai.parser.formattree.Part;

/**
 * 
 * @author Gilles Duboscq
 *
 */
public class BlockPartType extends PartType
{
    public enum blockType
    {
        forblock,
        switchblock,
        block
    }

    private blockType _type;

    public BlockPartType(String name, blockType type)
    {
        super(name);
        _type = type;
    }

    @Override
    public ValuePart getValuePart(DataTreeNodeContainer parent, Part part)
    {
        return null;
    }

    @Override
    public boolean isBlockType()
    {
        return true;
    }

    @Override
    public boolean isReadableType()
    {
        return false;
    }
    
    public blockType getType()
    {
        return _type;
    }

    @Override
    public int getTypeByteNumber()
    {
        return -1;
    }

}
