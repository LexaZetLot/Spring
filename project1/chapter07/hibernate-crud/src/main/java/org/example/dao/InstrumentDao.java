package org.example.dao;

import org.example.entities.Instrument;
import org.example.entities.Singer;

/**
 * Created by iuliana.cosmina on 4/23/17.
 */
public interface InstrumentDao {

    Instrument save(Instrument instrument);

}