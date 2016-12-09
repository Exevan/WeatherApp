package com.exevan.weatherappweb.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TimeStampedData.class)
public abstract class TimeStampedData_ {

	public static volatile SingularAttribute<TimeStampedData, LocalDate> date;
	public static volatile SingularAttribute<TimeStampedData, Long> id;
	public static volatile SingularAttribute<TimeStampedData, LocalTime> time;

}

