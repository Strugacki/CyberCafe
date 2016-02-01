package com.ug.cyberCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.dao.TerminalDao;
import com.ug.cyberCafe.domain.Terminal;

@Service("terminalService")
@Transactional
public class TerminalServiceImpl implements TerminalService{

	@Autowired
	TerminalDao terminalDao;
	
	@Override
	public Terminal getTerminalById(long id) {
		return terminalDao.getTerminalById(id);
	}

	@Override
	public void addTerminal(Terminal terminal) {
		terminalDao.addTerminal(terminal);
	}

	@Override
	public void updateTerminal(Terminal terminal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTerminal(Terminal terminal) {
		terminalDao.deleteTerminal(terminal);
	}

	@Override
	public List<Terminal> getAllTerminals() {
		return terminalDao.getAllTerminals();
	}

}
