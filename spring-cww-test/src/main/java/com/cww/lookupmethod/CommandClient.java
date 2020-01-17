package com.cww.lookupmethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandClient {

	@Autowired
	CommandManager tomCommandManager;

	public void execute() {
		tomCommandManager.process();
	}

}
