package org.expansaojava.repository;



import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.expansaojava.model.Loja;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LojaRepository implements PanacheRepository<Loja> {
}
