package com.cww.lookupmethod;

import org.springframework.beans.factory.annotation.Lookup;

public abstract class CommandManager {

	public void process(){
		Command command = CreateCommand();
		command.printName();
	}

	@Lookup
	protected abstract Command CreateCommand();
}
