package com.sandhya.springdata.idgenerators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomRandomeIDGenerator implements IdentifierGenerator {

	@SuppressWarnings("removal")
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
	Random random=null;
	int id =0;
	random =new Random();
	id = random.nextInt(100000);
		
		return new Long(id);
	}

}
