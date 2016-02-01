package com.ug.cyberCafe.service;

import java.util.List;

import com.ug.cyberCafe.domain.Terminal;

public interface TerminalService {
	
	Terminal getTerminalById(long id);

	void addTerminal(Terminal terminal);

	void updateTerminal(Terminal terminal);

	void deleteTerminal(Terminal terminal);

	List<Terminal> getAllTerminals();

}
