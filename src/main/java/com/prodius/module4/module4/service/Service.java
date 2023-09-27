package com.prodius.module4.module4.service;

import com.prodius.module4.module4.config.HibernateFactoryUtil;
import com.prodius.module4.module4.model.Details;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    public String getStats() {
        int count = 0;
        int fuels = 0;
        int brokeschema = 0;
        for (Details details : loadAllData()) {
            count++;
            fuels += details.getFuel();
            brokeschema += details.getBrokeSchemas();
        }
        return String.format("<td>%d</td><td>%d</td><td>%d</td>", count, brokeschema, fuels);
    }

    public String getStatsIds() {
        return loadAllData().stream()
                .map(details -> String.format("<tr>"
                                + "<td>%s</td>"
                                + "<td>%d</td>"
                                + "<td>%s</td>"
                                + "<td>%d</td>"
                                + "<td>%d</td>"
                                + "</tr>",
                        details.getId(), details.getBrokeSchemas(), details.getDate(), details.getFuel(),
                        details.getTime()))
                .collect(Collectors.joining(""));
    }

    private List<Details> loadAllData() {
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        try (final Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Details> criteria = builder.createQuery(Details.class);
            criteria.from(Details.class);
            return session.createQuery(criteria).getResultList();
        }
    }

}
