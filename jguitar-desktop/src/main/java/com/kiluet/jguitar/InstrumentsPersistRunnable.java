package com.kiluet.jguitar;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kiluet.jguitar.dao.JGuitarDAOException;
import com.kiluet.jguitar.dao.model.Instrument;
import com.kiluet.jguitar.dao.model.InstrumentString;

public class InstrumentsPersistRunnable extends AbstractPersistRunnable {

    private static final Logger logger = LoggerFactory.getLogger(InstrumentsPersistRunnable.class);

    public InstrumentsPersistRunnable() {
        super();
    }

    @Override
    public String getName() {
        return "Instruments";
    }

    @Override
    public void run() {
        logger.info("ENTERING run()");
        try {
            createElectricGuitar();
            createElectricBass();
            createCello();
            createViolin();
        } catch (JGuitarDAOException e) {
            e.printStackTrace();
        }
    }

    private void createElectricGuitar() throws JGuitarDAOException {
        String instrumentName = "Electric Guitar";
        List<Instrument> foundInstruments = daoMgr.getDaoBean().getInstrumentDAO().findByName(instrumentName);
        if (CollectionUtils.isNotEmpty(foundInstruments)) {
            return;
        }
        Instrument instrument = new Instrument(instrumentName, 27);
        instrument.getStrings().add(new InstrumentString(6, 40, instrument));
        instrument.getStrings().add(new InstrumentString(5, 45, instrument));
        instrument.getStrings().add(new InstrumentString(4, 50, instrument));
        instrument.getStrings().add(new InstrumentString(3, 55, instrument));
        instrument.getStrings().add(new InstrumentString(2, 59, instrument));
        instrument.getStrings().add(new InstrumentString(1, 64, instrument));
        daoMgr.getDaoBean().getInstrumentDAO().save(instrument);
    }

    private void createElectricBass() throws JGuitarDAOException {
        String instrumentName = "Electric Bass";
        List<Instrument> foundInstruments = daoMgr.getDaoBean().getInstrumentDAO().findByName(instrumentName);
        if (CollectionUtils.isNotEmpty(foundInstruments)) {
            return;
        }
        Instrument instrument = new Instrument(instrumentName, 34);
        instrument.getStrings().add(new InstrumentString(4, 28, instrument));
        instrument.getStrings().add(new InstrumentString(3, 33, instrument));
        instrument.getStrings().add(new InstrumentString(2, 38, instrument));
        instrument.getStrings().add(new InstrumentString(1, 43, instrument));
        daoMgr.getDaoBean().getInstrumentDAO().save(instrument);
    }

    private void createCello() throws JGuitarDAOException {
        String instrumentName = "Cello";
        List<Instrument> foundInstruments = daoMgr.getDaoBean().getInstrumentDAO().findByName(instrumentName);
        if (CollectionUtils.isNotEmpty(foundInstruments)) {
            return;
        }
        Instrument instrument = new Instrument(instrumentName, 42);
        instrument.getStrings().add(new InstrumentString(4, 36, instrument));
        instrument.getStrings().add(new InstrumentString(3, 43, instrument));
        instrument.getStrings().add(new InstrumentString(2, 50, instrument));
        instrument.getStrings().add(new InstrumentString(1, 57, instrument));
        daoMgr.getDaoBean().getInstrumentDAO().save(instrument);
    }

    private void createViolin() throws JGuitarDAOException {
        String instrumentName = "Violin";
        List<Instrument> foundInstruments = daoMgr.getDaoBean().getInstrumentDAO().findByName(instrumentName);
        if (CollectionUtils.isNotEmpty(foundInstruments)) {
            return;
        }
        Instrument instrument = new Instrument(instrumentName, 40);
        instrument.getStrings().add(new InstrumentString(4, 55, instrument));
        instrument.getStrings().add(new InstrumentString(3, 62, instrument));
        instrument.getStrings().add(new InstrumentString(2, 69, instrument));
        instrument.getStrings().add(new InstrumentString(1, 76, instrument));
        daoMgr.getDaoBean().getInstrumentDAO().save(instrument);
    }

}
