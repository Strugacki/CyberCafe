package com.ug.cyberCafe.dao;

import java.util.List;

import com.ug.cyberCafe.domain.Terminal;

public interface TerminalDao {

    void addTerminal(Terminal terminal);
    
    void deleteTerminalById(int id);
     
    List<Terminal> getAllTerminals();
 
    Terminal getTerminalById(int id);
	
}
