package com.ug.cyberCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.dao.TerminalDao;
import com.ug.cyberCafe.domain.Terminal;

@Service
@Transactional
public class TerminalServiceImpl implements TerminalService{

	@Autowired
	TerminalDao dao;
	
	@Override
	public Terminal getTerminalById(long id) {
		return dao.getTerminalById(id);
	}

	@Override
	public void addTerminal(Terminal terminal) {
		dao.addTerminal(terminal);
	}

	@Override
	public void updateTerminal(Terminal terminal) {
		dao.updateTerminal(terminal);
		
	}

	@Override
	public void deleteTerminal(Terminal terminal) {
		dao.deleteTerminal(terminal);
	}

	@Override
	public List<Terminal> getAllTerminals() {
		return dao.getAllTerminals();
	}

}
