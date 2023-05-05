package com.example.seamcrud;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {
    @Produces
    @PersistenceContext(unitName = "SeamPrimeFacesGlassfishPU")
    private EntityManager entityManager;
}
