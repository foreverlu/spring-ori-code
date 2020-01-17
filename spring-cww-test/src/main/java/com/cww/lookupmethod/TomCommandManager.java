package com.cww.lookupmethod;

import org.springframework.stereotype.Service;

@Service
public class TomCommandManager extends CommandManager {

	@Override
	protected Command CreateCommand() {
		Command command = new Command();
		command.name = "tom";
		return command;
	}
}
