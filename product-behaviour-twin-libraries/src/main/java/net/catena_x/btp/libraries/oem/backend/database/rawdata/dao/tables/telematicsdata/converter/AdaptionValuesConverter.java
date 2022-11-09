package net.catena_x.btp.libraries.oem.backend.database.rawdata.dao.tables.telematicsdata.converter;

import net.catena_x.btp.libraries.oem.backend.database.rawdata.dao.base.converter.DAOJsonConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdaptionValuesConverter extends DAOJsonConverter<List<double[]>> {
    public AdaptionValuesConverter() {
        super(ArrayList.class);
    }
}
