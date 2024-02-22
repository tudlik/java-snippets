package cz.jty.model.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PersonEntity.class)
public abstract class PersonEntity_ {

	public static volatile SingularAttribute<PersonEntity, Date> birthDay;
	public static volatile SingularAttribute<PersonEntity, String> country;
	public static volatile SingularAttribute<PersonEntity, String> role;
	public static volatile SingularAttribute<PersonEntity, String> name;
	public static volatile SingularAttribute<PersonEntity, Long> id;
	public static volatile SingularAttribute<PersonEntity, String> biography;

	public static final String BIRTH_DAY = "birthDay";
	public static final String COUNTRY = "country";
	public static final String ROLE = "role";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String BIOGRAPHY = "biography";

}

