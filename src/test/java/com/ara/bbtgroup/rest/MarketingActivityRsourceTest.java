package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.model.Marketingactivity;
import com.ara.bbtgroup.repository.MarketingactivityRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static java.lang.Long.valueOf;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarketingActivityRsourceTest {

    @Autowired
    private MarketingactivityRepository mrepo;

    private final Date STARTDATE = new Date(2018,01,01);
    private final Date ENDDATE = new Date(2018,01,31);
    private final int OWNER = 1;


    @Before
    public void initDataIntoDatabase(){

        Marketingactivity job = new Marketingactivity("Title 1","extra info", "comment", STARTDATE, ENDDATE, 1, OWNER );
        Marketingactivity job1 = new Marketingactivity("Title 2","extra info", "comment", STARTDATE, ENDDATE, 1, OWNER);
        Marketingactivity job2 = new Marketingactivity("Title 3","extra info", "comment", STARTDATE, ENDDATE, 1, OWNER);

        this.mrepo.save(job);
        this.mrepo.save(job1);
        this.mrepo.save(job2);
    }


    @Test
    public void saveJob_whenFoundById_thenOk(){

        Marketingactivity job = mrepo
                .save(new Marketingactivity("Title 1","extra info", "comment", STARTDATE, ENDDATE, 1, OWNER));

        Marketingactivity foundJob = mrepo.findOne(job.getMarketingactivityId());

        assertNotNull(foundJob);
    }

    @Test
    public void saveMultipleJobs_AndFindAll_whenMultipleFound_thenOk(){

        // saving multiple Tasks is automatically done with the @Before class

        List<Marketingactivity> jobList = (List<Marketingactivity>) mrepo.findAll();

        assertNotNull(jobList);
        assertTrue(jobList.size() > 0);
    }

    @Test
    public void saveJobAndDelete_whenDeleted_thenOk(){

        Marketingactivity job = mrepo
                .save(new Marketingactivity("Title 1","extra info", "comment", STARTDATE, ENDDATE, 1, 4194984));

        // check if data successfully written into database
        assertTrue(mrepo.findOne(job.getMarketingactivityId()).getEmployeeId() == 4194984);

        Long lastInsertJob = mrepo.findOne(job.getMarketingactivityId()).getMarketingactivityId();

        mrepo.delete(valueOf(lastInsertJob));

        assertNull(mrepo.findOne(lastInsertJob));

    }

    @Test
    public void updateJob_whenUpdated_thenOk(){
        Marketingactivity job = mrepo
                .save(new Marketingactivity("Title 1","extra info", "comment", STARTDATE, ENDDATE, 1, OWNER));

        Marketingactivity foundJob = mrepo.findOne(job.getMarketingactivityId());
        foundJob.setStatus(2);

        mrepo.save(foundJob);

        assertEquals(2, mrepo.findOne(job.getMarketingactivityId()).getStatus());
    }
}
