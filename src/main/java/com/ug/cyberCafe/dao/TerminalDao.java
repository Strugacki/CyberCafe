package com.ug.cyberCafe.dao;

import java.util.List;

import com.ug.cyberCafe.domain.Terminal;

public interface TerminalDao {

    void addTerminal(Terminal terminal);
    
    void deleteTerminal(Terminal terminal);
     
    List<Terminal> getAllTerminals();
 
    Terminal getTerminalById(long id);
    
    void updateTerminal(Terminal terminal);
	
}
