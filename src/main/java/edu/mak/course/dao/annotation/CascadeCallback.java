package edu.mak.course.dao.annotation;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class CascadeCallback implements ReflectionUtils.FieldCallback {

    private Object source;
    private MongoOperations mongoOperations;

    CascadeCallback(Object source, MongoOperations mongoOperations) {
        this.source = source;
        setMongoOperations(mongoOperations);
    }

    @Override
    public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
        ReflectionUtils.makeAccessible(field);

        if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(CascadeSave.class)) {
            Object fieldValue = field.get(getSource());

            if (fieldValue != null) {
                FieldCallback callback = new FieldCallback();

                ReflectionUtils.doWithFields(fieldValue.getClass(), callback);

                getMongoOperations().save(fieldValue);
            }
        }

    }

    private Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    private MongoOperations getMongoOperations() {
        return mongoOperations;
    }

    private void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
}