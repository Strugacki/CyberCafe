package com.ug.cyberCafe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.ug.cyberCafe.domain.Address;
import com.ug.cyberCafe.domain.Terminal;

public class TerminalDaoImpl extends AbstractDao<Integer, Terminal> implements TerminalDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTerminal(Terminal terminal) {
		sessionFactory.getCurrentSession().save(terminal);
	}

	@Override
	public void deleteTerminal(Terminal terminal) {
		terminal = (Terminal) sessionFactory.getCurrentSession().get(Terminal.class, terminal.getIdTerminal());
		sessionFactory.getCurrentSession().delete(terminal);
	}

	@Override
	public List<Terminal> getAllTerminals() {
		return sessionFactory.getCurrentSession().getNamedQuery("get.All.Terminals").list();
	}

	@Override
	public Terminal getTerminalById(long id) {
		return (Terminal) sessionFactory.getCurrentSession().get(Terminal.class, id);
	}

	@Override
	public void updateTerminal(Terminal terminal) {
		Terminal terminalToUpdate = getTerminalById(terminal.getIdTerminal());
		terminalToUpdate.setAvailable(terminal.getAvailable());
		terminalToUpdate.setType(terminal.getType());
		sessionFactory.getCurrentSession().update(terminalToUpdate);
	}

}
