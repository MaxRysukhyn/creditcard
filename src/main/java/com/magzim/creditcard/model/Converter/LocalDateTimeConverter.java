package com.magzim.creditcard.model.Converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by max on 8/30/15.
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime ldt) {
        return Timestamp.valueOf(ldt);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp ts) {
        return ts.toLocalDateTime();
    }
}