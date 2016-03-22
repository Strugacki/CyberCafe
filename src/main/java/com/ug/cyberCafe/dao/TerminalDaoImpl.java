package com.ug.cyberCafe.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.domain.Terminal;

@Transactional
@Repository
public class TerminalDaoImpl implements TerminalDao {
	
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

	@SuppressWarnings("unchecked")
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
		sessionFactory.getCurrentSession().update(terminal);
	}
	
	@Override
	public void deleteAllTerminals() {
		for(Terminal terminal : getAllTerminals() ) {
			deleteTerminal(terminal);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Terminal> getAllAvailableTerminals() {
		return sessionFactory.getCurrentSession().getNamedQuery("get.All.Available.Terminals").list();
	}

}
