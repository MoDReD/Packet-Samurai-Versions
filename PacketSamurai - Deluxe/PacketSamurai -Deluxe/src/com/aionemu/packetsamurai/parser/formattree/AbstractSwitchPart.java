package com.aionemu.packetsamurai.parser.formattree;

import java.util.List;
import java.util.Map;

import javolution.util.FastList;
import javolution.util.FastMap;

import com.aionemu.packetsamurai.parser.PartType;

/**
 * @author Gilles Duboscq
 * @author Nemesiss
 *
 */
public abstract class AbstractSwitchPart extends Part
{
    private int switchId;
    SwitchCaseBlock _default;
    Map<Integer, SwitchCaseBlock> casesMap = new FastMap<Integer,SwitchCaseBlock>();

    public AbstractSwitchPart(int id, String analyzerName) 
    {
        super(PartType.swicthBlock, -1, "SwitchPart", "","", analyzerName);
        this.setSwitchId(id);
    }

    public void setSwitchId(int id)
    {
        switchId = id;
        if(this.getContainingFormat() != null)
            this.getContainingFormat().triggerFormatChanged();
    }

    public int getSwitchId()
    {
        return switchId;
    }

    /**
     * switches can not have an id
     */
    public int getId()
    {
        return -1;
    }

    public boolean removeCase(SwitchCaseBlock sCase)
    {
        return removeCase(sCase.getSwitchCase());
    }

    public void setDefaultCase(SwitchCaseBlock dcase)
    {
        dcase.setParentContainer(this.getParentContainer()); // this can NOT be root
        dcase.setContainingFormat(this.getContainingFormat());
        dcase.setDefault(true);
        _default = dcase;
        if(this.getContainingFormat() != null)
            this.getContainingFormat().triggerFormatChanged();
    }

    public SwitchCaseBlock getDefaultCase()
    {
        return _default;
    }
    
    @Override
    public void setParentContainer(PartContainer pc)
    {
        super.setParentContainer(pc);
        for(SwitchCaseBlock block : getCases())
        {
            block.setParentContainer(pc);
        }
    }

    @Override
    public void setContainingFormat(Format format)
    {
        super.setContainingFormat(format);
        for(SwitchCaseBlock block : getCases())
        {
            block.setContainingFormat(format);
        }
    }

    public List<SwitchCaseBlock> getCases(boolean includeDefault)
    {
        List<SwitchCaseBlock> cases = getCases();
        if(includeDefault && _default != null)
            cases.add(_default);
        return cases;
    }

    public String treeString()
    {
        Part pp = getTestPart();
        if (pp != null)
        {
            return "Switch.. : "+pp.getName();
        }
        return "Switch..";
    }

    public Part getTestPart()
    {
    	return this.getParentContainer().getPacketPartByIdInScope(this.getSwitchId(),this);
    }

    public List<SwitchCaseBlock> getCases()
    {
        FastList<SwitchCaseBlock> cases = new FastList<SwitchCaseBlock>();
        cases.addAll(casesMap.values());
        return cases;
    }

    public void addCase(SwitchCaseBlock iCase)
    {
        iCase.setParentContainer(this.getParentContainer()); // this can NOT be root
        iCase.setContainingFormat(this.getContainingFormat());
    	if(iCase.isDefault())
    		_default = iCase;
    	else
    		casesMap.put(iCase.getSwitchCase(), iCase);
        if(this.getContainingFormat() != null)
            this.getContainingFormat().triggerFormatChanged();
    }

    public boolean removeCase(int switchCase)
    {
        if(casesMap.remove(new Integer(switchCase)) != null)
        {
            if(this.getContainingFormat() != null)
                this.getContainingFormat().triggerFormatChanged();
            return true;
        }
        if(getDefaultCase().getSwitchCase() == switchCase)
        {
            _default = null;
            if(this.getContainingFormat() != null)
                this.getContainingFormat().triggerFormatChanged();
            return true;
        }
        return false;
    }

	public abstract List<SwitchCaseBlock> getCases(int switchCase);
}
