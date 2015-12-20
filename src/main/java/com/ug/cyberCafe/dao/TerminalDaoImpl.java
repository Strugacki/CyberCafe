package com.ug.cyberCafe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ug.cyberCafe.domain.Terminal;

public class TerminalDaoImpl extends AbstractDao<Integer, Terminal> implements TerminalDao {

	@Override
	public void addTerminal(Terminal terminal) {
		persist(terminal);
	}

	@Override
	public void deleteTerminalById(int id) {
		
		
	}

	@Override
	public List<Terminal> getAllTerminals() {
		Criteria criteria = createEntityCriteria();
        return (List<Terminal>) criteria.list();
	}

	@Override
	public Terminal getTerminalById(int id) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Terminal) criteria.uniqueResult();
	}

}
