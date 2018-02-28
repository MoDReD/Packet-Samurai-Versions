package com.aionemu.packetsamurai.parser.datatree;

import com.aionemu.packetsamurai.parser.formattree.AbstractSwitchPart;
import com.aionemu.packetsamurai.parser.formattree.SwitchCaseBlock;

public class DataSwitchBlock extends DataTreeNodeContainer
{
    private ValuePart _testValuePart;
    
    //avoids construction of root SwitchBlock
    @SuppressWarnings("unused")
    private DataSwitchBlock()
    {
        
    }
    
    public DataSwitchBlock(DataTreeNodeContainer container, SwitchCaseBlock part, ValuePart vp)
    {
        super(container, part);
        _testValuePart = vp;
    }
    
    @Override
    public String treeString()
    {
        SwitchCaseBlock block = (SwitchCaseBlock) this.getModelPart();
        AbstractSwitchPart part = block.getContainingSwitch();
        if(block.isDefault())
            return "Switch on '"+part.getTestPart().getName()+"' - default case";
        return "Switch on '"+part.getTestPart().getName()+"' - case '"+this.getTestValuePart().readValue()+"'";
    }
    
    public ValuePart getTestValuePart()
    {
        return _testValuePart;
    }
}