package com.alekseev.kaffka.service;

import com.alekseev.kaffka.dto.Employer;
import kaffka.db.tables.Employers;
import kaffka.db.tables.records.EmployersRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SaveJooqKaffka {
    @Autowired
    private DSLContext dslContext;

    public Employer saveEmpl(Employer employer){
        EmployersRecord record=dslContext.insertInto(Employers.EMPLOYERS)
                .set(Employers.EMPLOYERS.AGE,employer.getAge())
                .set(Employers.EMPLOYERS.NAME,employer.getName())
                .returning(Employers.EMPLOYERS.ID)
                .fetchOne();
        employer.setId(record.getId());
        return employer;
    }

    }


