package com.aionemu.packetsamurai.parser.formattree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nemesiss
 * @author Rolandas
 */
public class BitwiseSwitchPart extends AbstractSwitchPart {

	public BitwiseSwitchPart(int id, String analyzerName) {
		super(id, analyzerName);
	}

	@Override
	public List<SwitchCaseBlock> getCases(int switchCase) {
		List<SwitchCaseBlock> result = new ArrayList<SwitchCaseBlock>();

		for (SwitchCaseBlock scb : casesMap.values()) {
			if ((scb.getSwitchCase() & switchCase) != 0) {
				result.add(scb);
				break;
			}
		}

		if (result.size() == 0) {
			if (_default == null)
				return result;
			result.add(_default);
		}

		return result;
	}
}
